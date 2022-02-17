package com.test.stepdefinitions;

import com.test.pageObject.ConciergeLoginPage;
import com.test.pageObject.ConciergeUserAccountPage;
import com.test.utility.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertTrue;

@Getter
public class ConciergeAssociateStepDefs {
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    AbstractStepDefs abstractStepDefs = new AbstractStepDefs();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    @Then("I expect that I am on the Concierge Dashboard page")
    public void iExpectThatIAmOnTheConciergeDashboardPage() {
        assertTrue(conciergeUserAccountPage.getUserNameButton().isDisplayed());
        assertTrue(conciergeUserAccountPage.getArtButtonMenu().getText().equals("ART"));
        assertTrue(conciergeUserAccountPage.getBathButtonMenu().getText().equals("BATH"));
        assertTrue(conciergeUserAccountPage.getBedButtonMenu().getText().equals("BED"));
        assertTrue(conciergeUserAccountPage.getProjectsButton().getText().equals("PROJECTS"));
        assertTrue(conciergeUserAccountPage.getLocationButton().isDisplayed());
        assertTrue(conciergeUserAccountPage.getInStockButtonMenu().getText().equals("IN STOCK"));
        assertTrue(conciergeUserAccountPage.getLivingButtonMenu().getText().equals("LIVING"));
        assertTrue(conciergeUserAccountPage.getDiningButtonMenu().getText().equals("DINING"));
        assertTrue(conciergeUserAccountPage.getLightingButtonMenu().getText().equals("LIGHTING"));
        assertTrue(conciergeUserAccountPage.getTextilesButtonMenu().getText().equals("TEXTILES"));
        assertTrue(conciergeUserAccountPage.getRugsButtonMenu().getText().equals("RUGS"));
        assertTrue(conciergeUserAccountPage.getWindowsButtonMenu().getText().equals("WINDOWS"));
        assertTrue(conciergeUserAccountPage.getDecorButtonMenu().getText().equals("DÉCOR"));
        assertTrue(conciergeUserAccountPage.getOutdoorButtonMenu().getText().equals("OUTDOOR"));
        assertTrue(conciergeUserAccountPage.getGiftsButtonMenu().getText().equals("GIFTS"));
        assertTrue(conciergeUserAccountPage.getSaleButtonMenu().getText().equals("SALE"));
    }

    @When("I change my store to store number 10")
    public void iChangeMyStoreToStoreNumber() {
        conciergeUserAccountPage.getNewPortBeachGallery().click();
        conciergeUserAccountPage.getPaloAltpGallery().click();
        conciergeUserAccountPage.getGallerySubmitButton().click();
    }

    @Then("I verify I see store Palo Alto in the header")
    public void iVerifyISeeStoreInTheHeader() {
        conciergeUserAccountPage.getNewPortBeachGallery().shouldBe(text("PALO ALTO"));
        assertTrue(conciergeUserAccountPage.getNewPortBeachGallery().getText().equals("PALO ALTO"));
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
        assertTrue(actualListOfGalleries.equals(actualListOfGalleries));
    }

    @When("user clicks on gallery button from header")
    public void userClicksOnGalleryButtonFromHeader() {
        conciergeUserAccountPage.getNewPortBeachGallery().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getNewPortBeachGallery().click();
    }

    @Given("I log into Concierge as {string}")
    public void iLogIntoConciergeAs(String arg0) {
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

