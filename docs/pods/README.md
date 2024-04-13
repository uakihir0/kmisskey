> [日本語](./README_ja.md)

# kmisskey cocoapods

This repository is the Cocoapods repository for [kmisskey]. [kmisskey] is a Misskey client library created using Kotlin Multiplatform.
Therefore, it can be built and used on Apple devices such as iOS. Here, we distribute it via Cocoapods as XCFrameworks.
Additionally, this repository is automatically committed by GitHub Actions of [kmisskey]. Please submit issues or pull requests to [kmisskey].

## Usage

### Podfile

Please include the following in your Podfile.
There are no versions in this repository, but there are branches corresponding to [kmisskey] versions.
Please check the branches on the [branch list](https://github.com/uakihir0/kmisskey-cocoapods/branches) to find the branch corresponding to the version you want to use.
Also, different builds are used for Debug and Release builds.

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

### Request Method

It can be used in Objective-C as well, but here's how to use it in Swift.
Please also refer to the README of [kmisskey] for detailed usage.

```swift
import kmisskey
...

let misskey = KmisskeyFactory().instance(
  uri: "https://misskey.io",
  clientSecret: "CLIENT_SECRET",
  userAccessToken: "ACCESS_TOKEN"
)

let response = misskey.accounts().i(request: CoreIRequest())
print(response.json)
```

## License

MIT License

## Author

[Akihiro Urushihara](https://github.com/uakihir0)


[kmisskey]: https://github.com/uakihir0/kmisskey