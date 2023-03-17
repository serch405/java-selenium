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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import tests.BaseTest;

import javax.xml.bind.annotation.XmlElementDecl;
import java.net.URL;


public class DriverFactory {
    public static WebDriver createDriver(Browser browser) throws MalformedURLException {
        Map<String, Object> chromePrefs = new HashMap<String, Object>();
        ChromeOptions chromeOptions = new ChromeOptions();

        switch (browser) {
            case CHROME:
                chromePrefs.put("download.default_directory", Globals.DOWNLOAD_FOLDER.getPath());
                chromePrefs.put("safebrowsing.enabled", true);
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                chromeOptions.addArguments("--window-size=1920,1080");
                chromeOptions.addArguments("--remote-allow-origins=*");
                break;
            case CHROME_HEADLESS:
                chromePrefs.put("download.default_directory", Globals.DOWNLOAD_FOLDER.getPath());
                chromePrefs.put("safebrowsing.enabled", true);
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--window-size=1920,1080");
                chromeOptions.addArguments("--remote-allow-origins=*");
                break;
        }

        if (Globals.ENVIRONMENT.equals(Environment.LOCAL)) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(chromeOptions);
        }

        else if (Globals.ENVIRONMENT.equals(Environment.SELENOID)) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setVersion("110.0");
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        }
        return null;
    }

}
