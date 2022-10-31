package com.projectName.pageObjects.salesBill.Controller;

import com.projectName.constants.DataConstantsSalesBill;
import com.projectName.constants.Validations;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.framework.init.AbstractPage;
import com.projectName.pageObjects.salesBill.Verification.SalesOrderVerification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SalesOrderController extends AbstractPage implements Validations, DataConstantsSalesBill {

    int tabCount;

    public SalesOrderController(WebDriver driver) {
        super(driver);
    }

    private WebElement txtbx_SearchSalesInvoice;
    private WebElement txtbx_HeaderDetails;
    private WebElement txt_InvoiceDetails;

    private WebElement btn_Filter;
    private WebElement txt_AddFilter;
    private WebElement txtbx_StartDate;
    private WebElement btn_ApplyFilter;
    private WebElement txtbx_PatientName;
    private WebElement txtbx_DoctorName;
    private WebElement btn_DeleteBill;
    private WebElement btn_EditBill;
    private WebElement btn_ReorderBill;
    private WebElement btn_FilterClose;

    private WebElement getTxtbx_HeaderDetails(int tabCount, int headerCount) {
        txtbx_HeaderDetails = driver.findElement(By.xpath("(//div[@id='mainTable_tabCon_" + tabCount + "_wrapper']//div[@class='dataTables_scrollHeadInner headerWidth']//tr/th/input)[" + headerCount + "]"));
        return txtbx_HeaderDetails;
    }

    private WebElement getTxt_InvoiceDetails(int tabCount) {
        txt_InvoiceDetails = driver.findElement(By.xpath("//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td"));
        return txt_InvoiceDetails;
    }

    private WebElement getTxtbx_SearchSalesInvoice(int tabCount) {
        txtbx_SearchSalesInvoice = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@class='dataTables_scroll']//tr[@role='row']/th/input[@placeholder='Invoice']"));
        return txtbx_SearchSalesInvoice;
    }

    private WebElement getBtn_Filter(int tabCount) {
        btn_Filter = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//button[@id='filter']"));
        return btn_Filter;
    }

    private WebElement getBtn_FilterClose(int tabCount) {
        btn_FilterClose = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@id='reportFilter']/div/h2/a"));
        return btn_FilterClose;
    }

    private WebElement getTxt_AddFilter(int tabCount) {
        txt_AddFilter = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@id='reportFilter']/div/h2"));
        return txt_AddFilter;
    }

    private WebElement getTxtbx_StartDate(int tabCount) {
        txtbx_StartDate = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//input[@id='lookbackStart']"));
        return txtbx_StartDate;
    }

    private WebElement getBtn_ApplyFilter(int tabCount) {
        btn_ApplyFilter = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//button[@id='applyFilter']"));
        return btn_ApplyFilter;
    }

    private WebElement getTxtbx_PatientName(int tabCount) {
        txtbx_PatientName = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//label[text()='Patient']//parent::th/input"));
        return txtbx_PatientName;
    }

    private WebElement getTxtbx_DoctorName(int tabCount) {
        txtbx_DoctorName = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//label[text()='Doctor']//parent::th/input"));
        return txtbx_DoctorName;
    }

    private WebElement getBtn_DeleteBill(int tabCount, int row) {
        btn_DeleteBill = driver.findElement(By.xpath("//table[@id='mainTable_tabCon_" + tabCount + "']//tr[" + row + "]//button[@title='Delete']"));
        return btn_DeleteBill;
    }

    private WebElement getBtn_ReorderBill(int tabCount, int row) {
        btn_ReorderBill = driver.findElement(By.xpath("//table[@id='mainTable_tabCon_" + tabCount + "']//tr[" + row + "]//button[@title='Reorder']"));
        return btn_ReorderBill;
    }

    private WebElement getBtn_EditBill(int tabCount, int row) {
        btn_EditBill = driver.findElement(By.xpath("//table[@id='mainTable_tabCon_" + tabCount + "']//tr[" + row + "]//button[@title='Edit']"));
        return btn_EditBill;
    }

    public int getHeaderColumnCount(int tabCount, String header, boolean isHeader) {
        int headercount = 0;
        String _temp;
        do {
            headercount++;
            _temp = getTxtbx_HeaderDetails(tabCount, headercount).getAttribute("placeholder");
            if (header.equalsIgnoreCase(_temp)) {
                break;
            }
        } while (headercount < 10);
        if (!isHeader) {
            if (header.equalsIgnoreCase(HEADER_PAYMENT) || header.equalsIgnoreCase(HEADER_ORDER_TYPE)) {
                headercount++;
            } else if (header.equalsIgnoreCase(HEADER_STATUS)) {
            } else {
                headercount--;
            }
        } else {
            if (header.equalsIgnoreCase(HEADER_INVOICE) || header.equalsIgnoreCase(HEADER_IDENTIFIER)) {
                headercount++;
            }
        }
        return headercount;
    }

    public void getSearchSalesInvoice(int tabCount, String invoice) {
        typeSlow(driver, getTxtbx_SearchSalesInvoice(tabCount), invoice);
    }

    public void getFilterByDate(int tabCount, String date) {
        clickOn(driver, getBtn_Filter(tabCount));
        type(getTxtbx_StartDate(tabCount), date.replaceAll("-", "/"));
        clickOn(driver, getBtn_ApplyFilter(tabCount));
//        clickOn(driver, getBtn_FilterClose(tabCount));
    }

    public void getDeleteSalesBill(int tabCount) {
        clickOn(driver, getBtn_DeleteBill(tabCount, 1));
    }

    public void getEditSalesBill(int tabCount) {
        clickOn(driver, getBtn_EditBill(tabCount, 1));
    }

    public void setSearchInvoice(int tabCount, String patient, String doctor, String payment, String totalAmount, String billStatus) {
        type(getTxtbx_PatientName(tabCount), patient);
        type(getTxtbx_DoctorName(tabCount), doctor);
        type(getTxtbx_HeaderDetails(tabCount, getHeaderColumnCount(tabCount, HEADER_PAYMENT, true)), payment);
        type(getTxtbx_HeaderDetails(tabCount, getHeaderColumnCount(tabCount, HEADER_TOTAL_AMOUNT, true)), totalAmount);
        type(getTxtbx_HeaderDetails(tabCount, getHeaderColumnCount(tabCount, HEADER_STATUS, true)), billStatus);
    }

    public void getDeleteSalesInvoice(SideMenuController sideMenuController, String patient, String doctor, String payment, String date, String totalAmount, String billStatus) {
        int count = 0;
        boolean check;
        tabCount = getSearchInvoice(sideMenuController, patient, doctor, payment, totalAmount, billStatus, date);
        do {
            check = deleteSalesInvoice(sideMenuController, patient, doctor, payment, totalAmount, billStatus, date);
            count++;
        } while (!check && count < 10);
        sideMenuController.closeCurrentTab(tabCount);
    }

    public int getEditSalesInvoice(SideMenuController sideMenuController, String patient, String doctor, String payment, String date, String totalAmount, String billStatus) {
        int count = 0;
        boolean check;
        tabCount = getSearchInvoice(sideMenuController, patient, doctor, payment, totalAmount, billStatus, date);
        do {
            check = editSalesInvoice(sideMenuController, patient, doctor, payment, totalAmount, billStatus, date);
            count++;
        } while (!check && count < 10);
        return tabCount;
    }

    public boolean editSalesInvoice(SideMenuController sideMenuController, String patient, String doctor, String payment, String totalAmount, String billStatus, String startDate) {
        boolean flag = false;
        if (new SalesOrderVerification(driver).isInvoicePresent(tabCount, patient, payment)) {
            try {
                getEditSalesBill(tabCount);
                sideMenuController.setPasswordToEditInvoice(INVOICE_PASSWORD);
                testStepsLog(_logStep++, patient + " - Sales Invoice with Patient Name is Opened");
                sideMenuController.closeCurrentTab(tabCount);
                tabCount = sideMenuController.getCurrentTabCount(EDIT_SALES);
                new SalesBillController(driver).getUnlockSalesInvoice(tabCount, SUPER_ADMIN_USERNAME, SUPER_ADMIN_PASSWORD);
                flag = true;
            } catch (Exception e) {
                getBrowserRefresh(driver);
                tabCount = getSearchInvoice(sideMenuController, patient, doctor, payment, totalAmount, billStatus, startDate);
                return flag;
            }
        } else {
            flag = true;
        }
        return flag;
    }

    public int getSearchInvoice(SideMenuController sideMenuController, String patient, String doctor, String payment, String totalAmount, String billStatus, String startDate) {
        tabCount = sideMenuController.openSalesOrder();
        getFilterByDate(tabCount, startDate);
        setSearchInvoice(tabCount, patient, doctor, payment, totalAmount, billStatus);
        return tabCount;
    }

    public boolean deleteSalesInvoice(SideMenuController sideMenuController, String patient, String doctor, String payment, String totalAmount, String billStatus, String startDate) {
        boolean flag = false;
        if (new SalesOrderVerification(driver).isInvoicePresent(tabCount, patient, payment)) {
            try {
                getDeleteSalesBill(tabCount);
                sideMenuController.setPasswordToDeleteInvoice(INVOICE_PASSWORD);
                if (sideMenuController.checkAlertMessage(ALERT_DELETE_SUCCESS)) {
                    testStepsLog(_logStep++, patient + " - Sales Invoice with Patient Name is deleted");
                }
            } catch (Exception e) {
                getBrowserRefresh(driver);
                tabCount = getSearchInvoice(sideMenuController, patient, doctor, payment, totalAmount, billStatus, startDate);
                return flag;
            }
        } else {
            flag = true;
        }
        return flag;
    }
}

