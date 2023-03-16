package tests;

import helpers.EmailUtils;
import helpers.Globals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.mail.MessagingException;


public class BaseTest {
    public static Logger logger = LogManager.getLogger(BaseTest.class);
    public static WebDriver driver;
    public static EmailUtils emailOfUser;

    @RegisterExtension
    TestsWatcher watcher = new TestsWatcher("target/surefire-reports");
    @BeforeAll
    public static void beforeAll() throws MessagingException {
        BaseTest.logger.debug("beforeAll");
        emailOfUser = new EmailUtils(Globals.USER, EmailUtils.EmailFolder.INBOX);
    }

}
