package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class ConciergeUserAccountPage {

    private final String orderDetailsButton = "//*[text()='%s']";

    private final String brandButtonWithCurrentBoard = "//*[@alt='%s']";

    private final String firstResultOfClientLookupParameterized = "(//*[text() = 'MEMBERSHIP']/../../..//*[starts-with(text(), '%s')])[1]";

    public final String currentLocationGalleryItem = "//li[contains(text(),'%s')]";

    public final String galleryItem = "//input[@value = '%s']";

    public final String brand = "//*[text()='%s']";

    public final String button = "//span[text()='%s']";

    private final SelenideElement galleryButton = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-1 MuiGrid-item MuiGrid-align-items-xs-center']/div[@class='MuiGrid-root MuiGrid-item'][2]"));

    private final SelenideElement gallerySelect = $(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiAutocomplete-input MuiAutocomplete-inputFocused MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd']"));

    private final SelenideElement outdoorMenu = $(By.xpath("//*[text()='Outdoor']"));

    private final SelenideElement chairsSubMenu = $(By.xpath("//*[text()='Chairs']"));

    private final SelenideElement firstItemMainMenu = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-justify-xs-space-between']/div[1]"));

    private final SelenideElement newClientHeaderBtn = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-justify-xs-flex-end MuiGrid-grid-xs-6']/span"));

    private final SelenideElement newClientButton = $(By.xpath("//*[text()='NEW']"));

    private final SelenideElement memberIdField = $(By.cssSelector("input[name='memberIdOrTradeId']"));
    private final SelenideElement memberIdField1 = $(By.cssSelector("input[name='memberID']"));

    private final SelenideElement businessAcNumber = $(By.xpath("//*[contains(text(), 'Business Account Number')]/../..//input"));

    private final SelenideElement clientLookupEmail = $(By.cssSelector("input[id='email']"));
    private final SelenideElement clientLookupEmailByName = $(By.cssSelector("input[name='email']"));

    private final SelenideElement dashboardTitle = $(By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1']"));

    private final SelenideElement seeResultsButton = $(By.xpath("(//span[@class='MuiButton-label'])[2]"));

    private final SelenideElement searchItemField = $(By.xpath("//input[contains(@class,'MuiOutlinedInput-inputAdornedStart')]"));

    private final SelenideElement searchButton = $(By.xpath("//*[text()='Search']"));

    private final SelenideElement automationClientButton = $(By.xpath("//*[contains(text(),'Client : Automation')]"));

    private final List<SelenideElement> listOfBrands = $$(By.xpath("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li"));
    private final List<SelenideElement> listOfMainCategories = $$(By.xpath("//div[@class=\"MuiGrid-root MuiGrid-container MuiGrid-justify-xs-space-between\"]/div"));

    private final SelenideElement saleMenu = $(By.xpath("(//div[@class=\"MuiGrid-root MuiGrid-container MuiGrid-justify-xs-space-between\"]/div)[15]"));

    private final List<SelenideElement> listOfSubCategories = $$(By.xpath("(//ul[@class=\"MuiList-root\"])[1]/li/span"));
    private final List<SelenideElement> listOfCollections = $$(By.xpath("(//ul[@class=\"MuiList-root\"])[2]/li"));

    private final SelenideElement projectsButton = $(By.xpath("//a[@data-analytics-worhlogo='projects-logo']"));

    private final SelenideElement locationButton = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item']/h6[contains(@class,'MuiTypography-displayInline')]"));

    private final SelenideElement userNameButton = $(By.xpath("//div[contains(@class,'MuiGrid-root MuiGrid-container')]/h6"));

    private final SelenideElement inStockButtonMenu = $(By.xpath("//div[1]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private final SelenideElement livingButtonMenu = $(By.xpath("//div[2]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private final SelenideElement diningButtonMenu = $(By.xpath("//div[3]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private final SelenideElement bedButtonMenu = $(By.xpath("//div[4]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private final SelenideElement bathButtonMenu = $(By.xpath("//div[5]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private final SelenideElement lightingButtonMenu = $(By.xpath("//div[6]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private final SelenideElement textilesButtonMenu = $(By.xpath("//div[7]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private final SelenideElement rugsButtonMenu = $(By.xpath("//div[8]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private final SelenideElement windowsButtonMenu = $(By.xpath("//div[9]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private final SelenideElement decorButtonMenu = $(By.xpath("//div[10]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private final SelenideElement artButtonMenu = $(By.xpath("//div[11]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private final SelenideElement outdoorButtonMenu = $(By.xpath("//div[12]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private final SelenideElement giftsButtonMenu = $(By.xpath("//div[13]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private final SelenideElement saleButtonMenu = $(By.xpath("//div[14]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private final SelenideElement newPortBeachGallery = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item']/span"));

    private final SelenideElement gallerySelectButton = $(By.xpath("//select[@id='gallery-select']/option"));

    private final SelenideElement paloAltpGallery = $(By.xpath("//select[@id='gallery-select']/option[2]"));

    private final SelenideElement gallerySubmitButton = $(By.xpath("//*[text()='SUBMIT']"));

    private final SelenideElement westHollywood = $(By.xpath("//*[@id=\"146\"]"));

    private final SelenideElement cartButton = $(By.xpath("//*[@id = 'header-cart-button']"));

    private final SelenideElement cartItemSum = $(By.xpath("//*[@id = 'header-cart-button']/div/span"));

    private final SelenideElement cartButtonItemSum = $(By.xpath("//*[@id = 'header-cart-button']//span"));

    private final SelenideElement orderHistoryButton = $(By.xpath("//a[1]/button[contains(@class,'MuiButton-root')]"));

    private final List<SelenideElement> menuItems = $$(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-justify-xs-space-between']//div"));

    private final List<SelenideElement> itemSubCategory = $$(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3'])/ul/li"));

    private final List<SelenideElement> clientSearchResultAddresses = $$(By.xpath("//td[@class='MuiTableCell-root MuiTableCell-body'][2]"));

    private final SelenideElement firstItemSubCategory = $(By.xpath("((//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3'])[1]//ul//li)[1]//span"));

    private final SelenideElement clientButton = $(By.id("header-client-button"));

    private final SelenideElement removeClientButton = $(By.xpath("//li[@id='1']/button"));

    private final SelenideElement removeClientByText = $(By.xpath("//*[text()='REMOVE CLIENT']"));

    private final SelenideElement brandButton = $(By.xpath("//a[@data-testid='brand-link']"));

    private final SelenideElement clientLookupHeaderBtn = $(By.xpath("//*[text()='CLIENT LOOKUP']"));

    private final SelenideElement contractText = $(By.xpath("//*[text()='Contract']"));

    private final SelenideElement clientLookupBtnId = $(By.xpath("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li[@id='1']"));

    private final SelenideElement clientLookupFirstName = $(By.xpath("//*[text() = 'First Name']/../..//input"));

    private final SelenideElement clientLookupFirstNameByName = $(By.cssSelector("input[name='firstName']"));

    private final SelenideElement clientLookupLastName = $(By.xpath("//*[text() = 'Last Name']/../..//input"));

    private final SelenideElement clientLookupPhoneNumber = $(By.xpath("//input[@name='phoneNumber']"));

    private final SelenideElement clientLookupSearchButton = $(By.xpath("//button[@type='submit']"));

    private final SelenideElement firstResultOfClientLookup = $(By.xpath("//td[@class='MuiTableCell-root MuiTableCell-body'][1]/div"));

    private final SelenideElement rhConciergeLogo = $(By.xpath("//a[@data-analytics-worhlogo='worh-logo']"));

    private final SelenideElement inStockMenuItem = $(By.xpath("//*[text()='In Stock']"));

    private final SelenideElement inStockBedding = $(By.xpath("//*[text()='In-Stock Bed']"));

    private final SelenideElement beds = $(By.xpath("//*[text()='Beds']"));

    private final SelenideElement dressers = $(By.xpath("//*[text()='Dressers']"));

    private final SelenideElement armoires = $(By.xpath("//*[text()='Armoires']"));

    private final SelenideElement sofas = $(By.xpath("//*[text()='Sofas']"));

    private final SelenideElement benches = $(By.xpath("//*[text()='Benches']"));

    private final SelenideElement bedding = $(By.xpath("//*[text()='Bedding']"));

    private final SelenideElement inStockBath = $(By.xpath("//*[text()='In-Stock Bath']"));

    private final SelenideElement inStockLighting = $(By.xpath("//*[text()='In-Stock Lighting']"));

    private final SelenideElement inStockTextiles = $(By.xpath("//*[text()='In-Stock Textiles']"));

    private final SelenideElement inStockRugs = $(By.xpath("//*[text()='In-Stock Rugs']"));

    private final SelenideElement inStockWindows = $(By.xpath("//*[text()='In-Stock Windows']"));

    private final SelenideElement toddlerBedding = $(By.xpath("//*[text()='Toddler Bedding']"));

    private final SelenideElement mainMenuHeader = $(By.cssSelector("#rh-header"));

    private final SelenideElement contractAccountText = $(By.xpath("//*[text()='CONTRACT ACCOUNT']"));

    private final SelenideElement closeButton = $(By.xpath("//*[text()='CLOSE']"));

    private final SelenideElement youHaveSelectedContractAccountText = $(By.xpath("//*[text()='You have selected a Contract Account which is reserved for the Contract Team. Please select an existing trade account or create a new one.']"));

    private final SelenideElement searchClientResultsPlusButton = $(By.xpath("(//td[@class='MuiTableCell-root MuiTableCell-body'][8])[1]"));

    private final List<SelenideElement> toddlerBeddingList = $$(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-true']/div/ul[@class='MuiGridList-root']/li[@class='MuiGridListTile-root']"));

    private final SelenideElement clientLookupStg3LastName = $(By.xpath("//input[@id='lastName']"));
    private final SelenideElement brandLink = $(By.xpath("//a[@data-testid='brand-link']"));
    private final SelenideElement firstSubMenu = $(By.xpath("//div[@role='tooltip']//descendant::div[contains(@class,'MuiGrid-container')]//child::div[contains(@class,'MuiGrid-root')][1]/ul/li[1]"));
    private final SelenideElement usename = $(By.xpath("//span[text()='Automation Associate']"));
    private final SelenideElement searchLens = $(By.xpath("//button[contains(@class,'MuiIconButton')]"));
    private final SelenideElement userIcon = $(By.xpath("//div[@data-analytics-nav='account-icon']"));
    private final SelenideElement pageLabel1 = $(By.xpath("//i[text()='Concierge']"));
    private final SelenideElement pageLabel2 = $(By.xpath("//h1[text()='Dashboard']"));
    private final SelenideElement existingGallery = $(By.xpath("//span[text()='NEWPORT BEACH']"));


    public SelenideElement getCurrentLocationGalleryItemByName(String name) {
        String path = String.format(currentLocationGalleryItem, name);
        return $(byXpath(path));
    }

    public SelenideElement getGalleryItemByName(String name) {
        String path = String.format(galleryItem, name);
        return $(byXpath(path));
    }

    public SelenideElement getFirstResultOfClientLookupByName(String name) {
        String path = String.format(firstResultOfClientLookupParameterized, name);
        return $(byXpath(path));
    }

    public SelenideElement getOrderDetailsButtonByName(String name) {
        String path = String.format(orderDetailsButton, name);
        return $(byXpath(path));
    }

    public SelenideElement getCurrentBrandByName(String brand) {
        String path = String.format(brandButtonWithCurrentBoard, brand);
        return $(byXpath(path));
    }

    public SelenideElement getBrand(String brandname){
        String path = String.format(brand, brandname);
        return $(byXpath(path));
    }

    public SelenideElement getButton(String buttonname){
        String path = String.format(button, buttonname);
        return $(byXpath(path));
    }

}
