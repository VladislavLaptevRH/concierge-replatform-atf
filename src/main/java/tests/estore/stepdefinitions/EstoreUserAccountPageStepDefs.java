package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.EstoreAddressScreen;
import tests.estore.pageObject.EstorePaymentPage;
import tests.estore.pageObject.EstoreUserAccountPage;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;

public class EstoreUserAccountPageStepDefs {
    EstoreGeneralStepDefs estoreGeneralStepDefs = new EstoreGeneralStepDefs();
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstorePaymentPage estorePaymentPage = new EstorePaymentPage();
    EstoreAddressScreen estoreAddressScreen = new EstoreAddressScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    static String firstName;

    @When("I go to profile payment method")
    public void iGoToProfilePaymentMethod() {
        String URL = Hooks.eStoreBaseURL + "/my-account/payment-info.jsp";
        open(URL);
        with().pollInterval(2, SECONDS).await().until(() -> true);
    }


    @When("I add new card for estore")
    public void iAddNewCardForEstore() {
        estoreUserAccountPage.getAddCardButton().should(Condition.visible, Duration.ofSeconds(30));
        estoreUserAccountPage.getAddCardButton().click();
        estoreUserAccountPage.getSelectTypeOfCardNewCard().should(Condition.visible, Duration.ofSeconds(20));
        Select selectCard = new Select(estoreUserAccountPage.getSelectTypeOfCardNewCard());
        selectCard.selectByValue("CC");
        switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card number']")));
        estorePaymentPage.getCardNumberField().setValue("4111111145551142");
        switchTo().defaultContent();
        switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card expiry date']")));
        estorePaymentPage.getExpiryDateField().setValue("0330");
        switchTo().defaultContent();
        switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
        estorePaymentPage.getCvcField().setValue("737");

        switchTo().defaultContent();
        estoreUserAccountPage.getBillingAddressFirstName().setValue("TestName");
        estoreUserAccountPage.getBillingAddressLastName().setValue("TestLastName");
        if (Hooks.eStoreBaseURL.contains("stg2")) {
            estoreUserAccountPage.getBillingAddressStreetAddressStg2().should(visible, Duration.ofSeconds(20));
            estoreUserAccountPage.getBillingAddressStreetAddressStg2().setValue("Bradford Drive, Hilliard, OH, USA");
            try {
                $(By.xpath("//*[text()='Bradford Drive, Hilliard, OH, USA']")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("//*[text()='Bradford Drive, Hilliard, OH, USA']")).click();
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                System.out.println("Dropdown list is not displayed");
            }
        } else {
            estoreUserAccountPage.getBillingAddressStreetAddress().setValue("Bradford Drive, Hilliard, OH, USA");
            generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressStreetAddress());
            estoreUserAccountPage.getBillingAddressStreetAddress().setValue("2479 Deer Run");
            estoreAddressScreen.getCityAddNewCard().setValue("Hilliard");
            Select selectCardState = new Select(estoreAddressScreen.getStateAddNewCard());
            selectCardState.selectByValue("OH");
            estoreAddressScreen.getPostalCodeAddNewCard().setValue("99950");

        }
        estoreUserAccountPage.getBillingAddressAptFloor().setValue("2");
        estoreUserAccountPage.getBillingAddressPhone().setValue("(555) 555-1234");
        with().pollInterval(3, SECONDS).await().until(() -> true);
        estoreUserAccountPage.getSaveCardButton().should(visible, Duration.ofSeconds(20));
        estoreUserAccountPage.getSaveCardButton().click();

    }

    @When("I update the address details")
    public void iUpdateTheAddressDetails() {
        estoreAddressScreen.getEditShippinggAddress().shouldHave(Condition.text("Edit"), Duration.ofSeconds(20));
        estoreAddressScreen.getEditShippinggAddress().click();

        estoreUserAccountPage.getSelectTypeOfCardNewCard().should(Condition.visible, Duration.ofSeconds(20));
        Select selectCard = new Select(estoreUserAccountPage.getSelectTypeOfCardNewCard());
        selectCard.selectByValue("CC");
        switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card number']")));
        estorePaymentPage.getCardNumberField().setValue("4678475330157543");
        switchTo().defaultContent();
        switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card expiry date']")));
        estorePaymentPage.getExpiryDateField().setValue("0330");
        switchTo().defaultContent();
        switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
        estorePaymentPage.getCvcField().setValue("737");
        switchTo().defaultContent();

        firstName = estoreGeneralStepDefs.generateRandomString(5);
        with().pollInterval(3, SECONDS).await().until(() -> true);
        estoreUserAccountPage.getBillingAddressFirstName().clear();
        estoreUserAccountPage.getBillingAddressFirstName().setValue(firstName);

        estoreUserAccountPage.getSaveCardButton().should(visible, Duration.ofSeconds(30));
        estoreUserAccountPage.getSaveCardButton().click();
    }

    @Then("I verify that it is shows new address")
    public void iVerifyThatItIsShowsNewAddress() {
        $(By.xpath("//*[contains(text(),'" + firstName + "')]")).shouldHave(Condition.text(firstName), Duration.ofSeconds(20));
    }

    @When("I click on address book estore button")
    public void iClickOnAddressBookEstoreButton() {
        estoreUserAccountPage.getAddressBookButton().should(Condition.visible, Duration.ofSeconds(20));
        estoreUserAccountPage.getAddressBookButton().click();
    }

    @Given("I log into eStore as guest")
    public void iLogIntoEStoreAsGuest() {
        System.out.println("Login as guest");
    }

    @When("I click on estore my account button")
    public void iClickOnEstoreMyAccountButton() {
        estoreUserAccountPage.getMyProfileButton().shouldHave(Condition.text("My Account"), Duration.ofSeconds(30));
        estoreUserAccountPage.getMyProfileButton().click();
    }

    @When("I click on add address button")
    public void iClickOnAddAddressButton() {
        estoreUserAccountPage.getAddAddressButton().should(visible, Duration.ofSeconds(40));
        estoreUserAccountPage.getAddAddressButton().click();

    }

    @When("I click on save address button")
    public void iClickOnSaveAddressButton() {
        estoreUserAccountPage.getSaveAddressButton().should(visible, Duration.ofSeconds(40));
        estoreUserAccountPage.getSaveAddressButton().scrollIntoView(true);
        estoreUserAccountPage.getSaveAddressButton().click();
    }

    @Then("I verify that error messages are displayed for each mandatory field")
    public void iVerifyThatErrorMessagesAreDisplayedForEachMandatoryField() {
        estoreUserAccountPage.getFirstNameRequired().should(visible, Duration.ofSeconds(40));
        estoreUserAccountPage.getLastNameRequired().should(visible, Duration.ofSeconds(40));
        estoreUserAccountPage.getCityRequired().should(visible, Duration.ofSeconds(40));
        estoreUserAccountPage.getStateRequired().should(visible, Duration.ofSeconds(40));
        estoreUserAccountPage.getPostalCodeRequired().should(visible, Duration.ofSeconds(40));
        estoreUserAccountPage.getPhoneRequired().should(visible, Duration.ofSeconds(40));
    }


    @Then("I verify that added address present in the grid")
    public void iVerifyThatAddedAddressPresentInTheGrid() {
        $(By.xpath("//*[contains(text(),'2479 Deer Run')]")).should(visible, Duration.ofSeconds(40));
    }

    @When("I click on delete estore button")
    public void iClickOnDeleteEstoreButton() {
        estoreUserAccountPage.getDeleteAddedAddressButton().should(visible, Duration.ofSeconds(40));
        estoreUserAccountPage.getDeleteAddedAddressButton().click();
    }

    @When("I click on delete address button from appeared pop up")
    public void iClickOnDeleteAddressButtonFromAppearedPopUp() {
        estoreUserAccountPage.getUseIWantToDeleteAddedAddress().should(visible, Duration.ofSeconds(40));
        estoreUserAccountPage.getUseIWantToDeleteAddedAddress().click();
    }

    @When("I edit existing address on address book page")
    public void iEditExistingAddressOnAddressBookPage() {
        estoreAddressScreen.getEditShippinggAddress().should(visible, Duration.ofSeconds(40));
        estoreAddressScreen.getEditShippinggAddress().click();
        firstName = estoreGeneralStepDefs.generateRandomString(5);
        estoreUserAccountPage.getBillingAddressFirstName().setValue(firstName);
    }

    @When("I added new card {string} for estore")
    public void iAddedNewCardForEstore(String paymentMethod) {
        estoreUserAccountPage.getAddCardButton().should(Condition.visible, Duration.ofSeconds(30));
        estoreUserAccountPage.getAddCardButton().click();
        estoreUserAccountPage.getSelectTypeOfCardNewCard().should(Condition.visible, Duration.ofSeconds(20));
        Select selectCard = new Select(estoreUserAccountPage.getSelectTypeOfCardNewCard());

        if (paymentMethod.equals("AMEX")) {
            selectCard.selectByValue("CC");
            switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card number']")));
            estorePaymentPage.getCardNumberField().setValue("341134113411347");
            switchTo().defaultContent();
            switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card expiry date']")));
            estorePaymentPage.getExpiryDateField().setValue("0225");
            switchTo().defaultContent();
            switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
            estorePaymentPage.getCvcField().setValue("6765");
        }
        if (paymentMethod.equals("VISA")) {
            selectCard.selectByValue("CC");
            switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card number']")));
            estorePaymentPage.getCardNumberField().setValue("4678475330157543");
            switchTo().defaultContent();
            switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card expiry date']")));
            estorePaymentPage.getExpiryDateField().setValue("0330");
            switchTo().defaultContent();
            switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
            estorePaymentPage.getCvcField().setValue("737");
        }
        if (paymentMethod.equals("MC")) {
            selectCard.selectByValue("CC");
            switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card number']")));
            estorePaymentPage.getCardNumberField().setValue("2222400010000008");
            switchTo().defaultContent();
            switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card expiry date']")));
            estorePaymentPage.getExpiryDateField().setValue("0330");
            switchTo().defaultContent();
            switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
            estorePaymentPage.getCvcField().setValue("737");
        }
        if (paymentMethod.equals("DISCOVER")) {
            if (Hooks.profile.contains("stg4")) {
                selectCard.selectByValue("CC");
                switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card number']")));
                estorePaymentPage.getCardNumberField().setValue("6011311276791204");
                switchTo().defaultContent();
                switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card expiry date']")));
                estorePaymentPage.getExpiryDateField().setValue("0224");
                switchTo().defaultContent();
                switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
                estorePaymentPage.getCvcField().setValue("238");
            }
            if (Hooks.profile.contains("stg2")) {
                selectCard.selectByValue("CC");
                switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card number']")));
                estorePaymentPage.getCardNumberField().setValue("6011601160116611");
                switchTo().defaultContent();
                switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card expiry date']")));
                estorePaymentPage.getExpiryDateField().setValue("0330");
                switchTo().defaultContent();
                switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
                estorePaymentPage.getCvcField().setValue("737");
            }

        }

        switchTo().defaultContent();
        estoreUserAccountPage.getBillingAddressFirstName().setValue("TestName");
        estoreUserAccountPage.getBillingAddressLastName().setValue("TestLastName");
        if (Hooks.eStoreBaseURL.contains("stg2")) {
            estoreUserAccountPage.getBillingAddressStreetAddressStg2().should(visible, Duration.ofSeconds(20));
            estoreUserAccountPage.getBillingAddressStreetAddressStg2().setValue("Bradford Drive, Hilliard, OH, USA");
            try {
                $(By.xpath("//*[text()='Bradford Drive, Hilliard, OH, USA']")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("//*[text()='Bradford Drive, Hilliard, OH, USA']")).click();
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                System.out.println("Dropdown list is not displayed");
            }
        } else {
            generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressStreetAddress());
            estoreUserAccountPage.getBillingAddressStreetAddress().setValue("2479 Deer Run");
            estoreAddressScreen.getCityAddNewCard().setValue("Hilliard");
            Select selectCardState = new Select(estoreAddressScreen.getStateAddNewCard());
            selectCardState.selectByValue("OH");
            estoreAddressScreen.getPostalCodeAddNewCard().setValue("99950");
        }
        estoreUserAccountPage.getBillingAddressAptFloor().setValue("2");
        estoreUserAccountPage.getBillingAddressPhone().setValue("(555) 555-1234");
        with().pollInterval(3, SECONDS).await().until(() -> true);
        estoreUserAccountPage.getSaveCardButton().should(visible, Duration.ofSeconds(20));
        estoreUserAccountPage.getSaveCardButton().click();
    }

    @Then("I verify that I'm able to add {string}")
    public void iVerifyThatIMAbleToAdd(String paymentMethod) {
        if (paymentMethod.equals("AMEX")) {
            $(By.xpath("//*[contains(text(),'American Express')]")).should(visible, Duration.ofSeconds(20));
        }
        if (paymentMethod.equals("DISCOVER")) {
            $(By.xpath("(//*[contains(text(),'Discover')])[2]")).should(visible, Duration.ofSeconds(20));
        }
    }

    @When("I goes to my account for estore")
    public void iGoesToMyAccountForEstore() {
        String URL = Hooks.eStoreBaseURL + "/my-account/profile.jsp";
        open(URL);

    }
}
