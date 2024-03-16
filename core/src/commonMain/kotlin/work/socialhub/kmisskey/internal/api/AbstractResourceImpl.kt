package work.socialhub.kmisskey.internal.api

import misskey4j.internal.util.MediaType
import work.socialhub.khttpclient.HttpRequest
import work.socialhub.khttpclient.HttpResponse
import work.socialhub.kmisskey.api.model.TokenRequest
import work.socialhub.kmisskey.entity.share.EmptyResponse
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.internal.Internal
import work.socialhub.kmisskey.internal.Internal.toJson
import work.socialhub.kmpcommon.runBlocking

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
    ): EmptyResponse {
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
     * 認証リクエストの場合
     */
    protected inline fun <reified T, reified K : TokenRequest> post(
        path: String,
        request: K,
    ): Response<T> {
        return runBlocking {
            proceed<T> {
                HttpRequest()
                    .url(uri + path)
                    .json(toJson(auth(request)))
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    /**
     * API の呼び出しを行う場合
     */
    protected inline fun <reified T> post(
        path: String,
        request: Any,
    ): Response<T> {
        return runBlocking {
            proceed<T> {
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
     * 認証リクエストの場合
     */
    protected inline fun <reified K : TokenRequest> postUnit(
        path: String,
        request: K,
    ): EmptyResponse {
        return runBlocking {
            proceedUnit {
                HttpRequest()
                    .url(uri + path)
                    .json(toJson(auth(request)))
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    /**
     * API の呼び出しを行う場合
     */
    protected fun postUnit(
        path: String,
        request: Any,
    ): EmptyResponse {
        return runBlocking {
            proceedUnit {
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
    protected inline fun <reified T> post(
        path: String,
        params: Map<String, Any>,
    ): Response<T> {
        return runBlocking {
            proceed<T> {
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

    fun MutableMap<String, Any>.add(
        key: String,
        value: Any?,
    ) {
        if (value != null) {
            this[key] = value
        }
    }
}
