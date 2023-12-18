package tests.estore.pageObject;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstoreSaleScreen {

    private SelenideElement saleLivingNav = $(By.xpath("//li[@id='container-rhr-saleNavigation_sale-navigation-cat160024']//span"));

    private SelenideElement saleDiningNav = $(By.xpath("//li[@id='container-rhr-saleNavigation_sale-navigation-cat1840042']//span"));

    private SelenideElement saleBedNav = $(By.xpath("//li[@id='container-rhr-saleNavigation_sale-navigation-cat780002']//span"));

    private SelenideElement saleBathNav = $(By.xpath("//li[@id='container-rhr-saleNavigation_sale-navigation-cat160092']//span"));

    private SelenideElement saleOutdoorNav = $(By.xpath("//li[@id='container-rhr-saleNavigation_sale-navigation-cat180003']//span"));

    private SelenideElement beddingCollectionNav = $(By.xpath("//li[@id='container-rhr-saleNavigation_sale-navigation-category-cat28660046']//span"));

    private SelenideElement lightingNav = $(By.xpath("//li[@id='container-rhr-saleNavigation_sale-navigation-cat160075']//span"));

    private SelenideElement textilesSaleNav = $(By.xpath("//li[@id='container-rhr-saleNavigation_sale-navigation-cat9750013']//span"));

    private SelenideElement rugsSaleNav = $(By.xpath("//li[@id='container-rhr-saleNavigation_sale-navigation-cat1535014']//span"));

    private SelenideElement decorSaleNav = $(By.xpath("//li[@id='container-rhr-saleNavigation_sale-navigation-cat1630014']//span"));

    private SelenideElement allDiningTablesNav = $(By.xpath("//li[@id='container-rhr-saleNavigation_sale-navigation-category-cat28650054']//span"));

    private SelenideElement saleButtonMenu = $(By.xpath("//*[text()='SALE']"));

    private SelenideElement sofasButton = $(By.xpath("//*[text()='Living']"));

    private SelenideElement saleCategoryButton = $(By.xpath("//div[@data-navigation-account-item-id='cat3890154']"));

    private SelenideElement saleLivingCategory = $(By.xpath("//*[text()='Living']"));

    private SelenideElement saleDiningCategory = $(By.xpath("//*[text()='Dining']"));

    private SelenideElement bedLivingCategory = $(By.xpath("//*[text()='Bed']"));

    private SelenideElement textilesSaleCategory = $(By.xpath("//*[text()='Textiles']"));

    private SelenideElement bedBedsSale = $(By.xpath("//*[text()='Beds']"));

    private SelenideElement bedNightstandssSale = $(By.xpath("//*[text()='Nightstands']"));

    private SelenideElement bedDresserssSale = $(By.xpath("//*[text()='Dressers']"));

    private SelenideElement bedBenchesSale = $(By.xpath("//*[text()='Benches']"));

    private SelenideElement WashstandsSale = $(By.xpath("//*[text()='Washstands']"));

    private SelenideElement mirrorMedicineSale = $(By.xpath("//*[text()='Mirrors & Medicine Cabinets']"));

    private SelenideElement bathLightingSale = $(By.xpath("//*[text()='Bath Lighting']"));

    private SelenideElement bathTowelsSale = $(By.xpath("//*[text()='Bath Towels']"));

    private SelenideElement outdoorChairsSale = $(By.xpath("//*[text()='Chairs']"));

    private SelenideElement outdoorSideTableSale = $(By.xpath("//*[text()='Side Tables']"));

    private SelenideElement outdoorChaisesSale = $(By.xpath("//*[text()='Chaises']"));

    private SelenideElement outdoorOttomansSale = $(By.xpath("//*[text()='Ottomans']"));

    private SelenideElement ceilingLightingSale = $(By.xpath("//*[text()='Ceiling Lighting']"));

    private SelenideElement wallLightingSale = $(By.xpath("//*[text()='Wall Lighting']"));

    private SelenideElement tableLightigSale = $(By.xpath("//*[text()='Table Lighting']"));

    private SelenideElement floorLightingSale = $(By.xpath("//*[text()='Floor Lighting']"));

    private SelenideElement mainSaleList = $(By.xpath("(//div[@id='rhr-sale-navigation-dropdown']//ul[@class='MuiList-root'])//li/span"));

    private SelenideElement subSaleList = $(By.xpath("(//ul[@class='MuiList-root'])[2]//li[3]/span"));

    private SelenideElement memberSalePrice = $(By.xpath("(//p[@data-testid='price-for-member'])[1]"));

    private SelenideElement regularSalePrice = $(By.xpath("(//p[@data-testid='price-for-sale'])[1]"));

    private SelenideElement fabricCharisSaleNav = $(By.xpath("//div[@id='rhr-sale-navigation-dropdown']//*[text()='Fabric Chairs']"));

    private SelenideElement leatherCharisSaleNav = $(By.xpath("//div[@id='rhr-sale-navigation-dropdown']//*[text()='Leather Chairs']"));

    private SelenideElement coffeTablesSaleNav = $(By.xpath("//div[@id='rhr-sale-navigation-dropdown']//*[text()='Coffee Tables']"));

    private SelenideElement sideTablesSaleNav = $(By.xpath("//div[@id='rhr-sale-navigation-dropdown']//*[text()='Side Tables']"));

    private SelenideElement consoleTablesSaleNav = $(By.xpath("//div[@id='rhr-sale-navigation-dropdown']//*[text()='Console Tables']"));

    private SelenideElement allDiningTables = $(By.xpath("//div[@id='rhr-sale-navigation-dropdown']//*[text()='All Dining Tables']"));

    private SelenideElement barCounterStools = $(By.xpath("//div[@id='rhr-sale-navigation-dropdown']//*[text()='Bar & Counter Stools']"));

    private SelenideElement cabinetsDining = $(By.xpath("//div[@id='rhr-sale-navigation-dropdown']//*[text()='Cabinets']"));

    private SelenideElement textilesBeddingCollections = $(By.xpath("//div[@id='rhr-sale-navigation-dropdown']//*[text()='Bedding Collections']"));

    private SelenideElement textilesSheetsPilloecases = $(By.xpath("//div[@id='rhr-sale-navigation-dropdown']//*[text()='Sheets & Pillowcases']"));

    private SelenideElement textilesTHrowsBlankets = $(By.xpath("//div[@id='rhr-sale-navigation-dropdown']//*[text()='Throws & Blankets']"));

    private SelenideElement textilesBathTowels = $(By.xpath("//div[@id='rhr-sale-navigation-dropdown']//*[text()='Bath Towels']"));

    private SelenideElement rugsAllRugs = $(By.xpath("//div[@id='rhr-sale-navigation-dropdown'](//*[text()='All Rugs'])[4]"));

    private SelenideElement rugsNeutralRugs = $(By.xpath("//*[text()='Neutral Rugs']"));

    private SelenideElement rugsIvoryRugs = $(By.xpath("//*[text()='Ivory Rugs']"));

    private SelenideElement rugsBlueRugs = $(By.xpath("//*[text()='Blue Rugs']"));

    private SelenideElement decorMirrors = $(By.xpath("//*[text()='Mirrors']"));

    private SelenideElement decorBarCabinets = $(By.xpath("//*[text()='Bar Cabinets & Carts']"));

    private SelenideElement decorCabinetHardware = $(By.xpath("//*[text()='Cabinet Hardware']"));

    private SelenideElement decorThrowsBlankets = $(By.xpath("//*[text()='Throws & Blankets']"));

    private SelenideElement decorAllMirrorsTextSalePg = $(By.xpath("//*[text()='All Mirrors']"));

    private SelenideElement clearAllLink = $(By.xpath("//*[@id='refineMenuDropdown_clearAll-btn']"));

    private SelenideElement saleAppliedFilter = $(By.xpath("//*[@id='refineMenuDropdown_clear-Sale-btn']"));

    private SelenideElement inStockAppliedFilter = $(By.xpath("//*[@id='refineMenuDropdown_clear-In-Stock-btn']"));

    private SelenideElement gridView1 = $(By.xpath("//*[contains(@class,'cols-4')]"));

    private SelenideElement collectionImage = $(By.xpath("(//img[contains(@alt,'prod')])[1]"));

    private SelenideElement collectionTitle = $(By.xpath("(//span[text()='802-Gram Turkish Towel Collection'])[1]"));

    private SelenideElement saleVerbiageMessage = $(By.xpath("//*[text()='VIEW SELECT ITEMS ON SALE']"));

    private SelenideElement beddingCollectionTitle = $(By.xpath("//*[text()='Bedding  collections']"));

    private SelenideElement highToLowText = $(By.xpath("//*[text()='Price High to Low']"));


    public void verifyThatBeddingCollectionTitleIsDisplayedOnCG() {
        beddingCollectionTitle.should(Condition.visible, Duration.ofSeconds(18));
    }

    public void clickToBeddingCollectionNav() {
        beddingCollectionNav.should(Condition.visible,
                Duration.ofSeconds(12)).click(ClickOptions.usingJavaScript());
    }

    public void verifyThatSaleAppliedFilterWasRemoved() {
        saleAppliedFilter.shouldNotBe(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatSaleAppliedFilterIsDisplayed() {
        saleAppliedFilter.shouldBe(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatStockAppliedFilterWasRemoved() {
        inStockAppliedFilter.shouldNotBe(Condition.visible, Duration.ofSeconds(12));
    }

    public void clickToClearAllLink() {
        clearAllLink.should(Condition.visible, Duration.ofSeconds(12))
                .click(ClickOptions.usingJavaScript());
    }

    public void verifyThatDecorAllMirrorsTextSalePgIsDisplayed() {
        decorAllMirrorsTextSalePg.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatfabricChairsSaleNavIsDisplayed() {
        fabricCharisSaleNav.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatleatherCharisSaleNavSaleNavIsDisplayed() {
        leatherCharisSaleNav.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatcoffeTablesSaleNavIsDisplayed() {
        coffeTablesSaleNav.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatsideTablesSaleNavIsDisplayed() {
        sideTablesSaleNav.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatconsoleTablesSaleNavIsDisplayed() {
        consoleTablesSaleNav.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void clickToSaleLivingNav() {
        saleLivingNav.should(Condition.visible, Duration.ofSeconds(12)).hover()
                .click(ClickOptions.usingJavaScript());
    }

    public void clickToSaleDiningNav() {
        saleDiningNav.should(Condition.visible, Duration.ofSeconds(12)).hover()
                .click(ClickOptions.usingJavaScript());
    }

    public void clickToSaleBedNav() {
        saleBedNav.should(Condition.visible, Duration.ofSeconds(12)).hover()
                .click(ClickOptions.usingJavaScript());
    }

    public void clickToAllDiningTablesNav() {
        allDiningTablesNav.should(Condition.visible, Duration.ofSeconds(12)).hover()
                .click(ClickOptions.usingJavaScript());
    }

    public void clickToSaleBathNav() {
        saleBathNav.should(Condition.visible, Duration.ofSeconds(12)).hover()
                .click(ClickOptions.usingJavaScript());
    }

    public void clickToSaleOutdoorNavNav() {
        saleOutdoorNav.should(Condition.visible, Duration.ofSeconds(12)).hover()
                .click(ClickOptions.usingJavaScript());
    }

    public void clickToSaleLightingNavNav() {
        lightingNav.should(Condition.visible, Duration.ofSeconds(12)).hover()
                .click(ClickOptions.usingJavaScript());
    }

    public void clickToSaleTextsilesNav() {
        textilesSaleNav.should(Condition.visible, Duration.ofSeconds(12)).hover()
                .click(ClickOptions.usingJavaScript());
    }

    public void clickToSaleDecorNav() {
        decorSaleNav.should(Condition.visible, Duration.ofSeconds(12)).hover()
                .click(ClickOptions.usingJavaScript());
    }

    public void clickToSaleRugsNav() {
        rugsSaleNav.should(Condition.visible, Duration.ofSeconds(12)).hover()
                .click(ClickOptions.usingJavaScript());
    }


}
