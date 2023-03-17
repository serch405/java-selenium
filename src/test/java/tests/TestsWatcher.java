package tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Optional;
import helpers.DriverFactory;
import helpers.Globals;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class TestsWatcher implements TestWatcher, BeforeEachCallback, AfterEachCallback {
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
            BaseTest.logger.debug("captureScreenshot exception");
        }
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws MalformedURLException {
        BaseTest.logger.debug("beforeEach");
        BaseTest.driver = DriverFactory.createDriver(Globals.BROWSER);
        BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        BaseTest.driver.get(Globals.URL);
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        BaseTest.logger.debug("afterEach");
        BaseTest.driver.quit();
    }

}
