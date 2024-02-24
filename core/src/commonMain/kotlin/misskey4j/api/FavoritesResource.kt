package misskey4j.api

import misskey4j.api.request.favorites.FavoritesCreateRequest
import misskey4j.api.request.favorites.FavoritesDeleteRequest
import misskey4j.entity.share.Response

interface FavoritesResource {

    /**
     * 指定した投稿をお気に入りに登録します。
     * https://misskey.io/api-doc#operation/notes/favorites/create
     */
    fun create(
        request: FavoritesCreateRequest
    ): Response<Unit>

    /**
     * 指定した投稿のお気に入りを解除します。
     * https://misskey.io/api-doc#operation/notes/favorites/delete
     */
    fun delete(
        request: FavoritesDeleteRequest
    ): Response<Unit>
}
