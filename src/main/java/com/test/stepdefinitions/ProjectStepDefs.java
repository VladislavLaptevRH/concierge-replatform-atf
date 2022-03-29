package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.IsDisplayed;
import com.test.pageObject.*;
import io.cucumber.java.en.*;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.awaitility.Awaitility.await;
import static org.testng.Assert.*;

public class ProjectStepDefs {
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeProjectScreen conciergeProjectScreen = new ConciergeProjectScreen();
    ProjectSettingsScreen projectSettingsScreen = new ProjectSettingsScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    Mailinator mailinator = new Mailinator();
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage();
    SelectOption selectOption = new SelectOption();
    Colors colors = new Colors();

    String spaceName;
    String opportunityName;
    String clientEmail;
    String aditionalEmail;
    int randomColor;
    int randomQuantity;
    String itemPrice;

    @When("I click on projects button")
    public void iClickOnProjectsButton() {
        conciergeUserAccountPage.getProjectsButton().shouldBe(visible, Duration.ofMinutes(1));
        conciergeUserAccountPage.getProjectsButton().click();
    }

    @When("I search project by provided {string}")
    public void iSearchProjectByProvided(String searchBy) {

    }

    @Then("I verify that search result is displayed")
    public void iVerifyThatSearchResultIsDisplayed() {
        conciergeProjectScreen.getResultsListForProjects().shouldBe(visible, Duration.ofMinutes(3));
        assertTrue(conciergeProjectScreen.getResultsListForProjects().isDisplayed());
        assertTrue(conciergeProjectScreen.getSearchResultsTitle().isDisplayed());
        assertTrue(conciergeProjectScreen.getMyProjectsButton().isDisplayed());
    }

    @When("I search project by {string}")
    public void iSearchProjectBy(String pricingType) {
        conciergeProjectScreen.getSearchBySelect().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(25));
        conciergeProjectScreen.getSearchBySelect().click();

        conciergeProjectScreen.getPricingType().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(25));
        conciergeProjectScreen.getPricingType().click();
        sleep(3000);
        conciergeProjectScreen.getPricingTypeSelect().click();

        sleep(2000);
        if (pricingType.equals("regular")) {
            conciergeProjectScreen.getRegularPricingType().shouldBe(visible, Duration.ofSeconds(20));
            executeJavaScript("arguments[0].click();", conciergeProjectScreen.getRegularPricingType());
        }
        if (pricingType.equals("member")) {
            conciergeProjectScreen.getMemberPricingType().shouldBe(visible, Duration.ofSeconds(20));
            executeJavaScript("arguments[0].click();", conciergeProjectScreen.getMemberPricingType());
        }
        if (pricingType.equals("trade")) {
            conciergeProjectScreen.getTradePricingType().shouldBe(visible, Duration.ofSeconds(20));
            executeJavaScript("arguments[0].click();", conciergeProjectScreen.getTradePricingType());
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
        sleep(2000);
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
        $(By.cssSelector("div[class='MuiInputBase-root MuiOutlinedInput-root Mui-error Mui-error MuiInputBase-fullWidth MuiInputBase-formControl'] div[role='button']")).click();
//        executeJavaScript("arguments[0].click();", conciergeProjectScreen.getPreferredContactMethodSelect());

        conciergeProjectScreen.getPreferredEmailContactMethod().shouldBe(visible, Duration.ofSeconds(30));
        executeJavaScript("arguments[0].click();", conciergeProjectScreen.getPreferredEmailContactMethod());

        conciergeProjectScreen.getCreateProjectDetailsDescriptionField().shouldBe(visible, Duration.ofSeconds(30));
        conciergeProjectScreen.getCreateProjectDetailsDescriptionField().setValue("testDescription");

        executeJavaScript("arguments[0].click();", conciergeProjectScreen.getCreateProjectButton());
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
        conciergeProjectScreen.getMoveToProjectButton().shouldHave(text("Move to Project"), Duration.ofMinutes(1));
        conciergeProjectScreen.getMoveToProjectButton().click();
    }

    @When("I click on save button")
    public void iClickOnSaveButton() {
        conciergeProjectScreen.getSaveMoveToProject().shouldBe(visible, Duration.ofSeconds(15));
        conciergeProjectScreen.getSaveMoveToProject().click();
    }

    @Then("I verify that projects screen is displayed")
    public void iVerifyThatProjectsScreenIsDisplayed() {
        conciergeProjectScreen.getForecastSetButton().shouldBe(visible, Duration.ofSeconds(40));
        assertTrue(conciergeProjectScreen.getSettingsButton().isDisplayed(), "Settings button is displayed");
        conciergeProjectScreen.getPrintButton().shouldBe(visible, Duration.ofSeconds(40));
        assertTrue(conciergeProjectScreen.getPrintButton().isDisplayed(), "Print button ia displayed");
        assertTrue(conciergeProjectScreen.getItems().isDisplayed(), "Items span is displayed");
        assertTrue(conciergeProjectScreen.getQty().isDisplayed(), "QTY span is displayed");
        assertTrue(conciergeProjectScreen.getSubtotal().isDisplayed(), "Subtotal span is displayed");
    }

    @When("I choose project from move to project pop up")
    public void iChooseProjectFromMoveToProjectPopUp() {
        sleep(3000);
        Select projectNameSelect = new Select(conciergeProjectScreen.getProjectName());
        projectNameSelect.selectByVisibleText("moveToProject");
    }

    @When("I click on the first project search result")
    public void iClickOnTheFirstProjectSearchResult() {
        conciergeProjectScreen.getFirstSearchResultOfProjects().shouldBe(visible, Duration.ofMinutes(5));
        conciergeProjectScreen.getFirstSearchResultOfProjects().click();
    }

    @When("I click on settings button")
    public void iClickOnSettingsButton() {
        conciergeProjectScreen.getSettingsButton().shouldHave(text("SETTINGS"), Duration.ofMinutes(1));
        conciergeProjectScreen.getSettingsButton().click();
    }

    @Then("I verify that project setting screen is displayed")
    public void iVerifyThatProjectSettingScreenIsDisplayed() {
        projectSettingsScreen.getUpdateProjectSettingsTitle().shouldBe(visible, Duration.ofSeconds(25));
        projectSettingsScreen.getAccountDetails().shouldBe(visible, Duration.ofSeconds(15));
        projectSettingsScreen.getSameShippingCheckBox().shouldBe(visible, Duration.ofSeconds(15));
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
        conciergeProjectScreen.getSelectPreferredContactMethod().shouldHave(text("Preferred Contact Method"), Duration.ofSeconds(20));
        sleep(2000);
        conciergeProjectScreen.getSelectPreferredContactMethod().click();
        conciergeProjectScreen.getPreferredEmailContactMethod().shouldHave(text("Email"), Duration.ofSeconds(15));
        conciergeProjectScreen.getPreferredEmailContactMethod().click();
    }

    @When("I click on create opportunity button")
    public void iClickOnCreateOpportunityButton() {
        conciergeProjectScreen.getCreateOpportunityButton().shouldBe(visible, Duration.ofSeconds(30));
        conciergeProjectScreen.getCreateOpportunityButton().click();
    }

    @When("I add item to created opportunity")
    public void iAddItemToCreatedOpportunity() {
        conciergeItemsScreen.getAddToProjectButton().shouldBe(visible, Duration.ofSeconds(20));
        conciergeItemsScreen.getAddToProjectButton().click();
        conciergeProjectScreen.getSelectOpportunityName().shouldBe(visible, Duration.ofSeconds(20));
        sleep(3000);
        conciergeProjectScreen.getSelectOpportunityName().click();
    }

    @Then("I verify that item was added")
    public void iVerifyThatItemWasAdded() {
        conciergeProjectScreen.getSaveMoveToProject().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(20));
        ;
        executeJavaScript("arguments[0].click();", conciergeProjectScreen.getSaveMoveToProject());
        conciergeProjectScreen.getGoToProjectButton().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(20));
        ;
        executeJavaScript("arguments[0].click();", conciergeProjectScreen.getGoToProjectButton());
    }

    @When("I click on email estimate button")
    public void iClickOnEmailEstimateButton() {
        conciergeProjectScreen.getEmailEstimateButton().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(20));
        conciergeProjectScreen.getEmailEstimateButton().scrollIntoView(true);
        executeJavaScript("arguments[0].click();", conciergeProjectScreen.getEmailEstimateButton());
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
        conciergeProjectScreen.getEmailEstimateAdditionEmailField().shouldBe(visible, Duration.ofSeconds(20));
        conciergeProjectScreen.getEmailEstimateAdditionEmailField().setValue(aditionalEmail);
    }

    @When("I click on email estimate button from project screen")
    public void iClickOnEmailEstimateButtonFromProjectScreen() {
        sleep(5000);
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        conciergeProjectScreen.getEmailEstimateProjectScreen().shouldHave(text("EMAIL ESTIMATE"), Duration.ofSeconds(20));
        executeJavaScript("arguments[0].click();", conciergeProjectScreen.getEmailEstimateProjectScreen());
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


    @When("I search project {string} by provided {string}")
    public void iSearchProjectByProvided(String projectName, String searchBy) {
        $(By.cssSelector("#demo-simple-select-outlined")).shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(25));
        sleep(2000);
        $(By.cssSelector("#demo-simple-select-outlined")).click();
        if (searchBy.equals("projectName")) {
            conciergeProjectScreen.getProjectNameButton().shouldHave(text("Project Name"), Duration.ofSeconds(20));
            sleep(2000);
            conciergeProjectScreen.getProjectNameButton().click();

            conciergeProjectScreen.getProjectNameField().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(20));
            sleep(2000);
            conciergeProjectScreen.getProjectNameField().setValue(projectName);
        }
        if (searchBy.equals("projectID")) {
            conciergeProjectScreen.getProjectIdButton().shouldBe(visible, Duration.ofSeconds(20));
            sleep(2000);
            conciergeProjectScreen.getProjectIdButton().click();
            conciergeProjectScreen.getProjectIdField().shouldBe(visible, Duration.ofSeconds(20));
            sleep(2000);
            conciergeProjectScreen.getProjectIdField().setValue("P54909938");
        }
        if (searchBy.equals("createdBy")) {
            conciergeProjectScreen.getCreatedByButton().shouldBe(visible, Duration.ofSeconds(20));
            sleep(2000);
            conciergeProjectScreen.getCreatedByButton().click();
            conciergeProjectScreen.getClientFirstNameField().shouldBe(visible, Duration.ofSeconds(20));
            sleep(2000);
            conciergeProjectScreen.getClientFirstNameField().setValue("Renuka");
            conciergeProjectScreen.getClientLastNameField().setValue("Boorla");
        }
        if (searchBy.equals("editedBy")) {
            conciergeProjectScreen.getEditedBy().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(20));
            sleep(2000);
            conciergeProjectScreen.getEditedBy().click();
            conciergeProjectScreen.getClientFirstNameField().shouldBe(visible, Duration.ofSeconds(40));
            conciergeProjectScreen.getClientFirstNameField().setValue("Renuka");
            conciergeProjectScreen.getClientLastNameField().setValue("Boorla");
        }
        conciergeProjectScreen.getSearchByButton().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(5));
        sleep(2000);
        conciergeProjectScreen.getSearchByButton().click();

    }

    @When("I choose color from option")
    public void iChooseColorFromOption() {
        sleep(2000);
        randomColor = generalStepDefs.getRandomNumber(0, 3);
        Select selectColor = new Select(selectOption.getLancasterColor());
        selectColor.selectByIndex(randomColor);
        System.out.println();
    }

    @When("I click on edit options button")
    public void iClickOnEditOptionsButton() {
        conciergeProjectScreen.getEditItemOptions().shouldBe(visible, Duration.ofSeconds(35));
        executeJavaScript("window.scrollBy(0,350)", "");
        projectSettingsScreen.getMoodBoardButton().shouldHave(text("MOODBOARD"), Duration.ofSeconds(15));
        executeJavaScript("arguments[0].click();", conciergeProjectScreen.getEditItemOptions());
    }

    @Then("verify that color was changed")
    public void verifyThatColorWasChanged() {
        if (randomColor == 0) {
            assertTrue(colors.getChestnut().isDisplayed());
        }
        if (randomColor == 1) {
            assertTrue(colors.getCocoa().isDisplayed());
        }
        if (randomColor == 2) {
            assertTrue(colors.getEbony().isDisplayed());
        }
        if (randomColor == 3) {
            assertTrue(colors.getEspressoColor().isDisplayed());
        }

    }

    @When("I choose quantity for item from project")
    public void iChooseQuantityForItemFromProject() {
        randomQuantity = generalStepDefs.getRandomNumber(2, 5);
        $(By.xpath("//div[@aria-haspopup='listbox']")).shouldBe(visible, Duration.ofSeconds(15));
        $(By.xpath("//div[@aria-haspopup='listbox']")).click();
        $(By.xpath("//li[@data-value='" + randomQuantity + "']")).shouldHave(text(Integer.toString(randomQuantity)), Duration.ofSeconds(10));
        $(By.xpath("//li[@data-value='" + randomQuantity + "']")).scrollIntoView(true);
        sleep(2000);
        $(By.xpath("//li[@data-value='" + randomQuantity + "']")).click();
    }

    @Then("verify that quantity for item was changed")
    public void verifyThatQuantityForItemWasChanged() {
        assertTrue(Integer.parseInt($(By.xpath("//div[@aria-haspopup='listbox']")).getText()) == randomQuantity);
    }

    @And("I choose project by project name {string}")
    public void iChooseProjectByProjectName(String projectName) {
        conciergeProjectScreen.getProjectNameMoveToProject().shouldBe(visible, Duration.ofSeconds(20));
        conciergeProjectScreen.getProjectNameMoveToProject().click();
        $(By.xpath("//*[text()='" + projectName + "']")).click();
    }

    @When("I click on remove button from project for added item")
    public void iClickOnRemoveButtonFromProjectForAddedItem() {
        conciergeProjectScreen.getREMOVEbutton().shouldBe(visible, Duration.ofSeconds(20));
        conciergeProjectScreen.getREMOVEbutton().click();
    }

    @Then("I verify that item was removed")
    public void iVerifyThatItemWasRemoved() {
        conciergeProjectScreen.getItemIdSpan().shouldNotBe(visible, Duration.ofSeconds(20));
        assertFalse(conciergeProjectScreen.getItemIdSpan().isDisplayed(), "Item# is not displayed");
    }

    @And("I click on regular price for item projects")
    public void iClickOnRegularPriceForItemProjects() {
        conciergeProjectScreen.getOverridePriceregularPrice().shouldBe(visible, Duration.ofMinutes(1));
        executeJavaScript("window.scrollBy(0,150)", "Scroll to regular price");
        sleep(2000);
        conciergeProjectScreen.getOverridePriceregularPrice().click();
        System.out.println();

    }

    @But("I choose {string} method for price override")
    public void iChooseMethodForPriceOverride(String methodValue) {
        conciergeProjectScreen.getPercentOffSelect().shouldBe(visible, Duration.ofSeconds(15));
        conciergeProjectScreen.getPercentOffSelect().click();
        $(By.xpath("//li[@data-value='" + methodValue + "']")).click();

    }

    @And("I introduce {string} percent discount")
    public void iIntroducePercentDiscount(String arg0) {
        conciergeProjectScreen.getPercentDiscount().clear();
        conciergeProjectScreen.getPercentDiscount().setValue(arg0);
    }

    @When("I introduce {string} for reason code")
    public void iIntroduceForReasonCode(String reasonCode) {
        conciergeProjectScreen.getReasonCode().shouldBe(visible, Duration.ofSeconds(12));
        conciergeProjectScreen.getReasonCode().click();
        $(By.xpath("//li[@data-value='" + reasonCode + "']")).click();
    }

    @And("I click on apply button")
    public void iClickOnApplyButton() {
        conciergeProjectScreen.getApplyButton().shouldBe(visible, Duration.ofSeconds(12));
        conciergeProjectScreen.getApplyButton().click();
    }

    @Then("I verify that overriden price displayed")
    public void iVerifyThatOverridenPriceDisplayed() {
        conciergeProjectScreen.getAmount4923().shouldBe(visible, Duration.ofSeconds(20));
        assertTrue(conciergeProjectScreen.getAmount4923().isDisplayed(), "Overriden price is displayed");
    }

    @And("I click on unlimited furniture delivery price")
    public void iClickOnUnlimitedFurnitureDeliveryPrice() {
        sleep(5000);
        executeJavaScript("window.scrollBy(0,800)", "Scroll to regular price");
        sleep(4000);
        conciergeProjectScreen.getAmount549().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(20));
        conciergeProjectScreen.getAmount549().click();
    }

    @When("I introduces {string} in dollar amount field")
    public void iIntroducesInDollarAmountField(String dollarAmount) {
        conciergeProjectScreen.getDollarAmountField().shouldBe(visible, Duration.ofSeconds(20));
        conciergeProjectScreen.getDollarAmountField().clear();
        conciergeProjectScreen.getDollarAmountField().setValue(dollarAmount);
    }

    @And("I choose {string} reason")
    public void iChooseReason(String reason) {
        Select selectReason = new Select(conciergeProjectScreen.getShippingOverridePriceReason());
        selectReason.selectByValue(reason);
    }

    @Then("I verified that override price for shipping displayed")
    public void iVerifiedThatOverridePriceForShippingDisplayed() {
        conciergeProjectScreen.getAmount50().shouldBe(visible, Duration.ofSeconds(20));
        assertTrue(conciergeProjectScreen.getAmount50().isDisplayed(), "Override price is displayed");
    }

    @And("I set the random quantity of goods")
    public void iSetTheRandomQuantityOfGoods() {
        conciergeProjectScreen.getLancasterSofaQty().shouldBe(visible, Duration.ofSeconds(12));
        Select frameQtySelect = new Select(conciergeProjectScreen.getLancasterSofaQty());
        randomQuantity = generalStepDefs.getRandomNumber(0, 30);
        frameQtySelect.selectByIndex(randomQuantity - 1);
    }

    @Then("I verify that subtotal amount updated according by quantity of items")
    public void iVerifyThatSubtotalAmountUpdatedAccordingByQuantityOfItems() {
        sleep(3000);
        String memberPriceText = conciergeProjectScreen.getRegularPrice().getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", "");
        int memberPrice = Integer.parseInt(memberPriceText);
        int totalItemPrice = randomQuantity * memberPrice;
        String finalPrice = Double.toString(totalItemPrice).replace(".", ",").replaceAll("\\,0", "");
        String forecast = conciergeProjectScreen.getForeCastTotalValue().getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", "");

        assertEquals(finalPrice, forecast, "Final price calculated correctly");
    }

    @And("I verify item price")
    public void iVerifyItemPrice() {
        conciergeProjectScreen.getRegularPriceValue().shouldBe(visible, Duration.ofSeconds(14));
        itemPrice = conciergeProjectScreen.getRegularPriceValue().getText();
    }

    @When("I change size {string} for project item")
    public void iChangeSizeForProjectItem(String size) {
        Select selectMirrorSize = new Select(conciergeProjectScreen.getMirrorSize());
        selectMirrorSize.selectByValue(size);
    }

    @When("I change finish {string} option for project item")
    public void iChangeFinishOptionForProjectItem(String finishValue) {
        sleep(2000);
        Select selectFinish = new Select(conciergeProjectScreen.getFinishOption());
        selectFinish.selectByVisibleText(finishValue);
    }

    @Then("I verify that price was not changes")
    public void iVerifyThatPriceWasNotChanges() {
        conciergeProjectScreen.getRegularPriceValue().shouldBe(visible, Duration.ofSeconds(12));
        assertEquals(conciergeProjectScreen.getRegularPriceValue().getText(), itemPrice, "Price was not changed");
    }

    @Then("I verify that forecast value is updated after hiding the item")
    public void iVerifyThatForecastValueIsUpdatedAfterHidingTheItem() {
        conciergeProjectScreen.getForeCastAmount().shouldBe(visible, Duration.ofSeconds(30));
        executeJavaScript("window.scrollBy(0,500)", "");
        sleep(2000);
        conciergeProjectScreen.getCheckMarkItemButton().click();
        String priceBeforeHide = conciergeProjectScreen.getForeCastAmount().getText();
        sleep(2000);
        conciergeProjectScreen.getCheckMarkItemButton().click();
        sleep(2000);
        String priceAfterHide = conciergeProjectScreen.getForecastSetButton().getText();
        assertFalse(priceBeforeHide.equals(priceAfterHide), "Forecast value is updated after ");
    }

    @When("I click on print button")
    public void iClickOnPrintButton() {
        conciergeProjectScreen.getPrintButton().shouldBe(visible, Duration.ofSeconds(12));
        conciergeProjectScreen.getPrintButton().click();
    }

    @When("I click on {string} button")
    public void iClickOnButton(String buttonName) {
        $(By.xpath("//*[text()='" + buttonName + "']")).shouldHave(text(buttonName), Duration.ofSeconds(15));
        $(By.xpath("//*[text()='" + buttonName + "']")).click();
    }

    @Then("I verify print popup is displayd")
    public void iVerifyPrintPopupIsDisplayd() {
        switchTo().frame($(By.id("pdf-viewer")));
        conciergeProjectScreen.getPrintPopUp().shouldBe(visible, Duration.ofSeconds(12));
        conciergeProjectScreen.getPrintPopUp().isDisplayed();
    }

    @When("I choose project from addToProject popup")
    public void iChooseProjectFromAddToProjectPopup() {
        conciergeProjectScreen.getAddToProjectProjectName().shouldBe(visible, Duration.ofMinutes(1));
        Select selectProject = new Select(conciergeProjectScreen.getAddToProjectProjectName());
        sleep(2000);
        selectProject.selectByVisibleText("addToProject");
        conciergeItemsScreen.getSaveProjectPopUpButton().shouldBe(visible, Duration.ofMinutes(1));
        conciergeItemsScreen.getSaveProjectPopUpButton().click();
        generalStepDefs.isElementVisible("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4'][1]//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained')]");
        conciergeItemsScreen.getGoToProjectButton().click();
    }

    @Then("I verify that forecast value is update according to quantity of item")
    public void iVerifyThatForecastValueIsUpdateAccordingToQuantityOfItem() {
        conciergeProjectScreen.getItemProjectPrice().shouldBe(visible, Duration.ofSeconds(40));
        System.out.println(randomQuantity);
        sleep(3000);
        int forecastExpected = randomQuantity * Integer.parseInt(conciergeProjectScreen.getItemProjectPrice().getText().replaceAll("\\$", "").replaceAll(",", "").replaceAll(".00", ""));
        int forecastActual = Integer.parseInt(conciergeProjectScreen.getForecastamountValue().getText().replaceAll("\\$", "").replaceAll(",", "").replaceAll(".00", ""));

        assertEquals(forecastActual, forecastExpected, "Forecast value has been updated");

    }

    @And("I set the random quantity {string} of goods")
    public void iSetTheRandomQuantityOfGoods(String arg0) {
        randomQuantity = generalStepDefs.getRandomNumber(1, 10);
        $(By.id(arg0)).shouldBe(visible, Duration.ofSeconds(20));
        executeJavaScript("window.scrollTo(0, 200)");
        sleep(2000);
        Select selectQuantity = new Select($(By.id(arg0)));
        selectQuantity.selectByValue(String.valueOf(randomQuantity));
        sleep(2000);
    }

    @When("I choose pricing type {string}")
    public void iChoosePricingType(String arg0) {
        conciergeProjectScreen.getForecastamountValue().shouldBe(visible, Duration.ofSeconds(12));
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        sleep(10000);
        conciergeProjectScreen.getPricingTypeDropdown().shouldBe(visible, Duration.ofSeconds(15));
        conciergeProjectScreen.getPricingTypeDropdown().click();
        if (arg0.equals("NON-MEMBER")) {
            conciergeProjectScreen.getRegularPricingType().shouldBe(visible, Duration.ofSeconds(20));
            conciergeProjectScreen.getRegularPricingType().click();
            System.out.println();
        } else {
            conciergeProjectScreen.getMemberPricingType().shouldBe(visible, Duration.ofSeconds(20));
            conciergeProjectScreen.getMemberPricingType().click();
        }
    }

    @Then("I verify forecast for {string}")
    public void iVerifyForecastFor(String pricingType) {
        conciergeProjectScreen.getForeCastAmount().shouldBe(visible, Duration.ofSeconds(20));
        conciergeProjectScreen.getForeCastAmount().scrollIntoView(true);
        sleep(3000);
        String prType = conciergeProjectScreen.getForeCastAmount().getText().replaceAll("Forecast Amount", "");
        sleep(2000);
        if (pricingType.equals("MEMBER")) {
            assertEquals(prType, "$4,496.00\n", "Forecast amount for member client is displayed");
        }
        if (pricingType.equals("NON-MEMBER")) {
            assertEquals(prType, "$5,995.00\n", "Forecast amount for non-member client is displayed");
            System.out.println();
        }
    }

    @When("user go to the next page {string} of projects")
    public void userGoToTheNextPageOfProjects(String arg0) {
        $(By.xpath("//button[@aria-label='Go to page " + arg0 + "']")).shouldBe(Condition.be(visible), Duration.ofSeconds(12));
        $(By.xpath("//button[@aria-label='Go to page " + arg0 + "']")).click();
    }

    @Then("user verifies that project page is displayed")
    public void userVerifiesThatProjectPageIsDisplayed() {
        $(By.xpath("//*[text()='MY PROJECTS']")).shouldBe(Condition.be(visible), Duration.ofSeconds(12));
        assertTrue($(By.xpath("//*[text()='MY PROJECTS']")).isDisplayed());
        assertTrue($(By.xpath("//h4[@class='MuiTypography-root MuiTypography-h4']")).isDisplayed());
    }

    @When("I verify that tax is not displayed")
    public void iVerifyThatTaxIsNotDisplayed() {
        conciergeProjectScreen.getSettingsButton().shouldHave(text("SETTINGS"), Duration.ofSeconds(20));
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        conciergeProjectScreen.getTaxExemptCheckBox().click();
        sleep(8000);
        assertFalse($(By.xpath("//*[text()='Tax']")).isDisplayed());
        conciergeProjectScreen.getTaxExemptCheckBox().click();
        sleep(4000);
        System.out.println();

//        }


    }

    @Then("I verify that tax exempt is displayed")
    public void iVerifyThatTaxExemptIsDisplayed() {
        $(By.xpath("//*[text()='Tax']")).shouldBe(visible, Duration.ofSeconds(15));
        assertTrue($(By.xpath("//*[text()='Tax']")).isDisplayed());
    }

    @When("I clicks on item from two items in row")
    public void iClicksOnItemsFromTwoItemsInRow() {
//        try {
//        $(By.xpath("//*[text()='Chairs']")).shouldHave(text("Chairs"), Duration.ofMinutes(1));
        sleep(3000);
        conciergeItemsScreen.getTwoItemsInRow().get(0).shouldBe(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        sleep(3000);
        conciergeItemsScreen.getTwoItemsInRow().get(0).click();
//        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
//            System.out.println("Items section are not displayed");
//        }
    }

    @When("I choose {string} for unclassified business client project")
    public void iChooseForUnclassifiedBusinessClientProject(String arg0) {
        conciergeProjectScreen.getSettingsButton().shouldHave(text("SETTINGS"), Duration.ofSeconds(15));
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        conciergeProjectScreen.getPricingTypeDropdown().shouldBe(visible, Duration.ofSeconds(20));
        conciergeProjectScreen.getPricingTypeDropdown().click();
        $(By.xpath("//li[@data-value='" + arg0 + "']")).shouldBe(visible, Duration.ofSeconds(10));
        $(By.xpath("//li[@data-value='" + arg0 + "']")).click();


    }

    @Then("I verify {string} for unclassified business client project")
    public void iVerifyForUnclassifiedBusinessClientProject(String pricingType) {
        sleep(3000);
        String forecastActual = conciergeProjectScreen.getForecastamountValue().getText().replaceAll("\\$", "").replaceAll(".00", "");
        if (pricingType.equals("NON_MEMBER") || (pricingType.equals("NON_TRADE"))) {
            assertEquals(forecastActual, "1,516", "Pricing for non member is displayed correctly");
        }
        if (pricingType.equals("MEMBER") || (pricingType.equals("TRADE"))) {
            assertEquals(forecastActual, "1,212", "Pricing for " + pricingType + " is displayed correctly");
        }
    }

    @When("user choose space {string}")
    public void userChooseSpace(String spaceName) {
        $(By.xpath("(//button[contains(@class,'MuiButtonBase-root')])[6]")).shouldBe(visible, Duration.ofSeconds(15));
        $(By.xpath("(//button[contains(@class,'MuiButtonBase-root')])[6]")).scrollIntoView(true);
        sleep(2000);
//        $(By.xpath("(//button[contains(@class,'MuiButtonBase-root')])[6]")).click();
        executeJavaScript("arguments[0].click();", $(By.xpath("(//button[contains(@class,'MuiButtonBase-root')])[6]")));

        System.out.println();
        $(By.xpath("//*[text()='" + spaceName + "']")).shouldHave(text(spaceName), Duration.ofSeconds(15));
        $(By.xpath("//*[text()='" + spaceName + "']")).click();
    }

    @Then("user verify that items for {string} are displayed")
    public void userVerifyThatItemsForAreDisplayed(String spaceName) {
        if (spaceName.equals("space2")) {
            $(By.xpath("(//*[text()='Metal Floating Mirror'])[2]")).shouldBe(visible, Duration.ofSeconds(15));
        } else {
            $(By.xpath("(//*[text()='La Paz Sofa'])[2]")).shouldBe(visible, Duration.ofSeconds(15));
        }
    }

    @When("I verify selections and deselection of project moodboard items")
    public void iVerifySelectionaAndDeselectionOfProjectMoodboardItems() {

    }
}
