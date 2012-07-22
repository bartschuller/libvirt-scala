package org.smop.libvirt.remote
import akka.actor._
import rpc.codecs._
import rpc.{Type, Rpc, LVPacket, Serial}
import java.net.URI
import org.smop.akka.util.{ByteIterator, ByteString}
import akka.{util => au}

class LVClient extends Actor with ActorLogging {
  implicit var serial: Serial = Serial(0)
  var replyDestinations = Map.empty[Int, (ActorRef, String)]
  implicit var socket: IO.SocketHandle = _
  val state = IO.IterateeRef.sync()

  def receive = {
    case msg: IO.Connected =>
    case msg: IO.Closed =>
    case IO.Read(handle, bytes) =>
      state(IO.Chunk(bytes))
    case msg@ rpc.Open(name, _, userData) =>
      val uri = URI.create(name.getOrElse("vbox:///session"))
      val host = Option(uri.getHost).getOrElse("localhost")
      val port = {val p = uri.getPort; if (p == -1) 16509 else p }
      socket = IOManager(context.system).connect(host, port)
      val byteString = writeCall(msg, userData)
      state flatMap {_ => readPacket}
      socket.write(byteString)
    case rpc.Close =>
      socket.close()
    case msg =>
      log.error("Didn't handle message [{}]", msg)
  }

  private def writeCall[T: LVcodec](message: T, userData: String): au.ByteString = {
    serial = serial.inc
    replyDestinations += serial.value -> (sender, userData)
    writeMessage(message)
  }
  private def writeMessage[T: LVcodec](message: T): au.ByteString = {
    val packet = implicitly[LVcodec[T]].toPacket(message)
    val builder = ByteString.newBuilder
    builder.putInt(7*4+packet.body.size) //length
    builder.putInt(packet.program)
    builder.putInt(packet.version)
    builder.putInt(packet.procedure)
    builder.putInt(packet.typ)
    builder.putInt(packet.serial)
    builder.putInt(packet.status)
    builder ++= packet.body
    au.ByteString(builder.result.asByteBuffer)
  }

  private val readPacket: IO.Iteratee[Unit] = for {
    rawLength <- IO take 4
    length = rawLength.asByteBuffer.getInt
    rawHeader <- IO take 24
    rawBody <- IO take (length - 28)
  } yield  {
    val iter = ByteIterator.ByteArrayIterator(rawHeader.toArray[Byte])
    val rawPacket = LVPacket(iter.getInt, iter.getInt, iter.getInt, iter.getInt, iter.getInt, iter.getInt, rawBody)
    val packet = rawPacket.specialize(rawPacket.procedure match {
      case Rpc.OPEN => ()
      case foo => log.error("unknown reply procedure {}", foo)
    })
    val (dest, data) = replyDestinations(packet.serial)
    if (packet.typ == Type.VIR_NET_REPLY)
      replyDestinations -= packet.serial
    log.info("replying to {}: {}", dest, packet)
    dest ! (data, packet)
  }
}
