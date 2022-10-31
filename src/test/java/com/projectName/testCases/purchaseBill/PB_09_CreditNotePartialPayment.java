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

public class PB_09_CreditNotePartialPayment extends WebDriverInit implements DataConstantsPurchaseBill, Validations {

    HashMap<String, ArrayList<Object>> map = new HashMap<>();

    PurchaseBillTabController purchaseBillTabController = new PurchaseBillTabController(driver);
    PurchaseBillTabVerification purchaseBillTabVerification = new PurchaseBillTabVerification(driver);
    SideMenuController sideMenuController = new SideMenuController(driver);
    PurchaseReturnTabController purchaseReturnTabController = new PurchaseReturnTabController(driver);
    CreditAmountVerification creditAmountVerification = new CreditAmountVerification(driver);
    LoginPageController loginPageController = new LoginPageController(driver);
    PurchaseOrdersTabVerification purchaseOrdersTabVerification = new PurchaseOrdersTabVerification(driver);
    PurchaseOrdersTabController purchaseOrdersTabController = new PurchaseOrdersTabController(driver);
    PurchaseReturnBillWiseTabController purchaseReturnBillWiseTabController = new PurchaseReturnBillWiseTabController(driver);
    CreditNoteController creditNoteController = new CreditNoteController(driver);

    int tabCount;
    String invoice;

    @BeforeClass(alwaysRun = true)
    public void getLogin() {
        testCaseLog("Login");
        loginPageController.getSignin();
    }

    @Test(priority = 8)
    public void getCreatePurchaseInvoice() {
        try {
            testCaseLog("getCreatePurchaseInvoice");

            map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_EB_PURCHASEBILL));

            purchaseOrdersTabController.getDeletePurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0));

            tabCount = sideMenuController.openPurchaseBillTab();

            purchaseBillTabController.getEnterFullPurchaseBillDetails(getData(map, INVOICE_NO, 0), tabCount, sideMenuController, map, getData(map, ORDER_TOTAL_FOOTER, 0));

            purchaseBillTabController.getSaveUpdateClosePurchaseBill(sideMenuController, tabCount, getData(map, UPDATE_DATE, 0), getData(map, MODIFY_INVOICE, 0));
            testStepsLog(_logStep++, "New Purchase Bill is Generated");
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
    public void getCreateExpiryCreditNote() {
        testCaseLog("getCreateExpiryCreditNote");
        map = new HashMap<>();
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_EXPIRY_RETURN));

        purchaseOrdersTabController.getDeletePurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0));

        purchaseReturnBillWiseTabController.getDeletePurchaseReturnInvoice(sideMenuController, getData(map, DISTRIBUTOR_NAME, 0), getData(map, PURCHASE_RETURN_TYPE, 0), getData(map, DATE, 0));

        purchaseReturnTabController.getCreateExpiryCreditNote(sideMenuController, map);
    }

    @Test(dependsOnMethods = {"getCreateExpiryCreditNote"})
    public void getAddPartialCreditNoteToInvoice() {
        testCaseLog("getAddPartialCreditNoteToInvoice");
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_EXPIRY_RETURN));
        tabCount = sideMenuController.openPurchaseBillTab();

        purchaseBillTabController.setDistributorName(tabCount, getData(map, DISTRIBUTOR_NAME, 0));

        purchaseBillTabController.getAddCreditAmount(tabCount);
        creditNoteController.getSelectCreditNotes(tabCount, map);

        Assert.assertTrue(purchaseBillTabVerification.getVerifyCreditNoteAddition(getData(map, CREDIT_TOTAL_AMOUNT_CAPTURED, 0), tabCount), "Credit note is not Added");
        testVerifyLog("Expiry Credit note is added to the purchase Bill");
    }

    @Test(dependsOnMethods = {"getAddPartialCreditNoteToInvoice"})
    public void getCreateInvoiceWithCreditNote() {
        testCaseLog("getCreateInvoiceWithCreditNote");
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_EXPIRY_RETURN));
        invoice = getData(map, INVOICE_NO, 0);

        map = new HashMap<>();
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_EB_PURCHASEBILL));

        purchaseBillTabController.getEnterAndSaveMedicinePurchaseBillDetails(invoice, tabCount, sideMenuController, purchaseBillTabController, map, getData(map, MODIFY_INVOICE, 0), getData(map, RETURN_ORDER_TOTAL_FOOTER, 0));
        testStepsLog(_logStep++, "Purchase bill with Expiry credit note is Generated");

        Assert.assertTrue(purchaseOrdersTabVerification.getVerifyPurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0)));
    }

    @Test(groups = "ExpiryReturn", dependsOnMethods = {"getCreateInvoiceWithCreditNote"})
    public void verifyCreditNoteTracking() {
        testCaseLog("verifyCreditNoteTracking");
        tabCount = sideMenuController.openCreditAmountTracking();

        map = new HashMap<>();
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_EXPIRY_RETURN));

        creditAmountVerification.getCreditAmountCheck(tabCount, map);
        testVerifyLog("Expiry Credit Note is Verified");
    }
}
