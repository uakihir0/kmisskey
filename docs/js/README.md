> [日本語](./README_ja.md)

# kmisskey.js

This repository is the npm repository for [kmisskey]. [kmisskey] is a Misskey client library created using Kotlin Multiplatform.
Therefore, it can be used in web applications and similar contexts.
Additionally, this repository is automatically committed by GitHub Actions of [kmisskey]. Please submit issues or pull requests to [kmisskey].

## Usage

### Installation

If you're managing with npm, you can add it to your application using the following command.
There are no versions in this repository, but there are branches corresponding to [kmisskey] versions.
Please check the branches on the [branch list](https://github.com/uakihir0/kmisskey-cocoapods/branches) to find the branch corresponding to the version you want to use.

```shell
npm add uakihir0/kmisskey.js
or
npm add uakihir0/kmisskey.js#{{BRANCH_NAME}}
```

### Request Method

TypeScript type information is included, so it's recommended to write in TypeScript.
Please also refer to the README of [kmisskey] for detailed usage.

```typescript
import kmisskey from "kmisskey-js";
import KmisskeyFactory = kmisskey.work.socialhub.kmisskey.KmisskeyFactory;
import IRequest = kmisskey.work.socialhub.kmisskey.api.request.i.IRequest;

...
    const factory = new KmisskeyFactory();
    const misskey = factory.instanceUserAccessToken(
      "https://misskey.io",
      "CLIENT_SECRET",
      "ACCESS_TOKEN",
    );
    misskey
      .accounts()
      .me(new IRequest())
      .then((res) => {
        console.log(res);
      });
```

## License

MIT License

## Author

[Akihiro Urushihara](https://github.com/uakihir0)

[kmisskey]: https://github.com/uakihir0/kmisskey