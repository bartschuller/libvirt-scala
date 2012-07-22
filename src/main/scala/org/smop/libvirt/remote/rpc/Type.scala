package org.smop.libvirt.remote.rpc

object Type {
  val VIR_NET_CALL = 0
  val VIR_NET_REPLY = 1
  val VIR_NET_MESSAGE = 2
  val VIR_NET_STREAM = 3
  val VIR_NET_CALL_WITH_FDS = 4
  val VIR_NET_REPLY_WITH_FDS = 5
}
