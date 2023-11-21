package tests.concierge.pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class ConciergeCartPageScreen {
    public final String QuantityItemLineNumber = "(//select[contains(@id,'quantity')])[%s]";
    public final String OptionItemLineNumber = "(//option[@value='%s'])[%s]";
    public final String selectPrice = "//option[@value='%s']";
    public final String shippingAddressStateItem = "//*[@id = 'address-state-field'])[1]/option)[%s]";
    public final String billingAddressStateItem = "//*[@id = 'address-state-field'])[2]/option)[%s]";

    private final SelenideElement continueAddingAdditionalButton = $(By.xpath("//*[text() = 'CONTINUE']"));
    private final SelenideElement orderClassificationGalleryOrder = $(By.xpath("//option[@value='RH Gallery Order']"));
    private final SelenideElement correctSpaceText = $(By.xpath("//*[text()='correctspace']"));
    private final SelenideElement wrongSpaceText = $(By.xpath("//*[text()='wrongspace']"));

    private final SelenideElement promoCodeText = $(By.xpath("//*[text()='Members have the privilege of receiving 25% off full priced items or 20% off sale items, whichever is the best price. Tax, shipping and surcharges are not included in calculating discount. Not valid for gift cards, personalization and gift boxes.']"));

    private final SelenideElement orderClassificationResidentialTrade = $(By.xpath("//option[@value='RH Residential Trade']"));
    private final ElementsCollection removeButtonList = $$(By.xpath("//*[text() = 'Remove']"));
    private final SelenideElement removeLinkButton = $(By.xpath("//*[text() = 'Remove']"));
    private final SelenideElement orderClassificationInteriorDesign = $(By.xpath("//option[@value='RH Interior Design']"));

    private final SelenideElement yourShoppingCartIsEmptyText = $(By.xpath("//*[text() = 'YOUR SHOPPING CART IS EMPTY']"));
    private final SelenideElement nanPrice = $(By.xpath("//*[text() = '$NaN']"));
    private final SelenideElement howWouldYouLikeToReceiveYourShipmentsText = $(By.xpath("//*[text() = 'How Would You Like to Receive Your Shipments?']"));
    private final SelenideElement totalPriceCurrentResult = $(By.xpath("//*[@aria-describedby = 'price-override-popper']/h5"));
    private final SelenideElement subtotalPriceCurrentResult = $(By.xpath("//*[contains(text(), 'Subtotal')]/../following-sibling::div/span"));
    private final SelenideElement topMemberSavingsCurrentResult = $(By.xpath("//h2/following-sibling::p"));
    private final SelenideElement priceForFinalSale = $(By.xpath("//*[@data-testid = 'price-for-final-sale']"));
    private final SelenideElement bottomMemberSavingsCurrentResult = $(By.xpath("(//*[contains(text(),'Join the RH Members Program')])[2]/.."));
    private final SelenideElement deliverItemsAsTheyAreAvailableText = $(By.xpath("//*[text() = 'Deliver items as they are available']"));
    private final SelenideElement deliveryASAPText = $(By.xpath("//*[text() = 'Deliver ASAP']"));
    private final SelenideElement rhMembersProgramTitleText = $(By.xpath("//*[text()= 'RH MEMBERS PROGRAM']"));
    private final SelenideElement willBeReadyForDeliveryBetweenText = $(By.xpath("//*[@id = 'component-sku']//p[contains (text(), 'will be ready for delivery between')]/span"));
    private final SelenideElement rhMembersProgramText = $(By.xpath("//h2[text() = 'RH MEMBERS PROGRAM']/following-sibling::p"));
    private final SelenideElement billingAddressEditButton = $(By.xpath("(//*[text()='Edit'])[10]"));
    private final SelenideElement itemInSockText = $(By.xpath("//*[contains(text(),'This item is in stock and will be ready for delivery between')]"));
    private final SelenideElement itemCanBeReturned = $(By.xpath(" //*[contains(text(),'This item can be returned or exchanged within 30 days of delivery')]"));
    private final SelenideElement shippingAddressEditButton = $(By.xpath("(//*[text()='Edit'])[1]"));
    private final SelenideElement availabilityText = $(By.xpath("//*[text()='Availability']"));
    private final SelenideElement monogramStyleValue = $(By.xpath("//*[text()='Bauer Bodoni 1 (BDNI-HC)']"));
    private final SelenideElement monogramStyle = $(By.xpath("//*[@id = 'listColumn1-Style']"));
    private final SelenideElement monogramColorValue = $(By.xpath("//*[text()='Light Gold Metallic (MLGD)']"));
    private final SelenideElement monogramColor = $(By.xpath("(//*[@id = 'listColumn1-Color'])[2]"));
    private final SelenideElement monogramTextValue = $(By.xpath("//*[text()='ABC']"));
    private final SelenideElement monogramText = $(By.xpath("//*[@type = 'text']"));
    private final SelenideElement designedSoldByText = $(By.xpath("//*[text()='Designed/Sold By:']"));
    private final SelenideElement automationAssociateText = $(By.xpath("//*[text()='Automation Associate']"));
    private final SelenideElement editedMonogramStyleValue = $(By.xpath("//*[text() = 'Style']"));
    private final SelenideElement joinNowButton = $(By.xpath("//*[text() = 'JOIN NOW']"));
    private final SelenideElement contractSavingsValue = $(By.xpath("//*[text()='$897.00']"));
    private final SelenideElement orderEstimate = $(By.xpath("//*[text() = 'Mattress Fee']/../..//p"));
    private final SelenideElement removeMembershipButton = $(By.xpath("//*[text() = 'REMOVE MEMBERSHIP']"));
    private final SelenideElement editedMonogramStyle = $(By.xpath("//*[@id = 'listColumn1-Style']"));
    private final SelenideElement weAreUnableToVerifyTheAddressProvidedText = $(By.xpath("//*[text()='WE ARE UNABLE TO VERIFY THE ADDRESS PROVIDED']"));
    private final SelenideElement editedMonogramColorValue = $(By.xpath("//*[text()='Light Gold Metallic (MLGD)']"));
    private final SelenideElement editedMonogramColor = $(By.xpath("(//*[@id = 'listColumn1-Color'])[2]"));
    private final SelenideElement editedMonogramTextValue = $(By.xpath("//*[text() = 'Text']"));
    private final SelenideElement editedMonogramText = $(By.xpath("//*[@id = 'listColumn1-Text']"));
    private final SelenideElement lastMonthDay = $(By.xpath("(//button/span/p[text() = '30'])[2]"));
    private final SelenideElement currentMonth = $(By.xpath("//*[contains(@class, 'MuiPickersCalendarHeader-switchHeader')]//p"));
    private final SelenideElement restShipmentText = $(By.xpath("//*[@id = 'reset-shipment']"));
    private final SelenideElement reasonCodeText = $(By.xpath("//*[@id = 'reason-code']"));
    private final SelenideElement shipOnOrAfterDate = $(By.xpath("//*[@id = 'ship-on-or-after-date']"));
    private final SelenideElement giftBoxPrice = $(By.xpath("//*[text()='$5.95']"));
    private final SelenideElement billingAddressCompanyNameInput = $(By.xpath("(//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input)[3]"));
    private final SelenideElement consolidateInfoAsFewDeliveriesAsPossible = $(By.xpath("//*[text() = 'Consolidate into as few deliveries as possible']"));
    private final SelenideElement deliveredOnTheLatestQuotedDeliveryDate = $(By.xpath("//*[text() = 'Delivered on the latest quoted delivery date']"));
    private final SelenideElement orderClassificationLabel = $(By.xpath("//*[@id = 'element-orderclassification-label']"));

    private final SelenideElement orderClassification = $(By.xpath("//*[@id = 'element-orderclassification']"));
    private final SelenideElement rhGalleryOrder = $(By.xpath("//*[@id = 'element-orderclassification']/option[text() = 'RH Gallery Order']"));
    private final SelenideElement rhResidentialTrade = $(By.xpath("//*[@id = 'element-orderclassification']/option[text() = 'RH Residential Trade']"));
    private final SelenideElement rhInteriorDesign = $(By.xpath("//*[@id = 'element-orderclassification']/option[text() = 'RH Interior Design']"));
    private final SelenideElement metalBoxFrameLeanerMirrorText = $(By.xpath("//*[text()='Metal Box Frame Leaner Mirror']"));
    private final SelenideElement dialogTitleCloseButton = $(By.xpath("//*[@data-testid = 'dialog-title-close-button']"));
    private final SelenideElement adjustedText = $(By.xpath("//*[text() = 'Adjusted']"));
    private final SelenideElement selectAnOption = $(By.xpath("//*[@id = 'element-orderclassification']/option[text() = 'Select an Option']"));
    private final SelenideElement closePopUp = $(By.xpath("//button[@data-testid='dialog-title-close-button']"));

    private final SelenideElement orderClassificationError = $(By.xpath("//*[text() = 'Please select an option for Order Classification.']"));

    private final SelenideElement arlesRectangularDinigTableId = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12']/div/div/div[1]//p[@id='listColumn2-Item#']"));

    private final SelenideElement shoppingCartEmpty = $(By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1']"));

    private final SelenideElement pleaseContinueBrowsingButton = $(By.xpath("//div[@id='spa-root']/div/main//a"));

    private final SelenideElement arlesRectangularDinigTableTitle = $(By.xpath("//h3[normalize-space()='Arles Rectangular Dining Table']"));

    private final SelenideElement gramTurkishTowel = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12']/div/div/div[2]//p[@id='listColumn2-Item#']"));

    private final SelenideElement gramTurkishTitle = $(By.xpath("//h3[normalize-space()='802-Gram Turkish Towel Collection']"));

    private final SelenideElement quantityButton = $(By.xpath("//*[contains(@id,'quantity')]"));

    private final SelenideElement orderClassificationSelect = $(By.xpath("//*[@name = 'orderClassification']"));

    private final SelenideElement membersProgramTitle = $(By.xpath("//h2[@class='MuiTypography-root MuiTypography-h2 MuiTypography-noWrap']"));

    private final SelenideElement agreeTermsForSaleCheckbox = $(By.xpath("//*[text()='I agree to the Terms of Sale for Special Orders.']"));

    private final SelenideElement colorCloseButton = $(By.xpath("//div[@class='MuiDialogTitle-root']/button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit']"));

    private final SelenideElement noThanksButton = $(By.xpath("//span[normalize-space()='NO, THANKS']"));

    private final SelenideElement becomeAMemberNow = $(By.xpath("//*[text()='BECOME A MEMBER NOW']"));

    private final SelenideElement orderEstimateTitle = $(By.xpath("//*[text()='Order Estimate']"));

    private final SelenideElement adjustmentCodeField = $(By.xpath("//input[@id='adjustment']"));

    private final SelenideElement reasonCodeField = $(By.xpath("//select[@id='reason_code']"));

    private final SelenideElement removeButton = $(By.xpath("//*[text()='Remove']"));

    private final SelenideElement cartTitle = $(By.xpath("//*[text()='CART']"));

    private final SelenideElement updateButton = $(By.xpath("//*[text() = 'UPDATE']"));

    private final SelenideElement clearOrderButton = $(By.xpath("//*[text() = 'Clear Cart']"));

    private final SelenideElement addMonogramButton = $(By.xpath("//*[text()='add monogram']"));

    private final SelenideElement saleItem = $(By.xpath(" //*[text() = 'Sale']"));

    private final SelenideElement monogramTextInput = $(By.xpath("//input[@data-testid='monogram-input0']"));
    private final SelenideElement priceFirstLineItem = $(By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-alignRight'])[1]"));
    private final SelenideElement priceSecondLineItem = $(By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-alignRight'])[2]"));
    private final SelenideElement totalPrice = $(By.xpath("//h5[@aria-describedby = 'shipping-override-price-dialog']"));
    private final SelenideElement totalAdditionalProductDiscountMessage = $(By.xpath("(//*[contains(@class,'MuiGrid-root MuiGrid-container')]/span)[7]"));
    private final SelenideElement totalAdditionalProductDiscount = $(By.xpath("(//*[contains(@class,'MuiGrid-root MuiGrid-container')]/span)[8]"));
    private final SelenideElement totalPriceAfterStateTax = $(By.xpath("//h5[contains(@class, 'MuiTypography-h5')]"));
    private final SelenideElement stateTax = $(By.xpath("//p[contains(@class, 'MuiTypography-body1 MuiTypography-alignRight')]"));
    private final SelenideElement totalAdditionalProductDiscountOnPaymentPage = $(By.xpath("(//div[contains(@class, 'MuiGrid-root MuiGrid-container MuiGrid-item')]/span)[5]"));
    private final SelenideElement billingShippingAddressSameCheckbox = $(By.xpath("//*[contains(@class, 'Mui-checked')]//*[@id = 'billing-shipping-address-same-checkbox']"));

    private final SelenideElement checkBalanceButton = $(By.xpath("//*[text()='Check balance']"));
    private final SelenideElement totalWithTaxesCurrentPrice = $(By.xpath("//*[text() = 'Unlimited Furniture Delivery' ]/../following-sibling::div/p"));

    private final SelenideElement tradeSavingsText = $(By.xpath("//*[text()='Trade savings']"));

    private final SelenideElement subtotalCurrentValue = $(By.xpath("//*[text() = 'Subtotal' ]/../following-sibling::div/span"));

    private final SelenideElement memberSavingsText = $(By.xpath("//*[text()='Member Savings']"));

    private final SelenideElement clearCartButtonPop = $(By.xpath("//button[contains(@class, 'MuiButton-containedPrimary')]/span/p"));

    private final SelenideElement clearCartButtonPopUpHeader = $(By.xpath("//*[text() = 'Are you sure you want to clear the current cart?']"));

    private final SelenideElement clearOrderButtonPopUpHeader = $(By.xpath("//*[text() = 'Are you sure you want to clear the current order?']"));

    private final List<SelenideElement> monogramFonts = $$(By.xpath("(//ul[@class='MuiGridList-root'])[1]//li[@class='MuiGridListTile-root']"));

    private final List<SelenideElement> monogramColors = $$(By.xpath("(//ul[@class='MuiGridList-root'])[2]//li[@class='MuiGridListTile-root']"));

    private final SelenideElement removeMonogramBtn = $(By.xpath("(//*[text()='Remove'])[1]"));

    private final SelenideElement userNamePromocode = $(By.xpath("//input[@autocomplete='new-username']"));

    private final SelenideElement passwordPromocde = $(By.xpath("//input[@type='password']"));

    private final SelenideElement acceptButton = $(By.xpath("//*[text()='Accept']"));

    private final SelenideElement keepShopping = $(By.xpath("//*[text()='Keep Shopping']"));

    private final SelenideElement applyEmpDiscountBtn = $(By.xpath("//*[text() = 'RH Employee Discount']//*[text() = 'Apply']"));

    private final SelenideElement applyPromocodeBtn = $(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-fullWidth']"));

    private final SelenideElement itemAddedToYourCart = $(By.xpath("//p[contains(@class,'MuiTypography-h4')]"));

    private final SelenideElement promotionCodeField = $(By.xpath("(//div[contains(@class,'MuiInputBase-formControl')]//input)[1]"));

    private final SelenideElement ufdCartButton = $(By.xpath("//*[text()='Unlimited Furniture Delivery']"));

    private final SelenideElement rhMembershipProgramTitle = $(By.xpath("//*[text()='Rh Members Program']"));

    private final SelenideElement personalizationText = $(By.xpath("//*[text()='PERSONALIZATION']"));

    private final SelenideElement editMonogramButton = $(By.xpath("//*[@id = 'component-options-details-list']/following-sibling::div/p[text() = 'Edit']"));

    private final SelenideElement posTransactionField = $(By.xpath("(//div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root')]/input)[1]"));

    private final SelenideElement posRegisterField = $(By.xpath("(//div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root')]/input)[2]"));

    private final SelenideElement totalMemberPrice = $(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-alignRight']"));

    private final SelenideElement firstProductNameInPG = $(By.xpath("(//*[contains(@id, 'RH')]//p/span)[1]"));

    private final SelenideElement regularPriceInPG = $(By.xpath("(//*[@data-testid = 'price-for-regular'])[1]"));

    private final SelenideElement pdpScreenZipCode = $(By.xpath("//*[contains(text(), 'Shipping to')]/a"));

    private final SelenideElement agreeAndAddToCart = $(By.xpath("//*[text() = 'Agree & Add To Cart']"));
    private final SelenideElement updatedZipCodeInPDP = $(By.xpath("//*[@data-testid = 'postal-code-dialog-opener']"));
    private final SelenideElement memberPriceInPG = $(By.xpath("(//*[@data-testid = 'price-for-member'])[1]"));
    private final ElementsCollection quantityItemLineList = $$(By.xpath("//select[contains(@id,'quantity')]"));

    private final SelenideElement cartFirstGridView = $(By.xpath("(//button[contains(@class, 'sc-gsDKAQ')])[1]"));

    private final SelenideElement cartSecondGridView = $(By.xpath("(//button[contains(@class, 'sc-gsDKAQ')])[2]"));

    private final SelenideElement cartThirdGridView = $(By.xpath("(//button[contains(@class, 'sc-gsDKAQ')])[3]"));

    private final SelenideElement shippingAddress = $(By.xpath("//*[text() = 'Shipping Address']"));
    private final SelenideElement billingAddress = $(By.xpath("//*[text() = 'Billing Address']"));
    private final SelenideElement shippingAddressStateField = $(By.xpath("(//*[@id = 'address-state-field'])[1]"));
    private final SelenideElement billingAddressStateField = $(By.xpath("(//*[@id = 'address-state-field'])[2]"));
    private final SelenideElement regularAndTotalPriceForTheProduct = $(By.xpath(" //*[@class = 'MuiButtonBase-root MuiFab-root' and not(contains(@style, 'hidden'))]"));

    private final SelenideElement totalRegularPrice = $(By.xpath("//*[@data-testid = 'price-for-regular']"));
    private final SelenideElement totalTradePrice = $(By.xpath("//*[@data-testid = 'price-for-trade']"));

    private final SelenideElement priceForMember = $(By.xpath("//p[@data-testid='price-for-member']"));

    private final SelenideElement finalSalePrice = $(By.xpath("//p[@data-testid='price-for-final-sale']"));

    private final SelenideElement tradeSalePrice = $(By.xpath("//p[@data-testid='price-for-trade']"));

    private final SelenideElement tradePriceLabel = $(By.xpath("//p[@data-testid='price-label-trade']"));

    private final SelenideElement postponeShipment = $(By.xpath("//p[@id='postpone-shipment']"));

    private final SelenideElement postponeSelectReasonCode = $(By.xpath("//select[@id='data_reason_code']"));

    private final SelenideElement postponeShipOnOrAfterDate = $(By.xpath("//*[contains(text(), 'Ship on or after')]"));

    private final SelenideElement soldToAddressTitle = $(By.xpath("//*[text()='Sold To Address']"));

    private final SelenideElement billingAddressTitle = $(By.xpath("//*[text()='Billing Address']"));

    private final SelenideElement shippingAddressTitle = $(By.xpath("//*[text()='Shipping Address']"));

    private final SelenideElement joinNow = $(By.xpath("//*[text()='JOIN NOW']"));

    private final SelenideElement applyUpperCaseBtn = $(By.xpath("//*[text()='APPLY']"));

    private final SelenideElement rhGiftCardBalance = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item'][2]/p[@class='MuiTypography-root MuiTypography-body1']"));

    private final SelenideElement spaceDropDown = $(By.xpath("//div[1]/button//div[contains(@class,'MuiGrid-root MuiGrid-container')]"));

    private final SelenideElement giftBoxFee = $(By.xpath("//*[text()='Gift Box Fee']"));

    private final SelenideElement removePromotionBtn = $(By.xpath("//*[text()='Remove Promotion']"));

    private final SelenideElement totalAditionalProdDiscount = $(By.xpath("//*[text()='Total Additional Product Discount']"));

    private final SelenideElement applyToAllCheckbox = $(By.xpath("//input[@name='applyToCart']"));

    private final SelenideElement totalAdditionalProdDiscountSum = $(By.xpath(" //*[text()='Total Additional Product Discount']/../following-sibling::div/span"));

    private final SelenideElement applyPostponeShipBtn = $(By.xpath("//*[@id=\"postpone-shipment\"]//*[text()='APPLY']"));

    private final SelenideElement addressButton = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][1]/a"));

    private final SelenideElement contractSavingsText = $(By.xpath("//*[text()='Contract savings']"));

    private final SelenideElement rhMembershipImmediatelyPay = $(By.xpath("//*[text()='Your RH Membership immediately pays for itself.']"));

    private final SelenideElement joinRhMemberProgramTitle = $(By.xpath("(//*[contains(text(),'Join the RH Members Program for ')])[2]"));

    private final SelenideElement tradeInViewPage = $(By.xpath("(//*[text()='TRADE'])[1]"));

    private final SelenideElement priceInViewPage = $(By.xpath("(//*[@id=\"price\"])[1]"));

    private final SelenideElement totalWithoutTaxes = $(By.xpath("//*[@aria-describedby = 'price-override-popper']/h5"));

    private final SelenideElement subtotal = $(By.xpath("//*[text() = 'Subtotal' ]/../following-sibling::div/span"));

    private final SelenideElement totalWithTaxes = $(By.xpath("//h5[@aria-describedby = 'shipping-override-price-dialog']"));

    private final SelenideElement unlimitedDeliverySectionInTotal = $(By.xpath("//*[text() = 'Unlimited Furniture Delivery' ]/../following-sibling::div/p"));

    public SelenideElement getQuantityByNumber(Integer number) {
        String path = String.format(QuantityItemLineNumber, number);
        return $(byXpath(path));
    }

    public SelenideElement getOptionLineItemByNumber(Integer lineItem1, Integer lineItem2) {
        String path = String.format(OptionItemLineNumber, lineItem1, lineItem2);
        return $(byXpath(path));
    }

    public SelenideElement getPriceByName(String price) {
        String path = String.format(selectPrice, price);
        return $(byXpath(path));
    }
    public SelenideElement getShippingAddressStateByNumber(Integer number) {
        String path = String.format(shippingAddressStateItem, number);
        return $(byXpath(path));
    }

    public SelenideElement getBillingAddressStateByNumber(Integer number) {
        String path = String.format(billingAddressStateItem, number);
        return $(byXpath(path));
    }


}
