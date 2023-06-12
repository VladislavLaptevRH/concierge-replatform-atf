package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import tests.concierge.pageObject.ConciergeItemsScreen;
import tests.concierge.pageObject.SelectOption;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;


public class ConciergeItemsStepDefs {
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    SelectOption selectOption = new SelectOption();

    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    @When("I select depth option")
    public void iSelectDepthProperty() {
        with().pollInterval(8, SECONDS).await().until(() -> true);
        generalStepDefs.waitForJSandJQueryToLoad();
        if(!selectOption.getDepthProperty().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
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
        with().pollInterval(8, SECONDS).await().until(() -> true);
        if(!selectOption.getFabricProperty().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        generalStepDefs.waitForJSandJQueryToLoad();
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
        generalStepDefs.waitForJSandJQueryToLoad();
        with().pollInterval(5, SECONDS).await().until(() -> true);
//        if(!selectOption.getColorOption().isDisplayed()){
//            WebDriverRunner.getWebDriver().navigate().refresh();
//            with().pollInterval(5, SECONDS).await().until(() -> true);
//        }
//        try {
        if(conciergeItemsScreen.getSelectSize().isDisplayed()) {
            conciergeItemsScreen.getSelectSize().should(Condition.and("", appear, enabled), Duration.ofSeconds(20));
            conciergeItemsScreen.getSelectSize().should(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select sizeList = new Select(conciergeItemsScreen.getSelectSize());
            sizeList.selectByIndex(1);
            with().pollInterval(2, SECONDS).await().until(() -> true);
//        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
//            System.out.println("Element not found");
//        }
        }
//        try {
        if(selectOption.getColorOption().isDisplayed()) {
            Select selectColor = new Select(selectOption.getColorOption());
            selectColor.selectByIndex(1);
            with().pollInterval(2, SECONDS).await().until(() -> true);
//        }   catch (com.codeborne.selenide.ex.ElementNotFound e) {
//            System.out.println("Element not found");
//        }
        }
//        try {
        if(conciergeItemsScreen.getSelectQTY().isDisplayed()) {
            Select quantityList = new Select(conciergeItemsScreen.getSelectQTY());
            quantityList.selectByIndex(2);
            with().pollInterval(2, SECONDS).await().until(() -> true);
//        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
//            System.out.println("Close button is not displayed");
//        }
        }
//        try {
        if(conciergeItemsScreen.getSelectFill().isDisplayed()) {
            Select fillList = new Select(conciergeItemsScreen.getSelectFill());
            fillList.selectByIndex(1);
            with().pollInterval(2, SECONDS).await().until(() -> true);
//        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
//            System.out.println("Close button is not displayed");
//        }
        }
//        try {
        if(conciergeItemsScreen.getSelectFinish().isDisplayed()) {
            Select finishList = new Select(conciergeItemsScreen.getSelectFinish());
            finishList.selectByIndex(1);
            with().pollInterval(2, SECONDS).await().until(() -> true);
//        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
//            System.out.println("Close button is not displayed");
//        }
        }
    }

    @When("I click on collections item")
    public void iClickOnCollectionsItem() {
        generalStepDefs.waitForJSandJQueryToLoad();
        try {
            conciergeItemsScreen.getCollectionsText().shouldHave(text("collections"), Duration.ofMinutes(1));
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Collection section is not displayed");
        }
        conciergeItemsScreen.getCollectionItem().click();
    }
}
