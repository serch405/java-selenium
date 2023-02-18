package tests;

import helpers.Email;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseTest {

    public static Logger logger = LogManager.getLogger(BaseTest.class);
    public static WebDriver driver;
    public static Email emailOfUserWithoutWS, emailOfUserWithEmptyWS, emailOfUserWithNotEmptyWS;

}
