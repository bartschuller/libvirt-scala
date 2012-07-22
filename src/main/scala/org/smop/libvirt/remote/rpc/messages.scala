package org.smop.libvirt.remote.rpc

case class Open(name: Option[String], flags: Int, userData: String = "")

case class Close()

case class GetType()

case class GetVersion()

case class GetMaxVcpus()
