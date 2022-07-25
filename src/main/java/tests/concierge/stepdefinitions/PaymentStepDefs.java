package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import tests.concierge.pageObject.ConciergeAddressScreen;
import tests.concierge.pageObject.ConciergeCartPageScreen;
import tests.concierge.pageObject.PaymentScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.AssertJUnit.assertEquals;

public class PaymentStepDefs {
    PaymentScreen paymentScreen = new PaymentScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    ConciergeAddressScreen conciergeAddressScreen = new ConciergeAddressScreen();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();

    @When("I introduces payment details for several payment methods")
    public void iIntroducesPaymentDetailsForSeveralPaymentMethods() {
        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(1));
        sleep(3000);
        generalStepDefs.payWith("VI", "4678 4753 3015 7543", "737", "0330");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("3");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
        sleep(3000);
        generalStepDefs.payWith("AX", "3411 3411 3411 347", "6765", "0225");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("1");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
        sleep(3000);
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment.selectByValue("RH");
        paymentScreen.getSplitPaymentCheckBox().should(visible, Duration.ofSeconds(20));
        paymentScreen.getSplitPaymentCheckBox().click();
        paymentScreen.getRhCardNumberField().setValue("5856373202133257");
        Select paymentPlan = new Select(paymentScreen.getSelectPaymentPlan());
        paymentPlan.selectByValue("001");
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("1");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
        sleep(3000);
        Select selectPayment1 = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment1.selectByValue("GiftCard");
        paymentScreen.getRhCardNumberField().setValue("6006493887999901635");
        paymentScreen.getRhCardPin().setValue("9559");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("1");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
        sleep(3000);
        generalStepDefs.payWith("DI", "6011 6011 6011 6611", "737", "0330");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("1");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
        sleep(3000);
        generalStepDefs.payWith("MC", "2222 4000 1000 0008", "737", "0330");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();

    }

    @When("I execute payment for {string}")
    public void iExecutePaymentFor(String paymentMethod) {
        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(1));
        if (paymentMethod.equals("VI")) {
            generalStepDefs.payWith("VI", "4678 4753 3015 7543", "737", "0330");
        }
        if (paymentMethod.equals("MC")) {
            generalStepDefs.payWith("MC", "2222 4000 1000 0008", "737", "0330");
        }
        if (paymentMethod.equals("AX")) {
            generalStepDefs.payWith("AX", "3411 3411 3411 347", "6765", "0225");

        }
        if (paymentMethod.equals("DI")) {
            generalStepDefs.payWith("DI", "6011 6011 6011 6611", "737", "0330");
        }
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
    }

    @When("I choose RH Gift Card from payment method")
    public void iChooseRHGiftCardFromPaymentMethod() {
        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(1));
        Select selectPaymentMethod = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPaymentMethod.selectByValue("GiftCard");
        paymentScreen.getRhCardNumberField().setValue("6006493887999901635");
        paymentScreen.getRhCardPin().setValue("9559");
    }

    @Then("I verify the complete billing address")
    public void iVerifyTheCompleteBillingAddress() {
        paymentScreen.getBillingAddress().shouldHave(text(
                "BILLING ADDRESS\n" +
                        "QA1 Automation\n" +
                        "AutomationCompany\n" +
                        "Qastreet\n" +
                        "QaApartment\n" +
                        "Schenectady, NY 12345\n" +
                        "US\n" +
                        "124131231\n" +
                        "automationnonmember@mailinator.com\n" +
                        "Edit"));

        assertEquals(paymentScreen.getBillingAddress().getText(),
                "BILLING ADDRESS\n" +
                        "QA1 Automation\n" +
                        "AutomationCompany\n" +
                        "Qastreet\n" +
                        "QaApartment\n" +
                        "Schenectady, NY 12345\n" +
                        "US\n" +
                        "124131231\n" +
                        "automationnonmember@mailinator.com\n" +
                        "Edit");
    }

    @Then("I verify subtotal, shipping fee, taxes based on postal code")
    public void iVerifySubtotalShippingFeeTaxesBasedOnPostalCode() {
        $(By.xpath("//*[text()='Subtotal']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='Standard Delivery Shipping']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='Estimated Sales Tax for 12345']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='$20.00']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='$9.00']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='US$2.32']")).should(visible, Duration.ofSeconds(15));
    }

    @Then("I verify that member savings in payment page")
    public void iVerifyThatMemberSavingsInPaymentPage() {
        $(By.xpath("//*[text()='Member Savings']")).should(visible, Duration.ofSeconds(25));
    }

    @Then("I verify that trade savings in payment page")
    public void iVerifyThatTradeSavingsInPaymentPage() {
        $(By.xpath("//*[text()='Trade savings']")).should(visible, Duration.ofSeconds(25));
    }

    @When("I edit payment method")
    public void iEditPaymentMethod() {
        conciergeAddressScreen.getEditPaymentOrderReview().should(visible, Duration.ofSeconds(15));
        conciergeAddressScreen.getEditPaymentOrderReview().scrollIntoView(true);
        conciergeAddressScreen.getEditPaymentOrderReview().click();
        paymentScreen.getRemovePaymentBtn().shouldHave(text("Remove"), Duration.ofSeconds(15));
        paymentScreen.getRemovePaymentBtn().should(Condition.and("", visible, enabled), Duration.ofSeconds(15));
        sleep(4000);
        paymentScreen.getRemovePaymentBtn().click();
        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("RH Credit Card"), Duration.ofMinutes(1));
        sleep(2000);
        paymentScreen.getChoosePaymentMethodBtn().should(Condition.be(visible), Duration.ofSeconds(35));
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment.selectByValue("POS");
        conciergeCartPageScreen.getPosRegisterField().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getPosRegisterField().setValue("1234");
        conciergeCartPageScreen.getPosTransactionField().setValue("1234");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
    }

    @When("I edit billing address from PG")
    public void iEditBillingAddressFromPG() {
        paymentScreen.getEditBillingAddressBtn().shouldHave(text("Edit"), Duration.ofSeconds(20));
        paymentScreen.getEditBillingAddressBtn().click();
        generalStepDefs.clearField(conciergeAddressScreen.getBillingAddressFirstName());
        conciergeAddressScreen.getBillingAddressFirstName().setValue("NewBillingAddress");
        System.out.println();
    }

}
