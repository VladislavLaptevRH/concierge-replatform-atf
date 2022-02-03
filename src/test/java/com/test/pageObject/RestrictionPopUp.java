package com.test.pageObject;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class RestrictionPopUp extends AbstractPage{

    @FindBy(xpath = "//h2[@class='MuiTypography-root MuiTypography-h2']")
    private WebElement shippingRestricitonsTitle;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-12 MuiGrid-grid-md-12'][2]")
    private WebElement restrictionsMessage;

    @FindBy(xpath = "//div[contains(@class,'MuiGrid-root MuiGrid-item')][1]/button")
    private WebElement viewCartButton;

    @FindBy(xpath = "//div[contains(@class,'MuiGrid-root MuiGrid-item')][2]/button")
    private WebElement editCartButton;

    /**
     * Constructor for initialize page object
     *
     * @param driver Web driver
     */
    public RestrictionPopUp(WebDriver driver) {
        super(driver);
    }
}
