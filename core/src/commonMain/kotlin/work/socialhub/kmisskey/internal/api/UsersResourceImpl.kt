package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.UsersFollowers
import work.socialhub.kmisskey.MisskeyAPI.UsersFollowing
import work.socialhub.kmisskey.MisskeyAPI.UsersReactions
import work.socialhub.kmisskey.MisskeyAPI.UsersRecommendation
import work.socialhub.kmisskey.MisskeyAPI.UsersRelation
import work.socialhub.kmisskey.MisskeyAPI.UsersSearch
import work.socialhub.kmisskey.MisskeyAPI.UsersSearchByUsernameAndHost
import work.socialhub.kmisskey.MisskeyAPI.UsersShow
import work.socialhub.kmisskey.api.UsersResource
import work.socialhub.kmisskey.api.request.users.UsersFollowersRequest
import work.socialhub.kmisskey.api.request.users.UsersFollowingsRequest
import work.socialhub.kmisskey.api.request.users.UsersReactionsRequest
import work.socialhub.kmisskey.api.request.users.UsersRecommendationRequest
import work.socialhub.kmisskey.api.request.users.UsersRelationRequest
import work.socialhub.kmisskey.api.request.users.UsersSearchByUsernameAndHostRequest
import work.socialhub.kmisskey.api.request.users.UsersSearchRequest
import work.socialhub.kmisskey.api.request.users.UsersSearchWithAuthRequest
import work.socialhub.kmisskey.api.request.users.UsersShowMultipleRequest
import work.socialhub.kmisskey.api.request.users.UsersShowSingleRequest
import work.socialhub.kmisskey.api.response.notes.UsersReactionsResponse
import work.socialhub.kmisskey.api.response.users.UsersFollowersResponse
import work.socialhub.kmisskey.api.response.users.UsersFollowingsResponse
import work.socialhub.kmisskey.api.response.users.UsersRecommendationResponse
import work.socialhub.kmisskey.api.response.users.UsersRelationResponse
import work.socialhub.kmisskey.api.response.users.UsersSearchByUsernameAndHostResponse
import work.socialhub.kmisskey.api.response.users.UsersSearchResponse
import work.socialhub.kmisskey.api.response.users.UsersShowResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.util.toBlocking

class UsersResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    UsersResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun followers(
        request: UsersFollowersRequest
    ): Response<Array<UsersFollowersResponse>> {
        return postAny(UsersFollowers.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun followersBlocking(
        request: UsersFollowersRequest
    ): Response<Array<UsersFollowersResponse>> {
        return toBlocking {
            followers(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun followings(
        request: UsersFollowingsRequest
    ): Response<Array<UsersFollowingsResponse>> {
        return postAny(UsersFollowing.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun followingsBlocking(
        request: UsersFollowingsRequest
    ): Response<Array<UsersFollowingsResponse>> {
        return toBlocking {
            followings(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun recommendation(
        request: UsersRecommendationRequest
    ): Response<Array<UsersRecommendationResponse>> {
        return post(UsersRecommendation.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun recommendationBlocking(
        request: UsersRecommendationRequest
    ): Response<Array<UsersRecommendationResponse>> {
        return toBlocking {
            recommendation(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun show(
        request: UsersShowSingleRequest
    ): Response<UsersShowResponse> {
        return post(UsersShow.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun showBlocking(
        request: UsersShowSingleRequest
    ): Response<UsersShowResponse> {
        return toBlocking {
            show(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun show(
        request: UsersShowMultipleRequest
    ): Response<Array<UsersShowResponse>> {
        return post(UsersShow.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun showBlocking(
        request: UsersShowMultipleRequest
    ): Response<Array<UsersShowResponse>> {
        return toBlocking {
            show(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun reactions(
        request: UsersReactionsRequest
    ): Response<Array<UsersReactionsResponse>> {
        return post(UsersReactions.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun reactionsBlocking(
        request: UsersReactionsRequest
    ): Response<Array<UsersReactionsResponse>> {
        return toBlocking {
            reactions(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun relation(
        request: UsersRelationRequest
    ): Response<Array<UsersRelationResponse>> {
        return post(UsersRelation.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun relationBlocking(
        request: UsersRelationRequest
    ): Response<Array<UsersRelationResponse>> {
        return toBlocking {
            relation(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun search(
        request: UsersSearchRequest
    ): Response<Array<UsersSearchResponse>> {
        return postAny(UsersSearch.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun searchBlocking(
        request: UsersSearchRequest
    ): Response<Array<UsersSearchResponse>> {
        return toBlocking {
            search(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun searchWithAuth(
        request: UsersSearchWithAuthRequest
    ): Response<Array<UsersSearchResponse>> {
        return post(UsersSearch.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun searchWithAuthBlocking(
        request: UsersSearchWithAuthRequest
    ): Response<Array<UsersSearchResponse>> {
        return toBlocking {
            searchWithAuth(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun searchByUsernameAndHost(
        request: UsersSearchByUsernameAndHostRequest
    ): Response<Array<UsersSearchByUsernameAndHostResponse>> {
        return postAny(UsersSearchByUsernameAndHost.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun searchByUsernameAndHostBlocking(
        request: UsersSearchByUsernameAndHostRequest
    ): Response<Array<UsersSearchByUsernameAndHostResponse>> {
        return toBlocking {
            searchByUsernameAndHost(request)
        }
    }
}
