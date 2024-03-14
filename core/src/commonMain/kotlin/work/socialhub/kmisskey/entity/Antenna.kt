package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable

@Serializable
class Antenna {

    var id = ""
    var createdAt = ""
    var name = ""
    var keywords: List<List<String>> = emptyList()
    var excludeKeywords: List<List<String>> = emptyList()
    var src = "all"
    var userListId: String? = ""
    var users: List<String> = emptyList()
    var caseSensitive = false
    var notify = false
    var withReplies = false
    var withFile = false
    var isActive = false
    var hasUnreadNote = false
}
