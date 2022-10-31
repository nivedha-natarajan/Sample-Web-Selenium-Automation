package com.projectName.pageObjects.salesBill.Controller;

import com.projectName.constants.DataConstantsSalesBill;
import com.projectName.constants.Validations;
import com.framework.init.AbstractPage;
import com.projectName.pageObjects.salesBill.Verification.SalesReturnVerification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;

public class SalesReturnController extends AbstractPage implements Validations, DataConstantsSalesBill {

    public SalesReturnController(WebDriver driver) {
        super(driver);
    }

    private WebElement txtbx_PatientName;
    private WebElement slt_PatientName;
    private WebElement txt_BillAccount;
    private WebElement txt_Date;
    private WebElement clk_SelectInvoices;
    private WebElement clk_SelectAll;
    private WebElement clk_DeselectAll;
    private WebElement txtbx_SearchInvoice;
    private WebElement clk_SelectInvoice;
    private WebElement btn_GetMedicine;
    private WebElement txtbx_SearchMedicine;
    private WebElement slt_SearchMedicine;
    private WebElement clk_Batch;
    private WebElement slt_Batch;
    private WebElement txtbx_Barcode;
    private WebElement clk_Invoice;
    private WebElement slt_Invoice;
    private WebElement txt_Discount;
    private WebElement txtbx_Quantity;
    private WebElement txtbx_Loose;
    private WebElement txtbx_MRP;
    private WebElement txt_Total;
    private WebElement clk_ModeOfPayment;
    private WebElement slt_ModeOfPayment;
    private WebElement txtbx_Remarks;
    private WebElement txt_Items;
    private WebElement txt_Quantity;
    private WebElement txt_DiscountRupees;
    private WebElement txt_BillAmount;
    private WebElement txt_TotalAmount;
    private WebElement btn_Return;
    private WebElement btn_DeleteMedicineRow;

    private WebElement getBtn_DeleteMedicineRow(int tabCount, int row) {
        btn_DeleteMedicineRow = driver.findElement(By.xpath("(//div[@id='medTuttabCon_" + tabCount + "']//div/span[contains(@data-bind,'removeDetail')])[" + row + "]"));
        return btn_DeleteMedicineRow;
    }

    private WebElement getTxtbx_PatientName(int tabCount) {
        txtbx_PatientName = driver.findElement(By.xpath("//input[@id='pat' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_PatientName;
    }

    private WebElement getSlt_PatientName(int tabCount, String patient) {
        slt_PatientName = driver.findElement(By.xpath("//li[contains(@id,'ui-id') and starts-with(text(),'" + patient + "')]"));
        return slt_PatientName;
    }

    private WebElement getTxt_BillAccount(int tabCount) {
        txt_BillAccount = driver.findElement(By.xpath("//input[@id='patientReturnEntityName' and @tab='tabCon_" + tabCount + "']"));
        return txt_BillAccount;
    }

    private WebElement getTxt_Date(int tabCount) {
        txt_Date = driver.findElement(By.xpath("//input[@id='backDatedSalesReturn' and @tab='tabCon_" + tabCount + "']"));
        return txt_Date;
    }

    private WebElement getClk_SelectInvoicesInHeader(int tabCount) {
        clk_SelectInvoices = driver.findElement(By.xpath("//div[@id='patTuttabCon_" + tabCount + "']//div/button/span[text()='Invoices']"));
        return clk_SelectInvoices;
    }

    private WebElement getClk_SelectAll(int tabCount) {
        clk_SelectAll = driver.findElement(By.xpath("//div[@id='patTuttabCon_" + tabCount + "']//div/button[text()='Select All']"));
        return clk_SelectAll;
    }

    private WebElement getClk_DeselectAll(int tabCount) {
        clk_DeselectAll = driver.findElement(By.xpath("//div[@id='patTuttabCon_" + tabCount + "']//div/button[text()='Deselect All']"));
        return clk_DeselectAll;
    }

    private WebElement getTxtbx_SearchInvoiceInHeader(int tabCount) {
        txtbx_SearchInvoice = driver.findElement(By.xpath("//div[@id='patTuttabCon_" + tabCount + "']//div[@class='bs-searchbox']/input"));
        return txtbx_SearchInvoice;
    }

    private WebElement getClk_SelectInvoiceInHeader(int tabCount, int row, String totalAmount) {
        clk_SelectInvoice = driver.findElement(By.xpath("//div[@id='patTuttabCon_" + tabCount + "']//div/ul/li[" + row + "]/a/span[contains(text(),'" + totalAmount + "')]"));
        return clk_SelectInvoice;
    }

    private WebElement getBtn_GetMedicine(int tabCount) {
        btn_GetMedicine = driver.findElement(By.xpath("//div[@id='patTuttabCon_" + tabCount + "']//button[@id='getAllMedicinesButton']"));
        return btn_GetMedicine;
    }

    private WebElement getTxtbx_SearchMedicine(int tabCount, int row) {
        txtbx_SearchMedicine = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_search_medicine')])[" + row + "]"));
        return txtbx_SearchMedicine;
    }

    private WebElement getSlt_SearchMedicine(String medicine, int row) {
        slt_SearchMedicine = driver.findElement(By.xpath("(//li[contains(@id,'ui-id')]/a/strong[starts-with(text(),'" + medicine + "')])[" + row + "]"));
        return slt_SearchMedicine;
    }

    private WebElement getClk_Batch(int tabCount, int row) {
        clk_Batch = driver.findElement(By.xpath("(//div[contains(@id,'tabCon_" + tabCount + "_batch')]/div/button)[" + row + "]"));
        return clk_Batch;
    }

    private WebElement getSlt_Batch(int tabCount, String batch, int row) {
        slt_Batch = driver.findElement(By.xpath("(//div[contains(@id,'tabCon_" + tabCount + "_batch')]/div/div/ul/li/a/span[contains(text(),'" + batch + "')])[" + row + "]"));
        return slt_Batch;
    }

    private WebElement getTxtbx_Barcode(int tabCount, int row) {
        txtbx_Barcode = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_barcode')])[" + row + "]"));
        return txtbx_Barcode;
    }

    private WebElement getClk_InvoiceInMedicine(int tabCount, int row) {
        clk_Invoice = driver.findElement(By.xpath("(//div[contains(@id,'s2id_tabCon_" + tabCount + "_invoice')])[" + row + "]"));
        return clk_Invoice;
    }

    private WebElement getTxtbx_SearchInvoiceInMedicine(int tabCount, int row) {
        txtbx_SearchInvoice = driver.findElement(By.xpath("(//div[@id='select2-drop']/div/input)[" + row + "]"));
        return txtbx_SearchInvoice;
    }

    private WebElement getSlt_InvoiceInMedicine(int row, String batch) {
        slt_Invoice = driver.findElement(By.xpath("(//div[@id='select2-drop']/ul/li/div/div/span[contains(text(),'" + batch + "')])[" + row + "]"));
        return slt_Invoice;
    }

    private WebElement getTxt_Discount(int tabCount, int row) {
        txt_Discount = driver.findElement(By.xpath("(//div[@id='medTuttabCon_" + tabCount + "']//div/label[contains(@data-bind,'discPer')])[" + row + "]"));
        return txt_Discount;
    }

    private WebElement getTxtbx_Quantity(int tabCount, int row) {
        txtbx_Quantity = driver.findElement(By.xpath("(//input[contains(@id,'tabCon_" + tabCount + "_qty')])[" + row + "]"));
        return txtbx_Quantity;
    }

    private WebElement getTxtbx_Loose(int tabCount, int row) {
        txtbx_Loose = driver.findElement(By.xpath("(//input[@tab='tabCon_" + tabCount + "' and contains(@data-bind,'loose')])[" + row + "]"));
        return txtbx_Loose;
    }

    private WebElement getTxtbx_MRP(int tabCount, int row) {
        txtbx_MRP = driver.findElement(By.xpath("(//input[@tab='tabCon_" + tabCount + "' and contains(@data-bind,'perSKU')])[" + row + "]"));
        return txtbx_MRP;
    }

    private WebElement getTxt_Total(int tabCount, int row) {
        txt_Total = driver.findElement(By.xpath("(//input[@tab='tabCon_" + tabCount + "' and contains(@data-bind,'totalPriceView')])[" + row + "]"));
        return txt_Total;
    }

    private WebElement getClk_ModeOfPayment(int tabCount) {
        clk_ModeOfPayment = driver.findElement(By.xpath("//div[@id='localCTA_tabCon_" + tabCount + "']//div[contains(@class,'selectPaymentMediumDropdown')]/div/div/button/span[contains(@class,'filter-option')]"));
        return clk_ModeOfPayment;
    }

    private WebElement getSlt_ModeOfPayment(int tabCount, String mod) {
        slt_ModeOfPayment = driver.findElement(By.xpath("//div[@id='localCTA_tabCon_" + tabCount + "']//ul/li/a/span[text()='" + mod.toLowerCase() + "']"));
        return slt_ModeOfPayment;
    }

    private WebElement getTxtbx_Remarks(int tabCount) {
        txtbx_Remarks = driver.findElement(By.xpath("//div[@id='localCTA_tabCon_" + tabCount + "']//div/label[text()='Remarks']/parent::div/input"));
        return txtbx_Remarks;
    }

    private WebElement getTxt_Items(int tabCount) {
        txt_Items = driver.findElement(By.xpath("//div[@id='localCTA_tabCon_" + tabCount + "']/div//label[text()='Items']/parent::div/label[@data-bind]"));
        return txt_Items;
    }

    private WebElement getTxt_Quantity(int tabCount) {
        txt_Quantity = driver.findElement(By.xpath("//div[@id='localCTA_tabCon_" + tabCount + "']/div//label[text()='Qty']/parent::div/label[@data-bind]"));
        return txt_Quantity;
    }

    private WebElement getTxt_DiscountRupees(int tabCount) {
        txt_DiscountRupees = driver.findElement(By.xpath("//div[@id='localCTA_tabCon_" + tabCount + "']/div//label[text()='Disc (₹)']/parent::div/label[@data-bind]"));
        return txt_DiscountRupees;
    }

    private WebElement getTxt_BillAmount(int tabCount) {
        txt_BillAmount = driver.findElement(By.xpath("//div[@id='localCTA_tabCon_" + tabCount + "']/div//label[text()='Bill Amt (₹)']/parent::div/label[@data-bind]"));
        return txt_BillAmount;
    }

    private WebElement getTxt_TotalAmount(int tabCount) {
        txt_TotalAmount = driver.findElement(By.xpath("//div[@id='localCTA_tabCon_" + tabCount + "']/div//label[text()='Total Amount']/parent::div/label[@data-bind]"));
        return txt_TotalAmount;
    }

    private WebElement getBtn_Return(int tabCount) {
        btn_Return = driver.findElement(By.xpath("//div[@id='localCTA_tabCon_" + tabCount + "']//button[text()='Return [F10]']"));
        return btn_Return;
    }

    public void setPatientName(int tabCount, String patient) {
        typeSlow(driver, getTxtbx_PatientName(tabCount), patient);
        clickOn(driver, getSlt_PatientName(tabCount, patient));
        pause();
    }

    public void setReturnSalesHeaderDetails(int tabCount, String totalAmount) {
        clickOn(driver, getClk_SelectInvoicesInHeader(tabCount));
        clickOn(driver, getClk_SelectInvoiceInHeader(tabCount, 1, totalAmount));
        clickOn(driver, getBtn_GetMedicine(tabCount));
    }

    public void getSaveReturnInvoice(int tabCount) {
        clickOn(driver, getBtn_Return(tabCount));
        testStepsLog(_logStep++, "Saved Return invoice");
    }

    public void setReturnSales(int tabCount, HashMap<String, ArrayList<Object>> map, String medicine, String batch, String discount, String salesTotal, String quantity, String loose, String mrp,
                               String totalAmount, String billAmount, String mop, String remarks, String discountRupees) {
        setReturnSalesHeaderDetails(tabCount, salesTotal);
        for (int i = 0; i < map.get(MEDICINE_NAME).size(); i++) {
            new SalesReturnVerification(driver).getVerifyMedicines(tabCount, i + 1, getData(map, MEDICINE_NAME, i), getData(map, BATCH, i), getData(map, DISCOUNT_PERCENTAGE, i),
                    getData(map, QUANTITY, i), getData(map, LOOSE, i), getData(map, MRP, i), getData(map, MEDICINE_TOTAL, i));
        }
        for (int i = 1; i < map.get(MEDICINE_NAME).size(); i++) {
            clickOn(driver, getBtn_DeleteMedicineRow(tabCount, i));
            testStepsLog(_logStep++, "All Existing Medicine details are cleared");
        }
        for (int i = 0; i < map.get(MEDICINE_NAME).size(); i++) {
            setMedicineDetails(tabCount, i + 1, getData(map, MEDICINE_NAME, i), getData(map, BATCH, i), getData(map, DISCOUNT_PERCENTAGE, i),
                    getData(map, QUANTITY, i), getData(map, LOOSE, i), getData(map, MRP, i), getData(map, TOTAL_AMOUNT, i));
        }
        testValidationLog("Return Medicine details are Added");
        setFooterDetails(tabCount, mop, remarks, String.valueOf(map.get(MEDICINE_NAME).size()), quantity, discountRupees, billAmount, totalAmount);
        getSaveReturnInvoice(tabCount);
        testStepsLog(_logStep++, "Return Invoice details are Added");
    }

    public void setFooterDetails(int tabCount, String mop, String remarks, String items, String quantity, String disc, String bill, String total) {
        clickOn(driver, getClk_ModeOfPayment(tabCount));
        clickOn(driver, getSlt_ModeOfPayment(tabCount, mop));
        typeSlow(driver, getTxtbx_Remarks(tabCount), remarks);
        new SalesReturnVerification(driver).getVerifyFooterDetails(tabCount, mop, remarks, items, quantity, disc, bill, total);
        testStepsLog(_logStep++, "Footer details are updated");
    }

    public void setMedicineDetails(int tabCount, int row, String medicine, String batch, String discount, String quantity, String loose, String mrp, String totalAmount) {
        typeSlow(driver, getTxtbx_SearchMedicine(tabCount, row), medicine);
        clickOn(driver, getSlt_SearchMedicine(medicine, row));
        clickOn(driver, getClk_Batch(tabCount, row));
        clickOn(driver, getSlt_Batch(tabCount, batch, row));
        clickOn(driver, getClk_InvoiceInMedicine(tabCount, row));
        clickOn(driver, getSlt_InvoiceInMedicine(row, batch));
        typeSlow(driver, getTxtbx_Quantity(tabCount, row), quantity);
        typeSlow(driver, getTxtbx_Loose(tabCount, row), loose);
        typeSlow(driver, getTxtbx_MRP(tabCount, row), mrp);
    }
}
