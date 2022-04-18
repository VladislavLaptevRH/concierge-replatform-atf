package com.test.stepdefinitions;

import com.test.pageObject.ConciergeLoginPage;
import com.test.pageObject.ConciergeUserAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;


public class ConciergeAccessibilityStepDefs {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(ConciergeAccessibilityStepDefs.class);

    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();

    @Given("^user opens the concierge site$")
    public void User_Ppens_The_Concierge_Site() {
        conciergeLoginPage.getUsernameField().shouldBe(visible, Duration.ofMinutes(5));
        conciergeLoginPage.getSignInButton().shouldBe(visible, Duration.ofMinutes(5));
        logger.info("Concierge portal opened with success");
    }


    @Then("user expects that no accessibility errors")
    public void userExpectsThatNoAccessibilityErrors() {
        conciergeUserAccountPage.getArtButtonMenu().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getBathButtonMenu().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getBedButtonMenu().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getArtButtonMenu().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getProjectsButton().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getLocationButton().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getInStockButtonMenu().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getLivingButtonMenu().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getDiningButtonMenu().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getBedButtonMenu().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getBathButtonMenu().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getLightingButtonMenu().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getTextilesButtonMenu().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getRugsButtonMenu().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getWindowsButtonMenu().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getDecorButtonMenu().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getArtButtonMenu().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getOutdoorButtonMenu().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getGiftsButtonMenu().shouldBe(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getSaleButtonMenu().shouldBe(visible, Duration.ofSeconds(10));
        logger.info("Accessibility errors are not present on the user account page");

    }

    @When("user sign in concierge portal")
    public void userSignInConciergePortal() {
        conciergeLoginPage.getUsernameField().shouldBe(visible, Duration.ofMinutes(1));
        conciergeLoginPage.getUsernameField().setValue("automationassociate");
        conciergeLoginPage.getPasswordField().setValue("S3pUgx4W");
        conciergeLoginPage.getSignInButton().click();
        conciergeLoginPage.getLocationNewPortBeach().click();
        conciergeLoginPage.getContinueButton().click();
    }

    @Then("user verifies that all items from menu are displayed")
    public void userVerifiesThatAllItemsFromMenuAreDisplayed() {
        List<String> expectedItems = new ArrayList(Arrays.asList("Living", "Dining", "Bed", "Bath", "Lighting", "Textiles", "Rugs", "Windows", "Décor", "Art", "Outdoor", "SALE"));
        List<String> items = new ArrayList<>();
        for (int i = 0; i < conciergeUserAccountPage.getMenuItems().size(); i++) {
            items = new ArrayList(Arrays.asList(conciergeUserAccountPage.getMenuItems().get(i).getText()));
        }
        GeneralStepDefs.compareList(expectedItems, items);
    }

}
