package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.entity.share.Response

class ChannelsResourceImpl(uri: String, i: String?) : AbstractResourceImpl(uri, i), ChannelsResource {
    /**
     * {@inheritDoc}
     */
    override fun owned(request: ChannelsOwnedRequest): Response<Array<ChannelsOwnedResponse>> {
        return post(
            Array<ChannelsOwnedResponse>::class.java,
            MisskeyAPI.ChannelsOwned.code(), request
        )
    }

    /**
     * {@inheritDoc}
     */
    override fun myFavorites(request: ChannelsMyFavoritesRequest): Response<Array<ChannelsMyFavoritesResponse>> {
        return post(
            Array<ChannelsMyFavoritesResponse>::class.java,
            MisskeyAPI.ChannelsMyFavorites.code(), request
        )
    }

    /**
     * {@inheritDoc}
     */
    override fun followed(request: ChannelsFollowedRequest): Response<Array<ChannelsFollowedResponse>> {
        return post(
            Array<ChannelsFollowedResponse>::class.java,
            MisskeyAPI.ChannelsFollowed.code(), request
        )
    }

    /**
     * {@inheritDoc}
     */
    override fun timeline(request: ChannelsTimelineRequest): Response<Array<ChannelsTimelineResponse>> {
        return post(
            Array<ChannelsTimelineResponse>::class.java,
            MisskeyAPI.ChannelsTimeline.code(), request
        )
    }

    /**
     * {@inheritDoc}
     */
    override fun show(request: ChannelsShowRequest): Response<ChannelsShowResponse> {
        return post(
            ChannelsShowResponse::class.java,
            MisskeyAPI.ChannelsShow.code(), request
        )
    }
}
