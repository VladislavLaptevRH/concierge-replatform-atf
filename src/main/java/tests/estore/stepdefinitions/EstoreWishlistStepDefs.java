package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.estore.pageObject.EstoreItemPage;
import tests.estore.pageObject.EstoreWishlistPage;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.Assert.assertTrue;

public class EstoreWishlistStepDefs {

    EstoreWishlistPage estoreWishlistPage = new EstoreWishlistPage();
    EstoreGeneralStepDefs generalStepDefs = new EstoreGeneralStepDefs();
    EstoreItemPage estoreItemPage = new EstoreItemPage();

    @Then("I validate items in wishlist")
    public void iValidateItemsInWishlist() {
        sleep(3000);
        assertTrue(estoreWishlistPage.getWhistItem().exists());
    }


    @When("I click on add to wishlist button")
    public void iClickOnAddToWishlistButton() {
        generalStepDefs.waitForJSandJQueryToLoad();
        estoreItemPage.getAddToWishListButton().scrollIntoView(true);
        estoreItemPage.getAddToWishListButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(30));
        estoreItemPage.getAddToWishListButton().click();

        estoreItemPage.getViewWishlistButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(30));
        estoreItemPage.getViewWishlistButton().click();
    }

    @Then("I validate member price in wishlist")
    public void iValidateMemberPriceInWishlist() {
        sleep(2000);
        assertTrue(estoreWishlistPage.getMemberPrice().exists());
    }
}
