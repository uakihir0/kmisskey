package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.*
import work.socialhub.kmisskey.api.response.channels.*
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport


@JsExport
interface ChannelsResource {

    /**
     * 管理しているチャンネル一覧を取得します。
     * @see "https://misskey.io/api-doc.tag/channels/operation/channels/owned"
     */
    fun owned(
        request: ChannelsOwnedRequest
    ): Response<Array<ChannelsOwnedResponse>>

    /**
     * お気に入りのチャンネル一覧を取得します。
     * @see "https://misskey.io/api-doc.tag/channels/operation/channels/my-favorites"
     */
    fun myFavorites(
        request: ChannelsMyFavoritesRequest
    ): Response<Array<ChannelsMyFavoritesResponse>>

    /**
     * フォローしているチャンネル一覧を取得します。
     * @see "https://misskey.io/api-doc.tag/channels/operation/channels/followed"
     */
    fun followed(
        request: ChannelsFollowedRequest
    ): Response<Array<ChannelsFollowedResponse>>

    /**
     * 指定したチャンネルのタイムラインを取得します。
     * @see "https://misskey.io/api-doc.tag/notes/operation/channels/timeline"
     */
    fun timeline(
        request: ChannelsTimelineRequest
    ): Response<Array<ChannelsTimelineResponse>>

    /**
     * 指定したチャンネルの情報を取得します。
     * @see "https://misskey.io/api-doc.tag/notes/operation/channels/show"
     */
    fun show(
        request: ChannelsShowRequest
    ): Response<ChannelsShowResponse>
}