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
import tests.estore.pageObject.EstoreUserAccountPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static tests.estore.stepdefinitions.EstoreUserAccountPageStepDefs.firstName;

public class EstoreAddressStepDefs {
    EstoreCheckoutAddressScreen estoreCheckoutAddressScreen = new EstoreCheckoutAddressScreen();
    EstoreAddressScreen estoreAddressScreen = new EstoreAddressScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    EstorePaymentPage estorePaymentPage = new EstorePaymentPage();
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();

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


    @Then("I validate {string} which we have entered earlier")
    public void iValidateWhichWeHaveEnteredEarlier(String arg0) {
        $(By.xpath("//*[text()='Safire William']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Rock Island, IL 61201']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='US']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='3097931846']")).should(visible, Duration.ofSeconds(20));

    }

    @When("I fill estore billing address")
    public void iFillEstoreBillingAndShippingAddress() {
        estoreAddressScreen.getShippingAddressfirstName().should(visible, Duration.ofSeconds(20));
        estoreAddressScreen.getShippingAddressfirstName().setValue("Safire");
        estoreAddressScreen.getShippingAddresslastName().setValue("William");
        estoreAddressScreen.getShippingAddressStreetAddress().setValue("4224 Simpson Street");
        estoreAddressScreen.getShippingAddressAptFloor().setValue("20");
        estoreAddressScreen.getShippingAddressCity().setValue("Rock Island");

        Select shippingAddressState = new Select(estoreAddressScreen.getShippingAddressState());
        shippingAddressState.selectByValue("IL");
        estoreAddressScreen.getPostalShippingCode().setValue("61201");
        estoreAddressScreen.getShippingAddressPhone().setValue("309-793-1846");
        estoreAddressScreen.getShippingAddressEmail().setValue("safirewilliam@gmail.com");
        estoreAddressScreen.getShippingAddressConfirmEmail().setValue("safirewilliam@gmail.com");
    }

    @Then("I verify add a new shipping address option is present")
    public void iVerifyAddANewShippingAddressOptionIsPresent() {
        $(By.xpath("//*[text()='Add a New Shipping Address to Your Account']")).should(visible, Duration.ofSeconds(20));
    }

    @When("I click on estore my account icon")
    public void iClickOnEstoreMyAccountIcon() {
        try {
            estoreUserAccountPage.getProfileIconButton().should(Condition.visible, Duration.ofSeconds(5));
            estoreUserAccountPage.getProfileIconButton().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            estoreUserAccountPage.getProfileIconButtonDiv().should(Condition.visible, Duration.ofSeconds(5));
            estoreUserAccountPage.getProfileIconButtonDiv().click();
        }

    }

    @When("I click on estore profile button")
    public void iClickOnEstoreProfileButton() {
        estoreUserAccountPage.getProfileButton().shouldHave(Condition.text("PROFILE"), Duration.ofSeconds(30));
        estoreUserAccountPage.getProfileButton().click();
    }

    @Then("I verify that add address button is displayed")
    public void iVerifyThatAddAddressButtonIsDisplayed() {
        estoreUserAccountPage.getAddAddressButton().should(visible, Duration.ofSeconds(20));
    }

    @When("I introduce data for new profile address")
    public void iIntroduceDataForNewProfileAddress() {
        estoreUserAccountPage.getBillingAddressFirstName().setValue("Petr");
        estoreUserAccountPage.getBillingAddressLastName().setValue("William");
        estoreUserAccountPage.getBillingAddressStreetAddress().setValue("Pennsylvania Avenue");
        estoreUserAccountPage.getBillingAddressAptFloor().setValue("2");
        estoreUserAccountPage.getBillingAddressCity().setValue("New York");
        Select state = new Select(estoreUserAccountPage.getBillingAddressSelectState());
        state.selectByValue("IL");
        estoreUserAccountPage.getBillingAddressPostalCode().setValue("12345");
        estoreUserAccountPage.getBillingAddressPhone().setValue("(541) 777-4321");
    }

    @Then("I verify that newly added address is present in shpping address list")
    public void iVerifyThatNewlyAddedAddressIsPresentInShppingAddressList() {
        System.out.println();
    }

    @When("I delete the first shipping address on address estore page")
    public void iDeleteTheFirstShippingAddressOnAddressEstorePage() {
        estoreCheckoutAddressScreen.getDeleteFirstShippingAddress().should(visible, Duration.ofSeconds(20));
        estoreCheckoutAddressScreen.getDeleteFirstShippingAddress().click();
    }

    @Then("I verify that added address is not present in the grid")
    public void iVerifyThatAddedAddressIsNotPresentInTheGrid() {
        $(By.xpath("//*[text()='Pennsylvania Avenue']")).shouldNotBe(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that added address edited address updated in the shipping address list")
    public void iVerifyThatAddedAddressEditedAddressUpdatedInTheShippingAddressList() {
        sleep(3000);
        $(By.xpath("//*[contains(text(),'" + firstName + "')]")).shouldHave(Condition.text(firstName), Duration.ofSeconds(20));
    }

    @Then("I verify that address on order review page the same as on address page")
    public void iVerifyThatAddressOnOrderReviewPageTheSameAsOnAddressPage() {
        //billings address
        $(By.xpath("//*[text()='akshay soni']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='123 Advenue Street']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Vancouver, WA 98765']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='US']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='3342294667']")).should(visible, Duration.ofSeconds(20));
        //shipping address
        $(By.xpath("//*[text()='QA1cztJcmPchW Automation']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Qastreet']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='QaApartment']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Schenectady, NY 12345']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='US']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='3342294667']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='$4,195.00']")).should(visible,Duration.ofSeconds(20));
        $(By.xpath("//*[text()='PYRITE MOSAIC ROUND MIRROR']")).should(visible,Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Qty 1']")).should(visible,Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Subtotal ']")).should(visible,Duration.ofSeconds(20));
        $(By.xpath("(//*[text()='$4,195.00'])[2]")).should(visible,Duration.ofSeconds(20));
        $(By.xpath("//*[text()='TOTAL']")).should(visible,Duration.ofSeconds(20));
        $(By.xpath("//*[text()='$5,123.52']")).should(visible,Duration.ofSeconds(20));
        $(By.xpath("//*[text()='7543']")).should(visible,Duration.ofSeconds(20));
        $(By.xpath("//*[text()='PAYMENT INFORMATION']")).should(visible,Duration.ofSeconds(20));
    }

    @When("I remove added address before")
    public void iRemoveAddedAddressBefore() {
        try {
            $(By.xpath("//*[text()='Delete']")).should(visible, Duration.ofSeconds(10));
            $(By.xpath("//*[text()='Delete']")).click();
            $(By.xpath("(//*[text()='Delete'])[2]")).should(visible,Duration.ofSeconds(10));
            $(By.xpath("(//*[text()='Delete'])[2]")).click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Address is not stored");
        }
    }
}
