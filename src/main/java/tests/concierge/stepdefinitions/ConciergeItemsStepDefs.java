package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import tests.concierge.pageObject.ConciergeItemsScreen;
import tests.concierge.pageObject.SelectOption;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;


public class ConciergeItemsStepDefs {
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    SelectOption selectOption = new SelectOption();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    @When("I select debth option")
    public void iSelectDebthProperty() {
        sleep(8000);
        generalStepDefs.waitForJSandJQueryToLoad();
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
        sleep(8000);
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
        sleep(8000);
        try {
            selectOption.getColorOption().should(Condition.and("", appear, enabled), Duration.ofSeconds(20));
            selectOption.getColorOption().should(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select selectFabric = new Select(selectOption.getColorOption());
            selectFabric.selectByIndex(1);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
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
