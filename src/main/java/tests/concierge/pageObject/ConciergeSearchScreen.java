package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Getter
public class ConciergeSearchScreen {
    private final SelenideElement searchItemInput = $(By.xpath("//*[@id = 'site-search-input']"));
}
