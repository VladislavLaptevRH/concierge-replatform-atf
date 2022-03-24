package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.test.pageObject.SelectOption;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


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

    @When("I click on collections item")
    public void iClickOnCollectionsItem() {
        try {
            $(By.xpath("//*[text()='collections']")).shouldHave(text("collections"), Duration.ofMinutes(1));
            $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12'][1]/li")).click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Collection section is not displayed");
        }
    }
}
