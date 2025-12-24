package work.socialhub.kmisskey.unit

import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import work.socialhub.kmisskey.entity.MutedWordItem

/**
 * MutedWordItemSerializer のユニットテスト
 */
class MutedWordItemSerializerTest {

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val listSerializer = ListSerializer(MutedWordItem.serializer())

    @Test
    fun testDeserializeRegexPattern() {
        // 正規表現パターン（文字列）
        val jsonString = """"/(@.+@.+\\\\..+){5,}/""""
        val item = json.decodeFromString<MutedWordItem>(jsonString)

        assertTrue(item is MutedWordItem.RegexPattern)
        assertEquals("/(@.+@.+\\\\..+){5,}/", (item as MutedWordItem.RegexPattern).pattern)
    }

    @Test
    fun testDeserializeKeywords() {
        // キーワード配列（AND条件）
        val jsonString = """["word1", "word2"]"""
        val item = json.decodeFromString<MutedWordItem>(jsonString)

        assertTrue(item is MutedWordItem.Keywords)
        val keywords = item as MutedWordItem.Keywords
        assertEquals(2, keywords.words.size)
        assertEquals("word1", keywords.words[0])
        assertEquals("word2", keywords.words[1])
    }

    @Test
    fun testDeserializeEmptyKeywords() {
        // 空のキーワード配列
        val jsonString = """[]"""
        val item = json.decodeFromString<MutedWordItem>(jsonString)

        assertTrue(item is MutedWordItem.Keywords)
        assertEquals(0, (item as MutedWordItem.Keywords).words.size)
    }

    @Test
    fun testDeserializeMixedList() {
        // 正規表現とキーワードの混在リスト
        val jsonString = """["/pattern/", ["keyword1", "keyword2"], "/another/"]"""
        val items = json.decodeFromString(listSerializer, jsonString)

        assertEquals(3, items.size)

        // 1番目: 正規表現
        assertTrue(items[0] is MutedWordItem.RegexPattern)
        assertEquals("/pattern/", (items[0] as MutedWordItem.RegexPattern).pattern)

        // 2番目: キーワード配列
        assertTrue(items[1] is MutedWordItem.Keywords)
        val keywords = items[1] as MutedWordItem.Keywords
        assertEquals(2, keywords.words.size)
        assertEquals("keyword1", keywords.words[0])
        assertEquals("keyword2", keywords.words[1])

        // 3番目: 正規表現
        assertTrue(items[2] is MutedWordItem.RegexPattern)
        assertEquals("/another/", (items[2] as MutedWordItem.RegexPattern).pattern)
    }

    @Test
    fun testSerializeRegexPattern() {
        val item = MutedWordItem.RegexPattern("/test/")
        val serialized = json.encodeToString(MutedWordItem.serializer(), item)

        assertEquals("\"/test/\"", serialized)
    }

    @Test
    fun testSerializeKeywords() {
        val item = MutedWordItem.Keywords(listOf("word1", "word2"))
        val serialized = json.encodeToString(MutedWordItem.serializer(), item)

        assertEquals("""["word1","word2"]""", serialized)
    }

    @Test
    fun testSerializeAndDeserializeRoundTrip() {
        val original = listOf(
            MutedWordItem.RegexPattern("/pattern/"),
            MutedWordItem.Keywords(listOf("a", "b")),
        )

        val serialized = json.encodeToString(listSerializer, original)
        val deserialized = json.decodeFromString(listSerializer, serialized)

        assertEquals(original.size, deserialized.size)

        assertTrue(deserialized[0] is MutedWordItem.RegexPattern)
        assertEquals("/pattern/", (deserialized[0] as MutedWordItem.RegexPattern).pattern)

        assertTrue(deserialized[1] is MutedWordItem.Keywords)
        assertEquals(listOf("a", "b"), (deserialized[1] as MutedWordItem.Keywords).words)
    }

    @Test
    fun testDeserializeActualApiResponseFormat() {
        // 実際のAPIレスポンスで発生するエラーパターンの再現テスト
        // hardMutedWords に正規表現パターン（文字列）が含まれるケース
        val jsonString = """["/(@.+@.+\\\\..+){5,}/", ["keyword1", "keyword2"]]"""
        val items = json.decodeFromString(listSerializer, jsonString)

        assertEquals(2, items.size)

        // 1番目: 正規表現（元のエラーの原因となった形式）
        assertTrue(items[0] is MutedWordItem.RegexPattern)
        assertEquals("/(@.+@.+\\\\..+){5,}/", (items[0] as MutedWordItem.RegexPattern).pattern)

        // 2番目: キーワード配列
        assertTrue(items[1] is MutedWordItem.Keywords)
        assertEquals(listOf("keyword1", "keyword2"), (items[1] as MutedWordItem.Keywords).words)
    }

    @Test
    fun testDeserializeSingleKeywordArray() {
        // 単一キーワードの配列
        val jsonString = """["single"]"""
        val item = json.decodeFromString<MutedWordItem>(jsonString)

        assertTrue(item is MutedWordItem.Keywords)
        assertEquals(listOf("single"), (item as MutedWordItem.Keywords).words)
    }
}
