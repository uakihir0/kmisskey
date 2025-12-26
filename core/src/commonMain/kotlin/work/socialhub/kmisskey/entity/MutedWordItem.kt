package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable
import work.socialhub.kmisskey.util.json.MutedWordItemSerializer
import kotlin.js.JsExport

/**
 * ミュートワード設定の項目
 * Misskey の mutedWords/hardMutedWords は以下の2種類の形式を混在できる:
 * - 正規表現パターン: "/pattern/" 形式の文字列
 * - キーワード配列: ["word1", "word2"] 形式のAND条件
 */
@JsExport
@Serializable(with = MutedWordItemSerializer::class)
sealed class MutedWordItem {

    /**
     * 正規表現パターン
     * 例: "/(@.+@.+\\.+){5,}/"
     */
    data class RegexPattern(val pattern: String) : MutedWordItem()

    /**
     * キーワード配列（AND条件）
     * 例: ["word1", "word2"] → word1 AND word2 の両方を含む場合にミュート
     */
    data class Keywords(val words: List<String>) : MutedWordItem()
}
