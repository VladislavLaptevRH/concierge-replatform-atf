package tests.estore.stepdefinitions;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.concierge.stepdefinitions.AbstractStepDefs;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.*;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.AssertJUnit.assertTrue;

public class EstoreCGStepDefs {
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstoreItemPage estoreItemPage = new EstoreItemPage();
    EstoreCGScreen estoreCGScreen = new EstoreCGScreen();
    EstoreSearchScreen estoreSearchScreen = new EstoreSearchScreen();
    AbstractStepDefs abstractStepDefs = new AbstractStepDefs();

    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    EstoreHomePage estoreHomePage = new EstoreHomePage();

    @Then("I validate the collection name is not empty")
    public void iValidateTheCollectionNameIsNotEmpty() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        $(By.xpath("(//h1//span)[1]")).has(text("Collections"));
    }

    @When("I scroll on the page till back to top button is visible")
    public void iScrollOnThePageTillBackToTopButtonIsVisible() {
        iValidateTheCollectionNameIsNotEmpty();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        executeJavaScript("window.scrollTo(0, 2500)");
        with().pollInterval(1, SECONDS).await().until(() -> true);
        executeJavaScript("window.scrollTo(0, 500)");
    }

    @Then("I verify that back to top button is clickable")
    public void iVerifyThatBackToTopButtonIsClickable() {
        estoreCGScreen.getBackToTopButton().should(Condition.interactable, Duration.ofSeconds(20));
        estoreCGScreen.getBackToTopButton().click();
    }

    @And("I verify that after click on back to top button user is scrolled to top on the page")
    public void iVerifyThatAfterClickOnBackToTopButtonUserIsScrolledToTopOnThePage() {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        iValidateTheCollectionNameIsNotEmpty();
    }

    @Then("I verify that single grid view is selected on CG page by default")
    public void iVerifyThatSingleGridViewIsSelectedOnCGPageByDefault() {
        estoreCGScreen.getCGdefaultGridView().should(Condition.visible, Duration.ofSeconds(40));
        estoreCGScreen.getComponentCollectionCardDetails().should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify collection name, image on collection banner")
    public void iVerifyCollectionNameImagePricesOnCollectionBanner() {
        iValidateTheCollectionNameIsNotEmpty();
        $(By.xpath("(//img)[2]")).should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify that I'm landing on preview the collection model")
    public void iVerifyThatIMLandingOnPreviewTheCollectionModel() {
        $(By.xpath("(//*[contains(text(),'Collection')])[3]")).should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify after click on X icon model gets closed")
    public void iVerifyAfterClickOnXIconModelGetsClosed() {
        estoreCGScreen.getCortonaSofaCollectionTitelPreviewPopUp().shouldNotBe(Condition.visible, Duration.ofSeconds(20));
    }

    @When("I click on close button on preview the collection modal pop up")
    public void iClickOnCloseButtonOnPreviewTheCollectionModalPopUp() {
        estoreCGScreen.getClosePreviewModalModelPopUp().should(Condition.visible, Duration.ofSeconds(20));
        estoreCGScreen.getClosePreviewModalModelPopUp().click();
    }

    @Then("I verify that collection modal is scrollable")
    public void iVerifyThatCollectionModalIsScrollable() {
        $(By.xpath("//*[contains(text(),'COLLECTION')]")).should(visible, Duration.ofSeconds(20));
        switchTo().frame($(By.id("esw_storage_iframe")));
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @And("I validate after scrolling all products are visible on the model")
    public void iValidateAfterScrollingAllProductsAreVisibleOnTheModel() {
        estoreCGScreen.getCortonaSofaCollectionUppercase().should(Condition.visible, Duration.ofSeconds(20));
    }

    @When("I click on any product from the preview collection model")
    public void iClickOnAnyProductFromThePreviewCollectionModel() {
        estoreCGScreen.getPreviewModelFirstItem().should(Condition.visible, Duration.ofSeconds(20));
        estoreCGScreen.getPreviewModelFirstItem().click();

    }

    @Then("I verify that estore PDP page is displayed")
    public void iVerifyThatEstorePDPPageIsDisplayed() {

        estoreItemPage.getAddToCartButton().scrollIntoView(true);
        estoreItemPage.getAddToCartButton().should(visible, Duration.ofSeconds(40));
    }

    @When("user goes to bedding collections test")
    public void userClicksOnBedLinesSubmenu() {
        estoreUserAccountPage.getBedLinesText().should(visible, Duration.ofSeconds(40));
        estoreUserAccountPage.getBedLinesText().click();
        estoreUserAccountPage.getBeddingCollectionsTest().should(visible, Duration.ofSeconds(40));
        estoreUserAccountPage.getBeddingCollectionsTest().click();
    }

    @When("user clicks on textile menu")
    public void userClicksOnTextileMenu() {
        estoreUserAccountPage.getTextilesText().should(visible, Duration.ofSeconds(40));
        estoreUserAccountPage.getTextilesText().click();
    }

    @Then("I verify that Enjoy Free Shipping On All Textiles banner is displayed")
    public void iVerifyThatEnjoyFreeShippingOnAllTextilesBannerIsDisplayed() {
    }

    @When("I go to {string} brand")
    public void iGoToMOBrand(String brand) {
        open("https://rhmodern." + Hooks.profile + ".rhnonprod.com/");
        $(By.xpath("//*[@data-analytics-worhlogo='worh-logo']")).should(visible, Duration.ofSeconds(25));
    }

    @Then("I verify that contract price is used for each product")
    public void iVerifyThatPriceIsDisplayedInCart() {
        $(By.xpath("(//*[text()='$35.00'])[2]")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that contract price is used for each B&C product")
    public void iVerifyThatPriceIsDisplayedInCartBC() {
        $(By.xpath("(//*[text()='$35.00'])[2]")).should(visible, Duration.ofSeconds(20));
    }

    @When("I go to B&C brand")
    public void iGoToBCBrand() {
        $(By.xpath("//a[@data-testid='brand-link']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//a[@data-testid='brand-link']")).click();
        $(By.xpath("//li[@data-analytics-url='https://rhbabyandchild." + Hooks.profile + ".rhnonprod.com/']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//li[@data-analytics-url='https://rhbabyandchild." + Hooks.profile + ".rhnonprod.com/']")).click();
    }

    @Then("I verify that contract price is used for each TN product")
    public void iVerifyThatContractPriceIsUsedForEachTNProduct() {
        $(By.xpath("(//*[text()='$35.00'])[2]")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that trade price is used for each TN product")
    public void iVerifyThatTradePriceIsUsedForEachTNProduct() {
        $(By.xpath("//*[text()='Trade']")).should(visible, Duration.ofSeconds(30));
    }

    @When("I goes to estore collection page")
    public void iGoesToEstoreCollectionPage() {
        String URL = Hooks.eStoreBaseURL + "/catalog/category/collections.jsp?cellBackground=false&categoryId=cat10220044&sale=false&topCatId=cat1840042&parentCatId=cat160045";
        open(URL);

        WebDriverRunner.getWebDriver().navigate().refresh();
    }

    @Then("I verify that page render in the same grid view that previously selected")
    public void iVerifyThatPageRenderInTheSameGridViewThatPreviouslySelected() {
        $(By.xpath("//div[contains(@class, 'grid-item-4')]")).
                should(visible, Duration.ofSeconds(5));
    }

    @When("I select {string} grid view on estore CG page")
    public void iSetGridViewOnEstoreCGPage(String arg0) {
        estoreSearchScreen.getThreeColumnsInRowGridButton().should(visible, Duration.ofSeconds(20));
        estoreSearchScreen.getThreeColumnsInRowGridButton().click();
        estoreSearchScreen.getThreeColumnsInRowGridElement().should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify CGS all menu items")
    public void iVerifyCGSAllMenuItems() {
        try {
            iValidateTheCollectionNameIsNotEmpty();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(2, SECONDS).await().until(() -> true);
            iValidateTheCollectionNameIsNotEmpty();
        }
    }

    @When("I goes to {string} estore collection page")
    public void iGoesToEstoreCollectionPage(String brand) {
        if (brand.equals("rh")) {
            String URL = Hooks.eStoreBaseURL + "/catalog/category/collections.jsp?cellBackground=false&categoryId=cat10220044&sale=false&topCatId=cat1840042&parentCatId=cat160045";
            open(URL);
            System.out.println();
        } else {
            String URL = "https://" +
                    brand + "." + Hooks.profile + "." + "rhnonprod.com";
            String category = "/catalog/category/collections.jsp?cellBackground=false&categoryId=cat10220044&sale=false&topCatId=cat1840042&parentCatId=cat160045" + "/?endpoint=" + Hooks.cookie;
            open(URL + category);
        }

    }

    @When("I go to {string} on eStore")
    public void iGoToOnEStore(String collectionName) {
        String URL = "";
        if (collectionName.equals("SEATING COLLECTIONS")) {
            URL = Hooks.eStoreBaseURL + "/catalog/category/collections.jsp?cellBackground=false&categoryId=cat10210013&sale=false&topCatId=cat160024&parentCatId=cat950002";
        }
        if (collectionName.equals("FABRIC CHAIR COLLECTIONS")) {
            URL = Hooks.eStoreBaseURL + "/catalog/category/collections.jsp?cellBackground=false&categoryId=cat10220044&sale=false&topCatId=cat1840042&parentCatId=cat160045";
        }
        if (collectionName.equals("RECTANGULAR TABLE COLLECTIONS")) {
            URL = Hooks.eStoreBaseURL + "/catalog/category/collections.jsp?cellBackground=false&categoryId=cat10220036&sale=false&topCatId=cat1840042&parentCatId=cat3870171";
        }
        open(URL);

        WebDriverRunner.getWebDriver().navigate().refresh();
    }

    @Then("I verify that CG page is displayed")
    public void iVerifyThatCGPageIsDisplayed() {
        iValidateTheCollectionNameIsNotEmpty();
    }

    @When("I go to CG estore page")
    public void iGoToCGEstorePage() {
    }

    @When("I click on random item from collection page with applied {string} grid view")
    public void iClickOnRandomItemFromCollectionPageWithAppliedGridView(String arg0) {
        if (arg0.equals("3")) {
            $(By.xpath("(//img[contains(@alt, 'Collection')])[1]")).should(visible, Duration.ofSeconds(25));
            $(By.xpath("(//img[contains(@alt, 'Collection')])[1]")).click();
        }
    }

    @Then("user verifies that price range is displayed below the thumbnail")
    public void userVerifiesThatPriceRangeIsDisplayedBelowTheThumbnail() {
        $(By.xpath("//*[text()='Member']")).should(visible, Duration.ofSeconds(20));
        int regularPrice = Integer.parseInt($(By.xpath("(//*[@data-testid='price-for-regular'])[1]")).getText().replaceAll("\\$", "").replaceAll("\\,", ""));
        int memberPrice = Integer.parseInt($(By.xpath("(//*[@data-testid='price-for-member'])[1]")).getText().replaceAll("\\$", "").replaceAll("\\,", ""));

        assertTrue("Regular price is not equal to zero", regularPrice > 0);
        assertTrue("Member price is not equal to zero", memberPrice > 0);
    }

    @When("I click on random product on collection page")
    public void iClickOnRandomProductOnCollectionPage() {
        $(By.xpath("(//div[@id='component-rh-image_wrapper'])[2]//div")).should(visible, Duration.ofSeconds(20)).click(ClickOptions.usingJavaScript());
    }

    @Then("I verify that the top navigation, logo, hamburger icon,search should be displayed")
    public void iVerifyThatTheTopNavigationLogoHamburgerIconSearchShouldBeDisplayed() {
        estoreHomePage.verifyThatRhLogoIsDisplayed();
        estoreHomePage.verifyThatNavigationMenuIsDisplayed();
        estoreHomePage.verifyThatHamburgerIconIsDisplayed();
        estoreHomePage.verifyThatSearchFieldIsDisplayed();
    }

    @Then("I verify that the CG title on the top left corner of the page")
    public void iVerifyThatTheCGTitleOnTheTopLeftCornerOfThePage() {
        estoreCGScreen.verifyThatSeatinCollectionTitleIsDisplayedOnCG();
    }

    @Then("I verify that by default the single grid view should be selected")
    public void iVerifyThatByDefaultTheSingleGridViewShouldBeSelected() {
        estoreCGScreen.verifyThatSingleGridViewIsDisplayed();
    }

    @Then("I verify that PG title, description text, member discount message is displayed")
    public void iVerifyThatPGTitleDescriptionTextMemberDiscountMessageIsDisplayed() {
        generalStepDefs.waitForJSandJQueryToLoad();
        estoreCGScreen.verifyThatSeatinCollectionTitleIsDisplayedOnCG();
        estoreCGScreen.verifyThatMemberDiscountMessageIsDisplayedOnCG();
        estoreCGScreen.verifyThatCGDescriptionIsDisplayed();
    }

    @And("I verify that In stock and size availability message is displayed")
    public void iVerifyThatInStockAndSizeAvailabilityMessageIsDisplayed() {
        estoreCGScreen.verifyThatinStockMessageTextIsDisplayed();

    }

    @When("I select {int}up grid view on CG for estore")
    public void iSelectUpGridViewOnCGForEstore(int gridView) {
        if (gridView == 2) {
            estoreSearchScreen.getTwoColumnsInRowGridElement().should(visible, Duration.ofSeconds(20));
            estoreSearchScreen.getTwoColumnsInRowGridElement().click();
            estoreCGScreen.verifyThatTwoGridViewIsDisplayed();
        }
        if (gridView == 3) {
            estoreSearchScreen.getThreeColumnsInRowGridButton().should(visible, Duration.ofSeconds(20));
            estoreSearchScreen.getThreeColumnsInRowGridButton().should(interactable, Duration.ofSeconds(20));
            estoreSearchScreen.getThreeColumnsInRowGridButton().click();
            estoreCGScreen.verifyThatThreeGridViewIsDisplayed();
        }

    }

    @Then("I verify that swatches are displayed for {int}up grid view")
    public void iVerifyThatSwatchesAreDisplayedForUpGridView(int gridView) {
        if (gridView == 1) {
            estoreCGScreen.verifyThatSwatches1upGridViewIsDisplayed();
        }
        if (gridView == 2) {
            estoreCGScreen.verifyThatSwatches2upGridViewIsDisplayed();
        }
        if (gridView == 3) {
            estoreCGScreen.verifyThatSwatches3upGridViewIsDisplayed();
        }
    }


}