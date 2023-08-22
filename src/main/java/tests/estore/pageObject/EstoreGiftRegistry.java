package tests.estore.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class EstoreGiftRegistry {

    private SelenideElement giftRegistrtyTitle = $(By.xpath("//*[text()='rh gift']"));

    private SelenideElement createARegistryButton = $(By.xpath("//span[text()='Create a Registry']"));
    private SelenideElement manageYourRegistryButton = $(By.xpath("//span[text()='Manage Your Registry']"));
    private SelenideElement selectEventyType = $(By.xpath("//select[@id='eventType']"));

    private SelenideElement eventTypeWedding = $(By.xpath("//option[@value='wedding']"));
    private SelenideElement eventDateTimeField = $(By.xpath("//input[@id='eventDateTime']"));

    private SelenideElement registrantFirstName = $(By.id("registrantAddress.firstName"));

    private SelenideElement registrantLastName = $(By.id("registrantAddress.lastName"));

    private SelenideElement registrantCountry = $(By.id("registrantAddress.country"));
    private SelenideElement registrantAddressLine = $(By.id("registrantAddress.addressLine1"));

    private SelenideElement registrantAddressLine2 = $(By.id("registrantAddress.addressLine2"));

    private SelenideElement registrantCity = $(By.id("registrantAddress.city"));

    private SelenideElement registrantState = $(By.id("registrantAddress.state"));

    private SelenideElement registrantPostalCode = $(By.id("registrantAddress.postalCode"));

    private SelenideElement registrantAddressPhone = $(By.id("registrantAddress.phone"));

    private SelenideElement createRegistryButton = $(By.xpath("//button[@type='submit']"));

    private SelenideElement selectedDate = $(By.xpath("//button[contains(@class,'MuiPickersDay-daySelected')]"));
//    (//div[@class='MuiPickersCalendar-week']//div[@role='presentation'])[32]

    private SelenideElement deleteRegistryButton = $(By.xpath("//*[text()='DELETE']"));
    private SelenideElement confirmDeleteRegistryButton = $(By.xpath("//*[text()='Delete registry']"));

    private SelenideElement giftRegistryButton = $(By.xpath("//h6[text()='Gift Registry']"));
    private SelenideElement findARegistryButton = $(By.xpath("//a[@href='/us/en/gift-registry/search.jsp']"));

    private SelenideElement searchRegistryFirstName = $(By.xpath("//input[@id='firstName']"));
    private SelenideElement searchRegistryLastName = $(By.xpath("//input[@id='lastName']"));

    private SelenideElement youDoNotHaveRegistry = $(By.xpath("//*[text()='You do not have a registry at this time. You may create one using the Create A Registry menu item on the left.']"));

    private SelenideElement registrantFirstNameSearchResult = $(By.xpath("//*[text()='REGISTRANT NAME']"));
    private SelenideElement registrantEventDateSearchResult = $(By.xpath("//*[text()='EVENT DATE']"));
    private SelenideElement registrantEventLocationSearchResult = $(By.xpath("//*[text()='EVENT LOCATION']"));
    private SelenideElement registrantEventTypeSearchResult = $(By.xpath("//*[text()='EVENT TYPE']"));
    private SelenideElement registrantRegistryNoSearchResult = $(By.xpath("//*[text()='REGISTRY NO.']"));

    public void verifyThatSearchResultIsDisplayed() {
        registrantFirstNameSearchResult.should(Condition.visible);
        registrantEventDateSearchResult.should(Condition.visible);
        registrantEventLocationSearchResult.should(Condition.visible);
        registrantEventTypeSearchResult.should(Condition.visible);
        registrantRegistryNoSearchResult.should(Condition.visible);
    }

    public void verifyThatYouDoNotHaveRegistryMessageIsDisplayed() {
        youDoNotHaveRegistry.should(Condition.visible);
    }

    public void introduceSearchRegistryFirstName() {
        searchRegistryFirstName.should(Condition.visible).setValue("test");
    }

    public void introduceSearchRegistryLastName() {
        searchRegistryLastName.should(Condition.visible).setValue("test");
    }

    public void introduceRegistrantFirstName() {
        registrantFirstName.should(Condition.visible).setValue("Bill");
    }

    public void introduceRegistrantLastName() {
        registrantLastName.should(Condition.visible).setValue("Reghre");
    }

    public void selectRegistrantCountry() {
        registrantCountry.should(Condition.visible);
        Select selectRegistrantCountry = new Select(registrantCountry);
        selectRegistrantCountry.selectByValue(Hooks.country);
    }

    public void selectRegistrantStreetAddress() {
        registrantAddressLine.should(Condition.visible).setValue("51 Rutter Rd");
    }

    public void selectRegistrantCity() {
        registrantCity.should(Condition.visible).setValue("Halifax");
    }

    public void selectRegistrantPostalCode() {
        registrantPostalCode.should(Condition.visible).setValue("17032");
    }

    public void selectRegistrantState(String state) {
        registrantState.should(Condition.interactable);
        Select selectState = new Select(registrantState);
        selectState.selectByValue(state);
    }

    public void selectRegistrantPhone() {
        registrantAddressPhone.should(Condition.visible).setValue("(717) 896-2972");
    }


    public void selectRegistryEventType(String eventType) {
        Select selectEventType = new Select(selectEventyType);
        selectEventType.selectByValue(eventType);
    }

    public void selectEventTimeDate() {
        eventDateTimeField.should(Condition.visible).click();
        selectedDate.should(Condition.visible, Duration.ofSeconds(30)).click();
    }

    public void clickToCreateRegistryButton() {
        createRegistryButton.should(Condition.visible, Duration.ofSeconds(20)).click();
    }

    public void verifyThatGiftRegistrtyTitleIsDisplayed() {
        giftRegistrtyTitle.should(Condition.visible, Duration.ofSeconds(20));
    }

    public void clickToCreateARegistryButton() {
        createARegistryButton.should(Condition.interactable, Duration.ofSeconds(15))
                .click();
    }

    public void clickToManageYourRegistryButton() {
        manageYourRegistryButton.should(Condition.interactable, Duration.ofSeconds(15))
                .click();
    }

    public void clickToFindARegistryButton() {
        findARegistryButton.should(Condition.interactable, Duration.ofSeconds(15))
                .click();
    }

    public void clickToDeleteRegistryButton() {
        deleteRegistryButton.should(Condition.visible).click();
        confirmDeleteRegistryButton.should(Condition.visible).click();
    }

    public void clickToGiftRegistryButton() {
        giftRegistryButton.should(Condition.visible).click();
    }


}
