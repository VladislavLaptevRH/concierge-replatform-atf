package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.test.pageObject.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

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

    @When("I clicks on a random menu item")
    public void iClicksOnARandomMenuItem() {
        conciergeUserAccountPage.getInStockButtonMenu().shouldBe(visible, Duration.ofSeconds(30));
        conciergeUserAccountPage.getInStockButtonMenu().click();
        conciergeUserAccountPage.getItemSubCategory().get(2).shouldBe(visible, Duration.ofSeconds(30));
        conciergeUserAccountPage.getItemSubCategory().get(2).click();
    }


    @When("I clicks on o random item")
    public void iClicksOnORandomItem() {
        conciergeItemsScreen.getItems().get(0).shouldBe(visible, Duration.ofSeconds(40));
        conciergeItemsScreen.getItems().get(0).click();
    }


    @When("I fill all options for item")
    public void iFillAllOptionsForItem() {
        selectOption.getQuantityElement().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(20));
        try {
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
        generalStepDefs.isElementVisible("//select[@id='element-orderclassification']");
        Select select = new Select(conciergeCartPageScreen.getOrderClassificationSelect());
        select.selectByIndex(1);
        $(conciergeItemsScreen.getCheckoutButton()).shouldBe(visible, Duration.ofSeconds(25));
        generalStepDefs.isElementVisible("//div[contains(@class,'MuiGrid-root MuiGrid-container MuiGrid-item')][2]//button");
        conciergeItemsScreen.getCheckoutButton().click();

        try {
            if (conciergeCartPageScreen.getNoThanksButton().isDisplayed()) {
                conciergeCartPageScreen.getNoThanksButton().click();
            }
        } catch (Exception e) {
            System.out.println("No thanks button is not displayed");
        }
    }

    @When("I introduces payment details")
    public void iClickOnContinueToPaymentButton() {
        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(1));
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment.selectByIndex(3);


        switchTo().frame($(By.cssSelector("iframe[title='Iframe for secured card data input field']")).shouldBe(visible, Duration.ofSeconds(15)));
        paymentScreen.getCardNumberField().setValue("4678475330157543");
        switchTo().defaultContent();
        switchTo().frame($(By.xpath("//div[contains(@class,'securityCode')]//iframe[@class='js-iframe']")).shouldBe(visible, Duration.ofSeconds(15)));
        paymentScreen.getCvcField().setValue("737");
        switchTo().defaultContent();

        switchTo().frame($(By.xpath("//div[contains(@class,'expiryDate')]//iframe[@title='Iframe for secured card data input field']")).shouldBe(visible, Duration.ofSeconds(15)));
        paymentScreen.getExpiryDateField().setValue("0330");
        switchTo().defaultContent();

        paymentScreen.getContinueToReview().click();

    }

    @Then("I verify that review screen is displayed")
    public void iVerifyThatReviewScreenIsDisplayed() {
        reviewOrderScreen.getBillingAddress().shouldBe(visible, Duration.ofSeconds(15));
        reviewOrderScreen.getShippingAddress().shouldBe(visible, Duration.ofSeconds(15));
        executeJavaScript("arguments[0].scrollIntoView(true);", reviewOrderScreen.getPlaceOrderButton());
    }

    @When("I click on a place order button")
    public void iClickOnPlaceOrderButton() {
        reviewOrderScreen.getPlaceOrderButton().shouldBe(enabled, Duration.ofMinutes(5));
        reviewOrderScreen.getPlaceOrderButton().scrollIntoView(true);
        reviewOrderScreen.getPlaceOrderButton().click();
    }

    @Then("I verify that confirmation order screen is displayed")
    public void iVerifyThatOrderDetailsScreenIsDisplayed() {
        confirmationOrderScreen.getThankYouTitle().shouldBe(visible, Duration.ofSeconds(25));
        assertTrue(confirmationOrderScreen.getYourOrderHasBeenPlaced().isDisplayed());
        assertTrue(confirmationOrderScreen.getThankYouTitle().isDisplayed());

    }

    @When("I choose client from header")
    public void iChooseClientFromHeader() {
        SelenideElement noClientButton = $(By.xpath("//*[text()='Client']"));
        try {
            noClientButton.shouldBe(visible, Duration.ofSeconds(5));
            if (noClientButton.isDisplayed()) {
                conciergeUserAccountPage.getClientButton().click();
                conciergeUserAccountPage.getClientLookupBtnId().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(15));
                conciergeUserAccountPage.getClientLookupBtnId().click();
                conciergeUserAccountPage.getClientLookupFirstName().shouldBe(visible, Duration.ofSeconds(25));
                conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
                conciergeUserAccountPage.getClientLookupLastName().setValue("Member");
                conciergeUserAccountPage.getClientLookupSearchButton().click();
                conciergeOrderHistoryForm.getCustomerFirstName().shouldBe(visible, Duration.ofSeconds(25));
                conciergeUserAccountPage.getFirstResultOfClientLookup().shouldBe(visible, Duration.ofSeconds(25));
                conciergeUserAccountPage.getFirstResultOfClientLookup().click();
                conciergeUserAccountPage.getClientButton().shouldHave().shouldHave(text("Automation"), Duration.ofSeconds(20));
            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Client is selected");
        }

    }

    @When("I fill all fields from address screen")
    public void iFillAllFieldsFromAddressScreenForBrands() {
        try {
            generalStepDefs.fillAddressFields();
            generalStepDefs.fillZipCodeStateCountry("12345", "US", "");
        } catch (Exception e) {
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
        conciergeUserAccountPage.getRhConciergeLogo().shouldBe(visible, Duration.ofSeconds(60));
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


            List<SelenideElement> toddlerBedding = $$(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-true']/div/ul[@class='MuiGridList-root']/li[@class='MuiGridListTile-root']"));
            int element = generalStepDefs.getRandomNumber(0, toddlerBedding.size());
            toddlerBedding.get(element).click();

            conciergeItemsScreen.getAddToCartButton().shouldBe(visible, Duration.ofSeconds(20));
            conciergeItemsScreen.getAddToCartButton().click();

            $(By.xpath("//button[@data-testid='dialog-title-close-button']")).shouldBe(visible, Duration.ofSeconds(25));
            $(By.xpath("//button[@data-testid='dialog-title-close-button']")).click();
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
            List<SelenideElement> toddlerBedding = $$(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-true']/div/ul[@class='MuiGridList-root']/li[@class='MuiGridListTile-root']"));
            int element = generalStepDefs.getRandomNumber(0, toddlerBedding.size());
            toddlerBedding.get(element).click();
            conciergeItemsScreen.getAddToCartButton().shouldBe(visible, Duration.ofSeconds(20));
            conciergeItemsScreen.getAddToCartButton().scrollIntoView(true);
            conciergeItemsScreen.getAddToCartButton().click();

            $(By.xpath("//div[@class='MuiDialogTitle-root']/button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit']")).shouldBe(visible, Duration.ofSeconds(20));
            SelenideElement closeButton = $(By.xpath("//div[@class='MuiDialogTitle-root']/button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit']"));
            closeButton.click();
        }

    }
}

