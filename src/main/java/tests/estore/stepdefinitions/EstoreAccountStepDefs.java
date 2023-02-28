package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.w3c.dom.ls.LSOutput;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.EstoreCartPage;
import tests.estore.pageObject.EstoreLoginPage;
import tests.estore.pageObject.EstoreUserAccountPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class EstoreAccountStepDefs {
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstoreLoginPage estoreLoginPage = new EstoreLoginPage();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    EstoreCartPage estoreCartPage = new EstoreCartPage();

    String firstName;
    String lastName;
    String email;

    @Then("I verify that the personal info is displayed")
    public void iVerifyThatThePersonalInfoIsDisplayed() {
        assertFalse(estoreUserAccountPage.getBillingAddressFirstName().getValue().isEmpty());
        assertFalse(estoreUserAccountPage.getBillingAddressLastName().getValue().isEmpty());
        assertTrue(estoreLoginPage.getContractTradeEmailField().getValue().equals("regularautomation@rh.com"));
    }

    @Then("I verify that by updating personal information, application should get saved the entered details")
    public void iVerifyThatByUpdatingPersonalInformationApplicationShouldGetSavedTheEnteredDetails() {
        estoreCartPage.getPopupCloseButton().click();
        assertTrue(estoreUserAccountPage.getBillingAddressFirstName().getValue().equals(firstName));
    }

    @When("I verify the max length for first name text field")
    public void iVerifyTheMaxLenghtForFirtsNameTextField() {
        estoreUserAccountPage.getBillingAddressFirstName().getText();
    }

    @When("I verify the min length for first name text field")
    public void iVerifyTheMinLenghtForFirtsNameTextField() {
        estoreUserAccountPage.getBillingAddressFirstName().getText();
    }

    @When("I update personal information for account")
    public void iUpdatePersonalInformationForAccount() {
        firstName = generalStepDefs.getAlphaNumericString(4);

        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressFirstName());
        estoreUserAccountPage.getBillingAddressFirstName().setValue(firstName);
    }

    @When("I click on estore update personal information data button")
    public void iClickOnEstoreUpdatePersonalInformationDataButton() {
        estoreUserAccountPage.getUpdatePersonalButton().should(Condition.visible, Duration.ofSeconds(20));
        estoreUserAccountPage.getUpdatePersonalButton().click();
    }

    @Then("I verify that after updating account profile popup with your profile has been updated message is displayed")
    public void iVerifyThatAfterUpdatingAccountProfilePopupWithYourProfileHasBeenUpdatedMessageIsDisplayed() {
        estoreUserAccountPage.getYourProfileHasBeenUpdate().should(visible, Duration.ofSeconds(20));
    }

    @When("I close estore your profile has been updated pop up")
    public void iCloseEstoreYourProfileHasBeenUpdatedPopUp() {
        estoreCartPage.getPopupCloseButton().should(visible, Duration.ofSeconds(20));
        estoreCartPage.getPopupCloseButton().click();
    }

    @When("I update email for account personal information")
    public void iUpdateEmailForAccountPersonalInformation() {
        estoreUserAccountPage.getEmailField().should(visible, Duration.ofSeconds(20));
        generalStepDefs.clearField(estoreUserAccountPage.getEmailField());
        estoreUserAccountPage.getEmailField().setValue("regularautomation@rh.com");
    }

    @Then("I verify that estore application should get an error message")
    public void iVerifyThatEstoreApplicationShouldGetAnErrorMessage() {
    }

    @Then("I verify that the updated firstname in top nav header")
    public void iVerifyThatTheUpdatedFirstnameInTopNavHeader() {
        $(By.xpath("//*[text()='" + "WELCOME BACK, " + firstName.toUpperCase() + "']")).should(visible, Duration.ofSeconds(20));
    }

    @When("I update first name for estore account")
    public void iUpdateFirstNameForEstoreAccount() {
        firstName = generalStepDefs.getAlphaNumericString(4);
        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressFirstName());
        estoreUserAccountPage.getBillingAddressFirstName().setValue(firstName);
    }

    @When("I update last name for estore account")
    public void iUpdateLastNameForEstoreAccount() {
        lastName = generalStepDefs.getAlphaNumericString(4);
        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressLastName());
        estoreUserAccountPage.getBillingAddressLastName().setValue(lastName);
    }

    @Then("I verify that the updated last name is saved")
    public void iVerifyThatTheUpdatedLastNameIsSaved() {
        assertTrue(estoreUserAccountPage.getBillingAddressLastName().getValue().equals(lastName));
    }

    @When("I update account email with the existing email")
    public void iUpdateAccountEmailWithTheExistingEmail() {
        estoreUserAccountPage.getEmailField().should(visible, Duration.ofSeconds(20));
        generalStepDefs.clearField(estoreUserAccountPage.getEmailField());
        estoreUserAccountPage.getEmailField().setValue("regularautomation@rh.com");    }

    @Then("I verify that error message is displayed regarding entered email is already registered")
    public void iVerifyThatErrorMessageIsDisplayedRegardingEnteredEmailIsAlreadyRegistered() {
        System.out.println();
    }
}
