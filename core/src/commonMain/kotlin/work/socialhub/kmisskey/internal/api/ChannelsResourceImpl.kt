package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI
import work.socialhub.kmisskey.MisskeyAPI.ChannelsFollowed
import work.socialhub.kmisskey.MisskeyAPI.ChannelsMyFavorites
import work.socialhub.kmisskey.MisskeyAPI.ChannelsOwned
import work.socialhub.kmisskey.api.ChannelsResource
import work.socialhub.kmisskey.api.request.ChannelsFollowedRequest
import work.socialhub.kmisskey.api.request.ChannelsMyFavoritesRequest
import work.socialhub.kmisskey.api.request.ChannelsOwnedRequest
import work.socialhub.kmisskey.api.request.ChannelsShowRequest
import work.socialhub.kmisskey.api.request.ChannelsTimelineRequest
import work.socialhub.kmisskey.api.response.channels.ChannelsFollowedResponse
import work.socialhub.kmisskey.api.response.channels.ChannelsMyFavoritesResponse
import work.socialhub.kmisskey.api.response.channels.ChannelsOwnedResponse
import work.socialhub.kmisskey.api.response.channels.ChannelsShowResponse
import work.socialhub.kmisskey.api.response.channels.ChannelsTimelineResponse
import work.socialhub.kmisskey.entity.share.Response

class ChannelsResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    ChannelsResource {

    /**
     * {@inheritDoc}
     */
    override fun owned(
        request: ChannelsOwnedRequest
    ): Response<Array<ChannelsOwnedResponse>> {
        return post(ChannelsOwned.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun myFavorites(
        request: ChannelsMyFavoritesRequest
    ): Response<Array<ChannelsMyFavoritesResponse>> {
        return post(ChannelsMyFavorites.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun followed(
        request: ChannelsFollowedRequest
    ): Response<Array<ChannelsFollowedResponse>> {
        return post(ChannelsFollowed.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun timeline(
        request: ChannelsTimelineRequest
    ): Response<Array<ChannelsTimelineResponse>> {
        return post(
            MisskeyAPI.ChannelsTimeline.path,
            request
        )
    }

    /**
     * {@inheritDoc}
     */
    override fun show(
        request: ChannelsShowRequest
    ): Response<ChannelsShowResponse> {
        return post(
            MisskeyAPI.ChannelsShow.path,
            request
        )
    }
}
