package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstoreAddressScreen {

    private final SelenideElement shippingAddressfirstName = $(By.id("shippingAddress.firstName"));

    private final SelenideElement shippingAddresslastName = $(By.id("shippingAddress.lastName"));

    private final SelenideElement shippingAddressStreetAddress = $(By.xpath("//input[@id='shippingAddress.addressLine1']"));

    private final SelenideElement shippingAddressAptFloor = $(By.id("shippingAddress.addressLine2"));

    private final SelenideElement shippingAddressCity = $(By.id("shippingAddress.city"));

    private final SelenideElement shippingAddressPhone = $(By.id("shippingAddress.phone"));

    private final SelenideElement shippingAddressEmail = $(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[9]"));

    private final SelenideElement shippingAddressConfirmEmail = $(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[10]"));

    private final SelenideElement submitZipCode = $(By.xpath("(//button[@type='submit'])[3]"));

    private final SelenideElement emailField = $(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[9]"));

    private final SelenideElement confirmEmail = $(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[10]"));

    private final SelenideElement editShippinggAddress = $(By.xpath("(//*[text()='Edit'])[1]"));

    private final SelenideElement shippingAddressState = $(By.xpath("//select[@id='shippingAddress.state']"));

    private final SelenideElement abState = $(By.xpath("//option[@value='AB']"));

    private final SelenideElement postalShippingCode = $(By.xpath("//input[@id='shippingAddress.postalCode']"));

    private final SelenideElement countrySelect = $(By.xpath("//select[@id='shippingAddress.country']"));

    private final SelenideElement canadaCountry = $(By.xpath("//select[@id='shippingAddress.country']//option[@value='CA']"));

    private final SelenideElement enterZipCodeBtn = $(By.xpath("(//span[@style='text-decoration: underline; cursor: pointer;'])[2]"));

    private final SelenideElement soldToTaxExempt = $(By.cssSelector("#soldToTaxExemptId"));

    private final SelenideElement shippingAddressText = $(By.xpath("(//h3[@class='MuiTypography-root MuiTypography-h3'])[1]"));

    private final SelenideElement checkOutTitle = $(By.xpath("//h3[@class='MuiTypography-root MuiTypography-h3 MuiTypography-alignCenter']"));

    private final SelenideElement addressText = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][1]/a[1]"));

    private final SelenideElement paymentText = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][2]/p"));

    private final SelenideElement reviewText = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][3]/p"));

    private final SelenideElement confirmationText = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][4]/p"));

    private final SelenideElement billingAddressText = $(By.xpath("//div[@id='billingAddresslbl']/h3"));

    private final SelenideElement okButton = $(By.xpath("//*[text()='OK']"));

    private final SelenideElement billingAddressFirstName = $(By.id("billingAddress.firstName"));

    private final SelenideElement addressCard = $(By.id("my-account-address-card"));

    private final SelenideElement soldToAddressTitle = $(By.xpath("//*[text()='Sold To Address']"));

    private final SelenideElement billingAddressTitle = $(By.xpath("//*[text()='Billing Address']"));

    private final SelenideElement sameAsShippingCheckbox = $(By.xpath("(//input[@type='checkbox'])[1]"));

    private final SelenideElement shippingAddressTitle = $(By.xpath("//*[text()='Shipping Address']"));

    private final SelenideElement editPaymentOrderReview = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item']/a)[2]"));

    private final SelenideElement editBillingAddress = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-align-items-xs-center']/a)[2]"));
}
