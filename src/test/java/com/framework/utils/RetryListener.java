package com.framework.utils;

import com.framework.init.WebDriverInit;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener extends WebDriverInit implements IRetryAnalyzer {

    int counter = 0;
    int retryLimit = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (counter < retryLimit) {
            counter++;
            testWarningLog(result.getThrowable().toString());
            testInfoLog("\n\nRetrying the failed testcase", String.valueOf(counter));
            getCloseAllTab(driver);
            getBrowserRefresh(driver);
            return true;
        }
        return false;
    }
}
