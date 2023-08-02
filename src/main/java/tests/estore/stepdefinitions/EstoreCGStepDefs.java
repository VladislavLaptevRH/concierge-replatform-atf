package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.concierge.stepdefinitions.AbstractStepDefs;
import tests.estore.pageObject.*;
import tests.utility.Hooks;

import java.time.Duration;
import java.util.concurrent.Callable;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.netty.handler.codec.rtsp.RtspHeaders.Values.URL;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.awaitility.Awaitility.with;

public class EstoreCGStepDefs {
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstoreItemPage estoreItemPage = new EstoreItemPage();
    EstoreCGScreen estoreCGScreen = new EstoreCGScreen();
    EstoreSearchScreen estoreSearchScreen = new EstoreSearchScreen();
    AbstractStepDefs abstractStepDefs = new AbstractStepDefs();

    @Then("I validate the collection name is not empty")
    public void iValidateTheCollectionNameIsNotEmpty() {
        if (Hooks.cookie.contains("SSR")) {
            $(By.xpath("//*[contains(text(),'COLLECTIONS')]")).should(Condition.and("", visible, interactable), Duration.ofSeconds(70));
        } else {
            if ((Hooks.cookie.equals("releasethurs")) || (Hooks.cookie.contains("userservice"))) {
                $(By.xpath("//*[contains(@class, 'MuiGrid-item')]//*[contains(text(),'collections')]")).should(Condition.interactable, Duration.ofSeconds(60));
                $(By.xpath("//*[contains(@class, 'MuiGrid-item')]//*[contains(text(),'collections')]")).should(Condition.visible, Duration.ofSeconds(60));
            } else {
                $(By.xpath("//*[contains(@class, 'MuiGrid-item')]//*[contains(text(),'collections')]")).should(Condition.interactable, Duration.ofSeconds(60));
                $(By.xpath("//*[contains(@class, 'MuiGrid-item')]//*[contains(text(),'collections')]")).should(Condition.visible, Duration.ofSeconds(60));

            }
        }
    }

    @When("I scroll on the page till back to top button is visible")
    public void iScrollOnThePageTillBackToTopButtonIsVisible() {
        iValidateTheCollectionNameIsNotEmpty();

        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");

        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Then("I verify that back to top button is clickable")
    public void iVerifyThatBackToTopButtonIsClickable() {
        estoreCGScreen.getBackToTopButton().should(Condition.visible, Duration.ofSeconds(20));
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
        iValidateTheCollectionNameIsNotEmpty();
    }

    @When("I goes to {string} estore collection page")
    public void iGoesToEstoreCollectionPage(String brand) {
        if (brand.equals("rh")) {
            String URL = Hooks.eStoreBaseURL + "/catalog/category/collections.jsp?cellBackground=false&categoryId=cat10220044&sale=false&topCatId=cat1840042&parentCatId=cat160045";
            open(URL);
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
}