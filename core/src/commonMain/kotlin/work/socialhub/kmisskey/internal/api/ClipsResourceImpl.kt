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

class ClipsResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    ClipsResource {

    /**
     * {@inheritDoc}
     */
    override fun list(
        request: ClipsListRequest
    ): Response<Array<ClipsListResponse>> {
        return post(ClipsList.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun notes(
        request: ClipsNotesRequest
    ): Response<Array<ClipsNotesResponse>> {
        return post(ClipsNotes.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun removeNote(
        request: ClipsRemoveNoteRequest
    ): EmptyResponse {
        return postUnit(ClipsRemoveNote.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun addNote(
        request: ClipsAddNoteRequest
    ): EmptyResponse {
        return postUnit(ClipsAddNote.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun deleteClip(
        request: ClipsDeleteRequest
    ): EmptyResponse {
        return postUnit(ClipsDelete.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun create(
        request: ClipsCreateRequest
    ): Response<ClipsCreateResponse> {
        return post(ClipsCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun show(
        request: ClipsShowRequest
    ): Response<ClipsShowResponse> {
        return post(ClipsShow.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun update(
        request: ClipsUpdateRequest
    ): Response<ClipsUpdateResponse> {
        return post(ClipsUpdate.path, request)
    }
}
