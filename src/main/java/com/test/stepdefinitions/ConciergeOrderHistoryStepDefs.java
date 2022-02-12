package com.test.stepdefinitions;

import com.test.pageObject.ConciergeOrderHistoryForm;
import com.test.pageObject.ConciergeUserAccountPage;
import com.test.utility.Hooks;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.testng.Assert.assertTrue;

public class ConciergeOrderHistoryStepDefs {
    WebDriver webDriver = Hooks.getWebDriver();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage(webDriver);
    ConciergeOrderHistoryForm conciergeOrderHistoryForm = new ConciergeOrderHistoryForm(webDriver);
    WebDriverWait wait = new WebDriverWait(webDriver, 10);
    String customerFirstName;

    @When("I navigate to the order history page from the concierge dashboard")
    public void iNavigateToTheOrderHistoryPageFromTheConciergeDashboard() {
        wait.until(ExpectedConditions.visibilityOf(conciergeUserAccountPage.getOrderHistoryButton()));
        conciergeUserAccountPage.getOrderHistoryButton().click();
    }

    @Then("I verify the customer lookup form appears")
    public void iVerifyTheCustomerLookupFormAppears() {
        wait.until(ExpectedConditions.visibilityOf(conciergeOrderHistoryForm.getOrderHistoryTitle()));
        assertTrue(conciergeOrderHistoryForm.getCustomerLookUp().isDisplayed());
        assertTrue(conciergeOrderHistoryForm.getFirstNameField().getAttribute("name").equals("firstName"));
        assertTrue(conciergeOrderHistoryForm.getLastNameField().getAttribute("name").equals("lastName"));
        assertTrue(conciergeOrderHistoryForm.getEmailAddressField().getAttribute("name").equals("email"));
        assertTrue(conciergeOrderHistoryForm.getPostalCodeField().getAttribute("name").equals("postalCode"));
        assertTrue(conciergeOrderHistoryForm.getMemberIdField().getAttribute("name").equals("memberID"));
        assertTrue(conciergeOrderHistoryForm.getBusinessAccountNumberField().getAttribute("name").equals("tradeID"));
        assertTrue(conciergeOrderHistoryForm.getCompanyNameField().getAttribute("name").equals("company"));
        assertTrue(conciergeOrderHistoryForm.getPhoneNumberField().getAttribute("name").equals("phoneNumber"));
        assertTrue(conciergeOrderHistoryForm.getContinueOrderLookUpButton().isDisplayed());
    }

    @And("I verify the order lookup form appears")
    public void iVerifyTheOrderLookupFormAppears() {
        assertTrue(conciergeOrderHistoryForm.getOrderLookUpTitle().isDisplayed());
        assertTrue(conciergeOrderHistoryForm.getOrderNumberField().isDisplayed());
    }


    @And("I search order history for customer {string} {string}")
    public String iSearchOrderHistoryForCustomer(String firstName, String lastName) {
        wait.until(ExpectedConditions.visibilityOf(conciergeOrderHistoryForm.getFirstNameField()));
        conciergeOrderHistoryForm.getFirstNameField().sendKeys(firstName);
        conciergeOrderHistoryForm.getLastNameField().sendKeys(lastName);
        conciergeOrderHistoryForm.getActiveContinueButton().click();
        customerFirstName = firstName;
        return customerFirstName;
    }

    @Then("I see results for order history by customer search")
    public void iSeeResultsForOrderHistoryByCustomerSearch() {
        if (customerFirstName.equals("notexist")) {
            wait.until(ExpectedConditions.visibilityOf(conciergeOrderHistoryForm.getSearchNoResultsMsg()));
            assertTrue(conciergeOrderHistoryForm.getSearchNoResultsMsg().getText().equals("Your search yielded no results"));
            assertTrue(conciergeOrderHistoryForm.getCreateNewAccountButton().getText().equals("CREATE NEW ACCOUNT"));
        } else {
            wait.until(ExpectedConditions.textToBePresentInElement(conciergeOrderHistoryForm.getCustomerAddress(), "ADDRESS"));
            assertTrue(conciergeOrderHistoryForm.getCustomerAccountResultsTitle().getText().contains("CUSTOMER ACCOUNT RESULTS"));
            assertTrue(conciergeOrderHistoryForm.getCustomerAddress().getText().equals("ADDRESS"));
            assertTrue(conciergeOrderHistoryForm.getCustomerFirstName().getText().equals("FIRST NAME"));
            assertTrue(conciergeOrderHistoryForm.getCustomerPhone().getText().equals("PHONE"));
            assertTrue(conciergeOrderHistoryForm.getCustomerEmail().getText().equals("EMAIL"));
            assertTrue(conciergeOrderHistoryForm.getCustomerCompany().getText().equals("COMPANY"));
            assertTrue(conciergeOrderHistoryForm.getCustomerTradeIdTaxExempt().getText().equals("TRADE ID / TAX EXEMPT"));

        }
    }

    @When("I click on the random result")
    public void iClickOnTheRandomResult() {
        wait.until(ExpectedConditions.visibilityOf(conciergeOrderHistoryForm.getFirstResult()));
        conciergeOrderHistoryForm.getFirstResult().click();
    }

    @Then("I verify that order history page is displayed")
    public void iVerifyThatOrderHistoryPageIsDisplayed() {
        wait.until(ExpectedConditions.textToBePresentInElement(conciergeOrderHistoryForm.getOrderHistoryTitle(), "ORDER HISTORY"));
        wait.until(ExpectedConditions.textToBePresentInElement(conciergeOrderHistoryForm.getCustomerFirstName(), "Order Date"));
        assertTrue(conciergeOrderHistoryForm.getOrderHistoryTitle().isDisplayed());
        assertTrue(conciergeOrderHistoryForm.getCustomerFirstName().getText().equals("Order Date"));
        assertTrue(conciergeOrderHistoryForm.getCustomerAddress().getText().equals("Order Number"));
        assertTrue(conciergeOrderHistoryForm.getCustomerPhone().getText().equals("Shipping Name"));
        assertTrue(conciergeOrderHistoryForm.getCustomerEmail().getText().equals("Shipping Location"));
        assertTrue(conciergeOrderHistoryForm.getCustomerCompany().getText().equals("Order Status"));
        assertTrue(conciergeOrderHistoryForm.getCustomerTradeIdTaxExempt().getText().equals("Order Total"));
        assertTrue(conciergeOrderHistoryForm.getOrderNotes().getText().equals("Notes"));
        assertTrue(conciergeOrderHistoryForm.getBackToSearchResultsButton().getText().equals("Back To Search Results"));

    }

    @When("I click on random order")
    public void iClickOnRandomOrder() {
        wait.until(ExpectedConditions.textToBePresentInElement(conciergeOrderHistoryForm.getOrderNotes(), "Notes"));
        conciergeOrderHistoryForm.getFirstResult().click();
    }

    @Then("I verify that I redirected to wismo")
    public void iVerifyThatIRedirectedToWismo() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        Boolean redirect = false;
        if (tabs.size() == 2) {
            redirect = true;
        }
        assertTrue(redirect);
    }

    @Then("I verifiy that Order Lookup title is displayed")
    public void iVerifiyThatOrderLookupTitleIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(conciergeOrderHistoryForm.getOrderHistoryTitle()));
        conciergeOrderHistoryForm.getOrderLookUpTitle().getText().equals("ORDER LOOKUP");
    }


    @When("I introduced {string} with status {string} order number in order number field")
    public void iIntroducedWithStatusOrderNumberInOrderNumberField(String orderId, String status) {
        if (status.equals("inProcess")) {
            conciergeOrderHistoryForm.getOrderNumberField().sendKeys(orderId);
        }
        if (status.equals("open")) {
            conciergeOrderHistoryForm.getOrderNumberField().sendKeys(orderId);
        }
        if (status.equals("notExisting")) {
            conciergeOrderHistoryForm.getOrderNumberField().sendKeys(orderId);
        }
        conciergeOrderHistoryForm.getContinueOrderLookUpButton().click();
    }

    @When("I click on back to search results button")
    public void iClickOnBackToSearchResultsButton() {
        wait.until(ExpectedConditions.visibilityOf(conciergeOrderHistoryForm.getBackToSearchResultsButton()));
        conciergeOrderHistoryForm.getBackToSearchResultsButton().click();
    }
}

