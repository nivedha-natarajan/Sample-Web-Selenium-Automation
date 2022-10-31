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

public class PB_08_CreditNoteFullPayment extends WebDriverInit implements DataConstantsPurchaseBill, Validations {

    HashMap<String, ArrayList<Object>> map = new HashMap<>();

    CreditAmountVerification creditAmountVerification = new CreditAmountVerification(driver);
    PurchaseBillTabController purchaseBillTabController = new PurchaseBillTabController(driver);
    PurchaseBillTabVerification purchaseBillTabVerification = new PurchaseBillTabVerification(driver);
    SideMenuController sideMenuController = new SideMenuController(driver);
    PurchaseReturnTabController purchaseReturnTabController = new PurchaseReturnTabController(driver);
    LoginPageController loginPageController = new LoginPageController(driver);
    CreditNoteController creditNoteController = new CreditNoteController(driver);
    PurchaseOrdersTabVerification purchaseOrdersTabVerification = new PurchaseOrdersTabVerification(driver);
    PurchaseOrdersTabController purchaseOrdersTabController = new PurchaseOrdersTabController(driver);
    PurchaseReturnBillWiseTabController purchaseReturnBillWiseTabController = new PurchaseReturnBillWiseTabController(driver);

    int tabCount;
    String invoice;

    @BeforeClass(alwaysRun = true)
    public void getLogin() {
        testCaseLog("Login");
        loginPageController.getSignin();
    }

    @Test(priority = 7, dependsOnGroups = {"CreatePurchaseBill"})
    public void getCreateCreditNote() {
        try {
            testCaseLog("getCreateCreditNote");

            map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_FULLPAYMENT));

            purchaseOrdersTabController.getDeletePurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0));
            purchaseReturnBillWiseTabController.getDeletePurchaseReturnInvoice(sideMenuController, getData(map, DISTRIBUTOR_NAME, 0), getData(map, PURCHASE_RETURN_TYPE, 0), getData(map, DATE, 0));

            invoice = getData(map, INVOICE_NO, 0);

            purchaseReturnTabController.getCreateSellableCreditNote(sideMenuController, map);
        } catch (ElementClickInterceptedException e) {
            if (sideMenuController.getCheckBackUpPopUp()) {
                testStepsLog(_logStep++, "Backup interrupted the Testing");
            }
            throw (e);
        }
    }

    @Test(dependsOnMethods = {"getCreateCreditNote"})
    public void getAddCreditNoteToInvoice() {
        testCaseLog("getAddCreditNoteToInvoice");
        tabCount = sideMenuController.openPurchaseBillTab();
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_FULLPAYMENT));
        purchaseBillTabController.setDistributorName(tabCount, getData(map, DISTRIBUTOR_NAME, 0));

        purchaseBillTabController.getAddCreditAmount(tabCount);
        creditNoteController.getSelectCreditNotes(tabCount, map);

        if (purchaseBillTabVerification.getVerifyCreditNoteAddition(getData(map, CREDIT_TOTAL_AMOUNT_CAPTURED, 0), tabCount)) {
            testVerifyLog("Credit note is added to the purchase Bill");
        } else {
            purchaseBillTabController.getAddCreditAmount(tabCount);
            creditNoteController.getSelectCreditNotes(tabCount, map);
        }
        map = new HashMap<>();
        map.putAll(getTestDataWorkbook(DATA_CREATE_PURCHASEBILL));

        purchaseBillTabController.getEnterAndSaveMedicinePurchaseBillDetails(invoice, tabCount, sideMenuController, purchaseBillTabController, map, getData(map, MODIFY_INVOICE, 0), getData(map, RETURN_ORDER_TOTAL_FOOTER, 0));
        testStepsLog(_logStep++, "Purchase bill with credit note is Generated");
    }

    @Test(dependsOnMethods = {"getAddCreditNoteToInvoice"})
    public void getCreateInvoiceWithCreditNote() {
        testCaseLog("getCreateInvoiceWithCreditNote");

        map = new HashMap<>();
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_FULLPAYMENT));

        Assert.assertTrue(purchaseOrdersTabVerification.getVerifyPurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0)));

        sideMenuController.closeCurrentTab(tabCount);
    }

    @Test(dependsOnMethods = {"getCreateInvoiceWithCreditNote"})
    public void verifyCreditNoteTracking() {
        testCaseLog("verifyCreditNoteTracking");
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_FULLPAYMENT));
        tabCount = sideMenuController.openCreditAmountTracking();

        creditAmountVerification.getCreditAmountCheck(tabCount, map);
        testVerifyLog("Credit Note is Verified");
    }
}
