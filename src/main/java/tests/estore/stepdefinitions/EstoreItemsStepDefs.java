package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import tests.concierge.pageObject.SelectOption;
import tests.estore.pageObject.EstoreItemPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;


public class EstoreItemsStepDefs {
    EstoreItemPage estoreItemPage = new EstoreItemPage();
    SelectOption selectOption = new SelectOption();
    EstoreGeneralStepDefs generalStepDefs = new EstoreGeneralStepDefs();

    @When("I select estore debth option")
    public void iSelectDebthProperty() {
        generalStepDefs.waitForJSandJQueryToLoad();
        try {
            executeJavaScript("window.scrollTo(0, 970)");
            selectOption.getDepthProperty().should(Condition.and("", appear, enabled), Duration.ofSeconds(60));
            selectOption.getDepthProperty().should(Condition.be(interactable), Duration.ofSeconds(45));
            Select selectDepth = new Select(selectOption.getDepthProperty());

            selectDepth.selectByIndex(3);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
        with().pollInterval(2, SECONDS).await().until(() -> true);

    }

    @When("I select estore fabric option")
    public void iSelectFabricProperty() {
        with().pollInterval(2, SECONDS).await().until(() -> true);
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

    @When("I select estore color option")
    public void iSelectColorOption() {
        generalStepDefs.waitForJSandJQueryToLoad();

        try {
            with().pollInterval(3, SECONDS).await().until(() -> true);
            selectOption.getColorOption().should(Condition.and("", appear, enabled), Duration.ofSeconds(20));
            selectOption.getColorOption().should(Condition.be(interactable), Duration.ofSeconds(5));
            Select selectFabric = new Select(selectOption.getColorOption());
            selectFabric.selectByIndex(1);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
        with().pollInterval(4, SECONDS).await().until(() -> true);
    }

    @When("I click on estore collections item")
    public void iClickOnCollectionsItem() {
        generalStepDefs.waitForJSandJQueryToLoad();
        try {
            estoreItemPage.getCollectionsText().shouldHave(text("collections"), Duration.ofMinutes(4));
            estoreItemPage.getCollectionItem().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Collection section is not displayed");
        }
    }
}