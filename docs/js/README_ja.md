# kmisskey.js

本レポジトリは、[kmisskey] の npm レポジトリです。[kmisskey] は Kotlin Multiplatform を用いて作成された Misskey クライアントライブラリです。
そのため、Web アプリケーション等でも使用していただくことができます。
また、このレポジトリは [kmisskey] の GitHub Actions によって自動コミットされています。issue や pull request は [kmisskey] にお願いします。

## 使用方法

### 追加方法

npm で管理している場合、以下のコマンドでアプリケーションに追加することができます。
本レポジトリにはバージョンは存在せず、[kmisskey] のバージョンと一致するブランチが存在します。
どのバージョンの [kmisskey] を使用するかは、本レポジトリのブランチを指定することで決定します。
[ブランチ一覧](https://github.com/uakihir0/kmisskey-cocoapods/branches) からバージョンに対応するブランチを確認してください。

```shell
npm add uakihir0/kmisskey.js
or
npm add uakihir0/kmisskey.js#{{BRANCH_NAME}}
```

### リクエスト方法

TypeScript の型情報も含まれており、TypeScript での記述をオススメします。
詳しい使い方については、[kmisskey] の README も合わせて確認してください。

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

## ライセンス

MIT License

## 作者

[Akihiro Urushihara](https://github.com/uakihir0)

[kmisskey]: https://github.com/uakihir0/kmisskey