package work.socialhub.kmisskey.util.json

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.contentOrNull
import work.socialhub.kmisskey.entity.MutedWordItem

/**
 * MutedWordItem のカスタムシリアライザー
 * Misskey の mutedWords/hardMutedWords は以下の2種類の形式を混在できる:
 * - 正規表現パターン: "/pattern/" 形式の文字列
 * - キーワード配列: ["word1", "word2"] 形式のAND条件
 */
object MutedWordItemSerializer : KSerializer<MutedWordItem> {

    override val descriptor: SerialDescriptor =
        buildClassSerialDescriptor("MutedWordItem")

    override fun deserialize(decoder: Decoder): MutedWordItem {
        val jsonDecoder = decoder as JsonDecoder
        val element = jsonDecoder.decodeJsonElement()

        return when (element) {
            // 文字列の場合: 正規表現パターン
            is JsonPrimitive -> {
                val content = element.contentOrNull
                    ?: throw IllegalStateException("MutedWordItem: content is null: $element")
                MutedWordItem.RegexPattern(content)
            }
            // 配列の場合: キーワード配列（AND条件）
            is JsonArray -> {
                val words = element.mapNotNull { item ->
                    (item as? JsonPrimitive)?.contentOrNull
                }
                MutedWordItem.Keywords(words)
            }

            else -> {
                throw IllegalStateException("MutedWordItem: unknown format: $element")
            }
        }
    }

    override fun serialize(encoder: Encoder, value: MutedWordItem) {
        val jsonEncoder = encoder as JsonEncoder

        when (value) {
            is MutedWordItem.RegexPattern -> {
                jsonEncoder.encodeJsonElement(JsonPrimitive(value.pattern))
            }

            is MutedWordItem.Keywords -> {
                val jsonArray = buildJsonArray {
                    value.words.forEach { word ->
                        add(JsonPrimitive(word))
                    }
                }
                jsonEncoder.encodeJsonElement(jsonArray)
            }
        }
    }
}
