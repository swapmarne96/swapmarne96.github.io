# Selenium Java UI Automation Framework

A starter UI automation project demonstrating browser-based testing with Java, Selenium WebDriver, TestNG and Maven.

## Stack
- Java 17
- Selenium 4
- TestNG
- Maven
- Page Object Model

## Example coverage
- Launch Chrome browser
- Open the SauceDemo login page
- Log in with the public demo account
- Verify that the inventory page is displayed

## Run locally
1. Install JDK 17 and Maven.
2. Install Google Chrome.
3. Run:

```bash
mvn clean test
```

Selenium Manager (included with Selenium 4) can resolve the compatible browser driver automatically in supported environments. Corporate network or proxy restrictions may require a preconfigured driver.

## Project structure

```text
src/test/java/
  com/swapnil/qa/base/BaseTest.java
  com/swapnil/qa/pages/LoginPage.java
  com/swapnil/qa/tests/LoginTest.java
testng.xml
pom.xml
```

This is an extensible starter framework. Add environment configuration, logging, reporting, parallel execution and CI workflows as the project evolves.
