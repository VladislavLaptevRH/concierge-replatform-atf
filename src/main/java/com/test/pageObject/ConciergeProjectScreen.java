package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ConciergeProjectScreen {

    private SelenideElement settingsButton = $(By.xpath("//div[1]/button[contains(@class,'MuiButton-fullWidth')]"));

    private SelenideElement forecastSetButton = $(By.xpath("//div[2]/button[contains(@class,'MuiButton-fullWidth')]"));

    private SelenideElement addToCartButton = $(By.xpath("/html/body/div[3]/div/main/div/div[3]/div/div/div/div/div/div/div[2]/div/div/div[4]/div/div/div[2]/button[1]"));

    private SelenideElement emailEstimateButton = $(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-fullWidth']"));

    private SelenideElement nonMemberButton = $(By.id("pricingTypeDropdown"));

    private SelenideElement continueButtonPopUp = $(By.xpath("//div[contains(@class,'MuiGrid-justify-xs-center')][1]/button"));

    private SelenideElement projectTitle = $(By.xpath("//h4[contains(@class,'MuiTypography-h4 MuiTypography-colorInherit')]"));

}
