package misskey4j.api.request

class GetMiAuthUriRequest {

    var sessionId: String? = null
    var name: String? = null
    var iconUri: String? = null
    var callbackUrl: String? = null
    var permission: List<String>? = null
}
