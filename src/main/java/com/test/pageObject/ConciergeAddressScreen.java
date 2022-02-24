package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ConciergeAddressScreen{
    private final SelenideElement checkOutTitle = $(By.xpath("//h3[@class='MuiTypography-root MuiTypography-h3 MuiTypography-alignCenter']"));

    private final SelenideElement addressText = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][1]/a[1]"));

    private final SelenideElement paymentText = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][2]/p"));

    private final SelenideElement reviewText = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][3]/p"));

    private final SelenideElement confirmationText = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][4]/p"));

    private final SelenideElement shippingAddressText = $(By.xpath("//div[1]/h3[@class='MuiTypography-root MuiTypography-h3']"));

    private final SelenideElement billingAddressText = $(By.xpath("//div[@id='billingAddresslbl']/h3"));

}
