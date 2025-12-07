package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.gallery.*
import work.socialhub.kmisskey.api.request.i.IListGalleryPostsRequest
import work.socialhub.kmisskey.api.request.users.ListUserGalleryPostsRequest
import work.socialhub.kmisskey.api.response.gallery.ListGalleryPostsResponse
import work.socialhub.kmisskey.entity.GalleryPost
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for GalleriesResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun GalleriesResource.postsPromise(
    request: ListGalleryPostsRequest
): Promise<Response<Array<ListGalleryPostsResponse>>> = GlobalScope.promise { posts(request) }

@OptIn(DelicateCoroutinesApi::class)
fun GalleriesResource.myPostsPromise(
    request: IListGalleryPostsRequest
): Promise<Response<Array<ListGalleryPostsResponse>>> = GlobalScope.promise { myPosts(request) }

@OptIn(DelicateCoroutinesApi::class)
fun GalleriesResource.usersPostsPromise(
    request: ListUserGalleryPostsRequest
): Promise<Response<Array<ListGalleryPostsResponse>>> = GlobalScope.promise { usersPosts(request) }

@OptIn(DelicateCoroutinesApi::class)
fun GalleriesResource.showPromise(
    request: ShowGalleryPostRequest
): Promise<Response<GalleryPost>> = GlobalScope.promise { show(request) }

@OptIn(DelicateCoroutinesApi::class)
fun GalleriesResource.createPromise(
    request: CreateGalleryPostRequest
): Promise<Response<GalleryPost>> = GlobalScope.promise { create(request) }

@OptIn(DelicateCoroutinesApi::class)
fun GalleriesResource.deletePromise(
    request: DeleteGalleryPostRequest
): Promise<EmptyResponse> = GlobalScope.promise { delete(request) }

@OptIn(DelicateCoroutinesApi::class)
fun GalleriesResource.updatePromise(
    request: UpdateGalleryPostRequest
): Promise<Response<GalleryPost>> = GlobalScope.promise { update(request) }

@OptIn(DelicateCoroutinesApi::class)
fun GalleriesResource.likePromise(
    request: LikeGalleryPostRequest
): Promise<EmptyResponse> = GlobalScope.promise { like(request) }

@OptIn(DelicateCoroutinesApi::class)
fun GalleriesResource.unlikePromise(
    request: UnlikeGalleryPostRequest
): Promise<EmptyResponse> = GlobalScope.promise { unlike(request) }

