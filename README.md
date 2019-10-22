# E2ETestNgMavenProject

It is maven Selenium UI testing using TestNG framework. It is sample End to End project to test some of the functionality of my blog https://sailpointblog.herokuapp.com.
I have 5 Test cases in total in this project and would look to increase it in the future.

# Features
1. Page Object Model (POM) is used as central repository for the homepage and login page. (Pages under test)
2. Properties file to provide the parameters required to run the test.
3. Log4j for the log.
4. Extent Report implemented for the detailed Reporting
5. Implemented Listeners to listen failed test and take screenshot in the event of failures.
6. TestNG.xml file to manage the run.
7. Can be run for any browsers in both headless and head mode.


# Get Started
Clone this project and open it on Eclipse. Make sure that Maven is installed in your system. You can run the test cases by running the testng.xml file and run as TestNG suite.
The Chrome driver is provided in this project, but you need to have firefox driver in the driver folder if you want to execute the test in firefox driver.

# Test Cases:
1. Validate Title
2. Validate Nav bar elements
3. User Login: correct username and correct password
4. User Login: incorrect username and correct password
5. User Login: correct username and incorrect password

