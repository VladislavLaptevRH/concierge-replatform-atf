package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.test.pageObject.*;
import com.test.utility.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.test.stepdefinitions.GeneralStepDefs.sleep;
import static org.awaitility.Awaitility.await;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ConciergeE2EStepDefs {
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen();
    RestrictionPopUp restrictionPopUp = new RestrictionPopUp();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();
    ConciergeOrderHistoryForm conciergeOrderHistoryForm = new ConciergeOrderHistoryForm();
    PaymentScreen paymentScreen = new PaymentScreen();
    SelectOption selectOption = new SelectOption();
    String usState = "";

    @When("I click on add to project button")
    public void userClickOnAddToProjectButton() {
        conciergeItemsScreen.getAddToProjectButton().shouldBe(visible, Duration.ofSeconds(12));
        conciergeItemsScreen.getAddToProjectButton().click();

        conciergeItemsScreen.getSaveProjectPopUpButton().shouldBe(visible, Duration.ofSeconds(12));
        conciergeItemsScreen.getSaveProjectPopUpButton().click();

        generalStepDefs.isElementVisible("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4'][1]//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained')]");
        conciergeItemsScreen.getGoToProjectButton().click();
    }

    @When("I click on go to project button")
    public void iClickOnGoToProjectButton() {
        generalStepDefs.isElementVisible("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4'][1]//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained')]");
        conciergeItemsScreen.getContinueShoppingButton().shouldBe(visible, Duration.ofSeconds(12));

        conciergeItemsScreen.getGoToProjectButton().click();
    }

    @When("I click on add to cart button from project screen")
    public void iClickOnAddToCartButtonFromProjectScreen() {
        generalStepDefs.isElementVisible("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth']/span[@class='MuiButton-label']");
        SelenideElement element = $(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth']/span[@class='MuiButton-label']"));
        executeJavaScript("arguments[0].click();", element);
    }

    @When("I choose random brand from menu")
    public void iChooseRandomBrandFromMenu() {
        conciergeUserAccountPage.getDashboardTitle().shouldBe(visible, Duration.ofSeconds(12));
        conciergeUserAccountPage.getOrderHistoryButton().shouldBe(visible, Duration.ofSeconds(12));
        conciergeUserAccountPage.getBrandButton().click();
        conciergeUserAccountPage.getListOfBrands().get(1).click();

    }

    @When("I go to item which has {string} restriction")
    public void iGoToItemWhichHasRestriction(String state) {
        usState = state;
        if (state.equals("NY")) {
            conciergeUserAccountPage.getSearchItemField().shouldBe(visible, Duration.ofSeconds(15));
            conciergeUserAccountPage.getSearchItemField().setValue("112411 BLSH BUMP");
            conciergeUserAccountPage.getSearchButton().click();
        }
        if (state.equals("CA")) {
            conciergeUserAccountPage.getSearchItemField().shouldBe(visible, Duration.ofSeconds(15));
            conciergeUserAccountPage.getSearchItemField().setValue("102980 IVOR");
            conciergeUserAccountPage.getSearchButton().click();
//            generalStepDefs.isElementVisible("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-true']/div/ul//li[@class='MuiGridListTile-root']");
            conciergeItemsScreen.getItems().get(0).shouldBe(visible, Duration.ofSeconds(12));
            conciergeItemsScreen.getItems().get(0).click();
        }
        try {
            conciergeUserAccountPage.getSeeResultsButton().shouldBe(visible, Duration.ofSeconds(15));
            if (conciergeUserAccountPage.getSeeResultsButton().isDisplayed()) {
                conciergeUserAccountPage.getSeeResultsButton().click();
            }
        } catch (com.codeborne.selenide.ex.InvalidStateException e) {
            System.out.println("See results button is not displayed");
        }

    }

    @When("I click on add to cart button")
    public void iClickOnAddToCartButton() {
        conciergeItemsScreen.getAddToCartButton().shouldBe(visible, Duration.ofSeconds(30));
        executeJavaScript("arguments[0].click();", conciergeItemsScreen.getAddToCartButton());
        if (usState.equals("CA")) {
            try {
                $(By.xpath("//button[@id='spo-auth-addToCart']")).shouldBe(visible, Duration.ofSeconds(5));
                conciergeItemsScreen.getAggreeeAndAddToCardButton().click();
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                System.out.println("Agree&add to card button is not displayed");
            }
        }
        conciergeItemsScreen.getViewCartButton().shouldBe(visible, Duration.ofSeconds(25));
        conciergeItemsScreen.getViewCartButton().click();
    }

    @When("I fill all fields from address with {string} zip code")
    public void iFillAllFieldsFromAddressWithZipCode(String state) {
        generalStepDefs.fillAddressFields();

        if (state.equals("NY")) {
            generalStepDefs.fillZipCodeStateCountry("10001", "US", "NY");
        }
        if (state.equals("CA")) {
            generalStepDefs.fillZipCodeStateCountry("A1A1A1", "CA", "");

        }
        generalStepDefs.continueToPaymentAfterAddressCheckout();
    }

    @Then("I verify that restrictions pop up is displayed")
    public void iVerifyThatRestrictionsPopUpIsDisplayed() {
        restrictionPopUp.getShippingRestricitonsTitle().shouldBe(visible, Duration.ofSeconds(40));
        assertTrue(restrictionPopUp.getShippingRestricitonsTitle().getText().contains("SHIPPING ERROR"));
        assertTrue(restrictionPopUp.getRestrictionsMessage().getText().contains("One or more items in your cart"));
    }

    @When("I remove all items from cart")
    public void iRemoveAllItemsFromCart() {
        conciergeUserAccountPage.getCartButton().shouldBe(visible, Duration.ofSeconds(15));
        if (!conciergeUserAccountPage.getCartButton().getText().equals("CART 0")) {
            conciergeUserAccountPage.getCartButton().click();
            while (true) {
                try {
                    WebElement closePopUp = $((By.xpath("//button[@data-testid='form-dialog-close-button']")));
                    if (closePopUp.isDisplayed()) {
                        closePopUp.click();
                    }
                } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                    System.out.println("Pop up is not appeared");
                }
                try {
                    SelenideElement selenideElement = $(By.xpath("//*[text()='Remove']"));
                    selenideElement.click();
                } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                    conciergeCartPageScreen.getPleaseContinueBrowsingButton().shouldBe(visible, Duration.ofSeconds(12));
                    conciergeCartPageScreen.getPleaseContinueBrowsingButton().click();
                    break;
                }
            }
        }
    }


    @When("I continue to payment")
    public void continueToPaymentAfterAddressCheckout() {
        checkoutAddressScreen.getContinuePaymentButton().shouldBe(visible, Duration.ofSeconds(40));
        executeJavaScript("arguments[0].scrollIntoView(true);", checkoutAddressScreen.getContinuePaymentButton());
        checkoutAddressScreen.getContinuePaymentButton().click();

        try {
            checkoutAddressScreen.getContinueButton().shouldBe(visible, Duration.ofSeconds(30));
            executeJavaScript("arguments[0].click();", checkoutAddressScreen.getContinueButton());
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Continue from popup is not displayed");
        }

    }

    @When("I introduces payment details for several payment methods")
    public void iIntroducesPaymentDetailsForSeveralPaymentMethods() {
        $(paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(1)));
        sleep(2);
        generalStepDefs.payWith("VI", "4678 4753 3015 7543", "737", "0330");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("30");
        paymentScreen.getContinueToReview().shouldBe(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();

        sleep(4);
        generalStepDefs.payWith("AX", "3411 3411 3411 347", "6765", "0225");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("30");
        paymentScreen.getContinueToReview().shouldBe(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();

        sleep(4);
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment.selectByValue("RH");
        paymentScreen.getSplitPaymentCheckBox().shouldBe(visible, Duration.ofSeconds(20));
        paymentScreen.getSplitPaymentCheckBox().click();
        paymentScreen.getRhCardNumberField().setValue("5856373200177801");
        Select paymentPlan = new Select(paymentScreen.getSelectPaymentPlan());
        paymentPlan.selectByValue("001");
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("10");
        paymentScreen.getContinueToReview().shouldBe(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();

        sleep(4);
        Select selectPayment1 = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment1.selectByValue("GiftCard");
        paymentScreen.getRhCardNumberField().setValue("6006493887999902500");
        paymentScreen.getRhCardPin().setValue("8138");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("1");
        paymentScreen.getContinueToReview().shouldBe(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();


        sleep(4);
        generalStepDefs.payWith("DI", "6011 6011 6011 6611", "737", "0330");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("10");
        paymentScreen.getContinueToReview().shouldBe(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();

        sleep(4);
        generalStepDefs.payWith("MC", "2222 4000 1000 0008", "737", "0330");
        paymentScreen.getContinueToReview().shouldBe(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));

        paymentScreen.getContinueToReview().click();

    }


    @When("I add {int} times an item in the cart")
    public void iAddTimesAnItemInTheCart(int arg0) throws InterruptedException {
        for (int i = 0; i < 70; i++) {
            $(By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1']")).shouldBe(visible, Duration.ofMinutes(1));
            conciergeUserAccountPage.getDashboardTitle().shouldHave(text("DASHBOARD"));
            conciergeUserAccountPage.getOrderHistoryButton().shouldBe(visible, Duration.ofSeconds(12));

            Random rand = new Random();

            conciergeUserAccountPage.getMenuItems().get(2).scrollIntoView(true);
            conciergeUserAccountPage.getMenuItems().get(2).click();

            conciergeUserAccountPage.getItemSubCategory().get(0).shouldBe(visible, Duration.ofMinutes(1));
            Thread.sleep(2000);
            conciergeUserAccountPage.getItemSubCategory().get(0).scrollIntoView(true);
            conciergeUserAccountPage.getItemSubCategory().get(0).click();


            SelenideElement SelenideElement = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12'][1]//li"));
            SelenideElement.click();

            $(By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1']")).shouldBe(visible, Duration.ofMinutes(1));
            await().forever().until(() -> conciergeItemsScreen.getCollectionsItems().get(0).isDisplayed());
            conciergeItemsScreen.getCollectionsItems().get(1 + rand.nextInt((1 - 0) + 1)).click();

            generalStepDefs.isElementVisible("//h2[@class='MuiTypography-root MuiTypography-h2']");
            String currentUrl = Hooks.getCurrentUrl();
            String currentProduct = currentUrl.substring(currentUrl.indexOf("="), currentUrl.indexOf("&")).replace("=", "");

            generalStepDefs.isElementVisible("//select[@id='" + currentProduct + "-qty-input']//option[3]");
            SelenideElement quantity = $(By.xpath("//select[@id='" + currentProduct + "-qty-input']"));
            executeJavaScript("arguments[0].scrollIntoView(true);", quantity);
            SelenideElement sizeOption = $(By.xpath("//select[@id='optionSelect-" + currentProduct + "-Size']"));
            await().forever().until(quantity::isDisplayed);
            quantity.click();

            Select selectSize = new Select(sizeOption);
            selectSize.selectByIndex(GeneralStepDefs.getRandomNumberInRange(1, 3));
            sizeOption.click();

            SelenideElement finishOption = $(By.xpath("//select[@id='optionSelect-" + currentProduct + "-Finish']"));
            finishOption.click();

            Select select = new Select(finishOption);
            select.selectByIndex(GeneralStepDefs.getRandomNumberInRange(1, 9));

            Select quantityButton = new Select(quantity);
            quantityButton.selectByIndex(2);


            $(By.xpath("//div[1]/div[@class='MuiFormControl-root MuiFormControl-fullWidth']/button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']")).shouldBe(visible, Duration.ofSeconds(12));
            conciergeItemsScreen.getAddToCartButton().click();

            $(By.xpath("//div[@class='MuiDialogTitle-root']/button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit']")).shouldBe(visible, Duration.ofSeconds(12));
            SelenideElement closeButton = $(By.xpath("//div[@class='MuiDialogTitle-root']/button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit']"));
            closeButton.click();

            $(By.xpath("//a[@id='nav-logo-img']")).shouldBe(visible, Duration.ofSeconds(12));
            SelenideElement logoButton = $(By.xpath("//a[@id='nav-logo-img']"));
            logoButton.click();
        }
    }

    @When("I go to item {string} from search field")
    public void iGoToItemFromSearchField(String arg0) {
        sleep(3);
        generalStepDefs.isElementVisible("//input[contains(@class,'MuiOutlinedInput-inputAdornedStart')]");
        conciergeUserAccountPage.getSearchItemField().setValue(arg0);
        conciergeUserAccountPage.getSearchButton().shouldBe(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getSearchButton().click();
        conciergeUserAccountPage.getSeeResultsButton().shouldBe(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getSeeResultsButton().click();
    }

    @When("I choose {string} from brand menu")
    public void iChooseFromBrandMenu(String brand) {
        conciergeUserAccountPage.getBrandButton().shouldBe(visible, Duration.ofSeconds(12));
        conciergeUserAccountPage.getBrandButton().click();

        if (brand.equals("RH Modern")) {
            conciergeUserAccountPage.getListOfBrands().get(1).shouldBe(visible, Duration.ofSeconds(12));
            conciergeUserAccountPage.getListOfBrands().get(1).click();
        }
        if (brand.equals("RH Baby&Child")) {
            conciergeUserAccountPage.getListOfBrands().get(2).shouldBe(visible, Duration.ofSeconds(12));
            conciergeUserAccountPage.getListOfBrands().get(2).click();
        }
        if (brand.equals("RH Teen")) {
            conciergeUserAccountPage.getListOfBrands().get(3).shouldBe(visible, Duration.ofSeconds(12));
            conciergeUserAccountPage.getListOfBrands().get(3).click();
        }
        if (brand.equals("RH Outdoor")) {
            conciergeUserAccountPage.getListOfBrands().get(4).shouldBe(visible, Duration.ofSeconds(12));
            conciergeUserAccountPage.getListOfBrands().get(4).click();
        }
        if (brand.equals("RH SKI House")) {
            conciergeUserAccountPage.getListOfBrands().get(5).shouldBe(visible, Duration.ofSeconds(12));
            conciergeUserAccountPage.getListOfBrands().get(5).click();
        }
        if (brand.equals("RH Beach House")) {
            conciergeUserAccountPage.getListOfBrands().get(6).shouldBe(visible, Duration.ofSeconds(12));
            conciergeUserAccountPage.getListOfBrands().get(6).click();
        }
        if (brand.equals("RH Interiors")) {
            conciergeUserAccountPage.getListOfBrands().get(7).shouldBe(visible, Duration.ofSeconds(12));
            conciergeUserAccountPage.getListOfBrands().get(7).click();
        }
    }


    @When("I click on no thanks button")
    public void iClickOnNoThanksButton() {
        generalStepDefs.isElementVisible("//select[@id='element-orderclassification']");
        Select select = new Select(conciergeCartPageScreen.getOrderClassificationSelect());
        select.selectByIndex(1);
        conciergeItemsScreen.getCheckoutButton().shouldBe(visible, Duration.ofSeconds(12));
        generalStepDefs.isElementVisible("//div[contains(@class,'MuiGrid-root MuiGrid-container MuiGrid-item')][2]//button");
        conciergeItemsScreen.getCheckoutButton().click();

        try {
            conciergeCartPageScreen.getNoThanksButton().shouldBe(visible, Duration.ofSeconds(5));
            conciergeCartPageScreen.getNoThanksButton().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("No thanks button is not displayed");
        }
    }


    @When("I choose client who is a non member")
    public void iChooseClientWhoIsANonMember() {
        try {
            if (conciergeUserAccountPage.getClientButton().getText().equals("CLIENT")) {
                conciergeUserAccountPage.getClientButton().click();
                generalStepDefs.isElementVisible("//span[normalize-space()='Client Lookup']");
                conciergeUserAccountPage.getClientLookupHeaderBtn().click();
                conciergeUserAccountPage.getClientLookupFirstName().shouldBe(visible, Duration.ofSeconds(12));
                conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
                conciergeUserAccountPage.getClientLookupLastName().setValue("Nonmember");
                conciergeUserAccountPage.getClientLookupSearchButton().click();
                conciergeOrderHistoryForm.getCustomerFirstName().shouldHave(text("NAME"));
                conciergeUserAccountPage.getFirstResultOfClientLookup().click();
                conciergeUserAccountPage.getClientButton().shouldHave(text("Mihail"));
            }
        } catch (Exception e) {
            System.out.println("Client is selected");
        }
        System.out.println();
    }

    @When("I remove client from header")
    public void iRemoveClientFromHeader() {
        try {
            sleep(2);
            if (conciergeUserAccountPage.getAutomationClientButton().isDisplayed()) {
                sleep(2);
                conciergeUserAccountPage.getAutomationClientButton().click();
                sleep(2);
                conciergeUserAccountPage.getRemoveClientButton().click();
            }
        } catch (Exception e) {
            System.out.println("Client is not selected");
        }
    }

    @When("I choose client who is a {string}")
    public void iChooseClientWhoIsAMember(String arg0) {
        conciergeUserAccountPage.getClientLookupFirstName().shouldBe(visible, Duration.ofSeconds(12));
        if (arg0.equals("member")) {
            conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
            conciergeUserAccountPage.getClientLookupLastName().setValue("Member");
        } else {
            conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
            conciergeUserAccountPage.getClientLookupLastName().setValue("NonMember");
        }

        conciergeUserAccountPage.getClientLookupSearchButton().click();
        conciergeOrderHistoryForm.getCustomerFirstName().shouldHave(text("NAME"));
        conciergeUserAccountPage.getFirstResultOfClientLookup().click();
    }

    @Then("I verify that member price is displayed as final price")
    public void iVerifyThatMemberPriceIsDisplayedAsFinalPrice() {
        conciergeCartPageScreen.getTotalMemberPrice().shouldBe(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getTotalMemberPrice().shouldHave(text("$314.00"));
        assertEquals(conciergeCartPageScreen.getTotalMemberPrice().getText(), "$314.00");
    }

    @And("I select count of product")
    public void iSelectCountOfProduct() {
        selectOption.getQuantityElement().shouldBe(visible, Duration.ofSeconds(30));
        selectOption.getQuantityElement().click();
    }

}



