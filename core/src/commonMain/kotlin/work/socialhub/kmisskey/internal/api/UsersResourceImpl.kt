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

class UsersResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    UsersResource {

    /**
     * {@inheritDoc}
     */
    override fun followers(
        request: UsersFollowersRequest
    ): Response<Array<UsersFollowersResponse>> {
        return post(UsersFollowers.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun followings(
        request: UsersFollowingsRequest
    ): Response<Array<UsersFollowingsResponse>> {
        return post(UsersFollowing.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun recommendation(
        request: UsersRecommendationRequest
    ): Response<Array<UsersRecommendationResponse>> {
        return post(UsersRecommendation.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun show(
        request: UsersShowSingleRequest
    ): Response<UsersShowResponse> {
        return post(UsersShow.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun show(
        request: UsersShowMultipleRequest
    ): Response<Array<UsersShowResponse>> {
        return post(UsersShow.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun reactions(
        request: UsersReactionsRequest
    ): Response<Array<UsersReactionsResponse>> {
        return post(UsersReactions.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun relation(
        request: UsersRelationRequest
    ): Response<Array<UsersRelationResponse>> {
        return post(UsersRelation.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun search(
        request: UsersSearchRequest
    ): Response<Array<UsersSearchResponse>> {
        return post(UsersSearch.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun searchByUsernameAndHost(
        request: UsersSearchByUsernameAndHostRequest
    ): Response<Array<UsersSearchByUsernameAndHostResponse>> {
        return post(UsersSearchByUsernameAndHost.path, request)
    }
}
