package pageobject;

import helpers.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BaseAuthPage {
    By emailInput = By.cssSelector("input[name='email']");
    By loginBtn = By.id("login");

    public LoginPage(WebDriver driver) {
        super(driver);
        WebDriverActions.waitUntilElementIsVisible(driver, this.loginBtn);
    }
    public void typeEmail(String email) {
        WebDriverActions.clearAndSendKeys(driver, emailInput, email);
    }

    public void submit() {
        driver.findElement(loginBtn).click();
    }

    public VerifyPage login(String email) {
        this.typeEmail(email);
        this.submit();
        return new VerifyPage(driver);
    }

    public LoginPage loginFailed(String email) {
        this.typeEmail(email);
        this.submit();
        return this;
    }

}
