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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    ConciergeProjectScreen conciergeProjectScreen = new ConciergeProjectScreen();
    SelectOption selectOption = new SelectOption();
    ConciergeAddressScreen conciergeAddressScreen = new ConciergeAddressScreen();
    String usState = "";
    String countOfItems = null;
    WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofMinutes(1));

    @When("I click on add to project button")
    public void userClickOnAddToProjectButton() {
        conciergeItemsScreen.getAddToProjectButton().should(visible, Duration.ofSeconds(12));
        conciergeItemsScreen.getAddToProjectButton().click();

    }

    @When("I click on go to project button")
    public void iClickOnGoToProjectButton() {
        generalStepDefs.isElementVisible("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4'][1]//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained')]");
        conciergeItemsScreen.getContinueShoppingButton().should(visible, Duration.ofSeconds(12));

        conciergeItemsScreen.getGoToProjectButton().click();
    }

    @When("I click on add to cart button from project screen")
    public void iClickOnAddToCartButtonFromProjectScreen() {
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeProjectScreen.getAddToCartButton().should(visible, Duration.ofSeconds(25));
        conciergeProjectScreen.getAddToCartButton().scrollIntoView(true);
        executeJavaScript("arguments[0].click();", conciergeProjectScreen.getAddToCartButton());
    }

    @When("I choose random brand from menu")
    public void iChooseRandomBrandFromMenu() {
        conciergeUserAccountPage.getDashboardTitle().should(visible, Duration.ofSeconds(12));
        conciergeUserAccountPage.getOrderHistoryButton().should(visible, Duration.ofSeconds(12));
        conciergeUserAccountPage.getBrandButton().click();
        conciergeUserAccountPage.getListOfBrands().get(1).click();

    }

//    @When("I go to item which has {string} restriction")
//    public void iGoToItemWhichHasRestriction(String state) {
//        usState = state;
//        generalStepDefs.waitForJSandJQueryToLoad();
//        conciergeUserAccountPage.getSearchItemField().should(Condition.and("", visible, enabled), Duration.ofSeconds(20));
//        conciergeUserAccountPage.getSearchItemField().should(empty, Duration.ofMinutes(1));
//        conciergeUserAccountPage.getSearchItemField().click();
//
//        if (state.equals("NY")) {
//            conciergeUserAccountPage.getSearchItemField().should(visible, Duration.ofSeconds(15));
//            conciergeUserAccountPage.getSearchItemField().setValue("112414 OCEN BUMP");
//            System.out.println();
//        }
//        if (state.equals("CA")) {
//            conciergeUserAccountPage.getSearchItemField().should(visible, Duration.ofSeconds(15));
//            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofMinutes(1));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'MuiOutlinedInput-inputAdornedStart')]")));
//            WebDriverRunner.getWebDriver().findElement(By.xpath("//input[contains(@class,'MuiOutlinedInput-inputAdornedStart')]")).sendKeys("112349 PTL SML");
//        }
//        conciergeUserAccountPage.getSearchButton().click();
//    }

    @When("I click on add to cart button")
    public void iClickOnAddToCartButton() {
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeItemsScreen.getAddToCartButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(50));
        conciergeItemsScreen.getAddToCartButton().shouldHave(text("ADD TO CART"), Duration.ofSeconds(50));
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
        restrictionPopUp.getShippingRestricitonsTitle().should(visible, Duration.ofSeconds(40));
        assertTrue(restrictionPopUp.getShippingRestricitonsTitle().getText().contains("SHIPPING ERROR"));
        assertTrue(restrictionPopUp.getRestrictionsMessage().getText().contains("One or more items in your cart"));
    }

    @When("I remove all items from cart")
    public void iRemoveAllItemsFromCart() {
        conciergeUserAccountPage.getCartButton().should(visible, Duration.ofMinutes(1));
        if (!conciergeUserAccountPage.getCartButton().getText().equals("CART 0")) {
            conciergeUserAccountPage.getCartButton().click();
            generalStepDefs.waitForJSandJQueryToLoad();
            conciergeCartPageScreen.getCartTitle().shouldHave(text("CART"), Duration.ofSeconds(12));
            conciergeCartPageScreen.getClearOrderButton().scrollIntoView(true);
            conciergeCartPageScreen.getOrderEstimateTitle().shouldHave(text("Order Estimate"), Duration.ofSeconds(12));
            conciergeCartPageScreen.getClearOrderButton().click();
            conciergeCartPageScreen.getClearOrderButtonPop().shouldHave(text("CLEAR ORDER"), Duration.ofSeconds(15));
            conciergeCartPageScreen.getClearOrderButtonPop().click();
            generalStepDefs.waitForJSandJQueryToLoad();
        }
    }


    @When("I continue to payment")
    public void continueToPaymentAfterAddressCheckout() {
        checkoutAddressScreen.getContinuePaymentButton().shouldHave(text(checkoutAddressScreen.getContinuePaymentButton().getText()), Duration.ofMinutes(1));
        executeJavaScript("arguments[0].scrollIntoView(true);", checkoutAddressScreen.getContinuePaymentButton());
        checkoutAddressScreen.getContinuePaymentButton().shouldHave(text(checkoutAddressScreen.getContinuePaymentButton().getText()), Duration.ofMinutes(1));
        checkoutAddressScreen.getContinuePaymentButton().click();
        try {
            checkoutAddressScreen.getContinueButton().should(visible, Duration.ofSeconds(40));
            executeJavaScript("arguments[0].click();", checkoutAddressScreen.getContinueButton());
            conciergeAddressScreen.getOkButton().should(visible, Duration.ofSeconds(12));
            conciergeAddressScreen.getOkButton().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Continue from popup is not displayed");
        }

    }


    @When("I add {int} times an item in the cart")
    public void iAddTimesAnItemInTheCart(int arg0) {
        for (int i = 0; i < 70; i++) {
            $(By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1']")).should(Condition.and("", visible, enabled), Duration.ofSeconds(30));
            conciergeUserAccountPage.getDashboardTitle().shouldHave(text("DASHBOARD"));
            conciergeUserAccountPage.getOrderHistoryButton().should(visible, Duration.ofSeconds(12));

            Random rand = new Random();

            conciergeUserAccountPage.getMenuItems().get(2).scrollIntoView(true);
            conciergeUserAccountPage.getMenuItems().get(2).click();

            conciergeUserAccountPage.getItemSubCategory().get(0).should(visible, Duration.ofMinutes(1));

            conciergeUserAccountPage.getItemSubCategory().get(0).scrollIntoView(true);
            conciergeUserAccountPage.getItemSubCategory().get(0).click();

            conciergeCartPageScreen.getShoppingCartEmpty().should(visible, Duration.ofMinutes(1));
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


            conciergeItemsScreen.getAddToCartButton().should(visible, Duration.ofSeconds(12));
            conciergeItemsScreen.getAddToCartButton().click();

            conciergeCartPageScreen.getClosePopUp().should(visible, Duration.ofSeconds(15));
            conciergeCartPageScreen.getClosePopUp().click();

            $(By.xpath("//a[@id='nav-logo-img']")).should(visible, Duration.ofSeconds(12));
            SelenideElement logoButton = $(By.xpath("//a[@id='nav-logo-img']"));
            logoButton.click();
        }
    }

    @When("I go to item {string} from search field")
    public void iGoToItemFromSearchField(String arg0) {
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeUserAccountPage.getSearchItemField().should(Condition.and("", visible, enabled), Duration.ofSeconds(20));
        conciergeUserAccountPage.getSearchItemField().should(empty, Duration.ofMinutes(1));
        conciergeUserAccountPage.getSearchItemField().click();
        generalStepDefs.waitForJSandJQueryToLoad();
        $(By.xpath("//button[contains(@class,'MuiButton-containedSizeLarge')]")).should(Condition.and("", visible, enabled), Duration.ofSeconds(15));
        sleep(3000);
        conciergeUserAccountPage.getSearchItemField().setValue(arg0);
        $(By.xpath("//button[contains(@class,'MuiButton-containedSizeLarge')]")).click();
    }

    @When("I choose {string} from brand menu")
    public void iChooseFromBrandMenu(String brand) {
        conciergeUserAccountPage.getBrandButton().should(visible, Duration.ofSeconds(12));
        conciergeUserAccountPage.getBrandButton().click();

        if (brand.equals("RH Modern")) {
            $(By.xpath("//li[@id='rhmodern']//button")).click();
        }
        if (brand.equals("RH Baby&Child")) {
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
            generalStepDefs.waitForJSandJQueryToLoad();
            conciergeCartPageScreen.getNoThanksButton().shouldHave(text("NO, THANKS"), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(conciergeCartPageScreen.getNoThanksButton()));
            wait.until(ExpectedConditions.visibilityOf(conciergeCartPageScreen.getNoThanksButton()));
            Actions actions = new Actions(WebDriverRunner.getWebDriver());
            actions.moveToElement(conciergeCartPageScreen.getNoThanksButton());
            conciergeCartPageScreen.getNoThanksButton().scrollIntoView(true);
            generalStepDefs.waitForJSandJQueryToLoad();
            sleep(4000);
            executeJavaScript("arguments[0].click();", conciergeCartPageScreen.getNoThanksButton());
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
    }

    @When("I choose client who is a non member")
    public void iChooseClientWhoIsANonMember() {
        try {
            if (conciergeUserAccountPage.getClientButton().getText().equals("CLIENT")) {
                conciergeUserAccountPage.getClientButton().click();
                generalStepDefs.isElementVisible("//span[normalize-space()='Client Lookup']");
                conciergeUserAccountPage.getClientLookupHeaderBtn().click();
                conciergeUserAccountPage.getClientLookupFirstName().should(visible, Duration.ofSeconds(12));
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
    }

    @When("I remove client from header")
    public void iRemoveClientFromHeader() {
        generalStepDefs.waitForJSandJQueryToLoad();
        sleep(5000);
        try {
            if (!conciergeUserAccountPage.getClientButton().getText().equals("CLIENT")) {
                conciergeUserAccountPage.getClientButton().shouldHave(text("Client : "), Duration.ofSeconds(10));
                conciergeUserAccountPage.getClientButton().should(visible, Duration.ofSeconds(10));
                conciergeUserAccountPage.getClientButton().click();
                conciergeUserAccountPage.getRemoveClientByText().shouldHave(text("Remove Client"), Duration.ofSeconds(5));
                conciergeUserAccountPage.getRemoveClientByText().click();
            }
            System.out.println();
        } catch (AssertionError e) {
            System.out.println("Client is not selected");
        }
    }

    @When("I choose client who is a {string}")
    public void iChooseClientWhoIsAMember(String businessClient) {
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeUserAccountPage.getClientLookupFirstName().should(visible, Duration.ofSeconds(12));
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
        conciergeUserAccountPage.getClientLookupSearchButton().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeUserAccountPage.getClientLookupSearchButton().shouldHave(text(conciergeUserAccountPage.getClientLookupSearchButton().getText()), Duration.ofMinutes(1));
        conciergeUserAccountPage.getClientLookupSearchButton().click();
        conciergeOrderHistoryForm.getCustomerFirstName().shouldHave(text("NAME"), Duration.ofMinutes(1));
        executeJavaScript("arguments[0].click();", conciergeUserAccountPage.getFirstResultOfClientLookup());

    }


    @And("I select count of product")
    public void iSelectCountOfProduct() {
        executeJavaScript("window.scrollTo(0, 1200)");
        conciergeItemsScreen.getDetailsSpan().should(Condition.and("", appear, enabled), Duration.ofSeconds(20));
        conciergeItemsScreen.getDetailsSpan().shouldHave(text(conciergeItemsScreen.getDetailsSpan().getText()), Duration.ofMinutes(3));
        selectOption.getQuantityElement().should(visible, Duration.ofMinutes(1));

        Select selectQty = new Select(selectOption.getQuantityElement());
        selectQty.selectByIndex(2);
    }

    @Then("I verify that address screen is displayed")
    public void iVerifyThatAddressScreenIsDisplayed() {
        checkoutAddressScreen.getFirstNameInpt().should(Condition.be(visible), Duration.ofSeconds(20));
        checkoutAddressScreen.getLastNameField().should(Condition.be(visible), Duration.ofSeconds(20));
        checkoutAddressScreen.getCompanyNameField().should(Condition.be(visible), Duration.ofSeconds(20));
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

        conciergeUserAccountPage.getOutdoorMenu().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeUserAccountPage.getOutdoorMenu().click();

    }

    @When("I click on chairs submenu")
    public void iClickOnChairsSubmenu() {
        conciergeUserAccountPage.getChairsSubMenu().shouldHave(text("Chairs"), Duration.ofMinutes(1));
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(conciergeUserAccountPage.getChairsSubMenu());
        conciergeUserAccountPage.getChairsSubMenu().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeUserAccountPage.getChairsSubMenu().click();
    }

    @When("I select finish option")
    public void iSelectFinishOption() {
        selectOption.getFinishOption().should(visible, Duration.ofMinutes(1));
        selectOption.getFinishOption().scrollIntoView(true);
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
            $(By.xpath("//*[contains(text(),'See Results on')]")).should(visible, Duration.ofSeconds(15));
            $(By.xpath("//*[contains(text(),'See Results on')]")).click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("See Results on button is not displayed");
        }


    }


    @When("I click on {string}")
    public void iClickOn(String arg0) {
        SelenideElement brand = $(By.xpath("//*[contains(text(),'" + arg0 + "')]")).should(visible, Duration.ofSeconds(12));
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

            selectOption.getDepthProperty().should(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select selectDepth = new Select(selectOption.getDepthProperty());

            selectDepth.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
        sleep(2000);

        //seatheight
        try {
            sleep(9000);
            selectOption.getSeatHeight().should(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select seatHeight = new Select(selectOption.getSeatHeight());

            seatHeight.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
        sleep(2000);

        //finish
        try {
            sleep(9000);
            selectOption.getFinishOption().should(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select finalOption = new Select(selectOption.getFinishOption());

            finalOption.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
        sleep(2000);

        //select color option
        try {
            selectOption.getColorOption().should(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select selectFabric = new Select(selectOption.getColorOption());
            selectFabric.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }

        //select length option
        try {
            sleep(9000);
            selectOption.getLengthOption().should(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select selectLength = new Select(selectOption.getLengthOption());
            selectLength.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }

        //select fill option
        try {
            sleep(16);
            selectOption.getLengthOption().should(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select selectFillOption = new Select(selectOption.getFillOption());
            selectFillOption.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }

        //fabric option
        try {
            sleep(18);
            selectOption.getFabricProperty().should(Condition.be(Condition.visible), Duration.ofSeconds(5));
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
            conciergeUserAccountPage.getClientLookupFirstName().should(visible, Duration.ofSeconds(40));
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
                conciergeUserAccountPage.getBusinessAcNumber().should(Condition.and("", enabled, visible), Duration.ofSeconds(40));
                conciergeUserAccountPage.getBusinessAcNumber().setValue(businessClient);
            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Error is appeared");
        }

        conciergeUserAccountPage.getClientLookupSearchButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(40));
        conciergeUserAccountPage.getClientLookupSearchButton().shouldHave(text(conciergeUserAccountPage.getClientLookupSearchButton().getText()), Duration.ofSeconds(40));
        conciergeUserAccountPage.getClientLookupSearchButton().click();
        conciergeOrderHistoryForm.getCustomerFirstName().shouldHave(text("NAME"), Duration.ofSeconds(40));
        executeJavaScript("arguments[0].click();", conciergeUserAccountPage.getFirstResultOfClientLookup());
    }

    @Then("I verify zipcode")
    public void iVerifyZipcode() {
        generalStepDefs.clearField(checkoutAddressScreen.getZipPostalCodeField());
        checkoutAddressScreen.getZipPostalCodeField().setValue("1234");
        $(By.xpath("//*[text()='Invalid zip/postal code.']")).should(visible, Duration.ofMinutes(1));
    }

    @When("I click on plus button from client lookup search results")
    public void iClickOnPlusButtonFromClientLookupSearchResults() {
        conciergeUserAccountPage.getSearchClientResultsPlusButton().should(visible, Duration.ofMinutes(1));
        conciergeUserAccountPage.getSearchClientResultsPlusButton().click();
    }

    @Then("I verify that tax exempt checkbox is unchecked by default for trade client")
    public void iVerifyThatTaxExemptCheckboxIsUncheckedByDefaultForTradeClient() {
        conciergeAddressScreen.getSoldToTaxExempt().shouldNotBe(visible, Duration.ofSeconds(15));
    }

    @Then("I verify trade prices for {string}")
    public void iVerifyTradePricesForPDP(String pageName) {
        if (pageName.equals("project page")) {
            $(By.xpath("//*[text()='TRADE']")).should(visible, Duration.ofSeconds(20));
            $(By.xpath("//*[text()='$3,165.00']")).should(visible, Duration.ofSeconds(20));

        } else {
            $(By.xpath("//*[text()='Trade']")).should(visible, Duration.ofSeconds(20));
            $(By.xpath("//*[text()='1509']")).should(visible, Duration.ofSeconds(20));
        }
    }

    @And("I fill all fields for sold to address")
    public void iFillAllFieldsForSoldToAddress() {
        generalStepDefs.fillAddressFields();
        generalStepDefs.fillZipCodeStateCountry("12345", "US", "");
        $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item']//input[@type='checkbox'])[2]")).scrollIntoView(true);
        $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item']//input[@type='checkbox'])[2]")).click();
        sleep(3000);
        $(By.cssSelector("body > div:nth-child(7) > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > label:nth-child(1) > span:nth-child(1) > span:nth-child(1) > input:nth-child(1)")).click();
    }
}



