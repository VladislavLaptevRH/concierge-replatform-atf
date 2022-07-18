package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class RestrictionPopUp{

    private final SelenideElement shippingRestricitonsTitle = $(By.xpath("//h2[@class='MuiTypography-root MuiTypography-h2']"));
    
    private final SelenideElement restrictionsMessage = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-12 MuiGrid-grid-md-12'][2]"));
    
    private final SelenideElement viewCartButton = $(By.xpath("//div[contains(@class,'MuiGrid-root MuiGrid-item')][1]/button"));

    private final SelenideElement editCartButton = $(By.xpath("//div[contains(@class,'MuiGrid-root MuiGrid-item')][2]/button"));

}
