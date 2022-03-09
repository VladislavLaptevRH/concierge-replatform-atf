package com.test.stepdefinitions;

import com.test.pageObject.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectStepDefs {
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeProjectScreen conciergeProjectScreen = new ConciergeProjectScreen();
    ProjectSettingsScreen projectSettingsScreen = new ProjectSettingsScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    Mailinator mailinator = new Mailinator();
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage();

    String spaceName;
    String opportunityName;
    String clientEmail;
    String aditionalEmail;

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
        conciergeProjectScreen.getSearchBySelect().shouldBe(visible, Duration.ofSeconds(20));
        conciergeProjectScreen.getSearchBySelect().click();
        conciergeProjectScreen.getPricingType().shouldBe(visible, Duration.ofSeconds(20));
        conciergeProjectScreen.getPricingType().click();
        conciergeProjectScreen.getPricingTypeSelect().shouldBe(visible, Duration.ofSeconds(20));
        conciergeProjectScreen.getPricingTypeSelect().click();

        if (pricingType.equals("regular")) {
            conciergeProjectScreen.getRegularPricingType().click();
        }
        if (pricingType.equals("member")) {
            conciergeProjectScreen.getMemberPricingType().shouldBe(visible, Duration.ofSeconds(20));
            conciergeProjectScreen.getMemberPricingType().click();
        }
        if (pricingType.equals("trade")) {
            conciergeProjectScreen.getTradePricingType().shouldBe(visible, Duration.ofSeconds(20));
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
            assertEquals(conciergeProjectScreen.getAMemberValue().getText(), "A. Member");
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
        conciergeProjectScreen.getFirstSearchResultOfProjects().shouldBe(visible, Duration.ofMinutes(5));
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

    @When("I click on add new opportunity button")
    public void iClickOnAddNewOpportunityButton() {
        conciergeProjectScreen.getAddOpportunityButton().shouldBe(visible, Duration.ofSeconds(15));
        conciergeProjectScreen.getAddOpportunityButton().click();
    }

    @When("I introduce opportunity name")
    public void iIntroduceOpportunityName() {
        opportunityName = generalStepDefs.getAlphaNumericString(4);
        conciergeProjectScreen.getOpportunityNameField().click();
        executeJavaScript("arguments[0].value = '';", conciergeProjectScreen.getOpportunityNameField());
        conciergeProjectScreen.getOpportunityNameField().clear();
        conciergeProjectScreen.getOpportunityNameField().setValue(opportunityName);
    }

    @When("I choose preferred contact method")
    public void iChoosePreferredContactMethod() {
        conciergeProjectScreen.getSelectPreferredContactMethod().shouldBe(visible, Duration.ofSeconds(20));
        conciergeProjectScreen.getSelectPreferredContactMethod().click();
        conciergeProjectScreen.getPreferredEmailContactMethod().click();
    }

    @When("I provide description for opportunity")
    public void iProvideDescriptionForOpportunity() {
        conciergeProjectScreen.getOpportunityDescription().shouldBe(visible, Duration.ofSeconds(20));
        conciergeProjectScreen.getOpportunityDescription().setValue("opportunity description");
    }

    @When("I click on create opportunity button")
    public void iClickOnCreateOpportunityButton() {
        conciergeProjectScreen.getCreateOpportunityButton().shouldBe(visible, Duration.ofSeconds(30));
        conciergeProjectScreen.getCreateOpportunityButton().click();
    }

    @When("I add item to created opportunity")
    public void iAddItemToCreatedOpportunity() {
        conciergeItemsScreen.getAddToProjectButton().shouldBe(visible, Duration.ofSeconds(12));
        conciergeItemsScreen.getAddToProjectButton().click();
        conciergeProjectScreen.getSelectOpportunityName().shouldBe(visible, Duration.ofSeconds(15));
        conciergeProjectScreen.getSelectOpportunityName().click();
    }

    @Then("I verify that item was added")
    public void iVerifyThatItemWasAdded() {
        conciergeProjectScreen.getSaveMoveToProject().shouldBe(visible, Duration.ofSeconds(25));
        conciergeProjectScreen.getSaveMoveToProject().click();
        conciergeProjectScreen.getGoToProjectButton().click();
    }

    @When("I click on email estimate button")
    public void iClickOnEmailEstimateButton() {
        conciergeProjectScreen.getEmailEstimateButton().shouldBe(visible, Duration.ofSeconds(40));
        conciergeProjectScreen.getEmailEstimateButton().scrollIntoView(true);
        conciergeProjectScreen.getEmailEstimateButton().click();
    }

    @When("I introduces client email from email estimate pop up")
    public void iIntroducesClientEmailFromEmailEstimatePopUp() {
        clientEmail = generalStepDefs.getAlphaNumericString(4) + "@mailinator.com";
        conciergeProjectScreen.getEmailEstimateEmailField().setValue(clientEmail);
        conciergeProjectScreen.getEmailEstimateMessageToClient().clear();
        conciergeProjectScreen.getEmailEstimateMessageToClient().setValue("this is test description");
    }

    @When("I introduces email in send copies of this project to additional emails")
    public void iIntroducesEmailInSendCopiesOfThisProjectToAdditionalEmails() {
        aditionalEmail = generalStepDefs.getAlphaNumericString(4) + "@mailinator.com";
        conciergeProjectScreen.getEmailEstimateAdditionEmailField().setValue(aditionalEmail);
    }

    @When("I click on email estimate button from project screen")
    public void iClickOnEmailEstimateButtonFromProjectScreen() {
        conciergeProjectScreen.getEmailEstimateProjectScreen().shouldBe(visible, Duration.ofSeconds(12));
        conciergeProjectScreen.getEmailEstimateProjectScreen().scrollIntoView(true);
        conciergeProjectScreen.getEmailEstimateProjectScreen().click();
    }

    @Then("I verify that the client received the letter on the {string}")
    public void iVerifyThatTheClientReceivedTheLetterOnThe(String email) {
        open("https://www.mailinator.com/");
        mailinator.getSearchEmailField().shouldBe(visible, Duration.ofSeconds(20));
        if (email.equals("client")) {
            mailinator.getSearchEmailField().setValue(clientEmail);
        }
        if (email.equals("additional")) {
            mailinator.getSearchEmailField().setValue(aditionalEmail);
        }
        mailinator.getGoButton().click();
        mailinator.getFirstLetter().shouldBe(visible, Duration.ofSeconds(25));
        mailinator.getFirstLetter().click();
        switchTo().frame(mailinator.getMessageBodyIframe());
        mailinator.getBodyEmailText().shouldBe(visible, Duration.ofSeconds(15));
        mailinator.getAssociateName().shouldBe(visible, Duration.ofSeconds(15));
    }

    @When("I click on bcc associate checkbox")
    public void iClickOnBCCAssociateCheckbox() {
        conciergeProjectScreen.getBccAssociateCheckBox().shouldBe(visible, Duration.ofSeconds(20));
        conciergeProjectScreen.getBccAssociateCheckBox().click();
    }

    @Then("I verify that project list is displayed")
    public void iVerifyThatProjectListIsDisplayed() {
        conciergeProjectScreen.getProjectName().shouldBe(visible, Duration.ofSeconds(15));
        Select selectProjectName = new Select(conciergeProjectScreen.getProjectName());
        sleep(2000);
        selectProjectName.selectByVisibleText("A. Member");
        sleep(2000);
        assertTrue(conciergeProjectScreen.getAMemberValue().isDisplayed(), "A. Member project is displayed");
        selectProjectName.selectByVisibleText("TestCompany");
        sleep(2000);
        assertTrue(conciergeProjectScreen.getTestCompanyValue().isDisplayed(), "TestCompany project is displayed");
    }

    @Then("I verify that opportunity list is displayed")
    public void iVerifyThatOpportunityListIsDisplayed() {
        conciergeProjectScreen.getSelectOpportunityName().shouldBe(visible, Duration.ofSeconds(20));
        assertTrue(conciergeProjectScreen.getSelectOpportunityName().isDisplayed(), "Phase 4 opportunity is displayed");
    }

    @Given("I log into Concierge as nbohr@nomail.com")
    public void iLogIntoConciergeAsNbohrNomailCom() {
        conciergeLoginPage.getPasswordField().shouldBe(visible, Duration.ofMinutes(5));
        conciergeLoginPage.getUsernameField().setValue("zorro@pom.com");
        conciergeLoginPage.getPasswordField().setValue("Resto123");
        conciergeLoginPage.getSignInButton().shouldBe(visible, Duration.ofSeconds(30));
        conciergeLoginPage.getSignInButton().click();
        conciergeLoginPage.getLocationNewPortBeach().shouldBe(visible, Duration.ofSeconds(30));
        conciergeLoginPage.getLocationNewPortBeach().click();
        conciergeLoginPage.getContinueButton().shouldBe(visible, Duration.ofSeconds(30));
        conciergeLoginPage.getContinueButton().click();
    }

    @Then("I verify that spaces list is displayed")
    public void iVerifyThatSpacesListIsDisplayed() {
        conciergeProjectScreen.getSelectSpaceName().shouldBe(visible, Duration.ofSeconds(20));
        conciergeProjectScreen.getSelectSpaceName().click();
        assertTrue(conciergeProjectScreen.getSelectSpaceName().isDisplayed(), "test2 space is displayed");
        conciergeProjectScreen.getSelectSpaceName().click();
        assertTrue(conciergeProjectScreen.getSelectSpaceName().isDisplayed(), "test1 and test1 space is displayed");
    }

    @When("I go to category")
    public void iGoToCategory() {
        conciergeUserAccountPage.getInStockButtonMenu().shouldBe(visible, Duration.ofSeconds(20));
        conciergeUserAccountPage.getInStockButtonMenu().click();

        conciergeUserAccountPage.getInStockBedding().shouldBe(visible, Duration.ofSeconds(20));
        conciergeUserAccountPage.getInStockBedding().click();

        conciergeUserAccountPage.getToddlerBedding().shouldBe(visible, Duration.ofSeconds(20));
        conciergeUserAccountPage.getToddlerBedding().click();

    }
}
