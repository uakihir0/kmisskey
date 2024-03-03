package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.*
import work.socialhub.kmisskey.api.ListsResource
import work.socialhub.kmisskey.api.request.lists.*
import work.socialhub.kmisskey.api.response.lists.UsersListsListResponse
import work.socialhub.kmisskey.api.response.lists.UsersListsShowResponse
import work.socialhub.kmisskey.entity.NoteList
import work.socialhub.kmisskey.entity.share.Response

class ListsResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    ListsResource {

    /**
     * {@inheritDoc}
     */
    override fun list(
        request: UsersListsListRequest
    ): Response<Array<UsersListsListResponse>> {
        return post(Lists.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun show(
        request: UsersListsShowRequest
    ): Response<UsersListsShowResponse> {
        return post(ListsShow.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun push(
        request: UsersListsPushRequest
    ): Response<Unit> {
        return post(ListsPush.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun pull(
        request: UsersListsPullRequest
    ): Response<Unit> {
        return post(ListsPull.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun create(
        request: UsersListsCreateRequest
    ): Response<NoteList> {
        return post(ListsCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun update(
        request: UsersListsUpdateRequest
    ): Response<NoteList> {
        return post(ListsUpdate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun delete(
        request: UsersListsDeleteRequest
    ): Response<Unit> {
        return post(ListsDelete.path, request)
    }
}
