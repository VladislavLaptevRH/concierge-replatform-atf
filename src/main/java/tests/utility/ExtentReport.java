package tests.utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.JsonFormatter;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class ExtentReport {
    public  static ExtentReports extent;
    public static ExtentSparkReporter config;
    public static String reportTitle;


    public static void startReport(Scenario scenario) throws IOException {
        extent = new ExtentReports();
        config = new ExtentSparkReporter("target/cucumber-html-report");
        JsonFormatter json = new JsonFormatter("cucumber-reports/Cucumber.json");
        extent.createDomainFromJsonArchive("cucumber-reports/Cucumber.json");
        extent.createTest(scenario.getName());
        extent.attachReporter(json, config);
        config.config().setReportName(getReportTitle());
    }

    public static String getReportTitle () {
        if (Hooks.profile.contains("stg2") && Hooks.conciergeURL.contains("stg2")) {
            reportTitle = "Concierge Stg2 Regression Report";
        } else if (Hooks.profile.contains("stg4") && Hooks.conciergeURL.contains("stg4")) {
            reportTitle = "Concierge Stg4 Regression Report";
        } else if (Hooks.profile.contains("prod") && Hooks.conciergeURL.contains("concierge")) {
            reportTitle = "Concierge Production Smoke Test Report";
        } else if (Hooks.profile.contains("stg2") && Hooks.eStoreURL.contains("stg2")) {
            reportTitle = "eStore Stg2 Regression Report";
        } else if (Hooks.profile.contains("stg4") && Hooks.eStoreURL.contains("stg4")) {
            reportTitle = "eStore Stg4 Regression Report";
        }else if (Hooks.profile.contains("prod") && Hooks.eStoreURL.contains("rh")) {
            reportTitle = "eStore Production Smoke Test Report";
        }
        return reportTitle;
    }
}
