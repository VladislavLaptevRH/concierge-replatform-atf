package com.test.pageObject;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter

public class ConciergeItemsScreen extends AbstractPage {
//    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-true']/div/ul//li[@class='MuiGridListTile-root']")
//    private List<WebElement> items;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-true']/div/ul//li[@class='MuiGridListTile-root']")
    private List<WebElement> items;

    @FindBy(xpath = "//li[@class='MuiGridListTile-root']")
    private List<WebElement> twoItemsInRow;

    @FindBy(xpath = "//div[1]/div[@class='MuiFormControl-root MuiFormControl-fullWidth']/button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[@id='ajax-proceed-to-cart']")
    private WebElement viewCartButton;

    @FindBy(xpath = "//div[contains(@class,'MuiGrid-root MuiGrid-container MuiGrid-item')][2]//button")
    private WebElement checkoutButton;

    @FindBy(xpath = "/html/body/div[4]/div[3]/div/div[2]/div/div[2]/div/div[2]/button")
    private WebElement closePopUpButton;

    @FindBy(xpath = "//div[contains(@class,'MuiGrid-grid-xs-12')][2]//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']")
    private WebElement addToProjectButton;

    @FindBy(xpath = "//div[2]/button[contains(@class,'MuiButton-containedPrimary MuiButton-fullWidth')]")
    private WebElement saveProjectPopUpButton;

    @FindBy(xpath = "/h3[@class='MuiTypography-root MuiTypography-h3']")
    private WebElement addedIttemToProjectTitle;

    @FindBy(xpath = "//div[2]/button[contains(@class,'MuiButtonBase-root MuiButton-root')]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//a[contains(@class,'MuiTypography-colorPrimary')]//button")
    private WebElement goToProjectButton;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']//h3[@class='MuiTypography-root MuiTypography-h3']")
    private WebElement addToProjectTitleSelect;

    @FindBy(xpath = "//select[@id='opportunityName']")
    private WebElement opportunityNameSelect;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-12 MuiGrid-grid-md-12'][3]//select")
    private WebElement spaceNameSelect;

    /**
     * Constructor for initialize page object
     *
     * @param driver Web driver
     */
    public ConciergeItemsScreen(WebDriver driver) {
        super(driver);
    }
}
