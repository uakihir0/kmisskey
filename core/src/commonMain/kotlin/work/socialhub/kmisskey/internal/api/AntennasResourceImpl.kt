package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI
import work.socialhub.kmisskey.api.AntennasResource
import work.socialhub.kmisskey.api.request.antennas.AntennasListRequest
import work.socialhub.kmisskey.api.request.antennas.AntennasNotesRequest
import work.socialhub.kmisskey.api.response.antennas.AntennasListResponse
import work.socialhub.kmisskey.api.response.antennas.AntennasNotesResponse
import work.socialhub.kmisskey.entity.share.Response

class AntennasResourceImpl(uri: String, i: String) : AbstractResourceImpl(uri, i), AntennasResource {

    /**
     * {@inheritDoc}
     */
    override fun list(): Response<Array<AntennasListResponse>> {
        return post(MisskeyAPI.AntennasList.path, AntennasListRequest())
    }

    /**
     * {@inheritDoc}
     */
    override fun notes(request: AntennasNotesRequest): Response<Array<AntennasNotesResponse>> {
        return post(MisskeyAPI.AntennasNotes.path, request)
    }
}
