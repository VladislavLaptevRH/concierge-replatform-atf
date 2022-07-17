package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstorePaymentScreen {
    private final SelenideElement editBillingAddressBtn = $(By.xpath("//a[@class='MuiTypography-root MuiLink-root MuiLink-underlineAlways MuiTypography-body1 MuiTypography-colorPrimary']"));

    private final SelenideElement removePaymentBtn = $(By.xpath("//a[@class='MuiTypography-root MuiLink-root MuiLink-underlineAlways MuiTypography-caption MuiTypography-colorPrimary']"));

    private final SelenideElement choosePaymentMethodBtn = $(By.xpath("//div[contains(@class,'Mui')]//select[contains(@class,'MuiInputBase-input')]"));

    private final SelenideElement selectPaymentPlan = $(By.xpath("//div[contains(@class,'MuiInputBase-fullWidth')]/select"));

    private final SelenideElement rhCardNumberField = $(By.xpath("//div[contains(@class,'MuiInputBase-fullWidth MuiInputBase-formControl')]/input"));

    private final SelenideElement rhCardPin = $(By.xpath("//input[@type='password']"));

    private final SelenideElement creditCardPaymentPlan = $(By.xpath("//div[contains(@class,'Mui-error Mui-error')]/select"));

    private final SelenideElement cardNumberField = $(By.xpath("//input[@id='encryptedCardNumber']"));

    private final SelenideElement fieldAmount = $(By.xpath("//div[contains(@class,'MuiOutlinedInput-adornedStart')]/input"));

    private final SelenideElement expiryDateField = $(By.xpath("//input[@id='encryptedExpiryDate']"));

    private final SelenideElement billingAddress = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-direction-xs-column MuiGrid-align-items-xs-flex-start']"));

    private final SelenideElement cvcField = $(By.xpath("//input[@id='encryptedSecurityCode']"));

    private final SelenideElement continueToReview = $(By.xpath("//*[text()='CONTINUE TO REVIEW']"));

    private final SelenideElement rhccContinueToReview = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container'][2]/button"));

    private final SelenideElement paymentMethodTitle = $(By.xpath("//div[contains(@class,'MuiGrid-container MuiGrid-item')]/h3[@class='MuiTypography-root MuiTypography-h3']"));

    private final SelenideElement splitPaymentCheckBox = $(By.xpath("//label[2]/span[@class='MuiTypography-root MuiFormControlLabel-label MuiTypography-body1']"));
}
