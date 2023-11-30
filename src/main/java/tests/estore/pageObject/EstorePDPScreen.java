package tests.estore.pageObject;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;

@Getter
public class EstorePDPScreen {
    private final SelenideElement canadaCountrySelected = $(By.xpath("//*[text()='Canada ($)']"));

    private final SelenideElement addToCartButtonViewInStockPopUp = $(By.xpath("(//button[@id='inStockProductCardActions_addToCart-btn'])[1]"));

    private final SelenideElement firstRegularPrice = $(By.xpath("(//p[@data-testid='price-for-regular'])[1]"));

    private final SelenideElement firstMemberPrice = $(By.xpath("(//p[@data-testid='price-for-member'])[1]"));

    private final SelenideElement addToCartActiveButton = $(By.xpath("(//*[text()='Add To Cart'])[1]"));

    private final SelenideElement addToCartInactiveButton = $(By.xpath("(//*[text()='Add To Cart'])[2]"));

    private final SelenideElement sortButton = $(By.xpath("(//*[contains(text(),'sort')])[2]"));

    private final SelenideElement sortByButton = $(By.xpath("//*[text()='Featured']"));

    private final SelenideElement priceLowToHigh = $(By.xpath("//*[text()='Price Low to High']"));

    private final SelenideElement priceHighToLow = $(By.xpath("//*[text()='Price High to Low']"));

    private final SelenideElement firstProduct = $(By.id("component-rh-image_wrapper"));

    private final SelenideElement priceBox = $(By.xpath("//span[@class='priceBox']"));

    private final SelenideElement sizeOption = $(By.xpath("(//select[contains(@id,'Size')])[1]"));

    private final SelenideElement colorOption = $(By.xpath("(//select[contains(@id,'Color')])[1]"));

    private final SelenideElement finishOption = $(By.xpath("(//select[contains(@id,'Finish')])[1]"));

    private final SelenideElement sizeLabelUnselectedOption = $(By.xpath("//label[@id='optionSelect-prod2020027-Size-label' and @data-shrink='false']"));

    private final SelenideElement thisItemWillBeDelieveredMsg = $(By.xpath("(//*[contains(text(),'This item will be delivered on or before')])[1]"));

    private final SelenideElement shipsFreeOfChargeViaStandarShipMsg = $(By.xpath("(//*[text()='Ships free of charge via Standard Delivery Shipping'])[1]"));

    private final SelenideElement thisItemCanBeReturnedMsg = $(By.xpath("//*[text()='This item can be returned within 30 days of delivery.']"));

    private final SelenideElement skuIdItemValue = $(By.xpath("//*[@data-testid='item-sku-id-desktop']"));

    private final SelenideElement returnPolicyButton = $(By.xpath("(//a[@href='/us/en/customer-service/return-policy.jsp'])[1]"));

    private final SelenideElement monogramCheckBox = $(By.xpath("//*[@data-testid='monogram-checkbox']"));

    private final SelenideElement editMonogramButton = $(By.xpath("//*[text()='Edit']"));

    private final SelenideElement koutHdFontMonogram = $(By.xpath("//input[@value='Knockout 2 (KOUT-HD)']"));

    private final SelenideElement goldMetallicColorMonogram = $(By.xpath("//input[@name='checkboxLight Gold Metallic (MLGD)']"));

    private final SelenideElement addMonogram = $(By.xpath("//button[@data-testid='monogram-add-button']"));

    private final SelenideElement itemIncludeMultipleComponentsMsg = $(By.xpath("//*[text()='This item includes multiple components. Individual components will be listed in your cart.']"));

    private final SelenideElement fistItemTitle = $(By.xpath("(//a[@id='product-option-grid']//p//span)[2]"));

    private final SelenideElement fistItemProductId = $(By.xpath("(//div[@data-cmp='cardImages'])[1]//img"));

    private final SelenideElement fillSelectOption = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Fill')])[1]"));

    private final SelenideElement armlessSofaSelectOption = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Armless Sofa')])[1]"));

    private final SelenideElement etaLineItemMessage = $(By.xpath("//*[contains(text(),'This item is in stock and will be delivered on or before')]"));

    private final SelenideElement returnLineItemMessage = $(By.xpath("//*[contains(text(),'This item can be returned within 30 days of delivery.')]"));

    private final SelenideElement regularSalePricePdp = $(By.xpath("(//*[@data-testid='price-for-sale'])[1]"));
    private final SelenideElement memberSalePricePdp = $(By.xpath("(//*[@data-testid='price-for-member'])[1]"));

    private final SelenideElement regularPricePdp = $(By.xpath("(//*[@data-testid='price-for-regular'])[1]"));
    private final SelenideElement memberPricePdp = $(By.xpath("(//*[@data-testid='price-for-member'])[1]"));

    private final SelenideElement lineItemMemberPrice = $(By.xpath("(//*[@id='rh-price-range-display']//*[@data-testid='price-for-member'])[3]"));

    private final SelenideElement lineItemRegularPrice = $(By.xpath("(//*[@id='rh-price-range-display']//*[@data-testid='price-for-regular'])[2]"));

    private final SelenideElement firstLineItemMemberPrice = $(By.xpath("(//*[@id='rh-price-range-display']//*[@data-testid='price-for-member'])[3]"));

    private final SelenideElement firstLineItemRegularPrice = $(By.xpath("(//*[@id='rh-price-range-display']//*[@data-testid='price-for-regular'])[2]"));

    private final SelenideElement spOcanNotBeReturnedMesssage = $(By.xpath("//*[contains(text(),'This item is special order and cannot be returned.')]"));

    public int getRegularFirstLineItemPricePDP() {
        return Integer.parseInt(firstLineItemRegularPrice.getText().replaceAll("\\$", "").replaceAll("\\,", ""));
    }

    public int getMemberFirstLineItemPricePDP() {
        return Integer.parseInt(firstLineItemMemberPrice.getText().replaceAll("\\$", "").replaceAll("\\,", ""));
    }

    public int getRegularLineItemPricePDP() {
        return Integer.parseInt(lineItemRegularPrice.getText().replaceAll("\\$", "").replaceAll("\\,", ""));
    }

    public int getMemberLineItemPricePDP() {
        return Integer.parseInt(lineItemMemberPrice.getText().replaceAll("\\$", "").replaceAll("\\,", ""));
    }

    public int getRegularSalePricePDP() {
        return Integer.parseInt(regularSalePricePdp.getText().replaceAll("\\$", "").replaceAll("\\,", ""));
    }

    public int getMemberPricePDP() {
        return Integer.parseInt(memberPricePdp.getText().replaceAll("\\$", "").replaceAll("\\,", ""));
    }

    public int getRegularPricePDP() {
        return Integer.parseInt(regularPricePdp.getText().replaceAll("\\$", "").replaceAll("\\,", ""));
    }

    public int getMemberSalePricePDP() {
        return Integer.parseInt(memberSalePricePdp.getText().replaceAll("\\$", "").replaceAll("\\,", ""));
    }

    public void verifyThatReturnMessageIsDisplayed() {
        returnLineItemMessage.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatEtaLineMessageIsDisplayed() {
        etaLineItemMessage.should(Condition.visible, Duration.ofSeconds(15));
    }

    public void selectArmlessSofaOption() {
        Select selectFillOption = new Select(armlessSofaSelectOption);
        selectFillOption.selectByIndex(1);
        with().pollInterval(2, SECONDS).await().until(() -> true);
    }

    public void selectFillOption() {
        fillSelectOption.should(Condition.interactable, Duration.ofSeconds(12));
        Select selectFillOption = new Select(fillSelectOption);
        selectFillOption.selectByIndex(1);
    }

    public void verifyThatItemIncludeMultipleComponentsMsgIsDisplayedAboveLineItemDropDown() {
        itemIncludeMultipleComponentsMsg.should(Condition.visible, Duration.ofSeconds(20));
    }

    public void verifyThatItemIncludeMultipleComponentsMsgIsDisplayedBellowLineItemDropDown() {
        itemIncludeMultipleComponentsMsg.should(Condition.visible, Duration.ofSeconds(20));
    }

    public void clickToReturnPolicyButton() {
        returnPolicyButton.should(Condition.and("", Condition.interactable, Condition.visible)
                , Duration.ofSeconds(15)).click(ClickOptions.usingJavaScript());
    }

    public void clickToAddMonogramButton() {
        addMonogram.should(Condition.and("", Condition.interactable, Condition.visible)
                , Duration.ofSeconds(15)).click(ClickOptions.usingJavaScript());
    }

    public void clickToEditMonogramButton() {
        editMonogramButton.should(Condition.and("", Condition.appear, Condition.visible)
                , Duration.ofSeconds(15)).click(ClickOptions.usingJavaScript());
    }

    public void selectMonogramKoutHdFont() {
        koutHdFontMonogram.should(Condition.visible).click();

    }

    public void selectGoldMetallicColorMonogram() {
        goldMetallicColorMonogram.click();

    }

    public void clickToMonogramCheckBox() {
        monogramCheckBox.should(Condition.and("", Condition.appear, Condition.visible)
                , Duration.ofSeconds(15)).click(ClickOptions.usingJavaScript());
    }

    public void verifyThatSpecialMessagesAreDisplayed() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        shipsFreeOfChargeViaStandarShipMsg.should(Condition.visible, Duration.ofSeconds(20));
        skuIdItemValue.should(Condition.visible, Duration.ofSeconds(20));
        //thisItemWillBeDelieveredMsg.should(Condition.visible, Duration.ofSeconds(20));
    }

    public void selectSizeOption() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        sizeOption.should(Condition.and("", Condition.interactable, Condition.visible,
                Condition.appear, Condition.enabled), Duration.ofSeconds(40));
        Select selectSize = new Select(sizeOption);
        selectSize.selectByIndex(2);
    }


    public void selectColorOption() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        sizeOption.should(Condition.and("", Condition.interactable, Condition.visible,
                Condition.appear), Duration.ofSeconds(40));
        Select selectColor = new Select(colorOption);
        selectColor.selectByIndex(3);
    }

    public void selectFinishOption() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        finishOption.should(Condition.and("", Condition.interactable, Condition.visible,
                Condition.appear, Condition.enabled), Duration.ofSeconds(40));
        Select selectFinishOption = new Select(finishOption);
        selectFinishOption.selectByIndex(1);
    }

}
