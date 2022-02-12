package com.test.pageObject;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter

public class ConciergeOrderHistoryForm extends AbstractPage {

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12'][2]/a")
    private WebElement backToSearchResultsButton;

    @FindBy(xpath = "//h1[@class='MuiTypography-root MuiTypography-h1']")
    private WebElement orderHistoryTitle;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6'][1]//h6")
    private WebElement customerLookUp;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[1]//input")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[2]//input")
    private WebElement firstNameField;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[3]//input")
    private WebElement lastNameField;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[4]//input")
    private WebElement emailAddressField;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[5]//input")
    private WebElement postalCodeField;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[6]//input")
    private WebElement memberIdField;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[7]//input")
    private WebElement businessAccountNumberField;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[8]//input")
    private WebElement companyNameField;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-sm-12']//div[contains(@class,'MuiGrid-root MuiGrid-item')]")
    private WebElement inactiveContinueButton;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-justify-xs-center']//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth']")
    private WebElement activeContinueButton;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6'][2]//div[1]/h6")
    private WebElement orderLookUpTitle;

    @FindBy(xpath = "//div[2]/form//input")
    private WebElement orderNumberField;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12'][2]/button")
    private WebElement continueOrderLookUpButton;

    @FindBy(xpath = "//div[contains(@class,'MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-4')]/div[1]/h6")
    private WebElement customerAccountResultsTitle;

    @FindBy(xpath = "//*[@id=\"spa-root\"]//th[1]")
    private WebElement customerFirstName;

    @FindBy(xpath = "//*[@id=\"spa-root\"]//th[2]")
    private WebElement customerAddress;

    @FindBy(xpath = "//*[@id=\"spa-root\"]//th[3]")
    private WebElement customerPhone;

    @FindBy(xpath = "//*[@id=\"spa-root\"]//th[4]")
    private WebElement customerEmail;

    @FindBy(xpath = "//*[@id=\"spa-root\"]//th[5]")
    private WebElement customerCompany;

    @FindBy(xpath = "//*[@id=\"spa-root\"]//th[6]")
    private WebElement customerTradeIdTaxExempt;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-outlinedSizeLarge MuiButton-sizeLarge']")
    private WebElement createNewAccountButton;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1']")
    private WebElement searchNoResultsMsg;

    @FindBy(xpath = "//*[@id=\"spa-root\"]//div[2]//div[2]//tbody/tr[1]/td[1]")
    private WebElement firstResult;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12'][1]/h6")
    private WebElement orderForTestTitle;

    @FindBy(xpath = "//*[@id=\"spa-root\"]//th[7]")
    private WebElement orderNotes;

    @FindBy(xpath = "//table[@class='MuiTable-root']/tbody[@class='MuiTableBody-root']/tr[@class='MuiTableRow-root jss22215']/td[@class='MuiTableCell-root MuiTableCell-body'][1]")
    private WebElement clientButton;

    /**
     * Constructor for initialize page object
     *
     * @param driver Web driver
     */
    public ConciergeOrderHistoryForm(WebDriver driver) {
        super(driver);
    }
}
