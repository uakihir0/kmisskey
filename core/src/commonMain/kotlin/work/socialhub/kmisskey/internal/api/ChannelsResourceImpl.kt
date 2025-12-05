package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.ChannelsFollowed
import work.socialhub.kmisskey.MisskeyAPI.ChannelsMyFavorites
import work.socialhub.kmisskey.MisskeyAPI.ChannelsOwned
import work.socialhub.kmisskey.MisskeyAPI.ChannelsShow
import work.socialhub.kmisskey.MisskeyAPI.ChannelsTimeline
import work.socialhub.kmisskey.api.ChannelsResource
import work.socialhub.kmisskey.api.request.channels.ChannelsFollowedRequest
import work.socialhub.kmisskey.api.request.channels.ChannelsMyFavoritesRequest
import work.socialhub.kmisskey.api.request.channels.ChannelsOwnedRequest
import work.socialhub.kmisskey.api.request.channels.ChannelsShowRequest
import work.socialhub.kmisskey.api.request.channels.ChannelsTimelineRequest
import work.socialhub.kmisskey.api.response.channels.ChannelsFollowedResponse
import work.socialhub.kmisskey.api.response.channels.ChannelsMyFavoritesResponse
import work.socialhub.kmisskey.api.response.channels.ChannelsOwnedResponse
import work.socialhub.kmisskey.api.response.channels.ChannelsShowResponse
import work.socialhub.kmisskey.api.response.channels.ChannelsTimelineResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.util.toBlocking

class ChannelsResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    ChannelsResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun owned(
        request: ChannelsOwnedRequest
    ): Response<Array<ChannelsOwnedResponse>> {
        return post(ChannelsOwned.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun ownedBlocking(
        request: ChannelsOwnedRequest
    ): Response<Array<ChannelsOwnedResponse>> {
        return toBlocking {
            owned(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun myFavorites(
        request: ChannelsMyFavoritesRequest
    ): Response<Array<ChannelsMyFavoritesResponse>> {
        return post(ChannelsMyFavorites.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun myFavoritesBlocking(
        request: ChannelsMyFavoritesRequest
    ): Response<Array<ChannelsMyFavoritesResponse>> {
        return toBlocking {
            myFavorites(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun followed(
        request: ChannelsFollowedRequest
    ): Response<Array<ChannelsFollowedResponse>> {
        return post(ChannelsFollowed.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun followedBlocking(
        request: ChannelsFollowedRequest
    ): Response<Array<ChannelsFollowedResponse>> {
        return toBlocking {
            followed(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun timeline(
        request: ChannelsTimelineRequest
    ): Response<Array<ChannelsTimelineResponse>> {
        return post(ChannelsTimeline.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun timelineBlocking(
        request: ChannelsTimelineRequest
    ): Response<Array<ChannelsTimelineResponse>> {
        return toBlocking {
            timeline(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun show(
        request: ChannelsShowRequest
    ): Response<ChannelsShowResponse> {
        return post(ChannelsShow.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun showBlocking(
        request: ChannelsShowRequest
    ): Response<ChannelsShowResponse> {
        return toBlocking {
            show(request)
        }
    }
}
