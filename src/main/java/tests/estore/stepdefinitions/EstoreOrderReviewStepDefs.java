package tests.estore.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.EstoreAddressScreen;
import tests.estore.pageObject.EstoreCartPage;
import tests.estore.pageObject.EstoreConfirmationOrderScreen;
import tests.estore.pageObject.EstoreReviewOrderPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class EstoreOrderReviewStepDefs {
    EstoreE2EStepDefs estoreE2EStepDefs = new EstoreE2EStepDefs();

    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    EstoreAddressStepDefs estoreAddressStepDefs = new EstoreAddressStepDefs();

    EstoreConfirmationOrderScreen estoreConfirmationOrderScreen = new EstoreConfirmationOrderScreen();

    EstoreAddressScreen estoreAddressScreen = new EstoreAddressScreen();

    EstoreCartPage estoreCartPage = new EstoreCartPage();

    EstoreReviewOrderPage estoreReviewOrderPage = new EstoreReviewOrderPage();

    @When("I click on estore edit payment button on order review page")
    public void iClickOnEstoreEditPaymentButtonOnOrderReviewPage() {
        $(By.xpath("(//*[text()='Edit'])[3]")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("(//*[text()='Edit'])[3]")).click();
    }

    @Then("I verify that payment has been changed")
    public void iVerifyThatPaymentHasBeenChanged() {
        $(By.xpath("//*[text()='7543']")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that I'm able to edit shipping and billing address")
    public void iVerifyThatIMAbleToEditShippingAndBillingAddress() {
        sleep(3000);
        $(By.xpath("(//*[@id='component-checkout-address-view_edit'])[1]")).should(visible, Duration.ofSeconds(20)).click();
        generalStepDefs.clearField($(By.id("shippingAddress.firstName")));
        $(By.id("shippingAddress.firstName")).should(visible, Duration.ofSeconds(40)).click();
        $(By.id("shippingAddress.firstName")).setValue("newShippingAddressName");
    }

    @When("I go to estore home page from thank you page")
    public void iGoToEstoreHomePageFromThankYouPage() {
        estoreConfirmationOrderScreen.clickToEstoreLogo();
    }

    @Then("I verify that shipping address was edited")
    public void iVerifyThatShippingAddressWasEdited() {
        $(By.xpath("//*[contains(text(), 'newShippingAddressName')]")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that billing address was edited")
    public void iVerifyThatBillingAddressWasEdited() {
        $(By.xpath("//*[contains(text(), 'newBillingAddressName')]")).should(visible, Duration.ofSeconds(20));
    }

    @And("I verify that I'm able to edit billing address on order review screen")
    public void iVerifyThatIMAbleToEditBillingAddressOnOrderReviewScreen() {
        $(By.xpath("(//*[@id='component-checkout-address-view_edit'])[2]")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("(//*[@id='component-checkout-address-view_edit'])[2]")).click();
        estoreAddressStepDefs.iClickOnEditEstoreBillingAddressButton();
    }

    @Then("I verify that I'm able to edit billing address from order review page")
    public void iVerifyThatIMAbleToEditBillingAddressFromOrderReviewPage() {
//        $(By.xpath("(//*[@id='component-checkout-address-view_edit'])[2]")).should(visible, Duration.ofSeconds(20)).click();
        $(By.id("billingAddress.firstName")).should(visible, Duration.ofSeconds(30));
        generalStepDefs.clearField($(By.id("billingAddress.firstName")));
        $(By.id("billingAddress.firstName")).should(visible, Duration.ofSeconds(40)).click();
        $(By.id("billingAddress.firstName")).setValue("newBillingAddressName");

    }

    @Then("I verify that Total Additional Product Discount message is displayed on order review page")
    public void iVerifyThatTotalAdditionalProductDiscountMessageIsDisplayedOnOrderReviewPage() {
        estoreCartPage.verifyThatTotalAdditionalProductDiscountMessageIsDisplayed();
    }

    @And("I verify that introduced order description message is displayed on {string} page")
    public void iVerifyThatIntrotucedOrderDescriptionMessageIsDisplayedOnPage(String message) {
        $(By.xpath("//*[text()='" + message + "']"))
                .should(visible, Duration.ofSeconds(30));
    }

    @When("I click on edit gift message on order review page")
    public void iClickOnEditGiftMessageOnOrderReviewPage() {
        estoreReviewOrderPage.clickToEditGiftMessageButton();
    }

    @Then("I verify the message {string} should be shown on {string} page")
    public void iVerifyTheMessageShouldBeShownOnPage(String arg0, String arg1) {
        estoreCartPage.verifyThatComponentMessageIsDisplayedForAllLineItems();
    }
}