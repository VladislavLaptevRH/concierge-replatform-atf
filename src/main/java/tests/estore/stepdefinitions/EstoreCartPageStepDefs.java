package tests.estore.stepdefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.EstoreCartPage;
import tests.estore.pageObject.EstoreItemPage;
import tests.estore.pageObject.EstoreUserAccountPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.sleep;

public class EstoreCartPageStepDefs {
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstoreCartPage estoreCartPage = new EstoreCartPage();
    EstoreGeneralStepDefs estoreGeneralStepDefs = new EstoreGeneralStepDefs();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    EstoreItemPage estoreItemPage = new EstoreItemPage();

    @When("I remove all items from estore cart")
    public void iRemoveAllItemsFromCart() {
        estoreUserAccountPage.getCartButton().should(visible, Duration.ofMinutes(3));
        sleep(3000);
        if (!estoreUserAccountPage.getCartButton().getText().equals("")) {
            estoreUserAccountPage.getCartButton().click();
            estoreGeneralStepDefs.waitForJSandJQueryToLoad();
            estoreCartPage.getCartTitle().shouldHave(text("CART"), Duration.ofSeconds(12));
            estoreCartPage.getClearOrderButton().scrollIntoView(true);
            estoreCartPage.getOrderEstimateTitle().shouldHave(text("Order Estimate"), Duration.ofSeconds(20));
            estoreCartPage.getClearOrderButton().click();
            estoreCartPage.getClearOrderButtonPop().shouldHave(text("CLEAR ORDER"), Duration.ofSeconds(25));
            estoreCartPage.getClearOrderButtonPop().click();
            estoreGeneralStepDefs.waitForJSandJQueryToLoad();
        }
    }

    @When("I click on view cart estore button")
    public void iClickOnViewCartButton() {
        sleep(3000);
        generalStepDefs.waitForJSandJQueryToLoad();
        estoreCartPage.getItemAddedToYourCart().should(visible, Duration.ofMinutes(1));
        estoreCartPage.getItemAddedToYourCart().shouldHave(text("Added To Your Cart"), Duration.ofSeconds(30));
        estoreItemPage.getViewCartButton().shouldHave(text("View Cart"), Duration.ofSeconds(60));
        estoreItemPage.getViewCartButton().should(visible, Duration.ofSeconds(60));
        estoreCartPage.getKeepShopping().should(visible, Duration.ofSeconds(15));
        estoreItemPage.getViewCartButton().click();
    }

    @When("I choose estore order classification")
    public void iChooseOrderClassification() {
        generalStepDefs.waitForJSandJQueryToLoad();
        Select selectOrder = new Select(estoreCartPage.getOrderClassificationSelect());
        estoreCartPage.getOrderClassificationSelect().selectOptionContainingText("Select an Option");
        estoreCartPage.getOrderClassificationSelect().shouldHave(text("Select an Option"), Duration.ofSeconds(5));
        sleep(7000);
        for (int i = 0; i < 10; i++) {
            selectOrder.selectByValue("RH Gallery Order");
            estoreCartPage.getOrderClassificationSelect().shouldHave(value("RH Gallery Order"), Duration.ofSeconds(5));
        }
        generalStepDefs.waitForJSandJQueryToLoad();
    }
}
