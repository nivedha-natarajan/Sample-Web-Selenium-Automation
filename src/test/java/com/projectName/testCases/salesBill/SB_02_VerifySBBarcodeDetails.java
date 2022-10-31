package com.projectName.testCases.salesBill;

import com.projectName.constants.DataConstantsSalesBill;
import com.projectName.constants.Validations;
import com.projectName.pageObjects.common.Controller.LoginPageController;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.projectName.pageObjects.salesBill.Controller.SalesBillController;
import com.projectName.pageObjects.salesBill.Controller.SalesOrderController;
import com.projectName.pageObjects.salesBill.Verification.SalesBillVerification;
import com.framework.init.WebDriverInit;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class SB_02_VerifySBBarcodeDetails extends WebDriverInit implements DataConstantsSalesBill, Validations {

    HashMap<String, ArrayList<Object>> map = new HashMap<>();

    LoginPageController loginPageController = new LoginPageController(driver);
    SalesBillController salesBillController = new SalesBillController(driver);
    SalesBillVerification salesBillVerification = new SalesBillVerification(driver);
    SideMenuController sideMenuController = new SideMenuController(driver);
    SalesOrderController salesOrderController = new SalesOrderController(driver);

    int tabCount;
    String _temp;

    @BeforeClass(alwaysRun = true)
    public void getLogin() {
        testCaseLog("Login");
        loginPageController.getSignin();
    }

    @Test(priority = 1)
    public void openSalesBill() {
        try {
            testCaseLog("openSalesBill");
            map.putAll(getTestDataWorkbook(DATA_VALIDATE_SALESBILL));

            salesOrderController.getDeleteSalesInvoice(sideMenuController, getData(map, PATIENT_NAME, 0), "", "", getData(map, DATE, 0), "0.00", "STAGE");

            tabCount = sideMenuController.getCurrentTabCount(TAB_SALE);

        } catch (ElementClickInterceptedException e) {
            if (sideMenuController.getCheckBackUpPopUp())
                testWarningLog("Backup interrupted the test execution");
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = "openSalesBill")
    public void verifyExistingPatientName() {
        testCaseLog("verifyExistingPatientName");
        map.putAll(getTestDataWorkbook(DATA_VALIDATE_SALESBILL));
        _temp = getData(map, PATIENT_NAME, 0);
        salesBillController.setPatientName(tabCount, _temp);
        salesBillController.click(tabCount);
        salesBillVerification.verifyPatientName(tabCount, _temp);
        testStepsLog(_logStep++, _temp + " - Existing Patient Name is Added");
    }

    @Test(dependsOnMethods = "verifyExistingPatientName")
    public void verifyExistingDoctorName() {
        testCaseLog("verifyExistingDoctorName");
        map.putAll(getTestDataWorkbook(DATA_VALIDATE_SALESBILL));
        _temp = getData(map, DOCTOR_NAME, 0);
        salesBillController.setDoctorName(tabCount, _temp);
        salesBillController.click(tabCount);
        salesBillVerification.verifyDoctorName(tabCount, _temp);
        testStepsLog(_logStep++, _temp + " - Existing Doctor Name is Added");
    }

    @Test(dependsOnMethods = "verifyExistingDoctorName")
    public void verifyBarcodeDetails() {
        testCaseLog("verifyBarcodeDetails");
        map.putAll(getTestDataWorkbook(DATA_VALIDATE_SALESBILL));
        tabCount = sideMenuController.getCurrentTabCount(TAB_SALE);
        _temp = getData(map, BARCODE, 0);
        salesBillController.setBarcode(tabCount, _temp, 1);
        testStepsLog(_logStep++, _temp + " - Barcode is Entered");

        salesBillVerification.verifyBarcodeDetails(tabCount, 1, getData(map, MEDICINE_NAME, 0), getData(map, BATCH, 0), getData(map, EXPIRY, 0), getData(map, MRP, 0));
        testVerifyLog(_temp + " - Barcode details are Verified");
    }
}
