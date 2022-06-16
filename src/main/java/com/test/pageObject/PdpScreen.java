package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Getter
public class PdpScreen {

    private SelenideElement specialOrdersButton = $(By.xpath("//div[@data-testid='SELECT FROM 12 STOCKED AND 121 SPECIAL ORDER FabricS']"));

    private SelenideElement fogSpecialOrderColor = $(By.xpath("(//ul[@class='MuiGridList-root']//li)[5]"));

    private SelenideElement fogSelectedOption = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Color')])[1]//option[@data-option='selected']"));

    private SelenideElement closeSpecialOrderPopUpButton = $(By.xpath("//div[@class='MuiDialogTitle-root']//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit']"));

}
