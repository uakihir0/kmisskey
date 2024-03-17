> [日本語](./docs/README_ja.md)

# kmisskey

![Maven metadata URL](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo.repsy.io%2Fmvn%2Fuakihir0%2Fpublic%2Fwork%2Fsocialhub%2Fkmisskey%2Fcore%2Fmaven-metadata.xml)

![badge][badge-js]
![badge][badge-jvm]
![badge][badge-ios]
![badge][badge-mac]

**This library is a Misskey client library that supports [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html).**
It depends on [khttpclient] and internally uses Ktor Client.
Therefore, this library is available on Kotlin Multiplatform and platforms supported by Ktor Client.
The behavior on each platform depends on [khttpclient].

## Usage

Below is how to use it in Kotlin with Gradle on supported platforms.
**If you want to use it on Apple platforms, please refer to [kmisskey-cocoapods](https://github.com/uakihir0/kmisskey-cocoapods).**
**Also, for usage in JavaScript, please refer to [kmsskey.js](https://github.com/uakihir0/kmisskey.js).**
Please refer to the test code for how to use each API.

```kotlin:build.gradle.kts
repositories {
    mavenCentral()
+   maven { url = uri("https://repo.repsy.io/mvn/uakihir0/public") }
}

dependencies {
+   implementation("work.socialhub.kmisskey:core:0.0.1-SNAPSHOT")
+   implementation("work.socialhub.kmisskey:stream:0.0.1-SNAPSHOT")
}
```

### Authentication

Using MiAuth, request the URL for users to authenticate as follows.

```kotlin
val misskey = MisskeyFactory.instance("HOST")

val response = misskey.auth().getMiAuthUri(
    GetMiAuthUriRequest().also { r ->
        r.name = "APP_NAME"
        r.callbackUrl = "APP_CALLBACK_URL"
        r.permission = Scope.ALL.map { it.target }
    }
)

println("URL:" + response.data)
```

After the user authenticates and is redirected, obtain the token from the redirected URL and get the access token as follows.

```kotlin
val response =
    misskey.auth().sessionUserKey(
        UserKeyAuthSessionRequest().also {
            it.token = "VERIFY_TOKEN"
            it.appSecret = "CLIENT_SECRET"
        }
    )

println("USER TOKEN: " + response.data.accessToken)
```

### Create Note

```kotlin
val misskey = MisskeyFactory.instance(
    "HOST", 
    "CLIENT_SECRET", 
    "ACCESS_TOKEN",
)

misskey.notes().create(
    NotesCreateRequest().also {
        it.text = "Hello World!"
        it.visibility = "home"
    })
```

## License

MIT License

## Author

[Akihiro Urushihara](https://github.com/uakihir0)

[khttpclient]: https://github.com/uakihir0/khttpclient
[badge-android]: http://img.shields.io/badge/-android-6EDB8D.svg
[badge-android-native]: http://img.shields.io/badge/support-[AndroidNative]-6EDB8D.svg
[badge-wearos]: http://img.shields.io/badge/-wearos-8ECDA0.svg
[badge-jvm]: http://img.shields.io/badge/-jvm-DB413D.svg
[badge-js]: http://img.shields.io/badge/-js-F8DB5D.svg
[badge-js-ir]: https://img.shields.io/badge/support-[IR]-AAC4E0.svg
[badge-nodejs]: https://img.shields.io/badge/-nodejs-68a063.svg
[badge-linux]: http://img.shields.io/badge/-linux-2D3F6C.svg
[badge-windows]: http://img.shields.io/badge/-windows-4D76CD.svg
[badge-wasm]: https://img.shields.io/badge/-wasm-624FE8.svg
[badge-apple-silicon]: http://img.shields.io/badge/support-[AppleSilicon]-43BBFF.svg
[badge-ios]: http://img.shields.io/badge/-ios-CDCDCD.svg
[badge-mac]: http://img.shields.io/badge/-macos-111111.svg
[badge-watchos]: http://img.shields.io/badge/-watchos-C0C0C0.svg
[badge-tvos]: http://img.shields.io/badge/-tvos-808080.svg