package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.messages.*
import work.socialhub.kmisskey.api.response.messages.MessagingHistoryResponse
import work.socialhub.kmisskey.api.response.messages.MessagingMessagesResponse
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for MessagesResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun MessagesResource.historyPromise(
    request: MessagingHistoryRequest
): Promise<Response<Array<MessagingHistoryResponse>>> = GlobalScope.promise { history(request) }

@OptIn(DelicateCoroutinesApi::class)
fun MessagesResource.messagesPromise(
    request: MessagingMessagesRequest
): Promise<Response<Array<MessagingMessagesResponse>>> = GlobalScope.promise { messages(request) }

@OptIn(DelicateCoroutinesApi::class)
fun MessagesResource.messagesCreatePromise(
    request: MessagingMessagesCreateRequest
): Promise<EmptyResponse> = GlobalScope.promise { messagesCreate(request) }

@OptIn(DelicateCoroutinesApi::class)
fun MessagesResource.messagesDeletePromise(
    request: MessagingMessagesDeleteRequest
): Promise<EmptyResponse> = GlobalScope.promise { messagesDelete(request) }

