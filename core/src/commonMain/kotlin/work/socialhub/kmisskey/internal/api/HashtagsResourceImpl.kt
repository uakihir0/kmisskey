package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.HashtagsTrend
import work.socialhub.kmisskey.api.HashtagsResource
import work.socialhub.kmisskey.api.request.hashtags.HashtagsTrendRequest
import work.socialhub.kmisskey.api.response.hashtags.HashtagsTrendResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.util.toBlocking

class HashtagsResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    HashtagsResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun trend(
        request: HashtagsTrendRequest
    ): Response<Array<HashtagsTrendResponse>> {
        return postAny(HashtagsTrend.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun trendBlocking(
        request: HashtagsTrendRequest
    ): Response<Array<HashtagsTrendResponse>> {
        return toBlocking {
            trend(request)
        }
    }
}
