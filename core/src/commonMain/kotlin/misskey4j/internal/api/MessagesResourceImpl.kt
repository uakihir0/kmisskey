package misskey4j.internal.api

import misskey4j.MisskeyAPI.*
import misskey4j.api.MessagesResource
import misskey4j.api.request.messages.MessagingHistoryRequest
import misskey4j.api.request.messages.MessagingMessagesCreateRequest
import misskey4j.api.request.messages.MessagingMessagesDeleteRequest
import misskey4j.api.request.messages.MessagingMessagesRequest
import misskey4j.api.response.messages.MessagingHistoryResponse
import misskey4j.api.response.messages.MessagingMessagesResponse
import misskey4j.entity.share.Response

class MessagesResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    MessagesResource {

    /**
     * {@inheritDoc}
     */
    override fun history(
        request: MessagingHistoryRequest
    ): Response<Array<MessagingHistoryResponse>> {
        return post(MessagesHistory.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun messages(
        request: MessagingMessagesRequest
    ): Response<Array<MessagingMessagesResponse>> {
        return post(Messages.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun messagesCreate(
        request: MessagingMessagesCreateRequest
    ): Response<Unit> {
        return post(MessagesCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun messagesDelete(
        request: MessagingMessagesDeleteRequest
    ): Response<Unit> {
        return post(MessagesDelete.path, request)
    }
}
