package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter

public class RegistryScreen {
    private SelenideElement paginationPages = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-justify-xs-center']"));

    private SelenideElement registryAddToCartButton = $(By.xpath("(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth'])[1]"));

    private SelenideElement selectItemQuantity = $(By.xpath("(//select[contains(@id,'quantity')])[2]"));

    private SelenideElement purhcaseRegistryButton = $(By.xpath("//*[text()='PURCHASE']"));

    private SelenideElement editRegistryButton = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item'][3]/a[@class='sc-gsDKAQ lbYYYt']"));

    private SelenideElement continueRegistrantButton = $(By.xpath("(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth'])[2]"));

    private SelenideElement deleteRegistryButton = $(By.xpath("//*[text()='DELETE']"));

    private SelenideElement primaryEmailAddress = $(By.xpath("(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-fullWidth MuiInputBase-formControl']/input)[1]"));

    private SelenideElement registryButton = $(By.xpath("//a[@href='/registry-search-v2']"));

    private SelenideElement firstName = $(By.xpath("//input[@name='first_name']"));

    private SelenideElement lastName = $(By.xpath("//input[@name='last_name']"));

    private SelenideElement email = $(By.xpath("//input[@name='email']"));

    private SelenideElement registryNumber = $(By.xpath("//input[@name='registry_number']"));

    private SelenideElement createdBy = $(By.xpath("//input[@name='created_by']"));

    private SelenideElement city = $(By.xpath("//input[@name='city']"));

    private SelenideElement eventType = $(By.xpath("//div[@id='type']"));

    private SelenideElement eventWeddingType = $(By.xpath("//li[@data-value='wedding']"));

    private SelenideElement createInGallery = $(By.xpath("//div[@id='gallery_id']"));

    private SelenideElement year = $(By.xpath("//div[@id='year']"));

    private SelenideElement month = $(By.xpath("//div[@id='month']"));

    private SelenideElement state = $(By.xpath("//div[@id='state']"));

    private SelenideElement saveChangeButton = $(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth']"));

    private SelenideElement editRegistryDetailsButton = $(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth']"));

    private SelenideElement confirmDeleteRegistryButton = $(By.xpath("(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth'])[2]"));

    private SelenideElement searchRegistryButton = $(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth']"));

    private SelenideElement searchResult = $(By.xpath("//tbody[@class='MuiTableBody-root']"));

    private SelenideElement newRegistryButton = $(By.xpath("(//a[@href=\"/create-registry-v2\"])[2]"));

    private SelenideElement newRegistryEventType = $(By.xpath("//div[@id='event']"));

    private SelenideElement registrantFirstName = $(By.id("registrantAddress.firstName"));

    private SelenideElement registrantLastName = $(By.id("registrantAddress.lastName"));

    private SelenideElement registrantAddressLine = $(By.id("registrantAddress.addressLine1"));

    private SelenideElement registrantAddressLine2 = $(By.id("registrantAddress.addressLine2"));

    private SelenideElement registrantCity = $(By.id("registrantAddress.city"));

    private SelenideElement registrantState = $(By.id("registrantAddress.state"));

    private SelenideElement registrantPostalCode = $(By.id("registrantAddress.postalCode"));

    private SelenideElement registrantAddressPhone = $(By.id("registrantAddress.phone"));

    private SelenideElement coRegistrantFirstName = $(By.id("coRegistrantAddress.firstName"));

    private SelenideElement coRegistrantLastName = $(By.id("coRegistrantAddress.lastName"));

    private SelenideElement coRegistrantAddressLine = $(By.id("coRegistrantAddress.addressLine1"));

    private SelenideElement coRegistrantAddressLine2 = $(By.id("coRegistrantAddress.addressLine2"));

    private SelenideElement coRegistantCity = $(By.id("coRegistrantAddress.city"));

    private SelenideElement coRegistantState = $(By.id("coRegistrantAddress.state"));

    private SelenideElement coRegistanPostalCode = $(By.id("coRegistrantAddress.postalCode"));

    private SelenideElement coRegistrantDayPhone = $(By.id("coRegistrantAddress.phone"));

}
