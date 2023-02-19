package pageobject.my;

import helpers.WebDriverActions;
import helpers.EmailUtils;
import helpers.UserModel;
import org.openqa.selenium.By;
import javax.mail.MessagingException;


public class LoginPage extends BasePageForMy {
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By codeInput = By.id("code");
    private By loginBtn = By.id("submit");

    public LoginPage() {
        super(driver);
    }

    public void typeEmail(String email) {
        WebDriverActions.clearAndSendKeys(driver, emailInput, email);
    }

    public void typePassword(String password) {
        WebDriverActions.clearAndSendKeys(driver, passwordInput, password);
    }

    public void typeCode(String code) {
        WebDriverActions.clearAndSendKeys(driver, codeInput, code);
    }

    public Boolean isLoginButtonShown() {
        return WebDriverActions.waitUntilElementIsVisible(driver, this.loginBtn);
    }

    public LoginPage loginFailedCredentials(UserModel user) {
        this.typeEmail(user.gmailEmail);
        this.typePassword("password");
        driver.findElement(loginBtn).click();
        return this;
    }

    public LoginPage loginFailedCode(UserModel user) {
        this.typeEmail(user.gmailEmail);
        this.typePassword(user.myPassword);
        driver.findElement(loginBtn).click();
        WebDriverActions.waitUntilElementIsVisible(driver, this.codeInput);
        this.typeCode("123456");
        driver.findElement(loginBtn).click();
        return this;
    }

    public DashboardPage login(UserModel user, EmailUtils emailUtils) throws MessagingException, InterruptedException {
        emailUtils.setAllMessagesAsRead();
        this.typeEmail(user.gmailEmail);
        this.typePassword(user.myPassword);
        driver.findElement(loginBtn).click();
        this.typeCode(emailUtils.getCode());
        driver.findElement(loginBtn).click();
        return new DashboardPage(driver);
    }

}
