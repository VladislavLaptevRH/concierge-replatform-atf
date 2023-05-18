package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class PdpScreen {

    public final String itemYAMLList = "(//*[text() = 'YOU MIGHT ALSO LIKE']/..//span)[%s]";
    private final SelenideElement manageRegistryButton = $(By.xpath("//*[text()='MANAGE REGISTRY']"));

    private final SelenideElement addToRegistryButton = $(By.xpath("(//button[@data-testid='add-to-registry-dialog-opener'])[1]"));

    private final SelenideElement specialOrdersButton = $(By.xpath("//div[contains(@data-testid,'SPECIAL ORDER FabricS')]"));

    private final SelenideElement fogSpecialOrderColor = $(By.xpath("//*[text() = 'Fog ']"));

    private final SelenideElement fogSelectedOption = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Color')])[1]//option[@data-option='selected']"));

    private final SelenideElement closeSpecialOrderPopUpButton = $(By.xpath("//button[@data-testid = 'dialog-title-close-button']"));

    private final SelenideElement specialOrderPopUpHeaderHeader = $(By.xpath("//p[@data-testid = 'swatch-panel-dialog-delivery-message']"));

    private final SelenideElement productTitleGiftCard = $(By.xpath("//*[@class='MuiTypography-root MuiTypography-h2' and text()='RH GIFT CARD']"));

//    private final List<SelenideElement> itemYAMLList = $$(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']/..//span"));


    public SelenideElement getTtemYAMLListByNumber(int number) {
        String path = String.format(itemYAMLList, number);
        return $(byXpath(path));
    }
}
