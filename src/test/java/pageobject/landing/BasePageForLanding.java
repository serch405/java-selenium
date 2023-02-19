package pageobject.landing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.BasePage;
import pageobject.landing.components.Header;

public class BasePageForLanding extends BasePage {
    protected Header headerComponent;
    protected By liveChat = By.cssSelector(".start-livechat");

    public BasePageForLanding(WebDriver driver) {
        super(driver);
        this.headerComponent = new Header();
    }

    protected LandingPage openLandingPage() {
        driver.findElement(headerComponent.emsiLogo).click();
        return new LandingPage(driver);
    }

}
