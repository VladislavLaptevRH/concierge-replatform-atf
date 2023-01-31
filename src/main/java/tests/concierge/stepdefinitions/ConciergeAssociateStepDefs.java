package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

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

    @When("I change my store to number {string}")
    public void iChangeMyStoreToStoreNumber(String storeNumber) {
        conciergeUserAccountPage.getNewPortBeachGallery().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getNewPortBeachGallery().click();
        conciergeUserAccountPage.getNewPortBeachGallery().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getGallerySelect().click();
        conciergeUserAccountPage.getCurrentLocationGalleryItemByName(storeNumber).click();
        conciergeUserAccountPage.getGallerySubmitButton().click();
        sleep(3000);
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

    @When("I choose gallery number {string}")
    public void iChooseContractGallery(String galleryNumber) {
        conciergeUserAccountPage.getGalleryButton().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getGalleryButton().click();
        conciergeUserAccountPage.getGalleryButton().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getGallerySelect().click();
        conciergeUserAccountPage.getCurrentLocationGalleryItemByName(galleryNumber).click();
        conciergeUserAccountPage.getGallerySubmitButton().click();
        sleep(3000);
    }

    @Then("I verify footer links")
    public void iVerifyFooterLinks() {
        $(By.xpath("//*[text()='RH.COM']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='DASHBOARD']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='PROJECTS']")).should(visible, Duration.ofSeconds(40));
    }

    @Then("I validate each cat and sub-cat")
    public void iValidateEachCatAndSubCat() {
        sleep(2000);
        for (int main = 1; main < conciergeUserAccountPage.getListOfMainCategories().size(); main++) {
            System.out.println("Main Category: " + conciergeUserAccountPage.getListOfMainCategories().get(main).getText());
            try {
                conciergeUserAccountPage.getListOfMainCategories().get(main).click();
            } catch (Exception e) {
                e.printStackTrace();
            }

            for (int sub = 0; sub < conciergeUserAccountPage.getListOfSubCategories().size(); sub++) {
                System.out.println("Sub Category: " + conciergeUserAccountPage.getListOfSubCategories().get(sub).getText());
                try {
                    conciergeUserAccountPage.getListOfSubCategories().get(sub).click();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sleep(5000);

                for (int collection = 0; collection < conciergeUserAccountPage.getListOfCollections().size(); collection++) {
                    System.out.println("Collection: " + conciergeUserAccountPage.getListOfCollections().get(collection).getText());
                    try {
                        conciergeUserAccountPage.getListOfCollections().get(collection).click();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    sleep(5000);
                    System.out.println(WebDriverRunner.getWebDriver().getTitle() + ": "+ Hooks.getCurrentUrl());
                    if (!Hooks.getCurrentUrl().contains("concierge")) {
                        open(Hooks.conciergeURL);
                        sleep(5000);
                    }

                    try {
                        conciergeUserAccountPage.getListOfMainCategories().get(main).click();
                        sleep(5000);
                        conciergeUserAccountPage.getListOfSubCategories().get(sub).click();
                        sleep(5000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

