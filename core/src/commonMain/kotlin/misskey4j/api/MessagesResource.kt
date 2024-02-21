package misskey4j.api

import misskey4j.api.request.messages.MessagingHistoryRequest
import misskey4j.api.request.messages.MessagingMessagesCreateRequest
import misskey4j.api.request.messages.MessagingMessagesDeleteRequest
import misskey4j.api.request.messages.MessagingMessagesRequest
import misskey4j.api.response.messages.MessagingHistoryResponse
import misskey4j.api.response.messages.MessagingMessagesResponse
import misskey4j.entity.share.Response

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
