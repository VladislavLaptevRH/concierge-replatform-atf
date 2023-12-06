package tests.estore.pageObject;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstoreFooter {

    public SelenideElement countrySelection = $(By.xpath("//img[contains(@src,'asset-library/symbols-and-glyphs/flags')]"));

    public SelenideElement caCountrySelect = $(By.xpath("//*[@data-value='CA']"));
    public SelenideElement usCountrySelect = $(By.xpath("//*[@data-value='US']"));

    public SelenideElement confirmCountrySelectionBtn = $(By.xpath("//*[text()='CONFIRM']"));

    public void clickToCountrySelectionButton() {
        countrySelection.should(Condition.visible, Duration.ofSeconds(12));
        countrySelection.scrollIntoView(true);
        countrySelection.should(Condition.interactable, Duration.ofSeconds(12)).click();
    }

    public void clickToCaCountrySelect() {
        caCountrySelect.should(Condition.visible, Duration.ofSeconds(12))
                .click(ClickOptions.usingJavaScript());
    }

    public void clickToUSCountrySelect() {
        usCountrySelect.should(Condition.visible, Duration.ofSeconds(12))
                .click(ClickOptions.usingJavaScript());
    }

}
