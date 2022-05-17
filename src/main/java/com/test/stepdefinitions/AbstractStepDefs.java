package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
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
        sleep(7000);
        conciergeUserAccountPage.getFirstItemMainMenu().should(visible, Duration.ofSeconds(60));
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(conciergeUserAccountPage.getFirstItemMainMenu());
        conciergeUserAccountPage.getFirstItemMainMenu().click();
        conciergeUserAccountPage.getItemSubCategory().get(0).should(visible, Duration.ofSeconds(30));
        conciergeUserAccountPage.getItemSubCategory().get(0).click();
    }

    @When("I clicks on o random item")
    public void iClicksOnORandomItem() {
        generalStepDefs.waitForLoad(WebDriverRunner.getWebDriver());
        try {
            conciergeItemsScreen.getItems().get(1).should(visible, Duration.ofMinutes(1));
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
        generalStepDefs.waitForLoad(WebDriverRunner.getWebDriver());
        try {
            conciergeCartPageScreen.getOrderClassificationSelect().should(Condition.and("Displayed", visible, enabled), Duration.ofMinutes(1));
            conciergeCartPageScreen.getOrderClassificationSelect().shouldHave(text(conciergeCartPageScreen.getOrderClassificationSelect().getText()), Duration.ofMinutes(1));

            Select select = new Select(conciergeCartPageScreen.getOrderClassificationSelect());
            select.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Order classification is selected");
        }
        conciergeItemsScreen.getCheckoutButton().should(Condition.and("Displayed", visible, enabled), Duration.ofMinutes(1));
        conciergeItemsScreen.getCheckoutButton().shouldHave(text(conciergeItemsScreen.getCheckoutButton().getText()), Duration.ofMinutes(2));
        conciergeItemsScreen.getCheckoutButton().click();
    }

    @When("I introduces payment details")
    public void iClickOnContinueToPaymentButton() {
        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(5));
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment.selectByIndex(3);

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
        reviewOrderScreen.getPlaceOrderButton().should(enabled, Duration.ofMinutes(3));
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
        confirmationOrderScreen.getThankYouTitle().should(visible, Duration.ofSeconds(25));
        assertTrue(confirmationOrderScreen.getYourOrderHasBeenPlaced().isDisplayed());
        assertTrue(confirmationOrderScreen.getThankYouTitle().isDisplayed());

    }

    @When("I fill all fields from address screen")
    public void iFillAllFieldsFromAddressScreenForBrands() {
        generalStepDefs.waitForLoad(WebDriverRunner.getWebDriver());
        try {
            checkoutAddressScreen.getFirstNameInpt().should(Condition.and("", enabled, visible), Duration.ofMinutes(1));
            if (checkoutAddressScreen.getFirstNameInpt().isDisplayed()) {
                generalStepDefs.fillAddressFields();
                generalStepDefs.fillZipCodeStateCountry("12345", "US", "");
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

    @When("I add item to cart")
    public void iAddItemToCart() {
        for (int i = 0; i < 150; i++) {
            open("https://rhbabyandchild.stg2.rhnonprod.com/search/results.jsp?Ntt=toddler+bedding&N=%7B%21tag%3Dsku_stocked%7Dsku_stocked%3A%28%22In-Stock%22%29+AND+%7B%21tag%3DBC_category_L0%7DBC_category_L0%3A%28%22Bedding%22%29&Ns=product.sale%7C1&topCatId=cat23860004&parentCatId=cat23540105&fromNav=true");

            for (int j = 0; j < 5; j++) {
                executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
                sleep(1000);
            }
            int element = generalStepDefs.getRandomNumber(0, conciergeUserAccountPage.getToddlerBeddingList().size());
            conciergeUserAccountPage.getToddlerBeddingList().get(element).click();

            conciergeItemsScreen.getAddToCartButton().should(visible, Duration.ofSeconds(20));
            conciergeItemsScreen.getAddToCartButton().click();

            conciergeCartPageScreen.getClosePopUp().should(visible, Duration.ofSeconds(15));
            conciergeCartPageScreen.getClosePopUp().click();
        }
    }


    @When("I add items in cart")
    public void iAddItemsInCart() {
        for (int i = 0; i < 10; i++) {
            conciergeUserAccountPage.getInStockMenuItem().should(visible, Duration.ofSeconds(20));
            conciergeUserAccountPage.getInStockMenuItem().click();
            conciergeUserAccountPage.getInStockBedding().should(visible, Duration.ofSeconds(20));
            conciergeUserAccountPage.getInStockBedding().click();
            conciergeUserAccountPage.getBeds().should(visible, Duration.ofSeconds(20));
            conciergeUserAccountPage.getBeds().click();

            for (int j = 0; j < 5; j++) {
                executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
                sleep(1000);
            }
            $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-true']/div/ul[@class='MuiGridList-root']/li[@class='MuiGridListTile-root']")).should(visible, Duration.ofSeconds(20));
            int element = generalStepDefs.getRandomNumber(0, conciergeUserAccountPage.getToddlerBeddingList().size());
            conciergeUserAccountPage.getToddlerBeddingList().get(element).click();
            conciergeItemsScreen.getAddToCartButton().should(visible, Duration.ofSeconds(20));
            conciergeItemsScreen.getAddToCartButton().scrollIntoView(true);
            conciergeItemsScreen.getAddToCartButton().click();
            conciergeCartPageScreen.getColorCloseButton().should(visible, Duration.ofSeconds(20));
            conciergeCartPageScreen.getColorCloseButton().click();
        }

    }
}

