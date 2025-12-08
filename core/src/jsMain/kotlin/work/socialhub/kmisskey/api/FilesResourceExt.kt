package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.files.FilesCreateRequest
import work.socialhub.kmisskey.api.response.files.FilesCreateResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for FilesResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun FilesResource.createPromise(
    request: FilesCreateRequest
): Promise<Response<FilesCreateResponse>> = GlobalScope.promise { create(request) }

