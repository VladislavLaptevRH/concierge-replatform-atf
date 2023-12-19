package tests.concierge.stepdefinitions;

import tests.concierge.pageObject.ConciergeAddressScreen;
import tests.concierge.pageObject.ConciergeCartPageScreen;
import tests.concierge.pageObject.PaymentScreen;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ThankYouPageStepDefs {
    PaymentScreen paymentScreen = new PaymentScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    ConciergeAddressScreen conciergeAddressScreen = new ConciergeAddressScreen();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();


    @Then("I verify all the line items in the cart on thank you page")
    public void iVerifyAllTheLineItemsInTheCartOnThankYouPage() {
        $(By.xpath("//*[text()='Qty 1']")).should(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getTotalMemberPrice().should(visible, Duration.ofSeconds(10));
        $(By.xpath("//*[contains(text(),'Subtotal')]")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[contains(text(),'Unlimited Furniture Delivery')]")).should(visible, Duration.ofSeconds(40));
        //$(By.xpath("//*[contains(text(),'Estimated Sales Tax for ')]")).should(visible, Duration.ofSeconds(40));
        conciergeCartPageScreen.getTotalMemberPrice().should(visible, Duration.ofSeconds(10));
    }

    @Then("I verify order number and email address verbiage")
    public void iVerifyOrderNumberAndEmailAddressVerbiage() {
        $(By.xpath("//*[text()='TOTAL']")).should(visible,Duration.ofSeconds(15));
    }

}
