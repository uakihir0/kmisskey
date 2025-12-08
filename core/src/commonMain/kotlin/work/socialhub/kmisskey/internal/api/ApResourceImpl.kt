package work.socialhub.kmisskey.internal.api

import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmisskey.MisskeyAPI.ApShow
import work.socialhub.kmisskey.api.ApResource
import work.socialhub.kmisskey.api.request.ApShowRequest
import work.socialhub.kmisskey.api.response.ApShowResponse
import work.socialhub.kmisskey.entity.Note
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.entity.user.User
import work.socialhub.kmisskey.internal.Internal.json
import work.socialhub.kmisskey.internal.Internal.toJson
import work.socialhub.kmisskey.internal.util.MediaType
import work.socialhub.kmisskey.util.toBlocking

class ApResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    ApResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun show(
        request: ApShowRequest
    ): Response<ApShowResponse> {

        // ApShowResponse は object フィールドがオブジェクトとして返されるため手動でパース
        val httpResponse = HttpRequest()
            .url(uri + ApShow.path)
            .json(toJson(auth(request)))
            .accept(MediaType.JSON)
            .post()

        val responseJson = httpResponse.stringBody
        val jsonObject = json.parseToJsonElement(responseJson).jsonObject

        val apShowResponse = ApShowResponse()
        apShowResponse.type = jsonObject["type"]?.jsonPrimitive?.content

        // object フィールドがオブジェクトの場合、type に応じて note または user に変換
        val objectElement = jsonObject["object"]
        if (objectElement != null && objectElement is JsonObject) {
            when (apShowResponse.type) {
                "Note" -> {
                    apShowResponse.note = json.decodeFromJsonElement(
                        Note.serializer(), objectElement
                    )
                }

                "User" -> {
                    apShowResponse.user = json.decodeFromJsonElement(
                        User.serializer(), objectElement
                    )
                }
            }
        }

        return Response(apShowResponse, responseJson)
    }

    /**
     * {@inheritDoc}
     */
    override fun showBlocking(
        request: ApShowRequest
    ): Response<ApShowResponse> {
        return toBlocking {
            show(request)
        }
    }
}
