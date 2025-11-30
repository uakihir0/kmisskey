package work.socialhub.kmisskey.unit

import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import work.socialhub.kmisskey.entity.Emojis
import work.socialhub.kmisskey.entity.user.User

/**
 * EmojisSerializer のユニットテスト
 */
class EmojisSerializerTest {

    private val json = Json {
        ignoreUnknownKeys = true
    }

    @Test
    fun testDeserializeArrayFormat() {
        // v11系: 配列形式
        val jsonString = """[{"name":"misskey","url":"https://example.com/emoji.png","category":"default","aliases":[]}]"""
        val emojis = json.decodeFromString<Emojis>(jsonString)

        assertEquals(1, emojis.list.size)
        assertEquals("misskey", emojis.list[0].name)
        assertEquals("https://example.com/emoji.png", emojis.list[0].url)
    }

    @Test
    fun testDeserializeEmptyArray() {
        // 空の配列
        val jsonString = """[]"""
        val emojis = json.decodeFromString<Emojis>(jsonString)

        assertEquals(0, emojis.list.size)
    }

    @Test
    fun testDeserializeObjectFormat() {
        // オブジェクト形式（listフィールドあり）
        val jsonString = """{"list":[{"name":"test","url":"https://example.com/test.png","category":"test","aliases":[]}]}"""
        val emojis = json.decodeFromString<Emojis>(jsonString)

        assertEquals(1, emojis.list.size)
        assertEquals("test", emojis.list[0].name)
    }

    @Test
    fun testDeserializeEmptyObject() {
        // 空のオブジェクト（v12系以降で使われる場合）
        val jsonString = """{}"""
        val emojis = json.decodeFromString<Emojis>(jsonString)

        assertEquals(0, emojis.list.size)
    }

    @Test
    fun testSerialize() {
        val emojis = Emojis()
        val serialized = json.encodeToString(Emojis.serializer(), emojis)

        // シリアライズ後もデシリアライズできることを確認
        val deserialized = json.decodeFromString<Emojis>(serialized)
        assertEquals(emojis.list.size, deserialized.list.size)
    }

    @Test
    fun testDeserializeV11UserWithEmojisArray() {
        // v11系サーバーからの実際のAPIレスポンス (users.show)
        val jsonString = """
        {
          "id": "9gzj6yo2l4",
          "name": "たけうちひろあき（:misskey:.dev）",
          "username": "takke",
          "host": null,
          "avatarUrl": "https://media.misskey.dev/dev/thumbnail-f723decf-e534-4283-8f1c-7e99e524f867.jpg",
          "avatarBlurhash": "yEDcR2V?00o#~UjER",
          "avatarColor": null,
          "isAdmin": false,
          "isBot": false,
          "isCat": false,
          "emojis": [
            {
              "name": "misskey",
              "url": "https://raw.githubusercontent.com/tkmrgit/misskey-emoji/c8a1b6ac5442de4b29abeb2fa021bb8a0979818a/emoji/00eb7798-a784-43e9-b4ea-62c995fef999%5B1%5D.png"
            }
          ],
          "url": null,
          "createdAt": "2023-07-09T21:49:07.970Z",
          "updatedAt": "2023-12-03T06:10:47.245Z",
          "bannerUrl": null,
          "bannerColor": null,
          "isLocked": false,
          "isModerator": false,
          "isSilenced": false,
          "isSuspended": false,
          "description": "ZonePane(ぞーぺん)の作者です。",
          "location": null,
          "birthday": null,
          "fields": [],
          "followersCount": 16,
          "followingCount": 4,
          "notesCount": 54,
          "pinnedNoteIds": [],
          "pinnedNotes": [],
          "pinnedPageId": null,
          "pinnedPage": null,
          "twoFactorEnabled": false,
          "usePasswordLessLogin": false,
          "securityKeys": false,
          "twitter": null,
          "github": null,
          "discord": null,
          "movedToUserId": null,
          "movedToUser": null
        }
        """.trimIndent()

        val user = json.decodeFromString<User>(jsonString)

        assertEquals("9gzj6yo2l4", user.id)
        assertEquals("takke", user.username)
        assertNotNull(user.emojis)
        assertEquals(1, user.emojis!!.list.size)
        assertEquals("misskey", user.emojis!!.list[0].name)
        assertEquals(
            "https://raw.githubusercontent.com/tkmrgit/misskey-emoji/c8a1b6ac5442de4b29abeb2fa021bb8a0979818a/emoji/00eb7798-a784-43e9-b4ea-62c995fef999%5B1%5D.png",
            user.emojis!!.list[0].url
        )
    }
}
