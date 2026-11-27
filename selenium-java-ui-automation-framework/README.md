# Selenium Java UI Automation Framework

A portfolio-ready starter framework for browser UI automation using Java 17, Selenium 4, TestNG and Maven. It demonstrates maintainable test structure, parallel-safe browser sessions, failure diagnostics and CI execution.

## Technology stack

- Java 17
- Selenium WebDriver 4 (Selenium Manager for driver resolution)
- TestNG with method-level parallel execution
- Maven
- Page Object Model
- Allure TestNG adapter for report data and failure screenshot attachments
- Log4j2 console and file logging
- GitHub Actions with headless Chrome

## Project structure

```text
src/test/java/com/swapnil/qa/
  base/BaseTest.java
  listeners/UiTestListener.java
  pages/LoginPage.java
  tests/LoginTest.java
src/test/resources/log4j2.xml
testng.xml
pom.xml
```

## Test scenarios

1. Positive login: valid SauceDemo credentials navigate to the Products page.
2. Negative login: invalid credentials display the expected validation message.

The sample uses the public SauceDemo practice site. Do not use personal or production credentials in this repository.

## Run locally

Prerequisites: JDK 17, Maven 3.8+ and Google Chrome.

```bash
mvn clean test
```

Run in headless mode:

```bash
mvn clean test -Dheadless=true
```

Override the base URL:

```bash
mvn clean test -DbaseUrl=https://www.saucedemo.com/
```

Selenium Manager attempts to resolve the matching browser driver automatically. Environments with restricted internet access, a corporate proxy or managed browser policies may need a pre-installed driver and approved network access.

## Reports and diagnostics

- TestNG/Surefire XML and text reports: `target/surefire-reports/`
- Allure result files: `target/allure-results/`
- Log file: `target/logs/automation.log`
- Failure screenshots are attached to Allure results by the TestNG listener.

To view an Allure HTML report, install Allure Commandline and run:

```bash
allure serve target/allure-results
```

## Parallel execution

The TestNG suite runs test methods in parallel with two threads. A ThreadLocal WebDriver keeps each test method's browser session isolated. Adjust `thread-count` in `testng.xml` to tune local execution capacity.

## Continuous integration

The GitHub Actions workflow runs the suite on pushes and pull requests that change this framework. It uses Java 17 and headless Chrome, then uploads Surefire reports, Allure results and logs as a downloadable workflow artifact—even when tests fail.

## Next improvements

- Add environment-specific configuration and secrets management.
- Expand coverage for cart, checkout and product sorting workflows.
- Add API setup/teardown and test data management.
- Publish the generated Allure HTML report from CI when a stable report-hosting target is configured.
