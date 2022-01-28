package com.test.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AbstractPage {

    private WebDriver driver;

    /**
     * Constructor for initialize page object
     *
     * @param driver Web driver
     */
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
}
