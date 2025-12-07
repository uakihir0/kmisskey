package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.notes.*
import work.socialhub.kmisskey.api.response.notes.*
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for NotesResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.usersPromise(
    request: UsersNotesRequest
): Promise<Response<Array<UsersNotesResponse>>> = GlobalScope.promise { users(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.notesPromise(
    request: NotesRequest
): Promise<Response<Array<NotesResponse>>> = GlobalScope.promise { notes(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.childrenPromise(
    request: NotesChildrenRequest
): Promise<Response<Array<NotesChildrenResponse>>> = GlobalScope.promise { children(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.repliesPromise(
    request: NotesRepliesRequest
): Promise<Response<Array<NotesRepliesResponse>>> = GlobalScope.promise { replies(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.conversationPromise(
    request: NotesConversationRequest
): Promise<Response<Array<NotesConversationResponse>>> = GlobalScope.promise { conversation(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.createPromise(
    request: NotesCreateRequest
): Promise<Response<NotesCreateResponse>> = GlobalScope.promise { create(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.deletePromise(
    request: NotesDeleteRequest
): Promise<EmptyResponse> = GlobalScope.promise { delete(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.mentionsPromise(
    request: NotesMentionsRequest
): Promise<Response<Array<NotesMentionsResponse>>> = GlobalScope.promise { mentions(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.featuredPromise(
    request: NotesFeaturedRequest
): Promise<Response<Array<NotesFeaturedResponse>>> = GlobalScope.promise { featured(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.globalTimelinePromise(
    request: NotesGlobalTimelineRequest
): Promise<Response<Array<NotesGlobalTimelineResponse>>> = GlobalScope.promise { globalTimeline(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.hybridTimelinePromise(
    request: NotesHybridTimelineRequest
): Promise<Response<Array<NotesHybridTimelineResponse>>> = GlobalScope.promise { hybridTimeline(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.localTimelinePromise(
    request: NotesLocalTimelineRequest
): Promise<Response<Array<NotesLocalTimelineResponse>>> = GlobalScope.promise { localTimeline(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.reactionsPromise(
    request: NotesReactionsRequest
): Promise<Response<Array<NotesReactionsResponse>>> = GlobalScope.promise { reactions(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.timelinePromise(
    request: NotesTimelineRequest
): Promise<Response<Array<NotesTimelineResponse>>> = GlobalScope.promise { timeline(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.showPromise(
    request: NotesShowRequest
): Promise<Response<NotesShowResponse>> = GlobalScope.promise { show(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.searchPromise(
    request: NotesSearchRequest
): Promise<Response<Array<NotesSearchResponse>>> = GlobalScope.promise { search(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.searchByTagPromise(
    request: NotesSearchByTagRequest
): Promise<Response<Array<NotesSearchByTagResponse>>> = GlobalScope.promise { searchByTag(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.userListTimelinePromise(
    request: NotesUserListTimelineRequest
): Promise<Response<Array<NotesUserListTimelineResponse>>> = GlobalScope.promise { userListTimeline(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.unrenotePromise(
    request: NoteUnrenoteRequest
): Promise<EmptyResponse> = GlobalScope.promise { unrenote(request) }

@OptIn(DelicateCoroutinesApi::class)
fun NotesResource.renotesPromise(
    request: NotesRenotesRequest
): Promise<Response<Array<NotesRenotesResponse>>> = GlobalScope.promise { renotes(request) }

