package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.FollowingCreate
import work.socialhub.kmisskey.MisskeyAPI.FollowingDelete
import work.socialhub.kmisskey.MisskeyAPI.FollowingRequestsAccept
import work.socialhub.kmisskey.MisskeyAPI.FollowingRequestsList
import work.socialhub.kmisskey.MisskeyAPI.FollowingRequestsReject
import work.socialhub.kmisskey.api.FollowingResource
import work.socialhub.kmisskey.api.request.following.FollowingCreateRequest
import work.socialhub.kmisskey.api.request.following.FollowingDeleteRequest
import work.socialhub.kmisskey.api.request.following.FollowingRequestsAcceptRequest
import work.socialhub.kmisskey.api.request.following.FollowingRequestsListRequest
import work.socialhub.kmisskey.api.request.following.FollowingRequestsRejectRequest
import work.socialhub.kmisskey.api.response.following.FollowingRequestsListResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response

class FollowingResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    FollowingResource {

    /**
     * {@inheritDoc}
     */
    override fun create(
        request: FollowingCreateRequest
    ): EmptyResponse {
        return postUnit(FollowingCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun delete(
        request: FollowingDeleteRequest
    ): EmptyResponse {
        return postUnit(FollowingDelete.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun requestsList(
        request: FollowingRequestsListRequest
    ): Response<Array<FollowingRequestsListResponse>> {
        return post(FollowingRequestsList.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun acceptRequest(
        request: FollowingRequestsAcceptRequest
    ): EmptyResponse {
        return postUnit(FollowingRequestsAccept.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun rejectRequest(
        request: FollowingRequestsRejectRequest
    ): EmptyResponse {
        return postUnit(FollowingRequestsReject.path, request)
    }
}
