package com.test.stepdefinitions;

import com.test.pageObject.*;
import com.test.utility.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static org.awaitility.Awaitility.await;
import static org.testng.Assert.assertTrue;

public class ConciergeE2EStepDefs {
    WebDriver webDriver = Hooks.getWebDriver();
    WebDriverWait wait = new WebDriverWait(webDriver, 10);
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen(webDriver);
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage(webDriver);
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen(webDriver);
    RestrictionPopUp restrictionPopUp = new RestrictionPopUp(webDriver);
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen(webDriver);
    Actions actions = new Actions(webDriver);
    PaymentScreen paymentScreen = new PaymentScreen(webDriver);
    String usState = "";

    @When("I click on add to project button")
    public void userClickOnAddToProjectButton() {
        wait.until(ExpectedConditions.visibilityOf(conciergeItemsScreen.getAddToProjectButton()));
        conciergeItemsScreen.getAddToProjectButton().click();

        wait.until(ExpectedConditions.elementToBeClickable(conciergeItemsScreen.getSaveProjectPopUpButton()));
        conciergeItemsScreen.getSaveProjectPopUpButton().click();

        generalStepDefs.isElementVisible("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4'][1]//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained')]");
        conciergeItemsScreen.getGoToProjectButton().click();
    }

    @When("I click on go to project button")
    public void iClickOnGoToProjectButton() {
        generalStepDefs.isElementVisible("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4'][1]//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained')]");
        wait.until(ExpectedConditions.elementToBeClickable(conciergeItemsScreen.getContinueShoppingButton()));

        conciergeItemsScreen.getGoToProjectButton().click();
    }

    @When("I click on add to cart button from project screen")
    public void iClickOnAddToCartButtonFromProjectScreen() {
        generalStepDefs.isElementVisible("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth']/span[@class='MuiButton-label']");
        WebElement element = webDriver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth']/span[@class='MuiButton-label']"));
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", element);
    }

    @When("I choose random brand from menu")
    public void iChooseRandomBrandFromMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getDashboardTitle()));
        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getOrderHistoryButton()));
        conciergeUserAccountPage.getBrandButton().click();
        conciergeUserAccountPage.getListOfBrands().get(1).click();

    }

    @When("I go to item which has {string} restriction")
    public void iGoToItemWhichHasRestriction(String state) {
        usState = state;
        if (state.equals("NY")) {
            generalStepDefs.waitForPageLoad(webDriver);
            conciergeUserAccountPage.getSearchItemField().sendKeys("112411 BLSH BUMP");
            conciergeUserAccountPage.getSearchButton().click();
        }
        if (state.equals("CA")) {
            generalStepDefs.waitForPageLoad(webDriver);
            conciergeUserAccountPage.getSearchItemField().sendKeys("102980 IVOR");
            conciergeUserAccountPage.getSearchButton().click();
            generalStepDefs.isElementVisible("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-true']/div/ul//li[@class='MuiGridListTile-root']");
            wait.until(ExpectedConditions.elementToBeClickable(conciergeItemsScreen.getItems().get(0)));
            conciergeItemsScreen.getItems().get(0).click();
        }
        try {
            if (conciergeUserAccountPage.getSeeResultsButton().isDisplayed()) {
                conciergeUserAccountPage.getSeeResultsButton().click();
            }
        } catch (Exception e) {
            System.out.println("See results button is not displayed");
        }

    }

    @When("I click on add to cart button")
    public void iClickOnAddToCartButton() {
        generalStepDefs.waitForPageLoad(webDriver);
        WebDriverWait waitAgreeButton = new WebDriverWait(webDriver, 3);
        generalStepDefs.isElementVisible("//div[1]/div[@class='MuiFormControl-root MuiFormControl-fullWidth']/button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']");
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", conciergeItemsScreen.getAddToCartButton());
        if (usState.equals("CA")) {
            try {
                waitAgreeButton.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='spo-auth-addToCart']")));
                conciergeItemsScreen.getAggreeeAndAddToCardButton().click();
            } catch (Exception e) {
                System.out.println("Agree&add to card button is not displayed");
            }
        }

        generalStepDefs.isElementVisible("//button[@id='ajax-proceed-to-cart']");
        conciergeItemsScreen.getViewCartButton().click();

    }

    @When("I fill all fields from address with {string} zip code")
    public void iFillAllFieldsFromAddressWithZipCode(String state) {
        generalStepDefs.waitForPageLoad(webDriver);
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
        assertTrue(restrictionPopUp.getShippingRestricitonsTitle().getText().contains("SHIPPING ERROR"));
        assertTrue(restrictionPopUp.getRestrictionsMessage().getText().contains("One or more items in your cart"));
    }

    @When("I remove all items from cart")
    public void iRemoveAllItemsFromCart() {
        WebDriverWait waitRemoveButton = new WebDriverWait(webDriver, 5);
        await().forever().until(() -> conciergeUserAccountPage.getCartButton().isDisplayed());
        if (!conciergeUserAccountPage.getCartButton().getText().equals("CART 0")) {
            conciergeUserAccountPage.getCartButton().click();
            while (true) {
                try {
                    WebElement closePopUp = webDriver.findElement(By.xpath("//button[@data-testid='form-dialog-close-button']"));
                    if (closePopUp.isDisplayed()) {
                        closePopUp.click();
                    }
                } catch (Exception e) {
                    System.out.println("Pop up is not appeared");
                }
                try {
                    waitRemoveButton.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[7]//div[1]/div/div/div/div[2]//div[2]/div[4]/div[1]/a/span")));
                    WebElement webElement = webDriver.findElement(By.xpath("//div[7]//div[1]/div/div/div/div[2]//div[2]/div[4]/div[1]/a/span"));
                    webElement.click();
                    try {
                        if (waitRemoveButton.until(ExpectedConditions.textToBePresentInElement(conciergeCartPageScreen.getPleaseContinueBrowsingButton(), "continue browsing"))) {
                            conciergeCartPageScreen.getPleaseContinueBrowsingButton().click();
                            break;
                        }
                    } catch (Exception e) {
                        continue;
                    }
                } catch (Exception e) {
                    break;
                }
            }
        }
    }


    @When("I continue to payment")
    public void continueToPaymentAfterAddressCheckout() {
        await().forever().until(() -> checkoutAddressScreen.getContinuePaymentButton().isDisplayed());
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", checkoutAddressScreen.getContinuePaymentButton());
        checkoutAddressScreen.getContinuePaymentButton().click();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(checkoutAddressScreen.getContinueButton()));
            JavascriptExecutor executor = (JavascriptExecutor) webDriver;
            executor.executeScript("arguments[0].click();", checkoutAddressScreen.getContinueButton());
        } catch (Exception e) {
            System.out.println("Continue from popup is not displayed");
        }

    }

    @When("I introduces payment details for several payment methods")
    public void iIntroducesPaymentDetailsForSeveralPaymentMethods() {
        wait.until(ExpectedConditions.textToBePresentInElement(paymentScreen.getChoosePaymentMethodBtn(), "Choose a payment method"));
        generalStepDefs.isElementVisible("//label[2]/span[@class='MuiTypography-root MuiFormControlLabel-label MuiTypography-body1']");
        generalStepDefs.payWith("AX", "3411 3411 3411 347", "6765", "0225");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().sendKeys("100");
        paymentScreen.getContinueToReview().click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'MuiButton-containedPrimary')]")));
        generalStepDefs.isElementVisible("//label[2]/span[@class='MuiTypography-root MuiFormControlLabel-label MuiTypography-body1']");
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment.selectByValue("RH");
        paymentScreen.getRhCardNumberField().sendKeys("5856373200177801");
        Select paymentPlan = new Select(paymentScreen.getSelectPaymentPlan());
        paymentPlan.selectByValue("001");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().sendKeys("50");
        paymentScreen.getRhccContinueToReview().click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'MuiButton-containedPrimary')]")));
        generalStepDefs.isElementVisible("//label[2]/span[@class='MuiTypography-root MuiFormControlLabel-label MuiTypography-body1']");
        selectPayment.selectByValue("GiftCard");
        paymentScreen.getRhCardNumberField().sendKeys("6006493887999902500");
        paymentScreen.getRhCardPin().sendKeys("8138");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().sendKeys("1");
        paymentScreen.getContinueToReview().click();


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'MuiButton-containedPrimary')]")));
        generalStepDefs.isElementVisible("//div[contains(@class,'Mui')]//select[contains(@class,'MuiInputBase-input')]");
        generalStepDefs.payWith("VI", "4678 4753 3015 7543", "737", "0330");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().sendKeys("50");
        paymentScreen.getContinueToReview().click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'MuiButton-containedPrimary')]")));
        generalStepDefs.isElementVisible("//div[contains(@class,'Mui')]//select[contains(@class,'MuiInputBase-input')]");
        generalStepDefs.payWith("DI", "6011 6011 6011 6611", "737", "0330");
        paymentScreen.getSplitPaymentCheckBox().click();
        generalStepDefs.clearField(paymentScreen.getFieldAmount());
        paymentScreen.getFieldAmount().sendKeys("50");
        paymentScreen.getContinueToReview().click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'MuiButton-containedPrimary')]")));
        generalStepDefs.isElementVisible("//div[contains(@class,'Mui')]//select[contains(@class,'MuiInputBase-input')]");
        generalStepDefs.payWith("MC", "2222 4000 1000 0008", "737", "0330");
        paymentScreen.getContinueToReview().click();

    }

    @When("I add {int} times an item in the cart")
    public void iAddTimesAnItemInTheCart(int arg0) throws InterruptedException {
        for (int i = 0; i < 70; i++) {
            generalStepDefs.isElementVisible("//h1[@class='MuiTypography-root MuiTypography-h1']");
            wait.until(ExpectedConditions.textToBePresentInElement(conciergeUserAccountPage.getDashboardTitle(), "DASHBOARD"));
            wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getOrderHistoryButton()));

            Random rand = new Random();

            actions.moveToElement(conciergeUserAccountPage.getMenuItems().get(2));
            conciergeUserAccountPage.getMenuItems().get(2).click();

            wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getItemSubCategory().get(0)));
            Thread.sleep(2000);
            actions.moveToElement(conciergeUserAccountPage.getItemSubCategory().get(0));
            conciergeUserAccountPage.getItemSubCategory().get(0).click();


            WebElement webElement = webDriver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12'][1]//li"));
            webElement.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1']")));
            await().forever().until(() -> conciergeItemsScreen.getCollectionsItems().get(0).isDisplayed());
            generalStepDefs.waitForPageLoad(webDriver);
            conciergeItemsScreen.getCollectionsItems().get(1 + rand.nextInt((1 - 0) + 1)).click();

            generalStepDefs.isElementVisible("//h2[@class='MuiTypography-root MuiTypography-h2']");
            String currentUrl = webDriver.getCurrentUrl();
            String currentProduct = currentUrl.substring(currentUrl.indexOf("="), currentUrl.indexOf("&")).replace("=", "");

            generalStepDefs.isElementVisible("//select[@id='" + currentProduct + "-qty-input']//option[3]");
            WebElement quantity = webDriver.findElement(By.xpath("//select[@id='" + currentProduct + "-qty-input']"));
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", quantity);
            WebElement sizeOption = webDriver.findElement(By.xpath("//select[@id='optionSelect-" + currentProduct + "-Size']"));
            await().forever().until(quantity::isDisplayed);
            wait.until(ExpectedConditions.elementToBeClickable(quantity));

            Select selectSize = new Select(sizeOption);
            selectSize.selectByIndex(GeneralStepDefs.getRandomNumberInRange(1, 3));
            sizeOption.click();

            WebElement finishOption = webDriver.findElement(By.xpath("//select[@id='optionSelect-" + currentProduct + "-Finish']"));
            wait.until(ExpectedConditions.elementToBeClickable(finishOption));

            Select select = new Select(finishOption);
            select.selectByIndex(GeneralStepDefs.getRandomNumberInRange(1, 9));

            wait.until(ExpectedConditions.elementToBeClickable((quantity)));
            Select quantityButton = new Select(quantity);
            quantityButton.selectByIndex(2);


            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]/div[@class='MuiFormControl-root MuiFormControl-fullWidth']/button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']")));
            conciergeItemsScreen.getAddToCartButton().click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='MuiDialogTitle-root']/button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit']")));
            WebElement closeButton = webDriver.findElement(By.xpath("//div[@class='MuiDialogTitle-root']/button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit']"));
            closeButton.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='nav-logo-img']")));
            WebElement logoButton = webDriver.findElement(By.xpath("//a[@id='nav-logo-img']"));
            logoButton.click();
        }
    }

    @When("I go to item {string} from search field")
    public void iGoToItemFromSearchField(String arg0) {
        generalStepDefs.isElementVisible("//input[contains(@class,'MuiOutlinedInput-inputAdornedStart')]");
        conciergeUserAccountPage.getSearchItemField().sendKeys(arg0);
        conciergeUserAccountPage.getSearchButton().click();
        generalStepDefs.isElementVisible("//span[@class='MuiButton-label']");
        conciergeUserAccountPage.getSeeResultsButton().click();
    }

    @When("I agree to the terms of sale")
    public void iAgreeToTheTermsOfSale() {
        WebElement agreeCheckBox = webDriver.findElement(By.xpath("//span[@class='MuiTypography-root MuiFormControlLabel-label MuiTypography-body1']/span"));
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", agreeCheckBox);
        WebElement updateButton = webDriver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-2 MuiGrid-grid-md-2']/button"));
        updateButton.click();
    }

    @When("I choose {string} from brand menu")
    public void iChooseFromBrandMenu(String brand) {
        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getOrderHistoryButton()));
        conciergeUserAccountPage.getBrandButton().click();

        if (brand.equals("RH Modern")) {
            conciergeUserAccountPage.getListOfBrands().get(1).click();
            generalStepDefs.isElementVisible("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li[1]");
        }
        if (brand.equals("RH Baby&Child")) {
            conciergeUserAccountPage.getListOfBrands().get(2).click();
            generalStepDefs.isElementVisible("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li[2]");
        }
        if (brand.equals("RH Teen")) {
            conciergeUserAccountPage.getListOfBrands().get(3).click();
            generalStepDefs.isElementVisible("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li[3]");
        }
        if (brand.equals("RH Outdoor")) {
            conciergeUserAccountPage.getListOfBrands().get(4).click();
            generalStepDefs.isElementVisible("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li[4]");
        }
        if (brand.equals("RH SKI House")) {
            conciergeUserAccountPage.getListOfBrands().get(5).click();
            generalStepDefs.isElementVisible("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li[5]");
        }
        if (brand.equals("RH Beach House")) {
            conciergeUserAccountPage.getListOfBrands().get(6).click();
            generalStepDefs.isElementVisible("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li[6]");
        }
        if (brand.equals("RH Interiors")) {
            conciergeUserAccountPage.getListOfBrands().get(7).click();
            generalStepDefs.isElementVisible("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li[7]");
        }
    }

    @And("I choose client as member from header")
    public void iChooseClientAsMemberFromHeader() {
        
    }
}



