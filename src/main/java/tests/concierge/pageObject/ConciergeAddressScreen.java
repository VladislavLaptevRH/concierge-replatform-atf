package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ConciergeAddressScreen {

    private final SelenideElement soldToTaxExempt = $(By.cssSelector("#soldToTaxExemptId"));

    private final SelenideElement shippingAddressText = $(By.xpath("//*[text() = 'Shipping Address']"));

    private final SelenideElement checkOutTitle = $(By.xpath("//h3[@class='MuiTypography-root MuiTypography-h3 MuiTypography-alignCenter']"));

    private final SelenideElement addressText = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][1]/a[1]"));

    private final SelenideElement paymentText = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][2]/p"));

    private final SelenideElement reviewText = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][3]/p"));

    private final SelenideElement confirmationText = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][4]/p"));

    private final SelenideElement billingAddressText = $(By.xpath("//*[text()='Billing Address']"));

    private final SelenideElement okButton = $(By.xpath("//*[text()='OK']"));

    private final SelenideElement billingAddressFirstName = $(By.id("billingAddress.firstName"));

    private final SelenideElement soldToAddressTitle = $(By.xpath("//*[text()='Sold To Address']"));

    private final SelenideElement billingAddressTitle = $(By.xpath("//*[text()='Billing Address']"));

    private final SelenideElement shippingAddressTitle = $(By.xpath("//*[text()='Shipping Address']"));

    private final SelenideElement editAddressButton = $(By.xpath("(//*[text()='Edit'])[1]"));

    private final SelenideElement editPaymentOrderReview = $(By.xpath("//a[@href='/us/en/checkout/payment.jsp' and text() = 'Edit']"));

    private final SelenideElement editShippingAddress = $(By.xpath("//*[text() = 'SHIPPING ADDRESS']/following-sibling::div/*[text() = 'Edit']"));

    private final SelenideElement editBillingAddress = $(By.xpath("//*[text() = 'BILLING ADDRESS']/following-sibling::div/*[text() = 'Edit']"));
}
