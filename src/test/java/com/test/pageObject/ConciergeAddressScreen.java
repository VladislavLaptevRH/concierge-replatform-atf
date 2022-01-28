package com.test.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConciergeAddressScreen extends AbstractPage{
    @FindBy(xpath = "//h3[@class='MuiTypography-root MuiTypography-h3 MuiTypography-alignCenter']")
    private WebElement checkOutTitle;

    @FindBy(xpath = "//li[@class='MuiBreadcrumbs-li'][1]/a[1]")
    private WebElement addressText;

    @FindBy(xpath = "//li[@class='MuiBreadcrumbs-li'][2]/p")
    private WebElement paymentText;

    @FindBy(xpath = "//li[@class='MuiBreadcrumbs-li'][3]/p")
    private WebElement reviewText;

    @FindBy(xpath = "//li[@class='MuiBreadcrumbs-li'][4]/p")
    private WebElement confirmationText;

    @FindBy(xpath = "//div[1]/h3[@class='MuiTypography-root MuiTypography-h3']")
    private WebElement shippingAddressText;

    @FindBy(xpath = "//div[@id='billingAddresslbl']/h3")
    private WebElement billingAddressText;


    /**
     * Constructor for initialize page object
     *
     * @param driver Web driver
     */
    public ConciergeAddressScreen(WebDriver driver) {
        super(driver);
    }
}
