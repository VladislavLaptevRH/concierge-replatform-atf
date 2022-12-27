package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class estoreOrderHistoryStepDefs {

    @When("I open order history for estore")
    public void iOpenOrderHistoryForEstore() {
        String URL = Hooks.eStoreBaseURL + "/my-account/order-history.jsp";
        open(URL);
        sleep(2000);
        WebDriverRunner.getWebDriver().navigate().refresh();
    }

    @Then("I verify that estore order history page is displayed")
    public void iVerifyThatEstoreOrderHistoryPageIsDisplayed() {
        $(By.xpath("//*[text()='Safire William']")).should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify that a new order listed in order history")
    public void iVerifyThatANewOrderListedInOrderHistory() {
//        $(By.xpath("(//*[text()='802-Gram Turkish Towel Collection'])[1]")).should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify that no orders for new registered user")
    public void iVerifyThatNoOrdersForNewRegisteredUser() {
        $(By.xpath("//*[text()='Found']")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Order']")).should(Condition.visible, Duration.ofSeconds(20));
    }

    @When("I click on estore order history")
    public void iClickOnEstoreOrderHistory() {
        $(By.xpath("//li[@data-navigation-account-item-id='/my-account/order-history.jsp']")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//li[@data-navigation-account-item-id='/my-account/order-history.jsp']")).click();
    }

    @When("I click on details and tracking order history")
    public void iClickOnDetailsAndTrackingOrderHistory() {
        $(By.xpath("(//*[text()='Details and Tracking'])[1]")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("(//*[text()='Details and Tracking'])[1]")).click();
    }

    @When("I click on estore logo")
    public void iClickOnEstoreConciergeLogo() {
        $(By.xpath("//a[@data-analytics-worhlogo='worh-logo']")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//a[@data-analytics-worhlogo='worh-logo']")).click();
    }

    @Then("I verify the fileds for estore order history")
    public void iVerifyTheFiledsForEstoreOrderHistory() {
        System.out.println();
    }

    @Then("I verify the estore total order count displayed at the bottom of the list")
    public void iVerifyTheEstoreTotalOrderCountDisplayedAtTheBottomOfTheList() {
        System.out.println();
        $(By.xpath("//*[text()='Found']")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Orders']")).should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify that the pagination for the order history is displayed")
    public void iVerifyThatThePaginationForTheOrderHistoryIsDisplayed() {
        $(By.xpath("//button[@aria-label='page 1']")).should(Condition.visible, Duration.ofSeconds(40));
        $(By.xpath("//button[@aria-label='Go to page 2']")).should(Condition.visible, Duration.ofSeconds(40));
    }

    @Then("I verify the billing summary link for order history")
    public void iVerifyTheBillingSummaryLinkForOrderHistory() {
        $(By.xpath("(//*[text()='Billing Summary'])[1]")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("(//*[text()='Billing Summary'])[1]")).click();
        $(By.xpath("//h1[@class='title brand']")).shouldHave(Condition.text("Billing Summary"), Duration.ofSeconds(20));
    }

    @Then("I verify the details and tracling link for the order placed")
    public void iVerifyTheDetailsAndTraclingLinkForTheOrderPlaced() {
        $(By.xpath("(//*[text()='Details and Tracking'])[1]")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("(//*[text()='Details and Tracking'])[1]")).click();
        $(By.xpath("(//*[text()='SHIP TO'])[1]")).should(Condition.visible,Duration.ofSeconds(20));
        $(By.xpath("//h1[@class='title brand']")).shouldHave(Condition.text("Billing Summary"), Duration.ofSeconds(20));

    }

    @Then("I verify the CW order number")
    public void iVerifyTheCWOrderNumber() {
       $(By.xpath("//*[text()='#']")).should(Condition.visible,Duration.ofSeconds(20));
    }


}
