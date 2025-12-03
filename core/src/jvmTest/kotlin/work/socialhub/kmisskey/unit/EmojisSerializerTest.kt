package work.socialhub.kmisskey.unit

import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import work.socialhub.kmisskey.entity.Emojis
import work.socialhub.kmisskey.entity.Note
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

    @Test
    fun testDeserializeMapFormat() {
        // reactionEmojis用: マップ形式 {"name@host": "url", ...}
        val jsonString = """{"zonepane@fedibird.com":"https://s3.fedibird.com/custom_emojis/images/000/331/764/original/73113cfb7278b3b7.png"}"""
        val emojis = json.decodeFromString<Emojis>(jsonString)

        assertEquals(1, emojis.list.size)
        assertEquals("zonepane@fedibird.com", emojis.list[0].name)
        assertEquals(
            "https://s3.fedibird.com/custom_emojis/images/000/331/764/original/73113cfb7278b3b7.png",
            emojis.list[0].url
        )
    }

    @Test
    fun testDeserializeNoteWithReactionEmojis() {
        // reactionEmojis を含む Note のテスト
        val jsonString = """
        {
          "id": "aft56qpbmtv30g52",
          "createdAt": "2025-12-03T05:40:07.727Z",
          "userId": "9bt8uw4ttx",
          "user": {
            "id": "9bt8uw4ttx",
            "name": "たけうちひろあき:io:🐧",
            "username": "takke",
            "host": null,
            "avatarUrl": "https://example.com/avatar.webp",
            "isBot": false,
            "isCat": false,
            "emojis": {},
            "onlineStatus": "online"
          },
          "text": "絵文字リアクションのテスト",
          "cw": null,
          "visibility": "public",
          "localOnly": false,
          "reactionAcceptance": "nonSensitiveOnly",
          "renoteCount": 0,
          "repliesCount": 0,
          "reactionCount": 1,
          "reactions": {
            ":zonepane@fedibird.com:": 1
          },
          "reactionEmojis": {
            "zonepane@fedibird.com": "https://s3.fedibird.com/custom_emojis/images/000/331/764/original/73113cfb7278b3b7.png"
          },
          "fileIds": [],
          "files": [],
          "replyId": null,
          "renoteId": null,
          "clippedCount": 0
        }
        """.trimIndent()
        val note = json.decodeFromString<Note>(jsonString)

        assertEquals("aft56qpbmtv30g52", note.id)
        assertEquals("絵文字リアクションのテスト", note.text)

        // reactionEmojis の検証
        assertNotNull(note.reactionEmojis)
        assertEquals(1, note.reactionEmojis!!.list.size)
        assertEquals("zonepane@fedibird.com", note.reactionEmojis!!.list[0].name)
        assertEquals(
            "https://s3.fedibird.com/custom_emojis/images/000/331/764/original/73113cfb7278b3b7.png",
            note.reactionEmojis!!.list[0].url
        )

        // user.emojis（空オブジェクト形式）の検証
        assertNotNull(note.user.emojis)
        assertEquals(0, note.user.emojis!!.list.size)
    }
}
