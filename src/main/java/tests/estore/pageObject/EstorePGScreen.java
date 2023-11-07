package tests.estore.pageObject;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class EstorePGScreen {
    private final SelenideElement firstSearchElement = $(By.xpath("(//div[contains(@id,'RH_')])[1]"));

    private final SelenideElement sofa = $(By.xpath("//*[text()='sofa']"));

    private final SelenideElement gridView3 = $(By.xpath("(//div[contains(@class,'MuiGrid-grid-xs-4')])[1]"));

    private final SelenideElement gridView2 = $(By.xpath("(//div[contains(@class,'MuiGrid-grid-xs-6')])[4]"));

    private final SelenideElement postponeShipOnOrAfterDate = $(By.xpath("//p[@id='ship-on-or-after-date']"));

    private final SelenideElement soldToAddressTitle = $(By.xpath("//*[text()='Sold To Address']"));

    private final SelenideElement billingAddressTitle = $(By.xpath("//*[text()='Billing Address']"));

    private final SelenideElement shippingAddressTitle = $(By.xpath("//*[text()='Shipping Address']"));

    private final SelenideElement joinNow = $(By.xpath("//*[text()='JOIN NOW']"));

    private final SelenideElement applyUpperCaseBtn = $(By.xpath("//*[text()='APPLY']"));

    private final SelenideElement rhGiftCardBalance = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item'][1]/p"));

    private final SelenideElement spaceDropDown = $(By.xpath("//div[1]/button//div[contains(@class,'MuiGrid-root MuiGrid-container')]"));

    private final SelenideElement giftBoxFee = $(By.xpath("//*[text()='Gift Box Fee']"));

    private final SelenideElement memberLabel = $(By.xpath("//p[@data-testid='price-label-member']"));

    private final SelenideElement zipCodeField = $(By.xpath("//input[@name='newPostalCode']"));

    private final SelenideElement regularItemPrice = $(By.xpath("(//p[@id='price'])[1]"));

    private final SelenideElement removePromotionBtn = $(By.xpath("//div[@class='MuiGrid-root']//*[text()='Remove']"));

    private final SelenideElement totalAditionalProdDiscount = $(By.xpath("//*[text()='Total Additional Product Discount']"));

    private final SelenideElement applyToAllCheckbox = $(By.xpath("//input[@name='applyToCart']"));

    private final SelenideElement applyPostponeShipBtn = $(By.xpath("//*[@id=\"postpone-shipment\"]//*[text()='APPLY']"));

    private final SelenideElement addressButton = $(By.xpath("//li[@class='MuiBreadcrumbs-li'][1]/a"));

    private final SelenideElement contractSavings = $(By.xpath("//*[text()='Contract savings']"));

    private final SelenideElement quantitySelect = $(By.xpath("//select[contains(@id,'quantity')]"));

    private final SelenideElement totalLineItemPrice = $(By.xpath("//div[@id='rh-line-item-card_total']"));

    private final SelenideElement viewGiftBoxBtn = $(By.xpath("//a[@href='#']"));

    private final SelenideElement saleButtonFilter = $(By.xpath("//*[text()='sale']"));

    private final SelenideElement inStockFilter = $(By.xpath("//*[text()='in-stock']"));

    private final SelenideElement materialFilter = $(By.xpath("//*[text()='Material']"));

    private final SelenideElement sizeFilter = $(By.xpath("//*[text()='Size']"));

    private final SelenideElement clearAll = $(By.xpath("//*[text()='Clear All']"));

    private final SelenideElement sortFilter = $(By.xpath("//*[text()='sort']"));

    private final SelenideElement saleFilterApplied = $(By.xpath("(//*[text()='sale'])[1]"));

    private final SelenideElement thumbalImg = $(By.xpath("//img[contains(@alt,'prod')]"));

    private final List<SelenideElement> listOfPgFusionElements = $$(By.xpath("//*[@id='component-rh-image_wrapper']"));

    private final SelenideElement livingCategory = $(By.xpath("//*[@data-navigation-account-item-id='cat160024']"));

    private final SelenideElement collectionTextTitle = $(By.xpath("//*[contains(text(),'RESULTS')]"));

    private final SelenideElement regularSalePrice = $(By.xpath("(//*[@data-testid='price-for-sale'])[1]"));

    private final SelenideElement memberSalePrice = $(By.xpath("(//*[@data-testid='price-for-member'])[1]"));

    private final SelenideElement regularPrice = $(By.xpath("(//*[@data-testid='price-for-regular'])[1]"));

    private final SelenideElement memberPrice = $(By.xpath("(//*[@data-testid='price-for-member'])[1]"));

    private final SelenideElement inStockFilterPG = $(By.xpath("//input[@name='In-Stock' and @type='checkbox']"));

    private final SelenideElement inStockTextFilterPG = $(By.xpath("//*[text()='in-stock']"));

    private final SelenideElement inStockColorText = $(By.xpath("(//p[@id='listColumn1-Color'])[1]"));

    private final SelenideElement inStockFilterColorizedImage = $(By.xpath("(//img[contains(@alt,'prod')])[1]"));

    private final SelenideElement PgCarousel = $(By.xpath("//*[@data-analytics-id='link']"));

    private final SelenideElement PgCarouselContent = $(By.id("component-product-grid"));

    private final List<SelenideElement> pgItems = $$(By.xpath("//div[@id='component-rh-image_wrapper']"));

    private SelenideElement resultsText = $(By.xpath("//*[text()='RESULTS']"));

    private SelenideElement finishText = $(By.xpath("//*[text()='Finish']"));

    private SelenideElement sizeText = $(By.xpath("//*[text()='Size']"));

    private SelenideElement colorOpionPG = $(By.xpath("(//*[@id='listColumn2-Color'])[1]"));

    private SelenideElement sizeOptionPG = $(By.xpath("(//*[@id='listColumn2-Size'])[1]"));

    private SelenideElement pgTitleBeds = $(By.xpath("//*[text()='All Beds']"));

    private SelenideElement sortByButtonFeatured = $(By.xpath("//*[text()='Featured']"));

    private SelenideElement grid3x3 = $(By.xpath("//div[contains(@class,'cols-4 ')]"));

    private SelenideElement sizeFinishesMessage = $(By.xpath("//*[text()='Available in multiple sizes & finishes']"));

    public void verifyThatPgTitleIsDisplayed(String title) {
        $(By.xpath("//h1[contains(text(),'" + title + "')]")).should(Condition.visible, Duration.ofSeconds(14));
    }

    public void sizeFinishesMessageIsDisplayed() {
        sizeFinishesMessage.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatGrid3x3SelectedByDefault() {
        grid3x3.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatSortByButtonFeaturedIsDisplayed() {
        sortByButtonFeatured.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatPgTitleBedIsDisplayed() {
        pgTitleBeds.should(Condition.visible, Duration.ofSeconds(12));
    }

    public int verifyCountOfPgItemsonThePage() {
        return pgItems.size();
    }

    public void verifyThatColorizedImagesAreDisplayed() {
        inStockColorText.should(Condition.visible, Duration.ofSeconds(12));
        inStockFilterColorizedImage.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void clickToInStockFilterPG() {
        inStockTextFilterPG.should(Condition.visible, Duration.ofSeconds(12));
        inStockFilterPG.click(ClickOptions.usingJavaScript());
    }

    public int getRegularPriceOnPg() {
        return Integer.parseInt(regularPrice.getText().replaceAll("[^0-9]", ""));
    }

    public int getMemberPriceOnPg() {
        return Integer.parseInt(memberPrice.getText().replaceAll("[^0-9]", ""));
    }

    public int getRegularSaleOnPgPrice() {
        return Integer.parseInt(regularSalePrice.getText().replaceAll("[^0-9]", ""));
    }

    public int getMemberSaleOnPgPrice() {
        return Integer.parseInt(memberSalePrice.getText().replaceAll("[^0-9]", ""));
    }
}


