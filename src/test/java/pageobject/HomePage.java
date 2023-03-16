package pageobject;

import helpers.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {
    By headerText = By.cssSelector("h1");
    By registerLink = By.xpath("//a[contains(text(), 'Register')]");
    By loginLink = By.xpath("//a[contains(text(), 'Login')]");
    By aboutLink = By.xpath("//a[contains(text(), 'About')]");

    public HomePage(WebDriver driver) {
        super(driver);
        WebDriverActions.waitUntilElementIsVisible(driver, this.loginLink);
    }

    public LoginPage openLoginPage() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }
}
