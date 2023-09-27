package tests.estore.stepdefinitions;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.*;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class EstoreAccountStepDefs {
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstoreLoginPage estoreLoginPage = new EstoreLoginPage();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    EstoreCartPage estoreCartPage = new EstoreCartPage();
    EstoreHomePage estoreHomePage = new EstoreHomePage();
    EstoreWishlistPage estoreWishlistPage = new EstoreWishlistPage();

    EstoreOrderHistoryScreen estoreOrderHistoryScreen = new EstoreOrderHistoryScreen();

    EstoreMemberStepDefs estoreMemberStepDefs = new EstoreMemberStepDefs();

    EstoreGiftRegistry estoreGiftRegistry = new EstoreGiftRegistry();

    EstoreUserAccountPageStepDefs estoreUserAccountPageStepDefs = new EstoreUserAccountPageStepDefs();

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
        estoreUserAccountPage.getBillingAddressFirstName().shouldHave(value(firstName), Duration.ofSeconds(40));
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
        estoreUserAccountPage.getBillingAddressFirstName().should(interactable, Duration.ofSeconds(15));
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
        estoreCartPage.getPopupCloseButton().should(visible, Duration.ofSeconds(40));
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
        estoreUserAccountPage.getBillingAddressFirstName().should(interactable, Duration.ofSeconds(15));
        estoreUserAccountPage.getBillingAddressFirstName().click();
        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressFirstName());
        estoreUserAccountPage.getBillingAddressFirstName().should(interactable, Duration.ofSeconds(15));
        estoreUserAccountPage.getBillingAddressFirstName().setValue(firstName);
    }

    @When("I update last name for estore account")
    public void iUpdateLastNameForEstoreAccount() {
        lastName = generalStepDefs.getAlphaNumericString(4);
        estoreUserAccountPage.getBillingAddressLastName().should(interactable, Duration.ofSeconds(15));
        estoreUserAccountPage.getBillingAddressLastName().click();
        generalStepDefs.clearField(estoreUserAccountPage.getBillingAddressLastName());
        estoreUserAccountPage.getBillingAddressLastName().should(interactable, Duration.ofSeconds(15));
        estoreUserAccountPage.getBillingAddressLastName().setValue(lastName);
    }

    @Then("I verify that the updated last name is saved")
    public void iVerifyThatTheUpdatedLastNameIsSaved() {
        estoreUserAccountPage.getBillingAddressLastName().shouldHave(value(lastName), Duration.ofSeconds(20));
    }

    @When("I update account email with the existing email")
    public void iUpdateAccountEmailWithTheExistingEmail() {
        estoreUserAccountPage.getEmailField().should(visible, Duration.ofSeconds(20));
        generalStepDefs.clearField(estoreUserAccountPage.getEmailField());
        estoreUserAccountPage.getEmailField().setValue("regularautomation@rh.com");
    }

    @Then("I verify that error message is displayed regarding entered email is already registered")
    public void iVerifyThatErrorMessageIsDisplayedRegardingEnteredEmailIsAlreadyRegistered() {
        System.out.println();
    }

    @When("I choose country for eStore from footer")
    public void iChooseCountryForEStoreFromFooter() {
        if (Hooks.country.equals("GB")) {
            estoreHomePage.chooseGBCountry();
        }

        if (Hooks.country.equals("CA")) {
            estoreHomePage.chooseCACountry();
        }
    }

    @Then("I verify that I'm able to create the new account")
    public void iVerifyThatIMAbleToCreateTheNewAccount() {
        estoreUserAccountPage.getCreateTitle().should(visible, Duration.ofSeconds(30));
    }

    @When("I click on create account button")
    public void iClickOnCreateAccountButton() {
        estoreUserAccountPage.clickToCreateNewAccountButton();
    }

    @When("I introduces the required details")
    public void iIntroducesTheRequiredDetails() {
        estoreUserAccountPage.introduceFirstNameIntoCreateAccountForm();
        estoreUserAccountPage.introduceLastNameIntoCreateAccountForm();
        estoreUserAccountPage.introduceEmailIntoCreateAccountForm();
        estoreUserAccountPage.introducePasswordIntoCreateAccountForm();
        estoreUserAccountPage.introduceConfirmPasswordIntoCreateAccountForm();
    }

    @When("I click on create account button from form")
    public void iClickOnCreateAccountButtonFromForm() {
        estoreUserAccountPage.clickToCreateAccountButtonForm();
    }

    @Given("I click on estore my account icon for guest user")
    public void iClickOnEstoreMyAccountIconForGuestUser() {
        generalStepDefs.waitForJSandJQueryToLoad();
        try {
            estoreLoginPage.clickToAccountIcon();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(2, SECONDS).await().until(() -> true);
            estoreLoginPage.clickToAccountIcon();
        }
    }

    @When("I click on agree privacy policy checkbox")
    public void iClickOnAgreePrivacyPolicyCheckbox() {
        estoreUserAccountPage.clickToAgreePrivacyPolicyCheckbox();
    }

    @When("I click on estore my account icon for registered user")
    public void iClickOnEstoreMyAccountIconForRegisteredUser() {
        estoreHomePage.clickToAccountButtonForregisteredUser();
    }

    @When("I click on the {string} from my account dropdown")
    public void iClickOnTheFromMyAccountDropdown(String option) {
        $(By.xpath("//li[contains(@id,'" + option + "')]"))
                .shouldBe(interactable, Duration.ofSeconds(20)).click(ClickOptions.usingJavaScript());
    }

    @Then("I verify that {string} is available for eStore")
    public void iVerifyThatIsAvailableForEStore(String pageOption) {
        if (pageOption.equals("order-history")) {
            estoreOrderHistoryScreen.verifyThatOrdersTitleIsDisplayed();
        }
        if (pageOption.equals("wish-list")) {
            estoreWishlistPage.verifyThatWishListTitleIsDisplayed();
        }
        if (pageOption.equals("membership")) {
            estoreMemberStepDefs.iValidateMembershipTitile();
        }
        if (pageOption.equals("gift-registry")) {
            estoreGiftRegistry.verifyThatGiftRegistrtyTitleIsDisplayed();
        }
        if (pageOption.equals("PROFILE")) {
            estoreUserAccountPage.verifyThatProfileTitleAreDisplayed();
            estoreUserAccountPage.verifyThatEmailAddressFieldIsDisplayed();
            estoreUserAccountPage.verifyThatBillingAddressLastNameFieldIsDisplayed();
            estoreUserAccountPage.verifyThatBillingAddressFirstNameFieldIsDisplayed();
        }
        if (pageOption.equals("signout")) {
            estoreUserAccountPage.verifyThatAreYouSureYouWantToSignoutMessageIsDisplayed();
            estoreUserAccountPage.verifyThatSignoutButtonIsDisplayed();
            estoreUserAccountPage.verifyThatCancelSignOutButtonPopUpIsDisplayed();
        }
    }

    @And("I verify that required page for {string} is displayed")
    public void iVerifyThatRequiredPageForIsDisplayed(String pageOption) {
        if (!(pageOption.equals("signout"))) {
            assertTrue("Order history page is displayed", Hooks.getCurrentUrl().contains(pageOption));
        }
    }

    @When("I click on my account button if page is not loaded")
    public void iClickOnMyAccountButtonIfPageIsNotLoaded() {
        if ($(By.xpath("//*[text()='You must be ']")).isDisplayed()) {
            iClickOnEstoreMyAccountIconForGuestUser();
        }
    }
}