package com.projectName.pageObjects.purchaseBill.Controller;

import com.projectName.constants.DataTabs;
import com.projectName.constants.Validations;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.projectName.pageObjects.purchaseBill.Verification.PurchaseOrdersTabVerification;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchaseOrdersTabController extends AbstractPage implements Validations, DataTabs {

    int tabCount;
    private WebElement txtbx_SearchId;
    private WebElement txtbx_SearchInvoice;
    private WebElement txt_Invoice;
    private WebElement clk_EditInvoice;
    private WebElement clk_DeleteInvoice;
    private WebElement clk_PublishInvoice;
    private WebElement clk_PrintInvoice;
    private WebElement clk_Return;
    private WebElement txt_NoInvoice;
    private WebElement txt_EmptyTableMessage;
    private WebElement txtbx_Pay;

    //Filter
    private WebElement btn_Filter;
    private WebElement txtbx_StartDate;
    private WebElement txtbx_EndDate;
    private WebElement btn_ApplyFilter;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public PurchaseOrdersTabController(WebDriver driver) {
        super(driver);
    }

    private WebElement getTxtbx_SearchId(int tabCount) {
        txtbx_SearchId = driver.findElement(By.xpath("//div[contains(@id,'tabCon_" + tabCount + "')]//th/input[@placeholder='Id']"));
        return txtbx_SearchId;
    }

    private WebElement getTxtbx_SearchInvoice(int tabCount) {
        txtbx_SearchInvoice = driver.findElement(By.xpath("//div[contains(@id,'tabCon_" + tabCount + "')]//th/input[@placeholder='Invoice']"));
        return txtbx_SearchInvoice;
    }

    private WebElement getTxt_Invoice(int tabCount, String invoice) {
        txt_Invoice = driver.findElement(By.xpath("//div[contains(@id,'tabCon_" + tabCount + "')]//div[text()='" + invoice + "']"));
        return txt_Invoice;
    }

    private WebElement getClk_EditInvoice(int tabCount) {
        clk_EditInvoice = driver.findElement(By.xpath("(//table[contains(@id,'tabCon_" + tabCount + "')]//div/button[contains(@onclick,'EDIT')]/span)[1]"));
        return clk_EditInvoice;
    }

    private WebElement getClk_DeleteInvoice(int tabCount) {
        clk_DeleteInvoice = driver.findElement(By.xpath("(//table[contains(@id,'tabCon_" + tabCount + "')]//div/button[contains(@onclick,'DELETE')]/span)[1]"));
        return clk_DeleteInvoice;
    }

    private WebElement getClk_PublishInvoice(int tabCount) {
        clk_PublishInvoice = driver.findElement(By.xpath("(//table[contains(@id,'tabCon_" + tabCount + "')]//div/button[contains(@onclick,'showViewModal')]/span)[1]"));
        return clk_PublishInvoice;
    }

    private WebElement getClk_Return(int tabCount) {
        clk_Return = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']//div/button[contains(@onclick,'genPurReturn')])[1]"));
        return clk_Return;
    }

    private WebElement getClk_PrintInvoice(int tabCount) {
        clk_PrintInvoice = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']//div/button[contains(@onclick,'globalPrintPurchase')])[1]"));
        return clk_PrintInvoice;
    }

    private WebElement getTxt_NoInvoice(int tabCount) {
        txt_NoInvoice = driver.findElement(By.xpath("//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[@class='dataTables_empty']"));
        return txt_NoInvoice;
    }

    private WebElement getTxtbx_Pay(int tabCount) {
        txtbx_Pay = driver.findElement(By.xpath("//div[@id='mainTable_tabCon_" + tabCount + "_wrapper']//input[@placeholder='Pay']"));
        return txtbx_Pay;
    }

    private WebElement getTxt_EmptyTableMessage(int tabCount) {
        txt_EmptyTableMessage = driver.findElement(By.xpath("//table[@id='mainTable_tabCon_" + tabCount + "']//div/p[@class='emptyTableMessage']"));
        return txt_EmptyTableMessage;
    }

    private WebElement getBtn_Filter(int tabCount) {
        btn_Filter = driver.findElement(By.xpath("//div[@id='tab_" + tabCount + "']//button[@id='filter']"));
        return btn_Filter;
    }

    private WebElement getTxtbx_StartDate() {
        txtbx_StartDate = driver.findElement(By.id("lookbackStart"));
        return txtbx_StartDate;
    }

    private WebElement getTxtbx_EndDate() {
        txtbx_EndDate = driver.findElement(By.id("lookbackEnd"));
        return txtbx_EndDate;
    }

    private WebElement getBtn_ApplyFilter() {
        btn_ApplyFilter = driver.findElement(By.id("applyFilter"));
        return btn_ApplyFilter;
    }

    public void getSearchPurchaseInvoice(int tabCount, String invoice) {
        pause(1);
        getExplicitWait(driver, getTxtbx_SearchInvoice(tabCount), EXPLICIT_WAIT);
        type(getTxtbx_SearchInvoice(tabCount), invoice);
    }

    public void getClickEditInvoice(int tabCount, String invoice, String pay) {
        getSearchPurchaseInvoice(tabCount, invoice);
        getSearchInvoicePaid(tabCount, pay);
        pause(1);
        clickOn(driver, getClk_EditInvoice(tabCount));
    }

    public void getClickDeleteInvoice(int tabCount) {
        pause(1);
        clickOn(driver, getClk_DeleteInvoice(tabCount));
    }

    public WebElement getSearchInvoice(int tabCount) {
        return getTxtbx_SearchInvoice(tabCount);
    }

    public void getDateFilter(String date, int tabCount) {
        date = date.replace("-", "/");
        clickOn(driver, getBtn_Filter(tabCount));
        type(getTxtbx_StartDate(), date);
        clickOn(driver, getTxtbx_EndDate());
        clickOn(driver, getBtn_ApplyFilter());
    }

    public void getSearchInvoicePaid(int tabCount, String pay) {
        type(getTxtbx_Pay(tabCount), pay);
    }

    public void getDeletePurchaseInvoice(SideMenuController sideMenuController, String invoice, String filterDate, String payStatus) {
        int count = 0;
        boolean check;
        tabCount = getSearchInvoiceBill(sideMenuController, filterDate, invoice, payStatus);
        do {
            check = deletePurchaseInvoice(sideMenuController, invoice, filterDate, payStatus);
            count++;
        } while (!check && count < 10);
        sideMenuController.closeCurrentTab(tabCount);
    }

    public int getSearchInvoiceBill(SideMenuController sideMenuController, String filterDate, String invoice, String payStatus) {
        tabCount = sideMenuController.openPurchasesOrderTab();
        getDateFilter(filterDate, tabCount);
        getSearchPurchaseInvoice(tabCount, invoice);
        getSearchInvoicePaid(tabCount, payStatus);
        return tabCount;
    }

    public boolean deletePurchaseInvoice(SideMenuController sideMenuController, String invoice, String filterDate, String payStatus) {
        boolean flag = false;
        try {
            if (new PurchaseOrdersTabVerification(driver).isInvoicePresent(tabCount, invoice)) {
                getClickDeleteInvoice(tabCount);
                sideMenuController.setPasswordToDeleteInvoice(INVOICE_PASSWORD);
                if (sideMenuController.checkAlertMessage(ALERT_DELETE_SUCCESS)) {
                    testStepsLog(_logStep++, invoice + " - Invoice is deleted");
                }
            } else {
                flag = true;
            }
            return flag;
        } catch (Exception e) {
            getBrowserRefresh(driver);
            tabCount = getSearchInvoiceBill(sideMenuController, filterDate, invoice, payStatus);
            return false;
        }
    }

    public int getEditInvoice(SideMenuController sideMenuController, String invoice, String payStatus) {
        int count = 0;
        boolean check;
        do {
            check = editInvoice(sideMenuController, invoice, payStatus);
            count++;
        } while (!check && count < 10);
        testStepsLog(_logStep++, "Invoice is opened");
        try {
            return sideMenuController.getCurrentTabCount(TAB_EDIT_PURCHASE);
        } catch (Exception e) {
            return sideMenuController.getCurrentTabCount(TAB_PURCHASEBILL);
        }
    }

    public boolean editInvoice(SideMenuController sideMenuController, String invoice, String payStatus) {
        int tabCount = sideMenuController.openPurchasesOrderTab();
        getClickEditInvoice(tabCount, invoice, payStatus);
        return sideMenuController.getEnterPasswordOk(INVOICE_PASSWORD);
    }
}
