package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;

import com.codeborne.selenide.WebDriverRunner;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tests.utility.Hooks;
import tests.concierge.pageObject.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ConciergeCartStepDefs {
    WebDriver webDriver = Hooks.getWebDriver();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    int randomQuantity;
    int priceFirstLineItem;
    int priceSecondLineItem;
    String lineItemPriceValueBeforeOverride;
    String totalPriceCart;
    DecimalFormat digitFormatDoubleZero = new DecimalFormat("0.00");
    PaymentScreen paymentScreen = new PaymentScreen();
    SelectOption selectOption = new SelectOption();
    ProjectSettingsScreen projectSettingsScreen = new ProjectSettingsScreen();
    ConciergeProjectScreen conciergeProjectScreen = new ConciergeProjectScreen();
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen();
    private static String USER_ID;
    private static final String USEREMAIL = "automationassociate@rh.com";
    private static final String PASSWORD = "Test@@123";
    public static final String BASE_URL = Hooks.conciergeURL;
    private static String id;
    private static Response response;
    private static String addItemEndpoint;




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
        conciergeCartPageScreen.getOrderClassificationSelect().should(visible, Duration.ofSeconds(40));
        assertTrue(conciergeCartPageScreen.getOrderClassificationSelect().isDisplayed(), "Order classification is displayed");
        assertTrue(conciergeItemsScreen.getCheckoutButton().isDisplayed(), "Checkout button is displayed");
    }

    @When("I click on view cart button")
    public void iClickOnViewCartButton() {
        sleep(3000);
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeCartPageScreen.getItemAddedToYourCart().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getItemAddedToYourCart().shouldHave(text("Added To Your Cart"), Duration.ofSeconds(30));
        conciergeItemsScreen.getViewCartButton().shouldHave(text("View Cart"), Duration.ofSeconds(60));
        conciergeItemsScreen.getViewCartButton().should(visible, Duration.ofSeconds(60));
        conciergeCartPageScreen.getKeepShopping().should(visible, Duration.ofSeconds(15));
        conciergeItemsScreen.getViewCartButton().click();
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
        sleep(2000);
        $(By.xpath("//option[@value='" + randomQuantity + "']")).should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        $(By.xpath("//option[@value='" + randomQuantity + "']")).click();

    }

    @Then("I verify that quantity was updated")
    public void iVerifyThatQuantityWasUpdated() {
        conciergeUserAccountPage.getCartButton().getText().equals("CART " + randomQuantity);
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
        sleep(6000);
        $(By.xpath("//*[text()='Metal Box Frame Leaner Mirror']")).shouldNotBe(visible, Duration.ofMinutes(1));
    }

    @When("I click on total item line price")
    public void iClickOnTotalItemLinePrice() {
        conciergeCartPageScreen.getTotalMemberPrice().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getTotalMemberPrice().scrollIntoView(true);
        lineItemPriceValueBeforeOverride = conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", "").replaceAll("C", "");
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
        sleep(2000);
        executeJavaScript("arguments[0].value='';", conciergeCartPageScreen.getAdjustmentCodeField());
        sleep(2000);
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
            sleep(5000);
            conciergeCartPageScreen.getApplyPostponeShipBtn().click();
        }
    }

    @Then("I verify line items prices for {string}")
    public void iVerifyLineItemsPricesFor(String arg0) {
        sleep(3000);
        conciergeCartPageScreen.getTotalMemberPrice().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getReasonCodeField().shouldNot(visible, Duration.ofSeconds(15));
        if (arg0.equals("PERCENT_OFF")) {
            String lineItemPriceValueAfterOverride = conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll("\\$", "").replaceAll("C", "");
            float line = Float.parseFloat(lineItemPriceValueBeforeOverride) / 2;
            assertEquals(digitFormatDoubleZero.format(line), lineItemPriceValueAfterOverride);
        }
        if (arg0.equals("AMOUNT_OFF")) {
            String lineItemPriceValueAfterOverride = conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", "").replaceAll("C", "");
            int expectedValuePriceValue = Integer.parseInt(lineItemPriceValueBeforeOverride) - 50;
            assertEquals(expectedValuePriceValue, Integer.parseInt(lineItemPriceValueAfterOverride));
        }
        if (arg0.equals("AMOUNT_OVERRIDE")) {
            String lineItemPriceValueAfterOverride = conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", "").replaceAll("C", "");
            assertEquals(lineItemPriceValueAfterOverride, "50");
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

    @When("I click on remove button from price override")
    public void iClickOnRemoveButtonFromPriceOverride() {
        conciergeProjectScreen.getREMOVEbutton().should(visible, Duration.ofMinutes(1));
        conciergeProjectScreen.getREMOVEbutton().click();
    }

    @Then("I verify that price override was removed")
    public void iVerifyThatPriceOverrideWasRemoved() {
        String lineItemPriceValueAfterOverride = conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", "").replaceAll("C", "");
        assertEquals(lineItemPriceValueBeforeOverride, lineItemPriceValueAfterOverride, "Price override was removed");
    }

    @When("I click on UFD button from cart")
    public void iClickOnUFDButtonFromCart() {
        conciergeCartPageScreen.getUfdCartButton().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getUfdCartButton().scrollIntoView(true);
        conciergeCartPageScreen.getUfdCartButton().click();
    }

    @When("I click on apply promocode button")
    public void iClickOnApplyPromocodeButton() {
        generalStepDefs.waitForJSandJQueryToLoad();
        sleep(3000);
        conciergeCartPageScreen.getApplyPromocodeBtn().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getApplyPromocodeBtn().click();
    }

    @When("I introduces promo code {string} for promo codes field")
    public void iIntroducesPromoCodeForPromoCodesField(String promo) {
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
        conciergeCartPageScreen.getTotalAditionalProdDiscount().should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='$1,075.50']")).should(visible, Duration.ofSeconds(15));
    }

    @When("I choose POP for payment method")
    public void iChoosePOPForPaymentMethod() {
        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(1));
        sleep(2000);
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
        if (arg0.equals("displayed")) {
            conciergeCartPageScreen.getTotalAditionalProdDiscount().should(visible, Duration.ofMinutes(1));
            conciergeCartPageScreen.getTotalAditionalProdDiscount().scrollTo();
            $(By.xpath("//*[text()='$1,075.50']")).should(visible, Duration.ofMinutes(1));
        } else {
            conciergeCartPageScreen.getTotalAditionalProdDiscount().shouldNotBe(visible, Duration.ofMinutes(1));
        }
    }

    @Then("I verify that promo code was removed")
    public void iVerifyThatPromoCodeWasRemoved() {
        $(By.xpath("//*[text()='Members have the privilege of receiving 25% off full priced items or 20% off sale items, whichever is the best price. Tax, shipping and surcharges are not included in calculating discount. Not valid for gift cards, personalization and gift boxes.']")).shouldNotBe(visible, Duration.ofMinutes(1));
    }

    @When("I select size option {int} for item")
    public void iSelectSizeOptionForItem(int sizeValue) {
        generalStepDefs.waitForJSandJQueryToLoad();
        try {
            conciergeItemsScreen.getAddToCartButton().scrollTo();
            selectOption.getSelectSizeElement().should(Condition.and("", visible, enabled), Duration.ofSeconds(30));
            //selectOption.getSelectSizeElement().scrollIntoView(true);
            Select size = new Select(selectOption.getSelectSizeElement());
            size.selectByIndex(sizeValue);
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
        sleep(4000);
        conciergeProjectScreen.getProjectName().should(visible, Duration.ofSeconds(15));
        Select selectProjectName = new Select(conciergeProjectScreen.getProjectName());
        selectProjectName.selectByVisibleText("additemtocorrectspace");
    }

    @When("I choose {string} space from move to project pop up")
    public void iChooseSpaceFromMoveToProjectPopUp(String arg0) {
        sleep(4000);
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
        conciergeUserAccountPage.getCartButton().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeUserAccountPage.getCartButton().shouldHave(text("" + arg0), Duration.ofMinutes(1));
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
        conciergeCartPageScreen.getSoldToAddressTitle().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getBillingAddressTitle().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getShippingAddressTitle().should(visible, Duration.ofMinutes(1));
    }

    @And("I edit ship to, bill to, sold to addresses")
    public void iEditShipToBillToSoldToAddresses() {
        $(By.xpath("(//*[text()='Edit'])[1]")).click();
        checkoutAddressScreen.getCompanyNameField().should(visible, Duration.ofMinutes(1));
        generalStepDefs.clearField(checkoutAddressScreen.getCompanyNameField());
        checkoutAddressScreen.getCompanyNameField().setValue("changedCompanyNameSoldAddress");
        $(By.xpath("(//*[text()='Edit'])[10]")).scrollIntoView(true);
        $(By.xpath("(//*[text()='Edit'])[10]")).click();
        $(By.xpath("(//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input)[2]")).should(visible, Duration.ofMinutes(1));
        generalStepDefs.clearField($(By.xpath("(//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input)[2]")));
        $(By.xpath("(//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input)[2]")).setValue("changedCompanyNameBillingAddress");

        $(By.xpath("(//*[text()='Edit'])[1]")).click();
        $(By.xpath("(//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input)[3]")).should(visible, Duration.ofMinutes(1));
        generalStepDefs.clearField($(By.xpath("(//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input)[3]")));
        $(By.xpath("(//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input)[3]")).setValue("changedCompanyNameShippingAddress");

    }

    @Then("I verify that membership price displayed as total price")
    public void iVerifyThatMembershipPriceDisplayedAsTotalPrice() {
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
        conciergeCartPageScreen.getPostponeShipOnOrAfterDate().shouldHave(text("Ship on or after: "), Duration.ofMinutes(1));
    }

    @Then("I verify that gift box was added")
    public void iVerifyThatGiftBoxWasAdded() {
        conciergeCartPageScreen.getGiftBoxFee().should(visible, Duration.ofMinutes(1));
    }

    @When("I click on gift box button")
    public void iClickOnRemoveGiftBoxButton() {
        generalStepDefs.waitForJSandJQueryToLoad();
        sleep(5000);
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
        checkoutAddressScreen.getFirstNameInpt().should(visible, Duration.ofMinutes(1));
        checkoutAddressScreen.getFirstNameInpt().shouldHave(value("QA1"), Duration.ofMinutes(1));
        checkoutAddressScreen.getLastNameField().shouldHave(value("Automation"), Duration.ofMinutes(1));
    }

    @Then("I verify that monogram was added")
    public void iVerifyThatMonoramWasAdded() {
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
        sleep(2000);
        conciergeCartPageScreen.getMonogramFonts().get(2).scrollIntoView(true);
        conciergeCartPageScreen.getMonogramFonts().get(2).should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeCartPageScreen.getMonogramFonts().get(2).doubleClick();
        sleep(2000);
        conciergeCartPageScreen.getMonogramColors().get(2).should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getMonogramColors().get(2).scrollIntoView(true);
        conciergeCartPageScreen.getMonogramColors().get(2).doubleClick();
        conciergeCartPageScreen.getMonogramText().setValue("test");
        conciergeCartPageScreen.getAddMonogramButton().click();
    }

    @When("I edit monogram")
    public void iEditMonogram() {
        generalStepDefs.waitForJSandJQueryToLoad();
        sleep(2000);
        conciergeCartPageScreen.getEditMonogramButton().click();
        sleep(2000);
        conciergeCartPageScreen.getMonogramColors().get(5).should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getMonogramColors().get(5).doubleClick();
        conciergeCartPageScreen.getAddMonogramButton().should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getAddMonogramButton().click();
    }

    @Then("I verify that monogram was edited")
    public void iVerifyThatMonogramWasEdited() {
        $(By.xpath("//*[text()='Dark Silver Metallic (MDSL)']")).shouldHave(text("Dark Silver Metallic (MDSL)"), Duration.ofSeconds(30));
    }

    @When("I remove monogram")
    public void iRemoveMonogram() {
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeCartPageScreen.getRemoveMonogramBtn().shouldHave(text("Remove"), Duration.ofMinutes(1));
        sleep(6000);
        conciergeCartPageScreen.getRemoveMonogramBtn().click();
    }

    @Then("I verify that monogram was removed")
    public void iVerifyThatMonogramWasRemoved() {
        conciergeCartPageScreen.getPersonalizationText().shouldNotBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Bauer Bodoni 2 (BDNI-HD)']")).shouldNotBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Champagne Metallic (MCHA)']")).shouldNotBe(visible, Duration.ofMinutes(1));
    }

    @Then("I verify that availability, Delivery and Returns messaging in cart")
    public void iVerifyThatAvailabilityDeliveryAndReturnsMessagingInCart() {
        $(By.xpath("//*[contains(text(),'This item is in stock and will be ready for delivery between ')]")).should(visible, Duration.ofSeconds(10));
        $(By.xpath("//*[contains(text(),'This item can be returned within 30 days of delivery.')]")).should(visible, Duration.ofMinutes(1));
    }

    @Then("I verify alternate addresses for client with multipel addresses")
    public void iVerifyAlternateAddressesForClientWithMultipelAddresses() {
        $(By.xpath("//td[@class='MuiTableCell-root MuiTableCell-body'][2]")).should(visible, Duration.ofMinutes(1));
    }

    @Then("I verify membership popup for guest user")
    public void iVerifyMembershipPopupForGuestUser() {
        $(By.xpath("//*[text()='Join the RH Members Program for $175.00, and save ']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Your RH Membership immediately pays for itself.']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='BECOME A MEMBER NOW']")).should(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getNoThanksButton().should(visible, Duration.ofMinutes(1));
    }

    @Then("I verify that employee discount is present")
    public void iVerifyThatEmployeeDiscountIsPresent() {
        conciergeCartPageScreen.getTotalAditionalProdDiscount().shouldHave(text("Total Additional Product Discount"), Duration.ofSeconds(15));
        conciergeCartPageScreen.getTotalAditionalProdDiscount().should(Condition.and("", visible, enabled), Duration.ofSeconds(15));
    }

    @When("I apply employee discount")
    public void iApplyEmployeeDiscount() {
        generalStepDefs.waitForJSandJQueryToLoad();
        conciergeCartPageScreen.getUserNamePromocode().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeCartPageScreen.getUserNamePromocode().scrollIntoView(true);
        sleep(2000);
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
        sleep(3000);
        conciergeUserAccountPage.getCartButton().should(Condition.and("", visible, enabled), Duration.ofMinutes(1));
        conciergeUserAccountPage.getCartButton().shouldHave(text("" + randomQuantity), Duration.ofSeconds(50));
    }

    @When("I click on check balance button")
    public void iClickOnCheckBalanceButton() {
        conciergeCartPageScreen.getCheckBalanceButton().should(visible, Duration.ofSeconds(30));
        conciergeCartPageScreen.getCheckBalanceButton().scrollIntoView(true);
        conciergeCartPageScreen.getCheckBalanceButton().click();
    }

    @Then("I verify that balance info is displayed")
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
    }

    @Then("I verify that designed sold by")
    public void iVerifyThatDesignedSoldBy() {
        $(By.xpath("//*[text()='Designed/Sold By:']")).shouldBe(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='Automation Associate']")).shouldBe(visible, Duration.ofSeconds(15));
    }

    @When("I choose order classification")
    public void iChooseOrderClassification() {
        generalStepDefs.waitForJSandJQueryToLoad();
        Select selectOrder = new Select(conciergeCartPageScreen.getOrderClassificationSelect());
        conciergeCartPageScreen.getOrderClassificationSelect().selectOptionContainingText("Select an Option");
        conciergeCartPageScreen.getOrderClassificationSelect().shouldHave(text("Select an Option"), Duration.ofSeconds(5));
        sleep(7000);
        for (int i = 0; i < 10; i++) {
            selectOrder.selectByValue("RH Gallery Order");
            conciergeCartPageScreen.getOrderClassificationSelect().shouldHave(value("RH Gallery Order"), Duration.ofSeconds(5));
        }
        generalStepDefs.waitForJSandJQueryToLoad();
    }

    @Then("I verify contract savings")
    public void iVerifyContractSavingsForCartPage() {
        conciergeCartPageScreen.getContractSavings().should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='$897.00']")).should(visible, Duration.ofSeconds(20));
    }

    @When("I click on order details button")
    public void iClickOnOrderDetailsButton() {
        conciergeUserAccountPage.getOrderDetailsButton().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getOrderDetailsButton().click();
    }

    @When("I remove all items from cart for minicart")
    public void iRemoveAllItemsFromCartForMinicart() {
        conciergeUserAccountPage.getCartButton().should(visible, Duration.ofMinutes(1));
        //conciergeUserAccountPage.getCartButton().shouldHave(text("CART"), Duration.ofMinutes(1));
        sleep(3000);
        if (!conciergeUserAccountPage.getCartButton().getText().equals("")) {
            conciergeUserAccountPage.getCartButton().click();
            generalStepDefs.waitForJSandJQueryToLoad();
           // conciergeCartPageScreen.getCartTitle().shouldHave(text("CART"), Duration.ofSeconds(12));
            conciergeCartPageScreen.getClearOrderButton().scrollIntoView(true);
            conciergeCartPageScreen.getOrderEstimateTitle().shouldHave(text("Order Estimate"), Duration.ofSeconds(20));
            conciergeCartPageScreen.getClearOrderButton().click();
            conciergeCartPageScreen.getClearOrderButtonPop().shouldHave(text("CLEAR ORDER"), Duration.ofSeconds(25));
            conciergeCartPageScreen.getClearOrderButtonPop().click();
            generalStepDefs.waitForJSandJQueryToLoad();
        }
    }
    @When("I add item to cart via API")
    public void iAddItemToCartViaAPI() {

        if (Hooks.conciergeURL.contains("stg2")) {
            USER_ID = "4c5c1919-99d6-47a3-a0f5-7d5287911944";
            addItemEndpoint = "/concierge-bff-v1-stg2/graphql";
        } else  {
            addItemEndpoint = "/concierge-bff-v1/graphql";
            USER_ID = "3d6b15b6-eca1-4ef5-8c3c-cc39c6a2b8a8";
        }

        String cartId  = generalStepDefs.getCurrentCartId(USER_ID);
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.headers("Content-Type", "application/json");
        request.headers("Cookie", "PF_AEM_PATHS=%5E%2F(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~IN%7C~IN)%7C(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~R%7C~R)%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)R)H%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)OD%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)IN%7C(%3F%3A(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)%7Cgift-registry~)MO%7Cinterior-design~BC%7Cgift-registry~RH%7Cstrada-ledoux~MO)%24; endpoint=develop; fusion_search=true; ui_asset_path=/concierge-ui-v1/");
        response = request.body("{\n" +
                "    \"operationName\": \"addLineItemsToConciergeCart\",\n" +
                "    \"variables\": {\n" +
                "        \"email\": \""+USEREMAIL+"\",\n" +
                "        \"cartId\": \""+ cartId +"\",\n" +
                "        \"lineItemsInput\": {\n" +
                "            \"items\": [\n" +
                "                {\n" +
                "                    \"sku\": \"63130001 GREY\",\n" +
                "                    \"quantity\": 1,\n" +
                "                    \"brand\": \"RH\",\n" +
                "                    \"giftTo\": \"\",\n" +
                "                    \"giftFrom\": \"\",\n" +
                "                    \"giftMessage\": \"\",\n" +
                "                    \"productId\": \"prod1617188\",\n" +
                "                    \"spoTermsAccepted\": false,\n" +
                "                    \"spoTerms\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    },\n" +
                "    \"query\": \"mutation addLineItemsToConciergeCart($email: String!, $cartId: String!, $lineItemsInput: ConciergeLineItemsInput!) {\\n  addLineItemsToConciergeCart(\\n    email: $email\\n    cartId: $cartId\\n    lineItemsInput: $lineItemsInput\\n  ) {\\n    ...Cart\\n  }\\n}\\n\\nfragment Cart on ConciergeCartType {\\n  __typename\\n  id\\n  requestedDeliveryDate\\n  requestedDeliveryDateReason\\n  postalCode\\n  country\\n  coordGroupType\\n  coordGroupGroupable\\n  coordGroupUserSelected\\n  orderNumber\\n  memberSavings\\n  cartSavings\\n  memberPrice\\n  isUserMember\\n  giftBoxFee\\n  hasGiftBox\\n  hasGiftFromRegistry\\n  giftRegistryIdList\\n  totalItemQuantity\\n  totalLines\\n  containsMembership\\n  guest {\\n    userId\\n    ctId\\n    atgUserId\\n    cwUserId\\n    email\\n    type\\n    typeId\\n    sourceCode\\n  }\\n  lineItems {\\n    giftFrom\\n    giftTo\\n    notes\\n    childSafety\\n    personalizeInfo {\\n      feeHigh\\n      feeLow\\n      selectedFont {\\n        id\\n        displayName\\n        previewImage\\n        image\\n        borders {\\n          id\\n        }\\n      }\\n      selectedBorder {\\n        id\\n        image\\n        displayName\\n        minLength\\n        maxLength\\n        numberOfLines\\n      }\\n      selectedStyle {\\n        id\\n        image\\n        minLength\\n        maxLength\\n        numberOfLines\\n        displayName\\n        previewImage\\n      }\\n      selectedColor {\\n        id\\n        displayName\\n        image\\n      }\\n    }\\n    isMonogramFee\\n    shouldWaiveMonogramFee\\n    shipVia\\n    shipViaCode\\n    isMonogrammable\\n    isPersonalizable\\n    monogram {\\n      styleId\\n      description\\n      maxLines\\n      fontCode\\n      fontColorCode\\n      borderCode\\n      lines\\n      fulfillmentCode\\n    }\\n    lineId\\n    quantity\\n    maxCartQuantity\\n    sku\\n    skuType\\n    brand\\n    displayName\\n    giftBoxDetail {\\n      giftBoxFee\\n      giftBoxCurrencyCode\\n    }\\n    giftWrap\\n    deliveryEta\\n    deliveryEtaStart\\n    deliveryEtaEnd\\n    coordGroup\\n    registryId\\n    spoTerms\\n    spoTermsAccepted\\n    spoTermsAcceptedDate\\n    isMembershipSku\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n    }\\n    availabilityInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n      }\\n    }\\n    deliveryInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n      }\\n    }\\n    productId\\n    product {\\n      displayName\\n      imageUrl\\n      targetUrl\\n      restrictions {\\n        spo\\n        returnPolicyMessage\\n        countryRestrictions\\n        mattressFeeLocation\\n        preBillMessage\\n        additionalMessages {\\n          curbsideMessage\\n          assemblyMessage\\n          giftCardMessage\\n          railroadMessage\\n          mattressFeeMessage\\n          cancellableMessage\\n          finalSaleMessage\\n        }\\n      }\\n    }\\n    price {\\n      itemPrice\\n      memberPrice\\n      discountPrice\\n      originalPrice\\n      overridePrice\\n      finalPrice\\n      priceStatus\\n      currencyCode\\n      totalPrice\\n      salePrice\\n      salePriceLabel\\n      priceType\\n      isOnClearance\\n      isOnSale\\n      showMemberPrice\\n      fees\\n      priceAdjustment {\\n        adjustment\\n        adjustmentType\\n        reason\\n        targetType\\n      }\\n      discounts {\\n        code\\n        name\\n        discountAmount\\n      }\\n    }\\n    options {\\n      type\\n      value\\n    }\\n    isGiftFromRegistry\\n    linkedLineItemId\\n    skuCustomization {\\n      type\\n      mountType\\n      lining\\n      panel\\n      controlType\\n      controlPosition\\n      controlLength\\n      tiltType\\n      controlAndTilt\\n      trim\\n      width\\n      length\\n      diameter\\n      roomLabel\\n      bracketColor\\n      rollType\\n      fulfillmentCode\\n    }\\n    galleryProjectId\\n    referenceId\\n    type\\n    tSSItem\\n    tSSInstallation\\n    skuRestrictions {\\n      spo\\n      membershipSku\\n      returnPolicyMessage\\n      restockingFee\\n      countryRestrictions\\n      mattressFeeLocation\\n      preBillMessage\\n      additionalMessages {\\n        curbsideMessage\\n        assemblyMessage\\n        giftCardMessage\\n        railroadMessage\\n        mattressFeeMessage\\n        cancellableMessage\\n        finalSaleMessage\\n      }\\n    }\\n    availabilityStatus\\n  }\\n  shipVia\\n  cartPrice {\\n    subtotal\\n    tax\\n    taxDetail {\\n      amount\\n      name\\n      country\\n      state\\n      imposition\\n      rate\\n    }\\n    totalPrice\\n    feeTotal\\n    currencyCode\\n    isFree\\n    fees {\\n      feeType\\n      quantity\\n      value\\n      unitCost\\n      linkedLineItemId\\n    }\\n    freightPrice {\\n      unlimitedFurnitureDelivery\\n      ground\\n      next\\n      second\\n      currency\\n      zoneCode\\n      surcharge\\n      shippingSurcharge\\n    }\\n    priceAdjustments {\\n      adjustment\\n      adjustmentType\\n      reason\\n      targetType\\n      adjustedPrice\\n      priceBeforeAdjustment\\n    }\\n  }\\n  soldToAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    companyName\\n    postalCode\\n    eveningPhone\\n    phone\\n    email\\n    firstName\\n    lastName\\n  }\\n  shipAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    companyName\\n    postalCode\\n    eveningPhone\\n    phone\\n    email\\n    firstName\\n    lastName\\n  }\\n  billAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    companyName\\n    postalCode\\n    phone\\n    email\\n    firstName\\n    lastName\\n  }\\n  payments {\\n    totalAmountRemaining\\n    totalAmountCovered\\n    appliedPayments {\\n      id\\n      paymentMethodType\\n      paymentType\\n      lastFour\\n      amountCovered\\n      currencyCode\\n      rhPaymentPlan\\n    }\\n  }\\n  importantInformation {\\n    type\\n    displayText\\n  }\\n  brand\\n  gallery {\\n    ctId\\n    designerCart\\n    galleryId\\n    key\\n    orderClassification\\n  }\\n  shipLabelSidemark\\n  giftMessage\\n  emailOverride\\n  commissions {\\n    available\\n    salesAttributions {\\n      agentLogin\\n      agentName\\n      percentage\\n      primary\\n    }\\n    total\\n  }\\n  discountCodes {\\n    code\\n    name\\n    description\\n  }\\n  shipRestrictedLineItems {\\n    displayName\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n    }\\n  }\\n  billRestrictedLineItems {\\n    displayName\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n    }\\n  }\\n  tSSEligible\\n  tSSApplied\\n  tSSFee\\n  taxExemptId\\n  totalAdditionalDiscount\\n}\\n\"\n" +
                "}").post(addItemEndpoint);

        String jsonString = response.asString();
        id = JsonPath.from(jsonString).get("id");
    }

    @When("I remove all items from cart via API")
    public void iRemoveAllItemsFromCartViaAPI() {

        if (BASE_URL.contains("stg2")) {
            USER_ID = "4c5c1919-99d6-47a3-a0f5-7d5287911944";
            addItemEndpoint = "/concierge-bff-v1-stg2/graphql";
        } else  {
            addItemEndpoint = "/concierge-bff-v1/graphql";
            USER_ID = "3d6b15b6-eca1-4ef5-8c3c-cc39c6a2b8a8";
        }

        String cartId  = generalStepDefs.getCurrentCartId(USER_ID);
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.headers("Content-Type", "application/json");
        request.headers("Cookie", "PF_AEM_PATHS=%5E%2F(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~IN%7C~IN)%7C(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~R%7C~R)%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)R)H%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)OD%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)IN%7C(%3F%3A(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)%7Cgift-registry~)MO%7Cinterior-design~BC%7Cgift-registry~RH%7Cstrada-ledoux~MO)%24; endpoint=develop; fusion_search=true; ui_asset_path=/concierge-ui-v1/");
        response = request.body("{\n" +
                "    \"operationName\": \"removeLineItemFromConciergeCart\",\n" +
                "    \"variables\": {\n" +
                "        \"lineId\": \"null\",\n" +
                "        \"email\": \""+USEREMAIL+"\",\n" +
                "        \"cartId\": \""+cartId+"\",\n" +
                "        \"hasMonogram\": false\n" +
                "    },\n" +
                "    \"query\": \"mutation removeLineItemFromConciergeCart($lineId: String!, $cartId: String!, $email: String!, $hasMonogram: Boolean!) {\\n  removeLineItemFromConciergeCart(\\n    lineId: $lineId\\n    cartId: $cartId\\n    email: $email\\n    hasMonogram: $hasMonogram\\n  ) {\\n    ...Cart\\n  }\\n}\\n\\nfragment Cart on ConciergeCartType {\\n  __typename\\n  id\\n  requestedDeliveryDate\\n  requestedDeliveryDateReason\\n  postalCode\\n  country\\n  coordGroupType\\n  coordGroupGroupable\\n  coordGroupUserSelected\\n  orderNumber\\n  memberSavings\\n  cartSavings\\n  memberPrice\\n  isUserMember\\n  giftBoxFee\\n  hasGiftBox\\n  hasGiftFromRegistry\\n  giftRegistryIdList\\n  totalItemQuantity\\n  totalLines\\n  containsMembership\\n  guest {\\n    userId\\n    ctId\\n    atgUserId\\n    cwUserId\\n    email\\n    type\\n    typeId\\n    sourceCode\\n  }\\n  lineItems {\\n    giftFrom\\n    giftTo\\n    notes\\n    childSafety\\n    personalizeInfo {\\n      feeHigh\\n      feeLow\\n      selectedFont {\\n        id\\n        displayName\\n        previewImage\\n        image\\n        borders {\\n          id\\n        }\\n      }\\n      selectedBorder {\\n        id\\n        image\\n        displayName\\n        minLength\\n        maxLength\\n        numberOfLines\\n      }\\n      selectedStyle {\\n        id\\n        image\\n        minLength\\n        maxLength\\n        numberOfLines\\n        displayName\\n        previewImage\\n      }\\n      selectedColor {\\n        id\\n        displayName\\n        image\\n      }\\n    }\\n    isMonogramFee\\n    shouldWaiveMonogramFee\\n    shipVia\\n    shipViaCode\\n    isMonogrammable\\n    isPersonalizable\\n    monogram {\\n      styleId\\n      description\\n      maxLines\\n      fontCode\\n      fontColorCode\\n      borderCode\\n      lines\\n      fulfillmentCode\\n    }\\n    lineId\\n    quantity\\n    maxCartQuantity\\n    sku\\n    skuType\\n    brand\\n    displayName\\n    giftBoxDetail {\\n      giftBoxFee\\n      giftBoxCurrencyCode\\n    }\\n    giftWrap\\n    deliveryEta\\n    deliveryEtaStart\\n    deliveryEtaEnd\\n    coordGroup\\n    registryId\\n    spoTerms\\n    spoTermsAccepted\\n    spoTermsAcceptedDate\\n    isMembershipSku\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n    }\\n    availabilityInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n      }\\n    }\\n    deliveryInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n      }\\n    }\\n    productId\\n    product {\\n      displayName\\n      imageUrl\\n      targetUrl\\n      restrictions {\\n        spo\\n        returnPolicyMessage\\n        countryRestrictions\\n        mattressFeeLocation\\n        preBillMessage\\n        additionalMessages {\\n          curbsideMessage\\n          assemblyMessage\\n          giftCardMessage\\n          railroadMessage\\n          mattressFeeMessage\\n          cancellableMessage\\n          finalSaleMessage\\n        }\\n      }\\n    }\\n    price {\\n      itemPrice\\n      memberPrice\\n      discountPrice\\n      originalPrice\\n      overridePrice\\n      finalPrice\\n      priceStatus\\n      currencyCode\\n      totalPrice\\n      salePrice\\n      salePriceLabel\\n      priceType\\n      isOnClearance\\n      isOnSale\\n      showMemberPrice\\n      fees\\n      priceAdjustment {\\n        adjustment\\n        adjustmentType\\n        reason\\n        targetType\\n      }\\n      discounts {\\n        code\\n        name\\n        discountAmount\\n      }\\n    }\\n    options {\\n      type\\n      value\\n    }\\n    isGiftFromRegistry\\n    linkedLineItemId\\n    skuCustomization {\\n      type\\n      mountType\\n      lining\\n      panel\\n      controlType\\n      controlPosition\\n      controlLength\\n      tiltType\\n      controlAndTilt\\n      trim\\n      width\\n      length\\n      diameter\\n      roomLabel\\n      bracketColor\\n      rollType\\n      fulfillmentCode\\n    }\\n    galleryProjectId\\n    referenceId\\n    type\\n    tSSItem\\n    tSSInstallation\\n    skuRestrictions {\\n      spo\\n      membershipSku\\n      returnPolicyMessage\\n      restockingFee\\n      countryRestrictions\\n      mattressFeeLocation\\n      preBillMessage\\n      additionalMessages {\\n        curbsideMessage\\n        assemblyMessage\\n        giftCardMessage\\n        railroadMessage\\n        mattressFeeMessage\\n        cancellableMessage\\n        finalSaleMessage\\n      }\\n    }\\n    availabilityStatus\\n  }\\n  shipVia\\n  cartPrice {\\n    subtotal\\n    tax\\n    taxDetail {\\n      amount\\n      name\\n      country\\n      state\\n      imposition\\n      rate\\n    }\\n    totalPrice\\n    feeTotal\\n    currencyCode\\n    isFree\\n    fees {\\n      feeType\\n      quantity\\n      value\\n      unitCost\\n      linkedLineItemId\\n    }\\n    freightPrice {\\n      unlimitedFurnitureDelivery\\n      ground\\n      next\\n      second\\n      currency\\n      zoneCode\\n      surcharge\\n      shippingSurcharge\\n    }\\n    priceAdjustments {\\n      adjustment\\n      adjustmentType\\n      reason\\n      targetType\\n      adjustedPrice\\n      priceBeforeAdjustment\\n    }\\n  }\\n  soldToAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    companyName\\n    postalCode\\n    eveningPhone\\n    phone\\n    email\\n    firstName\\n    lastName\\n  }\\n  shipAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    companyName\\n    postalCode\\n    eveningPhone\\n    phone\\n    email\\n    firstName\\n    lastName\\n  }\\n  billAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    companyName\\n    postalCode\\n    phone\\n    email\\n    firstName\\n    lastName\\n  }\\n  payments {\\n    totalAmountRemaining\\n    totalAmountCovered\\n    appliedPayments {\\n      id\\n      paymentMethodType\\n      paymentType\\n      lastFour\\n      amountCovered\\n      currencyCode\\n      rhPaymentPlan\\n    }\\n  }\\n  importantInformation {\\n    type\\n    displayText\\n  }\\n  brand\\n  gallery {\\n    ctId\\n    designerCart\\n    galleryId\\n    key\\n    orderClassification\\n  }\\n  shipLabelSidemark\\n  giftMessage\\n  emailOverride\\n  commissions {\\n    available\\n    salesAttributions {\\n      agentLogin\\n      agentName\\n      percentage\\n      primary\\n    }\\n    total\\n  }\\n  discountCodes {\\n    code\\n    name\\n    description\\n  }\\n  shipRestrictedLineItems {\\n    displayName\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n    }\\n  }\\n  billRestrictedLineItems {\\n    displayName\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n    }\\n  }\\n  tSSEligible\\n  tSSApplied\\n  tSSFee\\n  taxExemptId\\n  totalAdditionalDiscount\\n}\\n\"\n" +
                "}").post(addItemEndpoint);

        String jsonString = response.asString();
    }

    @When("I clear order via API")
    public void iClearOrderViaAPI() {

        if (BASE_URL.contains("stg2")) {
            USER_ID = "4c5c1919-99d6-47a3-a0f5-7d5287911944";
            addItemEndpoint = "/concierge-bff-v1-stg2/graphql";
        } else  {
            addItemEndpoint = "/concierge-bff-v1/graphql";
            USER_ID = "3d6b15b6-eca1-4ef5-8c3c-cc39c6a2b8a8";
        }

        String cartId  = generalStepDefs.getCurrentCartId(USER_ID);
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.headers("Content-Type", "application/json");
        request.headers("Cookie", "PF_AEM_PATHS=%5E%2F(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~IN%7C~IN)%7C(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~R%7C~R)%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)R)H%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)OD%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)IN%7C(%3F%3A(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)%7Cgift-registry~)MO%7Cinterior-design~BC%7Cgift-registry~RH%7Cstrada-ledoux~MO)%24; endpoint=develop; fusion_search=true; ui_asset_path=/concierge-ui-v1/");
        response = request.body("{\n" +
                "    \"operationName\": \"clearOrder\",\n" +
                "    \"variables\": {\n" +
                "        \"email\": \""+USEREMAIL+"\",\n" +
                "        \"cartId\": \""+cartId+"\"\n" +
                "    },\n" +
                "    \"query\": \"mutation clearOrder($email: String!, $cartId: String!) {\\n  clearOrder(email: $email, cartId: $cartId) {\\n    ...Cart\\n  }\\n}\\n\\nfragment Cart on ConciergeCartType {\\n  __typename\\n  id\\n  requestedDeliveryDate\\n  requestedDeliveryDateReason\\n  postalCode\\n  country\\n  coordGroupType\\n  coordGroupGroupable\\n  coordGroupUserSelected\\n  orderNumber\\n  memberSavings\\n  cartSavings\\n  memberPrice\\n  isUserMember\\n  giftBoxFee\\n  hasGiftBox\\n  hasGiftFromRegistry\\n  giftRegistryIdList\\n  totalItemQuantity\\n  totalLines\\n  containsMembership\\n  guest {\\n    userId\\n    ctId\\n    atgUserId\\n    cwUserId\\n    email\\n    type\\n    typeId\\n    sourceCode\\n  }\\n  lineItems {\\n    giftFrom\\n    giftTo\\n    notes\\n    childSafety\\n    personalizeInfo {\\n      feeHigh\\n      feeLow\\n      selectedFont {\\n        id\\n        displayName\\n        previewImage\\n        image\\n        borders {\\n          id\\n        }\\n      }\\n      selectedBorder {\\n        id\\n        image\\n        displayName\\n        minLength\\n        maxLength\\n        numberOfLines\\n      }\\n      selectedStyle {\\n        id\\n        image\\n        minLength\\n        maxLength\\n        numberOfLines\\n        displayName\\n        previewImage\\n      }\\n      selectedColor {\\n        id\\n        displayName\\n        image\\n      }\\n    }\\n    isMonogramFee\\n    shouldWaiveMonogramFee\\n    shipVia\\n    shipViaCode\\n    isMonogrammable\\n    isPersonalizable\\n    monogram {\\n      styleId\\n      description\\n      maxLines\\n      fontCode\\n      fontColorCode\\n      borderCode\\n      lines\\n      fulfillmentCode\\n    }\\n    lineId\\n    quantity\\n    maxCartQuantity\\n    sku\\n    skuType\\n    brand\\n    displayName\\n    giftBoxDetail {\\n      giftBoxFee\\n      giftBoxCurrencyCode\\n    }\\n    giftWrap\\n    deliveryEta\\n    deliveryEtaStart\\n    deliveryEtaEnd\\n    coordGroup\\n    registryId\\n    spoTerms\\n    spoTermsAccepted\\n    spoTermsAcceptedDate\\n    isMembershipSku\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n    }\\n    availabilityInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n      }\\n    }\\n    deliveryInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n      }\\n    }\\n    productId\\n    product {\\n      displayName\\n      imageUrl\\n      targetUrl\\n      restrictions {\\n        spo\\n        returnPolicyMessage\\n        countryRestrictions\\n        mattressFeeLocation\\n        preBillMessage\\n        additionalMessages {\\n          curbsideMessage\\n          assemblyMessage\\n          giftCardMessage\\n          railroadMessage\\n          mattressFeeMessage\\n          cancellableMessage\\n          finalSaleMessage\\n        }\\n      }\\n    }\\n    price {\\n      itemPrice\\n      memberPrice\\n      discountPrice\\n      originalPrice\\n      overridePrice\\n      finalPrice\\n      priceStatus\\n      currencyCode\\n      totalPrice\\n      salePrice\\n      salePriceLabel\\n      priceType\\n      isOnClearance\\n      isOnSale\\n      showMemberPrice\\n      fees\\n      priceAdjustment {\\n        adjustment\\n        adjustmentType\\n        reason\\n        targetType\\n      }\\n      discounts {\\n        code\\n        name\\n        discountAmount\\n      }\\n    }\\n    options {\\n      type\\n      value\\n    }\\n    isGiftFromRegistry\\n    linkedLineItemId\\n    skuCustomization {\\n      type\\n      mountType\\n      lining\\n      panel\\n      controlType\\n      controlPosition\\n      controlLength\\n      tiltType\\n      controlAndTilt\\n      trim\\n      width\\n      length\\n      diameter\\n      roomLabel\\n      bracketColor\\n      rollType\\n      fulfillmentCode\\n    }\\n    galleryProjectId\\n    referenceId\\n    type\\n    tSSItem\\n    tSSInstallation\\n    skuRestrictions {\\n      spo\\n      membershipSku\\n      returnPolicyMessage\\n      restockingFee\\n      countryRestrictions\\n      mattressFeeLocation\\n      preBillMessage\\n      additionalMessages {\\n        curbsideMessage\\n        assemblyMessage\\n        giftCardMessage\\n        railroadMessage\\n        mattressFeeMessage\\n        cancellableMessage\\n        finalSaleMessage\\n      }\\n    }\\n    availabilityStatus\\n  }\\n  shipVia\\n  cartPrice {\\n    subtotal\\n    tax\\n    taxDetail {\\n      amount\\n      name\\n      country\\n      state\\n      imposition\\n      rate\\n    }\\n    totalPrice\\n    feeTotal\\n    currencyCode\\n    isFree\\n    fees {\\n      feeType\\n      quantity\\n      value\\n      unitCost\\n      linkedLineItemId\\n    }\\n    freightPrice {\\n      unlimitedFurnitureDelivery\\n      ground\\n      next\\n      second\\n      currency\\n      zoneCode\\n      surcharge\\n      shippingSurcharge\\n    }\\n    priceAdjustments {\\n      adjustment\\n      adjustmentType\\n      reason\\n      targetType\\n      adjustedPrice\\n      priceBeforeAdjustment\\n    }\\n  }\\n  soldToAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    companyName\\n    postalCode\\n    eveningPhone\\n    phone\\n    email\\n    firstName\\n    lastName\\n  }\\n  shipAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    companyName\\n    postalCode\\n    eveningPhone\\n    phone\\n    email\\n    firstName\\n    lastName\\n  }\\n  billAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    companyName\\n    postalCode\\n    phone\\n    email\\n    firstName\\n    lastName\\n  }\\n  payments {\\n    totalAmountRemaining\\n    totalAmountCovered\\n    appliedPayments {\\n      id\\n      paymentMethodType\\n      paymentType\\n      lastFour\\n      amountCovered\\n      currencyCode\\n      rhPaymentPlan\\n    }\\n  }\\n  importantInformation {\\n    type\\n    displayText\\n  }\\n  brand\\n  gallery {\\n    ctId\\n    designerCart\\n    galleryId\\n    key\\n    orderClassification\\n  }\\n  shipLabelSidemark\\n  giftMessage\\n  emailOverride\\n  commissions {\\n    available\\n    salesAttributions {\\n      agentLogin\\n      agentName\\n      percentage\\n      primary\\n    }\\n    total\\n  }\\n  discountCodes {\\n    code\\n    name\\n    description\\n  }\\n  shipRestrictedLineItems {\\n    displayName\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n    }\\n  }\\n  billRestrictedLineItems {\\n    displayName\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n    }\\n  }\\n  tSSEligible\\n  tSSApplied\\n  tSSFee\\n  taxExemptId\\n  totalAdditionalDiscount\\n}\\n\"\n" +
                "}").post(addItemEndpoint);

        String jsonString = response.asString();
        id = JsonPath.from(jsonString).get("id");
        WebDriverRunner.getWebDriver().navigate().refresh();
    }
}
