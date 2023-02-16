package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ConfirmationOrderScreen {

    private final SelenideElement acceptPlaceOrderBtn = $(By.xpath("//*[@class= 'MuiButton-label' and text() ='ACCEPT & PLACE ORDER']"));

    private final SelenideElement signatureArea = $(By.xpath("//*[text() = 'SIGNATURE']/../following-sibling::div//canvas"));

    private final SelenideElement spoTermsCheckBox = $(By.xpath("(//input[@name='spoTermsCheckbox'])[2]"));
    
    private final SelenideElement orderDetailsButton = $(By.xpath("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]"));

    private final SelenideElement thankYouTitle = $(By.xpath("//*[text()='Thank You']"));
    private final SelenideElement yourOrderHasBeenPlaced = $(By.xpath("//*[text()='Your Order has been placed']"));
    private final SelenideElement requestingPlaceOrderError = $(By.xpath("//*[text() = 'Error while requesting place order']"));
    private final SelenideElement tryAgainButton = $(By.xpath("//*[text() = 'TRY AGAIN']"));
}
