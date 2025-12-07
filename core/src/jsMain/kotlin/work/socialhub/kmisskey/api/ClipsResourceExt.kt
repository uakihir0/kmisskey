package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.clips.*
import work.socialhub.kmisskey.api.response.clips.*
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for ClipsResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun ClipsResource.listPromise(
    request: ClipsListRequest
): Promise<Response<Array<ClipsListResponse>>> = GlobalScope.promise { list(request) }

@OptIn(DelicateCoroutinesApi::class)
fun ClipsResource.notesPromise(
    request: ClipsNotesRequest
): Promise<Response<Array<ClipsNotesResponse>>> = GlobalScope.promise { notes(request) }

@OptIn(DelicateCoroutinesApi::class)
fun ClipsResource.removeNotePromise(
    request: ClipsRemoveNoteRequest
): Promise<EmptyResponse> = GlobalScope.promise { removeNote(request) }

@OptIn(DelicateCoroutinesApi::class)
fun ClipsResource.addNotePromise(
    request: ClipsAddNoteRequest
): Promise<EmptyResponse> = GlobalScope.promise { addNote(request) }

@OptIn(DelicateCoroutinesApi::class)
fun ClipsResource.deleteClipPromise(
    request: ClipsDeleteRequest
): Promise<EmptyResponse> = GlobalScope.promise { deleteClip(request) }

@OptIn(DelicateCoroutinesApi::class)
fun ClipsResource.createPromise(
    request: ClipsCreateRequest
): Promise<Response<ClipsCreateResponse>> = GlobalScope.promise { create(request) }

@OptIn(DelicateCoroutinesApi::class)
fun ClipsResource.showPromise(
    request: ClipsShowRequest
): Promise<Response<ClipsShowResponse>> = GlobalScope.promise { show(request) }

@OptIn(DelicateCoroutinesApi::class)
fun ClipsResource.updatePromise(
    request: ClipsUpdateRequest
): Promise<Response<ClipsUpdateResponse>> = GlobalScope.promise { update(request) }

