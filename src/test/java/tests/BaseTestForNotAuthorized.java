package tests;

import helpers.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.RegisterExtension;
import javax.mail.MessagingException;

public class BaseTestForNotAuthorized extends BaseTest {

    @RegisterExtension
    WatcherForNotAuthorizedUser watcher = new WatcherForNotAuthorizedUser("target/surefire-reports");

    @BeforeAll
    public static void beforeAllForNotAuthorizedUser() throws MessagingException {
        BaseTest.logger.debug("beforeAllForNotAuthorizedUser");
        emailOfUserWithoutWS = new EmailUtils(Globals.USER_WITHOUT_WS, EmailUtils.EmailFolder.INBOX);
        emailOfUserWithEmptyWS = new EmailUtils(Globals.USER_WITH_EMPTY_WS, EmailUtils.EmailFolder.INBOX);
        emailOfUserWithNotEmptyWS = new EmailUtils(Globals.USER_WITH_NOT_EMPTY_WS, EmailUtils.EmailFolder.INBOX);
    }

}
