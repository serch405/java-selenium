package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentPropertiesReader {
    private Properties properties;
    private String environmentPropertyFolderPath = "src/main/resources/";
    private String environmentPropertyFilePath;

    public EnvironmentPropertiesReader() {

        switch(Globals.ENVIRONMENT) {
            case PROD : environmentPropertyFilePath = environmentPropertyFolderPath + "prod.properties";
                break;
            case TEST : environmentPropertyFilePath = environmentPropertyFolderPath + "test.properties";
                break;
        }
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(environmentPropertyFilePath));
            this.properties = new Properties();

            try {
                this.properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't find \"" + environmentPropertyFilePath + "\" file");
        }
    }

    public String getMyUrl() {
        return properties.getProperty("my.url");
    }

    public String getGmailHost() {
        return properties.getProperty("gmail.host");
    }

    public Integer getGmailPort() {
        return Integer.parseInt(properties.getProperty("gmail.port"));
    }

    public UserModel getUserWithoutWS() {
        return new UserModel(properties.getProperty("userWithoutWS.gmail.email"),
                properties.getProperty("userWithoutWS.gmail.appPassword"),
                properties.getProperty("userWithoutWS.my.password"),
                properties.getProperty("userWithoutWS.my.username"),
                properties.getProperty("userWithoutWS.my.workspace"));
    }

    public UserModel getUserWithNotEmptyWS() {
        return new UserModel(properties.getProperty("userWithNotEmptyWS.gmail.email"),
                properties.getProperty("userWithNotEmptyWS.gmail.appPassword"),
                properties.getProperty("userWithNotEmptyWS.my.password"),
                properties.getProperty("userWithNotEmptyWS.my.username"),
                properties.getProperty("userWithNotEmptyWS.my.workspace"));
    }

    public UserModel getUserWithEmptyWS() {
        return new UserModel(properties.getProperty("userWithEmptyWS.gmail.email"),
                properties.getProperty("userWithEmptyWS.gmail.appPassword"),
                properties.getProperty("userWithEmptyWS.my.password"),
                properties.getProperty("userWithEmptyWS.my.username"),
                properties.getProperty("userWithEmptyWS.my.workspace"));
    }

}
