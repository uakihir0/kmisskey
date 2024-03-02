package misskey4j.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import misskey4j.entity.user.MeDetailed
import misskey4j.entity.user.User
import misskey4j.entity.user.UserDetailedNotMe
import misskey4j.entity.user.UserLite

object UserSerializer :
    JsonContentPolymorphicSerializer<User>(
        User::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<User> {

        val isDeleted = element.jsonObject["isDeleted"]
        if (isDeleted != null) {
            println("HAS isDeleted")
            return MeDetailed.serializer()
        }

        val createdAt = element.jsonObject["createdAt"]
        if (createdAt != null) {
            println("HAS createdAt")
            return UserDetailedNotMe.serializer()
        }

        return UserLite.serializer()
    }
}