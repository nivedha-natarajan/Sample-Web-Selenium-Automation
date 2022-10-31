package com.projectName.testCases.purchaseBill;

import com.framework.init.WebDriverInit;
import com.projectName.constants.DataConstantsPurchaseBill;
import com.projectName.pageObjects.common.Controller.LoginPageController;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.projectName.pageObjects.purchaseBill.Controller.PurchaseBillTabController;
import com.projectName.pageObjects.purchaseBill.Controller.PurchaseOrdersTabController;
import com.projectName.pageObjects.purchaseBill.Verification.PurchaseBillTabVerification;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class PB_03_EditPurchaseBill extends WebDriverInit implements DataConstantsPurchaseBill {

    HashMap<String, ArrayList<Object>> map = new HashMap<>();

    PurchaseBillTabController purchaseBillTabController = new PurchaseBillTabController(driver);
    PurchaseBillTabVerification purchaseBillTabVerification = new PurchaseBillTabVerification(driver);
    SideMenuController sideMenuController = new SideMenuController(driver);
    PurchaseOrdersTabController purchaseOrdersTabController = new PurchaseOrdersTabController(driver);
    LoginPageController loginPageController = new LoginPageController(driver);

    int tabCount;

    @BeforeClass(alwaysRun = true)
    public void getLogin() {
        testCaseLog("Login");
        loginPageController.getSignin();
    }

    @Test(priority = 2, dependsOnGroups = "CreatePurchaseBill")
    public void getEditPurchaseBill() {
        try {
            testCaseLog("getEditPurchaseBill");
            map.putAll(getTestDataWorkbook(DATA_EDITPURCHASEBILL_ADD));

            tabCount = purchaseOrdersTabController.getEditInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, PAY_STATUS, 0));

            if (purchaseBillTabController.getAddEnterMedicineDetails(tabCount, map)) {
                testStepsLog(_logStep++, "Invoice is updated with Medicine details");
            }
        } catch (ElementClickInterceptedException e) {
            if (sideMenuController.getCheckBackUpPopUp()) {
                testWarningLog("Backup interrupted the Testing");
            }
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"getEditPurchaseBill"})
    public void getSaveEditPurchaseBill() {
        testCaseLog("getSaveEditPurchaseBill");
        purchaseBillTabController.getSaveUpdateClosePurchaseBill(sideMenuController, tabCount, getData(map, UPDATE_DATE, 0), getData(map, MODIFY_INVOICE, 0));
        testStepsLog(_logStep++, "New Purchase Bill is generated");
        sideMenuController.closeCurrentTab(tabCount);
    }

    @Test(dependsOnMethods = {"getSaveEditPurchaseBill"})
    public void getVerifyPurchaseBillInPurchaseOrder() {
        testCaseLog("getVerifyPurchaseBillInPurchaseOrder");
        map.putAll(getTestDataWorkbook(DATA_EDIT_PURCHASEBILL_VERIFY));

        tabCount = purchaseOrdersTabController.getEditInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, PAY_STATUS, 0));

        purchaseBillTabVerification.getVerifyPurchaseBillInvoice(tabCount, getData(map, INVOICE_NO, 0), map, getData(map, ORDER_TOTAL_FOOTER, 0));

        testStepsLog(_logStep++, "Purchase Invoice is Verified");
    }
}
