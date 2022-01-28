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

    @FindBy(xpath = "//select[@id='prod20240025-qty-input']")
    private WebElement quantityButton;

    @FindBy(xpath = "//select[@id='prod20240025-qty-input']//option[3]")
    private WebElement quantityOne;

    @FindBy(xpath = "//div[1]/div[@class='MuiFormControl-root MuiFormControl-fullWidth']/button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[@id='ajax-proceed-to-cart']")
    private WebElement viewCartButton;

    @FindBy(xpath = "//div[contains(@class,'MuiGrid-root MuiGrid-container MuiGrid-item')][2]//button")
    private WebElement checkoutButton;

    @FindBy(xpath = "/html/body/div[4]/div[3]/div/div[2]/div/div[2]/div/div[2]/button")
    private WebElement closePopUpButton;

    /**
     * Constructor for initialize page object
     *
     * @param driver Web driver
     */
    public ConciergeItemsScreen(WebDriver driver) {
        super(driver);
    }
}
