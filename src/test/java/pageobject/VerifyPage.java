package pageobject;

import helpers.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class VerifyPage extends BaseAuthPage {
    By passwordInput = By.cssSelector("input[name='password']");
    By codeInput = By.cssSelector("input[name='code']");
    By verifyBtn = By.id("verify");

    protected VerifyPage(WebDriver driver) {
        super(driver);
        WebDriverActions.waitUntilElementIsVisible(driver, this.passwordInput);
    }

    public void typePassword(String password) {
        WebDriverActions.clearAndSendKeys(driver, passwordInput, password);
    }

    public void typeCode(String code) {
        WebDriverActions.clearAndSendKeys(driver, codeInput, code);
    }

    public void submit() {
        driver.findElement(verifyBtn).click();
    }

    public DashboardPage login(String password, String code) {
        this.typePassword(password);
        this.typeCode(code);
        this.submit();
        return new DashboardPage(driver);
    }

    public VerifyPage loginFailed(String password, String code) {
        this.typePassword(password);
        this.typeCode(code);
        this.submit();
        return this;
    }

}
