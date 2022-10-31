package com.projectName.pageObjects.purchaseBill.Controller;

import com.projectName.constants.DataConstantsPurchaseBill;
import com.projectName.constants.Validations;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import erp.auto.testing.projectName.constants.*;
import com.projectName.pageObjects.purchaseBill.Verification.PurchaseReturnTabVerification;
import com.framework.init.AbstractPage;
import com.framework.utils.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;

public class PurchaseReturnTabController extends AbstractPage implements Configuration, Validations, DataConstantsPurchaseBill {

    PurchaseReturnTabVerification purchaseReturnTabVerification = new PurchaseReturnTabVerification(driver);
    //Header Details
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

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public PurchaseReturnTabController(WebDriver driver) {
        super(driver);
    }


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

    private WebElement getClk_TypeList(int tabCount) {
        clk_TypeList = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div//button[@title='damage return']"));
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

    private WebElement getClk_Batch(int tabCount, int rowCount) {
        clk_Batch = driver.findElement(By.xpath("(//tbody[@id='returntableBody']/tr/td[input[@tab='tabCon_" + tabCount + "']]/div/button)[" + rowCount + "]"));
        return clk_Batch;
    }

    private WebElement getSlt_BatchList(String batch, int tabCount) {
        slt_BatchList = driver.findElement(By.xpath("//tbody[@id='returntableBody']//td[input[@tab='tabCon_" + tabCount + "']]//span[contains(text(),'" + batch + "')]"));
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

    private WebElement getBtn_Save(int tabCount) {
        btn_Save = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//button[text()='Save [F10]']"));
        return btn_Save;
    }

    private WebElement getBtn_SaveAndPrint(int tabCount) {
        btn_SaveAndPrint = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//button[text()='Save & Print [F11]']"));
        return btn_SaveAndPrint;
    }

    public boolean setSellableHeaderDetails(int tabCount, String returnType, String distributor, boolean tcs, boolean CDandSch, boolean editCDValue, boolean CDPerc, boolean GST) {
        getExplicitWait(driver, getTxtbx_SearchDistributor(tabCount), EXPLICIT_WAIT);
        typeSlow(driver, getTxtbx_SearchDistributor(tabCount), distributor);
        clickOn(driver, getSlt_Distributor(distributor));
        isTCS(tcs, tabCount);
        isCDAndSch(CDandSch, tabCount);
        isEditCDValue(editCDValue, tabCount);
        isCDPerc(CDPerc, tabCount);
        isGST(GST, tabCount);
        SetReturnType(returnType.toLowerCase(), tabCount);
        purchaseReturnTabVerification.verifyPurchaseReturnHeader(tabCount, distributor, returnType);
        return true;
    }

    public boolean setExpiryHeaderDetails(int tabCount, String returnType, String distributor, boolean tcs, boolean CDandSch, boolean editCDValue, boolean CDPerc, boolean GST, String deduction) {
        pause(1);
        typeSlow(driver, getTxtbx_SearchDistributor(tabCount), distributor);
        clickOn(driver, getSlt_Distributor(distributor));
        SetReturnType(returnType.toLowerCase(), tabCount);
        setDeductionPercentage(tabCount, deduction);
        isTCS(tcs, tabCount);
        isCDAndSch(CDandSch, tabCount);
        isEditCDValue(editCDValue, tabCount);
        isCDPerc(CDPerc, tabCount);
        isGST(GST, tabCount);
        testStepsLog(_logStep++, "Purchase Return Header details are entered");
        purchaseReturnTabVerification.verifyPurchaseReturnHeader(tabCount, distributor, returnType);
        return true;
    }

    public void SetReturnType(String returnType, int tabCount) {
        clickOn(driver, getClk_TypeList(tabCount));
        clickOn(driver, getSlt_TypeList(tabCount, returnType));
    }

    public void isTCS(boolean check, int tabCount) {
        if (check) {
            clickOn(driver, getChkbx_TCS(tabCount));
        }
    }

    public void isCDAndSch(boolean check, int tabCount) {
        if (!check) {
            clickOn(driver, getChkbx_CDandSch(tabCount));
        }
    }

    public void isEditCDValue(boolean check, int tabCount) {
        if (check) {
            clickOn(driver, getChkbx_EditCDValue(tabCount));
        }
    }

    public void isCDPerc(boolean check, int tabCount) {
        if (check) {
            clickOn(driver, getChkbx_CDPerc(tabCount));
        }
    }

    public void setDeductionPercentage(int tabCount, String deduction) {
        type(getTxtbx_DeductionPerc(tabCount), deduction);
    }

    public void isGST(boolean check, int tabCount) {
        if (!check) {
            clickOn(driver, getChkbx_GST(tabCount));
        }
    }

    public boolean setMedicineDetails(int tabCount, int row, String medicine, String batch, String barcode,
                                      String invoice, String quantity, String free, String loose, String rate) {
        pause(2);
        typeSlow(driver, getTxtbx_SearchMedicine(tabCount, row), medicine);
        pause(1);
        clickOn(driver, getSlt_SearchMedicine(medicine, 1));
        clickOn(driver, getClk_Batch(tabCount, row));
        clickOn(driver, getSlt_BatchList(batch, tabCount));
        clickOn(driver, getClk_Invoice(tabCount, row));
        clickOn(driver, getSlt_Invoice(tabCount, invoice, row));
        typeSlow(driver, getTxtbx_Quantity(tabCount, row), quantity);
        try {
            typeSlow(driver, getTxtbx_Loose(tabCount, row), loose);
        } catch (Exception ignored) {
        }
        try {
            typeSlow(driver, getTxtbx_Free(tabCount, row), free);
        } catch (Exception ignored) {
        }
        typeSlow(driver, getTxtbx_Rate(tabCount, row), rate);
        click(tabCount);
        return true;
    }

    public void click(int tabCount) {
        clickOn(driver, getTxtbx_SearchMedicine(tabCount, 1));
    }

    public boolean setRemarks(int tabCount, String remarks) {
        type(getTxtbx_Remarks(tabCount), remarks);
        return true;
    }

    public void getClickSave(int tabCount) {
        clickOn(driver, getBtn_Save(tabCount));
    }

    public void getClinkSaveAndPrint(int tabCount) {
        clickOn(driver, getBtn_SaveAndPrint(tabCount));
    }

    public void clickAddDetailsButton(int tabCount) {
        clickOn(driver, getBtn_AddDetails(tabCount));
    }

    public void getCreateSellableCreditNote(SideMenuController sideMenuController, HashMap<String, ArrayList<Object>> map) {
        int tabCount = sideMenuController.openPurchaseReturns();

        if (setSellableHeaderDetails(tabCount, getData(map, PURCHASE_RETURN_TYPE, 0), getData(map, DISTRIBUTOR_NAME, 0), isBoolean(getData(map, TCS_PERC, 0)),
                isBoolean(getData(map, CD_SCH, 0)), isBoolean(getData(map, EDIT_CD_VALUE, 0)), isBoolean(getData(map, CD_PERC, 0)),
                isBoolean(getData(map, GST, 0)))) {
            testStepsLog(_logStep++, "Purchase Return Header details are entered");
        }
        int quantity = 0;
        for (int i = 1; i <= map.get(MEDICINE_NAME).size(); i++) {
            setMedicineDetails(tabCount, i, getData(map, MEDICINE_NAME, i - 1), getData(map, BATCH, i - 1), getData(map, BARCODE, i - 1), getData(map, RETURN_INVOICE_NO, i - 1),
                    getData(map, QUANTITY, i - 1), getData(map, FREE_QUANTITY, i - 1), getData(map, LOOSE_QUANTITY, i - 1), getData(map, RATE, i - 1));
            purchaseReturnTabVerification.verifyMedicineDetails(tabCount, i, getData(map, MEDICINE_NAME, i - 1), getData(map, BATCH, i - 1), getData(map, BARCODE, i - 1),
                    getData(map, QUANTITY, i - 1), getData(map, LOOSE, i - 1), getData(map, FREE_QUANTITY, i - 1), getData(map, RATE, i - 1),
                    getData(map, CD_RUPEES, i - 1), getData(map, SCHEME, i - 1), getData(map, NET_GST, i - 1), getData(map, MEDICINE_TOTAL, i - 1));
            quantity = quantity + Integer.parseInt(getData(map, QUANTITY, i - 1));
            if (i != (map.get(MEDICINE_NAME).size())) {
                clickAddDetailsButton(tabCount);
            }
        }
        testStepsLog(_logStep++, "Purchase Return Medicine details are entered");
        testVerifyLog("Medicine Details are Verified.");

        setRemarks(tabCount, getData(map, PURCHASE_RETURN_REMARKS, 0));
        purchaseReturnTabVerification.verifyFooterDetails(tabCount, getData(map, PURCHASE_RETURN_REMARKS, 0), getData(map, FOOTER_GST, 0), getData(map, FOOTER_MRP, 0),
                getData(map, FOOTER_COST_VALUE, 0), String.valueOf(map.get(MEDICINE_NAME).size()), String.valueOf(quantity), getData(map, TOTAL_AMOUNT, 0));

        getClickSave(tabCount);

        getAlertCheck(sideMenuController.getAlertMessage());

        testVerifyLog("Sellable Credit Note is created");

        sideMenuController.closeCurrentTab(tabCount);
    }

    public void getCreateExpiryCreditNote(SideMenuController sideMenuController, HashMap<String, ArrayList<Object>> map) {
        int tabCount = sideMenuController.openPurchaseReturns();

        setExpiryHeaderDetails(tabCount, getData(map, PURCHASE_RETURN_TYPE, 0), getData(map, DISTRIBUTOR_NAME, 0), isBoolean(getData(map, TCS_PERC, 0)),
                isBoolean(getData(map, CD_SCH, 0)), isBoolean(getData(map, EDIT_CD_VALUE, 0)), isBoolean(getData(map, CD_PERC, 0)),
                isBoolean(getData(map, GST, 0)), getData(map, DEDUCTION_PERCENTAGE, 0));
        int quantity = 0;
        for (int i = 1; i <= map.get(MEDICINE_NAME).size(); i++) {
            setMedicineDetails(tabCount, i, getData(map, MEDICINE_NAME, i - 1), getData(map, BATCH, i - 1), getData(map, BARCODE, i - 1), getData(map, RETURN_INVOICE_NO, i - 1),
                    getData(map, QUANTITY, i - 1), getData(map, FREE_QUANTITY, i - 1), getData(map, LOOSE_QUANTITY, i - 1), getData(map, RATE, i - 1));
            quantity = quantity + Integer.parseInt(getData(map, QUANTITY, i - 1));
            purchaseReturnTabVerification.verifyMedicineDetails(tabCount, i, getData(map, MEDICINE_NAME, i - 1), getData(map, BATCH, i - 1), getData(map, BARCODE, i - 1),
                    getData(map, QUANTITY, i - 1), getData(map, LOOSE, i - 1), getData(map, FREE_QUANTITY, i - 1), getData(map, RATE, i - 1),
                    getData(map, CD_RUPEES, i - 1), getData(map, SCHEME, i - 1), getData(map, NET_GST, i - 1), getData(map, MEDICINE_TOTAL, i - 1));
            if (i != (map.get(MEDICINE_NAME).size())) {
                clickAddDetailsButton(tabCount);
            }
        }
        testStepsLog(_logStep++, "Purchase Return Medicine details are entered");
        testVerifyLog("Medicine Details are Verified.");
        setRemarks(tabCount, getData(map, PURCHASE_RETURN_REMARKS, 0));
        purchaseReturnTabVerification.verifyFooterDetails(tabCount, getData(map, PURCHASE_RETURN_REMARKS, 0), getData(map, FOOTER_GST, 0), getData(map, FOOTER_MRP, 0),
                getData(map, FOOTER_COST_VALUE, 0), String.valueOf(map.get(MEDICINE_NAME).size()), String.valueOf(quantity), getData(map, TOTAL_AMOUNT, 0));

        getClickSave(tabCount);

        getAlertCheck(sideMenuController.getAlertMessage());
        testVerifyLog("Expiry Credit Note is created");

        sideMenuController.closeCurrentTab(tabCount);
    }

    public boolean isBoolean(String value) {
        return value.equalsIgnoreCase("yes");
    }

}
