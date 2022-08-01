package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


@Getter
public class CheckoutAddressScreen {

    private final SelenideElement firstNameBillingAddress = $(By.id("billingAddress.firstName"));

    private final SelenideElement firstNameInpt = $(By.xpath("//input[contains(@id,'firstName')and contains(@id,'shipping')]"));

    private final SelenideElement lastNameField = $(By.xpath("//form[@class='MuiGrid-root MuiGrid-container']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-justify-xs-center']/div[1]/div[1]/div[2]/div/input"));

    private final SelenideElement companyNameField = $(By.xpath("//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input"));

    private final SelenideElement streetAddressField = $(By.xpath("//form[@class='MuiGrid-root MuiGrid-container']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-justify-xs-center']/div[1]/div[1]/div[5]/div/input"));

    private final SelenideElement aptFloorSuiteField = $(By.xpath("//form[@class='MuiGrid-root MuiGrid-container']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-justify-xs-center']/div[1]/div[1]/div[6]/div/input"));

    private final SelenideElement cityField = $(By.xpath("//form[@class='MuiGrid-root MuiGrid-container']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-justify-xs-center']/div[1]/div[1]/div[7]/div/input"));

    private final SelenideElement stateField = $(By.xpath("(//div[contains(@class,'Mui')]//select[contains(@class,'Mui')])[2]"));

    private final SelenideElement countryField = $(By.xpath("(//div[contains(@class,'Mui')]//select[contains(@class,'Mui')])[1]"));

    private final SelenideElement zipPostalCodeField = $(By.xpath("//input[@id='shippingAddress.postalCode']"));

    private final SelenideElement phoneField = $(By.cssSelector("div:nth-child(2) > div:nth-child(9) > div:nth-child(2) > input:nth-child(1)"));

    private final SelenideElement eveningPhone = $(By.xpath("/input[@id='37']"));

    private final SelenideElement billingAddressAsShippingCheckBox = $(By.xpath("(//input[@type='checkbox'])[1]"));

    private final SelenideElement continuePaymentButton = $(By.xpath("//button[contains(@class,'MuiButton-contained')]"));

    private final SelenideElement continueButton = $(By.xpath("(//button[contains(@class,'MuiButton-containedPrimary')])[2]"));

}
