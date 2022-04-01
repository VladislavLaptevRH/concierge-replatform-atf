package com.test.utility;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class Hooks {
    private static WebDriver webDriver;
    private Properties properties;
    private final String propertyFilePath = "src/main/resources/application.properties";
    public static String associatePassword;
    public static String associateLogin;
    public static String leaderPassword;
    public static String leaderLogin;
    public static String currentUrl;

    /**
     * This method get properties from application.properties file
     */
    private void ConfigFileReader() {
        BufferedReader reader;
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
        associatePassword = (String) properties.get("associatePassword");
        associateLogin = (String) properties.get("associateLogin");
        leaderPassword = (String) properties.get("leaderPassword");
        leaderLogin = (String) properties.get("leaderLogin");
    }

    /**
     * Init web driver
     */
    @Before()
    public void initWebDriver() {
        ConfigFileReader();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--window-size=1366,768");
//        DesiredCapabilities dr = new DesiredCapabilities();
//        dr.setBrowserName("chrome");
//        dr.setCapability(ChromeOptions.CAPABILITY, options);
//        String urlToRemoteWD = "http://seleniumgrid.rhapsodynonprod.com:4444/wd/hub";
//        RemoteWebDriver driver = null;
//        try {
//            driver = new RemoteWebDriver(new URL(urlToRemoteWD), dr);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        WebDriverRunner.setWebDriver(driver);

        setUPWebDriver();
    }

    /**
     * Initialize Web driver
     */
    public void setUPWebDriver() {
        System.out.println("Inside initDriver method");

        WebDriverManager.chromedriver().setup();
        Configuration.driverManagerEnabled = true;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1366x768";
        Configuration.headless = true;
        open((String) properties.get("baseurl"));
        currentUrl = WebDriverRunner.url();
    }

    /**
     * @return current url from browser
     */
    public static String getCurrentUrl() {
        currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        return currentUrl;
    }

    /**
     * @return tabs from browser
     */
    public static ArrayList<String> getWindowsHandles() {
        ArrayList<String> tabs = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles());
        return tabs;
    }

    /**
     * Quit web driver.
     */
    @After()
    public void tearDownWebDriver(Scenario scenario) {
        System.out.println(scenario.getName() + " : " + scenario.getStatus());
        closeWindow();
        closeWebDriver();
        System.out.println("Driver was closed");
    }

    /**
     * Get web driver
     *
     * @return web driver
     */
    public static WebDriver getWebDriver() {
        return webDriver;
    }

}
