package com.coretestautomation.core.config;
import java.io.*;
import java.util.Properties;

public class PropertiesFile {
    public static Properties properties;

    public PropertiesFile(){
        BufferedReader reader;
        String propertyFilePath = "src/main/resources/env/config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if(browser != null) return browser;
        else throw new RuntimeException("Browser is not specified in the config.properties file");
    }

    public String getBrowserSize() {
        String browser_size = properties.getProperty("browserSize");
        if(browser_size != null) return browser_size;
        else throw new RuntimeException("Browser_size is not specified in the config.properties file");
    }


    public String getBrowserVersion() {
        String browser_size = properties.getProperty("browserVersion");
        if(browser_size != null) return browser_size;
        else throw new RuntimeException("Browser version is not specified in the config.properties file");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("applicationUrl");
        if(url != null) return url;
        else throw new RuntimeException("Application url is not specified in the config.properties file");
    }

    public static String getLogin() {
        String login = properties.getProperty("login");
        if(login != null) return login;
        else throw new RuntimeException("login is not specified in the config.properties file.");
    }

    public static String getPassword() {
        String password = properties.getProperty("password");
        if(password != null) return password;
        else throw new RuntimeException("password is not specified in the config.properties file.");
    }
}
