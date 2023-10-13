package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.estore.pageObject.EstoreHomePage;
import tests.estore.pageObject.EstoreOrderHistoryScreen;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;

public class estoreOrderHistoryStepDefs {
    EstoreAccountStepDefs estoreAccountStepDefs = new EstoreAccountStepDefs();
    EstoreHomePage estoreHomePage = new EstoreHomePage();
    EstoreOrderHistoryScreen estoreOrderHistoryScreen = new EstoreOrderHistoryScreen();
    EstoreGeneralStepDefs estoreGeneralStepDefs = new EstoreGeneralStepDefs();

    @When("I open order history for estore")
    public void iOpenOrderHistoryForEstore() {
        String URL = Hooks.eStoreBaseURL + "/my-account/order-history.jsp";
        open(URL);
        estoreGeneralStepDefs.waitForJSandJQueryToLoad();
        WebDriverRunner.getWebDriver().navigate().refresh();
        estoreGeneralStepDefs.waitForJSandJQueryToLoad();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        WebDriverRunner.getWebDriver().navigate().refresh();

    }

    @Then("I verify that estore order history page is displayed")
    public void iVerifyThatEstoreOrderHistoryPageIsDisplayed() {
        estoreOrderHistoryScreen.getOrderHistoryOrderText().should(Condition.visible, Duration.ofSeconds(20));
        estoreOrderHistoryScreen.getOrderHistorySafireWilliam().should(Condition.visible, Duration.ofSeconds(60));
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
        with().pollInterval(4, SECONDS).await().until(() -> true);
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
        estoreOrderHistoryScreen.getBillingSummaryButton().should(Condition.visible, Duration.ofSeconds(25));
        estoreOrderHistoryScreen.getBillingSummaryButton().should(Condition.appear, Duration.ofSeconds(25));
        if (!estoreOrderHistoryScreen.getBillingSummaryButton().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();

        }
        estoreOrderHistoryScreen.getBillingSummaryButton().should(Condition.visible, Duration.ofSeconds(20));
        estoreOrderHistoryScreen.getBillingSummaryButton().click();

        $(By.xpath("//*[text()='There has been no billing activity for order #']")).should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify the details and tracking link for the order placed")
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

    @Then("I open estore order history")
    public void iGoToEstoreOrderHistory() {
        String URL = Hooks.eStoreBaseURL + "/my-account/order-history.jsp";
        open(URL);

    }

    @Then("I verify that status is order in progress while order is still in progress")
    public void iVerifyThatStatusIsOrderInProgressWhileOrderIsStillInProgress() {
        $(By.xpath("(//*[text()='Details and Tracking'])[1]")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("(//*[text()='Details and Tracking'])[1]")).click();
        $(By.xpath("(//*[text()='IN PROGRESS'])[1]")).should(Condition.visible, Duration.ofSeconds(20));
    }

}