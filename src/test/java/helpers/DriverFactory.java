package helpers;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import enums.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import enums.Browser;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;


public class DriverFactory {
    public static WebDriver createDriver(Browser browser, Environment environment) throws MalformedURLException {
        Map<String, Object> prefs = new HashMap<String, Object>();
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        Object browserOptions = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Boolean chromeBrowser = browser.equals(Browser.CHROME) || browser.equals(Browser.CHROME_HEADLESS);

        if (chromeBrowser) {
            prefs.put("download.default_directory", Globals.DOWNLOAD_FOLDER.getPath());
            prefs.put("safebrowsing.enabled", true);
            chromeOptions.setExperimentalOption("prefs", prefs);
            chromeOptions.addArguments("--window-size=1920,1080");
            chromeOptions.addArguments("--remote-allow-origins=*");

            if (browser.equals(Browser.CHROME_HEADLESS)) {
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-gpu");
            }
            browserOptions = chromeOptions;
        }

        if (browser.equals(Browser.FIREFOX)) {
            prefs.put("browser.download.dir", Globals.DOWNLOAD_FOLDER.getPath());
            firefoxOptions.addPreference("browser.download.folderList", 2);
            firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
            firefoxOptions.setCapability("marionette", true);
            browserOptions = firefoxOptions;
        }

        if (environment.equals(Environment.LOCAL)) {
            if (chromeBrowser) {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver((ChromeOptions) browserOptions);
            } else if (browser.equals(Browser.FIREFOX)) {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver((FirefoxOptions) browserOptions);
            }
        }

        else if (environment.equals(Environment.SELENOID)) {
            if (chromeBrowser) {
                capabilities.setBrowserName("chrome");
                capabilities.setVersion(Globals.BROWSER_VERSION);
                capabilities.setCapability(ChromeOptions.CAPABILITY, browserOptions);
                return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            } else if (browser.equals(Browser.FIREFOX)) {
                capabilities.setBrowserName("firefox");
                capabilities.setVersion(Globals.BROWSER_VERSION);
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, browserOptions);
                return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            }
        }
        return null;
    }

}
