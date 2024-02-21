package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.entity.share.Response

class AuthResourceImpl(uri: String) : AbstractResourceImpl(uri, null), AuthResource {
    /**
     * {@inheritDoc}
     */
    override fun sessionGenerate(
        request: GenerateAuthSessionRequest
    ): Response<GenerateAuthSessionResponse> {
        return post(
            GenerateAuthSessionResponse::class.java,
            MisskeyAPI.AuthSessionGenerate.code(), request
        )
    }

    /**
     * {@inheritDoc}
     */
    override fun sessionUserKey(
        request: UserKeyAuthSessionRequest
    ): Response<UserKeyAuthSessionResponse> {
        return post(
            UserKeyAuthSessionResponse::class.java,
            MisskeyAPI.AuthSessionUserkey.code(), request
        )
    }

    /**
     * {@inheritDoc}
     */
    override fun getMiAuthUri(
        request: GetMiAuthUriRequest
    ): Response<String> {
        try {
            val url: java.net.URL = java.net.URL(uri)

            val builder: java.lang.StringBuilder = java.lang.StringBuilder()
            builder.append(url.getProtocol())
            builder.append("://")
            builder.append(url.getHost())
            builder.append("/miauth/")
            builder.append(request.sessionId)

            val params: MutableList<String> = java.util.ArrayList<String>()
            if (request.name != null) {
                params.add("name=" + encode(request.name))
            }
            if (request.iconUri != null) {
                params.add("icon=" + encode(request.iconUri))
            }
            if (request.callbackUrl != null) {
                params.add("callback=" + encode(request.callbackUrl))
            }
            if (request.permission != null) {
                params.add("permission=" + encode(java.lang.String.join(",", request.permission)))
            }

            if (params.size > 0) {
                builder.append("?")
                builder.append(java.lang.String.join("&", params))
            }

            val response = Response<String>()
            response.set(builder.toString())
            return response
        } catch (e: java.lang.Exception) {
            return null
        }
    }

    companion object {
        protected fun encode(str: String?): String? {
            return try {
                java.net.URLEncoder.encode(str, "UTF-8")
            } catch (e: java.lang.Exception) {
                null
            }
        }
    }
}
