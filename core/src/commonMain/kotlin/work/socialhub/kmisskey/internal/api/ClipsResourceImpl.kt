package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI
import work.socialhub.kmisskey.api.ClipsResource
import work.socialhub.kmisskey.api.request.clips.*
import work.socialhub.kmisskey.api.request.clips.ClipsNotesRequest
import work.socialhub.kmisskey.api.response.clips.ClipsListResponse
import work.socialhub.kmisskey.api.response.clips.*
import work.socialhub.kmisskey.entity.share.Response


class ClipsResourceImpl(uri: String, i: String) : AbstractResourceImpl(uri, i), ClipsResource {
    
    /**
     * {@inheritDoc}
     */
    override fun list(): Response<Array<ClipsListResponse>> {
        return post(MisskeyAPI.ClipsList.path, ClipsListRequest())
    }

    /**
     * {@inheritDoc}
     */
    override fun notes(request: ClipsNotesRequest): Response<Array<ClipsNotesResponse>> {
        return post(MisskeyAPI.ClipsNotes.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun removeNote(clipId: String, noteId: String): Response<Unit> {
        return post(MisskeyAPI.ClipsRemoveNote.path, ClipsRemoveNoteRequest(noteId, clipId))
    }

    /**
     * {@inheritDoc}
     */
    override fun addNote(clipId: String, noteId: String): Response<Unit> {
        return post(MisskeyAPI.ClipsAddNote.path, ClipsAddNoteRequest(noteId, clipId))
    }

    /**
     * {@inheritDoc}
     */
    override fun deleteClip(clipId: String): Response<Unit> {
        return post(MisskeyAPI.ClipsDelete.path, ClipsDeleteRequest(clipId))
    }

    /**
     * {@inheritDoc}
     */
    override fun create(request: ClipsCreateRequest): Response<ClipsCreateResponse> {
        return post(MisskeyAPI.ClipsCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun show(clipId: String): Response<ClipsShowResponse> {
        return post(MisskeyAPI.ClipsShow.path, ClipsShowRequest(clipId))
    }

    /**
     * {@inheritDoc}
     */
    override fun update(request: ClipsUpdateRequest): Response<ClipsUpdateResponse> {
        return post(MisskeyAPI.ClipsUpdate.path, request)
    }
}
