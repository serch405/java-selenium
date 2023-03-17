package helpers;

import enums.Browser;
import enums.Environment;


public class ProjectSystemProperties {

    public static Browser getBrowser() {
        String browser = System.getProperty("browser");

        if (browser == null || browser.equalsIgnoreCase("chrome")) return Browser.CHROME;
        else if (browser.equalsIgnoreCase("chrome_headless")) return Browser.CHROME_HEADLESS;
        else if (browser.equalsIgnoreCase("firefox")) return Browser.FIREFOX;
        else throw new RuntimeException("Can't parse Browser value: " + browser);
    }

    public static Environment getEnvironment() {
        String environment = System.getProperty("env");

        if (environment == null || environment.equalsIgnoreCase("local")) return Environment.LOCAL;
        else if (environment.equalsIgnoreCase("selenoid")) return Environment.SELENOID;
        else throw new RuntimeException("Can't parse Environment value: " + environment);
    }

    public static long getWait() {
        String wait = System.getProperty("wait");
        if (wait != null) return Long.parseLong(wait);
        return 10;
    }

}
