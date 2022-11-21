package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import tests.concierge.pageObject.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import tests.estore.pageObject.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.awaitility.Awaitility.await;
import static org.testng.Assert.assertTrue;

public class EstoreAbstractStepDefs {
    EstoreItemPage estoreItemPage = new EstoreItemPage();
    ConciergeOrderHistoryForm conciergeOrderHistoryForm = new ConciergeOrderHistoryForm();
    SelectOption selectOption = new SelectOption();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    EstoreReviewOrderPage estoreReviewOrderPage = new EstoreReviewOrderPage();
    ConfirmationOrderScreen confirmationOrderScreen = new ConfirmationOrderScreen();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();
    EstoreGeneralStepDefs generalStepDefs = new EstoreGeneralStepDefs();
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen();
    EstoreCheckoutAddressScreen estoreCheckoutAddressScreen = new EstoreCheckoutAddressScreen();
    EstoreCategories estoreCategories = new EstoreCategories();
    EstorePaymentPage estorePaymentPage = new EstorePaymentPage();
    EstoreGeneralStepDefs estoreGeneralStepDefs = new EstoreGeneralStepDefs();
    EstoreConfirmationOrderScreen estoreConfirmationOrderScreen = new EstoreConfirmationOrderScreen();


    @When("I clicks on a random estore menu item")
    public void iClicksOnARandomEstoreMenuItem() {
        sleep(7000);
        generalStepDefs.waitForJSandJQueryToLoad();
        estoreCategories.getLivingCategory().should(visible, Duration.ofSeconds(60));
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(estoreCategories.getLivingCategory());
        estoreCategories.getLivingCategory().click();
        $(By.xpath("//*[text()='Fabric Seating']")).should(visible,Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Fabric Seating']")).click();
        estoreCategories.getSofaCollections().should(visible, Duration.ofSeconds(40));
        actions.moveToElement(estoreCategories.getSofaCollections());
        estoreCategories.getSofaCollections().click();
    }


    @When("I clicks on estore random item")
    public void iClicksOnEstoreRandomItem() {
        sleep(5000);
        generalStepDefs.waitForJSandJQueryToLoad();
        try {
            estoreItemPage.getItems().should(Condition.and("", visible, enabled), Duration.ofMinutes(3));
            estoreItemPage.getItems().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            estoreItemPage.getTwoItemsInRow().get(1).should(visible, Duration.ofMinutes(1));
            estoreItemPage.getTwoItemsInRow().get(1).click();
            System.out.println("Items section are not displayed");
        }
    }

    @When("I fill all estore options for item")
    public void iFillAllEstoreOptionsForItem() {
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

    @When("I click on estore checkout button")
    public void iClickOnCheckoutButton() {
        generalStepDefs.waitForJSandJQueryToLoad();
        sleep(2000);
        conciergeItemsScreen.getCheckoutButton().shouldHave(text(conciergeItemsScreen.getCheckoutButton().getText()), Duration.ofMinutes(2));
        conciergeItemsScreen.getCheckoutButton().click();
    }

    @When("I introduces payment details for estore")
    public void iClickOnContinueToPaymentButton() {
        estorePaymentPage.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(2));
        Select selectPayment = new Select(estorePaymentPage.getChoosePaymentMethodBtn());
        selectPayment.selectByIndex(2);


        switchTo().frame($(By.cssSelector("iframe[title='Iframe for secured card number']")).should(visible, Duration.ofMinutes(1)));
        estorePaymentPage.getCardNumberField().setValue("4678475330157543");
        switchTo().defaultContent();

        switchTo().frame($(By.xpath("//div[contains(@class,'securityCode')]//iframe[@class='js-iframe']")).should(visible, Duration.ofMinutes(1)));
        estorePaymentPage.getCvcField().setValue("737");
        switchTo().defaultContent();

        switchTo().frame($(By.xpath("//div[contains(@class,'expiryDate')]//iframe[@title='Iframe for secured card expiry date']")).should(visible, Duration.ofMinutes(1)));
        estorePaymentPage.getExpiryDateField().setValue("0330");
        switchTo().defaultContent();

        estorePaymentPage.getContinueToCheckout().click();

    }

    @And("I verify that estore review screen is displayed")
    public void iVerifyThatReviewScreenIsDisplayed() {
        estoreReviewOrderPage.getBillingAddress().should(visible, Duration.ofMinutes(1));
        estoreReviewOrderPage.getShippingAddress().should(visible, Duration.ofMinutes(1));
    }

    @When("I click on a place estore order button")
    public void iClickOnPlaceOrderButton() {
        sleep(5000);
        estoreReviewOrderPage.getPlaceOrderButton().should(enabled, Duration.ofMinutes(3));
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        estoreReviewOrderPage.getPlaceOrderButton().should(enabled, Duration.ofMinutes(1));
        estoreReviewOrderPage.getPlaceOrderButton().click();

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

    @Then("I verify that confirmation estore order screen is displayed")
    public void iVerifyThatEstoreOrderDetailsScreenIsDisplayed() {
        generalStepDefs.waitForJSandJQueryToLoad();
        estoreConfirmationOrderScreen.getThankYouTitle().should(visible, Duration.ofSeconds(25));

        assertTrue(estoreConfirmationOrderScreen.getYourOrderHasBeenPlaced().isDisplayed());
    }

    @When("I fill all fields from estore address screen")
    public void iFillAllFieldsFromEstoreAddressScreenForBrands() {
        generalStepDefs.waitForJSandJQueryToLoad();
        try {
            estoreCheckoutAddressScreen.getFirstNameInpt().should(Condition.and("", enabled, visible), Duration.ofMinutes(1));
            if (estoreCheckoutAddressScreen.getFirstNameInpt().isDisplayed()) {
                estoreGeneralStepDefs.fillAddressFields();
                estoreGeneralStepDefs.fillZipCodeStateCountry("12345", "US", "");
            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Address fields are not available");
        }
    }

    @When("I fill all fields for guest user from estore address screen")
    public void iFillAllFieldsFromGuestEstoreAddressScreenForBrands() {
        generalStepDefs.waitForJSandJQueryToLoad();
        try {
            estoreCheckoutAddressScreen.getFirstNameInpt().should(Condition.and("", enabled, visible), Duration.ofMinutes(1));
            if (estoreCheckoutAddressScreen.getFirstNameInpt().isDisplayed()) {
                estoreGeneralStepDefs.fillAddressFields();
                estoreGeneralStepDefs.fillZipCodeStateCountry("12345", "US", "");
                executeJavaScript("arguments[0].click();", checkoutAddressScreen.getBillingAddressAsShippingCheckBox());
            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Address fields are not available");
        }
    }

    @When("I clicks on a random estore menu item for brands")
    public void iClicksOnARandomMenuEstoreItemForBrands() {
        await().forever().until(() -> conciergeUserAccountPage.getMenuItems().get(0).isDisplayed());
        conciergeUserAccountPage.getMenuItems().get(0).should(visible);
        conciergeUserAccountPage.getMenuItems().get(0).scrollIntoView(true);
        conciergeUserAccountPage.getMenuItems().get(0).click();
        conciergeUserAccountPage.getItemSubCategory().get(0).should(visible);
        conciergeUserAccountPage.getItemSubCategory().get(0).scrollIntoView(true);
        conciergeUserAccountPage.getItemSubCategory().get(0).click();
    }

    @When("I click on estore rh concierge logo")
    public void iClickOnEstoreRhConciergeLogo() {
        conciergeUserAccountPage.getRhConciergeLogo().should(Condition.and("", visible, enabled), Duration.ofMinutes(5));

        conciergeUserAccountPage.getRhConciergeLogo().click();
    }

    @When("I choose estore client from header")
    public void iChooseEstoreClientFromHeader() {
        generalStepDefs.waitForJSandJQueryToLoad();
        if (conciergeUserAccountPage.getClientButton().getText().equals("CLIENT")) {
            conciergeUserAccountPage.getClientButton().shouldHave(text("CLIENT"), Duration.ofSeconds(15));
            sleep(2000);
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

}

