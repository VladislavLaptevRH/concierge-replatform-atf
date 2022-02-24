package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ConfirmationOrderScreen {
    
    private final SelenideElement orderDetailsButton = $(By.xpath("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]"));

    private final SelenideElement thankYouTitle = $(By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1 MuiTypography-alignCenter']"));
    
    private final SelenideElement yourOrderHasBeenPlaced = $(By.xpath("//div[contains(@class,'MuiGrid-direction-xs-column MuiGrid-align-items-xs-center')]/h3"));
}
