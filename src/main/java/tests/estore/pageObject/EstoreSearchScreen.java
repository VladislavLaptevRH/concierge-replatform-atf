package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.eo.Se;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstoreSearchScreen {

    private SelenideElement results = $(By.xpath("//*[contains(text(),'RESULTS')]"));

    private SelenideElement threeColumnsInRowGridButton = $(By.xpath("(//*[local-name()='svg' and @data-active='false'])[1]"));

    private SelenideElement oneColumnInRowGridButton = $(By.xpath("(//*[local-name()='svg' and @data-active='false'])[2]"));

    private SelenideElement threeColumnsInRowGridElement = $(By.xpath("//div[contains(@class,'MuiGrid-grid-xs-4')]"));

    private SelenideElement twoColumnsInRowGridElement = $(By.xpath("(//*[local-name()='svg' and @data-active='false'])[1]"));

    private SelenideElement turkish802towel = $(By.xpath("//*[text()='802-GRAM TURKISH TOWEL COLLECTION']"));

    private SelenideElement searchIcon = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item'])[2]"));

    private SelenideElement sorryWeCannotFindMsg = $(By.xpath("//*[text()='We’re sorry, we cannot find what you are looking for.']"));

    private SelenideElement seeAllResultsButton = $(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedSecondary']"));

    private SelenideElement searchButton = $(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedSecondary']"));

    private SelenideElement hamburgerIcon = $(By.xpath("//div[@id='hamburgerIcon']"));

    private SelenideElement saveText = $(By.xpath("//*[text()='SAVE UP TO 70% AS AN RH MEMBER*']"));

    private SelenideElement upToText = $(By.xpath("//*[text()='up to']"));

    private SelenideElement save70 = $(By.xpath("//*[text()=' 70%']"));


}
