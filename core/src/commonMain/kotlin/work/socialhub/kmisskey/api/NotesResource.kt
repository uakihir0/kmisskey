package work.socialhub.kmisskey.api

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
import kotlin.js.JsExport

@JsExport
interface NotesResource {

    /**
     * 指定したユーザーのタイムラインを取得します。
     * https://misskey.io/api-doc#operation/users/notes
     */
    fun users(
        request: UsersNotesRequest
    ): Response<Array<UsersNotesResponse>>

    /**
     * 投稿を取得します。
     * https://misskey.io/api-doc#operation/notes
     */
    fun notes(
        request: NotesRequest
    ): Response<Array<NotesResponse>>

    /**
     * 指定した投稿への返信/引用を取得します。
     * https://misskey.io/api-doc#operation/notes/children
     */
    fun children(
        request: NotesChildrenRequest
    ): Response<Array<NotesChildrenResponse>>

    /**
     * 指定した投稿への返信を取得します。
     * https://misskey.io/api-doc#operation/notes/replies
     */
    fun replies(
        request: NotesRepliesRequest
    ): Response<Array<NotesRepliesResponse>>

    /**
     * 指定した投稿の文脈を取得します。
     * https://misskey.io/api-doc#operation/notes/conversation
     */
    fun conversation(
        request: NotesConversationRequest
    ): Response<Array<NotesConversationResponse>>

    /**
     * 投稿します。
     * https://misskey.io/api-doc#operation/notes/create
     */
    fun create(
        request: NotesCreateRequest
    ): Response<NotesCreateResponse>

    /**
     * 指定した投稿を削除します。
     * https://misskey.io/api-doc#operation/notes/delete
     */
    fun delete(
        request: NotesDeleteRequest
    ): EmptyResponse

    /**
     * 自分に言及している投稿の一覧を取得します。
     * https://misskey.io/api-doc#operation/notes/mentions
     */
    fun mentions(
        request: NotesMentionsRequest
    ): Response<Array<NotesMentionsResponse>>

    /**
     * Featured な投稿を取得します。
     * https://misskey.io/api-doc#operation/notes/featured
     */
    fun featured(
        request: NotesFeaturedRequest
    ): Response<Array<NotesFeaturedResponse>>

    /**
     * グローバルタイムラインを取得します。
     * https://misskey.io/api-doc#operation/notes/global-timeline
     */
    fun globalTimeline(
        request: NotesGlobalTimelineRequest
    ): Response<Array<NotesGlobalTimelineResponse>>

    /**
     * ソーシャルタイムラインを取得します。
     * https://misskey.io/api-doc#operation/notes/hybrid-timeline
     */
    fun hybridTimeline(
        request: NotesHybridTimelineRequest
    ): Response<Array<NotesHybridTimelineResponse>>

    /**
     * ローカルタイムラインを取得します。
     * https://misskey.io/api-doc#operation/notes/local-timeline
     */
    fun localTimeline(
        request: NotesLocalTimelineRequest
    ): Response<Array<NotesLocalTimelineResponse>>

    /**
     * ノートのリアクションを取得します。
     * https://misskey.io/api-doc#tag/notes/operation/notes/reactions
     */
    fun reactions(
        request: NotesReactionsRequest
    ): Response<Array<NotesReactionsResponse>>

    /**
     * タイムラインを取得します。
     * https://misskey.io/api-doc#operation/notes/timeline
     */
    fun timeline(
        request: NotesTimelineRequest
    ): Response<Array<NotesTimelineResponse>>

    /**
     * 指定した投稿を取得します。
     * https://misskey.io/api-doc#operation/notes/show
     */
    fun show(
        request: NotesShowRequest
    ): Response<NotesShowResponse>

    /**
     * 投稿を検索します。
     * https://misskey.io/api-doc#operation/notes/search
     */
    fun search(
        request: NotesSearchRequest
    ): Response<Array<NotesSearchResponse>>

    /**
     * 指定されたハッシュタグが付けられたノートを取得します。
     * https://misskey.io/api-doc#tag/notes/operation/notes/search-by-tag
     */
    fun searchByTag(
        request: NotesSearchByTagRequest
    ): Response<Array<NotesSearchByTagResponse>>

    /**
     * 指定したユーザーリストのタイムラインを取得します。
     * https://misskey.io/api-doc#operation/notes/user-list-timeline
     */
    fun userListTimeline(
        request: NotesUserListTimelineRequest
    ): Response<Array<NotesUserListTimelineResponse>>

    /**
     * 指定した投稿のRenoteを解除します。
     * https://misskey.io/api-doc#operation/notes/unrenote
     */
    fun unrenote(
        request: NoteUnrenoteRequest
    ): EmptyResponse

    /**
     * ノートに対するRenote一覧を取得します。
     * @see "https://misskey.io/api-doc.tag/notes/operation/notes/renotes"
     */
    fun renotes(
        request: NotesRenotesRequest
    ): Response<Array<NotesRenotesResponse>>
}
