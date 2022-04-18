package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.test.pageObject.ConciergeLoginPage;
import com.test.pageObject.ConciergeUserAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
public class ConciergeAssociateStepDefs {
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    AbstractStepDefs abstractStepDefs = new AbstractStepDefs();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    private static final Logger Log = LoggerFactory.getLogger(ConciergeAssociateStepDefs.class);

    @Then("I expect that I am on the Concierge Dashboard page")
    public void iExpectThatIAmOnTheConciergeDashboardPage() {
        conciergeUserAccountPage.getMainMenuHeader().shouldBe(Condition.be(visible), Duration.ofSeconds(10));
        assertTrue(conciergeUserAccountPage.getMainMenuHeader().isDisplayed(), "");
    }

    @When("I change my store to store number 10")
    public void iChangeMyStoreToStoreNumber() {
        conciergeUserAccountPage.getNewPortBeachGallery().shouldBe(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getNewPortBeachGallery().click();
        conciergeUserAccountPage.getPaloAltpGallery().click();
        conciergeUserAccountPage.getGallerySubmitButton().shouldBe(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getGallerySubmitButton().click();
    }

    @Then("I verify I see store Palo Alto in the header")
    public void iVerifyISeeStoreInTheHeader() {
        conciergeUserAccountPage.getNewPortBeachGallery().shouldBe(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getNewPortBeachGallery().shouldBe(text("PALO ALTO"));
        assertEquals(conciergeUserAccountPage.getNewPortBeachGallery().getText(), "PALO ALTO");
    }

    @Given("I login into Concierge with valid credentials for the store 146: West Hollywood")
    public void iLoginIntoConciergeWithValidCredentialsForTheStoreWestHollywood() {
        conciergeLoginPage.getUsernameField().setValue("mdovbenco");
        conciergeLoginPage.getPasswordField().setValue("171096workouT!");
        conciergeLoginPage.getSignInButton().click();
        conciergeLoginPage.getLocationWestHolywood().click();
        conciergeLoginPage.getContinueButton().click();
    }

    @Then("user verifies list of galleries")
    public void userVerifiesListOfGalleries() {
        conciergeUserAccountPage.getGallerySelectButton().shouldHave(text("NEWPORT"));
        String actualListOfGalleries = conciergeUserAccountPage.getGallerySelectButton().getText();
        assertEquals(actualListOfGalleries, actualListOfGalleries);
    }

    @When("user clicks on gallery button from header")
    public void userClicksOnGalleryButtonFromHeader() {
        conciergeUserAccountPage.getNewPortBeachGallery().shouldBe(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getNewPortBeachGallery().click();
    }

    @Given("I log into Concierge as {string}")
    public void iLogIntoConciergeAs(String arg0) {
        Log.debug("I log into Concierge as " + arg0);
        generalStepDefs.loginAsRole(arg0);
    }

    @Given("I am on concierge dashboard for the store 146:West Hollywood")
    public void iAmOnConciergeDashboardForTheStoreWestHollywood() {
        generalStepDefs.loginAsRole("aleader");
        conciergeUserAccountPage.getNewPortBeachGallery().click();
        conciergeUserAccountPage.getWestHollywood().click();
    }

    @When("I have the following items in the cart:")
    public void iHaveTheFollowingItemsInTheCart() {
        conciergeUserAccountPage.getCartButton().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getCartButton().click();
    }

}

