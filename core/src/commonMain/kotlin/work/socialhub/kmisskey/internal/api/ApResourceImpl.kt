package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.ApShow
import work.socialhub.kmisskey.api.ApResource
import work.socialhub.kmisskey.api.request.ApShowRequest
import work.socialhub.kmisskey.api.response.ApShowResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.internal.Internal.fromJson

class ApResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    ApResource {

    /**
     * {@inheritDoc}
     */
    override fun show(
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
}
