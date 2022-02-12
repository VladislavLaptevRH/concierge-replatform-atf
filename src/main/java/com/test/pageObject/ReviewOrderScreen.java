package com.test.pageObject;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ReviewOrderScreen extends AbstractPage{
    @FindBy(xpath = "//button[contains(@class,'MuiButton-contained MuiButton-containedPrimary')]")
    private WebElement placeOrderButton;

    @FindBy(xpath = "(//h3[contains(@class,'MuiTypography-root MuiTypography-h3')])[3]")
    private WebElement shippingAddress;

    @FindBy(xpath = "(//h3[contains(@class,'MuiTypography-root MuiTypography-h3')])[4]")
    private WebElement billingAddress;

    /**
     * Constructor for initialize page object
     *
     * @param driver Web driver
     */
    public ReviewOrderScreen(WebDriver driver) {
        super(driver);
    }
}
