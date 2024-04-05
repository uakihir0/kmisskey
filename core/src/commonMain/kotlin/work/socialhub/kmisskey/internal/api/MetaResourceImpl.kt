package work.socialhub.kmisskey.internal.api

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmisskey.MisskeyAPI
import work.socialhub.kmisskey.MisskeyAPI.Meta
import work.socialhub.kmisskey.api.MetaResource
import work.socialhub.kmisskey.api.request.meta.EmojisRequest
import work.socialhub.kmisskey.api.request.meta.MetaRequest
import work.socialhub.kmisskey.api.response.meta.EmojisResponse
import work.socialhub.kmisskey.api.response.meta.GetOnlineUsersCountResponse
import work.socialhub.kmisskey.api.response.meta.MetaResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.internal.util.MediaType
import work.socialhub.kmpcommon.runBlocking

class MetaResourceImpl(
    uri: String
) : AbstractResourceImpl(uri, ""),
    MetaResource {

    /**
     * {@inheritDoc}
     */
    override fun meta(
        request: MetaRequest
    ): Response<MetaResponse> {
        return post(Meta.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun emojis(
        request: EmojisRequest
    ): Response<EmojisResponse> {
        return post(MisskeyAPI.Emojis.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun getOnlineUsersCount(): Response<GetOnlineUsersCountResponse> {

        // simple get request
        return proceed {
            runBlocking {
                HttpRequest()
                    .url(uri + MisskeyAPI.GetOnlineUsersCount.path)
                    .accept(MediaType.JSON)
                    .post()
            }
        }

    }
}
