package com.projectName.testCases.purchaseBill;

import com.framework.init.WebDriverInit;
import com.projectName.constants.DataConstantsPurchaseBill;
import com.projectName.constants.Validations;
import com.projectName.pageObjects.common.Controller.LoginPageController;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.projectName.pageObjects.purchaseBill.Controller.BatchStockTabController;
import com.projectName.pageObjects.purchaseBill.Controller.PurchaseOrdersTabController;
import com.projectName.pageObjects.purchaseBill.Controller.PurchaseReturnBillWiseTabController;
import com.projectName.pageObjects.purchaseBill.Verification.BatchStockTabVerification;
import erp.auto.testing.projectName.constants.*;
import erp.auto.testing.projectName.pageObjects.purchaseBill.Controller.*;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class PB_13_VerifyBatchStock extends WebDriverInit implements Validations, DataConstantsPurchaseBill {

    HashMap<String, ArrayList<Object>> map = new HashMap<>();

    BatchStockTabController batchStockTabController = new BatchStockTabController(driver);
    BatchStockTabVerification batchStockTabVerification = new BatchStockTabVerification(driver);
    SideMenuController sideMenuController = new SideMenuController(driver);
    LoginPageController loginPageController = new LoginPageController(driver);
    PurchaseOrdersTabController purchaseOrdersTabController = new PurchaseOrdersTabController(driver);
    PurchaseReturnBillWiseTabController purchaseReturnBillWiseTabController = new PurchaseReturnBillWiseTabController(driver);

    int tabCount;
    int stockColumnNo;

    @BeforeClass(alwaysRun = true)
    public void getLogin() {
        testCaseLog("Login");
        loginPageController.getSignin();
    }

    @Test(priority = 12, dependsOnGroups = {"ExpiryReturn"})
    public void getVerifyBeforeBatchStockDeletion() {
        try {
            testCaseLog("getVerifyBeforeBatchStockDeletion");

            map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_EXPIRY_RETURN));

            getVerifyMedicineStock(map, MEDICINE_STOCK);
            testStepsLog(_logStep++, "Stock Verified Before deleting invoices.");
        } catch (ElementClickInterceptedException e) {
            if (sideMenuController.getCheckBackUpPopUp()) {
                testWarningLog("Backup interrupted the Testing");
            }
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"getVerifyBeforeBatchStockDeletion"})
    public void getVerifyAfterPurchaseInvoiceDeletion() {
        testCaseLog("getVerifyAfterPurchaseInvoiceDeletion");
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_EXPIRY_RETURN));
        purchaseOrdersTabController.getDeletePurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0));
        getVerifyMedicineStock(map, MEDICINE_STOCK_1);
        testVerifyLog("Stock Verified after Purchase Invoice deletion - " + getData(map, RETURN_INVOICE_NO, 0));
    }

    @Test(dependsOnMethods = {"getVerifyAfterPurchaseInvoiceDeletion"})
    public void getVerifyAfterReturnInvoiceDeletion() {
        testCaseLog("getVerifyAfterReturnInvoiceDeletion");
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_EXPIRY_RETURN));
        purchaseReturnBillWiseTabController.getDeletePurchaseReturnInvoice(sideMenuController, getData(map, DISTRIBUTOR_NAME, 0), getData(map, PURCHASE_RETURN_TYPE, 0), getData(map, DATE, 0));
        getVerifyMedicineStock(map, MEDICINE_STOCK_2);
        testStepsLog(_logStep++, "Stock Verified after Purchase return invoice deletion - " + getData(map, DISTRIBUTOR_NAME, 0));
    }

    @Test(dependsOnMethods = {"getVerifyAfterReturnInvoiceDeletion"})
    public void getVerifyAfterStockDeletion() {
        testCaseLog("getVerifyAfterStockDeletion");
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_EXPIRY_RETURN));
        getUpdateMedicineStock(map, MEDICINE_STOCK_UPDATE_QUANTITY, MEDICINE_STOCK_UPDATE_LOOSE);
        getVerifyMedicineStock(map, MEDICINE_STOCK_DELETED);
        testStepsLog(_logStep++, "Stock is updated 0 in stock batch");
    }

    @Test(dependsOnMethods = {"getVerifyAfterStockDeletion"})
    public void getVerifyAfterStockAddition() {
        testCaseLog("getVerifyAfterStockAddition");
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_EXPIRY_RETURN));
        getUpdateMedicineStock(map, MEDICINE_STOCK_2, MEDICINE_STOCK_UPDATE_LOOSE);
        getVerifyMedicineStock(map, MEDICINE_STOCK_2);
        testStepsLog(_logStep++, "Stock is updated back to current stock value");
    }

    @Test(dependsOnMethods = {"getVerifyAfterStockAddition"})
    public void getVerifyNoMedicineStock() {
        testCaseLog("getVerifyNoMedicineStock");
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_EXPIRY_RETURN));
        purchaseOrdersTabController.getDeletePurchaseInvoice(sideMenuController, getData(map, RETURN_INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0));
        getVerifyMedicineStock(map, MEDICINE_STOCK_DELETED);
        testStepsLog(_logStep++, "Stock is empty after all the invoices are deleted");
    }

    public void getVerifyMedicineStock(HashMap<String, ArrayList<Object>> map, String stock) {
        testCaseLog("getVerifyMedicineStock");
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_EXPIRY_RETURN));
        String stockCount;
        tabCount = sideMenuController.openBatchStock();

        batchStockTabController.getListAllMedicine();

        stockColumnNo = batchStockTabController.getStockColumnNumber(tabCount);

        for (int i = 0; i < map.get(MEDICINE_NAME).size(); i++) {
            stockCount = batchStockTabVerification.getVerifyMedicineStock(tabCount, getData(map, MEDICINE_NAME, i), getData(map, BATCH, i), getData(map, BARCODE, i), getData(map, stock, i), stockColumnNo);
            testVerifyLog("Current Stock for - " + getData(map, MEDICINE_NAME, i) + " - " + stockCount);
        }
        sideMenuController.closeCurrentTab(tabCount);
    }

    public void getUpdateMedicineStock(HashMap<String, ArrayList<Object>> map, String stockQuantity, String stockLoose) {
        testCaseLog("getUpdateMedicineStock");
        tabCount = sideMenuController.openBatchStock();
        map.putAll(getTestDataWorkbook(DATA_CREATE_CREDITNOTE_EXPIRY_RETURN));
        batchStockTabController.getListAllMedicine();

        for (int i = 0; i < map.get(MEDICINE_NAME).size(); i++) {
            batchStockTabController.getSearchMedicineStock(tabCount, getData(map, MEDICINE_NAME, i), getData(map, BATCH, i), getData(map, BARCODE, i));
            batchStockTabController.getUpdateQuantity(tabCount, getData(map, stockQuantity, i), getData(map, stockLoose, i), getData(map, MEDICINE_NAME, i), getData(map, ADJUSTMENT_REASON, 0));
            sideMenuController.checkAlertMessage(ALERT_UPDATE_SUCCESS);

            testStepsLog(_logStep++, "Medicine Stock is Updated - " + getData(map, MEDICINE_NAME, i) + " - with - " + getData(map, stockQuantity, i) + "::" + getData(map, stockLoose, i));
        }
        sideMenuController.closeCurrentTab(tabCount);
    }

}
