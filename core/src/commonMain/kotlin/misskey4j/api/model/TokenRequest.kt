package misskey4j.api.model

import kotlinx.serialization.Serializable

@Serializable
abstract class TokenRequest {
    abstract var i: String
}
