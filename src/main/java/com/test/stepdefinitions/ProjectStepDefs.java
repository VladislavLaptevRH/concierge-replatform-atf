package com.test.stepdefinitions;

import com.test.pageObject.ConciergeProjectScreen;
import com.test.pageObject.ConciergeUserAccountPage;
import com.test.pageObject.ProjectSettingsScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectStepDefs {
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeProjectScreen conciergeProjectScreen = new ConciergeProjectScreen();
    ProjectSettingsScreen projectSettingsScreen = new ProjectSettingsScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    String spaceName;

    @When("I click on projects button")
    public void iClickOnProjectsButton() {
        conciergeUserAccountPage.getProjectsButton().shouldBe(visible, Duration.ofMinutes(1));
        conciergeUserAccountPage.getProjectsButton().click();
    }

    @When("I search project by provided {string}")
    public void iSearchProjectByProvided(String searchBy) {
        conciergeProjectScreen.getSearchBySelect().shouldBe(visible, Duration.ofMinutes(1));
        conciergeProjectScreen.getSearchBySelect().click();
        if (searchBy.equals("projectName")) {
            conciergeProjectScreen.getProjectNameButton().shouldBe(visible, Duration.ofSeconds(12));
            conciergeProjectScreen.getProjectNameButton().click();
            conciergeProjectScreen.getProjectNameField().shouldBe(visible, Duration.ofSeconds(12));
            conciergeProjectScreen.getProjectNameField().setValue("test");
        }
        if (searchBy.equals("projectID")) {
            conciergeProjectScreen.getProjectIdButton().shouldBe(visible, Duration.ofSeconds(12));
            conciergeProjectScreen.getProjectIdButton().click();
            conciergeProjectScreen.getProjectIdField().shouldBe(visible, Duration.ofSeconds(12));
            conciergeProjectScreen.getProjectIdField().setValue("P54909938");
        }
        if (searchBy.equals("createdBy")) {
            conciergeProjectScreen.getCreatedByButton().shouldBe(visible, Duration.ofSeconds(12));
            conciergeProjectScreen.getCreatedByButton().click();
            conciergeProjectScreen.getClientFirstNameField().shouldBe(visible, Duration.ofSeconds(12));
            conciergeProjectScreen.getClientFirstNameField().setValue("Renuka");
            conciergeProjectScreen.getClientLastNameField().setValue("Boorla");
        }
        if (searchBy.equals("editedBy")) {
            conciergeProjectScreen.getEditedBy().shouldBe(visible, Duration.ofSeconds(12));
            conciergeProjectScreen.getEditedBy().click();
            conciergeProjectScreen.getClientFirstNameField().shouldBe(visible, Duration.ofSeconds(12));
            conciergeProjectScreen.getClientFirstNameField().setValue("Renuka");
            conciergeProjectScreen.getClientLastNameField().setValue("Boorla");
        }
        conciergeProjectScreen.getSearchByButton().click();
    }

    @Then("I verify that search result is displayed")
    public void iVerifyThatSearchResultIsDisplayed() {
        conciergeProjectScreen.getResultsListForProjects().shouldBe(visible, Duration.ofSeconds(20));
        assertTrue(conciergeProjectScreen.getResultsListForProjects().isDisplayed());
        assertTrue(conciergeProjectScreen.getSearchResultsTitle().isDisplayed());
        assertTrue(conciergeProjectScreen.getMyProjectsButton().isDisplayed());
    }

    @When("I search project by {string}")
    public void iSearchProjectBy(String pricingType) {
        conciergeProjectScreen.getSearchBySelect().shouldBe(visible, Duration.ofSeconds(12));
        conciergeProjectScreen.getSearchBySelect().click();
        conciergeProjectScreen.getPricingType().shouldBe(visible, Duration.ofSeconds(12));
        conciergeProjectScreen.getPricingType().click();
        conciergeProjectScreen.getPricingTypeSelect().click();

        if (pricingType.equals("regular")) {
            conciergeProjectScreen.getRegularPricingType().click();
        }
        if (pricingType.equals("member")) {
            conciergeProjectScreen.getMemberPricingType().shouldBe(visible, Duration.ofSeconds(12));
            conciergeProjectScreen.getMemberPricingType().click();
        }
        if (pricingType.equals("trade")) {
            conciergeProjectScreen.getTradePricingType().shouldBe(visible, Duration.ofSeconds(12));
            conciergeProjectScreen.getTradePricingType().click();
        }
    }

    @Then("I verify that search result for pricing type is displayed")
    public void iVerifyThatSearchResultForPricingTypeIsDisplayed() {
        conciergeProjectScreen.getResultsListForProjects().shouldBe(visible, Duration.ofSeconds(20));
        assertTrue(conciergeProjectScreen.getResultsListForProjects().isDisplayed());
        assertTrue(conciergeProjectScreen.getMyProjectsButton().isDisplayed());
        assertTrue(conciergeProjectScreen.getResultsListForProjects().isDisplayed());

    }

    @When("I introduces {string} first and last name")
    public void iIntroducesFirstAndLastName(String businessClient) {
        conciergeUserAccountPage.getClientLookupFirstName().shouldBe(visible, Duration.ofSeconds(25));
        if (businessClient.equals("member")) {
            conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
            conciergeUserAccountPage.getClientLookupLastName().setValue("Member");
        }
        if (businessClient.equals("nonmember")) {
            conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
            conciergeUserAccountPage.getClientLookupLastName().setValue("Nonmember");
        }
        if (businessClient.equals("trade")) {
            conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
            conciergeUserAccountPage.getClientLookupLastName().setValue("Trade");
        }
        if (businessClient.equals("unclassifiedBusiness")) {
            conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
            conciergeUserAccountPage.getClientLookupLastName().setValue("unclassifiedBusiness");
        }

        conciergeProjectScreen.getContinueCreateAProjectButton().click();
        conciergeProjectScreen.getProjectResultsFirstRow().shouldBe(visible, Duration.ofSeconds(12));
        conciergeProjectScreen.getProjectResultsFirstRow().click();
    }

    @When("I click on new project button")
    public void iClickOnNewProjectButton() {
        conciergeProjectScreen.getNewProjectButton().shouldBe(visible, Duration.ofSeconds(12));
        conciergeProjectScreen.getNewProjectButton().click();
    }

    @When("I introduces details for new project")
    public void iIntroducesDetailsForNewProject() {
        conciergeProjectScreen.getPreferredContactMethodSelect().shouldBe(visible, Duration.ofSeconds(40));
        conciergeProjectScreen.getPreferredContactMethodSelect().click();
        conciergeProjectScreen.getPreferredEmailContactMethod().shouldBe(visible, Duration.ofSeconds(30));
        conciergeProjectScreen.getPreferredEmailContactMethod().click();
        conciergeProjectScreen.getCreateProjectDetailsDescriptionField().shouldBe(visible, Duration.ofSeconds(30));
        conciergeProjectScreen.getCreateProjectDetailsDescriptionField().setValue("testDescription");
        conciergeProjectScreen.getCreateProjectButton().click();

    }

    @Then("I verify that new project for <{string}> was created")
    public void iVerifyThatNewProjectForWasCreated(String businessClient) {
        if (businessClient.equals("member")) {
            assertEquals($(By.xpath("//*[text()='A. Member']")).getText(), "A. Member");
        }
        if (businessClient.equals("nonmember")) {
            assertEquals($(By.xpath("//*[text()='A. Nonmember']")).getText(), "A. Nonmember");
        }
        if (businessClient.equals("trade")) {
            assertEquals($(By.xpath("//*[text()='A. Trade']")).getText(), "A. Trade");
        }
        if (businessClient.equals("")) {
            assertEquals($(By.xpath("//*[text()='A. Member']")).getText(), "TestCompany");
        }
    }

    @When("I click on move to project button")
    public void iClickOnMoveToProjectButton() {
        conciergeProjectScreen.getMoveToProjectButton().shouldBe(visible, Duration.ofSeconds(15));
        conciergeProjectScreen.getMoveToProjectButton().click();
    }

    @When("I click on save button")
    public void iClickOnSaveButton() {
        conciergeProjectScreen.getSaveMoveToProject().shouldBe(visible, Duration.ofSeconds(15));
        conciergeProjectScreen.getSaveMoveToProject().click();
    }

    @Then("I verify that projects screen is displayed")
    public void iVerifyThatProjectsScreenIsDisplayed() {
        conciergeProjectScreen.getForecastSetButton().shouldBe(visible, Duration.ofSeconds(25));
        assertTrue(conciergeProjectScreen.getSettingsButton().isDisplayed(), "Settings button is displayed");
        assertTrue(conciergeProjectScreen.getAvailabilityDeliveryButtons().isDisplayed(), "Availability& Delivery, add item note buttons are displayed");
        assertTrue(conciergeProjectScreen.getPrintButton().isDisplayed(), "Print button ia displayed");
        assertTrue(conciergeProjectScreen.getItems().isDisplayed(), "Items span is displayed");
        assertTrue(conciergeProjectScreen.getQty().isDisplayed(), "QTY span is displayed");
        assertTrue(conciergeProjectScreen.getSubtotal().isDisplayed(), "Subtotal span is displayed");
    }

    @When("I choose project from move to project pop up")
    public void iChooseProjectFromMoveToProjectPopUp() {
        conciergeProjectScreen.getSpaceName().shouldHave(text("General"), Duration.ofSeconds(15));
        Select projectNameSelect = new Select(conciergeProjectScreen.getProjectName());
        projectNameSelect.selectByIndex(1);
    }

    @When("I click on the first project search result")
    public void iClickOnTheFirstProjectSearchResult() {
        conciergeProjectScreen.getFirstSearchResultOfProjects().shouldBe(visible, Duration.ofMinutes(2));
        conciergeProjectScreen.getFirstSearchResultOfProjects().click();
    }

    @When("I click on settings button")
    public void iClickOnSettingsButton() {
        conciergeProjectScreen.getSettingsButton().shouldBe(visible, Duration.ofMinutes(1));
        conciergeProjectScreen.getSettingsButton().click();
    }

    @Then("I verify that project setting screen is displayed")
    public void iVerifyThatProjectSettingScreenIsDisplayed() {
        projectSettingsScreen.getUpdateProjectSettingsTitle().shouldBe(visible, Duration.ofSeconds(20));
        projectSettingsScreen.getAccountDetails().shouldBe(visible, Duration.ofSeconds(15));
        projectSettingsScreen.getSameShippingCheckBox().shouldBe(visible, Duration.ofSeconds(15));
        projectSettingsScreen.getUsdCurrency().shouldBe(visible, Duration.ofSeconds(15));
        projectSettingsScreen.getUsdCurrency().click();
        projectSettingsScreen.getCadCurrency().shouldBe(visible, Duration.ofSeconds(15));
        projectSettingsScreen.getGalleryButton().shouldBe(visible, Duration.ofSeconds(15));
        projectSettingsScreen.getDesignButton().shouldBe(visible, Duration.ofSeconds(15));
        projectSettingsScreen.getTradeButton().shouldBe(visible, Duration.ofSeconds(15));
        projectSettingsScreen.getProjectNameFieldSpan().shouldBe(visible, Duration.ofSeconds(15));
        projectSettingsScreen.getOpportunityNameFieldSpan().shouldBe(visible, Duration.ofMinutes(1));
        projectSettingsScreen.getDesiredDeliveryDate().shouldBe(visible, Duration.ofMinutes(1));
        projectSettingsScreen.getPurchasingDeadlineSpan().shouldBe(visible, Duration.ofMinutes(1));
        projectSettingsScreen.getPreferredContactMethodSpan().shouldBe(visible, Duration.ofMinutes(1));
        projectSettingsScreen.getDescriptionSpan().shouldBe(visible, Duration.ofSeconds(15));
        projectSettingsScreen.getSpaceNameSpan().shouldBe(visible, Duration.ofSeconds(15));
        projectSettingsScreen.getAddSpaceButton().shouldBe(visible, Duration.ofSeconds(15));
        projectSettingsScreen.getUpdateProjectSettingsBtn().shouldBe(visible, Duration.ofSeconds(15));
    }

    @When("I click on the moodboard button")
    public void iClickOnTheMoodboardButton() {
        projectSettingsScreen.getMoodBoardButton().shouldBe(visible, Duration.ofSeconds(15));
        projectSettingsScreen.getMoodBoardButton().click();
    }

    @Then("moodboard screen is displayed")
    public void moodboardScreenIsDisplayed() {
        projectSettingsScreen.getMoodboardDeactiveButton().shouldBe(visible, Duration.ofSeconds(15));
    }

    @When("I introduces space name")
    public void iIntroducesSpaceName() {
        spaceName = generalStepDefs.getAlphaNumericString(4);
        projectSettingsScreen.getSpaceNameSpan().shouldBe(visible, Duration.ofSeconds(12));
        projectSettingsScreen.getSpaceNameSpan().setValue(spaceName);
    }

    @When("I click on add space button")
    public void iClickOnAddSpaceButton() {
        projectSettingsScreen.getAddSpaceButton().shouldBe(visible, Duration.ofSeconds(20));
        projectSettingsScreen.getAddSpaceButton().click();
    }

    @Then("I verify that new space was created")
    public void iVerifyThatNewSpaceWasCreated() {
        assertTrue($(By.xpath("//*[text()='" + spaceName + "']")).isDisplayed(), "New space has been created");
        $(By.xpath("//*[text()='" + spaceName + "']")).shouldBe(visible, Duration.ofSeconds(12));
    }
}
