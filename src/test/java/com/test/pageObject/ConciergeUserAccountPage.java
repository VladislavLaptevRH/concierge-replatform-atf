package com.test.pageObject;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class ConciergeUserAccountPage extends AbstractPage{

    @FindBy(xpath = "//h1[@class='MuiTypography-root MuiTypography-h1']")
    private WebElement dashboardTitle;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item'][3]/a")
    private WebElement projectsButton;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item']/h6[contains(@class,'MuiTypography-displayInline')]")
    private WebElement locationButton;

    @FindBy(xpath = "//div[contains(@class,'MuiGrid-root MuiGrid-container')]/h6")
    private WebElement userNameButton;

    @FindBy(xpath = "//div[1]/h6[@class='MuiTypography-root MuiTypography-subtitle1']")
    private WebElement inStockButtonMenu;

    @FindBy(xpath = "//div[2]/h6[@class='MuiTypography-root MuiTypography-subtitle1']")
    private WebElement livingButtonMenu;

    @FindBy(xpath = "//div[3]/h6[@class='MuiTypography-root MuiTypography-subtitle1']")
    private WebElement diningButtonMenu;

    @FindBy(xpath = "//div[4]/h6[@class='MuiTypography-root MuiTypography-subtitle1']")
    private WebElement bedButtonMenu;

    @FindBy(xpath = "//div[5]/h6[@class='MuiTypography-root MuiTypography-subtitle1']")
    private WebElement bathButtonMenu;

    @FindBy(xpath = "//div[6]/h6[@class='MuiTypography-root MuiTypography-subtitle1']")
    private WebElement lightingButtonMenu;

    @FindBy(xpath = "//div[7]/h6[@class='MuiTypography-root MuiTypography-subtitle1']")
    private WebElement textilesButtonMenu;

    @FindBy(xpath = "//div[8]/h6[@class='MuiTypography-root MuiTypography-subtitle1']")
    private WebElement rugsButtonMenu;

    @FindBy(xpath = "//div[9]/h6[@class='MuiTypography-root MuiTypography-subtitle1']")
    private WebElement windowsButtonMenu;

    @FindBy(xpath = "//div[10]/h6[@class='MuiTypography-root MuiTypography-subtitle1']")
    private WebElement decorButtonMenu;

    @FindBy(xpath = "//div[11]/h6[@class='MuiTypography-root MuiTypography-subtitle1']")
    private WebElement artButtonMenu;

    @FindBy(xpath = "//div[12]/h6[@class='MuiTypography-root MuiTypography-subtitle1']")
    private WebElement outdoorButtonMenu;

    @FindBy(xpath = "//div[13]/h6[@class='MuiTypography-root MuiTypography-subtitle1']")
    private WebElement giftsButtonMenu;

    @FindBy(xpath = "//div[14]/h6[@class='MuiTypography-root MuiTypography-subtitle1']")
    private WebElement saleButtonMenu;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item']/h6[contains(@class,'MuiTypography-subtitle1 MuiTypography')]")
    private WebElement newPortBeachGallery;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-item'][1]")
    private WebElement gallerySelectButton;

    @FindBy(xpath = "//select[@id='gallery-select']/option[2]")
    private WebElement paloAltpGallery;

    @FindBy(xpath = "/html/body/div[4]/div/div[2]/button")
    private WebElement gallerySubmitButton;

    @FindBy(xpath = "//*[@id=\"146\"]")
    private WebElement westHollywood;

    @FindBy(xpath = "//div[3]//div[2]//div[1]//div[2]//div[3]/a/h6")
    private WebElement cartButton;

    @FindBy(xpath = "//a[1]/button[contains(@class,'MuiButton-root')]")
    private WebElement orderHistoryButton;

    @FindBy(xpath = "//div[@class='sc-jRQBWg idOKcy']//div[@class='MuiGrid-root MuiGrid-item']")
    private List<WebElement> menuItems;

    @FindBy(xpath = "//div[2]//ul[@class='MuiList-root']/li[@class='MuiListItem-root']")
    private List<WebElement> itemSubCategory;

    @FindBy(xpath = "//h6[normalize-space()='Client']")
    private WebElement clientButton;

    @FindBy(xpath = "//span[normalize-space()='Client Lookup']")
    private WebElement clientLookupHeaderBtn;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement clientLookupFirstName;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement clientLookupLastName;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    private WebElement clientLookupPhoneNumber;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement clientLookupSearchButton;

    @FindBy(xpath = "//td[@class='MuiTableCell-root MuiTableCell-body'][1]")
    private WebElement firstResultOfClientLookup;



    //ul[@class='MuiList-root']/li[@class='MuiListItem-root'][1]


    /**
     * Constructor for initialize page object
     *
     * @param driver Web driver
     */
    public ConciergeUserAccountPage(WebDriver driver) {
        super(driver);
    }
}
