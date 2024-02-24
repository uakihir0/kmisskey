package misskey4j.internal.api

import misskey4j.MisskeyAPI.*
import misskey4j.api.MutesResource
import misskey4j.api.request.mutes.MutesCreateRequest
import misskey4j.api.request.mutes.MutesDeleteRequest
import misskey4j.api.request.mutes.MutesListRequest
import misskey4j.api.response.mutes.MutesListResponse
import misskey4j.entity.share.Response

class MutesResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    MutesResource {

    /**
     * {@inheritDoc}
     */
    override fun create(
        request: MutesCreateRequest
    ): Response<Unit> {
        return post(MutesCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun delete(
        request: MutesDeleteRequest
    ): Response<Unit> {
        return post(MutesDelete.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun list(
        request: MutesListRequest
    ): Response<Array<MutesListResponse>> {
        return post(MutesList.path, request)
    }
}
