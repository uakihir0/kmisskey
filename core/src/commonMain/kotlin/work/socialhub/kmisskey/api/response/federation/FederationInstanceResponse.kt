package work.socialhub.kmisskey.api.response.federation

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class FederationInstanceResponse {

    var id: String? = null
    var firstRetrievedAt: String? = null
    var host: String? = null
    var usersCount: Int? = null
    var notesCount: Int? = null
    var followingCount: Int? = null
    var followersCount: Int? = null
    var notResponding: Boolean? = null
    var suspended: Boolean? = null
    var blocked: Boolean? = null
    var softwareName: String? = null
    var softwareVersion: String? = null
    var openRegistrations: Boolean? = null
    var name: String? = null
    var description: String? = null
    var maintainerName: String? = null
    var maintainerEmail: String? = null
    var iconUrl: String? = null
    var faviconUrl: String? = null
    var themeColor: String? = null
    var infoUpdatedAt: String? = null
}
