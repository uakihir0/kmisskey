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
import work.socialhub.kmisskey.util.toBlocking

class ListsResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    ListsResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun list(
        request: UsersListsListRequest
    ): Response<Array<UsersListsListResponse>> {
        return post(Lists.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun listBlocking(
        request: UsersListsListRequest
    ): Response<Array<UsersListsListResponse>> {
        return toBlocking {
            list(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun show(
        request: UsersListsShowRequest
    ): Response<UsersListsShowResponse> {
        return post(ListsShow.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun showBlocking(
        request: UsersListsShowRequest
    ): Response<UsersListsShowResponse> {
        return toBlocking {
            show(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun push(
        request: UsersListsPushRequest
    ): EmptyResponse {
        return postUnit(ListsPush.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun pushBlocking(
        request: UsersListsPushRequest
    ): EmptyResponse {
        return toBlocking {
            push(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun pull(
        request: UsersListsPullRequest
    ): EmptyResponse {
        return postUnit(ListsPull.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun pullBlocking(
        request: UsersListsPullRequest
    ): EmptyResponse {
        return toBlocking {
            pull(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun create(
        request: UsersListsCreateRequest
    ): Response<NoteList> {
        return post(ListsCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun createBlocking(
        request: UsersListsCreateRequest
    ): Response<NoteList> {
        return toBlocking {
            create(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun update(
        request: UsersListsUpdateRequest
    ): Response<NoteList> {
        return post(ListsUpdate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun updateBlocking(
        request: UsersListsUpdateRequest
    ): Response<NoteList> {
        return toBlocking {
            update(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun delete(
        request: UsersListsDeleteRequest
    ): EmptyResponse {
        return postUnit(ListsDelete.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun deleteBlocking(
        request: UsersListsDeleteRequest
    ): EmptyResponse {
        return toBlocking {
            delete(request)
        }
    }
}
