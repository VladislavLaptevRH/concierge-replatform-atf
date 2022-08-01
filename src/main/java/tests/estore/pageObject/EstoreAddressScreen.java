package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstoreAddressScreen {

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

    private final SelenideElement soldToAddressTitle = $(By.xpath("//*[text()='Sold To Address']"));

    private final SelenideElement billingAddressTitle = $(By.xpath("//*[text()='Billing Address']"));

    private final SelenideElement sameAsShippingCheckbox = $(By.xpath("(//input[@type='checkbox'])[1]"));

    private final SelenideElement shippingAddressTitle = $(By.xpath("//*[text()='Shipping Address']"));

    private final SelenideElement editPaymentOrderReview = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item']/a)[2]"));

    private final SelenideElement editShippingAddress = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-align-items-xs-center']/a)[1]"));

    private final SelenideElement editBillingAddress = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-align-items-xs-center']/a)[2]"));
}
