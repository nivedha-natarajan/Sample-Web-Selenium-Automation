package com.projectName.testCases.purchaseBill;

import com.framework.init.WebDriverInit;
import com.framework.utils.Configuration;
import com.projectName.constants.DataConstantsPurchaseBill;
import com.projectName.constants.UploadColumns;
import com.projectName.constants.Validations;
import com.projectName.pageObjects.common.Controller.LoginPageController;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.projectName.pageObjects.purchaseBill.Controller.PurchaseBillTabController;
import com.projectName.pageObjects.purchaseBill.Controller.PurchaseOrdersTabController;
import com.projectName.pageObjects.purchaseBill.Verification.PurchaseOrdersTabVerification;
import erp.auto.testing.projectName.constants.*;
import erp.auto.testing.projectName.pageObjects.purchaseBill.Controller.*;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class PB_12_CreatePurchaseBillWithUploadFile extends WebDriverInit implements UploadColumns, Validations, DataConstantsPurchaseBill {

    HashMap<String, ArrayList<Object>> map = new HashMap<>();

    PurchaseBillTabController purchaseBillTabController = new PurchaseBillTabController(driver);
    SideMenuController sideMenuController = new SideMenuController(driver);
    LoginPageController loginPageController = new LoginPageController(driver);
    PurchaseOrdersTabController purchaseOrdersTabController = new PurchaseOrdersTabController(driver);
    PurchaseOrdersTabVerification purchaseOrdersTabVerification = new PurchaseOrdersTabVerification(driver);

    int tabCount;

    @BeforeClass(alwaysRun = true)
    public void getLogin() {
        testCaseLog("Login");
        loginPageController.getSignin();
    }

    @Test(priority = 11)
    public void getCreatePurchaseBillWithUploadFile() {
        try {
            testCaseLog("getCreatePurchaseBillWithUploadFile");

            map.putAll(getTestDataWorkbook(DATA_CSV_UPLOAD));

            purchaseOrdersTabController.getDeletePurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0));

            tabCount = sideMenuController.openPurchaseBillTab();

            map.putAll(getTestDataWorkbook(DATA_CREATE_PURCHASEBILL));

            purchaseBillTabController.setDistributorName(tabCount, map, purchaseBillTabController, sideMenuController);

            map.putAll(getTestDataWorkbook(DATA_CSV_UPLOAD));

            purchaseBillTabController.getUploadFile(tabCount, Configuration.PURCHASE_BILL_UPLOAD_PATH);
            testStepsLog(_logStep++, "Purchase Bill file is uploaded successfully");

            purchaseBillTabController.getMatchCheckMedicineName(tabCount);

            purchaseBillTabController.setInvoiceNo(tabCount, getData(map, INVOICE_NO, 0));

            purchaseBillTabController.clickGenerateBarcode(tabCount);

            if (sideMenuController.checkAlertMessage(ALERT_ENTER_MISSING_ELEMENT)) {
                purchaseBillTabController.getMatchCheckMedicineName(tabCount);
                purchaseBillTabController.clickGenerateBarcode(tabCount);
            }

            if (!sideMenuController.checkAlertMessage(ALERT_BARCODE_DOWNLOAD)) {
                purchaseBillTabController.getUpdateExpiryAndInvoice(tabCount, getData(map, UPDATE_DATE, 0), getData(map, MODIFY_INVOICE, 0));
            }

            testStepsLog(_logStep++, "New Purchase Bill is generated from an Uploaded file");
            sideMenuController.closeCurrentTab(tabCount);

            Assert.assertTrue(purchaseOrdersTabVerification.getVerifyPurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0)));

        } catch (ElementClickInterceptedException e) {
            if (sideMenuController.getCheckBackUpPopUp()) {
                testWarningLog("Backup interrupted the Testing");
            }
            e.printStackTrace();
        }
    }

}
