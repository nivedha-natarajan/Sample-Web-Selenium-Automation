package com.projectName.testCases.purchaseBill;

import com.framework.init.WebDriverInit;
import com.framework.utils.Configuration;
import com.projectName.constants.DataConstantsPurchaseBill;
import com.projectName.constants.Validations;
import com.projectName.pageObjects.common.Controller.ConfigurationGeneralTabController;
import com.projectName.pageObjects.common.Controller.ConfigurationTabController;
import com.projectName.pageObjects.common.Controller.LoginPageController;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.projectName.pageObjects.purchaseBill.Verification.PurchaseBillTabVerification;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PB_06_VerifyPurchaseBillTaxConfigCheckBoxes extends WebDriverInit implements Validations, Configuration, DataConstantsPurchaseBill {

    PurchaseBillTabVerification purchaseBillTabVerification = new PurchaseBillTabVerification(driver);
    SideMenuController sideMenuController = new SideMenuController(driver);
    ConfigurationTabController configurationTabController = new ConfigurationTabController(driver);
    com.projectName.pageObjects.common.Controller.ConfigurationGeneralTabController ConfigurationGeneralTabController = new ConfigurationGeneralTabController(driver);
    LoginPageController loginPageController = new LoginPageController(driver);

    int tabCount;

    @BeforeClass(alwaysRun = true)
    public void getLogin() {
        testCaseLog("Login");
        loginPageController.getSignin();
    }

    @Test(priority = 5)
    public void verifyHSNTextBoxEnabled() {
        try {
            testCaseLog("verifyHSNTextBoxEnabled");

            tabCount = sideMenuController.openPurchaseBillTab();

            if (!purchaseBillTabVerification.getVerifyHSNTextBox(tabCount, 1)) {
                getChangeTaxesConfiguration(configurationTabController, sideMenuController, ConfigurationGeneralTabController);

                tabCount = sideMenuController.openPurchaseBillTab();

                purchaseBillTabVerification.getVerifyHSNTextBox(tabCount, 1);
            }
            testVerifyLog("HSN TextBox is Enabled");
        } catch (ElementClickInterceptedException e) {
            if (sideMenuController.getCheckBackUpPopUp()) {
                testWarningLog("Backup interrupted the Testing");
            }
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"verifyHSNTextBoxEnabled"})
    public void verifyBarcodeTextBoxEnabled() {
        testCaseLog("verifyBarcodeTextBoxEnabled");
        purchaseBillTabVerification.getVerifyBarcodeCheckBox(tabCount, 1);
        testVerifyLog("Barcode TextBox is Enabled");
    }

    @Test(dependsOnMethods = {"verifyBarcodeTextBoxEnabled"})
    public void verifyCESSTextBoxEnabled() {
        testCaseLog("verifyCESSTextBoxEnabled");
        purchaseBillTabVerification.isCESSTextBoxDisplayed(tabCount, 1);
        testVerifyLog("CESS TextBox is Enabled");
    }

    @Test(dependsOnMethods = {"verifyCESSTextBoxEnabled"})
    public void verifyIGSTTextBoxEnabled() {
        testCaseLog("verifyIGSTTextBoxEnabled");
        purchaseBillTabVerification.isIGSTTextBoxDisplayed(tabCount, 1);
        testVerifyLog("IGST TextBox is Enabled");
    }

    @Test(dependsOnMethods = {"verifyIGSTTextBoxEnabled"})
    public void verifyTCSTextBoxEnabled() {
        testCaseLog("verifyTCSTextBoxEnabled");
        purchaseBillTabVerification.getVerifyTCSTextBox(tabCount, 1);
        testVerifyLog("TCS TextBox is Enabled");
    }

    @Test(dependsOnMethods = {"verifyTCSTextBoxEnabled"})
    public void verifyCDTextBoxEnabled() {
        testCaseLog("verifyCDTextBoxEnabled");
        purchaseBillTabVerification.getVerifyCDCashTextBox(tabCount, 1);
        testVerifyLog("CD TextBox is Enabled");
    }

    @Test(dependsOnMethods = {"verifyCDTextBoxEnabled"})
    public void verifyVATTextBoxEnabled() {
        testCaseLog("verifyVATTextBoxEnabled");
        purchaseBillTabVerification.isVATTextBoxDisplayed(tabCount, 1);
        testVerifyLog("VAT TextBox is Enabled");
    }

    @Test(dependsOnMethods = {"verifyVATTextBoxEnabled"})
    public void getChangeConfigurationTextBox() {
        testCaseLog("getChangeConfigurationTextBox");
        getChangeTaxesConfiguration(configurationTabController, sideMenuController, ConfigurationGeneralTabController);

        tabCount = sideMenuController.openPurchaseBillTab();
    }

    @Test(dependsOnMethods = {"getChangeConfigurationTextBox"})
    public void verifyHSNTextBoxDisabled() {
        testCaseLog("verifyHSNTextBoxDisabled");
        if (!purchaseBillTabVerification.isHSNTextBoxDisplayed(tabCount, 1)) {
            testVerifyLog("HSN TextBox is Disabled");
        } else {
            testWarningLog("HSN TextBox is Enabled");
            Assert.fail();
        }
    }

    @Test(dependsOnMethods = {"getChangeConfigurationTextBox"})
    public void verifyCESSTextBoxDisabled() {
        testCaseLog("verifyCESSTextBoxDisabled");
        if (!purchaseBillTabVerification.isCESSTextBoxDisplayed(tabCount, 1)) {
            testVerifyLog("CESS TextBox is Disabled");
        } else {
            Assert.fail("CESS TextBox is Enabled");
        }
    }

    @Test(dependsOnMethods = {"getChangeConfigurationTextBox"})
    public void verifyIGSTTextBoxDisabled() {
        testCaseLog("verifyIGSTTextBoxDisabled");
        if (!purchaseBillTabVerification.isIGSTTextBoxDisplayed(tabCount, 1)) {
            testVerifyLog("IGST TextBox is Disabled");
        } else {
            Assert.fail("IGST TextBox is Enabled");
        }
    }

    @Test(dependsOnMethods = {"getChangeConfigurationTextBox"})
    public void verifyTCSTextBoxDisabled() {
        testCaseLog("verifyTCSTextBoxDisabled");
        if (!purchaseBillTabVerification.isTCSTextBoxDisplayed(tabCount, 1)) {
            testVerifyLog("TCS TextBox is Disabled");
        } else {
            Assert.fail("TCS TextBox is Enabled");
        }
    }

    @Test(dependsOnMethods = {"getChangeConfigurationTextBox"})
    public void verifyVATTextBoxDisabled() {
        testCaseLog("verifyVATTextBoxDisabled");
        if (!purchaseBillTabVerification.isVATTextBoxDisplayed(tabCount, 1)) {
            testVerifyLog("VAT TextBox is Disabled");
        } else {
            Assert.fail("VAT TextBox is Enabled");
        }
    }

    @Test(dependsOnMethods = {"getChangeConfigurationTextBox"})
    public void verifyCDTextBoxDisabled() {
        testCaseLog("verifyCDTextBoxDisabled");
        if (!purchaseBillTabVerification.isCDTextBoxDisplayed(tabCount, 1)) {
            testVerifyLog("CD TextBox is Disabled");
        } else {
            Assert.fail("CD TextBox is Enabled");
        }
    }

    @Test(dependsOnMethods = {"getChangeConfigurationTextBox"})
    public void verifyBarcodeTextBoxDisabled() {
        testCaseLog("verifyBarcodeTextBoxDisabled");
        if (!purchaseBillTabVerification.isBarcodeTextBoxDisplayed(tabCount, 1)) {
            testVerifyLog("Barcode TextBox is Disabled");
        } else {
            Assert.fail("Barcode TextBox is Enabled");
        }
    }

    public void getChangeTaxesConfiguration(ConfigurationTabController configurationTabController, SideMenuController sideMenuController, ConfigurationGeneralTabController ConfigurationGeneralTabController) {
        tabCount = sideMenuController.openConfigurationTab();

        if (configurationTabController.checkEnterPassword(tabCount, CONFIGURATION_PASSWORD, ALERTBOX_CONFIG_ENTER_PASSWORD)) {
            testStepsLog(_logStep++, "Configuration password is Entered");
        }

        configurationTabController.openGeneral(tabCount);

        if (configurationTabController.checkEnterPassword(tabCount, CONFIGURATION_PASSWORD, ALERTBOX_CONFIG_ENTER_PASSWORD)) {
            testStepsLog(_logStep++, "Configuration password is Entered");
        }

        ConfigurationGeneralTabController.openPurchase();

        ConfigurationGeneralTabController.getChangeTaxesConfiguration();
        testStepsLog(_logStep++, "Taxes Configurations are Enabled/Disabled");

        ConfigurationGeneralTabController.clickSubmit();

        Assert.assertTrue(sideMenuController.checkAlertMessage(ALERT_SAVE_SUCCESS), "Not Saved");
        testVerifyLog("Purchase Configuration is Saved");
        getBrowserRefresh(driver);
    }
}
