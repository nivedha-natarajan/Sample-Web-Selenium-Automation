package com.projectName.testCases.purchaseBill;

import com.projectName.constants.DataConstantsPurchaseBill;
import com.projectName.constants.Validations;
import com.projectName.pageObjects.common.Controller.LoginPageController;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.projectName.pageObjects.purchaseBill.Controller.AddDistriutorTabController;
import com.projectName.pageObjects.purchaseBill.Controller.DistributorsTabController;
import com.projectName.pageObjects.purchaseBill.Controller.PurchaseBillTabController;
import com.projectName.pageObjects.purchaseBill.Controller.PurchaseOrdersTabController;
import erp.auto.testing.projectName.pageObjects.purchaseBill.Controller.*;
import com.projectName.pageObjects.purchaseBill.Verification.PurchaseBillTabVerification;
import com.projectName.pageObjects.purchaseBill.Verification.PurchaseOrdersTabVerification;
import com.framework.init.WebDriverInit;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class PB_01_ValidatePurchaseBill extends WebDriverInit implements DataConstantsPurchaseBill, Validations {

    HashMap<String, ArrayList<Object>> map = new HashMap<>();

    PurchaseBillTabController purchaseBillTabController = new PurchaseBillTabController(driver);
    PurchaseBillTabVerification purchaseBillTabVerification = new PurchaseBillTabVerification(driver);
    SideMenuController sideMenuController = new SideMenuController(driver);
    LoginPageController loginPageController = new LoginPageController(driver);
    AddDistriutorTabController addDistriutorTabController = new AddDistriutorTabController(driver);

    DistributorsTabController distributorsTabController = new DistributorsTabController(driver);
    PurchaseOrdersTabController purchaseOrdersTabController = new PurchaseOrdersTabController(driver);
    PurchaseOrdersTabVerification purchaseOrdersTabVerification = new PurchaseOrdersTabVerification(driver);

    int tabCount;

    @BeforeClass(alwaysRun = true)
    public void getLogin() {
        testCaseLog("Login");
        loginPageController.getSignin();
    }

    @Test
    public void createPurchaseBill() {
        try {
            testCaseLog("createPurchaseBill");
            map.putAll(getTestDataWorkbook(DATA_VALIDATE_PURCHASEBILL));

            purchaseOrdersTabController.getDeletePurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0));
            distributorsTabController.getDeleteDistributor(sideMenuController, getData(map, DISTRIBUTOR_NAME, 0));

            tabCount = sideMenuController.openPurchaseBillTab();

            String distributorName = getData(map, DISTRIBUTOR_NAME, 0);
            if (purchaseBillTabController.setDistributorName(tabCount, distributorName)) {
                addDistriutorTabController.getAddDistributorName(tabCount, distributorName);
                Assert.assertTrue(sideMenuController.checkAlertMessage(ALERT_DISTRIBUTOR_SAVE_SUCCESS), "Not Saved");
                testStepsLog(_logStep++, distributorName + " - New Distributor is Added");
                purchaseBillTabController.click(tabCount);
                pause(3);
            }
            testStepsLog(_logStep++, distributorName + " - Distributor Name is Entered");

            String invoiceNo = getData(map, INVOICE_NO, 0);
            purchaseBillTabController.setInvoiceNo(tabCount, invoiceNo);
            testStepsLog(_logStep++, invoiceNo + " - Invoice no is Entered");

            String extraDiscount = getData(map, EXTRA_DISC, 0);
            purchaseBillTabController.setExtraDiscount(tabCount, extraDiscount);
            testStepsLog(_logStep++, extraDiscount + " - Extra Discount is Entered");

            purchaseBillTabVerification.getVerifyOrderTotal(tabCount, getData(map, EXTRA_DISC_ORDER_FOOTER, 0));
            testValidationLog("Extra Discount for Entire Bill is Applied");

            String cdPercHeader = getData(map, CD_PERC_HEADER, 0);
            purchaseBillTabController.setCDPercHeader(tabCount, cdPercHeader);
            testStepsLog(_logStep++, cdPercHeader + " - Cash Discount is Entered");

            purchaseBillTabVerification.getVerifyCDPercentage(tabCount, 1, getData(map, CD_PERC_HEADER, 0));
            testValidationLog("CD is applied for the entire bill");

            String medName = getData(map, MEDICINE_NAME, 0);
            purchaseBillTabController.setMedicineName(tabCount, 1, medName);
            testStepsLog(_logStep++, medName + " - Medicine Name is Entered");

            purchaseBillTabController.getEnableBarcode(tabCount);
            testStepsLog(_logStep++, "Barcode checkbox is Enabled");

            String barcode = getData(map, BARCODE, 0);
            purchaseBillTabController.setBarcode(tabCount, 1, barcode);
            testStepsLog(_logStep++, barcode + " - Barcode is Entered");

            String batch = getData(map, BATCH, 0);
            purchaseBillTabController.setBatch(tabCount, 1, batch);
            testStepsLog(_logStep++, batch + " - New Batch is Entered");

            String expiry = getData(map, EXPIRY, 0);
            purchaseBillTabController.setExpiry(tabCount, 1, expiry);
            testStepsLog(_logStep++, expiry + " - Expiry Date is Entered");

            String rate = getData(map, RATE_CP, 0);
            purchaseBillTabController.setRate(tabCount, 1, rate);
            testStepsLog(_logStep++, rate + " - Rate is Entered");

            String mrp = getData(map, MRP_SP, 0);
            purchaseBillTabController.setMRP(tabCount, 1, mrp);
            testStepsLog(_logStep++, mrp + " - MRP is Entered");

            String quantity = getData(map, QUANTITY, 0);
            purchaseBillTabController.setQuantity(tabCount, 1, quantity);
            testStepsLog(_logStep++, quantity + " - Quantity is Entered");

            String freeQuantity = getData(map, FREE_QUANTITY, 0);
            purchaseBillTabController.setFreeQuantity(tabCount, 1, freeQuantity);
            testStepsLog(_logStep++, freeQuantity + " - Free Quantity is Entered");

            String cgst = getData(map, CGST, 0);
            purchaseBillTabController.setCGST(tabCount, 1, cgst);
            testStepsLog(_logStep++, cgst + " - CGST is Entered");

            String cdPerc = getData(map, CD_PERCENTAGE, 0);
            purchaseBillTabController.setCDperc(tabCount, 1, cdPerc);
            testStepsLog(_logStep++, cdPerc + " - CD Percentage for individual medicine is Entered");

            String schCash = getData(map, SCHEME_RUPEES, 0);
            purchaseBillTabController.setSchemeCash(tabCount, 1, schCash);
            testStepsLog(_logStep++, schCash + " - Scheme Rupees is Entered");

            String schPerc = getData(map, SCHEME_PERCENTAGE, 0);
            purchaseBillTabController.setSchemePerc(tabCount, 1, schPerc);
            testStepsLog(_logStep++, schPerc + " - Scheme Percentage is Entered");

        } catch (ElementClickInterceptedException e) {
            if (sideMenuController.getCheckBackUpPopUp())
                testWarningLog("Backup interrupted the test execution");
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"createPurchaseBill"})
    public void verifyNewDistributorName() {
        testCaseLog("verifyNewDistributorName");

        String distributorName = getData(map, DISTRIBUTOR_NAME, 0);
        purchaseBillTabVerification.getVerifyDistributorName(tabCount, distributorName);
        testValidationLog(distributorName + " - Distributor Name is Verified");
    }

    @Test(dependsOnMethods = {"verifyNewDistributorName"})
    public void verifyInvoiceNo() {
        testCaseLog("verifyInvoiceNo");
        String invoiceNo = getData(map, INVOICE_NO, 0);
        purchaseBillTabVerification.getVerifyInvoiceNo(tabCount, invoiceNo);
        testValidationLog(invoiceNo + " - Invoice no is Verified");
    }

    @Test(dependsOnMethods = {"verifyInvoiceNo"})
    public void verifyInvoiceDate() {
        testCaseLog("verifyInvoiceDate");
        String invoiceDate = getCurrentDate();
        purchaseBillTabVerification.getVerifyInvoiceDate(tabCount, invoiceDate);
        testValidationLog(invoiceDate + " - Current Date is Verified");
    }

    @Test(dependsOnMethods = {"verifyInvoiceDate"})
    public void verifyExtraDiscount() {
        testCaseLog("verifyExtraDiscount");
        String extraDiscount = getData(map, EXTRA_DISC, 0);
        purchaseBillTabVerification.getVerifyExtraDiscount(tabCount, extraDiscount);
        testValidationLog(extraDiscount + " - Extra Discount is Verified");
    }

    @Test(dependsOnMethods = {"verifyExtraDiscount"})
    public void verifyCashDiscountHeader() {
        testCaseLog("verifyCashDiscountHeader");
        String cdPercHeader = getData(map, CD_PERC_HEADER, 0);
        purchaseBillTabVerification.getVerifyCDPercHeader(tabCount, cdPercHeader);
        testValidationLog(cdPercHeader + " - Cash Discount is Verified");
    }

    @Test(dependsOnMethods = {"verifyCashDiscountHeader"})
    public void enableBarcodeCheckbox() {
        testCaseLog("enableBarcodeCheckbox");
        purchaseBillTabVerification.getVerifyBarcodeTextBox(tabCount, 1);
        testValidationLog("Barcode textbox is Enable and Verified");
    }

    @Test(dependsOnMethods = {"enableBarcodeCheckbox"})
    public void verifyMedicineName() {
        testCaseLog("verifyMedicineName");
        String medName = getData(map, MEDICINE_NAME, 0);
        purchaseBillTabVerification.getVerifyMedicineName(tabCount, 1, medName);
        testValidationLog(medName + " - Medicine Name is Verified");
    }

    @Test(dependsOnMethods = {"verifyMedicineName"})
    public void verifyBarcodeValue() {
        testCaseLog("verifyBarcodeValue");
        String barcode = getData(map, BARCODE, 0);
        purchaseBillTabVerification.getVerifyBarcode(tabCount, 1, barcode);
        testValidationLog(barcode + " - Barcode is Verified");
    }

    @Test(dependsOnMethods = {"verifyBarcodeValue"})
    public void verifyBatch() {
        testCaseLog("verifyBatch");
        String batch = getData(map, BATCH, 0);
        purchaseBillTabVerification.getVerifyBatch(tabCount, 1, batch);
        testValidationLog(batch + " - New Batch is Verified");
    }

    @Test(dependsOnMethods = {"verifyBatch"})
    public void verifyExpiry() {
        testCaseLog("verifyExpiry");
        String expiry = getData(map, EXPIRY, 0);
        purchaseBillTabVerification.getVerifyExpiry(tabCount, 1, expiry);
        testValidationLog(expiry + " - Expiry Date is Verified");
    }

    @Test(dependsOnMethods = {"verifyExpiry"})
    public void verifyRate() {
        testCaseLog("verifyRate");
        String rate = getData(map, RATE_CP, 0);
        purchaseBillTabVerification.getVerifyRate(tabCount, 1, rate);
        testValidationLog(rate + " - Rate is Verified");
    }

    @Test(dependsOnMethods = {"verifyRate"})
    public void verifyMRP() {
        testCaseLog("verifyMRP");
        String mrp = getData(map, MRP_SP, 0);
        purchaseBillTabVerification.getVerifyMRP(tabCount, 1, mrp);
        testValidationLog(mrp + " - MRP is Verified");
    }

    @Test(dependsOnMethods = {"verifyMRP"})
    public void verifyQuantity() {
        testCaseLog("verifyQuantity");
        String quantity = getData(map, QUANTITY, 0);
        purchaseBillTabVerification.getVerifyQuantity(tabCount, 1, quantity);
        testValidationLog(quantity + " - Quantity is Verified");
    }

    @Test(dependsOnMethods = {"verifyQuantity"})
    public void verifyFreeQuantity() {
        testCaseLog("verifyFreeQuantity");
        String freeQuantity = getData(map, FREE_QUANTITY, 0);
        purchaseBillTabVerification.getVerifyFreeQuantity(tabCount, 1, freeQuantity);
        testValidationLog(freeQuantity + " - Free Quantity is Verified");
    }

    @Test(dependsOnMethods = {"verifyFreeQuantity"})
    public void verifyCGST() {
        testCaseLog("verifyCGST");
        String cgst = getData(map, CGST, 0);
        purchaseBillTabVerification.getVerifyGST(tabCount, 1, cgst);
        testValidationLog(cgst + " - CGST is Verified and SGST AutoPopulated is verified");
    }

    @Test(dependsOnMethods = {"verifyCGST"})
    public void verifyCDperc() {
        testCaseLog("verifyCDperc");
        String cdPerc = getData(map, CD_PERCENTAGE, 0);
        purchaseBillTabVerification.getVerifyCDperc(tabCount, 1, cdPerc);
        testValidationLog(cdPerc + " - CD Percentage for individual medicine is Verified");
    }

    @Test(dependsOnMethods = {"verifyCDperc"})
    public void verifySchemeCash() {
        testCaseLog("verifySchemeCash");
        String schCash = getData(map, SCHEME_RUPEES, 0);
        purchaseBillTabVerification.getVerifySchemeCash(tabCount, 1, schCash);
        testValidationLog(schCash + " - Scheme Rupees is Verified");
    }

    @Test(dependsOnMethods = {"verifySchemeCash"})
    public void verifySchemePerc() {
        testCaseLog("verifySchemePerc");
        String schPerc = getData(map, SCHEME_PERCENTAGE, 0);
        purchaseBillTabVerification.getVerifySchemePerc(tabCount, 1, schPerc);
        testValidationLog(schPerc + " - Scheme Percentage is Verified");
    }

    @Test(dependsOnMethods = {"verifySchemePerc"})
    public void verifyNet() {
        testCaseLog("verifyNet");
        purchaseBillTabController.getIndividualNetValue(tabCount, 1, getData(map, NET_TOTAL, 0));
        testValidationLog("Net Total is Verified");
    }

    @Test(dependsOnMethods = {"verifyNet"})
    public void verifySchemeFooter() {
        testCaseLog("verifySchemeFooter");
        purchaseBillTabVerification.getVerifySchemeFooter(tabCount, getData(map, SCHEME_FOOTER, 0));
        testValidationLog("Scheme Footer is Verified");
    }

    @Test(dependsOnMethods = {"verifySchemeFooter"})
    public void VerifyCashDiscountFooter() {
        testCaseLog("verifyCashDiscountFooter");
        purchaseBillTabVerification.getVerifyCDFooter(tabCount, getData(map, CD_FOOTER, 0));
        testValidationLog("Cash Discount is Verified");
    }

    @Test(dependsOnMethods = {"VerifyCashDiscountFooter"})
    public void verifyTaxTotal() {
        testCaseLog("verifyTaxTotal");
        purchaseBillTabVerification.getVerifyTaxTotal(tabCount, getData(map, TOTAL_TAX_FOOTER, 0));
        testValidationLog("Tax Total is Verified");
    }

    @Test(dependsOnMethods = {"verifyTaxTotal"})
    public void verifyGrossTotal() {
        testCaseLog("verifyGrossTotal");
        purchaseBillTabVerification.getVerifyGrossTotal(tabCount, getData(map, GROSS_TOTAL_FOOTER, 0));
        testValidationLog("Gross Total is Verified");
    }

    @Test(dependsOnMethods = {"verifyGrossTotal"})
    public void verifyOrderTotal() {
        testCaseLog("verifyOrderTotal");
        purchaseBillTabVerification.getVerifyOrderTotal(tabCount, getData(map, ORDER_TOTAL_FOOTER, 0));
        testValidationLog("Order total is Verified");
    }

    @Test(dependsOnMethods = {"verifyOrderTotal"})
    public void verifyCashDiscountRupeesHeader() {
        testCaseLog("verifyCashDiscountRupeesHeader");
        purchaseBillTabController.getChangeCDRupeesHeaderCheckBox(tabCount);
        purchaseBillTabController.setCDRupeesHeader(tabCount, getData(map, CD_RUPEES_HEADER, 0));
        testStepsLog(_logStep++, "Cash Discount for Entire Bill is Entered");
        testValidationLog("Cash Discount for Entire Bill is Entered");
    }

    @Test(dependsOnMethods = {"verifyCashDiscountRupeesHeader"})
    public void verifyCashDiscountCombinedPercHeader() {
        testCaseLog("verifyCashDiscountCombinedPercHeader");
        purchaseBillTabController.getChangeCDRupeesHeaderCheckBox(tabCount);
        purchaseBillTabVerification.getVerifyCDPercHeader(tabCount, getData(map, CD_PERC_RUPEES_HEADER, 0));
        testStepsLog(_logStep++, "Cash Discount Percentage and Rupees is Combined and applied for Entire Bill");
        purchaseBillTabVerification.getVerifyCDPercentage(tabCount, 1, getData(map, CD_PERC_RUPEES_HEADER, 0));
        testValidationLog("Cash Discount Percentage and Rupees is Combined and applied for medicine");
    }

    @Test(dependsOnMethods = {"verifyCashDiscountCombinedPercHeader"})
    public void verifyCashDiscountCombinedPerc() {
        testCaseLog("verifyCashDiscountCombinedPerc");
        purchaseBillTabController.getChangeCDRupeesHeaderCheckBox(tabCount);
        purchaseBillTabController.setCDRupees(tabCount, 1, getData(map, CD_PERCENTAGE, 0));
        testStepsLog(_logStep++, "Cash Discount Rupees is Entered for the Medicine");
        purchaseBillTabController.getChangeCDRupeesHeaderCheckBox(tabCount);
        purchaseBillTabVerification.getVerifyCDPercentage(tabCount, 1, getData(map, CD_RUPEES, 0));
        testValidationLog("Cash Discount Percentage is verified for the Medicine");
    }

    @Test(dependsOnMethods = {"verifyCashDiscountCombinedPerc"})
    public void getUpdateExpiry() {
        testCaseLog("getUpdateExpiry");
        purchaseBillTabController.clickGenerateBarcode(tabCount);

        purchaseBillTabController.getUpdateExpiry(getData(map, UPDATE_DATE, 0));
        testValidationLog("Expiry date is Updated");
    }

    @Test(dependsOnMethods = {"getUpdateExpiry"})
    public void getCreatePBWithSingleMedicine() {
        testCaseLog("getCreatePBWithSingleMedicine");
        purchaseBillTabController.clickGenerateBarcode(tabCount);
        testStepsLog(_logStep++, "Purchase Bill is successfully generated");
        testValidationLog("Purchase Bill is successfully generated");
    }

    @Test(groups = "ValidatePurchaseBill", dependsOnMethods = {"getCreatePBWithSingleMedicine"})
    public void getUpdateInvoice() {
        testCaseLog("getUpdateInvoice");
        purchaseBillTabController.getModifyUpdateInvoice(getData(map, MODIFY_INVOICE, 0));
        testValidationLog("Modify Invoice is cancelled");
    }

    @Test(dependsOnMethods = {"getUpdateInvoice"})
    public void getVerifyPurchaseBillInPurchaseOrder() {
        testCaseLog("getVerifyPurchaseBillInPurchaseOrder");
        purchaseOrdersTabVerification.getVerifyPurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0));
        testValidationLog("Purchase Bill is available in Purchases Order");
    }
}
