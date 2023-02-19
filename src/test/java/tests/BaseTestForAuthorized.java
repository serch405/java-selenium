package tests;

import helpers.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.RegisterExtension;
import pages.landing.LandingPage;
import pages.my.DashboardPage;
import pages.my.LoginPage;
import javax.mail.MessagingException;
import java.time.Duration;

public class BaseTestForAuthorized extends BaseTest {
    public static DashboardPage dashboardPage;

    @RegisterExtension
    WatcherForAuthorizedUser watcher = new WatcherForAuthorizedUser("target/surefire-reports");

    @Order(2)
    @BeforeAll
    public static void beforeAllForAuthorizedUser() throws MessagingException, InterruptedException {
        BaseTest.logger.debug("beforeAllForAuthorizedUser");
        emailOfUserWithNotEmptyWS = new Email(Globals.USER_WITH_NOT_EMPTY_WS, Email.EmailFolder.INBOX);
        BaseTest.driver = DriverFactory.createDriver(Globals.BROWSER);
        BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        LoginPage loginPage = new LandingPage(BaseTest.driver).openLoginPage();
        dashboardPage = loginPage.login(Globals.USER_WITH_NOT_EMPTY_WS, emailOfUserWithNotEmptyWS);
    }

    @AfterAll
    public static void afterAllForAuthorizedUser() {
        BaseTest.logger.debug("afterAllForAuthorizedUser");
        BaseTest.driver.quit();
    }

}
