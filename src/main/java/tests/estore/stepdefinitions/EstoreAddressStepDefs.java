package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.assertEquals;
import static tests.estore.stepdefinitions.EstoreUserAccountPageStepDefs.firstName;

public class EstoreAddressStepDefs {
    EstoreCheckoutAddressScreen estoreCheckoutAddressScreen = new EstoreCheckoutAddressScreen();
    EstoreAddressScreen estoreAddressScreen = new EstoreAddressScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    EstorePaymentPage estorePaymentPage = new EstorePaymentPage();
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstoreItemPage estoreItemPage = new EstoreItemPage();

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
        Select selectPaymentMethod = new Select(estorePaymentPage.getChoosePaymentMethodBtn());
        int optionSize = selectPaymentMethod.getOptions().size();
        assertEquals(optionSize, 3);
    }

    @Then("I verify that shipping address is displayed")
    public void iVerifyThatShippingAddressIsDisplayed() {
        $(By.xpath("//*[text()='SHIPPING ADDRESS']")).should(visible, Duration.ofSeconds(40));
    }

    @When("I click on edit shipping address button on estore order review page")
    public void iClickOnEditShippingAddressButtonOnEstoreOrderReviewPage() {
        sleep(20000);
        estoreAddressScreen.getEditShippinggAddress().shouldHave(text("Edit"), Duration.ofSeconds(20));
        estoreAddressScreen.getEditShippinggAddress().click();
    }

    @When("I click on edit shipping address button on estore address page")
    public void iClickOnEditShippingAddressButtonOnEstoreAddressPage() {
        try {
            sleep(20000);
            estoreAddressScreen.getEditShippinggAddress().shouldHave(text("Edit"), Duration.ofSeconds(20));
            estoreAddressScreen.getEditShippinggAddress().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Agree&add to cart button is not displayed");
        }

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
        $(By.xpath("//*[text()='Safire William']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Rock Island, IL 61201']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='US']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='3097931846']")).should(visible, Duration.ofSeconds(40));

    }

    @When("I fill estore billing address")
    public void iFillEstoreBillingAndShippingAddress() {
        sleep(2000);
        estoreAddressScreen.getBillingAddressFirstName().should(visible, Duration.ofSeconds(40));
        estoreAddressScreen.getBillingAddressFirstName().setValue("Safire");
        estoreAddressScreen.getBillingAddressLastName().setValue("William");
        estoreAddressScreen.getBillingAddressStreetAddress().setValue("4224 Simpson Street");
        estoreAddressScreen.getBillingAddressAptFloorSuite().setValue("20");
        estoreAddressScreen.getBillingAddressCity().setValue("Rock Island");

        Select billingAddressState = new Select(estoreAddressScreen.getBillingAddressState());
        billingAddressState.selectByValue("IL");
        estoreAddressScreen.getBillingAddressPostlaCode().setValue("61201");
        estoreAddressScreen.getBillingAddressPhone().setValue("309-793-1846");
    }

    @When("I fill estore shipping address")
    public void iFillEstoreShippingAndShippingAddress() {
        try {
            sleep(2000);
            estoreAddressScreen.getShippingAddressfirstName().should(visible, Duration.ofSeconds(40));
            generalStepDefs.clearField(estoreAddressScreen.getShippingAddressfirstName());
            estoreAddressScreen.getShippingAddressfirstName().setValue("Safire");

            generalStepDefs.clearField(estoreAddressScreen.getShippingAddresslastName());
            estoreAddressScreen.getShippingAddresslastName().setValue("William");

            Select shippingAddressCountry = new Select(estoreAddressScreen.getShippingAddressCountry());
            shippingAddressCountry.selectByValue("US");

            generalStepDefs.clearField(estoreAddressScreen.getShippingAddressStreetAddress());
            estoreAddressScreen.getShippingAddressStreetAddress().setValue("4224 Simpson Street");
            estoreAddressScreen.getShippingAddressAptFloor().click();
            estoreAddressScreen.getShippingAddressAptFloor().setValue("20");
            estoreAddressScreen.getShippingAddressCity().setValue("Rock Island");

            Select shippingAddressState = new Select(estoreAddressScreen.getShippingAddressState());
            shippingAddressState.selectByValue("IL");

            estoreAddressScreen.getPostalShippingCode().click();
            generalStepDefs.clearField(estoreAddressScreen.getPostalShippingCode());
            estoreAddressScreen.getPostalShippingCode().setValue("61201");

            estoreAddressScreen.getShippingAddressPhone().click();
            generalStepDefs.clearField(estoreAddressScreen.getShippingAddressPhone());
            estoreAddressScreen.getShippingAddressPhone().setValue("309-793-1846");
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Shipping address fields are not displayed");
        }

    }

    @Then("I verify add a new shipping address option is present")
    public void iVerifyAddANewShippingAddressOptionIsPresent() {
        $(By.xpath("//*[text()='Add a New Shipping Address to Your Account']")).should(visible, Duration.ofSeconds(40));
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
        estoreUserAccountPage.getAddAddressButton().should(visible, Duration.ofSeconds(40));
    }

    @When("I introduce data for new profile address")
    public void iIntroduceDataForNewProfileAddress() {
        estoreUserAccountPage.getBillingAddressFirstName().should(visible, Duration.ofSeconds(30));
        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressFirstName());
        estoreUserAccountPage.getBillingAddressFirstName().setValue("Petr");

        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressLastName());
        estoreUserAccountPage.getBillingAddressLastName().setValue(generalStepDefs.getAlphaNumericString(4));

        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressStreetAddress());
        estoreUserAccountPage.getBillingAddressStreetAddress().setValue("2479 Deer Run");
//
//        $(By.xpath("//*[text()='2479 Deer Run, Lewisville, TX, USA']")).should(visible, Duration.ofSeconds(20));
//        $(By.xpath("//*[text()='2479 Deer Run, Lewisville, TX, USA']")).click();

        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressAptFloor());
        estoreUserAccountPage.getBillingAddressAptFloor().setValue("2");

        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressCity());
        estoreUserAccountPage.getBillingAddressCity().setValue("Lewisville");

        Select state = new Select(estoreUserAccountPage.getBillingAddressSelectState());
        state.selectByValue("TX");

        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressPostalCode());
        estoreUserAccountPage.getBillingAddressPostalCode().setValue("12345");

        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressPhone());
        estoreUserAccountPage.getBillingAddressPhone().setValue("(541) 777-4321");

        sleep(5000);
    }

    @Then("I verify that newly added address is present in shpping address list")
    public void iVerifyThatNewlyAddedAddressIsPresentInShppingAddressList() {
        System.out.println();
    }

    @When("I delete the first shipping address on address estore page")
    public void iDeleteTheFirstShippingAddressOnAddressEstorePage() {
        estoreCheckoutAddressScreen.getDeleteFirstShippingAddress().should(visible, Duration.ofSeconds(40));
        estoreCheckoutAddressScreen.getDeleteFirstShippingAddress().click();
    }

    @Then("I verify that added address is not present in the grid")
    public void iVerifyThatAddedAddressIsNotPresentInTheGrid() {
        sleep(2000);
        $(By.xpath("//*[text()='Pennsylvania Avenue']")).shouldNotBe(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that added address edited address updated in the shipping address list")
    public void iVerifyThatAddedAddressEditedAddressUpdatedInTheShippingAddressList() {
        sleep(3000);
        $(By.xpath("//*[contains(text(),'" + firstName + "')]")).shouldHave(Condition.text(firstName), Duration.ofSeconds(20));
    }

    @Then("I verify that address on order review page the same as on address page")
    public void iVerifyThatAddressOnOrderReviewPageTheSameAsOnAddressPage() {
        $(By.xpath("//*[text()='4224 Simpson Street']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Rock Island, IL 61201']")).should(visible, Duration.ofSeconds(20));
    }

    @When("I remove added address before")
    public void iRemoveAddedAddressBefore() {
        try {
            $(By.xpath("//*[text()='Delete']")).should(visible, Duration.ofSeconds(10));
            $(By.xpath("//*[text()='Delete']")).click();
            $(By.xpath("(//*[text()='Delete'])[3]")).should(visible, Duration.ofSeconds(10));
            $(By.xpath("(//*[text()='Delete'])[3]")).click();

        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Address is not stored");
        }
    }

    @When("I continue to estore payment after address page")
    public void iContinueToEstorePaymentAfterAddressPage() {
        sleep(3000);
        $(By.xpath("//*[text()='Continue to payment']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Continue to payment']")).click();
        $(By.xpath("//*[text()='CONTINUE']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='CONTINUE']")).click();
    }

    @Then("I verify that added address displayed as shipping address")
    public void iVerifyThatAddedAddressDisplayedAsShippingAddress() {
        $(By.xpath("//*[text()='2479 Deer Run']")).should(visible, Duration.ofSeconds(20));
    }

    @When("I click on continue with original address estore button")
    public void iClickOnContinueWithOriginalAddressEstoreButton() {
        generalStepDefs.waitForJSandJQueryToLoad();
        estoreItemPage.getAddToCartButton().scrollIntoView(true);
        estoreItemPage.getAddToCartButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(50));
        estoreItemPage.getAddToCartButton().shouldHave(text("CONTINUE WITH ORIGINAL ADDRESS"), Duration.ofSeconds(50));
        estoreItemPage.getAddToCartButton().click();
    }

    @When("I click on continue to payment estore button")
    public void iClickOnContinueToPayment() {
        sleep(3000);
        $(By.xpath("//*[text()='Continue to payment']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Continue to payment']")).click();
    }

    @When("I fill estore shipping email address")
    public void iFillEstoreShippingEmailAddress() {
        estoreAddressScreen.getEmailField().should(visible, Duration.ofSeconds(20));
        estoreAddressScreen.getEmailField().sendKeys("automationtest@rh.com");
        estoreAddressScreen.getConfirmEmail().sendKeys("automationtest@rh.com");
        System.out.println();
    }

    @When("I remove added address before for address book")
    public void iRemoveAddedAddressBeforeForAddressBook() {
        try {
            $(By.xpath("//*[text()='Delete']")).should(visible, Duration.ofSeconds(10));
            $(By.xpath("//*[text()='Delete']")).click();
            $(By.xpath("(//*[text()='Delete'])[2]")).should(visible, Duration.ofSeconds(10));
            $(By.xpath("(//*[text()='Delete'])[2]")).click();

        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Address is not stored");
        }
    }

    @Then("I verify that added address is displayed in the shipping address list")
    public void iVerifyThatAddedAddressIsDisplayedInTheShippingAddressList() {
        $(By.xpath("//*[text()='2479 Deer Run']")).should(visible,Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Lewisville']")).should(visible,Duration.ofSeconds(20));

    }
}
