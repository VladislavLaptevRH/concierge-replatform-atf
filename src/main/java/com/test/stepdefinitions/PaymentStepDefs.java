package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.test.pageObject.PaymentScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.AssertJUnit.assertEquals;

public class PaymentStepDefs {
    PaymentScreen paymentScreen = new PaymentScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    @When("I introduces payment details for several payment methods")
    public void iIntroducesPaymentDetailsForSeveralPaymentMethods() {
        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(1));
        sleep(2000);
        generalStepDefs.payWith("VI", "4678 4753 3015 7543", "737", "0330");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("3");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
        sleep(2000);
        generalStepDefs.payWith("AX", "3411 3411 3411 347", "6765", "0225");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("1");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
        sleep(2000);
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
        sleep(2000);
        Select selectPayment1 = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment1.selectByValue("GiftCard");
        paymentScreen.getRhCardNumberField().setValue("6006493887999901635");
        paymentScreen.getRhCardPin().setValue("9559");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("1");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
        sleep(2000);
        generalStepDefs.payWith("DI", "6011 6011 6011 6611", "737", "0330");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("1");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
        sleep(2000);

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
        assertEquals(paymentScreen.getBillingAddress().getText(), "BILLING ADDRESS\n" +
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
    }
}
