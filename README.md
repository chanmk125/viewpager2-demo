# viewpager2-demo

ViewPager をメイン画面として、Android Jetpack の基本的なサンプルを実装していく。


# 使用ライブラリ（予定を含む）
## Android Jetpack
- Data Binding
- ViewPager2
- Paging2
- Epoxy
- ViewModel
- LiveData
- Coroutines
- Room

## Android Jetpack 以外のライブラリ
- OkHttp3
- Retrofit2
- Moshi

# 仕様
GitHub API を使ってユーザ検索、リポジトリ検索などをして、画面に表示する。

タブレイアウトで下記のようにFragmentを構成する。
- ユーザ検索
- リポジトリ検索
（アクセストークンなしで通信できるエンドポイント探して、他にも追加するかも）

それぞれの検索結果は無限スクロールする。
すでに取得したデータはローカルにキャッシュする。（キャッシュクリアのタイミングは考え中）

通信に失敗した場合はリトライを表示し、タップするとリトライ実施。

# 設計
- プレゼンテーション層はMVVM
  - LiveData を監視してUIを更新
- ロジックが必要になったら、UseCaseクラスに持たせる
- データ層はRespotiroyパターン

# 参考
## Paging
## Room
## リポジトリ
- [Android blueprints todo app](https://github.com/android/architecture-samples)
