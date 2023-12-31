package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class Mailinator {

    private final SelenideElement searchEmailField = $(By.xpath("//input[@id='search']"));

    private final SelenideElement goButton = $(By.xpath("//*[text()='GO']"));

    private final SelenideElement firstLetter = $(By.xpath("//td[@class='ng-binding'][1]"));

    private final SelenideElement messageBodyIframe = $(By.id("html_msg_body"));

    private final SelenideElement yourEstimateTitle = $(By.xpath("//*[contains(text(),'Your Estimate for')]"));

    private final SelenideElement associateName = $(By.xpath("//div[contains(text(),'Automation Associate')]"));

    private final SelenideElement bodyEmailText = $(By.xpath("//div[contains(text(),'this is test description')]"));

}
