package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.estore.pageObject.EstoreGiftRegistry;
import tests.utility.Hooks;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistryStepDefs {
    EstoreGiftRegistry estoreGiftRegistry = new EstoreGiftRegistry();

    EstoreGeneralStepDefs estoreGeneralStepDefs = new EstoreGeneralStepDefs();

    String firstNameRegistry = estoreGeneralStepDefs.getAlphaNumericString(5);
    String lastNameRegistry = estoreGeneralStepDefs.getAlphaNumericString(5);

    @When("I click on create a registry button")
    public void iClickOnCreateARegistryButton() {
        estoreGiftRegistry.clickToCreateARegistryButton();
    }

    @When("I click on manage your registry button")
    public void iClickOnManageARegistryButton() {
        estoreGiftRegistry.clickToManageYourRegistryButton();
    }

    @When("I click on find registry button")
    public void iClickOnFindRegistryButton() {
        estoreGiftRegistry.clickToFindARegistryButton();
    }

    @When("I go to create the new registry page for eStore")
    public void iGoToCreateTheNewRegistryPageForEStore() {
        open(Hooks.eStoreBaseURL + "/gift-registry/create-a-registry.jsp");
    }

    @When("I fill all required fields to create the new registry")
    public void iFillAllRequiredFiledsToCreateTheNewRegistry() {
        estoreGiftRegistry.selectRegistryEventType("wedding");
        estoreGiftRegistry.selectEventTimeDate();

        estoreGiftRegistry.introduceRegistrantFirstName();
        estoreGiftRegistry.introduceRegistrantLastName();
        estoreGiftRegistry.selectRegistrantCountry();
        estoreGiftRegistry.selectRegistrantStreetAddress();
        estoreGiftRegistry.selectRegistrantCity();
        estoreGiftRegistry.selectRegistrantState("PA");
        estoreGiftRegistry.selectRegistrantPostalCode();
        estoreGiftRegistry.selectRegistrantPhone();

    }

    @When("I click to create registry button on eStore")
    public void iClickToCrateRegistryButtonOnEStore() {
        estoreGiftRegistry.clickToCreateRegistryButton();
    }

    @Then("I verify that registry was created on eStore")
    public void iVerifyThatRegistryWasCreatedOnEStore() {
        $(By.xpath("//*[text()='REGISTRY']")).should(Condition.visible);
        $(By.xpath("//*[text()='EVENT DATE']")).should(Condition.visible);
        $(By.xpath("//*[text()='REGISTRY NO .']")).should(Condition.visible);
        $(By.xpath("//*[text()='Wedding']")).should(Condition.visible);
    }

    @And("I verify that I'm able to remove create gift registry")
    public void iVerifyThatIMAbleToRemoveCreateGiftRegistry() {
        estoreGiftRegistry.clickToDeleteRegistryButton();
    }

    @When("I go to find a registry")
    public void iGoToFindARegistry() {
        estoreGiftRegistry.clickToGiftRegistryButton();
        estoreGiftRegistry.clickToFindARegistryButtonGiftRegistryMenu();
    }

    @When("I introduce the first and last name to search for registry")
    public void iIntroduceTheFirstAndLastName() {
        estoreGiftRegistry.introduceSearchRegistryFirstName();
        estoreGiftRegistry.introduceSearchRegistryLastName();
    }

    @Then("I verify that registry has been deleted on eStore")
    public void iVerifyThatRegistryHasBeenDeletedOnEStore() {
        estoreGiftRegistry.verifyThatYouDoNotHaveRegistryMessageIsDisplayed();
    }

    @Then("I verify that search result on eStore for registry search by name is displayed")
    public void iVerifyThatSearchResultOnEStoreForRegistrySearchByNameIsDisplayed() {
        estoreGiftRegistry.verifyThatSearchResultIsDisplayed();
    }

}
