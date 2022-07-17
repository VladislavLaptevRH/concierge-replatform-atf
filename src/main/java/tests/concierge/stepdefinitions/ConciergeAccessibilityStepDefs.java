package tests.concierge.stepdefinitions;

import tests.concierge.pageObject.ConciergeLoginPage;
import tests.concierge.pageObject.ConciergeUserAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;

public class ConciergeAccessibilityStepDefs {
    private static final Logger Log = LoggerFactory.getLogger(ConciergeAccessibilityStepDefs .class);
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();

    @Given("^user opens the tests.concierge site$")
    public void User_Ppens_The_Concierge_Site() {
        Log.debug("User opens the tests.concierge product");
        conciergeLoginPage.getUsernameField().should(visible, Duration.ofMinutes(5));
        conciergeLoginPage.getSignInButton().should(visible, Duration.ofMinutes(5));
    }

    @Then("user expects that no accessibility errors")
    public void userExpectsThatNoAccessibilityErrors() {
        conciergeUserAccountPage.getArtButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getBathButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getBedButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getArtButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getProjectsButton().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getLocationButton().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getInStockButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getLivingButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getDiningButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getBedButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getBathButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getLightingButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getTextilesButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getRugsButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getWindowsButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getDecorButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getArtButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getOutdoorButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getGiftsButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getSaleButtonMenu().should(visible, Duration.ofSeconds(10));
    }

    @When("user sign in tests.concierge portal")
    public void userSignInConciergePortal() {
        conciergeLoginPage.getUsernameField().should(visible, Duration.ofMinutes(1));
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
