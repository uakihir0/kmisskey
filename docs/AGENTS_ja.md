# エージェント資料

## 概要

このレポジトリは [Misskey](https://misskey-hub.net/) の API クライアントライブラリです（Kotlin Multiplatform 対応）。Misskey は分散型 SNS プラットフォームで、ActivityPub プロトコルをサポートしています。

## 重要な概念

### Misskey API の構造

Misskey API はすべて **POST リクエスト** で、エンドポイントは `/api/{path}` 形式です。リクエストボディは JSON 形式で、認証が必要な場合は `i` パラメータにアクセストークンを含めます。

例：

- `notes/create` - ノート（投稿）の作成
- `notes/timeline` - ホームタイムラインの取得
- `users/show` - ユーザー情報の取得
- `i` - 自分のアカウント情報の取得

主要なエンドポイントカテゴリ：

- `notes/*` - ノート（投稿）関連
- `users/*` - ユーザー関連
- `i/*` - 自分のアカウント関連
- `following/*` - フォロー関連
- `drive/*` - ファイル関連
- `channels/*` - チャンネル関連
- `clips/*` - クリップ関連
- `gallery/*` - ギャラリー関連
- `messaging/*` - ダイレクトメッセージ関連（新しいバージョンでは非推奨）
- `mute/*`, `blocking/*` - ミュート/ブロック関連

### 認証方式

**MiAuth**: Misskey 独自の OAuth ライクな認証フロー

1. `MisskeyFactory.instance(host)` で未認証インスタンスを作成
2. `auth().getMiAuthUri()` で認証 URL を取得
3. ユーザーが認証後、コールバックからトークンを取得
4. `auth().sessionUserKey()` でアクセストークンを取得

**アプリケーション認証**: appSecret と userToken から SHA256 ハッシュを生成

**Web UI トークン**: Misskey の設定画面で発行したトークンをそのまま使用

### API 仕様の参照

実装時は Misskey API ドキュメントを参照してください：

- **API ドキュメント**: [misskey.io/api-doc](https://misskey.io/api-doc)
- **各インスタンスの API ドキュメント**: `https://{instance}/api-doc`

## ディレクトリ構成

- **`core/`**: REST API のコアライブラリ
  - `api/` - API リソースインターフェース
    - `model/` - 共有リクエストモデル（`TokenRequest`, `PollRequest`）
    - `request/` - カテゴリ別のリクエストオブジェクト
    - `response/` - カテゴリ別のレスポンスオブジェクト
  - `entity/` - データモデル（Note, User など）
    - `constant/` - 定数と Enum（`Visibility`, `NotificationType` など）
    - `user/` - ユーザー関連エンティティ（`User`, `UserLite`, `UserDetailedNotMe`, `MeDetailed`）
    - `share/` - 共有レスポンスモデル（`Response`, `RateLimit`, `EmptyResponse`）
    - `search/` - 検索関連エンティティ
  - `internal/` - 内部実装
    - `api/` - リソース実装クラス
    - `model/` - 内部モデル
    - `util/` - 内部ユーティリティ
  - `util/` - ユーティリティクラス
    - `json/` - カスタム JSON シリアライザー
  - `search/` - インスタンス検索機能
- **`stream/`**: WebSocket ストリーミング機能
  - `callback/` - ストリーミングイベント用コールバックインターフェース
  - `model/` - ストリーミングリクエスト/レスポンスモデル
- **`all/`**: 全モジュールを含むパッケージ（CocoaPods 用）
- **`plugins/`**: Gradle ビルド設定
- **`docs/`**: ドキュメント
- **`tool/`**: JS および CocoaPods 用セットアップスクリプト

## テスト方法

変更後は以下のテストを実行してください：

```shell
# 全テストを実行
./gradlew :core:jvmTest

# 特定のテストを実行
./gradlew :core:jvmTest --tests "work.socialhub.kmisskey.MisskeyTest"

# 特定のAPI用テストを実行
./gradlew :core:jvmTest --tests "work.socialhub.kmisskey.apis.NotesTest"
./gradlew :core:jvmTest --tests "work.socialhub.kmisskey.apis.UsersTest"
```

ネットワークアクセスができない場合は、ビルドの成功を確認：

```shell
./gradlew jvmJar
```

テストに認証情報が必要な場合は、`secrets.json` を作成（`secrets.json.default` を参照）：

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

## 実装ガイドライン

### API エンドポイントとパッケージ構造の対応

Misskey API のパスはパッケージ構造に対応します：

- `notes/create` → `api/request/notes/NotesCreateRequest.kt`
- `users/show` → `api/request/users/UsersShowRequest.kt`
- `i/favorites` → `api/request/i/IFavoritesRequest.kt`
- `clips/list` → `api/request/clips/ClipsListRequest.kt`
- `gallery/posts/create` → `api/request/gallery/CreateGalleryPostRequest.kt`

### 新しい API の追加手順

1. **`MisskeyAPI.kt`** にエンドポイントパスを追加
2. **リクエストクラス**を `api/request/{category}/` に作成
3. **レスポンスクラス**を `api/response/{category}/` に作成（必要な場合）
4. **リソースインターフェース**にメソッドを追加（`api/{Category}Resource.kt`）
5. **内部実装**を更新（`internal/api/{Category}ResourceImpl.kt`）

### API ドキュメントとの整合性確認

実装時は該当する API ドキュメントと照合してください：

**リクエストの確認項目：**

- すべてのパラメータが実装されているか
- 必須パラメータが non-nullable になっているか
- 型が正しくマッピングされているか（string, number, boolean, array など）

**レスポンスの確認項目：**

- すべてのフィールドが実装されているか
- ネストしたオブジェクトが適切にモデル化されているか
- 配列の型が正しいか

### 命名規則

| 種類         | 命名パターン           | 例                    |
| ------------ | ---------------------- | --------------------- |
| リクエスト   | `{ActionName}Request`  | `NotesCreateRequest`  |
| レスポンス   | `{ActionName}Response` | `NotesCreateResponse` |
| リソース     | `{Category}Resource`   | `NotesResource`       |
| エンティティ | 単数形                 | `Note`, `User`        |

### シリアライゼーション

すべてのクラスは `kotlinx.serialization` を使用：

```kotlin
@Serializable
class NotesCreateRequest : TokenRequest() {
    @SerialName("text")
    var text: String? = null

    @SerialName("visibility")
    var visibility: String? = null
}
```

## 重要な実装上の注意事項

### 利用可能なリソースタイプ

`Misskey` インターフェースは以下のリソースへのアクセスを提供します：

- `meta()` - インスタンスメタデータ
- `announcements()` - お知らせ
- `federation()` - 連合情報
- `ap()` - ActivityPub
- `app()` - アプリケーション管理
- `auth()` - 認証
- `accounts()` - アカウント操作（`i/*`）
- `users()` - ユーザー操作
- `lists()` - ユーザーリスト
- `channels()` - チャンネル
- `antennas()` - アンテナ
- `clips()` - クリップ
- `notes()` - ノート（投稿）
- `reactions()` - リアクション
- `favorites()` - お気に入り
- `following()` - フォロー操作
- `mutes()` - ミュート操作
- `blocks()` - ブロック操作
- `polls()` - アンケート投票
- `messages()` - ダイレクトメッセージ
- `files()` - ファイル/ドライブ操作
- `hashtags()` - ハッシュタグトレンド
- `other()` - その他の API（例：サービスワーカー）
- `webhook()` - Webhook 管理
- `gallery()` - ギャラリー投稿

### ストリーミング API の特別な要件

`stream` モジュールの API は以下の点に注意：

**接続方式：**

- WebSocket を使用（`wss://{host}/streaming?i={token}`）
- すべてのメソッドは `suspend` 関数として実装
- 複数のチャンネルを同時に購読可能

**チャンネル種別：**

- `main` - 通知
- `homeTimeline` - ホームタイムライン
- `localTimeline` - ローカルタイムライン
- `hybridTimeline` - ソーシャルタイムライン
- `globalTimeline` - グローバルタイムライン

**コールバック種別：**

- `NoteCallback` - ノートイベント
- `NotificationCallback` - 通知イベント
- `TimelineCallback` - タイムラインイベント
- `MentionCallback` - メンションイベント
- `FollowedCallback` - フォローイベント
- `RenoteCallback` - リノートイベント
- `ReplayCallback` - リプライイベント
- `OpenedCallback` - 接続開始
- `ClosedCallback` - 接続終了
- `ErrorCallback` - エラーイベント
- `EventCallback` - 汎用イベント

### JavaScript Promise 拡張関数

JavaScript から利用するために、Promise ベースの拡張関数が `core/src/jsMain/kotlin/work/socialhub/kmisskey/api/` に提供されています。

`suspend` 関数と `*Blocking` 関数は JavaScript から直接使用できないため、各 Resource インターフェースに対応する Promise 拡張関数が用意されています：

**拡張ファイルの命名規則:** `{Resource}Ext.kt`（例：`NotesResourceExt.kt`, `UsersResourceExt.kt`）

**使用例:**

```kotlin
// オリジナルの suspend 関数（@JsExport.Ignore でマーク）
suspend fun create(request: NotesCreateRequest): Response<NotesCreateResponse>

// Promise 拡張関数（JavaScript で利用可能）
fun NotesResource.createPromise(request: NotesCreateRequest): Promise<Response<NotesCreateResponse>>
```

**JavaScript からの呼び出し:**

```javascript
// Promise 拡張関数を使用
const response = await misskey.notes().createPromise(request);
```

### プラットフォーム固有の制限

- **`all` モジュール**: macOS でのみビルド可能（CocoaPods 関連）
- **JavaScript**: [kmisskey.js](https://github.com/uakihir0/kmisskey.js) を参照
- **Apple プラットフォーム**: [kmisskey-cocoapods](https://github.com/uakihir0/kmisskey-cocoapods) を参照

### 未実装の API

`MisskeyAPI.kt` でコメントアウトされているエンドポイントは未実装です。実装する場合は上記の「新しい API の追加手順」に従ってください。

## 主要なファイル参照

| 目的                       | ファイルパス                                                                   |
| -------------------------- | ------------------------------------------------------------------------------ |
| API エンドポイント定義     | `core/src/commonMain/kotlin/work/socialhub/kmisskey/MisskeyAPI.kt`             |
| メインインターフェース     | `core/src/commonMain/kotlin/work/socialhub/kmisskey/Misskey.kt`                |
| ファクトリ                 | `core/src/commonMain/kotlin/work/socialhub/kmisskey/MisskeyFactory.kt`         |
| API 使用例                 | `core/src/jvmTest/kotlin/work/socialhub/kmisskey/apis/`                        |
| ストリーミング API         | `stream/src/commonMain/kotlin/work/socialhub/kmisskey/stream/MisskeyStream.kt` |
| ストリーミングコールバック | `stream/src/commonMain/kotlin/work/socialhub/kmisskey/stream/callback/`        |
| JS Promise 拡張            | `core/src/jsMain/kotlin/work/socialhub/kmisskey/api/*Ext.kt`                   |
