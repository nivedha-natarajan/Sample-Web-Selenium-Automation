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

public class SB_05_ReturnCredit extends WebDriverInit implements DataConstantsSalesBill, Validations {

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

    @Test(priority = 4)
    public void verifyReturnMultipleMedicine() {
        try {
            testCaseLog("verifyReturnMultipleMedicine");
            map.putAll(getTestDataWorkbook(DATA_RETURN_SALES_BILL_THREE_MED));

            salesOrderController.getDeleteSalesInvoice(sideMenuController, getData(map, PATIENT_NAME, 0), getData(map, DOCTOR_NAME, 0), getData(map, PAYMENT_MODE, 0), getData(map, DATE, 0), getData(map, TOTAL_AMOUNT, 0), getData(map, SALES_STATUS, 0));

            tabCount = sideMenuController.getCurrentTabCount(TAB_SALE);

            salesBillController.setHeaderDetails(tabCount, getData(map, PATIENT_NAME, 0), getData(map, DOCTOR_NAME, 0), getData(map, SALES_HEADER_DISCOUNT, 0), getData(map, ADD_DISC, 0), getCurrentDate());

            salesBillController.setMedicineDetails(tabCount, map);
            salesBillController.getReturnMedicine(tabCount, Integer.parseInt(getData(map, RETURN_MEDICINE_COUNT, 0)), getData(map, QUANTITY, (Integer.parseInt(getData(map, RETURN_MEDICINE_COUNT, 0))) - 1));
            salesBillVerification.verifyTotalAmount(tabCount, getData(map, TOTAL_AMOUNT, 0));
            salesBillController.setFooterDetails(tabCount, getData(map, IS_HOME_DELIVERY, 0), getData(map, REMARKS, 0), getData(map, OUTSTANDING, 0), getData(map, MODE_OF_PAYMENT, 0),
                    getData(map, RECEIVED, 0), String.valueOf(map.get(MEDICINE_NAME).size()), getData(map, DISCOUNT_RUPEES, 0), getData(map, BILL_AMOUNT, 0),
                    getData(map, FOOTER_MARGIN, 0), getData(map, TOTAL_AMOUNT, 0), map);

            salesBillController.getSaveSalesBill(tabCount, getData(map, AMOUNT_RECEIVED, 0), getData(map, TOTAL_AMOUNT, 0), getData(map, RETURN_AMOUNT, 0));

            if (!sideMenuController.checkAlertMessage(ALERT_SAVE_SUCCESS)) {
                calculatorTabController.getSave(tabCount);
            }
            sideMenuController.getAlertMessage();
            testStepsLog(_logStep++, getData(map, PATIENT_NAME, 0) + " - Sales Bill with one Return medicine for the Patient is Created");
        } catch (ElementClickInterceptedException e) {
            if (sideMenuController.getCheckBackUpPopUp())
                testWarningLog("Backup interrupted the test execution");
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = "verifyReturnMultipleMedicine")
    public void verifySalesBill() {
        testCaseLog("verifySalesBill");
        tabCount = sideMenuController.openSalesOrder();
        salesOrderVerification.verifySalesBill(tabCount, getData(map, PATIENT_NAME, 0), getData(map, DOCTOR_NAME, 0),
                getData(map, MODE_OF_PAYMENT, 0), getData(map, TOTAL_AMOUNT, 0), getData(map, SALES_DISCOUNT_RUPEES, 0),
                getData(map, SALES_STATUS, 0), getData(map, DATE, 0));
    }
}