package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.messages.MessagingHistoryRequest
import work.socialhub.kmisskey.api.request.messages.MessagingMessagesCreateRequest
import work.socialhub.kmisskey.api.request.messages.MessagingMessagesDeleteRequest
import work.socialhub.kmisskey.api.request.messages.MessagingMessagesRequest
import work.socialhub.kmisskey.api.response.messages.MessagingHistoryResponse
import work.socialhub.kmisskey.api.response.messages.MessagingMessagesResponse
import work.socialhub.kmisskey.entity.share.Response

interface MessagesResource {

    /**
     * トークの履歴を取得します。
     * https://misskey.io/api-doc#operation/messaging/history
     */
    fun history(
        request: MessagingHistoryRequest
    ): Response<Array<MessagingHistoryResponse>>

    /**
     * トークメッセージ一覧を取得します。
     * https://misskey.io/api-doc#operation/messaging/messages
     */
    fun messages(
        request: MessagingMessagesRequest
    ): Response<Array<MessagingMessagesResponse>>

    /**
     * トークメッセージを送信します。
     * https://misskey.io/api-doc#operation/messaging/messages/create
     */
    fun messagesCreate(
        request: MessagingMessagesCreateRequest
    ): Response<Unit>

    /**
     * 指定したトークメッセージを削除します。
     * https://misskey.io/api-doc#operation/messaging/messages/delete
     */
    fun messagesDelete(
        request: MessagingMessagesDeleteRequest
    ): Response<Unit>
}
