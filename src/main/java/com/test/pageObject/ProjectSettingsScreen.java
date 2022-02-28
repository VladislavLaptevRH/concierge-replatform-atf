package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ProjectSettingsScreen {

    private final SelenideElement updateProjectSettingsTitle = $(By.xpath("//div/h6[@class='MuiTypography-root MuiTypography-subtitle2']"));

    private final SelenideElement accountDetails = $(By.xpath("//*[text()='Account Details']"));

    private final SelenideElement sameShippingCheckBox = $(By.xpath("//*[text()='Same Shipping']"));

    private final SelenideElement usdCurrency = $(By.xpath("//*[text()='USD']"));

    private final SelenideElement cadCurrency = $(By.xpath("//li[@data-value='CAD']"));

    private final SelenideElement galleryButton = $(By.xpath("//button[@value='GALLERY']"));

    private final SelenideElement designButton = $(By.xpath("//button[@value='DESIGN']"));

    private final SelenideElement tradeButton = $(By.xpath("//button[@value='TRADE']"));

    private final SelenideElement projectNameFieldSpan = $(By.xpath("//*[text()='Project Name']"));

    private final SelenideElement opportunityNameFieldSpan = $(By.xpath("//*[text()='Opportunity Name']"));

    private final SelenideElement desiredDeliveryDate = $(By.xpath("//*[text()='Desired Delivery Date']"));

    private final SelenideElement purchasingDeadlineSpan = $(By.xpath("//*[text()='Purchasing Deadline']"));

    private final SelenideElement preferredContactMethodSpan = $(By.xpath("//*[text()='Preferred Contact Method']"));

    private final SelenideElement descriptionSpan = $(By.xpath("//*[text()='Description']"));

    private final SelenideElement spaceNameSpan = $(By.xpath("//input[@id='spaceName']"));

    private final SelenideElement addSpaceButton = $(By.xpath("//*[text()='ADD SPACE']"));

    private final SelenideElement updateProjectSettingsBtn = $(By.xpath("//*[text()='UPDATE PROJECT SETTINGS']"));

    private final SelenideElement moodboardDeactiveButton = $(By.xpath("//button[@aria-pressed='false']"));

    private final SelenideElement moodBoardButton = $(By.xpath("//*[text()='MOODBOARD']"));

}
