package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.ApShow
import work.socialhub.kmisskey.api.ApResource
import work.socialhub.kmisskey.api.request.ApShowRequest
import work.socialhub.kmisskey.api.response.ApShowResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.internal.Internal.fromJson
import work.socialhub.kmisskey.util.toBlocking

class ApResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    ApResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun show(
        request: ApShowRequest
    ): Response<ApShowResponse> {

        // user または note に対応するためここでリクエストしてパース
        val response: Response<ApShowResponse> = post(
            ApShow.path, request
        )

        val apShowResponse = response.data
        if ("Note" == apShowResponse.type) {
            // object -> Note
            apShowResponse.note = fromJson(
                apShowResponse.`object`!!
            )

        } else if ("User" == apShowResponse.type) {
            // object -> User
            apShowResponse.user = fromJson(
                apShowResponse.`object`!!
            )
        }

        return response
    }

    /**
     * {@inheritDoc}
     */
    override fun showBlocking(
        request: ApShowRequest
    ): Response<ApShowResponse> {
        return toBlocking {
            show(request)
        }
    }
}
