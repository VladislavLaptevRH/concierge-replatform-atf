package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;


@Getter
public class CheckoutAddressScreen {


    private SelenideElement firstNameInpt =$(By.xpath("//input[contains(@id,'firstName')and contains(@id,'shipping')]"));


    private SelenideElement lastNameField =$(By.xpath("//form[@class='MuiGrid-root MuiGrid-container']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-justify-xs-center']/div[1]/div[1]/div[2]/div/input"));


    private SelenideElement companyNameField =$(By.xpath("//form[@class='MuiGrid-root MuiGrid-container']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-justify-xs-center']/div[1]/div[1]/div[3]/div/input"));


    private SelenideElement streetAddressField =$(By.xpath("//form[@class='MuiGrid-root MuiGrid-container']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-justify-xs-center']/div[1]/div[1]/div[5]/div/input"));


    private SelenideElement aptFloorSuiteField =$(By.xpath("//form[@class='MuiGrid-root MuiGrid-container']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-justify-xs-center']/div[1]/div[1]/div[6]/div/input"));


    private SelenideElement cityField =$(By.xpath("//form[@class='MuiGrid-root MuiGrid-container']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-justify-xs-center']/div[1]/div[1]/div[7]/div/input"));

    private SelenideElement stateField =$(By.xpath("(//div[contains(@class,'Mui')]//select[contains(@class,'Mui')])[2]"));


    private SelenideElement countryField =$(By.xpath("(//div[contains(@class,'Mui')]//select[contains(@class,'Mui')])[1]"));


    private SelenideElement zipPostalCodeField =$(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-direction-xs-column MuiGrid-grid-xs-12 MuiGrid-grid-sm-7 MuiGrid-grid-md-5 MuiGrid-grid-xl-6'][1]/div[1]/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4']/div/div/input"));

    @FindBy(css = "")
    private SelenideElement phoneField =$(By.cssSelector("div:nth-child(2) > div:nth-child(9) > div:nth-child(2) > input:nth-child(1)"));


    private SelenideElement eveningPhone =$(By.xpath("/input[@id='37']"));


    private SelenideElement billingAddressAsShippingCheckBox =$(By.xpath("//div[@id='billingAddresslbl']//span[@class='MuiIconButton-label']/input[@type='checkbox']"));


    private SelenideElement continuePaymentButton =$(By.xpath("//button[contains(@class,'MuiButton-contained')]"));


    private SelenideElement continueButton =$(By.xpath("(//button[contains(@class,'MuiButton-containedPrimary')])[2]"));
    
}
