package com.framework.common;

import com.aspose.cells.Cells;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.framework.init.ExtentInit;
import com.framework.utils.Logger;
import com.github.javafaker.Faker;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IResultMap;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.Utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class Generics extends Logger {

    protected static int _logStep = 1;
    public static String screenshotPath = "";
    private static final Faker faker = new Faker(new Locale("en-IND"));
    protected static WebDriverWait wait;
    public static Workbook WB;

    /**
     * Pause for passed seconds
     *
     * @param secs Time in Seconds
     */
    public static void pause(int... secs) {
        try {
            Thread.sleep((secs.length != 0 ? secs[0] : STATIC_WAIT) * 1000L);
        } catch (InterruptedException interruptedException) {
            System.out.println("Failure in Pause.");
        }
    }

    /**
     * To clear and send the value to the text field
     *
     * @param webElement WebElement
     * @param value      String Value
     */
    public static void type(WebElement webElement, String value) {
        clear(webElement);
        getStaticWait(100);
        sendKeys(webElement, value);
    }

    public static void typeSlow(WebDriver driver, WebElement webElement, String value) {
        getExplicitWait(driver, webElement, EXPLICIT_WAIT);
        clickOn(driver, webElement);
        getStaticWait(100);
        clear(webElement);
        clickOn(driver, webElement);
        for (int index = 0; index < value.length(); index++) {
            if (index == 0) clickOn(driver, webElement);
            webElement.sendKeys(String.valueOf(value.charAt(index)));
            getStaticWait(75);
        }
    }

    /**
     * To clear the value from the text field
     *
     * @param webElement WebElement
     */
    public static void clear(WebElement webElement) {
        webElement.clear();
    }

    public static void sendKeys(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    /**
     * To click on particular WebElement
     *
     * @param driver  WebDriver
     * @param element WebElement
     */
    public static void clickOn(WebDriver driver, WebElement element) {
        getExplicitWait(driver, element, EXPLICIT_WAIT);
        try {
            element.click();
        } catch (ElementClickInterceptedException ex) {
            clickOnJS(driver, element);
        }
    }

    public static void getExplicitWait(WebDriver webDriver, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void clickOnJS(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * To get text from the element
     *
     * @param element WebElement
     * @return Text from the WebElement
     */
    public static String getText(WebElement element) {
        return element.getText().trim();
    }

    /**
     * To get text from the element
     *
     * @param element WebElement
     * @return Text from the WebElement
     */
    public static String getValue(WebElement element) {
        return element.getAttribute("value").trim();
    }

    /**
     * To get text from the element
     *
     * @param element WebElement
     * @return Text from the WebElement
     */
    public static String getInnerText(WebElement element) {
        return element.getAttribute("innerText").trim();
    }

    /**
     * To get text from the element
     *
     * @param element WebElement
     * @return Text from the WebElement
     */
    public static String getTextJS(WebDriver driver, WebElement element) {
        return ((JavascriptExecutor) driver).executeScript("return $(arguments[0]).text();", element).toString();
    }

    /**
     * To check if element is available in page or not
     *
     * @param element WebElement
     * @return if web element display or not
     */
    public static boolean isElementDisplay(WebElement element) {
        return element.isDisplayed();
    }

    /**
     * To check if element is available in page or not
     *
     * @param element WebElement
     * @return if web element display or not
     */
    public static boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }


    public static boolean isElementPresent(WebDriver driver, String locator) {
        try {
            return driver.findElement(By.xpath(locator)).isDisplayed();
        } catch (NoSuchElementException nse) {
            return false;
        }
    }

    /**
     * @param driver  WebDriver
     * @param element WebElement
     */
    public static void scrollToElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        pause(1);
    }

    public static void scrollElement(WebElement element) {
        Coordinates cor = ((Locatable) element).getCoordinates();
        cor.inViewPort();
        pause(2);
    }

    public static void scrollToBottom(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


    /**
     * To highlight the selected element
     *
     * @param driver  WebDriver
     * @param element WebElement
     */
    private static void highlightElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border = '3px solid yellow'", element);
        pause(2);
    }

    /**
     * To open the URL in browser window
     *
     * @param driver WebDriver
     * @param url    URL String
     */
    public static void openURL(WebDriver driver, String url) {
        driver.get(url);
    }

    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public static void close(WebDriver driver) {
        driver.close();
    }

    /**
     * To refresh the web page
     *
     * @param driver WebDriver
     */
    public static void refresh(WebDriver driver) {
        driver.navigate().refresh();
    }

    /**
     * To get string with the random characters for with the passed characters length limit
     *
     * @param length String length
     * @return Random string
     */
    public static String getRandomCharacters(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    /**
     * To get the invalid email address
     *
     * @return Invalid Email Address
     */
    public static String getInvalidEmail() {
        return getRandomFirstName().toLowerCase() + "." + getRandomLastName().toLowerCase() + "testmail.com";
    }

    public static String getRegistrationEmail() {
        return "test_agent" + System.currentTimeMillis() + "@mailinator.com";
    }

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getPatientName() {
        return getRandomFirstName() + " " + getRandomLastName();
    }

    public static String getDoctorName() {
        return "Dr. " + getRandomFirstName() + " " + getRandomLastName();
    }

    public static String getRandomStreetName() {
        return faker.address().streetName();
    }

    public static String getBuildingNumber() {
        return faker.address().buildingNumber();
    }

    public static String getRandomVillage() {
        return faker.address().cityName();
    }

    public static String getRandomUsername() {
        return faker.name().username();
    }

    public static String getRandomDistrict() {
        return faker.address().city();
    }

    public static String getRandomCountry() {
        return faker.address().country();
    }

    public static String getRandomPinCode() {
        return faker.address().zipCode();
    }

    public static String getRandomBusinessName() {
        return faker.company().name();
    }

    public static String getRandomDBAName() {
        return faker.company().profession();
    }

    public static String getRandomURL() {
        return faker.company().url();
    }

    public static String getRandomGSTNumber() {
        return getRandomCharacters(2).toUpperCase() + getRandomCharacters(5).toUpperCase()
                + getRandomNumberBetween(1000, 9999) + (int) Math.round(Math.random()) +
                getRandomCharacters(1).toUpperCase() + "Z" + (int) Math.round(Math.random());
    }

    /**
     * To get the random email address or unregistered email address
     *
     * @return Random Email Address
     */
    public static String getUnRegisteredEmail() {
        return getRandomFirstName().toLowerCase() + "." + getRandomLastName().toLowerCase() + "@testmail.com";
    }

    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

    public static String getRandomMessage() {
        return faker.lorem().fixedString(100);
    }

    /**
     * To get the random password
     *
     * @return Random Password
     */
    public static String getRandomPassword() {
        return getRandomCharacters(3).toLowerCase() +
                getRandomCharacters(2).toUpperCase() + "@" + getRandomNumber();
    }

    public static int getRandomPIN() {
        return getRandomNumberBetween(1000, 9999);
    }

    /**
     * To get the random number from 10000 to 99999
     *
     * @return Random Number
     */
    public static int getRandomNumber() {
        return faker.number().numberBetween(10000, 99999);
    }

    public static long getRandomMobileNumber() {
        return Long.parseLong(getRandomNumber() + "" + getRandomNumber());
    }

    /**
     * To get the random number from 10000 to 99999
     *
     * @return Random Number
     */
    public static int getRandomNumberBetween(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

    /**
     * To check if the list is empty or not
     *
     * @param list List
     * @return true if list is empty
     */
    public static boolean isListEmpty(List list) {
        return list.size() == 0;
    }

    public static int sizeOf(List list) {
        return list.size();
    }

    public static int lastIndexOf(List list) {
        return sizeOf(list) - 1;
    }

    public static int getIntegerFromString(String str) {
        return Integer.parseInt(str.replaceAll("[^0-9.]+", ""));
    }

    public static long getLongFromString(String str) {
        return Long.parseLong(str.replaceAll("[^0-9.]+", ""));
    }

    public static double getDoubleFromString(String str) {
        return Double.parseDouble(str.replaceAll("[^0-9.]+", ""));
    }

    public static double formatTwoDecimal(double num) {
        DecimalFormat format = new DecimalFormat("0.00");
        return getDoubleFromString(format.format(num));
    }

    public static void switchToWindow(WebDriver driver) {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public static void switchToFrame(WebDriver driver, String id) {
        driver.switchTo().frame(id);
    }

    /**
     * To get the failure exception in single line
     *
     * @param tests Test Result
     */
    public static void getShortException(IResultMap tests) {

        for (ITestResult result : tests.getAllResults()) {

            Throwable exception = result.getThrowable();
            List<String> msgs = Reporter.getOutput(result);
            boolean hasReporterOutput = msgs.size() > 0;
            boolean hasThrowable = exception != null;
            if (hasThrowable) {
                boolean wantsMinimalOutput = result.getStatus() == ITestResult.SUCCESS;
                if (hasReporterOutput) {
                    testInfoLog((wantsMinimalOutput ? "Expected Exception" : "Failure Reason:"), "");
                }

                String str = Utils.shortStackTrace(exception, true);
                System.out.println(str);
                Scanner scanner = new Scanner(str);
                String firstLine = scanner.nextLine();
                testValidationLog(firstLine);
            }
        }
    }

    public static void setAttribute(WebDriver driver, String id, String attr) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('" + id + "').setAttribute('attr', '" + attr + "')");
    }

    public static long getMonthDifferenceBetween(LocalDate joinMonthYear, LocalDate currentMonthYear) {
        return ChronoUnit.MONTHS.between(
                joinMonthYear.withDayOfMonth(1),
                currentMonthYear.withDayOfMonth(1));
    }

    public static String getLastFileModified(String dir) {
        File fl = new File(dir);
        File[] files = fl.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isFile();
            }
        });
        long lastMod = Long.MIN_VALUE;
        File choice = null;
        for (File file : files) {
            if (file.lastModified() > lastMod) {
                choice = file;
                lastMod = file.lastModified();
            }
        }
        return choice.getName();
    }

    public static Double findMin(List<Double> list) {
        if (list == null || list.size() == 0) {
            return Double.MAX_VALUE;
        }
        return Collections.min(list);
    }

    public static Double findMax(List<Double> list) {
        if (list == null || list.size() == 0) {
            return Double.MIN_VALUE;
        }
        return Collections.max(list);
    }

    public static String getScreenshotLink() {
        return "<img src='" + screenshotPath + "' width='640' height='380'/>";
    }

    public static String getExtentScreenShot(WebDriver driver, String screenshot_name) {
        String destination = "";
        screenshotPath = "Screenshots" + File.separator + screenshot_name + ".png";
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            destination = ExtentInit.REPORT_PATH + File.separator + screenshotPath;
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    public static String getCurrentTimeStampString() {

        Date date = new Date();

        SimpleDateFormat sd = new SimpleDateFormat("MMddHHmmssSS");
        TimeZone timeZone = TimeZone.getDefault();
        Calendar cal = Calendar.getInstance(new SimpleTimeZone(timeZone.getOffset(date.getTime()), "GMT"));
        sd.setCalendar(cal);
        return sd.format(date);
    }

    public void stepFailure(WebDriver driver) {
        pause(1);
        getExtentScreenShot(driver, "Step_" + getCurrentTimeStampString());
        testInfoLog("\n\nStep Failure\nPlease check attached screenshot <br>", getScreenshotLink());
        failure();
    }

    public void stepPassed() {
        success();
    }

    public void deleteCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    public void quit(WebDriver driver) {
        driver.quit();
    }

    public void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public void implicitWaitOf(WebDriver driver, int... seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds.length != 0 ? seconds[0] : IMPLICIT_WAIT));
    }

    public static int getRandomIndex(List list) {
        return getRandomNumberBetween(0, lastIndexOf(list));
    }

    public static void scrollToTop(WebDriver driver) {
        WebElement element = driver.findElement(By.tagName("header"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void openLinkInNewWindow(WebDriver driver, String url) {
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", url);
        switchToWindow(driver);
    }

    public static void closeCurrentWindow(WebDriver driver) {
        driver.close();
        switchToWindow(driver);
    }

    public void mouseHoverTo(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        pause(1);
    }

    public static void switchToAlertAndAccept(WebDriver webDriver) {
        try {
            webDriver.switchTo().alert().accept();
        } catch (Exception e) {
            System.out.println("Failed to switch to the Alert");
        }
    }

    public static void getStaticWait(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ignored) {
        }
    }

    public static HashMap<String, ArrayList<Object>> getTestDataWorkbook(String tabName) {
        HashMap<String, ArrayList<Object>> map = new HashMap<>();
        try {
            WB = new Workbook(TEST_DATA);
            Worksheet sheet = WB.getWorksheets().get(tabName);
            Cells cell = sheet.getCells();
            int rowCount = cell.getMaxDataRow();
            int columnCount = cell.getMaxDataColumn();

            for (int row = 0; row <= rowCount; row++)
                for (int column = 0; column <= columnCount; column++)
                    if (map.containsKey(cell.get(0, column).getDisplayStringValue()))
                        map.get(cell.get(0, column).getDisplayStringValue()).add(cell.get(row, column).getDisplayStringValue());
                    else
                        map.put(cell.get(0, column).getDisplayStringValue(), new ArrayList<>());
        } catch (Exception e) {
            e.printStackTrace();
        }
        testInfoLog("Input data Tab", tabName);
        return map;
    }

    public static String getData(HashMap<String, ArrayList<Object>> map, String value, int count) {
        return map.get(value).get(count).toString().toUpperCase().trim();
    }

    public static int getActiveTabCount(WebDriver driver) {
        try {
            return Integer.parseInt(driver.findElement(By.xpath("//li[contains(@id,'nav_tab') and @class='active']")).getAttribute("id").replace("nav_tab_", ""));
        } catch (Exception e) {
            testWarningLog("Reading Tab-count failed");
            e.printStackTrace();
            return -1;
        }
    }

    public static int getSpecificTabCount(WebDriver driver, String tabName) {
        new
                WebDriverWait(driver,
                Duration.ofSeconds(EXPLICIT_WAIT)).
                until(ExpectedConditions.
                        visibilityOf(
                                driver.findElement(By.xpath("//ul[@id='navWrapTabs']/li/a/label[text()='" + tabName + "']"))));
        try {
            ArrayList<WebElement> tabNames = (ArrayList<WebElement>) driver.findElements(By.xpath("//ul[@id='navWrapTabs']/li/a/label"));
            int tabCount = 0;
            for (int i = 0; i < tabNames.size(); i++) {
                if (tabNames.get(i).getText().equals(tabName)) {
                    tabCount = i;
                }
            }

            String tempTabName = null;
            ArrayList<WebElement> tabNumber = (ArrayList<WebElement>) driver.findElements(By.xpath("//ul[@id='navWrapTabs']/li"));
            for (int i = 0; i < tabNumber.size(); i++) {
                if (i == tabCount) {
                    tempTabName = tabNumber.get(i).getAttribute("id");
                }
            }

            String[] temp = tempTabName.split("_tab_");
            tabCount = Integer.parseInt(temp[1]);

            return tabCount;
        } catch (Exception e) {
            testWarningLog("Reading Tabcount failed with the error - ");
            throw (e);
        }
    }

    public static void getBrowserRefresh(WebDriver driver) {
        driver.navigate().refresh();
        try {
            driver.switchTo().alert().accept();
        } catch (Exception noException) {
        }
    }

    public static boolean getSelectFromList(WebDriver driver, List<WebElement> List, WebElement element, WebElement elementAdd, String value) {
        try {
            pause(1);
            if (List.size() > 0) {
                new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));
                clickOn(driver, element);
                return false;
            } else {
                new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));
                clickOn(driver, elementAdd);
                return true;
            }
        } catch (Exception e) {
            testWarningLog("Selecting value failed - " + value);
            e.printStackTrace();
            return false;
        }
    }

    public static void getMoveElementToVisibility(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public boolean isAttributePresent(WebElement element, String attribute) {
        boolean result = false;
        try {
            String value = element.getAttribute(attribute);
            if (value != null) {
                result = true;
            }
        } catch (Exception ignore) {
        }

        return result;
    }

    public String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return formatter.format(date);
    }

    public static void getAlertCheck(String alert) {
        try {
            if (!Objects.equals(alert, "")) {
                testInfoLog("Alert", alert);
            }
        } catch (Exception ignored) {
        }
    }

    public static void getCloseAllTab(WebDriver driver) {
        SideMenuController sideMenuController = new SideMenuController(driver);
        pause();
        while (!(sideMenuController.getCurrentTabName().contains("Sale"))) {
            sideMenuController.closeCurrentTab(getActiveTabCount(driver));
        }
    }
}
