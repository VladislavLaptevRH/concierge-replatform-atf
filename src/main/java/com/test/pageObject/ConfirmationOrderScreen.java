package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ConfirmationOrderScreen {
    
    private SelenideElement orderDetailsButton = $(By.xpath("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]"));

    
    private SelenideElement thankYouTitle = $(By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1 MuiTypography-alignCenter']"));

    
    private SelenideElement yourOrderHasBeenPlaced = $(By.xpath("//div[contains(@class,'MuiGrid-direction-xs-column MuiGrid-align-items-xs-center')]/h3"));
}
