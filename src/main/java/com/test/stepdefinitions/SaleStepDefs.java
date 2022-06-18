package com.test.stepdefinitions;

import com.test.pageObject.SaleScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.testng.Assert.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class SaleStepDefs {
    SaleScreen saleScreen = new SaleScreen();

    @When("I click on sale")
    public void iClickOnSale() {
        saleScreen.getSaleOption().should(visible, Duration.ofMinutes(1));
        saleScreen.getSaleOption().click();
    }

    @Then ("I verify sale navigation bars are displayed")
    public void iVerifySaleNavigationBarsAreDisplayed () {
        assertTrue(saleScreen.getListOfNavigationBars().size() > 0, "Navigation bars are displayed");
    }
}
