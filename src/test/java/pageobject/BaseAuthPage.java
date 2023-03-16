package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BaseAuthPage extends BasePage{
    By headerText = By.cssSelector("h1");
    By messageText = By.cssSelector("div div p");
    By backToHomePageLink = By.xpath("//a[contains(text(), 'Back to Home page')]");

    public BaseAuthPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return driver.findElement(headerText).getText();
    }

    public String getMessageText() {
        return driver.findElement(messageText).getText();
    }

    public HomePage backToHome() {
        driver.findElement(backToHomePageLink).click();
        return new HomePage(driver);
    }

}
