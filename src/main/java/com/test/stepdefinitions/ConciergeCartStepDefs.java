package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.test.pageObject.ConciergeCartPageScreen;
import com.test.pageObject.ConciergeItemsScreen;
import com.test.pageObject.ConciergeUserAccountPage;
import com.test.utility.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.test.stepdefinitions.GeneralStepDefs.sleep;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ConciergeCartStepDefs {
    WebDriver webDriver = Hooks.getWebDriver();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();

    @When("I navigate to the cart page")
    public void iNavigateToTheCartPage() {
        conciergeUserAccountPage.getCartButton().shouldBe(visible, Duration.ofSeconds(25));
        conciergeUserAccountPage.getCartButton().click();
    }

    @Then("I verify that products the following options {string},{string},{string} are in the shopping cart")
    public void iVerifyThatProductsTheFollowingOptionsAreInTheShoppingCart(String productId, String fullSkuId, String quanity) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(conciergeCartPageScreen.getGramTurkishTowel());

        if (fullSkuId.equals("62960714")) {
            assertEquals(conciergeCartPageScreen.getArlesRectangularDinigTableTitle().getText(), "ARLES RECTANGULAR DINING TABLE");
            assertEquals(conciergeCartPageScreen.getArlesRectangularDinigTableId().getText(), "62960714 LGRY");
            System.out.println();
        }
        if (fullSkuId.equals("17050042")) {
            actions.perform();
            assertEquals(conciergeCartPageScreen.getGramTurkishTowel().getText(), "17050042 NGRH");
            assertEquals(conciergeCartPageScreen.getGramTurkishTitle().getText(), "802-GRAM TURKISH TOWEL COLLECTION");
        }
        assertTrue(conciergeCartPageScreen.getQuantityButton().isDisplayed(), "Quantity button is displayed");
    }

    @Then("I verify that cart is displayed")
    public void iVerifyThatCartIsDisplayed() {
        conciergeCartPageScreen.getOrderClassificationSelect().shouldBe(visible, Duration.ofSeconds(15));
        assertTrue(conciergeCartPageScreen.getOrderClassificationSelect().isDisplayed(), "Order classification is displayed");
        assertTrue(conciergeItemsScreen.getCheckoutButton().isDisplayed(), "Checkout button is displayed");

    }

    @When("I click on view cart button")
    public void iClickOnViewCartButton() {
        $(By.xpath("//p[contains(@class,'MuiTypography-h4')]")).shouldHave(text("1 Item  Added To Your Cart"), Duration.ofSeconds(15));
        conciergeItemsScreen.getViewCartButton().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(5));
        conciergeItemsScreen.getViewCartButton().click();
    }
}
