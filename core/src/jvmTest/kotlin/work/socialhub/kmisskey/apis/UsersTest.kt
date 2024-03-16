package work.socialhub.kmisskey.apis

import work.socialhub.kmisskey.AbstractTest
import work.socialhub.kmisskey.api.request.i.IRequest
import work.socialhub.kmisskey.api.request.users.*
import kotlin.test.Test

class UsersTest : AbstractTest() {

    @Test
    fun testUsersFollowings() {
        val misskey = misskey()

        val i = misskey.accounts().i(IRequest())
        val followings =
            misskey.users().followings(
                UsersFollowingsRequest().also {
                    it.userId = i.data.id
                })

        for (following in followings.data) {
            println(
                following.followee!!.id
                        + " : "
                        + following.followee!!.name
            )
        }
    }

    @Test
    fun testUsersRelation() {
        val misskey = misskey()

        val relations =
            misskey.users().relation(
                UsersRelationRequest().also {
                    it.userId = arrayOf(
                        "7rkrarq81i",
                        "7rkrg1wo1a",
                    )
                })

        for (relation in relations.data) {
            println(relation.id + " : " + relation.isFollowing)
        }
    }

    @Test
    fun testUsersSearch() {
        val misskey = misskey()

        val users = misskey.users().search(
            UsersSearchRequest().also {
                it.query = "Cat"
            })

        for (user in users.data) {
            print(user)
        }
    }

    @Test
    fun testShowUsers() {
        val misskey = misskey()

        val users = misskey.users().show(
            UsersShowMultipleRequest().also {
                it.userIds = arrayOf(
                    "7rkrarq81i",
                    "7rkrg1wo1a",
                )
            })

        print(users.data[0])
    }

    @Test
    fun testShowUser() {
        val misskey = misskey()

        run {
            val users = misskey.users().show(
                UsersShowSingleRequest().also {
                    it.userId = "7rkrarq81i"
                    it.host = "misskey.io"
                })
            print(users.data)
        }

        run {
            val users = misskey.users().show(
                UsersShowSingleRequest().also {
                    it.userId = "7rkrarq81i"
                })
            print(users.data)
        }
    }
}
