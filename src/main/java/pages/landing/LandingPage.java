package pages.landing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.my.LoginPage;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


public class LandingPage extends BasePageForLanding {

    public LandingPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.emsisoft.com/en/");
        this.waitUntilPageIsLoaded();
    }

    protected void waitUntilPageIsLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(headerComponent.emsiLogo));
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(liveChat));
    }

    public HomeProductPage openHomeProductPage() {
        return this.headerComponent.openHomeProductPage();
    }

    public BusinessProductPage openBusinessProductPage() {
        return this.headerComponent.openBusinessProductPage();
    }

    public CmdProductPage openCmdProductPage() {
        return this.headerComponent.openCmdProductPage();
    }

    public LoginPage openLoginPage() {
        LoginPage loginPage = this.headerComponent.openLoginPage();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> windowHandlesIterator = windowHandles.iterator();

        while (windowHandlesIterator.hasNext()) {
            String windowHandle = windowHandlesIterator.next();
            WebDriver popup = driver.switchTo().window(windowHandle);

            if (popup.getTitle().equals("MyEmsisoft")) {
                break;
            }
        }
        return loginPage;
    }

}
