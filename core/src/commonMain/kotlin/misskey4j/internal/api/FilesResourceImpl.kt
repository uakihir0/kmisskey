package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.entity.share.Response

class FilesResourceImpl(uri: String, i: String?) : AbstractResourceImpl(uri, i), FilesResource {
    /**
     * {@inheritDoc}
     */
    override fun create(
        request: FilesCreateRequest
    ): Response<FilesCreateResponse> {
        val params: Map<String, Any> = java.util.HashMap<String, Any>()
        addParam(params, "name", request.name)
        addParam(params, "folderId", request.folderId)
        addParam(params, "isSensitive", request.sensitive)
        addParam(params, "force", request.force)

        if (request.getFile() != null) {
            addParam(params, "file", request.getFile())
        }
        if (request.getStream() != null) {
            addParam(
                params, "file", StreamFile(
                    request.getStream(),
                    request.name
                )
            )
        }

        return post(
            FilesCreateResponse::class.java,
            MisskeyAPI.FilesCreate.code(), params
        )
    }
}
