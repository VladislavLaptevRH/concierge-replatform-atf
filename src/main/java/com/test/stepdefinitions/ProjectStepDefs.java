package com.test.stepdefinitions;

import com.test.pageObject.ConciergeProjectScreen;
import com.test.pageObject.ConciergeUserAccountPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectStepDefs {
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeProjectScreen conciergeProjectScreen = new ConciergeProjectScreen();

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
        $(By.xpath("//tr[contains(@class,'MuiTableRow-root')]/td[1]")).shouldBe(visible, Duration.ofSeconds(12));
        $(By.xpath("//tr[contains(@class,'MuiTableRow-root')]/td[1]")).click();
    }

    @When("I click on new project button")
    public void iClickOnNewProjectButton() {
        conciergeProjectScreen.getNewProjectButton().shouldBe(visible, Duration.ofSeconds(12));
        conciergeProjectScreen.getNewProjectButton().click();
    }

    @When("I introduces details for new project")
    public void iIntroducesDetailsForNewProject() {
        conciergeProjectScreen.getPrefferedContactMethodSelect().shouldBe(visible, Duration.ofSeconds(40));
        conciergeProjectScreen.getPrefferedContactMethodSelect().click();
        conciergeProjectScreen.getPrefferedEmailContactMethod().shouldBe(visible, Duration.ofSeconds(30));
        conciergeProjectScreen.getPrefferedEmailContactMethod().click();
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
}
