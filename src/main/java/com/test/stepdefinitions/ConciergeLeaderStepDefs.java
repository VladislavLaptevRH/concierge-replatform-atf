package com.test.stepdefinitions;

import com.test.pageObject.ConciergeLoginPage;
import com.test.utility.Hooks;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class ConciergeLeaderStepDefs {
    WebDriver webDriver = Hooks.getWebDriver();
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage(webDriver);

}
