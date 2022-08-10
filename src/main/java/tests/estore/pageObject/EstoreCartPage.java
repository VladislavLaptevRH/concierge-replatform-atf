package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class EstoreCartPage {
    private final SelenideElement joinNowCartEstoreButton = $(By.xpath("//*[text()='JOIN NOW']"));

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

    private final SelenideElement quantityButton = $(By.xpath("//select[@id='quantity_701bfc45-0262-4a2c-bf01-92887d788333_1']"));

    private final SelenideElement orderClassificationSelect = $(By.id("element-orderclassification"));

    private final SelenideElement membersProgramTitle = $(By.xpath("//h2[@class='MuiTypography-root MuiTypography-h2 MuiTypography-noWrap']"));

    private final SelenideElement closePopUp = $(By.xpath("//button[@data-testid='form-dialog-close-button']"));

    private final SelenideElement updateButton = $(By.xpath("//*[text()='UPDATE']"));

    private final SelenideElement agreeTermsForSaleCheckbox = $(By.xpath("//*[text()='I agree to the Terms of Sale for Special Orders.']"));

    private final SelenideElement colorCloseButton = $(By.xpath("//div[@class='MuiDialogTitle-root']/button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit']"));

    private final SelenideElement noThanksButton = $(By.xpath("//span[normalize-space()='NO, THANKS']"));

    private final SelenideElement becomeAmemberNow = $(By.xpath("//*[text()='BECOME A MEMBER NOW']"));

    private final SelenideElement orderEstimateTitle = $(By.xpath("//*[text()='Order Estimate']"));

    private final SelenideElement adjustmentCodeField = $(By.xpath("//input[@id='adjustment']"));

    private final SelenideElement reasonCodeField = $(By.xpath("//select[@id='reason_code']"));

    private final SelenideElement removeButton = $(By.xpath("//*[text()='Remove']"));

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

    private final SelenideElement applyPromocodeBtn = $(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-fullWidth']"));

    private final SelenideElement itemAddedToYourCart = $(By.xpath("//*[text()='1 Item Added To Your Cart']"));

    private final SelenideElement promotionCodeField = $(By.xpath("(//div[contains(@class,'MuiInputBase-formControl')]//input)[1]"));

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

    private final SelenideElement joinNow = $(By.xpath("//*[text()='JOIN NOW']"));

    private final SelenideElement applyUpperCaseBtn = $(By.xpath("//*[text()='APPLY']"));

    private final SelenideElement rhGiftCardBalance = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item'][2]/p[@class='MuiTypography-root MuiTypography-body1']"));

    private final SelenideElement spaceDropDown = $(By.xpath("//div[1]/button//div[contains(@class,'MuiGrid-root MuiGrid-container')]"));

    private final SelenideElement giftBoxFee = $(By.xpath("//*[text()='Gift Box Fee']"));

    private final SelenideElement memberLabel = $(By.xpath("//p[@data-testid='price-label-member']"));

    private final SelenideElement memberPrice = $(By.xpath("//p[@data-testid='price-for-member']"));

    private final SelenideElement zipCodeField = $(By.xpath("//input[@name='newPostalCode']"));

    private final SelenideElement removePromotionBtn = $(By.xpath("//div[@class='MuiGrid-root']//*[text()='Remove']"));

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

    private final SelenideElement joinRhMemberProgramTitle = $(By.xpath("(//*[contains(text(),'Join the RH Members Program for ')])[2]"));

}
