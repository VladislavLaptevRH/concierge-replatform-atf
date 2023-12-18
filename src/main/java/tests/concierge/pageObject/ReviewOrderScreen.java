package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ReviewOrderScreen{
    
    private final SelenideElement placeOrderButton = $(By.xpath("//button[contains(@class,'MuiButton-contained MuiButton-containedPrimary')]"));
    private final SelenideElement shippingAddress = $(By.xpath("(//div[@data-testid='checkout-address-view'])[1]"));
    private final SelenideElement billingAddress = $(By.xpath("(//div[@data-testid='checkout-address-view'])[2]"));
    private final SelenideElement paymentInformationTitle = $(By.xpath("//*[text()='Payment Information']"));
    private final SelenideElement visaCardText = $(By.xpath("//*[text()='Visa']"));
    private final SelenideElement cardMask = $(By.xpath("//*[contains(text(),'XXXXXXXX')]"));
    private final SelenideElement nanText = $(By.xpath("//*[text() = '$NaN']"));
    private final SelenideElement orderScreenPrice = $(By.xpath("//*[contains(text(),'XXXXXXXX')]/../following-sibling::div/p"));
    private final SelenideElement orderScreenEditButton = $(By.xpath("(//*[@href = '/us/en/checkout/payment.jsp'])[2]"));
    private final SelenideElement orderScreenThisPaymentText = $(By.xpath(" (//*[@href = '/us/en/checkout/payment.jsp'])[2]/following-sibling::p"));
    private final SelenideElement masterCardText = $(By.xpath("//*[text()='MasterCard']"));
    private final SelenideElement americanExpressCard = $(By.xpath("//*[text()='American Express']"));
    private final SelenideElement discoverCard = $(By.xpath("//*[text()='Discover']"));
    private final SelenideElement pos = $(By.xpath("//*[text()='Cash/Check']"));


}
