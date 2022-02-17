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
    SelenideElement sizeOption = $(By.xpath("//select[@id='optionSelect--Size']"));
    SelenideElement quantity = $(By.xpath("//select[@id='" + getProductId() + "-qty-input']"));
    SelenideElement finishOption = $(By.xpath("//select[@id='optionSelect-" + getProductId() + "-Finish']"));


    public static final String getProductId() {
        String currentUrl = webDriver.getCurrentUrl();
        String productId = currentUrl.substring(currentUrl.indexOf("="), currentUrl.indexOf("&")).replace("=", "");
        return productId;
    }
}
