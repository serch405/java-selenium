package helpers;

import enums.Browser;
import enums.Environment;

public class Globals {
    public static final Browser BROWSER = SystemPropertiesReader.getBrowser();
    public static final Environment ENVIRONMENT = SystemPropertiesReader.getEnvironment();
    public static final long WAIT = SystemPropertiesReader.getWait();
    public static EnvironmentPropertiesReader environmentPropertiesReader = new EnvironmentPropertiesReader();
    public static final String MY_URL = environmentPropertiesReader.getMyUrl();
    public static final String GMAIL_HOST = environmentPropertiesReader.getGmailHost();
    public static final Integer GMAIL_PORT = environmentPropertiesReader.getGmailPort();
    public static final UserModel USER_WITH_NOT_EMPTY_WS = environmentPropertiesReader.getUserWithNotEmptyWS();
    public static final UserModel USER_WITHOUT_WS = environmentPropertiesReader.getUserWithoutWS();;
    public static final UserModel USER_WITH_EMPTY_WS = environmentPropertiesReader.getUserWithEmptyWS();

}
