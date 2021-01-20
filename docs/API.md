# API

## はじめに
このプラグインでは、APIを実装しております。  
使用方法は以下をご覧ください。

## 使用方法
1. リポジトリの追加
2. 実際のコード

## リポジトリと依存関係
以下のリポジトリと依存関係を追加したください。
<details>
    <summary>クリックで開く</summary>
    ### Maven
    ```xml
    <repositories>
        ...
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
        ...
    </repositories>
    <dependency>
        <groupId>com.github.teamkun</groupId>
        <artifactId>gtawanteddisplaystarplugin</artifactId>
        <version>Tag</version>
    </dependency>
    ```

    ### Gradle

    ```javascript
    maven {
        id 'jitpack'
        url 'https://jitpack.io' 
    }
    ...
    dependencies {
        implementation 'com.github.teamkun:gtawanteddisplaystarplugin:Tag'
    }
    ```

    ### Sbt
    ```
    resolvers += "jitpack" at "https://jitpack.io"
    ...
    libraryDependencies += "com.github.teamkun" % "gtawanteddisplaystarplugin" % "Tag"
    ```

    ### Ieiningen
    ```
    :repositories [["jitpack" "https://jitpack.io"]]
    ...
    :dependencies [[com.github.teamkun/gtawanteddisplaystarplugin "Tag"]]
    ```
</details>

## API記述例
```java
///APIプロバイダを取得します。
StarDisplayAPI api = GTAWantedDisplayStarPlugin.getApi();

//プレイヤーに星を表示します。
api.showStar(Player, Max, WantedLevel, Blinking);

//オンラインのすべてのプレイヤーに星を表示します。
api.showStarBroadcast(Player, Max, WantedLevel, Blinking);
```
