package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


@Getter
public class CheckoutAddressScreen {

    private final SelenideElement orderDetailsButton = $(By.xpath("//*[contains( text(), 'View Order Details')]"));
    private final SelenideElement billingAddressCheckbox = $(By.xpath("(//*[@id ='billingAddresslbl']//label)[1]"));
    private final SelenideElement shippingAddressCountryDisabled = $(By.xpath("//*[@id = 'address-country-select'][@disabled]"));
    private final SelenideElement firstNameBillingAddress = $(By.xpath("//div[@id='billingAddresslbl']/descendant::input[@id='billingAddress.firstName']"));
    private final SelenideElement lastNameBillingAddress = $(By.xpath("//div[@id='billingAddresslbl']/descendant::input[@id='address-last-name-field']"));
    private final SelenideElement companyNameBillingAddress = $(By.xpath("//div[@id='billingAddresslbl']/descendant::input[@id='address-company-name-field']"));
    private final SelenideElement addressLine1BillingAddress = $(By.xpath("//div[@id='billingAddresslbl']/descendant::input[@id='billingAddress.addressLine1']"));
    private final SelenideElement addressLine2BillingAddress = $(By.xpath("//div[@id='billingAddresslbl']/descendant::input[@id='address-address-line-2']"));
    private final SelenideElement phoneBillingAddress = $(By.xpath("//div[@id='billingAddresslbl']/descendant::input[@id='address-phone-field']"));
    private final SelenideElement cityFieldBillingAddress = $(By.xpath("//div[@id='billingAddresslbl']/descendant::input[@id='address-city-field']"));
    private final SelenideElement emailAddressField = $(By.xpath("//label[text() = 'Email address']/following-sibling::div/input"));
    private final SelenideElement confirmEmailAddressField = $(By.xpath("//label[text() = 'Confirm email']/following-sibling::div/input"));

    private final SelenideElement checkoutAddressPopUpHeader = $(By.id("//*[text() = 'We are unable to verify your Shipping Address']"));

    private final SelenideElement firstNameInpt = $(By.xpath("//input[@id = 'shippingAddress.firstName']"));
    private final SelenideElement firstNameInptUpperCase = $(By.xpath("//*[text() = 'SHIPPING ADDRESS']/..//*[text() = 'First Name']/..//input"));
    private final SelenideElement tryAgainButton = $(By.xpath("//*[text() = 'TRY AGAIN']"));
    private final SelenideElement lastNameField = $(By.xpath("//input[@id = 'address-last-name-field']"));

    private final SelenideElement lastNameFieldUpperCase = $(By.xpath("//*[text() = 'SHIPPING ADDRESS']/..//*[text() = 'Last Name']/..//input"));

    private final SelenideElement companyNameField = $(By.xpath("//input[@id = 'address-company-name-field']"));
    private final SelenideElement companyNameFieldNew = $(By.xpath("//*[text() = 'Shipping Address']/..//*[text() = 'Company Name']/..//input"));

    private final SelenideElement companyNameFieldNewUserService = $(By.xpath("//*[text() = 'Shipping Address']/..//*[text() = 'Company Name (optional)']/..//input"));

    private final SelenideElement streetAddressField = $(By.xpath("//input[@id = 'shippingAddress.addressLine1']"));

    private final SelenideElement streetAddressFieldSold = $(By.xpath("//input[@id = 'soldToAddress.addressLine1']"));

    private final SelenideElement firstStreetAddress = $(By.xpath("(//li[contains(text(), 'North 16th Street')])[1]"));

    private final SelenideElement streetAddressFirstResult = $(By.xpath("//input[@id = 'shippingAddress.addressLine1']"));


    private final SelenideElement aptFloorSuiteField = $(By.xpath("//input[@id = 'address-address-line-2']"));

    private final SelenideElement cityField = $(By.xpath("//input[@id = 'address-city-field']"));

    private final SelenideElement stateField = $(By.xpath("(//div[contains(@class,'Mui')]//select[contains(@class,'Mui')])[2]"));

    private final SelenideElement countryField = $(By.xpath("(//div[contains(@class,'Mui')]//select[contains(@class,'Mui')])[1]"));

    private final SelenideElement zipPostalCodeField =  $(By.xpath("//input[@id = 'address-postal-code-field']"));

    private final SelenideElement zipPostalCodeFieldUpperCase =  $(By.xpath("//*[text() = 'SHIPPING ADDRESS']/..//*[text() = 'Zip/Postal Code']/..//input"));

    private final SelenideElement verifyingShippingAddressPage =  $(By.xpath("//*[text()='We are unable to verify your Shipping Address']"));

    private final SelenideElement verifyingBillingAddressPage =  $(By.xpath("//*[text()='We are unable to verify your Billing Address']"));

    private final SelenideElement phoneField = $(By.xpath("//input[@id = 'address-phone-field']"));

    private final SelenideElement eveningPhone = $(By.xpath("//*[text() = 'Shipping Address']/..//*[text() = 'Evening Phone (Optional)']/..//input"));

    private final SelenideElement billingAddressAsShippingCheckBox = $(By.xpath("//input[@id = 'billing-shipping-address-same-checkbox']"));

    private final SelenideElement continuePaymentButton = $(By.xpath("//button[contains(@class,'MuiButton-contained')]"));

    private final SelenideElement continueButton = $(By.xpath("(//button[contains(@class,'MuiButton-containedPrimary')])[2]"));

    private final SelenideElement confirmEditedAddress = $(By.xpath("//*[text() = 'CONTINUE']"));
}
