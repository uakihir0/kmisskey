package work.socialhub.kmisskey.internal

import kotlinx.datetime.TimeZone
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import misskey4j.util.json.UserSerializer
import work.socialhub.khttpclient.HttpResponse
import work.socialhub.kmisskey.MisskeyException
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.entity.user.User
import work.socialhub.kmpcommon.AnySerializer
import work.socialhub.kmpcommon.DateFormatter

object Internal {

    @OptIn(ExperimentalSerializationApi::class)
    val json = Json {
        explicitNulls = false
        encodeDefaults = true
        ignoreUnknownKeys = true
        serializersModule = SerializersModule {
            contextual(Any::class, AnySerializer)
            contextual(User::class, UserSerializer)
        }
    }

    inline fun <reified T> toJson(obj: T): String {
        return json.encodeToString(obj).let {
            println(it)
            it
        }
    }

    inline fun <reified T> fromJson(obj: String): T {
        return json.decodeFromString(obj)
    }

    val dateFormat = DateFormatter(
        format = "yyyy-MM-ddTHH:mm:ss.SSSZ",
        timezone = TimeZone.UTC,
    )

    inline fun proceedUnit(
        function: () -> HttpResponse
    ): Response<Unit> {
        try {
            val response = function()
            if (response.status == 200) {
                return Response(Unit, "")
            }

            throw handleError(
                exception = null,
                body = response.stringBody
            )
        } catch (e: Exception) {
            throw handleError(e)
        }
    }

    inline fun <reified T> proceed(
        function: () -> HttpResponse
    ): Response<T> {
        try {
            val response = function()
            if (response.status == 200) {
                return Response(
                    response.typedBody(json),
                    response.stringBody,
                )
            }

            throw handleError(
                exception = null,
                body = response.stringBody
            )
        } catch (e: Exception) {
            throw handleError(e)
        }
    }

    fun handleError(
        exception: Exception?,
        body: String? = null,
    ): MisskeyException {
        if (exception != null) {
            return MisskeyException(exception)
        }
        println(body)
        return MisskeyException(body)
    }
}