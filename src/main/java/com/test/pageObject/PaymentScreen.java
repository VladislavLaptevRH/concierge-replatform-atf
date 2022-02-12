package com.test.pageObject;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class PaymentScreen extends AbstractPage{
    @FindBy(xpath = "//div[contains(@class,'Mui')]//select[contains(@class,'MuiInputBase-input')]")
    private WebElement choosePaymentMethodBtn;

    @FindBy(xpath = "//div[contains(@class,'MuiInputBase-fullWidth')]/select")
    private WebElement selectPaymentPlan;

    @FindBy(xpath = "//div[contains(@class,'MuiInputBase-fullWidth MuiInputBase-formControl')]/input")
    private WebElement rhCardNumberField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement rhCardPin;

    @FindBy(xpath = "//div[contains(@class,'Mui-error Mui-error')]/select")
    private WebElement creditCardPaymentPlan;

    @FindBy(xpath = "//input[@id='encryptedCardNumber']")
    private WebElement cardNumberField;

    @FindBy(xpath = "//div[contains(@class,'MuiOutlinedInput-adornedStart')]/input")
    private WebElement fieldAmount;

    @FindBy(xpath = "//input[@id='encryptedExpiryDate']")
    private WebElement expiryDateField;

    @FindBy(xpath = "//input[@id='encryptedSecurityCode']")
    private WebElement cvcField;

    @FindBy(xpath = "//button[contains(@class, 'MuiButton-containedPrimary')]")
    private WebElement continueToReview;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container'][2]/button")
    private WebElement rhccContinueToReview;

    @FindBy(xpath = "//div[contains(@class,'MuiGrid-container MuiGrid-item')]/h3[@class='MuiTypography-root MuiTypography-h3']")
    private WebElement paymentMethodTitle;

    @FindBy(xpath = "//label[2]/span[@class='MuiTypography-root MuiFormControlLabel-label MuiTypography-body1']")
    private WebElement splitPaymentCheckBox;

    /**
     * Constructor for initialize page object
     *
     * @param driver Web driver
     */
    public PaymentScreen(WebDriver driver) {
        super(driver);
    }
}
