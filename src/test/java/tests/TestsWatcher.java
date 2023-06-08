package tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Optional;
import helpers.DriverFactory;
import helpers.EmailUtils;
import helpers.Globals;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import javax.mail.MessagingException;


public class TestsWatcher implements TestWatcher, BeforeAllCallback, BeforeEachCallback {
    static public String path;

    public TestsWatcher(String path) {
        this.path = path;
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable throwable) {
        BaseTest.driver.quit();
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> optional) {
        BaseTest.driver.quit();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {
        BaseTest.logger.debug("testFailed");
        captureScreenshot(context.getDisplayName());
        BaseTest.driver.quit();
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        BaseTest.driver.quit();
    }

    public void captureScreenshot(String fileName) {

        try {
            new File(path).mkdirs();
            String screenshot = path + File.separator + "screenshot-" + fileName + ".png";
            try (FileOutputStream out = new FileOutputStream(screenshot)) {
                out.write(((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BYTES));
            }
        } catch (IOException | WebDriverException e) {
            BaseTest.logger.debug("captureScreenshot exception: " + e.getMessage());
        }
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws MalformedURLException, MessagingException {
        BaseTest.logger.debug("beforeAll");
        BaseTest.emailOfUser = new EmailUtils(Globals.USER, EmailUtils.EmailFolder.INBOX);
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws MalformedURLException {
        BaseTest.logger.debug("beforeEach");
        BaseTest.driver = DriverFactory.createDriver(Globals.BROWSER, Globals.ENVIRONMENT);
        BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        BaseTest.driver.get(Globals.URL);
    }

}
