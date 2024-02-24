package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.api.FilesResource
import misskey4j.api.request.files.FilesCreateRequest
import misskey4j.api.response.files.FilesCreateResponse
import misskey4j.entity.share.Response
import misskey4j.internal.model.BytesFile

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
        params.add("folderId", request.folderId)
        params.add("isSensitive", request.sensitive)
        params.add("force", request.force)

        params.add(
            "file", BytesFile(
                bytes = request.bytes!!,
                name = request.name!!,
            )
        )

        return post(
            MisskeyAPI.FilesCreate.path,
            params
        )
    }
}
