package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.test.pageObject.ConciergeItemsScreen;
import com.test.pageObject.SelectOption;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class ConciergeItemsStepDefs {
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    SelectOption selectOption = new SelectOption();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    @When("I select debth option")
    public void iSelectDebthProperty() {
        generalStepDefs.waitForLoad(WebDriverRunner.getWebDriver());
        try {
            executeJavaScript("window.scrollTo(0, 970)");
            selectOption.getDepthProperty().should(Condition.and("", appear, enabled), Duration.ofSeconds(20));
            selectOption.getDepthProperty().should(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select selectDepth = new Select(selectOption.getDepthProperty());

            selectDepth.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
    }

    @When("I select fabric option")
    public void iSelectFabricProperty() {
        generalStepDefs.waitForLoad(WebDriverRunner.getWebDriver());
        try {
            selectOption.getFabricProperty().should(appear, Duration.ofSeconds(15));
            selectOption.getFabricProperty().should(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select selectFabric = new Select(selectOption.getFabricProperty());
            selectFabric.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
    }

    @When("I select color option")
    public void iSelectColorOption() {
        generalStepDefs.waitForLoad(WebDriverRunner.getWebDriver());
        try {
            selectOption.getColorOption().should(Condition.and("", appear, enabled), Duration.ofSeconds(20));
            selectOption.getColorOption().should(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select selectFabric = new Select(selectOption.getColorOption());
            selectFabric.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
    }

    @When("I click on collections item")
    public void iClickOnCollectionsItem() {
        generalStepDefs.waitForLoad(WebDriverRunner.getWebDriver());
        try {
            conciergeItemsScreen.getCollectionsText().shouldHave(text("collections"), Duration.ofMinutes(1));
            conciergeItemsScreen.getCollectionItem().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Collection section is not displayed");
        }
    }
}
