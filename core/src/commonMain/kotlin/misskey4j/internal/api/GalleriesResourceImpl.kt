package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.entity.share.Response

class GalleriesResourceImpl(uri: String, i: String?) : AbstractResourceImpl(uri, i), GalleriesResource {
    override fun posts(request: ListGalleryPostsRequest): Response<Array<ListGalleryPostsResponse>> {
        return post(
            Array<ListGalleryPostsResponse>::class.java,
            MisskeyAPI.GalleryPosts.code(), request
        )
    }

    override fun posts(request: IListGalleryPostsRequest): Response<Array<ListGalleryPostsResponse>> {
        return post(
            Array<ListGalleryPostsResponse>::class.java,
            MisskeyAPI.IGalleryPosts.code(), request
        )
    }

    override fun posts(request: ListUserGalleryPostsRequest): Response<Array<ListGalleryPostsResponse>> {
        return post(
            Array<ListGalleryPostsResponse>::class.java,
            MisskeyAPI.UserGalleryPosts.code(), request
        )
    }

    override fun show(request: ShowGalleryPostRequest): Response<GalleryPost> {
        return post(
            GalleryPost::class.java,
            MisskeyAPI.ShowGalleryPost.code(), request
        )
    }

    override fun create(request: CreateGalleryPostRequest): Response<GalleryPost> {
        return post(
            GalleryPost::class.java,
            MisskeyAPI.CreateGalleryPost.code(), request
        )
    }

    override fun delete(request: DeleteGalleryPostRequest): Response<java.lang.Void> {
        return post(MisskeyAPI.DeleteGalleryPost.code(), request)
    }

    override fun update(request: UpdateGalleryPostRequest): Response<GalleryPost> {
        return post(
            GalleryPost::class.java,
            MisskeyAPI.UpdateGalleryPost.code(), request
        )
    }

    override fun like(request: LikeGalleryPostRequest): Response<java.lang.Void> {
        return post(MisskeyAPI.LikeGalleryPost.code(), request)
    }

    override fun like(request: UnlikeGalleryPostRequest): Response<java.lang.Void> {
        return post(MisskeyAPI.UnlikeGalleryPost.code(), request)
    }
}
