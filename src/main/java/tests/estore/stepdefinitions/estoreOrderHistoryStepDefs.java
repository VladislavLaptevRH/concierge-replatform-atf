package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.estore.pageObject.EstoreOrderHistoryScreen;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class estoreOrderHistoryStepDefs {
    EstoreOrderHistoryScreen estoreOrderHistoryScreen = new EstoreOrderHistoryScreen();

    @When("I open order history for estore")
    public void iOpenOrderHistoryForEstore() {
        String URL = Hooks.eStoreBaseURL + "/my-account/order-history.jsp";
        open(URL);
        sleep(2000);
        WebDriverRunner.getWebDriver().navigate().refresh();
    }

    @Then("I verify that estore order history page is displayed")
    public void iVerifyThatEstoreOrderHistoryPageIsDisplayed() {
        estoreOrderHistoryScreen.getOrderHistorySafireWilliam().should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify that a new order listed in order history")
    public void iVerifyThatANewOrderListedInOrderHistory() {
        estoreOrderHistoryScreen.getShipTo().should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify that no orders for new registered user")
    public void iVerifyThatNoOrdersForNewRegisteredUser() {
        estoreOrderHistoryScreen.getOrderHistoryOrderText().should(Condition.visible, Duration.ofSeconds(20));
        estoreOrderHistoryScreen.getOrderHistoryFoundText().should(Condition.visible, Duration.ofSeconds(20));
    }

    @When("I click on estore order history")
    public void iClickOnEstoreOrderHistory() {
        estoreOrderHistoryScreen.getOrderHistoryButton().should(Condition.visible, Duration.ofSeconds(20));
        estoreOrderHistoryScreen.getOrderHistoryButton().click();
    }

    @When("I click on details and tracking order history")
    public void iClickOnDetailsAndTrackingOrderHistory() {
        estoreOrderHistoryScreen.getDetailsAndTrackingButton().should(Condition.visible, Duration.ofSeconds(20));
        estoreOrderHistoryScreen.getDetailsAndTrackingButton().click();
    }

    @When("I click on estore logo")
    public void iClickOnEstoreConciergeLogo() {
        estoreOrderHistoryScreen.getOrderHistoryEstoreLogo().should(Condition.visible, Duration.ofSeconds(20));
        estoreOrderHistoryScreen.getOrderHistoryEstoreLogo().click();
    }

    @Then("I verify the fileds for estore order history")
    public void iVerifyTheFiledsForEstoreOrderHistory() {
        estoreOrderHistoryScreen.getOrderTotal().shouldBe(Condition.visible, Duration.ofSeconds(20));
        estoreOrderHistoryScreen.getShipTo().shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify the estore total order count displayed at the bottom of the list")
    public void iVerifyTheEstoreTotalOrderCountDisplayedAtTheBottomOfTheList() {
        estoreOrderHistoryScreen.getFoundText().should(Condition.visible, Duration.ofSeconds(20));
        estoreOrderHistoryScreen.getOrdersText().should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify that the pagination for the order history is displayed")
    public void iVerifyThatThePaginationForTheOrderHistoryIsDisplayed() {
        estoreOrderHistoryScreen.getOrderHistoryPage1Button().should(Condition.visible, Duration.ofSeconds(40));
        estoreOrderHistoryScreen.getOrderHistoryPage2Button().should(Condition.visible, Duration.ofSeconds(40));
    }

    @Then("I verify the billing summary link for order history")
    public void iVerifyTheBillingSummaryLinkForOrderHistory() {
        estoreOrderHistoryScreen.getBillingSummaryButton().should(Condition.visible, Duration.ofSeconds(20));
        estoreOrderHistoryScreen.getBillingSummaryButton().click();
        estoreOrderHistoryScreen.getBillingSummaryBrandTitle().shouldHave(Condition.text("Billing Summary"), Duration.ofSeconds(20));
    }

    @Then("I verify the details and tracling link for the order placed")
    public void iVerifyTheDetailsAndTraclingLinkForTheOrderPlaced() {
        estoreOrderHistoryScreen.getDetailsAndTrackingButton().should(Condition.visible, Duration.ofSeconds(20));
        estoreOrderHistoryScreen.getDetailsAndTrackingButton().click();
        estoreOrderHistoryScreen.getShipTo().should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify the CW order number")
    public void iVerifyTheCWOrderNumber() {
        estoreOrderHistoryScreen.getCwNumber().should(Condition.visible, Duration.ofSeconds(20));
    }


    @Then("I verify order date and order total fields")
    public void iVerifyOrderDateAndOrderTotalFields() {
        estoreOrderHistoryScreen.getYear22().should(Condition.visible, Duration.ofSeconds(20));
    }
}