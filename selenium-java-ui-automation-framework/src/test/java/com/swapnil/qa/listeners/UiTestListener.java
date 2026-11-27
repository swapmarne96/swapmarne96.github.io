package com.swapnil.qa.listeners;

import com.swapnil.qa.base.BaseTest;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class UiTestListener implements ITestListener {
    private static final Logger log = LogManager.getLogger(UiTestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("TEST STARTED: {}", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("TEST PASSED: {}", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("TEST FAILED: {}", result.getName(), result.getThrowable());
        WebDriver driver = BaseTest.getDriver();
        if (driver instanceof TakesScreenshot screenshotDriver) {
            attachFailureScreenshot(screenshotDriver.getScreenshotAs(OutputType.BYTES));
        }
    }

    @Attachment(value = "Failure screenshot", type = "image/png")
    public byte[] attachFailureScreenshot(byte[] screenshot) {
        return screenshot;
    }
}
