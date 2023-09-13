package tests.estore.stepdefinitions;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.AssertJUnit.assertTrue;

public class EstoreSearchStepDefs {
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstoreCGScreen estoreCGScreen = new EstoreCGScreen();
    EstorePDPScreen estorePDPScreen = new EstorePDPScreen();
    EstoreSearchScreen estoreSearchScreen = new EstoreSearchScreen();
    EstoreItemPage estoreItemPage = new EstoreItemPage();
    EstorePGScreen estorePGScreen = new EstorePGScreen();

    @When("I go to estore item {string} from search field")
    public void iGoToItemFromEstoreSearchField(String arg0) {
        generalStepDefs.waitForJSandJQueryToLoad();
        $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item'])[2]//input")).should(visible, Duration.ofSeconds(60));
        $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item'])[2]//input")).click();
        estoreUserAccountPage.getSearchItemField().should(Condition.and("", visible, enabled), Duration.ofSeconds(40));
        estoreUserAccountPage.getSearchItemField().should(empty, Duration.ofMinutes(1));
        estoreUserAccountPage.getSearchItemField().click();
        generalStepDefs.waitForJSandJQueryToLoad();


        estoreUserAccountPage.getSearchItemField().setValue(arg0);

        estoreUserAccountPage.getSearchItemField().sendKeys(Keys.ENTER);

//        $(By.xpath("//*[text() = 'SEE ALL RESULTS']")).should(visible, Duration.ofSeconds(40));
//        $(By.xpath("//*[text() = 'SEE ALL RESULTS']")).click(ClickOptions.usingJavaScript());
    }

    @Then("I verify that search result {string} for search product via product name is displayed")
    public void iVerifyThatSearchResultForSearchProductViaProductNameIsDisplayed(String searchItem) {
        $(By.xpath("//*[text()='" + searchItem + "']")).should(Condition.visible, Duration.ofSeconds(20));
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
        estorePGScreen.getFirstSearchElement().should(visible, Duration.ofSeconds(20));
        estoreSearchScreen.getResults().should(visible, Duration.ofSeconds(20));
    }

    @When("I scroll to the bottom of the estore page")
    public void iScrollToTheBottomOfTheEstorePage() {
        $(By.id("rh-header")).should(visible, Duration.ofSeconds(40));
        generalStepDefs.waitForJSandJQueryToLoad();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        executeJavaScript("window.scrollTo(0, 2000)");
    }

    @When("I click on estore back to top button")
    public void iClickOnEstoreBackToTopButton() {
        with().pollInterval(4, SECONDS).await().until(() -> true);
        estoreCGScreen.getBackToTopButton().should(visible, Duration.ofSeconds(20));
        estoreCGScreen.getBackToTopButton().click();
        with().pollInterval(4, SECONDS).await().until(() -> true);
    }

    @Then("I verify that search results for {string} is displayed")
    public void iVerifyThatSearchResultsForIsDisplayed(String arg0) {
        $(By.xpath("//*[text()='" + arg0 + "']")).should(visible, Duration.ofSeconds(20));
    }

    @When("I select low to high for estore")
    public void iSelectLowToHighForEstore() {
        estorePDPScreen.getSortByButton().should(visible, Duration.ofSeconds(20));
        estorePDPScreen.getSortByButton().click();
        estorePDPScreen.getPriceLowToHigh().should(visible, Duration.ofSeconds(20));
        estorePDPScreen.getPriceLowToHigh().click(ClickOptions.usingJavaScript());
    }

    @When("I select high to low for estore")
    public void iSelectHighToLowForEstore() {

        estorePDPScreen.getSortByButton().should(visible, Duration.ofSeconds(20));
        estorePDPScreen.getSortByButton().click();

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
        int memberPrice = Integer.parseInt(estoreSearchScreen.getMemberPriceCollectionPage().getText().replaceAll("\\$", ""));
        int regularPrice = Integer.parseInt(estoreSearchScreen.getRegularPriceCollectionPage().getText().replaceAll("\\$", ""));

        estoreSearchScreen.getMemberLabelPriceCollectionPage().should(visible, Duration.ofSeconds(20));
        estoreSearchScreen.getRegularLabelPriceCollectionPage().should(visible, Duration.ofSeconds(20));

        assertTrue("", memberPrice > 0);
        assertTrue("", regularPrice > 0);

    }

    @Then("I verify that I'm able to use back button")
    public void iVerifyThatIMAbleToUseBackButton() {

        WebDriverRunner.getWebDriver().navigate().back();
        estorePDPScreen.getFirstProduct().should(visible, Duration.ofSeconds(20));

    }

    @Then("I verify that I'm able to use back button from CG")
    public void iVerifyThatIMAbleToUseBackButtonFromCG() {

        WebDriverRunner.getWebDriver().navigate().back();
        estoreUserAccountPage.getRhEstoreLogo().should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that search result {string} for search product via sku id is displayed")
    public void iVerifyThatSearchResultForSearchProductViaSkuIdIsDisplayed(String productName) {
        $(By.xpath("(//*[text()='" + productName + "'])[2]")).should(Condition.visible, Duration.ofSeconds(30));
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
        estoreSearchScreen.getSalePageBanner().should(visible, Duration.ofSeconds(20));
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

    @Then("I apply new arrivals facet")
    public void iApplyNewArrivalsFacet() {
        $(By.xpath("//*[text()='new arrivals']")).should(visible, Duration.ofSeconds(20)).click();
        $(By.xpath("//*[text()='RESULTS']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("(//*[text()='new arrivals'])[2]")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify in stock facet selection")
    public void iVerifyInStock() {
        $(By.xpath("//*[text()='in-stock']")).should(visible, Duration.ofSeconds(20)).click();
        $(By.xpath("//*[text()='sale']")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that I'm able to apply any facet")
    public void iVerifyThatIMAbleToApplyAnyFacet() {
    }

    @Then("I verify the results with multiple term search")
    public void iVerifyTheResultsWithMultipleTermSearch() {
        $(By.xpath("//*[text()='leather Sofa']")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that brands refinement does not appear in estore search page")
    public void iVerifyThatBrandsRefinementDoesNotAppearInEstoreSearchPage() {
        $(By.xpath("//*[text()='CONCEPTS']")).shouldNotBe(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that swathces are not displayed")
    public void iVerifyThatSwathcesAreNotDisplayed() {
    }

    @When("I apply multiple facet on estore search page")
    public void iApplyMultipleFacetOnEstoreSearchPage() {
        $(By.xpath("//*[text()='sale']")).click();
        $(By.xpath("//*[text()='in-stock']")).click();
        $(By.xpath("//*[contains(text(),'RESULTS')]")).shouldBe(visible, Duration.ofSeconds(20));
    }
}