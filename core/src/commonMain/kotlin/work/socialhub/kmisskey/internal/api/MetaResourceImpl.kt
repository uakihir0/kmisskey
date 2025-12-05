package work.socialhub.kmisskey.internal.api

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmisskey.MisskeyAPI.Emojis
import work.socialhub.kmisskey.MisskeyAPI.GetOnlineUsersCount
import work.socialhub.kmisskey.MisskeyAPI.Meta
import work.socialhub.kmisskey.api.MetaResource
import work.socialhub.kmisskey.api.request.meta.EmojisRequest
import work.socialhub.kmisskey.api.request.meta.MetaRequest
import work.socialhub.kmisskey.api.response.meta.EmojisResponse
import work.socialhub.kmisskey.api.response.meta.GetOnlineUsersCountResponse
import work.socialhub.kmisskey.api.response.meta.MetaResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.internal.util.MediaType
import work.socialhub.kmisskey.util.toBlocking

class MetaResourceImpl(
    uri: String
) : AbstractResourceImpl(uri, ""),
    MetaResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun meta(
        request: MetaRequest
    ): Response<MetaResponse> {
        return postAny(Meta.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun metaBlocking(
        request: MetaRequest
    ): Response<MetaResponse> {
        return toBlocking {
            meta(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun emojis(
        request: EmojisRequest
    ): Response<EmojisResponse> {
        return postAny(Emojis.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun emojisBlocking(
        request: EmojisRequest
    ): Response<EmojisResponse> {
        return toBlocking {
            emojis(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun getOnlineUsersCount(): Response<GetOnlineUsersCountResponse> {
        // simple get request
        return proceed {
            HttpRequest()
                .url(uri + GetOnlineUsersCount.path)
                .accept(MediaType.JSON)
                .post()
        }
    }

    /**
     * {@inheritDoc}
     */
    override fun getOnlineUsersCountBlocking(): Response<GetOnlineUsersCountResponse> {
        return toBlocking {
            getOnlineUsersCount()
        }
    }
}
