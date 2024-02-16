package misskey4j.entity.contant

enum class Visibility(
    val code: String
) {
    PUBLIC("public"),
    HONE("home"),
    FOLLOWERS("followers"),
    SPECIFIED("specified");
}
