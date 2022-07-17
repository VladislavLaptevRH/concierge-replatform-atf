package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import tests.concierge.pageObject.PdpScreen;
import tests.concierge.pageObject.RegistryScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class RegistryStepDefs {
    RegistryScreen registryScreen = new RegistryScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    PdpScreen pdpScreen = new PdpScreen();
    String registrantFirstName;
    String registrantLastName;
    String registrantAddress;


    @When("I click on registry button")
    public void iClickOnRegistryButton() {
        registryScreen.getRegistryButton().should(Condition.visible, Duration.ofSeconds(20));
        registryScreen.getRegistryButton().click();
    }

    @When("I search registry by name")
    public void iSearchRegistryByName() {
        registryScreen.getFirstName().should(Condition.visible, Duration.ofSeconds(15));
        registryScreen.getFirstName().setValue("automation");
        registryScreen.getLastName().setValue("testing");
    }

    @Then("I verify that search result for registry search by name is displayed")
    public void iVerifyThatSearchResultForRegistrySearchByNameIsDisplayed() {
    }

    @Then("I verify that search result for registry search by {string} is displayed")
    public void iVerifyThatSearchResultForRegistrySearchByIsDisplayed(String arg0) {
        registryScreen.getSearchResult().shouldHave(Condition.text("Automation Testing & Automation Testing Wedding 06/24/2022"), Duration.ofSeconds(20));
    }

    @When("I search registry by email")
    public void iSearchRegistryByEmail() {
        registryScreen.getEmail().should(Condition.visible, Duration.ofSeconds(20));
        registryScreen.getEmail().setValue("mdovbenco@rh.com");
    }

    @When("I search registry by event type")
    public void iSearchRegistryByEventType() {
        registryScreen.getFirstName().should(Condition.visible, Duration.ofSeconds(15));
        registryScreen.getFirstName().setValue("automation");
        registryScreen.getLastName().setValue("testing");
        registryScreen.getEventType().click();
        registryScreen.getEventWeddingType().shouldHave(Condition.text("Wedding"), Duration.ofSeconds(20));
        registryScreen.getEventWeddingType().click();

    }

    @When("I click on new registry button")
    public void iClickOnNewRegistryButton() {
        registryScreen.getNewRegistryButton().shouldHave(Condition.text("NEW"), Duration.ofSeconds(20));
        registryScreen.getNewRegistryButton().click();
    }

    @When("I fills all field for create registry")
    public void iFillsAllFieldFromCreateRegistry() {
        registrantFirstName = generalStepDefs.getAlphaNumericString(5);
        registrantLastName = generalStepDefs.getAlphaNumericString(5);

        registryScreen.getPrimaryEmailAddress().setValue("test@mailinator.com");
        registryScreen.getNewRegistryEventType().click();
        registryScreen.getEventWeddingType().shouldHave(Condition.text("Wedding"), Duration.ofSeconds(20));
        registryScreen.getEventWeddingType().click();

        registryScreen.getRegistrantFirstName().should(Condition.visible, Duration.ofSeconds(20));
        registryScreen.getRegistrantFirstName().setValue(registrantFirstName);
        registryScreen.getRegistrantLastName().setValue(registrantLastName);
        registryScreen.getRegistrantAddressLine().setValue("testAddress1");
        registryScreen.getRegistrantAddressLine2().setValue("testAddress1");
        registryScreen.getRegistrantCity().setValue("testCity");

        Select registrantState = new Select(registryScreen.getRegistrantState());
        registrantState.selectByValue("CO");
        registryScreen.getRegistrantPostalCode().setValue("2001");
        registryScreen.getRegistrantAddressPhone().setValue("(541) 777-1234");
    }

    @When("I click on {string} registry button")
    public void iClickOnRegistryButton(String arg0) {
        if (arg0.equals("create registry")) {
            registryScreen.getSearchRegistryButton().shouldHave(Condition.text("Create Registry"), Duration.ofSeconds(20));
            registryScreen.getSearchRegistryButton().click();
        }
        if (arg0.equals("edit registry")) {
            registryScreen.getEditRegistryButton().should(Condition.visible, Duration.ofSeconds(20));
            registryScreen.getEditRegistryButton().click();
        }
        if (arg0.equals("edit registry details")) {
            registryScreen.getEditRegistryDetailsButton().shouldHave(Condition.text("EDIT REGISTRY DETAILS"), Duration.ofSeconds(20));
            registryScreen.getEditRegistryDetailsButton().click();
        }
        if (arg0.equals("SEARCH")) {
            registryScreen.getSearchRegistryButton().shouldHave(Condition.text("SEARCH"), Duration.ofSeconds(20));
            registryScreen.getSearchRegistryButton().click();
        }
        if (arg0.equals("SAVE CHANGES")) {
            registryScreen.getSearchRegistryButton().shouldHave(Condition.text("SAVE CHANGES"), Duration.ofSeconds(20));
            registryScreen.getSearchRegistryButton().click();
        }
        if (arg0.equals("delete registry")) {
            registryScreen.getConfirmDeleteRegistryButton().shouldHave(Condition.text("DELETE REGISTRY"), Duration.ofSeconds(20));
            registryScreen.getConfirmDeleteRegistryButton().click();
        }
    }

    @Then("I verify that registry was created")
    public void iVerifyThatRegistryWasCreated() {
        registryScreen.getSearchResult().shouldHave(Condition.text(registrantFirstName + " " + registrantLastName + " Wedding 06/28/2022 Automation Associate Testcity, US 0"), Duration.ofSeconds(20));
    }

    @When("I click on continue registrant button")
    public void iClickOnContinueRegistrantButton() {
        registryScreen.getContinueRegistrantButton().should(Condition.visible, Duration.ofSeconds(20));
        registryScreen.getContinueRegistrantButton().click();
    }

    @When("I go to the created registry")
    public void iTryingToFindTheCreatedRegistry() {
        registryScreen.getFirstName().should(Condition.visible, Duration.ofSeconds(15));
        registryScreen.getFirstName().setValue(registrantFirstName);
        registryScreen.getLastName().setValue(registrantLastName);
        registryScreen.getEmail().setValue("test@mailinator.com");
    }

    @When("I click on displayed registry")
    public void iClickOnDisplayedRegistry() {
        registryScreen.getSearchResult().should(Condition.visible, Duration.ofSeconds(20));
        registryScreen.getSearchResult().click();
    }

    @When("I edit registry for registrant")
    public void iEditRegistryForRegistrant() {
        registrantAddress = generalStepDefs.getAlphaNumericString(5);
        sleep(3000);
        registryScreen.getRegistrantAddressLine().should(Condition.visible, Duration.ofSeconds(20));
        generalStepDefs.clearField(registryScreen.getRegistrantAddressLine());
        registryScreen.getRegistrantAddressLine().setValue(registrantAddress);
    }

    @Then("I verify that registry was edited")
    public void iVerifyThatRegistryWasEdited() {
        $(By.xpath("//*[text()='" + registrantAddress + "']")).should(Condition.visible, Duration.ofSeconds(20));
    }

    @When("I click on delete registry button")
    public void iClickOnDeleteRegistryButton() {
        registryScreen.getDeleteRegistryButton().should(Condition.text("DELETE"), Duration.ofMinutes(2));
        registryScreen.getDeleteRegistryButton().click();
    }

    @Then("I verify that registry has been deleted")
    public void iVerifyThatRegistryHasBeenDeleted() {
        $(By.xpath("//*[text()='No Results found.']")).should(Condition.visible, Duration.ofSeconds(20));
    }

    @When("I click on add to registry button")
    public void iClickOnAddToRegistryButton() {
        pdpScreen.getAddToRegistryButton().should(Condition.visible, Duration.ofMinutes(1));
        pdpScreen.getAddToRegistryButton().click();
    }

    @When("I click on manage registry button")
    public void iClickOnManageRegistryButton() {
        pdpScreen.getManageRegistryButton().should(Condition.visible, Duration.ofMinutes(1));
        pdpScreen.getManageRegistryButton().click();
    }

    @When("I click on purchase registry button")
    public void iClickOnPurchaseRegistryButton() {
        registryScreen.getPurhcaseRegistryButton().should(Condition.visible, Duration.ofMinutes(1));
        registryScreen.getPurhcaseRegistryButton().click();
    }

    @When("I choose quantity for registry's item")
    public void iChooseQuantityForRegistrySItem() {
        registryScreen.getSelectItemQuantity().should(Condition.visible, Duration.ofMinutes(1));
        Select itemQuantity = new Select(registryScreen.getSelectItemQuantity());
        itemQuantity.selectByIndex(1);
    }

    @When("I add item to cart from registry")
    public void iAddItemToCartFromRegistry() {
        registryScreen.getRegistryAddToCartButton().should(Condition.visible, Duration.ofMinutes(1));
        registryScreen.getRegistryAddToCartButton().click();
    }

    @Then("I verify that I'm able to manage registry")
    public void iVerifyThatIMAbleToManageRegistry() {
        $(By.xpath("//*[text()='MANAGE']")).should(Condition.visible, Duration.ofMinutes(1));
    }

    @Then("I verify that add to registry button is {string}")
    public void iVerifyThatAddToRegistryButtonIs(String arg0) {
        if (arg0.equals("displayed")) {
            pdpScreen.getAddToRegistryButton().should(Condition.visible, Duration.ofMinutes(1));
        }
        if (arg0.equals("not displayed")) {
            pdpScreen.getAddToRegistryButton().shouldNot(Condition.visible, Duration.ofMinutes(1));
        }
    }

    @When("I click on reset registry")
    public void iClickOnResetRegistry() {
        $(By.xpath("//li[@id='9']")).should(Condition.visible,Duration.ofMinutes(1));
        $(By.xpath("//li[@id='9']")).click();
    }

    @When("I search registry with more client create registries")
    public void iSearchRegistryWithMoreClientCreateRegistries() {
        registryScreen.getFirstName().should(Condition.visible, Duration.ofSeconds(15));
        registryScreen.getFirstName().setValue("renuka");
        registryScreen.getLastName().setValue("boorla");
    }

    @Then("I verify that pagination is displayed")
    public void iVerifyThatPaginationIsDisplayed() {
        registryScreen.getPaginationPages().shouldHave(Condition.text("1\n" +
                "2"),Duration.ofSeconds(12));
    }
}
