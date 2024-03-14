package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.api.request.ReadAnnouncementRequest
import work.socialhub.kmisskey.MisskeyAPI
import work.socialhub.kmisskey.api.AnnouncementsResource
import work.socialhub.kmisskey.api.request.AnnouncementsRequest
import work.socialhub.kmisskey.api.response.AnnouncementsResponse
import work.socialhub.kmisskey.entity.share.Response

class AnnouncementsResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    AnnouncementsResource
{

    /**
     * {@inheritDoc}
     */
    override fun announcements(request: AnnouncementsRequest): Response<Array<AnnouncementsResponse>> {
        return post(MisskeyAPI.Announcements.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun readAnnouncement(announcementId: String): Response<Unit> {
        return post(MisskeyAPI.ReadAnnouncement.path, ReadAnnouncementRequest(announcementId))
    }
}
