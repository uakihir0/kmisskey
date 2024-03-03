package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.*
import work.socialhub.kmisskey.api.GalleriesResource
import work.socialhub.kmisskey.api.request.gallery.*
import work.socialhub.kmisskey.api.request.i.IListGalleryPostsRequest
import work.socialhub.kmisskey.api.request.users.ListUserGalleryPostsRequest
import work.socialhub.kmisskey.api.response.gallery.ListGalleryPostsResponse
import work.socialhub.kmisskey.entity.GalleryPost
import work.socialhub.kmisskey.entity.share.Response

class GalleriesResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    GalleriesResource {

    override fun posts(
        request: ListGalleryPostsRequest
    ): Response<Array<ListGalleryPostsResponse>> {
        return post(GalleryPosts.path, request)
    }

    override fun posts(
        request: IListGalleryPostsRequest
    ): Response<Array<ListGalleryPostsResponse>> {
        return post(IGalleryPosts.path, request)
    }

    override fun posts(
        request: ListUserGalleryPostsRequest
    ): Response<Array<ListGalleryPostsResponse>> {
        return post(UserGalleryPosts.path, request)
    }

    override fun show(
        request: ShowGalleryPostRequest
    ): Response<GalleryPost> {
        return post(ShowGalleryPost.path, request)
    }

    override fun create(
        request: CreateGalleryPostRequest
    ): Response<GalleryPost> {
        return post(CreateGalleryPost.path, request)
    }

    override fun delete(
        request: DeleteGalleryPostRequest
    ): Response<Unit> {
        return post(DeleteGalleryPost.path, request)
    }

    override fun update(
        request: UpdateGalleryPostRequest
    ): Response<GalleryPost> {
        return post(UpdateGalleryPost.path, request)
    }

    override fun like(
        request: LikeGalleryPostRequest
    ): Response<Unit> {
        return post(LikeGalleryPost.path, request)
    }

    override fun like(
        request: UnlikeGalleryPostRequest
    ): Response<Unit> {
        return post(UnlikeGalleryPost.path, request)
    }
}
