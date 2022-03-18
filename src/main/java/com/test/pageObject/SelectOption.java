package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class SelectOption {

    private final SelenideElement lancasterColor = $(By.xpath("//select[@id='optionSelect-4']"));

    private final List<SelenideElement> lancastColorsList = $$(By.xpath("//select[@id='optionSelect-4']//option"));

    private final SelenideElement quantityOfLancasterOption = $(By.cssSelector("#quantity_I51173680"));

    private final SelenideElement quantityOfLancasterSofa = $(By.id("quantity_I24388989"));

    private final SelenideElement quantityBtn= $(By.id("quantity"));

    private final SelenideElement sizeOption = $(By.xpath("//select[@id='optionSelect--Size']"));

    private final SelenideElement quantityElement = $(By.xpath("//select[contains(@id,'prod') and contains(@id,'qty')]"));

    private final SelenideElement selectColorElement = $(By.xpath("//select[contains(@id,'prod') and contains(@id,'Color')]"));

    private final SelenideElement selectSizeElement = $(By.xpath("//select[contains(@id,'prod') and contains(@id,'Size')]"));


}
