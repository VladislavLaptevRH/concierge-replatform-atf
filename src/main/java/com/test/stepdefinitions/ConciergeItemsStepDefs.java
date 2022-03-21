package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.test.pageObject.SelectOption;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;


public class ConciergeItemsStepDefs {
    SelectOption selectOption = new SelectOption();

    @When("I select debth option")
    public void iSelectDebthProperty() {
        try {
            sleep(2000);
            selectOption.getDepthProperty().shouldBe(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select selectDepth = new Select(selectOption.getDepthProperty());
            selectDepth.selectByIndex(1);

        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
        sleep(2000);

    }

    @When("I select fabric option")
    public void iSelectFabricProperty() {
        try {
            sleep(2000);
            selectOption.getFabricProperty().shouldBe(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select selectFabric = new Select(selectOption.getFabricProperty());
            selectFabric.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
        sleep(2000);

    }

    @When("I select color option")
    public void iSelectColorOption() {
        sleep(2000);
        try {
            selectOption.getColorOption().shouldBe(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select selectFabric = new Select(selectOption.getColorOption());
            selectFabric.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
    }
}
