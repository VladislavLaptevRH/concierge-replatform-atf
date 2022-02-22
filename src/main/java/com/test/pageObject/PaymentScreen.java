package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class PaymentScreen{
    
    private SelenideElement choosePaymentMethodBtn = $(By.xpath("//div[contains(@class,'Mui')]//select[contains(@class,'MuiInputBase-input')]"));
    
    private SelenideElement selectPaymentPlan = $(By.xpath("//div[contains(@class,'MuiInputBase-fullWidth')]/select"));

    private SelenideElement rhCardNumberField = $(By.xpath("//div[contains(@class,'MuiInputBase-fullWidth MuiInputBase-formControl')]/input"));

    private SelenideElement rhCardPin = $(By.xpath("//input[@type='password']"));

    private SelenideElement creditCardPaymentPlan = $(By.xpath("//div[contains(@class,'Mui-error Mui-error')]/select"));

    private SelenideElement cardNumberField = $(By.xpath("//input[@id='encryptedCardNumber']"));;

    private SelenideElement fieldAmount = $(By.xpath("//div[contains(@class,'MuiOutlinedInput-adornedStart')]/input"));;
    
    private SelenideElement expiryDateField = $(By.xpath("//input[@id='encryptedExpiryDate']"));;
    
    private SelenideElement cvcField = $(By.xpath("//input[@id='encryptedSecurityCode']"));;
    
    private SelenideElement continueToReview = $(By.xpath("//*[text()='CONTINUE TO REVIEW']"));;
    
    private SelenideElement rhccContinueToReview = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container'][2]/button"));;
    
    private SelenideElement paymentMethodTitle = $(By.xpath("//div[contains(@class,'MuiGrid-container MuiGrid-item')]/h3[@class='MuiTypography-root MuiTypography-h3']"));;
    
    private SelenideElement splitPaymentCheckBox = $(By.xpath("//label[2]/span[@class='MuiTypography-root MuiFormControlLabel-label MuiTypography-body1']"));;
}
