package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.notes.*
import work.socialhub.kmisskey.api.response.notes.*
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
    ): Response<Unit>

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
    ): Response<Unit>

    /**
     * ノートに対するRenote一覧を取得します。
     * @see "https://misskey.io/api-doc.tag/notes/operation/notes/renotes"
     */
    fun renotes(
        request: NotesRenotesRequest
    ): Response<Array<NotesRenotesResponse>>
}
