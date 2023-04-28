package tests.utility;

import com.aventstack.extentreports.ExtentReports;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import tests.concierge.stepdefinitions.FilterStepDefs;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
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
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;

import com.aventstack.extentreports.ExtentReports;

@Getter
public class Hooks {
    private static WebDriver webDriver;
    public static Properties properties;
    private final String propertyFilePath = "src/main/resources/application.properties";
    public static String associatePassword;
    public static String associateLogin;
    public static String leaderPassword;
    public static String leaderLogin;
    public static String currentUrl;
    public static String conciergeURL;
    public static String eStoreURL;

    public static String conciergeBaseURL;
    public static String eStoreBaseURL;

    private static boolean setUpIsDone = false;
    private static final Logger Log = LoggerFactory.getLogger(FilterStepDefs.class);
    public static String profile;
    public static String cookie;
    public static String endpoint;

    ExtentReport report = new ExtentReport();

    /**
     * This method get properties from application.properties file
     */
    private void ConfigFileReader() {

//        profile = System.getenv("ENVIRONMENT");
//        cookie = System.getenv("ENDPOINT");

        profile = "stg2";
        cookie = "releasetues";
        if (profile == null) {
            Assert.fail("Environment Variable is NOT Set");
        } else {
            System.out.println("Tests are running on " + profile + " environment");
        }

        if (cookie == null) {
            System.out.println("Tests are running without cookie or endpoint");
        } else {
            System.out.println("Tests are running with endpoint = " + cookie);
        }

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
        conciergeBaseURL = properties.getProperty("url.concierge." + profile);
        eStoreBaseURL = properties.getProperty("url.estore." + profile);
        endpoint = properties.getProperty("endpoint.cookie." + cookie);
        associatePassword = (String) properties.get("associatePassword");
        associateLogin = (String) properties.get("associateLogin");
        leaderPassword = (String) properties.get("leaderPassword");
        leaderLogin = (String) properties.get("leaderLogin");
    }

    /**
     * Set up URL + endpoint  for eStore
     */
    public static String configureEstoreURL() {
        if ((profile.equals("stg4") && cookie.equals("no_endpoint"))) {
            eStoreURL = eStoreBaseURL;
        } else if (profile.equals("stg2") && cookie.equals("no_endpoint")) {
            eStoreURL = eStoreBaseURL;
        } else if (profile.equals("stg3") && cookie.equals("no_endpoint")) {
            eStoreURL = eStoreBaseURL;
        } else if (profile.equals("stg2") && cookie.equals("FEATURE_SSR=true")) {
            eStoreURL = eStoreBaseURL + "/?" + cookie;
        } else if (profile.equals("stg2") && cookie != null) {
            eStoreURL = eStoreBaseURL + "/?endpoint=" + cookie;
        } else if (profile.equals("stg4") && cookie != null) {
            eStoreURL = eStoreBaseURL + "/?endpoint=" + cookie;
        } else if (profile.equals("stg3") && cookie != null) {
            eStoreURL = eStoreBaseURL + "/?endpoint=" + cookie;
        }
        return eStoreURL;
    }

    /**
     * Set up URL + endpoint  for concierge
     */
    public static String configureConciergeURL() {
        if ((profile.equals("stg4") && cookie.equals("no_endpoint"))) {
            conciergeURL = conciergeBaseURL;
        } else if (profile.equals("stg2") && cookie.equals("no_endpoint")) {
            conciergeURL = conciergeBaseURL;
        } else if (profile.equals("stg2") && cookie != null) {
            conciergeURL = conciergeBaseURL + "/?endpoint=" + cookie;
        } else if (profile.equals("stg4") && cookie != null) {
            conciergeURL = conciergeBaseURL + "/?endpoint=" + cookie;
        } else if (profile.equals("stg3") && cookie != null) {
            conciergeURL = conciergeBaseURL + "/?endpoint=" + cookie;
        }
        return conciergeURL;
    }

    /**
     * Init web driver for regression and smoke  for tests.concierge
     */
    @Before("@estoreRegression")
    public void initWebDrivereStore() {
        try {
            ConfigFileReader();
            configureEstoreURL();
            setupChromeArguments();
            setUPWebDriver(eStoreURL);
        } catch (TimeoutException | MalformedURLException exception) {
            with().pollInterval(10, SECONDS).await().until(() -> true);
            refresh();
        }
    }

    /**
     * Init web driver for regression and smoke  for tests.concierge
     */
    @Before("@concierge-All or @target/rerun.txt")
    public void initWebDriver() {
        ConfigFileReader();
        configureConciergeURL();
//        setupChromeArguments();
        setUPWebDriver(conciergeURL);
    }

    /**
     * Initialize Web driver
     */
    public void setUPWebDriver(String url) {
        System.out.println("Inside initDriver method");
        WebDriverManager.chromedriver().setup();
        Configuration.driverManagerEnabled = true;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1366x768";
        Configuration.headless = true;
        Configuration.pageLoadStrategy = "normal";
        Configuration.timeout = 600000;
        Configuration.reportsFolder = "target/screenshots";
        open(url);
        currentUrl = WebDriverRunner.url();
    }

    /**
     * Set up chrome arguments for Jenkins run
     */
    public void setupChromeArguments() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1366,768");
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities dr = new DesiredCapabilities();
        dr.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = null;
        driver = new ChromeDriver(dr);
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
    @After("@concierge-All or @estoreRegression or @target/rerun.txt")
    public void tearDownWebDriver(Scenario scenario) {
        System.out.println(scenario.getName() + " : " + scenario.getStatus());

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
        /* TODO : Finish Extent Report Class Implementation */
        //report.endReport();
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

    /**
     * Setup cookies for concierge
     */
    public static void setupConciergeCookies() {
        if (cookie != null) {
            Cookie ck = new Cookie("endpoint", endpoint);
            WebDriverRunner.getWebDriver().manage().addCookie(ck);
            WebDriverRunner.getWebDriver().navigate().refresh();
        }
    }

    /**
     * Setup cookies for eStore
     */
    public static void setupEstoreCookies() {
        if (cookie != null) {
            Cookie ck = new Cookie("endpoint", endpoint);
            WebDriverRunner.getWebDriver().manage().addCookie(ck);
            WebDriverRunner.getWebDriver().navigate().refresh();
        }
    }
}