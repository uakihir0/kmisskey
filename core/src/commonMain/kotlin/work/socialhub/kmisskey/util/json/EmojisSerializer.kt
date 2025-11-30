package work.socialhub.kmisskey.util.json

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ArraySerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonArray
import work.socialhub.kmisskey.entity.Emoji
import work.socialhub.kmisskey.entity.Emojis

/**
 * Emojis のカスタムシリアライザー
 * v11系: 配列形式 [{"name":"misskey","url":"..."}]
 * v12系以降: オブジェクト形式（空のオブジェクト {} など）
 */
@OptIn(ExperimentalSerializationApi::class)
object EmojisSerializer : KSerializer<Emojis> {

    private val emojiArraySerializer = ArraySerializer(Emoji.serializer())

    override val descriptor: SerialDescriptor =
        buildClassSerialDescriptor("Emojis")

    override fun deserialize(decoder: Decoder): Emojis {
        val jsonDecoder = decoder as JsonDecoder
        val element = jsonDecoder.decodeJsonElement()

        val emojis = Emojis()

        when (element) {
            // v11系: 配列形式
            is JsonArray -> {
                emojis.list = jsonDecoder.json.decodeFromJsonElement(
                    emojiArraySerializer,
                    element
                )
            }
            // v12系以降: オブジェクト形式（空のオブジェクトまたはlistを含む）
            is JsonObject -> {
                val listElement = element["list"]
                if (listElement != null && listElement is JsonArray) {
                    emojis.list = jsonDecoder.json.decodeFromJsonElement(
                        emojiArraySerializer,
                        listElement.jsonArray
                    )
                }
                // listがない場合は空の配列のまま
            }
            else -> {
                // その他の場合は空の配列のまま
            }
        }

        return emojis
    }

    override fun serialize(encoder: Encoder, value: Emojis) {
        // シリアライズ時はオブジェクト形式で出力
        val jsonEncoder = encoder as JsonEncoder
        val jsonObject = kotlinx.serialization.json.buildJsonObject {
            put("list", jsonEncoder.json.encodeToJsonElement(
                emojiArraySerializer,
                value.list
            ))
        }
        jsonEncoder.encodeJsonElement(jsonObject)
    }
}
