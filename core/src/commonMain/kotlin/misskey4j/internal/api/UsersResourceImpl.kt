package misskey4j.internal.api

import misskey4j.MisskeyAPI.*
import misskey4j.api.UsersResource
import misskey4j.api.request.users.*
import misskey4j.api.response.notes.UsersReactionsResponse
import misskey4j.api.response.users.*
import misskey4j.entity.share.Response

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
