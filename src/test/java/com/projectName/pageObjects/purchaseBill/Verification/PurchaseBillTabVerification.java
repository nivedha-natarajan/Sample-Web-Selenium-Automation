package com.projectName.pageObjects.purchaseBill.Verification;

import com.projectName.constants.DataConstantsPurchaseBill;
import com.projectName.constants.UploadColumns;
import com.projectName.pageObjects.purchaseBill.Controller.PurchaseBillTabController;
import erp.auto.testing.projectName.constants.*;
import com.framework.init.AbstractPage;
import com.framework.utils.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;


public class PurchaseBillTabVerification extends AbstractPage implements Configuration, UploadColumns, DataConstantsPurchaseBill {

    PurchaseBillTabController purchaseBillTabController = new PurchaseBillTabController(driver);

    //Header
    private WebElement txtbx_DistriutorName;
    private WebElement txtbx_InvoiceNo;
    private WebElement txtbx_InvoiceDate;
    private WebElement txtbx_ExtraDiscount;
    private WebElement txtbx_CreditAmt;
    private WebElement txtbx_HeaderCashDiscountPerc;
    private WebElement chkbx_Barcode;
    private WebElement chkbx_CashDiscount;
    private WebElement chkbx_HSN;
    private WebElement chkbx_TCS;
    private WebElement txtbx_SearchMedicine;
    private WebElement txtbx_Barcode;
    private WebElement txtbx_HSN;
    private WebElement txtbx_Batch;
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
    private WebElement txtbx_SchemeRupees;
    private WebElement txtbx_SchemePercentage;
    private WebElement txt_Items;
    private WebElement txt_Quantity;
    private WebElement txt_SchemeRupees;
    private WebElement txt_TaxTotal;
    private WebElement txt_CDCash;
    private WebElement txt_GrossTotal;
    private WebElement txt_OrderTotal;
    private WebElement txt_LastPurchaseId;
    private WebElement txt_Outstanding;
    private WebElement txt_MedicineDetails;
    private WebElement btn_CancelMedicine;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public PurchaseBillTabVerification(WebDriver driver) {
        super(driver);
    }


    private WebElement getTxtbx_DistributorName(int tabCount) {
        txtbx_DistriutorName = driver.findElement(By.xpath("//input[@id='distributor' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_DistriutorName;
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

    private WebElement getBtn_CancelMedicine(int tabCount, int detailsCount) {
        btn_CancelMedicine = driver.findElement(By.xpath("(//div[contains(@id,'tabCon_" + tabCount + "')]//tbody/tr/td[@class='quantTab']/div/span)[" + detailsCount + "]"));
        return btn_CancelMedicine;
    }

    private WebElement getTxtbx_CreditAmt(int tabCount) {
        txtbx_CreditAmt = driver.findElement(By.xpath("//input[@tab='tabCon_" + tabCount + "' and @id='creditAmt']"));
        return txtbx_CreditAmt;
    }

    private WebElement getTxtbx_HeaderCashDiscountPerc(int tabCount) {
        txtbx_HeaderCashDiscountPerc = driver.findElement(By.xpath("//input[@tab='tabCon_" + tabCount + "' and @id='cd']"));
        return txtbx_HeaderCashDiscountPerc;
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

    private WebElement getTxtbx_SearchMedicine(int tabCount, int detailsCount) {
        txtbx_SearchMedicine = driver.findElement(By.xpath("(//span/input[contains(@id,'tabCon_" + tabCount + "_search_medicine')])[" + detailsCount + "]"));
        return txtbx_SearchMedicine;
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

    private WebElement getTxtbx_SchemePercentage(int tabCount, int detailsCount) {
        txtbx_SchemePercentage = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_schemePercent')])[" + detailsCount + "]"));
        return txtbx_SchemePercentage;
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

    private WebElement getTxt_GrossTotal(int tabCount) {
        txt_GrossTotal = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@class='footerBill purchaseFooterMain']//label[@data-bind='text:grossTotal']"));
        return txt_GrossTotal;
    }

    private WebElement getTxt_OrderTotal(int tabCount) {
        txt_OrderTotal = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//label[@class='amountValue']"));
        return txt_OrderTotal;
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

    public void getVerifyBarcodeTextBox(int tabCount, int row) {
        Assert.assertTrue(getTxtbx_Barcode(tabCount, row).isDisplayed(), "Barcode Textbox is not Displayed");
    }

    public void getVerifyExtraDiscount(int tabCount, String extraDisc) {
        Assert.assertEquals(getValue(getTxtbx_ExtraDiscount(tabCount)), extraDisc);
    }

    public void getVerifyCDPercHeader(int tabCount, String cdPercHeader) {
        Assert.assertEquals(getValue(getTxtbx_HeaderCashDiscountPerc(tabCount)), cdPercHeader);
    }

    public void getVerifyMedicineName(int tabCount, int row, String medName) {
        Assert.assertTrue(getValue(getTxtbx_SearchMedicine(tabCount, row)).contains(medName), "Medicine name is not Matching");
    }

    public void getVerifyBatch(int tabCount, int row, String batch) {
        Assert.assertEquals(getValue(getTxtbx_Batch(tabCount, row)).toUpperCase(), batch);
    }

    public void getVerifyExpiry(int tabCount, int row, String expiry) {
        Assert.assertEquals(getValue(getTxtbx_Expiry(tabCount, row)).toUpperCase(), expiry);
    }

    public void getVerifyRate(int tabCount, int row, String rate) {
        Assert.assertEquals(getValue(getTxtbx_Rate(tabCount, row)), rate);
    }

    public void getVerifyMRP(int tabCount, int row, String mrp) {
        Assert.assertEquals(getValue(getTxtbx_MRP(tabCount, row)), mrp);
    }

    public void getVerifyQuantity(int tabCount, int row, String quantity) {
        Assert.assertEquals(getValue(getTxtbx_Quantity(tabCount, row)), quantity);
    }

    public void getVerifyFreeQuantity(int tabCount, int row, String freeQuantity) {
        Assert.assertEquals(getValue(getTxtbx_FreeQuantity(tabCount, row)), freeQuantity);
    }

    public void getVerifyGST(int tabCount, int row, String cgst) {
        purchaseBillTabController.click(tabCount);
        Assert.assertEquals(getValue(getTxtbx_CGST(tabCount, row)), cgst);
        Assert.assertEquals(getValue(getTxtbx_SGST(tabCount, row)), cgst);
    }

    public void getVerifyCDperc(int tabCount, int row, String cdPerc) {
        Assert.assertEquals(getValue(getTxtbx_CDPercentage(tabCount, row)), cdPerc);
    }

    public void getVerifySchemeCash(int tabCount, int row, String schCash) {
        Assert.assertEquals(getValue(getTxtbx_SchemeRupees(tabCount, row)), schCash);
    }

    public void getVerifySchemePerc(int tabCount, int row, String schPerc) {
        Assert.assertEquals(getValue(getTxtbx_SchemePercentage(tabCount, row)), schPerc);
    }

    public void getVerifyDistributorName(int tabCount, String distributorName) {
        Assert.assertEquals(getValue(getTxtbx_DistributorName(tabCount)), distributorName);
    }

    public void getVerifyInvoiceNo(int tabCount, String invoiceNo) {
        Assert.assertEquals(getValue(getTxtbx_InvoiceNo(tabCount)), invoiceNo);
    }

    public void getVerifyInvoiceDate(int tabCount, String date) {
        Assert.assertEquals(getValue(getTxtbx_InvoiceDate(tabCount)), date);
    }

    public void getVerifyPurchaseBillHeader(int tabCount, String distributorName, String Invoice, String extraDisc) {
        Assert.assertEquals(getValue(getTxtbx_DistributorName(tabCount)), distributorName);
        Assert.assertEquals(getValue(getTxtbx_InvoiceNo(tabCount)), Invoice);
    }

    public void getVerifyCDPercentage(int tabCount, int row, String CDPerc) {
        purchaseBillTabController.click(tabCount);
        pause(1);
        Assert.assertEquals(getValue(getTxtbx_CDPercentage(tabCount, row)), CDPerc);
    }

    public void getVerifyCDRupees(int tabCount, int row, String CDRupees) {
        clickOn(driver, getTxtbx_SearchMedicine(tabCount, row));
        Assert.assertEquals(getValue(getTxtbx_CDCash(tabCount, row)), CDRupees);
    }

    public void getVerifyPurchaseBillMedicineDetails(int tabCount, int row, String medicine, String batch, String rate, String mrp, String quantity,
                                                     String freeQuantity, String cgst, String cdPerc, String schRs, String schPerc) {
        Assert.assertTrue(getValue(getTxtbx_SearchMedicine(tabCount, row)).contains(medicine), "Medicine name is not Matching");
        Assert.assertEquals(getValue(getTxtbx_Batch(tabCount, row)).toUpperCase(), batch, "Batch is not Matching");
        Assert.assertEquals(getValue(getTxtbx_Rate(tabCount, row)), rate, "Rate is not Matching");
        Assert.assertEquals(getValue(getTxtbx_MRP(tabCount, row)), mrp, "MRP is not Matching");
        Assert.assertEquals(getValue(getTxtbx_Quantity(tabCount, row)), quantity, "Quantity is not Matching");
        Assert.assertEquals(getValue(getTxtbx_FreeQuantity(tabCount, row)), freeQuantity, "Free Quantity is not Matching");
        Assert.assertEquals(getValue(getTxtbx_CGST(tabCount, row)), cgst, "CGST is not Matching");
        getVerifyCDPercentage(tabCount, row, cdPerc);
        Assert.assertEquals(getValue(getTxtbx_SchemeRupees(tabCount, row)), schRs, "Scheme Rupees is not Matching");
        Assert.assertEquals(getValue(getTxtbx_SchemePercentage(tabCount, row)), schPerc, "Scheme Percentage is not Matching");
    }

    public void getVerifyPurchaseBillFooter(int tabCount, String items, String quantity, String schRs, String taxTotal, String CDCash, String grossTotal, String orderTotal) {
        getVerifyItemsFooter(tabCount, items);
        getVerifyQuantityFooter(tabCount, quantity);
        getVerifySchemeFooter(tabCount, schRs);
        getVerifyTaxTotal(tabCount, taxTotal);
        getVerifyCDFooter(tabCount, CDCash);
        getVerifyGrossTotal(tabCount, grossTotal);
        getVerifyOrderTotal(tabCount, orderTotal);
    }

    public boolean getVerifyBarcodeCheckBox(int tabCount, int row) {
        clickOn(driver, getChkbx_Barcode(tabCount));
        testStepsLog(_logStep++, "Barcode Checkbox is Enabled/Disabled");
        return isBarcodeTextBoxDisplayed(tabCount, row);
    }

    public boolean isBarcodeTextBoxDisplayed(int tabCount, int row) {
        try {
            getTxtbx_Barcode(tabCount, row).isDisplayed();
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getVerifyCDCashTextBox(int tabCount, int row) {
        clickOn(driver, getChkbx_CashDiscount(tabCount));
        testStepsLog(_logStep++, "CD Cash Checkbox is Enabled/Disabled");
        return isCDTextBoxDisplayed(tabCount, row);
    }

    public boolean isCDTextBoxDisplayed(int tabCount, int row) {
        try {
            getTxtbx_CDCash(tabCount, row).isDisplayed();
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean isVATTextBoxDisplayed(int tabCount, int row) {
        try {
            getTxtbx_VAT(tabCount, row).isDisplayed();
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getVerifyHSNTextBox(int tabCount, int row) {
        return isHSNTextBoxDisplayed(tabCount, row);
    }

    public boolean isHSNTextBoxDisplayed(int tabCount, int row) {
        try {
            clickOn(driver, getChkbx_HSN(tabCount));
            getTxtbx_HSN(tabCount, row).isDisplayed();
            testStepsLog(_logStep++, "HSN Checkbox is Enabled/Disabled");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean getVerifyTCSTextBox(int tabCount, int row) {
        clickOn(driver, getChkbx_TCS(tabCount));
        testStepsLog(_logStep++, "TCS Checkbox is Enabled/Disabled");
        return isTCSTextBoxDisplayed(tabCount, row);
    }

    public boolean isTCSTextBoxDisplayed(int tabCount, int row) {
        try {
            getTxtbx_TCS(tabCount, row).isDisplayed();
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean isCESSTextBoxDisplayed(int tabCount, int row) {
        try {
            getTxtbx_CESS(tabCount, row).isDisplayed();
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean isIGSTTextBoxDisplayed(int tabCount, int row) {
        try {
            getTxtbx_IGST(tabCount, row).isDisplayed();
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    public void getVerifyBarcode(int tabCount, int row, String barcode) {
        Assert.assertEquals(getValue(getTxtbx_Barcode(tabCount, row)), barcode);
    }

    public void getVerifyBarcodePopulate(int tabCount, int row, String medicine, String expiry, String rate, String mrp, String cgst) {
        Assert.assertTrue(getValue(getTxtbx_SearchMedicine(tabCount, row)).startsWith(medicine), "Medicine is not Matching");
        Assert.assertEquals(getValue(getTxtbx_Expiry(tabCount, row)), expiry, "Expiry is not Matching");
        Assert.assertEquals(getValue(getTxtbx_Rate(tabCount, row)), rate, "Rate is not Matching");
        Assert.assertEquals(getValue(getTxtbx_MRP(tabCount, row)), mrp, "MRP is not Matching");
        Assert.assertEquals(getValue(getTxtbx_CGST(tabCount, row)), cgst, "CGST is not Matching");
        testVerifyLog("Verified Barcode autoPopulated details - Medicine Name, Expiry, Rate, MRP, CGST");
    }

    public void getVerifyBarcodeDetails(int tabCount, HashMap<String, ArrayList<Object>> map) {
        purchaseBillTabController.getEnableBarcode(tabCount);
        for (int i = 0; i < 1; i++) {
            purchaseBillTabController.setBarcode(tabCount, i + 1, getData(map, BARCODE, i));
            purchaseBillTabController.click(tabCount);
            pause();
            getVerifyBarcodePopulate(tabCount, i + 1, getData(map, MEDICINE_NAME, i), getData(map, UPDATE_DATE, i),
                    getData(map, RATE_CP, i), getData(map, MRP_SP, i), getData(map, CGST, i));
            testStepsLog(_logStep++, "Medicine details are populated for the barcode - " + getData(map, BARCODE, i));
        }
    }

    public boolean getVerifyCreditNoteAddition(String value, int tabCount) {
        Assert.assertTrue(getValue(getTxtbx_CreditAmt(tabCount)).startsWith(value), "Expected Amount : " + value + " - Actual Amount : " + getValue(getTxtbx_CreditAmt(tabCount)));
        return true;
    }

    public void getVerifyOutstanding(int tabCount) {
        getTxt_Outstanding(tabCount).isDisplayed();
    }

    public void getVerifyMedicineDetails(int tabCount) {
        getTxt_MedicineDetails(tabCount).isDisplayed();
    }

    public void getVerifyLastPurchaseId(int tabCount) {
        getTxt_LastPurchaseId(tabCount).isDisplayed();
    }

    public void getVerifySchemeFooter(int tabCount, String schRs) {
        Assert.assertEquals(getTxt_SchemeRupees(tabCount).getText(), schRs);
    }

    public void getVerifyItemsFooter(int tabCount, String items) {
        try {
            clickOn(driver, getBtn_CancelMedicine(tabCount, Integer.parseInt(items) + 1));
        } catch (Exception ignored) {
        }
        ;
        Assert.assertEquals(getTxt_Items(tabCount).getText(), items);
    }

    public void getVerifyQuantityFooter(int tabCount, String quantity) {
        Assert.assertEquals(getTxt_Quantity(tabCount).getText(), quantity);
    }

    public void getVerifyTaxTotal(int tabCount, String taxTotal) {
        Assert.assertEquals(getTxt_TaxTotal(tabCount).getText(), taxTotal);
    }

    public void getVerifyCDFooter(int tabCount, String CDCash) {
        Assert.assertEquals(getTxt_CDCash(tabCount).getText(), CDCash);
    }

    public void getVerifyGrossTotal(int tabCount, String grossTotal) {
        Assert.assertEquals(getTxt_GrossTotal(tabCount).getText(), grossTotal);
    }

    public void getVerifyOrderTotal(int tabCount, String orderTotal) {
        purchaseBillTabController.click(tabCount);
        Assert.assertEquals(getTxt_OrderTotal(tabCount).getText(), orderTotal);
    }

    public void getVerifyPurchaseBillInvoice(int tabCount, String invoice, HashMap<String, ArrayList<Object>> map, String orderTotalFooter) {
        int quantity = 0;

        pause(3);

        getVerifyPurchaseBillHeader(tabCount, getData(map, DISTRIBUTOR_NAME, 0), invoice, getData(map, EXTRA_DISC, 0));
        testVerifyLog("Purchase Invoice Header is Verified");

        getVerifyMedicineDetails(tabCount, map);

        for (int i = 0; i < map.get(QUANTITY).size(); i++) {
            quantity += Integer.parseInt(getData(map, QUANTITY, i));
        }

        getVerifyPurchaseBillFooter(tabCount, String.valueOf(map.get("Medicine Name").size()), String.valueOf(quantity),
                getData(map, SCHEME_FOOTER, 0), getData(map, TOTAL_TAX_FOOTER, 0), getData(map, CD_FOOTER, 0),
                getData(map, GROSS_TOTAL_FOOTER, 0), orderTotalFooter);
        testVerifyLog("Purchase Invoice Footer is Verified");
    }

    public boolean getVerifyMedicineDetails(int tabCount, HashMap<String, ArrayList<Object>> map) {
        for (int i = 1; i <= map.get(MEDICINE_NAME).size(); i++) {
            for (int j = 0; j < map.get(MEDICINE_NAME).size(); j++) {
                String medicine = getData(map, MEDICINE_NAME, i - 1);
                int row = purchaseBillTabController.getMedicineCount(tabCount, j, medicine);
                if (row >= 0) {
                    getVerifyPurchaseBillMedicineDetails(tabCount, row + 1, medicine,
                            getData(map, BATCH, i - 1), getData(map, RATE_CP, i - 1),
                            getData(map, MRP_SP, i - 1), getData(map, QUANTITY, i - 1), getData(map, FREE_QUANTITY, i - 1),
                            getData(map, CGST, i - 1), getData(map, CD_PERCENTAGE, i - 1), getData(map, SCHEME_RUPEES, i - 1), getData(map, SCHEME_PERCENTAGE, i - 1));
                    break;
                }
            }
        }
        testVerifyLog("Purchase Invoice Medicines Details are Verified");
        return true;
    }
}
