package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstoreConfirmationOrderScreen {

    private final SelenideElement acceptPlaceOrderBtn = $(By.xpath("//*[text()='ACCEPT & PLACE ORDER']"));

    private final SelenideElement signatureArea = $(By.xpath("//canvas[@width='1228']"));

    private final SelenideElement spoTermsCheckBox = $(By.xpath("(//input[@name='spoTermsCheckbox'])[2]"));

    private final SelenideElement orderDetailsButton = $(By.xpath("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]"));

    private final SelenideElement thankYouTitle = $(By.xpath("//*[text()='THANK YOU']"));

    private final SelenideElement yourOrderHasBeenPlaced = $(By.xpath("//*[text()='YOUR ORDER HAS BEEN PLACED']"));

}
