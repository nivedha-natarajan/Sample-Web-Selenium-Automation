package com.projectName.testCases.salesBill;

import com.projectName.constants.DataConstantsSalesBill;
import com.projectName.constants.Validations;
import com.projectName.pageObjects.common.Controller.LoginPageController;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.projectName.pageObjects.salesBill.Controller.CalculatorTabController;
import com.projectName.pageObjects.salesBill.Controller.SalesBillController;
import com.projectName.pageObjects.salesBill.Controller.SalesOrderController;
import com.projectName.pageObjects.salesBill.Verification.SalesBillVerification;
import com.projectName.pageObjects.salesBill.Verification.SalesOrderVerification;
import com.framework.init.WebDriverInit;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class SB_06_VerifyEditInvoice extends WebDriverInit implements DataConstantsSalesBill, Validations {

    HashMap<String, ArrayList<Object>> map = new HashMap<>();

    LoginPageController loginPageController = new LoginPageController(driver);
    SalesBillController salesBillController = new SalesBillController(driver);
    SideMenuController sideMenuController = new SideMenuController(driver);
    SalesOrderVerification salesOrderVerification = new SalesOrderVerification(driver);
    SalesOrderController salesOrderController = new SalesOrderController(driver);
    CalculatorTabController calculatorTabController = new CalculatorTabController(driver);
    SalesBillVerification salesBillVerification = new SalesBillVerification(driver);

    int tabCount;

    @BeforeClass(alwaysRun = true)
    public void getLogin() {
        testCaseLog("Login");
        loginPageController.getSignin();
    }

    @Test(priority = 5, dependsOnGroups = "ValidateSalesBill")
    public void verifyEditSalesBill() {
        try {
            testCaseLog("verifyEditSalesBill");
            map.putAll(getTestDataWorkbook(DATA_VALIDATE_SALESBILL));

            tabCount = salesOrderController.getEditSalesInvoice(sideMenuController, getData(map, PATIENT_NAME, 0), getData(map, DOCTOR_NAME, 0), getData(map, PAYMENT_MODE, 0), getData(map, DATE, 0), getData(map, TOTAL_AMOUNT, 0), getData(map, SALES_STATUS, 0));

            salesBillVerification.verifySalesBill(tabCount, map);

            salesBillController.getSaveSalesBill(tabCount, getData(map, AMOUNT_RECEIVED, 0), getData(map, TOTAL_AMOUNT, 0), getData(map, RETURN_AMOUNT, 0));

            if (!sideMenuController.checkAlertMessage(ALERT_SAVE_SUCCESS)) {
                calculatorTabController.getSave(tabCount);
            }
            sideMenuController.getAlertMessage();
            testStepsLog(_logStep++, getData(map, PATIENT_NAME, 0) + " - Edited Sales Bill with one Return medicine for the Patient is Saved");
        } catch (ElementClickInterceptedException e) {
            if (sideMenuController.getCheckBackUpPopUp())
                testWarningLog("Backup interrupted the test execution");
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = "verifyEditSalesBill")
    public void verifySalesBill() {
        testCaseLog("verifySalesBill");
        map.putAll(getTestDataWorkbook(DATA_RETURN_SALES_BILL_THREE_MED));
        tabCount = sideMenuController.openSalesOrder();
        salesOrderVerification.verifySalesBill(tabCount, getData(map, PATIENT_NAME, 0), getData(map, DOCTOR_NAME, 0),
                getData(map, MODE_OF_PAYMENT, 0), getData(map, TOTAL_AMOUNT, 0), getData(map, SALES_DISCOUNT_RUPEES, 0),
                getData(map, SALES_STATUS, 0), getData(map, DATE, 0));
    }
}
