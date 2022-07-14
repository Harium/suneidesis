Suneidesis (συνείδησις)
=======================

Suneidesis is a project to represent knowledge and build chatbots easily. This project started as an experiment to store stories but because querying data using code  became so complex, it was turned into a chatbot library.

[![CircleCI](https://circleci.com/gh/Harium/suneidesis.svg?style=svg)](https://circleci.com/gh/Harium/suneidesis)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.harium.suneidesis/core/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.harium.suneidesis/core/)

## Adding it to your project

### Maven
```
<dependency>
    <groupId>com.harium.suneidesis</groupId>
    <artifactId>core</artifactId>
    <version>1.6.6</version>
</dependency>
```

## Extensions

- [sunbot-discord](https://github.com/Harium/sunbot-discord/)
- [sunbot-slack](https://github.com/Harium/sunbot-slack/)
- [sunbot-slack-legacy](https://github.com/Harium/sunbot-slack-legacy/)
- [sunbot-http](https://github.com/Harium/sunbot-http/)
- [sunbot-http-client](https://github.com/Harium/sunbot-http-client)
- [sunbot-mqtt](https://github.com/Harium/sunbot-mqtt/)
- [sunbot-telegram](https://github.com/Harium/sunbot-telegram/)

## Examples

```
// A simple parrot bot (using console)
public static void main(String[] args) {
  Parser box = new EchoBox();
  
  Terminal terminal = new Terminal();
  terminal.addParser(box);
}
```

See more examples at [suneidesis-examples](https://github.com/Harium/suneidesis-examples/)
