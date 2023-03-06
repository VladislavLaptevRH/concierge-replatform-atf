package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class EstoreUserAccountPage {


    private final SelenideElement emailField = $(By.xpath("//input[@id='email']"));

    private final SelenideElement yourProfileHasBeenUpdate = $(By.xpath("//*[text()='YOUR PROFILE HAS BEEN UPDATED.']"));

    private final SelenideElement updatePersonalButton = $(By.xpath("//*[text()='UPDATE PERSONAL INFORMATION']"));

    private final SelenideElement beddingCollectionsTest = $(By.xpath("//*[text()='Bedding Collections']"));

    private final SelenideElement textilesText = $(By.xpath("//*[text()='Textiles']"));

    private final SelenideElement bedLinesText = $(By.xpath("//*[text()='Bed Linens']"));

    private final SelenideElement confirmDeleteAddedAddress = $(By.xpath("(//*[text()='Delete'])[3]"));

    private final SelenideElement useIWantToDeleteAddedAddress = $(By.xpath("(//*[text()='Delete'])[2]"));

    private final SelenideElement firstNameRequired = $(By.xpath("//*[text()='First name required.']"));

    private final SelenideElement lastNameRequired = $(By.xpath("//*[text()='Last name required.']"));

    private final SelenideElement cityRequired = $(By.xpath("//*[text()='City required.']"));

    private final SelenideElement stateRequired = $(By.xpath("//*[text()='State required.']"));

    private final SelenideElement postalCodeRequired = $(By.xpath("//*[text()='Postal code required.']"));

    private final SelenideElement phoneRequired = $(By.xpath("//*[text()='Phone required.']"));

    private final SelenideElement saveAddressButton = $(By.xpath("//*[text()='Save address']"));

    private final SelenideElement addAddressButton = $(By.xpath("//*[text()='Add address']"));

    private final SelenideElement addCardButton = $(By.xpath("//*[text()='Add Card']"));

    private final SelenideElement saveCardButton = $(By.xpath("//*[text()='SAVE CARD']"));

    private final SelenideElement billingAddressFirstName = $(By.xpath("//input[@id='firstName']"));

    private final SelenideElement billingAddressLastName = $(By.xpath("//input[@id='lastName']"));

    private final SelenideElement billingAddressStreetAddress = $(By.id("addressLine1"));

    private final SelenideElement billingAddressStreetAddressStg2 = $(By.xpath("//input[@data-testid='addressLine1']"));

    private final SelenideElement billingAddressAptFloor = $(By.xpath("//input[@id='addressLine2']"));

    private final SelenideElement billingAddressCity = $(By.xpath("//input[@id='city']"));

    private final SelenideElement billingAddressSelectState = $(By.xpath("//select[@id='state']"));

    private final SelenideElement billingAddressPostalCode = $(By.xpath("//input[@id='postalCode']"));

    private final SelenideElement billingAddressPhone = $(By.xpath("//input[@id='phone']"));

    private final SelenideElement newCardNumber = $(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd']"));

    private final SelenideElement selectTypeOfCardNewCard = $(By.xpath("//select[@class='MuiSelect-root MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input']"));

    private final SelenideElement creditCardNewCard = $(By.xpath("(//option[@value='CC'])[1]"));

    private final SelenideElement confirmDeleteButton = $(By.xpath("//*[text()='DELETE']"));

    private final SelenideElement deleteButton = $(By.xpath("//*[text()='Delete']"));

    private final SelenideElement deleteAddedAddressButton = $(By.xpath("(//*[text()='Delete'])[2]"));

    private final SelenideElement paymentMethodsButton = $(By.xpath("//a[@href='/my-account/payment-info.jsp']"));

    private final SelenideElement myProfileButton = $(By.xpath("//*[text()='My Account']"));

    private final SelenideElement profileButton = $(By.xpath("//*[text()='PROFILE']"));

    private final SelenideElement addressBookButton = $(By.xpath("//a[contains(@href,'/address-book.jsp')]"));

//    private final SelenideElement addressBookButtonStg4 = $(By.xpath("//a[@href="/my-account/address-book.jsp"));

    private final SelenideElement profileIconButton = $(By.xpath("//div[@data-analytics-nav='account-icon']"));

    private final SelenideElement profileIconButtonDiv = $(By.xpath("//div[@data-analytics-nav='account-icon']"));

    private final SelenideElement brandButton = $(By.xpath("//div[@id='hamburgerIcon']"));

    private final SelenideElement galleryButton = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item']/h6[@class='MuiTypography-root MuiTypography-subtitle1 MuiTypography-displayInline']"));

    private final SelenideElement gallerySelect = $(By.xpath("//select[@name='gallery-select']"));

    private final SelenideElement outdoorMenu = $(By.xpath("//*[text()='Outdoor']"));

    private final SelenideElement chairsSubMenu = $(By.xpath("//*[text()='Chairs']"));

    private final SelenideElement firstItemMainMenu = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item'][1]/h6[@class='MuiTypography-root MuiTypography-subtitle1']"));

    private final SelenideElement newClientHeaderBtn = $(By.xpath("//*[text()='Client : New Client']"));

    private final SelenideElement newClientButton = $(By.xpath("//*[text()='NEW']"));

    private final SelenideElement memberIdField = $(By.cssSelector("input[name='memberID']"));

    private final SelenideElement businessAcNumber = $(By.cssSelector("input[name='tradeID']"));

    private final SelenideElement clientLookupEmail = $(By.cssSelector("input[name='email']"));

    private final SelenideElement dashboardTitle = $(By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1']"));

    private final SelenideElement seeResultsButton = $(By.xpath("(//span[@class='MuiButton-label'])[2]"));

    private final SelenideElement orderDetailsButton = $(By.xpath("//*[text()='Order details']"));

    private final SelenideElement searchItemField = $(By.xpath("//input[@id='site-search-input']"));

    private final SelenideElement searchButton = $(By.xpath("//*[text()='Search']"));

    private final SelenideElement automationClientButton = $(By.xpath("//*[contains(text(),'Client : Automation')]"));

    private final List<SelenideElement> listOfBrands = $$(By.xpath("//a[@data-analytics-rootcat='OUR PRODUCTS']"));

    private final SelenideElement projectsButton = $(By.xpath("//*[text()='Projects']"));

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

    private final SelenideElement newPortBeachGallery = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item']/h6[contains(@class,'MuiTypography-subtitle1 MuiTypography')]"));

    private final SelenideElement gallerySelectButton = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-item'][1]"));

    private final SelenideElement paloAltpGallery = $(By.xpath("//select[@id='gallery-select']/option[2]"));

    private final SelenideElement gallerySubmitButton = $(By.xpath("//*[text()='Submit']"));

    private final SelenideElement westHollywood = $(By.xpath("//*[@id=\"146\"]"));

    private final SelenideElement cartButton = $(By.xpath("//a[@href='/checkout/shopping_cart.jsp']"));

    private final SelenideElement cartButtonStg4 = $(By.xpath("//a[@href='/checkout/shopping_cart.jsp']"));

    private final SelenideElement orderHistoryButton = $(By.xpath("//a[1]/button[contains(@class,'MuiButton-root')]"));

    private final List<SelenideElement> menuItems = $$(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-justify-xs-space-between']//div"));

    private final List<SelenideElement> itemSubCategory = $$(By.xpath("//div[2]//ul[@class='MuiList-root']/li[@class='MuiListItem-root']"));

    private final SelenideElement clientButton = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item'][1]/div[@class='MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-align-items-xs-center']/h6"));

    private final SelenideElement removeClientButton = $(By.xpath("//li[@id='1']/button"));

    private final SelenideElement removeClientByText = $(By.xpath("//*[text()='Remove Client']"));

    private final SelenideElement clientLookupHeaderBtn = $(By.xpath("//li[@id='1']/button"));

    private final SelenideElement contractText = $(By.xpath("//*[text()='Contract']"));

    private final SelenideElement tradeText = $(By.xpath("//*[text()='Trade']"));

    private final SelenideElement clientLookupBtnId = $(By.xpath("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li[@id='1']"));

    private final SelenideElement clientLookupFirstName = $(By.cssSelector("input[name='firstName']"));

    private final SelenideElement clientLookupLastName = $(By.cssSelector("input[name='lastName']"));

    private final SelenideElement clientLookupPhoneNumber = $(By.xpath("//input[@name='phoneNumber']"));

    private final SelenideElement clientLookupSearchButton = $(By.xpath("//button[@type='submit']"));

    private final SelenideElement firstResultOfClientLookup = $(By.xpath("//td[@class='MuiTableCell-root MuiTableCell-body'][1]/div"));

    private final SelenideElement rhEstoreLogo = $(By.xpath("//a[@data-analytics-worhlogo='worh-logo']"));

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

    private final SelenideElement searchClientResultsPlusButton = $(By.xpath("//td[@class='MuiTableCell-root MuiTableCell-body'][8]"));

    private final List<SelenideElement> toddlerBeddingList = $$(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-true']/div/ul[@class='MuiGridList-root']/li[@class='MuiGridListTile-root']"));
}
