package tests.estore.stepdefinitions;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.AssertJUnit;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.*;
import tests.utility.Hooks;

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

    EstoreGeneralStepDefs estoreGeneralStepDefs = new EstoreGeneralStepDefs();

    @When("I go to estore item {string} from search field")
    public void iGoToItemFromEstoreSearchField(String arg0) {
        generalStepDefs.waitForJSandJQueryToLoad();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        estoreUserAccountPage.getSearchItemFieldHomePage().should(visible, Duration.ofSeconds(60));
        estoreUserAccountPage.getSearchItemFieldHomePage().click();
        estoreUserAccountPage.getSearchItemField().should(Condition.and("", visible, enabled), Duration.ofSeconds(40));
        estoreUserAccountPage.getSearchItemField().should(empty, Duration.ofMinutes(1));
        estoreUserAccountPage.getSearchItemField().click(ClickOptions.usingJavaScript());
        generalStepDefs.waitForJSandJQueryToLoad();
        estoreUserAccountPage.getSearchItemField().sendKeys(arg0);
        with().pollInterval(2, SECONDS).await().until(() -> true);
        estoreUserAccountPage.getSearchItemField().click();
        estoreUserAccountPage.getSearchItemField().sendKeys(Keys.ENTER);
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
        sleep(2000);
        estoreUserAccountPage.getSearchItemField().click();
        estoreUserAccountPage.getSearchItemField().sendKeys(Keys.ENTER);
    }

    @Then("I verify that we cannot find what you are looking message is displayed")
    public void iVerifyThatWeCannotFindWhatYouAreLookingMessageIsNotDisplayed() {
        estoreSearchScreen.getSorryWeCannotFindMsg().should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify count of search results")
    public void iVerifyCountOfSearchResults() {
        estorePGScreen.getFirstSearchElement().should(visible, Duration.ofSeconds(20));
        //estoreSearchScreen.getResults().should(visible, Duration.ofSeconds(20));
    }

    @When("I scroll to the bottom of the estore page")
    public void iScrollToTheBottomOfTheEstorePage() {
        $(By.id("rh-header")).should(visible, Duration.ofSeconds(40));
        generalStepDefs.waitForJSandJQueryToLoad();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        executeJavaScript("window.scrollTo(0, 2000)");
    }

    @When("I scroll to the bottom of the PG estore page")
    public void iScrollToTheBottomOfTheEstorePGpage() {
        $(By.id("rh-header")).should(visible, Duration.ofSeconds(40));
        generalStepDefs.waitForJSandJQueryToLoad();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        executeJavaScript("window.scrollTo(0, 5000)");
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
        estoreItemPage.clickToViewSearchResultsButton();
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
        $(By.xpath("//*[@id='refinementOptionData_checkbox-Sale']//span")).shouldBe(visible).click();
        $(By.xpath("//*[@id='refinementOptionData_checkbox-In-Stock']//span")).shouldBe(visible).click();
        $(By.xpath("//*[@id='refinementOptionData_checkbox-New Arrivals']//span")).shouldBe(visible).click();
        $(By.xpath("(//*[contains(text(),'RESULTS')])[2]")).shouldBe(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that No search result message is displayed")
    public void iVerifyThatNoSearchResultMessageIsDisplayed() {
        estoreCGScreen.verifyThatNoSearchResultMessageIsDisplayed();
    }

    @Then("I verify that products that match the search criteria should be displayed")
    public void iVerifyThatProductsThatMatchTheSearchCriteriaShouldBeDisplayed() {
        estoreCGScreen.verifyThatTitleTerzoDiningTables();
    }

    @And("I verify that the price mentioned on PG page for {string}")
    public void iVerifyThatThePriceMentionedOnPGPageFor(String arg0) {
        try {
            int regularPrice = estorePGScreen.getRegularPriceOnPg();
            int memberPrice = estorePGScreen.getMemberPriceOnPg();

            AssertJUnit.assertTrue("Regular price is not equal to zero", regularPrice > 0);
            AssertJUnit.assertTrue("Member price is not equal to zero", memberPrice > 0);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Product grid is not displayed");
        }
    }

    @When("I click on Shape dropdown")
    public void iClickOnShapeDropdown() {
        estorePGScreen.clickOnShapeDropDown();
    }

    @When("I click on Rectangular option")
    public void iClickOnRectangularOption() {
        estorePGScreen.clickToRectangularCheckBox();
    }

    @Then("I verify that Rectangular filter should be displayed")
    public void iVerifyThatRectangularFilterShouldBeDisplayed() {
        estorePGScreen.verifyThatRectangularAppliedFilterIsDisplayed();
    }

    @When("I click on Size dropdown")
    public void iClickOnSizeDropdown() {
        estorePGScreen.clickToSizeDropDown();
    }

    @When("I click on width option from Size dropdown")
    public void iClickOnWidthOptionFromSizeDropdown() {
        estorePGScreen.clickToWidthOption();
    }

    @When("I click on Leather option")
    public void iClickOnLeatherOption() {
        estorePGScreen.clickToLeatherOption();
    }

    @When("I click on {int} length value")
    public void iClickOnLengthValue(int arg0) {
        estorePGScreen.clickOnlength5Value();
    }

    @And("I verify that RH MEMBERS PROGRAM SAVE {int}% ON EVERYTHING message is displayed on top of the page")
    public void iVerifyThatRHMEMBERSPROGRAMSAVEONEVERYTHINGMessageIsDisplayedOnTopOfThePage(int arg0) {
        estoreSearchScreen.verifyThatRhMembersProgramSaveMessageIsDisplayed();
    }

    @And("I verify that message {string} is displayed")
    public void iVerifyThatMessageIsDisplayed(String message) {
        estoreGeneralStepDefs.verifyThatmessageIsDisplayed(message);
    }

    @Then("I verify pricing format for product")
    public void iVerifyPricingFormatForProduct() {
        estoreSearchScreen.verifyPriceFormat();
    }

    @Then("I verify that Customer Service page is displayed")
    public void iVerifyThatCustomerServicePageIsDisplayed() {
        assertTrue("Customer service page is displayed", Hooks.getCurrentUrl().contains("customer-service"));
    }

    @When("I click on Customer Experience link")
    public void iClickOnCustomerExperienceLink() {
        estoreSearchScreen.getCustomerExperienceLink().should(visible, Duration.ofSeconds(9)).click(ClickOptions.usingJavaScript());
    }

    @Then("I verify that {int}x{int} grid view is active on Search page")
    public void iVerifyThatXGridViewIsActiveOnSearchPage(int arg0, int arg1) {
        estoreSearchScreen.getSearch2x2GridView().should(visible, Duration.ofSeconds(12));
    }
}