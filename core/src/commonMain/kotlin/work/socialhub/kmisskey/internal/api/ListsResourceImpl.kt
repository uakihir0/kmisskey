package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.Lists
import work.socialhub.kmisskey.MisskeyAPI.ListsCreate
import work.socialhub.kmisskey.MisskeyAPI.ListsDelete
import work.socialhub.kmisskey.MisskeyAPI.ListsPull
import work.socialhub.kmisskey.MisskeyAPI.ListsPush
import work.socialhub.kmisskey.MisskeyAPI.ListsShow
import work.socialhub.kmisskey.MisskeyAPI.ListsUpdate
import work.socialhub.kmisskey.api.ListsResource
import work.socialhub.kmisskey.api.request.lists.UsersListsCreateRequest
import work.socialhub.kmisskey.api.request.lists.UsersListsDeleteRequest
import work.socialhub.kmisskey.api.request.lists.UsersListsListRequest
import work.socialhub.kmisskey.api.request.lists.UsersListsPullRequest
import work.socialhub.kmisskey.api.request.lists.UsersListsPushRequest
import work.socialhub.kmisskey.api.request.lists.UsersListsShowRequest
import work.socialhub.kmisskey.api.request.lists.UsersListsUpdateRequest
import work.socialhub.kmisskey.api.response.lists.UsersListsListResponse
import work.socialhub.kmisskey.api.response.lists.UsersListsShowResponse
import work.socialhub.kmisskey.entity.NoteList
import work.socialhub.kmisskey.entity.share.EmptyResponse
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
    ): EmptyResponse {
        return postUnit(ListsPush.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun pull(
        request: UsersListsPullRequest
    ): EmptyResponse {
        return postUnit(ListsPull.path, request)
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
    ): EmptyResponse {
        return postUnit(ListsDelete.path, request)
    }
}
