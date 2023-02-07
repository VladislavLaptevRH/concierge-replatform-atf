package tests.estore.stepdefinitions;

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
import static com.codeborne.selenide.Selenide.*;
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
        try {
            estoreGeneralStepDefs.payWith("CC", "4678475330157543", "737", "0330");
            with().pollInterval(3, SECONDS).await().until(() -> true);
            $(By.xpath("//span[@data-testid='split_payment_checkbox']")).click();
            $(By.xpath("//input[@type='text']")).setValue("10");
            estoreE2EStepDefs.iClickOnContinuePaymentMethodEstoreButton();

            with().pollInterval(3, SECONDS).await().until(() -> true);
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(3, SECONDS).await().until(() -> true);

            estoreGeneralStepDefs.payWith("CC", "2222400010000008", "737", "0330");
            estoreE2EStepDefs.iClickOnContinuePaymentMethodEstoreButton();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            estoreE2EStepDefs.iClickOnContinuePaymentMethodEstoreButton();
        }

    }

    @When("I choose saved card {string} from payment method dropdown")
    public void iChooseSaveCardFromPaymentMethodDropdown(String cardType) {
        with().pollInterval(7, SECONDS).await().until(() -> true);
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
        with().pollInterval(3, SECONDS).await().until(() -> true);
        estoreGeneralStepDefs.payWith("CC", "2222400010000008", "737", "0330");
        $(By.xpath("//*[text()='CONTINUE']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='CONTINUE']")).click();

        with().pollInterval(4, SECONDS).await().until(() -> true);
        $(By.xpath("(//a[@href='/checkout/payment.jsp'])[2]")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("(//a[@href='/checkout/payment.jsp'])[2]")).click();
        with().pollInterval(4, SECONDS).await().until(() -> true);
        estoreCartPage.getRemoveButton().should(visible, Duration.ofSeconds(40));
        estoreCartPage.getRemoveButton().click();
        with().pollInterval(4, SECONDS).await().until(() -> true);
        estoreGeneralStepDefs.payWith("CC", "2222400010000008", "737", "0330");
        estoreE2EStepDefs.iClickOnContinuePaymentMethodEstoreButton();
    }

    @When("I edit estore billing address from PG")
    public void iEditBillingAddressFromPG() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        $(By.xpath("//a[@href='/checkout/payment.jsp#/']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//a[@href='/checkout/payment.jsp#/']")).click();
        estoreAddressScreen.getShippingAddressFirstName().click();
        estoreGeneralStepDefs.clearField(estoreAddressScreen.getShippingAddressFirstName());
        estoreAddressScreen.getShippingAddressFirstName().setValue("NewBillingAddress");
    }


    @When("I pay with RHCC for estore item")
    public void iPayWithRHCCForEstoreItem() {
//        estorePaymentPage.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(5));
        with().pollInterval(5, SECONDS).await().until(() -> true);
        Select paymentMethod = new Select(estorePaymentPage.getChoosePaymentMethodBtn());
        paymentMethod.selectByValue("RH");
        estorePaymentPage.getRhCardNumberField().setValue("6006101002587290");
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
            with().pollInterval(4, SECONDS).await().until(() -> true);
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
            estorePaymentPage.getCvcField().setValue("321");
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
            with().pollInterval(2, SECONDS).await().until(() -> true);
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
        with().pollInterval(3, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text()='Safire William']")).should(visible, Duration.ofSeconds(40));
    }

    @When("I remove existing payment method on payment estore page")
    public void iRemoveExistingPaymentMethodOnPaymentEstorePage() {
        estoreCartPage.getRemoveButton().should(visible, Duration.ofSeconds(40));
        estoreCartPage.getRemoveButton().click();
    }

    @When("I choose address with CAN zip code")
    public void iChooseAddressWithCANZipCode() {
        estoreAddressScreen.getShippingAddressState().should(visible, Duration.ofSeconds(20));
        Select selectCountry = new Select(estoreAddressScreen.getCountrySelect());
        selectCountry.selectByValue("CA");
        with().pollInterval(2, SECONDS).await().until(() -> true);
        estoreGeneralStepDefs.clearField(estoreAddressScreen.getPostalShippingCode());
        with().pollInterval(2, SECONDS).await().until(() -> true);
        estoreGeneralStepDefs.clearField(estoreAddressScreen.getPostalShippingCode());

        estoreAddressScreen.getPostalShippingCode().setValue("A1A1A1");
    }

    @When("I remove payment method which was used earlier")
    public void iRemovePaymentMethodWhichWasUsedEarlier() {
        try {
            estoreCartPage.getRemoveButton().should(visible, Duration.ofSeconds(30));
            estoreCartPage.getRemoveButton().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("There is no payment method that was used before");
        }

    }

    @When("I remove split payment which was used earlier")
    public void iRemovePaymentMethodWasUsedEarlier() {
        try {
            with().pollInterval(8, SECONDS).await().until(() -> true);
            while (estoreCartPage.getRemoveButton().isDisplayed()) {
                estoreCartPage.getRemoveButton().should(visible, Duration.ofSeconds(30));
                estoreCartPage.getRemoveButton().click();
                with().pollInterval(4, SECONDS).await().until(() -> true);
            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("There is no payment method that was used before");
        }

    }

    @When("I execute payment with credit card on estore")
    public void iExecutePaymentWithCreditCardOnEstore() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
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
        with().pollInterval(5, SECONDS).await().until(() -> true);
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
}
