package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.AppCreate
import work.socialhub.kmisskey.api.AppResource
import work.socialhub.kmisskey.api.request.CreateAppRequest
import work.socialhub.kmisskey.api.response.CreateAppResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.util.toBlocking

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
        return postAny(AppCreate.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun createAppBlocking(
        request: CreateAppRequest
    ): Response<CreateAppResponse> {
        return toBlocking {
            createApp(request)
        }
    }
}
