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
- `clips/*` - Clip related
- `gallery/*` - Gallery related
- `messaging/*` - Direct message related (deprecated in newer versions)
- `mute/*`, `blocking/*` - Mute/Block related

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
  - `api/` - API resource interfaces
    - `model/` - Shared request models (`TokenRequest`, `PollRequest`)
    - `request/` - Request objects organized by category
    - `response/` - Response objects organized by category
  - `entity/` - Data models (Note, User, etc.)
    - `contant/` - Constants and enums (`Visibility`, `NotificationType`, etc.)
    - `user/` - User-related entities (`User`, `UserLite`, `UserDetailedNotMe`, `MeDetailed`)
    - `share/` - Shared response models (`Response`, `RateLimit`, `EmptyResponse`)
    - `search/` - Search-related entities
  - `internal/` - Internal implementations
    - `api/` - Resource implementation classes
    - `model/` - Internal models
    - `util/` - Internal utilities
  - `util/` - Utility classes
    - `json/` - Custom JSON serializers
  - `search/` - Instance search functionality
- **`stream/`**: WebSocket streaming functionality
  - `callback/` - Callback interfaces for streaming events
  - `model/` - Streaming request/response models
- **`all/`**: Package containing all modules (for CocoaPods)
- **`plugins/`**: Gradle build configuration
- **`docs/`**: Documentation
- **`tool/`**: Setup scripts for JS and CocoaPods

## Testing

Run the following tests after making changes:

```shell
# Run all tests
./gradlew :core:jvmTest

# Run specific test
./gradlew :core:jvmTest --tests "work.socialhub.kmisskey.MisskeyTest"

# Run tests for a specific API
./gradlew :core:jvmTest --tests "work.socialhub.kmisskey.apis.NotesTest"
./gradlew :core:jvmTest --tests "work.socialhub.kmisskey.apis.UsersTest"
```

If network access is not available, verify that the build succeeds:

```shell
./gradlew jvmJar
```

If authentication credentials are required for testing, create `secrets.json` (refer to `secrets.json.default`):

```json
{
  "params": [
    {
      "host": "https://misskey.io/api/",
      "app_secret": "YOUR_APP_SECRET",
      "user_token": "YOUR_USER_TOKEN"
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
- `clips/list` → `api/request/clips/ClipsListRequest.kt`
- `gallery/posts/create` → `api/request/gallery/CreateGalleryPostRequest.kt`

### Steps to Add a New API

1. Add the endpoint path to **`MisskeyAPI.kt`**
2. Create the **request class** in `api/request/{category}/`
3. Create the **response class** in `api/response/{category}/` (if needed)
4. Add the method to the **resource interface** (`api/{Category}Resource.kt`)
5. Update the **internal implementation** (`internal/api/{Category}ResourceImpl.kt`)

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

### Available Resource Types

The `Misskey` interface provides access to the following resources:

- `meta()` - Instance metadata
- `announcements()` - Announcements
- `federation()` - Federation information
- `ap()` - ActivityPub
- `app()` - Application management
- `auth()` - Authentication
- `accounts()` - Account operations (`i/*`)
- `users()` - User operations
- `lists()` - User lists
- `channels()` - Channels
- `antennas()` - Antennas
- `clips()` - Clips
- `notes()` - Notes (posts)
- `reactions()` - Reactions
- `favorites()` - Favorites
- `following()` - Follow operations
- `mutes()` - Mute operations
- `blocks()` - Block operations
- `polls()` - Poll voting
- `messages()` - Direct messages
- `files()` - File/Drive operations
- `hashtags()` - Hashtag trends
- `other()` - Other APIs (e.g., service worker)
- `webhook()` - Webhook management
- `gallery()` - Gallery posts

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

**Callback types:**

- `NoteCallback` - Note events
- `NotificationCallback` - Notification events
- `TimelineCallback` - Timeline events
- `MentionCallback` - Mention events
- `FollowedCallback` - Follow events
- `RenoteCallback` - Renote events
- `ReplayCallback` - Reply events
- `OpenedCallback` - Connection opened
- `ClosedCallback` - Connection closed
- `ErrorCallback` - Error events
- `EventCallback` - Generic events

### JavaScript Promise Extensions

For JavaScript usage, Promise-based extension functions are provided in `core/src/jsMain/kotlin/work/socialhub/kmisskey/api/`.

Since `suspend` functions and `*Blocking` functions cannot be directly used from JavaScript, each Resource interface has corresponding Promise extension functions:

**Extension file naming:** `{Resource}Ext.kt` (e.g., `NotesResourceExt.kt`, `UsersResourceExt.kt`)

**Usage example:**

```kotlin
// Original suspend function (marked with @JsExport.Ignore)
suspend fun create(request: NotesCreateRequest): Response<NotesCreateResponse>

// Promise extension function (available for JavaScript)
fun NotesResource.createPromise(request: NotesCreateRequest): Promise<Response<NotesCreateResponse>>
```

**From JavaScript:**

```javascript
// Use the Promise extension function
const response = await misskey.notes().createPromise(request);
```

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
| API usage examples         | `core/src/jvmTest/kotlin/work/socialhub/kmisskey/apis/`                        |
| Streaming API              | `stream/src/commonMain/kotlin/work/socialhub/kmisskey/stream/MisskeyStream.kt` |
| Streaming callbacks        | `stream/src/commonMain/kotlin/work/socialhub/kmisskey/stream/callback/`        |
| JS Promise extensions      | `core/src/jsMain/kotlin/work/socialhub/kmisskey/api/*Ext.kt`                   |
