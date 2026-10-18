package com.aisignpro.utils;

import java.awt.Desktop;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aisgnpro.base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;
    private String reportPath;

    @Override
    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        File reportsDir = new File(System.getProperty("user.dir"), "reports");
        reportsDir.mkdirs();
        reportPath = new File(reportsDir, "Test-Report-" + timeStamp + ".html").getAbsolutePath();

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setDocumentTitle("AiSignPro Automation Report");
        spark.config().setReportName("AiSignPro Agreement Workflow Testing");
        spark.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Application", "AiSignPro");
        extent.setSystemInfo("Environment", "Staging");
        extent.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        extent.setSystemInfo("User", System.getProperty("user.name"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.assignCategory(result.getTestClass().getRealClass().getSimpleName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, result.getName() + " passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, result.getName() + " failed");
        test.fail(result.getThrowable());

        Object instance = result.getInstance();
        if (instance instanceof BaseClass) {
            WebDriver driver = ((BaseClass) instance).getDriver();
            if (driver != null) {
                String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
                test.addScreenCaptureFromBase64String(base64, result.getName());
            }
        }
    }

    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, result.getName() + " skipped");
        if (result.getThrowable() != null) {
            test.log(Status.INFO, result.getThrowable().getMessage());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new File(reportPath).toURI());
            }
        } catch (Exception e) {
            // Headless/CI: skip auto-open
        }
    }
}
