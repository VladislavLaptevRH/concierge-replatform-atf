package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ConciergeCartPageScreen {

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

    private final SelenideElement orderClassificationSelect = $(By.cssSelector("#element-orderclassification"));

    private final SelenideElement membersProgramTitle = $(By.xpath("//h2[@class='MuiTypography-root MuiTypography-h2 MuiTypography-noWrap']"));

    private final SelenideElement closePopUp = $(By.xpath("//button[@data-testid='form-dialog-close-button']"));

    private final SelenideElement updateButton = $(By.xpath("//*[text()='UPDATE']"));

    private final SelenideElement agreeTermsForSaleCheckbox = $(By.xpath("//*[text()='I agree to the Terms of Sale for Special Orders.']"));

    private final SelenideElement colorCloseButton = $(By.xpath("//div[@class='MuiDialogTitle-root']/button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit']"));

    private final SelenideElement noThanksButton = $(By.xpath("//*[text()='NO, THANKS']"));

    private final SelenideElement clearOrderButton = $(By.xpath("//a[contains(@class,'clearOrder MuiTypography-colorPrimary')]"));

    private final SelenideElement becomeAmemberNow = $(By.xpath("//*[text()='BECOME A MEMBER NOW']"));

    private final SelenideElement applyPromocodeButton = $(By.xpath("(//*[text()='Apply'])[1]"));

    private final SelenideElement itemAddedToYourCart = $(By.xpath("//p[contains(@class,'MuiTypography-h4')]"));

    private final SelenideElement promotionCodeField = $(By.xpath("(//div[contains(@class,'MuiInputBase-formControl')]//input)[1]"));

    private final SelenideElement ufdCartButton = $(By.xpath("//*[text()='Unlimited Furniture Delivery']"));

    private final SelenideElement rhMembershipProgramTitle = $(By.xpath("//*[text()='Rh Members Program']"));

    private final SelenideElement posTransactionField = $(By.xpath("(//div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root')]/input)[1]"));

    private final SelenideElement posRegisterField = $(By.xpath("(//div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root')]/input)[2]"));

    private final SelenideElement totalMemberPrice = $(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-alignRight']"));

    private final SelenideElement postponeShipment = $(By.xpath("//p[@id='postpone-shipment']"));

    private final SelenideElement postponeSelectReasonCode = $(By.xpath("//select[@id='data_reason_code']"));

    private final SelenideElement postponeShipOnOrAfterDate = $(By.xpath("//p[@id='ship-on-or-after-date']"));

    private final SelenideElement soldToAddressTitle = $(By.xpath("//*[text()='Sold To Address']"));

    private final SelenideElement billingAddressTitle = $(By.xpath("//*[text()='Billing Address']"));

    private final SelenideElement shippingAddressTitle = $(By.xpath("//*[text()='Shipping Address']"));

    private final SelenideElement joinNow = $(By.xpath("//*[text()='JOIN NOW']"));

    private final SelenideElement addressButton = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][1]/a"));

    private final SelenideElement rhMembershipImmediatlyPay = $(By.xpath("//*[text()='Your RH Membership immediately pays for itself.']"));

    private final SelenideElement joinRhMemberProgramTitle = $(By.xpath("(//*[contains(text(),'Join the RH Members Program for ')])[2]"));

}
