package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.test.pageObject.ConciergeOrderHistoryForm;
import com.test.pageObject.ConciergeUserAccountPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.sleep;


public class ClientSearchStepDefs {
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeOrderHistoryForm conciergeOrderHistoryForm = new ConciergeOrderHistoryForm();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    @When("I search client by {string}")
    public void iSearchClientByEmail(String searchBy) {
        sleep(2000);
        generalStepDefs.searchClientBy(searchBy);
    }

    @Then("I verify that client results is displayed")
    public void iVerifyThatClientResultsIsDisplayed() {
        conciergeOrderHistoryForm.getCustomerFirstName().should(visible, Duration.ofSeconds(50));
    }

    @When("I click on client button")
    public void iClickOnClientButton() {
        conciergeUserAccountPage.getClientButton().should(Condition.and("Displayed", appear, exist), Duration.ofMinutes(1));
        conciergeUserAccountPage.getClientButton().click();
        conciergeUserAccountPage.getClientLookupHeaderBtn().shouldHave(text("Client Lookup"), Duration.ofMinutes(1));
        conciergeUserAccountPage.getClientLookupHeaderBtn().click();
    }

    @When("I create new client")
    public void iCreateNewClient() {
        conciergeUserAccountPage.getNewClientButton().should(visible, Duration.ofMinutes(1));
        conciergeUserAccountPage.getNewClientButton().click();
    }

    @Then("I verify that new client has been created")
    public void iVerifyThatNewClientHasBeenCreated() {
        conciergeUserAccountPage.getNewClientHeaderBtn().should(visible, Duration.ofSeconds(30));
    }
}