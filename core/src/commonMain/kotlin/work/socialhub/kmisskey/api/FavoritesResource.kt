package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.favorites.FavoritesCreateRequest
import work.socialhub.kmisskey.api.request.favorites.FavoritesDeleteRequest
import work.socialhub.kmisskey.entity.share.EmptyResponse
import kotlin.js.JsExport

@JsExport
interface FavoritesResource {

    /**
     * 指定した投稿をお気に入りに登録します。
     * https://misskey.io/api-doc#operation/notes/favorites/create
     */
    suspend fun create(
        request: FavoritesCreateRequest
    ): EmptyResponse

    fun createBlocking(
        request: FavoritesCreateRequest
    ): EmptyResponse

    /**
     * 指定した投稿のお気に入りを解除します。
     * https://misskey.io/api-doc#operation/notes/favorites/delete
     */
    suspend fun delete(
        request: FavoritesDeleteRequest
    ): EmptyResponse

    fun deleteBlocking(
        request: FavoritesDeleteRequest
    ): EmptyResponse
}
