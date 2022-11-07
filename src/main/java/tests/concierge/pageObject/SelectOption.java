package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class SelectOption {

    private final SelenideElement lancasterColor = $(By.xpath("//select[@id='optionSelect-4']"));
    private final SelenideElement colorStg4 = $(By.id("optionSelect-2"));

    private final List<SelenideElement> lancastColorsList = $$(By.xpath("//select[@id='optionSelect-4']//option"));

    private final SelenideElement quantityOfLancasterOption = $(By.cssSelector("#quantity_I31828690"));

    private final SelenideElement quantityOfLancasterSofa = $(By.id("quantity_I24388989"));

    private final SelenideElement quantitySelectBtn = $(By.xpath("//select[contains(@id,'quantity')]"));

    private final SelenideElement sizeOption = $(By.xpath("//select[@id='optionSelect--Size']"));

    private final SelenideElement colorOption = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Color')])[1]"));

    private final SelenideElement fabricProperty = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Fabric')])[1]"));

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

}
