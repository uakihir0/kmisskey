package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.*
import work.socialhub.kmisskey.api.MutesResource
import work.socialhub.kmisskey.api.request.mutes.*
import work.socialhub.kmisskey.api.response.mutes.MutesListResponse
import work.socialhub.kmisskey.entity.share.Response

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
