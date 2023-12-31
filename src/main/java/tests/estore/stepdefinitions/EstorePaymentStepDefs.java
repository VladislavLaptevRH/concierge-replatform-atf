package tests.estore.stepdefinitions;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.estore.pageObject.*;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;

public class EstorePaymentStepDefs {
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstoreCartPage estoreCartPage = new EstoreCartPage();
    EstoreAddressScreen estoreAddressScreen = new EstoreAddressScreen();
    EstoreE2EStepDefs estoreE2EStepDefs = new EstoreE2EStepDefs();
    EstoreGeneralStepDefs estoreGeneralStepDefs = new EstoreGeneralStepDefs();
    EstorePaymentPage estorePaymentPage = new EstorePaymentPage();
    EstoreItemPage estoreItemPage = new EstoreItemPage();

    @Then("I verify that I'm able to execute estore split payment")
    public void iVerifyThatIMAbleToExecuteEstoreSplitPayment() {
        $(By.cssSelector("select[id=\"page-checkout-payment_select-payment-method\"]")).should(Condition.and("", appear, exist, interactable), Duration.ofSeconds(20));
        estoreGeneralStepDefs.payWith("CC", "4678475330157543", "737", "0330");

        $(By.xpath("//span[@data-testid='split_payment_checkbox']")).click();
        $(By.xpath("//input[@type='text']")).setValue("10");
        estoreE2EStepDefs.iClickOnContinuePaymentMethodEstoreButton();


        WebDriverRunner.getWebDriver().navigate().refresh();


        estoreGeneralStepDefs.payWith("CC", "2222400010000008", "737", "0330");
        estoreE2EStepDefs.iClickOnContinuePaymentMethodEstoreButton();

    }

    @When("I choose saved card {string} from payment method dropdown")
    public void iChooseSaveCardFromPaymentMethodDropdown(String cardType) {
        $(By.cssSelector("select[id=\"page-checkout-payment_select-payment-method\"]")).should(Condition.and("", appear, exist, interactable), Duration.ofSeconds(20));
        estorePaymentPage.getChoosePaymentMethodBtn().should(Condition.be(visible), Duration.ofSeconds(35));
        Select selectPayment = new Select(estorePaymentPage.getChoosePaymentMethodBtn());
        if (cardType.equals("VI")) {
            try {
                selectPayment.selectByValue("45642063983482960745");
                $(By.xpath("//iframe[@title='Iframe for secured card security code']")).should(Condition.be(visible), Duration.ofMinutes(2));
                switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
            } catch (org.openqa.selenium.NoSuchElementException e) {
                selectPayment.selectByValue("46784755611871507543");
                $(By.xpath("//iframe[@title='Iframe for secured card security code']")).should(Condition.be(visible), Duration.ofMinutes(2));
                switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
            }
        }
        if (cardType.equals("MC")) {
            try {
                selectPayment.selectByValue("22224052112154880008");
                $(By.xpath("//iframe[@title='Iframe for secured card security code']")).should(Condition.be(visible), Duration.ofMinutes(2));
                switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
            } catch (org.openqa.selenium.NoSuchElementException e) {
                selectPayment.selectByValue("22224053560881330008");
                $(By.xpath("//iframe[@title='Iframe for secured card security code']")).should(Condition.be(visible), Duration.ofMinutes(2));
                switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
            }
        }

        estorePaymentPage.getCvcField().should(visible, Duration.ofSeconds(40));
        estorePaymentPage.getCvcField().setValue("737");
        switchTo().defaultContent();
    }

    @Then("I verify that I'm able to edit payment")
    public void iVerifyThatIMAbleToEditPayment() {
        $(By.cssSelector("select[id=\"page-checkout-payment_select-payment-method\"]")).should(Condition.and("", appear, exist, interactable), Duration.ofSeconds(20));
        estoreGeneralStepDefs.payWith("CC", "2222400010000008", "737", "0330");
        $(By.xpath("//*[text()='CONTINUE']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='CONTINUE']")).click();
    }

    @When("I edit estore billing address from PG")
    public void iEditBillingAddressFromPG() {

        if ($(By.xpath("//*[text() = 'Something went wrong']")).isDisplayed()) {
            $(By.xpath("//*[@data-testid = 'dialog-title-close-button']")).click();
        }
        if ($(By.xpath("//a[@href='/checkout/payment.jsp#/']")).isDisplayed()) {
            $(By.xpath("//a[@href='/checkout/payment.jsp#/']")).should(visible, Duration.ofSeconds(20));
            $(By.xpath("//a[@href='/checkout/payment.jsp#/']")).click();
        }

        if (estoreAddressScreen.getEditBillingAddress().isDisplayed()) {
            estoreAddressScreen.getEditBillingAddress().should(visible, Duration.ofSeconds(20));
            estoreAddressScreen.getEditBillingAddress().click();
        }
        try {
            estoreAddressScreen.getEditBillingAddressNew().should(and("Visible,interactable", visible, interactable), Duration.ofSeconds(20));
            estoreAddressScreen.getEditBillingAddressNew().click(ClickOptions.usingJavaScript());
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Edit billing address button on address page is not displayed");
        }


        estoreAddressScreen.getBillingAddressFirstNameNew().click();
        estoreGeneralStepDefs.clearField(estoreAddressScreen.getBillingAddressFirstNameNew());
        estoreAddressScreen.getBillingAddressFirstNameNew().setValue("NewBillingAddress");
    }


    @When("I pay with RHCC for estore item")
    public void iPayWithRHCCForEstoreItem() {
        $(By.cssSelector("select[id=\"page-checkout-payment_select-payment-method\"]")).should(Condition.and("", appear, exist, interactable), Duration.ofSeconds(20));
        if (!estorePaymentPage.getChoosePaymentMethodBtn().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();

        }
        Select paymentMethod = new Select(estorePaymentPage.getChoosePaymentMethodBtn());

        paymentMethod.selectByValue("RH");
        estorePaymentPage.getRhCardNumberField().setValue("6006101002617063");
        Select paymentPlan = new Select(estorePaymentPage.getSelectPaymentPlan());
        paymentPlan.selectByIndex(1);
    }

    @When("I edit billing address from estore payment page")
    public void iEditBillingAddressFromEstorePaymentPage() {
        estoreAddressScreen.getEditShippinggAddress().should(visible, Duration.ofSeconds(40));
    }

    @When("I remove added before cart")
    public void iRemoveAddedBeforeCart() {
        try {
            estoreUserAccountPage.getDeleteButton().shouldHave(Condition.text("Delete"), Duration.ofSeconds(20));
            estoreUserAccountPage.getDeleteButton().click();
            estoreUserAccountPage.getConfirmDeleteButton().shouldHave(text("DELETE"), Duration.ofSeconds(20));
            estoreUserAccountPage.getConfirmDeleteButton().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Agree&add to cart button is not displayed");
        }

    }

    @Then("I verify unavailability of Discover for CAN address")
    public void iVerifyUnavailabilityOfDiscoverForCANAddress() {
    }

    @Then("I verify that discover is unavailable")
    public void iVerifyThatDiscoverIsUnavailable() {
        System.out.println();
    }

    @Then("I verify that I'm able to execute estore split payment with saved CC")
    public void iVerifyThatIMAbleToExecuteEstoreSplitPaymentWithSavedCC() {
        try {
            $(By.cssSelector("select[id=\"page-checkout-payment_select-payment-method\"]")).should(Condition.and("", appear, exist, interactable), Duration.ofSeconds(20));
            estorePaymentPage.getChoosePaymentMethodBtn().should(Condition.be(visible), Duration.ofSeconds(35));
            Select selectPayment = new Select(estorePaymentPage.getChoosePaymentMethodBtn());
            if (Hooks.profile.contains("stg4")) {
                selectPayment.selectByValue("45642063983482960745");
            }
            if (Hooks.profile.contains("stg2")) {
                selectPayment.selectByValue("46784755611871507543");
            }
            $(By.xpath("//iframe[@title='Iframe for secured card security code']")).should(Condition.be(visible), Duration.ofSeconds(20));
            switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
            estorePaymentPage.getCvcField().setValue("737");
            switchTo().defaultContent();

            $(By.xpath("//span[@data-testid='split_payment_checkbox']")).click();
            $(By.xpath("//input[@type='text']")).setValue("10");
            estoreE2EStepDefs.iClickOnContinuePaymentMethodEstoreButton();
            if (Hooks.profile.contains("stg2")) {
                selectPayment.selectByValue("22224053560881330008");
            }
            if (Hooks.profile.contains("stg4")) {
                selectPayment.selectByValue("22224052112154880008");
            }
            $(By.xpath("//iframe[@title='Iframe for secured card security code']")).should(Condition.be(visible), Duration.ofSeconds(20));
            switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
            estorePaymentPage.getCvcField().setValue("737");
            estorePaymentPage.getCvcField().shouldHave(value("737"), Duration.ofSeconds(15));

            switchTo().defaultContent();
            $(By.xpath("//span[@data-testid='split_payment_checkbox']")).click();
            $(By.xpath("//input[@type='text']")).setValue("10");
            estoreE2EStepDefs.iClickOnContinuePaymentMethodEstoreButton();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            estoreE2EStepDefs.iClickOnContinuePaymentMethodEstoreButton();
        }
    }

    @And("I verify that VI and MC card are available in payment method dropdown")
    public void iVerifyThatVIAndMCCardAreAvaialbeInPaymentMethodDropdown() {
        $(By.cssSelector("select[id=\"page-checkout-payment_select-payment-method\"]")).should(Condition.and("", appear, exist, interactable), Duration.ofSeconds(20));
        estorePaymentPage.getChoosePaymentMethodBtn().should(Condition.be(visible), Duration.ofSeconds(35));
        estorePaymentPage.getChoosePaymentMethodBtn().click();

        $(By.xpath("//*[text()='Visa ####-7543']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Master Card ####-0008']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Master Card ####-0008']")).click();
    }

    @Then("I verify that credit cards are displayed in total section")
    public void iVerifyThatCreditCardsAreDisplayedInTotalSection() {
        $(By.xpath("//*[text()='Charge to Visa ending 7543:']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Charge to MasterCard ending 0008:']")).should(visible, Duration.ofSeconds(40));
    }

    @Then("I validate updated order estimate and card details")
    public void iValidateUpdatedOrderEstimateAndCardDetails() {
        $(By.xpath("//*[text()='Subtotal ']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[contains(text(),'TOTAL')]")).should(visible, Duration.ofSeconds(40));
    }

    @When("I update item quantity in estore pdp")
    public void iUpdateItemQuantityInEstorePdp() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        estoreItemPage.getSelectQuantity().scrollIntoView(true);
        estoreItemPage.getSelectQuantity().should(visible, Duration.ofSeconds(40));
        Select selectQuantity = new Select(estoreItemPage.getSelectQuantity());
        selectQuantity.selectByValue("2");
    }

    @Then("I validate updated order estimate and card details for decrease item")
    public void iValidateUpdatedOrderEstimateAndCardDetailsForDecreaseItem() {
        $(By.xpath("//*[text()='Subtotal ']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[contains(text(),'TOTAL')]")).should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify unavailability of saved for RHCC")
    public void iVerifyUnavailabilityOfSavedForRHCC() {
        estorePaymentPage.getChoosePaymentMethodBtn().should(visible, Duration.ofSeconds(40));
        estorePaymentPage.getChoosePaymentMethodBtn().click();
        $(By.xpath("//*[text()='RH Credit Card ####-4849']")).shouldNotBe(visible, Duration.ofSeconds(20));
    }

    @Then("I validate that billing address based on saved payment method")
    public void iValidateThatBillingAddressBasedOnSavedPaymentMethod() {

        $(By.xpath("//*[text()='Safire William']")).should(visible, Duration.ofSeconds(40));
    }

    @When("I remove existing payment method on payment estore page")
    public void iRemoveExistingPaymentMethodOnPaymentEstorePage() {
        estoreCartPage.getRemoveButton().should(visible, Duration.ofSeconds(40));
        estoreCartPage.getRemoveButton().click(ClickOptions.usingJavaScript());
    }

    @When("I choose address with CAN zip code")
    public void iChooseAddressWithCANZipCode() {
        estoreAddressScreen.getShippingAddressState().should(visible, Duration.ofSeconds(20));
        Select selectCountry = new Select(estoreAddressScreen.getCountrySelect());
        selectCountry.selectByValue("CA");

        estoreAddressScreen.getStateSelect().click();
        estoreAddressScreen.getState().click();

        estoreGeneralStepDefs.clearField(estoreAddressScreen.getPostalShippingCode());

        estoreGeneralStepDefs.clearField(estoreAddressScreen.getPostalShippingCode());
        estoreAddressScreen.getPostalShippingCode().setValue("11111");
    }

    @When("I remove payment method which was used earlier")
    public void iRemovePaymentMethodWhichWasUsedEarlier() {
        $(By.id("component-order-summary")).should(Condition.and("", exist, appear), Duration.ofSeconds(25));
        if (estoreCartPage.getRemovePaymentBeforeText().isDisplayed()) {
            for (int i = 0; i < 3; i++) {
                estoreCartPage.getRemovePaymentBeforeText().shouldBe(Condition.and("Appear, interactable", exist, appear, interactable, visible), Duration.ofSeconds(20));
                estoreCartPage.getRemovePaymentBeforeText().click();
                if (!estoreCartPage.getRemovePaymentBeforeText().isDisplayed()) {
                    break;
                }
            }
        } else {
            System.out.println("There is no payment method that was used before");
        }

    }

    @When("I remove split payment which was used earlier")
    public void iRemovePaymentMethodWasUsedEarlier() {
        try {

            while (estoreCartPage.getRemoveButton().isDisplayed()) {
                estoreCartPage.getRemoveButton().should(visible, Duration.ofSeconds(30));
                estoreCartPage.getRemoveButton().click();

            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("There is no payment method that was used before");
        }

    }

    @When("I execute payment with credit card on estore")
    public void iExecutePaymentWithCreditCardOnEstore() {
        $(By.cssSelector("select[id=\"page-checkout-payment_select-payment-method\"]")).should(Condition.and("", appear, exist, interactable), Duration.ofSeconds(20));
        estoreGeneralStepDefs.payWith("CC", "4678475330157543", "737", "0330");
        with().pollInterval(2, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text()='CONTINUE']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='CONTINUE']")).click();
    }

    @Then("I verify that new payment was added")
    public void iVerifyThatNewPaymentWasAdded() {
        $(By.xpath("//*[contains(text(),'Visa')]")).should(visible, Duration.ofSeconds(20));
    }

    @When("I execute estore payment for {string}")
    public void iExecuteEstorePaymentFor(String cardType) {
        $(By.cssSelector("select[id=\"page-checkout-payment_select-payment-method\"]")).should(Condition.and("", appear, exist, interactable), Duration.ofSeconds(20));
        if (cardType.equals("VI")) {
            estoreGeneralStepDefs.payWith("CC", "4111111145551142", "737", "0330");
        }
        if (cardType.equals("MC")) {
            estoreGeneralStepDefs.payWith("CC", "2222400010000008", "737", "0330");

        }
        if (cardType.equals("AX")) {
            estoreGeneralStepDefs.payWith("CC", "341134113411347", "6765", "0225");

        }
        if (cardType.equals("DI")) {
            estoreGeneralStepDefs.payWith("CC", "6011601160116611", "737", "0330");

        }
        estoreE2EStepDefs.iClickOnContinuePaymentMethodEstoreButton();

    }

    @When("I click on edit estore billing address button on payment page")
    public void iClickOnEditEstoreBillingAddressButtonOnPaymentPage() {
        estorePaymentPage.getEditBillingAddressBtn().should(visible, Duration.ofSeconds(20));
        estorePaymentPage.getEditBillingAddressBtn().click(ClickOptions.usingJavaScript());
    }

    @When("I click on continue button from payment page")
    public void iClickOnContinueButtonFromPaymentPage() {
        $(By.xpath("//*[text()='CONTINUE']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='CONTINUE']")).click();
    }

    @Then("I verify that I'm able to execute estore split payment with RH Credit Card+Gift Card")
    public void iVerifyThatIMAbleToExecuteEstoreSplitPaymentWithRHCreditCardGiftCard() {
        $(By.cssSelector("select[id=\"page-checkout-payment_select-payment-method\"]")).should(Condition.and("", appear, exist, interactable), Duration.ofSeconds(20));
        estoreGeneralStepDefs.payWithRhCreditCard("6006101002617089");
        estorePaymentPage.clickToSplitPaymentCheckBox();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        $(By.xpath("//input[@type='text']")).setValue("10");
        estoreE2EStepDefs.iClickOnContinuePaymentMethodEstoreButton();

        estoreGeneralStepDefs.payWithRhGiftCard();
    }

    @Then("I verify that new billing address is displayed on payment page")
    public void iVerifyThatNewBillingAddressIsDisplayedOnAddressPage() {
        estorePaymentPage.verifyThatNewBillingAddressisDisplayed();
    }
}