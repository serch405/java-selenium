package tests;

import helpers.EmailUtils;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseTest {
    public static Logger logger = LogManager.getLogger(BaseTest.class);
    public static WebDriver driver;
    public static EmailUtils emailOfUser;

    @RegisterExtension
    TestsWatcher watcher = new TestsWatcher("target/surefire-reports");

}
