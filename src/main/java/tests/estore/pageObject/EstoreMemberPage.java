package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Sleeper;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class EstoreMemberPage {
    private final SelenideElement memberTitle = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item'])[6]/p"));
    private final List<SelenideElement> membershipDetails = $$(By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-direction-xs-column'])[2]/div/p"));
    private final SelenideElement addToCart = $(By.xpath("//span[@class='MuiButton-label' and text() = 'ADD TO CART']"));
    private final SelenideElement emailField = $(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input']"));
    private final SelenideElement linkEmailButton = $(By.xpath("//span[@class='MuiButton-label' and text() = 'LINK TO MEMBERSHIP']"));
    private final SelenideElement messageAlert = $(By.xpath("//div[@class='MuiAlert-message']"));
    private final SelenideElement cancelLink = $(By.xpath("//*[@data-analytics-id='link' and text() = 'Cancel Membership']"));

    //cancel membership page
    private List<SelenideElement> benefitsList = $$(By.xpath("//*[@class='MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-direction-xs-column']/ul/li"));
    private final SelenideElement continueMembershipButton = $(By.xpath("//span[@class='MuiButton-label' and text() = 'Continue Membership']"));
    private final SelenideElement cancelMembershipButton = $(By.xpath("//span[@class='MuiButton-label' and text() = 'Cancel Membership']"));
    private final SelenideElement cancelMessage = $(By.xpath("//*[@class='MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-direction-xs-column MuiGrid-grid-xl-8']/p"));
}
