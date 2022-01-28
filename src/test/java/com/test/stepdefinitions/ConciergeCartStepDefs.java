package com.test.stepdefinitions;

import com.test.pageObject.ConciergeCartPageScreen;
import com.test.pageObject.ConciergeUserAccountPage;
import com.test.utility.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class ConciergeCartStepDefs {
    WebDriver webDriver = Hooks.getWebDriver();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen(webDriver);
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage(webDriver);
    WebDriverWait wait = new WebDriverWait(webDriver, 10);


    @When("I navigate to the cart page")
    public void iNavigateToTheCartPage() {
        wait.until(ExpectedConditions.visibilityOf(conciergeUserAccountPage.getCartButton()));
        conciergeUserAccountPage.getCartButton().click();
    }

    @Then("I verify that products the following options {string},{string},{string} are in the shopping cart")
    public void iVerifyThatProductsTheFollowingOptionsAreInTheShoppingCart(String productId, String fullSkuId, String quanity) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(conciergeCartPageScreen.getGramTurkishTowel());


        if (fullSkuId.equals("62960714")) {
            assertTrue(conciergeCartPageScreen.getArlesRectangularDinigTableTitle().getText().equals("ARLES RECTANGULAR DINING TABLE"));
            assertTrue(conciergeCartPageScreen.getArlesRectangularDinigTableId().getText().equals("62960714 LGRY"));
            System.out.println();
        }
        if (fullSkuId.equals("17050042")) {
            actions.perform();
            assertTrue(conciergeCartPageScreen.getGramTurkishTowel().getText().equals("17050042 NGRH"));
            assertTrue(conciergeCartPageScreen.getGramTurkishTitle().getText().equals("802-GRAM TURKISH TOWEL COLLECTION"));
        }
        conciergeCartPageScreen.getQuantityButton().isDisplayed();
    }
}
