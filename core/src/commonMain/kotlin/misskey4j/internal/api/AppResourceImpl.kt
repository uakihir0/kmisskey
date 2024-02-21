package misskey4j.internal.api

import misskey4j.MisskeyAPI
import misskey4j.entity.share.Response

class AppResourceImpl(uri: String) : AbstractResourceImpl(uri, null), AppResource {
    /**
     * {@inheritDoc}
     */
    override fun createApp(
        request: CreateAppRequest
    ): Response<CreateAppResponse> {
        return post(
            CreateAppResponse::class.java,
            MisskeyAPI.AppCreate.code(), request
        )
    }
}
