package com.projectName.testCases.salesBill;

import com.projectName.constants.DataConstantsSalesBill;
import com.projectName.constants.Validations;
import com.projectName.pageObjects.common.Controller.LoginPageController;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.projectName.pageObjects.salesBill.Controller.*;
import erp.auto.testing.projectName.pageObjects.salesBill.Controller.*;
import com.framework.init.WebDriverInit;
import com.projectName.pageObjects.salesBill.Verification.SalesBillVerification;
import com.projectName.pageObjects.salesBill.Verification.SalesOrderVerification;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class SB_01_ValidateSalesBill extends WebDriverInit implements DataConstantsSalesBill, Validations {

    HashMap<String, ArrayList<Object>> map = new HashMap<>();

    LoginPageController loginPageController = new LoginPageController(driver);
    SalesBillController salesBillController = new SalesBillController(driver);
    SalesBillVerification salesBillVerification = new SalesBillVerification(driver);
    SideMenuController sideMenuController = new SideMenuController(driver);
    CalculatorTabController calculatorTabController = new CalculatorTabController(driver);
    SalesOrderVerification salesOrderVerification = new SalesOrderVerification(driver);
    SalesOrderController salesOrderController = new SalesOrderController(driver);

    int tabCount;
    String _temp;

    @BeforeClass(alwaysRun = true)
    public void getLogin() {
        testCaseLog("Login");
        loginPageController.getSignin();
    }

    @Test(priority = 0)
    public void enterSalesBillDetails() {
        try {
            testCaseLog("enterSalesBillDetails");
            map.putAll(getTestDataWorkbook(DATA_VALIDATE_SALESBILL));

            salesOrderController.getDeleteSalesInvoice(sideMenuController, getData(map, PATIENT_NAME, 0), getData(map, DOCTOR_NAME, 0), getData(map, MODE_OF_PAYMENT, 0), getData(map, DATE, 0), getData(map, TOTAL_AMOUNT, 0), getData(map, SALES_STATUS, 0));
            new PatientsController(driver).getDeletePatient(getData(map, PATIENT_NAME, 0));
            new DoctorsController(driver).getDeleteDoctor(getData(map, DOCTOR_NAME, 0));

            tabCount = sideMenuController.getCurrentTabCount(TAB_SALE);

            _temp = getData(map, PATIENT_NAME, 0);
            salesBillController.setPatientName(tabCount, _temp);
            testStepsLog(_logStep++, _temp + " - Patient Name is Entered");

            _temp = getData(map, DOCTOR_NAME, 0);
            salesBillController.setDoctorName(tabCount, _temp);
            testStepsLog(_logStep++, _temp + " - Doctor Name is Entered");

            _temp = getData(map, SALES_HEADER_DISCOUNT, 0);
            salesBillController.setHeaderDiscount(tabCount, _temp);
            testStepsLog(_logStep++, _temp + " - Header Discount is Entered");

            _temp = getData(map, ADD_DISC, 0);
            salesBillController.setAddDiscount(tabCount, _temp);
            testStepsLog(_logStep++, _temp + " - Additional Discount is Entered");

            _temp = getData(map, MEDICINE_NAME, 0);
            salesBillController.setMedicineName(tabCount, _temp, 1);
            testStepsLog(_logStep++, _temp + " - Medicine is Entered");

            _temp = getData(map, BATCH, 0);
            salesBillController.setBatch(tabCount, _temp, 1);
            testStepsLog(_logStep++, _temp + " - Batch is Entered");

            _temp = getData(map, DISCOUNT_PERCENTAGE, 0);
            salesBillController.setMedicineDiscountPercentage(tabCount, _temp, 1);
            testStepsLog(_logStep++, _temp + " - Discount Percentage is Entered");

            _temp = getData(map, QUANTITY, 0);
            salesBillController.setQuantity(tabCount, _temp, 1);
            testStepsLog(_logStep++, _temp + " - Quantity is Entered");

            _temp = getData(map, LOOSE, 0);
            salesBillController.setLoose(tabCount, _temp, 1);
            testStepsLog(_logStep++, _temp + " - Loose is Entered");

            _temp = getData(map, REMARKS, 0);
            salesBillController.setRemarks(tabCount, _temp);
            testStepsLog(_logStep++, _temp + " - Remarks is Entered");

            _temp = getData(map, IS_HOME_DELIVERY, 0);
            if (salesBillController.isHomeDelivery(tabCount, _temp)) {
                testStepsLog(_logStep++, _temp + " - Home Delivery is Enabled");
            }

            _temp = getData(map, MODE_OF_PAYMENT, 0);
            salesBillController.setModeofPayment(tabCount, _temp);
            testStepsLog(_logStep++, _temp + " - Mode of Payment is Entered");
        } catch (ElementClickInterceptedException e) {
            if (sideMenuController.getCheckBackUpPopUp())
                testWarningLog("Backup interrupted the test execution");
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = "enterSalesBillDetails")
    public void verifyPatientName() {
        testCaseLog("verifyPatientName");
        _temp = getData(map, PATIENT_NAME, 0);
        salesBillVerification.verifyPatientName(tabCount, _temp);
        testVerifyLog(_temp + " - Patient name is Verified");
    }

    @Test(dependsOnMethods = "verifyPatientName")
    public void verifyDoctorName() {
        testCaseLog("verifyDoctorName");
        _temp = getData(map, DOCTOR_NAME, 0);
        salesBillVerification.verifyDoctorName(tabCount, _temp);
        testVerifyLog(_temp + " - Doctor name is Verified");
    }

    @Test(dependsOnMethods = "verifyDoctorName")
    public void verifyHeaderDiscount() {
        testCaseLog("verifyHeaderDiscount");
        _temp = getData(map, SALES_HEADER_DISCOUNT, 0);
        salesBillVerification.verifyHeaderDiscount(tabCount, _temp);
        testVerifyLog(_temp + " - Header Discount is Verified");
    }

    @Test(dependsOnMethods = "verifyHeaderDiscount")
    public void verifyAdditionalDiscount() {
        testCaseLog("verifyAdditionalDiscount");
        _temp = getData(map, ADD_DISC, 0);
        salesBillVerification.verifyAdditionalDiscount(tabCount, _temp);
        testVerifyLog(_temp + " - Additional Discount is Verified");
    }

    @Test(dependsOnMethods = "verifyHeaderDiscount")
    public void verifyDate() {
        testCaseLog("verifyDate");
        _temp = getCurrentDate();
        salesBillVerification.verifyDate(tabCount, _temp);
        testVerifyLog(_temp + " - Current date is Verified");
    }

    @Test(dependsOnMethods = "verifyDate")
    public void verifyMedicineName() {
        testCaseLog("verifyMedicineName");
        _temp = getData(map, MEDICINE_NAME, 0);
        salesBillVerification.verifyMedicineName(tabCount, _temp, 1);
        testVerifyLog(_temp + " - Medicine Name is Verified");
    }

    @Test(dependsOnMethods = "verifyMedicineName")
    public void verifyBatch() {
        testCaseLog("verifyBatch");
        _temp = getData(map, BATCH, 0);
        salesBillVerification.verifyBatch(tabCount, _temp, 1);
        testVerifyLog(_temp + " - Batch is Verified");
    }

    @Test(dependsOnMethods = "verifyBatch")
    public void verifyExpiry() {
        testCaseLog("verifyExpiry");
        _temp = getData(map, EXPIRY, 0);
        salesBillVerification.verifyExpiry(tabCount, _temp, 1);
        testVerifyLog(_temp + " - Expiry is Verified");
    }

    @Test(dependsOnMethods = "verifyExpiry")
    public void verifyMargin() {
        testCaseLog("verifyMargin");
        _temp = getData(map, MARGIN, 0);
        salesBillVerification.verifyMargin(tabCount, _temp, 1);
        testVerifyLog(_temp + " - Margin is Verified");
    }

    @Test(dependsOnMethods = "verifyMargin")
    public void verifyDiscountPercentage() {
        testCaseLog("verifyDiscountPercentage");
        _temp = getData(map, DISCOUNT_PERCENTAGE, 0);
        salesBillVerification.verifyDiscountPercentage(tabCount, _temp, 1);
        testVerifyLog(_temp + " - Discount Percentage is Verified");
    }

    @Test(dependsOnMethods = "verifyDiscountPercentage")
    public void verifyQuantity() {
        testCaseLog("verifyQuantity");
        _temp = getData(map, QUANTITY, 0);
        salesBillVerification.verifyQuantity(tabCount, _temp, 1);
        testVerifyLog(_temp + " - Quantity is Verified");
    }

    @Test(dependsOnMethods = "verifyQuantity")
    public void verifyLoose() {
        testCaseLog("verifyLoose");
        _temp = getData(map, LOOSE, 0);
        salesBillVerification.verifyLoose(tabCount, _temp, 1);
        testVerifyLog(_temp + " - Loose is Verified");
    }

    @Test(dependsOnMethods = "verifyQuantity")
    public void verifyMRP() {
        testCaseLog("verifyMRP");
        _temp = getData(map, MRP, 0);
        salesBillVerification.verifyMRP(tabCount, _temp, 1);
        testVerifyLog(_temp + " - MRP is Verified");
    }

    @Test(dependsOnMethods = "verifyMRP")
    public void verifyNetGST() {
        testCaseLog("verifyNetGST");
        _temp = getData(map, NET_GST, 0);
        salesBillVerification.verifyNetGst(tabCount, _temp, 1);
        testVerifyLog(_temp + " - Net GST is Verified");
    }

    @Test(dependsOnMethods = "verifyNetGST")
    public void verifyMedicineTotal() {
        testCaseLog("verifyMedicineTotal");
        _temp = getData(map, MEDICINE_TOTAL, 0);
        salesBillVerification.verifyMedicineTotal(tabCount, _temp, 1);
        testVerifyLog(_temp + " - Medicine Total is Verified");
    }

    @Test(dependsOnMethods = "verifyMedicineTotal")
    public void verifyModeOfPayment() {
        testCaseLog("verifyModeOfPayment");
        _temp = getData(map, MODE_OF_PAYMENT, 0);
        salesBillVerification.verifyModeOfPayment(tabCount, _temp);
        testVerifyLog(_temp + " - Mode of Payment is Verified");
    }

    @Test(dependsOnMethods = "verifyMedicineTotal")
    public void verifyRemarks() {
        testCaseLog("verifyRemarks");
        _temp = getData(map, REMARKS, 0);
        salesBillVerification.verifyRemarks(tabCount, _temp);
        testVerifyLog(_temp + " - Remarks is Verified");
    }

    @Test(dependsOnMethods = "verifyModeOfPayment")
    public void verifyFooterItems() {
        testCaseLog("verifyFooterItems");
        _temp = String.valueOf(map.get(MEDICINE_NAME).size());
        salesBillVerification.verifyFooterItems(tabCount, _temp);
        testVerifyLog(_temp + " - Footer Items is Verified");
    }

    @Test(dependsOnMethods = "verifyFooterItems")
    public void verifyFooterQuantity() {
        testCaseLog("verifyFooterQuantity");
        _temp = getData(map, QUANTITY, 0) + ":" + getData(map, LOOSE, 0);
        salesBillVerification.verifyFooterQuantity(tabCount, _temp);
        testVerifyLog(_temp + " - Footer Quantity is Verified");
    }

    @Test(dependsOnMethods = "verifyFooterQuantity")
    public void verifyDiscountRupees() {
        testCaseLog("verifyDiscountRupees");
        _temp = getData(map, DISCOUNT_RUPEES, 0);
        salesBillVerification.verifyDiscountRupees(tabCount, _temp);
        testVerifyLog(_temp + " - Discount Rupees is Verified");
    }

    @Test(dependsOnMethods = "verifyDiscountRupees")
    public void verifyBillAmount() {
        testCaseLog("verifyBillAmount");
        _temp = getData(map, BILL_AMOUNT, 0);
        salesBillVerification.verifyBillAmount(tabCount, _temp);
        testVerifyLog(_temp + " - Bill Amount is Verified");
    }

    @Test(dependsOnMethods = "verifyBillAmount")
    public void verifyFooterMargin() {
        testCaseLog("verifyFooterMargin");
        _temp = getData(map, FOOTER_MARGIN, 0);
        salesBillVerification.verifyFooterMargin(tabCount, _temp);
        testVerifyLog(_temp + " - Margin Percentage is Verified");
    }

    @Test(dependsOnMethods = "verifyFooterMargin")
    public void verifyTotalAmount() {
        testCaseLog("verifyTotalAmount");
        _temp = getData(map, TOTAL_AMOUNT, 0);
        salesBillVerification.verifyTotalAmount(tabCount, _temp);
        testVerifyLog(_temp + " - Total Amount is Verified");
    }

    @Test(dependsOnMethods = "verifyTotalAmount")
    public void createSalesBill() {
        testCaseLog("createSalesBill");
        salesBillController.getSaveSalesBill(tabCount, getData(map, AMOUNT_RECEIVED, 0), getData(map, TOTAL_AMOUNT, 0), getData(map, RETURN_AMOUNT, 0));
        if (!sideMenuController.checkAlertMessage(ALERT_SAVE_SUCCESS)) {
            calculatorTabController.getSave(tabCount);
        }
        sideMenuController.getAlertMessage();
        testStepsLog(_logStep++, getData(map, PATIENT_NAME, 0) + " - Sales Bill with the Patient is Created");
    }

    @Test(dependsOnMethods = "createSalesBill", groups = "ValidateSalesBill")
    public void verifySalesBill() {
        testCaseLog("verifySalesBill");
        tabCount = sideMenuController.openSalesOrder();
        salesOrderVerification.verifySalesBill(tabCount, getData(map, PATIENT_NAME, 0), getData(map, DOCTOR_NAME, 0),
                getData(map, MODE_OF_PAYMENT, 0), getData(map, TOTAL_AMOUNT, 0), getData(map, SALES_DISCOUNT_RUPEES, 0),
                getData(map, SALES_STATUS, 0), getData(map, DATE, 0));
    }

}
