package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.an.E;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import tests.estore.pageObject.EstorePaymentPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.sleep;

public class EstorePaymentStepDefs {
    EstorePaymentPage estorePaymentPage = new EstorePaymentPage();
    EstoreGeneralStepDefs estoreGeneralStepDefs = new EstoreGeneralStepDefs();

    // Fix DuplicateStepDefinitionException - change the steps names so they uniqe from concierge step definition

   /* @When("I introduces payment details for estore several payment methods")
    public void iIntroducesPaymentDetailsForSeveralPaymentMethods() {
        estorePaymentPage.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(1));
        sleep(3000);
        estoreGeneralStepDefs.payWith("VI", "4678 4753 3015 7543", "737", "0330");
        estorePaymentPage.getSplitPaymentCheckBox().click();
        estoreGeneralStepDefs.clearField(estorePaymentPage.getFieldAmount());
        estorePaymentPage.getFieldAmount().setValue("3");
        estorePaymentPage.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        estorePaymentPage.getContinueToReview().click();
        sleep(3000);
        estoreGeneralStepDefs.payWith("AX", "3411 3411 3411 347", "6765", "0225");
        estorePaymentPage.getSplitPaymentCheckBox().click();
        estoreGeneralStepDefs.clearField(estorePaymentPage.getFieldAmount());
        estorePaymentPage.getFieldAmount().setValue("1");
        estorePaymentPage.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        estorePaymentPage.getContinueToReview().click();
        sleep(3000);
        Select selectPayment = new Select(estorePaymentPage.getChoosePaymentMethodBtn());
        selectPayment.selectByValue("RH");
        estorePaymentPage.getSplitPaymentCheckBox().should(visible, Duration.ofSeconds(20));
        estorePaymentPage.getSplitPaymentCheckBox().click();
        estorePaymentPage.getRhCardNumberField().setValue("5856373202133257");
        Select paymentPlan = new Select(estorePaymentPage.getSelectPaymentPlan());
        paymentPlan.selectByValue("001");
        estoreGeneralStepDefs.clearField(estorePaymentPage.getFieldAmount());
        estorePaymentPage.getFieldAmount().setValue("1");
        estorePaymentPage.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        estorePaymentPage.getContinueToReview().click();
        sleep(3000);
        Select selectPayment1 = new Select(estorePaymentPage.getChoosePaymentMethodBtn());
        selectPayment1.selectByValue("GiftCard");
        estorePaymentPage.getRhCardNumberField().setValue("6006493887999901635");
        estorePaymentPage.getRhCardPin().setValue("9559");
        estorePaymentPage.getSplitPaymentCheckBox().click();
        estoreGeneralStepDefs.clearField(estorePaymentPage.getFieldAmount());
        estorePaymentPage.getFieldAmount().setValue("1");
        estorePaymentPage.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        estorePaymentPage.getContinueToReview().click();
        sleep(3000);
        estoreGeneralStepDefs.payWith("DI", "6011 6011 6011 6611", "737", "0330");
        estorePaymentPage.getSplitPaymentCheckBox().click();
        estoreGeneralStepDefs.clearField(estorePaymentPage.getFieldAmount());
        estorePaymentPage.getFieldAmount().setValue("1");
        estorePaymentPage.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        estorePaymentPage.getContinueToReview().click();
        sleep(3000);
        estoreGeneralStepDefs.payWith("MC", "2222 4000 1000 0008", "737", "0330");
        estorePaymentPage.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        estorePaymentPage.getContinueToReview().click();
    }*/
}
