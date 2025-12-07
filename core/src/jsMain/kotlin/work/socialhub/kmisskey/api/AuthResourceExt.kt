package work.socialhub.kmisskey.api

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import work.socialhub.kmisskey.api.request.GenerateAuthSessionRequest
import work.socialhub.kmisskey.api.request.GetMiAuthUriRequest
import work.socialhub.kmisskey.api.request.UserKeyAuthSessionRequest
import work.socialhub.kmisskey.api.response.GenerateAuthSessionResponse
import work.socialhub.kmisskey.api.response.UserKeyAuthSessionResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.Promise

/**
 * Promise-based extensions for AuthResource (JavaScript)
 */
@OptIn(DelicateCoroutinesApi::class)
fun AuthResource.sessionGeneratePromise(
    request: GenerateAuthSessionRequest
): Promise<Response<GenerateAuthSessionResponse>> = GlobalScope.promise { sessionGenerate(request) }

@OptIn(DelicateCoroutinesApi::class)
fun AuthResource.sessionUserKeyPromise(
    request: UserKeyAuthSessionRequest
): Promise<Response<UserKeyAuthSessionResponse>> = GlobalScope.promise { sessionUserKey(request) }

@OptIn(DelicateCoroutinesApi::class)
fun AuthResource.getMiAuthUriPromise(
    request: GetMiAuthUriRequest
): Promise<Response<String>> = GlobalScope.promise { getMiAuthUri(request) }

