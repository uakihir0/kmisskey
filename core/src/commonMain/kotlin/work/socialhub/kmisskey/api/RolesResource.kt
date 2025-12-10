package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.roles.RolesRequest
import work.socialhub.kmisskey.api.request.roles.RolesShowRequest
import work.socialhub.kmisskey.api.request.roles.RolesUsersRequest
import work.socialhub.kmisskey.api.response.roles.RolesUsersResponse
import work.socialhub.kmisskey.entity.Role
import work.socialhub.kmisskey.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface RolesResource {

    /**
     * ロール一覧を取得します。
     * https://misskey.io/api-doc#operation/roles/list
     */
    @JsExport.Ignore
    suspend fun list(
        request: RolesRequest
    ): Response<Array<Role>>

    @JsExport.Ignore
    fun listBlocking(
        request: RolesRequest
    ): Response<Array<Role>>

    /**
     * ロールを取得します。
     * https://misskey.io/api-doc#operation/roles/show
     */
    @JsExport.Ignore
    suspend fun show(
        request: RolesShowRequest
    ): Response<Role>

    @JsExport.Ignore
    fun showBlocking(
        request: RolesShowRequest
    ): Response<Role>

    /**
     * ロールに割り当てられたユーザー一覧を取得します。
     * https://misskey.io/api-doc#operation/roles/users
     */
    @JsExport.Ignore
    suspend fun users(
        request: RolesUsersRequest
    ): Response<Array<RolesUsersResponse>>

    @JsExport.Ignore
    fun usersBlocking(
        request: RolesUsersRequest
    ): Response<Array<RolesUsersResponse>>
}
