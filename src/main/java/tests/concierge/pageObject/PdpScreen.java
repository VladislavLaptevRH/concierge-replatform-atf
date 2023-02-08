package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class PdpScreen {

    private SelenideElement manageRegistryButton = $(By.xpath("//*[text()='MANAGE REGISTRY']"));

    private SelenideElement addToRegistryButton = $(By.xpath("(//button[@data-testid='add-to-registry-dialog-opener'])[1]"));

    private SelenideElement specialOrdersButton = $(By.xpath("//div[contains(@data-testid,'SPECIAL ORDER FabricS')]"));

    private SelenideElement fogSpecialOrderColor = $(By.xpath("(//ul[@class='MuiGridList-root']//li)[5]"));

    private SelenideElement twilightColor = $(By.xpath("(//ul[@class='MuiGridList-root']//li)[15]"));

    private SelenideElement fogSelectedOption = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Color')])[1]//option[@data-option='selected']"));

    private SelenideElement closeSpecialOrderPopUpButton = $(By.xpath("//button[@data-testid = 'dialog-title-close-button']"));

    private final SelenideElement productTitleGiftCard = $(By.xpath("//*[@class='MuiTypography-root MuiTypography-h2' and text()='RH GIFT CARD']"));
}
