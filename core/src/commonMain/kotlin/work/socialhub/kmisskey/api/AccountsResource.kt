package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.i.IFavoritesRequest
import work.socialhub.kmisskey.api.request.i.INotificationsRequest
import work.socialhub.kmisskey.api.request.i.IRequest
import work.socialhub.kmisskey.api.response.i.IFavoritesResponse
import work.socialhub.kmisskey.api.response.i.INotificationsResponse
import work.socialhub.kmisskey.api.response.i.IResponse
import work.socialhub.kmisskey.entity.share.Response


/**
 * Account APIs.
 */
interface AccountsResource {

    /**
     * 自分のアカウント情報を取得します。
     * https://misskey.io/api-doc#tag/account/operation/i
     */
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
}
