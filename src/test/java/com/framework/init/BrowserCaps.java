package com.framework.init;

import com.framework.utils.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

import java.util.HashMap;
import java.util.Map;


public class BrowserCaps implements Configuration {

    public static String osName = "";
    public static String browserVersion = "";
    public static String browserName = "";

    /**
     * To configure the Firefox browser capabilities
     *
     * @return Firefox Browser Capabilities
     */
    static FirefoxOptions configureMozillaFirefox() {

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions option = new FirefoxOptions();

        option.setCapability("marionette", true);

        browserName = option.getBrowserName();
        osName = System.getProperty("os.name");
        browserVersion = option.getBrowserVersion();

        System.out.println("OS Name : " + osName);
        System.out.println("Browser Name : " + browserName);
        System.out.println("Browser Version : " + browserVersion);

        return option;
    }

    /**
     * To configure the Chrome browser capabilities
     *
     * @return Chrome Browser Capabilities
     */
    static ChromeOptions configureGoogleChrome() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions option = new ChromeOptions();
        if (IS_HEADLESS.equalsIgnoreCase("true")) {
            option.addArguments("--no-sandbox");
            option.addArguments("--disable-dev-shm-usage");
            option.addArguments("disable-infobars");
            option.addArguments("--enable-precise-memory-info");
            option.addArguments("--disable-popup-blocking");
            option.addArguments("--disable-default-apps");
            option.addArguments("--start-maximized");
            option.addArguments("--headless");
            option.addArguments("--window-size=1920x1080");
        }

        option.addArguments("incognito");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("profile.default_content_setting_values.plugins", 1);
        prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
        prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
        prefs.put("PluginsAllowedForUrls", URL);
        option.setExperimentalOption("prefs", prefs);

        browserName = option.getBrowserName();
        osName = System.getProperty("os.name");
        browserVersion = option.getBrowserVersion();

        System.out.println("OS Name : " + osName);
        System.out.println("Browser Name : " + browserName);
        System.out.println("Browser Version : " + browserVersion);

        return option;
    }

    /**
     * To configure the Edge browser capabilities
     *
     * @return Edge Browser Capabilities
     */
    static EdgeOptions configureMicrosoftEdge() {

        WebDriverManager.edgedriver().setup();
        EdgeOptions option = new EdgeOptions();

        option.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        option.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        option.setCapability("requireWindowFocus", true);

        browserName = option.getBrowserName();
        osName = System.getProperty("os.name");
        browserVersion = option.getBrowserVersion();

        System.out.println("OS Name : " + osName);
        System.out.println("Browser Name : " + browserName);
        System.out.println("Browser Version : " + browserVersion);

        return option;
    }

}
