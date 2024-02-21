package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.entity.Note
import misskey4j.entity.User
import misskey4j.entity.share.Response

class ApResourceImpl(uri: String, i: String?) : AbstractResourceImpl(uri, i), ApResource {
    /**
     * {@inheritDoc}
     */
    override fun show(request: ApShowRequest): Response<ApShowResponse> {
        // user または note に対応するためここでリクエストしてパースする

        val response: Response<ApShowResponse> = post(ApShowResponse::class.java, MisskeyAPI.ApShow.code(), request)

        val apShowResponse: ApShowResponse = response.get()
        if ("Note" == apShowResponse.type) {
            // object -> Note
            apShowResponse.note = getGsonInstance().fromJson(apShowResponse.`object`, Note::class.java)
        } else if ("User" == apShowResponse.type) {
            // object -> User
            apShowResponse.user = getGsonInstance().fromJson(apShowResponse.`object`, User::class.java)
        }

        return response
    }
}
