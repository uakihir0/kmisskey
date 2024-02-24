package misskey4j.internal.api

import misskey4j.MisskeyAPI.*
import misskey4j.api.NotesResource
import misskey4j.api.request.notes.*
import misskey4j.api.response.notes.*
import misskey4j.entity.share.Response

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
    ): Response<Unit> {
        return post(NotesDelete.path, request)
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
    ): Response<Unit> {
        return post(NotesUnrenote.path, request)
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
