package misskey4j.api

import misskey4j.api.request.i.IFavoritesRequest
import misskey4j.api.request.i.INotificationsRequest
import misskey4j.api.request.i.IRequest
import misskey4j.api.response.i.IFavoritesResponse
import misskey4j.api.response.i.INotificationsResponse
import misskey4j.api.response.i.IResponse
import misskey4j.entity.share.Response

/**
 * Account APIs.
 */
interface AccountsResource {

    /**
     * 自分のアカウント情報を取得します。
     * https://misskey.io/api-doc#operation/i
     */
    fun i(
        request: IRequest
    ): Response<IResponse>

    /**
     * お気に入りに登録した投稿一覧を取得します。
     * https://misskey.io/api-doc#operation/i/favorites
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
