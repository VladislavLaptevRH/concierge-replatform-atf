package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstoreOrderHistoryScreen {
    private SelenideElement year22 = $(By.xpath("(//*[contains(text(),'2022')])[3]"));

    private SelenideElement orderNumber = $(By.xpath("(//*[contains(text(),'#')])[3]"));

    private SelenideElement orderTotal = $(By.xpath("(//*[text()='Total'])[1]"));

    private SelenideElement shipTo = $(By.xpath("//*[text()='SHIP TO']"));

    private SelenideElement foundText = $(By.xpath("//*[text()='Found']"));

    private SelenideElement ordersText = $(By.xpath("//*[text()='Orders']"));

    private SelenideElement orderHistorySafireWilliam = $(By.xpath("//*[text()='Safire William']"));

    private SelenideElement orderHistoryFoundText = $(By.xpath("//*[text()='Found']"));

    private SelenideElement orderHistoryOrderText = $(By.xpath("//*[text()='Order']"));

    private SelenideElement orderHistoryButton = $(By.xpath("//li[@data-navigation-account-item-id='/my-account/order-history.jsp']"));

    private SelenideElement detailsAndTrackingButton = $(By.xpath("(//*[text()='Details and Tracking'])[1]"));

    private SelenideElement orderHistoryEstoreLogo = $(By.xpath("//a[@data-analytics-worhlogo='worh-logo']"));

    private SelenideElement orderHistoryPage1Button = $(By.xpath("//button[@aria-label='page 1']"));

    private SelenideElement orderHistoryPage2Button = $(By.xpath("//button[@aria-label='Go to page 2']"));

    private SelenideElement billingSummaryButton = $(By.xpath("(//*[text()='Billing Summary'])[1]"));

    private SelenideElement billingSummaryBrandTitle = $(By.xpath("//h1[@class='title brand']"));

    private SelenideElement shipToText = $(By.xpath("(//*[text()='SHIP TO'])[1]"));

    private SelenideElement titleBrand = $(By.xpath("//h1[@class='title brand']"));

    private SelenideElement cwNumber = $(By.xpath("//*[text()='#']"));

}
