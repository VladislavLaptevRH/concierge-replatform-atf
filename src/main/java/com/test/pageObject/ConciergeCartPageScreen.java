package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ConciergeCartPageScreen {

    private final SelenideElement arlesRectangularDinigTableId = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12']/div/div/div[1]//p[@id='listColumn2-Item#']"));

    private final SelenideElement shoppingCartEmpty = $(By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1']"));

    private final SelenideElement pleaseContinueBrowsingButton = $(By.xpath("//div[@id='spa-root']/div/main//a"));

    private final SelenideElement arlesRectangularDinigTableTitle = $(By.xpath("//h3[normalize-space()='Arles Rectangular Dining Table']"));

    private final SelenideElement gramTurkishTowel = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12']/div/div/div[2]//p[@id='listColumn2-Item#']"));

    private final SelenideElement gramTurkishTitle = $(By.xpath("//h3[normalize-space()='802-Gram Turkish Towel Collection']"));

    private final SelenideElement quantityButton = $(By.xpath("//select[@id='quantity_701bfc45-0262-4a2c-bf01-92887d788333_1']"));

    private final SelenideElement orderClassificationSelect = $(By.xpath("//select[@id='element-orderclassification']"));

    private final SelenideElement membersProgramTitle = $(By.xpath("//h2[@class='MuiTypography-root MuiTypography-h2 MuiTypography-noWrap']"));

    private final SelenideElement closePopUp = $(By.xpath("//button[@data-testid='form-dialog-close-button']"));

    private final SelenideElement noThanksButton = $(By.xpath("//*[text()='NO, THANKS']"));

    private final SelenideElement totalMemberPrice = $(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-alignRight']"));
}
