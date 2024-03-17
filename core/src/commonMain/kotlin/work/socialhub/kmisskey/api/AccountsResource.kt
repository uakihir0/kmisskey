package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.i.IFavoritesRequest
import work.socialhub.kmisskey.api.request.i.INotificationsRequest
import work.socialhub.kmisskey.api.request.i.IPinRequest
import work.socialhub.kmisskey.api.request.i.IRequest
import work.socialhub.kmisskey.api.request.i.IUnpinRequest
import work.socialhub.kmisskey.api.request.i.IUpdateRequest
import work.socialhub.kmisskey.api.response.i.IFavoritesResponse
import work.socialhub.kmisskey.api.response.i.INotificationsResponse
import work.socialhub.kmisskey.api.response.i.IPinResponse
import work.socialhub.kmisskey.api.response.i.IResponse
import work.socialhub.kmisskey.api.response.i.IUnpinResponse
import work.socialhub.kmisskey.api.response.i.IUpdateResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport
import kotlin.js.JsName


/**
 * Account APIs.
 */
@JsExport
interface AccountsResource {

    /**
     * 自分のアカウント情報を取得します。
     * https://misskey.io/api-doc#tag/account/operation/i
     */
    @JsName("me")
    fun i(
        request: IRequest
    ): Response<IResponse>

    /**
     * お気に入りに登録した投稿一覧を取得します。
     * https://misskey.io/api-doc#tag/account/operation/i/favorites
     */
    fun iFavorites(
        request: IFavoritesRequest
    ): Response<Array<IFavoritesResponse>>

    /**
     * 通知一覧を取得します。
     * https://misskey.io/api-doc#operation/i/notifications
     */
    fun iNotifications(
        request: INotificationsRequest
    ): Response<Array<INotificationsResponse>>

    /**
     * ログイン中のユーザーのプロフィール・設定を更新します。パラメータの値を設定しなければ、その項目は変更されません。
     *
     * https://misskey.io/api-doc#tag/account/operation/i/update
     */
    fun iUpdate(
        request: IUpdateRequest
    ): Response<IUpdateResponse>


    /**
     * 指定したノートをピン留めに登録します。
     *
     * https://misskey.io/api-doc#tag/account/operation/i/pin
     */
    fun pinNote(
        request: IPinRequest
    ): Response<IPinResponse>

    /**
     * 指定したノートをピン留めから削除します。
     *
     * https://misskey.io/api-doc#tag/account/operation/i/unpin
     */
    fun unpinNote(
        request: IUnpinRequest
    ): Response<IUnpinResponse>
}
