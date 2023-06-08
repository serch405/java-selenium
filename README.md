<a name="readme-top"></a>
# About the project
This is an automation framework for Java `1.8`, Maven `3.8.6`, JUnit `5.9.0` and Selenium WebDriver. It tests Flask app that should be launched separately. Tests can be executed locally or in an isolated environment (Selenoid)


## Prerequisites
1. Install JDK `1.8`
2. Install Maven `3.8.6`
3. Make sure Java and Maven are accessible from any folder
4. Install the latest Chrome and Firefox
5. Install and run Docker and Selenoid following https://aerokube.com/selenoid/latest/#_getting_started
6. Launch Flask app following https://github.com/serch405/flask-app/blob/main/README.md


## Installation
1. Clone the repo
2. Add a system variable for Allure `.allure\allure-*\bin`
3. Add `src\main\resources\configuration.properties`, it should contain the same list of properties as in `src\main\resources\sample_configuration.properties`
4. Fill `src\main\resources\configuration.properties`, where `mailBox.password` is a custom password for application, see https://support.google.com/accounts/answer/185833?hl=en


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
Allure reports can be generated using either Surefire results `target\surefire-reports` or its own `allure-results`:
   ```sh
   allure serve allure-results
   ```

## Additional info
Screenshots are getting generated in `target\surefire-reports` folder for all fails.<br>
Allure reports contain historical data only in case `allure-results` results has been used