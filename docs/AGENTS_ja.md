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
- `messaging/*` - ダイレクトメッセージ関連

### 認証方式

**MiAuth**: Misskey 独自の OAuth ライクな認証フロー

1. `MisskeyFactory.instance(host)` で未認証インスタンスを作成
2. `auth().getMiAuthUri()` で認証 URL を取得
3. ユーザーが認証後、コールバックからトークンを取得
4. `auth().sessionUserKey()` でアクセストークンを取得

**アプリケーション認証**: clientSecret と userToken から SHA256 ハッシュを生成

**Web UI トークン**: Misskey の設定画面で発行したトークンをそのまま使用

### API 仕様の参照

実装時は Misskey API ドキュメントを参照してください：

- **API ドキュメント**: [misskey.io/api-doc](https://misskey.io/api-doc)
- **各インスタンスの API ドキュメント**: `https://{instance}/api-doc`

## ディレクトリ構成

- **`core/`**: REST API のコアライブラリ
  - `api/` - API リソースインターフェースと実装
  - `api/request/` - リクエストオブジェクト
  - `api/response/` - レスポンスオブジェクト
  - `entity/` - データモデル（Note, User など）
  - `internal/` - 内部実装
- **`stream/`**: WebSocket ストリーミング機能
- **`all/`**: 全モジュールを含むパッケージ（CocoaPods 用）
- **`plugins/`**: Gradle ビルド設定

## テスト方法

変更後は以下のテストを実行してください：

```shell
# 全テストを実行
./gradlew :core:jvmTest

# 特定のテストを実行
./gradlew :core:jvmTest --tests "work.socialhub.kmisskey.MisskeyTest"
```

ネットワークアクセスができない場合は、ビルドの成功を確認：

```shell
./gradlew jvmJar
```

テストに認証情報が必要な場合は、`secrets.json` を作成：

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

## 実装ガイドライン

### API エンドポイントとパッケージ構造の対応

Misskey API のパスはパッケージ構造に対応します：

- `notes/create` → `api/request/notes/NotesCreateRequest.kt`
- `users/show` → `api/request/users/UsersShowRequest.kt`
- `i/favorites` → `api/request/i/IFavoritesRequest.kt`

### 新しい API の追加手順

1. **`MisskeyAPI.kt`** にエンドポイントパスを追加
2. **リクエストクラス**を `api/request/{category}/` に作成
3. **レスポンスクラス**を `api/response/{category}/` に作成
4. **リソースインターフェース**にメソッドを追加（`api/{Category}Resource.kt`）
5. **内部実装**を更新（`internal/{Category}ResourceImpl.kt`）

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

### プラットフォーム固有の制限

- **`all` モジュール**: macOS でのみビルド可能（CocoaPods 関連）
- **JavaScript**: [kmisskey.js](https://github.com/uakihir0/kmisskey.js) を参照
- **Apple プラットフォーム**: [kmisskey-cocoapods](https://github.com/uakihir0/kmisskey-cocoapods) を参照

### 未実装の API

`MisskeyAPI.kt` でコメントアウトされているエンドポイントは未実装です。実装する場合は上記の「新しい API の追加手順」に従ってください。

## 主要なファイル参照

| 目的                   | ファイルパス                                                                   |
| ---------------------- | ------------------------------------------------------------------------------ |
| API エンドポイント定義 | `core/src/commonMain/kotlin/work/socialhub/kmisskey/MisskeyAPI.kt`             |
| メインインターフェース | `core/src/commonMain/kotlin/work/socialhub/kmisskey/Misskey.kt`                |
| ファクトリ             | `core/src/commonMain/kotlin/work/socialhub/kmisskey/MisskeyFactory.kt`         |
| API 使用例             | `core/src/jvmTest/kotlin/work/socialhub/kmisskey/`                             |
| ストリーミング API     | `stream/src/commonMain/kotlin/work/socialhub/kmisskey/stream/MisskeyStream.kt` |
