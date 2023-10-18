package tests.concierge.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class SelectOption {

    public final String itemColorLList = "(//*[@data-test = 'sentinelStart']/following-sibling::div/ul/li)[%s]";
    private final SelenideElement lancasterColor = $(By.xpath("//select[@id='optionSelect-4']"));
    private final SelenideElement lancasterColorForProdSupport = $(By.xpath("//label[text() = 'Color']/../div"));
    private final SelenideElement colorStg4 = $(By.id("optionSelect-2"));

    private final List<SelenideElement> lancastColorsList = $$(By.xpath("//select[@id='optionSelect-4']//option"));

    private final SelenideElement quantityOfLancasterOption = $(By.cssSelector("#quantity_I31828690"));

    private final SelenideElement quantityOfLancasterSofa = $(By.id("quantity_I24388989"));

    private final SelenideElement quantitySelectBtn = $(By.xpath("//select[contains(@id,'quantity')]"));

    private final SelenideElement sizeOption = $(By.xpath("//select[@id='optionSelect--Size']"));

    private final SelenideElement colorOption = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Color')])[1]"));

    private final SelenideElement fabricProperty = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Fabric')])[1]"));

    private final SelenideElement fabricPropertyLineItem = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Fabric')])[2]"));

    private final SelenideElement itemPropertyLineItem = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Item')])"));

    private final SelenideElement colorPropertyLineItem = $(By.xpath("((//select[contains(@id,'prod') and contains(@id,'Color')]))[2]"));

    private final SelenideElement depthProperty = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Depth')])[1]"));

    private final SelenideElement finishOption = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Finish')])[1]"));

    private final SelenideElement lengthOption = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Length')])[1]"));

    private final SelenideElement seatHeight = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Seat Height')])[1]"));

    private final SelenideElement fillOption = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Fill')])[1]"));

    private final SelenideElement quantityElement = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'qty')])[1]"));

    private final SelenideElement selectColorElement = $(By.xpath("//select[contains(@id,'prod') and contains(@id,'Color')]"));

    private final SelenideElement selectSizeElement = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Size')])[1]"));

    private final SelenideElement valueOption = $(By.xpath("//select[contains(@id,'Value')]"));

    private final SelenideElement selectAmount = $(By.xpath("//option[@value='3500009']"));

    private final SelenideElement toInputField = $(By.xpath("//input[@id='pdp-gift-card-to']"));

    private final SelenideElement fromInputField = $(By.xpath("//input[@id='pdp-gift-card-from']"));


    public void selectFabricPropertyLineItem() {
        Select selectFabricPropertyLineItem = new Select(fabricPropertyLineItem);
        selectFabricPropertyLineItem.selectByIndex(2);
    }

    public void selectItemPropertyLineItem(){
        itemPropertyLineItem.should(Condition.interactable, Duration.ofSeconds(12));
        Select selectItemPropertyLineItems = new Select(itemPropertyLineItem);
        selectItemPropertyLineItems.selectByIndex(1);
    }

    public void selectColorOptionLineItem() {
        colorPropertyLineItem.should(Condition.interactable);
        Select selectColorOptionLineItem = new Select(colorPropertyLineItem);
        selectColorOptionLineItem.selectByIndex(2);
    }

    public SelenideElement getTtemColorListByNumber(int number) {
        String path = String.format(itemColorLList, number);
        return $(byXpath(path));
    }

}
