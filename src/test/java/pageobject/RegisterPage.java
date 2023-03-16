package pageobject;

import helpers.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterPage extends BaseAuthPage {
    By usernameInput = By.cssSelector("input[name='username']");
    By emailInput = By.cssSelector("input[name='email']");
    By passwordInput = By.cssSelector("input[name='password']");
    By repassInput = By.cssSelector("input[name='repass']");
    By submitBtn = By.cssSelector("button");

    protected RegisterPage(WebDriver driver) {
        super(driver);
        WebDriverActions.waitUntilElementIsVisible(driver, this.emailInput);
    }

    public void typeUsername(String username) {
        WebDriverActions.clearAndSendKeys(driver, usernameInput, username);
    }

    public void typeEmail(String email) {
        WebDriverActions.clearAndSendKeys(driver, emailInput, email);
    }

    public void typePassword(String password) {
        WebDriverActions.clearAndSendKeys(driver, passwordInput, password);
    }

    public void typeRepass(String repass) {
        WebDriverActions.clearAndSendKeys(driver, repassInput, repass);
    }

    public void fillForm(String username, String email, String password, String repass) {
        typeUsername(username);
        typeEmail(email);
        typePassword(password);
        typeRepass(repass);
    }

    public void submit() {
        driver.findElement(submitBtn).click();
    }

    public LoginPage register(String username, String email, String password, String repass) {
        this.fillForm(username, email, password, repass);
        this.submit();
        return new LoginPage(driver);
    }

    public RegisterPage registerFailed(String username, String email, String password, String repass) {
        this.fillForm(username, email, password, repass);
        this.submit();
        return this;
    }

}
