package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.concierge.pageObject.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.AssertJUnit.assertEquals;

public class PaymentStepDefs {
    PaymentScreen paymentScreen = new PaymentScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    ConciergeAddressScreen conciergeAddressScreen = new ConciergeAddressScreen();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();

    ConciergeProjectScreen conciergeProjectScreen = new ConciergeProjectScreen();

    AbstractStepDefs abstractStepDefs = new AbstractStepDefs();

    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen();

    PdpScreen pdpScreen = new PdpScreen();

    @When("I introduces payment details for several payment methods")
    public void iIntroducesPaymentDetailsForSeveralPaymentMethods() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (conciergeProjectScreen.getTryAgainButton().isDisplayed()) {
            for (int i = 0; i < 3; i++) {
                conciergeProjectScreen.getTryAgainButton().click();
                with().pollInterval(5, SECONDS).await().until(() -> true);
                $(By.xpath(" (//*[text()='Edit'])[1]")).click();
                with().pollInterval(1, SECONDS).await().until(() -> true);
                abstractStepDefs.iFillAllFieldsFromAddressScreenForBrands();
                checkoutAddressScreen.getContinuePaymentButton().click();
                iClickOnContinueWithOriginalAddressButton();
                with().pollInterval(3, SECONDS).await().until(() -> true);
                if (paymentScreen.getChoosePaymentMethodBtn().isDisplayed()) {
                    break;
                }
            }
        }
        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(1));
        with().pollInterval(3, SECONDS).await().until(() -> true);
        generalStepDefs.payWith("VI", "4111 1111 4555 1142", "737", "0330");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("3");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        generalStepDefs.payWith("AX", "3700 0000 0000 002", "7373", "0330");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("1");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment.selectByValue("RH");
        paymentScreen.getSplitPaymentCheckBox().should(visible, Duration.ofSeconds(40));
        paymentScreen.getSplitPaymentCheckBox().click();
        paymentScreen.getRhCardNumberField().setValue("6006101002617097");
        Select paymentPlan = new Select(paymentScreen.getSelectPaymentPlan());
        paymentPlan.selectByIndex(1);
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("1");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        Select selectPayment1 = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment1.selectByValue("GiftCard");
        paymentScreen.getRhCardNumberField().setValue("6006493887999901635");
        paymentScreen.getRhCardPin().setValue("9559");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("1");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        generalStepDefs.payWith("DI", "6011 6011 6011 6611", "737", "0330");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("1");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        generalStepDefs.payWith("MC", "5555 3412 4444 1115", "737", "0330");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
        with().pollInterval(1, SECONDS).await().until(() -> true);
    }

    @When("I execute payment for {string}")
    public void iExecutePaymentFor(String cardType) {
        if (!paymentScreen.getChoosePaymentMethodBtnDisplayed().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(3, SECONDS).await().until(() -> true);
        }

        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(1));
        if (cardType.equals("VI")) {
            generalStepDefs.payWith("VI", "4111 1111 4555 1142", "737", "0330");
        }
        if (cardType.equals("MC")) {
            generalStepDefs.payWith("MC", "5555 3412 4444 1115", "737", "0330");
        }
        if (cardType.equals("AX")) {
            generalStepDefs.payWith("AX", "3700 0000 0000 002", "7373", "0330");

        }
        if (cardType.equals("DI")) {
            generalStepDefs.payWith("DI", "6011 6011 6011 6611", "737", "0330");
        }
        if (cardType.equals("POS")) {
            paymentScreen.getChoosePaymentMethodBtn().should(Condition.be(visible), Duration.ofSeconds(35));
            Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
            selectPayment.selectByValue("POS");
            $(By.xpath("(//input)[1]")).should(visible, Duration.ofSeconds(10));
            $(By.xpath("(//input)[1]")).setValue("11111");
            $(By.xpath("(//input)[2]")).setValue("11");
        }
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
    }

    @When("I choose {string} from payment method")
    public void iChooseRHGiftCardFromPaymentMethod(String card) {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        Select selectPaymentMethod = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPaymentMethod.selectByVisibleText(card);
        with().pollInterval(2, SECONDS).await().until(() -> true);
        paymentScreen.getRhCardNumberField().setValue("6006493887999902229");
        paymentScreen.getRhCardPin().setValue("1980");
    }

    @Then("I verify the complete billing address")
    public void iVerifyTheCompleteBillingAddress() {
        paymentScreen.getBillingAddress().shouldHave(text(
                "BILLING ADDRESS\n" +
                        "QAFirst Automation\n" +
                        "AutomationCompany\n" +
                        "North 16th Street\n" +
                        "QaApartment\n" +
                        "Phoenix, AZ 85020\n" +
                        "US\n" +
                        "1241312319\n" +
                        "Edit"));

        assertEquals(paymentScreen.getBillingAddress().getText(),
                "BILLING ADDRESS\n" +
                        "QAFirst Automation\n" +
                        "AutomationCompany\n" +
                        "North 16th Street\n" +
                        "QaApartment\n" +
                        "Phoenix, AZ 85020\n" +
                        "US\n" +
                        "1241312319\n" +
                        "Edit");
    }

    @Then("I verify subtotal, shipping fee, taxes based on postal code")
    public void iVerifySubtotalShippingFeeTaxesBasedOnPostalCode() {
        $(By.xpath("//*[text()='Subtotal']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='Unlimited Furniture Delivery']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='Estimated Sales Tax for 85020']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='$3,222.16']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='$279.00']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='US $255.16']")).should(visible, Duration.ofSeconds(15));
    }

    @Then("I verify that member savings in payment page")
    public void iVerifyThatMemberSavingsInPaymentPage() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text()='Member Savings']")).should(visible, Duration.ofSeconds(25));
    }

    @Then("I verify that trade savings in payment page")
    public void iVerifyThatTradeSavingsInPaymentPage() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
//        $(By.xpath("//*[text()='Trade savings']")).should(visible, Duration.ofSeconds(25));
    }

    @When("I edit payment method")
    public void iEditPaymentMethod() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        executeJavaScript("window.scrollTo(0, 2000)");
        if(conciergeAddressScreen.getEditPaymentOrderReview().isDisplayed()){
            conciergeAddressScreen.getEditPaymentOrderReview().scrollIntoView(true);
            conciergeAddressScreen.getEditPaymentOrderReview().click();
        } else {
            conciergeAddressScreen.getEditPaymentOrderReviewEN().scrollIntoView(true);
            conciergeAddressScreen.getEditPaymentOrderReviewEN().click();
        }
        with().pollInterval(2, SECONDS).await().until(() -> true);
        paymentScreen.getRemovePaymentBtn().shouldHave(text("Remove"), Duration.ofSeconds(15));
        paymentScreen.getRemovePaymentBtn().should(Condition.and("", visible, enabled), Duration.ofSeconds(15));
        with().pollInterval(4, SECONDS).await().until(() -> true);
        paymentScreen.getRemovePaymentBtn().click();
        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("RH Credit Card"), Duration.ofMinutes(1));
        with().pollInterval(4, SECONDS).await().until(() -> true);
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
    }

    @Then("I verify that balance info is displayed")
    public void iVerifyThatBalanceInfoIsDisplayed() {
        conciergeCartPageScreen.getRhGiftCardBalance().shouldHave(text("RH Gift Card ending 2500 has balance of "), Duration.ofSeconds(25));
    }

    @When("I execute POS concierge payment")
    public void iExecutePOSConciergePayment() {
        System.out.println();
    }

    @When("I click on continue with original address button")
    public void iClickOnContinueWithOriginalAddressButton() {
        if($(By.xpath("//button[@data-testid='add-to-cart-dialog-opener']")).isDisplayed()){
            $(By.xpath("//button[@data-testid='add-to-cart-dialog-opener']")).should(Condition.and("", Condition.enabled, Condition.visible), Duration.ofSeconds(60));
            $(By.xpath("//button[@data-testid='add-to-cart-dialog-opener']")).click();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        if(pdpScreen.getCloseSpecialOrderPopUpButton().isDisplayed()){
            pdpScreen.getCloseSpecialOrderPopUpButton().click();
            $(By.xpath("//button[@data-testid='add-to-cart-dialog-opener']")).click();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
    }
}