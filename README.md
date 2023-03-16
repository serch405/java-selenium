<a name="readme-top"></a>
# About the project
This is a sample automation suite for Java `1.8`, Maven `3.8.6`, JUnit `5.9.0` and Selenium WebDriver 


## Prerequisites
1. Install JDK `1.8`
2. Install Maven `3.8.6`
3. Make sure Java and Maven are accessible from any folder
4. Install the latest Chrome


## Installation
1. Clone the repo
2. Add a system variable for Allure that generates a better report `.allure\allure-*\bin`
3. Fill `src\main\resources\prod.properties` if you are going to run tests on a production environment, and `src\main\resources\test.properties` for a test environment. 
`src\main\resources\sample.properties` is just an example with the list of all supported properties. 
`mailBox.password` property is not a regular Gmail password, it's a custom password for application (see https://support.google.com/accounts/answer/185833?hl=en)


## Usage on Windows
All listed commands should be executed from the project folder. Run all tests:
   ```sh
   mvn clean test
   ```
Run all tests of class:
   ```sh
   mvn clean test -Dtest=class_name
   ```
Run a specific test of class:
   ```sh
   mvn clean test -Dtest=class_name#test_name
   ```
By default tests use Chrome driver, but you can run them using Chrome headless inside, just pass an additional argument: 
   ```sh
   mvn clean test -Dbrowser=chromeHeadless
   ```
By default tests use Production environment, but you can run them on Test environment instead, just pass an additional argument:
   ```sh
   mvn clean test -Denvironment=test
   ```
You might need to use `install` instead of `test` if update of dependencies is required before test execution:
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
