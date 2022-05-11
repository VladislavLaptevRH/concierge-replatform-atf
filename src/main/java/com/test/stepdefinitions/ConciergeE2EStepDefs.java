package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.test.pageObject.*;
import com.test.utility.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.awaitility.Awaitility.await;
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
    ConciergeAddressScreen conciergeAddressScreen = new ConciergeAddressScreen();
    String usState = "";
    String countOfItems = null;

    @When("I click on add to project button")
    public void userClickOnAddToProjectButton() {
        conciergeItemsScreen.getAddToProjectButton().shouldBe(visible, Duration.ofSeconds(12));
        conciergeItemsScreen.getAddToProjectButton().click();

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
        sleep(3000);
        usState = state;
        sleep(3000);
        if (state.equals("NY")) {
            conciergeUserAccountPage.getSearchItemField().shouldBe(visible, Duration.ofSeconds(15));
            conciergeUserAccountPage.getSearchItemField().setValue("112414 OCEN BUMP");
        }
        if (state.equals("CA")) {
            conciergeUserAccountPage.getSearchItemField().shouldBe(visible, Duration.ofSeconds(15));
            conciergeUserAccountPage.getSearchItemField().setValue("112349 PTL SML");
        }
        conciergeUserAccountPage.getSearchButton().click();
    }

    @When("I click on add to cart button")
    public void iClickOnAddToCartButton() {
        conciergeItemsScreen.getAddToCartButton().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(30));
        conciergeItemsScreen.getAddToCartButton().shouldHave(text("ADD TO CART"), Duration.ofSeconds(30));
        conciergeItemsScreen.getAddToCartButton().scrollIntoView(true);
        conciergeItemsScreen.getAddToCartButton().click();

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
        conciergeUserAccountPage.getCartButton().shouldBe(visible, Duration.ofMinutes(1));
        if (!conciergeUserAccountPage.getCartButton().getText().equals("CART 0")) {
            conciergeUserAccountPage.getCartButton().click();
            System.out.println();
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
                    sleep(3000);
                    SelenideElement selenideElement = $(By.xpath("//*[text()='Remove']"));
                    selenideElement.click();
                } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                    conciergeCartPageScreen.getPleaseContinueBrowsingButton().shouldHave(text(conciergeCartPageScreen.getPleaseContinueBrowsingButton().getText()), Duration.ofMinutes(1));
                    conciergeCartPageScreen.getPleaseContinueBrowsingButton().click();
                    break;
                }
            }
        }
    }


    @When("I continue to payment")
    public void continueToPaymentAfterAddressCheckout() {
        try {
            sleep(10000);
            conciergeCartPageScreen.getNoThanksButton().shouldHave(text("NO, THANKS"), Duration.ofSeconds(15));
            sleep(3000);
            conciergeCartPageScreen.getNoThanksButton().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("No thanks button is not displayed");
        }

        checkoutAddressScreen.getContinuePaymentButton().shouldHave(text(checkoutAddressScreen.getContinuePaymentButton().getText()), Duration.ofMinutes(1));
        executeJavaScript("arguments[0].scrollIntoView(true);", checkoutAddressScreen.getContinuePaymentButton());
        checkoutAddressScreen.getContinuePaymentButton().shouldHave(text(checkoutAddressScreen.getContinuePaymentButton().getText()), Duration.ofMinutes(1));
        checkoutAddressScreen.getContinuePaymentButton().click();
        try {
            checkoutAddressScreen.getContinueButton().shouldBe(visible, Duration.ofSeconds(40));
            executeJavaScript("arguments[0].click();", checkoutAddressScreen.getContinueButton());
            conciergeAddressScreen.getOkButton().shouldBe(visible, Duration.ofSeconds(12));
            conciergeAddressScreen.getOkButton().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Continue from popup is not displayed");
        }

    }

    @When("I introduces payment details for several payment methods")
    public void iIntroducesPaymentDetailsForSeveralPaymentMethods() {
        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(1));
        sleep(2000);
        generalStepDefs.payWith("VI", "4678 4753 3015 7543", "737", "0330");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("30");
        paymentScreen.getContinueToReview().shouldBe(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();

        sleep(4000);
        generalStepDefs.payWith("AX", "3411 3411 3411 347", "6765", "0225");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("30");
        paymentScreen.getContinueToReview().shouldBe(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();

        sleep(4000);
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

        sleep(4000);
        Select selectPayment1 = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment1.selectByValue("GiftCard");
        paymentScreen.getRhCardNumberField().setValue("6006493887999902500");
        paymentScreen.getRhCardPin().setValue("8138");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("1");
        paymentScreen.getContinueToReview().shouldBe(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();


        sleep(4000);
        generalStepDefs.payWith("DI", "6011 6011 6011 6611", "737", "0330");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().setValue("10");
        paymentScreen.getContinueToReview().shouldBe(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();

        sleep(4000);
        generalStepDefs.payWith("MC", "2222 4000 1000 0008", "737", "0330");
        paymentScreen.getContinueToReview().shouldBe(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        sleep(4000);
        paymentScreen.getContinueToReview().click();

    }


    @When("I add {int} times an item in the cart")
    public void iAddTimesAnItemInTheCart(int arg0) throws InterruptedException {
        for (int i = 0; i < 70; i++) {
            $(By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1']")).shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(30));
            conciergeUserAccountPage.getDashboardTitle().shouldHave(text("DASHBOARD"));
            conciergeUserAccountPage.getOrderHistoryButton().shouldBe(visible, Duration.ofSeconds(12));

            Random rand = new Random();

            conciergeUserAccountPage.getMenuItems().get(2).scrollIntoView(true);
            conciergeUserAccountPage.getMenuItems().get(2).click();

            conciergeUserAccountPage.getItemSubCategory().get(0).shouldBe(visible, Duration.ofMinutes(1));
            Thread.sleep(2000);
            conciergeUserAccountPage.getItemSubCategory().get(0).scrollIntoView(true);
            conciergeUserAccountPage.getItemSubCategory().get(0).click();

            conciergeCartPageScreen.getShoppingCartEmpty().shouldBe(visible, Duration.ofMinutes(1));
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


            conciergeItemsScreen.getAddToCartButton().shouldBe(visible, Duration.ofSeconds(12));
            conciergeItemsScreen.getAddToCartButton().click();

            conciergeCartPageScreen.getClosePopUp().shouldBe(visible, Duration.ofSeconds(15));
            conciergeCartPageScreen.getClosePopUp().click();

            $(By.xpath("//a[@id='nav-logo-img']")).shouldBe(visible, Duration.ofSeconds(12));
            SelenideElement logoButton = $(By.xpath("//a[@id='nav-logo-img']"));
            logoButton.click();
        }
    }

    @When("I go to item {string} from search field")
    public void iGoToItemFromSearchField(String arg0) {
        sleep(5000);
        conciergeUserAccountPage.getSearchItemField().click();
        conciergeUserAccountPage.getSearchItemField().setValue(arg0);
        $(By.xpath("//button[contains(@class,'MuiButton-containedSizeLarge')]")).shouldHave(text("Search"), Duration.ofSeconds(15));
        sleep(3000);
        $(By.xpath("//button[contains(@class,'MuiButton-containedSizeLarge')]")).click();

    }

    @When("I choose {string} from brand menu")
    public void iChooseFromBrandMenu(String brand) {
        conciergeUserAccountPage.getBrandButton().shouldBe(visible, Duration.ofSeconds(12));
        conciergeUserAccountPage.getBrandButton().click();

        if (brand.equals("RH Modern")) {
            sleep(2000);
            $(By.xpath("//li[@id='rhmodern']//button")).click();
        }
        if (brand.equals("RH Baby&Child")) {
            sleep(2000);
            $(By.xpath("//li[@id='rhbabyandchild']//button")).click();

        }
        if (brand.equals("RH Teen")) {
            $(By.xpath("//li[@id='rhteen']//button")).shouldHave(text("RH TEEN"), Duration.ofSeconds(10));
            $(By.xpath("//li[@id='rhteen']//button")).click();
        }
        if (brand.equals("RH Outdoor")) {
            $(By.xpath("//li[@id='outdoor']//button")).shouldHave(text("RH Outdoor"), Duration.ofSeconds(10));
            $(By.xpath("//li[@id='outdoor']//button")).click();
        }
        if (brand.equals("RH SKI House")) {
            $(By.xpath("//li[@id='skihouse']//button")).shouldHave(text("RH SKI House"), Duration.ofSeconds(10));
            $(By.xpath("//li[@id='skihouse']//button")).click();
        }
        if (brand.equals("RH Beach House")) {
            $(By.xpath("//li[@id='rhbeachhouse']//button")).shouldHave(text("RH Beach House"), Duration.ofSeconds(10));
            $(By.xpath("//li[@id='rhbeachhouse']//button")).click();
        }
        if (brand.equals("RH Interiors")) {
            $(By.xpath("//li[@id='rhinteriors']//button")).shouldHave(text("RH Interiors"), Duration.ofSeconds(10));
            $(By.xpath("//li[@id='rhinteriors']//button")).click();
        }
    }


    @When("I click on no thanks button")
    public void iClickOnNoThanksButton() {
        try {
//            executeJavaScript("arguments[0].click();", conciergeCartPageScreen.getNoThanksButton());
            conciergeCartPageScreen.getNoThanksButton().shouldBe(visible, Duration.ofMinutes(1));
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
                conciergeUserAccountPage.getClientButton().shouldHave(text("Automation"));
            }
        } catch (Exception e) {
            System.out.println("Client is selected");
        }
        System.out.println();
    }

    @When("I remove client from header")
    public void iRemoveClientFromHeader() {
        try {
            if (!$(By.xpath("//*[text()='Client']")).isDisplayed()) {
//                conciergeUserAccountPage.getClientButton().shouldHave(text(conciergeUserAccountPage.getClientButton().getText()), Duration.ofSeconds(15));
//                conciergeUserAccountPage.getClientButton().shouldBe(Condition.and("", visible, enabled, exist, appear), Duration.ofSeconds(30));
                conciergeUserAccountPage.getClientButton().shouldBe(visible, Duration.ofMinutes(1));
                conciergeUserAccountPage.getClientButton().click();
                conciergeUserAccountPage.getRemoveClientByText().shouldHave(text("Remove Client"), Duration.ofSeconds(15));
                conciergeUserAccountPage.getRemoveClientByText().click();
            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Client is not selected");
        }
    }

    @When("I choose client who is a {string}")
    public void iChooseClientWhoIsAMember(String businessClient) {
        try {
            sleep(4000);
            conciergeUserAccountPage.getClientLookupFirstName().shouldBe(visible, Duration.ofSeconds(12));
            if (businessClient.equals("member")) {
                conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
                conciergeUserAccountPage.getClientLookupLastName().setValue("Member");
            }
            if (businessClient.equals("nonmember")) {
                conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
                conciergeUserAccountPage.getClientLookupLastName().setValue("Nonmember");
            }
            if (businessClient.equals("trade")) {
                conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
                conciergeUserAccountPage.getClientLookupLastName().setValue("Trade");
            }
            if (businessClient.equals("unclassifiedBusiness")) {
                conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
                conciergeUserAccountPage.getClientLookupLastName().setValue("unclassifiedBusiness");
            }
            sleep(5000);
            conciergeUserAccountPage.getClientLookupSearchButton().shouldBe(Condition.and("", visible, enabled), Duration.ofMinutes(3));
            conciergeUserAccountPage.getClientLookupSearchButton().shouldHave(text(conciergeUserAccountPage.getClientLookupSearchButton().getText()), Duration.ofMinutes(3));
            conciergeUserAccountPage.getClientLookupSearchButton().click();
            conciergeOrderHistoryForm.getCustomerFirstName().shouldHave(text("NAME"), Duration.ofMinutes(1));
            executeJavaScript("arguments[0].click();", conciergeUserAccountPage.getFirstResultOfClientLookup());
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {

        }

    }


    @And("I select count of product")
    public void iSelectCountOfProduct() {
        sleep(10000);
        executeJavaScript("window.scrollTo(0, 1200)");
        conciergeItemsScreen.getDetailsSpan().shouldHave(text(conciergeItemsScreen.getDetailsSpan().getText()), Duration.ofMinutes(3));
        selectOption.getQuantityElement().shouldBe(visible, Duration.ofMinutes(1));
        sleep(3000);
        Select selectQty = new Select(selectOption.getQuantityElement());
        selectQty.selectByIndex(2);
    }

    @Then("I verify that address screen is displayed")
    public void iVerifyThatAddressScreenIsDisplayed() {
        checkoutAddressScreen.getFirstNameInpt().shouldBe(Condition.be(visible), Duration.ofSeconds(20));
        checkoutAddressScreen.getLastNameField().shouldBe(Condition.be(visible), Duration.ofSeconds(20));
        checkoutAddressScreen.getCompanyNameField().shouldBe(Condition.be(visible), Duration.ofSeconds(20));
        assertTrue(checkoutAddressScreen.getFirstNameInpt().isDisplayed());
        assertTrue(checkoutAddressScreen.getLastNameField().isDisplayed());
        assertTrue(checkoutAddressScreen.getCompanyNameField().isDisplayed());
        assertTrue(checkoutAddressScreen.getStreetAddressField().isDisplayed());
        assertTrue(checkoutAddressScreen.getAptFloorSuiteField().isDisplayed());
        assertTrue(checkoutAddressScreen.getCityField().isDisplayed());
        assertTrue(checkoutAddressScreen.getPhoneField().isDisplayed());
    }

    @When("I click on sale point of menu")
    public void iClickOnSalePointOfMenu() {
        conciergeUserAccountPage.getOutdoorMenu().shouldHave(text("Outdoor"), Duration.ofMinutes(1));
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(conciergeUserAccountPage.getOutdoorMenu());
        sleep(3000);
        conciergeUserAccountPage.getOutdoorMenu().shouldBe(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeUserAccountPage.getOutdoorMenu().click();

    }

    @When("I click on chairs submenu")
    public void iClickOnChairsSubmenu() {
        sleep(3000);
        conciergeUserAccountPage.getChairsSubMenu().shouldHave(text("Chairs"), Duration.ofMinutes(1));
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(conciergeUserAccountPage.getChairsSubMenu());
        conciergeUserAccountPage.getChairsSubMenu().shouldBe(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeUserAccountPage.getChairsSubMenu().click();
    }

    @When("I select finish option")
    public void iSelectFinishOption() {
        selectOption.getFinishOption().shouldBe(visible, Duration.ofMinutes(1));
        selectOption.getFinishOption().scrollIntoView(true);
        sleep(2000);
        Select selectFinish = new Select(selectOption.getFinishOption());
        selectFinish.selectByIndex(1);
    }

    @When("I clicks on sofa collections")
    public void iClicksOnSofaCollections() {
        $(By.xpath("//*[text()='Sofa Collections']")).shouldHave(text("Sofa Collections"), Duration.ofSeconds(12));
        $(By.xpath("//*[text()='Sofa Collections']")).click();

    }

    @When("I click on see results button")
    public void iClickOnSeeResultsButton() {
        try {
            sleep(2000);
            $(By.xpath("//*[contains(text(),'See Results on')]")).shouldBe(visible, Duration.ofMinutes(1));
            $(By.xpath("//*[contains(text(),'See Results on')]")).click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("See Results on button is not displayed");
        }


    }


    @When("I click on {string}")
    public void iClickOn(String arg0) {
        SelenideElement brand = $(By.xpath("//*[contains(text(),'" + arg0 + "')]")).shouldBe(visible, Duration.ofSeconds(12));
        String brandValue = brand.getText();
        countOfItems = brandValue.substring(brandValue.indexOf("("), brandValue.indexOf(")")).replaceAll("\\(", "");
        $(By.xpath("//*[contains(text(),'" + arg0 + "')]")).click();
    }

    @Then("I verify that {string} are displayed")
    public void iVerifyThatAreDisplayed(String arg0) {
        $(By.xpath("//*[text()='" + arg0 + "']")).shouldHave(text(arg0), Duration.ofSeconds(20));
        $(By.xpath("//*[text()='" + arg0 + "']")).click();
    }

    @When("I fiils all options for item")
    public void iFiilsAllOptionsForItem() {
        //depth option
        sleep(9000);
        executeJavaScript("window.scrollTo(0, 970)");
        try {
            sleep(8000);
            selectOption.getDepthProperty().shouldBe(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select selectDepth = new Select(selectOption.getDepthProperty());
            sleep(3000);
            selectDepth.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
        sleep(2000);

        //seatheight
        try {
            sleep(9000);
            selectOption.getSeatHeight().shouldBe(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select seatHeight = new Select(selectOption.getSeatHeight());
            sleep(3000);
            seatHeight.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
        sleep(2000);

        //finish
        try {
            sleep(9000);
            selectOption.getFinishOption().shouldBe(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select finalOption = new Select(selectOption.getFinishOption());
            sleep(3000);
            finalOption.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
        sleep(2000);

        //select color option
        try {
            sleep(4000);
            selectOption.getColorOption().shouldBe(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select selectFabric = new Select(selectOption.getColorOption());
            selectFabric.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }

        //select length option
        try {
            sleep(9000);
            selectOption.getLengthOption().shouldBe(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select selectLength = new Select(selectOption.getLengthOption());
            selectLength.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }

        //select fill option
        try {
            sleep(16);
            selectOption.getLengthOption().shouldBe(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select selectFillOption = new Select(selectOption.getFillOption());
            selectFillOption.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }

        //fabric option
        try {
            sleep(18);
            selectOption.getFabricProperty().shouldBe(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select selectFabric = new Select(selectOption.getFabricProperty());
            selectFabric.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
        sleep(2000);

    }

    @When("I look on client by {string} with {string}")
    public void iChooseClientByWhoIsA(String searchParam, String businessClient) {
        try {
            sleep(4000);
            conciergeUserAccountPage.getClientLookupFirstName().shouldBe(visible, Duration.ofSeconds(12));
            if (searchParam.equals("name")) {
                if (businessClient.equals("member")) {
                    conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
                    conciergeUserAccountPage.getClientLookupLastName().setValue("Member");
                }
                if (businessClient.equals("nonmember")) {
                    conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
                    conciergeUserAccountPage.getClientLookupLastName().setValue("Nonmember");
                }
                if (businessClient.equals("trade")) {
                    conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
                    conciergeUserAccountPage.getClientLookupLastName().setValue("Trade");
                }
                if (businessClient.equals("unclassifiedBusiness")) {
                    conciergeUserAccountPage.getClientLookupFirstName().setValue("Automation");
                    conciergeUserAccountPage.getClientLookupLastName().setValue("unclassifiedBusiness");
                }
            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Error is appeared");
        }

        try {
            if (searchParam.equals("accountnumber")) {
                conciergeUserAccountPage.getBusinessAcNumber().setValue(businessClient);
            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Error is appeared");
        }

        sleep(5000);
        conciergeUserAccountPage.getClientLookupSearchButton().shouldBe(Condition.and("", visible, enabled), Duration.ofMinutes(3));
        conciergeUserAccountPage.getClientLookupSearchButton().shouldHave(text(conciergeUserAccountPage.getClientLookupSearchButton().getText()), Duration.ofMinutes(3));
        conciergeUserAccountPage.getClientLookupSearchButton().click();
        conciergeOrderHistoryForm.getCustomerFirstName().shouldHave(text("NAME"), Duration.ofMinutes(1));
        executeJavaScript("arguments[0].click();", conciergeUserAccountPage.getFirstResultOfClientLookup());
    }

    @Then("I verify zipcode")
    public void iVerifyZipcode() {
        generalStepDefs.clearField(checkoutAddressScreen.getZipPostalCodeField());
        checkoutAddressScreen.getZipPostalCodeField().setValue("1234");
        $(By.xpath("//*[text()='Invalid zip/postal code.']")).shouldBe(visible, Duration.ofMinutes(1));
    }

    @When("I click on plus button from client lookup search results")
    public void iClickOnPlusButtonFromClientLookupSearchResults() {
        conciergeUserAccountPage.getSearchClientResultsPlusButton().shouldBe(visible, Duration.ofMinutes(1));
        conciergeUserAccountPage.getSearchClientResultsPlusButton().click();
    }
}



