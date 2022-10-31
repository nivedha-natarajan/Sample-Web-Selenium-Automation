package com.projectName.pageObjects.purchaseBill.Verification;

import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.projectName.pageObjects.purchaseBill.Controller.PurchaseOrdersTabController;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchaseOrdersTabVerification extends AbstractPage {

    PurchaseOrdersTabController purchaseOrdersTabController = new PurchaseOrdersTabController(driver);

    int tabCount;
    private WebElement txt_Invoice;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public PurchaseOrdersTabVerification(WebDriver driver) {
        super(driver);
    }

    private WebElement getTxt_Invoice(int tabCount, String invoice) {
        txt_Invoice = driver.findElement(By.xpath("//div[contains(@id,'tabCon_" + tabCount + "')]//div[text()='" + invoice + "']"));
        return txt_Invoice;
    }

    public boolean isInvoicePresent(int tabCount, String invoice) {
        pause(1);
        try {
            getTxt_Invoice(tabCount, invoice).isDisplayed();
            testVerifyLog(invoice + " - Invoice is present in Purchases");
            return true;
        } catch (NoSuchElementException e) {
            testVerifyLog(invoice + " - Invoice is not present in Purchases");
            return false;
        }
    }

    public boolean getVerifyPurchaseInvoice(SideMenuController sideMenuController, String invoice, String filterDate, String payStatus) {
        int count = 0;
        boolean check;
        tabCount = purchaseOrdersTabController.getSearchInvoiceBill(sideMenuController, filterDate, invoice, payStatus);
        do {
            check = verifyPurchaseInvoice(sideMenuController, invoice, filterDate, payStatus);
            count++;
        } while (!check && count < 10);
        sideMenuController.closeCurrentTab(tabCount);
        return check;
    }

    public boolean verifyPurchaseInvoice(SideMenuController sideMenuController, String invoice, String filterDate, String payStatus) {
        try {
            isInvoicePresent(tabCount, invoice);
            return true;
        } catch (Exception e) {
            getBrowserRefresh(driver);
            tabCount = purchaseOrdersTabController.getSearchInvoiceBill(sideMenuController, filterDate, invoice, payStatus);
            return false;
        }
    }
}

