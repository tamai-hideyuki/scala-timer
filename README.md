[English ☞](./docs/README.en.md)

#  scala-timer
### 「Scala.js製UIタイマー＋リアルタイム残り時間表示」

- **scala-timer** は、Scalaで実装されたシンプルかつ拡張性のあるカウントダウンタイマーです。  
- コマンドライン（JVM）とWebブラウザ（Scala.js）双方に対応しており、リアルタイムで残り時間を表示するUIも備えています。


---

##  特徴

-  Scala製コマンドラインタイマー（JVMベース）
-  Scala.jsによるWebタイマーUI（リアルタイム残り時間表示付き）
-  サーバ不要、ブラウザのみで動作
-  sbtベースで簡単にビルド＆実行可能
-  最小限の依存ライブラリ構成

---


##  プロジェクト構成

| ディレクトリ | 内容                                |
|--------------|-------------------------------------|
| `timer-core/` | Scala（JVM）向けのタイマー本体      |
| `timer-ui/`   | Scala.js製のWeb UIコンポーネント     |
| `project/`    | sbtプロジェクト共通設定             |
| `README.md`   | このファイル                        |

---


##  利用方法

### 1. コマンドラインタイマー（JVM）

```bash
cd timer-core

sbt run -- 5
```

```text
→ 5分のカウントダウンがターミナル上で開始されます。
```

##  WebタイマーUI（Scala.js）


```bash
cd timer-ui

sbt fastLinkJS
```

- **以下のHTMLをブラウザで開きます：**
```html
<!-- timer-ui/index.html の例 -->
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8" />
  <title>Scala Timer</title>
  <script type="text/javascript" src="target/scala-3.x/timer-ui-fastopt.js"></script>
</head>
<body>
  <h1> Scala Timer</h1>
  <div id="app"></div>
</body>
</html>
```
- **上記HTMLとScala.jsコードが連携し、リアルタイム残り時間表示を行います。**

## ビルド手順（共通）

- **Scala.js UIビルド：**
```bash
cd timer-ui

sbt fastLinkJS
```

- **CLIタイマー：**
```bash
cd timer-core

sbt run
```

## 利用技術

- Scala 3.x
- Scala.js
- sbt（Scala Build Tool）
- HTML5 / JavaScript連携

## 今後の展望

-  タイマー終了時の通知音対応
-  プリセット時間ボタンの追加
-  スマホ対応 / PWA化
-  複数タイマーの同時管理
-  集中時間の統計取得（履歴ログ）

