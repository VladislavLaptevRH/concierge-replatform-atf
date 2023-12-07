package tests.estore.pageObject;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstorePaymentPage {

    private final SelenideElement rhCreditCardNumberField = $(By.xpath("//label[text()='Card Number']/..//input"));

    private final SelenideElement selectAPaymentPlanRhCreditCard = $(By.xpath("//label[text()='Select a Payment Plan']/..//select"));

    private final SelenideElement editBillingAddressBtn = $(By.xpath("//*[@data-analytics-id='link' and text()='EDIT']"));

    private final SelenideElement removePaymentBtn = $(By.xpath("//a[@class='MuiTypography-root MuiLink-root MuiLink-underlineAlways MuiTypography-caption MuiTypography-colorPrimary']"));

    private final SelenideElement choosePaymentMethodBtn = $(By.xpath("//div[contains(@class,'Mui')]//select[contains(@class,'MuiInputBase-input')]"));

    private final SelenideElement selectPaymentPlan = $(By.xpath("//div[contains(@class,'MuiInputBase-fullWidth')]/select"));

    private final SelenideElement rhCardNumberField = $(By.xpath("//div[contains(@class,'MuiInputBase-fullWidth MuiInputBase-formControl')]/input"));

    private final SelenideElement rhCardPin = $(By.xpath("//input[@type='password']"));

    private final SelenideElement rhCreditCardPaymentOption = $(By.xpath("//option[@value='RH']"));

    private final SelenideElement creditCardPaymentPlan = $(By.xpath("//div[contains(@class,'Mui-error Mui-error')]/select"));

    private final SelenideElement cardNumberField = $(By.xpath("//input[@data-fieldtype='encryptedCardNumber']"));

    private final SelenideElement fieldAmount = $(By.xpath("//div[contains(@class,'MuiOutlinedInput-adornedStart')]/input"));

    private final SelenideElement expiryDateField = $(By.xpath("//input[@data-fieldtype='encryptedExpiryDate']"));

    private final SelenideElement billingAddress = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-direction-xs-column MuiGrid-align-items-xs-flex-start']"));

    private final SelenideElement cvcField = $(By.xpath("//input[@data-fieldtype='encryptedSecurityCode']"));

    private final SelenideElement continueToReview = $(By.xpath("//*[text()='CONTINUE TO REVIEW']"));

    private final SelenideElement continueToPayment = $(By.cssSelector("#page-checkout-address_continue-to-payment-btn"));

    private final SelenideElement continueToCheckout = $(By.xpath("//*[text()='CONTINUE']"));

    private final SelenideElement rhccContinueToReview = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container'][2]/button"));

    private final SelenideElement paymentMethodTitle = $(By.xpath("//div[contains(@class,'MuiGrid-container MuiGrid-item')]/h3[@class='MuiTypography-root MuiTypography-h3']"));

    private final SelenideElement splitPaymentCheckBox = $(By.xpath("//input[@id='page-checkout-payment_split-payment']"));

    private final SelenideElement selectPaymentType = $(By.cssSelector("select[id=\"page-checkout-payment_select-payment-method\"]"));

    public void verifyThatNewBillingAddressisDisplayed() {
        $(By.xpath("//*[text()='John Ivanov']")).should(Condition.visible);
        $(By.xpath("//*[text()='66 Ceres St']")).should(Condition.visible);
        $(By.xpath("//*[text()='San Francisco, CA, 94124']")).should(Condition.visible);
        $(By.xpath("//*[text()='4158224747']")).should(Condition.visible);
    }


    public void selectRhCreditCardPaymentPlan() {
        Select rhCreditCard = new Select(selectAPaymentPlanRhCreditCard);
        rhCreditCard.selectByValue("41714");
    }

    public void clickToSplitPaymentCheckBox() {
        $(By.xpath("//span[text()='Split Payment with Additional Cards']")).
                should(Condition.visible, Duration.ofSeconds(45));

        splitPaymentCheckBox.click(ClickOptions.usingJavaScript());
    }

}


