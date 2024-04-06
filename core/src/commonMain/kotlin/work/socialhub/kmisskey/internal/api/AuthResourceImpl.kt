package work.socialhub.kmisskey.internal.api

import io.ktor.http.*
import work.socialhub.kmisskey.MisskeyAPI.AuthSessionGenerate
import work.socialhub.kmisskey.MisskeyAPI.AuthSessionUserkey
import work.socialhub.kmisskey.api.AuthResource
import work.socialhub.kmisskey.api.request.GenerateAuthSessionRequest
import work.socialhub.kmisskey.api.request.GetMiAuthUriRequest
import work.socialhub.kmisskey.api.request.UserKeyAuthSessionRequest
import work.socialhub.kmisskey.api.response.GenerateAuthSessionResponse
import work.socialhub.kmisskey.api.response.UserKeyAuthSessionResponse
import work.socialhub.kmisskey.entity.share.Response

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
        return postAny(AuthSessionGenerate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun sessionUserKey(
        request: UserKeyAuthSessionRequest
    ): Response<UserKeyAuthSessionResponse> {
        return postAny(AuthSessionUserkey.path, request)
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
