package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class SelectOption {

    private final SelenideElement sizeOption = $(By.xpath("//select[@id='optionSelect--Size']"));

    private final SelenideElement quantityElement = $(By.xpath("//select[contains(@id,'prod') and contains(@id,'qty')]"));

    private final SelenideElement selectColorElement = $(By.xpath("//select[contains(@id,'prod') and contains(@id,'Color')]"));

    private final SelenideElement selectSizeElement = $(By.xpath("//select[contains(@id,'prod') and contains(@id,'Size')]"));


}
