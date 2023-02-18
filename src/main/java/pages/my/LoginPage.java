package pages.my;

import helpers.SeleniumAddition;
import helpers.Email;
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
        SeleniumAddition.clearAndSendKeys(driver, emailInput, email);
    }

    public void typePassword(String password) {
        SeleniumAddition.clearAndSendKeys(driver, passwordInput, password);
    }

    public void typeCode(String code) {
        SeleniumAddition.clearAndSendKeys(driver, codeInput, code);
    }

    public Boolean isLoginButtonShown() {
        return SeleniumAddition.waitUntilElementIsVisible(driver, this.loginBtn);
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
        SeleniumAddition.waitUntilElementIsVisible(driver, this.codeInput);
        this.typeCode("123456");
        driver.findElement(loginBtn).click();
        return this;
    }

    public DashboardPage login(UserModel user, Email email) throws MessagingException, InterruptedException {
        email.setAllMessagesAsRead();
        this.typeEmail(user.gmailEmail);
        this.typePassword(user.myPassword);
        driver.findElement(loginBtn).click();
        this.typeCode(email.getCode());
        driver.findElement(loginBtn).click();
        return new DashboardPage(driver);
    }

}
