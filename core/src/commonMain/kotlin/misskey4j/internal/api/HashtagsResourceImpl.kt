package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.entity.share.Response

class HashtagsResourceImpl(uri: String, i: String?) : AbstractResourceImpl(uri, i), HashtagsResource {
    /**
     * {@inheritDoc}
     */
    override fun trend(
        request: HashtagsTrendRequest
    ): Response<Array<HashtagsTrendResponse>> {
        return post(
            Array<HashtagsTrendResponse>::class.java,
            MisskeyAPI.HashtagsTrend.code(), request
        )
    }
}
