package tests.estore.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.estore.pageObject.EstoreItemPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class EstoreWishlistStepDefs {

    EstoreItemPage estoreItemPage = new EstoreItemPage();

    @Then("I validate items in wishlist")
    public void iValidateItemsInWishlist() {
        sleep(3000);
//        estoreWishlistPage.getWhistItem().should(visible,Duration.ofSeconds(30));
    }


    @When("I click on add to wishlist button")
    public void iClickOnAddToWishlistButton() {
//        generalStepDefs.waitForJSandJQueryToLoad();
//        sleep(3000);
//        estoreItemPage.getAddToWishListButton().scrollIntoView(true);
//        sleep(3000);
//        estoreItemPage.getAddToWishListButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(30));
//        estoreItemPage.getAddToWishListButton().click();
//
//        estoreItemPage.getViewWishlistButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(30));
//        estoreItemPage.getViewWishlistButton().click();
    }

    @Then("I validate member price in wishlist")
    public void iValidateMemberPriceInWishlist() {
        sleep(2000);
//        assertTrue(estoreWishlistPage.getMemberPrice().exists());
    }

    @When("I click on view wishlist button")
    public void iClickOnViewWishlistButton() {
        estoreItemPage.getViewWishlistButton().should(visible,Duration.ofSeconds(20));
        estoreItemPage.getViewWishlistButton().click();
    }
}
