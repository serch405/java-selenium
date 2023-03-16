package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class WebDriverActions {

    public static void clearAndSendKeys(WebDriver driver, By by, String value) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(value);
    }

    public static boolean waitUntilElementIsVisible(WebDriver driver, By by) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(Globals.WAIT)).until(ExpectedConditions.visibilityOfElementLocated(by));
            Thread.sleep(250);
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public static boolean waitUntilElementIsInvisible(WebDriver driver, By by) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(Globals.WAIT)).until(ExpectedConditions.invisibilityOfElementLocated(by));
            Thread.sleep(250);
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public static boolean waitUntilElementIsClickable(WebDriver driver, By by) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(Globals.WAIT)).until(ExpectedConditions.elementToBeClickable(by));
            Thread.sleep(250);
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public static boolean waitUntilElementAttributeContains(WebDriver driver, By by, String attributeName, String attributeValue) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(Globals.WAIT)).until(ExpectedConditions.attributeContains(by, attributeName, attributeValue));
            Thread.sleep(250);
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

}
