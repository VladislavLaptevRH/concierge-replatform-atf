package com.test.stepdefinitions;

import com.codeborne.selenide.SelenideElement;
import com.test.pageObject.*;
import com.test.utility.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.awaitility.Awaitility.await;
import static org.testng.Assert.assertTrue;

public class AbstractStepDefs {
    ConciergeOrderHistoryForm conciergeOrderHistoryForm = new ConciergeOrderHistoryForm();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    PaymentScreen paymentScreen = new PaymentScreen();
    ReviewOrderScreen reviewOrderScreen = new ReviewOrderScreen();
    ConfirmationOrderScreen confirmationOrderScreen = new ConfirmationOrderScreen();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    RestrictionPopUp restrictionPopUp = new RestrictionPopUp();


    @When("I clicks on a random menu item")
    public void iClicksOnARandomMenuItem() {
//        generalStepDefs.isElementVisible("//h1[@class='MuiTypography-root MuiTypography-h1']");
//        wait.until(ExpectedConditions.textToBePresentInElement(conciergeUserAccountPage.getDashboardTitle(), "DASHBOARD"));
//        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getOrderHistoryButton()));

        $(conciergeUserAccountPage.getMenuItems().get(0)).shouldBe(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getMenuItems().get(0).click();

        $(conciergeUserAccountPage.getItemSubCategory().get(2)).shouldBe(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getItemSubCategory().get(2).click();
    }


    @When("I clicks on o random item")
    public void iClicksOnORandomItem() {
        $(conciergeItemsScreen.getItems().get(0)).shouldBe(visible, Duration.ofSeconds(12));
        generalStepDefs.isElementVisible("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-true']/div/ul//li[@class='MuiGridListTile-root']");
        conciergeItemsScreen.getItems().get(0).click();
    }


    @When("I fill all options for item")
    public void iFillAllOptionsForItem() throws InterruptedException {
        restrictionPopUp.getShippingRestricitonsTitle().shouldBe(visible, Duration.ofMinutes(2));
        String currentUrl = Hooks.getCurrentUrl();
        String currentProduct;
        if (currentUrl.contains("&")) {
            currentProduct = currentUrl.substring(currentUrl.indexOf("="), currentUrl.indexOf("&")).
                    replace("=", "");
        } else {
            currentProduct = currentUrl.substring(currentUrl.indexOf("="), 96).replace("=", "");
            SelenideElement sizeOption = $(By.xpath("//select[@id='optionSelect-" + currentProduct + "-Size']"));
            Select selectSize = new Select(sizeOption);
            selectSize.selectByIndex((1));
            Thread.sleep(2000);
            SelenideElement colorOption = $(By.xpath("//select[@id='optionSelect-" + currentProduct + "-Color']"));
            colorOption.shouldBe(visible,Duration.ofSeconds(12));
            Select selectColorOption = new Select(colorOption);
            selectColorOption.selectByIndex((1));
        }

        $(By.xpath("//select[@id='" + currentProduct + "-qty-input']//option[3]")).shouldBe(visible, Duration.ofMinutes(1));
        SelenideElement quantity = $(By.xpath("//select[@id='" + currentProduct + "-qty-input']//option[3]"));
        executeJavaScript("arguments[0].scrollIntoView(true);", quantity);
        quantity.click();
    }

    @When("I click on checkout button")
    public void iClickOnCheckoutButton() {
        generalStepDefs.isElementVisible("//select[@id='element-orderclassification']");
        Select select = new Select(conciergeCartPageScreen.getOrderClassificationSelect());
        select.selectByIndex(1);
        $(conciergeItemsScreen.getCheckoutButton()).shouldBe(visible);
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
        $(paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(1)));
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
        reviewOrderScreen.getPlaceOrderButton().shouldBe(visible, Duration.ofMinutes(5));
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
        try {
            if (conciergeUserAccountPage.getClientButton().getText().equals("CLIENT")) {
                conciergeUserAccountPage.getClientButton().click();
                conciergeUserAccountPage.getClientLookupHeaderBtn().shouldBe(visible,Duration.ofSeconds(80));
                conciergeUserAccountPage.getClientLookupHeaderBtn().click();
                conciergeUserAccountPage.getClientLookupFirstName().shouldBe(visible, Duration.ofSeconds(80));
                conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
                conciergeUserAccountPage.getClientLookupLastName().setValue("Member");
                conciergeUserAccountPage.getClientLookupSearchButton().click();
                conciergeOrderHistoryForm.getCustomerFirstName().shouldBe(visible,Duration.ofSeconds(80));
                conciergeUserAccountPage.getFirstResultOfClientLookup().shouldBe(visible, Duration.ofSeconds(80));
                conciergeUserAccountPage.getFirstResultOfClientLookup().click();
                conciergeUserAccountPage.getClientButton().shouldHave().shouldHave(text("Automation"), Duration.ofSeconds(20));
            }
        } catch (Exception e) {
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
}

