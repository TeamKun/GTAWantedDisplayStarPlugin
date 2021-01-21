# API

## はじめに
このプラグインでは、APIを実装しております。  
使用方法は以下をご覧ください。

## 使用方法
1. リポジトリの追加
2. 実際のコード

## JavaDocがほしいひと
[ここ](https://teamkun.github.io/GTAWantedDisplayStarPlugin/)にありますのでご自由に御覧ください。

## リポジトリと依存関係
以下のリポジトリと依存関係を追加したください。
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
<dependencies>
    ...
    <dependency>
        <groupId>com.github.teamkun</groupId>
        <artifactId>gtawanteddisplaystarplugin</artifactId>
        <version>Tag</version>
    </dependency>
    ...
</dependencies>
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

ibraryDependencies += "com.github.teamkun" % "gtawanteddisplaystarplugin" % "Tag"
```

### Ieiningen
```
:repositories [["jitpack" "https://jitpack.io"]]

...

:dependencies [[com.github.teamkun/gtawanteddisplaystarplugin "Tag"]]
```

## API記述例
```java
///APIプロバイダを取得します。
StarDisplayAPI api = GTAWantedDisplayStarPlugin.getApi();

//プレイヤーに星を表示します。
api.showStar(Player, Max, WantedLevel, Flag);

//オンラインのすべてのプレイヤーに星を表示します。
api.showStarBroadcast(Player, Max, WantedLevel, Flag...);
```

## 使用可能フラグ
+ BLINK => 星が点滅します。
+ NONE => 追加オプションを利用しません。
