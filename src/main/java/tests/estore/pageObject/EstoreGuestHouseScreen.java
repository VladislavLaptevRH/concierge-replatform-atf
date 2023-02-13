package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstoreGuestHouseScreen {

    private SelenideElement diningRoomGuestHouse = $(By.xpath("//a[@id='dining_room']"));

    private SelenideElement diningRoomTeraceTitle = $(By.xpath("//*[text()='The dining room & Terrace']"));

    private SelenideElement breakfast = $(By.xpath("//*[text()='BREAKFAST']"));

    private SelenideElement brunch = $(By.xpath("//*[text()='BRUNCH']"));

    private SelenideElement lunch = $(By.xpath("//*[text()='LUNCH']"));

    private SelenideElement dinner = $(By.xpath("//*[text()='DINNER']"));

    private SelenideElement wineList = $(By.xpath("//*[text()='WINE LIST']"));

    private SelenideElement caviarBar = $(By.xpath("//a[@id='caviar_bar']"));

    private SelenideElement champageCaviarBarTitle = $(By.xpath("//*[text()='the champagne & caviar bar']"));

    private SelenideElement champageCaviarBarMenu = $(By.xpath("//*[text()='MENU']"));

    private SelenideElement guestRoomsText = $(By.xpath("//*[text()='GUEST ROOMS']"));

    private SelenideElement theResidenceText = $(By.xpath("//*[text()='THE RESIDENCE']"));

    private SelenideElement champageList = $(By.xpath("//*[text()='CHAMPAGNE LIST']"));

    private SelenideElement champageReservations = $(By.xpath("//*[text()='RESERVATIONS']"));

    private SelenideElement privateRooftopPoolText = $(By.xpath("//*[text()='private rooftop pool & dining terrace']"));

    private SelenideElement guestRoomsSuites = $(By.xpath("//a[@id='guest_room']"));

    private SelenideElement guestRooftopPool = $(By.xpath("//a[@id='rooftop_pool']"));


}
