# kmisskey cocoapods

本レポジトリは、[kmisskey] の Cocoapods レポジトリです。[kmisskey] は Kotlin Multiplatform を用いて作成された Misskey クライアントライブラリです。
そのため、iOS 等の Apple Device でも使用でもビルドして使用することができます。ここでは、XCFramework としてビルドしたものを Cocoapods 経由で配布しています。
また、このレポジトリは [kmisskey] の GitHub Actions によって自動コミットされています。issue や pull request は [kmisskey] にお願いします。

## 使用方法

### Podfile

Podfile に以下のように記載してください。
本レポジトリにはバージョンは存在せず、[kmisskey] のバージョンと一致するブランチが存在します。
どのバージョンの [kmisskey] を使用するかは、本レポジトリのブランチを指定することで決定します。
[ブランチ一覧](https://github.com/uakihir0/kmisskey-cocoapods/branches) からバージョンに対応するブランチを確認してください。
また、Debug ビルドと Release ビルドでは異なるものを使用しています。

```ruby
target '{{PROJECT_NAME}}' do
  use_frameworks!

  # Pods for kmisskey
  pod 'kmisskey-debug', 
    :configuration => ['Debug'], 
    :git => 'https://github.com/uakihir0/kmisskey-cocoapods/', 
    :branch => '{{BRANCH_NAME}}'
  pod 'kmisskey-release', 
    :configuration => ['Release'], 
    :git => 'https://github.com/uakihir0/kmisskey-cocoapods/', 
    :branch => '{{BRANCH_NAME}}'
  ...
end
```

### リクエスト方法

Objective-C でも使用可能ですが、以下に Swift での使用方法を記載します。
詳しい使い方については、[kmisskey] の README も合わせて確認してください。

```swift
import kmisskey

let misskey = KmisskeyFactory.shared.instance(
  uri: "https://misskey.io",
  appSecret: "APP_SECRET",
  userAccessToken: "ACCESS_TOKEN"
)

let response = misskey.accounts().i(request: CoreIRequest())
print(response.json)
```

## ライセンス

MIT License

## 作者

[Akihiro Urushihara](https://github.com/uakihir0)


[kmisskey]: https://github.com/uakihir0/kmisskey