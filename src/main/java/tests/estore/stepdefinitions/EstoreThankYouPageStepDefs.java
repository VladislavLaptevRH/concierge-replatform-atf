package tests.estore.stepdefinitions;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.concierge.pageObject.ConciergeCartPageScreen;
import tests.estore.pageObject.EstoreConfirmationOrderScreen;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class EstoreThankYouPageStepDefs {
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();
    EstoreConfirmationOrderScreen estoreConfirmationOrderScreen = new EstoreConfirmationOrderScreen();
    EstoreAbstractStepDefs estoreAbstractStepDefs = new EstoreAbstractStepDefs();

    @Then("I verify all the line items in the estore cart on thank you page")
    public void iVerifyAllTheLineItemsInTheCartOnThankYouPage() {
        $(By.xpath("//*[text()='Qty 1']")).should(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getTotalMemberPrice().shouldHave(text("$2,156.00"), Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Subtotal']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Unlimited Furniture Delivery']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[contains(text(),'Estimated Sales Tax for ')]")).should(visible, Duration.ofSeconds(40));
        conciergeCartPageScreen.getTotalMemberPrice().shouldHave(text("$2,156.00"), Duration.ofMinutes(1));

    }

    @Then("I verify estore order number and email address verbiage")
    public void iVerifyEstoreOrderNumberAndEmailAddressVerbiage() {
        $(By.xpath("//*[text()='Your order number is ']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='. You will receive an order confirmation via email at']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='automationnonmember@mailinator.com']")).should(visible, Duration.ofSeconds(15));
    }

    @Then("I verify that estore thank you page is displayed")
    public void iVerifyThatEstoreThankYouPageIsDisplayed() {
        if (!estoreConfirmationOrderScreen.getThankYouTitle().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
        }
        $(By.xpath("//*[text()='THANK YOU']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[contains(text(),'You will receive an order confirmation number shortly via email.')]")).should(visible, Duration.ofSeconds(40));
    }

    @When("I click on eStore logo from thank you page")
    public void iClickOnEStoreLogoFromThankYouPage() {
        $(By.xpath("//a[@href='/us/en/']")).should(visible,Duration.ofSeconds(20))
                .click(ClickOptions.usingJavaScript());
    }
}