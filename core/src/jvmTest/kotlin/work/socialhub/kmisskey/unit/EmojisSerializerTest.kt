package work.socialhub.kmisskey.unit

import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import work.socialhub.kmisskey.entity.Emojis

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
}
