package org.smop.libvirt.remote.rpc
import akka.{util => au}
import akka.actor.{ActorRef, IO}
import org.smop.akka.util.{ByteIterator, ByteString, ByteStringBuilder}
import java.nio.ByteOrder
import java.nio.charset.Charset

case class Serial(value: Int) {
  def inc = Serial(value + 1)
}
case class LVPacket[T](program: Int, version: Int, procedure: Int, typ: Int, serial: Int, status: Int, body: T) {
  def specialize[S](s: S) = LVPacket[S](program, version, procedure, typ, serial, status, s)
}

package object codecs {
  implicit val byteOrderIsBigEndian = ByteOrder.BIG_ENDIAN
  val charsetIsUTF8 = Charset.forName("UTF-8")
  private def remoteString(builder: ByteStringBuilder, oString: Option[String]) {
    if (oString.isDefined) {
      builder.putInt(1)
      remoteNonNullString(builder, oString.get)
    } else
      builder.putInt(0)
  }
  private def remoteNonNullString(builder: ByteStringBuilder, string: String) {
    val bytes = string.getBytes(charsetIsUTF8)
    val length = bytes.length
    builder.putInt(length)
    builder ++= bytes
    var remainder = 4 - length % 4
    if (remainder < 4)
      while (remainder > 0) {
        builder.putByte(0)
        remainder -= 1
      }
  }

  object Iteratees {
  }

  trait LVcodec[RPC] {
    def toPacket(msg: RPC)(implicit serial: Serial): LVPacket[au.ByteString]
  }

  object LVcodec {
    implicit val openCodec = new LVcodec[Open] {
      def toPacket(msg: Open)(implicit serial: Serial): LVPacket[au.ByteString] = {
        val builder = ByteString.newBuilder
        remoteString(builder, msg.name)
        builder.putInt(msg.flags)
        LVPacket(0x20008086, 1, Rpc.OPEN, Type.VIR_NET_CALL, serial.value, Status.VIR_NET_OK, au.ByteString(builder.result.asByteBuffer))
      }
    }
  }
}
