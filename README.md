# Conduit Selenium Tests

UI test automation project for the Conduit application.

The project was created to practice automated testing with Selenium WebDriver and Java, with a focus on writing readable and maintainable tests.

## Tech stack

* Java 25
* Selenium WebDriver 4.47.0
* JUnit 5
* Maven
* Git / GitHub

## What is tested

### Login

* successful login
* invalid email
* invalid password
* invalid credentials
* empty login fields

### Articles

* creating an article
* editing an article
* opening an article
* deleting an article
* adding an article to favorites
* removing an article from favorites

### Comments

* adding a comment
* deleting a comment
* empty comment validation

## Project structure

The tests use the Page Object Model to keep page interactions separate from test logic.

## Project structure

**src/test/java**

* `base` - test setup
* `data` - test data
* `pages`- Page Objects
* `tests`- test cases

**src/test/resources**

* `test-data.properties` - test credentials

Explicit waits are used instead of `Thread.sleep()`.

Test credentials are kept in a separate properties file rather than directly in the test classes.

## Running tests

Requirements:

* Java 25
* Maven
* Google Chrome

Run all tests:

```bash
mvn clean test
```

Run a specific test class:

```bash
mvn -Dtest=LoginTests test
```

## Why I made this project

I built this project as part of my preparation for a Junior QA / Test Automation position.

The main goal was to get practical experience with Selenium, JUnit, Page Object Model, waits, test data and organizing an automated test project.

## Author

Jakub Wąsik

GitHub: https://github.com/kubawasik7
