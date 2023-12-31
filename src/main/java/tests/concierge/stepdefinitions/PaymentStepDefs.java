package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import tests.concierge.pageObject.*;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.AssertJUnit.assertEquals;
import static tests.concierge.stepdefinitions.ConciergeE2EStepDefs.iClickOnNoThanksButton;

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
        with().pollInterval(2, SECONDS).await().until(() -> true);
        paymentScreen.getFieldAmount().setValue("1");
        with().pollInterval(2, SECONDS).await().until(() -> true);
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        with().pollInterval(2, SECONDS).await().until(() -> true);
        paymentScreen.getContinueToReview().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        with().pollInterval(2, SECONDS).await().until(() -> true);
        selectPayment.selectByValue("RH");
        with().pollInterval(2, SECONDS).await().until(() -> true);
        paymentScreen.getSplitPaymentCheckBox().should(visible, Duration.ofSeconds(40));
        with().pollInterval(2, SECONDS).await().until(() -> true);
        paymentScreen.getSplitPaymentCheckBox().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        paymentScreen.getRhCardNumberField().setValue("6006101002617097");
        with().pollInterval(2, SECONDS).await().until(() -> true);
        Select paymentPlan = new Select(paymentScreen.getSelectPaymentPlan());
        with().pollInterval(2, SECONDS).await().until(() -> true);
        paymentPlan.selectByIndex(1);
        with().pollInterval(2, SECONDS).await().until(() -> true);
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        with().pollInterval(3, SECONDS).await().until(() -> true);
        paymentScreen.getFieldAmount().setValue("1");
        with().pollInterval(3, SECONDS).await().until(() -> true);
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        with().pollInterval(3, SECONDS).await().until(() -> true);
        paymentScreen.getContinueToReview().click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        Select selectPayment1 = new Select(paymentScreen.getChoosePaymentMethodBtn());
        with().pollInterval(3, SECONDS).await().until(() -> true);
        selectPayment1.selectByValue("GiftCard");
        with().pollInterval(3, SECONDS).await().until(() -> true);
        paymentScreen.getRhCardNumberField().setValue("6006493887999901635");
        with().pollInterval(3, SECONDS).await().until(() -> true);
        paymentScreen.getRhCardPin().setValue("9559");
        with().pollInterval(3, SECONDS).await().until(() -> true);
        paymentScreen.getSplitPaymentCheckBox().click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        with().pollInterval(3, SECONDS).await().until(() -> true);
        paymentScreen.getFieldAmount().setValue("1");
        with().pollInterval(3, SECONDS).await().until(() -> true);
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        with().pollInterval(3, SECONDS).await().until(() -> true);
        paymentScreen.getContinueToReview().click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        generalStepDefs.payWith("DI", "6011 6011 6011 6611", "737", "0330");
        with().pollInterval(3, SECONDS).await().until(() -> true);
        paymentScreen.getSplitPaymentCheckBox().click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        with().pollInterval(3, SECONDS).await().until(() -> true);
        paymentScreen.getFieldAmount().setValue("1");
        with().pollInterval(3, SECONDS).await().until(() -> true);
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        with().pollInterval(3, SECONDS).await().until(() -> true);
        paymentScreen.getContinueToReview().click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        generalStepDefs.payWith("MC", "5555 3412 4444 1115", "737", "0330");
        with().pollInterval(3, SECONDS).await().until(() -> true);
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        with().pollInterval(3, SECONDS).await().until(() -> true);
        paymentScreen.getContinueToReview().click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
    }

    @When("I execute payment for {string}")
    public void iExecutePaymentFor(String cardType) {
//                if (!paymentScreen.getChoosePaymentMethodBtnDisplayed().isDisplayed()) {
//                    WebDriverRunner.getWebDriver().navigate().refresh();
//                    with().pollInterval(3, SECONDS).await().until(() -> true);
//
//                    if(checkoutAddressScreen.getBillingAddressCheckbox().exists()) {
//                        if (!$(By.xpath("//*[contains(@class, 'Mui-checked')]//*[@id = 'billing-shipping-address-same-checkbox']")).isDisplayed()) {
//                            $(By.xpath("//*[@id = 'billing-shipping-address-same-checkbox']")).click();
//                            with().pollInterval(2, SECONDS).await().until(() -> true);
//                        }
//                    }
//
//                    if (!checkoutAddressScreen.getContinuePaymentButton().isDisplayed()) {
//                        WebDriverRunner.getWebDriver().navigate().refresh();
//                        with().pollInterval(5, SECONDS).await().until(() -> true);
//                        abstractStepDefs.iClickOnCheckoutButton();
//                        checkoutAddressScreen.getContinuePaymentButton().shouldHave(text(checkoutAddressScreen.getContinuePaymentButton().getText()), Duration.ofMinutes(1));
//                        executeJavaScript("arguments[0].scrollIntoView(true);", checkoutAddressScreen.getContinuePaymentButton());
//                        checkoutAddressScreen.getContinuePaymentButton().shouldHave(text(checkoutAddressScreen.getContinuePaymentButton().getText()), Duration.ofMinutes(1));
//                        checkoutAddressScreen.getContinuePaymentButton().click();
//                        abstractStepDefs.iFillAllFieldsFromAddressScreenForBrands();
//                    }
//                    checkoutAddressScreen.getContinuePaymentButton().shouldHave(text(checkoutAddressScreen.getContinuePaymentButton().getText()), Duration.ofMinutes(1));
//                    executeJavaScript("arguments[0].scrollIntoView(true);", checkoutAddressScreen.getContinuePaymentButton());
//                    checkoutAddressScreen.getContinuePaymentButton().shouldHave(text(checkoutAddressScreen.getContinuePaymentButton().getText()), Duration.ofMinutes(1));
//                    checkoutAddressScreen.getContinuePaymentButton().click();
//                    with().pollInterval(5, SECONDS).await().until(() -> true);
//                    if (conciergeProjectScreen.getTryAgainButton().isDisplayed()) {
//                        conciergeProjectScreen.getTryAgainButton().click();
//                        with().pollInterval(3, SECONDS).await().until(() -> true);
//                        abstractStepDefs.iFillAllFieldsFromAddressScreenForBrands();
//                        checkoutAddressScreen.getContinuePaymentButton().click();
//                        with().pollInterval(3, SECONDS).await().until(() -> true);
//                    }
//
//                    if (conciergeProjectScreen.getContinueWithSuggestedAddressButton().isDisplayed()) {
//                        conciergeProjectScreen.getContinueWithSuggestedAddressButton().click();
//                        with().pollInterval(5, SECONDS).await().until(() -> true);
//                    }
//
//                    if ($(By.xpath("//*[text() = 'CONTINUE']")).isDisplayed()) {
//                        $(By.xpath("//*[text() = 'CONTINUE']")).click();
//                        with().pollInterval(5, SECONDS).await().until(() -> true);
//                    }
//
//                    if (conciergeProjectScreen.getTryAgainButton().isDisplayed()) {
//                        conciergeProjectScreen.getTryAgainButton().click();
//                        with().pollInterval(3, SECONDS).await().until(() -> true);
//                        abstractStepDefs.iFillAllFieldsFromAddressScreenForBrands();
//                        checkoutAddressScreen.getContinuePaymentButton().click();
//                        with().pollInterval(3, SECONDS).await().until(() -> true);
//                        $(By.xpath("//*[text() = 'CONTINUE']")).click();
//                        with().pollInterval(5, SECONDS).await().until(() -> true);
//                    }
//            }
        if(conciergeCartPageScreen.getShippingAddress().isDisplayed() || conciergeCartPageScreen.getShippingAddressUpperCase().isDisplayed()){
            abstractStepDefs.iFillAllFieldsFromAddressScreenForBrands();
            continueToPayment();
            iClickOnContinueWithOriginalAddressButton();
        }
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if(!paymentScreen.getChoosePaymentMethodBtn().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
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
        generalStepDefs.paymentTypeVar = cardType;
    }

    public void continueToPayment() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (!checkoutAddressScreen.getContinuePaymentButton().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
            abstractStepDefs.iClickOnCheckoutButton();
            iClickOnNoThanksButton();
            abstractStepDefs.iFillAllFieldsFromAddressScreenForBrands();
        }
        checkoutAddressScreen.getContinuePaymentButton().shouldHave(text(checkoutAddressScreen.getContinuePaymentButton().getText()), Duration.ofMinutes(1));
        executeJavaScript("arguments[0].scrollIntoView(true);", checkoutAddressScreen.getContinuePaymentButton());
        checkoutAddressScreen.getContinuePaymentButton().shouldHave(text(checkoutAddressScreen.getContinuePaymentButton().getText()), Duration.ofMinutes(1));
        checkoutAddressScreen.getContinuePaymentButton().click();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (conciergeProjectScreen.getTryAgainButton().isDisplayed()) {
            conciergeProjectScreen.getTryAgainButton().click();
            with().pollInterval(3, SECONDS).await().until(() -> true);
            abstractStepDefs.iFillAllFieldsFromAddressScreenForBrands();
            checkoutAddressScreen.getContinuePaymentButton().click();
            with().pollInterval(3, SECONDS).await().until(() -> true);
        }

        if (conciergeProjectScreen.getContinueWithSuggestedAddressButton().isDisplayed()) {
            conciergeProjectScreen.getContinueWithSuggestedAddressButton().click();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }

        if ($(By.xpath("//*[text() = 'CONTINUE']")).isDisplayed()) {
            $(By.xpath("//*[text() = 'CONTINUE']")).click();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }

        if (conciergeProjectScreen.getTryAgainButton().isDisplayed()) {
            conciergeProjectScreen.getTryAgainButton().click();
            with().pollInterval(3, SECONDS).await().until(() -> true);
            abstractStepDefs.iFillAllFieldsFromAddressScreenForBrands();
            checkoutAddressScreen.getContinuePaymentButton().click();
            with().pollInterval(3, SECONDS).await().until(() -> true);
            $(By.xpath("//*[text() = 'CONTINUE']")).click();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
    }

    @When("I pay with RHCC method")
    public void iPayWithRHCCMethod() {
        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(1));
        paymentScreen.getChoosePaymentMethodBtn().click();
        paymentScreen.getChoosePaymentMethodBtn().should(Condition.be(visible), Duration.ofSeconds(35));
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment.selectByValue("RH");
        $(By.xpath("//*[text() = 'Card Number']/..//input")).setValue("6006101002587290");
        Select paymentPlan = new Select($(By.xpath("//*[text() = 'Select a Payment Plan']/..//select")));
        paymentPlan.selectByIndex(1);
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
    }

    @When("I choose {string} from payment method")
    public void iChooseRHGiftCardFromPaymentMethod(String card) {
        with().pollInterval(5, SECONDS).await().until(() -> true);
//        WebDriverRunner.getWebDriver().navigate().refresh();
        Select selectPaymentMethod = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPaymentMethod.selectByVisibleText(card);
        with().pollInterval(2, SECONDS).await().until(() -> true);
        paymentScreen.getRhCardNumberField().setValue("6006493887999902229");
        paymentScreen.getRhCardPin().setValue("1980");
    }

    @When("I verify that I can't pay by RHCC and Discover cards for Canada")
    public void iVerifyThatICantPayByRHCCAndDiscoverCardsForCanada() {
        $(By.xpath("//*[@id = 'payment-method-select']")).click();
        $(By.xpath("//*[@id = 'payment-option-RH']")).shouldNotBe(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'payment-option-card']")).click();
        generalStepDefs.payWith("DI", "6011 6011 6011 6611", "737", "0330");
        $(By.xpath("//*[@id = 'payment-review-button-1'][@disabled]")).shouldBe(visible, Duration.ofSeconds(15));
    }

    @When("I execute split payment with {string}")
    public void iExecuteSplitPayment(String cardType) {
        if (cardType.equals("VI")) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
            paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofSeconds(15));
            generalStepDefs.payWith("VI", "4111 1111 4555 1142", "737", "0330");
            $(By.xpath("//*[text()='Split Payment with Additional Cards']")).click();
            $(By.xpath("//*[text()='Enter the amount you would like to put on this card:']")).should(visible, Duration.ofSeconds(15));
            $(By.xpath("//*[text()='Enter the amount you would like to put on this card:']/..//*[text() = '$']")).should(visible, Duration.ofSeconds(15));
            $(By.xpath("//input[@value = '0.00']")).should(visible, Duration.ofSeconds(15));
            $(By.xpath("//input[contains(@class, 'MuiOutlinedInput-inputAdornedStart')]")).doubleClick().sendKeys(Keys.BACK_SPACE);
            with().pollInterval(3, SECONDS).await().until(() -> true);
            $(By.xpath("//input[contains(@class, 'MuiOutlinedInput-inputAdornedStart')]")).setValue("10");
            paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
            paymentScreen.getContinueToReview().click();
            $(By.xpath("//*[text()='Charge to Visa ending 1142:']")).should(visible, Duration.ofSeconds(15));
            $(By.xpath("//*[text()='Remove']")).should(visible, Duration.ofSeconds(15));
        }
        if (cardType.equals("MC")) {
            Select paymentMethodList = new Select($(By.xpath("//select[@id = 'payment-method-select']")));
            with().pollInterval(3, SECONDS).await().until(() -> true);
            paymentMethodList.selectByValue("card");
            generalStepDefs.payWith("MC", "5555 3412 4444 1115", "737", "0330");
            paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
            paymentScreen.getContinueToReview().click();
        }
    }

    @When("I verify that payment split is working and paid amount is visible on the review page")
    public void iVerifyThatPaymentSplitIsWorkingAndPaidAmountIsVisibleOnReviewPage() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text()='Payment Information']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='Visa']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("(//*[contains(text(),'XXXXXXXX')])[1]")).shouldHave(text("XXXXXXXX 1142"), Duration.ofSeconds(15));
        $(By.xpath("//*[text() = '$NaN']")).shouldNotBe(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='$10.00']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='MasterCard']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("(//*[contains(text(),'XXXXXXXX')])[2]")).shouldHave(text("XXXXXXXX 1115"), Duration.ofSeconds(15));
        $(By.xpath("//*[text()='$3,165.46']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("(//*[@href = '/us/en/checkout/payment.jsp'])[2]")).shouldHave(text("Edit"), Duration.ofSeconds(15));
        $(By.xpath("(//*[@href = '/us/en/checkout/payment.jsp'])[2]/following-sibling::p")).shouldHave(text("this payment."), Duration.ofSeconds(15));
    }

    @When("I verify that payment split is working and paid amount is visible on the confirmation page")
    public void iVerifyThatPaymentSplitIsWorkingAndPaidAmountIsVisibleOnConfirmationPage() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text()='Payment Information']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='Visa']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("(//*[contains(text(),'XXXXXXXX')])[1]")).shouldHave(text("XXXXXXXX 1142"), Duration.ofSeconds(15));
        $(By.xpath("//*[text() = '$NaN']")).shouldNotBe(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='$10.00']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='MasterCard']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("(//*[contains(text(),'XXXXXXXX')])[2]")).shouldHave(text("XXXXXXXX 1115"), Duration.ofSeconds(15));
        $(By.xpath("//*[text()='$3,165.46']")).should(visible, Duration.ofSeconds(15));
    }

    @When("I verify that payment POS is working and paid amount is visible on the review page")
    public void iVerifyThatPaymentPOSIsWorkingAndPaidAmountIsVisibleOnReviewPage() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text()='Payment Information']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='Cash/Check']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[contains(text(),'XXXXXXXX')]")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text() = '$NaN']")).shouldNotBe(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='$3,175.46']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("(//*[@href = '/us/en/checkout/payment.jsp'])[2]")).shouldHave(text("Edit"), Duration.ofSeconds(15));
        $(By.xpath("(//*[@href = '/us/en/checkout/payment.jsp'])[2]/following-sibling::p")).shouldHave(text("this payment."), Duration.ofSeconds(15));
    }

    @When("I verify that payment POS is working and paid amount is visible on the confirmation page")
    public void iVerifyThatPaymentPOSIsWorkingAndPaidAmountIsVisibleOnConfirmationPage() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text()='Payment Information']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='Cash/Check']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[contains(text(),'XXXXXXXX')]")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text() = '$NaN']")).shouldNotBe(visible, Duration.ofSeconds(15));
    }

    @When("I verify that payment RHCC is working and paid amount is visible on the review page")
    public void iVerifyThatPaymentRHCCIsWorkingAndPaidAmountIsVisibleOnReviewPage() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text()='Payment Information']")).scrollIntoView(true);
        $(By.xpath("//*[text()='Payment Information']")).should(visible, Duration.ofSeconds(15));
        if(!$(By.xpath("//*[text()='RH Credit Card']")).isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
        }
        $(By.xpath("//*[text()='RH Credit Card']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[contains(text(),'XXXXXXXX')]")).shouldHave(text("XXXXXXXX 7290"), Duration.ofSeconds(15));
        $(By.xpath("//*[text() = '$NaN']")).shouldNotBe(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='$3,175.46']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[contains(text(),\"You've chosen 24.99% Standard Purchase APR and Payments.Standard Purchase APR and Payments: \")]")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[contains(text(),\" Standard financing terms apply. Interest will be charged on the unpaid purchase balance at the APR for standard Purchases. New accounts: standard Purchase APR 24.99%. Minimum interest charge $1. Existing accounts, see your Cardholder Agreement for applicable terms. Subject to credit approval. RH financing account issued by TD Bank, N.A. \")]")).should(visible, Duration.ofSeconds(15));
        with().pollInterval(5, SECONDS).await().until(() -> true);
//        $(By.xpath("(//*[@href = '/us/en/checkout/payment.jsp'])[2]")).shouldHave(text("Edit"), Duration.ofSeconds(15));
//        $(By.xpath("(//*[@href = '/us/en/checkout/payment.jsp'])[2]/following-sibling::p")).shouldHave(text("this payment."), Duration.ofSeconds(15));
    }

    @When("I verify that payment RHCC is working and paid amount is visible on the confirmation page")
    public void iVerifyThatPaymentRHCCIsWorkingAndPaidAmountIsVisibleOnConfirmationPage() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text()='Payment Information']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='RH Credit Card']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[contains(text(),'XXXXXXXX')]")).shouldHave(text("XXXXXXXX 7290"), Duration.ofSeconds(15));
        $(By.xpath("//*[text() = '$NaN']")).shouldNotBe(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='$3,175.46']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[contains(text(),\"You've chosen 24.99% Standard Purchase APR and Payments.Standard Purchase APR and Payments: \")]")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[contains(text(),\" Standard financing terms apply. Interest will be charged on the unpaid purchase balance at the APR for standard Purchases. New accounts: standard Purchase APR 24.99%. Minimum interest charge $1. Existing accounts, see your Cardholder Agreement for applicable terms. Subject to credit approval. RH financing account issued by TD Bank, N.A. \")]")).should(visible, Duration.ofSeconds(15));
    }

    @When("I verify that payment CC is working and paid amount is visible on the review page")
    public void iVerifyThatPaymentCCIsWorkingAndPaidAmountIsVisibleOnReviewPage() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text()='Payment Information']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='Visa']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[contains(text(),'XXXXXXXX')]")).shouldHave(text("XXXXXXXX 1142"), Duration.ofSeconds(15));
        $(By.xpath("//*[text() = '$NaN']")).shouldNotBe(visible, Duration.ofSeconds(15));
        $(By.xpath("(//*[@href = '/us/en/checkout/payment.jsp'])[2]")).shouldHave(text("Edit"), Duration.ofSeconds(15));
        $(By.xpath("(//*[@href = '/us/en/checkout/payment.jsp'])[2]/following-sibling::p")).shouldHave(text("this payment."), Duration.ofSeconds(15));
    }

    @Then("I verify the complete billing address")
    public void iVerifyTheCompleteBillingAddress() {
      
        if (Hooks.cookie.equals("prodsupport")) {
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
        } else {
            paymentScreen.getBillingAddress().shouldHave(text(
                            "BILLING ADDRESS\n" +
                            "QAFirst Automation\n" +
                            "AutomationCompany\n" +
                            "North 16th Street\n" +
                            "QaApartment\n" +
                            "Phoenix, AZ, 85020\n" +
                            "US\n" +
                            "1241312319\n" +
                            "test@mailinator.com\n" +
                            "EDIT"));

            assertEquals(paymentScreen.getBillingAddress().getText(),
                     "BILLING ADDRESS\n" +
                            "QAFirst Automation\n" +
                            "AutomationCompany\n" +
                            "North 16th Street\n" +
                            "QaApartment\n" +
                            "Phoenix, AZ, 85020\n" +
                            "US\n" +
                            "1241312319\n" +
                            "test@mailinator.com\n" +
                            "EDIT");
      }
    }
  
    @Then("I verify subtotal, shipping fee, taxes based on postal code")
    public void iVerifySubtotalShippingFeeTaxesBasedOnPostalCode() {
        $(By.xpath("//*[text()='Subtotal  ']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='Unlimited Furniture Delivery']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='Estimated Sales Tax for 85020']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text() = '$NaN']")).shouldNotBe(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='$2,625.00']")).should(visible, Duration.ofSeconds(15));
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
        if (conciergeAddressScreen.getEditPaymentOrderReview().isDisplayed()) {
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
        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Credit Card"), Duration.ofMinutes(1));
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
        conciergeCartPageScreen.getRhGiftCardBalance().shouldHave(text("RH Gift Card ending 2229 has balance of "), Duration.ofSeconds(25));
    }

    @When("I execute POS concierge payment")
    public void iExecutePOSConciergePayment() {
        System.out.println();
    }

    @When("I click on continue with original address button")
    public void iClickOnContinueWithOriginalAddressButton() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (paymentScreen.getContinueWithOriginalAddressButton().isDisplayed()) {
            paymentScreen.getContinueWithOriginalAddressButton().should(Condition.and("", Condition.enabled, Condition.visible), Duration.ofSeconds(60));
            paymentScreen.getContinueWithOriginalAddressButton().click();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        if (pdpScreen.getCloseSpecialOrderPopUpButton().isDisplayed()) {
            pdpScreen.getCloseSpecialOrderPopUpButton().click();
            $(By.xpath("(//button[@data-testid='add-to-cart-dialog-opener'])[1]")).click();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
    }

    @Then("I verify that on the payment page the same address as for the saved mastercard")
    public void iVerifyThatOnThePaymentPageTheSameAddressAsForTheSavedMastercard() {
        $(By.xpath("//*[text()='Safire William']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Ocala Street']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Silver Spring, MD, 20901']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='3097931846']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='US']")).should(visible, Duration.ofSeconds(20));
    }
}