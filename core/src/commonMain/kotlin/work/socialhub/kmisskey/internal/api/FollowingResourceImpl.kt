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
import work.socialhub.kmisskey.util.toBlocking

class FollowingResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    FollowingResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun create(
        request: FollowingCreateRequest
    ): EmptyResponse {
        return postUnit(FollowingCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun createBlocking(
        request: FollowingCreateRequest
    ): EmptyResponse {
        return toBlocking {
            create(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun delete(
        request: FollowingDeleteRequest
    ): EmptyResponse {
        return postUnit(FollowingDelete.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun deleteBlocking(
        request: FollowingDeleteRequest
    ): EmptyResponse {
        return toBlocking {
            delete(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun requestsList(
        request: FollowingRequestsListRequest
    ): Response<Array<FollowingRequestsListResponse>> {
        return post(FollowingRequestsList.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun requestsListBlocking(
        request: FollowingRequestsListRequest
    ): Response<Array<FollowingRequestsListResponse>> {
        return toBlocking {
            requestsList(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun acceptRequest(
        request: FollowingRequestsAcceptRequest
    ): EmptyResponse {
        return postUnit(FollowingRequestsAccept.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun acceptRequestBlocking(
        request: FollowingRequestsAcceptRequest
    ): EmptyResponse {
        return toBlocking {
            acceptRequest(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun rejectRequest(
        request: FollowingRequestsRejectRequest
    ): EmptyResponse {
        return postUnit(FollowingRequestsReject.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun rejectRequestBlocking(
        request: FollowingRequestsRejectRequest
    ): EmptyResponse {
        return toBlocking {
            rejectRequest(request)
        }
    }
}
