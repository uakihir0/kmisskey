package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.ClipsAddNote
import work.socialhub.kmisskey.MisskeyAPI.ClipsCreate
import work.socialhub.kmisskey.MisskeyAPI.ClipsDelete
import work.socialhub.kmisskey.MisskeyAPI.ClipsList
import work.socialhub.kmisskey.MisskeyAPI.ClipsNotes
import work.socialhub.kmisskey.MisskeyAPI.ClipsRemoveNote
import work.socialhub.kmisskey.MisskeyAPI.ClipsShow
import work.socialhub.kmisskey.MisskeyAPI.ClipsUpdate
import work.socialhub.kmisskey.api.ClipsResource
import work.socialhub.kmisskey.api.request.clips.ClipsAddNoteRequest
import work.socialhub.kmisskey.api.request.clips.ClipsCreateRequest
import work.socialhub.kmisskey.api.request.clips.ClipsDeleteRequest
import work.socialhub.kmisskey.api.request.clips.ClipsListRequest
import work.socialhub.kmisskey.api.request.clips.ClipsNotesRequest
import work.socialhub.kmisskey.api.request.clips.ClipsRemoveNoteRequest
import work.socialhub.kmisskey.api.request.clips.ClipsShowRequest
import work.socialhub.kmisskey.api.request.clips.ClipsUpdateRequest
import work.socialhub.kmisskey.api.response.clips.ClipsCreateResponse
import work.socialhub.kmisskey.api.response.clips.ClipsListResponse
import work.socialhub.kmisskey.api.response.clips.ClipsNotesResponse
import work.socialhub.kmisskey.api.response.clips.ClipsShowResponse
import work.socialhub.kmisskey.api.response.clips.ClipsUpdateResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.util.toBlocking

class ClipsResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    ClipsResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun list(
        request: ClipsListRequest
    ): Response<Array<ClipsListResponse>> {
        return post(ClipsList.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun listBlocking(
        request: ClipsListRequest
    ): Response<Array<ClipsListResponse>> {
        return toBlocking {
            list(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun notes(
        request: ClipsNotesRequest
    ): Response<Array<ClipsNotesResponse>> {
        return post(ClipsNotes.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun notesBlocking(
        request: ClipsNotesRequest
    ): Response<Array<ClipsNotesResponse>> {
        return toBlocking {
            notes(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun removeNote(
        request: ClipsRemoveNoteRequest
    ): EmptyResponse {
        return postUnit(ClipsRemoveNote.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun removeNoteBlocking(
        request: ClipsRemoveNoteRequest
    ): EmptyResponse {
        return toBlocking {
            removeNote(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun addNote(
        request: ClipsAddNoteRequest
    ): EmptyResponse {
        return postUnit(ClipsAddNote.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun addNoteBlocking(
        request: ClipsAddNoteRequest
    ): EmptyResponse {
        return toBlocking {
            addNote(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun deleteClip(
        request: ClipsDeleteRequest
    ): EmptyResponse {
        return postUnit(ClipsDelete.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun deleteClipBlocking(
        request: ClipsDeleteRequest
    ): EmptyResponse {
        return toBlocking {
            deleteClip(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun create(
        request: ClipsCreateRequest
    ): Response<ClipsCreateResponse> {
        return post(ClipsCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun createBlocking(
        request: ClipsCreateRequest
    ): Response<ClipsCreateResponse> {
        return toBlocking {
            create(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun show(
        request: ClipsShowRequest
    ): Response<ClipsShowResponse> {
        return post(ClipsShow.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun showBlocking(
        request: ClipsShowRequest
    ): Response<ClipsShowResponse> {
        return toBlocking {
            show(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun update(
        request: ClipsUpdateRequest
    ): Response<ClipsUpdateResponse> {
        return post(ClipsUpdate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun updateBlocking(
        request: ClipsUpdateRequest
    ): Response<ClipsUpdateResponse> {
        return toBlocking {
            update(request)
        }
    }
}
