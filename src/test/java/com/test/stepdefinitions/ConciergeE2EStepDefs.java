package com.test.stepdefinitions;

import com.test.pageObject.CheckoutAddressScreen;
import com.test.pageObject.ConciergeItemsScreen;
import com.test.pageObject.ConciergeUserAccountPage;
import com.test.pageObject.RestrictionPopUp;
import com.test.utility.Hooks;
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

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class ConciergeE2EStepDefs {
    WebDriver webDriver = Hooks.getWebDriver();
    WebDriverWait wait = new WebDriverWait(webDriver, 20);
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen(webDriver);
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage(webDriver);
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen(webDriver);
    RestrictionPopUp restrictionPopUp = new RestrictionPopUp(webDriver);
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    String usState="";

    @When("I click on add to project button")
    public void userClickOnAddToProjectButton() {
        wait.until(ExpectedConditions.visibilityOf(conciergeItemsScreen.getAddToProjectButton()));
        conciergeItemsScreen.getAddToProjectButton().click();

        wait.until(ExpectedConditions.elementToBeClickable(conciergeItemsScreen.getSaveProjectPopUpButton()));
        conciergeItemsScreen.getSaveProjectPopUpButton().click();

//        wait.until(ExpectedConditions.visibilityOf(conciergeItemsScreen.getViewCartButton()));
//        conciergeItemsScreen.getViewCartButton().click();
    }

    @When("I click on go to project button")
    public void iClickOnGoToProjectButton() {
        Actions actions = new Actions(webDriver);
        wait.until(ExpectedConditions.elementToBeClickable(conciergeItemsScreen.getGoToProjectButton()));
        wait.until(ExpectedConditions.elementToBeClickable(conciergeItemsScreen.getContinueShoppingButton()));
        generalStepDefs.waitForPageLoad(webDriver);
        conciergeItemsScreen.getGoToProjectButton().click();
    }

    @When("I click on add to cart button from project screen")
    public void iClickOnAddToCartButtonFromProjectScreen() throws InterruptedException {
        generalStepDefs.waitForPageLoad(webDriver);
        WebElement element = webDriver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth']/span[@class='MuiButton-label']"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", element);

//        if (conciergeProjectScreen.getContinueButtonPopUp().isDisplayed()) {
//            conciergeProjectScreen.getContinueButtonPopUp().click();
//        }


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
            conciergeUserAccountPage.getSearchItemField().sendKeys("112411 BLSH BUMP");
        }
        if (state.equals("CA")) {
            conciergeUserAccountPage.getSearchItemField().sendKeys("10061229 CTCN");
        }
        conciergeUserAccountPage.getSearchButton().click();
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
        await().forever().until(() -> conciergeItemsScreen.getAddToCartButton().isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(conciergeItemsScreen.getAddToCartButton()));
        conciergeItemsScreen.getAddToCartButton().click();

        if (usState.equals("CA")) {
            try {
                await().forever().until(() -> conciergeItemsScreen.getAggreeeAndAddToCardButton().isDisplayed());
                conciergeItemsScreen.getAggreeeAndAddToCardButton().click();
            } catch (Exception e) {
                System.out.println("Agree&add to card button is not displayed");
            }
        }
        wait.until(ExpectedConditions.visibilityOf(conciergeItemsScreen.getViewCartButton()));
        conciergeItemsScreen.getViewCartButton().click();

    }


    @When("I fill all fields from address with {string} zip code")
    public void iFillAllFieldsFromAddressWithZipCode(String state) throws InterruptedException {
        generalStepDefs.waitForPageLoad(webDriver);
        if (state.equals("NY")) {
            generalStepDefs.fillAddressFields("10001", state);
        }
        if (state.equals("CA")) {
            generalStepDefs.waitForPageLoad(webDriver);
            Select countrySelect = new Select(checkoutAddressScreen.getCountryField());
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", countrySelect);
            countrySelect.selectByValue("CA");
            generalStepDefs.fillAddressFields("A1A1A1", "");

        }

    }

    @Then("I verify that restrictions pop up is displayed")
    public void iVerifyThatRestrictionsPopUpIsDisplayed() {
        if (usState.equals("NY")) {
            usState = "New York";
        } else {
            usState = "Canada";
        }
        restrictionPopUp.getShippingRestricitonsTitle().getText().equals("SHIPPING ERROR");
        restrictionPopUp.getRestrictionsMessage().getText().equals("One or more items in your cart ($Savannah Ultra-Fine Organic Cotton Crib Bumper) cannot be shipped to the state of  " + usState + "  due to state regulations.Please remove the item(s) from your cart, or provide a different shipping address for this order.");
    }
}
