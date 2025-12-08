package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.gallery.CreateGalleryPostRequest
import work.socialhub.kmisskey.api.request.gallery.DeleteGalleryPostRequest
import work.socialhub.kmisskey.api.request.gallery.LikeGalleryPostRequest
import work.socialhub.kmisskey.api.request.gallery.ListGalleryPostsRequest
import work.socialhub.kmisskey.api.request.gallery.ShowGalleryPostRequest
import work.socialhub.kmisskey.api.request.gallery.UnlikeGalleryPostRequest
import work.socialhub.kmisskey.api.request.gallery.UpdateGalleryPostRequest
import work.socialhub.kmisskey.api.request.i.IListGalleryPostsRequest
import work.socialhub.kmisskey.api.request.users.ListUserGalleryPostsRequest
import work.socialhub.kmisskey.api.response.gallery.ListGalleryPostsResponse
import work.socialhub.kmisskey.entity.GalleryPost
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface GalleriesResource {

    /**
     * Get gallery posts.
     * @see "https://misskey.io/api-doc.operation/gallery/posts"
     */
    @JsExport.Ignore
    suspend fun posts(
        request: ListGalleryPostsRequest
    ): Response<Array<ListGalleryPostsResponse>>

    @JsExport.Ignore
    fun postsBlocking(
        request: ListGalleryPostsRequest
    ): Response<Array<ListGalleryPostsResponse>>

    /**
     * Get my gallery posts.
     * @see "https://misskey.io/api-doc.operation/i/gallery/posts"
     */
    @JsExport.Ignore
    suspend fun myPosts(
        request: IListGalleryPostsRequest
    ): Response<Array<ListGalleryPostsResponse>>

    @JsExport.Ignore
    fun myPostsBlocking(
        request: IListGalleryPostsRequest
    ): Response<Array<ListGalleryPostsResponse>>

    /**
     * Get user's gallery posts.
     * @see "https://misskey.io/api-doc.operation/users/gallery/posts"
     */
    @JsExport.Ignore
    suspend fun usersPosts(
        request: ListUserGalleryPostsRequest
    ): Response<Array<ListGalleryPostsResponse>>

    @JsExport.Ignore
    fun usersPostsBlocking(
        request: ListUserGalleryPostsRequest
    ): Response<Array<ListGalleryPostsResponse>>

    /**
     * Show a gallery post.
     * @see "https://misskey.io/api-doc.operation/gallery/posts/show"
     */
    @JsExport.Ignore
    suspend fun show(
        request: ShowGalleryPostRequest
    ): Response<GalleryPost>

    @JsExport.Ignore
    fun showBlocking(
        request: ShowGalleryPostRequest
    ): Response<GalleryPost>

    /**
     * Create a gallery post.
     * @see "https://misskey.io/api-doc.operation/gallery/posts/create"
     */
    @JsExport.Ignore
    suspend fun create(
        request: CreateGalleryPostRequest
    ): Response<GalleryPost>

    @JsExport.Ignore
    fun createBlocking(
        request: CreateGalleryPostRequest
    ): Response<GalleryPost>

    /**
     * Delete a gallery post.
     *
     * @see "https://misskey.io/api-doc.operation/gallery/posts/delete"
     */
    @JsExport.Ignore
    suspend fun delete(
        request: DeleteGalleryPostRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun deleteBlocking(
        request: DeleteGalleryPostRequest
    ): EmptyResponse

    /**
     * Update a gallery post.
     * @see "https://misskey.io/api-doc.operation/gallery/posts/delete"
     */
    @JsExport.Ignore
    suspend fun update(
        request: UpdateGalleryPostRequest
    ): Response<GalleryPost>

    @JsExport.Ignore
    fun updateBlocking(
        request: UpdateGalleryPostRequest
    ): Response<GalleryPost>

    /**
     * Like a gallery post.
     * @see "https://misskey.io/api-doc.operation/gallery/posts/like"
     */
    @JsExport.Ignore
    suspend fun like(
        request: LikeGalleryPostRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun likeBlocking(
        request: LikeGalleryPostRequest
    ): EmptyResponse

    /**
     * Unlike a gallery post.
     *
     * @see "https://misskey.io/api-doc.operation/gallery/posts/unlike"
     */
    @JsExport.Ignore
    suspend fun unlike(
        request: UnlikeGalleryPostRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun unlikeBlocking(
        request: UnlikeGalleryPostRequest
    ): EmptyResponse
}
