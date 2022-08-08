package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ConfirmationOrderScreen {

    private final SelenideElement acceptPlaceOrderBtn = $(By.xpath("//*[text()='ACCEPT & PLACE ORDER']"));

    private final SelenideElement signatureArea = $(By.xpath("//canvas[@width='1228']"));

    private final SelenideElement spoTermsCheckBox = $(By.xpath("(//input[@name='spoTermsCheckbox'])[2]"));
    
    private final SelenideElement orderDetailsButton = $(By.xpath("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]"));

    private final SelenideElement thankYouTitle = $(By.xpath("//*[@id=\"spa-root\"]/div/main/div/div[2]/div[2]/div/div/div/div/div/p[1]"));
    
    private final SelenideElement yourOrderHasBeenPlaced = $(By.xpath("//*[@id=\"spa-root\"]/div/main/div/div[2]/div[2]/div/div/div/div/div/p[2]"));
}
