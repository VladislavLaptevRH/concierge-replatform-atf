package tests.estore.stepdefinitions;

import tests.concierge.pageObject.ConciergeAddressScreen;
import tests.concierge.pageObject.ConciergeCartPageScreen;
import tests.concierge.pageObject.PaymentScreen;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class EstoreThankYouPageStepDefs {
    PaymentScreen paymentScreen = new PaymentScreen();
    EstoreGeneralStepDefs generalStepDefs = new EstoreGeneralStepDefs();
    ConciergeAddressScreen conciergeAddressScreen = new ConciergeAddressScreen();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();
    // Fix DuplicateStepDefinitionException - change the steps names so they uniqe from concierge step definition

  /*  @Then("I verify all the line items in the cart on thank you page")
    public void iVerifyAllTheLineItemsInTheCartOnThankYouPage() {
        $(By.xpath("//*[text()='Qty 1']")).should(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getTotalMemberPrice().shouldHave(text("$2,156.00"), Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Subtotal']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Unlimited Furniture Delivery']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[contains(text(),'Estimated Sales Tax for ')]")).should(visible, Duration.ofSeconds(20));
        conciergeCartPageScreen.getTotalMemberPrice().shouldHave(text("$2,156.00"), Duration.ofMinutes(1));

    }

    @Then("I verify order number and email address verbiage")
    public void iVerifyOrderNumberAndEmailAddressVerbiage() {
        $(By.xpath("//*[text()='Your order number is ']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='. You will receive an order confirmation via email at']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='automationnonmember@mailinator.com']")).should(visible, Duration.ofSeconds(15));
    }

    @Then("I verify that thank you page is displayed")
    public void iVerifyThatThankYouPageIsDisplayed() {
        $(By.xpath("//*[text()='THANK YOU']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[contains(text(),'You will receive an order confirmation number shortly via email.')]")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Order details']")).should(visible, Duration.ofSeconds(20));
    }*/
}
