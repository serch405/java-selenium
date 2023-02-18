package pages.landing.components;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pages.Base;
import pages.landing.BusinessProductPage;
import pages.landing.CmdProductPage;
import pages.landing.HomeProductPage;
import pages.my.LoginPage;

public class Header extends Base {
    public By emsiLogo = By.cssSelector("a.logo-emsisoft");
    public By protectionMenuItem = By.xpath("//ul[@id='menu-header-en']/li/a[contains(text(), 'Protection')]");
    public By homeProductSubMenuItem = By.xpath("//ul[@id='menu-header-en']/li/ul/li/a[contains(@href,'https://www.emsisoft.com/en/anti-malware-home/')]");
    public By businessProductSubMenuItem = By.xpath("//ul[@id='menu-header-en']/li/ul/li/a[contains(@href,'https://www.emsisoft.com/en/business-security/')]");
    public By remediationMenuItem = By.xpath("//ul[@id='menu-header-en']/li/ul/li/a[contains(@href,'https://www.emsisoft.com/en/commandline-scanner/')]");
    public By cmdProductSubMenuItem = By.xpath("//ul[@id='menu-header-en']/li/ul/li/a[contains(@href,'https://www.emsisoft.com/en/commandline-scanner/')]");
    public By iframe = By.cssSelector(".login iframe");
    public By loginButton = By.id("link");

    public Header() {
        super(driver);
    }

    public HomeProductPage openHomeProductPage() {
        new Actions(driver)
                .moveToElement(driver.findElement(protectionMenuItem))
                .click(driver.findElement(homeProductSubMenuItem))
                .perform();
        return new HomeProductPage();
    }

    public BusinessProductPage openBusinessProductPage() {
        new Actions(driver)
                .moveToElement(driver.findElement(protectionMenuItem))
                .click(driver.findElement(businessProductSubMenuItem))
                .perform();
        return new BusinessProductPage();
    }

    public CmdProductPage openCmdProductPage() {
        new Actions(driver)
                .moveToElement(driver.findElement(remediationMenuItem))
                .click(driver.findElement(cmdProductSubMenuItem))
                .perform();
        return new CmdProductPage();
    }

    public LoginPage openLoginPage() {
        driver.switchTo().frame(driver.findElement(iframe)).findElement(loginButton).click();
        return new LoginPage();
    }

}
