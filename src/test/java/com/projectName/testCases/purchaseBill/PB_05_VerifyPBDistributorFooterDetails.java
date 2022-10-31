package com.projectName.testCases.purchaseBill;

import com.framework.init.WebDriverInit;
import com.projectName.constants.DataConstantsPurchaseBill;
import com.projectName.pageObjects.common.Controller.LoginPageController;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.projectName.pageObjects.purchaseBill.Controller.PurchaseBillTabController;
import com.projectName.pageObjects.purchaseBill.Verification.PurchaseBillTabVerification;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class PB_05_VerifyPBDistributorFooterDetails extends WebDriverInit implements DataConstantsPurchaseBill {

    HashMap<String, ArrayList<Object>> map = new HashMap<>();

    PurchaseBillTabController purchaseBillTabController = new PurchaseBillTabController(driver);
    PurchaseBillTabVerification purchaseBillTabVerification = new PurchaseBillTabVerification(driver);
    SideMenuController sideMenuController = new SideMenuController(driver);
    LoginPageController loginPageController = new LoginPageController(driver);

    int tabCount;

    @BeforeClass(alwaysRun = true)
    public void getLogin() {
        testCaseLog("Login");
        loginPageController.getSignin();
    }

    @Test(priority = 4, dependsOnGroups = {"ValidatePurchaseBill"})
    public void verifyAddExistingDistributor() {
        try {
            testCaseLog("verifyAddExistingDistributor");
            map.putAll(getTestDataWorkbook(DATA_VALIDATE_PURCHASEBILL));

            tabCount = sideMenuController.openPurchaseBillTab();

            purchaseBillTabController.setDistributorName(tabCount, getData(map, DISTRIBUTOR_NAME, 0));
            testStepsLog(_logStep++, "Existing Distributor is Added");
        } catch (ElementClickInterceptedException e) {
            if (sideMenuController.getCheckBackUpPopUp()) {
                testWarningLog("Backup interrupted the Testing");
            }
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"verifyAddExistingDistributor"})
    public void verifyAddExistingBatch() {
        testCaseLog("verifyAddExistingBatch");
        purchaseBillTabController.setMedicineName(tabCount, 1, getData(map, MEDICINE_NAME, 0));
        purchaseBillTabController.getEnterMedicineDetails(tabCount, 1, getData(map, MEDICINE_NAME, 0), getData(map, BARCODE, 0), getData(map, BATCH, 0), getData(map, EXPIRY, 0),
                getData(map, RATE_CP, 0), getData(map, MRP_SP, 0), getData(map, QUANTITY, 0), getData(map, FREE_QUANTITY, 0),
                getData(map, CGST, 0), getData(map, CD_PERCENTAGE, 0), getData(map, SCHEME_RUPEES, 0), getData(map, SCHEME_PERCENTAGE, 0));
        testStepsLog(_logStep++, "Existing Batch is Added");
    }

    @Test(dependsOnMethods = {"verifyAddExistingBatch"})
    public void verifyDistributorOutstanding() {
        testCaseLog("verifyDistributorOutstanding");
        testStepsLog(_logStep++, "Distributor Outstanding is Displayed");
        purchaseBillTabVerification.getVerifyOutstanding(tabCount);
        testValidationLog("Distributor Outstanding is Verified");
    }

    @Test(dependsOnMethods = {"verifyAddExistingBatch"})
    public void verifyDistributorMedicineDetails() {
        testCaseLog("verifyDistributorMedicineDetails");
        testStepsLog(_logStep++, "Distributor Medicine Details is Displayed");
        purchaseBillTabVerification.getVerifyMedicineDetails(tabCount);
        testValidationLog("Distributor Medicine Details is Verified");
    }

    @Test(dependsOnMethods = {"verifyAddExistingBatch"})
    public void verifyDistributorLastPurchaseId() {
        testCaseLog("verifyDistributorLastPurchaseId");
        testStepsLog(_logStep++, "Distributor Last Purchase ID is Displayed");
        purchaseBillTabVerification.getVerifyLastPurchaseId(tabCount);
        testValidationLog("Distributor Last Purchase ID is Verified");
    }
}
