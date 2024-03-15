# java-spock-example
![Github Actions Status](https://github.com/joseeliaschavez/java-spock-example/actions/workflows/gradle.yml/badge.svg?branch=develop&event=push)

<img  alt="Spock Logo" src="https://github.com/spockframework/spock/blob/master/docs/images/spock-main-logo.png?raw=true" width="100">
<img  alt="Spock Logo" src="https://spring.io/img/projects/spring-boot.svg" width="100">

An example project testing out features of the Spock testing framework with a SpringBoot application.

## Running the tests

Run the tests using the Gradle wrapper:
```bash
./gradlew test
```

This will execute both JUnit5 unit tests and Spock specs. The test logger has been configured to print 
all tests and their status.

```bash
$ ./gradlew test
OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended

> Task :test

LoadContextSpec > when context is loaded then all expected beans are created PASSED

HelloControllerSpec > when get is performed then the response has status 200 and content is 'Hello world!' PASSED

StarFleetShipResourceSpec > when get is performed then the response has status 200 and content is list of strings PASSED

ExampleJunitTest > when_listOfStrings_then_Passes() PASSED

ExampleJunitTest > when_listOfStrings_then_Fails() SKIPPED

BUILD SUCCESSFUL in 2s
5 actionable tasks: 2 executed, 3 up-to-date
```

## Contributing

Please make sure to use a pull request to add code. Any contributions are welcome!
The goal is to experiment implementing Spock tests against a SpringBoot RESTful application.

This [Baeldung tutorial](https://www.baeldung.com/spring-boot-testing) details different Spring Tests that can be 
implemented and their use.

The [Spock docs](https://spockframework.org/spock/docs/2.3/modules.html#_spring_module) detail use of the 
`spock-spring` library to integrate Spock with Spring Tests.

## References

1. [Spring Boot](https://github.com/spring-projects/spring-boot) 
2. [Spock Framework](https://github.com/spockframework/spock)

