package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter

public class ConciergeOrderHistoryForm {

    private final SelenideElement backToSearchResultsButton = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12'][2]/a"));

    private final SelenideElement orderHistoryTitle = $(By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1']"));

    private final SelenideElement customerLookUp = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6'][1]//h6"));

    private final SelenideElement phoneNumberField = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[1]//input"));

    private final SelenideElement firstNameField = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[2]//input"));

    private final SelenideElement lastNameField = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[3]//input"));

    private final SelenideElement emailAddressField = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[4]//input"));

    private final SelenideElement postalCodeField = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[5]//input"));

    private final SelenideElement memberIdField = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[6]//input"));

    private final SelenideElement businessAccountNumberField = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[7]//input"));

    private final SelenideElement companyNameField = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[8]//input"));
    
    private final SelenideElement inactiveContinueButton = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-sm-12']//div[contains(@class,'MuiGrid-root MuiGrid-item')]"));
    
    private final SelenideElement activeContinueButton = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-justify-xs-center']//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth']"));
    
    private final SelenideElement orderLookUpTitle = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6'][2]//div[1]/h6"));
    
    private final SelenideElement orderNumberField = $(By.xpath("//div[2]/form//input"));

    private final SelenideElement continueOrderLookUpButton = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12'][2]/button"));

    private final SelenideElement customerAccountResultsTitle = $(By.xpath("//div[contains(@class,'MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-4')]/div[1]/h6"));

    private final SelenideElement customerFirstName = $(By.xpath("//*[@id=\"spa-root\"]//th[1]"));

    private final SelenideElement customerAddress = $(By.xpath("//*[@id=\"spa-root\"]//th[2]"));
    
    private final SelenideElement customerPhone = $(By.xpath("//*[@id=\"spa-root\"]//th[3]"));
    
    private final SelenideElement customerEmail = $(By.xpath("//*[@id=\"spa-root\"]//th[4]"));
    
    private final SelenideElement customerCompany = $(By.xpath("//*[@id=\"spa-root\"]//th[5]"));
    
    private final SelenideElement customerTradeIdTaxExempt = $(By.xpath("//*[@id=\"spa-root\"]//th[6]"));
    
    private final SelenideElement createNewAccountButton = $(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-outlinedSizeLarge MuiButton-sizeLarge']"));

    private final SelenideElement searchNoResultsMsg = $(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1']"));

    private final SelenideElement firstResult = $(By.xpath("//*[@id=\"spa-root\"]//div[2]//div[2]//tbody/tr[1]/td[1]"));

    private final SelenideElement orderForTestTitle = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12'][1]/h6"));

    private final SelenideElement orderNotes = $(By.xpath("//*[@id=\"spa-root\"]//th[7]"));

    private final SelenideElement clientButton = $(By.xpath("//table[@class='MuiTable-root']/tbody[@class='MuiTableBody-root']/tr[@class='MuiTableRow-root jss22215']/td[@class='MuiTableCell-root MuiTableCell-body'][1]"));
}
