package com.projectName.testCases.purchaseBill;

import com.framework.init.WebDriverInit;
import com.framework.utils.Configuration;
import com.projectName.constants.DataConstantsPurchaseBill;
import com.projectName.constants.Validations;
import com.projectName.pageObjects.common.Controller.ConfigurationGeneralTabController;
import com.projectName.pageObjects.common.Controller.ConfigurationTabController;
import com.projectName.pageObjects.common.Controller.LoginPageController;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.projectName.pageObjects.purchaseBill.Controller.PurchaseBillTabController;
import com.projectName.pageObjects.purchaseBill.Controller.PurchaseOrdersTabController;
import com.projectName.pageObjects.purchaseBill.Controller.SelectInvoiceFromChallanController;
import com.projectName.pageObjects.purchaseBill.Verification.PurchaseOrdersTabVerification;
import erp.auto.testing.projectName.pageObjects.purchaseBill.Controller.*;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class PB_07_CreateInvoicefromChallan extends WebDriverInit implements DataConstantsPurchaseBill, Validations {

    HashMap<String, ArrayList<Object>> map = new HashMap<>();
    PurchaseBillTabController purchaseBillTabController = new PurchaseBillTabController(driver);
    SideMenuController sideMenuController = new SideMenuController(driver);
    ConfigurationTabController configurationTabController = new ConfigurationTabController(driver);
    ConfigurationGeneralTabController configurationGeneralTabController = new ConfigurationGeneralTabController(driver);
    SelectInvoiceFromChallanController selectInvoiceFromChallanController = new SelectInvoiceFromChallanController(driver);
    LoginPageController loginPageController = new LoginPageController(driver);
    PurchaseOrdersTabController purchaseOrdersTabController = new PurchaseOrdersTabController(driver);
    PurchaseOrdersTabVerification purchaseOrdersTabVerification = new PurchaseOrdersTabVerification(driver);

    int tabCount;

    @BeforeClass(alwaysRun = true)
    public void getLogin() {
        testCaseLog("Login");
        loginPageController.getSignin();
    }

    @Test(priority = 6)
    public void getEnableChallanConfiguration() {
        try {
            testCaseLog("getEnableChallanConfiguration");
            map.putAll(getTestDataWorkbook(DATA_CREATE_CHALLAN));

            purchaseOrdersTabController.getDeletePurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0));
            purchaseOrdersTabController.getDeletePurchaseInvoice(sideMenuController, getData(map, CHALLAN_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0));

            tabCount = sideMenuController.openPurchaseBillTab();

            if (!purchaseBillTabController.isChallanCheckboxEnabled(tabCount)) {
                getChangeChallan(configurationTabController, sideMenuController, configurationGeneralTabController);
                testStepsLog(_logStep++, "Challan Checkbox is Enabled");
            } else {
                sideMenuController.closeCurrentTab(tabCount);
            }

        } catch (ElementClickInterceptedException e) {
            if (sideMenuController.getCheckBackUpPopUp()) {
                testWarningLog("Backup interrupted the Testing");
            }
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"getEnableChallanConfiguration"})
    public void getCreateChallan() {
        testCaseLog("getCreateChallan");
        map.putAll(getTestDataWorkbook(DATA_CREATE_CHALLAN));
        tabCount = sideMenuController.openPurchaseBillTab();

        purchaseBillTabController.clickChallanCheckBox(tabCount);
        testStepsLog(_logStep++, "Challan Checkbox is selected");
        purchaseBillTabController.getEnterFullPurchaseBillDetails(getData(map, CHALLAN_NO, 0), tabCount, sideMenuController, map, getData(map, ORDER_TOTAL_FOOTER, 0));
        purchaseBillTabController.getSaveUpdateClosePurchaseBill(sideMenuController, tabCount, getData(map, UPDATE_DATE, 0), getData(map, MODIFY_INVOICE, 0));
        testStepsLog(_logStep++, "Challan is created");
        sideMenuController.closeCurrentTab(tabCount);
    }

    @Test(dependsOnMethods = {"getCreateChallan"})
    public void getVerifyChallanPresent() {
        testCaseLog("getVerifyChallanPresent");
        map.putAll(getTestDataWorkbook(DATA_CREATE_CHALLAN));
        Assert.assertTrue(purchaseOrdersTabVerification.getVerifyPurchaseInvoice(sideMenuController, getData(map, CHALLAN_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0)));
    }

    @Test(dependsOnMethods = {"getVerifyChallanPresent"})
    public void getCreateInvoiceFromChallan() {
        testCaseLog("getCreateInvoiceFromChallan");
        map.putAll(getTestDataWorkbook(DATA_CREATE_CHALLAN));
        tabCount = sideMenuController.openCreateInvoiceFromChallan();

        purchaseBillTabController.setDistributorName(tabCount, getData(map, DISTRIBUTOR_NAME, 0));

        try {
            getSelectChallan(tabCount, map, purchaseBillTabController);
        } catch (NoSuchElementException e) {
            testWarningLog("Challan/s are not visible");
        }
        sideMenuController.closeCurrentTab(tabCount);
        purchaseOrdersTabVerification.getVerifyPurchaseInvoice(sideMenuController, getData(map, INVOICE_NO, 0), getData(map, DATE, 0), getData(map, PAY_STATUS, 0));

        getChangeChallan(configurationTabController, sideMenuController, configurationGeneralTabController);
        testStepsLog(_logStep++, "Challan Checkbox is Disabled");
    }

    public void getSelectChallan(int tabCount, HashMap<String, ArrayList<Object>> map, PurchaseBillTabController pb) {
        if (pb.checkChallanVisible(tabCount, getData(map, CHALLAN_NO, 0))) {
            testStepsLog(_logStep++, "Challan/s available for the Distributor is Visible - " + getData(map, DISTRIBUTOR_NAME, 0));
            pb.selectChallan(tabCount, getData(map, CHALLAN_NO, 0));
            testStepsLog(_logStep++, getData(map, CHALLAN_NO, 0) + " - Challan is selected");

            selectInvoiceFromChallanController.clickAddToInvoice(tabCount, getData(map, CHALLAN_NO, 0));
            testStepsLog(_logStep++, "Selected challan is added to the Invoice");

            pb.setInvoiceNo(tabCount, getData(map, INVOICE_NO, 0));
            testStepsLog(_logStep++, "Invoice no is Entered");

            pb.clickGenerateBarcode(tabCount);
            testStepsLog(_logStep++, "Invoice is created from Challan");
        }
    }

    public void getChangeChallan(ConfigurationTabController configurationTabController, SideMenuController sideMenuController, ConfigurationGeneralTabController configurationGeneralTabController) {
        tabCount = sideMenuController.openConfigurationTab();

        if (configurationTabController.checkEnterPassword(tabCount, Configuration.CONFIGURATION_PASSWORD, ALERTBOX_CONFIG_ENTER_PASSWORD)) {
            testStepsLog(_logStep++, "Configuration password is Entered");
        }

        configurationTabController.openGeneral(tabCount);
        testStepsLog(_logStep++, "General settings is Opened");

        if (configurationTabController.checkEnterPassword(tabCount, Configuration.CONFIGURATION_PASSWORD, ALERTBOX_CONFIG_ENTER_PASSWORD)) {
            testStepsLog(_logStep++, "Configuration password is Entered");
        }

        configurationGeneralTabController.openPurchase();

        configurationGeneralTabController.getChangeChallanCheckBox();
        testStepsLog(_logStep++, "Challan is Enabled/Disabled");

        configurationGeneralTabController.clickSubmit();

        Assert.assertTrue(sideMenuController.checkAlertMessage(ALERT_SAVE_SUCCESS), "Not Saved");
        testValidationLog("Purchase Configuration is Saved");
        loginPageController.getSignOut();
        loginPageController.getSignin();
    }

}
