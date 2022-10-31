package com.projectName.pageObjects.purchaseBill.Controller;

import com.projectName.constants.DataConstantsPurchaseBill;
import com.projectName.constants.UploadColumns;
import com.projectName.constants.Validations;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import erp.auto.testing.projectName.constants.*;
import com.projectName.pageObjects.purchaseBill.Verification.CreditNoteVerification;
import com.projectName.pageObjects.purchaseBill.Verification.PurchaseBillTabVerification;
import com.framework.init.AbstractPage;
import com.framework.utils.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PurchaseBillTabController extends AbstractPage implements Configuration, UploadColumns, Validations, DataConstantsPurchaseBill {

    //Header
    private WebElement txtbx_DistriutorName;
    private List<WebElement> list_AddDistributor;
    private WebElement slt_AddDistributor;
    private WebElement clk_AddDistributor;
    private WebElement txtbx_InvoiceNo;
    private WebElement txtbx_InvoiceDate;
    private WebElement txtbx_ExtraDiscount;
    private WebElement txtbx_CreditAmt;
    private WebElement clk_CreditAmt;
    private WebElement txtbx_HeaderCashDiscountPerc;
    private WebElement txtbx_HeaderCashDiscountRupees;
    private WebElement chkbx_Cash;
    private WebElement chkbx_Challan;
    private WebElement chkbx_Barcode;
    private WebElement chkbx_CashDiscount;
    private WebElement chkbx_HSN;
    private WebElement chkbx_TCS;
    private WebElement btn_Upload;

    //Medicine Details
    private WebElement txt_FileSourceMedicine;
    private WebElement txtbx_SearchMedicine;
    private List<WebElement> list_SearchMedicine;
    private WebElement slt_SearchMedicine;
    private WebElement txt_MedicineRow;
    private WebElement txtbx_Barcode;
    private WebElement txtbx_HSN;
    private WebElement txtbx_Batch;
    private List<WebElement> list_BatchList;
    private WebElement slt_BatchList;
    private WebElement txtbx_Expiry;
    private WebElement txtbx_Rate;
    private WebElement txtbx_MRP;
    private WebElement txtbx_Quantity;
    private WebElement txtbx_FreeQuantity;
    private WebElement txtbx_VAT;
    private WebElement txtbx_CGST;
    private WebElement txtbx_SGST;
    private WebElement txtbx_CESS;
    private WebElement txtbx_IGST;
    private WebElement txtbx_CDPercentage;
    private WebElement txtbx_CDCash;
    private WebElement txtbx_TCS;
    private WebElement txtbx_SchemeConfig;
    private WebElement txtbx_SchemeRupees;
    private WebElement txtbx_SchemePercentage;
    private WebElement txt_IndividualNet;
    private WebElement btn_CancelMedicine;
    private WebElement btn_AddDetails;
    private WebElement btn_SelectAllMedicine;
    private WebElement btn_SelectIndividualMedicine;
    private WebElement list_SearchMedicineList;

    //Medicine Footer
    private List<WebElement> txt_MedicineCount;
    private WebElement txt_IndividualMedicineDetails;
    private WebElement txt_Items;
    private WebElement txt_Quantity;
    private WebElement txt_SchemeRupees;
    private WebElement txt_TaxTotal;
    private WebElement txt_CDCash;
    private WebElement txt_AddorLess;
    private WebElement txt_GrossTotal;
    private WebElement txtbx_PlacedOrderId;
    private WebElement txtbx_Remarks;
    private WebElement txt_OrderTotal;
    private WebElement btn_GenerateBarcode;
    private WebElement txt_LastPurchaseId;
    private WebElement txt_Outstanding;
    private WebElement txt_MedicineDetails;

    //Alert
    private WebElement txtbx_ExpireDate;
    private WebElement txt_UpdateExpireDate;
    private WebElement btn_UpdateExpireOk;
    private WebElement btn_UpdateExpireCancel;
    private WebElement txt_UpdateInvoice;
    private WebElement btn_UpdateInvoiceOk;
    private WebElement btn_UpdateInvoiceCancel;

    //Invoice
    private WebElement txt_SelectInvoice;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public PurchaseBillTabController(WebDriver driver) {
        super(driver);
    }

    private WebElement getTxtbx_DistributorName(int tabCount) {
        txtbx_DistriutorName = driver.findElement(By.xpath("//input[@id='distributor' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_DistriutorName;
    }

    private List<WebElement> getList_AddDistributor(String distributorName) {
        list_AddDistributor = driver.findElements(By.xpath("//ul[contains(@id,'ui-id')]/li[text()='" + distributorName + "']"));
        return list_AddDistributor;
    }

    private WebElement getSlt_AddDistributor(String distributorName) {
        slt_AddDistributor = driver.findElement(By.xpath("//ul[contains(@id,'ui-id')]/li[text()='" + distributorName + "']"));
        return slt_AddDistributor;
    }

    private WebElement getClk_AddDistributor(int tabCount) {
        clk_AddDistributor = driver.findElement(By.xpath("//span[contains(@onclick,'tabCon_" + tabCount + "')]/span[@id='selectDistributor']"));
        return clk_AddDistributor;
    }

    private WebElement getTxtbx_InvoiceNo(int tabCount) {
        txtbx_InvoiceNo = driver.findElement(By.xpath("//div/input[@id='invoice' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_InvoiceNo;
    }

    private WebElement getTxtbx_InvoiceDate(int tabCount) {
        txtbx_InvoiceDate = driver.findElement(By.xpath("//input[@tab='tabCon_" + tabCount + "' and @id='invoiceDate']"));
        return txtbx_InvoiceDate;
    }

    private WebElement getTxtbx_ExtraDiscount(int tabCount) {
        txtbx_ExtraDiscount = driver.findElement(By.xpath("//input[@tab='tabCon_" + tabCount + "' and @id='extraDiscount']"));
        return txtbx_ExtraDiscount;
    }

    private WebElement getTxtbx_CreditAmt(int tabCount) {
        txtbx_CreditAmt = driver.findElement(By.xpath("//input[@tab='tabCon_" + tabCount + "' and @id='creditAmt']"));
        return txtbx_CreditAmt;
    }

    private WebElement getClk_CreditAmtAdd(int tabCount) {
        clk_CreditAmt = driver.findElement(By.xpath("//span[contains(@onclick,'tabCon_" + tabCount + "') and @id='addCreditNoteIcon']"));
        return clk_CreditAmt;
    }

    private WebElement getTxtbx_HeaderCashDiscountPerc(int tabCount) {
        txtbx_HeaderCashDiscountPerc = driver.findElement(By.xpath("//input[@tab='tabCon_" + tabCount + "' and @id='cd']"));
        return txtbx_HeaderCashDiscountPerc;
    }

    private WebElement getTxtbx_HeaderCashDiscountRupees(int tabCount) {
        txtbx_HeaderCashDiscountRupees = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//input[@id='cdValueByUser']"));
        return txtbx_HeaderCashDiscountRupees;
    }

    private WebElement getChkbx_Cash(int tabCount) {
        chkbx_Cash = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div/input[@id='challan']"));
        return chkbx_Cash;
    }

    private WebElement getChkbx_Challan(int tabCount) {
        chkbx_Challan = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//span/input[@id='challan']"));
        return chkbx_Challan;
    }

    private WebElement getChkbx_Barcode(int tabCount) {
        chkbx_Barcode = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//input[@data-bind='checked: enableBarcode']"));
        return chkbx_Barcode;
    }

    private WebElement getChkbx_CashDiscount(int tabCount) {
        chkbx_CashDiscount = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//input[@data-bind='checked: enableCDInValue']"));
        return chkbx_CashDiscount;
    }

    private WebElement getChkbx_HSN(int tabCount) {
        chkbx_HSN = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//input[@data-bind='checked: enableHSN']"));
        return chkbx_HSN;
    }

    private WebElement getChkbx_TCS(int tabCount) {
        chkbx_TCS = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//input[@data-bind='checked: applyTCS']"));
        return chkbx_TCS;
    }

    private WebElement getBtn_Upload(int tabCount) {
        btn_Upload = driver.findElement(By.xpath("//div[contains(@id,'tabCon_" + tabCount + "')]//input[@id='purchaseFiles']"));
        return btn_Upload;
    }

    private WebElement getTxt_FileSourceMedicine(int tabCount, int detailsCount) {
        txt_FileSourceMedicine = driver.findElement(By.xpath("(//div[@id='medTuttabCon_" + tabCount + "']//tr/td[5]/label[1])[" + detailsCount + "]"));
        return txt_FileSourceMedicine;
    }

    private WebElement getTxtbx_SearchMedicine(int tabCount, int detailsCount) {
        txtbx_SearchMedicine = driver.findElement(By.xpath("(//span/input[contains(@id,'tabCon_" + tabCount + "_search_medicine')])[" + detailsCount + "]"));
        return txtbx_SearchMedicine;
    }

    private WebElement getTxt_MedicineRow(int tabCount, int detailsCount) {
        txt_MedicineRow = driver.findElement(By.xpath("//span/input[contains(@id,'tabCon_" + tabCount + "_search_medicine') and @highlightindex=" + detailsCount + "]"));
        return txt_MedicineRow;
    }

    private List<WebElement> getList_SearchMedicine(String medicineName) {
        list_SearchMedicine = driver.findElements(By.xpath("//ul[contains(@id,'ui-id')]/li/a/strong[starts-with(text(),'" + medicineName + "')]"));
        return list_SearchMedicine;
    }

    private WebElement getSlt_SearchMedicine(String medicineName, int count) {
        slt_SearchMedicine = driver.findElement(By.xpath("(//ul[contains(@id,'ui-id')]/li/a/strong[contains(text(),'" + medicineName + "')])[" + count + "]"));
        return slt_SearchMedicine;
    }

    private WebElement getTxtbx_Barcode(int tabCount, int detailsCount) {
        txtbx_Barcode = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_barcode')])[" + detailsCount + "]"));
        return txtbx_Barcode;
    }

    private WebElement getTxtbx_HSN(int tabCount, int detailsCount) {
        txtbx_HSN = driver.findElement(By.xpath("(//input[@tab='tabCon_" + tabCount + "' and @placeholder='HSN'])[" + detailsCount + "]"));
        return txtbx_HSN;
    }

    private WebElement getTxtbx_Batch(int tabCount, int detailsCount) {
        txtbx_Batch = driver.findElement(By.xpath("(//span/input[@class='form-control commonInput ui-autocomplete-input' and @tab='tabCon_" + tabCount + "'])[" + detailsCount + "]"));
        return txtbx_Batch;
    }

    private List<WebElement> getList_BatchList(String batch) {
        list_BatchList = driver.findElements(By.xpath("//li[contains(@id,'ui-id')]/a/span[starts-with(text(),'" + batch + "')]"));
        return list_BatchList;
    }

    private WebElement getSlt_BatchList(String batch) {
        slt_BatchList = driver.findElement(By.xpath("//li[contains(@id,'ui-id')]/a/span[starts-with(text(),'" + batch + "')]"));
        return slt_BatchList;
    }

    private WebElement getTxtbx_Expiry(int tabCount, int detailsCount) {
        txtbx_Expiry = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_exp')])[" + detailsCount + "]"));
        return txtbx_Expiry;
    }

    private WebElement getTxtbx_Rate(int tabCount, int detailsCount) {
        txtbx_Rate = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_costprice')])[" + detailsCount + "]"));
        return txtbx_Rate;
    }

    private WebElement getTxtbx_MRP(int tabCount, int detailsCount) {
        txtbx_MRP = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_mrp')])[" + detailsCount + "]"));
        return txtbx_MRP;
    }

    private WebElement getTxtbx_Quantity(int tabCount, int detailsCount) {
        txtbx_Quantity = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_quantity')])[" + detailsCount + "]"));
        return txtbx_Quantity;
    }

    private WebElement getTxtbx_FreeQuantity(int tabCount, int detailsCount) {
        txtbx_FreeQuantity = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_free')])[" + detailsCount + "]"));
        return txtbx_FreeQuantity;
    }

    private WebElement getTxtbx_VAT(int tabCount, int detailsCount) {
        txtbx_VAT = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_vat')])[" + detailsCount + "]"));
        return txtbx_VAT;
    }

    private WebElement getTxtbx_CGST(int tabCount, int detailsCount) {
        txtbx_CGST = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_cgstPer')])[" + detailsCount + "]"));
        return txtbx_CGST;
    }

    private WebElement getTxtbx_SGST(int tabCount, int detailsCount) {
        txtbx_SGST = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_sgstPer')])[" + detailsCount + "]"));
        return txtbx_SGST;
    }

    private WebElement getTxtbx_CESS(int tabCount, int detailsCount) {
        txtbx_CESS = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_gccessPer')])[" + detailsCount + "]"));
        return txtbx_CESS;
    }

    private WebElement getTxtbx_IGST(int tabCount, int detailsCount) {
        txtbx_IGST = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_igstPer')])[" + detailsCount + "]"));
        return txtbx_IGST;
    }

    private WebElement getTxtbx_CDPercentage(int tabCount, int detailsCount) {
        txtbx_CDPercentage = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_cdPercent')])[" + detailsCount + "]"));
        return txtbx_CDPercentage;
    }

    private WebElement getTxtbx_CDCash(int tabCount, int detailsCount) {
        txtbx_CDCash = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_cash_disc_value')])[" + detailsCount + "]"));
        return txtbx_CDCash;
    }

    private WebElement getTxtbx_TCS(int tabCount, int detailsCount) {
        txtbx_TCS = driver.findElement(By.xpath("(//input[@placeholder='TCS' and @tab='tabCon_" + tabCount + "'])[" + detailsCount + "]"));
        return txtbx_TCS;
    }

    private WebElement getTxtbx_SchemeRupees(int tabCount, int detailsCount) {
        txtbx_SchemeRupees = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "') and contains(@data-bind,'schemeValueINR')])[" + detailsCount + "]"));
        return txtbx_SchemeRupees;
    }

    private WebElement getTxtbx_SchemeConfig(int tabCount, int detailsCount) {
        txtbx_SchemeConfig = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "') and contains(@data-bind,'schemeConfig')])[" + detailsCount + "]"));
        return txtbx_SchemeConfig;
    }

    private WebElement getTxtbx_SchemePercentage(int tabCount, int detailsCount) {
        txtbx_SchemePercentage = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_schemePercent')])[" + detailsCount + "]"));
        return txtbx_SchemePercentage;
    }

    private WebElement getTxt_IndividualNet(int tabCount, int detailsCount) {
        txt_IndividualNet = driver.findElement(By.xpath("(//div[@id='tabCon_" + tabCount + "']//input[@placeholder='Gross'])[" + detailsCount + "]"));
        return txt_IndividualNet;
    }

    private WebElement getBtn_CancelMedicine(int tabCount, int detailsCount) {
        btn_CancelMedicine = driver.findElement(By.xpath("(//div[contains(@id,'tabCon_" + tabCount + "')]//tbody/tr/td[@class='quantTab']/div/span)[" + detailsCount + "]"));
        return btn_CancelMedicine;
    }

    private WebElement getBtn_AddDetails(int tabCount) {
        btn_AddDetails = driver.findElement(By.xpath("//div[contains(@id,'tabCon_" + tabCount + "')]//div[@data-bind='click: function(){addDetail(true)}']/span"));
        return btn_AddDetails;
    }

    private WebElement getBtn_SelectAllMedicine(int tabCount) {
        btn_SelectAllMedicine = driver.findElement(By.xpath("//div[contains(@id,'tabCon_" + tabCount + "')]//input[contains(@data-bind,'selectAll')]"));
        return btn_SelectAllMedicine;
    }

    private WebElement getBtn_SelectIndividualMedicine(int tabCount, int detailsCount) {
        btn_SelectIndividualMedicine = driver.findElement(By.xpath("(//div[contains(@id,'tabCon_" + tabCount + "')]//tbody/tr/td/input[@type='checkbox'])[" + detailsCount + "]"));
        return btn_SelectIndividualMedicine;
    }

    private WebElement getList_SearchMedicineList() {
        list_SearchMedicineList = driver.findElement(By.xpath("//ul[@id='ui-id-24']/li/a/strong[1]"));
        return list_SearchMedicineList;
    }

    private List<WebElement> getTxt_MedicineCount(int tabCount) {
        txt_MedicineCount = driver.findElements(By.xpath("//input[contains(@id,'tabCon_" + tabCount + "_search_medicine')]"));
        return txt_MedicineCount;
    }

    private WebElement getTxt_IndividualMedicineDetails(int tabCount) {
        txt_IndividualMedicineDetails = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//span[@data-bind='text :  info']"));
        return txt_IndividualMedicineDetails;
    }

    private WebElement getTxt_Items(int tabCount) {
        txt_Items = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@class='footerBill purchaseFooterMain']//label[@data-bind='text:items']"));
        return txt_Items;
    }

    private WebElement getTxt_Quantity(int tabCount) {
        txt_Quantity = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@class='footerBill purchaseFooterMain']//label[@data-bind='text:totalQty']"));
        return txt_Quantity;
    }

    private WebElement getTxt_SchemeRupees(int tabCount) {
        txt_SchemeRupees = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@class='footerBill purchaseFooterMain']//label[@data-bind='text : schemeTotal']"));
        return txt_SchemeRupees;
    }

    private WebElement getTxt_TaxTotal(int tabCount) {
        txt_TaxTotal = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@class='footerBill purchaseFooterMain']//label[@data-bind='text: vatTotal']"));
        return txt_TaxTotal;
    }

    private WebElement getTxt_CDCash(int tabCount) {
        txt_CDCash = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@class='footerBill purchaseFooterMain']//label[@data-bind='text: cdTotal']"));
        return txt_CDCash;
    }

    private WebElement getTxt_AddorLess(int tabCount) {
        txt_AddorLess = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@class='footerBill purchaseFooterMain']//label[@data-bind='text:roff']"));
        return txt_AddorLess;
    }

    private WebElement getTxt_GrossTotal(int tabCount) {
        txt_GrossTotal = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@class='footerBill purchaseFooterMain']//label[@data-bind='text:grossTotal']"));
        return txt_GrossTotal;
    }

    private WebElement getTxtbx_PlacedOrderId(int tabCount) {
        txtbx_PlacedOrderId = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div/div/span[2]/div/label"));
        return txtbx_PlacedOrderId;
    }

    private WebElement getTxtbx_Remarks(int tabCount) {
        txtbx_Remarks = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div/div/span[4]/div/input"));
        return txtbx_Remarks;
    }

    private WebElement getTxt_OrderTotal(int tabCount) {
        txt_OrderTotal = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//label[@class='amountValue']"));
        return txt_OrderTotal;
    }

    private WebElement getBtn_GenerateBarcode(int tabCount) {
        btn_GenerateBarcode = driver.findElement(By.xpath("//button[@tab='tabCon_" + tabCount + "' and @class='btn btn-primary btnTran']"));
        return btn_GenerateBarcode;
    }

    private WebElement getTxt_LastPurchaseId(int tabCount) {
        txt_LastPurchaseId = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@class='lastPurchaseId']"));
        return txt_LastPurchaseId;
    }

    private WebElement getTxt_Outstanding(int tabCount) {
        txt_Outstanding = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@id='purchaseBillOutstanding']/span[1]"));
        return txt_Outstanding;
    }

    private WebElement getTxt_MedicineDetails(int tabCount) {
        txt_MedicineDetails = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div[5]/span"));
        return txt_MedicineDetails;
    }

    private WebElement getTxtbx_ExpireDate() {
        txtbx_ExpireDate = driver.findElement(By.id("updateExpiryDate"));
        return txtbx_ExpireDate;
    }

    private WebElement getTxt_UpdateExpireDate() {
        txt_UpdateExpireDate = driver.findElement(By.xpath("//div[@class='bootbox modal fade in']//div[@class='modal-header']/h4"));
        return txt_UpdateExpireDate;
    }

    private WebElement getBtn_UpdateExpireOk() {
        btn_UpdateExpireOk = driver.findElement(By.xpath("//div[@class='bootbox modal fade in']//div[@class='modal-footer']/button[text()='OK']"));
        return btn_UpdateExpireOk;
    }

    private WebElement getBtn_UpdateExpireCancel() {
        btn_UpdateExpireCancel = driver.findElement(By.xpath("//div[@class='bootbox modal fade in']//div[@class='modal-footer']/button[text()='Cancel!']"));
        return btn_UpdateExpireCancel;
    }

    private WebElement getTxt_UpdateInvoice() {
        txt_UpdateInvoice = driver.findElement(By.xpath("//div[@class='bootbox modal fade bootbox-confirm in']//div[@class='bootbox-body']"));
        return txt_UpdateInvoice;
    }

    private WebElement getBtn_UpdateInvoiceOk() {
        btn_UpdateInvoiceOk = driver.findElement(By.xpath("//div[@class='bootbox modal fade bootbox-confirm in']//div[@class='modal-footer']/button[text()='OK']"));
        return btn_UpdateInvoiceOk;
    }

    private WebElement getBtn_UpdateInvoiceCancel() {
        btn_UpdateInvoiceCancel = driver.findElement(By.xpath("//div[@class='bootbox modal fade bootbox-confirm in']//div[@class='modal-footer']/button[text()='Cancel']"));
        return btn_UpdateInvoiceCancel;
    }

    private WebElement getTxt_SelectInvoice(int tabCount, String challan) {
        txt_SelectInvoice = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div[@class='challanFooter']/button/span[text()='" + challan + "']"));
        return txt_SelectInvoice;
    }

    public void getEnableBarcode(int tabCount) {
        clickOn(driver, getChkbx_Barcode(tabCount));
        testStepsLog(_logStep++, "Barcode checkbox enabled/disabled");
    }

    public void getEnterPurchaseBillHeaderDetails(int tabCount, String extraDisc) {
        getExplicitWait(driver, getTxtbx_ExtraDiscount(tabCount), EXPLICIT_WAIT);
        setExtraDiscount(tabCount, extraDisc);
        getEnableBarcode(tabCount);
        new PurchaseBillTabVerification(driver).getVerifyExtraDiscount(tabCount, extraDisc);
    }

    public void setExtraDiscount(int tabCount, String extraDisc) {
        typeSlow(driver, getTxtbx_ExtraDiscount(tabCount), extraDisc);
        click(tabCount);
    }

    public void setCDPercHeader(int tabCount, String cdPercHeader) {
        typeSlow(driver, getTxtbx_HeaderCashDiscountPerc(tabCount), cdPercHeader);
        click(tabCount);
    }

    public void getChangeCDRupeesHeaderCheckBox(int tabCount) {
        clickOn(driver, getChkbx_CashDiscount(tabCount));
    }

    public void setCDRupeesHeader(int tabCount, String cdRupeesHeader) {
        Assert.assertTrue(getTxtbx_HeaderCashDiscountRupees(tabCount).isDisplayed());
        typeSlow(driver, getTxtbx_HeaderCashDiscountRupees(tabCount), cdRupeesHeader);
    }

    public boolean setMedicineNameCSV(int tabCount, int row, String tempMedicineName) {
        pause(1);
        typeSlow(driver, getTxtbx_SearchMedicine(tabCount, row), tempMedicineName.toUpperCase().trim());
        pause(2);
        if (getSelectFromList(driver, getList_SearchMedicine(tempMedicineName), getSlt_SearchMedicine(tempMedicineName, 1), getSlt_SearchMedicine("- " + tempMedicineName, 1), tempMedicineName)) {
            AddMedicineTabController addMedicineTabController = new AddMedicineTabController(driver);
            HashMap<String, ArrayList<Object>> temp = new HashMap<>(getTestDataWorkbook(DATA_CSV_UPLOAD));
            row = row - 1;
            addMedicineTabController.getAddMedicine(getData(temp, CSV_ITEM_DESCRIPTION, row), getData(temp, CSV_ITEM_DESCRIPTION, row), getData(temp, CSV_CATEGORY, row), getData(temp, CSV_PACKING, row),
                    getData(temp, CSV_THERAPEUTIC, row), getData(temp, CSV_SUB_THERAPEUTIC, row), getData(temp, CSV_LOOSE, row), getData(temp, CSV_QUANTITY, row), getData(temp, CSV_BARCODE, row),
                    getData(temp, CSV_SHORT_CODE, row), getData(temp, CSV_MANUFACTURER, row), getData(temp, CSV_CGST, row), getData(temp, CSV_MIN_STOCK, row),
                    getData(temp, CSV_MAX_STOCK, row), getData(temp, CSV_SALT, row), getData(temp, CSV_SCHEDULE_TYPE, row), getData(temp, CSV_HSN_CODE, row), getData(temp, CSV_RACK, row),
                    getData(temp, CSV_SUBSTITUTE, row), getData(temp, CSV_TB, row), getData(temp, CSV_REMARKS, row));
            pause(1);
            return true;
        }
        new PurchaseBillTabVerification(driver).getVerifyMedicineName(tabCount, row, tempMedicineName);
        return false;
    }

    public boolean setMedicineName(int tabCount, int row, String tempMedicineName) {
        pause(1);
        typeSlow(driver, getTxtbx_SearchMedicine(tabCount, row), tempMedicineName);
        pause(2);
        if (getSelectFromList(driver, getList_SearchMedicine(tempMedicineName), getSlt_SearchMedicine(tempMedicineName, 1), getSlt_SearchMedicine("- " + tempMedicineName, 1), tempMedicineName)) {
            AddMedicineTabController addMedicineTabController = new AddMedicineTabController(driver);
            HashMap<String, ArrayList<Object>> temp = new HashMap<>(getTestDataWorkbook(DATA_ADD_MEDICINE));
            addMedicineTabController.getAddMedicine(tempMedicineName, getData(temp, ITEM_TYPE, 0), getData(temp, CATEGORY, 0), getData(temp, PACKAGING, 0), getData(temp, THERAPEUTIC, 0),
                    getData(temp, SUB_THERAPEUTIC, 0), getData(temp, LOOSE, 0), getData(temp, QUANTITY, 0), getData(temp, BARCODE, 0), getData(temp, SHORT_CODE, 0),
                    getData(temp, MANUFACTURER, 0), getData(temp, CGST, 0), getData(temp, MIN_STOCK, 0), getData(temp, MAX_STOCK, 0), getData(temp, SALT, 0),
                    getData(temp, SCHEDULE_TYPE, 0), getData(temp, HSN_CODE, 0), getData(temp, RACK, 0), getData(temp, SUBSTITUTE, 0), getData(temp, TB, 0), getData(temp, REMARKS, 0));
            pause(1);
            return true;
        }
        new PurchaseBillTabVerification(driver).getVerifyMedicineName(tabCount, row, tempMedicineName);
        return false;
    }

    public void setBatch(int tabCount, int tab, String batch) {
        getExplicitWait(driver, getTxtbx_Batch(tabCount, tab), EXPLICIT_WAIT);
        typeSlow(driver, getTxtbx_Batch(tabCount, tab), batch);
        pause(1);
        if (getList_BatchList(batch).size() > 0) {
            clickOn(driver, getSlt_BatchList(batch));
        } else {
            clickOn(driver, getSlt_BatchList("ADD - " + batch));
        }
    }

    public void setExpiry(int tabCount, int tab, String expiry) {
        type(getTxtbx_Expiry(tabCount, tab), expiry);
    }

    public void setRate(int tabCount, int tab, String rate) {
        type(getTxtbx_Rate(tabCount, tab), rate);
    }

    public void setMRP(int tabCount, int tab, String mrp) {
        type(getTxtbx_MRP(tabCount, tab), mrp);
    }

    public void setQuantity(int tabCount, int tab, String quantity) {
        type(getTxtbx_Quantity(tabCount, tab), quantity);
    }

    public void setFreeQuantity(int tabCount, int tab, String freeQuantity) {
        type(getTxtbx_FreeQuantity(tabCount, tab), freeQuantity);
    }

    public void setCGST(int tabCount, int tab, String cgst) {
        type(getTxtbx_CGST(tabCount, tab), cgst);
    }

    public void setCDperc(int tabCount, int tab, String cdPerc) {
        type(getTxtbx_CDPercentage(tabCount, tab), cdPerc);
    }

    public void setSchemeCash(int tabCount, int tab, String schCash) {
        type(getTxtbx_SchemeRupees(tabCount, tab), schCash);
    }

    public void setSchemePerc(int tabCount, int tab, String schPerc) {
        type(getTxtbx_SchemePercentage(tabCount, tab), schPerc);
    }

    public void getIndividualNetValue(int tabCount, int tab, String net) {
        Assert.assertEquals(getValue(getTxt_IndividualNet(tabCount, tab)), net);
    }

    public void getEnterMedicineDetails(int tabCount, int tab, String medName, String barcode, String batch, String expiry, String rate, String mrp, String quantity, String freeQuantity, String cgst, String cdPerc, String schCash, String schPerc) {
        setBarcode(tabCount, tab, barcode);
        setBatch(tabCount, tab, batch);
        setExpiry(tabCount, tab, expiry);
        setRate(tabCount, tab, rate);
        setMRP(tabCount, tab, mrp);
        setQuantity(tabCount, tab, quantity);
        setFreeQuantity(tabCount, tab, freeQuantity);
        setCGST(tabCount, tab, cgst);
        setCDperc(tabCount, tab, cdPerc);
        setSchemeCash(tabCount, tab, schCash);
        setSchemePerc(tabCount, tab, schPerc);
        new PurchaseBillTabVerification(driver).getVerifyPurchaseBillMedicineDetails(tabCount, tab, medName, batch, rate, mrp, quantity, freeQuantity, cgst, cdPerc, schCash, schPerc);
    }

    public void click(int tabCount) {
        clickOn(driver, getTxtbx_SearchMedicine(tabCount, 1));
    }

    public void clickAddDetailsButton(int tabCount) {
        clickOn(driver, getBtn_AddDetails(tabCount));
    }

    public boolean setDistributorName(int tabCount, String distributorName) {
        pause(3);
        getExplicitWait(driver, getTxtbx_DistributorName(tabCount), EXPLICIT_WAIT);
        typeSlow(driver, getTxtbx_DistributorName(tabCount), distributorName);
        pause();
        if (getList_AddDistributor(distributorName).size() > 0) {
            clickOn(driver, getSlt_AddDistributor(distributorName));
            return false;
        } else {
            clickOn(driver, getSlt_AddDistributor("Add - " + distributorName));
            return true;
        }
    }

    public void setInvoiceNo(int tabCount, String value) {
        pause(2);
        getExplicitWait(driver, getTxtbx_InvoiceNo(tabCount), EXPLICIT_WAIT);
        typeSlow(driver, getTxtbx_InvoiceNo(tabCount), value);
    }

    public void setInvoiceDate(int tabCount, String date) {
        getTxtbx_InvoiceDate(tabCount).clear();
        typeSlow(driver, getTxtbx_InvoiceDate(tabCount), date);
    }

    public void clickGenerateBarcode(int tabCount) {
        clickOn(driver, getBtn_GenerateBarcode(tabCount));
    }

    public int getMedicineCount(int tabCount, int row, String medicine) {
        if (getValue(getTxt_MedicineRow(tabCount, row)).contains(medicine)) {
            return row;
        }
        return -1;
    }

    public void setCDRupees(int tabCount, int row, String CDRupees) {
        pause(1);
        type(getTxtbx_CDCash(tabCount, row), CDRupees);
    }

    public WebElement getDistributorValue(int tabCount) {
        return getTxtbx_DistributorName(tabCount);
    }

    public boolean isBarcodeTextBoxDisplayed(int tabCount, int row) {
        try {
            getTxtbx_Barcode(tabCount, row).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void setBarcode(int tabCount, int tab, String barcode) {
        if (barcode.length() < 2) {
            if (isBarcodeTextBoxDisplayed(tabCount, 1)) {
                getTxtbx_Barcode(tabCount, tab).clear();
            }
        } else {
            if (isBarcodeTextBoxDisplayed(tabCount, 1)) {
                type(getTxtbx_Barcode(tabCount, tab), barcode);
            }
        }
    }

    public boolean isUpdateExpiryPopUp() {
        try {
            getTxt_UpdateExpireDate().isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean getUpdateExpiryAndInvoice(int tabCount, String updateDate, String isUpdateInvoice) {
        if (isInvoiceUpdatePopUp()) {
            getModifyUpdateInvoice(isUpdateInvoice);
            return true;
        }

        if (isUpdateExpiryPopUp()) {
            getUpdateExpiry(updateDate);
            clickGenerateBarcode(tabCount);
            if (isInvoiceUpdatePopUp()) {
                getModifyUpdateInvoice(isUpdateInvoice);
                return true;
            }
        }
        return false;
    }

    public void getUpdateExpiry(String date) {
        pause(2);
        type(getTxtbx_ExpireDate(), date);
        clickOn(driver, getBtn_UpdateExpireOk());
        testStepsLog(_logStep++, "Expiry date for the invoice is updated");
    }

    public boolean isInvoiceUpdatePopUp() {
        try {
            pause();
            getExplicitWait(driver, getTxt_UpdateInvoice(), EXPLICIT_WAIT);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void getModifyUpdateInvoice(String value) {
        pause(1);
        if (value.equalsIgnoreCase("yes")) {
            clickOn(driver, getBtn_UpdateInvoiceOk());
            testStepsLog(_logStep++, "Modify Invoice is opened");
        } else {
            clickOn(driver, getBtn_UpdateInvoiceCancel());
            testStepsLog(_logStep++, "Modify Invoice is cancelled");
        }
    }

    public void clickChallanCheckBox(int tabCount) {
        clickOn(driver, getChkbx_Challan(tabCount));
    }

    public boolean isChallanCheckboxEnabled(int tabCount) {
        if (getChkbx_Challan(tabCount).isDisplayed()) {
            testStepsLog(_logStep++, "Challan Checkbox is Enabled");
            return true;
        } else {
            testStepsLog(_logStep++, "Challan Checkbox is Disabled");
            return false;
        }
    }

    public boolean checkChallanVisible(int tabCount, String challan) {
        if (getTxt_SelectInvoice(tabCount, challan).isDisplayed()) {
            testStepsLog(_logStep++, "Challan is Displayed");
            return true;
        } else {
            testStepsLog(_logStep++, "Challan is not Displayed");
            return false;
        }
    }

    public void selectChallan(int tabCount, String challan) {
        clickOn(driver, getTxt_SelectInvoice(tabCount, challan));
    }

    public int getMedicineCount(int tabCount) {
        return getTxt_MedicineCount(tabCount).size();
    }

    public void getAddCreditAmount(int tabCount) {
        clickOn(driver, getClk_CreditAmtAdd(tabCount));
        new CreditNoteVerification(driver).verifyOpenCreditNoteCheck(tabCount);
    }

    public boolean getUploadFile(int tabCount, String file) {
        try {
            pause(1);
            type(getBtn_Upload(tabCount), System.getProperty("user.dir") + file);
            pause(2);
            return true;
        } catch (Exception e) {
            testWarningLog(e.getMessage());
            return false;
        }
    }

    public void getMatchCheckMedicineName(int tabCount) {
        String medicineTemp;
        for (int i = 1; i <= getMedicineCount(tabCount); i++) {
            if (getValue(getTxtbx_SearchMedicine(tabCount, i)).length() < 1) {
                String[] temp = getTxt_FileSourceMedicine(tabCount, i).getText().trim().split(" ");
                medicineTemp = temp[0] + " " + temp[1];
                setMedicineNameCSV(tabCount, i, medicineTemp);
            }
        }
    }

    public void getEnterFullPurchaseBillDetails(String invoice, int tabCount, SideMenuController sideMenuController, HashMap<String, ArrayList<Object>> map, String orderTotalFooter) {
        setInvoiceNo(tabCount, invoice);
        testStepsLog(_logStep++, "Invoice no is Entered");

        if (setDistributorName(tabCount, getData(map, DISTRIBUTOR_NAME, 0))) {
            AddDistriutorTabController adt = new AddDistriutorTabController(driver);
            adt.getAddDistributorName(tabCount, getData(map, DISTRIBUTOR_NAME, 0));
            if (sideMenuController.checkAlertMessage(ALERT_DISTRIBUTOR_SAVE_SUCCESS)) {
                testStepsLog(_logStep++, getData(map, DISTRIBUTOR_NAME, 0) + " - New Distributor is Added");
            } else {
                getAlertCheck(sideMenuController.getAlertMessage());
                testWarningLog("New Distributor is not Added - " + getData(map, DISTRIBUTOR_NAME, 0));
            }
            pause(3);
        }

        getEnterPurchaseBillHeaderDetails(tabCount, getData(map, EXTRA_DISC, 0));
        testStepsLog(_logStep++, "Header details are updated");

        for (int i = 1; i <= map.get(MEDICINE_NAME).size(); i++) {
            String tempMedicineName = getData(map, MEDICINE_NAME, i - 1);

            if (setMedicineName(tabCount, i, tempMedicineName)) {
                sideMenuController.checkAlertMessage(ALERT_ADD_SUCCESS);
            }

            getEnterMedicineDetails(tabCount, i, tempMedicineName, getData(map, BARCODE, i - 1), getData(map, BATCH, i - 1), getData(map, EXPIRY, i - 1), getData(map, RATE_CP, i - 1),
                    getData(map, MRP_SP, i - 1), getData(map, QUANTITY, i - 1), getData(map, FREE_QUANTITY, i - 1),
                    getData(map, CGST, i - 1), getData(map, CD_PERCENTAGE, i - 1), getData(map, SCHEME_RUPEES, i - 1), getData(map, SCHEME_PERCENTAGE, i - 1));
            if (i != (map.get(MEDICINE_NAME).size())) {
                clickAddDetailsButton(tabCount);
            }
        }
        testStepsLog(_logStep++, "Medicine details are updated");
        new PurchaseBillTabVerification(driver).getVerifyPurchaseBillInvoice(tabCount, invoice, map, orderTotalFooter);
        click(tabCount);
    }

    public boolean getEnterAndSaveMedicinePurchaseBillDetails(String invoice, int tabCount, SideMenuController sideMenuController, PurchaseBillTabController pb, HashMap<String, ArrayList<Object>> map, String modifyInvoice, String orderTotalFooter) {
        setInvoiceNo(tabCount, invoice);
        testStepsLog(_logStep++, "Invoice no is Entered");

        getEnterPurchaseBillHeaderDetails(tabCount, getData(map, EXTRA_DISC, 0));
        testStepsLog(_logStep++, "Header details are updated");

        pause(2);

        for (int i = 1; i <= map.get(MEDICINE_NAME).size(); i++) {
            String tempMedicineName = getData(map, MEDICINE_NAME, i - 1);

            setMedicineName(tabCount, i, tempMedicineName);

            getEnterMedicineDetails(tabCount, i, tempMedicineName, getData(map, BARCODE, i - 1), getData(map, BATCH, i - 1), getData(map, EXPIRY, i - 1), getData(map, RATE_CP, i - 1),
                    getData(map, MRP_SP, i - 1), getData(map, QUANTITY, i - 1), getData(map, FREE_QUANTITY, i - 1),
                    getData(map, CGST, i - 1), getData(map, CD_PERCENTAGE, i - 1), getData(map, SCHEME_RUPEES, i - 1), getData(map, SCHEME_PERCENTAGE, i - 1));
            if (i != (map.get(MEDICINE_NAME).size())) {
                clickAddDetailsButton(tabCount);
            }
        }
        testStepsLog(_logStep++, "Medicine details are updated");
        new PurchaseBillTabVerification(driver).getVerifyPurchaseBillInvoice(tabCount, invoice, map, orderTotalFooter);

        boolean check = getSaveUpdateClosePurchaseBill(sideMenuController, tabCount, getData(map, UPDATE_DATE, 0), modifyInvoice);
        testStepsLog(_logStep++, "New Purchase Bill is generated");

        sideMenuController.closeCurrentTab(tabCount);

        return check;
    }

    public boolean getAddEnterMedicineDetails(int tabCount, HashMap<String, ArrayList<Object>> map) {
        pause(3);
        int medicineCount = getMedicineCount(tabCount) + 1;
        getEnableBarcode(tabCount);

        for (int i = 0; i < map.get(MEDICINE_NAME).size(); i++) {
            clickAddDetailsButton(tabCount);
            String tempMedicineName = getData(map, MEDICINE_NAME, i);
            pause(1);
            setMedicineName(tabCount, medicineCount + i, tempMedicineName);
            getEnterMedicineDetails(tabCount, medicineCount, tempMedicineName, getData(map, BARCODE, i), getData(map, BATCH, i), getData(map, EXPIRY, i), getData(map, RATE_CP, i),
                    getData(map, MRP_SP, i), getData(map, QUANTITY, i), getData(map, FREE_QUANTITY, i),
                    getData(map, CGST, i), getData(map, CD_PERCENTAGE, i), getData(map, SCHEME_RUPEES, i), getData(map, SCHEME_PERCENTAGE, i));
        }
        click(tabCount);
        return new PurchaseBillTabVerification(driver).getVerifyMedicineDetails(tabCount, map);
    }


    public static void getEnterMedicineDetails(int tabCount, PurchaseBillTabController purchaseBillTabController, HashMap<String, ArrayList<Object>> map) {
        purchaseBillTabController.getEnableBarcode(tabCount);

        for (int i = 0; i < map.get(MEDICINE_NAME).size(); i++) {
            String tempMedicineName = getData(map, MEDICINE_NAME, i);
            purchaseBillTabController.setMedicineName(tabCount, i + 1, tempMedicineName);
            purchaseBillTabController.getEnterMedicineDetails(tabCount, i + 1, tempMedicineName, getData(map, BARCODE, i), getData(map, BATCH, i), getData(map, EXPIRY, i), getData(map, RATE_CP, i),
                    getData(map, MRP_SP, i), getData(map, QUANTITY, i), getData(map, FREE_QUANTITY, i),
                    getData(map, CGST, i), getData(map, CD_PERCENTAGE, i), getData(map, SCHEME_RUPEES, i), getData(map, SCHEME_PERCENTAGE, i));
            if (i < (map.get(MEDICINE_NAME).size())) {
                purchaseBillTabController.clickAddDetailsButton(tabCount);
            }
        }
    }

    public boolean getSaveUpdateClosePurchaseBill(SideMenuController sideMenuController, int tabCount, String updateDate, String isModifyInvoice) {
        clickGenerateBarcode(tabCount);
        getAlertCheck(sideMenuController.getAlertMessage());
        return getUpdateExpiryAndInvoice(tabCount, updateDate, isModifyInvoice);
    }

    public void setDistributorName(int tabCount, HashMap<String, ArrayList<Object>> map, PurchaseBillTabController purchaseBillTabController, SideMenuController sideMenuController) {
        if (purchaseBillTabController.setDistributorName(tabCount, getData(map, DISTRIBUTOR_NAME, 0))) {
            AddDistriutorTabController addDistriutorTabController = new AddDistriutorTabController(driver);
            addDistriutorTabController.getAddDistributorName(tabCount, getData(map, DISTRIBUTOR_NAME, 0));
            if (sideMenuController.checkAlertMessage(ALERT_DISTRIBUTOR_SAVE_SUCCESS)) {
                testStepsLog(_logStep++, getData(map, DISTRIBUTOR_NAME, 0) + " - New Distributor is Added");
            } else {
                getAlertCheck(sideMenuController.getAlertMessage());
                testWarningLog("New Distributor is not Added - " + getData(map, DISTRIBUTOR_NAME, 0));
            }
            pause(3);
        }
    }
}
