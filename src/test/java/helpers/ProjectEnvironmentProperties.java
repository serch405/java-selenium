package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ProjectEnvironmentProperties {
    private Properties properties;
    private String environmentPropertyFolderPath = "src/test/resources/";
    private String environmentPropertyFilePath;

    public ProjectEnvironmentProperties() {

        switch(Globals.ENVIRONMENT) {
            case LOCAL : environmentPropertyFilePath = environmentPropertyFolderPath + "local.properties";
                break;
            case PROD : environmentPropertyFilePath = environmentPropertyFolderPath + "prod.properties";
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

    public String getUrl() {
        return properties.getProperty("url");
    }

    public String getGmailHost() {
        return properties.getProperty("gmail.host");
    }

    public Integer getGmailPort() {
        return Integer.parseInt(properties.getProperty("gmail.port"));
    }

    public UserModel getUser() {
        return new UserModel(properties.getProperty("user.gmail.email"),
                properties.getProperty("user.gmail.appPassword"),
                properties.getProperty("user.password"),
                properties.getProperty("user.username"));
    }

}
