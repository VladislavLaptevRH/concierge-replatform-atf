package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.ElementNotFound;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.mn.Харин;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import tests.concierge.pageObject.*;
import tests.estore.stepdefinitions.EstoreCartPageStepDefs;
import tests.utility.Hooks;

import java.text.DecimalFormat;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ConciergeCartStepDefs {
    WebDriver webDriver = Hooks.getWebDriver();

    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    ConciergeE2EStepDefs conciergeE2EStepDefs = new ConciergeE2EStepDefs();
    AbstractStepDefs abstractStepDefs = new AbstractStepDefs();
    ConciergeAddressScreen conciergeAddressScreen = new ConciergeAddressScreen();

    EstoreCartPageStepDefs estoreCartPageStepDefs = new EstoreCartPageStepDefs();
    int randomQuantity;
    int priceFirstLineItem;
    int priceSecondLineItem;
    String lineItemPriceValueBeforeOverride;

    String lineItemPriceValueBefore;

    String lineItemPriceValueAfterOverride;
    String totalPriceCart;
    DecimalFormat digitFormatDoubleZero = new DecimalFormat("0.00");
    PaymentScreen paymentScreen = new PaymentScreen();
    SelectOption selectOption = new SelectOption();
    ProjectSettingsScreen projectSettingsScreen = new ProjectSettingsScreen();
    ConciergeProjectScreen conciergeProjectScreen = new ConciergeProjectScreen();
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen();
    PaymentStepDefs paymentStepDefs = new PaymentStepDefs();
    float line;
    String actual = "";

    String totalPrice = "";
    String totalAdditionalProductDiscount = "";
    String totalAdditionalProductDiscountMessage = "";

    public String RegularPrice;

    public String MemberPrice;

    @When("I navigate to the cart page")
    public void iNavigateToTheCartPage() {
        conciergeUserAccountPage.getCartButton().should(visible, Duration.ofSeconds(25));
        conciergeUserAccountPage.getCartButton().click();
    }

    @Then("I verify that products the following options {string},{string},{string} are in the shopping cart")
    public void iVerifyThatProductsTheFollowingOptionsAreInTheShoppingCart(String productId, String fullSkuId, String quanity) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(conciergeCartPageScreen.getGramTurkishTowel());

        if (fullSkuId.equals("62960714")) {
            assertEquals(conciergeCartPageScreen.getArlesRectangularDinigTableTitle().getText(), "ARLES RECTANGULAR DINING TABLE");
            assertEquals(conciergeCartPageScreen.getArlesRectangularDinigTableId().getText(), "62960714 LGRY");
        }
        if (fullSkuId.equals("17050042")) {
            actions.perform();
            assertEquals(conciergeCartPageScreen.getGramTurkishTowel().getText(), "17050042 NGRH");
            assertEquals(conciergeCartPageScreen.getGramTurkishTitle().getText(), "802-GRAM TURKISH TOWEL COLLECTION");
        }
        assertTrue(conciergeCartPageScreen.getQuantityButton().isDisplayed(), "Quantity button is displayed");
    }

    @Then("I verify that cart is displayed")
    public void iVerifyThatCartIsDisplayed() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if(!conciergeCartPageScreen.getOrderClassificationSelect().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        conciergeCartPageScreen.getOrderClassificationSelect().should(visible, Duration.ofSeconds(40));
        assertTrue(conciergeCartPageScreen.getOrderClassificationSelect().isDisplayed(), "Order classification is displayed");
        assertTrue(conciergeItemsScreen.getCheckoutButton().isDisplayed(), "Checkout button is displayed");
    }

    @When("I click on view cart button")
    public void iClickOnViewCartButton() {
        generalStepDefs.waitForJSandJQueryToLoad();
        if($(By.xpath("//*[text() = 'Agree & Add To Cart']")).isDisplayed()){
            $(By.xpath("//*[text() = 'Agree & Add To Cart']")).click();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        if (!conciergeCartPageScreen.getItemAddedToYourCart().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
            if (conciergeUserAccountPage.getCartButtonItemSum().exists()) {
                String URL = Hooks.conciergeBaseURL + "/us/en/checkout/shopping_cart.jsp";
                open(URL);
                with().pollInterval(5, SECONDS).await().until(() -> true);
            } else {
                conciergeE2EStepDefs.iOpenProductPageWithAnd("prod1617188", "63130001");
                conciergeE2EStepDefs.iClickOnAddToCartButton();
                conciergeCartPageScreen.getItemAddedToYourCart().should(visible, Duration.ofMinutes(1));
                conciergeCartPageScreen.getItemAddedToYourCart().shouldHave(text("Added To Your Cart"), Duration.ofSeconds(30));
                conciergeItemsScreen.getViewCartButton().shouldHave(text("View Cart"), Duration.ofSeconds(60));
                conciergeItemsScreen.getViewCartButton().should(visible, Duration.ofSeconds(60));
                conciergeCartPageScreen.getKeepShopping().should(visible, Duration.ofSeconds(15));
                conciergeItemsScreen.getViewCartButton().click();
            }
        } else {
            conciergeCartPageScreen.getItemAddedToYourCart().should(visible, Duration.ofMinutes(1));
            conciergeCartPageScreen.getItemAddedToYourCart().shouldHave(text("Added To Your Cart"), Duration.ofSeconds(30));
            conciergeItemsScreen.getViewCartButton().shouldHave(text("View Cart"), Duration.ofSeconds(60));
            conciergeItemsScreen.getViewCartButton().should(visible, Duration.ofSeconds(60));
            conciergeCartPageScreen.getKeepShopping().should(visible, Duration.ofSeconds(15));
            conciergeItemsScreen.getViewCartButton().click();
        }
    }

    @Then("I verify order classification")
    public void iVerifyOrderClassification() {
        conciergeCartPageScreen.getOrderClassificationSelect().should(Condition.and("", enabled, visible), Duration.ofMinutes(1));
        conciergeCartPageScreen.getOrderClassificationGalleryOrder().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getOrderClassificationInteriorDesign().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getOrderClassificationResidentialTrade().should(visible, Duration.ofMinutes(1));
    }

    @When("I click on clear order button from cart")
    public void iClickOnClearOrderButtonFromCart() {
        conciergeCartPageScreen.getClearOrderButton().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getClearOrderButton().scrollIntoView(true);
        conciergeCartPageScreen.getClearOrderButton().click();
        conciergeCartPageScreen.getClearOrderButtonPop().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getClearOrderButtonPop().click();
        conciergeUserAccountPage.getCartButton().shouldHave(text("CART 0"), Duration.ofSeconds(12));
    }

    @When("I click on quantity line item button")
    public void iClickOnQuantityLineItemButton() {
        selectOption.getQuantitySelectBtn().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        selectOption.getQuantitySelectBtn().should(visible, Duration.ofMinutes(1));
        selectOption.getQuantitySelectBtn().click();
        randomQuantity = generalStepDefs.getRandomNumber(2, 5);
        $(By.xpath("//option[@value='" + randomQuantity + "']")).should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        $(By.xpath("//option[@value='" + randomQuantity + "']")).shouldHave(text(Integer.toString(randomQuantity)), Duration.ofSeconds(10));
        $(By.xpath("//option[@value='" + randomQuantity + "']")).scrollIntoView(true);
        with().pollInterval(2, SECONDS).await().until(() -> true);
        $(By.xpath("//option[@value='" + randomQuantity + "']")).should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        $(By.xpath("//option[@value='" + randomQuantity + "']")).click();
        WebDriverRunner.getWebDriver().navigate().refresh();
        with().pollInterval(5, SECONDS).await().until(() -> true);
    }

    @Then("I verify that quantity was updated")
    public void iVerifyThatQuantityWasUpdated() {
        assertEquals(randomQuantity, Integer.parseInt(conciergeUserAccountPage.getCartButtonItemSum().getText()));
    }

    @When("I click on remove button from cart page")
    public void iClickOnRemoveButtonFromCartPage() {
        conciergeCartPageScreen.getRemoveButton().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getRemoveButton().shouldHave(text("Remove"), Duration.ofMinutes(1));
        conciergeCartPageScreen.getRemoveButton().scrollIntoView(true);
        conciergeCartPageScreen.getRemoveButton().click();
    }

    @Then("I verify that line item was removed")
    public void iVerifyThatLineItemWasRemoved() {
        with().pollInterval(6, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text()='Metal Box Frame Leaner Mirror']")).shouldNotBe(visible, Duration.ofMinutes(1));
    }

    @When("I click on total item line price")
    public void iClickOnTotalItemLinePrice() {
        int quantity = Integer.parseInt($(By.xpath("//*[contains(@id, 'quantity')]")).getText());
        if(quantity > 1){
            for(int i =0; i < 3; i++){
                Select countryQuantity = new Select(conciergeCartPageScreen.getQuantityButton());
                countryQuantity.selectByValue("1");
                WebDriverRunner.getWebDriver().navigate().refresh();
                with().pollInterval(5, SECONDS).await().until(() -> true);
            }
        }
        lineItemPriceValueBefore = conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll("\\$", "").replaceAll("C", "");
        conciergeCartPageScreen.getTotalMemberPrice().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getTotalMemberPrice().scrollIntoView(true);
        conciergeCartPageScreen.getTotalMemberPrice().click();
    }

    @When("I select price override {string}")
    public void iSelectPriceOverride(String arg0) {
        $(By.xpath("//option[@value='" + arg0 + "']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//option[@value='" + arg0 + "']")).click();

    }

    @When("I introduces value for override price")
    public void iIntroducesValueForOverridePrice() {
        conciergeCartPageScreen.getAdjustmentCodeField().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getAdjustmentCodeField().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        executeJavaScript("arguments[0].value='';", conciergeCartPageScreen.getAdjustmentCodeField());
        with().pollInterval(2, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getAdjustmentCodeField().setValue("50");
    }

    @When("I choose reason code for price override")
    public void iChooseReasonCodeForPriceOverride() {
        Select select = new Select(conciergeCartPageScreen.getReasonCodeField());
        select.selectByValue("G");
    }

    @When("I click on apply uppercase button for {string}")
    public void iClickOnApplyUppercaseButton(String method) {
        if (method.equals("override line item")) {
            conciergeCartPageScreen.getApplyUpperCaseBtn().shouldHave(text("APPLY"), Duration.ofMinutes(1));
            conciergeCartPageScreen.getApplyUpperCaseBtn().click();
        }
        if (method.equals("postpone shipment")) {
            generalStepDefs.waitForJSandJQueryToLoad();
            conciergeCartPageScreen.getApplyPostponeShipBtn().shouldHave(text("APPLY"), Duration.ofMinutes(1));
            conciergeCartPageScreen.getApplyPostponeShipBtn().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
            with().pollInterval(5, SECONDS).await().until(() -> true);
            conciergeCartPageScreen.getApplyPostponeShipBtn().click();
        }
    }

    @Then("I verify line items prices for {string}")
    public void iVerifyLineItemsPricesFor(String arg0) {
        generalStepDefs.waitForJSandJQueryToLoad();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getTotalMemberPrice().should(visible, Duration.ofMinutes(1));
        with().pollInterval(2, SECONDS).await().until(() -> true);
        executeJavaScript("window.scrollTo(0, -500)");
        if(conciergeCartPageScreen.getReasonCodeField().isDisplayed()){
            conciergeCartPageScreen.getClosePopUp().click();
            with().pollInterval(3, SECONDS).await().until(() -> true);
        }
        conciergeCartPageScreen.getReasonCodeField().shouldNot(visible, Duration.ofSeconds(15));
        with().pollInterval(2, SECONDS).await().until(() -> true);
        if (arg0.equals("PERCENT_OFF")) {
            if($(By.xpath("//*[text() = 'Sale']")).isDisplayed()){
                lineItemPriceValueBeforeOverride = conciergeCartPageScreen.getFinalSalePrice().getText().replaceAll(",", "").replaceAll("\\$", "").replaceAll("C", "");
            } else {
                lineItemPriceValueBeforeOverride = conciergeCartPageScreen.getTotalRegularPrice().getText().replaceAll(",", "").replaceAll("\\$", "").replaceAll("C", "");
            }
            lineItemPriceValueAfterOverride = conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll("\\$", "").replaceAll("C", "");
            line = Float.parseFloat(lineItemPriceValueBeforeOverride) / 2;
            actual = conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll("\\$", "").replaceAll("C", "");
            assertEquals(line, Float.parseFloat(actual));
            assertEquals(Float.parseFloat(lineItemPriceValueAfterOverride), line);
        }
        if (arg0.equals("AMOUNT_OFF")) {
            float expectedValuePriceValue = Float.parseFloat(lineItemPriceValueBefore) - 50;
            assertEquals(expectedValuePriceValue, Float.parseFloat(conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll("\\$", "").replaceAll("C", "")));
        }
        if (arg0.equals("AMOUNT_OVERRIDE")) {
            String lineItemPriceValueAfterOverride = conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll("\\$", "").replaceAll("C", "");
            executeJavaScript("window.scrollTo(0, -500)");
            assertEquals(lineItemPriceValueAfterOverride, "50.00");
        }
    }

    @When("I click on apply all checkbox")
    public void iClickOnApplyAllCheckbox() {
        conciergeCartPageScreen.getApplyToAllCheckbox().scrollIntoView(true);
        conciergeCartPageScreen.getApplyToAllCheckbox().click();
    }

    @When("I save price for every line item")
    public void iSavePriceForEveryLineItem() {
        priceFirstLineItem = Integer.parseInt($(By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-alignRight'])[1]")).getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", ""));
        priceSecondLineItem = Integer.parseInt($(By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-alignRight'])[2]")).getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", ""));
    }

    @Then("I verify that price override was executed for all line items")
    public void iVerifyThatPriceOverrideWasExecutedForAllLineItems() {
        int priceFirstLineItemAfterOverride = Integer.parseInt($(By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-alignRight'])[1]")).getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", ""));
        int priceSecondLineItemAfterOverride = Integer.parseInt($(By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-alignRight'])[2]")).getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", ""));
        assertEquals(priceFirstLineItem, priceFirstLineItemAfterOverride / 2);
        assertEquals(priceSecondLineItem, priceSecondLineItemAfterOverride / 2);
    }

    @When("I click on remove button from project")
    public void iClickOnRemoveButtonFromProject() {
        generalStepDefs.waitForJSandJQueryToLoad();
        String items = conciergeProjectScreen.getItems().getText().replaceAll("ITEMS: ", "");
        int IntItems = Integer.parseInt(items);
        for(int i = IntItems; i > 0; i--){
            conciergeProjectScreen.getUpButton().doubleClick();
            conciergeProjectScreen.getREMOVEbuttonList().get(0).hover();
            conciergeProjectScreen.getREMOVEbuttonList().get(0).click();
            with().pollInterval(3, SECONDS).await().until(() -> true);
        }
        conciergeProjectScreen.getREMOVEbuttonList().get(0).shouldNot(visible);
    }

    @When("I click on remove button from price override")
    public void iClickOnRemoveButtonFromPriceOverride() {
        conciergeProjectScreen.getPriceOverrodeRemoveButton().doubleClick();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        conciergeProjectScreen.getPriceOverrodeRemoveButton().shouldNot(visible);

    }
    @Then("I verify that price override was removed")
    public void iVerifyThatPriceOverrideWasRemoved() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        actual = conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", "").replaceAll("C", "");
        assertEquals(Float.parseFloat(lineItemPriceValueBeforeOverride), Float.parseFloat(actual), "Price override was removed");
    }

    @When("I click on UFD button from cart")
    public void iClickOnUFDButtonFromCart() {
        conciergeCartPageScreen.getUfdCartButton().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getUfdCartButton().scrollIntoView(true);
        conciergeCartPageScreen.getUfdCartButton().click();
    }

    @When("I click on apply promocode button")
    public void iClickOnApplyPromocodeButton() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeCartPageScreen.getApplyPromocodeBtn().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getApplyPromocodeBtn().click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        totalPrice = $(By.xpath("//h5[@aria-describedby = 'shipping-override-price-dialog']")).getText().replaceAll(",", "").replaceAll("\\$", "");
        totalAdditionalProductDiscountMessage = $(By.xpath("(//*[contains(@class,'MuiGrid-root MuiGrid-container')]/span)[7]")).getText();
        totalAdditionalProductDiscount = $(By.xpath("(//*[contains(@class,'MuiGrid-root MuiGrid-container')]/span)[8]")).getText().replaceAll(",", "").replaceAll("\\$", "");
    }

    @When("I introduces promo code {string} for promo codes field")
    public void iIntroducesPromoCodeForPromoCodesField(String promo) {
        if(!conciergeCartPageScreen.getPromotionCodeField().isDisplayed()){
            iRemoveAllItemsFromCartViaUI();
            conciergeE2EStepDefs.iRemoveClientFromHeader();
            iAddItemToCartViaAPI();
            conciergeE2EStepDefs.iOpenCart();
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        with().pollInterval(5, SECONDS).await().until(() -> true);
        Select countryQuantity = new Select(conciergeCartPageScreen.getQuantityButton());
        countryQuantity.selectByValue("1");
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getPromotionCodeField().should(empty, Duration.ofMinutes(1));
        conciergeCartPageScreen.getPromotionCodeField().scrollIntoView(true);
        conciergeCartPageScreen.getPromotionCodeField().click();
        conciergeCartPageScreen.getPromotionCodeField().setValue(promo);
        totalPriceCart = conciergeCartPageScreen.getTotalMemberPrice().getText();
    }

    @Then("I verify that {string} promocode was approved for cart items")
    public void iVerifyThatPromocodeWasApprovedForCartItems(String promoType) {
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeCartPageScreen.getTotalAditionalProdDiscount().should(visible, Duration.ofSeconds(15));
    }

    @Then("I verify that total price from cart and from payment page is the same")
    public void iVerifyThatTotalPriceFromCartAndFromPaymentPageIsTheSame() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if(!conciergeCartPageScreen.getTotalAditionalProdDiscount().isDisplayed()){
            iRemoveAllItemsFromCartViaUI();
            conciergeE2EStepDefs.iRemoveClientFromHeader();
            iAddItemToCartViaAPI();
            conciergeE2EStepDefs.iOpenCart();
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
            iIntroducesPromoCodeForPromoCodesField("FEMAD");
            iClickOnApplyPromocodeButton();
            iChooseOrderClassification();
            abstractStepDefs.iClickOnCheckoutButton();
            conciergeE2EStepDefs.iClickOnNoThanksButton();
            conciergeE2EStepDefs.iChooseClientWhoIsAMember("Non-Member");
            abstractStepDefs.iFillAllFieldsFromAddressScreenForBrands();
            conciergeE2EStepDefs.continueToPaymentAfterAddressCheckout();
            paymentStepDefs.iClickOnContinueWithOriginalAddressButton();
        }
        float totalPriceAfterStateTax = Float.parseFloat($(By.xpath("//h5[contains(@class, 'MuiTypography-h5')]")).getText().replaceAll(",", "").replaceAll("\\$", ""));
        float stateTax = Float.parseFloat($(By.xpath("//p[contains(@class, 'MuiTypography-body1 MuiTypography-alignRight')]")).getText().replaceAll(",", "").replaceAll("\\$", ""));
        float totalPriceBeforeStateTax = Float.parseFloat(totalPrice);
        float totalAdditionalProductDiscountOnPaymentPage = Float.parseFloat($(By.xpath("(//div[contains(@class, 'MuiGrid-root MuiGrid-container MuiGrid-item')]/span)[5]")).getText().replaceAll(",", "").replaceAll("\\$", ""));
        conciergeCartPageScreen.getTotalAditionalProdDiscount().should(visible, Duration.ofSeconds(15));
       assertEquals(totalPriceAfterStateTax, totalPriceBeforeStateTax + stateTax);
       assertEquals(Float.parseFloat(totalAdditionalProductDiscount), totalAdditionalProductDiscountOnPaymentPage);
    }

    @When("I choose POS for payment method")
    public void iChoosePOPForPaymentMethod() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if(conciergeProjectScreen.getTryAgainButton().isDisplayed()) {
            for (int i = 0; i < 3; i++) {
                if (!paymentScreen.getChoosePaymentMethodBtnDisplayed().isDisplayed()) {
                    WebDriverRunner.getWebDriver().navigate().refresh();
                    with().pollInterval(3, SECONDS).await().until(() -> true);

                    if (checkoutAddressScreen.getBillingAddressCheckbox().exists()) {
                        if (!$(By.xpath("//*[contains(@class, 'Mui-checked')]//*[@id = 'billing-shipping-address-same-checkbox']")).isDisplayed()) {
                            $(By.xpath("//*[@id = 'billing-shipping-address-same-checkbox']")).click();
                            with().pollInterval(2, SECONDS).await().until(() -> true);
                        }
                    }

                    if (!checkoutAddressScreen.getContinuePaymentButton().isDisplayed()) {
                        WebDriverRunner.getWebDriver().navigate().refresh();
                        with().pollInterval(5, SECONDS).await().until(() -> true);
                        abstractStepDefs.iClickOnCheckoutButton();
                        checkoutAddressScreen.getContinuePaymentButton().shouldHave(text(checkoutAddressScreen.getContinuePaymentButton().getText()), Duration.ofMinutes(1));
                        executeJavaScript("arguments[0].scrollIntoView(true);", checkoutAddressScreen.getContinuePaymentButton());
                        checkoutAddressScreen.getContinuePaymentButton().shouldHave(text(checkoutAddressScreen.getContinuePaymentButton().getText()), Duration.ofMinutes(1));
                        checkoutAddressScreen.getContinuePaymentButton().click();
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
                    paymentStepDefs.iClickOnContinueWithOriginalAddressButton();
                    if (paymentScreen.getChoosePaymentMethodBtnDisplayed().isDisplayed()) {
                        break;
                    }
                }
            }
        }
        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(1));
        paymentScreen.getChoosePaymentMethodBtn().click();
        paymentScreen.getChoosePaymentMethodBtn().should(Condition.be(visible), Duration.ofSeconds(35));
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment.selectByValue("POS");
        conciergeCartPageScreen.getPosRegisterField().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getPosRegisterField().setValue("1234");
        conciergeCartPageScreen.getPosTransactionField().setValue("1234");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
    }

    @Then("I verify that Total Additional Product Discount message is {string} on review page")
    public void iVerifyThatTotalAdditionalProductDiscountMessageIsOnReviewPage(String arg0) {
        if(!conciergeCartPageScreen.getTotalAditionalProdDiscount().isDisplayed()){
            iRemoveAllItemsFromCartViaUI();
            conciergeE2EStepDefs.iRemoveClientFromHeader();
            iAddItemToCartViaAPI();
            conciergeE2EStepDefs.iOpenCart();
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
            iIntroducesPromoCodeForPromoCodesField("FEMAD");
            iClickOnApplyPromocodeButton();
            iChooseOrderClassification();
            abstractStepDefs.iClickOnCheckoutButton();
            conciergeE2EStepDefs.iClickOnNoThanksButton();
            conciergeE2EStepDefs.iChooseClientWhoIsAMember("Non-Member");
            abstractStepDefs.iFillAllFieldsFromAddressScreenForBrands();
            conciergeE2EStepDefs.continueToPaymentAfterAddressCheckout();
            paymentStepDefs.iClickOnContinueWithOriginalAddressButton();
            iChoosePOPForPaymentMethod();
        }
        if (arg0.equals("displayed")) {
            conciergeCartPageScreen.getTotalAditionalProdDiscount().should(visible, Duration.ofMinutes(1));
            conciergeCartPageScreen.getTotalAditionalProdDiscount().scrollTo();
            assertEquals(totalAdditionalProductDiscountMessage, "Total Additional Product Discount");
        } else {
            conciergeCartPageScreen.getTotalAditionalProdDiscount().shouldNotBe(visible, Duration.ofMinutes(1));
        }
    }

    @Then("I verify that promo code was removed")
    public void iVerifyThatPromoCodeWasRemoved() {
        $(By.xpath("//*[text()='Members have the privilege of receiving 25% off full priced items or 20% off sale items, whichever is the best price. Tax, shipping and surcharges are not included in calculating discount. Not valid for gift cards, personalization and gift boxes.']")).shouldNotBe(visible, Duration.ofMinutes(1));
    }

    @When("I select size option {string} for item")
    public void iSelectSizeOptionForItem(String sizeValue) {
        generalStepDefs.waitForJSandJQueryToLoad();
        if (!conciergeItemsScreen.getAddToCartButton().isDisplayed()) {
            for (int i = 0; i < 3; i++) {
                WebDriverRunner.getWebDriver().navigate().refresh();
                with().pollInterval(4, SECONDS).await().until(() -> true);
                if (conciergeItemsScreen.getAddToCartButton().isDisplayed()) {
                    break;
                }
            }
        }
        try {
            with().pollInterval(2, SECONDS).await().until(() -> true);
            conciergeItemsScreen.getAddToCartButton().scrollTo();
            with().pollInterval(2, SECONDS).await().until(() -> true);
            selectOption.getSelectSizeElement().should(Condition.and("", visible, enabled), Duration.ofSeconds(30));
            selectOption.getSelectSizeElement().scrollIntoView(true);
            Select size = new Select(selectOption.getSelectSizeElement());
            size.selectByVisibleText(sizeValue);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Element is not displayed");
        }
    }

    @When("I click on add new space button")
    public void iClickOnAddNewSpaceButton() {
        projectSettingsScreen.getAddNewSpaceButton().should(visible, Duration.ofSeconds(40));
        projectSettingsScreen.getAddNewSpaceButton().click();
    }

    @When("I choose {string} project from move to project pop up")
    public void iChooseProjectFromMoveToProjectPopUp(String arg0) {
        with().pollInterval(4, SECONDS).await().until(() -> true);
        conciergeProjectScreen.getProjectName().should(visible, Duration.ofSeconds(15));
        Select selectProjectName = new Select(conciergeProjectScreen.getProjectName());
        selectProjectName.selectByVisibleText("additemtocorrectspace");
    }

    @When("I choose {string} space from move to project pop up")
    public void iChooseSpaceFromMoveToProjectPopUp(String arg0) {
        with().pollInterval(4, SECONDS).await().until(() -> true);
        conciergeProjectScreen.getProjectName().should(visible, Duration.ofSeconds(15));
        Select selectProjectName = new Select(conciergeProjectScreen.getSelectSpaceName());
        selectProjectName.selectByValue(arg0);
    }

    @Then("I verify that spaces are displayed in space dropdown")
    public void iVerifyThatSpacesAreDisplayedInSpaceDropdown() {
        conciergeCartPageScreen.getSpaceDropDown().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getSpaceDropDown().click();
        $(By.xpath("//*[text()='correctspace']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='wrongspace']")).should(visible, Duration.ofMinutes(1));
    }

    @When("I click on update button from price override pop up")
    public void iClickOnUpdateButtonFromPriceOverridePopUp() {
        conciergeCartPageScreen.getUpdateButton().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getUpdateButton().click();
    }

    @Then("I verify that mini cart value is equal to {int}")
    public void iVerifyThatMiniCartValueIsEqualTo(int arg0) {
        WebDriverRunner.getWebDriver().navigate().refresh();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeUserAccountPage.getCartButton().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        int arg1 = Integer.parseInt(conciergeUserAccountPage.getCartItemSum().getText());
        if (arg1 > 1) {
            iRemoveAllItemsFromCartViaUI();
            conciergeE2EStepDefs.iOpenProductPageWithAnd("prod1617188", "63130001");
            conciergeE2EStepDefs.iClickOnAddToCartButton();
            iClickOnViewCartButton();
        }
        assertEquals(Integer.parseInt(conciergeUserAccountPage.getCartItemSum().getText()), arg0);
    }

    @Then("I verify membership banner for {string} client")
    public void iVerifyMemberBannerForClient(String arg0) {
        conciergeCartPageScreen.getMembersProgramTitle().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getJoinRhMemberProgramTitle().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getJoinNow().should(visible, Duration.ofMinutes(1));
    }

    @Then("I verify membership banner for {string} client not displayed")
    public void iVerifyMemberBannerForClientNotDisplayed(String arg0) {
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeCartPageScreen.getMembersProgramTitle().shouldNotBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getJoinRhMemberProgramTitle().shouldNotBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getJoinNow().shouldNotBe(visible, Duration.ofMinutes(1));
    }

    @Then("I verify that membership popup for {string} is not displayed")
    public void iVerifyThatMembershipPopupForIsDisplayed(String arg0) {
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeCartPageScreen.getNoThanksButton().shouldNotBe(visible, Duration.ofSeconds(10));
        conciergeCartPageScreen.getBecomeAmemberNow().shouldNotBe(visible, Duration.ofSeconds(10));
        conciergeCartPageScreen.getMembersProgramTitle().shouldNotBe(visible, Duration.ofSeconds(10));
        conciergeCartPageScreen.getJoinRhMemberProgramTitle().shouldNotBe(visible, Duration.ofSeconds(10));
        conciergeCartPageScreen.getRhMembershipImmediatlyPay().shouldNotBe(visible, Duration.ofSeconds(10));
    }

    @Then("I verify that ship to, bill to, sold to addresses are displayed")
    public void iVerifyThatShipToBillToSoldToAddressesAreDisplayed() {
        try {
            conciergeCartPageScreen.getSoldToAddressTitle().should(visible, Duration.ofMinutes(1));
        } catch (ElementNotFound e){
            System.out.println("Sold Address is not displayed");
        }
        try {
            conciergeCartPageScreen.getBillingAddressTitle().should(visible, Duration.ofMinutes(1));
        } catch (ElementNotFound e){
            System.out.println("Billing Address is not displayed");
        }
       try{
           conciergeCartPageScreen.getShippingAddressTitle().should(visible, Duration.ofMinutes(1));
       } catch (ElementNotFound e){
           System.out.println("Sipping Address is not displayed");
       }

    }

    @And("I edit ship to, bill to, sold to addresses")
    public void iEditShipToBillToSoldToAddresses() {
            if(conciergeAddressScreen.getEditSAddressButtonUserService().isDisplayed()){
                conciergeAddressScreen.getEditSAddressButtonUserService().scrollIntoView(true);
                conciergeAddressScreen.getEditSAddressButtonUserService().click();
            }
        if(conciergeAddressScreen.getEditSAddressButtonUserService1().isDisplayed()){
            conciergeAddressScreen.getEditSAddressButtonUserService1().scrollIntoView(true);
            conciergeAddressScreen.getEditSAddressButtonUserService1().click();
        }
                checkoutAddressScreen.getCompanyNameFieldNewUserService().should(visible, Duration.ofMinutes(1));
                generalStepDefs.clearField(checkoutAddressScreen.getCompanyNameFieldNewUserService());
            checkoutAddressScreen.getCompanyNameFieldNewUserService().should(visible, Duration.ofMinutes(1));
            generalStepDefs.clearField(checkoutAddressScreen.getCompanyNameFieldNewUserService());
            checkoutAddressScreen.getCompanyNameFieldNewUserService().setValue("changedCompanyNameSoldAddress");
        if($(By.xpath("(//*[text()='Edit'])[10]")).isDisplayed()){
            $(By.xpath("(//*[text()='Edit'])[10]")).scrollIntoView(true);
            $(By.xpath("(//*[text()='Edit'])[10]")).click();
        }
            $(By.xpath("//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input")).should(visible, Duration.ofMinutes(1));
            generalStepDefs.clearField($(By.xpath("//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input")));
            $(By.xpath("//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input")).setValue("changedCompanyNameBillingAddress");

        if($(By.xpath("(//*[text()='Edit'])[1]")).isDisplayed()){
            $(By.xpath("(//*[text()='Edit'])[1]")).click();
        }
            $(By.xpath("//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input")).should(visible, Duration.ofMinutes(1));
            generalStepDefs.clearField($(By.xpath("//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input")));
            $(By.xpath("//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input")).setValue("changedCompanyNameShippingAddress");
    }

    @Then("I verify that membership price displayed as total price")
    public void iVerifyThatMembershipPriceDisplayedAsTotalPrice() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (!conciergeCartPageScreen.getPriceForMember().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        String memberPrice = conciergeCartPageScreen.getPriceForMember().getText();
        String totalPrice = conciergeCartPageScreen.getTotalMemberPrice().getText();
        assertEquals(memberPrice, totalPrice, "Membership price displayed as total price");
    }

    @When("I choose postpone shipment")
    public void iChoosePostponeShipment() {
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeCartPageScreen.getPostponeShipment().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeCartPageScreen.getPostponeShipment().scrollIntoView(true);
        conciergeCartPageScreen.getPostponeShipment().shouldHave(text("Postpone Shipment"), Duration.ofSeconds(15));
        conciergeCartPageScreen.getPostponeShipment().click();
        conciergeCartPageScreen.getPostponeSelectReasonCode().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeCartPageScreen.getPostponeSelectReasonCode().should(visible, Duration.ofSeconds(15));
        Select postponeReasonCode = new Select(conciergeCartPageScreen.getPostponeSelectReasonCode());
        conciergeCartPageScreen.getPostponeSelectReasonCode().scrollIntoView(true);
        postponeReasonCode.selectByValue("Construction/Remodel");
    }

    @Then("I verify that postpone shipment was applied")
    public void iVerifyThatPostponeShipmentWasApplied() {
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeCartPageScreen.getPostponeShipOnOrAfterDate().should(visible, Duration.ofSeconds(10));
    }

    @Then("I verify that gift box was added")
    public void iVerifyThatGiftBoxWasAdded() {
        conciergeCartPageScreen.getGiftBoxFee().should(visible, Duration.ofMinutes(1));
    }

    @When("I click on gift box button")
    public void iClickOnRemoveGiftBoxButton() {
        generalStepDefs.waitForJSandJQueryToLoad();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        executeJavaScript("arguments[0].click();", conciergeItemsScreen.getAddGiftCheckBox());
    }

    @Then("I verify that gift box was removed")
    public void iVerifyThatGiftBoxWasRemoved() {
        conciergeCartPageScreen.getGiftBoxFee().shouldNotBe(visible, Duration.ofMinutes(1));
    }

    @Then("I verify that member savings for a {string} user")
    public void iVerifyThatMemberSavingsForAUser(String arg0) {
        conciergeCartPageScreen.getTotalMemberPrice().shouldHave(text("$2,156.00"), Duration.ofMinutes(1));
    }

    @When("I click on cart button from header")
    public void iClickOnCartButtonFromHeader() {
        conciergeUserAccountPage.getCartButton().should(visible, Duration.ofMinutes(1));
        conciergeUserAccountPage.getCartButton().click();
    }

    @Then("I verify {string} savings for a {string} user")
    public void iVerifyThatSavingsForAUser(String arg0, String arg1) {
        if (arg1.equals("nonmember") || (arg1.equals("contract"))) {
            conciergeCartPageScreen.getTotalMemberPrice().should(Condition.and("", enabled, visible), Duration.ofMinutes(1));
            String finalSalePrice = conciergeCartPageScreen.getFinalSalePrice().getText();
            String totalMemberPrice = conciergeCartPageScreen.getTotalMemberPrice().getText();
            assertEquals(finalSalePrice, totalMemberPrice, "Savings for nonmember user in cart");
        }
        if (arg1.equals("trade")) {
            conciergeCartPageScreen.getTradeSavingsText().should(Condition.and("", enabled, visible), Duration.ofMinutes(1));
            String tradelSalePrice = conciergeCartPageScreen.getTradeSalePrice().getText();
            String totalMemberPrice = conciergeCartPageScreen.getTotalMemberPrice().getText();
            assertEquals(tradelSalePrice, totalMemberPrice, "Savings for nonmember user in cart");
        }
        if (arg1.equals("member")) {
            conciergeCartPageScreen.getMemberSavingsText().should(Condition.and("", enabled, visible), Duration.ofMinutes(1));
            String memberSalePrice = conciergeCartPageScreen.getPriceForMember().getText();
            String totalMemberPrice = conciergeCartPageScreen.getTotalMemberPrice().getText();
            assertEquals(memberSalePrice, totalMemberPrice, "Savings for nonmember user in cart");
        }

    }

    @When("I goes to address page from review screen")
    public void iGoesToAddressPageFromReviewScreen() {
        conciergeCartPageScreen.getAddressButton().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getAddressButton().shouldHave(text("Address"), Duration.ofMinutes(1));
        conciergeCartPageScreen.getAddressButton().click();
    }

    @Then("I verify that address saved in address page")
    public void iVerifyThatAddressSavedInAddressPage() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        if($(By.xpath("(//*[text()='Edit'])[1]")).isDisplayed()) {
            $(By.xpath("(//*[text()='Edit'])[1]")).scrollIntoView(true);
            $(By.xpath("(//*[text()='Edit'])[1]")).click();
        }
        checkoutAddressScreen.getFirstNameInpt().should(visible, Duration.ofMinutes(1));
        checkoutAddressScreen.getFirstNameInpt().shouldHave(value("QAFirst"), Duration.ofMinutes(1));
        checkoutAddressScreen.getLastNameField().shouldHave(value("Automation"), Duration.ofMinutes(1));
    }

    @Then("I verify that monogram was added")
    public void iVerifyThatMonoramWasAdded() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getPersonalizationText().should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Bauer Bodoni 1 (BDNI-HC)']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Light Gold Metallic (MLGD)']")).should(visible, Duration.ofMinutes(1));
    }


    @When("I click on add monogram checkbox")
    public void iClickOnAddMonogramCheckbox() {
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeItemsScreen.getAddMonogramCheckBox().scrollIntoView(true);
        conciergeItemsScreen.getAddMonogramCheckBox().click();
    }

    @When("I choose monogram properties")
    public void iChooseMonogramProperties() {
        generalStepDefs.waitForJSandJQueryToLoad();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getMonogramFonts().get(2).scrollIntoView(true);
        conciergeCartPageScreen.getMonogramFonts().get(2).should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeCartPageScreen.getMonogramFonts().get(2).doubleClick();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getMonogramColors().get(2).should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getMonogramColors().get(2).scrollIntoView(true);
        conciergeCartPageScreen.getMonogramColors().get(2).doubleClick();
        conciergeCartPageScreen.getMonogramText().setValue("test");
        conciergeCartPageScreen.getAddMonogramButton().click();
    }

    @When("I edit monogram")
    public void iEditMonogram() {
        generalStepDefs.waitForJSandJQueryToLoad();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getEditMonogramButton().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getMonogramColors().get(5).should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getMonogramColors().get(5).doubleClick();
        conciergeCartPageScreen.getAddMonogramButton().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getAddMonogramButton().click();
    }

    @Then("I verify that monogram was edited")
    public void iVerifyThatMonogramWasEdited() {
//        WebDriverRunner.getWebDriver().navigate().refresh();
//        with().pollInterval(5, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text()='Dark Silver Metallic (MDSL)']")).shouldHave(text("Dark Silver Metallic (MDSL)"), Duration.ofSeconds(30));
    }

    @When("I remove monogram")
    public void iRemoveMonogram() {
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeCartPageScreen.getRemoveMonogramBtn().shouldHave(text("Remove"), Duration.ofMinutes(1));
        conciergeCartPageScreen.getRemoveMonogramBtn().click();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        WebDriverRunner.getWebDriver().navigate().refresh();
        with().pollInterval(5, SECONDS).await().until(() -> true);
    }

    @Then("I verify that monogram was removed")
    public void iVerifyThatMonogramWasRemoved() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getPersonalizationText().shouldNotBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Bauer Bodoni 2 (BDNI-HD)']")).shouldNotBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Dark Silver Metallic (MDSL)']")).shouldNotBe(visible, Duration.ofMinutes(1));
    }

    @Then("I verify that availability, Delivery and Returns messaging in cart")
    public void iVerifyThatAvailabilityDeliveryAndReturnsMessagingInCart() {
        $(By.xpath("//*[contains(text(),'This item will be ready for delivery between')]")).should(visible, Duration.ofSeconds(10));
        $(By.xpath("//*[contains(text(),'This item can be returned or exchanged within 30 days of delivery')]")).should(visible, Duration.ofMinutes(1));
    }

    @Then("I verify alternate addresses for client with multipel addresses")
    public void iVerifyAlternateAddressesForClientWithMultipelAddresses() {
        int addressesSize = conciergeUserAccountPage.getClientSearchResultAddresses().size();
        assertTrue(addressesSize > 1);
    }

    @Then("I verify membership popup for guest user")
    public void iVerifyMembershipPopupForGuestUser() {
        if (!conciergeCartPageScreen.getNoThanksButton().isDisplayed()) {
            for (int i = 0; i < 3; i++) {
                String URL = Hooks.conciergeBaseURL + "/checkout/shopping_cart.jsp";
                open(URL);
                with().pollInterval(5, SECONDS).await().until(() -> true);
                abstractStepDefs.iClickOnCheckoutButton();
                if ($(By.xpath("//*[text()='Your RH Membership immediately pays for itself.']")).isDisplayed()) {
                    break;
                }
            }

        }
        $(By.xpath("//*[text()='Your RH Membership immediately pays for itself.']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='BECOME A MEMBER NOW']")).should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getNoThanksButton().should(visible, Duration.ofMinutes(1));
    }

    @Then("I verify that employee discount is present")
    public void iVerifyThatEmployeeDiscountIsPresent() {
        conciergeCartPageScreen.getTotalAditionalProdDiscount().shouldHave(text("Total Additional Product Discount"), Duration.ofSeconds(15));
        conciergeCartPageScreen.getTotalAditionalProdDiscount().should(Condition.and("", visible, enabled), Duration.ofSeconds(15));
    }

    @Then("I verify membership banner")
    public void iVerifyMembershipBanner() {
        $(By.xpath("//*[text() = 'REMOVE MEMBERSHIP']")).shouldBe(visible, Duration.ofSeconds(15));
        MemberPrice = $(By.xpath("//*[@aria-describedby = 'price-override-popper']/h5")).getText().replace("$", "");
        float regularPrice = Float.parseFloat(RegularPrice);
        float memberPrice = Float.parseFloat(MemberPrice);
        String savings = Float.toString(regularPrice - memberPrice).replaceAll(".0", "");
        $(By.xpath("//h2[text() = ' RH MEMBERS PROGRAM']")).shouldBe(visible, Duration.ofSeconds(15));
        assertEquals("You've elected to join the RH Members Program, and you'll save $" + savings + ".00 on this order.", $(By.xpath("//h2[text() = ' RH MEMBERS PROGRAM']/following-sibling::p")).getText());
    }

    @When("I apply employee discount")
    public void iApplyEmployeeDiscount() {
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeCartPageScreen.getUserNamePromocode().scrollIntoView(true);
        conciergeCartPageScreen.getUserNamePromocode().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        with().pollInterval(2, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getUserNamePromocode().setValue("ediscount");
        conciergeCartPageScreen.getPasswordPromocde().should(Condition.and("", visible, enabled), Duration.ofSeconds(12));
        conciergeCartPageScreen.getPasswordPromocde().setValue("p6K6K6Mx");
        conciergeCartPageScreen.getApplyEmpDiscountBtn().click();
        conciergeCartPageScreen.getAcceptButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(12));
        conciergeCartPageScreen.getAcceptButton().should(visible, Duration.ofSeconds(12));
        conciergeCartPageScreen.getAcceptButton().click();
    }

    @Then("I verify that mini cart value is equal to quantity of product")
    public void iVerifyThatMiniCartValueIsEqualToQuantityOfProduct() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeUserAccountPage.getCartButton().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        assertEquals(randomQuantity, Integer.parseInt(conciergeUserAccountPage.getCartItemSum().getText()));
    }

    @When("I click on check balance button")
    public void iClickOnCheckBalanceButton() {
        conciergeCartPageScreen.getCheckBalanceButton().should(visible, Duration.ofSeconds(30));
        conciergeCartPageScreen.getCheckBalanceButton().scrollIntoView(true);
        conciergeCartPageScreen.getCheckBalanceButton().click();
    }

    @Then("I verify that gift card balance info is displayed")
    public void iVerifyThatBalanceInfoIsDisplayed() {
        conciergeCartPageScreen.getRhGiftCardBalance().shouldHave(text("RH Gift Card ending 1635 has balance of "), Duration.ofSeconds(25));
    }

    @When("I click on first item from grid")
    public void iClickOnMonogramItem() {
        $(By.xpath("//*[text()='Availability']")).shouldHave(text("Availability"), Duration.ofSeconds(20));
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeItemsScreen.getFirstItem().should(Condition.and("", visible, enabled), Duration.ofSeconds(20));
        conciergeItemsScreen.getFirstItem().click();
    }

    @And("I remove promotion from cart")
    public void iRemovePromotionFromCart() {
        conciergeCartPageScreen.getRemovePromotionBtn().should(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getRemovePromotionBtn().click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
    }

    @And("I verify that promotion is not displayed")
    public void iVerifyThatPromotionIsNotDisplayed() {
        if (conciergeCartPageScreen.getTotalAditionalProdDiscount().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        conciergeCartPageScreen.getTotalAditionalProdDiscount().shouldNot(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getTotalAdditionalProdDiscountSum().shouldNot(visible, Duration.ofSeconds(15));
    }


    @Then("I verify that designed sold by")
    public void iVerifyThatDesignedSoldBy() {
        $(By.xpath("//*[text()='Designed/Sold By:']")).shouldBe(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='Automation Associate']")).shouldBe(visible, Duration.ofSeconds(15));
    }

    @Then("I save member price")
    public void iSaveMemberPrice() {
        $(By.xpath("//*[@aria-describedby = 'price-override-popper']/h5")).shouldBe(visible, Duration.ofSeconds(15));
       RegularPrice = $(By.xpath("//*[@aria-describedby = 'price-override-popper']/h5")).getText().replace("$", "");
    }

    @When("I choose order classification")
    public void iChooseOrderClassification() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (!conciergeCartPageScreen.getOrderClassificationSelect().exists()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        Select orderClassificationDropDownList = new Select(conciergeCartPageScreen.getOrderClassificationSelect());
        orderClassificationDropDownList.selectByValue("RH Gallery Order");
        with().pollInterval(5, SECONDS).await().until(() -> true);
    }

    @Then("I verify contract savings")
    public void iVerifyContractSavingsForCartPage() {
        conciergeCartPageScreen.getContractSavings().should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='$897.00']")).should(visible, Duration.ofSeconds(20));
    }

    @When("I click on order details button")
    public void iClickOnOrderDetailsButton() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (conciergeUserAccountPage.getOrderDetailsButtonByName("View Order Details").isDisplayed()) {
            conciergeUserAccountPage.getOrderDetailsButtonByName("View Order Details").click();
        } else if (conciergeUserAccountPage.getOrderDetailsButtonByName("Order details").isDisplayed()) {
            conciergeUserAccountPage.getOrderDetailsButtonByName("Order details").click();
        } else {
            with().pollInterval(1, SECONDS).await().until(() -> true);
        }
    }

    @When("I remove all items from cart for minicart")
    public void iRemoveAllItemsFromCartForMinicart() {
        GeneralStepDefs.removeLineItemFromConciergeCart();
    }

    @When("I add item to cart via API")
    public void iAddItemToCartViaAPI() {
        GeneralStepDefs.addLineItemsToConciergeCart();
    }

    @When("I add item to cart via UI")
    public void iAddItemToCartViaUI() {
        conciergeE2EStepDefs.iOpenProductPageWithAnd("prod1617188", "63130001");
        conciergeE2EStepDefs.iClickOnAddToCartButton();
        estoreCartPageStepDefs.iClickOnViewCartButton();
    }

    @When("I add item to cart via API with sela item")
    public void iAddItemToCartViaAPIWithSelaItem() {
        GeneralStepDefs.addLineItemsToConciergeCart();
    }

    @When("I remove all items from cart via API")
    public void iRemoveAllItemsFromCartViaAPI() {
        GeneralStepDefs.removeLineItemFromConciergeCart();
    }

    @When("I remove all items from cart via UI")
    public void iRemoveAllItemsFromCartViaUI() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        WebDriverRunner.getWebDriver().navigate().refresh();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (!conciergeUserAccountPage.getCartButtonItemSum().exists()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        if(conciergeUserAccountPage.getCartButtonItemSum().isDisplayed()){
            GeneralStepDefs.removeLineItemFromConciergeCart();
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
            if(conciergeUserAccountPage.getCartButtonItemSum().isDisplayed()){
                try{
                    if (conciergeUserAccountPage.getCartButtonItemSum().exists()) {
                        String URL = Hooks.conciergeBaseURL + "/us/en/checkout/shopping_cart.jsp";
                        open(URL);
                        with().pollInterval(3, SECONDS).await().until(() -> true);
                        WebDriverRunner.getWebDriver().navigate().refresh();
                        with().pollInterval(3, SECONDS).await().until(() -> true);
                        if (!conciergeCartPageScreen.getClearOrderButton().exists()) {
                            WebDriverRunner.getWebDriver().navigate().refresh();
                            open(URL);
                            with().pollInterval(5, SECONDS).await().until(() -> true);
                        }
                        if (!conciergeCartPageScreen.getClearOrderButton().exists()) {
                            System.out.println("400, 503 error");
                        }
                        conciergeCartPageScreen.getClearOrderButton().should(Condition.be(visible), Duration.ofSeconds(10));
                        conciergeCartPageScreen.getClearOrderButton().scrollIntoView(true);
                        conciergeCartPageScreen.getClearOrderButton().click();
                        with().pollInterval(2, SECONDS).await().until(() -> true);
                        if (!conciergeCartPageScreen.getClearOrderButtonPopUpHeader().isDisplayed()) {
                            for (int i = 0; i < 3; i++) {
                                WebDriverRunner.getWebDriver().navigate().refresh();
                                with().pollInterval(4, SECONDS).await().until(() -> true);
                                conciergeCartPageScreen.getClearOrderButton().scrollIntoView(true);
                                conciergeCartPageScreen.getClearOrderButton().shouldHave(visible, Duration.ofSeconds(10));
                                conciergeCartPageScreen.getClearOrderButton().click();
                                with().pollInterval(2, SECONDS).await().until(() -> true);
                                if (conciergeCartPageScreen.getClearOrderButtonPopUpHeader().isDisplayed()) {
                                    conciergeCartPageScreen.getClearOrderButtonPop().click();
                                    break;
                                }
                            }
                        } else {
                            conciergeCartPageScreen.getClearOrderButtonPopUpHeader().shouldHave(text("Are you sure you want to clear the current order?"), Duration.ofSeconds(30));
                            conciergeCartPageScreen.getClearOrderButtonPop().should(Condition.be(visible), Duration.ofSeconds(10));
                            conciergeCartPageScreen.getClearOrderButtonPop().click();
                            with().pollInterval(5, SECONDS).await().until(() -> true);
                        }
                        WebDriverRunner.getWebDriver().navigate().refresh();
                        with().pollInterval(5, SECONDS).await().until(() -> true);
                        conciergeUserAccountPage.getCartButton().should(visible, Duration.ofMinutes(5));

                    }
                } catch (ElementNotFound e){
                    System.out.println("Element not found");
                }
            }
        }
    }

    @When("I clear order via API")
    public void iClearOrderViaAPI() {
        GeneralStepDefs.clearOrder();
    }
}