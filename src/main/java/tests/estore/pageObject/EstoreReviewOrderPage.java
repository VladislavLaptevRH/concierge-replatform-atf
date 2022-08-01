package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstoreReviewOrderPage {

    private final SelenideElement placeOrderButton = $(By.xpath("//button[contains(@class,'MuiButton-contained MuiButton-containedPrimary')]"));

    private final SelenideElement shippingAddress = $(By.xpath("(//h3[contains(@class,'MuiTypography-root MuiTypography-h3')])[3]"));

    private final SelenideElement billingAddress = $(By.xpath("(//h3[contains(@class,'MuiTypography-root MuiTypography-h3')])[4]"));

}
