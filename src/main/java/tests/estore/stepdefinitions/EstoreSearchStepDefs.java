package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.*;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;

public class EstoreSearchStepDefs {
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstoreCGScreen estoreCGScreen = new EstoreCGScreen();
    EstorePDPScreen estorePDPScreen = new EstorePDPScreen();
    EstoreSearchScreen estoreSearchScreen = new EstoreSearchScreen();
    EstoreItemPage estoreItemPage = new EstoreItemPage();

    @Then("I verify that search result for search product via product name is displayed")
    public void iVerifyThatSearchResultForSearchProductViaProductNameIsDisplayed() {
        estoreSearchScreen.getTurkish802towel().should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//span[@class='priceBox']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//span[@class='priceBox']")).shouldHave(text("$"), Duration.ofSeconds(20));
    }

    @When("I introduced random text for search field")
    public void iIntroducedRandomTextForSearchField() {
        generalStepDefs.waitForJSandJQueryToLoad();
        estoreSearchScreen.getSearchIcon().should(visible, Duration.ofSeconds(60));
        estoreSearchScreen.getSearchIcon().click();
        estoreUserAccountPage.getSearchItemField().should(Condition.and("", visible, enabled), Duration.ofSeconds(40));
        estoreUserAccountPage.getSearchItemField().should(empty, Duration.ofMinutes(1));
        estoreUserAccountPage.getSearchItemField().click();
        generalStepDefs.waitForJSandJQueryToLoad();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        estoreUserAccountPage.getSearchItemField().setValue(generalStepDefs.getAlphaNumericString(7));

        estoreSearchScreen.getSeeAllResultsButton().should(visible, Duration.ofSeconds(40));
        estoreSearchScreen.getSeeAllResultsButton().click();
    }

    @Then("I verify that we cannot find what you are looking message is displayed")
    public void iVerifyThatWeCannotFindWhatYouAreLookingMessageIsNotDisplayed() {
        estoreSearchScreen.getSorryWeCannotFindMsg().should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify count of search results")
    public void iVerifyCountOfSearchResults() {
        estoreSearchScreen.getResults().should(visible, Duration.ofSeconds(20));
    }

    @When("I scroll to the bottom of the estore page")
    public void iScrollToTheBottomOfTheEstorePage() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    @When("I click on estore back to top button")
    public void iClickOnEstoreBackToTopButton() {
        estoreCGScreen.getBackToTopButton().should(visible, Duration.ofSeconds(20));
        estoreCGScreen.getBackToTopButton().click();
    }

    @Then("I verify that search results for {string} is displayed")
    public void iVerifyThatSearchResultsForIsDisplayed(String arg0) {
        $(By.xpath("//*[text()='" + arg0 + "']")).should(visible, Duration.ofSeconds(20));
    }

    @When("I select low to high for estore")
    public void iSelectLowToHighForEstore() {
        if (Hooks.cookie.equals("releasethurs")) {
            estorePDPScreen.getSortByButton().should(visible, Duration.ofSeconds(20));
            estorePDPScreen.getSortByButton().click();
        }
         if(Hooks.cookie.contains("userservice")){
                estorePDPScreen.getSortByButton().should(visible, Duration.ofSeconds(20));
                estorePDPScreen.getSortByButton().click();
            } else {
            estorePDPScreen.getSortButton().should(visible, Duration.ofSeconds(20));
            estorePDPScreen.getSortButton().click();
        }
        estorePDPScreen.getPriceLowToHigh().should(visible, Duration.ofSeconds(20));
        estorePDPScreen.getPriceLowToHigh().click();
    }

    @When("I select high to low for estore")
    public void iSelectHighToLowForEstore() {
        if (Hooks.cookie.equals("releasethurs")) {
            estorePDPScreen.getSortByButton().should(visible, Duration.ofSeconds(20));
            estorePDPScreen.getSortByButton().click();
        }
        if(Hooks.cookie.contains("userservice")){
            estorePDPScreen.getSortByButton().should(visible, Duration.ofSeconds(20));
            estorePDPScreen.getSortByButton().click();
        }else {
            estorePDPScreen.getSortButton().should(visible, Duration.ofSeconds(20));
            estorePDPScreen.getSortButton().click();
        }
        estorePDPScreen.getPriceHighToLow().should(visible, Duration.ofSeconds(20));
        estorePDPScreen.getPriceHighToLow().click();
    }

    @When("I navigate for the first product PDP")
    public void iNavigateForTheFirstProductPDP() {
        estorePDPScreen.getFirstProduct().should(visible, Duration.ofSeconds(20));
        estorePDPScreen.getFirstProduct().click();
    }

    @Then("I verify pricing on search result page")
    public void iVerifyPricingOnSearchResultPage() {
        estorePDPScreen.getPriceBox().should(visible, Duration.ofSeconds(20));
        estorePDPScreen.getPriceBox().shouldHave(text("$"), Duration.ofSeconds(20));
    }

    @Then("I verify that I'm able to use back button")
    public void iVerifyThatIMAbleToUseBackButton() {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        WebDriverRunner.getWebDriver().navigate().back();
        estorePDPScreen.getFirstProduct().should(visible, Duration.ofSeconds(20));

    }

    @Then("I verify that I'm able to use back button from CG")
    public void iVerifyThatIMAbleToUseBackButtonFromCG() {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        WebDriverRunner.getWebDriver().navigate().back();
        estoreUserAccountPage.getRhEstoreLogo().should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that search result {string} for search product via sku id is displayed")
    public void iVerifyThatSearchResultForSearchProductViaSkuIdIsDisplayed(String productName) {
        $(By.xpath("(//*[text()='" + productName + "'])[2]")).should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify the {string}")
    public void iVerifyThe(String gridNumber) {
        if (gridNumber.equals(3)) {
            estoreSearchScreen.getThreeColumnsInRowGridButton().should(visible, Duration.ofSeconds(20));
            estoreSearchScreen.getThreeColumnsInRowGridButton().click();
            estoreSearchScreen.getThreeColumnsInRowGridElement().should(visible, Duration.ofSeconds(20));
        }
        if (gridNumber.equals("2")) {
            estoreSearchScreen.getTwoColumnsInRowGridElement().should(visible, Duration.ofSeconds(20));
        }
        if (gridNumber.equals("1")) {
            estoreSearchScreen.getOneColumnInRowGridButton().should(visible, Duration.ofSeconds(20));
            estoreSearchScreen.getOneColumnInRowGridButton().click();
        }
    }

    @When("I click on hamburger menu for estore")
    public void iClickOnHamburgerMenuForEstore() {
        estoreSearchScreen.getHamburgerIcon().should(visible, Duration.ofSeconds(20));
        estoreSearchScreen.getHamburgerIcon().click();
    }

    @Then("I verify sale banner for estore")
    public void iVerifySaleBannerForEstore() {
        estoreSearchScreen.getSaveText().should(visible, Duration.ofSeconds(20));
    }

    @When("I click on view results")
    public void iClickOnViewResults() {
        estoreItemPage.getAddToCartButton().should(visible, Duration.ofSeconds(20));
        estoreItemPage.getAddToCartButton().click();
    }

    @Then("I verify cribs title for estore")
    public void iVerifyCribsTitleForEstore() {
        $(By.xpath("//*[text()='cribs']")).should(visible, Duration.ofSeconds(20));
    }

    @When("I apply new arrivals facet")
    public void iApplyNewArrivalsFacet() {
    }
}