package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
open class MetaFeatures {

    var registration = false
    var localTimeLine = false
    var globalTimeLine = false
    var elasticsearch = false
    var hcaptcha = false
    var recaptcha = false
    var objectStorage = false
    var serviceWorker = false
    var miauth = false
}
