package tests.estore.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class EstoreGiftRegistry {

    private SelenideElement giftRegistrtyTitle = $(By.xpath("//*[text()='rh gift']"));

    public void verifyThatGiftRegistrtyTitleIsDisplayed() {
        giftRegistrtyTitle.should(Condition.visible, Duration.ofSeconds(20));
    }
}
