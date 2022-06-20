package com.test.pageObject;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import java.util.List;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
@Getter

public class SaleScreen {
    private final SelenideElement saleOption = $(By.xpath("//*[@class='MuiTypography-root MuiTypography-subtitle1' and text()='SALE']"));
    private final List<SelenideElement> listOfNavigationBars = $$(By.xpath("//div[@class= 'MuiGrid-root MuiGrid-container MuiGrid-justify-xs-space-evenly']//div"));
}
