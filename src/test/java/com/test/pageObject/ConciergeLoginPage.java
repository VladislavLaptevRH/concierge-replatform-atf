package com.test.pageObject;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ConciergeLoginPage extends AbstractPage {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='login-form__submit']")
    private WebElement sumbitButton;

//    @FindBy(xpath = "//select[@id='location']")
//    private WebElement locationButton;
    @FindBy(xpath = "//select[@id='location']")
    private WebElement location;

    @FindBy(xpath = "//button[contains(@class,'MuiButtonBase-root MuiButton-root')]")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id='location']/option[2]")
    private WebElement locationNewPortBeach;

    @FindBy(xpath = "//*[@id='location']/option[36]")
    private WebElement locationWestHolywood;

    @FindBy(xpath = "//button[@class='login-form__submit']")
    private WebElement signInButton;

//button[@class='login-form__submit']
//    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained jss459 MuiButton-containedPrimary']")
//    private WebElement continueButton;




    /**
     * Constructor for initialize page object
     *
     * @param driver Web driver
     */
    public ConciergeLoginPage(WebDriver driver) {
        super(driver);
    }
}
