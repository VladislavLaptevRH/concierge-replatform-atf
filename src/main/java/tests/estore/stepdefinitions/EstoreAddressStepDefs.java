package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.EstoreAddressScreen;
import tests.estore.pageObject.EstoreCheckoutAddressScreen;
import tests.estore.pageObject.EstorePaymentPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class EstoreAddressStepDefs {
    EstoreCheckoutAddressScreen estoreCheckoutAddressScreen = new EstoreCheckoutAddressScreen();
    EstoreAddressScreen estoreAddressScreen = new EstoreAddressScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    EstorePaymentPage estorePaymentPage = new EstorePaymentPage();

    @When("I click on edit estore billing address button")
    public void iClickOnEditEstoreBillingAddressButton() {
        estoreAddressScreen.getEditShippinggAddress().should(Condition.visible, Duration.ofSeconds(20));
        estoreAddressScreen.getEditShippinggAddress().click();
    }

    @When("I update shipping address for CAN")
    public void iUpdateShippingAddressForCAN() {
        sleep(4000);
        Select selectCountry = new Select(estoreAddressScreen.getCountrySelect());
        selectCountry.selectByValue("CA");
        Select shippingAddress = new Select(estoreAddressScreen.getShippingAddressState());
        shippingAddress.selectByValue("AB");
        estoreAddressScreen.getShippingAddressState();
        generalStepDefs.clearField(estoreAddressScreen.getPostalShippingCode());
        estoreAddressScreen.getPostalShippingCode().setValue("A1A1A1");

    }

    @Then("I verify unavailability for RHCC")
    public void iVerifyUnavailabilityForRHCC() {
        estorePaymentPage.getChoosePaymentMethodBtn().should(Condition.be(visible), Duration.ofSeconds(35));
        estorePaymentPage.getChoosePaymentMethodBtn().click();
        estorePaymentPage.getRhCreditCardPaymentOption().shouldNotBe(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that shipping address is displayed")
    public void iVerifyThatShippingAddressIsDisplayed() {
        $(By.xpath("//*[text()='SHIPPING ADDRESS']")).should(visible, Duration.ofSeconds(20));
    }

    @When("I click on edit shipping address button on estore order review page")
    public void iClickOnEditShippingAddressButtonOnEstoreOrderReviewPage() {
        sleep(20000);
        estoreAddressScreen.getEditShippinggAddress().shouldHave(text("Edit"), Duration.ofSeconds(20));
        estoreAddressScreen.getEditShippinggAddress().click();
    }

    @When("I click on edit shipping address button on estore address page")
    public void iClickOnEditShippingAddressButtonOnEstoreAddressPage() {
        sleep(20000);
        estoreAddressScreen.getEditShippinggAddress().shouldHave(text("Edit"), Duration.ofSeconds(20));
        estoreAddressScreen.getEditShippinggAddress().click();
    }

    @Then("I verify that current currency is canadian dollar")
    public void iVerifyThatCurrentCurrencyIsCanadianDollar() {
        $(By.xpath("//*[contains(text(),'C$')]")).should(visible, Duration.ofSeconds(30));
    }

    @When("I update shipping address for US")
    public void iUpdateShippingAddressForUS() {
        Select selectCountry = new Select(estoreAddressScreen.getCountrySelect());
        selectCountry.selectByValue("US");
        Select shippingAddress = new Select(estoreAddressScreen.getShippingAddressState());
        shippingAddress.selectByValue("CO");
        generalStepDefs.clearField(estoreAddressScreen.getPostalShippingCode());
        estoreAddressScreen.getPostalShippingCode().setValue("12345");
    }

    @When("I click on estore continue button")
    public void iClickOnEstoreContinueButton() {
        estoreCheckoutAddressScreen.getContinuePaymentButton().shouldHave(text(estoreCheckoutAddressScreen.getContinuePaymentButton().getText()), Duration.ofMinutes(1));
        executeJavaScript("arguments[0].scrollIntoView(true);", estoreCheckoutAddressScreen.getContinuePaymentButton());
        estoreCheckoutAddressScreen.getContinuePaymentButton().shouldHave(text(estoreCheckoutAddressScreen.getContinuePaymentButton().getText()), Duration.ofMinutes(1));
        estoreCheckoutAddressScreen.getContinuePaymentButton().click();
    }
}
