package tests.estore.stepdefinitions;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.*;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.Assert.assertTrue;

public class EstoreSaleStepDefs {

    EstoreCGScreen estoreCGScreen = new EstoreCGScreen();
    EstoreSaleScreen estoreSaleScreen = new EstoreSaleScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    EstorePGScreen estorePGScreen = new EstorePGScreen();
    EstorePgStepDefs estorePgStepDefs = new EstorePgStepDefs();

    EstorePdpPageScreen estorePdpPageScreen = new EstorePdpPageScreen();

    EstorePDPScreen estorePDPScreen = new EstorePDPScreen();

    EstoreHomePage estoreHomePage = new EstoreHomePage();
    String URL;
    int memberSalePrice;
    int regularSalePrice;

    @When("I click on estore sale button")
    public void iClickOnEstoreSaleButton() {
        estoreSaleScreen.getSaleButtonMenu().should(visible, Duration.ofSeconds(20));
        estoreSaleScreen.getSaleButtonMenu().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
    }

    @Then("I verify that I'm able to navigate different category")
    public void iVerifyThatIMAbleToNavigateDifferentCategory() {
        estoreSaleScreen.getMainSaleList().should(Condition.and("Visible, interactable", Condition.interactable, visible), Duration.ofSeconds(20));
        estoreSaleScreen.getMainSaleList().click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
    }

    @Then("I verify sale category for estore")
    public void iVerifySaleCategoryForEstore() {
        estoreSaleScreen.getSaleLivingCategory().should(visible, Duration.ofSeconds(20));
        estoreSaleScreen.getSaleDiningCategory().should(visible, Duration.ofSeconds(20));
        estoreSaleScreen.getBedLivingCategory().should(visible, Duration.ofSeconds(20));
        estoreSaleScreen.getTextilesSaleCategory().should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify the back button from sale PDP page")
    public void iVerifyTheBackButtonFromSalePDPPage() {
        WebDriverRunner.getWebDriver().navigate().back();
    }

    @When("I go to sale estore category")
    public void iGoToSaleEstoreCategory() {
        URL = "https://stg2.rhnonprod.com/catalog/category/products.jsp?categoryId=cat10240094&pgterm=RH+Dressers&sale=true&topCatId=cat3890154&parentCatId=cat780002";
        open(URL);
    }

    @Then("I verify sale prices on PG pages for sale items")
    public void iVerifySalePricesOnPGPagesForSaleItems() {
        regularSalePrice = Integer.parseInt(estoreSaleScreen.getRegularSalePrice().getText().replaceAll("\\$", "").replaceAll(",", ""));
        memberSalePrice = Integer.parseInt(estoreSaleScreen.getMemberSalePrice().getText().replaceAll("\\$", "").replaceAll(",", ""));
        assertTrue(memberSalePrice > 0, "Member sale price is displayed");
        assertTrue(regularSalePrice > 0, "Regular sale price is displayed");
    }

    @When("I go to Sale product page")
    public void iGoToSaleProductPage() {
        String saleUrl = "https://stg2.rhnonprod.com/us/en/catalog/category/products.jsp?categoryId=cat25450027&pgterm=" +
                "RH+Fabric+Sofas&sale=true&topCatId=cat3890154&parentCatId=cat160024?endpoint=" + Hooks.cookie;
        open(saleUrl);
    }

    @When("I go to the sale page with {string} on estore")
    public void iGoToTheSalePageWithOnEstore(String arg0) {
        String saleUrl = "";

        if (arg0.equals("sofas")) {
            saleUrl = Hooks.eStoreBaseURL + "/us/en/catalog/category/products.jsp?pgterm=RH+Fabric+Sofas&N=%7B%21tag%3Dsku_showOnly%7Dsku_showOnly%3A%28\"Sale\"%29&Ns=product.sale%7C1&categoryId=cat25450027" + Hooks.cookie;
        }
        open(saleUrl);
    }

    @When("I click to secondary NAV of Sale")
    public void iClickToSecondaryNAVOfSale() {
        estoreSaleScreen.clickToSaleLivingNav();
    }

    @Then("I verify that SALE Nav should be expanded with secondary NAV")
    public void iVerifyThatSALENavShouldBeExpandedWithSecondaryNAV() {
        estoreSaleScreen.verifyThatfabricChairsSaleNavIsDisplayed();
        estoreSaleScreen.verifyThatleatherCharisSaleNavSaleNavIsDisplayed();
    }

    @When("I click on Living from sale nav menu")
    public void iClickOnFromSaleNavMenu() {
        estoreSaleScreen.clickToSaleLivingNav();
    }

    @Then("I verify that Living in Secondary NAV should expand tertiary NAV")
    public void iVerifyThatLivingInSecondaryNAVShouldExpandTertiaryNAV() {
        estoreSaleScreen.verifyThatfabricChairsSaleNavIsDisplayed();
        estoreSaleScreen.verifyThatleatherCharisSaleNavSaleNavIsDisplayed();
        estoreSaleScreen.verifyThatsideTablesSaleNavIsDisplayed();
        estoreSaleScreen.verifyThatconsoleTablesSaleNavIsDisplayed();
        estoreSaleScreen.verifyThatcoffeTablesSaleNavIsDisplayed();
    }

    @When("I click on Dining from sale nav menu")
    public void iClickOnDiningFromSaleNavMenu() {
        estoreSaleScreen.clickToSaleDiningNav();

    }

    @Then("I verify that Dining in Secondary NAV should expand tertiary NAV")
    public void iVerifyThatDiningInSecondaryNAVShouldExpandTertiaryNAV() {
        estoreSaleScreen.getAllDiningTables().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getBarCounterStools().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getCabinetsDining().should(visible, Duration.ofSeconds(12));
    }

    @When("I click on Bed from sale nav menu")
    public void iClickOnBedFromSaleNavMenu() {
        estoreSaleScreen.clickToSaleBedNav();
    }

    @Then("I verify that Bed in Secondary NAV should expand tertiary NAV")
    public void iVerifyThatBedInSecondaryNAVShouldExpandTertiaryNAV() {
        estoreSaleScreen.getBedBedsSale().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getBedNightstandssSale().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getBedDresserssSale().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getBedBenchesSale().should(visible, Duration.ofSeconds(12));
    }

    @When("I click on Bath from sale nav menu")
    public void iClickOnBathFromSaleNavMenu() {
        estoreSaleScreen.clickToSaleBathNav();
    }

    @Then("I verify that Bath in Secondary NAV should expand tertiary NAV")
    public void iVerifyThatBathInSecondaryNAVShouldExpandTertiaryNAV() {
        estoreSaleScreen.getBathTowelsSale().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getBathLightingSale().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getMirrorMedicineSale().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getWashstandsSale().should(visible, Duration.ofSeconds(12));
    }

    @When("I click on Outdoor from sale nav menu")
    public void iClickOnOutdoorFromSaleNavMenu() {
        estoreSaleScreen.clickToSaleOutdoorNavNav();
    }


    @Then("I verify that Outdoor in Secondary NAV should expand tertiary NAV")
    public void iVerifyThatOutdoorInSecondaryNAVShouldExpandTertiaryNAV() {
        estoreSaleScreen.getOutdoorChairsSale().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getOutdoorSideTableSale().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getOutdoorChaisesSale().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getOutdoorOttomansSale().should(visible, Duration.ofSeconds(12));
    }

    @When("I click on Lighting from sale nav menu")
    public void iClickOnLightingFromSaleNavMenu() {
        estoreSaleScreen.clickToSaleLightingNavNav();
    }

    @Then("I verify that Lighting in Secondary NAV should expand tertiary NAV")
    public void iVerifyThatLightingInSecondaryNAVShouldExpandTertiaryNAV() {
        estoreSaleScreen.getCeilingLightingSale().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getWallLightingSale().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getTableLightigSale().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getFloorLightingSale().should(visible, Duration.ofSeconds(12));
    }

    @When("I click on Textiles from sale nav menu")
    public void iClickOnTextilesFromSaleNavMenu() {
        estoreSaleScreen.clickToSaleTextsilesNav();
    }

    @Then("I verify that Textiles in Secondary NAV should expand tertiary NAV")
    public void iVerifyThatTextilesInSecondaryNAVShouldExpandTertiaryNAV() {
        estoreSaleScreen.getTextilesBathTowels().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getTextilesSheetsPilloecases().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getTextilesBeddingCollections().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getTextilesTHrowsBlankets().should(visible, Duration.ofSeconds(12));
    }

    @When("I click on Rugs from sale nav menu")
    public void iClickOnRugsFromSaleNavMenu() {
        estoreSaleScreen.clickToSaleRugsNav();
    }

    @Then("I verify that Rugs in Secondary NAV should expand tertiary NAV")
    public void iVerifyThatRugsInSecondaryNAVShouldExpandTertiaryNAV() {
        estoreSaleScreen.getRugsAllRugs().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getRugsIvoryRugs().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getRugsNeutralRugs().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getRugsBlueRugs().should(visible, Duration.ofSeconds(12));
    }

    @When("I click on Decor from sale nav menu")
    public void iClickOnDecorFromSaleNavMenu() {
        estoreSaleScreen.clickToSaleDecorNav();
    }

    @Then("I verify that Decor in Secondary NAV should expand tertiary NAV")
    public void iVerifyThatDecorInSecondaryNAVShouldExpandTertiaryNAV() {
        estoreSaleScreen.getDecorMirrors().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getDecorBarCabinets().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getDecorCabinetHardware().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getDecorThrowsBlankets().should(visible, Duration.ofSeconds(12));
    }

    @Then("I verify that user is able to navigate to Sale PG")
    public void iVerifyThatUserIsAbleToNavigateToSalePG() {
        estoreSaleScreen.verifyThatDecorAllMirrorsTextSalePgIsDisplayed();
        estorePGScreen.getSaleButtonFilter().should(visible, Duration.ofSeconds(12));
        estorePGScreen.getInStockTextFilterPG().should(visible, Duration.ofSeconds(12));
    }

    @When("I click on Decor Mirrors from nav of Sale")
    public void iClickOnDecorMirrorsFromNavOfSale() {
        estoreSaleScreen.getDecorMirrors().click();
    }

    @Then("I verify that In stock filter was applied")
    public void iVerifyThatInStockFilterWasApplied() {
        estorePGScreen.getInStockFilter().should(visible, Duration.ofSeconds(20));
        estorePGScreen.getClearAll().should(visible, Duration.ofSeconds(20));
        estorePGScreen.getResultsText().should(visible, Duration.ofSeconds(20));
    }

    @When("I click on All Dining Tables in tertiary nav")
    public void iClickOnAllDiningTablesInTertiaryNav() {
        estoreSaleScreen.clickToAllDiningTablesNav();
    }

    @When("I click on clear all link in applied section filter")
    public void iClickOnClearAllLinkInAppliedSectionFilter() {
        estoreSaleScreen.clickToClearAllLink();
    }

    @Then("I verify that the applied filters have been removed")
    public void iVerifyThatTheAppliedFiltersHaveBeenRemoved() {
        estoreSaleScreen.verifyThatSaleAppliedFilterWasRemoved();
    }

    @Then("I verify that the applied In stock filters have been removed")
    public void iVerifyThatTheAppliedInStockFiltersHaveBeenRemoved() {
        estoreSaleScreen.verifyThatStockAppliedFilterWasRemoved();
    }

    @Then("I verify that CG title is displayed on eStore")
    public void iVerifyThatCGTitleIsDisplayedOnEStore() {
        estorePdpPageScreen.getTurkishTowelCollectionTitle().should(Condition.and("", interactable, visible), Duration.ofSeconds(20));
    }

    @And("I verify that {int} grid view should be selected state by default")
    public void iVerifyThatGridViewShouldBeSelectedStateByDefault(int arg0) {
        estoreSaleScreen.getGridView1().should(visible, Duration.ofSeconds(12));
    }

    @Then("I verify that each collection have image, title")
    public void iVerifyThatEachCollectionHaveImageTitle() {
        estoreSaleScreen.getCollectionTitle().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getCollectionImage().should(visible, Duration.ofSeconds(12));
        estoreSaleScreen.getSaleVerbiageMessage().should(visible, Duration.ofSeconds(12));
    }

    @When("I click on Bedding collection from tertiary NAV")
    public void iClickOnBeddingCollectionFromTertiaryNAV() {
        estoreSaleScreen.clickToBeddingCollectionNav();
    }

    @Then("I verify that user is able to change the sort option - Featured")
    public void iVerifyThatUserIsAbleToChangeTheSortOptionFeatured() {
        estorePDPScreen.getSortByButton().should(visible, Duration.ofSeconds(20));
        estorePDPScreen.getSortByButton().click();
        estorePDPScreen.getPriceHighToLow().should(visible, Duration.ofSeconds(20));
        estorePDPScreen.getPriceHighToLow().click();
        estoreSaleScreen.getHighToLowText().should(visible, Duration.ofSeconds(12));
    }

    @When("I click on Bed in TOP NAV menu")
    public void iClickOnBedInTOPNAVMenu() {
        estoreHomePage.clickToBedNav();
    }

    @When("I click on SALE in Secondary NAV")
    public void iClickOnSALEInSecondaryNAV() {
        estoreHomePage.clickToSaleTopNav();
    }

    @When("I click on Bedroom collection in Tertiary NAV")
    public void iClickOnBedroomCollectionInTertiaryNAV() {
        estoreHomePage.clickToSaleBedBeddingCollection();
    }

    @When("I click on Beds in Tertiary NAV")
    public void iClickOnBedsInTertiaryNAV() {
        estoreHomePage.clickToBedsSaleTertiaryNav();
    }

    @And("I verify that sale filter should be not displayed in Filter section")
    public void iVerifyThatSaleFilterShouldBeNotDisplayedInFilterSection() {
        estorePGScreen.getSaleFilterApplied().should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that number of products should be displayed as RESULTS")
    public void iVerifyThatNumberOfProductsShouldBeDisplayedAsRESULTS() {
        estorePGScreen.getResultsText().should(visible, Duration.ofSeconds(20));
    }

    @And("I verify that Regular,Sale,Member Price should be displayed for the products")
    public void iVerifyThatRegularSaleMemberPriceShouldBeDisplayedForTheProducts() {
        System.out.println();
    }

    @When("I click on {string} in TOP NAV menu")
    public void iClickOnInTOPNAVMenu(String topNav) {
        estoreHomePage.clickToTopNavMenu(topNav);
    }

    @Then("I verify that Sale filter was applied")
    public void iVerifyThatSaleFilterWasApplied() {
        estoreSaleScreen.verifyThatSaleAppliedFilterIsDisplayed();
    }

    @When("I click on length button")
    public void iClickOnLengthButton() {
        estorePGScreen.getLengthFilterOption().should(visible, Duration.ofSeconds(12)).click(ClickOptions.usingJavaScript());
    }
}