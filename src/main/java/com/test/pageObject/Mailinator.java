package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class Mailinator {

    private SelenideElement searchEmailField = $(By.xpath("//input[@id='search']"));

    private SelenideElement goButton = $(By.xpath("//*[text()='GO']"));

    private SelenideElement firstLetter = $(By.xpath("//td[@class='ng-binding'][1]"));

    private SelenideElement messageBodyIframe = $(By.id("html_msg_body"));

    private SelenideElement yourEstimateTitle = $(By.xpath("//*[contains(text(),'Your Estimate for')]"));

    private SelenideElement associateName = $(By.xpath("//*[contains(text(),'Automation Associate')]"));

    private SelenideElement bodyEmailText = $(By.xpath("//*[contains(text(),'this is test description')]"));

}
