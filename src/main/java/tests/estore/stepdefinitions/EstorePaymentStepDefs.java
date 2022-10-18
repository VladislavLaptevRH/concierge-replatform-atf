package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.estore.pageObject.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

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
            sleep(3000);
            $(By.xpath("//span[@data-testid='split_payment_checkbox']")).click();
            $(By.xpath("//input[@type='text']")).setValue("10");
            estoreE2EStepDefs.iClickOnContinuePaymentMethodEstoreButton();

            sleep(3000);
            WebDriverRunner.getWebDriver().navigate().refresh();
            sleep(3000);

            estoreGeneralStepDefs.payWith("CC", "2222400010000008", "737", "0330");
            estoreE2EStepDefs.iClickOnContinuePaymentMethodEstoreButton();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            estoreE2EStepDefs.iClickOnContinuePaymentMethodEstoreButton();
        }

    }

    @When("I choose saved card {string} from payment method dropdown")
    public void iChooseSaveCardFromPaymentMethodDropdown(String cardType) {
        sleep(4000);
        estorePaymentPage.getChoosePaymentMethodBtn().should(Condition.be(visible), Duration.ofSeconds(35));
        Select selectPayment = new Select(estorePaymentPage.getChoosePaymentMethodBtn());
        if (cardType.equals("VI")) {
            selectPayment.selectByValue("45642063983482960745");
            $(By.xpath("//iframe[@title='Iframe for secured card security code']")).should(Condition.be(visible), Duration.ofMinutes(2));
            switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
        }
        if (cardType.equals("MC")) {
            selectPayment.selectByValue("22224052112154880008");
            $(By.xpath("//iframe[@title='Iframe for secured card security code']")).should(Condition.be(visible), Duration.ofMinutes(2));
            switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
        }

        estorePaymentPage.getCvcField().should(visible, Duration.ofSeconds(40));
        estorePaymentPage.getCvcField().setValue("737");
        switchTo().defaultContent();


//        $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container']//button")).click();
//                estorePaymentPage.getContinueToCheckout().should(visible,Duration.ofSeconds(20));
//        estorePaymentPage.getContinueToCheckout().click();

    }

    @Then("I verify that I'm able to edit payment")
    public void iVerifyThatIMAbleToEditPayment() {
        sleep(3000);
        estoreGeneralStepDefs.payWith("CC", "2222400010000008", "737", "0330");
        estoreE2EStepDefs.iClickOnContinuePaymentMethodEstoreButton();
        sleep(4000);
        $(By.xpath("(//a[@href='/checkout/payment.jsp'])[2]")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("(//a[@href='/checkout/payment.jsp'])[2]")).click();
        sleep(4000);
        estoreCartPage.getRemoveButton().should(visible, Duration.ofSeconds(40));
        estoreCartPage.getRemoveButton().click();
        sleep(4000);
        estoreGeneralStepDefs.payWith("CC", "2222400010000008", "737", "0330");
        estoreE2EStepDefs.iClickOnContinuePaymentMethodEstoreButton();
    }

    @When("I edit estore billing address from PG")
    public void iEditBillingAddressFromPG() {
        sleep(3000);
        estoreAddressScreen.getEditShippinggAddress().should(visible, Duration.ofSeconds(40));
        estoreAddressScreen.getEditShippinggAddress().click();
        $(By.xpath("//a[@href='/checkout/payment.jsp#/']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//a[@href='/checkout/payment.jsp#/']")).click();
        estoreAddressScreen.getBillingAddressFirstName().click();
        estoreGeneralStepDefs.clearField(estoreAddressScreen.getBillingAddressFirstName());
        estoreAddressScreen.getBillingAddressFirstName().setValue("NewBillingAddress");
    }


    @When("I pay with RHCC for estore item")
    public void iPayWithRHCCForEstoreItem() {
        estorePaymentPage.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(5));
        Select paymentMethod = new Select(estorePaymentPage.getChoosePaymentMethodBtn());
        paymentMethod.selectByValue("RH");
        estorePaymentPage.getRhCardNumberField().setValue("6006101002587258");
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
            sleep(4000);
            estorePaymentPage.getChoosePaymentMethodBtn().should(Condition.be(visible), Duration.ofSeconds(35));
            Select selectPayment = new Select(estorePaymentPage.getChoosePaymentMethodBtn());
            selectPayment.selectByValue("45642063983482960745");
            $(By.xpath("//iframe[@title='Iframe for secured card security code']")).should(Condition.be(visible), Duration.ofSeconds(20));
            switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
            estorePaymentPage.getCvcField().setValue("321");
            switchTo().defaultContent();
            $(By.xpath("//span[@data-testid='split_payment_checkbox']")).click();
            $(By.xpath("//input[@type='text']")).setValue("10");
            estoreE2EStepDefs.iClickOnContinuePaymentMethodEstoreButton();
            selectPayment.selectByValue("22224052112154880008");
            $(By.xpath("//iframe[@title='Iframe for secured card security code']")).should(Condition.be(visible), Duration.ofSeconds(20));
            switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
            estorePaymentPage.getCvcField().setValue("737");
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
        $(By.xpath("//*[text()='TOTAL']")).should(visible, Duration.ofSeconds(40));
    }

    @When("I update item quantity in estore pdp")
    public void iUpdateItemQuantityInEstorePdp() {
        sleep(3000);
        estoreItemPage.getSelectQuantity().scrollIntoView(true);
        estoreItemPage.getSelectQuantity().should(visible, Duration.ofSeconds(40));
        Select selectQuantity = new Select(estoreItemPage.getSelectQuantity());
        selectQuantity.selectByValue("2");
    }

    @Then("I validate updated order estimate and card details for decrease item")
    public void iValidateUpdatedOrderEstimateAndCardDetailsForDecreaseItem() {
        $(By.xpath("//*[text()='Subtotal ']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='TOTAL']")).should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify unavailability of saved for RHCC")
    public void iVerifyUnavailabilityOfSavedForRHCC() {
        estorePaymentPage.getChoosePaymentMethodBtn().should(visible, Duration.ofSeconds(40));
        estorePaymentPage.getChoosePaymentMethodBtn().click();
        $(By.xpath("//*[text()='RH Credit Card ####-4849']")).shouldNotBe(visible, Duration.ofSeconds(20));
    }

    @Then("I validate that billing address based on saved payment method")
    public void iValidateThatBillingAddressBasedOnSavedPaymentMethod() {
        sleep(3000);
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
        sleep(2000);
        estoreGeneralStepDefs.clearField(estoreAddressScreen.getPostalShippingCode());
        sleep(2000);
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
            sleep(8000);
            while (estoreCartPage.getRemoveButton().isDisplayed()) {
                estoreCartPage.getRemoveButton().should(visible, Duration.ofSeconds(30));
                estoreCartPage.getRemoveButton().click();
                sleep(4000);
            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("There is no payment method that was used before");
        }

    }

    @When("I execute payment with credit card on estore")
    public void iExecutePaymentWithCreditCardOnEstore() {
        sleep(5000);
        estoreGeneralStepDefs.payWith("CC", "4678475330157543", "737", "0330");
        estoreE2EStepDefs.iClickOnContinuePaymentMethodEstoreButton();

    }

    @Then("I verify that new payment was added")
    public void iVerifyThatNewPaymentWasAdded() {
        $(By.xpath("//*[contains(text(),'Visa')]")).should(visible, Duration.ofSeconds(20));
    }
}
