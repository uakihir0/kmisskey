package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.messages.MessagingHistoryRequest
import work.socialhub.kmisskey.api.request.messages.MessagingMessagesCreateRequest
import work.socialhub.kmisskey.api.request.messages.MessagingMessagesDeleteRequest
import work.socialhub.kmisskey.api.request.messages.MessagingMessagesRequest
import work.socialhub.kmisskey.api.response.messages.MessagingHistoryResponse
import work.socialhub.kmisskey.api.response.messages.MessagingMessagesResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface MessagesResource {

    /**
     * トークの履歴を取得します。
     * https://misskey.io/api-doc#operation/messaging/history
     */
    @JsExport.Ignore
    suspend fun history(
        request: MessagingHistoryRequest
    ): Response<Array<MessagingHistoryResponse>>

    @JsExport.Ignore
    fun historyBlocking(
        request: MessagingHistoryRequest
    ): Response<Array<MessagingHistoryResponse>>

    /**
     * トークメッセージ一覧を取得します。
     * https://misskey.io/api-doc#operation/messaging/messages
     */
    @JsExport.Ignore
    suspend fun messages(
        request: MessagingMessagesRequest
    ): Response<Array<MessagingMessagesResponse>>

    @JsExport.Ignore
    fun messagesBlocking(
        request: MessagingMessagesRequest
    ): Response<Array<MessagingMessagesResponse>>

    /**
     * トークメッセージを送信します。
     * https://misskey.io/api-doc#operation/messaging/messages/create
     */
    @JsExport.Ignore
    suspend fun messagesCreate(
        request: MessagingMessagesCreateRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun messagesCreateBlocking(
        request: MessagingMessagesCreateRequest
    ): EmptyResponse

    /**
     * 指定したトークメッセージを削除します。
     * https://misskey.io/api-doc#operation/messaging/messages/delete
     */
    @JsExport.Ignore
    suspend fun messagesDelete(
        request: MessagingMessagesDeleteRequest
    ): EmptyResponse

    @JsExport.Ignore
    fun messagesDeleteBlocking(
        request: MessagingMessagesDeleteRequest
    ): EmptyResponse
}
