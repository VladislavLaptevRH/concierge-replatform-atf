package com.test.pageObject;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class PaymentScreen extends AbstractPage{
    @FindBy(xpath = "//div[contains(@class,'Mui')]//select[contains(@class,'MuiInputBase-input')]")
    private WebElement choosePaymentMethodBtn;

    @FindBy(xpath = "//input[@id='encryptedCardNumber']")
    private WebElement cardNumberField;

    @FindBy(xpath = "//input[@id='encryptedExpiryDate']")
    private WebElement expiryDateField;

    @FindBy(xpath = "//input[@id='encryptedSecurityCode']")
    private WebElement cvcField;

    @FindBy(xpath = "//button[contains(@class, 'MuiButton-containedPrimary')]")
    private WebElement continueToReview;

    @FindBy(xpath = "//div[contains(@class,'MuiGrid-container MuiGrid-item')]/h3[@class='MuiTypography-root MuiTypography-h3']")
    private WebElement paymentMethodTitle;

    /**
     * Constructor for initialize page object
     *
     * @param driver Web driver
     */
    public PaymentScreen(WebDriver driver) {
        super(driver);
    }
}
