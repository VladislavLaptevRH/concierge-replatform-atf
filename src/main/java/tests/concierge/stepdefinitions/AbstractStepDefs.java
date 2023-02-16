package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import tests.concierge.pageObject.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.awaitility.Awaitility.with;
import static org.testng.Assert.assertTrue;

public class AbstractStepDefs {
    ConciergeOrderHistoryForm conciergeOrderHistoryForm = new ConciergeOrderHistoryForm();
    SelectOption selectOption = new SelectOption();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    PaymentScreen paymentScreen = new PaymentScreen();
    ReviewOrderScreen reviewOrderScreen = new ReviewOrderScreen();
    ConfirmationOrderScreen confirmationOrderScreen = new ConfirmationOrderScreen();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen();


    @When("I clicks on a random menu item")
    public void iClicksOnARandomMenuItem() {
        for (int main = 1; main < conciergeUserAccountPage.getListOfMainCategories().size(); main++) {
            if (main == 1) {
                System.out.println("Main Category: " + conciergeUserAccountPage.getListOfMainCategories().get(main).getText());
                conciergeUserAccountPage.getListOfMainCategories().get(main).click();
            }
        }
            for (int sub = 0; sub < conciergeUserAccountPage.getListOfSubCategories().size(); sub++) {
                if (sub == 0) {
                    System.out.println("Sub Category: " + conciergeUserAccountPage.getListOfSubCategories().get(sub).getText());
                    conciergeUserAccountPage.getListOfSubCategories().get(sub).click();
                }
                for (int collection = 0; collection < conciergeUserAccountPage.getListOfCollections().size(); collection++) {
                    if (collection == 0) {
                        System.out.println("Collection: " + conciergeUserAccountPage.getListOfCollections().get(collection).getText());
                        conciergeUserAccountPage.getListOfCollections().get(collection).click();
                    }
                }
            }
        with().pollInterval(5, SECONDS).await().until(() -> true);
        System.out.println(WebDriverRunner.getWebDriver().getTitle() + ": "+ Hooks.getCurrentUrl());
    }


    @When("I clicks on o random item")
    public void iClicksOnORandomItem() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        generalStepDefs.waitForJSandJQueryToLoad();
        try {
            conciergeItemsScreen.getItems().get(1).should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
            conciergeItemsScreen.getItems().get(1).click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            conciergeItemsScreen.getTwoItemsInRow().get(1).should(visible, Duration.ofMinutes(1));
            conciergeItemsScreen.getTwoItemsInRow().get(1).click();
            System.out.println("Items section are not displayed");
        }
    }

    @When("I fill all options for item")
    public void iFillAllOptionsForItem() {
        try {
            conciergeCartPageScreen.getColorCloseButton().should(visible, Duration.ofSeconds(15));
            conciergeCartPageScreen.getColorCloseButton().click();
            selectOption.getSelectSizeElement().should(Condition.and("", visible, enabled), Duration.ofSeconds(5));
            if (selectOption.getSelectSizeElement().isDisplayed()) {
                Select size = new Select(selectOption.getSelectSizeElement());
                size.selectByIndex(2);
            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Element is not displayed");
        }

        try {
            selectOption.getQuantityElement().should(Condition.and("", visible, enabled), Duration.ofSeconds(40));
            selectOption.getQuantityElement().scrollIntoView(true);
            selectOption.getSelectColorElement().should(Condition.and("", visible, enabled), Duration.ofSeconds(5));
            if (selectOption.getSelectColorElement().isDisplayed()) {
                Select color = new Select(selectOption.getSelectColorElement());
                color.selectByIndex(2);
            }

            if (selectOption.getQuantityElement().isDisplayed()) {
                Select quantity = new Select(selectOption.getQuantityElement());
                quantity.selectByIndex(2);
            }

        } catch (
                com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Element is not displayed");
        }

    }

    @When("I click on checkout button")
    public void iClickOnCheckoutButton() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if(!conciergeItemsScreen.getCheckoutButton().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeItemsScreen.getCheckoutButton().shouldHave(text(conciergeItemsScreen.getCheckoutButton().getText()), Duration.ofMinutes(2));
        conciergeItemsScreen.getCheckoutButton().click();
    }

    @When("I introduces payment details")
    public void iClickOnContinueToPaymentButton() {
        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(5));
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment.selectByValue("POS");

        switchTo().frame($(By.cssSelector("iframe[title='Iframe for secured card data input field']")).should(visible, Duration.ofMinutes(1)));
        paymentScreen.getCardNumberField().setValue("4678475330157543");
        switchTo().defaultContent();
        switchTo().frame($(By.xpath("//div[contains(@class,'securityCode')]//iframe[@class='js-iframe']")).should(visible, Duration.ofMinutes(1)));
        paymentScreen.getCvcField().setValue("737");
        switchTo().defaultContent();

        switchTo().frame($(By.xpath("//div[contains(@class,'expiryDate')]//iframe[@title='Iframe for secured card data input field']")).should(visible, Duration.ofMinutes(1)));
        paymentScreen.getExpiryDateField().setValue("0330");
        switchTo().defaultContent();

        paymentScreen.getContinueToReview().click();
    }

    @And("I verify that review screen is displayed")
    public void iVerifyThatReviewScreenIsDisplayed() {
        reviewOrderScreen.getBillingAddress().should(visible, Duration.ofMinutes(1));
        reviewOrderScreen.getShippingAddress().should(visible, Duration.ofMinutes(1));
    }

    @When("I click on a place order button")
    public void iClickOnPlaceOrderButton() {
        with().pollInterval(9, SECONDS).await().until(() -> true);
        reviewOrderScreen.getPlaceOrderButton().should(enabled, Duration.ofSeconds(45));
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        reviewOrderScreen.getPlaceOrderButton().should(enabled, Duration.ofMinutes(1));
        reviewOrderScreen.getPlaceOrderButton().click();
        try {
            confirmationOrderScreen.getAcceptPlaceOrderBtn().should(Condition.be(visible), Duration.ofSeconds(5));
            executeJavaScript("arguments[0].click();", confirmationOrderScreen.getSpoTermsCheckBox());
            confirmationOrderScreen.getSignatureArea().click();
            confirmationOrderScreen.getAcceptPlaceOrderBtn().scrollIntoView(true);
            confirmationOrderScreen.getAcceptPlaceOrderBtn().should(Condition.be(visible), Duration.ofSeconds(5));
            executeJavaScript("arguments[0].click();", confirmationOrderScreen.getAcceptPlaceOrderBtn());
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Order terms popup is not displayed");
        }
    }

    @Then("I verify that confirmation order screen is displayed")
    public void iVerifyThatOrderDetailsScreenIsDisplayed() {
        generalStepDefs.waitForJSandJQueryToLoad();
        confirmationOrderScreen.getThankYouTitle().should(visible, Duration.ofSeconds(25));
        assertTrue(confirmationOrderScreen.getYourOrderHasBeenPlaced().isDisplayed());
        assertTrue(confirmationOrderScreen.getThankYouTitle().isDisplayed());
    }

    @When("I fill all fields from address screen")
    public void iFillAllFieldsFromAddressScreenForBrands() {
        generalStepDefs.waitForJSandJQueryToLoad();
        try {
            checkoutAddressScreen.getFirstNameInpt().should(Condition.and("", enabled, visible), Duration.ofSeconds(10));
            if (checkoutAddressScreen.getFirstNameInpt().isDisplayed()) {
                generalStepDefs.fillAddressFields();
                generalStepDefs.fillZipCodeStateCountry("85020", "US", "");
                generalStepDefs.clearField(checkoutAddressScreen.getEmailAddressField());
                checkoutAddressScreen.getEmailAddressField().setValue("test@mailinator.com");
            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Address fields are not available");
        }
    }

    @When("I clicks on a random menu item for brands")
    public void iClicksOnARandomMenuItemForBrands() {
        await().forever().until(() -> conciergeUserAccountPage.getMenuItems().get(0).isDisplayed());
        conciergeUserAccountPage.getMenuItems().get(0).should(visible);
        conciergeUserAccountPage.getMenuItems().get(0).scrollIntoView(true);
        conciergeUserAccountPage.getMenuItems().get(0).click();
        conciergeUserAccountPage.getItemSubCategory().get(0).should(visible);
        conciergeUserAccountPage.getItemSubCategory().get(0).scrollIntoView(true);
        conciergeUserAccountPage.getItemSubCategory().get(0).click();
    }

    @When("I click on rh concierge logo")
    public void iClickOnRhConciergeLogo() {
        conciergeUserAccountPage.getRhConciergeLogo().should(Condition.and("", visible, enabled), Duration.ofMinutes(5));

        conciergeUserAccountPage.getRhConciergeLogo().click();
    }

    @When("I choose client from header")
    public void iChooseClientFromHeader() {
        generalStepDefs.waitForJSandJQueryToLoad();
        if (conciergeUserAccountPage.getClientButton().getText().equals("CLIENT")) {
            conciergeUserAccountPage.getClientButton().shouldHave(text("CLIENT"), Duration.ofSeconds(15));
            with().pollInterval(2, SECONDS).await().until(() -> true);
            conciergeUserAccountPage.getClientButton().click();
            conciergeUserAccountPage.getClientLookupHeaderBtn().shouldHave(text("Client Lookup"), Duration.ofMinutes(1));
            conciergeUserAccountPage.getClientLookupHeaderBtn().click();

            generalStepDefs.waitForJSandJQueryToLoad();
            conciergeUserAccountPage.getClientLookupFirstName().should(visible, Duration.ofSeconds(25));
            conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
            conciergeUserAccountPage.getClientLookupLastName().setValue("Trade");
            conciergeUserAccountPage.getClientLookupSearchButton().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
            conciergeUserAccountPage.getClientLookupSearchButton().shouldHave(text(conciergeUserAccountPage.getClientLookupSearchButton().getText()), Duration.ofMinutes(1));
            conciergeUserAccountPage.getClientLookupSearchButton().click();
            conciergeOrderHistoryForm.getCustomerFirstName().shouldHave(text("NAME"), Duration.ofMinutes(1));
            executeJavaScript("arguments[0].click();", conciergeUserAccountPage.getFirstResultOfClientLookup());
            System.out.println();
        }
    }

    @When("I verify that concierge is displayed")
    public void iVerifyThatConciergeIsDisplayed() {

    }

}

