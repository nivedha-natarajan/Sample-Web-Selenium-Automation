package com.projectName.pageObjects.purchaseBill.Controller;

import com.projectName.constants.DataColumnsPurchaseBill;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreditAmountTabController extends AbstractPage implements DataColumnsPurchaseBill {

    private WebElement txtbx_Distributor;
    private WebElement txtbx_PurchaseInvoice;
    private WebElement txtbx_Amount;
    private WebElement txt_Distributor;
    private WebElement txt_PurchaseInvoice;
    private WebElement txt_Amount;
    private WebElement txt_CreditAmount;
    private WebElement txt_Status;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public CreditAmountTabController(WebDriver driver) {
        super(driver);
    }

    private WebElement getTxtbx_Distributor(int tabCount) {
        txtbx_Distributor = driver.findElement(By.xpath("//div[@id='mainTable_tabCon_" + tabCount + "_wrapper']//div[@class='dataTables_scrollHead']//input[@placeholder='Distributor']"));
        return txtbx_Distributor;
    }

    private WebElement getTxtbx_PurchaseInvoice(int tabCount) {
        txtbx_PurchaseInvoice = driver.findElement(By.xpath("//div[@id='mainTable_tabCon_" + tabCount + "_wrapper']//div[@class='dataTables_scrollHead']//input[@placeholder='Purchase Invoice']"));
        return txtbx_PurchaseInvoice;
    }

    private WebElement getTxtbx_Amount(int tabCount) {
        txtbx_Amount = driver.findElement(By.xpath("//div[@id='mainTable_tabCon_" + tabCount + "_wrapper']//div[@class='dataTables_scrollHead']//input[@placeholder='Amount']"));
        return txtbx_Amount;
    }

    private WebElement getTxt_Distributor(int tabCount, int row) {
        txt_Distributor = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[2]/div)[" + row + "]"));
        return txt_Distributor;
    }

    private WebElement getTxt_PurchaseInvoice(int tabCount, int row) {
        txt_PurchaseInvoice = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[5]/div)[" + row + "]"));
        return txt_PurchaseInvoice;
    }

    private WebElement getTxt_Amount(int tabCount, int row) {
        txt_Amount = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[6]/div)[" + row + "]"));
        return txt_Amount;
    }

    private WebElement getTxt_CreditAmount(int tabCount, int row) {
        txt_CreditAmount = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[7]/div)[" + row + "]"));
        return txt_CreditAmount;
    }

    private WebElement getTxt_Status(int tabCount, int row) {
        txt_Status = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[9]/div)[" + row + "]"));
        return txt_Status;
    }

    public void getSearchPurchaseInvoice(int tabCount, String distributor, String purchaseInvoice, String amount) {
        getExplicitWait(driver, getTxtbx_Distributor(tabCount), EXPLICIT_WAIT);
        type(getTxtbx_Distributor(tabCount), distributor);
        type(getTxtbx_PurchaseInvoice(tabCount), purchaseInvoice);
        type(getTxtbx_Amount(tabCount), amount);
    }
}
