package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.PagesCreate
import work.socialhub.kmisskey.MisskeyAPI.PagesDelete
import work.socialhub.kmisskey.MisskeyAPI.PagesShow
import work.socialhub.kmisskey.MisskeyAPI.PagesUpdate
import work.socialhub.kmisskey.api.PagesResource
import work.socialhub.kmisskey.api.request.pages.PagesCreateRequest
import work.socialhub.kmisskey.api.request.pages.PagesDeleteRequest
import work.socialhub.kmisskey.api.request.pages.PagesShowRequest
import work.socialhub.kmisskey.api.request.pages.PagesUpdateRequest
import work.socialhub.kmisskey.entity.Page
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.internal.model.BytesFile
import work.socialhub.kmisskey.util.toBlocking

class PagesResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    PagesResource {

    override suspend fun create(
        request: PagesCreateRequest
    ): Response<Page> {
        return post(PagesCreate.path, request)
    }

    override fun createBlocking(
        request: PagesCreateRequest
    ): Response<Page> {
        return toBlocking {
            create(request)
        }
    }

    override suspend fun delete(
        request: PagesDeleteRequest
    ): EmptyResponse {
        return postUnit(PagesDelete.path, request)
    }

    override fun deleteBlocking(
        request: PagesDeleteRequest
    ): EmptyResponse {
        return toBlocking {
            delete(request)
        }
    }

    override suspend fun show(
        request: PagesShowRequest
    ): Response<Page> {
        return post(PagesShow.path, request)
    }

    override fun showBlocking(
        request: PagesShowRequest
    ): Response<Page> {
        return toBlocking {
            show(request)
        }
    }

    override suspend fun update(
        request: PagesUpdateRequest
    ): Response<Page> {
        return post(PagesUpdate.path, request)
    }

    override fun updateBlocking(
        request: PagesUpdateRequest
    ): Response<Page> {
        return toBlocking {
            update(request)
        }
    }
}
