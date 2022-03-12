# Test Cucumber and Spring

Build "fat" jar file, which:
1) runs cucumber tests from feature files
2) gathers allure results
3) generates allure report

### Requirements

1. Open JDK 11
2. Cucumber 6.9.1
3. Spring 2.1.8
4. Allure 2.13.6

### Build

```shell
mvn clean package
```

### Run tests

Cucumber help
```shell
java -jar target/cuc-test-1.0-SNAPSHOT.jar --help
```
Run tests with tag `@all` from feature files from path `src/main/resources/features`
```shell
java -jar target/cuc-test-1.0-SNAPSHOT.jar -t @all src/main/resources/features
```

### Report

Open report from path `allure-report`
```shell
allure open allure-report
```

### Docker

#### Build docker image

```shell
docker build -f Dockerfile -t cucumber-spring ./
```

#### Run docker container

Run with report mount
```shell
docker run -ti --rm \
    -v $PWD/allure-report:/app/allure-report \
    cucumber-spring
```

Run with features and report
```shell
docker run -ti --rm \
    -v $PWD/src/main/resources/features:/app/features \
    -v $PWD/allure-results:/app/allure-results \
    -v $PWD/allure-report:/app/allure-report \
    cucumber-spring
```