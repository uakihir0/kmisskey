package work.socialhub.kmisskey.api

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
import kotlin.js.JsExport


@JsExport
interface ChannelsResource {

    /**
     * 管理しているチャンネル一覧を取得します。
     * @see "https://misskey.io/api-doc.tag/channels/operation/channels/owned"
     */
    suspend fun owned(
        request: ChannelsOwnedRequest
    ): Response<Array<ChannelsOwnedResponse>>

    fun ownedBlocking(
        request: ChannelsOwnedRequest
    ): Response<Array<ChannelsOwnedResponse>>

    /**
     * お気に入りのチャンネル一覧を取得します。
     * @see "https://misskey.io/api-doc.tag/channels/operation/channels/my-favorites"
     */
    suspend fun myFavorites(
        request: ChannelsMyFavoritesRequest
    ): Response<Array<ChannelsMyFavoritesResponse>>

    fun myFavoritesBlocking(
        request: ChannelsMyFavoritesRequest
    ): Response<Array<ChannelsMyFavoritesResponse>>

    /**
     * フォローしているチャンネル一覧を取得します。
     * @see "https://misskey.io/api-doc.tag/channels/operation/channels/followed"
     */
    suspend fun followed(
        request: ChannelsFollowedRequest
    ): Response<Array<ChannelsFollowedResponse>>

    fun followedBlocking(
        request: ChannelsFollowedRequest
    ): Response<Array<ChannelsFollowedResponse>>

    /**
     * 指定したチャンネルのタイムラインを取得します。
     * @see "https://misskey.io/api-doc.tag/notes/operation/channels/timeline"
     */
    suspend fun timeline(
        request: ChannelsTimelineRequest
    ): Response<Array<ChannelsTimelineResponse>>

    fun timelineBlocking(
        request: ChannelsTimelineRequest
    ): Response<Array<ChannelsTimelineResponse>>

    /**
     * 指定したチャンネルの情報を取得します。
     * @see "https://misskey.io/api-doc.tag/notes/operation/channels/show"
     */
    suspend fun show(
        request: ChannelsShowRequest
    ): Response<ChannelsShowResponse>

    fun showBlocking(
        request: ChannelsShowRequest
    ): Response<ChannelsShowResponse>
}
