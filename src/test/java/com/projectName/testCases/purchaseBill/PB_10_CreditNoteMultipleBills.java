package com.projectName.testCases.purchaseBill;

import com.framework.init.WebDriverInit;
import com.projectName.constants.DataConstantsPurchaseBill;
import com.projectName.constants.Validations;
import com.projectName.pageObjects.common.Controller.LoginPageController;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.projectName.pageObjects.purchaseBill.Controller.*;
import com.projectName.pageObjects.purchaseBill.Verification.CreditAmountVerification;
import com.projectName.pageObjects.purchaseBill.Verification.PurchaseBillTabVerification;
import com.projectName.pageObjects.purchaseBill.Verification.PurchaseOrdersTabVerification;
import erp.auto.testing.projectName.pageObjects.purchaseBill.Controller.*;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class PB_10_CreditNoteMultipleBills extends WebDriverInit implements Validations, DataConstantsPurchaseBill {

    HashMap<String, ArrayList<Object>> map = new HashMap<>();

    PurchaseBillTabController purchaseBillTabController = new PurchaseBillTabController(driver);
    PurchaseBillTabVerification purchaseBillTabVerification = new PurchaseBillTabVerification(driver);
    SideMenuController sideMenuController = new SideMenuController(driver);
    PurchaseReturnTabController purchaseReturnTabController = new PurchaseReturnTabController(driver);
    CreditAmountVerification creditAmountVerification = new CreditAmountVerification(driver);
    LoginPageController loginPageController = new LoginPageController(driver);
    PurchaseOrdersTabVerification purchaseOrdersTabVerification = new PurchaseOrdersTabVerification(driver);
    PurchaseOrdersTabController purchaseOrdersTabController = new PurchaseOrdersTabController(driver);
    CreditNoteController creditNoteController = new CreditNoteController(driver);
    PurchaseReturnBillWiseTabController purchaseReturnBillWiseTabController = new PurchaseReturnBillWiseTabController(driver);

    int tabCount;
    String invoice;

    @BeforeClass(alwaysRun = true)
    public void getLogin() {
        testCaseLog("Login");
        loginPageController.getSignin();
    }

    @Test(priority = 9)
    public void getCreatePurchaseInvoice() {
        try {
            testCaseLog("getCreatePurchaseInvoice");

            map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_MB_PURCHASEBILL));

            purchaseOrdersTabController.getDeletePurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0));

            tabCount = sideMenuController.openPurchaseBillTab();

            purchaseBillTabController.getEnterFullPurchaseBillDetails(getData(map, INVOICE_NO, 0), tabCount, sideMenuController, map, getData(map, ORDER_TOTAL_FOOTER, 0));

            purchaseBillTabController.getSaveUpdateClosePurchaseBill(sideMenuController, tabCount, getData(map, UPDATE_DATE, 0), getData(map, MODIFY_INVOICE, 0));
            testStepsLog(_logStep++, "Purchase Invoice is created");
            sideMenuController.closeCurrentTab(tabCount);

            Assert.assertTrue(purchaseOrdersTabVerification.getVerifyPurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0)));

        } catch (ElementClickInterceptedException e) {
            if (sideMenuController.getCheckBackUpPopUp()) {
                testWarningLog("Backup interrupted the Testing");
            }
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = "getCreatePurchaseInvoice")
    public void getCreateMultipleCreditNotes() {
        testCaseLog("getCreateMultipleCreditNotes");
        map = new HashMap<>();
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_MULTIPLEBILLS));

        purchaseOrdersTabController.getDeletePurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0));
        purchaseReturnBillWiseTabController.getDeletePurchaseReturnInvoice(sideMenuController, getData(map, DISTRIBUTOR_NAME, 0), getData(map, PURCHASE_RETURN_TYPE, 0), getData(map, DATE, 0));

        purchaseReturnTabController.getCreateSellableCreditNote(sideMenuController, map);
        purchaseReturnTabController.getCreateSellableCreditNote(sideMenuController, map);
    }

    @Test(dependsOnMethods = {"getCreateMultipleCreditNotes"})
    public void getAddMultipleCreditNotesToInvoice() {
        testCaseLog("getAddMultipleCreditNotesToInvoice");
        tabCount = sideMenuController.openPurchaseBillTab();
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_MULTIPLEBILLS));
        purchaseBillTabController.setDistributorName(tabCount, getData(map, DISTRIBUTOR_NAME, 0));

        purchaseBillTabController.getAddCreditAmount(tabCount);
        creditNoteController.getSelectCreditNotes(tabCount, map);

        Assert.assertTrue(purchaseBillTabVerification.getVerifyCreditNoteAddition(getData(map, CREDIT_TOTAL_AMOUNT_CAPTURED, 0), tabCount), "Credit note is not Added");
        testVerifyLog("Multiple Credit notes are added to the purchase Bill");

        invoice = getData(map, INVOICE_NO, 0);

        map = new HashMap<>();
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_MB_PURCHASEBILL));

        purchaseBillTabController.getEnterAndSaveMedicinePurchaseBillDetails(invoice, tabCount, sideMenuController, purchaseBillTabController, map, getData(map, MODIFY_INVOICE, 0), getData(map, RETURN_ORDER_TOTAL_FOOTER, 0));
        testVerifyLog("Purchase bill with Multiple credit notes is Generated");
    }

    @Test(dependsOnMethods = {"getAddMultipleCreditNotesToInvoice"})
    public void getCreateInvoiceWithMultipleCreditNotes() {
        testCaseLog("getCreateInvoiceWithMultipleCreditNotes");
        map = new HashMap<>();
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_MULTIPLEBILLS));

        Assert.assertTrue(purchaseOrdersTabVerification.getVerifyPurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0)));
    }

    @Test(dependsOnMethods = {"getCreateInvoiceWithMultipleCreditNotes"})
    public void verifyMultipleCreditNoteTracking() {
        testCaseLog("verifyMultipleCreditNoteTracking");
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_MULTIPLEBILLS));
        tabCount = sideMenuController.openCreditAmountTracking();

        creditAmountVerification.getCreditAmountCheck(tabCount, map);
        testVerifyLog("Multiple Credit Notes and the statuses are Verified");
    }
}
