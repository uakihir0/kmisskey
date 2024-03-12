package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.AppCreate
import work.socialhub.kmisskey.api.AppResource
import work.socialhub.kmisskey.api.request.CreateAppRequest
import work.socialhub.kmisskey.api.response.CreateAppResponse
import work.socialhub.kmisskey.entity.share.Response

class AppResourceImpl(
    uri: String
) : AbstractResourceImpl(uri, ""),
    AppResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun createApp(
        request: CreateAppRequest
    ): Response<CreateAppResponse> {
        return post(AppCreate.path, request)
    }
}
