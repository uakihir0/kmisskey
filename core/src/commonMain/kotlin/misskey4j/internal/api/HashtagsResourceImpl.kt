package misskey4j.internal.api

import misskey4j.MisskeyAPI.HashtagsTrend
import misskey4j.api.HashtagsResource
import misskey4j.api.request.hashtags.HashtagsTrendRequest
import misskey4j.api.response.hashtags.HashtagsTrendResponse
import misskey4j.entity.share.Response

class HashtagsResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    HashtagsResource {

    /**
     * {@inheritDoc}
     */
    override fun trend(
        request: HashtagsTrendRequest
    ): Response<Array<HashtagsTrendResponse>> {
        return post(HashtagsTrend.path, request)
    }
}
