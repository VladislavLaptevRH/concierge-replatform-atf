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
import static org.testng.Assert.assertEquals;
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
        assertEquals(conciergeOrderHistoryForm.getFirstNameField().getAttribute("name"), "firstName");
        assertEquals(conciergeOrderHistoryForm.getLastNameField().getAttribute("name"), "lastName");
        assertEquals(conciergeOrderHistoryForm.getEmailAddressField().getAttribute("name"), "email");
        assertEquals(conciergeOrderHistoryForm.getPostalCodeField().getAttribute("name"), "postalCode");
        assertEquals(conciergeOrderHistoryForm.getMemberIdField().getAttribute("name"), "memberID");
        assertEquals(conciergeOrderHistoryForm.getBusinessAccountNumberField().getAttribute("name"), "tradeID");
        assertEquals(conciergeOrderHistoryForm.getCompanyNameField().getAttribute("name"), "company");
        assertEquals(conciergeOrderHistoryForm.getPhoneNumberField().getAttribute("name"), "phoneNumber");
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
            assertEquals(conciergeOrderHistoryForm.getSearchNoResultsMsg().getText(), "Your search yielded no results");
            assertEquals(conciergeOrderHistoryForm.getCreateNewAccountButton().getText(), "CREATE NEW ACCOUNT");
        } else {
            conciergeOrderHistoryForm.getCustomerAccountResultsTitle().shouldBe(visible, Duration.ofMinutes(1));
            assertTrue(conciergeOrderHistoryForm.getCustomerAccountResultsTitle().getText().contains("CUSTOMER ACCOUNT RESULTS"));
            assertEquals(conciergeOrderHistoryForm.getCustomerAddress().getText(), "ADDRESS");
            assertEquals(conciergeOrderHistoryForm.getCustomerFirstName().getText(), "FIRST NAME");
            assertEquals(conciergeOrderHistoryForm.getCustomerPhone().getText(), "PHONE");
            assertEquals(conciergeOrderHistoryForm.getCustomerEmail().getText(), "EMAIL");
            assertEquals(conciergeOrderHistoryForm.getCustomerCompany().getText(), "COMPANY");
            assertEquals(conciergeOrderHistoryForm.getCustomerTradeIdTaxExempt().getText(), "TRADE ID / TAX EXEMPT");

        }
    }

    @When("I click on the random result")
    public void iClickOnTheRandomResult() {
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
    public void iClickOnRandomOrder() {
        sleep(2);
        conciergeOrderHistoryForm.getFirstResult().shouldBe(visible, Duration.ofMinutes(1));
        conciergeOrderHistoryForm.getFirstResult().click();
    }

    @Then("I verify that I redirected to wismo")
    public void iVerifyThatIRedirectedToWismo() {
        ArrayList<String> tabs = new ArrayList<>(getWindowsHandles());
        switchTo().window(tabs.get(1));
        boolean redirect = tabs.size() == 2;
        assertTrue(redirect);
    }

    @Then("I verifiy that Order Lookup title is displayed")
    public void iVerifiyThatOrderLookupTitleIsDisplayed() {
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
        conciergeOrderHistoryForm.getBackToSearchResultsButton().shouldBe(visible, Duration.ofMinutes(1));
        conciergeOrderHistoryForm.getBackToSearchResultsButton().click();
    }
}

