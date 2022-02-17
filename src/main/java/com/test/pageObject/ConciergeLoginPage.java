package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ConciergeLoginPage {
    //    private SelenideElement usernameField = $(By.xpath("//input[@id='username']"));
    private SelenideElement usernameField = $(By.xpath("//input[@id='username']"));

    private SelenideElement passwordField = $(By.xpath("//input[@id='password']"));

    private SelenideElement sumbitButton = $(By.xpath("//button[@class='login-form__submit']"));

    private SelenideElement location = $(By.xpath("//select[@id='location']"));

    private SelenideElement continueButton = $(By.xpath("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]"));

    private SelenideElement locationNewPortBeach = $(By.xpath("//*[@id='location']/option[2]"));

    private SelenideElement locationWestHolywood = $(By.xpath("//*[@id='location']/option[36]"));

    private SelenideElement signInButton = $(By.xpath("//button[@class='login-form__submit']"));


}
