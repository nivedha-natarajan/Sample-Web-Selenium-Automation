package com.projectName.pageObjects.purchaseBill.Verification;

import com.projectName.pageObjects.purchaseBill.Controller.PurchaseReturnBillWiseTabController;
import com.framework.init.AbstractPage;
import com.framework.utils.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchaseReturnBillWiseTabVerification extends AbstractPage implements Configuration {

    PurchaseReturnBillWiseTabController purchaseReturnBillWiseTabController = new PurchaseReturnBillWiseTabController(driver);
    private WebElement btn_DeleteBill;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public PurchaseReturnBillWiseTabVerification(WebDriver driver) {
        super(driver);
    }

    private WebElement getBtn_DeleteBill(int tabCount) {
        btn_DeleteBill = driver.findElement(By.xpath("//table[contains(@id,'tabCon_" + tabCount + "')]/tbody/tr[1]//span[contains(@class,'deleteReportButton')]"));
        return btn_DeleteBill;
    }

    public boolean isPresentReturnBill(int tabCount, String distributor, String returnType, String startDate) {
        purchaseReturnBillWiseTabController.getDateFilter(tabCount, startDate);
        purchaseReturnBillWiseTabController.getSearchReturnBill(tabCount, distributor, returnType);
        try {
            getExplicitWait(driver, getBtn_DeleteBill(tabCount), EXPLICIT_WAIT);
            testVerifyLog(distributor + " - Return Invoice is present");
            return true;
        } catch (NoSuchElementException e) {
            testVerifyLog(distributor + " - Return Invoice is not present");
            return false;
        }
    }
}
