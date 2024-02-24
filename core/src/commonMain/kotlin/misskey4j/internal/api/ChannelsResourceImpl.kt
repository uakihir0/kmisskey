package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.api.ChannelsResource
import misskey4j.api.request.*
import misskey4j.api.response.channels.*
import misskey4j.entity.share.Response

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
        return post(
            MisskeyAPI.ChannelsOwned.path,
            request
        )
    }

    /**
     * {@inheritDoc}
     */
    override fun myFavorites(
        request: ChannelsMyFavoritesRequest
    ): Response<Array<ChannelsMyFavoritesResponse>> {
        return post(
            MisskeyAPI.ChannelsMyFavorites.path,
            request
        )
    }

    /**
     * {@inheritDoc}
     */
    override fun followed(
        request: ChannelsFollowedRequest
    ): Response<Array<ChannelsFollowedResponse>> {
        return post(
            MisskeyAPI.ChannelsFollowed.path,
            request
        )
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
