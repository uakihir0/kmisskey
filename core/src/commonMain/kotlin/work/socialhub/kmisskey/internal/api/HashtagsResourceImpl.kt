package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.HashtagsTrend
import work.socialhub.kmisskey.api.HashtagsResource
import work.socialhub.kmisskey.api.request.hashtags.HashtagsTrendRequest
import work.socialhub.kmisskey.api.response.hashtags.HashtagsTrendResponse
import work.socialhub.kmisskey.entity.share.Response

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
        return postAny(HashtagsTrend.path, request)
    }
}
