package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.FilesCreate
import work.socialhub.kmisskey.api.FilesResource
import work.socialhub.kmisskey.api.request.files.FilesCreateRequest
import work.socialhub.kmisskey.api.response.files.FilesCreateResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.internal.model.BytesFile

class FilesResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    FilesResource {

    /**
     * {@inheritDoc}
     */
    override fun create(
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

        return post(FilesCreate.path, params)
    }
}
