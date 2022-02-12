package com.test.pageObject;

import com.test.utility.Hooks;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class SelectOption extends AbstractPage {
    static WebDriver webDriver = Hooks.getWebDriver();

    WebElement sizeOption = webDriver.findElement(By.xpath("//select[@id='optionSelect--Size']"));
    private WebElement quantity = webDriver.findElement(By.xpath("//select[@id='" + getProductId() + "-qty-input']"));
    private WebElement finishOption = webDriver.findElement(By.xpath("//select[@id='optionSelect-" + getProductId() + "-Finish']"));

    /**
     * Constructor for initialize page object
     *
     * @param driver Web driver
     */
    public SelectOption(WebDriver driver) {
        super(driver);
    }


    public static final String getProductId() {
        String currentUrl = webDriver.getCurrentUrl();
        String productId = currentUrl.substring(currentUrl.indexOf("="), currentUrl.indexOf("&")).replace("=", "");
        return productId;
    }
}
