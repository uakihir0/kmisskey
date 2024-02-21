package misskey4j.internal.api

import misskey4j.api.model.TokenRequest
import misskey4j.entity.Color
import misskey4j.entity.share.Response
import misskey4j.internal.Internal
import misskey4j.internal.Internal.toJson
import misskey4j.internal.util.MediaType
import work.socialhub.khttpclient.HttpRequest
import work.socialhub.khttpclient.HttpResponse

abstract class AbstractResourceImpl(
    val uri: String,
    val i: String
) {

    fun <T : TokenRequest> auth(req: T): T {
        req.i = i
        return req
    }

    /**
     * API を実行のハンドリングを行う関数
     * 引数で与えられた関数内で HTTP コールを実行
     */
    protected inline fun proceedUnit(
        function: () -> HttpResponse
    ): Response<Unit> {
        return Internal.proceedUnit(function)
    }

    /**
     * API を実行のハンドリングを行う関数
     * 引数で与えられた関数内で HTTP コールを実行
     */
    protected inline fun <reified T> proceed(
        function: () -> HttpResponse
    ): Response<T> {
        return Internal.proceed(function)
    }

    /**
     * API の呼び出しを行う場合
     */
    protected suspend inline fun <reified T> post(
        path: String,
        request: Any
    ): Response<T> {
        return proceed {

            // 認証リクエストの場合
            if (request is TokenRequest) {
                HttpRequest()
                    .url(uri + path)
                    .json(toJson(auth(request)))
                    .accept(MediaType.JSON)
                    .post()

            } else {
                HttpRequest()
                    .url(uri + path)
                    .json(toJson(request))
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    /**
     * API の呼び出しを行う場合
     */
    protected suspend fun postUnit(
        path: String,
        request: Any,
    ): Response<Unit> {
        return proceedUnit {

            // 認証リクエストの場合
            if (request is TokenRequest) {
                HttpRequest()
                    .url(uri + path)
                    .json(toJson(auth(request)))
                    .accept(MediaType.JSON)
                    .post()

            } else {
                HttpRequest()
                    .url(uri + path)
                    .json(toJson(request))
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    /**
     * API の呼び出しを行う場合
     * (ファイル付きの POST を行う場合)
     */
    protected suspend inline fun <reified T> post(
        path: String,
        params: Map<String, Any>,
    ): Response<T> {

        return proceed {
            val request = HttpRequest()
                .url(uri + path)
                .param("i", i)

            params.forEach { (k, v) ->
                request.param(k, v)
            }

            request
                .accept(MediaType.JSON)
                .post()
        }
    }
}
