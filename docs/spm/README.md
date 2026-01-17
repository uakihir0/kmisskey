> [日本語](./README_ja.md)

# kmisskey SPM

This repository is the Swift Package repository for [kmisskey].
[kmisskey] is a Misskey client library built using Kotlin Multiplatform.
As a result, it can be built and used on Apple devices such as iOS.
Here, we distribute the library built as an XCFramework via Swift Package.
Additionally, this repository is automatically committed to via GitHub Actions from [kmisskey].
Please direct any issues or pull requests to [kmisskey].

## Usage

This repository does not have its own versioning.
Instead, branches corresponding to the versions of [kmisskey] are provided.
To use a specific version of [kmisskey], specify the corresponding branch of this repository.
Check the [list of branches](https://github.com/uakihir0/kmisskey-spm/branches) to find the branch matching your desired version.

### How to Make Requests

Although it is also usable from Objective-C, below is an example of how to use it in Swift.
For more detailed usage instructions, please refer to the [kmisskey] README.

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

## License

MIT License

## Author

[Akihiro Urushihara](https://github.com/uakihir0)

[kmisskey]: https://github.com/uakihir0/kmisskey
