package com.test.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import com.test.pageObject.ConciergeOrderHistoryForm;
import com.test.pageObject.ConciergeUserAccountPage;
import static com.codeborne.selenide.Condition.visible;


public class ClientSearchStepDefs {
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeOrderHistoryForm conciergeOrderHistoryForm = new ConciergeOrderHistoryForm();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();


    @When("I search client by {string}")
    public void iSearchClientByEmail(String searchBy) {
        generalStepDefs.searchClientBy(searchBy);
    }


    @Then("I verify that client results is displayed")
    public void iVerifyThatClientResultsIsDisplayed() {
        conciergeOrderHistoryForm.getCustomerFirstName().shouldBe(visible, Duration.ofSeconds(50));
    }

    @When("I click on client button")
    public void iClickOnClientButton() {
        conciergeUserAccountPage.getClientButton().shouldBe(visible, Duration.ofMinutes(1));
        conciergeUserAccountPage.getClientButton().click();
        conciergeUserAccountPage.getClientLookupHeaderBtn().shouldBe(visible, Duration.ofSeconds(80));
        conciergeUserAccountPage.getClientLookupHeaderBtn().click();
    }

    @When("I create new client")
    public void iCreateNewClient() {
        conciergeUserAccountPage.getNewClientButton().shouldBe(visible, Duration.ofMinutes(1));
        conciergeUserAccountPage.getNewClientButton().click();
    }

    @Then("I verify that new client has been created")
    public void iVerifyThatNewClientHasBeenCreated() {
        conciergeUserAccountPage.getNewClientHeaderBtn().shouldBe(visible, Duration.ofSeconds(30));
    }


}