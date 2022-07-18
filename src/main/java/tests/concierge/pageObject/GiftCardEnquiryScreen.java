package tests.concierge.pageObject;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import lombok.Getter;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
@Getter

public class GiftCardEnquiryScreen {

    private final SelenideElement giftCardEnquiry = $(By.xpath("//*[@class='MuiButton-label' and text()='Gift card enquiry']"));
    private final SelenideElement cardNumberField = $(By.xpath("//input[@id='1']"));
    private final SelenideElement cardPinField = $(By.xpath("//input[@type='password']"));
    private final SelenideElement submitButton = $(By.xpath("//*[@class='MuiButton-label' and text()='Submit']"));
    private final SelenideElement purchaseCard = $(By.xpath("//*[@class='MuiButton-label' and text()='RH']"));
    private final List<SelenideElement> listOfTransactionDetailsHeading = $$(By.xpath("//th[@scope='col']"));
}
