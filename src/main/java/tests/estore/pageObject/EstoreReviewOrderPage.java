package tests.estore.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstoreReviewOrderPage {

    private final SelenideElement placeOrderButton = $(By.xpath("//*[text()='Place Order']"));

    private final SelenideElement shippingAddress = $(By.xpath("(//h3[contains(@class,'MuiTypography-root MuiTypography-h3')])[3]"));

    private final SelenideElement billingAddress = $(By.xpath("(//h3[contains(@class,'MuiTypography-root MuiTypography-h3')])[4]"));

    private final SelenideElement editGiftMessageButton = $(By.xpath("(//*[@href='/us/en/checkout/address.jsp'])[2]"));

    public void clickToEditGiftMessageButton() {
        editGiftMessageButton.should(Condition.interactable,
                Duration.ofSeconds(20)).click();
    }

}
