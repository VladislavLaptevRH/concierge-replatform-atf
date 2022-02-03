package com.test.utility;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.TimeUnit;

@Getter
@PropertySource("classpath:credentials.properties.properties")
public class Hooks {

    @Autowired
    @Value("{$baseUrl}")
    private String baseUrl;

    private static WebDriver webDriver;

    /**
     * Init web driver
     */
    @Before()
    public void initWebDriver() {
        setUPWebDriver();
    }

    /**
     * Initialize Web driver
     */
    public void setUPWebDriver() {
        System.out.println(baseUrl);
        System.out.println("Inside initDriver method");

        try {
            System.setProperty("webdriver.chrome.driver", "/Users/mihail/IdeaProjects/concierge-atf/driver/chromedriver");
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.get("https://stg2-concierge.restorationhardware.com?platform=new");
            webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Driver is initdriver" + webDriver);
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    /**
     * Quit web driver.
     */
    @After()
    public void tearDownWebDriver() {
        webDriver.quit();
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
