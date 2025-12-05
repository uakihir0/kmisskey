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
    suspend fun history(
        request: MessagingHistoryRequest
    ): Response<Array<MessagingHistoryResponse>>

    fun historyBlocking(
        request: MessagingHistoryRequest
    ): Response<Array<MessagingHistoryResponse>>

    /**
     * トークメッセージ一覧を取得します。
     * https://misskey.io/api-doc#operation/messaging/messages
     */
    suspend fun messages(
        request: MessagingMessagesRequest
    ): Response<Array<MessagingMessagesResponse>>

    fun messagesBlocking(
        request: MessagingMessagesRequest
    ): Response<Array<MessagingMessagesResponse>>

    /**
     * トークメッセージを送信します。
     * https://misskey.io/api-doc#operation/messaging/messages/create
     */
    suspend fun messagesCreate(
        request: MessagingMessagesCreateRequest
    ): EmptyResponse

    fun messagesCreateBlocking(
        request: MessagingMessagesCreateRequest
    ): EmptyResponse

    /**
     * 指定したトークメッセージを削除します。
     * https://misskey.io/api-doc#operation/messaging/messages/delete
     */
    suspend fun messagesDelete(
        request: MessagingMessagesDeleteRequest
    ): EmptyResponse

    fun messagesDeleteBlocking(
        request: MessagingMessagesDeleteRequest
    ): EmptyResponse
}
