[English ☞](./docs/README.en.md)

![Scala](https://img.shields.io/badge/Scala-3.3.3-red?style=flat-square&logo=scala&logoColor=white)


# Scala Timer プロジェクト

- このプロジェクトは、Scala で実装されたシンプルかつ拡張性のあるカウントダウンタイマーです。
- JVM 上で動作するコマンドラインタイマーと、Scala.js を使用して Web ブラウザで動作するユーザーインターフェース付きの Web ベースタイマーという、主に2つのコンポーネントで構成されています。

---

## プロジェクト構造

- **プロジェクトは、sbt のマルチプロジェクトビルドとして構成されています。**

- timer-core: Java Virtual Machine (JVM) 上で動作するシンプルなコマンドラインカウントダウンタイマーです。
- timer-ui: Scala.js を使用して JavaScript にコンパイルされ、Web ブラウザで動作するユーザーインターフェース付きの Web ベースカウントダウンタイマーです。
- project/: sbt のビルド定義ファイルが含まれています。

---

## はじめに

- **Scala Timer プロジェクトをセットアップし、実行するには、以下の手順に従ってください。**

#### 前提条件

- 開始する前に、以下がインストールされていることを確認してください。
  - Java Development Kit (JDK): バージョン 17 以降を推奨（例: OpenJDK）。
  - sbt (Scala Build Tool): バージョン 1.x 以降（例: sbt インストールガイド）。
  - Python 3: Web UI をローカルで簡単に提供するために使用します（ほとんどのシステムにプリインストールされています）。
  - Git: バージョン管理用。


##  プロジェクトの使用方法

```bash
git clone https://github.com/tamai-hideyuki/scala-timer.git

cd scala-timer/apps/

# コンパイルの実行
sbt fastLinkJS
```

- sbt の起動

```bash
sbt
```

- timerCore プロジェクトへの切り替え: sbt コンソール内で、timerCore サブプロジェクトに切り替えます。

```bash
sbt:scala-timer> project timerCore
```

- タイマーの実行: run コマンドでタイマーを実行します。引数として分数を指定できます（デフォルトは1分）。
- **1分タイマーを実行する場合:**
```Scala
sbt:timer-core> run
```
- **3分タイマーを実行する場合:**
```Scala
sbt:timer-core> run 3
```
>実行すると、コンソールにカウントダウンが表示され、指定した時間が経過すると終了します。


---

## Web ベースタイマーの実行

- timer-ui プロジェクトは Scala.js で実装されており、Web ブラウザで動作します。

- **sbt の起動:**
  - sbt がまだ起動していない場合は、scala-timer プロジェクトのルートから sbt と入力して sbt コンソールを起動します。
   ```bash
   sbt
   ```
- **timerUI プロジェクトへの切り替え:**
- sbt コンソール内で、timerUI サブプロジェクトに切り替えます。
```Scala
sbt:scala-timer> project timerUI
```

- JavaScript ファイルの生成 (開発用):
- Scala.js コードを JavaScript にコンパイルし、ファイルの変更時に自動的に再コンパイルするには（開発に推奨）、~fastLinkJS コマンドを使用します。

```Scala
sbt:timer-ui> ~fastLinkJS
```
>このコマンドはバックグラウンドで実行され続け、Scala コードを保存するたびに timer-ui/target/scala-3.3.3/timer-ui-fastopt.js が継続的に生成されます。

- ローカル Web サーバーの起動:
- 生成された JavaScript ファイル（timer-ui/target/scala-3.3.3/timer-ui-fastopt.js）をブラウザで読み込むために、ローカル Web サーバーが必要です。
新しいターミナルウィンドウを開き、timer-ui ディレクトリに移動して Web サーバーを起動します。

```bash
cd timer-ui
python3 -m http.server 8000 # Python 3 がインストールされている場合
```
>（Python 3 がインストールされていない、または別のポートを使用したい場合は、別の方法で Web サーバーを起動してください。例: npm install -g http-server を実行後、http-server -p 8000 など。）

- ブラウザでアクセス:

- **Web サーバーが起動したら、Web ブラウザで以下の URL にアクセスします。**
```bash
http://localhost:8000/index.html
```

>ブラウザに「Scala Timer」の UI が表示されます。希望する分数（分）を入力し、「Start Ritual」ボタンをクリックするとカウントダウンが始まります！








 




