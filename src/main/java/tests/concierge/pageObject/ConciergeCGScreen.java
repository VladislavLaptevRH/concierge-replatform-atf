package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ConciergeCGScreen {
    private final SelenideElement price = $(By.xpath("//*[text()='$']"));
}
