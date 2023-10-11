package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstoreSearchScreen {

    private SelenideElement memberLabelPriceCollectionPage = $(By.xpath("//p[@data-testid='price-label-member']"));

    private SelenideElement regularLabelPriceCollectionPage = $(By.xpath("//p[@data-testid='price-label-regular']"));

    private SelenideElement regularPriceCollectionPage = $(By.xpath("(//p[@data-testid='price-for-regular'])[1]"));

    private SelenideElement memberPriceCollectionPage = $(By.xpath("(//p[@data-testid='price-for-member'])[1]"));

    private SelenideElement results = $(By.xpath("//*[contains(text(),'Results')]"));

    private SelenideElement threeColumnsInRowGridButton = $(By.xpath("//*[@column='3']"));

    private SelenideElement oneColumnInRowGridButton = $(By.xpath("(//*[contains(@class, 'MuiSvgIcon-root')])[7]"));

    private SelenideElement threeColumnsInRowGridElement = $(By.xpath("//div[contains(@class,'MuiGrid-grid-xs-4')]"));

    private SelenideElement twoColumnsInRowGridElement = $(By.xpath("(//*[contains(@class, 'MuiSvgIcon-root')])[6]"));

    private SelenideElement turkish802towel = $(By.xpath("//*[text()='802-GRAM TURKISH TOWEL COLLECTION']"));

    private SelenideElement searchIcon = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item'])[2]"));

    private SelenideElement sorryWeCannotFindMsg = $(By.xpath("//*[text()='We’re sorry, we cannot find what you are looking for.']"));

    private SelenideElement seeAllResultsButton = $(By.xpath("//*[text() = 'SEE ALL RESULTS']"));

    private SelenideElement searchButton = $(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedSecondary']"));

    private SelenideElement hamburgerIcon = $(By.xpath("//div[@id='hamburgerIcon']"));

    private SelenideElement saveText = $(By.xpath("//*[text()='SAVE UP TO 70% AS AN RH MEMBER*']"));

    private SelenideElement salePageBanner = $(By.xpath("//img[@data-id='component-salepage-banner']"));

    private SelenideElement upToText = $(By.xpath("//*[text()='up to']"));

    private SelenideElement save70 = $(By.xpath("//*[text()=' 70%']"));


}
