package com.framework.init;

import com.aspose.cells.Workbook;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.framework.common.Generics;
import com.framework.utils.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.lang.reflect.Method;

public class WebDriverInit extends Generics implements Configuration {

    public static WebDriver driver;
    public static String _methodName;

    @BeforeSuite(alwaysRun = true)
    public void startReport(ITestContext testContext) {
        ExtentInit.initializeReport(testContext.getCurrentXmlTest().getSuite().getName());
        try {
            WB = new Workbook(TEST_DATA);
        } catch (Exception e) {
            testWarningLog("Creation of Test Data Workbook is failed with the error - " + e.getMessage());
            e.printStackTrace();
        }
    }

    @BeforeClass(alwaysRun = true)
    public void init() {
        switch (BROWSER.toLowerCase()) {
            case "firefox":
            case "mozilla firefox":
                driver = new FirefoxDriver(BrowserCaps.configureMozillaFirefox());
            case "edge":
            case "ms edge":
            case "microsoft edge":
                driver = new RemoteWebDriver(Configuration.getRemoteGridURL(), BrowserCaps.configureMicrosoftEdge());
            default:
                driver = new ChromeDriver(BrowserCaps.configureGoogleChrome());
        }

        implicitWaitOf(driver, IMPLICIT_WAIT);
        maximizeWindow(driver);
        openURL(driver, URL);
    }

    /**
     * To initialize the driver before executing the test cases
     *
     * @param method Test Method Instance
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        _methodName = method.getName();
    }

    /**
     * To close the resources once the test execution is completed
     *
     * @param testResult Test Result
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) {
        String testName;
        ITestContext ex = testResult.getTestContext();

        try {
            testName = testResult.getName();
            if (testResult.getStatus() == ITestResult.FAILURE) {

                logger.log(Status.FAIL, MarkupHelper.createLabel(testName + " - Test Case Failed", ExtentColor.RED));
                logger.log(Status.FAIL, MarkupHelper.createLabel(testResult.getThrowable() + " - Test Case Failed", ExtentColor.RED));
                String screenshotPath = getExtentScreenShot(driver, testName);
                logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
                testInfoLog("\n\nStep Failure\nPlease check attached screenshot : <br><br>", getScreenshotLink());

                System.out.println();
                System.out.println("TEST FAILED - " + testName);
                System.out.println();
                System.out.println("ERROR MESSAGE: " + testResult.getThrowable());
                System.out.println("\n");

                Reporter.setCurrentTestResult(testResult);
                failure();

                getShortException(ex.getFailedTests());

            } else if ((testResult.getStatus() == ITestResult.SUCCESS)) {
                logger.log(Status.PASS, MarkupHelper.createLabel(testName + " Test Case PASSED", ExtentColor.GREEN));
                System.out.println("TEST PASSED - " + testName + "\n");
            } else if ((testResult.getStatus() == ITestResult.SKIP)) {
                logger.log(Status.SKIP, MarkupHelper.createLabel(testName + " - Test Case Skipped", ExtentColor.ORANGE));
            }

        } catch (Exception throwable) {
            throwable.printStackTrace();
            System.err.println("Exception ::\n" + throwable);
        }
    }

    @AfterClass(alwaysRun = true)
    public void clear() {
        deleteCookies(driver);
        quit(driver);
    }

    /**
     * To flush the extent report details.
     */
    @AfterSuite(alwaysRun = true)
    public void endReport(ITestContext testContext) {
        ExtentInit.flushReport();
        ZipUtil.pack(new File(REPORT_PATH), new File(FOLDER_PATH + File.separator + "report" + System.currentTimeMillis() + ".zip"));
        ZipUtil.pack(new File(REPORT_PATH), new File(PROJECT_DIR + File.separator + "report_" + testContext.getCurrentXmlTest().getSuite().getName() + ".zip"));
    }
}
