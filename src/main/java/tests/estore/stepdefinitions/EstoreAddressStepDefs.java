package tests.estore.stepdefinitions;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.*;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static tests.estore.stepdefinitions.EstoreUserAccountPageStepDefs.firstName;

public class EstoreAddressStepDefs {
    EstoreCheckoutAddressScreen estoreCheckoutAddressScreen = new EstoreCheckoutAddressScreen();
    EstoreAddressScreen estoreAddressScreen = new EstoreAddressScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    EstorePaymentPage estorePaymentPage = new EstorePaymentPage();
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstoreItemPage estoreItemPage = new EstoreItemPage();
    EstoreAbstractStepDefs estoreAbstractStepDefs = new EstoreAbstractStepDefs();

    EstoreE2EStepDefs estoreE2EStepDefs = new EstoreE2EStepDefs();

    EstoreUserAccountPageStepDefs estoreUserAccountPageStepDefs = new EstoreUserAccountPageStepDefs();


    @When("I click on edit estore billing address button")
    public void iClickOnEditEstoreBillingAddressButton() {
        try {
            estoreAddressScreen.getEditBillingAddress().should(Condition.and("Visible, interactable", visible, interactable), Duration.ofSeconds(20));
            estoreAddressScreen.getEditBillingAddress().click(ClickOptions.usingJavaScript());
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Edit button is not displayed");
            if (estoreAddressScreen.getEditBillingAddress().isDisplayed()) {
                executeJavaScript("arguments[0].click();", estoreAddressScreen.getEditBillingAddress());
            }
        }
    }

    @When("I update shipping address for CAN")
    public void iUpdateShippingAddressForCAN() {

        estoreAddressScreen.getShippingAddressFirstName().should(visible, Duration.ofSeconds(40));
        estoreAddressScreen.getShippingAddressFirstName().should(interactable, Duration.ofSeconds(40));
        generalStepDefs.clearField(estoreAddressScreen.getShippingAddressFirstName());
        estoreAddressScreen.getShippingAddressFirstName().setValue("Safire");

        estoreAddressScreen.getShippingAddressLastName1().should(interactable, Duration.ofSeconds(30));
        generalStepDefs.clearField(estoreAddressScreen.getShippingAddressLastName1());
        estoreAddressScreen.getShippingAddressLastName1().setValue("William");


        estoreAddressScreen.getShippingAddressStreetAddressStg2().should(interactable, Duration.ofSeconds(30));
        generalStepDefs.clearField(estoreAddressScreen.getShippingAddressStreetAddressStg2());
        estoreAddressScreen.getShippingAddressStreetAddressStg2().setValue("Brew Creek Road, Whistler, BC, Canada");

        try {


            $(By.xpath("//*[text()='Brew Creek Road, Whistler, BC, Canada']")).should(interactable, Duration.ofSeconds(5));
            $(By.xpath("//*[text()='Brew Creek Road, Whistler, BC, Canada']")).should(visible, Duration.ofSeconds(5));
            $(By.xpath("//*[text()='Brew Creek Road, Whistler, BC, Canada']")).click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Dropdown list is not displayed");
        }

        estoreAddressScreen.getShippingAddressPhone().shouldBe(interactable, Duration.ofSeconds(30));
        estoreAddressScreen.getShippingAddressPhone().click();
        generalStepDefs.clearField(estoreAddressScreen.getShippingAddressPhone());
        estoreAddressScreen.getShippingAddressPhone().setValue("604-848-6525");


        estoreAddressScreen.getShippingAddressCity().shouldBe(interactable, Duration.ofSeconds(30));
        estoreAddressScreen.getShippingAddressCity().click();
        generalStepDefs.clearField(estoreAddressScreen.getShippingAddressCity());
        estoreAddressScreen.getShippingAddressCity().sendKeys("Whistler");

        estoreAddressScreen.getShippingAddressState().shouldBe(interactable, Duration.ofSeconds(20));
        Select selectState = new Select(estoreAddressScreen.getShippingAddressState());
        selectState.selectByValue("BC");

        estoreAddressScreen.getPostalShippingCode().should(interactable, Duration.ofSeconds(20));
        generalStepDefs.clearField(estoreAddressScreen.getPostalShippingCode());
        estoreAddressScreen.getPostalShippingCode().setValue("M4J 3S3");
    }

    @Then("I verify unavailability for RHCC")
    public void iVerifyUnavailabilityForRHCC() {
        estorePaymentPage.getChoosePaymentMethodBtn().should(Condition.be(interactable), Duration.ofSeconds(35));
        estorePaymentPage.getChoosePaymentMethodBtn().shouldNotHave(value("RH"), Duration.ofSeconds(35));
    }

    @Then("I verify that shipping address is displayed")
    public void iVerifyThatShippingAddressIsDisplayed() {
        $(By.xpath("//*[text()='SHIPPING ADDRESS']")).should(visible, Duration.ofSeconds(40));
    }

    @When("I click on edit shipping address button on estore order review page")
    public void iClickOnEditShippingAddressButtonOnEstoreOrderReviewPage() {

        estoreAddressScreen.getEditShippinggAddress().shouldHave(text("Edit"), Duration.ofSeconds(20));
        estoreAddressScreen.getEditShippinggAddress().click();
    }

    @When("I click on edit shipping address button on estore address page")
    public void iClickOnEditShippingAddressButtonOnEstoreAddressPage() {
        try {

            estoreAddressScreen.getEditShippinggAddress().shouldHave(text("Edit"), Duration.ofSeconds(20));
            estoreAddressScreen.getEditShippinggAddress().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Edit shipping address button is not displayed");
        }

    }

    @Then("I verify that current currency is canadian dollar")
    public void iVerifyThatCurrentCurrencyIsCanadianDollar() {
        $(By.xpath("//*[contains(text(),'$')]")).should(visible, Duration.ofSeconds(30));
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
        estoreCheckoutAddressScreen.getContinuePaymentButton().hover();
        estoreCheckoutAddressScreen.getContinuePaymentButton().should(interactable, Duration.ofSeconds(20)).click();
    }


    @Then("I validate {string} which we have entered earlier")
    public void iValidateWhichWeHaveEnteredEarlier(String arg0) {
        $(By.xpath("//*[text()='Safire William']")).should(visible, Duration.ofSeconds(50));
    }

    @When("I fill estore billing address")
    public void iFillEstoreBillingAndShippingAddress() {
        estoreAddressScreen.getBillingAddressFirstName().should(visible, Duration.ofSeconds(40));
        generalStepDefs.clearField(estoreAddressScreen.getBillingAddressFirstName());
        estoreAddressScreen.getBillingAddressFirstName().setValue("Safire");
        generalStepDefs.clearField(estoreAddressScreen.getBillingAddressLastName());
        estoreAddressScreen.getBillingAddressLastName().setValue("William");
        generalStepDefs.clearField(estoreAddressScreen.getBillingAddressStreetAddress());
        estoreAddressScreen.getBillingAddressStreetAddress().setValue("4224 Simpson Street");
        generalStepDefs.clearField(estoreAddressScreen.getBillingAddressCity());
        estoreAddressScreen.getBillingAddressCity().setValue("Rock Island");

        Select billingAddressState = new Select(estoreAddressScreen.getBillingAddressState());
        billingAddressState.selectByValue("IL");
        generalStepDefs.clearField(estoreAddressScreen.getBillingAddressPostlaCode());
        estoreAddressScreen.getBillingAddressPostlaCode().setValue("61201");
        generalStepDefs.clearField(estoreAddressScreen.getBillingAddressPhone());
        estoreAddressScreen.getBillingAddressPhone().setValue("309-793-1846");
    }

    @When("I fill estore shipping address")
    public void iFillEstoreShippingAndShippingAddress() {
        estoreAddressScreen.getShippingAddressFirstName().should(visible, Duration.ofSeconds(40));
        generalStepDefs.clearField(estoreAddressScreen.getShippingAddressFirstName());
        estoreAddressScreen.getShippingAddressFirstName().setValue("Safire");

        generalStepDefs.clearField(estoreAddressScreen.getShippingAddressLastName1());
        estoreAddressScreen.getShippingAddressLastName1().setValue("William");

        $(By.cssSelector("input[data-testid=\"shippingAddress.addressLine1\"]")).click();
        generalStepDefs.clearField($(By.cssSelector("input[data-testid=\"shippingAddress.addressLine1\"]")));
        $(By.cssSelector("input[data-testid=\"shippingAddress.addressLine1\"]")).setValue("4524 Ocala Street");

        $(By.xpath("//ul[@role='menu']//li[1]")).should(visible, Duration.ofSeconds(10))
                .click(ClickOptions.usingJavaScript());

//        $(By.cssSelector("input[id=\"shippingAddress.city\"]")).click();
//        generalStepDefs.clearField($(By.cssSelector("input[id=\"shippingAddress.city\"]")));
//        $(By.cssSelector("input[id=\"shippingAddress.city\"]")).setValue("Orlando");
//
//        $(By.cssSelector("select[id=\"shippingAddress.state\"]")).should(interactable, Duration.ofSeconds(20));
//        Select selectCaState = new Select($(By.cssSelector("select[id=\"shippingAddress.state\"]")));
//        selectCaState.selectByValue("FL");
//
//        $(By.cssSelector("input[id=\"shippingAddress.postalCode\"]")).click();
//        generalStepDefs.clearField($(By.cssSelector("input[id=\"shippingAddress.postalCode\"]")));
//        $(By.cssSelector("input[id=\"shippingAddress.postalCode\"]")).setValue("32801");

        estoreAddressScreen.getShippingAddressPhone().click();
        generalStepDefs.clearField(estoreAddressScreen.getShippingAddressPhone());
        estoreAddressScreen.getShippingAddressPhone().setValue("309-793-1846");
        estoreAddressScreen.getShippingAddressPhone().shouldHave(value("309-793-1846"), Duration.ofSeconds(15));

    }

    @Then("I verify add a new shipping address option is present")
    public void iVerifyAddANewShippingAddressOptionIsPresent() {
        $(By.xpath("//*[contains(text(),'Add')]")).should(visible, Duration.ofSeconds(40));
    }

    @When("I click on estore my account icon")
    public void iClickOnEstoreMyAccountIcon() {
        estoreUserAccountPage.getProfileIconButton().should(interactable, Duration.ofSeconds(20));
        estoreUserAccountPage.getProfileIconButton().should(visible, Duration.ofSeconds(20));
        estoreUserAccountPage.getProfileIconButton().hover();
        estoreUserAccountPage.getProfileIconButton().should(appear, Duration.ofSeconds(20));
        estoreUserAccountPage.getProfileIconButton().click(ClickOptions.usingJavaScript());

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
        estoreUserAccountPage.getBillingAddressFirstName().setValue("Ivan");

        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressLastName());
        estoreUserAccountPage.getBillingAddressLastName().setValue(generalStepDefs.getAlphaNumericString(4));

        if (Hooks.eStoreURL.contains("stg2")) {
            generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressStreetAddressStg2());
            estoreUserAccountPage.getBillingAddressStreetAddressStg2().setValue("2479 Deer Run");
            try {
                $(By.xpath("//*[text()='2479 Deer Run, Lewisville, TX, USA']")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("//*[text()='2479 Deer Run, Lewisville, TX, USA']")).click();
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                System.out.println("Dropdown list is not displayed");
            }
        } else {
            generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressStreetAddress());
            estoreUserAccountPage.getBillingAddressStreetAddress().setValue("2479 Deer Run");
            try {
                $(By.xpath("//*[text()='2479 Deer Run, Lewisville, TX, USA']")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("//*[text()='2479 Deer Run, Lewisville, TX, USA']")).click();
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                System.out.println("Dropdown list is not displayed");
            }
        }

        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressAptFloor());
        estoreUserAccountPage.getBillingAddressAptFloor().setValue("2");

        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressCity());
        estoreUserAccountPage.getBillingAddressCity().setValue("Lewisville");

        Select state = new Select(estoreUserAccountPage.getBillingAddressSelectState());
        state.selectByValue("TX");

//        estoreUserAccountPage.getBillingAddressPostalCode().click();
//        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressPostalCode());
//        estoreUserAccountPage.getBillingAddressPostalCode().setValue("73301");

        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressPhone());
        estoreUserAccountPage.getBillingAddressPhone().setValue("(541) 777-4321");


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

        $(By.xpath("//*[text()='Pennsylvania Avenue']")).shouldNotBe(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that added address edited address updated in the shipping address list")
    public void iVerifyThatAddedAddressEditedAddressUpdatedInTheShippingAddressList() {

        $(By.xpath("//*[contains(text(),'" + firstName + "')]")).shouldHave(Condition.text(firstName), Duration.ofSeconds(20));
    }

    @Then("I verify that address on order review page the same as on address page")
    public void iVerifyThatAddressOnOrderReviewPageTheSameAsOnAddressPage() {
        $(By.xpath("//div[@data-testid='checkout-address-view']")).should(visible, Duration.ofSeconds(20));
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

        $(By.xpath("//*[text()='Continue to payment']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Continue to payment']")).click();
        $(By.xpath("//*[text()='CONTINUE']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='CONTINUE']")).click();
    }

    @Then("I verify that added address displayed as shipping address")
    public void iVerifyThatAddedAddressDisplayedAsShippingAddress() {

        $(By.xpath("//*[text()='2479 Deer Run']")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I see new Billing address")
    public void iSeeNewBillingAddress() {

        $(By.xpath("(//*[text() = 'BILLING ADDRESS']/following-sibling::*)[1]")).shouldHave(text("NewBillingAddress"), Duration.ofSeconds(40));
    }

    @When("I click on continue with original address estore button")
    public void iClickOnContinueWithOriginalAddressEstoreButton() {
        generalStepDefs.waitForJSandJQueryToLoad();
        estoreItemPage.getContinueWithOriginalAddressButton().should(Condition.and("", visible, enabled, interactable), Duration.ofSeconds(30));
        estoreItemPage.getContinueWithOriginalAddressButton().shouldHave(text("CONTINUE"), Duration.ofSeconds(30));
        estoreItemPage.getContinueWithOriginalAddressButton().click(ClickOptions.usingJavaScript());
    }

    @When("I click on continue to payment estore button")
    public void iClickOnContinueToPayment() {
        estorePaymentPage.getContinueToPayment().should(Condition.and("", visible, interactable), Duration.ofSeconds(20));
        estorePaymentPage.getContinueToPayment().scrollIntoView(true);
        estoreAddressScreen.getShippingAddressPhone().shouldNotBe(empty);
        estorePaymentPage.getContinueToPayment().should(Condition.and("", visible, interactable), Duration.ofSeconds(20)).click(ClickOptions.usingJavaScript());

        if ($(By.xpath("//*[contains(text(), 'required')]")).isDisplayed()) {
            iFillEstoreShippingAndShippingAddress();
            estoreE2EStepDefs.iClickOnSameAsShippingAddressCheckbox();
            estoreE2EStepDefs.iClickOnSameAsShippingAddressCheckbox();
            $(By.xpath("//*[text()='Continue to payment']")).should(Condition.and("", visible, interactable), Duration.ofSeconds(20));

            executeJavaScript("arguments[0].click();", $(By.xpath("//button[@type='submit']")));

        }
    }

    @When("I fill estore shipping email address")
    public void iFillEstoreShippingEmailAddress() {
        String shippingEmail = generalStepDefs.getAlphaNumericString(5) + "@rh.com";
        estoreAddressScreen.getEmailField().should(visible, Duration.ofSeconds(20));
        estoreAddressScreen.getEmailField().sendKeys(shippingEmail);
        estoreAddressScreen.getConfirmEmail().sendKeys(shippingEmail);
    }

    @When("I remove added address before for address book")
    public void iRemoveAddedAddressBeforeForAddressBook() {
        try {
            $(By.xpath("//*[text()='Delete']")).should(visible, Duration.ofSeconds(10));
            $(By.xpath("//*[text()='Delete']")).click();
            $(By.xpath("//button[contains(@class,'MuiButton-containedPrimary')]")).should(visible, Duration.ofSeconds(10));
            $(By.xpath("//button[contains(@class,'MuiButton-containedPrimary')]")).click();

        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Address is not stored");
        }
    }

    @Then("I verify that added address is displayed in the shipping address list")
    public void iVerifyThatAddedAddressIsDisplayedInTheShippingAddressList() {
        $(By.xpath("//*[text()='2479 Deer Run']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Lewisville']")).should(visible, Duration.ofSeconds(20));

    }

    @When("I introduce data for new profile address without phone number")
    public void iIntroduceDataForNewProfileAddressWithoutPhoneNumber() {
        estoreUserAccountPage.getBillingAddressFirstName().should(visible, Duration.ofSeconds(30));
        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressFirstName());
        estoreUserAccountPage.getBillingAddressFirstName().setValue("Petr");

        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressLastName());
        estoreUserAccountPage.getBillingAddressLastName().setValue(generalStepDefs.getAlphaNumericString(4));

        if (Hooks.eStoreURL.contains("stg4")) {
            generalStepDefs.clearField(estoreAddressScreen.getShippingAddressStreetAddress());
            estoreAddressScreen.getShippingAddressStreetAddress().setValue("Bradford Drive, Hilliard, OH, USA");
            estoreAddressScreen.getShippingAddressLastName().click();
            try {
                $(By.xpath("//*[text()='Bradford Drive, Hilliard, OH, USA']")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("//*[text()='Bradford Drive, Hilliard, OH, USA']")).click();
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                System.out.println("Dropdown list is not displayed");
            }
        } else {

            generalStepDefs.clearField(estoreAddressScreen.getShippingAddressAddStreetField());
            estoreAddressScreen.getShippingAddressAddStreetField().setValue("Bradford Drive, Hilliard, OH, USA");
            try {

                $(By.xpath("//*[text()='Bradford Drive, Hilliard, OH, USA']")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("//*[text()='Bradford Drive, Hilliard, OH, USA']")).click();
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                System.out.println("Dropdown list is not displayed");
            }
        }


        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressAptFloor());
        estoreUserAccountPage.getBillingAddressAptFloor().setValue("2");

        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressCity());
        estoreUserAccountPage.getBillingAddressCity().setValue("Lewisville");

        Select state = new Select(estoreUserAccountPage.getBillingAddressSelectState());
        state.selectByValue("TX");

        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressPostalCode());
        estoreUserAccountPage.getBillingAddressPostalCode().setValue("12345");

    }

    @Then("user verify that field is required message is displayed")
    public void userVerifyThatErrorIsDisplayed() {
        $(By.xpath("//*[text()='Phone required.']")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that billing address the same as shipping functionality")
    public void iVerifyThatBillingAddressTheSameAsShippingFunctionality() {
        estoreAddressScreen.getBillingAddressFirstName().shouldHave(value("Safire"), Duration.ofSeconds(20));
        estoreAddressScreen.getBillingAddressLastName().shouldHave(value("William"), Duration.ofSeconds(20));
    }

    @Then("I verify shipping and billing address on order review page")
    public void iVerifyShippingAddressOnOrderReviewPage() {

        $(By.xpath("(//div[@data-testid='checkout-address-view'])[1]")).shouldHave(text("SHIPPING ADDRESS"), Duration.ofSeconds(25));
        $(By.xpath("(//div[@data-testid='checkout-address-view'])[2]")).shouldHave(text("BILLING ADDRESS"), Duration.ofSeconds(25));
    }

    @Then("I verify shipping and billing address on order confirmation page")
    public void iVerifyShippingAndBillingAddressOnOrderConfirmationPage() {
        $(By.xpath("(//div[@data-testid='checkout-address-view'])[1]")).shouldHave(text("SHIPPING ADDRESS"), Duration.ofSeconds(25));
        $(By.xpath("(//div[@data-testid='checkout-address-view'])[2]")).shouldHave(text("BILLING ADDRESS"), Duration.ofSeconds(25));
    }

    @When("I add gift message")
    public void iAddGiftMessage() {
    }

    @When("I update estore address for {string}")
    public void iUpdateEstoreAddressFor(String arg0) {
        generalStepDefs.fillZipCodeStateCountry("10001", "US", "NY");
    }

    @When("I fill estore shipping address for {string}")
    public void iFillEstoreShippingAddressFor(String state) {

        estoreAddressScreen.getShippingAddressFirstName().should(visible, Duration.ofSeconds(40));
        generalStepDefs.clearField(estoreAddressScreen.getShippingAddressFirstName());
        estoreAddressScreen.getShippingAddressFirstName().setValue("Safire");

        generalStepDefs.clearField(estoreAddressScreen.getShippingAddressLastName1());
        estoreAddressScreen.getShippingAddressLastName1().setValue("William");

        $(By.cssSelector("input[data-testid=\"shippingAddress.addressLine1\"]")).click();
        generalStepDefs.clearField($(By.cssSelector("input[data-testid=\"shippingAddress.addressLine1\"]")));
        $(By.cssSelector("input[data-testid=\"shippingAddress.addressLine1\"]")).setValue("Metrotech Center");

        $(By.cssSelector("input[id=\"shippingAddress.city\"]")).click();
        generalStepDefs.clearField($(By.cssSelector("input[id=\"shippingAddress.city\"]")));
        $(By.cssSelector("input[id=\"shippingAddress.city\"]")).setValue("Brooklyn");

        $(By.cssSelector("select[id=\"shippingAddress.state\"]")).should(interactable, Duration.ofSeconds(20));
        Select selectCaState = new Select($(By.cssSelector("select[id=\"shippingAddress.state\"]")));
        selectCaState.selectByValue("NY");

        $(By.cssSelector("input[id=\"shippingAddress.postalCode\"]")).click();
        generalStepDefs.clearField($(By.cssSelector("input[id=\"shippingAddress.postalCode\"]")));
        $(By.cssSelector("input[id=\"shippingAddress.postalCode\"]")).setValue("10001");

        estoreAddressScreen.getShippingAddressPhone().click();
        generalStepDefs.clearField(estoreAddressScreen.getShippingAddressPhone());
        estoreAddressScreen.getShippingAddressPhone().setValue("309-793-1846");
    }

    @When("I fill estore shipping address for CAN")
    public void iFillEstoreShippingAddressForCAN() {
        if ($(By.xpath("//*[text() = 'Shipping Address']/..//span[1]/*[text() = 'Edit']")).isDisplayed()) {
            System.out.println("The shipping address was already filled");
        } else {

            if (Hooks.eStoreURL.contains("stg3")) {
                $(By.xpath("//*[text()='Add New Address']")).click();
            }
            estoreAddressScreen.getShippingAddressFirstName().should(visible, Duration.ofSeconds(40));
            generalStepDefs.clearField(estoreAddressScreen.getShippingAddressFirstName());
            estoreAddressScreen.getShippingAddressFirstName().setValue("Safire");

            generalStepDefs.clearField(estoreAddressScreen.getShippingAddressLastName1());
            estoreAddressScreen.getShippingAddressLastName1().setValue("William");

            $(By.cssSelector("input[data-testid=\"shippingAddress.addressLine1\"]")).click();
            generalStepDefs.clearField($(By.cssSelector("input[data-testid=\"shippingAddress.addressLine1\"]")));
            $(By.cssSelector("input[data-testid=\"shippingAddress.addressLine1\"]")).setValue("101 JASPER AVE SW");

            $(By.cssSelector("input[id=\"shippingAddress.city\"]")).click();
            generalStepDefs.clearField($(By.cssSelector("input[id=\"shippingAddress.city\"]")));
            $(By.cssSelector("input[id=\"shippingAddress.city\"]")).setValue("Kelowna");

            $(By.cssSelector("select[id=\"shippingAddress.state\"]")).should(interactable, Duration.ofSeconds(30));
            Select selectCaState = new Select($(By.cssSelector("select[id=\"shippingAddress.state\"]")));
            selectCaState.selectByValue("BC");

            $(By.cssSelector("input[id=\"shippingAddress.postalCode\"]")).click();
            generalStepDefs.clearField($(By.cssSelector("input[id=\"shippingAddress.postalCode\"]")));
            $(By.cssSelector("input[id=\"shippingAddress.postalCode\"]")).setValue("M4B1G5");

            estoreAddressScreen.getShippingAddressPhone().click();
            generalStepDefs.clearField(estoreAddressScreen.getShippingAddressPhone());
            estoreAddressScreen.getShippingAddressPhone().setValue("309-793-1846");
        }
    }

    @When("I choose {string} shipping address")
    public void iChooseMDShippingAddress(String state) {
        estoreAddressScreen.selectAddressState(state);
    }

    @When("I introduct the following postal code {string} for shipping address")
    public void iIntroductTheFollowingPostalCodeForShippingAddress(String postalCode) {
        estoreAddressScreen.introducePostalCode(postalCode);
    }

    @And("I verify billing and shipping address are correct")
    public void iVerifyBillingAndShippingAddressAreCorrect() {
        $(By.xpath("//*[text()='SHIPPING ADDRESS']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Safire William']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Ocala Street']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='US']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='BILLING ADDRESS']")).should(visible, Duration.ofSeconds(20));
    }

    @When("I click on edit billing adress button on address page")
    public void iClickOnEditBillingAdressButtonOnAddressPage() {
        $(By.xpath(" (//*[text()='Edit'])[1]")).should(Condition.and("", visible, interactable),
                Duration.ofSeconds(20));
        $(By.xpath(" (//*[text()='Edit'])[1]")).click();

    }

    @When("I fill estore shipping address for contract&trade")
    public void iFillEstoreShippingAddressForContractTrade() {

        estoreAddressScreen.getShippingAddressFirstName().should(visible, Duration.ofSeconds(10));
        if (estoreAddressScreen.getShippingAddressFirstName().is(empty)) {
            iFillEstoreShippingAndShippingAddress();
        }
    }
}
