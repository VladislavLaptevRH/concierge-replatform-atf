package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


@Getter
public class EstoreCheckoutAddressScreen {

    private final SelenideElement deleteFirstShippingAddress = $(By.xpath("(//*[text()='Delete'])[1]"));

    private final SelenideElement continueAsGuestButton = $(By.xpath("(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary'])[3]"));

    private final SelenideElement firstNameBillingAddress = $(By.id("billingAddress.firstName"));

    private final SelenideElement firstNameInpt = $(By.xpath("//input[contains(@id,'firstName')and contains(@id,'shipping')]"));

    private final SelenideElement lastNameField = $(By.xpath("//input[@id='shippingAddress.lastName']"));

    private final SelenideElement companyNameField = $(By.xpath("//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input"));

    private final SelenideElement streetAddressField = $(By.xpath("//input[@id='shippingAddress.addressLine1']"));

    private final SelenideElement aptFloorSuiteField = $(By.xpath("//input[@id='shippingAddress.addressLine2']"));

    private final SelenideElement cityField = $(By.xpath("//input[@id='shippingAddress.city']"));

    private final SelenideElement stateField = $(By.xpath("(//div[contains(@class,'Mui')]//select[contains(@class,'Mui')])[2]"));

    private final SelenideElement countryField = $(By.xpath("(//div[contains(@class,'Mui')]//select[contains(@class,'Mui')])[1]"));

    private final SelenideElement zipPostalCodeField = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-direction-xs-column MuiGrid-grid-xs-12 MuiGrid-grid-sm-7 MuiGrid-grid-md-5 MuiGrid-grid-xl-6'][1]/div[1]/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4']/div/div/input"));

    private final SelenideElement phoneField = $(By.xpath("//input[@id='shippingAddress.phone']"));

    private final SelenideElement eveningPhone = $(By.xpath("/input[@id='37']"));

    private final SelenideElement billingAddressAsShippingCheckBox = $(By.cssSelector("div[class='MuiGrid-root MuiGrid-item'] input[type='checkbox']"));

    private final SelenideElement continuePaymentButton = $(By.xpath("//span[@class='MuiButton-label' and text() = 'CONTINUE']"));

    private final SelenideElement continueButton = $(By.xpath("(//button[contains(@class,'MuiButton-containedPrimary')])[2]"));

}
