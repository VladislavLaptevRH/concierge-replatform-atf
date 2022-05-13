package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.test.pageObject.ConciergeItemsScreen;
import com.test.pageObject.SelectOption;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class ConciergeItemsStepDefs {
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    SelectOption selectOption = new SelectOption();

    @When("I select debth option")
    public void iSelectDebthProperty() {
        try {
            sleep(3000);
            executeJavaScript("window.scrollTo(0, 970)");
            sleep(5000);
            selectOption.getDepthProperty().should(Condition.and("", appear, enabled), Duration.ofSeconds(20));
            selectOption.getDepthProperty().shouldBe(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select selectDepth = new Select(selectOption.getDepthProperty());
            sleep(3000);
            selectDepth.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
        sleep(2000);

    }

    @When("I select fabric option")
    public void iSelectFabricProperty() {
        try {
            sleep(4000);
            selectOption.getFabricProperty().should(appear, Duration.ofSeconds(15));
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
        sleep(8000);
        try {
            selectOption.getColorOption().should(Condition.and("", appear, enabled), Duration.ofSeconds(20));
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
            conciergeItemsScreen.getCollectionsText().shouldHave(text("collections"), Duration.ofMinutes(1));
            sleep(3000);
            conciergeItemsScreen.getCollectionItem().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Collection section is not displayed");
        }
    }

    @When("I click on add monogram checkbox")
    public void iClickOnAddMonogramCheckbox() {
        sleep(7000);
        conciergeItemsScreen.getAddMonogramCheckBox().click();
    }

    @When("I choose monogram properties")
    public void iChooseMonogramProperties() {
        sleep(5000);
        $(By.xpath("(//ul[@class='MuiGridList-root'])[1]//li[@class='MuiGridListTile-root'][2]")).shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("(//ul[@class='MuiGridList-root'])[1]//li[@class='MuiGridListTile-root'][2]")).click();

        $(By.xpath("(//ul[@class='MuiGridList-root'])[2]//li[@class='MuiGridListTile-root'][2]")).shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("(//ul[@class='MuiGridList-root'])[2]//li[@class='MuiGridListTile-root'][2]")).click();

        $(By.xpath("//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-formControl']//input")).setValue("test");

        $(By.xpath("//*[text()='add monogram']")).click();
    }
}
