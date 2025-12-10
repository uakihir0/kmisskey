package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.Folders
import work.socialhub.kmisskey.MisskeyAPI.FoldersCreate
import work.socialhub.kmisskey.MisskeyAPI.FoldersDelete
import work.socialhub.kmisskey.MisskeyAPI.FoldersShow
import work.socialhub.kmisskey.MisskeyAPI.FoldersUpdate
import work.socialhub.kmisskey.api.FoldersResource
import work.socialhub.kmisskey.api.request.folders.FoldersCreateRequest
import work.socialhub.kmisskey.api.request.folders.FoldersDeleteRequest
import work.socialhub.kmisskey.api.request.folders.FoldersRequest
import work.socialhub.kmisskey.api.request.folders.FoldersShowRequest
import work.socialhub.kmisskey.api.request.folders.FoldersUpdateRequest
import work.socialhub.kmisskey.entity.Folder
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.util.toBlocking

class FoldersResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    FoldersResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun create(
        request: FoldersCreateRequest
    ): Response<Folder> {
        return post(FoldersCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun createBlocking(
        request: FoldersCreateRequest
    ): Response<Folder> {
        return toBlocking {
            create(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun list(
        request: FoldersRequest
    ): Response<Array<Folder>> {
        return post(Folders.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun listBlocking(
        request: FoldersRequest
    ): Response<Array<Folder>> {
        return toBlocking {
            list(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun show(
        request: FoldersShowRequest
    ): Response<Folder> {
        return post(FoldersShow.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun showBlocking(
        request: FoldersShowRequest
    ): Response<Folder> {
        return toBlocking {
            show(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun delete(
        request: FoldersDeleteRequest
    ): EmptyResponse {
        return postUnit(FoldersDelete.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun deleteBlocking(
        request: FoldersDeleteRequest
    ): EmptyResponse {
        return toBlocking {
            delete(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun update(
        request: FoldersUpdateRequest
    ): Response<Folder> {
        return post(FoldersUpdate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun updateBlocking(
        request: FoldersUpdateRequest
    ): Response<Folder> {
        return toBlocking {
            update(request)
        }
    }
}
