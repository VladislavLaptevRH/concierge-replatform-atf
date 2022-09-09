package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
@Getter

public class EstoreHomePage {
    private final List<SelenideElement> listOfNavigationBar = $$(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-justify-xs-space-between']/div"));
    private final List<SelenideElement> listOfBrandNames = $$(By.xpath("//div[@id= 'brand-links-container']/ul/li"));
    private final List<SelenideElement> listOfSubCategories = $$(By.xpath("//div[@class= 'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3']/ul/li"));
    private final List<SelenideElement> listOfHamburgeritems = $$(By.xpath("//div[@class= 'MuiGrid-root MuiGrid-item']/ul/li/a/span"));

    private final SelenideElement searchIcon = $(By.xpath("//span[@class='MuiIconButton-label']"));
    private final SelenideElement hamburgerIcon = $(By.id("hamburgerIcon"));

    private final SelenideElement categoryDropdown = $(By.id("nav-cat-img"));
    private final SelenideElement locationDropdown = $(By.id("gallery-select"));

    private final SelenideElement searchInputField = $(By.id("site-search-input"));
    private final SelenideElement phoneNumberInputField = $(By.id("customerPhone"));
    private final SelenideElement firstNameInputField = $(By.id("firstName"));
    private final SelenideElement lastNameInputField = $(By.id("lastName"));
    private final SelenideElement emailInputField = $(By.id("customerEmail"));
    private final SelenideElement messageInputField = $(By.id("message"));

    private final SelenideElement thankMessageText = $(By.xpath("//p[@class= 'MuiTypography-root MuiTypography-body1 MuiTypography-paragraph']"));

    private final SelenideElement searchCloseButton = $(By.xpath("//button[@data-testid = 'dialog-title-close-button']"));
    private final SelenideElement seeAllResultButton = $(By.xpath("//button[@class= 'MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedSecondary']"));
    private final SelenideElement requestConsultationButton = $(By.xpath("//button[@bannername= 'RequestConsultation']"));
    private final SelenideElement iframeRequestAConsultationButton = $(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth']"));
    private final SelenideElement wishlist = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-justify-xs-space-between'])[3]"));
    private final SelenideElement accountIcon = $(By.xpath("//div[@data-analytics-nav='account-icon']"));
    private final SelenideElement member = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-justify-xs-space-between'])[4]"));
}
