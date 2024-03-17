package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.AnnouncementsRequest
import work.socialhub.kmisskey.api.request.ReadAnnouncementRequest
import work.socialhub.kmisskey.api.response.AnnouncementsResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

/**
 * Announcements APIs.
 */
@JsExport
interface AnnouncementsResource {

    /**
     * サーバーからのお知らせを取得します。
     *
     * https://misskey.io/api-doc#tag/meta/operation/announcements
     */
    fun announcements(
        request: AnnouncementsRequest
    ): Response<Array<AnnouncementsResponse>>

    /**
     * お知らせを既読にします。
     *
     * https://misskey.io/api-doc#tag/account/operation/i/read-announcement
     */
    fun readAnnouncement(
        request: ReadAnnouncementRequest
    ): EmptyResponse
}
