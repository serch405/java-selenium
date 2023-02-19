package pageobject.my.components;

import helpers.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import pageobject.Base;
import pageobject.my.GlobalIncidents;


public class Sidebar extends Base {
    public By sidebar = By.cssSelector("div.sidebar-main");
    public By workspacesItem = By.cssSelector("a#menu-workspaces");
    public By workspacesSublist = By.className("hidden-ul");
    public By globalIncidentsItem = By.cssSelector("a#menu-global-incidents");

    public Sidebar() {
        super(driver);
    }

    public Boolean isSidebarExpended() {
        Dimension dim = driver.findElement(sidebar).getSize();
        return dim.width > 100;
    }

    public Boolean isWorkspacesSublistExpended() {
        return WebDriverActions.waitUntilElementAttributeContains(driver, workspacesSublist, "style", "display: block;");
    }

//    public void getWorkspacesSublistExpendIcon() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        String content = (String) js.executeScript("return window.getComputedStyle(document.querySelector('a#menu-workspaces'),':after').getPropertyValue('content')");
//        System.out.println(content);
//    }

    public void clickWorkspacesExpendIcon() {
        int width = driver.findElement(workspacesItem).getSize().getWidth();
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(workspacesItem)).moveByOffset(width/2-5, 0).click().perform();
    }

    public GlobalIncidents openGlobalIncidentsPage() {
        driver.findElement(globalIncidentsItem).click();
        return new GlobalIncidents(driver);
    }

}
