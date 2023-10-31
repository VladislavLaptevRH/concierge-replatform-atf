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

    private SelenideElement lightingNav = $(By.xpath("//li[@id='container-rhr-saleNavigation_sale-navigation-cat160075']//span"));

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

    private SelenideElement mainSaleList = $(By.xpath("(//ul[@class='MuiList-root'])[1]//li[1]/span"));

    private SelenideElement subSaleList = $(By.xpath("(//ul[@class='MuiList-root'])[2]//li[3]/span"));

    private SelenideElement memberSalePrice = $(By.xpath("(//p[@data-testid='price-for-member'])[1]"));

    private SelenideElement regularSalePrice = $(By.xpath("(//p[@data-testid='price-for-sale'])[1]"));

    private SelenideElement fabricCharisSaleNav = $(By.xpath("//*[text()='Fabric Chairs']"));

    private SelenideElement leatherCharisSaleNav = $(By.xpath("//*[text()='Leather Chairs']"));

    private SelenideElement coffeTablesSaleNav = $(By.xpath("//*[text()='Coffee Tables']"));

    private SelenideElement sideTablesSaleNav = $(By.xpath("//*[text()='Side Tables']"));

    private SelenideElement consoleTablesSaleNav = $(By.xpath("//*[text()='Console Tables']"));

    private SelenideElement allDiningTables = $(By.xpath("//*[text()='All Dining Tables']"));

    private SelenideElement barCounterStools = $(By.xpath("//*[text()='Bar & Counter Stools']"));

    private SelenideElement cabinetsDining = $(By.xpath("//*[text()='Cabinets']"));


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

}
