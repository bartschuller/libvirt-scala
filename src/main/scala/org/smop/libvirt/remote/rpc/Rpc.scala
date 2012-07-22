package org.smop.libvirt.remote.rpc


object Rpc {
  /* Each function must have a three-word comment.  The first word is
   * whether gendispatch.pl handles daemon, the second whether
   * it handles src/remote.  Additional flags can be specified after a
   * pipe.
   * The last argument describes priority of API. There are two accepted
   * values: low, high; Each API that might eventually access hypervisor's
   * monitor (and thus block) MUST fall into low priority. However, there
   * are some exceptions to this rule, e.g. domainDestroy. Other APIs MAY
   * be marked as high priority. If in doubt, it's safe to choose low.
   * Low is taken as default, and thus can be left out.
   *
   * The (readstream|writestream)@<offset> flag lets daemon and src/remote
   * create a stream.  The direction is defined from the src/remote point
   * of view.  A readstream transfers data from daemon to src/remote.  The
   * <offset> specifies at which offset the stream parameter is inserted
   * in the function parameter list. */
  val OPEN = 1 /* skipgen skipgen priority:high */
  val CLOSE = 2 /* skipgen skipgen priority:high */
  val GET_TYPE = 3 /* autogen skipgen priority:high */
  val GET_VERSION = 4 /* autogen autogen priority:high */
  val GET_MAX_VCPUS = 5 /* autogen autogen priority:high */
  val NODE_GET_INFO = 6 /* autogen autogen priority:high */
  val GET_CAPABILITIES = 7 /* autogen autogen */
  val DOMAIN_ATTACH_DEVICE = 8 /* autogen autogen */
  val DOMAIN_CREATE = 9 /* autogen skipgen */
  val DOMAIN_CREATE_XML = 10 /* autogen autogen */

  val DOMAIN_DEFINE_XML = 11 /* autogen autogen priority:high */
  val DOMAIN_DESTROY = 12 /* autogen autogen priority:high */
  val DOMAIN_DETACH_DEVICE = 13 /* autogen autogen */
  val DOMAIN_GET_XML_DESC = 14 /* autogen autogen */
  val DOMAIN_GET_AUTOSTART = 15 /* autogen autogen priority:high */
  val DOMAIN_GET_INFO = 16 /* autogen autogen */
  val DOMAIN_GET_MAX_MEMORY = 17 /* autogen autogen priority:high */
  val DOMAIN_GET_MAX_VCPUS = 18 /* autogen autogen priority:high */
  val DOMAIN_GET_OS_TYPE = 19 /* autogen autogen priority:high */
  val DOMAIN_GET_VCPUS = 20 /* skipgen skipgen priority:high */

  val LIST_DEFINED_DOMAINS = 21 /* autogen autogen priority:high */
  val DOMAIN_LOOKUP_BY_ID = 22 /* autogen autogen priority:high */
  val DOMAIN_LOOKUP_BY_NAME = 23 /* autogen autogen priority:high */
  val DOMAIN_LOOKUP_BY_UUID = 24 /* autogen autogen priority:high */
  val NUM_OF_DEFINED_DOMAINS = 25 /* autogen autogen priority:high */
  val DOMAIN_PIN_VCPU = 26 /* autogen autogen */
  val DOMAIN_REBOOT = 27 /* autogen autogen */
  val DOMAIN_RESUME = 28 /* autogen autogen */
  val DOMAIN_SET_AUTOSTART = 29 /* autogen autogen priority:high */
  val DOMAIN_SET_MAX_MEMORY = 30 /* autogen autogen priority:high */

  val DOMAIN_SET_MEMORY = 31 /* autogen autogen */
  val DOMAIN_SET_VCPUS = 32 /* autogen autogen */
  val DOMAIN_SHUTDOWN = 33 /* autogen autogen */
  val DOMAIN_SUSPEND = 34 /* autogen autogen */
  val DOMAIN_UNDEFINE = 35 /* autogen autogen priority:high */
  val LIST_DEFINED_NETWORKS = 36 /* autogen autogen priority:high */
  val LIST_DOMAINS = 37 /* autogen skipgen priority:high */
  val LIST_NETWORKS = 38 /* autogen autogen priority:high */
  val NETWORK_CREATE = 39 /* autogen autogen */
  val NETWORK_CREATE_XML = 40 /* autogen autogen */

  val NETWORK_DEFINE_XML = 41 /* autogen autogen priority:high */
  val NETWORK_DESTROY = 42 /* autogen autogen priority:high */
  val NETWORK_GET_XML_DESC = 43 /* autogen autogen priority:high */
  val NETWORK_GET_AUTOSTART = 44 /* autogen autogen priority:high */
  val NETWORK_GET_BRIDGE_NAME = 45 /* autogen autogen priority:high */
  val NETWORK_LOOKUP_BY_NAME = 46 /* autogen autogen priority:high */
  val NETWORK_LOOKUP_BY_UUID = 47 /* autogen autogen priority:high */
  val NETWORK_SET_AUTOSTART = 48 /* autogen autogen priority:high */
  val NETWORK_UNDEFINE = 49 /* autogen autogen priority:high */
  val NUM_OF_DEFINED_NETWORKS = 50 /* autogen autogen priority:high */

  val NUM_OF_DOMAINS = 51 /* autogen autogen priority:high */
  val NUM_OF_NETWORKS = 52 /* autogen autogen priority:high */
  val DOMAIN_CORE_DUMP = 53 /* autogen autogen */
  val DOMAIN_RESTORE = 54 /* autogen autogen */
  val DOMAIN_SAVE = 55 /* autogen autogen */
  val DOMAIN_GET_SCHEDULER_TYPE = 56 /* skipgen skipgen */
  val DOMAIN_GET_SCHEDULER_PARAMETERS = 57 /* skipgen autogen */
  val DOMAIN_SET_SCHEDULER_PARAMETERS = 58 /* autogen autogen */
  val GET_HOSTNAME = 59 /* autogen autogen priority:high */
  val SUPPORTS_FEATURE = 60 /* skipgen autogen priority:high */

  val DOMAIN_MIGRATE_PREPARE = 61 /* skipgen skipgen */
  val DOMAIN_MIGRATE_PERFORM = 62 /* autogen autogen */
  val DOMAIN_MIGRATE_FINISH = 63 /* autogen autogen */
  val DOMAIN_BLOCK_STATS = 64 /* autogen autogen */
  val DOMAIN_INTERFACE_STATS = 65 /* autogen autogen priority:high */
  val AUTH_LIST = 66 /* skipgen skipgen priority:high */
  val AUTH_SASL_INIT = 67 /* skipgen skipgen priority:high */
  val AUTH_SASL_START = 68 /* skipgen skipgen priority:high */
  val AUTH_SASL_STEP = 69 /* skipgen skipgen priority:high */
  val AUTH_POLKIT = 70 /* skipgen skipgen priority:high */

  val NUM_OF_STORAGE_POOLS = 71 /* autogen autogen priority:high */
  val LIST_STORAGE_POOLS = 72 /* autogen autogen priority:high */
  val NUM_OF_DEFINED_STORAGE_POOLS = 73 /* autogen autogen priority:high */
  val LIST_DEFINED_STORAGE_POOLS = 74 /* autogen autogen priority:high */
  val FIND_STORAGE_POOL_SOURCES = 75 /* autogen skipgen */
  val STORAGE_POOL_CREATE_XML = 76 /* autogen autogen */
  val STORAGE_POOL_DEFINE_XML = 77 /* autogen autogen priority:high */
  val STORAGE_POOL_CREATE = 78 /* autogen autogen */
  val STORAGE_POOL_BUILD = 79 /* autogen autogen */
  val STORAGE_POOL_DESTROY = 80 /* autogen autogen priority:high */

  val STORAGE_POOL_DELETE = 81 /* autogen autogen */
  val STORAGE_POOL_UNDEFINE = 82 /* autogen autogen priority:high */
  val STORAGE_POOL_REFRESH = 83 /* autogen autogen */
  val STORAGE_POOL_LOOKUP_BY_NAME = 84 /* autogen autogen priority:high */
  val STORAGE_POOL_LOOKUP_BY_UUID = 85 /* autogen autogen priority:high */
  val STORAGE_POOL_LOOKUP_BY_VOLUME = 86 /* autogen autogen priority:high */
  val STORAGE_POOL_GET_INFO = 87 /* autogen autogen priority:high */
  val STORAGE_POOL_GET_XML_DESC = 88 /* autogen autogen priority:high */
  val STORAGE_POOL_GET_AUTOSTART = 89 /* autogen autogen priority:high */
  val STORAGE_POOL_SET_AUTOSTART = 90 /* autogen autogen priority:high */

  val STORAGE_POOL_NUM_OF_VOLUMES = 91 /* autogen autogen priority:high */
  val STORAGE_POOL_LIST_VOLUMES = 92 /* autogen autogen priority:high */
  val STORAGE_VOL_CREATE_XML = 93 /* autogen autogen */
  val STORAGE_VOL_DELETE = 94 /* autogen autogen */
  val STORAGE_VOL_LOOKUP_BY_NAME = 95 /* autogen autogen priority:high */
  val STORAGE_VOL_LOOKUP_BY_KEY = 96 /* autogen autogen priority:high */
  val STORAGE_VOL_LOOKUP_BY_PATH = 97 /* autogen autogen priority:high */
  val STORAGE_VOL_GET_INFO = 98 /* autogen autogen priority:high */
  val STORAGE_VOL_GET_XML_DESC = 99 /* autogen autogen priority:high */
  val STORAGE_VOL_GET_PATH = 100 /* autogen autogen priority:high */

  val NODE_GET_CELLS_FREE_MEMORY = 101 /* autogen skipgen priority:high */
  val NODE_GET_FREE_MEMORY = 102 /* autogen autogen priority:high */
  val DOMAIN_BLOCK_PEEK = 103 /* skipgen skipgen */
  val DOMAIN_MEMORY_PEEK = 104 /* skipgen skipgen */
  val DOMAIN_EVENTS_REGISTER = 105 /* skipgen skipgen priority:high */
  val DOMAIN_EVENTS_DEREGISTER = 106 /* skipgen skipgen priority:high */
  val DOMAIN_EVENT_LIFECYCLE = 107 /* autogen autogen */
  val DOMAIN_MIGRATE_PREPARE2 = 108 /* skipgen skipgen */
  val DOMAIN_MIGRATE_FINISH2 = 109 /* autogen autogen */
  val GET_URI = 110 /* autogen skipgen priority:high */

  val NODE_NUM_OF_DEVICES = 111 /* autogen autogen priority:high */
  val NODE_LIST_DEVICES = 112 /* autogen autogen priority:high */
  val NODE_DEVICE_LOOKUP_BY_NAME = 113 /* autogen autogen priority:high */
  val NODE_DEVICE_GET_XML_DESC = 114 /* autogen autogen */
  val NODE_DEVICE_GET_PARENT = 115 /* skipgen autogen priority:high */
  val NODE_DEVICE_NUM_OF_CAPS = 116 /* autogen autogen priority:high */
  val NODE_DEVICE_LIST_CAPS = 117 /* autogen autogen priority:high */
  val NODE_DEVICE_DETTACH = 118 /* autogen skipgen */
  val NODE_DEVICE_RE_ATTACH = 119 /* autogen skipgen */
  val NODE_DEVICE_RESET = 120 /* autogen skipgen */

  val DOMAIN_GET_SECURITY_LABEL = 121 /* skipgen skipgen priority:high */
  val NODE_GET_SECURITY_MODEL = 122 /* skipgen skipgen priority:high */
  val NODE_DEVICE_CREATE_XML = 123 /* autogen autogen */
  val NODE_DEVICE_DESTROY = 124 /* autogen autogen priority:high */
  val STORAGE_VOL_CREATE_XML_FROM = 125 /* autogen autogen */
  val NUM_OF_INTERFACES = 126 /* autogen autogen priority:high */
  val LIST_INTERFACES = 127 /* autogen autogen priority:high */
  val INTERFACE_LOOKUP_BY_NAME = 128 /* autogen autogen priority:high */
  val INTERFACE_LOOKUP_BY_MAC_STRING = 129 /* autogen autogen priority:high */
  val INTERFACE_GET_XML_DESC = 130 /* autogen autogen */

  val INTERFACE_DEFINE_XML = 131 /* autogen autogen priority:high */
  val INTERFACE_UNDEFINE = 132 /* autogen autogen priority:high */
  val INTERFACE_CREATE = 133 /* autogen autogen */
  val INTERFACE_DESTROY = 134 /* autogen autogen priority:high */
  val DOMAIN_XML_FROM_NATIVE = 135 /* autogen autogen */
  val DOMAIN_XML_TO_NATIVE = 136 /* autogen autogen */
  val NUM_OF_DEFINED_INTERFACES = 137 /* autogen autogen priority:high */
  val LIST_DEFINED_INTERFACES = 138 /* autogen autogen priority:high */
  val NUM_OF_SECRETS = 139 /* autogen autogen priority:high */
  val LIST_SECRETS = 140 /* autogen autogen priority:high */

  val SECRET_LOOKUP_BY_UUID = 141 /* autogen autogen priority:high */
  val SECRET_DEFINE_XML = 142 /* autogen autogen priority:high */
  val SECRET_GET_XML_DESC = 143 /* autogen autogen priority:high */
  val SECRET_SET_VALUE = 144 /* autogen autogen priority:high */
  val SECRET_GET_VALUE = 145 /* skipgen skipgen priority:high */
  val SECRET_UNDEFINE = 146 /* autogen autogen priority:high */
  val SECRET_LOOKUP_BY_USAGE = 147 /* autogen autogen priority:high */
  val DOMAIN_MIGRATE_PREPARE_TUNNEL = 148 /* autogen autogen | writestream@1 */
  val IS_SECURE = 149 /* autogen skipgen priority:high */
  val DOMAIN_IS_ACTIVE = 150 /* autogen autogen priority:high */

  val DOMAIN_IS_PERSISTENT = 151 /* autogen autogen priority:high */
  val NETWORK_IS_ACTIVE = 152 /* autogen autogen priority:high */
  val NETWORK_IS_PERSISTENT = 153 /* autogen autogen priority:high */
  val STORAGE_POOL_IS_ACTIVE = 154 /* autogen autogen priority:high */
  val STORAGE_POOL_IS_PERSISTENT = 155 /* autogen autogen priority:high */
  val INTERFACE_IS_ACTIVE = 156 /* autogen autogen priority:high */
  val GET_LIB_VERSION = 157 /* autogen autogen priority:high */
  val CPU_COMPARE = 158 /* autogen autogen priority:high */
  val DOMAIN_MEMORY_STATS = 159 /* skipgen skipgen */
  val DOMAIN_ATTACH_DEVICE_FLAGS = 160 /* autogen autogen */

  val DOMAIN_DETACH_DEVICE_FLAGS = 161 /* autogen autogen */
  val CPU_BASELINE = 162 /* autogen autogen */
  val DOMAIN_GET_JOB_INFO = 163 /* autogen autogen */
  val DOMAIN_ABORT_JOB = 164 /* autogen autogen */
  val STORAGE_VOL_WIPE = 165 /* autogen autogen */
  val DOMAIN_MIGRATE_SET_MAX_DOWNTIME = 166 /* autogen autogen */
  val DOMAIN_EVENTS_REGISTER_ANY = 167 /* skipgen skipgen priority:high */
  val DOMAIN_EVENTS_DEREGISTER_ANY = 168 /* skipgen skipgen priority:high */
  val DOMAIN_EVENT_REBOOT = 169 /* autogen autogen */
  val DOMAIN_EVENT_RTC_CHANGE = 170 /* autogen autogen */

  val DOMAIN_EVENT_WATCHDOG = 171 /* autogen autogen */
  val DOMAIN_EVENT_IO_ERROR = 172 /* autogen autogen */
  val DOMAIN_EVENT_GRAPHICS = 173 /* autogen autogen */
  val DOMAIN_UPDATE_DEVICE_FLAGS = 174 /* autogen autogen */
  val NWFILTER_LOOKUP_BY_NAME = 175 /* autogen autogen priority:high */
  val NWFILTER_LOOKUP_BY_UUID = 176 /* autogen autogen priority:high */
  val NWFILTER_GET_XML_DESC = 177 /* autogen autogen priority:high */
  val NUM_OF_NWFILTERS = 178 /* autogen autogen priority:high */
  val LIST_NWFILTERS = 179 /* autogen autogen priority:high */
  val NWFILTER_DEFINE_XML = 180 /* autogen autogen priority:high */

  val NWFILTER_UNDEFINE = 181 /* autogen autogen priority:high */
  val DOMAIN_MANAGED_SAVE = 182 /* autogen autogen */
  val DOMAIN_HAS_MANAGED_SAVE_IMAGE = 183 /* autogen autogen */
  val DOMAIN_MANAGED_SAVE_REMOVE = 184 /* autogen autogen */
  val DOMAIN_SNAPSHOT_CREATE_XML = 185 /* autogen autogen */
  val DOMAIN_SNAPSHOT_GET_XML_DESC = 186 /* autogen autogen priority:high */
  val DOMAIN_SNAPSHOT_NUM = 187 /* autogen autogen priority:high */
  val DOMAIN_SNAPSHOT_LIST_NAMES = 188 /* autogen autogen priority:high */
  val DOMAIN_SNAPSHOT_LOOKUP_BY_NAME = 189 /* autogen autogen priority:high */
  val DOMAIN_HAS_CURRENT_SNAPSHOT = 190 /* autogen autogen */

  val DOMAIN_SNAPSHOT_CURRENT = 191 /* autogen autogen */
  val DOMAIN_REVERT_TO_SNAPSHOT = 192 /* autogen autogen */
  val DOMAIN_SNAPSHOT_DELETE = 193 /* autogen autogen */
  val DOMAIN_GET_BLOCK_INFO = 194 /* autogen autogen */
  val DOMAIN_EVENT_IO_ERROR_REASON = 195 /* autogen autogen */
  val DOMAIN_CREATE_WITH_FLAGS = 196 /* autogen autogen */
  val DOMAIN_SET_MEMORY_PARAMETERS = 197 /* autogen autogen */
  val DOMAIN_GET_MEMORY_PARAMETERS = 198 /* skipgen skipgen */
  val DOMAIN_SET_VCPUS_FLAGS = 199 /* autogen autogen */
  val DOMAIN_GET_VCPUS_FLAGS = 200 /* autogen autogen */

  val DOMAIN_OPEN_CONSOLE = 201 /* autogen autogen | readstream@2 */
  val DOMAIN_IS_UPDATED = 202 /* autogen autogen priority:high */
  val GET_SYSINFO = 203 /* autogen autogen priority:high */
  val DOMAIN_SET_MEMORY_FLAGS = 204 /* autogen autogen */
  val DOMAIN_SET_BLKIO_PARAMETERS = 205 /* autogen autogen */
  val DOMAIN_GET_BLKIO_PARAMETERS = 206 /* skipgen skipgen */
  val DOMAIN_MIGRATE_SET_MAX_SPEED = 207 /* autogen autogen */
  val STORAGE_VOL_UPLOAD = 208 /* autogen autogen | writestream@1 */
  val STORAGE_VOL_DOWNLOAD = 209 /* autogen autogen | readstream@1 */
  val DOMAIN_INJECT_NMI = 210 /* autogen autogen */

  val DOMAIN_SCREENSHOT = 211 /* autogen autogen | readstream@1 */
  val DOMAIN_GET_STATE = 212 /* skipgen skipgen priority:high */
  val DOMAIN_MIGRATE_BEGIN3 = 213 /* skipgen skipgen */
  val DOMAIN_MIGRATE_PREPARE3 = 214 /* skipgen skipgen */
  val DOMAIN_MIGRATE_PREPARE_TUNNEL3 = 215 /* autogen skipgen | writestream@1 */
  val DOMAIN_MIGRATE_PERFORM3 = 216 /* skipgen skipgen */
  val DOMAIN_MIGRATE_FINISH3 = 217 /* skipgen skipgen */
  val DOMAIN_MIGRATE_CONFIRM3 = 218 /* skipgen skipgen */
  val DOMAIN_SET_SCHEDULER_PARAMETERS_FLAGS = 219 /* autogen autogen */
  val INTERFACE_CHANGE_BEGIN = 220 /* autogen autogen */

  val INTERFACE_CHANGE_COMMIT = 221 /* autogen autogen */
  val INTERFACE_CHANGE_ROLLBACK = 222 /* autogen autogen */
  val DOMAIN_GET_SCHEDULER_PARAMETERS_FLAGS = 223 /* skipgen autogen */
  val DOMAIN_EVENT_CONTROL_ERROR = 224 /* skipgen skipgen */
  val DOMAIN_PIN_VCPU_FLAGS = 225 /* autogen autogen */
  val DOMAIN_SEND_KEY = 226 /* autogen autogen */
  val NODE_GET_CPU_STATS = 227 /* skipgen skipgen priority:high */
  val NODE_GET_MEMORY_STATS = 228 /* skipgen skipgen priority:high */
  val DOMAIN_GET_CONTROL_INFO = 229 /* autogen autogen priority:high */
  val DOMAIN_GET_VCPU_PIN_INFO = 230 /* skipgen skipgen */

  val DOMAIN_UNDEFINE_FLAGS = 231 /* autogen autogen priority:high */
  val DOMAIN_SAVE_FLAGS = 232 /* autogen autogen */
  val DOMAIN_RESTORE_FLAGS = 233 /* autogen autogen */
  val DOMAIN_DESTROY_FLAGS = 234 /* autogen autogen priority:high */
  val DOMAIN_SAVE_IMAGE_GET_XML_DESC = 235 /* autogen autogen priority:high */
  val DOMAIN_SAVE_IMAGE_DEFINE_XML = 236 /* autogen autogen priority:high */
  val DOMAIN_BLOCK_JOB_ABORT = 237 /* autogen autogen */
  val DOMAIN_GET_BLOCK_JOB_INFO = 238 /* skipgen skipgen */
  val DOMAIN_BLOCK_JOB_SET_SPEED = 239 /* autogen autogen */
  val DOMAIN_BLOCK_PULL = 240 /* autogen autogen */

  val DOMAIN_EVENT_BLOCK_JOB = 241 /* skipgen skipgen */
  val DOMAIN_MIGRATE_GET_MAX_SPEED = 242 /* autogen autogen */
  val DOMAIN_BLOCK_STATS_FLAGS = 243 /* skipgen skipgen */
  val DOMAIN_SNAPSHOT_GET_PARENT = 244 /* autogen autogen priority:high */
  val DOMAIN_RESET = 245 /* autogen autogen */
  val DOMAIN_SNAPSHOT_NUM_CHILDREN = 246 /* autogen autogen priority:high */
  val DOMAIN_SNAPSHOT_LIST_CHILDREN_NAMES = 247 /* autogen autogen priority:high */
  val DOMAIN_EVENT_DISK_CHANGE = 248 /* skipgen skipgen */
  val DOMAIN_OPEN_GRAPHICS = 249 /* skipgen skipgen */
  val NODE_SUSPEND_FOR_DURATION = 250 /* autogen autogen */

  val DOMAIN_BLOCK_RESIZE = 251 /* autogen autogen */
  val DOMAIN_SET_BLOCK_IO_TUNE = 252 /* autogen autogen */
  val DOMAIN_GET_BLOCK_IO_TUNE = 253 /* skipgen skipgen */
  val DOMAIN_SET_NUMA_PARAMETERS = 254 /* autogen autogen */
  val DOMAIN_GET_NUMA_PARAMETERS = 255 /* skipgen skipgen */
  val DOMAIN_SET_INTERFACE_PARAMETERS = 256 /* autogen autogen */
  val DOMAIN_GET_INTERFACE_PARAMETERS = 257 /* skipgen skipgen */
  val DOMAIN_SHUTDOWN_FLAGS = 258 /* autogen autogen */
  val STORAGE_VOL_WIPE_PATTERN = 259 /* autogen autogen */
  val STORAGE_VOL_RESIZE = 260 /* autogen autogen */

  val DOMAIN_PM_SUSPEND_FOR_DURATION = 261 /* autogen autogen */
  val DOMAIN_GET_CPU_STATS = 262 /* skipgen skipgen */
  val DOMAIN_GET_DISK_ERRORS = 263 /* skipgen skipgen */
  val DOMAIN_SET_METADATA = 264 /* autogen autogen */
  val DOMAIN_GET_METADATA = 265 /* autogen autogen */
  val DOMAIN_BLOCK_REBASE = 266 /* autogen autogen */
  val DOMAIN_PM_WAKEUP = 267 /* autogen autogen */
  val DOMAIN_EVENT_TRAY_CHANGE = 268 /* autogen autogen */
  val DOMAIN_EVENT_PMWAKEUP = 269 /* autogen autogen */
  val DOMAIN_EVENT_PMSUSPEND = 270 /* autogen autogen */

  val DOMAIN_SNAPSHOT_IS_CURRENT = 271 /* autogen autogen */
  val DOMAIN_SNAPSHOT_HAS_METADATA = 272 /* autogen autogen */
  val CONNECT_LIST_ALL_DOMAINS = 273 /* skipgen skipgen priority:high */
  val DOMAIN_LIST_ALL_SNAPSHOTS = 274 /* skipgen skipgen priority:high */
  val DOMAIN_SNAPSHOT_LIST_ALL_CHILDREN = 275 /* skipgen skipgen priority:high */

  /*
   * Notice how the entries are grouped in sets of 10 ?
   * Nice isn't it. Please keep it this way when adding more.
   *
   * Each function must have a three-word comment.  The first word is
   * whether gendispatch.pl handles daemon, the second whether
   * it handles src/remote.  Additional flags can be specified after a
   * pipe.
   * The last argument describes priority of API. There are two accepted
   * values: low, high; Each API that might eventually access hypervisor's
   * monitor (and thus block) MUST fall into low priority. However, there
   * are some exceptions to this rule, e.g. domainDestroy. Other APIs MAY
   * be marked as high priority. If in doubt, it's safe to choose low.
   * Low is taken as default, and thus can be left out.
   *
   * The (readstream|writestream)@<offset> flag lets daemon and src/remote
   * create a stream.  The direction is defined from the src/remote point
   * of view.  A readstream transfers data from daemon to src/remote.  The
   * <offset> specifies at which offset the stream parameter is inserted
   * in the function parameter list. */
}
