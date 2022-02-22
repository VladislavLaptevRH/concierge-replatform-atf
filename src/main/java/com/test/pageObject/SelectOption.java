package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import com.test.utility.Hooks;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class SelectOption {
    static WebDriver webDriver = Hooks.getWebDriver();

    private SelenideElement sizeOption = $(By.xpath("//select[@id='optionSelect--Size']"));

    private SelenideElement quantity = $(By.xpath("//select[@id='" + getProductId() + "-qty-input']"));

    private SelenideElement finishOption = $(By.xpath("//select[@id='optionSelect-" + getProductId() + "-Finish']"));


    /**
     * @return product id from url
     * This method returns product id
     */
    public static final String getProductId() {
        String currentUrl = webDriver.getCurrentUrl();
        String productId = currentUrl.substring(currentUrl.indexOf("="), currentUrl.indexOf("&")).replace("=", "");
        return productId;
    }
}
