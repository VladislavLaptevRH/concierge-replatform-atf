package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import tests.concierge.pageObject.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.estore.pageObject.EstoreItemPage;
import tests.utility.Hooks;

import java.time.Duration;
import java.util.UUID;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.Assert.*;

public class ProjectStepDefs {
    EstoreItemPage estoreItemPage = new EstoreItemPage();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeProjectScreen conciergeProjectScreen = new ConciergeProjectScreen();
    ProjectSettingsScreen projectSettingsScreen = new ProjectSettingsScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    Mailinator mailinator = new Mailinator();
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage();
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();
    ConciergeE2EStepDefs conciergeE2EStepDefs = new ConciergeE2EStepDefs();
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
        with().pollInterval(9, SECONDS).await().until(() -> true);
        conciergeUserAccountPage.getProjectsButton().should(visible, Duration.ofMinutes(1));
        conciergeUserAccountPage.getProjectsButton().click();
    }

    @Then("I verify that search result is displayed")
    public void iVerifyThatSearchResultIsDisplayed() {
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeProjectScreen.getResultsListForProjects().should(visible, Duration.ofMinutes(1));
    }

    @When("I search project by {string}")
    public void iSearchProjectBy(String pricingType) {
        conciergeProjectScreen.getSearchBySelect().should(Condition.and("", visible, enabled), Duration.ofSeconds(25));
        conciergeProjectScreen.getSearchBySelect().click();

        conciergeProjectScreen.getPricingType().should(Condition.and("", visible, enabled), Duration.ofSeconds(25));
        conciergeProjectScreen.getPricingType().click();

        conciergeProjectScreen.getPricingTypeSelect().click();

        with().pollInterval(2, SECONDS).await().until(() -> true);
        if (pricingType.equals("regular")) {
            conciergeProjectScreen.getRegularPricingType().should(visible, Duration.ofSeconds(40));
            executeJavaScript("arguments[0].click();", conciergeProjectScreen.getRegularPricingType());
        }
        if (pricingType.equals("member")) {
            conciergeProjectScreen.getMemberPricingType().should(visible, Duration.ofSeconds(40));
            executeJavaScript("arguments[0].click();", conciergeProjectScreen.getMemberPricingType());
        }
        if (pricingType.equals("trade")) {
            conciergeProjectScreen.getTradePricingType().should(visible, Duration.ofSeconds(40));
            executeJavaScript("arguments[0].click();", conciergeProjectScreen.getTradePricingType());
        }
    }

    @Then("I verify that search result for pricing type is displayed")
    public void iVerifyThatSearchResultForPricingTypeIsDisplayed() {
        conciergeProjectScreen.getResultsListForProjects().should(visible, Duration.ofSeconds(40));
    }

    @When("I introduces {string} first and last name")
    public void iIntroducesFirstAndLastName(String businessClient) {
        conciergeUserAccountPage.getClientLookupFirstName().should(visible, Duration.ofSeconds(25));
        with().pollInterval(2, SECONDS).await().until(() -> true);
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
        $(By.xpath("//*[text() = 'CONTINUE']")).click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        conciergeProjectScreen.getContinueCreateAProjectButton().click();
        conciergeUserAccountPage.getClientLookupEmail().shouldBe(visible, Duration.ofSeconds(12));
        conciergeUserAccountPage.getClientLookupEmail().setValue("test@test.com");
        conciergeProjectScreen.getClientPhone().shouldBe(visible, Duration.ofSeconds(12));
        conciergeProjectScreen.getClientPhone().setValue("1234567890");
        conciergeProjectScreen.getClientPostalCode().shouldBe(visible, Duration.ofSeconds(12));
        conciergeProjectScreen.getClientPostalCode().setValue("95035");
        conciergeProjectScreen.getContinueCreateAProjectButton().click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text() = 'Preferred Contact Method']/../div/div")).click();
        $(By.xpath("//*[text() = 'Phone']")).click();
        $(By.xpath("//*[text() = 'CREATE PROJECT']")).click();
//        conciergeProjectScreen.getProjectResultsFirstRow().should(visible, Duration.ofSeconds(12));
//        conciergeProjectScreen.getProjectResultsFirstRow().click();
    }

    @When("I click on new project button")
    public void iClickOnNewProjectButton() {
        conciergeProjectScreen.getNewProjectButton().should(visible, Duration.ofSeconds(12));
        conciergeProjectScreen.getNewProjectButton().click();
    }

    @When("I introduces details for new project")
    public void iIntroducesDetailsForNewProject() {
        conciergeProjectScreen.getPreferredContactMethodSelect().should(visible, Duration.ofSeconds(40));
        $(By.cssSelector("div[class='MuiInputBase-root MuiOutlinedInput-root Mui-error Mui-error MuiInputBase-fullWidth MuiInputBase-formControl'] div[role='button']")).click();
        conciergeProjectScreen.getPreferredEmailContactMethod().should(visible, Duration.ofSeconds(30));
        executeJavaScript("arguments[0].click();", conciergeProjectScreen.getPreferredEmailContactMethod());
        conciergeProjectScreen.getCreateProjectDetailsDescriptionField().should(visible, Duration.ofSeconds(30));
        conciergeProjectScreen.getCreateProjectDetailsDescriptionField().setValue("testDescription");
        executeJavaScript("arguments[0].click();", conciergeProjectScreen.getCreateProjectButton());
    }

    @Then("I verify that new project for <{string}> was created")
    public void iVerifyThatNewProjectForWasCreated(String businessClient) {
        if (businessClient.equals("member")) {
            assertEquals(conciergeProjectScreen.getAMemberValue().getText(), "A. Member");
        }
        if (businessClient.equals("nonmember")) {
            assertEquals($(By.xpath("(//*[text()='A. Nonmember'])[1]")).getText(), "A. Nonmember");
        }
        if (businessClient.equals("trade")) {
            assertEquals($(By.xpath("(//*[text()='A. Trade'])[1]")).getText(), "A. Trade");
        }
        if (businessClient.equals("")) {
            assertEquals($(By.xpath("(//*[text()='A. Member'])[1]")).getText(), "TestCompany");
        }
    }

    @When("I click on move to project button")
    public void iClickOnMoveToProjectButton() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        conciergeProjectScreen.getMoveToProjectButton().shouldHave(text("Move to Project"), Duration.ofMinutes(1));
        conciergeProjectScreen.getMoveToProjectButton().click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
    }

    @When("I click on save button")
    public void iClickOnSaveButton() {
        try {
            conciergeProjectScreen.getSaveMoveToProject().should(Condition.and("", visible, enabled), Duration.ofSeconds(10));
            conciergeProjectScreen.getSaveMoveToProject().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            conciergeProjectScreen.getSaveMoveToProjectUppercase().should(Condition.and("", visible, enabled), Duration.ofSeconds(10));
            conciergeProjectScreen.getSaveMoveToProjectUppercase().click();
        }
    }

    @Then("I verify that projects screen is displayed")
    public void iVerifyThatProjectsScreenIsDisplayed() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeProjectScreen.getForecastSetButton().should(visible, Duration.ofSeconds(40));
        assertTrue(conciergeProjectScreen.getSettingsButton().isDisplayed(), "Settings button is displayed");
        conciergeProjectScreen.getPrintButton().should(visible, Duration.ofSeconds(40));
        assertTrue(conciergeProjectScreen.getPrintButton().isDisplayed(), "Print button ia displayed");
        assertTrue(conciergeProjectScreen.getItems().isDisplayed(), "Items span is displayed");
        assertTrue(conciergeProjectScreen.getQty().isDisplayed(), "QTY span is displayed");
        assertTrue(conciergeProjectScreen.getSubtotal().isDisplayed(), "Subtotal span is displayed");
    }

    @When("I choose project from move to project pop up")
    public void iChooseProjectFromMoveToProjectPopUp() {
        conciergeProjectScreen.getProjectName().shouldHave(text("moveToProject"), Duration.ofSeconds(15));
        Select projectNameSelect = new Select(conciergeProjectScreen.getProjectName());
        projectNameSelect.selectByValue("P44181381");
    }

    @When("I click on the first project search result")
    public void iClickOnTheFirstProjectSearchResult() {
        if (conciergeProjectScreen.getPopUpErrorWhileLoadingProjects().isDisplayed()) {
            conciergeProjectScreen.getTryAgainButton().click();
            with().pollInterval(2, SECONDS).await().until(() -> true);
            conciergeProjectScreen.getFirstSearchResultOfProjects().should(visible, Duration.ofMinutes(5));
            conciergeProjectScreen.getFirstSearchResultOfProjects().click();
        } else {
            conciergeProjectScreen.getFirstSearchResultOfProjects().should(visible, Duration.ofMinutes(5));
            conciergeProjectScreen.getFirstSearchResultOfProjects().click();
        }
    }
    @When("I click on settings button")
    public void iClickOnSettingsButton() {
        conciergeProjectScreen.getSettingsButton().shouldHave(text("SETTINGS"), Duration.ofMinutes(1));
        conciergeProjectScreen.getSettingsButton().click();
    }

    @Then("I verify that project setting screen is displayed")
    public void iVerifyThatProjectSettingScreenIsDisplayed() {
        projectSettingsScreen.getUpdateProjectSettingsTitle().should(visible, Duration.ofSeconds(25));
        projectSettingsScreen.getAccountDetails().should(visible, Duration.ofSeconds(15));
        projectSettingsScreen.getSameShippingCheckBox().should(visible, Duration.ofSeconds(15));
        projectSettingsScreen.getUpdateProjectSettingsBtn().should(visible, Duration.ofSeconds(15));
    }

    @When("I click on the moodboard button")
    public void iClickOnTheMoodboardButton() {
        projectSettingsScreen.getMoodBoardButton().should(visible, Duration.ofSeconds(15));
        projectSettingsScreen.getMoodBoardButton().click();
    }

    @Then("moodboard screen is displayed")
    public void moodboardScreenIsDisplayed() {
        projectSettingsScreen.getMoodboardDeactiveButton().should(visible, Duration.ofSeconds(15));
    }

    @When("I introduces space name")
    public void iIntroducesSpaceName() {
        spaceName = generalStepDefs.getAlphaNumericString(4);
        projectSettingsScreen.getSpaceNameSpan().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        projectSettingsScreen.getSpaceNameSpan().should(visible, Duration.ofSeconds(12));
        projectSettingsScreen.getSpaceNameSpan().sendKeys(spaceName);
    }

    @When("I click on add space button")
    public void iClickOnAddSpaceButton() {

        projectSettingsScreen.getAddSpaceButton().should(visible, Duration.ofSeconds(40));
        projectSettingsScreen.getAddSpaceButton().click();
    }

    @Then("I verify that new space was created")
    public void iVerifyThatNewSpaceWasCreated() {
        assertTrue($(By.xpath("//*[text()='" + spaceName + "']")).isDisplayed(), "New space has been created");
        $(By.xpath("//*[text()='" + spaceName + "']")).should(visible, Duration.ofSeconds(12));
    }

    @When("I click on add new opportunity button")
    public void iClickOnAddNewOpportunityButton() {
        conciergeProjectScreen.getAddOpportunityButton().should(visible, Duration.ofSeconds(15));
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
        generalStepDefs.waitForJSandJQueryToLoad();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        $(By.xpath("//label[text() = 'Preferred Contact Method']/following-sibling::div")).should(Condition.and("", enabled, visible), Duration.ofSeconds(20));
        with().pollInterval(3, SECONDS).await().until(() -> true);
        $(By.xpath("//label[text() = 'Preferred Contact Method']/following-sibling::div")).click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        conciergeProjectScreen.getPreferredEmailContactMethod().shouldHave(text("Email"), Duration.ofSeconds(15));
        conciergeProjectScreen.getPreferredEmailContactMethod().click();
    }

    @When("I click on create opportunity button")
    public void iClickOnCreateOpportunityButton() {
        conciergeProjectScreen.getCreateOpportunityButton().should(visible, Duration.ofSeconds(30));
        conciergeProjectScreen.getCreateOpportunityButton().click();
    }

    @When("I add item to created opportunity")
    public void iAddItemToCreatedOpportunity() {
        conciergeItemsScreen.getAddToProjectButton().should(visible, Duration.ofSeconds(40));
        conciergeItemsScreen.getAddToProjectButton().click();
    }

    @Then("I verify that item was added")
    public void iVerifyThatItemWasAdded() {
        conciergeProjectScreen.getSaveMoveToProject().should(Condition.and("", visible, enabled), Duration.ofSeconds(20));
        executeJavaScript("arguments[0].click();", conciergeProjectScreen.getSaveMoveToProject());
        conciergeProjectScreen.getGoToProjectButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(20));
        executeJavaScript("arguments[0].click();", conciergeProjectScreen.getGoToProjectButton());
    }

    @When("I click on email estimate button")
    public void iClickOnEmailEstimateButton() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        conciergeProjectScreen.getEmailEstimateButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(50));
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        conciergeProjectScreen.getEmailEstimateButton().scrollIntoView(true);
        conciergeProjectScreen.getEmailEstimateButton().should(visible, Duration.ofSeconds(15));
        conciergeProjectScreen.getEmailEstimateButton().shouldHave(text("EMAIL ESTIMATE"), Duration.ofSeconds(20));
        with().pollInterval(3, SECONDS).await().until(() -> true);
        executeJavaScript("arguments[0].click();", conciergeProjectScreen.getEmailEstimateButton());
    }

    @When("I introduces client email from email estimate pop up")
    public void iIntroducesClientEmailFromEmailEstimatePopUp() {
        conciergeProjectScreen.getEmailEstimateEmailField().should(visible, Duration.ofMinutes(2));
        clientEmail = generalStepDefs.getAlphaNumericString(4) + "@mailinator.com";
        conciergeProjectScreen.getEmailEstimateEmailField().setValue(clientEmail);
        conciergeProjectScreen.getEmailEstimateMessageToClient().clear();
        conciergeProjectScreen.getEmailEstimateMessageToClient().setValue("this is test description");
    }

    @When("I introduces email in send copies of this project to additional emails")
    public void iIntroducesEmailInSendCopiesOfThisProjectToAdditionalEmails() {
        aditionalEmail = UUID.randomUUID() + "@mailinator.com";
        conciergeProjectScreen.getEmailEstimateAdditionEmailField().should(visible, Duration.ofSeconds(40));
        conciergeProjectScreen.getEmailEstimateAdditionEmailField().setValue(aditionalEmail);
    }

    @When("I click on email estimate button from project screen")
    public void iClickOnEmailEstimateButtonFromProjectScreen() {
        generalStepDefs.waitForJSandJQueryToLoad();
        $(By.xpath("//span[normalize-space()='ADD TO CART']")).shouldHave(text("ADD TO CART"), Duration.ofSeconds(15));
        with().pollInterval(3, SECONDS).await().until(() -> true);
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        $(By.id("footer")).scrollIntoView(true);
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeProjectScreen.getEmailEstimateProjectScreen().shouldHave(text("EMAIL ESTIMATE"), Duration.ofSeconds(20));
        executeJavaScript("arguments[0].click();", conciergeProjectScreen.getEmailEstimateProjectScreen());
    }

    @Then("I verify that the client received the letter on the {string}")
    public void iVerifyThatTheClientReceivedTheLetterOnThe(String email) {
        open("https://www.mailinator.com/");
        mailinator.getSearchEmailField().should(visible, Duration.ofSeconds(40));
        if (email.equals("client")) {
            mailinator.getSearchEmailField().setValue(clientEmail);
        }
        if (email.equals("additional")) {
            mailinator.getSearchEmailField().setValue(aditionalEmail);
        }
        mailinator.getGoButton().click();
//        mailinator.getFirstLetter().should(visible, Duration.ofSeconds(25));
//        mailinator.getFirstLetter().click();
//        switchTo().frame(mailinator.getMessageBodyIframe());
//        mailinator.getBodyEmailText().should(visible, Duration.ofSeconds(15));
//        mailinator.getAssociateName().should(visible, Duration.ofSeconds(15));
    }

    @When("I click on bcc associate checkbox")
    public void iClickOnBCCAssociateCheckbox() {
        conciergeProjectScreen.getBccAssociateCheckBox().should(visible, Duration.ofSeconds(40));
        conciergeProjectScreen.getBccAssociateCheckBox().click();
    }

    @Then("I verify that project list is displayed")
    public void iVerifyThatProjectListIsDisplayed() {
        conciergeProjectScreen.getProjectName().should(visible, Duration.ofSeconds(15));
        Select selectProjectName = new Select(conciergeProjectScreen.getProjectName());
        with().pollInterval(2, SECONDS).await().until(() -> true);
        selectProjectName.selectByVisibleText("A. Member");
        with().pollInterval(2, SECONDS).await().until(() -> true);
        assertTrue(conciergeProjectScreen.getAMemberValue().isDisplayed(), "A. Member project is displayed");
        selectProjectName.selectByVisibleText("TestCompany");
        with().pollInterval(2, SECONDS).await().until(() -> true);
        assertTrue(conciergeProjectScreen.getTestCompanyValue().isDisplayed(), "TestCompany project is displayed");
    }

    @Then("I verify that opportunity list is displayed")
    public void iVerifyThatOpportunityListIsDisplayed() {
        conciergeProjectScreen.getSelectOpportunityName().should(visible, Duration.ofSeconds(40));
        assertTrue(conciergeProjectScreen.getSelectOpportunityName().isDisplayed(), "Phase 4 opportunity is displayed");
    }

    @Given("I log into Concierge as nbohr@nomail.com")
    public void iLogIntoConciergeAsNbohrNomailCom() {
        conciergeLoginPage.getPasswordField().should(visible, Duration.ofMinutes(5));
        conciergeLoginPage.getUsernameField().setValue("zorro@pom.com");
        conciergeLoginPage.getPasswordField().setValue("Resto123");
        conciergeLoginPage.getSignInButton().should(visible, Duration.ofSeconds(30));
        conciergeLoginPage.getSignInButton().click();
        conciergeLoginPage.getLocationNewPortBeach().should(visible, Duration.ofSeconds(30));
        conciergeLoginPage.getLocationNewPortBeach().click();
        conciergeLoginPage.getContinueButton().should(visible, Duration.ofSeconds(30));
        conciergeLoginPage.getContinueButton().click();
    }

    @Then("I verify that spaces list is displayed")
    public void iVerifyThatSpacesListIsDisplayed() {
        conciergeProjectScreen.getSelectSpaceName().should(visible, Duration.ofSeconds(40));
        conciergeProjectScreen.getSelectSpaceName().click();
        assertTrue(conciergeProjectScreen.getSelectSpaceName().isDisplayed(), "test2 space is displayed");
        conciergeProjectScreen.getSelectSpaceName().click();
        assertTrue(conciergeProjectScreen.getSelectSpaceName().isDisplayed(), "test1 and test1 space is displayed");
    }

    @When("I go to category")
    public void iGoToCategory() {
        conciergeUserAccountPage.getInStockButtonMenu().should(visible, Duration.ofSeconds(40));
        conciergeUserAccountPage.getInStockButtonMenu().click();
        conciergeUserAccountPage.getInStockBedding().should(visible, Duration.ofSeconds(40));
        conciergeUserAccountPage.getInStockBedding().click();
        conciergeUserAccountPage.getToddlerBedding().should(visible, Duration.ofSeconds(40));
        conciergeUserAccountPage.getToddlerBedding().click();
    }


    @When("I search project {string} by provided {string}")
    public void iSearchProjectByProvided(String projectName, String searchBy) {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if(!conciergeProjectScreen.getProjectNameField().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        } else if (conciergeProjectScreen.getTryAgainButton().isDisplayed()) {
            conciergeProjectScreen.getTryAgainButton().click();
            with().pollInterval(3, SECONDS).await().until(() -> true);
        }
        generalStepDefs.waitForJSandJQueryToLoad();
        $(By.cssSelector("#demo-simple-select-outlined")).should(Condition.and("", visible, enabled), Duration.ofSeconds(25));
        $(By.cssSelector("#demo-simple-select-outlined")).shouldHave(text("Project Name"), Duration.ofSeconds(20));
        if (searchBy.equals("projectName")) {
            conciergeProjectScreen.getProjectNameField().should(Condition.and("", visible, enabled), Duration.ofSeconds(20));
            conciergeProjectScreen.getProjectNameField().setValue(projectName);
        }
        if (searchBy.equals("projectID")) {
            $(By.cssSelector("#demo-simple-select-outlined")).click();
            generalStepDefs.waitForJSandJQueryToLoad();
            conciergeProjectScreen.getProjectIdButton().shouldHave(text("Project ID"), Duration.ofSeconds(20));
            conciergeProjectScreen.getProjectIdButton().click();
            conciergeProjectScreen.getProjectIdField().should(visible, Duration.ofSeconds(40));
            conciergeProjectScreen.getProjectIdField().setValue("P54909938");
        }
        if (searchBy.equals("createdBy")) {
            $(By.cssSelector("#demo-simple-select-outlined")).click();
            generalStepDefs.waitForJSandJQueryToLoad();
            conciergeProjectScreen.getCreatedByButton().shouldHave(text("Created By"), Duration.ofSeconds(20));
            executeJavaScript("arguments[0].click();", conciergeProjectScreen.getCreatedByButton());
            conciergeProjectScreen.getClientFirstNameField().should(visible, Duration.ofSeconds(40));
            conciergeProjectScreen.getClientFirstNameField().setValue("Renuka");
            conciergeProjectScreen.getClientLastNameField().setValue("Boorla");
        }
        if (searchBy.equals("editedBy")) {
            $(By.cssSelector("#demo-simple-select-outlined")).click();
            generalStepDefs.waitForJSandJQueryToLoad();
            conciergeProjectScreen.getEditedBy().shouldHave(text("Edited By"), Duration.ofSeconds(20));
            conciergeProjectScreen.getEditedBy().click();
            conciergeProjectScreen.getClientFirstNameField().should(visible, Duration.ofSeconds(40));
            conciergeProjectScreen.getClientFirstNameField().setValue("Renuka");
            conciergeProjectScreen.getClientLastNameField().setValue("Boorla");
        }
        conciergeProjectScreen.getSearchByButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(5));
        with().pollInterval(2, SECONDS).await().until(() -> true);
        conciergeProjectScreen.getSearchByButton().click();
    }

    @When("I choose color from option")
    public void iChooseColorFromOption() {
        randomColor = generalStepDefs.getRandomNumber(0, 3);
        Select selectColor;
        if (Hooks.profile.equals("stg4")) {
            selectColor = new Select(selectOption.getColorStg4());
        } else {
            selectColor = new Select(selectOption.getLancasterColor());
        }
        selectColor.selectByIndex(randomColor);
    }

    @When("I click on edit options button")
    public void iClickOnEditOptionsButton() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        conciergeProjectScreen.getEditItemOptions().should(visible, Duration.ofSeconds(35));
        executeJavaScript("window.scrollBy(0,350)", "");
        projectSettingsScreen.getMoodBoardButton().shouldHave(text("MOODBOARD"), Duration.ofSeconds(15));
        conciergeProjectScreen.getEditItemOptions().click();
        System.out.println();
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
        executeJavaScript("window.scrollTo(0, 200)");
        randomQuantity = generalStepDefs.getRandomNumber(2, 5);
        $(By.xpath("//div[@aria-haspopup='listbox']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//div[@aria-haspopup='listbox']")).click();

        if (Hooks.profile.equals("stg2")) {
            randomQuantity = 1;
        }

        $(By.xpath("//li[@data-value='" + randomQuantity + "']")).shouldHave(text(Integer.toString(randomQuantity)), Duration.ofSeconds(10));
        $(By.xpath("//li[@data-value='" + randomQuantity + "']")).scrollIntoView(true);
        with().pollInterval(2, SECONDS).await().until(() -> true);
        $(By.xpath("//li[@data-value='" + randomQuantity + "']")).click();
    }

    @Then("verify that quantity for item was changed")
    public void verifyThatQuantityForItemWasChanged() {
        assertEquals(randomQuantity, Integer.parseInt($(By.xpath("//div[@aria-haspopup='listbox']")).getText()));
    }

    @And("I choose project by project name {string}")
    public void iChooseProjectByProjectName(String projectName) {
        conciergeProjectScreen.getProjectNameMoveToProject().should(visible, Duration.ofSeconds(40));
        conciergeProjectScreen.getProjectNameMoveToProject().click();
        $(By.xpath("//*[text()='" + projectName + "']")).click();
    }

    @When("I click on remove button from project for added item")
    public void iClickOnRemoveButtonFromProjectForAddedItem() {
        conciergeProjectScreen.getREMOVEbutton().should(visible, Duration.ofSeconds(40));
        conciergeProjectScreen.getREMOVEbutton().click();
    }

    @Then("I verify that item was removed")
    public void iVerifyThatItemWasRemoved() {
        conciergeProjectScreen.getItemIdSpan().shouldNotBe(visible, Duration.ofSeconds(20));
        assertFalse(conciergeProjectScreen.getItemIdSpan().isDisplayed(), "Item# is not displayed");
    }

    @And("I click on regular price for item projects")
    public void iClickOnRegularPriceForItemProjects() {
        conciergeProjectScreen.getOverridePriceregularPrice().should(visible, Duration.ofMinutes(1));
        executeJavaScript("window.scrollBy(0,150)", "Scroll to regular price");
        if(conciergeProjectScreen.getAdjustedPrice().isDisplayed()) {
            conciergeProjectScreen.getAdjustedPrice().click();
            with().pollInterval(2, SECONDS).await().until(() -> true);
        } else {
        conciergeProjectScreen.getOverridePriceregularPrice().should(visible, Duration.ofMinutes(1));
        conciergeProjectScreen.getOverridePriceregularPrice().click();
    }}

    @But("I choose {string} method for price override")
    public void iChooseMethodForPriceOverride(String methodValue) {
        conciergeProjectScreen.getPercentOffSelect().should(visible, Duration.ofSeconds(15));
        conciergeProjectScreen.getPercentOffSelect().click();
        $(By.xpath("//li[@data-value='" + methodValue + "']")).click();
    }

    @And("I introduce {string} percent discount")
    public void iIntroducePercentDiscount(String arg0) {
        while(conciergeProjectScreen.getPresentDiscount().isDisplayed()){
            conciergeProjectScreen.getPercentDiscount().sendKeys(Keys.BACK_SPACE);
        }
        conciergeProjectScreen.getPercentDiscount().setValue(arg0);
    }

    @When("I introduce {string} for reason code")
    public void iIntroduceForReasonCode(String reasonCode) {
        conciergeProjectScreen.getReasonCode().should(visible, Duration.ofSeconds(12));
        conciergeProjectScreen.getReasonCode().click();
        $(By.xpath("//li[@data-value='" + reasonCode + "']")).click();
    }

    @And("I click on apply button")
    public void iClickOnApplyButton() {
        if (conciergeProjectScreen.getApplyButton().isDisplayed()) {
            conciergeProjectScreen.getApplyButton().should(visible, Duration.ofSeconds(12));
            conciergeProjectScreen.getApplyButton().click();
        } else {
            conciergeProjectScreen.getUpdateButton().should(visible, Duration.ofSeconds(12));
            conciergeProjectScreen.getUpdateButton().click();
        }
    }

    @Then("I verify that overriden price displayed")
    public void iVerifyThatOverridenPriceDisplayed() {
        conciergeProjectScreen.getAdjustedPrice().should(visible, Duration.ofSeconds(40));
    }

    @And("I click on unlimited furniture delivery price")
    public void iClickOnUnlimitedFurnitureDeliveryPrice() {
        generalStepDefs.waitForJSandJQueryToLoad();
        $(By.id("footer")).shouldHave(text("RH.COM\n" +
                "DASHBOARD\n" +
                "PROJECTS\n" +
                "REGISTRY\n"), Duration.ofSeconds(20));
        with().pollInterval(3, SECONDS).await().until(() -> true);
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        $(By.id("footer")).scrollIntoView(true);
        with().pollInterval(3, SECONDS).await().until(() -> true);
        conciergeProjectScreen.getUfdPrice().should(Condition.and("", visible, enabled), Duration.ofSeconds(20));
        conciergeProjectScreen.getUfdPrice().click();
    }

    @When("I introduces {string} in dollar amount field")
    public void iIntroducesInDollarAmountField(String dollarAmount) {
        conciergeProjectScreen.getDollarAmountField().should(visible, Duration.ofSeconds(40));
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
        conciergeProjectScreen.getAmount50().should(visible, Duration.ofSeconds(40));
        assertTrue(conciergeProjectScreen.getAmount50().isDisplayed(), "Override price is displayed");
    }

    @And("I set the random quantity of goods")
    public void iSetTheRandomQuantityOfGoods() {
        conciergeProjectScreen.getLancasterSofaQty().should(visible, Duration.ofSeconds(12));
        Select frameQtySelect = new Select(conciergeProjectScreen.getLancasterSofaQty());
        randomQuantity = generalStepDefs.getRandomNumber(0, 30);
        frameQtySelect.selectByIndex(randomQuantity - 1);
    }

    @Then("I verify that subtotal amount updated according by quantity of items")
    public void iVerifyThatSubtotalAmountUpdatedAccordingByQuantityOfItems() {
        with().pollInterval(4, SECONDS).await().until(() -> true);
        String memberPriceText = conciergeProjectScreen.getRegularPrice().getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", "");
        int memberPrice = Integer.parseInt(memberPriceText);
        int totalItemPrice = randomQuantity * memberPrice;
        String finalPrice = Double.toString(totalItemPrice).replace(".", ",").replaceAll(",0", "");
        String forecast = conciergeProjectScreen.getForeCastTotalValue().getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", "");

        assertEquals(finalPrice, forecast, "Final price calculated correctly");
    }

    @And("I verify item price")
    public void iVerifyItemPrice() {
        conciergeProjectScreen.getRegularPriceValue().should(visible, Duration.ofSeconds(14));
        itemPrice = conciergeProjectScreen.getRegularPriceValue().getText();
    }

    @When("I change size {string} for project item")
    public void iChangeSizeForProjectItem(String size) {
        Select selectMirrorSize = new Select(conciergeProjectScreen.getMirrorSize());
        selectMirrorSize.selectByValue(size);
    }

    @When("I change finish {string} option for project item")
    public void iChangeFinishOptionForProjectItem(String finishValue) {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        Select selectFinish = new Select(conciergeProjectScreen.getFinishOption());
        selectFinish.selectByVisibleText(finishValue);
    }

    @Then("I verify that price was not changes")
    public void iVerifyThatPriceWasNotChanges() {
        conciergeProjectScreen.getRegularPriceValue().should(visible, Duration.ofSeconds(12));
        assertEquals(conciergeProjectScreen.getRegularPriceValue().getText(), itemPrice, "Price was not changed");
    }

    @Then("I verify that forecast value is updated after hiding the item")
    public void iVerifyThatForecastValueIsUpdatedAfterHidingTheItem() {
        conciergeProjectScreen.getForeCastAmount().shouldHave(text("Forecast Amount"), Duration.ofSeconds(30));
        executeJavaScript("window.scrollBy(0,500)", "");
        with().pollInterval(2, SECONDS).await().until(() -> true);
        conciergeProjectScreen.getCheckMarkItemButton().click();
        String priceBeforeHide = conciergeProjectScreen.getForeCastAmount().getText();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        conciergeProjectScreen.getCheckMarkItemButton().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        String priceAfterHide = conciergeProjectScreen.getForecastSetButton().getText();
        assertNotEquals(priceAfterHide, priceBeforeHide, "Forecast value is updated after ");
    }

    @When("I click on print button")
    public void iClickOnPrintButton() {
        conciergeProjectScreen.getPrintButton().should(visible, Duration.ofSeconds(12));
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
        conciergeProjectScreen.getPrintPopUp().should(visible, Duration.ofSeconds(12));
    }

    @When("I choose project from addToProject popup")
    public void iChooseProjectFromAddToProjectPopup() {
        conciergeProjectScreen.getAddToProjectProjectName().should(visible, Duration.ofMinutes(1));
        conciergeProjectScreen.getAddToProjectProjectName().click();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if(!conciergeItemsScreen.getSaveProjectPopUpButton().isEnabled() || !conciergeProjectScreen.getProjectNamePopUpDropDownListItem().isDisplayed() || conciergeItemsScreen.getError().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
            conciergeE2EStepDefs.iOpenProductPageWithAnd("prod1617188", "63130001");
            conciergeE2EStepDefs.userClickOnAddToProjectButton();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        conciergeProjectScreen.getProjectNamePopUpDropDownListItem().scrollIntoView(true);
        conciergeProjectScreen.getProjectNamePopUpDropDownListItem().click();
        conciergeItemsScreen.getSaveProjectPopUpButton().should(visible, Duration.ofMinutes(1));
        conciergeItemsScreen.getSaveProjectPopUpButton().click();
        generalStepDefs.isElementVisible("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4'][1]//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained')]");
        conciergeItemsScreen.getGoToProjectButton().click();
    }

    @Then("I verify that forecast value is update according to quantity of item")
    public void iVerifyThatForecastValueIsUpdateAccordingToQuantityOfItem() {
        int forecastExpected;
        conciergeProjectScreen.getRegularPrice().should(visible, Duration.ofSeconds(40));
        with().pollInterval(3, SECONDS).await().until(() -> true);
        if (Hooks.profile.equals("stg4")) {
            forecastExpected = randomQuantity * 4496;
        } else {
            forecastExpected = randomQuantity * 2150;
        }
        int forecastActual = Integer.parseInt(conciergeProjectScreen.getForecastamountValue().getText().replaceAll("\\$", "").replaceAll(",", "").replaceAll(".00", ""));
        assertEquals(forecastActual, forecastExpected, "Forecast value has been updated");
    }

    @And("I set the random quantity {string} of goods")
    public void iSetTheRandomQuantityOfGoods(String arg0) {
        randomQuantity = generalStepDefs.getRandomNumber(1, 10);
        $(By.id(arg0)).should(visible, Duration.ofSeconds(40));
        executeJavaScript("window.scrollTo(0, 200)");
        with().pollInterval(2, SECONDS).await().until(() -> true);
        Select selectQuantity = new Select($(By.id(arg0)));
        selectQuantity.selectByValue(String.valueOf(randomQuantity));
        with().pollInterval(2, SECONDS).await().until(() -> true);
    }

    @When("I choose pricing type {string}")
    public void iChoosePricingType(String arg0) {
        conciergeProjectScreen.getForecastamountValue().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeProjectScreen.getForecastamountValue().should(visible, Duration.ofSeconds(12));
//        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        $(By.id("footer")).shouldHave(text("RH.COM\n" +
                "DASHBOARD\n" +
                "PROJECTS\n" +
                "REGISTRY\n"), Duration.ofSeconds(20));
        $(By.id("footer")).scrollIntoView(true);

        conciergeProjectScreen.getPricingTypeDropdown().should(visible, Duration.ofMinutes(1));
        conciergeProjectScreen.getPricingTypeDropdown().click();
        if (arg0.equals("TRADE")) {
            conciergeProjectScreen.getTradePricingType().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
            conciergeProjectScreen.getTradePricingType().should(visible, Duration.ofSeconds(40));
            conciergeProjectScreen.getTradePricingType().click();
        }
        if (arg0.equals("NON-MEMBER")) {
            conciergeProjectScreen.getRegularPricingType().should(visible, Duration.ofSeconds(40));
            conciergeProjectScreen.getRegularPricingType().click();
        }
        if (arg0.equals("MEMBER")) {
            conciergeProjectScreen.getMemberPricingType().should(visible, Duration.ofSeconds(40));
            conciergeProjectScreen.getMemberPricingType().click();
        }
    }
    //$4,496.00

    @Then("I verify forecast for {string}")
    public void iVerifyForecastFor(String pricingType) {
        conciergeProjectScreen.getForeCastAmount().should(visible, Duration.ofSeconds(40));
        conciergeProjectScreen.getForeCastAmount().scrollIntoView(true);
        conciergeProjectScreen.getForeCastAmount().shouldHave(text("Forecast Amount"), Duration.ofSeconds(15));
        //String forecastPrice = conciergeProjectScreen.getForeCastAmount().getText().replaceAll("Forecast Amount", "");;
        with().pollInterval(3, SECONDS).await().until(() -> true);
        if (pricingType.equals("MEMBER")) {
            if (Hooks.profile.equals("stg4")) {
                assertEquals(conciergeProjectScreen.getForeCastAmount().getText().replaceAll("Forecast Amount", ""), "$4,496.00\n");
            } else {
                conciergeProjectScreen.getForeCastAmount().shouldHave(text("$1,616.00"), Duration.ofSeconds(25));
                String prType = conciergeProjectScreen.getForeCastAmount().getText().replaceAll("Forecast Amount", "");
                assertEquals(prType, "$1,616.00\n", "Forecast amount for member client is displayed");
            }
        }
        if (pricingType.equals("NON-MEMBER")) {
            if (Hooks.profile.equals("stg4")) {
                assertEquals(conciergeProjectScreen.getForeCastAmount().getText().replaceAll("Forecast Amount", ""), "$5,995.00\n");
            } else {
                conciergeProjectScreen.getForeCastAmount().shouldHave(text("$2,021.00"), Duration.ofSeconds(25));
                String prType = conciergeProjectScreen.getForeCastAmount().getText().replaceAll("Forecast Amount", "");
                assertEquals(prType, "$2,021.00\n", "Forecast amount for non-member client is displayed");
            }
        }
    }

    @When("user go to the next page {string} of projects")
    public void userGoToTheNextPageOfProjects(String arg0) {
        $(By.xpath("//button[@aria-label='Go to page " + arg0 + "']")).should(Condition.be(visible), Duration.ofSeconds(12));
        $(By.xpath("//button[@aria-label='Go to page " + arg0 + "']")).click();
    }

    @Then("user verifies that project page is displayed")
    public void userVerifiesThatProjectPageIsDisplayed() {
        $(By.xpath("//*[text()='MY PROJECTS']")).should(Condition.be(visible), Duration.ofSeconds(12));
        assertTrue($(By.xpath("//*[text()='MY PROJECTS']")).isDisplayed());
        assertTrue($(By.xpath("//h4[@class='MuiTypography-root MuiTypography-h4']")).isDisplayed());
    }

    @When("I verify that tax is not displayed")
    public void iVerifyThatTaxIsNotDisplayed() {
        if(conciergeProjectScreen.getTaxCheckedCheckbox().isDisplayed()){
            executeJavaScript("arguments[0].click();", conciergeProjectScreen.getTaxExemptCheckBox());
            with().pollInterval(3, SECONDS).await().until(() -> true);
        }
        $(By.xpath("//*[text()='Tax']")).should(visible, Duration.ofMinutes(1));
        conciergeProjectScreen.getTaxExemptCheckBox().scrollIntoView(true);
        executeJavaScript("arguments[0].click();", conciergeProjectScreen.getTaxExemptCheckBox());
        $(By.xpath("//*[text()='Tax']")).shouldNot(visible, Duration.ofMinutes(1));
        executeJavaScript("arguments[0].click();", conciergeProjectScreen.getTaxExemptCheckBox());
    }

    @Then("I verify that tax exempt is displayed")
    public void iVerifyThatTaxExemptIsDisplayed() {
        $(By.xpath("//*[text()='Tax']")).should(visible, Duration.ofSeconds(15));
        assertTrue($(By.xpath("//*[text()='Tax']")).isDisplayed());
    }

    @When("I clicks on item from two items in row")
    public void iClicksOnItemsFromTwoItemsInRow() {
        conciergeItemsScreen.getTwoItemsInRow().get(0).should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeItemsScreen.getTwoItemsInRow().get(0).click();
    }

    @When("I choose {string} for unclassified business client project")
    public void iChooseForUnclassifiedBusinessClientProject(String pricingType) {
        conciergeProjectScreen.getSettingsButton().shouldHave(text("SETTINGS"), Duration.ofSeconds(40));
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        conciergeProjectScreen.getPricingTypeDropdown().should(Condition.and("", visible, enabled), Duration.ofSeconds(40));
        conciergeProjectScreen.getPricingTypeDropdown().click();

        if (pricingType.equals("NON_MEMBER")) {
            $(By.xpath("//li[@data-value='" + pricingType + "']")).shouldHave(text("NON-MEMBER"), Duration.ofSeconds(10));
        }
        if (pricingType.equals("NON-TRADE")) {
            $(By.xpath("//li[@data-value='" + pricingType + "']")).shouldHave(text("NON-TRADE"), Duration.ofSeconds(10));
        }
        if (pricingType.equals("MEMBER")) {
            $(By.xpath("//li[@data-value='" + pricingType + "']")).shouldHave(text("MEMBER"), Duration.ofSeconds(10));
        }
        if ((pricingType.equals("TRADE"))) {
            $(By.xpath("//li[@data-value='" + pricingType + "']")).shouldHave(text("TRADE"), Duration.ofSeconds(10));
        }
        with().pollInterval(2, SECONDS).await().until(() -> true);
        $(By.xpath("//li[@data-value='" + pricingType + "']")).click();
    }

    @Then("I verify {string} for unclassified business client project")
    public void iVerifyForUnclassifiedBusinessClientProject(String pricingType) {
        if (pricingType.equals("NON_MEMBER") || (pricingType.equals("NON_TRADE"))) {
            conciergeProjectScreen.getForecastamountValue().shouldHave(text("$1,090.00"), Duration.ofSeconds(40));
            String forecastActual = conciergeProjectScreen.getForecastamountValue().getText().replaceAll("\\$", "").replaceAll(".00", "");
            $(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1'])[7]")).shouldHave(text("$1,090.00"), Duration.ofSeconds(120));
            assertEquals(forecastActual, "1,090", "Pricing for non member is displayed correctly");
        }
        if (pricingType.equals("MEMBER") || (pricingType.equals("TRADE"))) {
            conciergeProjectScreen.getForecastamountValue().shouldHave(text("$817.00"), Duration.ofSeconds(40));
            String forecastActual = conciergeProjectScreen.getForecastamountValue().getText().replaceAll("\\$", "").replaceAll(".00", "");
            $(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1'])[7]")).shouldHave(text("$817.00"), Duration.ofSeconds(120));
            assertEquals(forecastActual, "817", "Pricing for " + pricingType + " is displayed correctly");
        }
    }

    @When("user choose space {string}")
    public void userChooseSpace(String spaceName) {
        if(conciergeProjectScreen.getPopUpErrorSomethingWentWrong().isDisplayed()){
            conciergeProjectScreen.getTryAgainButton().click();
            with().pollInterval(2, SECONDS).await().until(() -> true);
        }
        if (spaceName.equals("space2")) {
            $(By.xpath("//div/h5[text() = 'space1']")).click();
            with().pollInterval(2, SECONDS).await().until(() -> true);
            $(By.xpath("//button/h5[text() = '" + spaceName + "']")).shouldHave(text(spaceName), Duration.ofSeconds(15));
            $(By.xpath("//button/h5[text() = '" + spaceName + "']")).click();
        }
        with().pollInterval(2, SECONDS).await().until(() -> true);
        $(By.xpath("//div/h5[contains(text(), 'space')]")).should(visible, Duration.ofSeconds(10));
        $(By.xpath("//div/h5[contains(text(), 'space')]")).click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        $(By.xpath("//button/h5[text() = '" + spaceName + "']")).shouldHave(text(spaceName), Duration.ofSeconds(15));
        $(By.xpath("//button/h5[text() = '" + spaceName + "']")).click();
    }

    @Then("user verify that items for {string} are displayed")
    public void userVerifyThatItemsForAreDisplayed(String spaceName) {
        if (spaceName.equals("space2")) {
            conciergeItemsScreen.getMetalFloatingMirror().should(visible, Duration.ofSeconds(15));
        } else {
            conciergeItemsScreen.getLapazSofaItem().should(visible, Duration.ofSeconds(15));
        }
    }

    @When("I click on agree&add button")
    public void iClickOnAgreeAddButton() {
        try {
            conciergeItemsScreen.getAggreeeAndAddToCardButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(5));
            conciergeItemsScreen.getAggreeeAndAddToCardButton().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Agree&add to cart button is not displayed");
        }
    }

    @Then("I verify that availability, Delivery and Returns messaging for {string} is displayed")
    public void iVerifyThatAvailabilityDeliveryAndReturnsMessagingForIsDisplayed(String arg0) {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        if (arg0.equals("SPO")) {
            $(By.xpath("(//*[text()='AVAILABILITY & DELIVERY'])[3]")).shouldHave(text("AVAILABILITY & DELIVERY"), Duration.ofSeconds(20)).scrollIntoView(true);
            executeJavaScript("window.scrollTo(0, 800)");
//            Actions actions = new Actions(WebDriverRunner.getWebDriver());
//            actions.moveToElement($(By.xpath("(//*[text()='AVAILABILITY & DELIVERY'])[3]")));
            with().pollInterval(3, SECONDS).await().until(() -> true);
            $(By.xpath("(//*[text()='AVAILABILITY & DELIVERY'])[3]")).click();
            $(By.xpath("//*[contains(text(),'This item is in stock and will be ready for delivery between')]")).shouldHave(text("This item is in stock and will be ready for delivery between"), Duration.ofSeconds(20));
        }
        if (arg0.equals("In stock")) {
            $(By.xpath("(//*[text()='AVAILABILITY & DELIVERY'])[2]")).shouldHave(text("AVAILABILITY & DELIVERY"),Duration.ofSeconds(20)).scrollIntoView(true);
            executeJavaScript("window.scrollTo(0, 800)");
            with().pollInterval(3, SECONDS).await().until(() -> true);
//            Actions actions = new Actions(WebDriverRunner.getWebDriver());
//            actions.moveToElement($(By.xpath("(//*[text()='AVAILABILITY & DELIVERY'])[2]")));
            $(By.xpath("(//*[text()='AVAILABILITY & DELIVERY'])[2]")).click();
//            $(By.xpath("(//div[@class='MuiTypography-root MuiTypography-caption MuiTypography-gutterBottom'])[2]")).shouldHave(text("This item is in stock and will be delivered"), Duration.ofSeconds(20));
        }

        if (arg0.equals("SPO In stock Items")) {
            with().pollInterval(3, SECONDS).await().until(() -> true);
            $(By.xpath("(//*[text()='AVAILABILITY & DELIVERY'])[2]")).shouldHave(text("AVAILABILITY & DELIVERY"), Duration.ofSeconds(20)).scrollIntoView(true);
            executeJavaScript("window.scrollTo(0, 800)");
            with().pollInterval(3, SECONDS).await().until(() -> true);
            $(By.xpath("(//*[text()='AVAILABILITY & DELIVERY'])[2]")).click();
            $(By.xpath("(//div[@class='MuiTypography-root MuiTypography-caption MuiTypography-gutterBottom'])[3]")).shouldHave(text("This item is in stock and will be ready for delivery"), Duration.ofSeconds(20));
        }

    }

    @When("I choose {string}")
    public void iChoose(String arg0) {
        if (arg0.equals("DESIGN")) {
            conciergeProjectScreen.getDesignButton().should(visible, Duration.ofSeconds(15));
            conciergeProjectScreen.getDesignButton().click();
        }

        if (arg0.equals("TRADE")) {
            conciergeProjectScreen.getTradeButton().should(visible, Duration.ofSeconds(15));
            conciergeProjectScreen.getTradeButton().click();
        }
    }

    @When("I introduces project name for new project for {string}")
    public void iIntroducesProjectNameForNewProjectFor(String arg0) {
        $(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[2]")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[2]")).setValue(arg0);
    }

    @Then("I verify that project for {string} was created")
    public void iVerifyThatProjectForWasCreated(String arg0) {
        $(By.xpath("//*[text()='A. Member" + arg0 + "']")).should(visible, Duration.ofSeconds(120));
    }

    @When("I choose currency for create a project pop up")
    public void iChooseCurrencyForCreateAProjectPopUp() {
        $(By.xpath("(//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input'])[2]")).click();
        conciergeProjectScreen.getUsdCurrencyValue().should(visible, Duration.ofSeconds(15));
        conciergeProjectScreen.getUsdCurrencyValue().click();
    }

    @When("I click on create project button")
    public void iClickOnCreateProjectButton() {
        conciergeProjectScreen.getCreateProjectButton().should(visible, Duration.ofSeconds(40));
        conciergeProjectScreen.getCreateProjectButton().click();
    }

    @When("I choose preferred contact method for projectType")
    public void iChoosePreferredContactMethodForProjectType() {
        $(By.xpath("(//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input'])[3]")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("(//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input'])[3]")).click();
        conciergeProjectScreen.getPreferredEmailContactMethod().shouldHave(text("Email"), Duration.ofSeconds(15));
        conciergeProjectScreen.getPreferredEmailContactMethod().click();
    }

    @Then("I verify that project list is displayed from add to project modal")
    public void iVerifyThatProjectListIsDisplayedFromAddToProjectModal() {
        $(By.xpath("//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiAutocomplete-inputRoot MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-adornedEnd MuiOutlinedInput-adornedEnd']")).should(visible, Duration.ofSeconds(15)).click();
    }

    @Then("I verify that opportunities list in dropdown is displayed from add to project modal")
    public void iVerifyThatOpportunitiesListInDropdownIsDisplayedFromAddToProjectModal() {
        $(By.xpath("(//select[@class='MuiSelect-root MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input'])[1]")).should(visible, Duration.ofSeconds(15));
    }

    @Then("I verify that space list in dropdown is displayed from add to project modal")
    public void iVerifyThatSpaceListInDropdownIsDisplayedFromAddToProjectModal() {
        $(By.xpath("(//select[@class='MuiSelect-root MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input'])[2]")).should(visible, Duration.ofSeconds(15));
    }

    @Then("I verify that item was added to the selected space")
    public void iVerifyThatItemWasAddedToTheSelectedSpace() {
        $(By.xpath("(//button[contains(@class, 'MuiButtonBase-root')])[5]")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("(//button[contains(@class, 'MuiButtonBase-root')])[5]")).click();
        $(By.xpath("//*[text()='" + spaceName + "']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='" + spaceName + "']")).scrollIntoView(true);
        $(By.xpath("//*[text()='" + spaceName + "']")).click();
        $(By.xpath("//img[@alt='French Contemporary Panel 4-Door Media Console']")).should(visible, Duration.ofSeconds(25));
    }

    @When("I click on save button uppercase")
    public void iClickOnSaveButtonUppercase() {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        conciergeProjectScreen.getSaveBtnUppercase().should(Condition.and("", enabled, visible), Duration.ofMinutes(1));
        conciergeProjectScreen.getSaveBtnUppercase().should(visible, Duration.ofSeconds(15));
        conciergeProjectScreen.getSaveBtnUppercase().click();

    }

    @Then("I verify the address page, prefilled address and email address must be filled")
    public void iVerifyTheAddressPagePrefilledAddressAndEmailAddressMustBeFilled() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        checkoutAddressScreen.getBillingAddressAsShippingCheckBox().click();
        checkoutAddressScreen.getContinuePaymentButton().scrollIntoView(true);
        checkoutAddressScreen.getContinuePaymentButton().should(visible, Duration.ofSeconds(15));
        checkoutAddressScreen.getContinuePaymentButton().click();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if(checkoutAddressScreen.getVerifyingShippingAddressPage().isDisplayed()){
            checkoutAddressScreen.getVerifyingShippingAddressPage().should(visible, Duration.ofSeconds(40));
            checkoutAddressScreen.getVerifyingBillingAddressPage().should(visible, Duration.ofSeconds(40));
        } else {
            checkoutAddressScreen.getVerifyingShippingAddressPage().should(visible, Duration.ofSeconds(40));
        }

    }

    @Then("I verify that item {string} was added to project")
    public void iVerifyThatItemWasAddedToProject(String itemName) {
        $(By.xpath("(//*[text()='" + itemName + "'])[2]")).should(visible, Duration.ofMinutes(1));
    }

    @Then("I verify that item added and project load in correct space and oppty")
    public void iVerifyThatItemAddedAndProjectLoadInCorrectSpaceAndOppty() {
        conciergeCartPageScreen.getSpaceDropDown().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeCartPageScreen.getSpaceDropDown().shouldHave(text("correctspace"), Duration.ofMinutes(1));
        $(By.xpath("//h6[contains(@class,'MuiTypography-h6 MuiTypography-gutterBottom MuiTypography-displayInline')]")).shouldHave(text("French Contemporary Panel 4-Door Media Console"), Duration.ofMinutes(1));
    }

    @When("I click on adjusted price")
    public void iClickOnAdjustedPrice() {
        conciergeProjectScreen.getAdjustedPrice().should(Condition.and("", visible, enabled), Duration.ofSeconds(30));
        conciergeProjectScreen.getAdjustedPrice().should(visible, Duration.ofMinutes(1));
        conciergeProjectScreen.getAdjustedPrice().click();
    }

    @When("I removed adjustment price")
    public void iRemovedAdjustemPrice() {
        if(conciergeProjectScreen.getPopUpErrorSomethingWentWrong().isDisplayed()){
           conciergeProjectScreen.getTryAgainButton().click();
            with().pollInterval(2, SECONDS).await().until(() -> true);
        }
        $(By.xpath("//*[text()='Remove']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Remove']")).click();
    }

    @When("I verify selections and deselection of project moodboard items")
    public void iVerifySelectionsAndDeselectionOfProjectMoodboardItems() {

    }

    @Then("I verify that sku id has been updated after changes")
    public void iVerifyThatSkuIdHasBeenUpdatedAfterChanges() {
        if(conciergeProjectScreen.getPopUpErrorSomethingWentWrong().isDisplayed()){
            conciergeProjectScreen.getTryAgainButton().click();
            with().pollInterval(2, SECONDS).await().until(() -> true);
        }
        randomQuantity = generalStepDefs.getRandomNumber(0, 4);
        with().pollInterval(3, SECONDS).await().until(() -> true);
        $(By.xpath("//div[1]/div/div[1]/button[2]")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//div[1]/div/div[1]/button[2]")).click();
        executeJavaScript("window.scrollTo(-200, 250)");
//        Select selectSize = new Select($(By.cssSelector("#optionSelect-0")));
//        selectSize.selectByIndex(randomQuantity);
        with().pollInterval(3, SECONDS).await().until(() -> true);
        $(By.xpath("//div[1]/div/div[1]/button[2]")).should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        $(By.xpath("//div[1]/div/div[1]/button[2]")).click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        if (randomQuantity == 0) {
            $(By.xpath("//*[text()='10070143 PEWT']")).should(visible, Duration.ofMinutes(1));
        }
        if (randomQuantity == 1) {
            $(By.xpath("//*[text()='40200454 PEWT']")).should(visible, Duration.ofMinutes(1));
        }
        if (randomQuantity == 2) {
            $(By.xpath("//*[text()='41450559 PEWT']")).should(visible, Duration.ofMinutes(1));
        }
        if (randomQuantity == 3) {
            $(By.xpath("//*[text()='40200388 PEWT']")).should(visible, Duration.ofMinutes(1));
        }
        if (randomQuantity == 4) {
            $(By.xpath("//*[text()='41120018 PEWT']")).should(visible, Duration.ofMinutes(1));
        }
    }

    @When("I click on view all button from space dropdown")
    public void iClickOnViewAllButtonFromSpaceDropdown() {
        $(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-colorTextPrimary' and text() = 'View All']")).should(visible, Duration.ofSeconds(10));
        $(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-colorTextPrimary' and text() = 'View All']")).click();
        $(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5' and text()='VIEW ALL']")).should(visible, Duration.ofSeconds(1));
        $(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5' and text()='VIEW ALL']")).click();
    }

    @Then("I verify that items from all spaces are displayed")
    public void iVerifyThatItemsFromAllSpacesAreDisplayed() {
        $(By.xpath("//*[text()='Space is empty, add products.']")).should(visible, Duration.ofSeconds(35));
    }

    @When("I introduces {string} in percent amount field")
    public void iIntroducesInPercentAmountField(String arg0) {
    }

    @When("I click on forecast set button")
    public void iClickOnForecastSetButton() {
        conciergeProjectScreen.getForecastSetButton().should(visible, Duration.ofSeconds(40));
        conciergeProjectScreen.getForecastSetButton().click();
    }

    @Then("I verify forecast amount for selected items & spaces")
    public void iVerifyForecastAmountForSelectedItemsSpaces() {
    }

    @When("I click on entire opportunity radio button")
    public void iClickOnEntireOpportunityRadioButton() {
        $(By.xpath("//*[text()='Entire Opportunity']")).should(visible, Duration.ofSeconds(1));
        $(By.xpath("//*[text()='Entire Opportunity']")).click();
    }

    @When("I click on Selected items & spaces radio button")
    public void iClickOnSelectedItemsSpacesRadioButton() {
        $(By.xpath("//*[text()='Selected items & spaces']")).should(visible, Duration.ofSeconds(30));
        $(By.xpath("//*[text()='Selected items & spaces']")).click();
    }
}