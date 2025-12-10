package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.Files
import work.socialhub.kmisskey.MisskeyAPI.FilesCreate
import work.socialhub.kmisskey.MisskeyAPI.FilesDelete
import work.socialhub.kmisskey.MisskeyAPI.FilesFind
import work.socialhub.kmisskey.MisskeyAPI.FilesShow
import work.socialhub.kmisskey.MisskeyAPI.FilesUpdate
import work.socialhub.kmisskey.api.FilesResource
import work.socialhub.kmisskey.api.request.files.FilesCreateRequest
import work.socialhub.kmisskey.api.request.files.FilesDeleteRequest
import work.socialhub.kmisskey.api.request.files.FilesFindRequest
import work.socialhub.kmisskey.api.request.files.FilesRequest
import work.socialhub.kmisskey.api.request.files.FilesShowRequest
import work.socialhub.kmisskey.api.request.files.FilesUpdateRequest
import work.socialhub.kmisskey.api.response.files.FilesCreateResponse
import work.socialhub.kmisskey.entity.File
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.internal.model.BytesFile
import work.socialhub.kmisskey.util.toBlocking

class FilesResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    FilesResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun create(
        request: FilesCreateRequest
    ): Response<FilesCreateResponse> {

        val params = mutableMapOf<String, Any>()
        params.add("name", request.name)
        params.add("comment", request.comment)
        params.add("folderId", request.folderId)
        params.add("isSensitive", request.sensitive)
        params.add("force", request.force)

        params.add(
            "file", BytesFile(
                bytes = request.bytes!!,
                name = request.name!!,
            )
        )

        return postWithFile(FilesCreate.path, params)
    }

    /**
     * {@inheritDoc}
     */
    override fun createBlocking(
        request: FilesCreateRequest
    ): Response<FilesCreateResponse> {
        return toBlocking {
            create(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun show(
        request: FilesShowRequest
    ): Response<File> {
        return post(FilesShow.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun showBlocking(
        request: FilesShowRequest
    ): Response<File> {
        return toBlocking {
            show(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun list(
        request: FilesRequest
    ): Response<Array<File>> {
        return post(Files.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun listBlocking(
        request: FilesRequest
    ): Response<Array<File>> {
        return toBlocking {
            list(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun find(
        request: FilesFindRequest
    ): Response<Array<File>> {
        return post(FilesFind.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun findBlocking(
        request: FilesFindRequest
    ): Response<Array<File>> {
        return toBlocking {
            find(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun delete(
        request: FilesDeleteRequest
    ): EmptyResponse {
        return postUnit(FilesDelete.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun deleteBlocking(
        request: FilesDeleteRequest
    ): EmptyResponse {
        return toBlocking {
            delete(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun update(
        request: FilesUpdateRequest
    ): Response<File> {
        return post(FilesUpdate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun updateBlocking(
        request: FilesUpdateRequest
    ): Response<File> {
        return toBlocking {
            update(request)
        }
    }
}
