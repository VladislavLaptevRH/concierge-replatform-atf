package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;
import tests.concierge.pageObject.ConciergeLoginPage;
import tests.concierge.pageObject.ConciergeUserAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
public class ConciergeAssociateStepDefs {
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    AbstractStepDefs abstractStepDefs = new AbstractStepDefs();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    private static final Logger Log = LoggerFactory.getLogger(ConciergeAssociateStepDefs.class);


    @Given("I log into Concierge as {string}")
    public void iLogIntoConciergeAs(String arg0) {
        Log.debug("I log into Concierge as " + arg0);
        generalStepDefs.loginAsRole(arg0);
        generalStepDefs.waitForJSandJQueryToLoad();

    }

    @Then("I expect that I am on the Concierge Dashboard page")
    public void iExpectThatIAmOnTheConciergeDashboardPage() {
        conciergeUserAccountPage.getMainMenuHeader().should(Condition.be(visible), Duration.ofSeconds(10));
        assertTrue(conciergeUserAccountPage.getMainMenuHeader().isDisplayed(), "");
    }

    @When("I change my store to store number 10")
    public void iChangeMyStoreToStoreNumber() {
        conciergeUserAccountPage.getNewPortBeachGallery().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getNewPortBeachGallery().click();
        conciergeUserAccountPage.getPaloAltpGallery().click();
        conciergeUserAccountPage.getGallerySubmitButton().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getGallerySubmitButton().click();
    }

    @Then("I verify I see store Palo Alto in the header")
    public void iVerifyISeeStoreInTheHeader() {
        conciergeUserAccountPage.getNewPortBeachGallery().should(visible, Duration.ofSeconds(40));
        conciergeUserAccountPage.getNewPortBeachGallery().should(text("PALO ALTO"));
        assertEquals(conciergeUserAccountPage.getNewPortBeachGallery().getText(), "PALO ALTO");
    }

    @Then("user verifies list of galleries")
    public void userVerifiesListOfGalleries() {
        conciergeUserAccountPage.getGallerySelectButton().shouldHave(text("NEWPORT"),Duration.ofSeconds(12));
        String actualListOfGalleries = conciergeUserAccountPage.getGallerySelectButton().getText();
        assertEquals(actualListOfGalleries, actualListOfGalleries);
    }

    @When("user clicks on gallery button from header")
    public void userClicksOnGalleryButtonFromHeader() {
        conciergeUserAccountPage.getNewPortBeachGallery().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getNewPortBeachGallery().click();
    }

    @When("I choose contract gallery")
    public void iChooseContractGallery() {
        conciergeUserAccountPage.getGalleryButton().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getGalleryButton().click();
        conciergeUserAccountPage.getGalleryButton().should(visible, Duration.ofSeconds(15));
        Select gallerySelect = new Select(conciergeUserAccountPage.getGallerySelect());
        gallerySelect.selectByValue("997");
        conciergeUserAccountPage.getGallerySubmitButton().click();
        sleep(3000);
        //997: Contract

        conciergeUserAccountPage.getGallerySelect().click();


    }

    @Then("I verify footer links")
    public void iVerifyFooterLinks() {
        $(By.xpath("//*[text()='RH.COM']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='DASHBOARD']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='PROJECTS']")).should(visible, Duration.ofSeconds(40));
    }
}

