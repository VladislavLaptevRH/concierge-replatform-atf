package tests.estore.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class EstoreReturnPolicyScreen {

    private SelenideElement returnsPolicyTitle = $(By.xpath("//h3[text()='RETURNS']"));

    private SelenideElement returnOrderNumberField = $(By.xpath("//input[@name='order-number']"));

    private SelenideElement returnEmailIdField = $(By.xpath("//input[@name='email-id']"));

    private SelenideElement viewOrderButton = $(By.xpath("//button[@data-testid='view-order-button']"));

    private SelenideElement returnPolicyLink = $(By.xpath("//a[text()='RETURN POLICY']"));


    public void verifyThatReturnPolicyPageIsDisplayed() {
        returnsPolicyTitle.should(Condition.visible, Duration.ofSeconds(15));
        returnOrderNumberField.should(Condition.visible, Duration.ofSeconds(15));
        returnEmailIdField.should(Condition.visible, Duration.ofSeconds(15));
        viewOrderButton.should(Condition.visible, Duration.ofSeconds(15));
        returnPolicyLink.should(Condition.visible, Duration.ofSeconds(15));
    }
}
