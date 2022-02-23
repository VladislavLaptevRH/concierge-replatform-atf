package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ConciergeProjectScreen {

    private SelenideElement settingsButton = $(By.xpath("//div[1]/button[contains(@class,'MuiButton-fullWidth')]"));

    private SelenideElement forecastSetButton = $(By.xpath("//div[2]/button[contains(@class,'MuiButton-fullWidth')]"));

    private SelenideElement addToCartButton = $(By.xpath("/html/body/div[3]/div/main/div/div[3]/div/div/div/div/div/div/div[2]/div/div/div[4]/div/div/div[2]/button[1]"));

    private SelenideElement emailEstimateButton = $(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-fullWidth']"));

    private SelenideElement nonMemberButton = $(By.id("pricingTypeDropdown"));

    private SelenideElement continueCreateAProjectButton = $(By.xpath("//*[text()='CONTINUE']"));

    private SelenideElement continueButtonPopUp = $(By.xpath("//div[contains(@class,'MuiGrid-justify-xs-center')][1]/button"));

    private SelenideElement projectTitle = $(By.xpath("//h4[contains(@class,'MuiTypography-h4 MuiTypography-colorInherit')]"));

    private SelenideElement searchBySelect = $(By.xpath("//div[@id='demo-simple-select-outlined']"));

    private SelenideElement projectNameField = $(By.xpath("//input[@id='projectName']"));

    private SelenideElement clientFirstNameField = $(By.xpath("//input[@id='text1']"));

    private SelenideElement clientLastNameField = $(By.xpath("//input[@id='text2']"));

//    private SelenideElement pricingType = $(By.xpath("//div[@id='mui-component-select-type']"));

    private SelenideElement selectLocationProject = $(By.xpath("//div[@id='mui-component-select-location']"));

    private SelenideElement projectNameButton = $(By.xpath("//li[@data-value='projectName']"));

    private SelenideElement clientNameButton = $(By.xpath("//li[@data-value='clientName']"));

    private SelenideElement projectIdButton = $(By.xpath("//li[@data-value='projectId']"));

    private SelenideElement projectIdField = $(By.xpath("//input[@id='projectId']"));

    private SelenideElement pricingType = $(By.xpath("//li[@data-value='pricingType']"));

    private SelenideElement rhLocationButton = $(By.xpath("//li[@data-value='gallery']"));

    private SelenideElement createdByButton = $(By.xpath("//li[@data-value='createdBy']"));

    private SelenideElement editedBy = $(By.xpath("//li[@data-value='editedBy']"));

    private SelenideElement searchByButton = $(By.xpath("//*[text()='SEARCH']"));

    private SelenideElement searchResultsTitle = $(By.xpath("//*[contains(text(),'SEARCH RESULTS')]"));

    private SelenideElement myProjectsButton = $(By.xpath("//*[text()='MY PROJECTS']"));

    private SelenideElement resultsListForProjects = $(By.xpath("//div[contains(@class,'MuiGrid-align-items-xs-flex-start')]"));

    private SelenideElement regularPricingType = $(By.xpath("//li[@data-value='NON_MEMBER']"));

    private SelenideElement memberPricingType = $(By.xpath("//li[@data-value='MEMBER']"));

    private SelenideElement tradePricingType = $(By.xpath("//li[@data-value='TRADE']"));

    private SelenideElement pricingTypeSelect = $(By.xpath("//div[@id='mui-component-select-type']"));

    private SelenideElement newProjectButton = $(By.xpath("//*[text()='New Project']"));

    private SelenideElement prefferedContactMethodSelect = $(By.xpath("//div[contains(@class,'MuiInputBase-fullWidth MuiInputBase-formControl')]/div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input']"));

    private SelenideElement prefferedContactMethod = $(By.xpath("//*[text()='Phone']"));

    private SelenideElement prefferedEmailContactMethod = $(By.xpath("//*[text()='Email']"));

    private SelenideElement createProjectDetailsDescriptionField = $(By.xpath("//textarea"));

    private SelenideElement createProjectButton = $(By.xpath("//*[text()='CREATE PROJECT']"));

}
