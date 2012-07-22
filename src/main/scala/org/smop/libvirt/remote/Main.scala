package org.smop.libvirt.remote

import akka.actor._
import akka.util.duration._
import akka.util.Timeout
import akka.pattern.{ask, gracefulStop}
import akka.dispatch.{Future, Await}

object Main extends App {
  val system = ActorSystem("MySystem")
  val client = system.actorOf(Props[LVClient], name = "libvirtClient")
  //implicit val timeout = Timeout(5 seconds)
  client ! rpc.Open(Some("vbox:///session"), 0)
  //client ! rpc.AuthList
  Thread.sleep(15000L)
  client ! rpc.Close
  val stopped: Future[Boolean] = gracefulStop(client, 5 seconds)(system)
  Await.result(stopped, 6 seconds)
  system.shutdown()
}
