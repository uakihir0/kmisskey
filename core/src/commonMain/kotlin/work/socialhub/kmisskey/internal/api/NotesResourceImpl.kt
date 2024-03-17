package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.Notes
import work.socialhub.kmisskey.MisskeyAPI.NotesChildren
import work.socialhub.kmisskey.MisskeyAPI.NotesConversation
import work.socialhub.kmisskey.MisskeyAPI.NotesCreate
import work.socialhub.kmisskey.MisskeyAPI.NotesDelete
import work.socialhub.kmisskey.MisskeyAPI.NotesFeatured
import work.socialhub.kmisskey.MisskeyAPI.NotesGlobalTimeline
import work.socialhub.kmisskey.MisskeyAPI.NotesHybridTimeline
import work.socialhub.kmisskey.MisskeyAPI.NotesLocalTimeline
import work.socialhub.kmisskey.MisskeyAPI.NotesMentions
import work.socialhub.kmisskey.MisskeyAPI.NotesReactions
import work.socialhub.kmisskey.MisskeyAPI.NotesRenotes
import work.socialhub.kmisskey.MisskeyAPI.NotesReplies
import work.socialhub.kmisskey.MisskeyAPI.NotesSearch
import work.socialhub.kmisskey.MisskeyAPI.NotesSearchByTag
import work.socialhub.kmisskey.MisskeyAPI.NotesShow
import work.socialhub.kmisskey.MisskeyAPI.NotesTimeline
import work.socialhub.kmisskey.MisskeyAPI.NotesUnrenote
import work.socialhub.kmisskey.MisskeyAPI.NotesUserListTimeline
import work.socialhub.kmisskey.MisskeyAPI.UsersNotes
import work.socialhub.kmisskey.api.NotesResource
import work.socialhub.kmisskey.api.request.notes.NoteUnrenoteRequest
import work.socialhub.kmisskey.api.request.notes.NotesChildrenRequest
import work.socialhub.kmisskey.api.request.notes.NotesConversationRequest
import work.socialhub.kmisskey.api.request.notes.NotesCreateRequest
import work.socialhub.kmisskey.api.request.notes.NotesDeleteRequest
import work.socialhub.kmisskey.api.request.notes.NotesFeaturedRequest
import work.socialhub.kmisskey.api.request.notes.NotesGlobalTimelineRequest
import work.socialhub.kmisskey.api.request.notes.NotesHybridTimelineRequest
import work.socialhub.kmisskey.api.request.notes.NotesLocalTimelineRequest
import work.socialhub.kmisskey.api.request.notes.NotesMentionsRequest
import work.socialhub.kmisskey.api.request.notes.NotesReactionsRequest
import work.socialhub.kmisskey.api.request.notes.NotesRenotesRequest
import work.socialhub.kmisskey.api.request.notes.NotesRepliesRequest
import work.socialhub.kmisskey.api.request.notes.NotesRequest
import work.socialhub.kmisskey.api.request.notes.NotesSearchByTagRequest
import work.socialhub.kmisskey.api.request.notes.NotesSearchRequest
import work.socialhub.kmisskey.api.request.notes.NotesShowRequest
import work.socialhub.kmisskey.api.request.notes.NotesTimelineRequest
import work.socialhub.kmisskey.api.request.notes.NotesUserListTimelineRequest
import work.socialhub.kmisskey.api.request.notes.UsersNotesRequest
import work.socialhub.kmisskey.api.response.notes.NotesChildrenResponse
import work.socialhub.kmisskey.api.response.notes.NotesConversationResponse
import work.socialhub.kmisskey.api.response.notes.NotesCreateResponse
import work.socialhub.kmisskey.api.response.notes.NotesFeaturedResponse
import work.socialhub.kmisskey.api.response.notes.NotesGlobalTimelineResponse
import work.socialhub.kmisskey.api.response.notes.NotesHybridTimelineResponse
import work.socialhub.kmisskey.api.response.notes.NotesLocalTimelineResponse
import work.socialhub.kmisskey.api.response.notes.NotesMentionsResponse
import work.socialhub.kmisskey.api.response.notes.NotesReactionsResponse
import work.socialhub.kmisskey.api.response.notes.NotesRenotesResponse
import work.socialhub.kmisskey.api.response.notes.NotesRepliesResponse
import work.socialhub.kmisskey.api.response.notes.NotesResponse
import work.socialhub.kmisskey.api.response.notes.NotesSearchByTagResponse
import work.socialhub.kmisskey.api.response.notes.NotesSearchResponse
import work.socialhub.kmisskey.api.response.notes.NotesShowResponse
import work.socialhub.kmisskey.api.response.notes.NotesTimelineResponse
import work.socialhub.kmisskey.api.response.notes.NotesUserListTimelineResponse
import work.socialhub.kmisskey.api.response.notes.UsersNotesResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response

class NotesResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    NotesResource {

    /**
     * {@inheritDoc}
     */
    override fun users(
        request: UsersNotesRequest
    ): Response<Array<UsersNotesResponse>> {
        return post(UsersNotes.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun notes(
        request: NotesRequest
    ): Response<Array<NotesResponse>> {
        return post(Notes.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun children(
        request: NotesChildrenRequest
    ): Response<Array<NotesChildrenResponse>> {
        return post(NotesChildren.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun replies(
        request: NotesRepliesRequest
    ): Response<Array<NotesRepliesResponse>> {
        return post(NotesReplies.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun conversation(
        request: NotesConversationRequest
    ): Response<Array<NotesConversationResponse>> {
        return post(NotesConversation.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun create(
        request: NotesCreateRequest
    ): Response<NotesCreateResponse> {
        return post(NotesCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun delete(
        request: NotesDeleteRequest
    ): EmptyResponse {
        return postUnit(NotesDelete.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun mentions(
        request: NotesMentionsRequest
    ): Response<Array<NotesMentionsResponse>> {
        return post(NotesMentions.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun featured(
        request: NotesFeaturedRequest
    ): Response<Array<NotesFeaturedResponse>> {
        return post(NotesFeatured.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun globalTimeline(
        request: NotesGlobalTimelineRequest
    ): Response<Array<NotesGlobalTimelineResponse>> {
        return post(NotesGlobalTimeline.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun hybridTimeline(
        request: NotesHybridTimelineRequest
    ): Response<Array<NotesHybridTimelineResponse>> {
        return post(NotesHybridTimeline.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun localTimeline(
        request: NotesLocalTimelineRequest
    ): Response<Array<NotesLocalTimelineResponse>> {
        return post(NotesLocalTimeline.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun reactions(
        request: NotesReactionsRequest
    ): Response<Array<NotesReactionsResponse>> {
        return post(NotesReactions.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun timeline(
        request: NotesTimelineRequest
    ): Response<Array<NotesTimelineResponse>> {
        return post(NotesTimeline.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun show(
        request: NotesShowRequest
    ): Response<NotesShowResponse> {
        return post(NotesShow.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun search(
        request: NotesSearchRequest
    ): Response<Array<NotesSearchResponse>> {
        return post(NotesSearch.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun searchByTag(
        request: NotesSearchByTagRequest
    ): Response<Array<NotesSearchByTagResponse>> {
        return post(NotesSearchByTag.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun userListTimeline(
        request: NotesUserListTimelineRequest
    ): Response<Array<NotesUserListTimelineResponse>> {
        return post(NotesUserListTimeline.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun unrenote(
        request: NoteUnrenoteRequest
    ): EmptyResponse {
        return postUnit(NotesUnrenote.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun renotes(
        request: NotesRenotesRequest
    ): Response<Array<NotesRenotesResponse>> {
        return post(NotesRenotes.path, request)
    }
}
