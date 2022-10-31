package com.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public interface Configuration {

    Properties configProp = new Properties();
    String configurationPath = "Resources/configuration/config.properties";

    String PROJECT_DIR = getProjectDir();

    String BROWSER = getProperty("browser");
    String URL = System.getProperty("url");

    String SELENIUM_HUB = getProperty("selenium.hub");
    String SELENIUM_PORT = getProperty("selenium.port");

    String USERNAME = getProperty("username");
    String LOGIN_PASSWORD = getProperty("password");
    String TEST_DATA = getProperty("test.data");
    String IS_HEADLESS = getProperty("is.headless");

    int IMPLICIT_WAIT = Integer.parseInt(getProperty("implicit.wait"));
    int EXPLICIT_WAIT = Integer.parseInt(getProperty("explicit.wait"));
    int STATIC_WAIT = Integer.parseInt(getProperty("static.wait"));

    String REPORT_ICONS = PROJECT_DIR + File.separator + ".icons" + File.separator;

    static URL getRemoteGridURL() {

        URL REMOTE_GRID_URL = null;

        try {
            REMOTE_GRID_URL = new URL("http://" + SELENIUM_HUB + ":" + SELENIUM_PORT + "/wd/hub");
        } catch (MalformedURLException ex) {
            Logger.log("Error occurred in Remote Grid URL.");
        }

        return REMOTE_GRID_URL;
    }

    /**
     * To get the current project directory path
     *
     * @return Project Directory path
     */
    static String getProjectDir() {
        return System.getProperty("user.dir");
    }

    /**
     * To get the Test Configuration Property values
     *
     * @param key Key
     * @return Value of Key
     */
    static String getProperty(String key) {
        InputStream input = null;
        try {
            input = new FileInputStream(configurationPath);
            configProp.load(input);
        } catch (Exception e) {
            Logger.log("Error occurred while reading the file.");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return configProp.getProperty(key);
    }

}
