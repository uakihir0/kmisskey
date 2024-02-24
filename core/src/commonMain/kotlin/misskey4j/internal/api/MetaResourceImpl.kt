package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.MisskeyAPI.Meta
import misskey4j.api.MetaResource
import misskey4j.api.request.meta.EmojisRequest
import misskey4j.api.request.meta.MetaRequest
import misskey4j.api.response.meta.EmojisResponse
import misskey4j.api.response.meta.MetaResponse
import misskey4j.entity.share.Response

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
}
