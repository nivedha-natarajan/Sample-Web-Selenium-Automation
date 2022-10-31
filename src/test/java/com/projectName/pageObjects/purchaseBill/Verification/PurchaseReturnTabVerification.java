package com.projectName.pageObjects.purchaseBill.Verification;

import com.projectName.constants.DataConstantsPurchaseBill;
import com.projectName.constants.Validations;
import com.framework.init.AbstractPage;
import com.framework.utils.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PurchaseReturnTabVerification extends AbstractPage implements Configuration, Validations, DataConstantsPurchaseBill {

    public PurchaseReturnTabVerification(WebDriver driver) {
        super(driver);
    }

    private WebElement txtbx_SearchDistributor;
    private WebElement slt_Distributor;
    private WebElement txtbx_Date;
    private WebElement chkbx_TCS;
    private WebElement txtbx_DeductionPerc;
    private WebElement clk_TypeList;
    private WebElement slt_TypeList;
    private WebElement chkbx_CDandSch;
    private WebElement chkbx_EditCDValue;
    private WebElement chkbx_CDPerc;
    private WebElement chkbx_GST;

    //Medicine Details
    private WebElement txtbx_SearchMedicine;
    private WebElement slt_SearchMedicine;
    private WebElement clk_Batch;
    private WebElement slt_BatchList;
    private WebElement txtbx_Barcode;
    private WebElement slt_Barcode;
    private WebElement clk_Invoice;
    private WebElement slt_Invoice;
    private WebElement txtbx_Quantity;
    private WebElement txtbx_Loose;
    private WebElement txtbx_Free;
    private WebElement txtbx_Rate;
    private WebElement btn_AddDetails;
    private WebElement txtbx_Remarks;
    private WebElement btn_Save;
    private WebElement btn_SaveAndPrint;


    private WebElement getTxtbx_SearchDistributor(int tabCount) {
        txtbx_SearchDistributor = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//input[@id='searchDistributorPurchaseReturn']"));
        return txtbx_SearchDistributor;
    }

    private WebElement getSlt_Distributor(String distributor) {
        slt_Distributor = driver.findElement(By.xpath("//li[contains(@id,'ui-id')]/a/strong[text()='" + distributor + "']"));
        return slt_Distributor;
    }

    private WebElement getTxtbx_Date(int tabCount) {
        txtbx_Date = driver.findElement(By.xpath("//input[@id='backDatedPurchaseReturn' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Date;
    }

    private WebElement getChkbx_TCS(int tabCount) {
        chkbx_TCS = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div/span/div/input"));
        return chkbx_TCS;
    }

    private WebElement getTxtbx_DeductionPerc(int tabCount) {
        txtbx_DeductionPerc = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div/input[@id='dedPercentGlobal']"));
        return txtbx_DeductionPerc;
    }

    private WebElement getClk_TypeList(int tabCount, String returnType) {
        clk_TypeList = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div//button[@title='" + returnType + "']"));
        return clk_TypeList;
    }

    private WebElement getSlt_TypeList(int tabCount, String returnType) {
        slt_TypeList = driver.findElement(By.xpath("//select[@tab='tabCon_" + tabCount + "']/option[@value='" + returnType + "']"));
        return slt_TypeList;
    }

    private WebElement getChkbx_CDandSch(int tabCount) {
        chkbx_CDandSch = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div//label/span[contains(text(),'CD & Sch')]"));
        return chkbx_CDandSch;
    }

    private WebElement getChkbx_EditCDValue(int tabCount) {
        chkbx_EditCDValue = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div//label/span[contains(text(),'Edit CD Value')]"));
        return chkbx_EditCDValue;
    }

    private WebElement getChkbx_CDPerc(int tabCount) {
        chkbx_CDPerc = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div//label/span[contains(text(),'CD in %')]"));
        return chkbx_CDPerc;
    }

    private WebElement getChkbx_GST(int tabCount) {
        chkbx_GST = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div//label/span[contains(text(),'GST')]"));
        return chkbx_GST;
    }

    private WebElement getTxtbx_SearchMedicine(int tabCount, int rowCount) {
        txtbx_SearchMedicine = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_search_medicine')])[" + rowCount + "]"));
        return txtbx_SearchMedicine;
    }

    private WebElement getSlt_SearchMedicine(String medicine, int rowCount) {
        slt_SearchMedicine = driver.findElement(By.xpath("(//li[contains(@id,'ui-id')]/a/strong[starts-with(text(),'" + medicine + "')])[" + rowCount + "]"));
        return slt_SearchMedicine;
    }

    private WebElement getClk_Batch(int tabCount, String batch) {
        clk_Batch = driver.findElement(By.xpath("//tbody[@id='returntableBody']/tr/td[input[@tab='tabCon_" + tabCount + "']]/div/button[contains(@title,'" + batch + "')]"));
        return clk_Batch;
    }

    private WebElement getSlt_BatchList(String batch, int tabCount) {
        slt_BatchList = driver.findElement(By.xpath("//tbody[@id='returntableBody']/tr/td[input[@tab='tabCon_" + tabCount + "']]/div/div/ul/li/a/span[contains(text(),'" + batch + "')]"));
        return slt_BatchList;
    }

    private WebElement getTxtbx_Barcode(int tabCount, int rowCount) {
        txtbx_Barcode = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_barcodeReturn')])[" + rowCount + "]"));
        return txtbx_Barcode;
    }

    private WebElement getSlt_Barcode(String barcode) {
        slt_Barcode = driver.findElement(By.xpath("//li[contains(@id,'ui-id')]/a/strong[text()='" + barcode + "']"));
        return slt_Barcode;
    }

    private WebElement getClk_Invoice(int tabCount, int rowCount) {
        clk_Invoice = driver.findElement(By.xpath("(//tbody[@id='returntableBody']/tr/td/div/div/button[contains(@data-id,'tabCon_" + tabCount + "_invoice')])[" + rowCount + "]"));
        return clk_Invoice;
    }

    private WebElement getSlt_Invoice(int tabCount, String invoice, int rowCount) {
        slt_Invoice = driver.findElement(By.xpath("(//select[contains(@id,'tabCon_" + tabCount + "_invoice')]/option[contains(text(),'" + invoice + "')])[" + rowCount + "][1]"));
        return slt_Invoice;
    }

    private WebElement getTxtbx_Quantity(int tabCount, int rowCount) {
        txtbx_Quantity = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_qty')])[" + rowCount + "]"));
        return txtbx_Quantity;
    }

    private WebElement getTxtbx_Loose(int tabCount, int rowCount) {
        txtbx_Loose = driver.findElement(By.xpath("(//tbody[@id='returntableBody']/tr/td/div/input[@tab='tabCon_" + tabCount + "' and @placeholder='Loose'])[" + rowCount + "]"));
        return txtbx_Loose;
    }

    private WebElement getTxtbx_Free(int tabCount, int rowCount) {
        txtbx_Free = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_Free')])[" + rowCount + "]"));
        return txtbx_Free;
    }

    private WebElement getTxtbx_Rate(int tabCount, int rowCount) {
        txtbx_Rate = driver.findElement(By.xpath("(//tbody[@id='returntableBody']/tr/td/input[@tab='tabCon_" + tabCount + "' and contains(@data-bind,'value:returnBasePrice')])[" + rowCount + "]"));
        return txtbx_Rate;
    }

    private WebElement getBtn_AddDetails(int tabCount) {
        btn_AddDetails = driver.findElement(By.xpath("//div[contains(@id,'tabCon_" + tabCount + "')]//div[@data-bind='click: function(){addDetail(true)}']/span"));
        return btn_AddDetails;
    }

    private WebElement getTxtbx_Remarks(int tabCount) {
        txtbx_Remarks = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div/input[contains(@data-bind,'value: remarks')]"));
        return txtbx_Remarks;
    }

    private WebElement getTxt_FooterGST(int tabCount) {
        txtbx_Remarks = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//label[@class='footerPurchaseLabel' and contains(@data-bind,'totalTax')]"));
        return txtbx_Remarks;
    }

    private WebElement getTxt_FooterMRP(int tabCount) {
        txtbx_Remarks = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//label[@class='footerPurchaseLabel' and contains(@data-bind,'mrpTotal')]"));
        return txtbx_Remarks;
    }

    private WebElement getTxt_FooterCostValue(int tabCount) {
        txtbx_Remarks = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//label[@class='footerPurchaseLabel' and contains(@data-bind,'effectiveCPTotal')]"));
        return txtbx_Remarks;
    }

    private WebElement getTxt_FooterItemsQuantity(int tabCount) {
        txtbx_Remarks = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//label[@class='footerPurchaseLabel' and contains(@data-bind,'totalQty')]"));
        return txtbx_Remarks;
    }

    private WebElement getTxt_FooterTotalAmount(int tabCount) {
        txtbx_Remarks = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//label[@class='amountValue']"));
        return txtbx_Remarks;
    }

    private WebElement getTxt_CashDiscount(int tabCount, int rowCount) {
        txtbx_Remarks = driver.findElement(By.xpath("(//input[@tab='tabCon_" + tabCount + "' and contains(@data-bind,'cdValueInput')])[" + rowCount + "]"));
        return txtbx_Remarks;
    }

    private WebElement getTxt_Scheme(int tabCount, int rowCount) {
        txtbx_Remarks = driver.findElement(By.xpath("(//input[@tab='tabCon_" + tabCount + "' and contains(@data-bind,'schemeInput')])[" + rowCount + "]"));
        return txtbx_Remarks;
    }

    private WebElement getTxt_NetGST(int tabCount, int rowCount) {
        txtbx_Remarks = driver.findElement(By.xpath("(//input[@tab='tabCon_" + tabCount + "' and contains(@data-bind,'netGstValue')])[" + rowCount + "]"));
        return txtbx_Remarks;
    }

    private WebElement getTxt_MedicineTotal(int tabCount, int rowCount) {
        txtbx_Remarks = driver.findElement(By.xpath("(//input[@tab='tabCon_" + tabCount + "' and contains(@data-bind,'totalPrice')])[" + rowCount + "]"));
        return txtbx_Remarks;
    }

    private WebElement getBtn_Save(int tabCount) {
        btn_Save = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//button[text()='Save [F10]']"));
        return btn_Save;
    }

    private WebElement getBtn_SaveAndPrint(int tabCount) {
        btn_SaveAndPrint = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//button[text()='Save & Print [F11]']"));
        return btn_SaveAndPrint;
    }

    public void verifyPurchaseReturnHeader(int tabCount, String distributorName, String returnType) {
        Assert.assertEquals(getValue(getTxtbx_SearchDistributor(tabCount)), distributorName);
        Assert.assertTrue(isElementPresent(getClk_TypeList(tabCount, returnType.toLowerCase())), "Return type is not Matching");
        testVerifyLog("Purchase Return header details are Verified");
    }

    public void verifyMedicineDetails(int tabCount, int row, String medicine, String batch, String barcode, String quantity,
                                      String loose, String free, String rate, String cd, String scheme, String netGst, String medicineTotal) {
        Assert.assertTrue(getValue(getTxtbx_SearchMedicine(tabCount, row)).contains(medicine), "Medicine name is not Matching");
        Assert.assertTrue(isElementPresent(getClk_Batch(tabCount, batch)), "Batch is not Matching");
        Assert.assertTrue(getValue(getTxtbx_Barcode(tabCount, row)).contains(barcode), "Barcode is not Matching");
        Assert.assertEquals(getValue(getTxtbx_Quantity(tabCount, row)), quantity, "Quantity is not Matching");
        try {
            Assert.assertEquals(getValue(getTxtbx_Loose(tabCount, row)), loose, "Loose is not Matching");
        } catch (Exception ignored) {
        }
        try {
            Assert.assertEquals(getValue(getTxtbx_Free(tabCount, row)), free, "Free is not Matching");
        } catch (Exception ignored) {
        }
        Assert.assertEquals(getValue(getTxtbx_Rate(tabCount, row)), rate, "Rate is not Matching");
        Assert.assertEquals(getValue(getTxt_CashDiscount(tabCount, row)), cd, "Cash Discount is not Matching");
        Assert.assertEquals(getValue(getTxt_Scheme(tabCount, row)), scheme, "Scheme is not Matching");
        Assert.assertEquals(getValue(getTxt_NetGST(tabCount, row)), netGst, "Net GST Discount is not Matching");
        Assert.assertEquals(getValue(getTxt_MedicineTotal(tabCount, row)), medicineTotal, "Total is not Matching");
    }

    public void verifyFooterDetails(int tabCount, String remarks, String gst, String mrp, String costValue, String items, String quantity,
                                    String totalAmount) {
        Assert.assertEquals(getValue(getTxtbx_Remarks(tabCount)), remarks, "Remarks is not Matching");
        Assert.assertEquals(getText(getTxt_FooterGST(tabCount)), gst, "GST is not Matching");
        Assert.assertEquals(getText(getTxt_FooterMRP(tabCount)), mrp, "MRP is not Matching");
        Assert.assertEquals(getText(getTxt_FooterCostValue(tabCount)), costValue, "Cost Value is not Matching");
        Assert.assertEquals(getText(getTxt_FooterItemsQuantity(tabCount)), items + "/" + quantity, "Items and Quantity are not Matching");
        Assert.assertEquals(getText(getTxt_FooterTotalAmount(tabCount)), totalAmount, "Total Amount is not Matching");
        testVerifyLog("Purchase Return Footer details are Verified");
    }
}
