package com.test.pageObject;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ConciergeCartPageScreen extends AbstractPage {
    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12']/div/div/div[1]//p[@id='listColumn2-Item#']")
    private WebElement arlesRectangularDinigTableId;

    @FindBy(xpath = "//h1[@class='MuiTypography-root MuiTypography-h1']")
    private WebElement shoppingCartEmpty;

    @FindBy(xpath = "//div[@id='spa-root']/div/main//a")
    private WebElement pleaseContinueBrowsingButton;

    @FindBy(xpath = "//h3[normalize-space()='Arles Rectangular Dining Table']")
    private WebElement arlesRectangularDinigTableTitle;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12']/div/div/div[2]//p[@id='listColumn2-Item#']")
    private WebElement gramTurkishTowel;

    @FindBy(xpath = "//h3[normalize-space()='802-Gram Turkish Towel Collection']")
    private WebElement gramTurkishTitle;

    @FindBy(xpath = "//select[@id='quantity_701bfc45-0262-4a2c-bf01-92887d788333_1']")
    private WebElement quantityButton;

    @FindBy(xpath = "//select[@id='element-orderclassification']")
    private WebElement orderClassificationSelect;

    @FindBy(xpath = "//h2[@class='MuiTypography-root MuiTypography-h2 MuiTypography-noWrap']")
    private WebElement membersProgramTitle;

    @FindBy(xpath = "//button[@data-testid='form-dialog-close-button']")
    private WebElement closePopUp;


    /**
     * Constructor for initialize page object
     *
     * @param driver Web driver
     */
    public ConciergeCartPageScreen(WebDriver driver) {
        super(driver);
    }
}
