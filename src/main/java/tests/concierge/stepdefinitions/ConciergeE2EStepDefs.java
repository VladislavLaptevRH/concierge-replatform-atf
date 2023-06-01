package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.Keys;
import tests.utility.Hooks;
import tests.concierge.pageObject.*;
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
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.awaitility.Awaitility.with;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ConciergeE2EStepDefs {
    ConfirmationOrderScreen confirmationOrderScreen = new ConfirmationOrderScreen();
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
    AbstractStepDefs abstractStepDefs = new AbstractStepDefs();
    PaymentStepDefs paymentStepDefs = new PaymentStepDefs();
    PdpScreen pdpScreen = new PdpScreen();

    String usState = "";
    String countOfItems = null;
    WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofMinutes(1));
    String environment;

    @When("I click on add to project button")
    public void userClickOnAddToProjectButton() {
        //conciergeItemsScreen.getAddToProjectButton().should(Condition.and("", enabled, visible), Duration.ofSeconds(12));
        if (!conciergeItemsScreen.getAddToProjectButton().isEnabled()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
            conciergeItemsScreen.getAddToProjectButton().scrollTo();
            conciergeItemsScreen.getAddToProjectButton().click();
        } else {
            conciergeItemsScreen.getAddToProjectButton().scrollTo();
            conciergeItemsScreen.getAddToProjectButton().click();
        }

    }

    @When("I click on go to project button")
    public void iClickOnGoToProjectButton() {
        generalStepDefs.isElementVisible("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4'][1]//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained')]");
        conciergeItemsScreen.getContinueShoppingButton().should(visible, Duration.ofSeconds(12));
        conciergeItemsScreen.getGoToProjectButton().click();
    }

    @When("I click on add to cart button from project screen")
    public void iClickOnAddToCartButtonFromProjectScreen() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (!conciergeProjectScreen.getAddToCartButton().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
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
//        with().pollInterval(3, SECONDS).await().until(() -> true);
//        WebDriverRunner.getWebDriver().navigate().refresh();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        if (conciergeItemsScreen.getAddToCartButtonDisabled().isDisplayed()) {
            for (int i = 0; i < 3; i++) {
                WebDriverRunner.getWebDriver().navigate().refresh();
                if (!conciergeItemsScreen.getAddToCartButtonDisabled().isDisplayed()) {
                    break;
                }
            }
        }
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeItemsScreen.getAddToCartButton().scrollTo();
        if (conciergeItemsScreen.getAddToCartButtonDisabled().isDisplayed()) {
            if (conciergeItemsScreen.getSelectFabric().isDisplayed()) {
                try {
                    Select fabricList = new Select(conciergeItemsScreen.getSelectFabric());
                    fabricList.selectByVisibleText("Perennials Performance Textured Linen Weave");
                    with().pollInterval(1, SECONDS).await().until(() -> true);
                } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException e) {
                    System.out.println("Element not found");
                }
            }
            if (conciergeItemsScreen.getSelectSize().isDisplayed()) {
                try {
                    Select sizeList = new Select(conciergeItemsScreen.getSelectSize());
                    sizeList.selectByVisibleText("Washcloth");
                } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException e) {
                    System.out.println("Element not found");
                }
                with().pollInterval(1, SECONDS).await().until(() -> true);
            }

            if (conciergeItemsScreen.getSelectSize().isDisplayed()) {
                try {
                    Select sizeList = new Select(conciergeItemsScreen.getSelectSize());
                    sizeList.selectByVisibleText("Queen");
                } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException e) {
                    System.out.println("Element not found");
                }
                with().pollInterval(1, SECONDS).await().until(() -> true);
            }

                if (conciergeItemsScreen.getSelectColor().isDisplayed()) {
                    try {
                        Select colorList = new Select(conciergeItemsScreen.getSelectColor());
                        colorList.selectByVisibleText("Fog");
                    } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException e) {
                        System.out.println("Element not found");
                    }
                    with().pollInterval(1, SECONDS).await().until(() -> true);
                }
            if (conciergeItemsScreen.getSelectFinish().isDisplayed()) {
                try {
                    Select finishList = new Select(conciergeItemsScreen.getSelectFinish());
                    finishList.selectByVisibleText("Fog");
                } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException e) {
                    System.out.println("Element not found");
                }
                with().pollInterval(1, SECONDS).await().until(() -> true);
            }
            if (conciergeItemsScreen.getSelectFinish().isDisplayed()) {
                try {
                    Select finishList = new Select(conciergeItemsScreen.getSelectFinish());
                    finishList.selectByVisibleText("Antiqued Natural");
                } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException e) {
                    System.out.println("Element not found");
                }
                with().pollInterval(1, SECONDS).await().until(() -> true);
            }

            if (conciergeItemsScreen.getSelectQTY().isDisplayed()) {
                try {
                    Select quantityList = new Select(conciergeItemsScreen.getSelectQTY());
                    quantityList.selectByVisibleText("1");
                    with().pollInterval(1, SECONDS).await().until(() -> true);
                } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException e) {
                    System.out.println("Element not found");
                }
            }
        }
            conciergeItemsScreen.getAddToCartButton().shouldHave(text("ADD TO CART"), Duration.ofSeconds(50));
        if (conciergeItemsScreen.getAddToCartButtonDisabled().isDisplayed()) {
            for (int i = 0; i < 3; i++) {
                WebDriverRunner.getWebDriver().navigate().refresh();
                if (!conciergeItemsScreen.getAddToCartButtonDisabled().isDisplayed()) {
                    break;
                }
            }
        }
            conciergeItemsScreen.getAddToCartButton().click();
            with().pollInterval(5, SECONDS).await().until(() -> true);

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
        generalStepDefs.removeLineItemFromConciergeCart();
        with().pollInterval(3, SECONDS).await().until(() -> true);
    }

    @When("I confirm edited address")
    public void iConfirmEditedAddress() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        checkoutAddressScreen.getContinueButton().should(visible, Duration.ofSeconds(2));
        checkoutAddressScreen.getContinueButton().click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
    }

    @When("I continue to payment")
    public void continueToPaymentAfterAddressCheckout() {
        if (!checkoutAddressScreen.getContinuePaymentButton().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
            abstractStepDefs.iClickOnCheckoutButton();
            iClickOnNoThanksButton();
            abstractStepDefs.iFillAllFieldsFromAddressScreenForBrands();
        }
        checkoutAddressScreen.getContinuePaymentButton().shouldHave(text(checkoutAddressScreen.getContinuePaymentButton().getText()), Duration.ofMinutes(1));
        executeJavaScript("arguments[0].scrollIntoView(true);", checkoutAddressScreen.getContinuePaymentButton());
        checkoutAddressScreen.getContinuePaymentButton().shouldHave(text(checkoutAddressScreen.getContinuePaymentButton().getText()), Duration.ofMinutes(1));
        checkoutAddressScreen.getContinuePaymentButton().click();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (conciergeProjectScreen.getTryAgainButton().isDisplayed()) {
            conciergeProjectScreen.getTryAgainButton().click();
            with().pollInterval(3, SECONDS).await().until(() -> true);
            abstractStepDefs.iFillAllFieldsFromAddressScreenForBrands();
            checkoutAddressScreen.getContinuePaymentButton().click();
            with().pollInterval(3, SECONDS).await().until(() -> true);
        }

        if (conciergeProjectScreen.getContinueWithSuggestedAddressButton().isDisplayed()) {
            conciergeProjectScreen.getContinueWithSuggestedAddressButton().click();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }

        if ($(By.xpath("//*[text() = 'CONTINUE']")).isDisplayed()) {
            $(By.xpath("//*[text() = 'CONTINUE']")).click();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }

        if (conciergeProjectScreen.getTryAgainButton().isDisplayed()) {
            conciergeProjectScreen.getTryAgainButton().click();
            with().pollInterval(3, SECONDS).await().until(() -> true);
            abstractStepDefs.iFillAllFieldsFromAddressScreenForBrands();
            checkoutAddressScreen.getContinuePaymentButton().click();
            with().pollInterval(3, SECONDS).await().until(() -> true);
            $(By.xpath("//*[text() = 'CONTINUE']")).click();
            with().pollInterval(5, SECONDS).await().until(() -> true);
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
        with().pollInterval(3, SECONDS).await().until(() -> true);
        conciergeUserAccountPage.getSearchItemField().setValue(arg0);
        $(By.xpath("//button[contains(@class,'MuiButton-containedSizeLarge')]")).click();
    }

    @When("I choose {string} from brand menu")
    public void iChooseFromBrandMenu(String brand) {
        conciergeUserAccountPage.getBrandButton().should(visible, Duration.ofSeconds(12));
        conciergeUserAccountPage.getBrandButton().click();

        if (Hooks.profile.contains("stg2")) {
            environment = "stg2";

        } else if (Hooks.profile.contains("stg4")) {
            environment = "stg4";

        } else if (Hooks.profile.contains("prod")) {
            environment = "null";
        }

        if (brand.equals("RH Modern") && Hooks.profile.equals("prod")) {
            $(By.xpath("//li[@data-analytics-url='https://rhmodern.rh.com/']")).shouldHave(text("RH MODERN"), Duration.ofSeconds(20));
            $(By.xpath("//li[@data-analytics-url='https://rhmodern.rh.com/']")).click();
        } else if (brand.equals("RH Modern")) {
            $(By.xpath("//li[@data-analytics-url='https://rhmodern. " + environment + ".rhnonprod.com/']")).shouldHave(text("RH MODERN"), Duration.ofSeconds(20));
            $(By.xpath("//li[@data-analytics-url='https://rhmodern." + environment + ".rhnonprod.com/']")).click();
        }

        if (brand.equals("RH Baby&Child") && Hooks.profile.equals("prod")) {
            $(By.xpath("//li[@data-analytics-url='https://rhbabyandchild.rh.com/']")).shouldHave(text("RH BABY & CHILD"));
            $(By.xpath("//li[@data-analytics-url='https://rhbabyandchild.rh.com/']")).click();
        } else if (brand.equals("RH Baby&Child")) {
            $(By.xpath("//li[@data-analytics-url='https://rhbabyandchild." + environment + ".rhnonprod.com/']")).shouldHave(text("RH BABY & CHILD"));
            $(By.xpath("//li[@data-analytics-url='https://rhbabyandchild." + environment + ".rhnonprod.com/']")).click();
        }

        if (brand.equals("RH Teen") && Hooks.profile.equals("prod")) {
            $(By.xpath("//li[@data-analytics-url='https://rhteen.rh.com/']")).shouldHave(text("RH TEEN"), Duration.ofSeconds(10));
            $(By.xpath("//li[@data-analytics-url='https://rhteen.rh.com/']")).click();
        } else if (brand.equals("RH Teen")) {
            $(By.xpath("//li[@data-analytics-url='https://rhteen.stg2.rhnonprod.com/']/span")).shouldHave(text("RH TEEN"), Duration.ofSeconds(10));
            $(By.xpath("//li[@data-analytics-url='https://rhteen.stg2.rhnonprod.com/']/span")).click();
        }

        if (brand.equals("RH Outdoor") && Hooks.profile.equals("prod")) {
            $(By.xpath("//li[@data-analytics-url='https://rhoutdoor.rh.com/']")).shouldHave(text("RH Outdoor"), Duration.ofSeconds(10));
            $(By.xpath("//li[@data-analytics-url='https://rhoutdoor.rh.com/']")).click();
        } else if (brand.equals("RH Outdoor")) {
            $(By.xpath("//li[@data-analytics-url='https://rhoutdoor." + environment + ".rhnonprod.com/']")).shouldHave(text("RH Outdoor"), Duration.ofSeconds(10));
            $(By.xpath("//li[@data-analytics-url='https://rhoutdoor." + environment + ".rhnonprod.com/']")).click();
        }

        if (brand.equals("RH SKI House") && Hooks.profile.equals("prod")) {
            $(By.xpath("//li[@data-analytics-url='https://rhskihouse.rh.com/']")).shouldHave(text("RH SKI House"), Duration.ofSeconds(10));
            $(By.xpath("//li[@data-analytics-url='https://rhskihouse.rh.com/']")).click();
        } else if (brand.equals("RH SKI House")) {
            $(By.xpath("//li[@data-analytics-url='https://rhskihouse." + environment + ".rhnonprod.com/']")).shouldHave(text("RH SKI House"), Duration.ofSeconds(10));
            $(By.xpath("//li[@data-analytics-url='https://rhskihouse." + environment + ".rhnonprod.com/']")).click();
        }

        if (brand.equals("RH Beach House") && Hooks.profile.equals("prod")) {
            $(By.xpath("//li[@data-analytics-url='https://rhbeachhouse.rh.com/']")).shouldHave(text("RH Beach House"), Duration.ofSeconds(10));
            $(By.xpath("//li[@data-analytics-url='https://rhbeachhouse.rh.com/']")).click();
        } else if (brand.equals("RH Beach House")) {
            $(By.xpath("//li[@data-analytics-url='https://rhbeachhouse." + environment + ".rhnonprod.com/']")).shouldHave(text("RH Beach House"), Duration.ofSeconds(10));
            $(By.xpath("//li[@data-analytics-url='https://rhbeachhouse." + environment + ".rhnonprod.com/']")).click();
        }

        if (brand.equals("RH Interiors") && Hooks.profile.equals("prod")) {
            $(By.xpath("//li[@data-analytics-url='https://rhinteriors.rh.com/']")).shouldHave(text("RH Interiors"), Duration.ofSeconds(10));
            $(By.xpath("//li[@data-analytics-url='https://rhinteriors.rh.com/']")).click();
        } else if (brand.equals("RH Interiors")) {
            $(By.xpath("//li[@data-analytics-url='https://rhinteriors." + environment + ".rhnonprod.com/']")).shouldHave(text("RH Interiors"), Duration.ofSeconds(10));
            $(By.xpath("//li[@data-analytics-url='https://rhinteriors." + environment + ".rhnonprod.com/']")).click();
        }

    }

    @When("I click on no thanks button")
    public void iClickOnNoThanksButton() {
        if (conciergeCartPageScreen.getNoThanksButton().isDisplayed()) {
            generalStepDefs.waitForJSandJQueryToLoad();
            conciergeCartPageScreen.getNoThanksButton().shouldHave(text("NO, THANKS"), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(conciergeCartPageScreen.getNoThanksButton()));
            wait.until(ExpectedConditions.visibilityOf(conciergeCartPageScreen.getNoThanksButton()));
//            Actions actions = new Actions(WebDriverRunner.getWebDriver());
//            actions.moveToElement(conciergeCartPageScreen.getNoThanksButton());
//            conciergeCartPageScreen.getNoThanksButton().scrollIntoView(true);
            generalStepDefs.waitForJSandJQueryToLoad();
//            with().pollInterval(2, SECONDS).await().until(() -> true);
            executeJavaScript("arguments[0].click();", conciergeCartPageScreen.getNoThanksButton());
            with().pollInterval(2, SECONDS).await().until(() -> true);
        } else {
            System.out.println("Close button is not displayed");
        }
        if (conciergeCartPageScreen.getNoThanksButton().isDisplayed()) {
            for (int i = 0; i < 3; i++) {
                conciergeCartPageScreen.getNoThanksButton().click();
                with().pollInterval(2, SECONDS).await().until(() -> true);
                if (!conciergeCartPageScreen.getNoThanksButton().isDisplayed()) {
                    break;
                }
            }
        }
    }

    @When("I click on continue adding additional button")
    public void iClickOnContinueAddingAdditionalButton() {
//        with().pollInterval(3, SECONDS).await().until(() -> true);
        if (conciergeCartPageScreen.getContinueAddingAdditionalButton().isDisplayed()) {
            generalStepDefs.waitForJSandJQueryToLoad();
            conciergeCartPageScreen.getContinueAddingAdditionalButton().shouldHave(text("CONTINUE"), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(conciergeCartPageScreen.getContinueAddingAdditionalButton()));
            wait.until(ExpectedConditions.visibilityOf(conciergeCartPageScreen.getContinueAddingAdditionalButton()));
            Actions actions = new Actions(WebDriverRunner.getWebDriver());
            actions.moveToElement(conciergeCartPageScreen.getContinueAddingAdditionalButton());
            conciergeCartPageScreen.getContinueAddingAdditionalButton().scrollIntoView(true);
            generalStepDefs.waitForJSandJQueryToLoad();
            executeJavaScript("arguments[0].click();", conciergeCartPageScreen.getContinueAddingAdditionalButton());
            sleep(20000);
        } else {
            System.out.println("Continue button is not displayed");
            sleep(25000);
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
        if(!conciergeUserAccountPage.getClientButton().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeUserAccountPage.getClientButton().should(visible, Duration.ofSeconds(20));
        conciergeUserAccountPage.getClientButton().click();
        with().pollInterval(1, SECONDS).await().until(() -> true);
        if (conciergeUserAccountPage.getRemoveClientByText().isDisplayed()) {
            conciergeUserAccountPage.getRemoveClientByText().click();
            with().pollInterval(1, SECONDS).await().until(() -> true);
        }
        if(pdpScreen.getCloseSpecialOrderPopUpButton().exists()){
            pdpScreen.getCloseSpecialOrderPopUpButton().click();
        }
        with().pollInterval(1, SECONDS).await().until(() -> true);
    }

    @When("I choose client who is a {string}")
    public void iChooseClientWhoIsAMember(String businessClient) {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (conciergeItemsScreen.getCheckoutButton().isDisplayed()) {
            abstractStepDefs.iClickOnCheckoutButton();
            iClickOnNoThanksButton();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }

        if (!conciergeUserAccountPage.getClientLookupFirstNameByName().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
            if (!conciergeUserAccountPage.getClientLookupFirstNameByName().isDisplayed()) {
                String URL = Hooks.conciergeBaseURL + "/checkout/shopping_cart.jsp";
                open(URL);
                with().pollInterval(5, SECONDS).await().until(() -> true);
                abstractStepDefs.iClickOnCheckoutButton();
                iClickOnNoThanksButton();
            }
        }
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (businessClient.equals("Member")) {
//            conciergeUserAccountPage.getClientLookupFirstNameByName().setValue("Automation");
//            conciergeUserAccountPage.getClientLookupLastName().setValue("Member");
            conciergeUserAccountPage.getClientLookupEmail().setValue("testmemberacc0517@gmail.com");
        } else if (businessClient.equals("Non-Member")) {
            generalStepDefs.clearField(conciergeUserAccountPage.getClientLookupFirstNameByName());
            conciergeUserAccountPage.getClientLookupFirstNameByName().setValue("Automation");

            if (Hooks.profile.equals("stg3")) {
                generalStepDefs.clearField(conciergeUserAccountPage.getClientLookupStg3LastName());
                conciergeUserAccountPage.getClientLookupStg3LastName().setValue("Nonmember");
            } else {
                generalStepDefs.clearField(conciergeUserAccountPage.getClientLookupLastName());
                conciergeUserAccountPage.getClientLookupLastName().setValue("Nonmember");
            }

        } else if (businessClient.equals("Trade")) {
            if (!conciergeUserAccountPage.getClientLookupFirstNameByName().isDisplayed()) {
                WebDriverRunner.getWebDriver().navigate().refresh();
                with().pollInterval(5, SECONDS).await().until(() -> true);
            }
            conciergeUserAccountPage.getClientLookupFirstNameByName().setValue("Automation");
            conciergeUserAccountPage.getClientLookupLastName().setValue("Trade");
        } else if (businessClient.equals("Unclassified")) {
            conciergeUserAccountPage.getClientLookupFirstNameByName().setValue("Automation");
            conciergeUserAccountPage.getClientLookupLastName().setValue("UnclassifiedBusiness");
            with().pollInterval(2, SECONDS).await().until(() -> true);
        }
        conciergeUserAccountPage.getClientLookupSearchButton().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeUserAccountPage.getClientLookupSearchButton().shouldHave(text(conciergeUserAccountPage.getClientLookupSearchButton().getText()), Duration.ofMinutes(1));
        conciergeUserAccountPage.getClientLookupSearchButton().click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        if($(By.xpath("//*[text() = 'Select a country.']")).isDisplayed()){
            Select country = new Select($(By.xpath("//select[@id = 'country']")));
            country.selectByValue("US");
            conciergeUserAccountPage.getClientLookupSearchButton().click();
        }
        if (!conciergeOrderHistoryForm.getCustomerFirstName().shouldHave(text("NAME")).isDisplayed()) {
            conciergeUserAccountPage.getClientLookupSearchButton().click();
            with().pollInterval(9, SECONDS).await().until(() -> true);
        }
        conciergeUserAccountPage.getFirstResultOfClientLookupByName(businessClient).click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
    }


    @And("I select count of product")
    public void iSelectCountOfProduct() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        try {
            if (Hooks.cookie.equals("contentfix")) {
                if (!$(By.xpath("//*[text()=' DETAILS']")).isDisplayed()) {
                    for (int i = 0; i < 3; i++) {
                        WebDriverRunner.getWebDriver().navigate().refresh();
                        with().pollInterval(5, SECONDS).await().until(() -> true);
                        if (conciergeItemsScreen.getDetailsSpan().isDisplayed()) {
                            break;
                        }
                    }
                }
            } else {
                if (!conciergeItemsScreen.getDetailsSpan().isDisplayed()) {
                    for (int i = 0; i < 3; i++) {
                        WebDriverRunner.getWebDriver().navigate().refresh();
                        with().pollInterval(5, SECONDS).await().until(() -> true);
                        if (conciergeItemsScreen.getDetailsSpan().isDisplayed()) {
                            break;
                        }
                    }
                }
            }
        } catch (ElementNotFound e){
            System.out.println("Details button is not displaying");
        }

        if (Hooks.cookie.equals("contentfix")) {
            if (!$(By.xpath("//*[text()=' DETAILS']")).isDisplayed()) {
               abstractStepDefs.iClickOnRhConciergeLogo();
                iGoToItemFromSearchField("63130001");


            }
        } else {
            if (!conciergeItemsScreen.getDetailsSpan().isDisplayed()) {
                abstractStepDefs.iClickOnRhConciergeLogo();
                iGoToItemFromSearchField("63130001");
            }
        }

        executeJavaScript("window.scrollTo(0, 600)");
        if (conciergeItemsScreen.getAddToCartButtonDisabled().isDisplayed()) {
            for (int i = 0; i < 3; i++) {
                WebDriverRunner.getWebDriver().navigate().refresh();
                with().pollInterval(5, SECONDS).await().until(() -> true);
                if (!conciergeItemsScreen.getAddToCartButtonDisabled().isDisplayed()) {
                    break;
                }
            }
        }
        conciergeItemsScreen.getDetailsSpan().scrollTo();
        conciergeItemsScreen.getDetailsSpan().should(Condition.and("", appear, enabled), Duration.ofSeconds(20));
        conciergeItemsScreen.getDetailsSpan().shouldHave(text(conciergeItemsScreen.getDetailsSpan().getText()), Duration.ofSeconds(20));
        selectOption.getQuantityElement().should(visible, Duration.ofMinutes(1));
        if (!selectOption.getQuantityElement().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
        }

        if(conciergeItemsScreen.getSelectSize().isDisplayed()){
            try {
                Select sizeList = new Select(conciergeItemsScreen.getSelectSize());
                sizeList.selectByIndex(1);
            } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException e){
                System.out.println("Element not found");
            }
            with().pollInterval(1, SECONDS).await().until(() -> true);
        }
        if (conciergeItemsScreen.getSelectFinish().isDisplayed()) {
            try {
                Select finishList = new Select(conciergeItemsScreen.getSelectFinish());
                finishList.selectByIndex(1);
            } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException e) {
                System.out.println("Element not found");
            }
            with().pollInterval(1, SECONDS).await().until(() -> true);
        }
        if(selectOption.getQuantityElement().isDisplayed()){
            try {
                Select selectQty = new Select(selectOption.getQuantityElement());
                selectQty.selectByIndex(2);
            } catch (java.lang.UnsupportedOperationException e){
                System.out.println("Element not found");
            }
            with().pollInterval(1, SECONDS).await().until(() -> true);
        }

    }

    @Then("I verify that address screen is displayed")
    public void iVerifyThatAddressScreenIsDisplayed() {
        conciergeAddressScreen.getShippingAddressTitle().should(visible, Duration.ofSeconds(20));
        conciergeAddressScreen.getBillingAddressTitle().should(visible, Duration.ofSeconds(20));
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
        with().pollInterval(9, SECONDS).await().until(() -> true);
        executeJavaScript("window.scrollTo(0, 970)");
        try {

            selectOption.getDepthProperty().should(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select selectDepth = new Select(selectOption.getDepthProperty());

            selectDepth.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
        with().pollInterval(2, SECONDS).await().until(() -> true);

        //seatheight
        try {
            with().pollInterval(9, SECONDS).await().until(() -> true);
            selectOption.getSeatHeight().should(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select seatHeight = new Select(selectOption.getSeatHeight());

            seatHeight.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
        with().pollInterval(2, SECONDS).await().until(() -> true);

        //finish
        try {
            with().pollInterval(9, SECONDS).await().until(() -> true);
            selectOption.getFinishOption().should(Condition.be(Condition.visible), Duration.ofSeconds(5));
            Select finalOption = new Select(selectOption.getFinishOption());

            finalOption.selectByIndex(2);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
        with().pollInterval(2, SECONDS).await().until(() -> true);

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
            with().pollInterval(9, SECONDS).await().until(() -> true);
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
        with().pollInterval(2, SECONDS).await().until(() -> true);

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
        try {
            conciergeUserAccountPage.getClientLookupSearchButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(40));
            conciergeUserAccountPage.getClientLookupSearchButton().shouldHave(text(conciergeUserAccountPage.getClientLookupSearchButton().getText()), Duration.ofSeconds(40));
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
            conciergeUserAccountPage.getClientLookupSearchButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(40));
            conciergeUserAccountPage.getClientLookupSearchButton().shouldHave(text(conciergeUserAccountPage.getClientLookupSearchButton().getText()), Duration.ofSeconds(40));
        }
        conciergeUserAccountPage.getClientLookupSearchButton().click();
        conciergeOrderHistoryForm.getCustomerFirstName().shouldHave(text("NAME"), Duration.ofSeconds(40));
        executeJavaScript("arguments[0].click();", conciergeUserAccountPage.getFirstResultOfClientLookup());
    }

    @Then("I verify zipcode")
    public void iVerifyZipcode() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if($(By.xpath("(//*[text()='Edit'])[10]")).isDisplayed()) {
            $(By.xpath("(//*[text()='Edit'])[10]")).scrollIntoView(true);
            $(By.xpath("(//*[text()='Edit'])[10]")).click();
        }
        generalStepDefs.clearField(checkoutAddressScreen.getZipPostalCodeField());
        checkoutAddressScreen.getZipPostalCodeField().setValue("1234");
        $(By.xpath("//*[text()='Invalid zip/postal code.']")).should(visible, Duration.ofMinutes(1));
    }

    @When("I choose a Non-Member client and click on plus button from client lookup search results")
    public void iClickOnPlusButtonFromClientLookupSearchResults() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (conciergeItemsScreen.getCheckoutButton().isDisplayed()) {
            abstractStepDefs.iClickOnCheckoutButton();
            iClickOnNoThanksButton();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        if (!conciergeUserAccountPage.getClientLookupFirstNameByName().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
            if (!conciergeUserAccountPage.getClientLookupFirstNameByName().isDisplayed()) {
                String URL = Hooks.conciergeBaseURL + "/us/eu/checkout/shopping_cart.jsp";
                open(URL);
                with().pollInterval(5, SECONDS).await().until(() -> true);
                abstractStepDefs.iClickOnCheckoutButton();
                iClickOnNoThanksButton();
            }
        }
        with().pollInterval(5, SECONDS).await().until(() -> true);
            generalStepDefs.clearField(conciergeUserAccountPage.getClientLookupFirstNameByName());
            conciergeUserAccountPage.getClientLookupFirstNameByName().setValue("Automation");
            generalStepDefs.clearField(conciergeUserAccountPage.getClientLookupLastName());
            conciergeUserAccountPage.getClientLookupLastName().setValue("Nonmember");

        conciergeUserAccountPage.getClientLookupSearchButton().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeUserAccountPage.getClientLookupSearchButton().shouldHave(text(conciergeUserAccountPage.getClientLookupSearchButton().getText()), Duration.ofMinutes(1));
        conciergeUserAccountPage.getClientLookupSearchButton().click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        if($(By.xpath("//*[text() = 'Select a country.']")).isDisplayed()){
            Select country = new Select($(By.xpath("//select[@id = 'country']")));
            country.selectByValue("US");
            conciergeUserAccountPage.getClientLookupSearchButton().click();
        }
        if (!conciergeOrderHistoryForm.getCustomerFirstName().shouldHave(text("NAME")).isDisplayed()) {
            conciergeUserAccountPage.getClientLookupSearchButton().click();
            with().pollInterval(9, SECONDS).await().until(() -> true);
        }
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
            $(By.xpath("//*[text()='TRADE']")).should(visible, Duration.ofSeconds(30));
            if (Hooks.profile.equals("stg4")) {
                $(By.xpath("//*[text()='$1,256.00']")).should(visible, Duration.ofSeconds(20));
            } else {
                $(By.xpath("//*[text()='$2,688.00']")).should(visible, Duration.ofSeconds(20));
            }
        } else if (pageName.equals("PG")) {
            assertEquals(conciergeCartPageScreen.getTradePriceLabel().getText(), "Trade");
            if (Hooks.profile.equals("stg2")) {
                assertEquals(conciergeCartPageScreen.getTradeSalePrice().getText().replaceAll(",", ""), "$1585");
            } else {
                assertEquals(conciergeCartPageScreen.getTradeSalePrice().getText(), "$2,688.00");
            }
        } else {
            assertEquals(conciergeCartPageScreen.getTradePriceLabel().getText(), "Trade");
            if (Hooks.profile.equals("stg2")) {
                assertEquals(conciergeCartPageScreen.getTradeSalePrice().getText().replaceAll(",", ""), "$3693.00");
            } else {
                assertEquals(conciergeCartPageScreen.getTradeSalePrice().getText(), "$2,688.00");
            }
        }
    }

    @And("I fill all fields for sold to address")
    public void iFillAllFieldsForSoldToAddress() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        if($(By.xpath("(//*[text()='Edit'])[1]")).isDisplayed()) {
            $(By.xpath("(//*[text()='Edit'])[1]")).scrollIntoView(true);
            $(By.xpath("(//*[text()='Edit'])[1]")).click();
        }
        generalStepDefs.fillAddressFields();
        with().pollInterval(3, SECONDS).await().until(() -> true);
    }

    @Then("I verify that I'm able to edit shipping address")
    public void iVerifyThatIMAbleToEditShippingAddress() {
        if(Hooks.cookie.contains("prodsupport")){
            $(By.xpath("//*[text()='NewShippingAddress NewLastName']")).shouldHave(text("NewShippingAddress NewLastName"), Duration.ofSeconds(25));
            $(By.xpath("//*[text()='NewCompanyName']")).shouldHave(text("NewCompanyName"), Duration.ofSeconds(25));
            $(By.xpath("//*[text()='Newappartment']")).shouldHave(text("Newappartment"), Duration.ofSeconds(25));
            $(By.xpath("//*[text()='37 New Road']")).shouldHave(text("37 New Road"), Duration.ofSeconds(25));
            $(By.xpath("//*[text()='3234546576']")).shouldHave(text("3234546576"), Duration.ofSeconds(25));
            $(By.xpath("//*[text()='US']")).shouldHave(text("US"), Duration.ofSeconds(25));
        } else {
            $(By.xpath("//*[text()='NewShippingAddress NewLastName']")).shouldHave(text("NewShippingAddress NewLastName"), Duration.ofSeconds(25));
            $(By.xpath("//*[text()='NewAppartment']")).shouldHave(text("NewAppartment"), Duration.ofSeconds(25));
            $(By.xpath("//*[text()='Milpitas, AZ, 85020']")).shouldHave(text("Milpitas, AZ, 85020"), Duration.ofSeconds(25));
            $(By.xpath("//*[text()='37 new road']")).shouldHave(text("37 new road"), Duration.ofSeconds(25));
            $(By.xpath("//*[text()='3234546576']")).shouldHave(text("3234546576"), Duration.ofSeconds(25));
            $(By.xpath("//*[text()='US']")).shouldHave(text("US"), Duration.ofSeconds(25));
        }
    }

    @When("I edit shipping address from order review page")
    public void iEditShippingAddressFromOrderReviewPage() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        if(!conciergeAddressScreen.getEditShippingAddress().isDisplayed() || !conciergeAddressScreen.getEditShippingAddressCapital().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(3, SECONDS).await().until(() -> true);
        }
        if(conciergeAddressScreen.getEditShippingAddress().isDisplayed()){
            conciergeAddressScreen.getEditShippingAddress().should(visible, Duration.ofSeconds(15));
            conciergeAddressScreen.getEditShippingAddress().click();
            with().pollInterval(2, SECONDS).await().until(() -> true);
        } else {
            conciergeAddressScreen.getEditShippingAddressCapital().should(visible, Duration.ofSeconds(15));
            conciergeAddressScreen.getEditShippingAddressCapital().click();
            with().pollInterval(2, SECONDS).await().until(() -> true);
        }
        if($(By.xpath(" (//*[text()='Edit'])[1]")).isDisplayed()){
            $(By.xpath(" (//*[text()='Edit'])[1]")).click();
            with().pollInterval(2, SECONDS).await().until(() -> true);
        }
        checkoutAddressScreen.getFirstNameInpt().should(visible, Duration.ofSeconds(15));
        generalStepDefs.clearField(checkoutAddressScreen.getFirstNameInpt());
        checkoutAddressScreen.getFirstNameInpt().setValue("NewShippingAddress");
        generalStepDefs.clearField(checkoutAddressScreen.getLastNameField());
        checkoutAddressScreen.getLastNameField().setValue("NewLastName");
        generalStepDefs.clearField(checkoutAddressScreen.getCompanyNameField());
        checkoutAddressScreen.getCompanyNameField().setValue("NewCompanyName");
        generalStepDefs.clearField(checkoutAddressScreen.getStreetAddressField());
        checkoutAddressScreen.getStreetAddressField().setValue("37 new road");
        generalStepDefs.clearField(checkoutAddressScreen.getAptFloorSuiteField());
        checkoutAddressScreen.getAptFloorSuiteField().setValue("NewAppartment");

        generalStepDefs.clearField(checkoutAddressScreen.getCityField());
        checkoutAddressScreen.getCityField().setValue("Milpitas");

        generalStepDefs.clearField(checkoutAddressScreen.getPhoneField());
        checkoutAddressScreen.getPhoneField().setValue("3234546576");
    }

    @When("I edit billing address from order review page")
    public void iEditBillingAddressFromOrderReviewPage() {
        try {
            if (Hooks.cookie.contains("prodsupport")) {
                conciergeAddressScreen.getEditBillingAddress().should(visible, Duration.ofSeconds(15));
                conciergeAddressScreen.getEditBillingAddress().click();
                with().pollInterval(2, SECONDS).await().until(() -> true);
            } else {
                conciergeAddressScreen.getEditBillingAddressCapital().should(visible, Duration.ofSeconds(15));
                conciergeAddressScreen.getEditBillingAddressCapital().click();
                with().pollInterval(2, SECONDS).await().until(() -> true);
            }
        } catch (ElementNotFound e){
            System.out.println("Element not found");
        }

        try {
            if (Hooks.cookie.contains("prodsupport")) {
                $(By.xpath("(//*[text() = 'Billing Address']/..//*[text()='Edit'])[1]")).should(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[text() = 'Billing Address']/..//*[text()='Edit'])[1]")).click();
                with().pollInterval(2, SECONDS).await().until(() -> true);
            } else {
                $(By.xpath("(//*[text() = 'BILLING ADDRESS']/..//*[text()='EDIT'])[1]")).should(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[text() = 'BILLING ADDRESS']/..//*[text()='EDIT'])[1]")).click();
                with().pollInterval(2, SECONDS).await().until(() -> true);

            }
        }catch (ElementNotFound e){
            System.out.println("Element not found");
        }

        try {
            abstractStepDefs.iFillAllFieldsFromAddressScreenForBrands();
            generalStepDefs.clearField(checkoutAddressScreen.getFirstNameBillingAddress());
            checkoutAddressScreen.getFirstNameBillingAddress().setValue("NewFirstName");
            generalStepDefs.clearField(checkoutAddressScreen.getLastNameBillingAddress());
            checkoutAddressScreen.getLastNameBillingAddress().setValue("NewLastName");
            generalStepDefs.clearField(checkoutAddressScreen.getCompanyNameBillingAddress());
            checkoutAddressScreen.getCompanyNameBillingAddress().setValue("NewCompanyName");
            generalStepDefs.clearField(checkoutAddressScreen.getAddressLine1BillingAddress());
            checkoutAddressScreen.getAddressLine1BillingAddress().setValue("37 new road");
            generalStepDefs.clearField(checkoutAddressScreen.getAddressLine2BillingAddress());
            checkoutAddressScreen.getAddressLine2BillingAddress().setValue("NewAppartment");
            generalStepDefs.clearField(checkoutAddressScreen.getCityFieldBillingAddress());
            checkoutAddressScreen.getCityFieldBillingAddress().setValue("Milpitas");
            generalStepDefs.clearField(checkoutAddressScreen.getPhoneBillingAddress());
            checkoutAddressScreen.getPhoneBillingAddress().setValue("3234546576");
        } catch (ElementNotFound e){
            System.out.println("Element not found");
        }
    }

    @And("I verify that I'm able to edit billing address")
    public void iVerifyThatIMAbleToEditBillingAddress() {
        if(Hooks.cookie.contains("prodsupport")){
        $(By.xpath("//*[text()='NewFirstName NewLastName']")).shouldHave(text("NewFirstName NewLastName"), Duration.ofSeconds(25));
        $(By.xpath("//*[text()='NewCompanyName']")).shouldHave(text("NewCompanyName"), Duration.ofSeconds(25));
        $(By.xpath("//*[text()='Newappartment']")).shouldHave(text("Newappartment"), Duration.ofSeconds(25));
        $(By.xpath("//*[text()='37 New Road']")).shouldHave(text("37 New Road"), Duration.ofSeconds(25));
        $(By.xpath("//*[text()='Billing Address']/..//*[text()='Phoenix, AZ 85020']")).shouldHave(text("Phoenix, AZ 85020"), Duration.ofSeconds(25));
        $(By.xpath("//*[text()='Billing Address']/..//*[text()='US']")).shouldHave(text("US"), Duration.ofSeconds(25));
        $(By.xpath("//*[text()='3234546576']")).shouldHave(text("3234546576"), Duration.ofSeconds(25));
        } else {
            $(By.xpath("//*[text()='NewFirstName NewLastName']")).shouldHave(text("NewFirstName NewLastName"), Duration.ofSeconds(25));
            $(By.xpath("//*[text()='NewAppartment']")).shouldHave(text("NewAppartment"), Duration.ofSeconds(25));
            $(By.xpath("//*[text()='37 new road']")).shouldHave(text("37 new road"), Duration.ofSeconds(25));
            $(By.xpath("//*[text()='BILLING ADDRESS']/..//*[text()='Milpitas, AZ, 85020']")).shouldHave(text("Milpitas, AZ, 85020"), Duration.ofSeconds(25));
            $(By.xpath("//*[text()='BILLING ADDRESS']/..//*[text()='US']")).shouldHave(text("US"), Duration.ofSeconds(25));
            $(By.xpath("//*[text()='3234546576']")).shouldHave(text("3234546576"), Duration.ofSeconds(25));
        }
    }

    @Then("I verify the payment details and order estimate summary")
    public void iVerifyThePaymentDetailsAndOrderEstimateSummary() {
        $(By.xpath("//*[text()='Payment Information']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Cash/Check']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Order Estimate']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Subtotal']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Unlimited Furniture Delivery']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[contains(text(),'Estimated Sales Tax for ')]")).should(visible, Duration.ofSeconds(40));

    }

    @Then("I verify spo order & terms review signature")
    public void iVerifySpoOrderTermsReviewSignature() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (confirmationOrderScreen.getRequestingPlaceOrderError().isDisplayed()) {
            confirmationOrderScreen.getTryAgainButton().click();
        }
        with().pollInterval(5, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text()='ORDER & TERMS REVIEW SIGNATURE CAPTURE']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='SIGNATURE']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='CLEAR SIGNATURE']")).should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify that all the line items in the cart with the order review page")
    public void iVerifyThatAllTheLineItemsInTheCartWithTheOrderReviewPage() {
//        if(!$(By.xpath("//*[text()='Qty 1']")).isDisplayed()){
//            WebDriverRunner.getWebDriver().navigate().refresh();
//            with().pollInterval(5, SECONDS).await().until(() -> true);
//        }
        with().pollInterval(5, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text()='Qty 1']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Subtotal']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Unlimited Furniture Delivery']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[contains(text(),'Estimated Sales Tax for ')]")).should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify order details from thank you page")
    public void iVerifyOrderDetailsFromThankYouPage() {
        $(By.xpath("(//div[@data-testid='checkout-address-view'])[1]")).should(visible, Duration.ofSeconds(25));
        $(By.xpath("//*[text()='Important Information']")).should(visible, Duration.ofSeconds(25));
        conciergeCartPageScreen.getTotalMemberPrice().should(visible, Duration.ofSeconds(10));
        $(By.xpath("//*[text()='Subtotal']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Unlimited Furniture Delivery']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[contains(text(),'Estimated Sales Tax for ')]")).should(visible, Duration.ofSeconds(40));
    }

    @When("I select length option")
    public void iSelectLengthOption() {
        generalStepDefs.waitForJSandJQueryToLoad();
        with().pollInterval(6, SECONDS).await().until(() -> true);
        if (!selectOption.getLengthOption().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        //selectOption.getLengthOption().should(visible, Duration.ofSeconds(15));
        Select selectLength = new Select(selectOption.getLengthOption());
        selectLength.selectByValue("80400002");
    }

    @When("I open product page with {string} and {string} for stg3")
    public void iOpenProductPageStg3(String productId, String skuId) {
        String URL = Hooks.conciergeBaseURL + "/catalog/product/product.jsp?productId=" + productId + "&fullSkuId=" + skuId + "+FOG";
        open(URL);
        with().pollInterval(5, SECONDS).await().until(() -> true);
    }

    @When("I open product page with {string} and {string}")
    public void iOpenProductPageWithAnd(String productId, String skuId) {
        String URL = Hooks.conciergeBaseURL + "/catalog/product/product.jsp?productId=" + productId + "&fullSkuId=" + skuId + "+GREY";
        open(URL);
        if (conciergeItemsScreen.getAddToCartButtonDisabled().isDisplayed()) {
            for (int i = 0; i < 4; i++) {
                WebDriverRunner.getWebDriver().navigate().refresh();
                with().pollInterval(3, SECONDS).await().until(() -> true);
                if (!conciergeItemsScreen.getAddToCartButtonDisabled().isDisplayed()) {
                    break;
                }
            }
        }
        conciergeItemsScreen.getAddToCartButton().scrollTo();
        conciergeItemsScreen.getAddToCartButton().should(visible, Duration.ofSeconds(10));
        if (!conciergeItemsScreen.getAddToCartButton().isEnabled()) {
            try {
                Select sizeList = new Select(conciergeItemsScreen.getSelectSize());
                sizeList.selectByVisibleText("Queen");
            } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException e){
                System.out.println("Element not found");
            }
            with().pollInterval(1, SECONDS).await().until(() -> true);
            try{
            Select finishList = new Select(conciergeItemsScreen.getSelectFinish());
            finishList.selectByVisibleText("Antiqued Grey Oak");
            with().pollInterval(1, SECONDS).await().until(() -> true);
            } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException e){
                System.out.println("Element not found");
            }
            try {
                Select finishList = new Select(conciergeItemsScreen.getSelectFinish());
                finishList.selectByVisibleText("Antiqued Grey Oak");
            } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException e){
                System.out.println("Element not found");
            }
            try {
                Select finishList = new Select(conciergeItemsScreen.getSelectFinish());
                finishList.selectByVisibleText("Antiqued Grey Oak");
            } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException e){
                System.out.println("Element not found");
            }
            with().pollInterval(1, SECONDS).await().until(() -> true);
            try {
                Select quantityList = new Select(conciergeItemsScreen.getSelectQTY());
                quantityList.selectByVisibleText("1");
            } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException e){
                System.out.println("Element not found");
            }
        }
    }

    @When("I open product page with productId {string}")
    public void iOpenProductPageWithProductId(String productId) {
        String URL = Hooks.conciergeBaseURL + "/catalog/product/product.jsp?productId=" + productId + "";
        open(URL);
        with().pollInterval(6, SECONDS).await().until(() -> true);
    }

    @When("I open cart")
    public void iOpenCart() {
        String URL = Hooks.conciergeBaseURL + "/us/en/checkout/shopping_cart.jsp";
        open(URL);
        with().pollInterval(5, SECONDS).await().until(() -> true);
        boolean isCartEmpty = $(By.xpath("//*[text()='YOUR SHOPPING CART IS EMPTY']")).isDisplayed();
        if (isCartEmpty) {
            System.out.println("Calling clear order api to delete old cartId");
            // generalStepDefs.clearOrder();
            System.out.println("Cart is empty, adding item again via API call.");
            // generalStepDefs.addLineItemsToConciergeCart();
        }
        WebDriverRunner.getWebDriver().navigate().refresh();
        with().pollInterval(2, SECONDS).await().until(() -> true);
    }

    @When("I click on edit concierge billing address button")
    public void iClickOnEditConciergeBillingAddressButton() {
        System.out.println();
        if (conciergeAddressScreen.getEditBAddressButton().isDisplayed()) {
            conciergeAddressScreen.getEditBAddressButton().shouldHave(text("Edit"), Duration.ofSeconds(10));
            conciergeAddressScreen.getEditBAddressButton().click();
        }else{
            System.out.println();
        }
    }
}