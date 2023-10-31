package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ConciergeHomePage {

    public final SelenideElement closeCountrySideBar = $(By.xpath("//*[@data-testid= 'dialog-title-close-button']"));
    public final SelenideElement countrySelection = $(By.xpath("(//*[@class = 'MuiGrid-root MuiGrid-item']//div)[3]"));

    private final SelenideElement gbCountry = $(By.xpath("//*[text() = 'United Kingdom (£)']"));

    private final SelenideElement caCountry = $(By.xpath("//*[text() = 'Canada ($)']"));

    private final SelenideElement usCountry = $(By.xpath("//*[text() = 'United States ($)']"));

    private final SelenideElement selectCountrySaveButton = $(By.xpath("//*[text() = 'CONFIRM']"));

    private final SelenideElement selectCountryHeadline = $(By.xpath("//*[text() = 'PLEASE SELECT COUNTRY & LANGUAGE']"));

    public void chooseGBCountry() {
        countrySelection.should(visible).scrollIntoView(true).click();
        selectCountryHeadline.should(visible, Duration.ofSeconds(20));
        gbCountry.should(visible, Duration.ofSeconds(20)).click();
        if(selectCountrySaveButton.isDisplayed()){
            selectCountrySaveButton.should(visible, Duration.ofSeconds(20)).click();
        } else {
            System.out.println("The country already chosen");
            closeCountrySideBar.click();
        }

    }

    public void chooseCACountry() {
        countrySelection.should(visible).scrollIntoView(true).click();
        selectCountryHeadline.should(visible, Duration.ofSeconds(20));
        caCountry.should(visible, Duration.ofSeconds(20)).click();
        if(selectCountrySaveButton.isDisplayed()){
            selectCountrySaveButton.should(visible, Duration.ofSeconds(20)).click();
        } else {
            System.out.println("The country already chosen");
            closeCountrySideBar.click();
        }
    }

    public void chooseUSCountry() {
        countrySelection.should(visible).scrollIntoView(true).click();
        selectCountryHeadline.should(visible, Duration.ofSeconds(20));
        usCountry.should(visible, Duration.ofSeconds(20)).click();
        if(selectCountrySaveButton.isDisplayed()){
            selectCountrySaveButton.should(visible, Duration.ofSeconds(20)).click();
        } else {
            System.out.println("The country already chosen");
            closeCountrySideBar.click();
        }
    }

}
