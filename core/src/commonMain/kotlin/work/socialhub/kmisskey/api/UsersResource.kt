package work.socialhub.kmisskey.api

import work.socialhub.kmisskey.api.request.users.*
import work.socialhub.kmisskey.api.response.notes.UsersReactionsResponse
import work.socialhub.kmisskey.api.response.users.*
import work.socialhub.kmisskey.entity.share.Response

interface UsersResource {

    /**
     * 指定したユーザーのフォロワー一覧を取得します。
     * https://misskey.io/api-doc#operation/users/followers
     */
    fun followers(
        request: UsersFollowersRequest
    ): Response<Array<UsersFollowersResponse>>

    /**
     * 指定したユーザーのフォロー一覧を取得します。
     * https://misskey.io/api-doc#operation/users/following
     */
    fun followings(
        request: UsersFollowingsRequest
    ): Response<Array<UsersFollowingsResponse>>

    /**
     * おすすめのユーザーを取得します。
     * https://misskey.io/api-doc#operation/users/recommendation
     */
    fun recommendation(
        request: UsersRecommendationRequest
    ): Response<Array<UsersRecommendationResponse>>

    /**
     * 指定したユーザーの情報を取得します。(単数)
     * https://misskey.io/api-doc#operation/users/show
     */
    fun show(
        request: UsersShowSingleRequest
    ): Response<UsersShowResponse>

    /**
     * 指定したユーザーの情報を取得します。(複数)
     * https://misskey.io/api-doc#operation/users/show
     */
    fun show(
        request: UsersShowMultipleRequest
    ): Response<Array<UsersShowResponse>>

    /**
     * ユーザーがつけたリアクションを取得します。
     * https://misskey.io/api-doc#operation/users/reactions
     */
    fun reactions(
        request: UsersReactionsRequest
    ): Response<Array<UsersReactionsResponse>>

    /**
     * ユーザー間のリレーションを取得します。
     * https://misskey.io/api-doc#operation/users/relation
     */
    fun relation(
        request: UsersRelationRequest
    ): Response<Array<UsersRelationResponse>>

    /**
     * ユーザーを検索します。
     * https://misskey.io/api-doc#operation/users/search
     */
    fun search(
        request: UsersSearchRequest
    ): Response<Array<UsersSearchResponse>>

    /**
     * ユーザー名・ホスト名からユーザーを検索します。
     * https://misskey.io/api-doc#operation/users/search-by-username-and-host
     */
    fun searchByUsernameAndHost(
        request: UsersSearchByUsernameAndHostRequest
    ): Response<Array<UsersSearchByUsernameAndHostResponse>>
}
