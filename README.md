# Orbit test automation framework #
Test automation framework for Orbit products.

### Requirements ###
* Java 11+
* Gradle 7.6+
* Will to run UI and API tests :)

### Information
* To see framework architecture visit: 
* Framework supports next browsers: Chrome...

### How to run tests?
Use provided gradle commands to run tests:
* To run smoke test suite you can use this gradle command:
  ```gradle clean test```
* To run single test class:
  ```gradle clean test --tests ClassName_Test.testMethodName_test -i```
* To run single test method:
  ```gradle clean test --tests ClassName_Test.testMethodName_test -i```
