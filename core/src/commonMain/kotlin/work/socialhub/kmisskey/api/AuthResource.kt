package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.GenerateAuthSessionRequest
import work.socialhub.kmisskey.api.request.GetMiAuthUriRequest
import work.socialhub.kmisskey.api.request.UserKeyAuthSessionRequest
import work.socialhub.kmisskey.api.response.GenerateAuthSessionResponse
import work.socialhub.kmisskey.api.response.UserKeyAuthSessionResponse
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

/**
 * Auth APIs.
 */
@JsExport
interface AuthResource {

    /**
     * アプリを認証するためのトークンを作成します。
     * https://misskey.io/api-doc#operation/auth/session/generate
     */
    fun sessionGenerate(
        request: GenerateAuthSessionRequest
    ): Response<GenerateAuthSessionResponse>

    /**
     * ユーザーのアクセストークンを発行します。
     * https://misskey.io/api-doc#operation/auth/session/userkey
     */
    fun sessionUserKey(
        request: UserKeyAuthSessionRequest
    ): Response<UserKeyAuthSessionResponse>

    /**
     * MiAuth の認証ページのアドレスを生成します。
     */
    fun getMiAuthUri(
        request: GetMiAuthUriRequest
    ): Response<String>
}
