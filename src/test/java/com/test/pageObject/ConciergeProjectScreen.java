package com.test.pageObject;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ConciergeProjectScreen extends AbstractPage{
    @FindBy(xpath = "//div[1]/button[contains(@class,'MuiButton-fullWidth')]")
    private WebElement settingsButton;

    @FindBy(xpath = "//div[2]/button[contains(@class,'MuiButton-fullWidth')]")
    private WebElement forecastSetButton;

    @FindBy(xpath = "/html/body/div[3]/div/main/div/div[3]/div/div/div/div/div/div/div[2]/div/div/div[4]/div/div/div[2]/button[1]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-fullWidth']")
    private WebElement emailEstimateButton;

    @FindBy(id = "pricingTypeDropdown")
    private WebElement nonMemberButton;

    @FindBy(xpath = "//div[contains(@class,'MuiGrid-justify-xs-center')][1]/button")
    private WebElement continueButtonPopUp;

    @FindBy(xpath = "//h4[contains(@class,'MuiTypography-h4 MuiTypography-colorInherit')]")
    private WebElement projectTitle;

    /**
     * Constructor for initialize page object
     *
     * @param driver Web driver
     */
    public ConciergeProjectScreen(WebDriver driver) {
        super(driver);
    }
}
