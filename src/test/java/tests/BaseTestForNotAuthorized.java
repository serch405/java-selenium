package tests;

import helpers.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.RegisterExtension;
import javax.mail.MessagingException;


public class BaseTestForNotAuthorized extends BaseTest {

    @RegisterExtension
    WatcherForNotAuthorizedUser watcher = new WatcherForNotAuthorizedUser("target/surefire-reports");

    @Order(2)
    @BeforeAll
    public static void beforeAllForNotAuthorizedUser() throws MessagingException {
        BaseTest.logger.debug("beforeAllForNotAuthorizedUser");
        emailOfUserWithoutWS = new Email(Globals.USER_WITHOUT_WS, Email.EmailFolder.INBOX);
        emailOfUserWithEmptyWS = new Email(Globals.USER_WITH_EMPTY_WS, Email.EmailFolder.INBOX);
        emailOfUserWithNotEmptyWS = new Email(Globals.USER_WITH_NOT_EMPTY_WS, Email.EmailFolder.INBOX);
    }

}
