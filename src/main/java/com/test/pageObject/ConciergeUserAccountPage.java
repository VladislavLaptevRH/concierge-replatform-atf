package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class ConciergeUserAccountPage {

    private SelenideElement newClientHeaderBtn = $(By.xpath("//*[text()='Client : New Client']"));

    private SelenideElement newClientButton = $(By.xpath("//*[text()='NEW']"));

    private SelenideElement memberIdField = $(By.xpath("//input[@name='memberID']"));

    private SelenideElement businessAcNumber = $(By.xpath("//input[@name='tradeID']"));

    private SelenideElement clientLookupEmail = $(By.xpath("//input[@name='email']"));

    private SelenideElement dashboardTitle = $(By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1']"));

    private SelenideElement seeResultsButton = $(By.xpath("//span[@class='MuiButton-label']"));

    private SelenideElement searchItemField = $(By.xpath("//input[contains(@class,'MuiInputBase-inputAdornedStart')]"));

    private SelenideElement searchButton = $(By.xpath("//*[text()='Search']"));

    private SelenideElement automationClientButton = $(By.xpath("//*[contains(text(),'Client : Automation')]"));

    private List<SelenideElement> listOfBrands = $$(By.xpath("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li"));

    private SelenideElement projectsButton = $(By.xpath("//*[text()='Projects']"));

    private SelenideElement locationButton = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item']/h6[contains(@class,'MuiTypography-displayInline')]"));

    private SelenideElement userNameButton = $(By.xpath("//div[contains(@class,'MuiGrid-root MuiGrid-container')]/h6"));

    private SelenideElement inStockButtonMenu = $(By.xpath("//div[1]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private SelenideElement livingButtonMenu = $(By.xpath("//div[2]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private SelenideElement diningButtonMenu = $(By.xpath("//div[3]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private SelenideElement bedButtonMenu = $(By.xpath("//div[4]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private SelenideElement bathButtonMenu = $(By.xpath("//div[5]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private SelenideElement lightingButtonMenu = $(By.xpath("//div[6]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private SelenideElement textilesButtonMenu = $(By.xpath("//div[7]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private SelenideElement rugsButtonMenu = $(By.xpath("//div[8]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private SelenideElement windowsButtonMenu = $(By.xpath("//div[9]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private SelenideElement decorButtonMenu = $(By.xpath("//div[10]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private SelenideElement artButtonMenu = $(By.xpath("//div[11]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private SelenideElement outdoorButtonMenu = $(By.xpath("//div[12]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private SelenideElement giftsButtonMenu = $(By.xpath("//div[13]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private SelenideElement saleButtonMenu = $(By.xpath("//div[14]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private SelenideElement newPortBeachGallery = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item']/h6[contains(@class,'MuiTypography-subtitle1 MuiTypography')]"));

    private SelenideElement gallerySelectButton = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-item'][1]"));

    private SelenideElement paloAltpGallery = $(By.xpath("//select[@id='gallery-select']/option[2]"));

    private SelenideElement gallerySubmitButton = $(By.xpath("//*[text()='Submit']"));

    private SelenideElement westHollywood = $(By.xpath("//*[@id=\"146\"]"));

    private SelenideElement cartButton = $(By.xpath("//div[3]//div[2]//div[1]//div[2]//div[3]/a/h6"));

    private SelenideElement orderHistoryButton = $(By.xpath("//a[1]/button[contains(@class,'MuiButton-root')]"));

    private List<SelenideElement> menuItems = $$(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-justify-xs-space-between']//div"));

    private List<SelenideElement> itemSubCategory = $$(By.xpath("//div[2]//ul[@class='MuiList-root']/li[@class='MuiListItem-root']"));

    private SelenideElement clientButton = $(By.xpath("//div[1]/div[@class='MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-align-items-xs-center']/h6"));

    private SelenideElement removeClientButton = $(By.xpath("//li[@id='1']/button"));

    private SelenideElement removeClientByText = $(By.xpath("//*[text()='Remove Client']"));

    private SelenideElement brandButton = $(By.xpath("//div[2]/div[@class='MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-align-items-xs-center']/h6"));

    private SelenideElement clientLookupHeaderBtn = $(By.xpath("//li[@id='1']"));

    private SelenideElement clientLookupBtnId = $(By.xpath("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li[@id='1']"));

    private SelenideElement clientLookupFirstName = $(By.xpath("//input[@name='firstName']"));

    private SelenideElement clientLookupLastName = $(By.xpath("//input[@name='lastName']"));

    private SelenideElement clientLookupPhoneNumber = $(By.xpath("//input[@name='phoneNumber']"));

    private SelenideElement clientLookupSearchButton = $(By.xpath("//button[@type='submit']"));

    private SelenideElement firstResultOfClientLookup = $(By.xpath("//td[@class='MuiTableCell-root MuiTableCell-body'][1]/div"));

    private SelenideElement rhConciergeLogo = $(By.xpath("//a[@id='nav-logo-img']"));

    private SelenideElement inStockMenuItem = $(By.xpath("//*[text()='In Stock']"));

    private SelenideElement inStockBedding = $(By.xpath("//*[text()='In-Stock Bed']"));

    private SelenideElement beds = $(By.xpath("//*[text()='Beds']"));

    private SelenideElement dressers = $(By.xpath("//*[text()='Dressers']"));

    private SelenideElement armoires = $(By.xpath("//*[text()='Armoires']"));

    private SelenideElement sofas = $(By.xpath("//*[text()='Sofas']"));

    private SelenideElement benches = $(By.xpath("//*[text()='Benches']"));

    private SelenideElement bedding = $(By.xpath("//*[text()='Bedding']"));

    private SelenideElement inStockBath = $(By.xpath("//*[text()='In-Stock Bath']"));

    private SelenideElement inStockLighting = $(By.xpath("//*[text()='In-Stock Lighting']"));

    private SelenideElement inStockTextiles = $(By.xpath("//*[text()='In-Stock Textiles']"));

    private SelenideElement inStockRugs = $(By.xpath("//*[text()='In-Stock Rugs']"));

    private SelenideElement inStockWindows = $(By.xpath("//*[text()='In-Stock Windows']"));

    private SelenideElement toddlerBedding = $(By.xpath("//*[text()='Toddler Bedding']"));

    private List<SelenideElement> toddlerBeddingList = $$(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-true']/div/ul[@class='MuiGridList-root']/li[@class='MuiGridListTile-root']"));


}
