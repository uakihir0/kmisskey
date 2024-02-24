package misskey4j.internal.api

import io.ktor.http.*
import misskey4j.MisskeyAPI
import misskey4j.api.AuthResource
import misskey4j.api.request.GenerateAuthSessionRequest
import misskey4j.api.request.GetMiAuthUriRequest
import misskey4j.api.request.UserKeyAuthSessionRequest
import misskey4j.api.response.GenerateAuthSessionResponse
import misskey4j.api.response.UserKeyAuthSessionResponse
import misskey4j.entity.share.Response

class AuthResourceImpl(
    uri: String
) : AbstractResourceImpl(uri, ""),
    AuthResource {

    /**
     * {@inheritDoc}
     */
    override fun sessionGenerate(
        request: GenerateAuthSessionRequest
    ): Response<GenerateAuthSessionResponse> {
        return post(
            MisskeyAPI.AuthSessionGenerate.path,
            request
        )
    }

    /**
     * {@inheritDoc}
     */
    override fun sessionUserKey(
        request: UserKeyAuthSessionRequest
    ): Response<UserKeyAuthSessionResponse> {
        return post(
            MisskeyAPI.AuthSessionUserkey.path,
            request
        )
    }

    /**
     * {@inheritDoc}
     */
    override fun getMiAuthUri(
        request: GetMiAuthUriRequest
    ): Response<String> {
        val url = Url(uri)
        var authUrl = "${url.protocol}://${url.host}/miauth/${request.sessionId}"

        val m = mutableListOf<String>()
        request.name?.let { m += "name=${e(it)}" }
        request.iconUri?.let { m += "icon=${e(it)}" }
        request.callbackUrl?.let { m += "callback=${e(it)}" }
        request.permission?.let { m += "permission=${e(it.joinToString(","))}" }

        if (m.isNotEmpty()) {
            authUrl += "?${m.joinToString("&")}"
        }

        return Response(authUrl, "")
    }

    companion object {
        private fun e(
            str: String
        ): String {
            return str.encodeURLParameter()
        }
    }
}
