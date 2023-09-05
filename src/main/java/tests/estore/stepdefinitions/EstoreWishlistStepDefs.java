package tests.estore.stepdefinitions;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.estore.pageObject.EstoreItemPage;
import tests.estore.pageObject.EstoreWishlistPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static org.testng.AssertJUnit.assertTrue;

public class EstoreWishlistStepDefs {

    EstoreItemPage estoreItemPage = new EstoreItemPage();
    EstoreWishlistPage estoreWishlistPage = new EstoreWishlistPage();
    EstoreGeneralStepDefs estoreGeneralStepDefs = new EstoreGeneralStepDefs();

    @Then("I validate items in wishlist")
    public void iValidateItemsInWishlist() {
        estoreWishlistPage.getWhistItem().should(visible, Duration.ofSeconds(30));
    }

    @When("I click on add to wishlist button")
    public void iClickOnAddToWishlistButton() {
        estoreGeneralStepDefs.waitForJSandJQueryToLoad();

        estoreItemPage.getAddToWishListButton().scrollIntoView(true);

        estoreItemPage.getAddToWishListButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(40));
        estoreItemPage.getAddToWishListButton().click();

        estoreItemPage.getViewWishlistButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(40));
        estoreItemPage.getViewWishlistButton().click(ClickOptions.usingJavaScript());
    }

    @Then("I validate member price in wishlist")
    public void iValidateMemberPriceInWishlist() {

        assertTrue(estoreWishlistPage.getMemberPrice().exists());
    }

    @When("I click on view wishlist button")
    public void iClickOnViewWishlistButton() {
        estoreItemPage.getViewWishlistButton().should(Condition.and("Visible, interactable condition", visible, interactable), Duration.ofSeconds(20));
        estoreItemPage.getViewWishlistButton().click(ClickOptions.usingJavaScript());
    }

    @Then("I verify that I'm able to remove wishlist from cart")
    public void iVerifyThatIMAbleToRemoveWishlistFromCart() {
        estoreWishlistPage.getRemoveButtonWishList().should(visible, Duration.ofSeconds(20));
        estoreWishlistPage.getRemoveButtonWishList().click();
    }
}
