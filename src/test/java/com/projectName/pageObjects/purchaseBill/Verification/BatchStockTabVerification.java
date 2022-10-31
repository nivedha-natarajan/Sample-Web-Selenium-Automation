package com.projectName.pageObjects.purchaseBill.Verification;

import com.projectName.pageObjects.purchaseBill.Controller.BatchStockTabController;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BatchStockTabVerification extends AbstractPage {

    BatchStockTabController batchStockTabController = new BatchStockTabController(driver);

    //StockBatch
    private WebElement txt_Medicine;
    private WebElement txt_Batch;
    private WebElement txt_Barcode;
    private WebElement txt_Stock;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public BatchStockTabVerification(WebDriver driver) {
        super(driver);
    }

    private WebElement getTxt_Medicine(int tabCount) {
        txt_Medicine = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td/div)[1]"));
        return txt_Medicine;
    }

    private WebElement getTxt_Batch(int tabCount) {
        txt_Batch = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[5]/div)[1]"));
        return txt_Batch;
    }

    private WebElement getTxt_Barcode(int tabCount) {
        txt_Barcode = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[6]/div)[1]"));
        return txt_Barcode;
    }

    private WebElement getTxt_Stock(int tabCount, int col) {
        txt_Stock = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[" + col + "]/div)[1]"));
        return txt_Stock;
    }

    public String getVerifyStock(int tabCount, String medicine, String batch, String barcode, String stock, int stockColNo) {
        try {
            Assert.assertTrue(getTxt_Medicine(tabCount).getText().startsWith(medicine), "Medicine name is not Matching");
            Assert.assertEquals(getTxt_Batch(tabCount).getText(), batch, "Batch is not Matching");
            Assert.assertEquals(getTxt_Barcode(tabCount).getText(), barcode, "barcode is not Matching");
            Assert.assertEquals(getTxt_Stock(tabCount, stockColNo).getText(), stock, "stock is not Matching");
            return getTxt_Stock(tabCount, stockColNo).getText();
        } catch (NoSuchElementException e) {
            return "0";
        }
    }

    public String getVerifyMedicineStock(int tabCount, String medicine, String batch, String barcode, String stock, int stockColNo) {
        batchStockTabController.getSearchMedicineStock(tabCount, medicine, batch, barcode);
        return getVerifyStock(tabCount, medicine, batch, barcode, stock, stockColNo);
    }
}
