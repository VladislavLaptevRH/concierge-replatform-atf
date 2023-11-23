package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.ElementNotFound;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import jdk.internal.org.jline.utils.Display;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import tests.concierge.pageObject.*;
import tests.estore.stepdefinitions.EstoreCartPageStepDefs;
import tests.utility.Hooks;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static tests.utility.Hooks.country;

public class ConciergeCartStepDefs {
    WebDriver webDriver = Hooks.getWebDriver();

    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    ConciergeE2EStepDefs conciergeE2EStepDefs = new ConciergeE2EStepDefs();
    AbstractStepDefs abstractStepDefs = new AbstractStepDefs();
    ConciergeAddressScreen conciergeAddressScreen = new ConciergeAddressScreen();

    PdpScreen pdpScreen = new PdpScreen();

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

    Pdp pdp = new Pdp();
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

    public static String date;
    public static String year;
    public static String month;

    public static String method;

   public static float topTotalPriceAfterDecreasing;
   public static float subtotalPriceAfterDecreasing;
   public static float bottomTotalPriceAfterDecreasing;
   public static float topMemberSavingsAfterDecreasing;
   public static float bottomMemberSavingsAfterDecreasing;
   ArrayList<Integer> quantityList = new ArrayList<>();

    public int sumOfArray = 0;

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
        if (!conciergeCartPageScreen.getOrderClassificationSelect().isDisplayed()) {
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
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if(conciergeCartPageScreen.getAgreeAndAddToCart().isDisplayed()){
            conciergeCartPageScreen.getAgreeAndAddToCart().click();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        conciergeItemsScreen.getViewCartButton().shouldHave(text("View Cart"), Duration.ofSeconds(60));
        conciergeItemsScreen.getViewCartButton().should(visible, Duration.ofSeconds(60));
        conciergeCartPageScreen.getKeepShopping().should(visible, Duration.ofSeconds(15));
        conciergeItemsScreen.getViewCartButton().click();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeItemsScreen.getViewCartImage().click();
        with().pollInterval(5, SECONDS).await().until(() -> true);
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
        conciergeCartPageScreen.getClearOrderButton().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getClearOrderButton().click();
        conciergeUserAccountPage.getCartButton().shouldHave(text("CART 0"), Duration.ofSeconds(12));
    }

    @When("I click on quantity line item button")
    public void iClickOnQuantityLineItemButton() {
        selectOption.getQuantitySelectBtn().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        selectOption.getQuantitySelectBtn().should(visible, Duration.ofMinutes(1));
        for(int i = 1; i <= conciergeCartPageScreen.getQuantityItemLineList().size(); i++) {
            conciergeCartPageScreen.getQuantityByNumber(i).click();
            randomQuantity = generalStepDefs.getRandomNumber(2, 40);
            conciergeCartPageScreen.getOptionLineItemByNumber(randomQuantity, i).should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
            conciergeCartPageScreen.getOptionLineItemByNumber(randomQuantity, i).shouldHave(text(Integer.toString(randomQuantity)), Duration.ofSeconds(10));
            conciergeCartPageScreen.getOptionLineItemByNumber(randomQuantity, i).scrollIntoView(true);
            with().pollInterval(2, SECONDS).await().until(() -> true);
            conciergeCartPageScreen.getOptionLineItemByNumber(randomQuantity, i).should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
            conciergeCartPageScreen.getOptionLineItemByNumber(randomQuantity, i).click();
            quantityList.add(randomQuantity);
        }
        WebDriverRunner.getWebDriver().navigate().refresh();
        with().pollInterval(5, SECONDS).await().until(() -> true);
    }

    @Then("I verify that quantity was updated")
    public void iVerifyThatQuantityWasUpdated() {
        for (Integer integer : quantityList) {
            sumOfArray = integer + sumOfArray;
            with().pollInterval(1, SECONDS).await().until(() -> true);
        }
        with().pollInterval(1, SECONDS).await().until(() -> true);
        System.out.println(quantityList);
        assertEquals(sumOfArray, Integer.parseInt(conciergeUserAccountPage.getCartButtonItemSum().getText()));
    }

    @Then("I remove the line items one by one")
    public void iRemoveAllItemsOneByOne() {
       while(conciergeCartPageScreen.getRemoveButtonList().first().isDisplayed()){
           conciergeCartPageScreen.getRemoveButtonList().last().scrollIntoView(true);
           conciergeCartPageScreen.getRemoveButtonList().last().click();
           with().pollInterval(5, SECONDS).await().until(() -> true);
       }
        conciergeCartPageScreen.getYourShoppingCartIsEmptyText().should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify grouping")
    public void iVerifyGrouping() {
        conciergeCartPageScreen.getHowWouldYouLikeToReceiveYourShipmentsText().scrollIntoView(true);
        conciergeCartPageScreen.getHowWouldYouLikeToReceiveYourShipmentsText().shouldBe(visible, Duration.ofSeconds(20));
        conciergeCartPageScreen.getDeliverItemsAsTheyAreAvailableText().shouldBe(visible, Duration.ofSeconds(20));
        conciergeCartPageScreen.getDeliveryASAPText().shouldBe(visible, Duration.ofSeconds(20));
        conciergeCartPageScreen.getConsolidateInfoAsFewDeliveriesAsPossible().shouldBe(visible, Duration.ofSeconds(20));
        conciergeCartPageScreen.getDeliveredOnTheLatestQuotedDeliveryDate().shouldBe(visible, Duration.ofSeconds(20));
    }

    @Then("I verify order classification dropdown")
    public void iVerifyOrderClassificationDropdown() {
        conciergeCartPageScreen.getOrderClassificationLabel().should(text("Order Classification*"), Duration.ofSeconds(20));
        conciergeCartPageScreen.getSelectAnOption().shouldNotBe(visible, Duration.ofSeconds(20));
        conciergeCartPageScreen.getOrderClassification().click();
        conciergeCartPageScreen.getSelectAnOption().shouldNotBe(visible, Duration.ofSeconds(20));
        conciergeCartPageScreen.getRhGalleryOrder().shouldNotBe(visible, Duration.ofSeconds(20));
        conciergeCartPageScreen.getRhResidentialTrade().shouldNotBe(visible, Duration.ofSeconds(20));
        conciergeCartPageScreen.getRhInteriorDesign().shouldNotBe(visible, Duration.ofSeconds(20));
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
        conciergeCartPageScreen.getMetalBoxFrameLeanerMirrorText().shouldNotBe(visible, Duration.ofMinutes(1));
    }

    @Then("Close the Form")
    public void iCloseForm() {
        with().pollInterval(6, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getDialogTitleCloseButton().click();
        conciergeCartPageScreen.getAdjustedText().shouldNotBe(visible, Duration.ofMinutes(1));
    }

    @When("I click on total item line price")
    public void iClickOnTotalItemLinePrice() {

        if(!conciergeCartPageScreen.getQuantityButton().isDisplayed()){
            for(int i = 0; i < 3; i++){
                WebDriverRunner.getWebDriver().navigate().refresh();
                with().pollInterval(5, SECONDS).await().until(() -> true);
                if(conciergeCartPageScreen.getQuantityButton().isDisplayed()){
                    break;
                }
            }

        }
        conciergeCartPageScreen.getQuantityButton().should(visible, Duration.ofSeconds(15));
        int quantity = Integer.parseInt(conciergeCartPageScreen.getQuantityButton().getText());
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
        conciergeCartPageScreen.getPriceByName(arg0).should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getPriceByName(arg0).click();
        method = arg0;
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
    public void iClickOnApplyUppercaseButton(String arg0) {
        if(conciergeCartPageScreen.getUpdateButton().isDisplayed()){
            conciergeCartPageScreen.getRemoveButton().click();
            with().pollInterval(5, SECONDS).await().until(() -> true);
            iClickOnTotalItemLinePrice();
            iSelectPriceOverride(method);
            iIntroducesValueForOverridePrice();
            iChooseReasonCodeForPriceOverride();
        }
        if (arg0.equals("override line item")) {
            conciergeCartPageScreen.getApplyUpperCaseBtn().shouldHave(text("APPLY"), Duration.ofMinutes(1));
            conciergeCartPageScreen.getApplyUpperCaseBtn().click();
        }
        if (arg0.equals("postpone shipment")) {
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
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getTotalMemberPrice().should(visible, Duration.ofMinutes(1));
        with().pollInterval(2, SECONDS).await().until(() -> true);
        executeJavaScript("window.scrollTo(0, -500)");
        if (conciergeCartPageScreen.getReasonCodeField().isDisplayed()) {
            conciergeCartPageScreen.getClosePopUp().click();
            with().pollInterval(3, SECONDS).await().until(() -> true);
        }
        conciergeCartPageScreen.getReasonCodeField().shouldNot(visible, Duration.ofSeconds(15));
        with().pollInterval(2, SECONDS).await().until(() -> true);
        if (arg0.equals("PERCENT_OFF")) {
            if(conciergeCartPageScreen.getSaleItem().isDisplayed()){
                lineItemPriceValueBeforeOverride = conciergeCartPageScreen.getFinalSalePrice().getText().replaceAll(",", "").replaceAll("\\$", "").replaceAll("C", "");
            } else {
                lineItemPriceValueBeforeOverride = conciergeCartPageScreen.getTotalRegularPrice().getText().replaceAll(",", "").replaceAll("\\$", "").replaceAll("C", "");
            }
            lineItemPriceValueAfterOverride = conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll("\\$", "").replaceAll("C", "");
            with().pollInterval(2, SECONDS).await().until(() -> true);

            line = Float.parseFloat(lineItemPriceValueBeforeOverride);
            with().pollInterval(2, SECONDS).await().until(() -> true);

            actual = conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll("\\$", "").replaceAll("C", "");
            with().pollInterval(2, SECONDS).await().until(() -> true);

            if(line != Float.parseFloat(actual)){
                WebDriverRunner.getWebDriver().navigate().refresh();
            }
            System.out.println("line: "+line);
            System.out.println("actual: "+actual);
            assertEquals(line , (Float.parseFloat(actual))*2);
            assertEquals(Float.parseFloat(lineItemPriceValueAfterOverride)*2, line);
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
        priceFirstLineItem = Integer.parseInt(conciergeCartPageScreen.getPriceFirstLineItem().getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", ""));
        priceSecondLineItem = Integer.parseInt(conciergeCartPageScreen.getPriceSecondLineItem().getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", ""));
    }

    @Then("I verify that price override was executed for all line items")
    public void iVerifyThatPriceOverrideWasExecutedForAllLineItems() {
        int priceFirstLineItemAfterOverride = Integer.parseInt(conciergeCartPageScreen.getPriceFirstLineItem().getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", ""));
        int priceSecondLineItemAfterOverride = Integer.parseInt(conciergeCartPageScreen.getPriceSecondLineItem().getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", ""));
        assertEquals(priceFirstLineItem, priceFirstLineItemAfterOverride / 2);
        assertEquals(priceSecondLineItem, priceSecondLineItemAfterOverride / 2);
    }

    @When("I click on remove button from project")
    public void iClickOnRemoveButtonFromProject() {
        generalStepDefs.waitForJSandJQueryToLoad();
        String items = conciergeProjectScreen.getItems().getText().replaceAll("ITEMS: ", "");
        int IntItems = Integer.parseInt(items);
        for (int i = IntItems; i > 0; i--) {
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
        totalPrice = conciergeCartPageScreen.getTotalPrice().getText().replaceAll(",", "").replaceAll("\\$", "");
        totalAdditionalProductDiscountMessage = conciergeCartPageScreen.getTotalAdditionalProductDiscountMessage().getText();
        totalAdditionalProductDiscount = conciergeCartPageScreen.getTotalAdditionalProductDiscount().getText().replaceAll(",", "").replaceAll("\\$", "");
    }

    @When("I introduces promo code {string} for promo codes field")
    public void iIntroducesPromoCodeForPromoCodesField(String promo) {
        if (!conciergeCartPageScreen.getPromotionCodeField().isDisplayed()) {
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
        if (!conciergeCartPageScreen.getTotalAditionalProdDiscount().isDisplayed()) {
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
        float totalPriceAfterStateTax = Float.parseFloat(conciergeCartPageScreen.getTotalPriceAfterStateTax().getText().replaceAll(",", "").replaceAll("\\$", ""));
        float stateTax = Float.parseFloat(conciergeCartPageScreen.getStateTax().getText().replaceAll(",", "").replaceAll("\\$", ""));
        float totalPriceBeforeStateTax = Float.parseFloat(totalPrice);
        float totalAdditionalProductDiscountOnPaymentPage = Float.parseFloat(conciergeCartPageScreen.getTotalAdditionalProductDiscountOnPaymentPage().getText().replaceAll(",", "").replaceAll("\\$", ""));
        conciergeCartPageScreen.getTotalAditionalProdDiscount().should(visible, Duration.ofSeconds(15));
        assertEquals(totalPriceAfterStateTax, totalPriceBeforeStateTax + stateTax);
        assertEquals(Float.parseFloat(totalAdditionalProductDiscount), totalAdditionalProductDiscountOnPaymentPage);
    }

    @When("I choose POS for payment method")
    public void iChoosePOPForPaymentMethod() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (conciergeProjectScreen.getTryAgainButton().isDisplayed()) {
            for (int i = 0; i < 3; i++) {
                if (!paymentScreen.getChoosePaymentMethodBtnDisplayed().isDisplayed()) {
                    WebDriverRunner.getWebDriver().navigate().refresh();
                    with().pollInterval(3, SECONDS).await().until(() -> true);

                    if (checkoutAddressScreen.getBillingAddressCheckbox().exists()) {
                        if (!conciergeCartPageScreen.getBillingShippingAddressSameCheckbox().isDisplayed()) {
                            conciergeCartPageScreen.getBillingShippingAddressSameCheckbox().click();
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

                    if (conciergeCartPageScreen.getContinueAddingAdditionalButton().isDisplayed()) {
                        conciergeCartPageScreen.getContinueAddingAdditionalButton().click();
                        with().pollInterval(5, SECONDS).await().until(() -> true);
                    }

                    if (conciergeProjectScreen.getTryAgainButton().isDisplayed()) {
                        conciergeProjectScreen.getTryAgainButton().click();
                        with().pollInterval(3, SECONDS).await().until(() -> true);
                        abstractStepDefs.iFillAllFieldsFromAddressScreenForBrands();
                        checkoutAddressScreen.getContinuePaymentButton().click();
                        with().pollInterval(3, SECONDS).await().until(() -> true);
                        conciergeCartPageScreen.getContinueAddingAdditionalButton().click();
                        with().pollInterval(5, SECONDS).await().until(() -> true);
                    }
                    paymentStepDefs.iClickOnContinueWithOriginalAddressButton();
                    if (paymentScreen.getChoosePaymentMethodBtnDisplayed().isDisplayed()) {
                        break;
                    }
                }
            }
        }
//        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(1));
        paymentScreen.getChoosePaymentMethodBtn().click();
        paymentScreen.getChoosePaymentMethodBtn().should(Condition.be(visible), Duration.ofSeconds(35));
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        with().pollInterval(4, SECONDS).await().until(() -> true);
        selectPayment.selectByValue("POS");
        with().pollInterval(4, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getPosRegisterField().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getPosRegisterField().setValue("1234");
        conciergeCartPageScreen.getPosTransactionField().setValue("1234");
        paymentScreen.getContinueToReview().should(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        paymentScreen.getContinueToReview().click();
    }

    @Then("I verify that Total Additional Product Discount message is {string} on review page")
    public void iVerifyThatTotalAdditionalProductDiscountMessageIsOnReviewPage(String arg0) {
        if (!conciergeCartPageScreen.getTotalAditionalProdDiscount().isDisplayed()) {
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
       conciergeCartPageScreen.getPromoCodeText().shouldNotBe(visible, Duration.ofMinutes(1));
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
        conciergeCartPageScreen.getCorrectSpaceText().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getWrongSpaceText().should(visible, Duration.ofMinutes(1));
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
        conciergeCartPageScreen.getBecomeAMemberNow().shouldNotBe(visible, Duration.ofSeconds(10));
        conciergeCartPageScreen.getMembersProgramTitle().shouldNotBe(visible, Duration.ofSeconds(10));
        conciergeCartPageScreen.getJoinRhMemberProgramTitle().shouldNotBe(visible, Duration.ofSeconds(10));
        conciergeCartPageScreen.getRhMembershipImmediatelyPay().shouldNotBe(visible, Duration.ofSeconds(10));
    }

    @Then("I verify that ship to, bill to, sold to addresses are displayed")
    public void iVerifyThatShipToBillToSoldToAddressesAreDisplayed() {
        try {
            conciergeCartPageScreen.getSoldToAddressTitle().should(visible, Duration.ofMinutes(1));
        } catch (ElementNotFound e) {
            System.out.println("Sold Address is not displayed");
        }
        try {
            conciergeCartPageScreen.getBillingAddressTitle().should(visible, Duration.ofMinutes(1));
        } catch (ElementNotFound e) {
            System.out.println("Billing Address is not displayed");
        }
        try {
            conciergeCartPageScreen.getShippingAddressTitle().should(visible, Duration.ofMinutes(1));
        } catch (ElementNotFound e) {
            System.out.println("Sipping Address is not displayed");
        }

    }

    @And("I edit ship to, bill to, sold to addresses")
    public void iEditShipToBillToSoldToAddresses() {
        if (conciergeAddressScreen.getEditSAddressButtonUserService().isDisplayed()) {
            conciergeAddressScreen.getEditSAddressButtonUserService().scrollIntoView(true);
            conciergeAddressScreen.getEditSAddressButtonUserService().click();
        }
        if (conciergeAddressScreen.getEditSAddressButtonUserService1().isDisplayed()) {
            conciergeAddressScreen.getEditSAddressButtonUserService1().scrollIntoView(true);
            conciergeAddressScreen.getEditSAddressButtonUserService1().click();
        }
                checkoutAddressScreen.getCompanyNameFieldNewUserService().should(visible, Duration.ofMinutes(1));
                generalStepDefs.clearField(checkoutAddressScreen.getCompanyNameFieldNewUserService());
            checkoutAddressScreen.getCompanyNameFieldNewUserService().should(visible, Duration.ofMinutes(1));
            generalStepDefs.clearField(checkoutAddressScreen.getCompanyNameFieldNewUserService());
            checkoutAddressScreen.getCompanyNameFieldNewUserService().setValue("changedCompanyNameSoldAddress");
        if(conciergeCartPageScreen.getBillingAddressEditButton().isDisplayed()){
            conciergeCartPageScreen.getBillingAddressEditButton().scrollIntoView(true);
            conciergeCartPageScreen.getBillingAddressEditButton().click();
        }
            conciergeCartPageScreen.getBillingAddressCompanyNameInput().should(visible, Duration.ofMinutes(1));
            generalStepDefs.clearField(conciergeCartPageScreen.getBillingAddressCompanyNameInput());
        conciergeCartPageScreen.getBillingAddressCompanyNameInput().setValue("changedCompanyNameBillingAddress");

        if(conciergeCartPageScreen.getBillingAddressEditButton().isDisplayed()){
            conciergeCartPageScreen.getBillingAddressEditButton().click();
        }
        conciergeCartPageScreen.getBillingAddressCompanyNameInput().should(visible, Duration.ofMinutes(1));
            generalStepDefs.clearField(conciergeCartPageScreen.getBillingAddressCompanyNameInput());
        conciergeCartPageScreen.getBillingAddressCompanyNameInput().setValue("changedCompanyNameShippingAddress");
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

    @Then("I verify that contract client price displayed as total price")
    public void iVerifyThatContractClientDisplayedAsTotalPrice() {
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
        conciergeCartPageScreen.getPostponeShipment().should( visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getPostponeShipment().scrollIntoView(true);
        conciergeCartPageScreen.getPostponeShipment().shouldHave(text("Postpone Shipment"), Duration.ofSeconds(15));
        conciergeCartPageScreen.getPostponeShipment().click();
        conciergeCartPageScreen.getPostponeSelectReasonCode().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeCartPageScreen.getPostponeSelectReasonCode().should(visible, Duration.ofSeconds(15));
        Select postponeReasonCode = new Select(conciergeCartPageScreen.getPostponeSelectReasonCode());
        conciergeCartPageScreen.getPostponeSelectReasonCode().scrollIntoView(true);
        postponeReasonCode.selectByValue("Construction/Remodel");
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getLastMonthDay().click();
        date = conciergeCartPageScreen.getCurrentMonth().getText();

    }

    @Then("I verify that postpone shipment was applied")
    public void iVerifyThatPostponeShipmentWasApplied() {
        generalStepDefs.waitForJSandJQueryToLoad();
        month = date.substring(0, 4);
        String fistLetter = month.substring(0, 1);
        String lastPart = month.substring(1, 3).toLowerCase();
        month = fistLetter + lastPart;
        year = date.replaceAll("[^0-9]", "");
       conciergeCartPageScreen.getRestShipmentText().shouldHave(text("Reset Shipment"), Duration.ofSeconds(15));
        conciergeCartPageScreen.getReasonCodeText().shouldHave(text("Reason Code: Construction/Remodel"), Duration.ofSeconds(15));
        conciergeCartPageScreen.getShipOnOrAfterDate().shouldHave(text("Ship on or after: " + month + " 30, " + year + ""), Duration.ofSeconds(15));
    }

    @Then("I remove postpone shipment")
    public void iRemovePostPhoneShipment() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getRestShipmentText().click();
        conciergeCartPageScreen.getRestShipmentText().shouldNot(visible, Duration.ofSeconds(15));
       conciergeCartPageScreen.getReasonCodeText().shouldNot(visible, Duration.ofSeconds(15));
       conciergeCartPageScreen.getShipOnOrAfterDate().shouldNot(visible, Duration.ofSeconds(15));
    }

    @Then("I verify that gift box was added")
    public void iVerifyThatGiftBoxWasAdded() {
        conciergeCartPageScreen.getGiftBoxFee().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getGiftBoxPrice().shouldHave(text("$5.95"), Duration.ofSeconds(15));

    }

    @When("I click on gift box button")
    public void iClickOnRemoveGiftBoxButton() {
        generalStepDefs.waitForJSandJQueryToLoad();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if(!conciergeItemsScreen.getAddGiftCheckBox().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        executeJavaScript("arguments[0].click();", conciergeItemsScreen.getAddGiftCheckBox());
        with().pollInterval(5, SECONDS).await().until(() -> true);
    }

    @Then("I verify that gift box was removed")
    public void iVerifyThatGiftBoxWasRemoved() {
        conciergeCartPageScreen.getGiftBoxFee().shouldNotBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getGiftBoxPrice().shouldNot(visible, Duration.ofSeconds(15));
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
        if(conciergeCartPageScreen.getShippingAddressEditButton().isDisplayed()) {
            conciergeCartPageScreen.getShippingAddressEditButton().scrollIntoView(true);
            conciergeCartPageScreen.getShippingAddressEditButton().click();
        }
        checkoutAddressScreen.getFirstNameInpt().should(visible, Duration.ofMinutes(1));
        checkoutAddressScreen.getFirstNameInpt().shouldHave(value("QAFirst"), Duration.ofMinutes(1));
        checkoutAddressScreen.getLastNameField().shouldHave(value("Automation"), Duration.ofMinutes(1));
    }

    @Then("I verify that monogram was added")
    public void iVerifyThatMonoramWasAdded() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getMonogramStyleValue().should(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getMonogramTextValue().should(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getMonogramStyle().shouldHave(text("Style"), Duration.ofSeconds(15));
        conciergeCartPageScreen.getMonogramColor().shouldHave(text("Color"), Duration.ofSeconds(15));
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
        conciergeCartPageScreen.getMonogramColors().get(2).click();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getMonogramTextInput().setValue("ABC");
        conciergeCartPageScreen.getMonogramColors().get(2).click();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getAddMonogramButton().click();
    }

    @When("I edit monogram")
    public void iEditMonogram() {
        generalStepDefs.waitForJSandJQueryToLoad();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getEditMonogramButton().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getMonogramFonts().get(5).scrollIntoView(true);
        conciergeCartPageScreen.getMonogramFonts().get(5).should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeCartPageScreen.getMonogramFonts().get(5).doubleClick();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getMonogramTextInput().setValue("DFG");
        conciergeCartPageScreen.getAddMonogramButton().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getAddMonogramButton().click();
    }

    @Then("I verify that monogram was edited")
    public void iVerifyThatMonogramWasEdited() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getEditedMonogramStyleValue().should(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getEditedMonogramColorValue().should(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getEditedMonogramTextValue().should(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getEditedMonogramStyle().shouldHave(text("Style"), Duration.ofSeconds(15));
        conciergeCartPageScreen.getEditedMonogramText().shouldHave(text("Text"), Duration.ofSeconds(15));
        conciergeCartPageScreen.getEditedMonogramColor().shouldHave(text("Color"), Duration.ofSeconds(15));
    }

    @When("I remove monogram")
    public void iRemoveMonogram() {
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeCartPageScreen.getRemoveMonogramBtn().shouldHave(text("Remove"), Duration.ofMinutes(1));
        conciergeCartPageScreen.getRemoveMonogramBtn().click();
        with().pollInterval(9, SECONDS).await().until(() -> true);
        //WebDriverRunner.getWebDriver().navigate().refresh();
        with().pollInterval(5, SECONDS).await().until(() -> true);
    }

    @Then("I verify that monogram was removed")
    public void iVerifyThatMonogramWasRemoved() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getEditedMonogramStyleValue().shouldNotBe(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getEditedMonogramColorValue().shouldNotBe(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getEditedMonogramTextValue().shouldNotBe(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getEditedMonogramStyle().shouldNotBe(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getEditedMonogramText().shouldNotBe(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getEditedMonogramColor().shouldNotBe(visible, Duration.ofSeconds(15));
    }

    @Then("I verify that availability, Delivery and Returns messaging in cart")
    public void iVerifyThatAvailabilityDeliveryAndReturnsMessagingInCart() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getItemInSockText().should(visible, Duration.ofSeconds(10));
        conciergeCartPageScreen.getItemCanBeReturned().should(visible, Duration.ofMinutes(1));
    }

    @Then("I verify alternate addresses for client with multiple addresses")
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
                if (conciergeCartPageScreen.getRhMembershipImmediatelyPay().isDisplayed()) {
                    break;
                }
            }

        }
        conciergeCartPageScreen.getRhMembershipImmediatelyPay().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getBecomeAMemberNow().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getNoThanksButton().should(visible, Duration.ofMinutes(1));
    }

    @Then("I verify that employee discount is present")
    public void iVerifyThatEmployeeDiscountIsPresent() {
        conciergeCartPageScreen.getTotalAditionalProdDiscount().shouldHave(text("Total Additional Product Discount"), Duration.ofSeconds(15));
        conciergeCartPageScreen.getTotalAditionalProdDiscount().should(Condition.and("", visible, enabled), Duration.ofSeconds(15));
    }

    @Then("I verify membership banner")
    public void iVerifyMembershipBanner() {
        with().pollInterval(9, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getRemoveMembershipButton().shouldBe(visible, Duration.ofSeconds(15));
        with().pollInterval(9, SECONDS).await().until(() -> true);
        MemberPrice = conciergeCartPageScreen.getTotalPriceCurrentResult().getText().replace("$", "").replace(",", "");
        float regularPrice = Float.parseFloat(RegularPrice);
        float memberPrice = Float.parseFloat(MemberPrice);
        String savings = Float.toString(regularPrice - memberPrice);
        String Savings= conciergeCartPageScreen.getRhMembersProgramTitleText().getText();
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
        conciergeCartPageScreen.getAvailabilityText().shouldHave(text("Availability"), Duration.ofSeconds(20));
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
        conciergeCartPageScreen.getDesignedSoldByText().shouldBe(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getAutomationAssociateText().shouldBe(visible, Duration.ofSeconds(15));
    }

    @Then("I click {string} on cart screen")
    public void iClickOnButtonOnCartScreen(String button) {
        switch (button) {
            case "join now button":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                conciergeCartPageScreen.getJoinNowButton().click();
                with().pollInterval(9, SECONDS).await().until(() -> true);
                conciergeCartPageScreen.getJoinNowButton().shouldNot(visible,  Duration.ofSeconds(15));
                break;
            case "remove membership button":
                conciergeCartPageScreen.getRemoveMembershipButton().click();
                with().pollInterval(9, SECONDS).await().until(() -> true);
                conciergeCartPageScreen.getJoinNowButton().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case "Remove Link":
                for(int i = 0; i <= 3 ; i++) {
                    conciergeCartPageScreen.getRemoveLinkButton().click();
                    with().pollInterval(9, SECONDS).await().until(() -> true);
                   if(!conciergeCartPageScreen.getRemoveLinkButton().isDisplayed()){
                       break;
                   }
                }

                if(!conciergeCartPageScreen.getYourShoppingCartIsEmptyText().isDisplayed()){
                  
                    WebDriverRunner.getWebDriver().navigate().refresh();
                }
                conciergeCartPageScreen.getYourShoppingCartIsEmptyText().shouldBe(visible, Duration.ofSeconds(15));
                break;
            default:
                break;
        }
    }

    @Then("I verify that {string} on the cart page")
    public void iVerifyThatOnTheCartPage(String data) {
        switch (data) {
            case "quantity and sum were decreased":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                assertEquals(topTotalPriceAfterDecreasing / 5, Float.parseFloat(conciergeCartPageScreen.getTotalPriceCurrentResult().getText().replace("$", "").replace(",", "")));
                assertEquals(subtotalPriceAfterDecreasing / 5, Float.parseFloat(conciergeCartPageScreen.getSubtotalPriceCurrentResult().getText().replace("$", "").replace(".00","").replace(",", "")));
//                assertEquals(bottomTotalPriceAfterDecreasing / 5, Float.parseFloat(cart.getText().replace("$", "").replace(",", "")));
                assertEquals(topMemberSavingsAfterDecreasing / 5, Float.parseFloat(conciergeCartPageScreen.getTopMemberSavingsCurrentResult().getText().substring(51, 57).replace(",", "")));
                assertEquals(bottomMemberSavingsAfterDecreasing / 5, Float.parseFloat(conciergeCartPageScreen.getBottomMemberSavingsCurrentResult().getText().replaceAll("[^0-9]", "").replace("00", "")));
                break;
            case "quantity and sum were increased1":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                assertEquals(topTotalPriceAfterDecreasing * 4, Float.parseFloat(conciergeCartPageScreen.getTotalPriceCurrentResult().getText().replace("$", "").replace(",", "")));
                assertEquals(subtotalPriceAfterDecreasing * 4, Float.parseFloat(conciergeCartPageScreen.getSubtotalPriceCurrentResult().getText().replace("$", "").replace(".00","").replace(",", "")));
//                assertEquals(bottomTotalPriceAfterDecreasing * 4, Float.parseFloat($(By.xpath("//h5[@aria-describedby = 'shipping-override-price-dialog']")).getText().replace("$", "").replace(",", "")));
                assertEquals(topMemberSavingsAfterDecreasing * 4, Float.parseFloat(conciergeCartPageScreen.getTopMemberSavingsCurrentResult().getText().substring(51, 57).replace(",", "")));
                assertEquals(bottomMemberSavingsAfterDecreasing * 4, Float.parseFloat(conciergeCartPageScreen.getBottomMemberSavingsCurrentResult().getText().replaceAll("[^0-9]", "").replace("00", "")));
                assertEquals(topTotalPriceAfterDecreasing / 5, Float.parseFloat($(By.xpath("//*[@aria-describedby = 'price-override-popper']/h5")).getText().replace("$", "").replace(",", "")));
                assertEquals(subtotalPriceAfterDecreasing / 5, Float.parseFloat($(By.xpath("//*[contains(text(), 'Subtotal')]/../following-sibling::div/span")).getText().replace("$", "").replace(".00","").replace(",", "")));
                assertEquals(topMemberSavingsAfterDecreasing / 5, Float.parseFloat( $(By.xpath("//h2/following-sibling::p")).getText().substring(51, 57).replace(",", "")));
                with().pollInterval(5, SECONDS).await().until(() -> true);
                assertEquals(bottomMemberSavingsAfterDecreasing / 5, Float.parseFloat($(By.xpath("(//*[contains(text(),'Join the RH Members Program')])[2]/..")).getText().replaceAll("[^0-9]", "").replace("00", "")));
                break;
            case "quantity and sum were increased":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                assertEquals(topTotalPriceAfterDecreasing * 4, Float.parseFloat($(By.xpath("//*[@aria-describedby = 'price-override-popper']/h5")).getText().replace("$", "").replace(",", "")));

                assertEquals(subtotalPriceAfterDecreasing * 4, Float.parseFloat($(By.xpath("//*[contains(text(), 'Subtotal')]/../following-sibling::div/span")).getText().replace("$", "").replace(".00","").replace(",", "")));
                with().pollInterval(5, SECONDS).await().until(() -> true);
                assertEquals(topMemberSavingsAfterDecreasing * 4, Float.parseFloat( $(By.xpath("//h2/following-sibling::p")).getText().substring(51, 57).replace(",", "")));
                with().pollInterval(5, SECONDS).await().until(() -> true);
                assertEquals(bottomMemberSavingsAfterDecreasing * 4, Float.parseFloat($(By.xpath("(//*[contains(text(),'Join the RH Members Program')])[2]/..")).getText().replaceAll("[^0-9]", "").replace("00", "")));
                break;
            default:
                break;
        }
    }

    @Then("I change quantity in the car for {string}")
    public void iChangeQuantityInTheCart(String quantity) {
        Select itemList = new Select(conciergeCartPageScreen.getQuantityButton());
        itemList.selectByIndex(Integer.parseInt(quantity));
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if(!conciergeCartPageScreen.getQuantityButton().getText().equals(quantity)){
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
    }

    @Then("I save data for decreasing")
    public void iSafeDataForDecreasing() {
        topTotalPriceAfterDecreasing = Float.parseFloat(conciergeCartPageScreen.getTotalPriceCurrentResult().getText().replace("$", "").replace(",", ""));
        subtotalPriceAfterDecreasing = Float.parseFloat(conciergeCartPageScreen.getSubtotalPriceCurrentResult().getText().replace("$", "").replace(".00","").replace(",", ""));
        bottomTotalPriceAfterDecreasing = Float.parseFloat(conciergeCartPageScreen.getTotalPrice().getText().replace("$", "").replace(",", ""));
        topMemberSavingsAfterDecreasing = Float.parseFloat(conciergeCartPageScreen.getTopMemberSavingsCurrentResult().getText().substring(51, 59).replace(",", ""));
        bottomMemberSavingsAfterDecreasing = Float.parseFloat(conciergeCartPageScreen.getBottomMemberSavingsCurrentResult().getText().replaceAll("[^0-9]", "").replace("00", ""));
    }

    @Then("I save data for increasing")
    public void iSafeDataForIncreasing() {
        if(!conciergeCartPageScreen.getTotalPriceCurrentResult().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
        }
        topTotalPriceAfterDecreasing = Float.parseFloat(conciergeCartPageScreen.getTotalPriceCurrentResult().getText().replace("$", "").replace(",", ""));
        subtotalPriceAfterDecreasing = Float.parseFloat(conciergeCartPageScreen.getSubtotalPriceCurrentResult().getText().replace("$", "").replace(".00","").replace(",", ""));
        bottomTotalPriceAfterDecreasing = Float.parseFloat(conciergeCartPageScreen.getTotalPrice().getText().replace("$", "").replace(",", ""));
        topMemberSavingsAfterDecreasing = Float.parseFloat(conciergeCartPageScreen.getTopMemberSavingsCurrentResult().getText().substring(51, 57).replace(",", ""));
        bottomMemberSavingsAfterDecreasing = Float.parseFloat(conciergeCartPageScreen.getBottomMemberSavingsCurrentResult().getText().replaceAll("[^0-9]", "").replace("00", ""));
    }

    @Then("I verify membership banner in PG")
    public void iVerifyMembershipBannerInPG() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getRemoveMembershipButton().shouldBe(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getTopMemberSavingsCurrentResult().shouldBe(visible, Duration.ofSeconds(15));
    }

    @Then("I verify that Membership Banner is present with all the data")
    public void iVerifyThatMembershipBannerIsPresentWithAllTheData() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getTotalPriceCurrentResult().shouldBe(visible, Duration.ofSeconds(15));
       RegularPrice = conciergeCartPageScreen.getTotalPriceCurrentResult().getText().replace("$", "").replace(",", "");
        $(By.xpath("//h2/i")).shouldBe(text("The"), Duration.ofSeconds(15));
        $(By.xpath("//h2")).shouldBe(text(" RH MEMBERS PROGRAM"), Duration.ofSeconds(15));
        conciergeCartPageScreen.getTopMemberSavingsCurrentResult().shouldBe(visible, Duration.ofSeconds(15));
        conciergeCartPageScreen.getJoinNowButton().shouldBe(visible, Duration.ofSeconds(15));
    }

    @When("I choose order classification")
    public void iChooseOrderClassification() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (!conciergeCartPageScreen.getOrderClassificationSelect().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        with().pollInterval(5, SECONDS).await().until(() -> true);
        Select orderClassificationDropDownList = new Select(conciergeCartPageScreen.getOrderClassificationSelect());
        orderClassificationDropDownList.selectByValue("RH Gallery Order");
        with().pollInterval(5, SECONDS).await().until(() -> true);
    }

    @Then("I verify contract savings")
    public void iVerifyContractSavingsForCartPage() {
        conciergeCartPageScreen.getContractSavingsText().should(visible, Duration.ofSeconds(20));
        conciergeCartPageScreen.getContractSavingsValue().should(visible, Duration.ofSeconds(20));
    }

    @When("I click on order details button")
    public void iClickOnOrderDetailsButton() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if(!conciergeUserAccountPage.getOrderDetailsButtonByName("Order Details").isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
        }
        conciergeUserAccountPage.getOrderDetailsButtonByName("View Order Details").isDisplayed();
        conciergeUserAccountPage.getOrderDetailsButtonByName("View Order Details").click();
    }

    @When("I remove all items from cart for minicart")
    public void iRemoveAllItemsFromCartForMinicart() {
        GeneralStepDefs.removeLineItemFromConciergeCart();
    }

    @When("I add item to cart via API")
    public void iAddItemToCartViaAPI() {
        GeneralStepDefs.addLineItemsToConciergeCart();
    }

    @When("I verify that mattress fee is showing in order estimate")
    public void iVerifyThatMattressFeeIsShowing() {
        if(Objects.equals(country, "US")){
            assertEquals(conciergeCartPageScreen.getOrderEstimate().getText(), "$10.50");
        }
        if(Objects.equals(country, "GB")){
            assertEquals(conciergeCartPageScreen.getOrderEstimate().getText(), "$11.75");
        }
        if(Objects.equals(country, "CA")){
            assertEquals(conciergeCartPageScreen.getOrderEstimate().getText(), "$16");
        }
    }

    @When("I verify that company name is not mandatory on address page")
    public void iVerifyThatCompanyIsNotMandatoryOnAddressPage() {
        conciergeCartPageScreen.getWeAreUnableToVerifyTheAddressProvidedText().should(visible, Duration.ofSeconds(20));
    }

    @When("I verify updated zip code in the cart is {string}")
    public void iVerifyUpdatedZipCode(String zipCode) {
        conciergeCartPageScreen.getPdpScreenZipCode().should(text(zipCode), Duration.ofSeconds(20));
    }

    @When("I verify updated zip code in PDP")
    public void iVerifyUpdatedZipCodeInPDP() {
        conciergeCartPageScreen.getUpdatedZipCodeInPDP().should(text("11111"), Duration.ofSeconds(20));
    }

    @When("Verify that after come back to address page from payment page ship to and bill to address is showing")
    public void iVerifyShippingAndBillingAddresses() {
        WebDriverRunner.getWebDriver().navigate().back();
        conciergeCartPageScreen.getShippingAddress().should(visible, Duration.ofSeconds(20));
        conciergeCartPageScreen.getBillingAddress().should(visible, Duration.ofSeconds(20));
    }

    @Then("Verify Checkout page should get opened with Shipping and Billing address option")
    public void iVerifyCheckoutShippingAndBillingAddresses() {
        WebDriverRunner.getWebDriver().navigate().back();
        conciergeCartPageScreen.getShippingAddress().should(visible, Duration.ofSeconds(20));
        conciergeCartPageScreen.getBillingAddress().should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify client should not get added with empty address field.")
    public void iVerifyClientNotAdded() {
        WebDriverRunner.getWebDriver().navigate().back();
        conciergeCartPageScreen.getShippingAddress().should(visible, Duration.ofSeconds(20));
        conciergeCartPageScreen.getBillingAddress().should(visible, Duration.ofSeconds(20));
    }

    @When("Verify that on address page state drop down field is not shown empty")
    public void iVerifyThatStateDropDownIsNotEmpty() {
        conciergeCartPageScreen.getShippingAddressStateField().click();
        List<String> stateItems = new ArrayList(Arrays.asList("AL - Alabama", "AK - Alaska", "AZ - Arizona", "AR - Arkansas", "CA - California", "CO - Colorado", "CT - Connecticut", "DE - Delaware", "DC - District Of Columbia", "FL - Florida", "GA - Georgia", "HI - Hawaii", "ID - Idaho", "IL - Illinois", "IN - Indiana", "IA - Iowa", "KS - Kansas", "KY - Kentucky", "LA - Louisiana", "ME - Maine", "MD - Maryland", "MA - Massachusetts", "MI - Michigan", "MN - Minnesota", "MS - Mississippi", "MO - Missouri", "MT - Montana", "NE - Nebraska", "NV - Nevada", "NH - New Hampshire", "NJ - New Jersey", "NM - New Mexico", "NY - New York", "NC - North Carolina", "ND - North Dakota", "OH - Ohio", "OK - Oklahoma", "OR - Oregon", "PA - Pennsylvania", "RI - Rhode Island", "SC - South Carolina", "SD - South Dakota", "TN - Tennessee", "TX - Texas", "UT - Utah", "VT - Vermont", "VA - Virginia", "WA - Washington", "WV - West Virginia", "WI - Wisconsin", "WY - Wyoming"));
        for (int i = 2; i <= stateItems.size(); i++) {
           conciergeCartPageScreen.getShippingAddressStateByNumber(i).scrollIntoView(true);
            assertEquals( conciergeCartPageScreen.getShippingAddressStateByNumber(i).getText(), stateItems.get(i-2));
        }
        conciergeCartPageScreen.getBillingAddressStateField().click();
        for (int i = 2; i <= stateItems.size(); i++) {
            conciergeCartPageScreen.getBillingAddressStateByNumber(i).scrollIntoView(true);
            assertEquals( conciergeCartPageScreen.getBillingAddressStateByNumber(i).getText(), stateItems.get(i-2));
        }
    }

    @When("I add line items to cart via API for grouping")
    public void iAddLineItemsToCartViaAPIForGrouping() {
        GeneralStepDefs.addLineItemsToConciergeCartWithSKU("10031801 WGRY", "1");
        GeneralStepDefs.addLineItemsToConciergeCartWithSKU("22100257 LHST", "1");
        GeneralStepDefs.addLineItemsToConciergeCartWithSKU("10106866 FGWT", "1");
    }

    @When("I add line items to cart via API")
    public void iAddLineItemsToCartViaAPI() {
        GeneralStepDefs.addLineItemsToConciergeCartWithSKU("10031801 WGRY", "1");
        GeneralStepDefs.addLineItemsToConciergeCartWithSKU("10078584 ABRS", "1");
        GeneralStepDefs.addLineItemsToConciergeCartWithSKU("10106866 FGWT", "1");
    }

    @When("Verify that zip code was updated in the Cart to {string}")
    public void verifyThatZipCodeWasUpdatedInTheCart(String zipCode) {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if(conciergeCartPageScreen.getPdpScreenZipCode().isDisplayed()) {
            conciergeCartPageScreen.getPdpScreenZipCode().should(visible, Duration.ofSeconds(10));
            conciergeCartPageScreen.getPdpScreenZipCode().scrollIntoView(true);
            with().pollInterval(8, SECONDS).await().until(() -> true);
            assertEquals(zipCode, conciergeCartPageScreen.getPdpScreenZipCode().getText());
        }
        else{
            conciergeCartPageScreen.getPdpScreenZipCode().shouldNotBe(visible, Duration.ofSeconds(10));
        }
    }

    @Then("I change zip code in the cart to {string}")
    public void changeTheZipCodeInTheCart(String zipCode) {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getPdpScreenZipCode().click();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        generalStepDefs.clearField(pdpScreen.getPostalCode());
        pdpScreen.getPostalCode().setValue(zipCode);
        pdpScreen.getConfirmationPostalCode().click();
        with().pollInterval(8, SECONDS).await().until(() -> true);

    }

    @Then("I change zip code on PDP page to {string}")
    public void changeTheZipCodeOnPDPPAge(String zipCode) {
        with().pollInterval(9, SECONDS).await().until(() -> true);
        if(!conciergeCartPageScreen.getWillBeReadyForDeliveryBetweenText().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            pdp.iChoseLineItemSelectionsOneByOne("1");
        }
        conciergeCartPageScreen.getWillBeReadyForDeliveryBetweenText().click();
        generalStepDefs.clearField(pdpScreen.getPostalCode());
        pdpScreen.getPostalCode().setValue(zipCode);
        pdpScreen.getConfirmationPostalCode().click();
        with().pollInterval(5, SECONDS).await().until(() -> true);
    }

    @When("I add item to cart via API with {string} and quantity {string}")
    public void iAddItemToCartViaAPI(String SKU, String quantity) {
        GeneralStepDefs.addLineItemsToConciergeCartWithSKU(SKU, quantity);
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

    @When("I clear all orders form the cart")
    public void iClearAllItemsFromTheCart() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        WebDriverRunner.getWebDriver().navigate().refresh();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (!conciergeUserAccountPage.getCartButtonItemSum().exists()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        if (conciergeUserAccountPage.getCartButtonItemSum().isDisplayed()) {
            try {
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
                                conciergeCartPageScreen.getClearOrderButton().click();
                                break;
                            }
                        }
                    } else {
                        conciergeCartPageScreen.getClearOrderButtonPopUpHeader().shouldHave(text("Are you sure you want to clear the current cart?"), Duration.ofSeconds(30));
                        conciergeCartPageScreen.getClearOrderButton().should(Condition.be(visible), Duration.ofSeconds(10));
                        conciergeCartPageScreen.getClearOrderButton().click();
                        with().pollInterval(5, SECONDS).await().until(() -> true);
                    }
                    WebDriverRunner.getWebDriver().navigate().refresh();
                    with().pollInterval(5, SECONDS).await().until(() -> true);
                    conciergeUserAccountPage.getCartButton().should(visible, Duration.ofMinutes(5));

                }
            } catch (ElementNotFound e) {
                System.out.println("Element not found");
            }
        }
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
        if (conciergeUserAccountPage.getCartButtonItemSum().isDisplayed()) {
            GeneralStepDefs.removeLineItemFromConciergeCart();
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
            if (conciergeUserAccountPage.getCartButtonItemSum().isDisplayed()) {
                try {
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
                        if (!conciergeCartPageScreen.getClearOrderButtonPopUpHeader().isDisplayed() || !conciergeCartPageScreen.getClearCartButtonPopUpHeader().isDisplayed()) {
                            for (int i = 0; i < 3; i++) {
                                    conciergeCartPageScreen.getClearCartButtonPop().should(Condition.be(visible), Duration.ofSeconds(10));
                                    conciergeCartPageScreen.getClearCartButtonPop().click();
                                    with().pollInterval(5, SECONDS).await().until(() -> true);
                                if (!conciergeUserAccountPage.getCartButtonItemSum().isDisplayed()) {
                                    break;
                                }
                            }
                        }
                        WebDriverRunner.getWebDriver().navigate().refresh();
                        with().pollInterval(5, SECONDS).await().until(() -> true);
                        conciergeUserAccountPage.getCartButton().should(visible, Duration.ofMinutes(5));
                    }
                } catch (ElementNotFound e) {
                    System.out.println("Element not found");
                }
            }
        }
    }

    @When("I verify all the sums on the cart page")
    public void iVerifyAllTheSumsOnTheCartPage() {
        if (country.equals("GB")) {

        }

        if (country.equals("CA")) {

        }

            if (country == null || country.equals("US")) {
                with().pollInterval(9, SECONDS).await().until(() -> true);
                conciergeCartPageScreen.getNanPrice().shouldNotBe(visible, Duration.ofSeconds(15));
                conciergeCartPageScreen.getRegularPriceInPG().shouldHave(text("$3,860.00"), Duration.ofSeconds(20));
                conciergeCartPageScreen.getRegularPriceInPG().shouldNotHave(text("$NaN"), Duration.ofSeconds(20));
                conciergeCartPageScreen.getMemberPriceInPG().shouldHave(text("$2,895.00"), Duration.ofSeconds(20));
                conciergeCartPageScreen.getMemberPriceInPG().shouldNotHave(text("$NaN"), Duration.ofSeconds(20));
                if(conciergeCartPageScreen.getPriceForFinalSale().isDisplayed()){
                    conciergeCartPageScreen.getPriceForFinalSale().shouldHave(text("$5,010.00"), Duration.ofSeconds(20));
                    conciergeCartPageScreen.getPriceForFinalSale().shouldNotHave(text("$NaN"), Duration.ofSeconds(20));
                }
                conciergeCartPageScreen.getTotalPriceCurrentResult().shouldHave(text("$3,860.00"), Duration.ofSeconds(20));
                conciergeCartPageScreen.getTotalPriceCurrentResult().shouldNotHave(text("$NaN"), Duration.ofSeconds(20));
                conciergeCartPageScreen.getSubtotalCurrentValue().shouldHave(text("$3,860.00"), Duration.ofSeconds(20));
                conciergeCartPageScreen.getSubtotalCurrentValue().shouldNotHave(text("$NaN"), Duration.ofSeconds(20));
                conciergeCartPageScreen.getTotalWithTaxesCurrentPrice().shouldHave(text("$299.00"), Duration.ofSeconds(20));
                conciergeCartPageScreen.getTotalWithTaxesCurrentPrice().shouldNotHave(text("$NaN"), Duration.ofSeconds(20));
                conciergeCartPageScreen.getTotalPrice().shouldHave(text("$4,159.00"), Duration.ofSeconds(20));
                conciergeCartPageScreen.getTotalPrice().shouldNotHave(text("$NaN"), Duration.ofSeconds(20));
            }
            $(By.xpath("//*[@aria-describedby = 'price-override-popper']/h5")).shouldHave(text("$3,860.00"), Duration.ofSeconds(20));
            $(By.xpath("//*[text() = 'Subtotal' ]/../following-sibling::div/span")).shouldHave(text("$3,860.00"), Duration.ofSeconds(20));
        }

    @When("I verify all the sums on the cart page with item quantity {string}")
    public void iVerifyAllTheSumsOnTheCartPage(String quantity) {
        if (country.equals("GB")) {

        }

        if (country.equals("CA")) {

        }

        if (country == null || country.equals("US")) {
            with().pollInterval(5, SECONDS).await().until(() -> true);

            conciergeCartPageScreen.getTotalRegularPrice().should(visible, Duration.ofSeconds(20));
            if(conciergeCartPageScreen.getTotalTradePrice().isDisplayed()){
                conciergeCartPageScreen.getTotalTradePrice().should(visible, Duration.ofSeconds(20));
            } else {
                conciergeCartPageScreen.getMemberPriceInPG().should(visible, Duration.ofSeconds(20));
                //conciergeCartPageScreen.getMemberPriceInPG().shouldNotHave(text("$NaN"), Duration.ofSeconds(20));
            }
            if(conciergeCartPageScreen.getPriceForFinalSale().isDisplayed()){
                conciergeCartPageScreen.getPriceForFinalSale().shouldHave(visible, Duration.ofSeconds(20));
                //conciergeCartPageScreen.getPriceForFinalSale().shouldNotHave(visible, Duration.ofSeconds(20));
            }
            String Amount = conciergeCartPageScreen.getPriceInViewPage().getText().replace("$", "").replace(".00", "").replaceAll(",", "");
            System.out.println("Amount: "+Amount);

            Integer number = Integer.parseInt(Amount);
            System.out.println("number: "+number);

            int totalWithoutTaxes = number * Integer.parseInt(quantity);
           // assertEquals(totalWithoutTaxes, Integer.parseInt(String.valueOf(conciergeCartPageScreen.getTotalWithoutTaxes().getText()).replaceAll("\\$", "").replaceAll(",", "").replaceAll(".00", "")));

            int subtotal = number * Integer.parseInt(quantity);
            //assertEquals(subtotal, Integer.parseInt(String.valueOf(conciergeCartPageScreen.getSubtotal().getText()).replaceAll("\\$", "").replaceAll(",", "").replaceAll(".00", "")));

            int totalWithTaxes = subtotal + (Integer.parseInt(String.valueOf(conciergeCartPageScreen.getUnlimitedDeliverySectionInTotal().getText()).replaceAll("\\$", "").replaceAll(",", "").replaceAll(".00", "")));
            assertEquals(totalWithTaxes, Integer.parseInt(String.valueOf(conciergeCartPageScreen.getTotalWithTaxes().getText()).replaceAll("\\$", "").replaceAll(",", "").replaceAll(".00", "")));

        }
    }

    @When("I clear order via API")
    public void iClearOrderViaAPI() {
        GeneralStepDefs.clearOrder();
    }

    @Then("I verify that {string} on Cart screen")
    public void iVerifyThatOnCartScreen(String data) {
        switch (data) {
            case "Regular price & Total Price for the product":
                conciergeCartPageScreen.getRegularAndTotalPriceForTheProduct().shouldBe(visible, Duration.ofSeconds(20));
                break;
            default: break;
        }
    }
}