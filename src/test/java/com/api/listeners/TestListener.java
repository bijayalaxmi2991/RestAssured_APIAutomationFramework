package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListener.class);

    public void onStart(ITestContext context) {
        logger.info("TEST STARTED!");
    }

    public void onFinish(ITestContext context) {
        logger.info("TEST COMPLETED!");
    }

    public void onTestStart(ITestResult result) {
        logger.info("STARTED:: "+ result.getMethod().getMethodName());
        logger.info("Description: "+ result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("PASSED:: "+ result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        logger.error("FAILED:: "+ result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
        logger.error("SKIPPED:: "+ result.getMethod().getMethodName());
    }



}
