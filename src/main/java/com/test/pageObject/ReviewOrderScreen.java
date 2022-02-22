package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ReviewOrderScreen{
    
    private SelenideElement placeOrderButton = $(By.xpath("//button[contains(@class,'MuiButton-contained MuiButton-containedPrimary')]"));

    private SelenideElement shippingAddress = $(By.xpath("(//h3[contains(@class,'MuiTypography-root MuiTypography-h3')])[3]"));
    
    private SelenideElement billingAddress = $(By.xpath("(//h3[contains(@class,'MuiTypography-root MuiTypography-h3')])[4]"));

}
