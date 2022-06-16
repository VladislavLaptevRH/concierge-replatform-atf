package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class RhNonProdStepDefs {

    @Given("I log into stgrhnonprod")
    public void iLogIntoStgRhnonprod() {
    }

    @When("I go to item using {string}")
    public void iGoToItemUsing(String arg0) {
        open("https://stg2.rhnonprod.com/catalog/product/product.jsp?productId=" + arg0);
//        $(By.xpath("(//button[@type='button'])[1]")).should(Condition.visible, Duration.ofSeconds(15));
//        $(By.xpath("(//button[@type='button'])[1]")).click();
//        $(By.id("site-search-input")).should(Condition.visible, Duration.ofSeconds(20));
//        $(By.id("site-search-input")).sendKeys(arg0);
//        sleep(2000);
//        $(By.id("site-search-input")).sendKeys(Keys.ENTER);
    }

    @When("I add item to cart")
    public void iAddItemToCart() {
        sleep(10000);
        $(By.id("mount-type")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.id("mount-type")).scrollIntoView(true);
        Select mountType = new Select($(By.id("mount-type")));
        mountType.selectByIndex(1);

        Select width = new Select($(By.id("width-inches")));
        width.selectByIndex(1);

        Select widthInch = new Select($(By.id("width-fraction-gap")));
        widthInch.selectByIndex(1);

        Select lengthInches = new Select($(By.id("length-inches")));
        lengthInches.selectByIndex(1);

        Select lengthGap = new Select($(By.id("length-fraction-gap")));
        lengthGap.selectByIndex(1);

        Select controlType = new Select($(By.id("control-type")));
        controlType.selectByIndex(1);

        Select controlPosition = new Select($(By.id("control-positions")));
        controlPosition.selectByIndex(1);

        Select hardwareFinish = new Select($(By.id("hardware-finish")));
        hardwareFinish.selectByIndex(1);

        $(By.id("roll-type")).scrollIntoView(true);
        Select rollType = new Select($(By.id("roll-type")));
        rollType.selectByIndex(1);

        for (int i = 1; i < 33; i++) {
            sleep(5000);
            $(By.id("room-label")).should(Condition.visible, Duration.ofSeconds(60));
            Select roomLabel = new Select($(By.id("room-label")));
            roomLabel.selectByIndex(i);

            $(By.xpath("//button[@data-testid='add-to-cart-dialog-opener']")).should(Condition.and("", Condition.enabled, Condition.visible), Duration.ofSeconds(60));
            $(By.xpath("//button[@data-testid='add-to-cart-dialog-opener']")).click();

            $(By.id("spo-auth-addToCart")).should(Condition.and("", Condition.enabled, Condition.visible), Duration.ofSeconds(25));
            $(By.id("spo-auth-addToCart")).click();

            $(By.id("ajax-continue-shopping")).should(Condition.and("", Condition.enabled, Condition.visible), Duration.ofSeconds(25));
            $(By.id("ajax-continue-shopping")).click();
        }
    }
}
