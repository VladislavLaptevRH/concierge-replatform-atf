package com.test.pageObject;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CheckoutAddressScreen extends AbstractPage{

    @FindBy(xpath = "//input[contains(@id,'firstName')and contains(@id,'shipping')]")
    private WebElement firstNameInpt;

    @FindBy(xpath = "//form[@class='MuiGrid-root MuiGrid-container']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-justify-xs-center']/div[1]/div[1]/div[2]/div/input")
    private WebElement lastNameField;

    @FindBy(xpath = "//form[@class='MuiGrid-root MuiGrid-container']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-justify-xs-center']/div[1]/div[1]/div[3]/div/input")
    private WebElement companyNameField;

    @FindBy(xpath = "//form[@class='MuiGrid-root MuiGrid-container']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-justify-xs-center']/div[1]/div[1]/div[5]/div/input")
    private WebElement streetAddressField;

    @FindBy(xpath ="//form[@class='MuiGrid-root MuiGrid-container']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-justify-xs-center']/div[1]/div[1]/div[6]/div/input")
    private WebElement aptFloorSuiteField;

    @FindBy(xpath = "//form[@class='MuiGrid-root MuiGrid-container']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-justify-xs-center']/div[1]/div[1]/div[7]/div/input")
    private WebElement cityField;

    @FindBy(xpath = "(//div[contains(@class,'Mui')]//select[contains(@class,'Mui')])[2]")
    private WebElement stateField;

    @FindBy(xpath = "(//div[contains(@class,'Mui')]//select[contains(@class,'Mui')])[1]")
    private WebElement countryField;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-direction-xs-column MuiGrid-grid-xs-12 MuiGrid-grid-sm-7 MuiGrid-grid-md-5 MuiGrid-grid-xl-6'][1]/div[1]/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4']/div/div/input")
    private WebElement zipPostalCodeField;

    @FindBy(xpath = "//form[@class='MuiGrid-root MuiGrid-container']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-justify-xs-center']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-direction-xs-column MuiGrid-grid-xs-12 MuiGrid-grid-sm-7 MuiGrid-grid-md-5 MuiGrid-grid-xl-6'][1]/div[@class='MuiGrid-root MuiGrid-container MuiGrid-direction-xs-column MuiGrid-align-items-xs-flex-start'][1]/div[@class='MuiFormControl-root MuiTextField-root MuiFormControl-marginNormal MuiFormControl-fullWidth'][8]/div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-fullWidth MuiInputBase-formControl']/input")
    private WebElement phoneField;

    @FindBy(xpath = "/input[@id='37']")
    private WebElement eveningPhone;

    @FindBy(xpath = "//div[@id='billingAddresslbl']//span[@class='MuiIconButton-label']/input[@type='checkbox']")
    private WebElement billingAddressAsShippingCheckBox;

    @FindBy(xpath = "//button[contains(@class,'MuiButton-contained')]")
    private WebElement continuePaymentButton;

    @FindBy(xpath = "(//button[contains(@class,'MuiButton-containedPrimary')])[2]")
    private WebElement continueButton;

    /**
     * Constructor for initialize page object
     *
     * @param driver Web driver
     */
    public CheckoutAddressScreen(WebDriver driver) {
        super(driver);
    }
}
