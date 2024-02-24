package misskey4j.internal.api

import misskey4j.MisskeyAPI.*
import misskey4j.api.ListsResource
import misskey4j.api.request.lists.*
import misskey4j.api.response.lists.UsersListsListResponse
import misskey4j.api.response.lists.UsersListsShowResponse
import misskey4j.entity.NoteList
import misskey4j.entity.share.Response

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
