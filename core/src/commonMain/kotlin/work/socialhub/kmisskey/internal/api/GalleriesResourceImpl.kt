package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.CreateGalleryPost
import work.socialhub.kmisskey.MisskeyAPI.DeleteGalleryPost
import work.socialhub.kmisskey.MisskeyAPI.GalleryPosts
import work.socialhub.kmisskey.MisskeyAPI.IGalleryPosts
import work.socialhub.kmisskey.MisskeyAPI.LikeGalleryPost
import work.socialhub.kmisskey.MisskeyAPI.ShowGalleryPost
import work.socialhub.kmisskey.MisskeyAPI.UnlikeGalleryPost
import work.socialhub.kmisskey.MisskeyAPI.UpdateGalleryPost
import work.socialhub.kmisskey.MisskeyAPI.UserGalleryPosts
import work.socialhub.kmisskey.api.GalleriesResource
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

    override fun myPosts(
        request: IListGalleryPostsRequest
    ): Response<Array<ListGalleryPostsResponse>> {
        return post(IGalleryPosts.path, request)
    }

    override fun usersPosts(
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
    ): EmptyResponse {
        return postUnit(DeleteGalleryPost.path, request)
    }

    override fun update(
        request: UpdateGalleryPostRequest
    ): Response<GalleryPost> {
        return post(UpdateGalleryPost.path, request)
    }

    override fun like(
        request: LikeGalleryPostRequest
    ): EmptyResponse {
        return postUnit(LikeGalleryPost.path, request)
    }

    override fun unlike(
        request: UnlikeGalleryPostRequest
    ): EmptyResponse {
        return postUnit(UnlikeGalleryPost.path, request)
    }
}
