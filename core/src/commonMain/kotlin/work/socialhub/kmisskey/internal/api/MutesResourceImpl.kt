package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.MutesCreate
import work.socialhub.kmisskey.MisskeyAPI.MutesDelete
import work.socialhub.kmisskey.MisskeyAPI.MutesList
import work.socialhub.kmisskey.api.MutesResource
import work.socialhub.kmisskey.api.request.mutes.MutesCreateRequest
import work.socialhub.kmisskey.api.request.mutes.MutesDeleteRequest
import work.socialhub.kmisskey.api.request.mutes.MutesListRequest
import work.socialhub.kmisskey.api.response.mutes.MutesListResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
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
    ): EmptyResponse {
        return postUnit(MutesCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun delete(
        request: MutesDeleteRequest
    ): EmptyResponse {
        return postUnit(MutesDelete.path, request)
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
