package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.api.ApResource
import misskey4j.api.request.ApShowRequest
import misskey4j.api.response.ApShowResponse
import misskey4j.entity.share.Response
import misskey4j.internal.Internal.fromJson

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
            MisskeyAPI.ApShow.path,
            request
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
