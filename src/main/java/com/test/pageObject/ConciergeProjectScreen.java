package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ConciergeProjectScreen {

    private final SelenideElement addToCartButton = $(By.xpath("/html/body/div[3]/div/main/div/div[3]/div/div/div/div/div/div/div[2]/div/div/div[4]/div/div/div[2]/button[1]"));

    private final SelenideElement pricingTypeDropdown = $(By.cssSelector("#pricingTypeDropdown"));

    private final SelenideElement continueCreateAProjectButton = $(By.xpath("//*[text()='CONTINUE']"));

    private final SelenideElement continueButtonPopUp = $(By.xpath("//div[contains(@class,'MuiGrid-justify-xs-center')][1]/button"));

    private final SelenideElement projectTitle = $(By.xpath("//h4[contains(@class,'MuiTypography-h4 MuiTypography-colorInherit')]"));

    private final SelenideElement searchBySelect = $(By.cssSelector("#demo-simple-select-outlined"));

    private final SelenideElement projectNameField = $(By.xpath("//input[@id='projectName']"));

    private final SelenideElement clientFirstNameField = $(By.xpath("//input[@id='text1']"));

    private final SelenideElement clientLastNameField = $(By.xpath("//input[@id='text2']"));

    private final SelenideElement selectLocationProject = $(By.xpath("//div[@id='mui-component-select-location']"));

    private final SelenideElement projectNameButton = $(By.xpath("//li[@data-value='projectName']"));

    private final SelenideElement clientNameButton = $(By.xpath("//li[@data-value='clientName']"));

    private final SelenideElement projectIdButton = $(By.xpath("//li[@data-value='projectId']"));

    private final SelenideElement projectIdField = $(By.xpath("//input[@id='projectId']"));

    private final SelenideElement pricingType = $(By.xpath("//li[@data-value='pricingType']"));

    private final SelenideElement rhLocationButton = $(By.xpath("//li[@data-value='gallery']"));

    private final SelenideElement createdByButton = $(By.xpath("//li[@data-value='createdBy']"));

    private final SelenideElement editedBy = $(By.xpath("//li[@data-value='editedBy']"));

    private final SelenideElement searchByButton = $(By.xpath("//*[text()='SEARCH']"));

    private final SelenideElement searchResultsTitle = $(By.xpath("//*[contains(text(),'SEARCH RESULTS')]"));

    private final SelenideElement myProjectsButton = $(By.xpath("//*[text()='MY PROJECTS']"));

    private final SelenideElement resultsListForProjects = $(By.xpath("//div[contains(@class,'MuiGrid-align-items-xs-flex-start')]"));

    private final SelenideElement regularPricingType = $(By.xpath("//li[@data-value='NON_MEMBER']"));

    private final SelenideElement memberPricingType = $(By.xpath("//li[@data-value='MEMBER']"));

    private final SelenideElement tradePricingType = $(By.xpath("//li[@data-value='TRADE']"));

    private final SelenideElement pricingTypeSelect = $(By.cssSelector("#mui-component-select-type"));

    private final SelenideElement newProjectButton = $(By.xpath("//*[text()='New Project']"));

    private final SelenideElement preferredContactMethodSelect = $(By.xpath("//div[contains(@class,'MuiInputBase-fullWidth MuiInputBase-formControl')]/div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input']"));

    private final SelenideElement preferredContactMethod = $(By.xpath("//*[text()='Phone']"));

    private final SelenideElement preferredEmailContactMethod = $(By.xpath("//*[text()='Email']"));

    private final SelenideElement createProjectDetailsDescriptionField = $(By.xpath("//textarea"));

    private final SelenideElement createProjectButton = $(By.xpath("//*[text()='CREATE PROJECT']"));

    private final SelenideElement saveMoveToProject = $(By.xpath("//*[text()='Save']"));

    private final SelenideElement forecastSetButton = $(By.xpath("//*[text()='FORECAST SET']"));

    private final SelenideElement settingsButton = $(By.xpath("//*[text()='SETTINGS']"));

    private final SelenideElement printButton = $(By.xpath("//*[text()='Print']"));

    private final SelenideElement items = $(By.xpath("//*[contains(text(),'ITEMS')]"));

    private final SelenideElement qty = $(By.xpath("//*[contains(text(),'QTY')]"));

    private final SelenideElement subtotal = $(By.xpath("//*[contains(text(),'SUBTOTAL')]"));

    private final SelenideElement totalPrice = $(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 MuiTypography-alignCenter']"));

    private final SelenideElement availabilityDeliveryButtons = $(By.xpath("//div[@id='panel1a-header']"));

    private final SelenideElement projectName = $(By.xpath("//select[@name='projectName']"));

    private final SelenideElement spaceName = $(By.xpath("//select[@name='spaceName']"));

    private final SelenideElement moveToProjectButton = $(By.xpath("//div[contains(@class,'MuiGrid-grid-md-12')]//*[text()='Move to Project']"));

    private final SelenideElement projectResultsFirstRow = $(By.xpath("//tr[contains(@class,'MuiTableRow-root')]/td[1]"));

    private final SelenideElement firstSearchResultOfProjects = $(By.xpath("//div[contains(@class,'MuiGrid-root MuiGrid-container MuiGrid-align-items-xs-flex-start')][1]/div[contains(@class,'MuiGrid-root MuiGrid-item')]/div[1]"));

    private final SelenideElement emailEstimateProjectScreen = $(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-fullWidth']"));

    private final SelenideElement emailEstimateButton = $(By.cssSelector("button[type='submit'] span[class='MuiButton-label']"));

    private final SelenideElement emailEstimateEmailField = $(By.xpath("//input[@name='email']"));

    private final SelenideElement emailEstimateMessageToClient = $(By.xpath("//textarea[@name='message']"));

    private final SelenideElement emailEstimateAdditionEmailField = $(By.xpath("//input[@name='cc']"));

    private final SelenideElement goToProjectButton = $(By.xpath("//*[text()='GO TO PROJECT']"));

    private final SelenideElement opportunityNameField = $(By.xpath("//div[3]/div/div/div[1]//input"));

    private final SelenideElement selectPreferredContactMethod = $(By.cssSelector(".MuiSelect-root.MuiSelect-select.MuiSelect-selectMenu.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input"));

    private final SelenideElement opportunityDescription = $(By.cssSelector(".MuiInputBase-input.MuiOutlinedInput-input.MuiInputBase-inputMultiline.MuiOutlinedInput-inputMultiline[aria-invalid='true']"));

    private final SelenideElement selectOpportunityName = $(By.xpath("//select[@name='opportunityName']"));

    private final SelenideElement opportunityPhase4Value = $(By.xpath("//*[text()='A. Member - Phase 4']"));

    private final SelenideElement createOpportunityButton = $(By.xpath("//*[text()='CREATE OPPORTUNITY']"));

    private final SelenideElement addOpportunityButton = $(By.xpath("//span[@aria-label='Add Opportunity']"));

    private final SelenideElement bccAssociateCheckBox = $(By.xpath("//*[text()='BCC Associate']"));

    private final SelenideElement aMemberValue = $(By.xpath("//*[text()='A. Member']"));

    private final SelenideElement testCompanyValue = $(By.xpath("//*[text()='TestCompany']"));

    private final SelenideElement selectSpaceName = $(By.xpath("//select[@name='spaceName']"));

    private final SelenideElement test1Space = $(By.xpath("//option[text()='test1']"));

    private final SelenideElement test2Space = $(By.xpath("//option[text()='test2']"));

    private final SelenideElement itemIdSpan = $(By.xpath("//*[text()='Item#']"));

    private final SelenideElement REMOVEbutton = $(By.xpath("//*[text()='REMOVE']"));

    private final SelenideElement amount7295 = $(By.xpath("//*[text()='$7,295.00']"));

    private final SelenideElement amount50 = $(By.xpath("//*[text()='$50.00']"));

    private final SelenideElement amount549 = $(By.xpath("//*[text()='$549.00']"));

    private final SelenideElement amount4923 = $(By.xpath("//*[text()='$4,923.90']"));

    private final SelenideElement percentDiscount = $(By.id("outlined-helperText"));

    private SelenideElement dollarAmountField = $(By.id("dollar-amount"));

    private SelenideElement shippingOverridePriceReason = $(By.id("override-reason"));

    private SelenideElement reasonCode = $(By.id("reasoncode-select-outlined"));

    private SelenideElement applyButton = $(By.xpath("//*[text()='Apply']"));

    private SelenideElement percentOffSelect = $(By.id("method-select-outlined"));

    private SelenideElement lancasterSofaQty = $(By.id("quantity_I51173680"));

    private SelenideElement mirrorSize = $(By.id("optionSelect-0"));

    private SelenideElement finishOption = $(By.id("optionSelect-1"));

    private SelenideElement forecastamountValue = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-2'][3]/div"));

    private SelenideElement itemProjectPrice = $(By.xpath("//div[1]/p[@class='MuiTypography-root MuiTypography-body1']"));

    private SelenideElement printPopUp = $(By.id("documentInfo"));

    private final SelenideElement checkMarkItemButton = $(By.xpath("//div/div/div[2]/div/div/div/div/div/div[1]//div[1]//button[2]"));

    private final SelenideElement foreCastAmount = $(By.xpath("//div[2]//div[3]//div[1]//div[5]/div[1]"));

    private final SelenideElement editItemOptions = $(By.xpath("//div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div[1]/div/button[1]"));

    private SelenideElement regularPriceValue = $(By.cssSelector(".MuiTypography-root.MuiTypography-body1.MuiTypography-alignCenter"));

    private SelenideElement addToProjectProjectName = $(By.id("project-name-select"));

    private SelenideElement prieItemFromProject = $(By.xpath("//div[2]/div[@class='MuiGrid-root MuiGrid-item'][1]/p"));

    private final SelenideElement emailEstimateSendButton = $(By.cssSelector("button[type='submit'] span[class='MuiButton-label']"));
}
