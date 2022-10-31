package com.projectName.testCases.purchaseBill;

import com.framework.init.WebDriverInit;
import com.projectName.constants.DataConstantsPurchaseBill;
import com.projectName.constants.Validations;
import com.projectName.pageObjects.common.Controller.LoginPageController;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.projectName.pageObjects.purchaseBill.Controller.MedicinesController;
import com.projectName.pageObjects.purchaseBill.Controller.PurchaseBillTabController;
import com.projectName.pageObjects.purchaseBill.Controller.PurchaseOrdersTabController;
import com.projectName.pageObjects.purchaseBill.Verification.MedicinesVerification;
import com.projectName.pageObjects.purchaseBill.Verification.PurchaseOrdersTabVerification;
import erp.auto.testing.projectName.constants.*;
import erp.auto.testing.projectName.pageObjects.purchaseBill.Controller.*;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class PB_11_EditMedicineScreen extends WebDriverInit implements Validations, DataConstantsPurchaseBill {

    HashMap<String, ArrayList<Object>> map = new HashMap<>();

    PurchaseBillTabController purchaseBillTabController = new PurchaseBillTabController(driver);
    SideMenuController sideMenuController = new SideMenuController(driver);
    PurchaseOrdersTabController purchaseOrdersTabController = new PurchaseOrdersTabController(driver);
    MedicinesController medicinesController = new MedicinesController(driver);
    MedicinesVerification medicinesVerification = new MedicinesVerification(driver);
    LoginPageController loginPageController = new LoginPageController(driver);
    PurchaseOrdersTabVerification purchaseOrdersTabVerification = new PurchaseOrdersTabVerification(driver);

    int tabCount;

    @BeforeClass(alwaysRun = true)
    public void getLogin() {
        testCaseLog("Login");
        loginPageController.getSignin();
    }

    @Test(priority = 10)
    public void getEditMedicineScreen() {
        try {
            testCaseLog("getEditMedicineScreen");
            map.putAll(getTestDataWorkbook(DATA_CREATE_PURCHASEBILL_WITH_MODIFY_INVOICE));

            purchaseOrdersTabController.getDeletePurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0));

            tabCount = sideMenuController.openPurchaseBillTab();

            purchaseBillTabController.getEnterFullPurchaseBillDetails(getData(map, INVOICE_NO, 0), tabCount, sideMenuController, map, getData(map, ORDER_TOTAL_FOOTER, 0));
            purchaseBillTabController.getSaveUpdateClosePurchaseBill(sideMenuController, tabCount, getData(map, UPDATE_DATE, 0), getData(map, MODIFY_INVOICE, 0));

            map.putAll(getTestDataWorkbook(DATA_MODIFY_INVOICE_MEDICINES));

            medicinesVerification.getVerifyMedicineBeforeModifyDetails(tabCount, map);
            testStepsLog(_logStep++, "Medicine details are verified");

            medicinesController.getEnterHeaderDetails(tabCount, map);
            testStepsLog(_logStep++, "Medicine Header Details are Entered");

            medicinesController.getSelectAll(tabCount);
            medicinesController.getSaveMedicineDetails(tabCount);

            Assert.assertTrue(sideMenuController.checkAlertMessage(ALERT_SAVE_SUCCESS), "Not Saved");
            testVerifyLog("Medicines Detail changes are saved successfully!");

            sideMenuController.closeCurrentTab(tabCount);
        } catch (ElementClickInterceptedException e) {
            if (sideMenuController.getCheckBackUpPopUp()) {
                testWarningLog("Backup interrupted the Testing");
            }
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = "getEditMedicineScreen")
    public void getVerifyMedicineDetails() {
        map.putAll(getTestDataWorkbook(DATA_MODIFY_INVOICE_MEDICINES));
        getOpenEditPurchaseMedicine(purchaseBillTabController, sideMenuController, purchaseOrdersTabController, getData(map, INVOICE_NO, 0), getData(map, MODIFY_INVOICE, 0));

        medicinesVerification.getVerifyMedicineAfterModifyDetails(tabCount, map);
        testVerifyLog("Medicine Edit details updated are verified");

        sideMenuController.closeCurrentTab(tabCount);
    }

    @Test(dependsOnMethods = "getVerifyMedicineDetails")
    public void getVerifyPurchaseInvoiceInPurchases() {
        map.putAll(getTestDataWorkbook(DATA_MODIFY_INVOICE_MEDICINES));
        try {
            tabCount = sideMenuController.getCurrentTabCount(TAB_PURCHASES);
            sideMenuController.closeCurrentTab(tabCount);
        } catch (Exception ignored) {
        }
        purchaseOrdersTabVerification.getVerifyPurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0));
    }

    public void getOpenEditPurchaseMedicine(PurchaseBillTabController purchaseBillTabController, SideMenuController sideMenuController, PurchaseOrdersTabController purchaseOrdersTabController, String invoiceNo, String isModifyInvoice) {
        map.putAll(getTestDataWorkbook(DATA_MODIFY_INVOICE_MEDICINES));
        tabCount = purchaseOrdersTabController.getEditInvoice(sideMenuController, invoiceNo, getData(map, PAY_STATUS, 0));
        testStepsLog(_logStep++, "Invoice is opened");

        pause(2);
        purchaseBillTabController.clickGenerateBarcode(tabCount);

        purchaseBillTabController.getModifyUpdateInvoice(isModifyInvoice);
        testStepsLog(_logStep++, "Medicine tab to Modify details is Opened");
    }
}
