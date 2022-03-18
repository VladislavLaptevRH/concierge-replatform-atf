package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.test.pageObject.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.awaitility.Awaitility.await;
import static org.testng.Assert.assertTrue;

public class AbstractStepDefs {
    SelectOption selectOption = new SelectOption();
    ConciergeOrderHistoryForm conciergeOrderHistoryForm = new ConciergeOrderHistoryForm();
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
        sleep(3000);
        conciergeUserAccountPage.getInStockButtonMenu().shouldBe(visible, Duration.ofSeconds(15));
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(conciergeUserAccountPage.getInStockMenuItem());
        executeJavaScript("arguments[0].click();", conciergeUserAccountPage.getInStockButtonMenu());
        conciergeUserAccountPage.getItemSubCategory().get(0).shouldBe(visible, Duration.ofSeconds(30));
        executeJavaScript("arguments[0].click();", conciergeUserAccountPage.getItemSubCategory().get(0));
    }

    @When("I clicks on o random item")
    public void iClicksOnORandomItem() {
        conciergeItemsScreen.getItems().get(0).shouldBe(visible, Duration.ofSeconds(40));
        conciergeItemsScreen.getItems().get(0).click();
    }


    @When("I fill all options for item")
    public void iFillAllOptionsForItem() {
        selectOption.getQuantityElement().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(40));
        selectOption.getQuantityElement().scrollIntoView(true);

        try {
            conciergeCartPageScreen.getClosePopUp().shouldBe(visible, Duration.ofSeconds(15));
            conciergeCartPageScreen.getClosePopUp().click();
            selectOption.getSelectSizeElement().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(5));
            if (selectOption.getSelectSizeElement().isDisplayed()) {
                Select size = new Select(selectOption.getSelectSizeElement());
                size.selectByIndex(2);
            }
            selectOption.getSelectColorElement().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(5));
            if (selectOption.getSelectColorElement().isDisplayed()) {
                Select color = new Select(selectOption.getSelectColorElement());
                color.selectByIndex(2);
            }
            if (selectOption.getQuantityElement().isDisplayed()) {
                Select quantity = new Select(selectOption.getQuantityElement());
                quantity.selectByIndex(2);
            }

        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Element is not displayed");
        }
    }

    @When("I click on checkout button")
    public void iClickOnCheckoutButton() {
        conciergeCartPageScreen.getOrderClassificationSelect().shouldBe(Condition.be(visible), Duration.ofSeconds(15));
        Select select = new Select(conciergeCartPageScreen.getOrderClassificationSelect());
        select.selectByIndex(1);
        conciergeItemsScreen.getCheckoutButton().shouldBe(visible, Duration.ofSeconds(12));
        conciergeItemsScreen.getCheckoutButton().click();

        try {
            conciergeCartPageScreen.getAgreeTermsForSaleCheckbox().shouldBe(Condition.be(visible), Duration.ofSeconds(4));
            conciergeCartPageScreen.getAgreeTermsForSaleCheckbox().click();

            conciergeCartPageScreen.getUpdateButton().shouldBe(Condition.be(visible), Duration.ofSeconds(4));
            conciergeCartPageScreen.getUpdateButton().click();

            sleep(3000);
            conciergeItemsScreen.getCheckoutButton().scrollIntoView(true);
            sleep(2000);
            conciergeItemsScreen.getCheckoutButton().click();


        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("I agree to the Terms of Sale for Special Orders is not displayed");
        }

        try {
            conciergeCartPageScreen.getNoThanksButton().shouldBe(visible, Duration.ofSeconds(12));
            if (conciergeCartPageScreen.getNoThanksButton().isDisplayed()) {
                conciergeCartPageScreen.getNoThanksButton().click();
            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("No thanks button is not displayed");
        }
        try {
            conciergeUserAccountPage.getClientLookupFirstName().shouldBe(visible, Duration.ofMinutes(1));
            Selenide.sleep(3000);
            conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
            conciergeUserAccountPage.getClientLookupLastName().setValue("Member");
            conciergeUserAccountPage.getClientLookupSearchButton().click();
            conciergeOrderHistoryForm.getCustomerFirstName().shouldBe(visible, Duration.ofSeconds(15));
            conciergeUserAccountPage.getFirstResultOfClientLookup().shouldBe(visible, Duration.ofSeconds(15));
            conciergeUserAccountPage.getFirstResultOfClientLookup().click();
            conciergeItemsScreen.getCheckoutButton().shouldBe(visible, Duration.ofSeconds(12));
            conciergeItemsScreen.getCheckoutButton().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Client is selected");
        }

    }

    @When("I introduces payment details")
    public void iClickOnContinueToPaymentButton() {
        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(1));
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment.selectByIndex(3);

        switchTo().frame($(By.cssSelector("iframe[title='Iframe for secured card data input field']")).shouldBe(visible, Duration.ofMinutes(1)));
        paymentScreen.getCardNumberField().setValue("4678475330157543");
        switchTo().defaultContent();
        switchTo().frame($(By.xpath("//div[contains(@class,'securityCode')]//iframe[@class='js-iframe']")).shouldBe(visible, Duration.ofMinutes(1)));
        paymentScreen.getCvcField().setValue("737");
        switchTo().defaultContent();

        switchTo().frame($(By.xpath("//div[contains(@class,'expiryDate')]//iframe[@title='Iframe for secured card data input field']")).shouldBe(visible, Duration.ofMinutes(1)));
        paymentScreen.getExpiryDateField().setValue("0330");
        switchTo().defaultContent();

        paymentScreen.getContinueToReview().click();

    }

    @And("I verify that review screen is displayed")
    public void iVerifyThatReviewScreenIsDisplayed() {
        reviewOrderScreen.getBillingAddress().shouldBe(visible, Duration.ofMinutes(1));
        reviewOrderScreen.getShippingAddress().shouldBe(visible, Duration.ofMinutes(1));
    }

    @When("I click on a place order button")
    public void iClickOnPlaceOrderButton() {
        reviewOrderScreen.getPlaceOrderButton().shouldBe(enabled, Duration.ofMinutes(3));
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        reviewOrderScreen.getPlaceOrderButton().shouldBe(enabled, Duration.ofMinutes(1));
        reviewOrderScreen.getPlaceOrderButton().click();

        try {
            confirmationOrderScreen.getAcceptPlaceOrderBtn().shouldBe(Condition.be(visible), Duration.ofSeconds(5));
            executeJavaScript("arguments[0].click();", confirmationOrderScreen.getSpoTermsCheckBox());
            confirmationOrderScreen.getSignatureArea().click();
            confirmationOrderScreen.getAcceptPlaceOrderBtn().scrollIntoView(true);
            confirmationOrderScreen.getAcceptPlaceOrderBtn().shouldBe(Condition.be(visible), Duration.ofSeconds(5));
            executeJavaScript("arguments[0].click();", confirmationOrderScreen.getAcceptPlaceOrderBtn());
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Order terms popup is not displayed");
        }
    }

    @Then("I verify that confirmation order screen is displayed")
    public void iVerifyThatOrderDetailsScreenIsDisplayed() {
        confirmationOrderScreen.getThankYouTitle().shouldBe(visible, Duration.ofSeconds(25));
        assertTrue(confirmationOrderScreen.getYourOrderHasBeenPlaced().isDisplayed());
        assertTrue(confirmationOrderScreen.getThankYouTitle().isDisplayed());

    }

    @When("I fill all fields from address screen")
    public void iFillAllFieldsFromAddressScreenForBrands() {
        try {
            checkoutAddressScreen.getFirstNameInpt().shouldBe(visible, Duration.ofMinutes(1));
            if (checkoutAddressScreen.getFirstNameInpt().isDisplayed()) {
                generalStepDefs.fillAddressFields();
                generalStepDefs.fillZipCodeStateCountry("12345", "US", "");
            }
//            sleep(2000);
//            executeJavaScript("arguments[0].scrollIntoView(true);", checkoutAddressScreen.getBillingAddressAsShippingCheckBox());
//            sleep(2000);
//            executeJavaScript("arguments[0].click();", checkoutAddressScreen.getBillingAddressAsShippingCheckBox());
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Address fields are not available");
        }
    }

    @When("I clicks on a random menu item for brands")
    public void iClicksOnARandomMenuItemForBrands() {
        await().forever().until(() -> conciergeUserAccountPage.getMenuItems().get(0).isDisplayed());
        conciergeUserAccountPage.getMenuItems().get(0).shouldBe(visible);
        conciergeUserAccountPage.getMenuItems().get(0).scrollIntoView(true);
        conciergeUserAccountPage.getMenuItems().get(0).click();
        conciergeUserAccountPage.getItemSubCategory().get(0).shouldBe(visible);
        conciergeUserAccountPage.getItemSubCategory().get(0).scrollIntoView(true);
        conciergeUserAccountPage.getItemSubCategory().get(0).click();
    }

    @When("I click on rh concierge logo")
    public void iClickOnRhConciergeLogo() {
        conciergeUserAccountPage.getRhConciergeLogo().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(20));
        conciergeUserAccountPage.getRhConciergeLogo().click();
    }

    @When("I add item to cart")
    public void iAddItemToCart() {
        for (int i = 0; i < 150; i++) {
            sleep(2000);
            open("https://rhbabyandchild.stg2.rhnonprod.com/search/results.jsp?Ntt=toddler+bedding&N=%7B%21tag%3Dsku_stocked%7Dsku_stocked%3A%28%22In-Stock%22%29+AND+%7B%21tag%3DBC_category_L0%7DBC_category_L0%3A%28%22Bedding%22%29&Ns=product.sale%7C1&topCatId=cat23860004&parentCatId=cat23540105&fromNav=true");

            for (int j = 0; j < 5; j++) {
                executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
                sleep(1000);
            }
            int element = generalStepDefs.getRandomNumber(0, conciergeUserAccountPage.getToddlerBeddingList().size());
            conciergeUserAccountPage.getToddlerBeddingList().get(element).click();

            conciergeItemsScreen.getAddToCartButton().shouldBe(visible, Duration.ofSeconds(20));
            conciergeItemsScreen.getAddToCartButton().click();

            conciergeCartPageScreen.getClosePopUp().shouldBe(visible, Duration.ofSeconds(15));
            conciergeCartPageScreen.getClosePopUp().click();
        }
    }


    @When("I add items in cart")
    public void iAddItemsInCart() {
        for (int i = 0; i < 10; i++) {
            conciergeUserAccountPage.getInStockMenuItem().shouldBe(visible, Duration.ofSeconds(20));
            conciergeUserAccountPage.getInStockMenuItem().click();
            conciergeUserAccountPage.getInStockBedding().shouldBe(visible, Duration.ofSeconds(20));
            conciergeUserAccountPage.getInStockBedding().click();
            conciergeUserAccountPage.getBeds().shouldBe(visible, Duration.ofSeconds(20));
            conciergeUserAccountPage.getBeds().click();

            for (int j = 0; j < 5; j++) {
                executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
                sleep(1000);
            }
            $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-true']/div/ul[@class='MuiGridList-root']/li[@class='MuiGridListTile-root']")).shouldBe(visible, Duration.ofSeconds(20));
            int element = generalStepDefs.getRandomNumber(0, conciergeUserAccountPage.getToddlerBeddingList().size());
            conciergeUserAccountPage.getToddlerBeddingList().get(element).click();
            conciergeItemsScreen.getAddToCartButton().shouldBe(visible, Duration.ofSeconds(20));
            conciergeItemsScreen.getAddToCartButton().scrollIntoView(true);
            conciergeItemsScreen.getAddToCartButton().click();

            conciergeCartPageScreen.getColorCloseButton().shouldBe(visible, Duration.ofSeconds(20));
            conciergeCartPageScreen.getColorCloseButton().click();
        }

    }
}

