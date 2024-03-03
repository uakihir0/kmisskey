package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.*
import work.socialhub.kmisskey.api.MessagesResource
import work.socialhub.kmisskey.api.request.messages.MessagingHistoryRequest
import work.socialhub.kmisskey.api.request.messages.MessagingMessagesCreateRequest
import work.socialhub.kmisskey.api.request.messages.MessagingMessagesDeleteRequest
import work.socialhub.kmisskey.api.request.messages.MessagingMessagesRequest
import work.socialhub.kmisskey.api.response.messages.MessagingHistoryResponse
import work.socialhub.kmisskey.api.response.messages.MessagingMessagesResponse
import work.socialhub.kmisskey.entity.share.Response

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
