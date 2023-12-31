package tests.concierge.pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class ConciergeProjectScreen {
    public final String forecastAmountString = "(//*[text() = 'Forecast Amount']/preceding-sibling::div)[%s]";
    private final ElementsCollection forecastAmountList = $$(By.xpath("//*[text() = 'Forecast Amount']/preceding-sibling::div"));
    private final SelenideElement projectMemberPrice = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item'][1]/p/b"));

    private final SelenideElement pricingTypeDropdown = $(By.cssSelector("#pricingTypeDropdown"));

    private final SelenideElement removeText = $(By.xpath("//*[text()='Remove']"));

    private final SelenideElement UpButton = $(By.xpath("(//p[contains(text(), 'ITEMS')]/../..//button)[1]"));
    private final SelenideElement DownButton = $(By.xpath("(//p[contains(text(), 'ITEMS')]/../..//button)[2]"));
    private final SelenideElement taxCheckedCheckbox = $(By.xpath("//*[text() = 'Tax Exempt']/../preceding-sibling::div/span[contains(@class, 'Mui-checked')]"));

    private final SelenideElement continueWithSuggestedAddressButton = $(By.xpath("//*[text() = 'CONTINUE WITH SUGGESTED ADDRESS']"));

    private final SelenideElement popUpErrorSomethingWentWrong = $(By.xpath("//*[text()='SOMETHING WENT WRONG.']"));

    private final SelenideElement popUpErrorWhileLoadingProjects = $(By.xpath("//*[text()='Error while loading projects']"));

    private final SelenideElement tryAgainButton = $(By.xpath("//*[text()='TRY AGAIN']"));

    private final SelenideElement continueCreateAProjectButton = $(By.xpath("//*[text()='CREATE NEW ACCOUNT']"));

    private final SelenideElement continueButtonPopUp = $(By.xpath("//div[contains(@class,'MuiGrid-justify-xs-center')][1]/button"));

    private final SelenideElement projectTitle = $(By.xpath("//h4[contains(@class,'MuiTypography-h4 MuiTypography-colorInherit')]"));

    private final SelenideElement searchBySelect = $(By.cssSelector("#demo-simple-select-outlined"));

    private final SelenideElement projectNameField = $(By.xpath("//input[@id='projectName']"));

    private final SelenideElement clientFirstNameField = $(By.xpath("//input[@id='text1']"));

    private final SelenideElement clientLastNameField = $(By.xpath("//input[@id='text2']"));

    private final SelenideElement addToCartButton = $(By.xpath("//*[text() = 'Add to Cart']"));

    private final SelenideElement selectLocationProject = $(By.xpath("//div[@id='mui-component-select-location']"));

    private final SelenideElement projectNameButton = $(By.xpath("//ul//li[@data-value='projectName']"));

    private final SelenideElement clientNameButton = $(By.xpath("//li[@data-value='clientName']"));

    private final SelenideElement projectIdButton = $(By.xpath("//li[@data-value='projectId']"));

    private final SelenideElement projectIdField = $(By.xpath("//input[@id='projectId']"));

    private final SelenideElement pricingType = $(By.xpath("//li[@data-value='pricingType']"));

    private final SelenideElement pricingTypeById = $(By.xpath("//li[@data-value='pricingType']"));

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
    private final SelenideElement newProjectPlusIcon = $(By.xpath("//span[text()='NEW']//parent::div/preceding-sibling::div"));

    private final SelenideElement preferredContactMethodSelect = $(By.xpath("//div[contains(@class,'MuiInputBase-fullWidth MuiInputBase-formControl')]/div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input']"));

    private final SelenideElement preferredContactMethod = $(By.xpath("//*[text()='Phone']"));

    private final SelenideElement preferredEmailContactMethod = $(By.xpath("//li[@data-value='Email']"));

    private final SelenideElement createProjectDetailsDescriptionField = $(By.xpath("//textarea"));

    private final SelenideElement usdCurrencyValue = $(By.xpath("//li[@data-value='USD']"));

    private final SelenideElement designButton = $(By.xpath("//*[text()='DESIGN']"));

    private final SelenideElement tradeButton = $(By.xpath("//*[text()='TRADE']"));

    private final SelenideElement createProjectButton = $(By.xpath("//*[text()='CREATE PROJECT']"));

    private final SelenideElement saveMoveToProject = $(By.xpath("//span[normalize-space()='SAVE']"));

    private final SelenideElement SaveMoveToProjectUppercase = $(By.xpath("//span[normalize-space()='Save']"));

    private final SelenideElement saveBtnUppercase = $(By.xpath("//*[text()='SAVE']"));

    private final SelenideElement saveBtnLowerCase = $(By.xpath("//*[text()='Save']"));

    private final SelenideElement forecastSetButton = $(By.xpath("//*[text()='FORECAST SET']"));

    private final SelenideElement settingsButton = $(By.xpath("//*[text()='SETTINGS']"));

    private final SelenideElement printButton = $(By.xpath("//*[text()='PRINT']"));

    private final SelenideElement items = $(By.xpath("//*[contains(text(),'ITEMS')]"));

    private final SelenideElement qty = $(By.xpath("//*[contains(text(),'QTY')]"));

    private final SelenideElement subtotal = $(By.xpath("//*[contains(text(),'SUBTOTAL')]"));

    private final SelenideElement totalPrice = $(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 MuiTypography-alignCenter']"));

    private final SelenideElement projectName = $(By.xpath("//select[@name='projectName']"));

    private final SelenideElement projectNameMoveToProject = $(By.xpath("//input[@id='project-name']"));

    private final SelenideElement spaceName = $(By.xpath("//select[@name='spaceName']"));

    private final SelenideElement moveToProjectSpan = $(By.xpath("(//h3[@class='MuiTypography-root MuiTypography-h3'])[3]"));

    private final SelenideElement moveToProjectButton = $(By.xpath("//div[contains(@class,'MuiGrid-grid-md-12')]//*[text()='Move to Project']"));

    private final SelenideElement projectResultsFirstRow = $(By.xpath("(//*[contains(text(), 'Member')])[1]"));

    private final SelenideElement firstSearchResultOfProjects = $(By.xpath("(//*[contains(text(), 'Current')])[1]"));

    private final SelenideElement thirtySixSearchResultOfProjects = $(By.xpath("//div[contains(@class,'MuiGrid-root MuiGrid-container MuiGrid-align-items-xs-flex-start')][1]/div[contains(@class,'MuiGrid-root MuiGrid-item')]/div[36]"));

    private final SelenideElement emailEstimateProjectScreen = $(By.xpath("//button/*[text() = 'EMAIL ESTIMATE']"));

    private final SelenideElement emailEstimateButton = $(By.cssSelector("button[type='submit'] span[class='MuiButton-label']"));

    private final SelenideElement emailEstimateEmailField = $(By.xpath("//input[@name='email']"));

    private final SelenideElement emailEstimateMessageToClient = $(By.xpath("//textarea[@name='message']"));

    private final SelenideElement emailEstimateAdditionEmailField = $(By.xpath("//input[@name='cc']"));

    private final SelenideElement projectNameItemTitle = $(By.xpath("//h6/.."));
    private final SelenideElement emailItemName = $(By.xpath("(//*[@class = 'productImageAndAttributes'])[2]//td[2]/div"));

    private final SelenideElement goToProjectButton = $(By.xpath("//*[text()='GO TO PROJECT']"));

    private final SelenideElement opportunityNameField = $(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input']"));

    private final SelenideElement selectPreferredContactMethod = $(By.xpath("//*[text()='Please select a preferred contact method.']"));

    private final SelenideElement opportunityDescription = $(By.cssSelector(".MuiInputBase-input.MuiOutlinedInput-input.MuiInputBase-inputMultiline.MuiOutlinedInput-inputMultiline[aria-invalid='true']"));

    private final SelenideElement selectOpportunityName = $(By.xpath("//select[@name='opportunityName']"));

    private final SelenideElement opportunityPhase4Value = $(By.xpath("//*[text()='A. Member - Phase 4']"));

    private final SelenideElement createOpportunityButton = $(By.xpath("//*[text()='CREATE OPPORTUNITY']"));

    private final SelenideElement addOpportunityButton = $(By.xpath("//span[@class='MuiButtonBase-root MuiIconButton-root']"));

    private final SelenideElement bccAssociateCheckBox = $(By.xpath("//*[text()='BCC Associate']"));

    private final SelenideElement aMemberValue = $(By.xpath("(//*[text()='A. Member'])[1]"));

    private final SelenideElement testCompanyValue = $(By.xpath("//*[text()='TestCompany']"));

    private final SelenideElement selectSpaceName = $(By.xpath("//select[@name='spaceName']"));

    private final SelenideElement test1Space = $(By.xpath("//option[text()='test1']"));

    private final SelenideElement test2Space = $(By.xpath("//option[text()='test2']"));

    private final SelenideElement itemIdSpan = $(By.xpath("//*[text()='Item#']"));

    private final List<SelenideElement> REMOVEbuttonList = $$(By.xpath("(//*[text()='REMOVE']/preceding-sibling::button)[1]"));

    private final SelenideElement REMOVEbutton = $(By.xpath("(//*[text()='REMOVE']/preceding-sibling::button)[1]"));

    private final SelenideElement priceOverrodeRemoveButton = $(By.xpath("//*[text()='REMOVE']"));

    private final SelenideElement clientPhone = $(By.cssSelector("input[name='phoneNumber']"));

    private final SelenideElement clientPostalCode = $(By.cssSelector("input[name='postalCode']"));

    private final SelenideElement regularPrice = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item'][1]/p)[1]"));

    private final SelenideElement overridePriceregularPrice = $(By.xpath("(//*[text() = 'REGULAR']/../..//p)[1]"));

    private final SelenideElement amount50 = $(By.xpath("//*[text()='$50.00']"));

    private final SelenideElement amount549 = $(By.xpath("//*[text()='$549.00']"));

    private final SelenideElement amount4923 = $(By.xpath("//*[text()='$2,223.90']"));

    private final SelenideElement adjustedPrice = $(By.xpath("(//*[text() = 'ADJUSTED']/../..//p)[1]"));

    private final SelenideElement ufdPrice = $(By.xpath("(//div[@id='sticky-project-footer-content']//div[@aria-describedby='override-popover-null']/span)[1]"));

    private final SelenideElement percentDiscount = $(By.id("outlined-helperText"));

    private final SelenideElement presentDiscount = $(By.xpath("//label[contains(@class, 'MuiFormLabel-filled')and text() = 'Discount %']"));

    private final SelenideElement dollarAmountField = $(By.id("dollar-amount"));

    private final SelenideElement shippingOverridePriceReason = $(By.id("override-reason"));

    private final SelenideElement reasonCode = $(By.id("reasoncode-select-outlined"));

    private final SelenideElement updateButton = $(By.xpath("//*[text()='Update']"));

    private final SelenideElement applyButton = $(By.xpath("//*[text()='Apply']"));

    private final SelenideElement percentOffSelect = $(By.id("method-select-outlined"));

    private final SelenideElement lancasterSofaQty = $(By.id("quantity_I51173680"));

    private final SelenideElement mirrorSize = $(By.id("optionSelect-0"));

    private final SelenideElement finishOption = $(By.id("optionSelect-0"));

    private final SelenideElement forecastAmountValue = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-2'][3]/div)[1]"));

    private final SelenideElement itemProjectPrice = $(By.xpath("(//div[1]/p[@class='MuiTypography-root MuiTypography-body1'])[4]"));

    private final SelenideElement printPopUp = $(By.id("documentInfo"));

    private final SelenideElement checkMarkItemButton = $(By.xpath("//button[contains(@class,'MuiButtonBase-root')][3]"));

    private final SelenideElement foreCastAmount = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-2'][3])[1]"));

    private final SelenideElement memberItemPrice = $(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1'])[2]"));

    private final SelenideElement foreCastTotalValue = $(By.xpath("(//div[contains(@class,'MuiBox-root')])[10]"));

    private final SelenideElement editItemOptions = $(By.xpath("(//button[contains(@class,'MuiButtonBase-root')])[13]"));

    private final SelenideElement regularPriceValue = $(By.xpath("(//*[contains(text(),'$')])[4]"));

    private final SelenideElement paginationGoToPage2 = $(By.xpath("//*[@aria-label = 'Go to page 2']"));

    private final SelenideElement addToProjectProjectName = $(By.id("project-name"));

    private final SelenideElement projectNamePopUpDropDownListItem = $(By.xpath("//*[text()='TestCompany']"));

    private final SelenideElement taxExemptCheckBox = $(By.xpath(" //*[text() = 'Tax Exempt']/../preceding-sibling::div//input"));

    private final SelenideElement prieItemFromProject = $(By.xpath("//div[2]/div[@class='MuiGrid-root MuiGrid-item'][1]/p"));

    private final SelenideElement emailEstimateSendButton = $(By.cssSelector("button[type='submit'] span[class='MuiButton-label']"));

    public SelenideElement getForecastAmountByNumber(int number) {
        String path = String.format(forecastAmountString, number);
        return $(byXpath(path));
    }
}
