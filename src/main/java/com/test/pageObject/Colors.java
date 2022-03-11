package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class Colors {

    private SelenideElement pewterColor = $(By.xpath("//*[text()='Pewter ']"));

    private SelenideElement ebonyColor = $(By.xpath("//*[text()='Ebony ']"));

    private SelenideElement espressoColor = $(By.xpath("//*[text()='Espresso ']"));

    private SelenideElement chestnut = $(By.xpath("//*[text()='Chestnut ']"));

    private SelenideElement cocoa = $(By.xpath("//*[text()='Cocoa ']"));

    private SelenideElement ebony = $(By.xpath("//*[text()='Ebony ']"));

}
