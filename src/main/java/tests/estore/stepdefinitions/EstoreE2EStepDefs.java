package tests.estore.stepdefinitions;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.concierge.pageObject.*;
import tests.estore.pageObject.*;
import tests.utility.Hooks;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.awaitility.Awaitility.with;
import static org.testng.Assert.assertTrue;

public class EstoreE2EStepDefs {
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen();
    RestrictionPopUp restrictionPopUp = new RestrictionPopUp();
    EstoreGeneralStepDefs generalStepDefs = new EstoreGeneralStepDefs();
    EstoreItemPage estoreItemPage = new EstoreItemPage();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();
    ConciergeOrderHistoryForm conciergeOrderHistoryForm = new ConciergeOrderHistoryForm();
    ConciergeProjectScreen conciergeProjectScreen = new ConciergeProjectScreen();
    SelectOption selectOption = new SelectOption();
    EstoreCartPage estoreCartPage = new EstoreCartPage();
    EstoreCheckoutAddressScreen estoreCheckoutAddressScreen = new EstoreCheckoutAddressScreen();
    ConciergeAddressScreen conciergeAddressScreen = new ConciergeAddressScreen();
    EstoreAddressScreen estoreAddressScreen = new EstoreAddressScreen();
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    String countOfItems = null;
    WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofMinutes(1));

    @When("I click on add to project estore button")
    public void userClickOnAddToProjectEstoreButton() {
        conciergeItemsScreen.getAddToProjectButton().should(Condition.and("", enabled, visible), Duration.ofSeconds(12));
        conciergeItemsScreen.getAddToProjectButton().click();

    }

    @When("I click on go to project estore button")
    public void iClickOnGoToProjectEstoreButton() {
        generalStepDefs.isElementVisible("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4'][1]//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained')]");
        conciergeItemsScreen.getContinueShoppingButton().should(visible, Duration.ofSeconds(12));

        conciergeItemsScreen.getGoToProjectButton().click();
    }

    @When("I click on add to cart estore button from project screen")
    public void iClickOnAddToCartEstoreButtonFromProjectScreen() {
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeProjectScreen.getAddToCartButton().should(visible, Duration.ofSeconds(25));
        conciergeProjectScreen.getAddToCartButton().scrollIntoView(true);
        executeJavaScript("arguments[0].click();", conciergeProjectScreen.getAddToCartButton());
    }

    @When("I choose random estore brand from menu")
    public void iChooseRandomBrandFromEstoreMenu() {
        estoreUserAccountPage.getDashboardTitle().should(visible, Duration.ofSeconds(12));
        estoreUserAccountPage.getOrderHistoryButton().should(visible, Duration.ofSeconds(12));
        estoreUserAccountPage.getBrandButton().click();
        estoreUserAccountPage.getListOfBrands().get(1).click();
    }

    @When("I click on add to cart estore button")
    public void iClickOnAddToCartButton() {
        estoreItemPage.getAddToCartButton().shouldHave(text("ADD TO CART"), Duration.ofSeconds(50));
        estoreItemPage.getAddToCartButton().should(enabled);
        estoreItemPage.getAddToCartButton().scrollIntoView(true);
        estoreItemPage.getAddToCartButton().shouldBe(visible);
        estoreItemPage.getAddToCartButton().shouldBe(interactable).click(ClickOptions.usingJavaScript());
    }

    @When("I fill all estore fields from address with {string} zip code")
    public void iFillAllEstoreFieldsFromAddressWithZipCode(String state) {
        generalStepDefs.fillAddressFields();

        if (state.equals("NY")) {
            generalStepDefs.fillZipCodeStateCountry("10001", "US", "NY");
        }
        if (state.equals("CA")) {
            generalStepDefs.fillZipCodeStateCountry("A1A1A1", "CA", "");

        }
        generalStepDefs.continueToPaymentAfterAddressCheckout();
    }

    @Then("I verify that estore restrictions pop up is displayed")
    public void iVerifyThatEstoreRestrictionsPopUpIsDisplayed() {
        restrictionPopUp.getShippingRestricitonsTitle().should(visible, Duration.ofSeconds(40));
        assertTrue(restrictionPopUp.getShippingRestricitonsTitle().getText().contains("SHIPPING ERROR"));
        assertTrue(restrictionPopUp.getRestrictionsMessage().getText().contains("One or more items in your cart"));
    }


    @When("I continue to estore payment")
    public void continueToPaymentAfterEstoreAddressCheckout() {
        estoreCheckoutAddressScreen.getContinuePaymentButton().shouldHave(text(estoreCheckoutAddressScreen.getContinuePaymentButton().getText()), Duration.ofMinutes(1));
        executeJavaScript("arguments[0].scrollIntoView(true);", estoreCheckoutAddressScreen.getContinuePaymentButton());
        estoreCheckoutAddressScreen.getContinuePaymentButton().shouldHave(text(estoreCheckoutAddressScreen.getContinuePaymentButton().getText()), Duration.ofMinutes(1));
        estoreCheckoutAddressScreen.getContinuePaymentButton().click();
        try {
            estoreCheckoutAddressScreen.getContinueButton().should(visible, Duration.ofSeconds(40));
            executeJavaScript("arguments[0].click();", estoreCheckoutAddressScreen.getContinueButton());
            estoreAddressScreen.getOkButton().should(visible, Duration.ofSeconds(12));
            estoreAddressScreen.getOkButton().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Continue from popup is not displayed");
        }

    }


    @When("I add {int} times an item in the estore cart")
    public void iAddTimesAnItemInTheEstoreCart(int arg0) {
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
            selectSize.selectByIndex(EstoreGeneralStepDefs.getRandomNumberInRange(1, 3));
            sizeOption.click();

            SelenideElement finishOption = $(By.xpath("//select[@id='optionSelect-" + currentProduct + "-Finish']"));
            finishOption.click();

            Select select = new Select(finishOption);
            select.selectByIndex(EstoreGeneralStepDefs.getRandomNumberInRange(1, 9));

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

    @When("I choose estore {string} from brand menu")
    public void iChooseFromBrandEstoreMenu(String brand) {
        estoreUserAccountPage.getBrandButton().should(visible, Duration.ofSeconds(12));
        estoreUserAccountPage.getBrandButton().click();

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

    @When("I click on estore no thanks button")
    public void iClickOnNoThanksEstoreButton() {
        generalStepDefs.waitForJSandJQueryToLoad();
        estoreCartPage.clickOnNoThanksButton();
    }

    @When("I choose estore client who is a non member")
    public void iChooseEstoreClientWhoIsANonMember() {
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

    @When("I remove estore client from header")
    public void iRemoveEstoreClientFromHeader() {
        generalStepDefs.waitForJSandJQueryToLoad();

        try {
            if ($(By.xpath("//*[contains(text(),'Client: ')]")).isDisplayed()) {
                conciergeUserAccountPage.getClientButton().should(visible, Duration.ofSeconds(10));
                conciergeUserAccountPage.getClientButton().click();
                conciergeUserAccountPage.getRemoveClientByText().shouldHave(text("Remove Client"), Duration.ofSeconds(5));
                conciergeUserAccountPage.getRemoveClientByText().click();
            }
        } catch (AssertionError e) {
            System.out.println("Client is not selected");
        }
    }

    @When("I choose estore client who is a {string}")
    public void iChooseEstoreClientWhoIsAMember(String businessClient) {
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeUserAccountPage.getClientLookupFirstName().should(visible, Duration.ofSeconds(25));
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


    @And("I select count of estore product")
    public void iSelectCountOfEstoreProduct() {
        executeJavaScript("window.scrollTo(0, 1200)");
        conciergeItemsScreen.getDetailsSpan().should(Condition.and("", appear, enabled), Duration.ofSeconds(20));
        conciergeItemsScreen.getDetailsSpan().shouldHave(text(conciergeItemsScreen.getDetailsSpan().getText()), Duration.ofMinutes(3));
        selectOption.getQuantityElement().should(visible, Duration.ofMinutes(1));

        Select selectQty = new Select(selectOption.getQuantityElement());
        selectQty.selectByIndex(2);
    }

    @Then("I verify that estore address screen is displayed")
    public void iVerifyThatEstoreAddressScreenIsDisplayed() {
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

    @When("I click on estore sale point of menu")
    public void iClickOnSaleEstorePointOfMenu() {
        conciergeUserAccountPage.getOutdoorMenu().shouldHave(text("Outdoor"), Duration.ofMinutes(1));
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(conciergeUserAccountPage.getOutdoorMenu());

        conciergeUserAccountPage.getOutdoorMenu().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeUserAccountPage.getOutdoorMenu().click();

    }

    @When("I click on estore chairs submenu")
    public void iClickOnEstoreChairsSubmenu() {
        conciergeUserAccountPage.getChairsSubMenu().shouldHave(text("Chairs"), Duration.ofMinutes(1));
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(conciergeUserAccountPage.getChairsSubMenu());
        conciergeUserAccountPage.getChairsSubMenu().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeUserAccountPage.getChairsSubMenu().click();
    }

    @When("I select estore finish option")
    public void iSelectEstoreFinishOption() {
        selectOption.getFinishOption().should(visible, Duration.ofMinutes(1));
        selectOption.getFinishOption().scrollIntoView(true);
        Select selectFinish = new Select(selectOption.getFinishOption());
        selectFinish.selectByIndex(1);
    }

    @When("I clicks on estore sofa collections")
    public void iClicksOnEstoreSofaCollections() {
        $(By.xpath("//*[text()='Sofa Collections']")).shouldHave(text("Sofa Collections"), Duration.ofSeconds(12));
        $(By.xpath("//*[text()='Sofa Collections']")).click();
    }

    @When("I click on see results estore button")
    public void iClickOnSeeEstoreResultsButton() {
        try {
            $(By.xpath("//*[contains(text(),'See Results on')]")).should(visible, Duration.ofSeconds(15));
            $(By.xpath("//*[contains(text(),'See Results on')]")).click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("See Results on button is not displayed");
        }
    }

    @When("I click estore on {string}")
    public void iClickEstoreOn(String arg0) {
        SelenideElement brand = $(By.xpath("//*[contains(text(),'" + arg0 + "')]")).should(visible, Duration.ofSeconds(12));
        String brandValue = brand.getText();
        countOfItems = brandValue.substring(brandValue.indexOf("("), brandValue.indexOf(")")).replaceAll("\\(", "");
        $(By.xpath("//*[contains(text(),'" + arg0 + "')]")).click();
    }

    @Then("I verify that estore {string} are displayed")
    public void iVerifyThatAreEstoreDisplayed(String arg0) {
        $(By.xpath("//*[text()='" + arg0 + "']")).shouldHave(text(arg0), Duration.ofSeconds(20));
        $(By.xpath("//*[text()='" + arg0 + "']")).click();
    }

    @When("I look on estore client by {string} with {string}")
    public void iChooseClientEstoreByWhoIsA(String searchParam, String businessClient) {
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

    @Then("I verify estore zipcode")
    public void iVerifyEstoreZipcode() {
        generalStepDefs.clearField(checkoutAddressScreen.getZipPostalCodeField());
        checkoutAddressScreen.getZipPostalCodeField().setValue("1234");
        $(By.xpath("//*[text()='Invalid zip/postal code.']")).should(visible, Duration.ofMinutes(1));
    }

    @When("I click on estore plus button from client lookup search results")
    public void iClickOnEstorePlusButtonFromClientLookupSearchResults() {
        conciergeUserAccountPage.getSearchClientResultsPlusButton().should(visible, Duration.ofMinutes(1));
        conciergeUserAccountPage.getSearchClientResultsPlusButton().click();
    }

    @Then("I verify that estore tax exempt checkbox is unchecked by default for trade client")
    public void iVerifyThatEstoreTaxExemptCheckboxIsUncheckedByDefaultForTradeClient() {
        conciergeAddressScreen.getSoldToTaxExempt().shouldNotBe(visible, Duration.ofSeconds(15));
    }

    @Then("I verify estore trade prices for {string}")
    public void iVerifyEstoreTradePricesForPDP(String pageName) {
        if (pageName.equals("project page")) {
            $(By.xpath("//*[text()='TRADE']")).should(visible, Duration.ofSeconds(30));
            $(By.xpath("//*[text()='$3,165.00']")).should(visible, Duration.ofSeconds(40));

        } else {
            $(By.xpath("//*[text()='Trade']")).should(visible, Duration.ofSeconds(30));
            $(By.xpath("//*[text()='1509']")).should(visible, Duration.ofSeconds(40));
        }
    }

    @And("I fill all estore fields for sold to address")
    public void iFillAllEstoreFieldsForSoldToAddress() {
        generalStepDefs.fillAddressFields();
        generalStepDefs.fillZipCodeStateCountry("12345", "US", "");
        $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item']//input[@type='checkbox'])[2]")).scrollIntoView(true);
        $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item']//input[@type='checkbox'])[2]")).click();

        $(By.cssSelector("body > div:nth-child(7) > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > label:nth-child(1) > span:nth-child(1) > span:nth-child(1) > input:nth-child(1)")).click();
    }

    @Then("I verify that I'm able to edit estore shipping address")
    public void iVerifyThatIMAbleToEditEstoreShippingAddress() {
        $(By.xpath("//*[text()='NewShippingAddress Automation']")).shouldHave(text("NewShippingAddress"), Duration.ofSeconds(25));
    }

    @When("I edit estore shipping address from order review page")
    public void iEditShippingEstoreAddressFromOrderReviewPage() {

        conciergeAddressScreen.getEditShippingAddress().should(visible, Duration.ofSeconds(15));
        conciergeAddressScreen.getEditShippingAddress().click();
        checkoutAddressScreen.getFirstNameInpt().should(visible, Duration.ofSeconds(15));
        generalStepDefs.clearField(checkoutAddressScreen.getFirstNameInpt());
        checkoutAddressScreen.getFirstNameInpt().setValue("NewShippingAddress");
    }

    @When("I edit estore billing address from order review page")
    public void iEditBillingEstoreAddressFromOrderReviewPage() {
        conciergeAddressScreen.getEditBillingAddress().should(visible, Duration.ofSeconds(15));
        conciergeAddressScreen.getEditBillingAddress().click();
        generalStepDefs.clearField(checkoutAddressScreen.getFirstNameBillingAddress());
        checkoutAddressScreen.getFirstNameBillingAddress().setValue("NewBillingAddress");
    }

    @And("I verify that I'm able to edit estore billing address")
    public void iVerifyThatIMAbleToEditEstoreBillingAddress() {
        $(By.xpath("//*[text()='NewBillingAddress Automation']")).shouldHave(text("NewBillingAddress"), Duration.ofSeconds(25));
    }

    @Then("I verify the estore payment details and order estimate summary")
    public void iVerifyTheEstorePaymentDetailsAndOrderEstimateSummary() {
        $(By.xpath("//*[text()='Payment Information']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Cash/Check']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Order Estimate']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Subtotal']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Unlimited Furniture Delivery']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[contains(text(),'Estimated Sales Tax for ')]")).should(visible, Duration.ofSeconds(40));

    }

    @Then("I verify estore spo order & terms review signature")
    public void iVerifyEstoreSpoOrderTermsReviewSignature() {
        $(By.xpath("//*[text()='ORDER & TERMS REVIEW SIGNATURE CAPTURE']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='SIGNATURE']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='CLEAR SIGNATURE']")).should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify that all the line items in the cart with the estore order review page")
    public void iVerifyThatAllTheLineEstoreItemsInTheCartWithTheOrderReviewPage() {
        $(By.xpath("//*[text()='Qty 1']")).should(visible, Duration.ofSeconds(40));
        conciergeCartPageScreen.getTotalMemberPrice().shouldHave(text("$2,156.00"), Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Subtotal']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Unlimited Furniture Delivery']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[contains(text(),'Estimated Sales Tax for ')]")).should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify order details from estore thank you page")
    public void iVerifyEstoreOrderDetailsFromThankYouPage() {
        estoreAddressScreen.getShippingAddressTitle().should(visible, Duration.ofSeconds(25));
        $(By.xpath("//*[text()='Billing Address']")).should(visible, Duration.ofSeconds(25));
        $(By.xpath("//*[text()='Important Information']")).should(visible, Duration.ofSeconds(25));
        conciergeCartPageScreen.getTotalMemberPrice().shouldHave(text("$2,156.00"), Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Subtotal']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Unlimited Furniture Delivery']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[contains(text(),'Estimated Sales Tax for ')]")).should(visible, Duration.ofSeconds(40));
    }

    @When("I select estore length option")
    public void iSelectEstoreLengthOption() {
        generalStepDefs.waitForJSandJQueryToLoad();

        selectOption.getLengthOption().should(visible, Duration.ofSeconds(15));
        Select selectLength = new Select(selectOption.getLengthOption());
        selectLength.selectByValue("80400002");
    }

    @When("I click on same as estore shipping address checkbox")
    public void iClickOnSameAsShippingAddressCheckbox() {
        if(estoreAddressScreen.getSameAsShippingAddress().is(visible)) {
                estoreAddressScreen.getSameAsShippingAddress().should(Condition.and("Exist ,appear, interactable",
                        exist, appear, interactable), Duration.ofSeconds(15));
                estoreAddressScreen.getSameAsShippingAddress().click(ClickOptions.usingJavaScript());
        }
        else{
            estoreAddressScreen.getSameAsShippingAddress().shouldNotBe(interactable);
        }
    }

    @When("I click on continue payment method estore button")
    public void iClickOnContinuePaymentMethodEstoreButton() {

        try {
            if (estoreAddressScreen.getContinueToPayment().isDisplayed()) {
                estoreAddressScreen.getContinueToPayment().scrollIntoView(true);
                estoreAddressScreen.getContinueToPayment().should(visible, Duration.ofSeconds(2));
                estoreAddressScreen.getContinueToPayment().click();

            } else {
                estoreAddressScreen.getContinuePayment().scrollIntoView(true);
                estoreAddressScreen.getContinuePayment().should(visible, Duration.ofSeconds(2));
                estoreAddressScreen.getContinuePayment().click();

            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Continue button is not displayed");
        }
    }

    @When("I open direct product page on estore")
    public void iOpenDirectProductPageOnEstore() {
        String url = "https://stg2.rhnonprod.com/catalog/product/product.jsp?productId=prod690088&fullSkuId=63130001+NATL";
        open(url);
        WebDriverRunner.getWebDriver().navigate().refresh();
    }

    @When("I open estore product page with productId {string} and skuId {string}")
    public void iOpenEstoreProductPageWithProductIdAndSkuId(String productId, String skuId) {
        String URL = Hooks.eStoreURL + "/catalog/product/product.jsp?productId=" + productId + "&fullSkuId=" + skuId + "+NATL";
        open(URL);

        if (!conciergeItemsScreen.getAddToCartButton().isDisplayed()) {
            open(URL);
        }
    }

    @When("I refresh current estore page")
    public void iRefreshCurrentEstorePage() {

        WebDriverRunner.getWebDriver().navigate().refresh();
    }

    @When("I open the product category {string}")
    public void IOpenProductCategory(String categoryId) {
        String URL = null;
        if (Hooks.profile.equals("stg2")) {
            URL = Hooks.eStoreBaseURL + "/catalog/category/products.jsp?categoryId=" + categoryId;
        }
        open(URL);
    }

    @When("I open product page with {string} and {string} with {string} for estore")
    public void iOpenProductPageWithAndForEstore(String productId, String skuId, String options) {
        String URL = null;
        with().pollInterval(5, SECONDS).await().until(() -> true);

        if (Hooks.profile.equals("stg3")) {
            URL = Hooks.eStoreBaseURL + "/us/en/catalog/product/product.jsp?productId=" + productId + "&fullSkuId=" + skuId + "+" + options;
        }
        if (Hooks.profile.equals("stg2")) {
            URL = Hooks.eStoreBaseURL + "/catalog/product/product.jsp?productId=" + productId + "&fullSkuId=" + skuId + "+" + options + "&categoryId=search";
        }

        open(URL);


        try {
            estoreItemPage.getAddToCartButton().should(visible);
            estoreItemPage.getAddToCartButton().scrollTo();
            if (!estoreItemPage.getAddToCartButton().isEnabled()) {
                for (int i = 0; i < 3; i++) {
                    WebDriverRunner.getWebDriver().navigate().refresh();

                    if (estoreItemPage.getAddToCartButton().isEnabled()) {
                        break;
                    }
                }
            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(2, SECONDS).await().until(() -> true);
        }
    }

    @When("I open product page with {string} and {string} for estore")
    public void iOpenProductPageAndForEstore(String productId, String skuId) {
        String URL = null;
        with().pollInterval(5, SECONDS).await().until(() -> true);
        URL = Hooks.eStoreBaseURL + "/catalog/product/product.jsp?productId=" + productId + "&fullSkuId=" + skuId + "&clientrender=true";

        open(URL);
        try {
            estoreItemPage.getAddToCartButton().should(visible, Duration.ofSeconds(20));
            estoreItemPage.getAddToCartButton().scrollTo();
            if (!estoreItemPage.getAddToCartButton().isEnabled()) {
                for (int i = 0; i < 3; i++) {
                    WebDriverRunner.getWebDriver().navigate().refresh();

                    if (estoreItemPage.getAddToCartButton().isEnabled()) {
                        break;
                    }
                }
            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(2, SECONDS).await().until(() -> true);
        }
    }

    @When("I open product page with productID {string} for estore")
    public void iOpenProductPageWithProductIDForEstore(String productId) {
        String URL = null;
        with().pollInterval(5, SECONDS).await().until(() -> true);
        URL = Hooks.eStoreBaseURL + "/catalog/product/product.jsp?productId=" + productId + "&sale=false&src=rel";
        open(URL);
        try {
            estoreItemPage.getAddToCartButton().should(visible);
            estoreItemPage.getAddToCartButton().scrollTo();
            if (!estoreItemPage.getAddToCartButton().isEnabled()) {
                for (int i = 0; i < 3; i++) {
                    if (estoreItemPage.getAddToCartButton().isEnabled()) {
                        break;
                    }
                }
            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(2, SECONDS).await().until(() -> true);
        }
    }
}
