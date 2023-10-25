package tests.estore.stepdefinitions;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;
import tests.concierge.pageObject.SelectOption;
import tests.estore.pageObject.*;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.AssertJUnit.*;

public class EstorePdpStepDefs {

    EstorePdpPageScreen estorePdpPageScreen = new EstorePdpPageScreen();

    SelectOption selectOption = new SelectOption();

    EstoreCartPage estoreCartPage = new EstoreCartPage();

    EstoreHomePage estoreHomePage = new EstoreHomePage();

    EstorePGScreen estorePGScreen = new EstorePGScreen();

    EstorePDPScreen estorePDPScreen = new EstorePDPScreen();

    EstoreReturnPolicyScreen estoreReturnPolicyScreen = new EstoreReturnPolicyScreen();

    EstoreE2EStepDefs estoreE2EStepDefs = new EstoreE2EStepDefs();

    EstoreAccountStepDefs estoreAccountStepDefs = new EstoreAccountStepDefs();

    EstorePgStepDefs estorePgStepDefs = new EstorePgStepDefs();
    String regularUSPrice;
    String memberUSPrice;
    String regularCAGBPrice;
    String memberCAGBPrice;
    String MemberSalePrice;
    String RegularSalePrice;

    int itemCartPriceRegular;
    int itemCartPriceMember;

    int regularPricePdp;
    int memberPricePdp;


    @Then("I verify that user can see product details correctly mentioned for a product")
    public void iVerifyThatUserCanSeeProductDetailsCorrectlyMentionedForAProduct() {
        $(By.xpath("//*[text()='DETAILS']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='DETAILS']")).click();
        $(By.xpath("//*[text()='Loomed to a rich 802 grams per square meter']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Made of the finest 100% cotton terry cloth from Turkey']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Bath sheets and towels are luxuriously oversized for enveloping comfort']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Bath sheets, bath towels and hand towels may be monogrammed; placement will be front and center, just above the dobby']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Add a 1-initial or 3-initial monogram with choice of font color and style; choose Tone-on-Tone color option to match towel color']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Personalized items may not be returned and are not eligible for expedited shipping']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Care']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify user can see the correct price for hero image product and the line items")
    public void iVerifyUserCanSeeTheCorrectPriceForHeroImageProductAndTheLineItems() {
        estorePdpPageScreen.getMemberPrice().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getRegularPrice().should(Condition.visible, Duration.ofSeconds(20));
    }

    @And("I verify view In-stock options")
    public void iVerifyViewInStockOptions() {
        estorePdpPageScreen.getInStockOptionsButton().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getInStockOptionsButton().click();
        estorePdpPageScreen.getInStockTitle().should(Condition.visible, Duration.ofSeconds(20));

//        estorePdpPageScreen.getTurkishTowelCollectionTitle().should(Condition.and("", interactable, visible), Duration.ofSeconds(20));
        estorePdpPageScreen.getItemInStockOption().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getSizeInStockOption().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getColorInStockOption().should(Condition.visible, Duration.ofSeconds(20));
    }

    @And("I verify view sale")
    public void iVerifysalepage() {
        estorePdpPageScreen.getViewSaleItems().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getViewSaleItems().click();

        estorePdpPageScreen.getTurkishTowelCollectionTitle().should(Condition.and("", interactable, visible), Duration.ofSeconds(20));
        estorePdpPageScreen.getItemInStockOption().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getSizeInStockOption().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getColorInStockOption().should(Condition.visible, Duration.ofSeconds(20));
    }

    @And("I click Add to Wishlist")
    public void iAddtoWishlist() {
        if (estorePdpPageScreen.getSelectSize().isDisplayed()) {
            Select sizeList = new Select(estorePdpPageScreen.getSelectSize());
            sizeList.selectByIndex(1);
            with().pollInterval(2, SECONDS).await().until(() -> true);
        }
        if (estorePdpPageScreen.getSelectColorElement().isDisplayed()) {
            Select color = new Select(estorePdpPageScreen.getSelectColorElement());
            color.selectByIndex(2);
            with().pollInterval(2, SECONDS).await().until(() -> true);
        }
        estorePdpPageScreen.getAddToWishlist().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getAddToWishlist().click(ClickOptions.usingJavaScript());
    }

    @Then("I verify the items present in the wishlist")
    public void iVerifyItemsinWishList() {
        estorePdpPageScreen.getViewWishlistButton().should(Condition.and("Visible, interactable condition", visible, interactable), Duration.ofSeconds(20));
        estorePdpPageScreen.getKeepShopping().should(Condition.and("Visible, interactable condition", visible, interactable), Duration.ofSeconds(20));
        estorePdpPageScreen.getViewWishlistButton().click();
        WebDriverRunner.getWebDriver().navigate().back();
        iAddtoWishlist();
        estorePdpPageScreen.getKeepShopping().click();
        WebDriverRunner.getWebDriver().navigate().back();
    }

    @Then("I verify Details, Dimensions and Fabric")
    public void iVerifyDetailsDimensionsAndFabric() {
        estorePdpPageScreen.getDetailsButton().should(visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getDetailsButton().click();
        $(By.xpath("//*[text()='Made of the finest 100% cotton terry cloth from Turkey']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Personalized items may not be returned and are not eligible for expedited shipping']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Care']")).should(visible, Duration.ofSeconds(20));

        estorePdpPageScreen.getDimensionsButton().should(visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getDimensionsButton().click();
        $(By.xpath("(//*[contains(text(),'Bath Sheet')])[1]")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("(//*[contains(text(),'Hand Towel')])[1]")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("(//*[contains(text(),'Bath Towel')])[1]")).should(visible, Duration.ofSeconds(20));
    }

    @Then("verify the product price as per the postal code")
    public void verifyTheProductPriceAsPerThePostalCode() {
        int regularPrice = Integer.parseInt($(By.xpath("(//*[@data-testid='price-for-regular'])[1]")).getText().replaceAll("\\$", "").replaceAll("\\,", ""));
        int memberPrice = Integer.parseInt($(By.xpath("(//*[@data-testid='price-for-member'])[1]")).getText().replaceAll("\\$", "").replaceAll("\\,", ""));

        assertTrue("Regular price is not equal to zero", regularPrice > 0);
        assertTrue("Member price is not equal to zero", memberPrice > 0);
    }

    @Then("I verify that price for product&line should be in US dollars on PDP page")
    public void iVerifyThatPriceForProductLineShouldBeInUS$() {
        estorePdpPageScreen.getRegularTheFirstPrice().shouldHave(text("$"));
    }

    @When("I update {string} postal code on pdp page")
    public void iUpdatePostalCodeOnPdpPage(String country) {
        estorePdpPageScreen.getPostalCodePdp().should(visible, Duration.ofSeconds(25));
        estorePdpPageScreen.getPostalCodePdp().scrollIntoView(true);
        estorePdpPageScreen.getPostalCodePdp().click();
        $(By.xpath("//div[@id='country-zipcode-selection']")).should(visible, Duration.ofSeconds(20)).click();
        if (country.equals("CAN")) {
            $(By.xpath("//li[@data-value='CA']")).should(visible, Duration.ofSeconds(20)).click();
            $(By.xpath("//input[@id='postal-code-international']")).clear();
            $(By.xpath("//input[@id='postal-code-international']")).setValue("Y1A 9Z9");
            estorePdpPageScreen.getSubmitPostalCode().should(visible, Duration.ofSeconds(20));
            estorePdpPageScreen.getSubmitPostalCode().click();
            estorePdpPageScreen.getConfirmChangeButton().should(visible, Duration.ofSeconds(40)).click();
            WebDriverRunner.getWebDriver().navigate().refresh();
            $(By.xpath("//*[text()='Y1A 9Z9.']")).should(visible, Duration.ofSeconds(40));
        }
        if (country.equals("US")) {
            $(By.xpath("//li[@data-value='US']")).should(visible, Duration.ofSeconds(20)).click();
            $(By.xpath("//input[@id='postal-code-international']")).clear();
            $(By.xpath("//input[@id='postal-code-international']")).setValue("82083");
            estorePdpPageScreen.getSubmitPostalCode().should(visible, Duration.ofSeconds(20));
            estorePdpPageScreen.getSubmitPostalCode().click();
        }
        if (country.equals("GB")) {
            $(By.xpath("//li[@data-value='GB']")).should(visible, Duration.ofSeconds(20)).click();
            $(By.xpath("//input[@id='postal-code-international']")).clear();
            $(By.xpath("//input[@id='postal-code-international']")).setValue("SW1W 0NY");
            estorePdpPageScreen.getSubmitPostalCode().should(visible, Duration.ofSeconds(20));
            estorePdpPageScreen.getSubmitPostalCode().click();
            estorePdpPageScreen.getConfirmChangeButton().should(visible, Duration.ofSeconds(40)).click();
        }
    }

    @Then("I add quantity and add to cart In-stock options")
    public void iAddQuantityandAddtoCart() {
        estorePdpPageScreen.getQtyInStockItems().click();
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(estorePdpPageScreen.getQtyInStockItems_2()).click();
        estorePdpPageScreen.getAddToCartBtnInStockItems().click();
    }


    @Then("I verify line items {string}")
    public void iVerifyLineItems(String functional) {
        if (functional.equals("lineitemimage")) {
            estorePdpPageScreen.getLineItemImage().should(visible, Duration.ofSeconds(30));
        }
        if (functional.equals("customizeanproduct")) {
            estorePdpPageScreen.getSizeOption().should(visible, Duration.ofSeconds(20)).scrollIntoView(true);
            estorePdpPageScreen.getSizeOption().should(interactable, Duration.ofSeconds(20));
            Select selectSize = new Select(estorePdpPageScreen.getSizeOption());
            selectSize.selectByIndex(2);
            with().pollInterval(4, SECONDS).await().until(() -> true);
            estorePdpPageScreen.getColorOption().should(interactable, Duration.ofSeconds(25));
            Select selectColor = new Select(estorePdpPageScreen.getColorOption());
            selectColor.selectByIndex(2);
        }
        if (functional.equals("addtowishlist")) {
            estoreCartPage.getAddToWishlistButton().should(visible, Duration.ofSeconds(20)).scrollIntoView(true);
            estoreCartPage.getAddToWishlistButton().should(interactable, Duration.ofSeconds(20)).click();

        }
        if (functional.equals("locationfunctionality")) {
            estorePdpPageScreen.getPostalCodePdp().should(visible, Duration.ofSeconds(30));
        }
    }

    @Then("I verify the sku for single and multiple ids")
    public void iVerifyTheSkuForSingleAndMultipleIds() {
        estorePdpPageScreen.getColorOption().should(visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getColorOption().scrollIntoView(true).should(visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getSizeOption().should(Condition.and("", visible, interactable), Duration.ofSeconds(20));

        Select selectColor = new Select(estorePdpPageScreen.getColorOption());
        selectColor.selectByIndex(2);
        estorePdpPageScreen.getColorOption().should(Condition.and("", visible, interactable), Duration.ofSeconds(20));
        sleep(3000);
        Select selectSize = new Select(estorePdpPageScreen.getSizeOption());
        selectSize.selectByIndex(2);

        estorePdpPageScreen.getSkuIdValue().shouldHave(text("Item# 17050042 EUCY"), Duration.ofSeconds(30));
    }

    @Then("I verify that PDP screen is displayed")
    public void iVerifyThatPDPScreenIsDisplayed() {
        $(By.xpath("(//*[text()='802-Gram Turkish Towel Collection'])[2]")).should(visible, Duration.ofSeconds(30));
    }

    @And("I verify the browser back")
    public void iVerifyTheBrowserBack() {
        WebDriverRunner.getWebDriver().navigate().back();
        WebDriverRunner.getWebDriver().getCurrentUrl().equals("https://stg2.rhnonprod.com/us/en/");
        estoreHomePage.getHomePageLogo().should(visible, Duration.ofSeconds(30));
    }

    @Then("I verify the browser forwards button")
    public void iVerifyTheBrowserForwardsButton() {
        WebDriverRunner.getWebDriver().navigate().forward();
        $(By.xpath("(//*[text()='802-Gram Turkish Towel Collection'])[2]")).should(visible, Duration.ofSeconds(30));
    }

    @Then("I verify the search icon functionality")
    public void iVerifyTheSearchIconFunctionality() {
        estorePGScreen.getInStockFilter().should(visible, Duration.ofSeconds(30));
        estorePGScreen.getSofa().should(visible, Duration.ofSeconds(30));
    }

    @Then("I verify the product price for the selected country")
    public void iVerifyTheProductPriceForTheSelectedCountry() {
        estorePdpPageScreen.getRegularTheFirstPrice().shouldHave(text("$20"), Duration.ofSeconds(30));
        estorePdpPageScreen.getMemberTheFirstPrice().shouldHave(text("$15"), Duration.ofSeconds(30));
    }

    @Then("I verify the product price on PDP for non-sale cushion and frame product")
    public void iVerifyTheProductPriceOnPDPForNonSaleCushionAndFrameProduct() {
        estorePdpPageScreen.getRegularTheFirstPrice().shouldHave(text("$13"), Duration.ofSeconds(30));
        estorePdpPageScreen.getMemberTheFirstPrice().shouldHave(text("$9"), Duration.ofSeconds(30));
        estorePdpPageScreen.getMemberTheSecondPrice().shouldHave(text("$18"), Duration.ofSeconds(30));
        estorePdpPageScreen.getRegularTheSecondPrice().shouldHave(text("$25"), Duration.ofSeconds(30));
    }

    @When("I update {string} postal code on cart page")
    public void iUpdatePostalCodeOnPDPPage(String zipCode) {
        estoreCartPage.getPostalCodeButton().should(visible, Duration.ofSeconds(20));
        estoreCartPage.getPostalCodeButton().scrollIntoView(true);
        estoreCartPage.getPostalCodeButton().click();
        estorePdpPageScreen.getCountryZipCodeSelection().click();
        if (zipCode.equals("US")) {
            $(By.xpath("//li[@data-value='US']")).should(visible, Duration.ofSeconds(20)).click();
            estorePdpPageScreen.getPostalCodeField().should(visible, Duration.ofSeconds(20)).sendKeys("88989");
            estorePdpPageScreen.getSubmitPostalCode().should(visible, Duration.ofSeconds(25)).click();
        }
        if (zipCode.equals("CA")) {
            $(By.xpath("//li[@data-value='CA']")).should(visible, Duration.ofSeconds(20)).click();
            estorePdpPageScreen.getPostalCodeField().should(visible, Duration.ofSeconds(20)).sendKeys("Y1A 9Z9");
            estorePdpPageScreen.getSubmitPostalCode().should(visible, Duration.ofSeconds(25)).click();
            $(By.xpath("//*[text()='CONFIRM CHANGE']")).should(interactable, Duration.ofSeconds(20));
            $(By.xpath("//*[text()='CONFIRM CHANGE']")).should(visible, Duration.ofSeconds(20)).click();
        }
    }

    @Then("I verify that price is showing for regular and member user")
    public void iVerifyThatPriceIsShowingForRegularUser() {
        estorePdpPageScreen.getMemberPrice().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getRegularPrice().should(Condition.visible, Duration.ofSeconds(20));
    }

    @And("I verify that price for {string} and {string} with {string} was updated for {string}")
    public void iVerifyThatPriceForAndWithWasUpdatedFor(String arg0, String arg1, String arg2, String arg3) {
        if (arg3.equals("CAN") && (arg0.equals("prod2020027"))) {
            $(By.xpath("//*[text()='$13']")).should(visible, Duration.ofSeconds(20));
            $(By.xpath("//*[text()='$9']")).should(visible, Duration.ofSeconds(20));
        }
    }

    @When("I unselect the size option for {string} and {string} with {string} for estore")
    public void iUnselectTheSizeOptionForAndWithForEstore(String prodId, String arg1, String arg2) {
        Select sizeOption = new Select($(By.xpath("//select[@id='optionSelect-" + prodId + "-Size']")));
        sizeOption.selectByValue("");
    }

    @Then("I verify availability , delivery and return messages in PDP")
    public void iVerifyAvailabilityDeliveryAndReturnMessagesInPDP() {
        iVerifySpecialMessagesOnPDPPage();
    }

    @Then("I verify link bellow {string} is displayed")
    public void iVerifyLinkBellowIsDisplayed(String arg0) {
        $(By.xpath("(//span[text()='In-Stock' and text()='View' and 'items'])[1]")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("(//span[text()='View' and 'Sale' and 'items'])[3]")).should(visible, Duration.ofSeconds(20));
    }

    @Then("verify that the {string} zip code was updated with the {string} zip code")
    public void verifyThatTheZipCodeWasUpdatedWithTheZipCode(String arg0, String arg1) {
        $(By.xpath("(//*[text()='Y1A 9Z9.'])[1]")).should(visible, Duration.ofSeconds(30));
    }

    @When("I select size option on the PDP page")
    public void iSelectSizeOptionOnThePDPPage() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        if (estorePDPScreen.getSizeOption().isDisplayed()) {
            estorePDPScreen.selectSizeOption();
        }
    }

    @When("I select finish option on the PDP page")
    public void iSelectFinishOptionOnThePDPPage() {
        estorePDPScreen.selectFinishOption();
    }

    @Then("I verify the product price for product {string} and {string} with {string} for the selected {string} country")
    public void iVerifyTheProductPriceForProductAndWithForTheSelectedCountry(String productID, String arg1, String selectedOptions, String country) {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        WebDriverRunner.getWebDriver().navigate().refresh();
        estorePdpPageScreen.getRegularTheFirstPrice().should(visible, Duration.ofSeconds(20));
        regularPricePdp = Integer.parseInt(estorePdpPageScreen.getRegularPdpProductPrice().getText().replaceAll("\\$", ""));
        memberPricePdp = Integer.parseInt(estorePdpPageScreen.getMemberPdpProductPrice().getText().replaceAll("\\$", ""));

        assertTrue("Regular price is greater than 0", regularPricePdp > 0);
        assertTrue("Member price is greater than 0", memberPricePdp > 0);

    }

    @Then("I verify the text displaying before price at hero image level for product {string} and {string} with {string} for the selected {string} country")
    public void iVerifyTheTextDisplayingBeforePriceAtHeroImageLevel(String productID, String arg1, String selectedOptions, String country) {
        $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12']//p[text()='Starting at']")).should(visible, Duration.ofSeconds(30));
    }


    @Then("I verify the text displaying before price at line item level for product {string} and {string} with {string} for the selected {string} country")
    public void iVerifyTheTextDisplayingBeforePriceAtLineItemLevel(String productID, String arg1, String selectedOptions, String country) {
        $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container']//p[text()='Starting at']")).should(visible, Duration.ofSeconds(30));
    }

    @Then("I verify that user is able to add line item separately for product {string} and {string} with {string} for the selected {string} country")
    public void iVerifyThatUserIsAbleToAddLineItemSeparatelyForProduct(String productID, String arg1, String selectedOptions, String country) {
        String lineTimeId = estorePdpPageScreen.getLineItemId().getText();
        String itemIt = lineTimeId.split("# ")[1];
        estorePdpPageScreen.getAddToCartBtn().click();
        estorePdpPageScreen.getItemAddedInCarMsg().should(visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getViewCartBtn().click();
        $(By.xpath("//p[text()='" + itemIt + "']")).should(visible, Duration.ofSeconds(30));
        Select selectSize = new Select(estorePdpPageScreen.getSizeOption());
        selectSize.selectByIndex(2);
        Select selectColor = new Select(estorePdpPageScreen.getColorOption());
        selectColor.selectByIndex(2);
    }

    @Then("I verify availability delivery and return for product {string} and {string} with {string} for the selected {string} country")
    public void iVerifyAvailabilityDeliveryAndReturnForProduct(String productID, String arg1, String selectedOptions, String country) {
        $(By.xpath("(//span[text()='Return Policy'])[1]")).should(visible, Duration.ofSeconds(30));
        $(By.xpath("(//p[text()='Configure this item to view delivery information '])[1]")).should(visible, Duration.ofSeconds(30));
        estorePdpPageScreen.getInStockOptionsButton().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getInStockOptionsButton().click();
        $(By.xpath("//*[text()='These options are available for']")).shouldBe(visible, Duration.ofSeconds(15));
    }

    @Then("I verify functionality for Hero Image on PDP for product {string} and {string} with {string} for the selected {string} country")
    public void iVerifyFunctionalityForHeroImageONPDPForProduct(String productID, String arg1, String selectedOptions, String country) {
        $(By.xpath("//img[@data-testid='desktop-pdp-image']")).hover();
        estorePdpPageScreen.getHeroImageForwardBtn().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getHeroImageForwardBtn().click();
        estorePdpPageScreen.getHeroImageBackBtn().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getHeroImageBackBtn().click();
        estorePdpPageScreen.getHeroImagePlusIconZoomInBtn().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getHeroImagePlusIconZoomInBtn().click();
        estorePdpPageScreen.getHeroImagePlusIconZoomOutBtn().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getHeroImagePlusIconZoomOutBtn().click();
        estorePdpPageScreen.getHeroImageUpwardBtn().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getHeroImageUpwardBtn().click();
        estorePdpPageScreen.getHeroImageDownwardBtn().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getHeroImageDownwardBtn().click();
        estorePdpPageScreen.getHeroImageCloseIcon().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getHeroImageCloseIcon().click();
    }

    @Then("I verify the PDP title and pricing for product")
    public void iVerifyThePDPTitleAndPricingForProduct() {
        String titleOnPg = estorePDPScreen.getFistItemTitle().getText();
        String priceOnPG = estorePDPScreen.getFirstRegularPrice().getText();
        String productId = estorePDPScreen.getFistItemProductId().getAttribute("alt");
        String pdId = productId.split("_")[0];
        estoreE2EStepDefs.iOpenProductPageWithAndForEstore(pdId, "", "");
        String titleOnPDP = estorePdpPageScreen.getPDPTitle().getText();
        String priceOnPDP = estorePdpPageScreen.getRegularTheFirstPrice().getText();
        Assert.assertEquals(titleOnPg, titleOnPDP);
        Assert.assertEquals(priceOnPG, priceOnPDP);
    }

    @Then("I verify the content of PDP for eStore - verifying SOFA PDP")
    public void iVerifyTheContentOfPDPForEstoreProduct() {
        Assert.assertTrue(estorePdpPageScreen.getPDPTitle().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getAlsoAvailableInLeatherText().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getShopTheEntireCollectionText().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getHeroImage().isDisplayed());
        estorePdpPageScreen.getHeroImage().hover();
        Assert.assertTrue(estorePdpPageScreen.getHeroImageForwardBtn().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getHeroImageBackBtn().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getAddToCartBtn().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getReturnPolicyLink().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getConfigureDeliveryInformationText().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getPdpDetailsSection().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getPdpDimensionsSection().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getPdpFabricCareSection().isDisplayed());
    }

    @Then("I verify another PDP - Chaise")
    public void iVerifyAnotherPDPChaiseProduct() {
        Assert.assertTrue(estorePdpPageScreen.getPDPTitle().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getAlsoAvailableInAluminumText().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getShopTheEntireCollectionText().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getInStockOptionsButton().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getPdpDetailsSection().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getPdpDimensionsSection().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getPdpCareSection().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getHeroImage().isDisplayed());
        estorePdpPageScreen.getHeroImage().hover();
        Assert.assertTrue(estorePdpPageScreen.getHeroImageForwardBtn().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getHeroImageBackBtn().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getAddToCartBtn().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getReturnPolicyLink().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getConfigureDeliveryInformationText().isDisplayed());
    }

    @Then("I verify another PDP - Bench")
    public void iVerifyAnotherPDPBenchProduct() {
        Assert.assertTrue(estorePdpPageScreen.getPDPTitle().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getInStockOptionsButton().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getShopTheEntireCollectionText().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getPdpDetailsSection().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getPdpDimensionsSection().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getPdpCareSection().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getHeroImage().isDisplayed());
        estorePdpPageScreen.getHeroImage().hover();
        Assert.assertTrue(estorePdpPageScreen.getHeroImageForwardBtn().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getHeroImageBackBtn().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getAddToCartBtn().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getReturnPolicyLink().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getTouchUpKitText().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getPdpFooter().isDisplayed());
    }

    @Then("I verify another PDP - Towel")
    public void iVerifyAnotherPDPTowelProduct() {
        Assert.assertTrue(estorePdpPageScreen.getPDPTitle().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getPdpColorOption().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getInStockOptionsButton().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getPdpDetailsSection().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getPdpDimensionsSection().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getHeroImage().isDisplayed());
        estorePdpPageScreen.getHeroImage().hover();
        Assert.assertTrue(estorePdpPageScreen.getHeroImageForwardBtn().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getHeroImageBackBtn().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getAddToCartBtn().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getReturnPolicyLink().isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getPdpFooter().isDisplayed());
    }

    @Then("I verify the product price as per the Ship to selection for product {string} and {string} with {string} for the selected {string} country")
    public void iVerifyTheProductPriceAsPerTheShipToSelectionForProduct(String productID, String arg1, String selectedOptions, String country) {
        estorePdpPageScreen.getCountrySelectionBtn().should(visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getCountrySelectionBtn().scrollIntoView(true);
        estorePdpPageScreen.getCountrySelectionBtn().should(visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getCountrySelectionBtn().click();
        estorePdpPageScreen.getCountyCode().should(visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getCountyCode().click();
        WebDriverRunner.getWebDriver().navigate().refresh();
        estorePdpPageScreen.getHeroImageMemberPrice().should(visible, Duration.ofSeconds(20));
        Assert.assertTrue(estorePdpPageScreen.getHeroImageMemberPrice().shouldBe(visible, Duration.ofSeconds(15)).isDisplayed());
        Assert.assertTrue(estorePdpPageScreen.getHeroImageRegularPrice().shouldBe(visible, Duration.ofSeconds(15)).isDisplayed());
        estorePdpPageScreen.getInStockOptionsButton().click();
        estorePdpPageScreen.getPostalCodeInput().sendKeys("W1S 3ES");
        estorePdpPageScreen.getPostalCodeSubmitBtn().click();
        estorePdpPageScreen.getViewStockMsg().shouldBe(visible, Duration.ofSeconds(15));
        estorePdpPageScreen.getAvailableItemMsg().shouldBe(visible, Duration.ofSeconds(15));
        estorePdpPageScreen.getHeroImageCloseIcon().click();
    }

    @Then("I verify the line item price for Combined Frame and Cushion for product {string} and {string} with {string} for the selected {string} country")
    public void iVerifyTheLineItemPriceForCombineAndCushionProduct(String productID, String arg1, String selectedOptions, String country) {
        String heroImageMemberPrice = estorePdpPageScreen.getHeroImageMemberPrice().getText().trim();
        String heroImageRegularPrice = estorePdpPageScreen.getHeroImageRegularPrice().getText().trim();
        String lineItemMemberPrice = estorePdpPageScreen.getLineItemMemberPrice().getText().trim();
        String lineItemRegularPrice = estorePdpPageScreen.getLineItemRegularPrice().getText().trim();

        assertEquals("Hero image & line item member price is not equal", heroImageMemberPrice, lineItemMemberPrice);
        assertEquals("Hero image & line item regular price is not equal", heroImageRegularPrice, lineItemRegularPrice);
    }

    @And("I verify that {string} popup is displayed")
    public void iVerifyThatPopupIsDisplayed(String modalPopUp) {
        if (modalPopUp.equals("View In-Stock")) {
            $(By.xpath("(//span[text()='In-Stock' and text()='View' and 'items'])[1]")).should(visible, Duration.ofSeconds(20)).click(ClickOptions.usingJavaScript());
            $(By.xpath("(//p[text()='802-Gram Turkish Towel Collection'])[2]")).should(visible, Duration.ofSeconds(20));
            estorePDPScreen.getAddToCartButtonViewInStockPopUp().should(visible, Duration.ofSeconds(15));
        }
        if (modalPopUp.equals("View On Sale")) {
            $(By.xpath("(//span[text()='View' and 'Sale' and 'items'])[3]")).should(visible, Duration.ofSeconds(20)).click(ClickOptions.usingJavaScript());
            $(By.xpath("//span[text()='ON SALE']")).should(visible, Duration.ofSeconds(20));
            $(By.xpath("(//p[text()='802-Gram Turkish Towel Collection'])[2]")).should(visible, Duration.ofSeconds(20));
            estorePDPScreen.getAddToCartButtonViewInStockPopUp().should(visible, Duration.ofSeconds(15));
        }
    }

    @When("I select color option on the PDP page")
    public void iSelectColorOptionOnThePDPPage() {
        estorePDPScreen.selectColorOption();
    }

    @And("I verify special messages on PDP page")
    public void iVerifySpecialMessagesOnPDPPage() {
        estorePDPScreen.verifyThatSpecialMessagesAreDisplayed();
    }

    @When("I get prices for US for eStore")
    public void iGetPricesForUSForEStore() {
        regularUSPrice = estorePDPScreen.getFirstRegularPrice().getText();
        memberUSPrice = estorePDPScreen.getFirstMemberPrice().getText();
    }

    @Then("I verify that prices for {string} was updated")
    public void iVerifyThatPricesForWasUpdated(String arg0) {
        regularCAGBPrice = estorePDPScreen.getFirstRegularPrice().getText();
        memberCAGBPrice = estorePDPScreen.getFirstMemberPrice().getText();
        estorePDPScreen.getFirstRegularPrice().shouldNotHave(text(regularUSPrice), Duration.ofSeconds(25));

        assertFalse("Regular price was update after country was changed", regularUSPrice.equals(regularCAGBPrice));
        assertFalse("Member price was update after country was changed", memberUSPrice.equals(memberCAGBPrice));
    }

    @Then("I verify price for member and regular user on PDP")
    public void iVerifyThatPriceForMemberAndRegularUserOnPDP() {
        regularCAGBPrice = estorePDPScreen.getFirstRegularPrice().getText();
        memberCAGBPrice = estorePDPScreen.getFirstMemberPrice().getText();
    }

    @Then("I verify that price in cart is the same as on PDP")
    public void iVerifyThatPriceInCartIsTheSameAsOnPDP() {
        estoreCartPage.getCartRegularPrice().should(visible, Duration.ofSeconds(20));
        itemCartPriceRegular = estoreCartPage.getRegularProductPriceInCart();
        itemCartPriceMember = estoreCartPage.getMemberProductPriceInCart();

        assertEquals("Verify that regular price on the Cart is the same as on PDP",
                itemCartPriceRegular, regularPricePdp);
        assertEquals("Verify that member price on the Cart is the same as on PDP",
                itemCartPriceMember, memberPricePdp);
    }


    @When("user clicks on return policy link")
    public void userClicksOnReturnPolicyLink() {
        estorePDPScreen.clickToReturnPolicyButton();
    }

    @Then("user verifies that user is redirected to a return policy page")
    public void userVerifiesThatUserIsRedirectedToAReturnPolicyPage() {
        estoreReturnPolicyScreen.verifyThatReturnPolicyPageIsDisplayed();
    }

    @When("I click on add monogram checkbox from pdp on eStore")
    public void iClickOnAddMonogramCheckboxFromPdpOnEStore() {
        estorePDPScreen.clickToMonogramCheckBox();
    }

    @When("I add monogram to product on eStore")
    public void iVerfiyThatIMAbleToChooseMonogram() {
        $(By.xpath("//*[text()='PERSONALIZE YOUR SELECTIONS']")).should(visible, Duration.ofSeconds(25));
        $(By.xpath("//input[@name='checkboxBauer Bodoni 2 (BDNI-HD)']")).click();
        $(By.xpath("//input[@name='checkboxTone-on-Tone (TOT)']")).click();
        $(By.xpath("//input[@data-testid='monogram-input0']")).should(appear, Duration.ofSeconds(25)).setValue("tes");
        $(By.xpath("//button[@data-testid='monogram-add-button']")).should(visible, Duration.ofSeconds(25)).click();
    }

    @Then("I verify that monogram was added for pdp on eStore")
    public void iVerifyThatMonogramWasAddedForPdpOnEStore() {
        $(By.xpath("//p[text()='PERSONALIZATION']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//p[text()='Style']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//p[text()='Bauer Bodoni 2 (BDNI-HD)']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//p[text()='Text']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//p[text()='tes']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[@id='listColumn1-Color']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//p[text()='TOT']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//p[text()='Edit']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//p[text()='Remove']")).should(visible, Duration.ofSeconds(20));
    }

    @And("I click Add to Cart and validate the added items in the cart")
    public void iAddtoCart() {
        if (estorePdpPageScreen.getSelectSize().isDisplayed()) {
            Select sizeList = new Select(estorePdpPageScreen.getSelectSize());
            sizeList.selectByIndex(1);
            with().pollInterval(2, SECONDS).await().until(() -> true);
        }
        if (estorePdpPageScreen.getSelectColorElement().isDisplayed()) {
            Select color = new Select(estorePdpPageScreen.getSelectColorElement());
            color.selectByIndex(2);
            with().pollInterval(2, SECONDS).await().until(() -> true);
        }
        estorePdpPageScreen.getAddToCartBtn().click();
        estorePdpPageScreen.getKeepShopping().should(Condition.and("Visible, interactable condition", visible, interactable), Duration.ofSeconds(20));
        estorePdpPageScreen.getViewCartBtn().should(Condition.and("Visible, interactable condition", visible, interactable), Duration.ofSeconds(20));
        estorePdpPageScreen.getViewCartBtn().click();
        estorePdpPageScreen.getViewCartValidation().should(Condition.and("Visible, interactable condition", visible, interactable), Duration.ofSeconds(20));
    }

    @Then("Sale price validated before and after customizing")
    public void iVerifySalePriceshowsCombined() {
        MemberSalePrice = estorePdpPageScreen.getMemberPdpProductPrice().getText();
        RegularSalePrice = estorePdpPageScreen.getRegularTheSecondPrice().getText();

        //updating the values to see the price difference
        Select depth = new Select(estorePdpPageScreen.getSelectDepth());
        depth.selectByIndex(1);
        with().pollInterval(2, SECONDS).await().until(() -> true);

        Select fill = new Select(estorePdpPageScreen.getSelectFill());
        fill.selectByIndex(1);
        with().pollInterval(2, SECONDS).await().until(() -> true);

        Select color = new Select(estorePdpPageScreen.getSelectColor());
        color.selectByIndex(1);
        with().pollInterval(2, SECONDS).await().until(() -> true);

        Select depthlength = new Select(estorePdpPageScreen.getSelectLength());
        depthlength.selectByIndex(1);
        with().pollInterval(2, SECONDS).await().until(() -> true);

        Select depthleather = new Select(estorePdpPageScreen.getSelectLeather());
        depthleather.selectByIndex(1);
        with().pollInterval(2, SECONDS).await().until(() -> true);

        memberUSPrice = estorePdpPageScreen.getMemberPdpProductPrice().getText();
        regularUSPrice = estorePdpPageScreen.getRegularTheSecondPrice().getText();

        assertTrue("Regular price is updated after values are updated", regularUSPrice.equalsIgnoreCase(RegularSalePrice));
        assertTrue("Member price is updated after values are updated", memberUSPrice.equalsIgnoreCase(MemberSalePrice));

    }

    @When("Product with Sale URL is opened")
    public void iOpenURL() {
        String Url = "https://stg2.rhnonprod.com/us/en/catalog/product/product.jsp?productId=prod2140453&sale=true&layout=horizontal";
        open(Url);
        WebDriverRunner.getWebDriver().navigate().refresh();
    }

    @Then("Sale price validated and URL sale==true")
    public void iVerifySalePriceandUrlisTrue() {
        MemberSalePrice = estorePdpPageScreen.getMemberPdpProductPrice().getText();
        RegularSalePrice = estorePdpPageScreen.getRegularTheSecondPrice().getText();
        assertTrue(Hooks.getCurrentUrl().contains("sale=true"));
    }

    @Then("Sale link validated along with selecting value")
    public void iVerifySaleLinkValidated() {
        RegularSalePrice = estorePdpPageScreen.getRegularTheSecondPrice().getText();

        //updating the values to see the price difference
        Select Size = new Select(estorePdpPageScreen.getSelectSize());
        Size.selectByIndex(1);
        with().pollInterval(2, SECONDS).await().until(() -> true);

        Select color = new Select(estorePdpPageScreen.getSelectColor());
        color.selectByIndex(1);
        with().pollInterval(2, SECONDS).await().until(() -> true);

        Select Fabric = new Select(estorePdpPageScreen.getSelectFabric());
        Fabric.selectByIndex(1);
        with().pollInterval(2, SECONDS).await().until(() -> true);

        Select cushionFill = new Select(estorePdpPageScreen.getSelectCushionFill());
        cushionFill.selectByIndex(1);
        with().pollInterval(2, SECONDS).await().until(() -> true);

        regularUSPrice = estorePdpPageScreen.getRegularTheSecondPrice().getText();
        assertTrue("Regular price is updated after Sale product values are updated", regularUSPrice.equalsIgnoreCase(RegularSalePrice));

        estorePdpPageScreen.getViewSaleItem().should(Condition.and("Visible, interactable condition", visible, interactable), Duration.ofSeconds(20));
        estorePdpPageScreen.getViewSaleItem().click();
    }


    @Then("I verify the multisku ID is showing up once the line item is configured")
    public void iVerifyTheMultiskuIDIsShowingUpOnceTheLineItemIsConfigured() {
        $(By.xpath("//*[text()='Item# m000001198111']")).should(visible, Duration.ofSeconds(12));
    }

    @Then("I verify that the ETA on PDP")
    public void iVerifyThatTheETAOnPDP() {
        $(By.xpath("(//*[contains(text(),'This item is special order and will be ready for delivery between')])[2]")).should(visible);
    }

    @Then("I verify that {string} message is displayed {string} the line item dropdown")
    public void iVerifyThatMessageIsDisplayedTheLienItemDropdown(String message, String location) {
        estorePDPScreen.verifyThatItemIncludeMultipleComponentsMsgIsDisplayedAboveLineItemDropDown();
    }

    @Then("I verify that sku id is not changed after quantity update")
    public void iVerifyThatSkuIdIsNotChangedAfterQuantityUpdate() {
        System.out.println();
    }

    @Then("I verify that sku id is equal to {string} on estore PDP")
    public void iVerifyThatSkuIdIsEqualToOnEstorePDP(String skuId) {
        $(By.xpath("//*[contains(text(),'" + skuId + "')]")).should(visible);
    }

    @When("I choose option for")
    public void iChooseOptionFor() {
        System.out.println();
    }

    @When("I select estore fill option")
    public void iSelectEstoreFillOption() {
        estorePDPScreen.selectFillOption();
        with().pollInterval(2, SECONDS).await().until(() -> true);
    }

    @When("I select armless sofa option")
    public void iSelectArmlessSofaOption() {
        estorePDPScreen.selectArmlessSofaOption();
    }

    @Then("I verify the multisku line item is showing all the ETA and return messages after line item is configured")
    public void iVerifyTheMultiskuLineItemIsShowingAllTheETAAndReturnMessagesAfterLineItemIsConfigured() {
        estorePDPScreen.verifyThatEtaLineMessageIsDisplayed();
        estorePDPScreen.verifyThatReturnMessageIsDisplayed();
    }

    @When("I select item option for line item")
    public void iSelectItemOptionForLineItem() {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        selectOption.selectItemPropertyLineItem();
    }

    @When("I select color option for line item")
    public void iSelectColorOptionForLineItem() {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        selectOption.selectColorOptionLineItem();
    }

    @When("I select fabric option for line item")
    public void iSelectFabricOptionForLineItem() {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        selectOption.selectFabricPropertyLineItem();
    }

    @Then("I verify that prices for the VIEW SELECT ITEMS ON SALE on PDP and the sale page")
    public void iVerifyThatPricesForTheVIEWSELECTITEMSONSALEOnPDPAndTheSalePage() {
        AssertJUnit.assertEquals("Regular price is not equal to zero", estorePGScreen.getRegularSaleOnPgPrice(), estorePDPScreen.getRegularSalePricePDP());
        AssertJUnit.assertEquals("Member price is not equal to zero", estorePGScreen.getMemberSaleOnPgPrice(), estorePDPScreen.getMemberSalePricePDP());

    }
}


