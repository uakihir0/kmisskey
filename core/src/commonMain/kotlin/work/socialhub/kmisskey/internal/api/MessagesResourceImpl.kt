package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.Messages
import work.socialhub.kmisskey.MisskeyAPI.MessagesCreate
import work.socialhub.kmisskey.MisskeyAPI.MessagesDelete
import work.socialhub.kmisskey.MisskeyAPI.MessagesHistory
import work.socialhub.kmisskey.api.MessagesResource
import work.socialhub.kmisskey.api.request.messages.MessagingHistoryRequest
import work.socialhub.kmisskey.api.request.messages.MessagingMessagesCreateRequest
import work.socialhub.kmisskey.api.request.messages.MessagingMessagesDeleteRequest
import work.socialhub.kmisskey.api.request.messages.MessagingMessagesRequest
import work.socialhub.kmisskey.api.response.messages.MessagingHistoryResponse
import work.socialhub.kmisskey.api.response.messages.MessagingMessagesResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.util.toBlocking

class MessagesResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    MessagesResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun history(
        request: MessagingHistoryRequest
    ): Response<Array<MessagingHistoryResponse>> {
        return post(MessagesHistory.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun historyBlocking(
        request: MessagingHistoryRequest
    ): Response<Array<MessagingHistoryResponse>> {
        return toBlocking {
            history(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun messages(
        request: MessagingMessagesRequest
    ): Response<Array<MessagingMessagesResponse>> {
        return post(Messages.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun messagesBlocking(
        request: MessagingMessagesRequest
    ): Response<Array<MessagingMessagesResponse>> {
        return toBlocking {
            messages(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun messagesCreate(
        request: MessagingMessagesCreateRequest
    ): EmptyResponse {
        return postUnit(MessagesCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun messagesCreateBlocking(
        request: MessagingMessagesCreateRequest
    ): EmptyResponse {
        return toBlocking {
            messagesCreate(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun messagesDelete(
        request: MessagingMessagesDeleteRequest
    ): EmptyResponse {
        return postUnit(MessagesDelete.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun messagesDeleteBlocking(
        request: MessagingMessagesDeleteRequest
    ): EmptyResponse {
        return toBlocking {
            messagesDelete(request)
        }
    }
}
