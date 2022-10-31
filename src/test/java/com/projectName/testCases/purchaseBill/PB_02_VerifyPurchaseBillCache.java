package com.projectName.testCases.purchaseBill;

import com.framework.init.WebDriverInit;
import com.projectName.constants.DataConstantsPurchaseBill;
import com.projectName.pageObjects.common.Controller.LoginPageController;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.projectName.pageObjects.purchaseBill.Controller.PurchaseBillTabController;
import com.projectName.pageObjects.purchaseBill.Controller.PurchaseOrdersTabController;
import com.projectName.pageObjects.purchaseBill.Verification.PurchaseBillTabVerification;
import com.projectName.pageObjects.purchaseBill.Verification.PurchaseOrdersTabVerification;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class PB_02_VerifyPurchaseBillCache extends WebDriverInit implements DataConstantsPurchaseBill {

    HashMap<String, ArrayList<Object>> map = new HashMap<>();
    PurchaseBillTabController purchaseBillTabController = new PurchaseBillTabController(driver);
    PurchaseBillTabVerification purchaseBillTabVerification = new PurchaseBillTabVerification(driver);
    SideMenuController sideMenuController = new SideMenuController(driver);
    LoginPageController loginPageController = new LoginPageController(driver);
    PurchaseOrdersTabVerification purchaseOrdersTabVerification = new PurchaseOrdersTabVerification(driver);
    PurchaseOrdersTabController purchaseOrdersTabController = new PurchaseOrdersTabController(driver);

    int tabCount;

    @BeforeClass(alwaysRun = true)
    public void getLogin() {
        testCaseLog("Login");
        loginPageController.getSignin();
    }

    @Test(priority = 1)
    public void enterPurchaseBillDetails() {
        try {
            testCaseLog("enterPurchaseBillDetails");
            map.putAll(getTestDataWorkbook(DATA_CREATE_PURCHASEBILL));

            purchaseOrdersTabController.getDeletePurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0));

            tabCount = sideMenuController.openPurchaseBillTab();

            purchaseBillTabController.getEnterFullPurchaseBillDetails(getData(map, INVOICE_NO, 0), tabCount, sideMenuController, map, getData(map, ORDER_TOTAL_FOOTER, 0));
        } catch (ElementClickInterceptedException e) {
            if (sideMenuController.getCheckBackUpPopUp()) {
                testWarningLog("Backup interrupted the Testing");
            }
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"enterPurchaseBillDetails"})
    public void getVerifyPurchaseBillCache() {
        testCaseLog("getVerifyPurchaseBillCache");
        pause();
        getBrowserRefresh(driver);
        pause();
        tabCount = sideMenuController.getSpecificTabCount(TAB_PURCHASEBILL);
        purchaseBillTabController.setExtraDiscount(tabCount, getData(map, EXTRA_DISC, 0));
        purchaseBillTabVerification.getVerifyExtraDiscount(tabCount, getData(map, EXTRA_DISC, 0));
        purchaseBillTabVerification.getVerifyPurchaseBillInvoice(tabCount, getData(map, INVOICE_NO, 0), map, getData(map, ORDER_TOTAL_FOOTER, 0));
    }

    @Test(dependsOnMethods = {"getVerifyPurchaseBillCache"})
    public void verifySaveCachePurchaseBillDetails() {
        testCaseLog("verifySaveCachePurchaseBillDetails");
        purchaseBillTabController.getSaveUpdateClosePurchaseBill(sideMenuController, tabCount, getData(map, UPDATE_DATE, 0), getData(map, MODIFY_INVOICE, 0));
        testStepsLog(_logStep++, "Cache Purchase Bill is Saved and Generated");
    }

    @Test(groups = "CreatePurchaseBill", dependsOnMethods = {"verifySaveCachePurchaseBillDetails"})
    public void getVerifyPurchaseBillInPurchaseOrder() {
        testCaseLog("getVerifyPurchaseBillInPurchaseOrder");
        Assert.assertTrue(purchaseOrdersTabVerification.getVerifyPurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0)));
        testStepsLog(_logStep++, "Purchase Bill is available in Purchases Order");
    }
}
