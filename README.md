# Conduit Selenium Tests

UI test automation project for the Conduit application.

The project was created to practice automated testing with Selenium WebDriver and Java, with a focus on writing readable and maintainable tests.

## Tech stack

* Java 25
* Selenium WebDriver 4.47.0
* JUnit 5
* Maven
* Git / GitHub

## Test scenarios

### Login

* successful login 
* login with unregistered email address
* login with invalid email address format
* login with invalid password
* login with empty email field
* login with empty password field


### Registration
- Successful registration
- Registration with empty username
- Registration with empty password
- Registration with empty email address
- Registration with invalid email address
- Registration with existing username
- Registration with existing email address

### Articles
- Opening an existing article
- Creating an article successfully
- Attempting to create an article without a title
- Attempting to create an article without a description
- Attempting to create an article without a body
- Editing an article successfully
- Deleting an article successfully
- Adding an article to favorites
- Removing an article from favorites

### Comments
- Adding a comment successfully
- Deleting a comment
- Attempting to add an empty comment

## Test cases

Detailed test cases are documented separately in [TEST_CASES.md](TEST_CASES.md).

The test cases describe the test conditions, steps and expected results. Selected test cases are implemented as automated UI tests using Selenium WebDriver.

## Test architecture

The tests use the Page Object Model to keep page interactions separate from test logic.

Explicit waits are used instead of `Thread.sleep()` to improve test stability.

Test data is stored separately from test classes in a properties file.

## Project structure

**src/test/java**

* `base` - test setup and base classes
* `data` - test data and data readers
* `pages` - Page Objects
* `tests` - automated UI tests

**src/test/resources**

* `test-data.properties` - test credentials and registration data

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

The main goal was to gain practical experience with Selenium WebDriver, JUnit, Page Object Model, explicit waits, test data management and organizing an automated test project.

## Author

Jakub Wąsik
