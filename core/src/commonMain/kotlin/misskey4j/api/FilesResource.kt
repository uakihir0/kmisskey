package misskey4j.api

import misskey4j.api.request.files.FilesCreateRequest
import misskey4j.api.response.files.FilesCreateResponse
import misskey4j.entity.share.Response

interface FilesResource {

    /**
     * ドライブにファイルをアップロードします。
     * https://misskey.io/api-doc#operation/drive/files/create
     */
    fun create(
        request: FilesCreateRequest
    ): Response<FilesCreateResponse>
}
