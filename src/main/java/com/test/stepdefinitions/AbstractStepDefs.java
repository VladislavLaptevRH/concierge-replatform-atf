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
        conciergeUserAccountPage.getFirstItemMainMenu().shouldBe(visible, Duration.ofSeconds(60));
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(conciergeUserAccountPage.getFirstItemMainMenu());
        conciergeUserAccountPage.getFirstItemMainMenu().click();
        conciergeUserAccountPage.getItemSubCategory().get(0).shouldBe(visible, Duration.ofSeconds(30));
        conciergeUserAccountPage.getItemSubCategory().get(0).click();
    }

    @When("I clicks on o random item")
    public void iClicksOnORandomItem() {
        try {
            sleep(4000);
            conciergeItemsScreen.getItems().get(1).shouldBe(visible, Duration.ofMinutes(1));
            conciergeItemsScreen.getItems().get(1).click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            conciergeItemsScreen.getTwoItemsInRow().get(1).shouldBe(visible, Duration.ofMinutes(1));
            conciergeItemsScreen.getTwoItemsInRow().get(1).click();
            System.out.println("Items section are not displayed");
        }
    }

    @When("I fill all options for item")
    public void iFillAllOptionsForItem() {
        sleep(3000);
        try {
            conciergeCartPageScreen.getColorCloseButton().shouldBe(visible, Duration.ofSeconds(15));
            conciergeCartPageScreen.getColorCloseButton().click();
            selectOption.getSelectSizeElement().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(5));
            if (selectOption.getSelectSizeElement().isDisplayed()) {
                Select size = new Select(selectOption.getSelectSizeElement());
                size.selectByIndex(2);
            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Element is not displayed");
        }

        try {
            selectOption.getQuantityElement().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(40));
            selectOption.getQuantityElement().scrollIntoView(true);
            selectOption.getSelectColorElement().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(5));
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
        try {
            conciergeCartPageScreen.getOrderClassificationSelect().should(Condition.and("Displayed", visible, enabled), Duration.ofMinutes(1));
            conciergeCartPageScreen.getOrderClassificationSelect().shouldHave(text(conciergeCartPageScreen.getOrderClassificationSelect().getText()), Duration.ofMinutes(1));
            sleep(3000);
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
        sleep(4000);
        try {
            checkoutAddressScreen.getFirstNameInpt().shouldBe(Condition.and("", enabled, visible), Duration.ofMinutes(1));
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
        conciergeUserAccountPage.getMenuItems().get(0).shouldBe(visible);
        conciergeUserAccountPage.getMenuItems().get(0).scrollIntoView(true);
        conciergeUserAccountPage.getMenuItems().get(0).click();
        conciergeUserAccountPage.getItemSubCategory().get(0).shouldBe(visible);
        conciergeUserAccountPage.getItemSubCategory().get(0).scrollIntoView(true);
        conciergeUserAccountPage.getItemSubCategory().get(0).click();
    }

    @When("I click on rh concierge logo")
    public void iClickOnRhConciergeLogo() {
        conciergeUserAccountPage.getRhConciergeLogo().shouldBe(Condition.and("", visible, enabled), Duration.ofMinutes(5));
        sleep(5000);
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

