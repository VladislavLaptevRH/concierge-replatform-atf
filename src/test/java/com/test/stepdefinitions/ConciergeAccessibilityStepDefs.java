package com.test.stepdefinitions;

import com.test.pageObject.ConciergeLoginPage;
import com.test.pageObject.ConciergeUserAccountPage;
import com.test.utility.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import static org.testng.Assert.assertTrue;


public class ConciergeAccessibilityStepDefs {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(ConciergeAccessibilityStepDefs.class);

    WebDriver webDriver = Hooks.getWebDriver();
    WebDriverWait wait = new WebDriverWait(webDriver, 20);
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage(webDriver);
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage(webDriver);
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    @Given("^user opens the concierge site$")
    public void User_Ppens_The_Concierge_Site() {
        wait.until(ExpectedConditions.visibilityOf(conciergeLoginPage.getUsernameField()));
        assertTrue(conciergeLoginPage.getUsernameField().isDisplayed());
        assertTrue(conciergeLoginPage.getUsernameField().isDisplayed());
        assertTrue(conciergeLoginPage.getSignInButton().isDisplayed());
        logger.info("Concierge portal opened with success");

    }


    @Then("user expects that no accessibility errors")
    public void userExpectsThatNoAccessibilityErrors() {
        generalStepDefs.waitForPageLoad(webDriver);
        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getBathButtonMenu()));
        assertTrue(conciergeUserAccountPage.getArtButtonMenu().isDisplayed());
        assertTrue(conciergeUserAccountPage.getBathButtonMenu().isDisplayed());
        assertTrue(conciergeUserAccountPage.getBedButtonMenu().isDisplayed());
        assertTrue(conciergeUserAccountPage.getArtButtonMenu().isDisplayed());
        assertTrue(conciergeUserAccountPage.getProjectsButton().isDisplayed());
        assertTrue(conciergeUserAccountPage.getLocationButton().isDisplayed());
        assertTrue(conciergeUserAccountPage.getInStockButtonMenu().isDisplayed());
        assertTrue(conciergeUserAccountPage.getLivingButtonMenu().isDisplayed());
        assertTrue(conciergeUserAccountPage.getDiningButtonMenu().isDisplayed());
        assertTrue(conciergeUserAccountPage.getBedButtonMenu().isDisplayed());
        assertTrue(conciergeUserAccountPage.getBathButtonMenu().isDisplayed());
        assertTrue(conciergeUserAccountPage.getLightingButtonMenu().isDisplayed());
        assertTrue(conciergeUserAccountPage.getTextilesButtonMenu().isDisplayed());
        assertTrue(conciergeUserAccountPage.getRugsButtonMenu().isDisplayed());
        assertTrue(conciergeUserAccountPage.getWindowsButtonMenu().isDisplayed());
        assertTrue(conciergeUserAccountPage.getDecorButtonMenu().isDisplayed());
        assertTrue(conciergeUserAccountPage.getArtButtonMenu().isDisplayed());
        assertTrue(conciergeUserAccountPage.getOutdoorButtonMenu().isDisplayed());
        assertTrue(conciergeUserAccountPage.getGiftsButtonMenu().isDisplayed());
        assertTrue(conciergeUserAccountPage.getSaleButtonMenu().isDisplayed());
        logger.info("Accessibility errors are not present on the user account page");

    }

    @When("user sign in concierge portal")
    public void userSignInConciergePortal() throws InterruptedException {
        conciergeLoginPage.getUsernameField().sendKeys("mdovbenco");
        conciergeLoginPage.getPasswordField().sendKeys("171096workouT!");
        conciergeLoginPage.getSignInButton().click();
        conciergeLoginPage.getLocationNewPortBeach().click();
        conciergeLoginPage.getContinueButton().click();
    }


}
