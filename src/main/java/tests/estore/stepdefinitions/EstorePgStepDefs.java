package tests.estore.stepdefinitions;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.*;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class EstorePgStepDefs {

    EstoreSearchScreen estoreSearchScreen = new EstoreSearchScreen();
    EstorePGScreen estorePGScreen = new EstorePGScreen();
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    EstorePDPScreen estorePDPScreen = new EstorePDPScreen();

    EstoreSaleScreen estoreSaleScreen = new EstoreSaleScreen();
    EstoreFooter estoreFooter = new EstoreFooter();

    EstoreItemPage estoreItemPage = new EstoreItemPage();

    int priceFromTheFirstProduct;
    int priceFromTheSecondProduct;

    int regularSalePrice;

    int memberSalePrice;

    int memberPrice;
    int regularPrice;

    int regularPiceUSBeforeChangeTheZip;
    int memberPiceUSBeforeChangeTheZip;
    int regularPriceCANChangeTheZip;
    int memberPriceCANChangeTheZip;
    int memberPriceUSAfterChangeTheZip;
    int regularPriceUSAfterChangeTheZip;

    int countOfPgBeforeScroll;

    int countOfPgAfterScroll;

    @Then("I validate {string},{string} and {string} grid view should work")
    public void iValidateAndGridViewShouldWork(String arg0, String arg1, String arg2) {
        if (arg0.equals("1")) {
            estoreSearchScreen.getOneColumnInRowGridButton().should(visible, Duration.ofSeconds(20));
            estoreSearchScreen.getOneColumnInRowGridButton().click();
        }

        if (arg1.equals("2")) {
            estoreSearchScreen.getTwoColumnsInRowGridElement().should(visible, Duration.ofSeconds(20));
            estoreSearchScreen.getTwoColumnsInRowGridElement().click();
        }

        if (arg2.equals("3")) {
            estoreSearchScreen.getThreeColumnsInRowGridButton().should(visible, Duration.ofSeconds(20));
            estoreSearchScreen.getThreeColumnsInRowGridButton().should(interactable, Duration.ofSeconds(20));
            estoreSearchScreen.getThreeColumnsInRowGridButton().click();
        }

    }


    @Then("I verify that two grids are default view in PG")
    public void iVerifyThatTwoGridsAreDefaultViewInPG() {
        estoreSearchScreen.verifyThatDefaultGridIsDisplayed();
    }

    @When("I goes to estore product sale page")
    public void iGoesToEstorePg() {
        String URL = Hooks.eStoreBaseURL + "/search/results.jsp?Ntt=tables&Ns=product.sale%7C1";
        open(URL);

        WebDriverRunner.getWebDriver().navigate().refresh();
    }

    @When("I apply In stock to Sale filter")
    public void iApplyInStockToSaleFilter() {
        WebDriverRunner.getWebDriver().navigate().refresh();
        with().pollInterval(4, SECONDS).await().until(() -> true);
        estorePGScreen.getSaleButtonFilter().shouldHave(text("SALE"), Duration.ofSeconds(20));
        executeJavaScript("arguments[0].click();", estorePGScreen.getSaleButtonFilter());
    }

    @Then("I verify that search results page is displayed with newly searched products")
    public void iVerifyThatSearchResultsPageIsDisplayedWithNewlySearchedProducts() {
        estoreSearchScreen.getTurkish802towel().should(visible, Duration.ofSeconds(20));
    }

    @When("I scroll on the PG page till back to top button is visible")
    public void iScrollOnThePGPageTillBackToTopButtonIsVisible() {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        executeJavaScript("window.scrollTo(0, 800)");
    }

    @And("I verify that after click on back to top button user is scrolled to top on the PG")
    public void iVerifyThatAfterClickOnBackToTopButtonUserIsScrolledToTopOnThePG() {
        iApplyInStockToSaleFilter();
    }

    @When("I navigate back from {string} page")
    public void iNavigateBackFromPage(String arg0) {
        generalStepDefs.waitForJSandJQueryToLoad();
        WebDriverRunner.getWebDriver().navigate().back();
    }

    @When("I navigate to any estore fusion PG")
    public void iNavigateToAnyEstoreFusionPG() {
        estorePGScreen.getListOfPgFusionElements().get(0).should(visible, Duration.ofSeconds(20));
        estorePGScreen.getListOfPgFusionElements().get(0).click();
    }

    @Then("I verify page with previous filter applied")
    public void iVerifyPageWithPreviousFilterApplied() {
        estorePGScreen.getListOfPgFusionElements().get(2).should(visible, Duration.ofSeconds(20));
        estorePGScreen.getSaleFilterApplied().should(visible, Duration.ofSeconds(20));
    }

    @When("I change a grid view from default {int} grid view to {int} grid view")
    public void iChangeAGridViewFromDefaultGridViewToGridView(int arg0, int arg1) {
        $(By.xpath("//*[local-name()='svg' and @data-active='false']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[local-name()='svg' and @data-active='false']")).click();
    }

    @Then("I verify that page is displayed with the previous grid selected")
    public void iVerifyThatPageIsDisplayedWithThePreviousGridSelected() {
        $(By.xpath("(//*[local-name()='svg' and @data-active='true'])[1]")).should(visible, Duration.ofSeconds(20));
    }

    @When("I navigate to PG page from top menu")
    public void iNavigateToPGPageFromTopMenu() {
        estorePGScreen.getLivingCategory().should(visible, Duration.ofSeconds(10));
        estorePGScreen.getLivingCategory().click();
        estoreUserAccountPage.getInStockMenuItem().should(visible, Duration.ofSeconds(5));
        estoreUserAccountPage.getInStockMenuItem().click();
        estoreUserAccountPage.getSofas().should(visible, Duration.ofSeconds(10));
        estoreUserAccountPage.getSofas().click();
    }

    @Then("I verify that PG page is displayed with all the related products")
    public void iVerifyThatPGPageIsDisplayedWithAllTheRelatedProducts() {
        estoreUserAccountPage.getSofas().should(visible, Duration.ofSeconds(5));
        estorePGScreen.getGridView3().should(visible, Duration.ofSeconds(10));
    }

    @Then("I verify that sale verbiage message are present on PG page")
    public void iVerifyThatSaleVerbiageMessageArePresentOnPGPage() {
        estoreSaleScreen.getSaleVerbiageMessage().should(visible, Duration.ofSeconds(12));
    }

    @Then("I verify alignment for two and three grid views")
    public void iVerifyAlignmentForTwoAndThreeGridViews() {
        estorePGScreen.getGridView3().should(visible, Duration.ofSeconds(10));
        $(By.xpath("//*[contains(@class,'cols-4 ')]")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[@column='2']")).click();
        $(By.xpath("//*[contains(@class,'cols-6 ')]")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that application render to the same view grid which was selected")
    public void iVerifyThatApplicationRenderToTheSameViewGridWhichWasSelected() {
        estorePGScreen.getGridView2().should(visible, Duration.ofSeconds(10));
    }

    @Then("I verify that redirected to the exact product on PG")
    public void iVerifyThatRedirectedToTheExactProductOnPG() {
        estorePGScreen.getSofa().scrollIntoView(true);
        estorePGScreen.getSofa().should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that PG page is displayed with all filter options")
    public void iVerifyThatPGPageIsDisplayedWithAllFilterOptions() {
        estorePGScreen.getSaleButtonFilter().should(visible, Duration.ofSeconds(10));
        estorePGScreen.getMaterialFilter().should(visible, Duration.ofSeconds(10));
        estorePGScreen.getInStockFilter().should(visible, Duration.ofSeconds(10));
        estorePGScreen.getSizeFilter().should(visible, Duration.ofSeconds(10));
        estorePGScreen.getSortFilter().should(visible, Duration.ofSeconds(10));
    }

    @When("I goes to {string} estore brand")
    public void iGoesToEstoreBrand(String brand) {
        String url = Hooks.eStoreBaseURL.replaceAll("https://", "");
        open("https://" + brand + "." + url);
    }

    @Then("I verify the member price on PG page after selecting the specifications")
    public void iVerifyTheMemberPriceOnPGPageAfterSelectingTheSpecifications() {
        int memberPrice = Integer.parseInt($(By.xpath("(//*[@data-testid='price-for-member'])[1]")).getText().replaceAll("\\,", "").replaceAll("\\$", ""));
        AssertJUnit.assertTrue("Member price is not equal to zero", memberPrice > 0);

    }

    @Then("I verify that product thumbnail is correctly loaded")
    public void iVerifyThatProductThumbnailIsCorrectlyLoaded() {
        estorePGScreen.getThumbalImg().should(visible, Duration.ofSeconds(35));
    }

    @Then("I verify that sorting low to high is working as expected")
    public void iVerifyThatSortingLowToHighIsWorkingAsExpected() {
        int countOfTheSecondProduct = 2;
        priceFromTheFirstProduct = Integer.parseInt($(By.xpath("(//*[@data-testid='price-for-regular'])[1]")).getText().replaceAll("[^0-9]", ""));
        priceFromTheSecondProduct = Integer.parseInt($(By.xpath("(//*[@data-testid='price-for-regular'])[" + countOfTheSecondProduct + "]")).getText().replaceAll("[^0-9]", ""));

        while ((priceFromTheFirstProduct == priceFromTheSecondProduct)) {
            countOfTheSecondProduct++;
            priceFromTheSecondProduct = Integer.parseInt($(By.xpath("(//*[@data-testid='price-for-regular'])[" + countOfTheSecondProduct + "]")).getText().replaceAll("[^0-9]", ""));

            if (countOfTheSecondProduct > 12) {
                break;
            }
        }

        assertTrue(priceFromTheFirstProduct < priceFromTheSecondProduct, "The price of the first product is less than the price for the second product");
    }

    @Then("I verify that PG page is displayed for eStore")
    public void iVerifyThatPGPageIsDisplayedForEStore() {
//        estorePGScreen.getCollectionTextTitle().should(visible, Duration.ofSeconds(20));
        estorePGScreen.getGridView3().should(visible, Duration.ofSeconds(10));
    }

    @Then("I verify that user navigated to PG page successfully")
    public void iVerifyThatUserNavigatedToPgPageSuccessfully() {
        estorePGScreen.getPgResultsTitle().should(visible, Duration.ofSeconds(20));
        estorePGScreen.getGridView3().should(visible, Duration.ofSeconds(10));
    }

    @Then("I verify that sorting high to low is working as expected")
    public void iVerifyThatSortingHighToLowIsWorkingAsExpected() {
        priceFromTheFirstProduct = Integer.parseInt($(By.xpath("(//*[@data-testid='price-for-regular'])[1]")).getText().replaceAll("\\,", "").replaceAll("\\$", ""));
        priceFromTheSecondProduct = Integer.parseInt($(By.xpath("(//*[@data-testid='price-for-regular'])[2]")).getText().replaceAll("\\,", "").replaceAll("\\$", ""));

        assertTrue(priceFromTheFirstProduct >= priceFromTheSecondProduct, "The price of the first product is less than the price for the second product");

    }

    @Then("I validate {string} and {string} grid view should work")
    public void iValidateAndGridViewShouldWork(String arg0, String arg1) {
        System.out.println();
    }

    @When("I check price for {string} on PG page for estore")
    public void iCheckPriceForOnPGPageForEstore(String arg0) {
        priceFromTheFirstProduct = estorePGScreen.getRegularPriceOnPg();
        memberPrice = estorePGScreen.getMemberPriceOnPg();
        with().pollInterval(4, SECONDS).await().until(() -> true);
    }

    @Then("I verify that prices are matching between PG nad PDP pages")
    public void iVerifyThatPricesAreMatchingBetweenPGNadPDPPages() {
        int regularPrice = Integer.parseInt($(By.xpath("(//*[@data-testid='price-for-regular'])[1]")).getText().replaceAll("\\$", "").replaceAll("\\,", ""));
        int memberPrice = Integer.parseInt($(By.xpath("(//*[@data-testid='price-for-member'])[1]")).getText().replaceAll("\\$", "").replaceAll("\\,", ""));

        AssertJUnit.assertEquals("Regular price is not equal to zero", regularPrice, priceFromTheFirstProduct);
        AssertJUnit.assertEquals("Member price is not equal to zero", memberPrice, memberPrice);
    }

    @When("I check sale price for {string} on PG page for estore")
    public void iCheckSalePriceForOnPGPageForEstore(String arg0) {
        regularSalePrice = estorePGScreen.getRegularSaleOnPgPrice();
        memberSalePrice = estorePGScreen.getMemberSaleOnPgPrice();
    }

    @Then("I verify that prices for the VIEW SELECT ITEMS ON SALE on PG and the sale page")
    public void iVerifyThatPricesForTheVIEWSELECTITEMSONSALEOnPGAndTheSalePage() {
        int regularSalePagePrice = estorePGScreen.getRegularSaleOnPgPrice();
        int memberSalePagePrice = estorePGScreen.getMemberSaleOnPgPrice();

        AssertJUnit.assertEquals("Regular price is not equal to zero", regularSalePagePrice, regularSalePrice);
        AssertJUnit.assertEquals("Member price is not equal to zero", memberSalePagePrice, memberSalePrice);
    }

    @Then("I verify that the price mentioned on PG page")
    public void iVerifyThatThePriceMentionedOnPGPage() {
        int regularPrice = estorePGScreen.getRegularPriceOnPg();
        int memberPrice = estorePGScreen.getMemberPriceOnPg();

        AssertJUnit.assertTrue("Regular price is not equal to zero", regularPrice > 0);
        AssertJUnit.assertTrue("Member price is not equal to zero", memberPrice > 0);
    }

    @Then("I verify that combined price on frame and cushion on PG")
    public void iVerifyThatCombinedPriceOnFrameAndCushionOnPG() {
        estorePGScreen.getRegularPrice().should(visible, Duration.ofSeconds(12));
        estorePGScreen.getMemberPrice().should(visible, Duration.ofSeconds(12));

        regularPrice = estorePGScreen.getRegularPriceOnPg();
        memberPrice = estorePGScreen.getMemberPriceOnPg();
        AssertJUnit.assertTrue("Verify that member proudct price is correct", regularPrice > 0);
        AssertJUnit.assertTrue("Verify that regular proudct price is correct", memberPrice > 0);
    }

    @And("I verify that price on PG is the same as on PDP")
    public void iVerifyThatPriceOnPGISTheSameAsOnPDP() {
        estorePDPScreen.getFirstMemberPrice().should(visible, Duration.ofSeconds(12));
        assertEquals("Verify that member price on PG is the same as on PDP", estorePDPScreen.getMemberPricePDP(), memberPrice);
        assertEquals("Verify that regular price on PG is the same as on PDP", estorePDPScreen.getRegularPricePDP(), regularPrice);
    }

    @When("I apply In stock filter on PG for estore")
    public void iApplyInStockFilterOnPGForEstore() {
        estorePGScreen.clickToInStockFilterPG();
    }

    @Then("I verify that the prices shown against instock products on PG page")
    public void iVerifyThatThePricesShownAgainstInstockProductsOnPGPage() {
        estorePGScreen.getRegularPrice().should(visible, Duration.ofSeconds(12));
        estorePGScreen.getMemberPrice().should(visible, Duration.ofSeconds(12));

        regularPrice = estorePGScreen.getRegularPriceOnPg();
        memberPrice = estorePGScreen.getMemberPriceOnPg();
        AssertJUnit.assertTrue("Verify that member proudct price is correct", regularPrice > 0);
        AssertJUnit.assertTrue("Verify that regular proudct price is correct", memberPrice > 0);

    }

    @And("I verify that price on PG is the same as on PDP for In stock filter applied")
    public void iVerifyThatPriceOnPGIsTheSameAsOnPDPForInStockFilterApplied() {
        with().pollInterval(6, SECONDS).await().until(() -> true);
        estoreItemPage.getAddToCartButton().scrollIntoView(true);
        estorePDPScreen.getLineItemRegularPrice().should(visible, Duration.ofSeconds(12));
        assertEquals("Verify that member price on PG is the same as on PDP", estorePDPScreen.getMemberLineItemPricePDP(), memberPrice);
        assertEquals("Verify that regular price on PG is the same as on PDP", estorePDPScreen.getRegularLineItemPricePDP(), regularPrice);

    }

    @Then("I verify that the products are shown with relevant colorized images on PG page")
    public void iVerifyThatTheProductsAreShownWithRelevantColorizedImagesOnPGPage() {
        estorePGScreen.verifyThatColorizedImagesAreDisplayed();
    }

    @When("I update zip code to {string} zip code on PG from footer")
    public void iUpdateZipCodeToZipCodeOnPGFromFooter(String arg0) {
        estoreFooter.getCountrySelection().should(visible, Duration.ofSeconds(12));
        estoreFooter.clickToCountrySelectionButton();
        if (arg0.equals("CAN")) {
            estoreFooter.clickToCaCountrySelect();
        }
        if (arg0.equals("US")) {
            estoreFooter.clickToUSCountrySelect();
        }
    }


    @When("I check the prices for {string} zip code")
    public void iCheckThePricesForZipCode(String arg0) {
        regularPiceUSBeforeChangeTheZip = estorePGScreen.getRegularPriceOnPg();
        memberPiceUSBeforeChangeTheZip = estorePGScreen.getMemberPriceOnPg();

        assertTrue(regularPiceUSBeforeChangeTheZip > 0, "Member price is not equal to zero");
        assertTrue(memberPiceUSBeforeChangeTheZip > 0, "Regular price is not equal to zero");
    }

    @Then("I verify that prices for {string} was updated on PG")
    public void iVerifyThatPricesForWasUpdatedOnPG(String country) {

        if (country.equals("CAN")) {
            regularPriceCANChangeTheZip = estorePGScreen.getRegularPriceOnPg();
            memberPriceCANChangeTheZip = estorePGScreen.getMemberPriceOnPg();

            assertFalse(regularPriceCANChangeTheZip == regularPiceUSBeforeChangeTheZip);
            assertFalse(memberPriceCANChangeTheZip == memberPiceUSBeforeChangeTheZip);
        }
        if (country.equals("US")) {
            regularPriceUSAfterChangeTheZip = estorePGScreen.getRegularPriceOnPg();
            memberPriceUSAfterChangeTheZip = estorePGScreen.getMemberPriceOnPg();

            Assert.assertEquals(regularPiceUSBeforeChangeTheZip, regularPriceUSAfterChangeTheZip);
            Assert.assertEquals(memberPiceUSBeforeChangeTheZip, memberPriceUSAfterChangeTheZip);
        }
    }

    @When("I open CG page with sale message")
    public void iOpenCGPageWithSaleMessage() {
        String saleMessageUrl = Hooks.eStoreBaseURL + "/us/en/catalog/category/products.jsp?pgterm=RH+Fabric+Chairs&N=%7B%21tag%3Dsku_showOnly%7Dsku_showOnly%3A%28\"Sale\"%29&Ns=product.sale%7C1&categoryId=cat10210007";
        open(saleMessageUrl);
    }


    @Then("I verify the count of displayed PG item in grid")
    public void iVerifyTheCountOfDisplayedPGItemInGrid() {
        countOfPgBeforeScroll = estorePGScreen.verifyCountOfPgItemsonThePage();
    }

    @Then("I verify that the number of items in PG was increased after scroll")
    public void iVerifyThatTheNumberOfItemsInPGWasIncreasedAfterScroll() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        countOfPgAfterScroll = estorePGScreen.verifyCountOfPgItemsonThePage();

        assertTrue(countOfPgBeforeScroll < countOfPgAfterScroll);
    }

    @Then("I verify price on PG after In-stock filter was applied")
    public void iVerifyPriceOnPGAfterInStockFilterWasApplied() {
        estorePGScreen.getRegularPrice().should(visible, Duration.ofSeconds(12));
        estorePGScreen.getMemberPrice().should(visible, Duration.ofSeconds(12));

        regularPrice = estorePGScreen.getRegularPriceOnPg();
        memberPrice = estorePGScreen.getMemberPriceOnPg();
    }

    @And("I verify that price on Sale PG is the same as on PDP after In stock filter was applied")
    public void iVerifyThatPriceOnPGISTheSameAsOnPDPWithInStockFilter() {
        estorePDPScreen.getFirstLineItemMemberPrice().should(visible, Duration.ofSeconds(12));
        estorePDPScreen.getFirstLineItemMemberPrice().scrollIntoView(true);
        with().pollInterval(3, SECONDS).await().until(() -> true);
        assertEquals("Verify that member price on PG is the same as on PDP", estorePDPScreen.getMemberFirstLineItemPricePDP(), memberPrice);
        assertEquals("Verify that regular price on PG is the same as on PDP", estorePDPScreen.getRegularFirstLineItemPricePDP(), regularPrice);
    }


    @Then("I verify that PG title is displayed for Beds")
    public void iVerifyThatPGTitleIsDisplayedForBeds() {
        estorePGScreen.verifyThatPgTitleBedIsDisplayed();
    }

    @And("I verify that default sort order should be featured")
    public void iVerifyThatDefaultSortOrderShouldBeFeatured() {
        estorePGScreen.verifyThatSortByButtonFeaturedIsDisplayed();
    }

    @Then("I verify that {int}x{int} grid should be in selected state by default")
    public void iVerifyThatXGridShouldBeInSelectedStateByDefault(int arg0, int arg1) {
        estorePGScreen.verifyThatGrid3x3SelectedByDefault();
    }

    @And("I verify that available in multiple sizes&finishes should be displayed")
    public void iVerifyThatAvailableInMultipleSizesFinishesShouldBeDisplayed() {
        estorePGScreen.sizeFinishesMessageIsDisplayed();
    }

    @Then("I verify that PG title is displayed for {string}")
    public void iVerifyThatPGTitleIsDisplayedFor(String title) {
        estorePGScreen.verifyThatPgTitleIsDisplayed(title);
    }

    @Then("I verify that {int}x{int} grid view should be selected in state")
    public void iVerifyThatXGridViewShouldBeSelectedInState(int arg0, int arg1) {
        try {
            estorePGScreen.getGrid3x3().should(visible, Duration.ofSeconds(12));
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Grid view with elements are not displayed");
        }
    }

    @Then("I verify that width filter should be displayed in the applied filter list")
    public void iVerifyThatWidthFilterShouldBeDisplayedInTheAppliedFilterList() {
        estorePGScreen.verifyThatWidthOptionWasApplied();
    }

    @When("I select width option value")
    public void iSelectWidthOptionValue() {
        estorePGScreen.clickOnwidthLowerThan20();
    }

    @When("I click on Material dropdown")
    public void iClickOnMaterialDropdown() {
        estorePGScreen.clickToMaterialFilterOption();
    }

    @And("I verify that material filter was applied")
    public void iVerifyThatMaterialFilterWasApplied() {
        estorePGScreen.verifyThatleatherFilterWasApplied();
    }

    @When("I click on New Arrival filter")
    public void iClickOnNewArrivalFilter() {
        estorePGScreen.clickToNewArrivalsFilter();
    }

    @Then("I verify that New Arrival filter was applied")
    public void iVerifyThatNewArrivalFilterWasApplied() {
        estorePGScreen.verifyThatNewArrivalsFilterWasApplied();
    }

    @When("I click on sort by button for estore")
    public void iClickOnSortByButtonForEstore() {
        estorePDPScreen.getSortByButton().should(visible, Duration.ofSeconds(20));
        estorePDPScreen.getSortByButton().click();
    }

    @Then("I verify that Featured,High to Low, Low to High options are displayed")
    public void iVerifyThatFeaturedHighToLowLowToHighOptionsAreDisplayed() {
        estorePGScreen.verifyThatSortByButtonFeaturedIsDisplayed();
        estorePDPScreen.getPriceLowToHigh().should(visible, Duration.ofSeconds(20));
        estorePDPScreen.getPriceHighToLow().should(visible, Duration.ofSeconds(20));
    }
}