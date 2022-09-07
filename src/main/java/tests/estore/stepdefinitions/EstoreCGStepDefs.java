package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.estore.pageObject.EstoreCGScreen;
import tests.estore.pageObject.EstoreItemPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class EstoreCGStepDefs {

    EstoreItemPage estoreItemPage = new EstoreItemPage();
    EstoreCGScreen estoreCGScreen = new EstoreCGScreen();

    @Then("I validate the collection name is not empty")
    public void iValidateTheCollectionNameIsNotEmpty() {
        estoreCGScreen.getSofaCollections().should(Condition.visible, Duration.ofSeconds(20));
    }

    @When("I scroll on the page till back to top button is visible")
    public void iScrollOnThePageTillBackToTopButtonIsVisible() {
        estoreCGScreen.getSofaCollections().should(Condition.visible, Duration.ofSeconds(20));
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Then("I verify that back to top button is clickable")
    public void iVerifyThatBackToTopButtonIsClickable() {
        estoreCGScreen.getBackToTopButton().should(Condition.visible, Duration.ofSeconds(20));
        estoreCGScreen.getBackToTopButton().click();
    }

    @And("I verify that after click on back to top button user is scrolled to top on the page")
    public void iVerifyThatAfterClickOnBackToTopButtonUserIsScrolledToTopOnThePage() {
        estoreCGScreen.getSofaCollections().should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify that single grid view is selected on CG page by default")
    public void iVerifyThatSingleGridViewIsSelectedOnCGPageByDefault() {
        estoreCGScreen.getCGdefaultGridView().should(Condition.visible, Duration.ofSeconds(20));
        estoreCGScreen.getComponentCollectionCardDetails().should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify collection name, image, prices on collection banner")
    public void iVerifyCollectionNameImagePricesOnCollectionBanner() {
        $(By.xpath("//*[text()='9595']")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()=' Regular /']")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='7196']")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()=' Member']")).should(Condition.visible, Duration.ofSeconds(20));
        estoreCGScreen.getSofaCollections().should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//img[@alt='Cortona Sofa Collection']")).should(Condition.visible, Duration.ofSeconds(20));
    }

    @When("I click on preview the collection link")
    public void iClickOnPreviewTheCollectionLink() {
        estoreCGScreen.getPreviewTheCollectionButton().should(Condition.visible, Duration.ofSeconds(20));
        estoreCGScreen.getPreviewTheCollectionButton().click();
    }

    @Then("I verify that I'm landing on preview the collection model")
    public void iVerifyThatIMLandingOnPreviewTheCollectionModel() {
        estoreCGScreen.getCortonaSofaCollectionTitelPreviewPopUp().should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify after click on X icon model gets closed")
    public void iVerifyAfterClickOnXIconModelGetsClosed() {
        estoreCGScreen.getCortonaSofaCollectionTitelPreviewPopUp().shouldNotBe(Condition.visible, Duration.ofSeconds(20));

    }

    @When("I click on close button on preview the collection modal pop up")
    public void iClickOnCloseButtonOnPreviewTheCollectionModalPopUp() {
        estoreCGScreen.getClosePreviewModalModelPopUp().should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify that collection modal is scrollable")
    public void iVerifyThatCollectionModalIsScrollable() {
        estoreCGScreen.getCortonaSofaCollectionTitelPreviewPopUp().should(Condition.visible, Duration.ofSeconds(20));
        switchTo().frame($(By.id("esw_storage_iframe")));
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @And("I validate after scrolling all products are visible on the model")
    public void iValidateAfterScrollingAllProductsAreVisibleOnTheModel() {
//        estoreCGScreen.getPreviewTheCollectionLastItem().should(Condition.visible, Duration.ofSeconds(20));

        $(By.xpath("//*[text()='CORTONA SOFA COLLECTION']")).should(Condition.visible, Duration.ofSeconds(20));
//        estoreCGScreen.getCortonaOttomanText().should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify product image, name and prices are visible for each product on the model")
    public void iVerifyProductImageNameAndPricesAreVisibleForEachProductOnTheModel() {
        $(By.xpath("//*[text()='Cortona Sofaa']")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//p[@data-testid='price-for-regular']")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//p[@data-testid='price-for-member']")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//div[@data-cmp='cardImages']//div[@id='component-rh-image_wrapper']")).should(Condition.visible, Duration.ofSeconds(20));
    }

    @When("I click on any product from the preview collection model")
    public void iClickOnAnyProductFromThePreviewCollectionModel() {
        estoreCGScreen.getPreviewModelFirstItem().should(Condition.visible, Duration.ofSeconds(20));
        estoreCGScreen.getPreviewModelFirstItem().click();

    }

    @Then("I verify that estore PDP page is displayed")
    public void iVerifyThatEstorePDPPageIsDisplayed() {

        estoreItemPage.getAddToCartButton().scrollIntoView(true);
        estoreItemPage.getAddToCartButton().should(visible, Duration.ofSeconds(20));
    }
}
