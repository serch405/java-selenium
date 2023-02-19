package pageobject.my;

import helpers.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.BasePage;

public class BasePageForMy extends BasePage {
    private By toastMessage = By.className("dx-overlay-content");

    public BasePageForMy(WebDriver driver) {
        super(driver);
    }

    public Boolean waitUntilToastMessageAppear() {
        return WebDriverActions.waitUntilElementIsVisible(driver, toastMessage);
    }

    public String getToastMessageText() {
        return driver.findElement(toastMessage).getText();
    }

}
