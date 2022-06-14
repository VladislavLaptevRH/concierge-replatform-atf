package com.test.stepdefinitions;

import com.test.pageObject.ConciergeCartPageScreen;
import com.test.pageObject.ConciergeItemsScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Pdp {
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();

    @When("I click on add monogram checkbox from pdp")
    public void iClickOnAddMonogramCheckboxFromPdp() {
        sleep(3000);
        conciergeItemsScreen.getAddMonogramCheckBoxPdp().click();
    }

    @When("I choose monogram properties for pdp")
    public void iChooseMonogramPropertiesForPdp() {
//        conciergeCartPageScreen.getMonogramColors().get(2).should(visible, Duration.ofMinutes(1));
        sleep(3000);
        conciergeCartPageScreen.getMonogramColors().get(2).scrollIntoView(true);
        conciergeCartPageScreen.getMonogramColors().get(2).click();
//        conciergeItemsScreen.getMonogramColorChampagne().should(visible, Duration.ofSeconds(20));
        sleep(2000);
        conciergeItemsScreen.getMonogramColorChampagne().scrollIntoView(true);
        conciergeItemsScreen.getMonogramColorChampagne().click();
        conciergeCartPageScreen.getMonogramText().setValue("test");
        conciergeCartPageScreen.getAddMonogramButton().click();
    }

    @Then("I verify that monogram was added for pdp")
    public void iVerifyThatMonogramWasAddedForPdp() {
        $(By.xpath("//*[text()='Bauer Bodoni 1 (BDNI-HC)']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Text']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Style']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Color']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='MCHA']")).should(visible, Duration.ofSeconds(20));
    }

    @When("I click on view in stock items")
    public void iClickOnViewInStockItems() {
        $(By.xpath("//*[text()='In-Stock']")).shouldHave(text("In-Stock"), Duration.ofSeconds(20));
        $(By.xpath("//*[text()='In-Stock']")).scrollIntoView(true);
        $(By.xpath("//*[text()='In-Stock']")).click();
    }

    @Then("I verify that in stock modal pop up is displayed")
    public void iVerifyThatInStockModalPopUpIsDisplayed() {
        $(By.xpath("//*[text()='IN STOCK']")).shouldHave(text("IN STOCK"), Duration.ofSeconds(15));
        $(By.xpath("//*[text()='These options are available for']")).shouldBe(visible, Duration.ofSeconds(15));
    }

    @When("I click on view sale items")
    public void iClickOnViewSaleItems() {
        $(By.xpath("//*[text()='Sale']")).shouldHave(text("Sale"), Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Sale']")).scrollIntoView(true);
        $(By.xpath("//*[text()='Sale']")).click();
    }

    @Then("I verify that on sale modal pop up is displayed")
    public void iVerifyThatOnSaleModalPopUpIsDisplayed() {
        $(By.xpath("//*[text()='ON SALE']")).shouldHave(text("ON SALE"), Duration.ofSeconds(20));
    }
}
