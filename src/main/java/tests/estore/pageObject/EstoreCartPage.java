package tests.estore.pageObject;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import tests.utility.Hooks;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.AssertJUnit.assertTrue;

@Getter
public class EstoreCartPage {

    EstoreItemPage estoreItemPage = new EstoreItemPage();

    private SelenideElement specialOrdertext = $(By.xpath("//*[text()='Special Order']"));

    private SelenideElement termsOfSaletext = $(By.xpath("//*[text()='Terms of Sale']"));

    private SelenideElement spoPanelTermsOfUseLink = $(By.xpath("//a[@href='/OUR-COMPANY/TERMS-OF-USE']"));

    private SelenideElement spoPanelItemName = $(By.xpath("//*[text()='ORIGINAL LANCASTER THREE-SEAT-CUSHION U-CHAISE SECTIONAL']"));

    private SelenideElement confirmChangeCaZipCode = $(By.xpath("//button//span[text()='CONFIRM CHANGE']"));

    private SelenideElement postalCodeCountrySelection = $(By.xpath("//div[@id='country-zipcode-selection']"));

    private SelenideElement postalCodeCASelection = $(By.xpath("//li[@data-value='CA']"));

    private SelenideElement acceptDiscountReminders = $(By.xpath("//button//span[text()='Accept']"));

    private SelenideElement rhMemberProgramTitle = $(By.xpath("//*[text()='Rh Members Program']"));

    private final SelenideElement becomeAmemberButton = $(By.id("addToCartMembershipDialog_becomeMember-btn"));

    private SelenideElement postalCodeButton = $(By.xpath("//*[@id='component-order-summary']//span"));

    private final SelenideElement joinNowCartEstoreButton = $(By.xpath("//*[text() = 'JOIN NOW']"));

    private final String variableJoinButton = "//*[text() = '%s']";

    private final SelenideElement removeMembershipButton = $(By.xpath("//*[text()='REMOVE MEMBERSHIP']"));

    private final SelenideElement joinNowMembershipButton = $(By.xpath("//div[@ctaname='Join Now']//button"));

    private final SelenideElement rhMemberFooterLink = $(By.xpath("//a[@href='/membership']"));

    private final SelenideElement orderClassificationGalleryOrder = $(By.xpath("//option[@value='RH Gallery Order']"));

    private final SelenideElement orderClassificationResidentialTrade = $(By.xpath("//option[@value='RH Residential Trade']"));

    private final SelenideElement orderClassificationInteriorDesign = $(By.xpath("//option[@value='RH Interior Design']"));

    private final SelenideElement arlesRectangularDinigTableId = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12']/div/div/div[1]//p[@id='listColumn2-Item#']"));

    private final SelenideElement shoppingCartEmpty = $(By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1']"));

    private final SelenideElement pleaseContinueBrowsingButton = $(By.xpath("//div[@id='spa-root']/div/main//a"));

    private final SelenideElement arlesRectangularDinigTableTitle = $(By.xpath("//h3[normalize-space()='Arles Rectangular Dining Table']"));

    private final SelenideElement gramTurkishTowel = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12']/div/div/div[2]//p[@id='listColumn2-Item#']"));

    private final SelenideElement gramTurkishTitle = $(By.xpath("//h3[normalize-space()='802-Gram Turkish Towel Collection']"));

    private final SelenideElement orderClassificationSelect = $(By.id("element-orderclassification"));

    private final SelenideElement membersProgramTitle = $(By.xpath("//h2[@class='MuiTypography-root MuiTypography-h2 MuiTypography-noWrap']"));

    private final SelenideElement closePopUp = $(By.xpath("//button[@data-testid='form-dialog-close-button']"));

    private final SelenideElement updateButton = $(By.xpath("//*[text()='UPDATE']"));

    private final SelenideElement agreeTermsForSaleCheckbox = $(By.xpath("//*[text()='I agree to the Terms of Sale for Special Orders.']"));

    private final SelenideElement colorCloseButton = $(By.xpath("//div[@class='MuiDialogTitle-root']/button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit']"));

    private final SelenideElement noThanksButton = $(By.cssSelector("#dialog-rh-membership_no-thanks-button"));

    private final SelenideElement becomeAmemberNow = $(By.xpath("//*[text()='BECOME A MEMBER NOW']"));

    private final SelenideElement orderEstimateTitle = $(By.xpath("//*[text()='Order Estimate']"));

    private final SelenideElement adjustmentCodeField = $(By.xpath("//input[@id='adjustment']"));

    private final SelenideElement reasonCodeField = $(By.xpath("//select[@id='reason_code']"));

    private final SelenideElement selectQuantity = $(By.xpath("//select[contains(@id,'quantity')]"));

    private final SelenideElement removeButton = $(By.xpath("//*[text()='Remove']"));

    private final SelenideElement estoreCartButton = $(By.xpath("//a[@href='/us/en/checkout/shopping_cart.jsp']"));

    private final SelenideElement cartButtonOrderReview = $(By.xpath("(//a[@href='/checkout/shopping_cart.jsp'])[2]"));

    private final SelenideElement cartTitle = $(By.xpath("//*[text()='CART']"));

    private final SelenideElement clearOrderButton = $(By.xpath("//div[@class='MuiGrid-root']//a"));

    private final SelenideElement addMonogramButton = $(By.xpath("//*[text()='add monogram']"));

    private final SelenideElement monogramText = $(By.xpath("//input[@data-testid='monogram-input0']"));

    private final SelenideElement checkBalanceButton = $(By.xpath("//*[text()='Check balance']"));

    private final SelenideElement tradeSavingsText = $(By.xpath("//*[text()='Trade savings']"));

    private final SelenideElement memberSavingsText = $(By.xpath("//*[text()='Member Savings']"));

    private final SelenideElement clearOrderButtonPop = $(By.xpath("//*[text()='CLEAR ORDER']"));

    private final List<SelenideElement> monogramFonts = $$(By.xpath("(//ul[@class='MuiGridList-root'])[1]//li[@class='MuiGridListTile-root']"));

    private final List<SelenideElement> monogramColors = $$(By.xpath("(//ul[@class='MuiGridList-root'])[2]//li[@class='MuiGridListTile-root']"));

    private final SelenideElement removeMonogramBtn = $(By.xpath("//p[contains(@class,'MuiTypography-root MuiLink-root')][2]"));

    private final SelenideElement userNamePromocode = $(By.xpath("//input[@autocomplete='new-username']"));

    private final SelenideElement userNameEmployeeDiscount = $(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[2]"));

    private final SelenideElement passwordEmployeeDiscount = $(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[3]"));

    private final SelenideElement passwordPromocde = $(By.xpath("//input[@type='password']"));

    private final SelenideElement acceptButton = $(By.xpath("//*[text()='Accept']"));

    private final SelenideElement keepShopping = $(By.xpath("//*[text()='Keep Shopping']"));

    private final SelenideElement applyEmpDiscountBtn = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-4']//button)[2]"));

    private final SelenideElement applyPromocodeBtn = $(By.xpath("(//*[text()='Apply'])[1]"));

    private final SelenideElement itemAddedToYourCart = $(By.xpath("//*[text()='1 Item Added To Your Cart']"));

    private final SelenideElement promotionCodeField = $(By.xpath("(//div[contains(@class,'MuiFormControl-root')])[2]//input"));

    private final SelenideElement ufdCartButton = $(By.xpath("//*[text()='Unlimited Furniture Delivery']"));

    private final SelenideElement rhMembershipProgramTitle = $(By.xpath("//*[text()='Rh Members Program']"));

    private final SelenideElement personalizationText = $(By.xpath("//*[text()='PERSONALIZATION']"));

    private final SelenideElement editMonogramButton = $(By.cssSelector("div:nth-child(2) > p:nth-child(3)"));

    private final SelenideElement posTransactionField = $(By.xpath("(//div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root')]/input)[1]"));

    private final SelenideElement posRegisterField = $(By.xpath("(//div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root')]/input)[2]"));

    private final SelenideElement totalMemberPrice = $(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-alignRight']"));

    private final SelenideElement priceForMember = $(By.xpath("//p[@data-testid='price-for-member']"));

    private final SelenideElement finalSalePrice = $(By.xpath("//p[@data-testid='price-for-final-sale']"));

    private final SelenideElement tradeSalePrice = $(By.xpath("//p[@data-testid='price-for-trade']"));

    private final SelenideElement postponeShipment = $(By.xpath("//p[@id='postpone-shipment']"));

    private final SelenideElement postponeSelectReasonCode = $(By.xpath("//select[@id='data_reason_code']"));

    private final SelenideElement postponeShipOnOrAfterDate = $(By.xpath("//p[@id='ship-on-or-after-date']"));

    private final SelenideElement soldToAddressTitle = $(By.xpath("//*[text()='Sold To Address']"));

    private final SelenideElement billingAddressTitle = $(By.xpath("//*[text()='Billing Address']"));

    private final SelenideElement shippingAddressTitle = $(By.xpath("//*[text()='Shipping Address']"));

    private final SelenideElement joinNow = $(By.xpath("(//*[@id='addToCartMembershipDialog_becomeMember-link'])[1]"));

    private final SelenideElement applyUpperCaseBtn = $(By.xpath("//*[text()='APPLY']"));

    private final SelenideElement rhGiftCardBalance = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item'][1]/p"));

    private final SelenideElement spaceDropDown = $(By.xpath("//div[1]/button//div[contains(@class,'MuiGrid-root MuiGrid-container')]"));

    private final SelenideElement giftBoxFee = $(By.xpath("//*[text()='Gift Box Fee']"));

    private final SelenideElement memberLabel = $(By.xpath("//p[@data-testid='price-label-member']"));

    private final SelenideElement memberPrice = $(By.xpath("//p[@data-testid='price-for-member']"));

    private final SelenideElement zipCodeField = $(By.xpath("//*[@id='postal-code-international']"));

    private final SelenideElement regularItemPrice = $(By.xpath("(//p[@id='price'])[1]"));

    private final SelenideElement removePromotionBtn = $(By.xpath("//div[@class='MuiGrid-root']//*[text()='Remove']"));

    private final SelenideElement removePaymentBeforeText = $(By.xpath("//*[text()='Remove']"));

    private final SelenideElement totalAditionalProdDiscount = $(By.xpath("//*[text()='Total Additional Product Discount']"));

    private final SelenideElement applyToAllCheckbox = $(By.xpath("//input[@name='applyToCart']"));

    private final SelenideElement applyPostponeShipBtn = $(By.xpath("//*[@id=\"postpone-shipment\"]//*[text()='APPLY']"));

    private final SelenideElement addressButton = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][1]/a"));

    private final SelenideElement contractSavings = $(By.xpath("//*[text()='Contract savings']"));

    private final SelenideElement quantitySelect = $(By.xpath("//select[contains(@id,'quantity')]"));

    private final SelenideElement totalLineItemPrice = $(By.xpath("//div[@id='rh-line-item-card_total']"));

    private final SelenideElement viewGiftBoxBtn = $(By.xpath("//a[@href='#']"));

    private final SelenideElement popupCloseButton = $(By.xpath("//button[@data-testid='form-dialog-close-button']"));

    private final SelenideElement rhMembershipImmediatlyPay = $(By.xpath("//*[text()='Your RH Membership immediately pays for itself.']"));

    private final SelenideElement joinRhMemberProgramTitle = $(By.xpath("//*[contains(text(),'Join the RH Members Program for ')]"));

    private final SelenideElement addToWishlistButton = $(By.xpath("(//*[text()='ADD TO WISHLIST'])[1]"));

    private final SelenideElement totalProductPrice = $(By.id("rh-line-item-card_total"));

    private final SelenideElement removeMembershipLink = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-direction-xs-column MuiGrid-align-items-xs-center MuiGrid-justify-xs-center']/span"));

    private final List<SelenideElement> memberShipBannerList = $$(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-direction-xs-column MuiGrid-align-items-xs-center MuiGrid-justify-xs-center']/p"));

    private final SelenideElement cartRegularPrice = $(By.xpath("(//p[@data-testid='price-for-regular'])[1]"));

    private final SelenideElement cartMemberPrice = $(By.xpath("(//p[@data-testid='price-for-member'])[1]"));

    private final SelenideElement selectChargesOption = $(By.xpath("(//div[@dropdowntype='true']//div//select)[2]"));

    private final SelenideElement option2to3DaysCharges = $(By.xpath("//option[@value='second']"));

    private final SelenideElement option1to2DaysCharges = $(By.xpath("//option[@value='next']"));

    private final SelenideElement twoToThreeBusinessDaysText = $(By.xpath("//*[text()='2-day (2 to 3 business days) $50.00']"));

    private final SelenideElement totalAdditionalProductDiscount = $(By.xpath("//*[text()='Total Additional Product Discount']"));

    private final SelenideElement thankYouForJoiningTheMemberProgram = $(By.xpath("//*[contains(text(),'Thank you for joining the RH Members Program.')]"));

    private final SelenideElement componentMessageTheFirstItem = $(By.xpath("(//*[text()='ORIGINAL LANCASTER THREE-SEAT-CUSHION U-CHAISE SECTIONAL'])[1]"));

    private final SelenideElement componentMessageTheSecondItem = $(By.xpath("(//*[text()='ORIGINAL LANCASTER THREE-SEAT-CUSHION U-CHAISE SECTIONAL'])[2]"));

    private final SelenideElement componentMessageTheThirdItem = $(By.xpath("(//*[text()='ORIGINAL LANCASTER THREE-SEAT-CUSHION U-CHAISE SECTIONAL'])[3]"));

    private final SelenideElement theFirstSkusBundle = $(By.xpath("//*[text()='57670938 WHCK']"));

    private final SelenideElement theSecondSkusBundle = $(By.xpath("//*[text()='57680681 WHCK']"));

    private final SelenideElement theThirdSkusBundle = $(By.xpath("//*[text()='70290760 WHCK']"));

    private final SelenideElement subtotalWithMemberSavings = $(By.xpath("//*[text()='Subtotal with Member Savings']"));

    private final SelenideElement joinTheRhMembersProgram = $(By.xpath("//*[text()='Join the RH Members Program']"));

    private final SelenideElement saveOnjoinTheRhMembersProgram = $(By.xpath("//*[text()='and you can save']"));

    private final SelenideElement standardDeliveryShipping = $(By.xpath("//*[text()='Standard Delivery Shipping']"));

    private final SelenideElement mattressRecyclingFee = $(By.xpath("//*[text()='mattress recycling fee']"));

    private final SelenideElement toBeCollectedAtCheckout = $(By.xpath("//*[text()=' to be collected at checkout.']"));

    private final SelenideElement deliverItemOption = $(By.xpath("//*[contains(text(),'This item is special order and will be ready for delivery between')]"));

    private final SelenideElement deliveryItemMessage = $(By.xpath("//*[contains(text(),'This item will be ready for delivery between')]"));

    private final SelenideElement theSecondDeliverItemOption = $(By.xpath("(//*[contains(text(),'This item is special order and will be ready for delivery between')])[2]"));

    private final SelenideElement cartIconHeader = $(By.xpath("//a[@id='container-rhrHeader_cart-btn']"));

    private final SelenideElement groupShipping3to7daysMessage = $(By.xpath("//*[text()='Ground shipping will arrive in 3 to 7 business days if received by noon ET (Mon-Fri). Items are not delivered on weekends or holidays.']"));

    private final SelenideElement postalCode20901 = $(By.xpath("//*[text()='20901.']"));

    public void clickToCartIconHeader() {
        cartIconHeader.should(visible, Duration.ofSeconds(12)).click(ClickOptions.usingJavaScript());
    }

    public void verifyThatCartPageIsDisplayed() {
        assertTrue(Hooks.getCurrentUrl().contains("shopping_cart"));
    }

    public void verifyThatAllTheComponentsOfTheBundleAreAddedToCart() {
        theFirstSkusBundle.should(visible, Duration.ofSeconds(12));
        theSecondSkusBundle.should(visible, Duration.ofSeconds(12));
        theThirdSkusBundle.should(visible, Duration.ofSeconds(12));
    }

    public void verifyThatSpoPanelIsDisplayed() {
        specialOrdertext.should(visible, Duration.ofSeconds(12));
        termsOfSaletext.should(visible, Duration.ofSeconds(12));
        spoPanelTermsOfUseLink.should(visible, Duration.ofSeconds(12));
        spoPanelItemName.should(visible, Duration.ofSeconds(12));
        estoreItemPage.getAggreeeAndAddToCardButton().should(Condition.and("", visible, interactable), Duration.ofSeconds(12));
    }

    public void verifyThatComponentMessageIsDisplayedForAllLineItems() {
        componentMessageTheFirstItem.should(visible, Duration.ofSeconds(12));
        componentMessageTheSecondItem.should(visible, Duration.ofSeconds(12));
        componentMessageTheThirdItem.should(visible, Duration.ofSeconds(12));
    }

    public void verifyThatTotalAdditionalProductDiscountMessageIsDisplayed() {
        totalAdditionalProductDiscount.should(visible, Duration.ofSeconds(20));
    }

    public void verifyThatRemoveMembershipButtonIsDisplayed() {
        removeMembershipButton.should(visible);
    }

    public void verifyThatThankYouForJoiningTheMemberProgramMessageIsDisplayed() {
        thankYouForJoiningTheMemberProgram.should(visible, Duration.ofSeconds(20));
    }

    public int getLineItemMemberPrice() {
        return Integer.parseInt(totalLineItemPrice.getText().replaceAll("[^0-9]", "").replaceAll("00", ""));
    }

    public void veifyThatTwoToThreeBusinessDaysTextIsDisplayed() {
        twoToThreeBusinessDaysText.should(visible, Duration.ofSeconds(15));
    }

    public void selectApplicableCharges2to3Days() {
        selectChargesOption.should(visible);
        selectChargesOption.scrollIntoView(true);
        selectChargesOption.should(interactable).click();
        option2to3DaysCharges.should(interactable);
        option2to3DaysCharges.click();
    }

    public void selectApplicableCharges1to2Days() {
        selectChargesOption.should(visible);
        selectChargesOption.scrollIntoView(true);
        selectChargesOption.should(interactable).click();
        option1to2DaysCharges.should(interactable);
        option1to2DaysCharges.click();
    }

    public SelenideElement getVariableJoinButtonByName(String name) {
        String path = String.format(variableJoinButton, name);
        return $(byXpath(path));
    }

    public void introduceMonogramText() {
        monogramText.should(visible, Duration.ofSeconds(15)).sendKeys("tes");
    }

    public int getMemberProductPriceInCart() {
        int memberProductPriceCart = Integer.parseInt(cartMemberPrice.getText().replaceAll(".00", "").replaceAll("\\$", ""));
        return memberProductPriceCart;
    }

    public int getRegularProductPriceInCart() {
        int regulatProductPriceCart = Integer.parseInt(cartRegularPrice.getText().replaceAll(".00", "").replaceAll("\\$", ""));
        return regulatProductPriceCart;
    }

    public int getTotalProductPrice() {
        int totalProductPriceCart = Integer.parseInt(totalProductPrice.getText().replaceAll(".00", "").replaceAll("\\$", ""));
        return totalProductPriceCart;
    }

    public int getRegularProductPriceValueInt() {
        int regularProductPrice = Integer.parseInt(cartRegularPrice.getText().replaceAll(".00", "").replaceAll("\\$", ""));
        return regularProductPrice;
    }

    public int getQuantityOfProductInCart() {
        int quantityOfProduct = Integer.parseInt($(By.xpath("//*[contains(@id,'quantity')]")).getText());
        return quantityOfProduct;
    }

    public void verifyThatPurchasingMembershipPopIsNotDisplayed() {
        joinNowMembershipButton.shouldNotBe(Condition.visible, Duration.ofSeconds(20));
        noThanksButton.shouldNotBe(Condition.visible, Duration.ofSeconds(20));
        rhMemberProgramTitle.shouldNotBe(Condition.visible, Duration.ofSeconds(20));
        rhMembershipImmediatlyPay.shouldNotBe(Condition.visible, Duration.ofSeconds(20));
    }

    public void clickOnNoThanksButton() {
        noThanksButton.shouldHave(text("NO, THANKS"), Duration.ofSeconds(20));
        noThanksButton.should(appear, Duration.ofSeconds(10));
        noThanksButton.should(exist, Duration.ofSeconds(10));
        noThanksButton.should(interactable, Duration.ofSeconds(10));
        with().pollInterval(2, SECONDS).await().until(() -> true);
        noThanksButton.doubleClick();
    }

    public void verifyUFDAmount() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String totalLineItemPriceValue = totalLineItemPrice.getText();
        int totalLineItemPriceAmount = Integer.parseInt(totalLineItemPrice.getText().substring(0, totalLineItemPriceValue.indexOf(".00")).replaceAll("[^0-9]", ""));
        int ufdAmount = 279;
        int totalLineItemPriceWithCharges = ufdAmount + totalLineItemPriceAmount;
        String totalPrice = decimalFormat.format(totalLineItemPriceWithCharges);

        $(By.xpath("//*[text()=\"" + "$" + totalPrice + ".00" + "\"]")).should(visible, Duration.ofSeconds(12));
    }
}
