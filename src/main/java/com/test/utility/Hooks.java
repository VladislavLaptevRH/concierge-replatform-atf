package com.test.utility;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.test.stepdefinitions.FilterStepDefs;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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

    private static boolean setUpIsDone = false;
    private static final Logger Log = LoggerFactory.getLogger(FilterStepDefs.class);


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
     * Init web driver for regression and smoke  for concierge
     */
    @Before("@eStoreRegression or @eStoreSmoke")
    public void initWebDrivereStore() {
        setupChromeArguments();
        setUPWebDriver((String) properties.get("eStoreUrl"));
    }

    /**
     * Init web driver for rhnonprod for filter automation tests
     */
    @Before("@rhnonprodFilter")
    public void initWebDriverIntdNonProd() {
//        setupChromeArguments();
        setUPWebDriverIntNonProd();
    }

    /**
     * Init web driver for regression and smoke  for concierge
     */
    @Before("@conciergeRegression or @conciergeSmoke")
    public void initWebDriver() {
        ConfigFileReader();
        setupChromeArguments();
        setUPWebDriver((String) properties.get("conciergestg2url"));
    }

    /**
     * Initialize Web driver
     */
    public void setUPWebDriverIntNonProd() {
        System.out.println("Inside initDriver method");
        if (setUpIsDone) {
            return;
        }
        WebDriverManager.chromedriver().setup();
        Configuration.driverManagerEnabled = true;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1366x768";
        Configuration.headless = false;

        open((String) properties.get("intdnonprod"));
        Log.debug("Open https://intd.rhnonprod.com/ product");
        setUpIsDone = true;
    }

    /**
     * Initialize Web driver
     */
    public void setUPWebDriver(String url) {
//        System.out.println("Inside initDriver method");
//        WebDriverManager.chromedriver().setup();
//        Configuration.driverManagerEnabled = true;
//        Configuration.browser = "chrome";
//        Configuration.browserSize = "1366x768";
        Configuration.headless = true;
        Configuration.pageLoadStrategy = "normal";
        Configuration.timeout = 60000;
        Configuration.reportsFolder = "target/screenshots";
        open(url);
        currentUrl = WebDriverRunner.url();
    }

    /**
     * Set up chrome arguments for Jenkins run
     */
    public void setupChromeArguments() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1366,768");
        DesiredCapabilities dr = new DesiredCapabilities();
        dr.setBrowserName("chrome");
        dr.setCapability(ChromeOptions.CAPABILITY, options);
        String urlToRemoteWD = "http://seleniumgrid.rhapsodynonprod.com:4444/wd/hub";
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(urlToRemoteWD), dr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        WebDriverRunner.setWebDriver(driver);
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
    @After("@conciergeRegression or @conciergeSmoke or @eStoreRegression or @eStoreSmoke")
    public void tearDownWebDriver(Scenario scenario) {
        System.out.println(scenario.getName() + " : " + scenario.getStatus());
        closeWindow();
        closeWebDriver();
        System.out.println("Driver was closed");
        sleep(2000);
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
