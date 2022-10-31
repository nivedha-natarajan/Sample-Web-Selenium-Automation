package com.projectName.testCases.purchaseBill;

import com.framework.init.WebDriverInit;
import com.projectName.constants.DataConstantsPurchaseBill;
import com.projectName.pageObjects.common.Controller.LoginPageController;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.projectName.pageObjects.purchaseBill.Verification.PurchaseBillTabVerification;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class PB_04_VerifyPBBarcodeDetails extends WebDriverInit implements DataConstantsPurchaseBill {

    HashMap<String, ArrayList<Object>> map = new HashMap<>();

    PurchaseBillTabVerification purchaseBillTabVerification = new PurchaseBillTabVerification(driver);
    SideMenuController sideMenuController = new SideMenuController(driver);
    LoginPageController loginPageController = new LoginPageController(driver);

    int tabCount;

    @BeforeClass(alwaysRun = true)
    public void getLogin() {
        testCaseLog("Login");
        loginPageController.getSignin();
    }

    @Test(priority = 3, dependsOnGroups = {"ValidatePurchaseBill"})
    public void verifyBarcodeDetails() {
        try {
            testCaseLog("verifyBarcodeDetails");
            map.putAll(getTestDataWorkbook(DATA_VALIDATE_PURCHASEBILL));

            tabCount = sideMenuController.openPurchaseBillTab();

            purchaseBillTabVerification.getVerifyBarcodeDetails(tabCount, map);
            testVerifyLog("Medicine details are populated for the corresponding barcode");
        } catch (ElementClickInterceptedException e) {
            if (sideMenuController.getCheckBackUpPopUp()) {
                testStepsLog(_logStep++, "Backup interrupted the Testing");
            }
            e.printStackTrace();
        }
    }
}
