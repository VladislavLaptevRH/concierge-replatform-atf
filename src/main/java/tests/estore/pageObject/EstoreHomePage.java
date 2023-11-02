package tests.estore.pageObject;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter

public class EstoreHomePage {

    private final SelenideElement appNavigationBar = $(By.id("app-navigation-bar"));

    private final List<SelenideElement> listOfNavigationBar = $$(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-justify-xs-space-between']/div"));
    private final List<SelenideElement> listOfBrandNames = $$(By.xpath("//div[@id= 'brand-links-container']/ul/li"));
    private final List<SelenideElement> listOfSubCategories = $$(By.xpath("(//ul[@class=\"MuiList-root\"])[1]/li"));
    private final List<SelenideElement> listOfHamburgeritems = $$(By.xpath("//div[@class= 'MuiGrid-root MuiGrid-item']/ul/li/a/span"));
    private final List<SelenideElement> listOfCollection = $$(By.xpath("(//ul[@class=\"MuiList-root\"])[2]/li"));

    private final SelenideElement searchIcon = $(By.xpath("//span[@class='MuiIconButton-label']"));
    private final SelenideElement hamburgerIcon = $(By.id("hamburgerIcon"));

    private final SelenideElement searchIconHomePage = $(By.xpath("(//span[@class='MuiIconButton-label'])[1]"));

    private final SelenideElement categoryDropdown = $(By.xpath("//div[@id='hamburgerIcon']"));
    private final SelenideElement locationDropdown = $(By.id("gallery-select"));

    private final SelenideElement searchInputField = $(By.xpath("//input[@type='text']"));
    private final SelenideElement phoneNumberInputField = $(By.id("customerPhone"));

    private final SelenideElement phoneNumberField = $(By.id("phone"));
    private final SelenideElement firstNameInputField = $(By.id("firstName"));
    private final SelenideElement lastNameInputField = $(By.id("lastName"));
    private final SelenideElement emailInputField = $(By.id("customerEmail"));
    private final SelenideElement messageInputField = $(By.id("description"));

    private final SelenideElement orderHistoryAccountMenuBtn = $(By.xpath("//*[@id='account-menu-link-/my-account/order-history.jsp']"));

    private final SelenideElement thankMessageText = $(By.xpath("//*[contains(text(),'Thank you for telling us about your project.')]"));

    private final SelenideElement searchCloseButton = $(By.xpath("//button[@data-testid = 'dialog-title-close-button']"));
    private final SelenideElement seeAllResultButton = $(By.xpath("//*[text() = 'SEE ALL RESULTS']"));
    private final SelenideElement requestConsultationButton = $(By.xpath("(//div[@cqitemsorder='rh_request_consultat']//button)[1]"));
    private final SelenideElement iframeRequestAConsultationButton = $(By.xpath("//*[text()='REQUEST A CONSULTATION']"));
    private final SelenideElement wishlist = $(By.id("account-menu-link-my-account/wish-list.jsp"));
    private final SelenideElement accountIcon = $(By.xpath("//*[@data-analytics-nav='account-icon']"));
    private final SelenideElement member = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-justify-xs-space-between'])[4]"));

    private final SelenideElement homePageLogo = $(By.xpath("//*[@data-analytics-worhlogo='worh-logo']"));

    private final SelenideElement countrySelection = $(By.id("country-selection"));

    private final SelenideElement gbCountry = $(By.xpath("//li[@data-value='GB']"));

    private final SelenideElement caCountry = $(By.xpath("//li[@data-value='CA']"));

    private final SelenideElement headerCartButton = $(By.xpath("//a[@href='/us/en/checkout/shopping_cart.jsp']"));

    private final SelenideElement rhLogo = $(By.id("container-rhr-header_logo-rhr"));

    private final SelenideElement searchField = $(By.id("container-rhrSearchField_search-btn"));

    private final SelenideElement cartIconHomePage = $(By.id("container-rhrHeader_cart-btn"));

    private final SelenideElement myAccountIconHomePage = $(By.id("container-accountNavMenu_account-btn"));


    public void verifyThatMyAccountIconIsDisplayed() {
        myAccountIconHomePage.should(visible, Duration.ofSeconds(12));
    }

    public void verifyThatCartIconIsDisplayed() {
        cartIconHomePage.should(visible, Duration.ofSeconds(12));
    }

    public void verifyThatNavigationMenuIsDisplayed() {
        appNavigationBar.should(visible, Duration.ofSeconds(12));
    }

    public void verifyThatSearchFieldIsDisplayed() {
        searchField.should(visible, Duration.ofSeconds(12));
    }

    public void verifyThatRhLogoIsDisplayed() {
        rhLogo.should(visible, Duration.ofSeconds(12));
    }

    private final SelenideElement homePageMenu = $(By.xpath("//div[contains(@data-navigation-account-item-id,'cat')]"));

    private final SelenideElement copyRightSymbol = $(By.xpath("//*[text()='© ']"));

    private final SelenideElement footerYearValue = $(By.xpath("//*[text()='2023']"));

    private final SelenideElement footerRhCompanyName = $(By.xpath("//*[text()=' RH']"));


    public void verifyThatAllItemsFromFooterAreDisplayed() {
        copyRightSymbol.should(visible, Duration.ofSeconds(12));
        footerYearValue.should(visible, Duration.ofSeconds(12));
        footerRhCompanyName.should(visible, Duration.ofSeconds(12));
    }

    public void verifyThatHomePageLogoIsDisplayed() {
        homePageLogo.should(visible, Duration.ofSeconds(30));
    }

    public void homePageMenuIsDisplayed() {
        homePageMenu.should(visible, Duration.ofSeconds(12));
    }
    private final SelenideElement cartButtonIcon = $(By.xpath("//*[@id='container-rhrHeader_cart-btn']"));

    private final SelenideElement itemCartIconCount = $(By.xpath("//*[@id='container-rhrHeader_cart-btn']//span"));


    public int getCountOfItemFromCart() {
        int countOfItem = Integer.parseInt(itemCartIconCount.getText());
        return countOfItem;
    }

    public void verifyThatCartButtonIconIsDisplayed() {
        cartButtonIcon.should(visible, Duration.ofSeconds(12));
    }

    public void clickToAccountButtonForregisteredUser() {
        accountIcon.should(interactable, Duration.ofSeconds(20));
        accountIcon.click();
    }

    public void verifyThatAccountIconIsDisplayed() {
        accountIcon.should(visible, Duration.ofSeconds(12));
    }

    public void clickToOrderHistoryAccountMenu() {
        orderHistoryAccountMenuBtn.shouldBe(interactable, Duration.ofSeconds(20));
        accountIcon.click(ClickOptions.usingJavaScript());
    }

    public void chooseGBCountry() {
        countrySelection.should(visible).scrollIntoView(true).click();
        gbCountry.should(visible, Duration.ofSeconds(20)).click();
    }

    public void chooseCACountry() {
        countrySelection.should(visible).scrollIntoView(true).click();
        caCountry.should(visible, Duration.ofSeconds(20)).click();
    }

    public void verifyThatHamburgerIconIsDisplayed() {
        hamburgerIcon.should(visible, Duration.ofSeconds(20));
    }
}
