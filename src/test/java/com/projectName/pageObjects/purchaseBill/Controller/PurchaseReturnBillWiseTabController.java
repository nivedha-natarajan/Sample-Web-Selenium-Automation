package com.projectName.pageObjects.purchaseBill.Controller;

import com.projectName.constants.Validations;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.projectName.pageObjects.purchaseBill.Verification.PurchaseReturnBillWiseTabVerification;
import com.framework.init.AbstractPage;
import com.framework.utils.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchaseReturnBillWiseTabController extends AbstractPage implements Configuration, Validations {

    public PurchaseReturnBillWiseTabController(WebDriver driver) {
        super(driver);
    }

    private WebElement txtbx_SearchDistributor;
    private WebElement txtbx_SearchReturnType;
    private WebElement btn_DeleteBill;
    private WebElement btn_EditBill;

    private WebElement btn_Filter;
    private WebElement btn_ApplyFilter;
    private WebElement txtbx_StartDate;
    private WebElement txt_ApplyFiler;


    private WebElement getTxtbx_SearchDistributor(int tabCount) {
        txtbx_SearchDistributor = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//tr[@role='row']/th/input[@placeholder='Distributor']"));
        return txtbx_SearchDistributor;
    }

    private WebElement getTxtbx_SearchReturnType(int tabCount) {
        txtbx_SearchReturnType = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//tr[@role='row']/th/input[@placeholder='Return Type']"));
        return txtbx_SearchReturnType;
    }

    private WebElement getBtn_DeleteBill(int tabCount) {
        btn_DeleteBill = driver.findElement(By.xpath("//table[contains(@id,'tabCon_" + tabCount + "')]/tbody/tr[1]//span[contains(@class,'deleteReportButton')]"));
        return btn_DeleteBill;
    }

    private WebElement getBtn_EditBill(int tabCount) {
        btn_EditBill = driver.findElement(By.xpath("//table[contains(@id,'tabCon_" + tabCount + "')]/tbody/tr[1]//span[contains(@class,'pencil editReportButton')]"));
        return btn_EditBill;
    }

    private WebElement getBtn_Filter(int tabCount) {
        btn_Filter = driver.findElement(By.xpath("//div[@id='tab_" + tabCount + "']//button[@id='filter']"));
        return btn_Filter;
    }

    private WebElement getBtn_ApplyFilter(int tabCount) {
        btn_ApplyFilter = driver.findElement(By.xpath("//div[@id='tab_" + tabCount + "']//button[@id='applyFilter']"));
        return btn_ApplyFilter;
    }

    private WebElement getTxtbx_StartDate(int tabCount) {
        txtbx_StartDate = driver.findElement(By.xpath("//div[@id='tab_" + tabCount + "']//input[@id='lookbackStart']"));
        return txtbx_StartDate;
    }

    private WebElement getTxt_ApplyFiler(int tabCount) {
        txt_ApplyFiler = driver.findElement(By.xpath("//div[@id='tab_" + tabCount + "']//div[@id='reportFilter']/div/h2"));
        return txt_ApplyFiler;
    }

    private WebElement getTxt_CloseApplyFiler(int tabCount) {
        txt_ApplyFiler = driver.findElement(By.xpath("//div[@id='tab_" + tabCount + "']//div[@id='reportFilter']//a[@class='closeSidebar']"));
        return txt_ApplyFiler;
    }

    public void getSearchReturnBill(int tabCount, String distributor, String returnType) {
        type(getTxtbx_SearchDistributor(tabCount), distributor);
        type(getTxtbx_SearchReturnType(tabCount), returnType);
    }

    public void getDeleteReturnBill(int tabCount) {
        if (getBtn_DeleteBill(tabCount).isDisplayed()) {
            clickOn(driver, getBtn_DeleteBill(tabCount));
        }
    }

    public boolean getClickEditReturnBill(int tabCount) {
        if (getBtn_EditBill(tabCount).isDisplayed()) {
            clickOn(driver, getBtn_EditBill(tabCount));
            return true;
        }
        return false;
    }

    public void getDateFilter(int tabCount, String date) {
        clickOn(driver, getBtn_Filter(tabCount));
        isElementPresent(getTxt_ApplyFiler(tabCount));
        type(getTxtbx_StartDate(tabCount), date);
        clickOn(driver, getBtn_ApplyFilter(tabCount));
    }

    public void getDeletePurchaseReturnInvoice(SideMenuController sideMenuController, String distributor, String returnType, String startDate) {
        int count = 0;
        boolean check;
        do {
            check = deletePurchaseReturnInvoice(sideMenuController, distributor, returnType, startDate);
            count++;
        } while (!check && count < 10);
    }

    public boolean deletePurchaseReturnInvoice(SideMenuController sideMenuController, String distributor, String returnType, String startDate) {
        boolean flag = false;
        try {
            int tabCount = sideMenuController.openPurchaseReturnOrders();
            if (new PurchaseReturnBillWiseTabVerification(driver).isPresentReturnBill(tabCount, distributor, returnType, startDate)) {
                getDeleteReturnBill(tabCount);
                sideMenuController.setPasswordToDeleteInvoice(INVOICE_PASSWORD);
                if (sideMenuController.checkAlertMessage(ALERT_DELETE_SUCCESS)) {
                    testStepsLog(_logStep++, distributor + " - Invoice is deleted");
                } else {
                    getAlertCheck(sideMenuController.getAlertMessage());
                    testWarningLog("The selected credit note has been resolved in inventory id. Please edit the purchase bill.");
                    flag = true;
                }
            } else {
                flag = true;
            }
            sideMenuController.closeCurrentTab(tabCount);
        } catch (Exception e) {
            getBrowserRefresh(driver);
            flag = false;
        }
        return flag;
    }
}
