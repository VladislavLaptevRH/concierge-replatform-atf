package tests.concierge.stepdefinitions;

import tests.concierge.pageObject.ConciergeOrderHistoryForm;
import tests.concierge.pageObject.ConciergeUserAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static tests.utility.Hooks.getWindowsHandles;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ConciergeOrderHistoryStepDefs {
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeOrderHistoryForm conciergeOrderHistoryForm = new ConciergeOrderHistoryForm();
    String customerFirstName;

    @When("I navigate to the order history page from the concierge dashboard")
    public void iNavigateToTheOrderHistoryPageFromTheConciergeDashboard() {
        conciergeUserAccountPage.getOrderHistoryButton().should(visible, Duration.ofMinutes(1));
        conciergeUserAccountPage.getOrderHistoryButton().click();
    }

    @Then("I verify the customer lookup form appears")
    public void iVerifyTheCustomerLookupFormAppears() {
        conciergeOrderHistoryForm.getCustomerLookUp().should(visible, Duration.ofMinutes(1));
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
        conciergeOrderHistoryForm.getFirstNameField().should(visible, Duration.ofMinutes(1));
        conciergeOrderHistoryForm.getFirstNameField().setValue(firstName);
        conciergeOrderHistoryForm.getLastNameField().setValue(lastName);
        conciergeOrderHistoryForm.getActiveContinueButton().click();
        customerFirstName = firstName;
        return customerFirstName;
    }

    @Then("I see results for order history by customer search")
    public void iSeeResultsForOrderHistoryByCustomerSearch() {
        if (customerFirstName.equals("notexist")) {
            conciergeOrderHistoryForm.getSearchNoResultsMsg().should(visible, Duration.ofMinutes(1));
            assertEquals(conciergeOrderHistoryForm.getSearchNoResultsMsg().getText(), "Your search yielded no results");
            assertEquals(conciergeOrderHistoryForm.getCreateNewAccountButton().getText(), "CREATE NEW ACCOUNT");
        } else {
            conciergeOrderHistoryForm.getCustomerAccountResultsTitle().should(visible, Duration.ofMinutes(1));
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
        //conciergeOrderHistoryForm.getFirstResult().should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Automation NonMember']")).should(visible, Duration.ofSeconds(40));
        //conciergeOrderHistoryForm.getFirstResult().click();
        $(By.xpath("//*[text()='Automation NonMember']")).click();
    }

    @Then("I verify that order history page is displayed")
    public void iVerifyThatOrderHistoryPageIsDisplayed() {
        conciergeOrderHistoryForm.getCustomerFirstName().shouldHave(text("Order Date"));
        conciergeOrderHistoryForm.getCustomerAddress().shouldHave(text("Order Number"));
        conciergeOrderHistoryForm.getCustomerEmail().shouldHave(text("Shipping Location"));
        conciergeOrderHistoryForm.getCustomerPhone().shouldHave(text("Shipping Name"));
        conciergeOrderHistoryForm.getCustomerCompany().shouldHave(text("Order Status"));
        conciergeOrderHistoryForm.getCustomerTradeIdTaxExempt().shouldHave(text("Order Total"));
        conciergeOrderHistoryForm.getBackToSearchResultsButton().shouldHave(text("Back To Search Results"));
    }

    @When("I click on random order")
    public void iClickOnRandomOrder() {
        sleep(4000);
        $(By.xpath("//*[text()='Automation NonMember']")).should(visible, Duration.ofSeconds(40));
        conciergeOrderHistoryForm.getFirstResult().should(visible, Duration.ofMinutes(1));
        conciergeOrderHistoryForm.getFirstResult().click();
    }

    @Then("I verify that I redirected to wismo")
    public void iVerifyThatIRedirectedToWismo() {
        $(By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1']")).shouldHave(text("ORDER HISTORY"), Duration.ofSeconds(30));
        sleep(3000);
        ArrayList<String> tabs = new ArrayList<>(getWindowsHandles());
        switchTo().window(tabs.get(1));
        boolean redirect = tabs.size() == 2;
        assertTrue(redirect);
    }

    @Then("I verifiy that Order Lookup title is displayed")
    public void iVerifiyThatOrderLookupTitleIsDisplayed() {
        conciergeOrderHistoryForm.getOrderLookUpTitle().should(visible, Duration.ofMinutes(1));
        conciergeOrderHistoryForm.getOrderLookUpTitle().shouldHave(text("ORDER LOOKUP"), Duration.ofSeconds(30));
    }

    @When("I introduced {string} with status {string} order number in order number field")
    public void iIntroducedWithStatusOrderNumberInOrderNumberField(String orderId, String status) {
        conciergeOrderHistoryForm.getOrderNumberField().should(visible, Duration.ofMinutes(1));
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
        conciergeOrderHistoryForm.getBackToSearchResultsButton().should(visible, Duration.ofMinutes(1));
        conciergeOrderHistoryForm.getBackToSearchResultsButton().click();
    }
}

