package tests;

import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;


public class WatcherForAuthorizedUser implements TestWatcher {

    static public String path;

    public WatcherForAuthorizedUser(String path) {
        BaseTest.logger.debug("WatcherForAuthorizedUser");
        this.path = path;
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable throwable) { }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> optional) { }

    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {
        captureScreenshot(context.getTestClass() + "-" + context.getDisplayName());
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) { }

    public void captureScreenshot(String fileName) {
        BaseTest.logger.debug("captureScreenshot");

        try {
            new File(path).mkdirs();
            String screenshot = path + File.separator + "screenshot-" + fileName + ".png";
            try (FileOutputStream out = new FileOutputStream(screenshot)) {
                out.write(((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BYTES));
            }
        } catch (IOException | WebDriverException e) {
            BaseTest.logger.fatal("captureScreenshot exception");
        }
    }

}
