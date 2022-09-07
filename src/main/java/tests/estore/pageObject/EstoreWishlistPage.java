package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import java.util.List;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class EstoreWishlistPage {
    private final List<SelenideElement> listOfWishItems = $$(By.xpath("//a[@class='MuiTypography-root MuiLink-root MuiLink-underlineHover MuiTypography-colorPrimary']"));
    private final SelenideElement whistItem = $(By.id("rh-line-item-card"));
    private final SelenideElement memberPrice = $(By.xpath("//p[@data-testid='price-label-member']"));
}
