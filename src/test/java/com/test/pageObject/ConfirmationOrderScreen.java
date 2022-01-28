package com.test.pageObject;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ConfirmationOrderScreen extends AbstractPage{
    @FindBy(xpath = "//button[contains(@class,'MuiButtonBase-root MuiButton-root')]")
    private WebElement orderDetailsButton;

    @FindBy(xpath = "//h1[@class='MuiTypography-root MuiTypography-h1 MuiTypography-alignCenter']")
    private WebElement thankYouTitle;

    @FindBy(xpath = "//div[contains(@class,'MuiGrid-direction-xs-column MuiGrid-align-items-xs-center')]/h3")
    private WebElement yourOrderHasBeenPlaced;



    /**
     * Constructor for initialize page object
     *
     * @param driver Web driver
     */
    public ConfirmationOrderScreen(WebDriver driver) {
        super(driver);
    }
}
