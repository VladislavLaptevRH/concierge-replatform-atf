package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.test.pageObject.ConciergeAddressScreen;
import com.test.pageObject.ConciergeUserAccountPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

public class ClientStepDefs {
    ConciergeAddressScreen conciergeAddressScreen = new ConciergeAddressScreen();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();

    @Then("I verify sold-to, billing, shipping address on address page")
    public void iVerifySoldToBillingShippingAddressOnAddressPage() {
        conciergeAddressScreen.getBillingAddressText().should(Condition.visible, Duration.ofSeconds(15));
        conciergeAddressScreen.getShippingAddressText().should(Condition.visible, Duration.ofSeconds(15));
        conciergeAddressScreen.getSoldToAddressTitle().should(Condition.visible, Duration.ofSeconds(15));
    }

    @Then("I verify that I'm able to select contract client")
    public void iVerifyThatIMAbleToSelectContractClient() {
        conciergeUserAccountPage.getCloseButton().should(Condition.visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getContractAccountText().should(Condition.visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getYouHaveSelectedContractAccountText().should(Condition.visible, Duration.ofSeconds(15));
    }

    @When("I go to collection page")
    public void iGoToCollectionPage() {

    }
}
