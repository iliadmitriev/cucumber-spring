# Test Cucumber and Spring

### Requirements

1. Open JDK 11

### Build

```shell
mvn clean package
```

### Run

Help
```shell
java -jar target/cuc-test-1.0-SNAPSHOT.jar --help
```
Run Tests with tag `@all` from feature files from path `src/main/resources/features`
```shell
java -jar target/cuc-test-1.0-SNAPSHOT.jar -t @all src/main/resources/features
```
