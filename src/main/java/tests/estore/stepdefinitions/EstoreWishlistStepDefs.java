package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.estore.pageObject.EstoreItemPage;
import tests.estore.pageObject.EstoreWishlistPage;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.AssertJUnit.assertTrue;

public class EstoreWishlistStepDefs {

    EstoreItemPage estoreItemPage = new EstoreItemPage();
    EstoreWishlistPage estoreWishlistPage = new EstoreWishlistPage();
    EstoreGeneralStepDefs estoreGeneralStepDefs = new EstoreGeneralStepDefs();

    @Then("I validate items in wishlist")
    public void iValidateItemsInWishlist() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        estoreWishlistPage.getWhistItem().should(visible, Duration.ofSeconds(30));
    }

    @When("I click on add to wishlist button")
    public void iClickOnAddToWishlistButton() {
        estoreGeneralStepDefs.waitForJSandJQueryToLoad();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        estoreItemPage.getAddToWishListButton().scrollIntoView(true);
        with().pollInterval(3, SECONDS).await().until(() -> true);
        estoreItemPage.getAddToWishListButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(30));
        estoreItemPage.getAddToWishListButton().click();

        estoreItemPage.getViewWishlistButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(30));
        estoreItemPage.getViewWishlistButton().click();
    }

    @Then("I validate member price in wishlist")
    public void iValidateMemberPriceInWishlist() {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        assertTrue(estoreWishlistPage.getMemberPrice().exists());
    }

    @When("I click on view wishlist button")
    public void iClickOnViewWishlistButton() {
        if (Hooks.cookie.equals("contentfix")) {
            $(By.xpath("//*[text()='VIEW WISHLIST']")).should(visible, Duration.ofSeconds(30));
            $(By.xpath("//*[text()='VIEW WISHLIST']")).click();
        } else {
            estoreItemPage.getViewWishlistButton().should(visible, Duration.ofSeconds(20));
            estoreItemPage.getViewWishlistButton().click();
        }
    }

}