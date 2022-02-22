package com.test.stepdefinitions;

import com.test.pageObject.ConciergeOrderHistoryForm;
import com.test.pageObject.ConciergeUserAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.test.stepdefinitions.GeneralStepDefs.sleep;
import static com.test.utility.Hooks.getWindowsHandles;
import static org.testng.Assert.assertTrue;

public class ConciergeOrderHistoryStepDefs {
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeOrderHistoryForm conciergeOrderHistoryForm = new ConciergeOrderHistoryForm();
    String customerFirstName;

    @When("I navigate to the order history page from the concierge dashboard")
    public void iNavigateToTheOrderHistoryPageFromTheConciergeDashboard() {
        conciergeUserAccountPage.getOrderHistoryButton().shouldBe(visible, Duration.ofMinutes(1));
        conciergeUserAccountPage.getOrderHistoryButton().click();
    }

    @Then("I verify the customer lookup form appears")
    public void iVerifyTheCustomerLookupFormAppears() {
        conciergeOrderHistoryForm.getCustomerLookUp().shouldBe(visible, Duration.ofMinutes(1));
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
        conciergeOrderHistoryForm.getFirstNameField().shouldBe(visible, Duration.ofMinutes(1));
        conciergeOrderHistoryForm.getFirstNameField().setValue(firstName);
        conciergeOrderHistoryForm.getLastNameField().setValue(lastName);
        conciergeOrderHistoryForm.getActiveContinueButton().click();
        customerFirstName = firstName;
        return customerFirstName;
    }

    @Then("I see results for order history by customer search")
    public void iSeeResultsForOrderHistoryByCustomerSearch() {
        if (customerFirstName.equals("notexist")) {
            conciergeOrderHistoryForm.getSearchNoResultsMsg().shouldBe(visible, Duration.ofMinutes(1));
            assertTrue(conciergeOrderHistoryForm.getSearchNoResultsMsg().getText().equals("Your search yielded no results"));
            assertTrue(conciergeOrderHistoryForm.getCreateNewAccountButton().getText().equals("CREATE NEW ACCOUNT"));
        } else {
            conciergeOrderHistoryForm.getCustomerAccountResultsTitle().shouldBe(visible, Duration.ofMinutes(1));
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
//        wait.until(ExpectedConditions.visibilityOf(conciergeOrderHistoryForm.getFirstResult()));
        conciergeOrderHistoryForm.getFirstResult().shouldBe(visible, Duration.ofMinutes(1));
        conciergeOrderHistoryForm.getFirstResult().click();
    }

    @Then("I verify that order history page is displayed")
    public void iVerifyThatOrderHistoryPageIsDisplayed() {
        conciergeOrderHistoryForm.getOrderHistoryTitle().shouldBe(visible, Duration.ofMinutes(1));
        conciergeOrderHistoryForm.getCustomerFirstName().shouldBe(visible, Duration.ofMinutes(1));
        assertTrue(conciergeOrderHistoryForm.getOrderHistoryTitle().isDisplayed());
        conciergeOrderHistoryForm.getCustomerFirstName().shouldHave(text("Order Date"));
        conciergeOrderHistoryForm.getCustomerAddress().shouldHave(text("Order Number"));
        conciergeOrderHistoryForm.getCustomerEmail().shouldHave(text("Shipping Location"));
        conciergeOrderHistoryForm.getCustomerPhone().shouldHave(text("Shipping Name"));
        conciergeOrderHistoryForm.getCustomerCompany().shouldHave(text("Order Status"));
        conciergeOrderHistoryForm.getCustomerTradeIdTaxExempt().shouldHave(text("Order Total"));
        conciergeOrderHistoryForm.getOrderNotes().shouldHave(text("Notes"));
        conciergeOrderHistoryForm.getBackToSearchResultsButton().shouldHave(text("Back To Search Results"));
    }

    @When("I click on random order")
    public void iClickOnRandomOrder() throws InterruptedException {
//        wait.until(ExpectedConditions.textToBePresentInElement(conciergeOrderHistoryForm.getOrderNotes(), "Notes"));

        sleep(2);
        conciergeOrderHistoryForm.getFirstResult().shouldBe(visible, Duration.ofMinutes(1));
        conciergeOrderHistoryForm.getFirstResult().click();
    }

    @Then("I verify that I redirected to wismo")
    public void iVerifyThatIRedirectedToWismo() {
        ArrayList<String> tabs = new ArrayList<>(getWindowsHandles());
        switchTo().window(tabs.get(1));
        boolean redirect = false;
        if (tabs.size() == 2) {
            redirect = true;
        }
        assertTrue(redirect);
    }

    @Then("I verifiy that Order Lookup title is displayed")
    public void iVerifiyThatOrderLookupTitleIsDisplayed() {
//        wait.until(ExpectedConditions.visibilityOf(conciergeOrderHistoryForm.getOrderHistoryTitle()));
        conciergeOrderHistoryForm.getOrderLookUpTitle().shouldBe(visible, Duration.ofMinutes(1));
        conciergeOrderHistoryForm.getOrderLookUpTitle().getText().equals("ORDER LOOKUP");
    }


    @When("I introduced {string} with status {string} order number in order number field")
    public void iIntroducedWithStatusOrderNumberInOrderNumberField(String orderId, String status) {
        conciergeOrderHistoryForm.getOrderNumberField().shouldBe(visible, Duration.ofMinutes(1));
        if (status.equals("inProcess")) {
            conciergeOrderHistoryForm.getOrderNumberField().setValue(orderId);
        }
        if (status.equals("open")) {
            conciergeOrderHistoryForm.getOrderNumberField().setValue(orderId);
        }
        if (status.equals("notExisting")) {
            conciergeOrderHistoryForm.getOrderNumberField().setValue(orderId);
        }
        conciergeOrderHistoryForm.getContinueOrderLookUpButton().click();
    }

    @When("I click on back to search results button")
    public void iClickOnBackToSearchResultsButton() {
//        wait.until(ExpectedConditions.visibilityOf(conciergeOrderHistoryForm.getBackToSearchResultsButton()));
        conciergeOrderHistoryForm.getBackToSearchResultsButton().shouldBe(visible, Duration.ofMinutes(1));
        conciergeOrderHistoryForm.getBackToSearchResultsButton().click();
    }

}

