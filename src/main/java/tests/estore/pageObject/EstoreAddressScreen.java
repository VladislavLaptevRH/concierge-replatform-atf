package tests.estore.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.concierge.stepdefinitions.GeneralStepDefs;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

@Getter
public class EstoreAddressScreen {

    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    private final SelenideElement shippingAddressCountry = $(By.xpath("//*[@id = 'shippingAddress.country']"));

    private final SelenideElement shippingAddressCountryDisabled = $(By.xpath("//*[@id = 'shippingAddress.country'][@disabled]"));

    private final SelenideElement shippingAddressFirstName = $(By.id("shippingAddress.firstName"));

    private final SelenideElement shippingAddressLastName = $(By.id("shippingAddress.lastName"));

    private final SelenideElement shippingAddressStreetAddress = $(By.id("addressLine1"));

    private final SelenideElement shippingAddressLastName1 = $(By.id("shippingAddress.lastName"));

    private final SelenideElement shippingAddressStreetAddress1 = $(By.id("shippingAddress.addressLine1"));

    private final SelenideElement shippingAddressStreetAddressStg2 = $(By.xpath("//input[@data-testid='shippingAddress.addressLine1']"));

    private final SelenideElement shippingAddressAddStreetField = $(By.xpath("//input[@data-testid='addressLine1']"));

    private final SelenideElement shippingAddressAptFloor = $(By.id("shippingAddress.addressLine2"));

    private final SelenideElement shippingAddressCity = $(By.id("shippingAddress.city"));

    private final SelenideElement cityAddNewCard = $(By.id("city"));

    private final SelenideElement stateAddNewCard = $(By.id("state"));

    private final SelenideElement postalCodeAddNewCard = $(By.id("postalCode"));

    private final SelenideElement shippingAddressPhone = $(By.id("shippingAddress.phone"));

    private final SelenideElement shippingAddressEmail = $(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[8]"));

    private final SelenideElement shippingAddressConfirmEmail = $(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[9]"));

    private final SelenideElement submitZipCode = $(By.xpath("//*[text()='CONFIRM']"));

    private final SelenideElement emailField = $(By.xpath("((//div[contains(@class,'MuiGrid-align-items-xs-flex-start')])[1]//input)[1]"));

    private final SelenideElement confirmEmail = $(By.xpath("((//div[contains(@class,'MuiGrid-align-items-xs-flex-start')])[1]//input)[2]"));

    private final SelenideElement editShippinggAddress = $(By.xpath("(//*[text()='Edit'])[1]"));

    private final SelenideElement shippingAddressState = $(By.xpath("//select[@id='shippingAddress.state']"));

    private final SelenideElement abState = $(By.xpath("//option[@value='AB']"));

    private final SelenideElement postalShippingCode = $(By.xpath("//input[@id='shippingAddress.postalCode']"));

    private final SelenideElement countrySelect = $(By.xpath("//select[@id='shippingAddress.country']"));

    private final SelenideElement stateSelect = $(By.xpath("//select[@id='shippingAddress.state']"));

    private final SelenideElement state = $(By.xpath("//*[text() = 'AZ - Arizona']"));

    private final SelenideElement canadaCountry = $(By.xpath("//select[@id='shippingAddress.country']//option[@value='CA']"));

    private final SelenideElement enterZipCodeBtn = $(By.xpath("//div[@id='component-order-summary']//span"));

    private final SelenideElement soldToTaxExempt = $(By.cssSelector("#soldToTaxExemptId"));

    private final SelenideElement shippingAddressText = $(By.xpath("(//h3[@class='MuiTypography-root MuiTypography-h3'])[1]"));

    private final SelenideElement checkOutTitle = $(By.xpath("//h3[@class='MuiTypography-root MuiTypography-h3 MuiTypography-alignCenter']"));

    private final SelenideElement addressText = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][1]/a[1]"));

    private final SelenideElement paymentText = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][2]/p"));

    private final SelenideElement reviewText = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][3]/p"));

    private final SelenideElement continueToPayment = $(By.xpath("//*[text() = 'Continue to payment']"));

    private final SelenideElement continuePayment = $(By.xpath("//*[text() = 'CONTINUE']"));

    private final SelenideElement confirmationText = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][4]/p"));

    private final SelenideElement billingAddressText = $(By.xpath("//div[@id='billingAddresslbl']/h3"));

    private final SelenideElement okButton = $(By.xpath("//*[text()='OK']"));

    private final SelenideElement billingAddressFirstName = $(By.id("billingAddress.firstName"));

    private final SelenideElement billingAddressFirstNameNew = $(By.xpath("//input[@id = 'billingAddress.firstName']"));

    private final SelenideElement billingAddressLastName = $(By.id("billingAddress.lastName"));

    private final SelenideElement billingAddressStreetAddress = $(By.xpath("//*[@data-testid='billingAddress.addressLine1']"));

    private final SelenideElement billingAddressAptFloorSuite = $(By.xpath("//*[@data-testid='billingAddress.addressLine2']"));

    private final SelenideElement billingAddressCity = $(By.id("billingAddress.city"));

    private final SelenideElement billingAddressState = $(By.id("billingAddress.state"));

    private final SelenideElement billingAddressPhone = $(By.id("billingAddress.phone"));

    private final SelenideElement billingAddressPostlaCode = $(By.id("billingAddress.postalCode"));

    private final SelenideElement addressCard = $(By.id("my-account-address-card"));

    private final SelenideElement soldToAddressTitle = $(By.xpath("//*[text()='Sold To Address']"));

    private final SelenideElement billingAddressTitle = $(By.xpath("//*[text()='Billing Address']"));

    private final SelenideElement sameAsShippingCheckbox = $(By.xpath("(//input[@type='checkbox'])[1]"));

    private final SelenideElement shippingAddressTitle = $(By.xpath("//*[text()='Shipping Address']"));

    private final SelenideElement editPaymentOrderReview = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item']/a)[2]"));

    private final SelenideElement editBillingAddress = $(By.xpath("//*[text() = 'Edit']"));

    private final SelenideElement editBillingAddressNew = $(By.xpath("//*[text() = 'Billing Address']/..//*[text() = 'Edit']"));

    private final SelenideElement addGiftMessageBtn = $(By.xpath("//*[@id='giftMessage']//div"));
    private final SelenideElement orderDescriptionBtn = $(By.xpath("(//*[@id='giftMessage']//*[@class='MuiGrid-root MuiGrid-container MuiGrid-item'])[2]"));

    private final SelenideElement inputForTheFirstGiftMessage = $(By.xpath("(//*[@class='MuiCollapse-container MuiCollapse-entered']//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[1]"));

    private final SelenideElement inputForTheFirstOrderDescriptionMessage = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-item']//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[4]"));

    private final SelenideElement sameAsShippingAddress = $(By.xpath("//span[text()='Same as shipping address']"));
    public void clickToAddGiftMessageButton() {
        addGiftMessageBtn.should(Condition.interactable,
                Duration.ofSeconds(15)).click();
    }

    public void clickToOrderDescriptionButton() {
        orderDescriptionBtn.should(Condition.interactable,
                Duration.ofSeconds(15)).click();
    }

    public void introduceOrderDescriptionMessage(String message) {
        inputForTheFirstOrderDescriptionMessage.should(Condition.interactable,
                Duration.ofSeconds(15)).click();
        generalStepDefs.clearField(inputForTheFirstOrderDescriptionMessage);
        inputForTheFirstOrderDescriptionMessage.should(Condition.interactable,
                Duration.ofSeconds(15)).setValue(message);
    }

    public void introduceTheFirstGiftMessage(String giftMessage) {
        inputForTheFirstGiftMessage.should(Condition.interactable,
                Duration.ofSeconds(15)).click();
        generalStepDefs.clearField(inputForTheFirstGiftMessage);

        sleep(1000);
        inputForTheFirstGiftMessage.should(Condition.interactable,
                Duration.ofSeconds(15)).click();
        inputForTheFirstGiftMessage.should(Condition.interactable,
                Duration.ofSeconds(15)).setValue(giftMessage);
    }

    public void selectAddressState(String state) {
        shippingAddressState.should(Condition.and("Visible, interactable", Condition.visible, Condition.interactable), Duration.ofSeconds(25));
        Select selectAddressState = new Select(shippingAddressState);
        selectAddressState.selectByValue(state);
    }

    public void introducePostalCode(String postalCode) {
        postalShippingCode.should(Condition.and("Visible, interactable", Condition.visible, Condition.interactable), Duration.ofSeconds(25));
        generalStepDefs.clearField(postalShippingCode);
        postalShippingCode.sendKeys(postalCode);
    }

}


