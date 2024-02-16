package misskey4j.api.request

class CreateAppRequest {

    var name: String? = null
    var description: String? = null
    var permission: List<String>? = null
    var callbackUrl: String? = null
}
