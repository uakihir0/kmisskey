package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.Announcements
import work.socialhub.kmisskey.MisskeyAPI.ReadAnnouncement
import work.socialhub.kmisskey.api.AnnouncementsResource
import work.socialhub.kmisskey.api.request.AnnouncementsRequest
import work.socialhub.kmisskey.api.request.ReadAnnouncementRequest
import work.socialhub.kmisskey.api.response.AnnouncementsResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.util.toBlocking

class AnnouncementsResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    AnnouncementsResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun announcements(
        request: AnnouncementsRequest
    ): Response<Array<AnnouncementsResponse>> {
        return post(Announcements.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun announcementsBlocking(
        request: AnnouncementsRequest
    ): Response<Array<AnnouncementsResponse>> {
        return toBlocking {
            announcements(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun readAnnouncement(
        request: ReadAnnouncementRequest
    ): EmptyResponse {
        return postUnit(ReadAnnouncement.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun readAnnouncementBlocking(
        request: ReadAnnouncementRequest
    ): EmptyResponse {
        return toBlocking {
            readAnnouncement(request)
        }
    }
}
