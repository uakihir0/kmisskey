package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.api.GalleriesResource
import misskey4j.api.request.gallery.*
import misskey4j.api.request.i.IListGalleryPostsRequest
import misskey4j.api.request.users.ListUserGalleryPostsRequest
import misskey4j.api.response.gallery.ListGalleryPostsResponse
import misskey4j.entity.GalleryPost
import misskey4j.entity.share.Response

class GalleriesResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    GalleriesResource {

    override fun posts(
        request: ListGalleryPostsRequest
    ): Response<Array<ListGalleryPostsResponse>> {
        return post(
            MisskeyAPI.GalleryPosts.path,
            request
        )
    }

    override fun posts(
        request: IListGalleryPostsRequest
    ): Response<Array<ListGalleryPostsResponse>> {
        return post(
            MisskeyAPI.IGalleryPosts.path,
            request
        )
    }

    override fun posts(
        request: ListUserGalleryPostsRequest
    ): Response<Array<ListGalleryPostsResponse>> {
        return post(
            MisskeyAPI.UserGalleryPosts.path,
            request
        )
    }

    override fun show(
        request: ShowGalleryPostRequest
    ): Response<GalleryPost> {
        return post(
            MisskeyAPI.ShowGalleryPost.path,
            request
        )
    }

    override fun create(
        request: CreateGalleryPostRequest
    ): Response<GalleryPost> {
        return post(
            MisskeyAPI.CreateGalleryPost.path,
            request
        )
    }

    override fun delete(
        request: DeleteGalleryPostRequest
    ): Response<Unit> {
        return post(
            MisskeyAPI.DeleteGalleryPost.path,
            request
        )
    }

    override fun update(
        request: UpdateGalleryPostRequest
    ): Response<GalleryPost> {
        return post(
            MisskeyAPI.UpdateGalleryPost.path,
            request
        )
    }

    override fun like(
        request: LikeGalleryPostRequest
    ): Response<Unit> {
        return post(
            MisskeyAPI.LikeGalleryPost.path,
            request
        )
    }

    override fun like(
        request: UnlikeGalleryPostRequest
    ): Response<Unit> {
        return post(
            MisskeyAPI.UnlikeGalleryPost.path,
            request
        )
    }
}
