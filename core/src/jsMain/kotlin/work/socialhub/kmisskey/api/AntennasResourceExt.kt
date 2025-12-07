package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.antennas.AntennasListRequest
import work.socialhub.kmisskey.api.request.antennas.AntennasNotesRequest
import work.socialhub.kmisskey.api.response.antennas.AntennasListResponse
import work.socialhub.kmisskey.api.response.antennas.AntennasNotesResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for AntennasResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun AntennasResource.listPromise(
    request: AntennasListRequest
): Promise<Response<Array<AntennasListResponse>>> = GlobalScope.promise { list(request) }

@OptIn(DelicateCoroutinesApi::class)
fun AntennasResource.notesPromise(
    request: AntennasNotesRequest
): Promise<Response<Array<AntennasNotesResponse>>> = GlobalScope.promise { notes(request) }

