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

}
