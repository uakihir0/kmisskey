package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.AnnouncementsRequest
import work.socialhub.kmisskey.api.request.ReadAnnouncementRequest
import work.socialhub.kmisskey.api.response.AnnouncementsResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for AnnouncementsResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun AnnouncementsResource.announcementsPromise(
    request: AnnouncementsRequest
): Promise<Response<Array<AnnouncementsResponse>>> = GlobalScope.promise { announcements(request) }

@OptIn(DelicateCoroutinesApi::class)
fun AnnouncementsResource.readAnnouncementPromise(
    request: ReadAnnouncementRequest
): Promise<EmptyResponse> = GlobalScope.promise { readAnnouncement(request) }

