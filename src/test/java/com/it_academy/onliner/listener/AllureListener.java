package com.it_academy.onliner.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.it_academy.onliner.utils.ScreenshotUtils.takeScreenshotAndAttachToAllureReport;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshotAndAttachToAllureReport();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        takeScreenshotAndAttachToAllureReport();
    }
}
