package work.socialhub.kmisskey.unit

import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import work.socialhub.kmisskey.entity.Color
import work.socialhub.kmisskey.entity.user.UserDetailedNotMe
import work.socialhub.kmisskey.util.ColorDecoder

/**
 * ColorDecoder のユニットテスト
 * bannerColor は String として受け取り、ColorDecoder で Color オブジェクトに変換する
 */
class ColorDecoderTest {

    private val json = Json {
        ignoreUnknownKeys = true
    }

    // ========================================
    // ColorDecoder 単体テスト
    // ========================================

    @Test
    fun decodeHexWithPrefix() {
        val color = ColorDecoder.decode("#86b300")

        assertEquals(0x86, color.r)
        assertEquals(0xb3, color.g)
        assertEquals(0x00, color.b)
    }

    @Test
    fun decodeHexWithoutPrefix() {
        val color = ColorDecoder.decode("86b300")

        assertEquals(0x86, color.r)
        assertEquals(0xb3, color.g)
        assertEquals(0x00, color.b)
    }

    @Test
    fun decodeShortHexWithPrefix() {
        // #RGB → #RRGGBB に展開される
        val color = ColorDecoder.decode("#fff")

        assertEquals(0xff, color.r)
        assertEquals(0xff, color.g)
        assertEquals(0xff, color.b)
    }

    @Test
    fun decodeShortHexWithPrefix2() {
        val color = ColorDecoder.decode("#abc")

        assertEquals(0xaa, color.r)
        assertEquals(0xbb, color.g)
        assertEquals(0xcc, color.b)
    }

    @Test
    fun decodeShortHexWithoutPrefix() {
        val color = ColorDecoder.decode("f80")

        assertEquals(0xff, color.r)
        assertEquals(0x88, color.g)
        assertEquals(0x00, color.b)
    }

    @Test
    fun decodeRgbFormat() {
        val color = ColorDecoder.decode("rgb(169,122,93)")

        assertEquals(169, color.r)
        assertEquals(122, color.g)
        assertEquals(93, color.b)
    }

    @Test
    fun decodeRgbFormatWithSpaces() {
        val color = ColorDecoder.decode("rgb(169, 122, 93)")

        assertEquals(169, color.r)
        assertEquals(122, color.g)
        assertEquals(93, color.b)
    }

    @Test
    fun decodeCommaSeparated() {
        val color = ColorDecoder.decode("169,122,93")

        assertEquals(169, color.r)
        assertEquals(122, color.g)
        assertEquals(93, color.b)
    }

    // ========================================
    // User の bannerColor テスト
    // ========================================

    @Test
    fun testDeserializeUserWithBannerColorRgbString() {
        // bannerColor が rgb文字列形式で返される場合のテスト
        val jsonString = """
        {
          "id": "test123",
          "name": "Test User",
          "username": "testuser",
          "host": null,
          "avatarUrl": "https://example.com/avatar.jpg",
          "isBot": false,
          "isCat": false,
          "createdAt": "2024-01-01T00:00:00.000Z",
          "bannerColor": "rgb(169,122,93)"
        }
        """.trimIndent()

        val user = json.decodeFromString<UserDetailedNotMe>(jsonString)

        assertEquals("test123", user.id)
        assertEquals("testuser", user.username)

        // bannerColor は文字列として保持される
        assertEquals("rgb(169,122,93)", user.bannerColor)

        // bannerColorObject で Color オブジェクトを取得
        assertNotNull(user.bannerColorObject)
        assertEquals(169, user.bannerColorObject!!.r)
        assertEquals(122, user.bannerColorObject!!.g)
        assertEquals(93, user.bannerColorObject!!.b)
    }

    @Test
    fun testDeserializeUserWithBannerColorHexString() {
        // bannerColor が hex形式で返される場合のテスト
        val jsonString = """
        {
          "id": "test123",
          "name": "Test User",
          "username": "testuser",
          "host": null,
          "avatarUrl": "https://example.com/avatar.jpg",
          "isBot": false,
          "isCat": false,
          "createdAt": "2024-01-01T00:00:00.000Z",
          "bannerColor": "#86b300"
        }
        """.trimIndent()

        val user = json.decodeFromString<UserDetailedNotMe>(jsonString)

        assertEquals("test123", user.id)
        assertEquals("#86b300", user.bannerColor)

        assertNotNull(user.bannerColorObject)
        assertEquals(0x86, user.bannerColorObject!!.r)
        assertEquals(0xb3, user.bannerColorObject!!.g)
        assertEquals(0x00, user.bannerColorObject!!.b)
    }

    @Test
    fun testDeserializeUserWithBannerColorNull() {
        // bannerColor が null の場合
        val jsonString = """
        {
          "id": "test123",
          "name": "Test User",
          "username": "testuser",
          "host": null,
          "avatarUrl": "https://example.com/avatar.jpg",
          "isBot": false,
          "isCat": false,
          "createdAt": "2024-01-01T00:00:00.000Z",
          "bannerColor": null
        }
        """.trimIndent()

        val user = json.decodeFromString<UserDetailedNotMe>(jsonString)

        assertEquals("test123", user.id)
        assertNull(user.bannerColor)
        // bannerBlurhash も null なので bannerColorObject も null
        assertNull(user.bannerColorObject)
    }
}
