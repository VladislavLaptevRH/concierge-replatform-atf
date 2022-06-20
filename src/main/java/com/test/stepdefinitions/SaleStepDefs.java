package com.test.stepdefinitions;

import com.test.pageObject.SaleScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.testng.Assert.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<String> items = new ArrayList<>();
        List<String> expectedItems = new ArrayList(Arrays.asList("Living", "Dining", "Bed", "Bath", "Lighting", "Textiles", "Rugs", "Windows", "Décor", "Art", "Outdoor"));
        for (int i = 0; i < saleScreen.getListOfNavigationBars().size(); i++) {
            items = new ArrayList(Arrays.asList(saleScreen.getListOfNavigationBars().get(i).getText()));
        }
        GeneralStepDefs.compareList(expectedItems, items);
    }
}
