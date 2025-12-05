# Agent Documentation

## Overview

This repository is an API client library for [Misskey](https://misskey-hub.net/) (Kotlin Multiplatform compatible). Misskey is a decentralized social networking platform that supports the ActivityPub protocol.

## Key Concepts

### Misskey API Structure

All Misskey API requests are **POST requests**, with endpoints in the format `/api/{path}`. The request body is in JSON format, and when authentication is required, the access token is included in the `i` parameter.

Examples:

- `notes/create` - Create a note (post)
- `notes/timeline` - Get home timeline
- `users/show` - Get user information
- `i` - Get your own account information

Main endpoint categories:

- `notes/*` - Note (post) related
- `users/*` - User related
- `i/*` - Own account related
- `following/*` - Follow related
- `drive/*` - File related
- `channels/*` - Channel related
- `messaging/*` - Direct message related

### Authentication Methods

**MiAuth**: Misskey's own OAuth-like authentication flow

1. Create an unauthenticated instance with `MisskeyFactory.instance(host)`
2. Get the authentication URL with `auth().getMiAuthUri()`
3. After user authentication, get the token from the callback
4. Get the access token with `auth().sessionUserKey()`

**Application Authentication**: Generate a SHA256 hash from clientSecret and userToken

**Web UI Token**: Use the token issued from Misskey's settings page directly

### API Specification Reference

Refer to the Misskey API documentation when implementing:

- **API Documentation**: [misskey.io/api-doc](https://misskey.io/api-doc)
- **API Documentation for each instance**: `https://{instance}/api-doc`

## Directory Structure

- **`core/`**: Core library for REST API
  - `api/` - API resource interfaces and implementations
  - `api/request/` - Request objects
  - `api/response/` - Response objects
  - `entity/` - Data models (Note, User, etc.)
  - `internal/` - Internal implementations
- **`stream/`**: WebSocket streaming functionality
- **`all/`**: Package containing all modules (for CocoaPods)
- **`plugins/`**: Gradle build configuration

## Testing

Run the following tests after making changes:

```shell
# Run all tests
./gradlew :core:jvmTest

# Run specific test
./gradlew :core:jvmTest --tests "work.socialhub.kmisskey.MisskeyTest"
```

If network access is not available, verify that the build succeeds:

```shell
./gradlew jvmJar
```

If authentication credentials are required for testing, create `secrets.json`:

```json
{
  "params": [
    {
      "host": "https://misskey.io/api/",
      "client_secret": "YOUR_CLIENT_SECRET",
      "user_token": "YOUR_USER_TOKEN",
      "owned_user_token": "YOUR_OWNED_ACCESS_TOKEN"
    }
  ]
}
```

## Implementation Guidelines

### Correspondence Between API Endpoints and Package Structure

Misskey API paths correspond to the package structure:

- `notes/create` → `api/request/notes/NotesCreateRequest.kt`
- `users/show` → `api/request/users/UsersShowRequest.kt`
- `i/favorites` → `api/request/i/IFavoritesRequest.kt`

### Steps to Add a New API

1. Add the endpoint path to **`MisskeyAPI.kt`**
2. Create the **request class** in `api/request/{category}/`
3. Create the **response class** in `api/response/{category}/`
4. Add the method to the **resource interface** (`api/{Category}Resource.kt`)
5. Update the **internal implementation** (`internal/{Category}ResourceImpl.kt`)

### Verify Consistency with API Documentation

When implementing, verify against the corresponding API documentation:

**Request verification items:**

- Are all parameters implemented?
- Are required parameters non-nullable?
- Are types correctly mapped? (string, number, boolean, array, etc.)

**Response verification items:**

- Are all fields implemented?
- Are nested objects properly modeled?
- Are array types correct?

### Naming Conventions

| Type      | Naming Pattern         | Example               |
| --------- | ---------------------- | --------------------- |
| Request   | `{ActionName}Request`  | `NotesCreateRequest`  |
| Response  | `{ActionName}Response` | `NotesCreateResponse` |
| Resource  | `{Category}Resource`   | `NotesResource`       |
| Entity    | Singular form          | `Note`, `User`        |

### Serialization

All classes use `kotlinx.serialization`:

```kotlin
@Serializable
class NotesCreateRequest : TokenRequest() {
    @SerialName("text")
    var text: String? = null

    @SerialName("visibility")
    var visibility: String? = null
}
```

## Important Implementation Notes

### Special Requirements for Streaming API

Note the following for APIs in the `stream` module:

**Connection method:**

- Uses WebSocket (`wss://{host}/streaming?i={token}`)
- All methods are implemented as `suspend` functions
- Multiple channels can be subscribed to simultaneously

**Channel types:**

- `main` - Notifications
- `homeTimeline` - Home timeline
- `localTimeline` - Local timeline
- `hybridTimeline` - Social timeline
- `globalTimeline` - Global timeline

### Platform-Specific Limitations

- **`all` module**: Can only be built on macOS (CocoaPods related)
- **JavaScript**: Refer to [kmisskey.js](https://github.com/uakihir0/kmisskey.js)
- **Apple platforms**: Refer to [kmisskey-cocoapods](https://github.com/uakihir0/kmisskey-cocoapods)

### Unimplemented APIs

Endpoints that are commented out in `MisskeyAPI.kt` are unimplemented. When implementing them, follow the "Steps to Add a New API" above.

## Key File References

| Purpose                    | File Path                                                                      |
| -------------------------- | ------------------------------------------------------------------------------ |
| API endpoint definitions   | `core/src/commonMain/kotlin/work/socialhub/kmisskey/MisskeyAPI.kt`             |
| Main interface             | `core/src/commonMain/kotlin/work/socialhub/kmisskey/Misskey.kt`                |
| Factory                    | `core/src/commonMain/kotlin/work/socialhub/kmisskey/MisskeyFactory.kt`         |
| API usage examples         | `core/src/jvmTest/kotlin/work/socialhub/kmisskey/`                             |
| Streaming API              | `stream/src/commonMain/kotlin/work/socialhub/kmisskey/stream/MisskeyStream.kt` |

