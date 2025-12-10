package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.RolesList
import work.socialhub.kmisskey.MisskeyAPI.RolesShow
import work.socialhub.kmisskey.MisskeyAPI.RolesUsers
import work.socialhub.kmisskey.api.RolesResource
import work.socialhub.kmisskey.api.request.roles.RolesRequest
import work.socialhub.kmisskey.api.request.roles.RolesShowRequest
import work.socialhub.kmisskey.api.request.roles.RolesUsersRequest
import work.socialhub.kmisskey.api.response.roles.RolesUsersResponse
import work.socialhub.kmisskey.entity.Role
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.util.toBlocking

class RolesResourceImpl(
    uri: String,
    i: String,
) : AbstractResourceImpl(uri, i),
    RolesResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun list(
        request: RolesRequest
    ): Response<Array<Role>> {
        return post(RolesList.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun listBlocking(
        request: RolesRequest
    ): Response<Array<Role>> {
        return toBlocking {
            list(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun show(
        request: RolesShowRequest
    ): Response<Role> {
        return post(RolesShow.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun showBlocking(
        request: RolesShowRequest
    ): Response<Role> {
        return toBlocking {
            show(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun users(
        request: RolesUsersRequest
    ): Response<Array<RolesUsersResponse>> {
        return post(RolesUsers.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun usersBlocking(
        request: RolesUsersRequest
    ): Response<Array<RolesUsersResponse>> {
        return toBlocking {
            users(request)
        }
    }
}
