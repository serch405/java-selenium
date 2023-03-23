<a name="readme-top"></a>
# About the project
This is a sample automation suite for Java `1.8`, Maven `3.8.6`, JUnit `5.9.0` and Selenium WebDriver . Tests can be executed locally or in an isolated environment (Selenoid)


## Prerequisites
1. Install JDK `1.8`
2. Install Maven `3.8.6`
3. Make sure Java and Maven are accessible from any folder
4. Install the latest Chrome and Firefox
5. Install and run Docker and Selenoid following (see https://aerokube.com/selenoid/latest/#_getting_started)


## Installation
1. Clone the repo
2. Add a system variable for Allure that generates a better report `.allure\allure-*\bin`
3. Add and fill `src\main\resources\configuration.properties` following `src\main\resources\sample_configuration.properties` as an example that contains all supported properties.</br> 
Note: `mailBox.password` is not a regular Gmail password, it's a custom password for application (see https://support.google.com/accounts/answer/185833?hl=en)


## Usage on Windows
All listed commands should be executed from the project folder.</br></br>
Execute all tests:
   ```sh
   mvn clean test
   ```
Execute all tests of class:
   ```sh
   mvn clean test -Dtest=class_name
   ```
Execute a specific test of class:
   ```sh
   mvn clean test -Dtest=class_name#test_name
   ```
By default, tests use Chrome driver, but you can execute them using Chrome headless or Firefox instead, just pass an additional argument: 
   ```sh
   mvn clean test -Dbrowser=chrome_headless
   mvn clean test -Dbrowser=fireFox
   ```
By default, tests get executed locally, but you can execute them in an isolated environment (Selenoid), just pass an additional argument:
   ```sh
   mvn clean test -Denv=selenoid
   ```
You might need to use `install` instead of `test` if update of dependencies is required before the execution:
   ```sh
   mvn clean install
   ```
Allure reports can be generated either using Surefire results `target\surefire-reports` or its own `allure-results`:
   ```sh
   allure serve allure-results
   ```

## Additional info
Screenshots are getting generated in `target\surefire-reports` folder for all fails.<br>
Allure reports will contain historical data if results are based on `allure-results` results
