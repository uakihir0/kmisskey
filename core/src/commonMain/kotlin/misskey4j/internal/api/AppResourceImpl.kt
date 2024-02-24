package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.api.AppResource
import misskey4j.api.request.CreateAppRequest
import misskey4j.api.response.CreateAppResponse
import misskey4j.entity.share.Response

class AppResourceImpl(
    uri: String
) : AbstractResourceImpl(uri, ""),
    AppResource {

    /**
     * {@inheritDoc}
     */
    override fun createApp(
        request: CreateAppRequest
    ): Response<CreateAppResponse> {
        return post(
            MisskeyAPI.AppCreate.path,
            request,
        )
    }
}
