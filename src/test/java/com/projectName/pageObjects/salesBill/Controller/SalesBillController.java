package com.projectName.pageObjects.salesBill.Controller;

import com.projectName.constants.DataConstantsSalesBill;
import com.projectName.constants.Validations;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.projectName.pageObjects.salesBill.Verification.CalculatorTabVerification;
import com.framework.init.AbstractPage;
import com.projectName.pageObjects.salesBill.Verification.SalesBillVerification;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SalesBillController extends AbstractPage implements Validations, DataConstantsSalesBill {

    public SalesBillController(WebDriver driver) {
        super(driver);
    }

    CalculatorTabController calculatorTabController = new CalculatorTabController(driver);
    CalculatorTabVerification calculatorTabVerification = new CalculatorTabVerification(driver);

    private WebElement txtbx_Patient;
    private List<WebElement> list_Patient;
    private WebElement slt_AddPatient;
    private WebElement clk_AddPatient;
    private WebElement txtbx_Doctor;
    private List<WebElement> list_Doctor;
    private WebElement slt_AddDoctor;
    private WebElement clk_AddDoctor;
    private WebElement txtbx_Discount;
    private WebElement txtbx_Invoice;
    private WebElement txtbx_AddDisc;
    private WebElement txtbx_Date;
    private WebElement txtbx_SearchMedicine;
    private WebElement slt_SearchMedicine;
    private WebElement txtbx_Batch;
    private WebElement txtbx_Barcode;
    private WebElement slt_BatchList;
    private WebElement txt_Expiry;
    private WebElement txt_Margin;
    private WebElement txtbx_DiscountPercentage;
    private WebElement txtbx_Quantity;
    private WebElement txtbx_Loose;

    private WebElement txtbx_MRP;
    private WebElement txt_NetGST;
    private WebElement txt_Total;
    private WebElement txtbx_Remarks;
    private WebElement txt_Outstanding;
    private WebElement chkbx_HomeDelivery;
    private WebElement clk_ModeOfPayment;
    private WebElement slt_ModeOfPayment;
    private WebElement txtbx_Received;

    private WebElement txt_SelectedTotal;
    private WebElement txt_Items;
    private WebElement txt_Quantity;
    private WebElement txt_DiscountRupees;
    private WebElement txt_BillAmount;
    private WebElement txt_MarginPercentage;
    private WebElement txt_TotalAmount;
    private WebElement btn_Save;
    private WebElement btn_SaveAndPrint;

    private WebElement slt_AllMedicine;
    private WebElement slt_ParticularMedicine;
    private WebElement clk_AddRow;
    private WebElement clk_CancelRow;
    private List<WebElement> txt_MedicineRow;
    private WebElement txt_LoadedTerminal;
    private WebElement btn_Unlock;
    private WebElement txt_SuperAdmin;
    private WebElement txtbx_Username;
    private WebElement txtbx_Password;
    private WebElement btn_Authenticate;
    private WebElement btn_AddRow;


    private WebElement getBtn_AddRow(int tabCount) {
        btn_AddRow = driver.findElement(By.xpath("//div[@id='addMedTuttabCon_" + tabCount + "']/span"));
        return btn_AddRow;
    }

    private WebElement getTxtbx_Patient(int tabCount) {
        txtbx_Patient = driver.findElement(By.xpath("//input[@id='pat' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Patient;
    }

    public List<WebElement> getList_Patient(String patient) {
        list_Patient = driver.findElements(By.xpath("//ul[contains(@id,'ui-id')]/li/a[starts-with(text(),'" + patient + "')]"));
        return list_Patient;
    }

    private WebElement getSlt_AddPatient(String patient) {
        slt_AddPatient = driver.findElement(By.xpath("//ul[contains(@id,'ui-id')]/li/a[starts-with(text(),'" + patient + "')][1]"));
        return slt_AddPatient;
    }

    private WebElement getClk_AddPatient(int tabCount) {
        clk_AddPatient = driver.findElement(By.xpath("//div[@id='patTuttabCon_" + tabCount + "']//div/span[contains(@onclick,'openSidebar')]/span"));
        return clk_AddPatient;
    }

    private WebElement getTxtbx_Doctor(int tabCount) {
        txtbx_Doctor = driver.findElement(By.xpath("//input[@id='doc' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Doctor;
    }

    public List<WebElement> getList_Doctor(String doctor) {
        list_Doctor = driver.findElements(By.xpath("//ul[contains(@id,'ui-id')]/li/a[text()='" + doctor + "']"));
        return list_Doctor;
    }

    private WebElement getSlt_AddDoctor(String doctor) {
        slt_AddDoctor = driver.findElement(By.xpath("//ul[contains(@id,'ui-id')]/li/a[starts-with(text(),'" + doctor + "')][1]"));
        return slt_AddDoctor;
    }

    private WebElement getClk_AddDoctor(int tabCount) {
        clk_AddDoctor = driver.findElement(By.xpath("//span[contains(@onclick,'tabCon_" + tabCount + "')]/spailln[@id='editDoctorIcon']"));
        return clk_AddDoctor;
    }

    private WebElement getTxtbx_Discount(int tabCount) {
        txtbx_Discount = driver.findElement(By.xpath("//input[@id='billLevelDiscount' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Discount;
    }

    private WebElement getTxtbx_Invoice(int tabCount) {
        txtbx_Invoice = driver.findElement(By.xpath("//input[@id='invoice' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Invoice;
    }

    private WebElement getTxtbx_AddDisc(int tabCount) {
        txtbx_AddDisc = driver.findElement(By.xpath("//input[@data-bind='value:extraDiscount' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_AddDisc;
    }

    private WebElement getTxtbx_Date(int tabCount) {
        txtbx_Date = driver.findElement(By.xpath("//input[@id='createdAt' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Date;
    }

    private WebElement getTxtbx_SearchMedicine(int tabCount, int row) {
        txtbx_SearchMedicine = driver.findElement(By.xpath("(//td/input[contains(@id,'tabCon_" + tabCount + "_search_medicine')])[" + row + "]"));
        return txtbx_SearchMedicine;
    }

    private WebElement getSlt_SearchMedicine(String medicineName, int count) {
        slt_SearchMedicine = driver.findElement(By.xpath("(//ul[contains(@id,'ui-id')]/li/a/strong[contains(text(),'" + medicineName + "')])[" + count + "]"));
        return slt_SearchMedicine;
    }

    private WebElement getClk_Batch(int tabCount, int row) {
        txtbx_Batch = driver.findElement(By.xpath("(//div/button[contains(@data-id,'tabCon_" + tabCount + "_select')])[" + row + "]"));
        return txtbx_Batch;
    }

    private WebElement getSlt_BatchList(int tabCount, String batch, int row) {
        slt_BatchList = driver.findElement(By.xpath("(//div[contains(@id,'tabCon_" + tabCount + "_batch')]//a/span[contains(text(),'" + batch + "')])[" + row + "]"));
        return slt_BatchList;
    }

    private WebElement getTxtbx_Barcode(int tabCount, int row) {
        txtbx_Barcode = driver.findElement(By.xpath("//input[@id='tabCon_" + tabCount + "_barcode_" + (row - 1) + "']"));
        return txtbx_Barcode;
    }

    private WebElement getSlt_Barcode(String barcode) {
        txtbx_Barcode = driver.findElement(By.xpath("//li[contains(@id,'ui-id')]/a/strong[text()='" + barcode + "']"));
        return txtbx_Barcode;
    }

    private WebElement getTxt_Expiry(int tabCount, int row) {
        txt_Expiry = driver.findElement(By.xpath("(//div[@id='medTuttabCon_" + tabCount + "']//td/label[contains(@data-bind,'batchExpiry')])[" + row + "]"));
        return txt_Expiry;
    }

    private WebElement getTxt_Margin(int tabCount, int row) {
        txt_Margin = driver.findElement(By.xpath("//div[@id='medTuttabCon_" + tabCount + "']//label[@class='control-label marginLabel']/span[@highlightindex='" + (row - 1) + "']"));
        return txt_Margin;
    }

    private WebElement getTxtbx_DiscountPercentage(int tabCount, int row) {
        txtbx_DiscountPercentage = driver.findElement(By.xpath("(//td/div/span/input[contains(@data-bind,'value:discPer') and @tab='tabCon_" + tabCount + "'])[" + row + "]"));
        return txtbx_DiscountPercentage;
    }

    private WebElement getTxtbx_Quantity(int tabCount, int row) {
        txtbx_Quantity = driver.findElement(By.xpath("//input[contains(@id,'tabCon_" + tabCount + "_qty') and @highlightindex='" + (row - 1) + "']"));
        return txtbx_Quantity;
    }

    private WebElement getTxtbx_Loose(int tabCount, int row) {
        txtbx_Loose = driver.findElement(By.xpath("(//input[contains(@data-bind,'value:loose') and @tab='tabCon_" + tabCount + "'])[" + row + "]"));
        return txtbx_Loose;
    }

    private WebElement getTxtbx_MRP(int tabCount, int row) {
        txtbx_MRP = driver.findElement(By.xpath("//input[contains(@id,'tabCon_" + tabCount + "_perSKU') and @highlightindex='" + (row - 1) + "']"));
        return txtbx_MRP;
    }

    private WebElement getTxt_NetGST(int tabCount, int row) {
        txt_NetGST = driver.findElement(By.xpath("(//input[contains(@data-bind,'value:netGstValue') and @tab='tabCon_" + tabCount + "'])[" + row + "]"));
        return txt_NetGST;
    }

    private WebElement getTxt_Total(int tabCount, int row) {
        txt_Total = driver.findElement(By.xpath("(//tr/td/div/input[@tab='tabCon_" + tabCount + "' and contains(@data-bind,'value:discPrice')])[" + row + "]"));
        return txt_Total;
    }

    private WebElement getTxtbx_Remarks(int tabCount) {
        txtbx_Remarks = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//input[@id='mainRemark']"));
        return txtbx_Remarks;
    }

    private WebElement getTxt_Outstanding(int tabCount) {
        txt_Outstanding = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[2]/div/label[contains(@data-bind,'pendAmt')]"));
        return txt_Outstanding;
    }

    private WebElement getChkbx_HomeDelivery(int tabCount) {
        chkbx_HomeDelivery = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//td/span/div/input"));
        return chkbx_HomeDelivery;
    }

    private WebElement getClk_ModeOfPayment(int tabCount) {
        clk_ModeOfPayment = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//td[2]/div/div/button"));
        return clk_ModeOfPayment;
    }

    private WebElement getSlt_ModeOfPayment(int tabCount, String mop) {
        slt_ModeOfPayment = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//td[2]//div/ul/li/a/span[text()='" + mop + "']"));
        return slt_ModeOfPayment;
    }

    private WebElement getTxtbx_Received(int tabCount) {
        txtbx_Received = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//input[@data-bind='value:payNow']"));
        return txtbx_Received;
    }

    private WebElement getTxt_SelectedTotal(int tabCount) {
        txt_SelectedTotal = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//input[@data-bind='value:subAmt']"));
        return txt_SelectedTotal;
    }

    private WebElement getTxt_Items(int tabCount) {
        txt_Items = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//label[text()='Items/Qty']/parent::td/label[@data-bind='text: items']"));
        return txt_Items;
    }

    private WebElement getTxt_Quantity(int tabCount) {
        txt_Quantity = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//label[text()='Items/Qty']/parent::td/label[@data-bind='text: totalQty']"));
        ;
        return txt_Quantity;
    }

    private WebElement getTxt_DiscountRupees(int tabCount) {
        txt_DiscountRupees = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div//label[contains(@data-bind,'discount')]"));
        ;
        return txt_DiscountRupees;
    }

    private WebElement getTxt_BillAmount(int tabCount) {
        txt_BillAmount = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div//label[@data-bind='text: amount']"));
        return txt_BillAmount;
    }

    private WebElement getTxt_MarginPercentage(int tabCount) {
        txt_MarginPercentage = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div//label[@data-bind='text: grossMarginPercent']"));
        return txt_MarginPercentage;
    }

    private WebElement getTxt_TotalAmount(int tabCount) {
        txt_TotalAmount = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div//label[text()='Total Amount']/parent::div/label[@data-bind='text: finalAmt']"));
        return txt_TotalAmount;
    }

    private WebElement getBtn_Save(int tabCount) {
        btn_Save = driver.findElement(By.xpath("//button[text()='Save' and @tab='tabCon_" + tabCount + "']"));
        return btn_Save;
    }

    private WebElement getBtn_SaveAndPrint(int tabCount) {
        btn_SaveAndPrint = driver.findElement(By.xpath("//button[@id='saveandPrintSales' and @tab='tabCon_" + tabCount + "']"));
        return btn_SaveAndPrint;
    }

    private WebElement getClk_AddRow(int tabCount) {
        clk_AddRow = driver.findElement(By.xpath("//div[@id='addMedTuttabCon_" + tabCount + "']/span"));
        return clk_AddRow;
    }

    private WebElement getClk_CancelRow(int tabCount, int row) {
        clk_CancelRow = driver.findElement(By.xpath("(//div[@id='tabCon_" + tabCount + "']//tbody/tr/td[contains(@class,'quantTab')]/div/span)[" + row + "]"));
        return clk_CancelRow;
    }

    private List<WebElement> getTxt_MedicineRow(int tabCount) {
        txt_MedicineRow = driver.findElements(By.xpath("//input[contains(@id,'tabCon_" + tabCount + "_search_medicine')]"));
        return txt_MedicineRow;
    }

    private WebElement getTxt_LoadedTerminal(int tabCount) {
        txt_LoadedTerminal = driver.findElement(By.xpath("//div[contains(@id,'tabCon_" + tabCount + "')]/div/span[contains(text(),'Admin has loaded the bill on terminal')]"));
        return txt_LoadedTerminal;
    }

    private WebElement getBtn_Unlock(int tabCount) {
        btn_Unlock = driver.findElement(By.xpath("//button[@id='unlockButton' and @tab='tabCon_" + tabCount + "']"));
        return btn_Unlock;
    }

    private WebElement getTxt_SuperAdmin(int tabCount) {
        txt_SuperAdmin = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div[@id='superAdmin']/div/h2"));
        return txt_SuperAdmin;
    }

    private WebElement getTxtbx_Username(int tabCount) {
        txtbx_Username = driver.findElement(By.xpath("//input[@id='superAdminUsername' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Username;
    }

    private WebElement getTxtbx_Password(int tabCount) {
        txtbx_Password = driver.findElement(By.xpath("//input[@id='superAdminPassword' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Password;
    }

    private WebElement getBtn_Authenticate(int tabCount) {
        btn_Authenticate = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//button[@id='authenticate']"));
        return btn_Authenticate;
    }

    public void getUnlockSalesInvoice(int tabCount, String username, String password) {
        if (clickUnlockSales(tabCount)) {
            setSuperAdminCredentials(tabCount, username, password);
            new SideMenuController(driver).checkAlertMessage(ALERT_UNLOCK_SUCCESS);
            pause();
        }
    }

    public int getExistingMedicineCount(int tabCount) {
        return getTxt_MedicineRow(tabCount).size();
    }

    public void getDeleteExistingMedicineRow(int tabCount) {
        int size = getExistingMedicineCount(tabCount);
        for (int i = 1; i <= size; i++) {
            clickOn(driver, getClk_CancelRow(tabCount, i));
        }
    }

    public boolean clickUnlockSales(int tabCount) {
        if (new SalesBillVerification(driver).verifyUnlockSalesInvoice(tabCount)) {
            clickOn(driver, getBtn_Unlock(tabCount));
            return true;
        }
        return false;
    }

    public void setSuperAdminCredentials(int tabCount, String username, String password) {
        if (new SalesBillVerification(driver).verifySuperAdminTab(tabCount)) {
            typeSlow(driver, getTxtbx_Username(tabCount), username);
            typeSlow(driver, getTxtbx_Password(tabCount), password);
            clickOn(driver, getBtn_Authenticate(tabCount));
        }
    }

    public void click(int tabCount) {
        clickOn(driver, getTxtbx_Discount(tabCount));
    }

    public void setInvoice(int tabCount, String invoice) {
        typeSlow(driver, getTxtbx_Invoice(tabCount), invoice);
        click(tabCount);
        pause(2);
    }

    public void setPatientName(int tabCount, String patient) {
        boolean _flag = false;
        typeSlow(driver, getTxtbx_Patient(tabCount), patient);
        pause();
        if (getList_Patient(patient).size() > 0) {
            clickOn(driver, getSlt_AddPatient(patient));
        } else {
            clickOn(driver, getSlt_AddPatient("Add - " + patient));
            _flag = true;
        }
        if (_flag) {
            new AddPatientController(driver).getAddPatientSave(tabCount);
        }
    }

    public void setDoctorName(int tabCount, String doctor) {
        boolean _flag = false;
        typeSlow(driver, getTxtbx_Doctor(tabCount), doctor);
        pause();
        if (getList_Doctor(doctor).size() > 0) {
            clickOn(driver, getSlt_AddDoctor(doctor));
        } else {
            clickOn(driver, getSlt_AddDoctor("Add - " + doctor));
            _flag = true;
        }
        if (_flag) {
            new AddDoctorController(driver).getAddDoctorSave(tabCount);
        }
    }

    public void setHeaderDiscount(int tabCount, String headerDiscount) {
        typeSlow(driver, getTxtbx_Discount(tabCount), headerDiscount);
    }

    public void setAddDiscount(int tabCount, String addDiscount) {
        typeSlow(driver, getTxtbx_AddDisc(tabCount), addDiscount);
    }

    public void setDate(int tabCount, String date) {
        typeSlow(driver, getTxtbx_Date(tabCount), date);
        click(tabCount);
    }

    public void getEnterHeaderDetails(int tabCount, String patientName, String doctorName, String headerDiscount, String addDisc, String date) {
        setPatientName(tabCount, patientName);
        setDoctorName(tabCount, doctorName);
        setHeaderDiscount(tabCount, headerDiscount);
        setAddDiscount(tabCount, addDisc);
        new SalesBillVerification(driver).verifyHeaderDetails(tabCount, patientName, doctorName, headerDiscount, addDisc, date);
        testStepsLog(_logStep++, "Sales Header Details are Entered");
    }

    public void setMedicineName(int tabCount, String medicine, int row) {
        typeSlow(driver, getTxtbx_SearchMedicine(tabCount, row), medicine);
        pause();
        clickOn(driver, getSlt_SearchMedicine(medicine, 1));
    }

    public void setBatch(int tabCount, String batch, int row) {
        clickOn(driver, getClk_Batch(tabCount, row));
        clickOn(driver, getSlt_BatchList(tabCount, batch, 1));
    }

    public void setBarcode(int tabCount, String barcode, int row) {
        type(getTxtbx_Barcode(tabCount, row), barcode);
        try {
            clickOn(driver, getSlt_Barcode(barcode));
        } catch (Exception ignored) {
        }
        click(tabCount);
    }

    public void setMedicineDiscountPercentage(int tabCount, String discPercentage, int row) {
        typeSlow(driver, getTxtbx_DiscountPercentage(tabCount, row), discPercentage);
    }

    public void setQuantity(int tabCount, String qty, int row) {
        typeSlow(driver, getTxtbx_Quantity(tabCount, row), qty);
    }

    public void setLoose(int tabCount, String loose, int row) {
        typeSlow(driver, getTxtbx_Loose(tabCount, row), loose);
    }

    public void setMRP(int tabCount, String mrp, int row) {
        typeSlow(driver, getTxtbx_MRP(tabCount, row), mrp);
    }

    public void setMedicineDetails(int tabCount, HashMap<String, ArrayList<Object>> map) {
        for (int i = 1; i <= map.get(MEDICINE_NAME).size(); i++) {
            setMedicineName(tabCount, getData(map, MEDICINE_NAME, i - 1), i);
            setBatch(tabCount, getData(map, BATCH, i - 1), i);
            setMedicineDiscountPercentage(tabCount, getData(map, DISCOUNT_PERCENTAGE, i - 1), i);
            setQuantity(tabCount, getData(map, QUANTITY, i - 1), i);
            setLoose(tabCount, getData(map, LOOSE, i - 1), i);
            click(tabCount);
            new SalesBillVerification(driver).verifyMedicineDetails(tabCount, i, getData(map, MEDICINE_NAME, i - 1), getData(map, BATCH, i - 1), getData(map, EXPIRY, i - 1),
                    getData(map, MARGIN, i - 1), getData(map, DISCOUNT_PERCENTAGE, i - 1), getData(map, QUANTITY, i - 1),
                    getData(map, LOOSE, i - 1), getData(map, MRP, i - 1), getData(map, NET_GST, i - 1), getData(map, MEDICINE_TOTAL, i - 1));
            clickOn(driver, getBtn_AddRow(tabCount));
        }
        testStepsLog(_logStep++, "Medicine Details are Entered");
        testVerifyLog("Sales Bill Medicine Details are Verified");
    }

    public void setRemarks(int tabCount, String remarks) {
        clickOn(driver, getTxtbx_Remarks(tabCount));
        typeSlow(driver, getTxtbx_Remarks(tabCount), remarks);
    }

    public boolean isHomeDelivery(int tabCount, String homeDelivery) {
        if (homeDelivery.equalsIgnoreCase("Yes")) {
            clickOn(driver, getChkbx_HomeDelivery(tabCount));
            return true;
        }
        return false;
    }

    public void setModeofPayment(int tabCount, String mop) {
        clickOn(driver, getClk_ModeOfPayment(tabCount));
        clickOn(driver, getSlt_ModeOfPayment(tabCount, mop.toLowerCase()));
    }

    public void getSaveSalesBill(int tabCount, String amountReceived, String totalAmount, String returnAmount) {
        clickOn(driver, getBtn_Save(tabCount));
        if (calculatorTabVerification.verifyCalculatorTabOpened(tabCount)) {
            calculatorTabController.setAmountReceived(tabCount, amountReceived);
            calculatorTabVerification.verifyAmounts(tabCount, totalAmount, amountReceived, returnAmount);
            calculatorTabController.getSave(tabCount);
        }
    }

    public void getSaveAndPrintSalesBill(int tabCount) {
        clickOn(driver, getBtn_SaveAndPrint(tabCount));
    }

    public void setFooterDetails(int tabCount, String isHomeDelivery, String remarks, String outstanding, String mop, String received, String footerItem,
                                 String discRupees, String billAmount, String footerMargin, String totalAmount, HashMap<String, ArrayList<Object>> map) {

        setRemarks(tabCount, remarks);
        isHomeDelivery(tabCount, isHomeDelivery);
        setModeofPayment(tabCount, mop);
        String footerQuantity;
        int quantity = 0;
        int loose = 0;
        for (int i = 0; i < map.get(MEDICINE_NAME).size(); i++) {
            quantity = quantity + Integer.parseInt(getData(map, QUANTITY, i));
            loose = loose + Integer.parseInt(getData(map, LOOSE, i));
        }
        if (loose != 0) {
            footerQuantity = String.valueOf(quantity) + ":" + String.valueOf(loose);
        } else {
            footerQuantity = String.valueOf(quantity);
        }
        testStepsLog(_logStep++, "Footer Details are Entered");
        new SalesBillVerification(driver).verifyFooterDetails(tabCount, isHomeDelivery, remarks, outstanding, mop, received, footerItem, footerQuantity,
                discRupees, billAmount, footerMargin, totalAmount);
    }

    public void getReturnMedicine(int tabCount, int row, String quantity) {
        type(getTxtbx_Quantity(tabCount, 1), quantity);
        getTxtbx_MRP(tabCount, row).sendKeys(Keys.chord(Keys.CONTROL + "e"));
    }

    public void setHeaderDetails(int tabCount, String patientName, String doctorName, String headerDiscount, String addDiscount, String date) {
        setPatientName(tabCount, patientName);
        setDoctorName(tabCount, doctorName);
        setHeaderDiscount(tabCount, headerDiscount);
        setAddDiscount(tabCount, addDiscount);
        testStepsLog(_logStep++, "Header details are Entered");
        new SalesBillVerification(driver).verifyHeaderDetails(tabCount, patientName, doctorName, headerDiscount, addDiscount, date);
    }
}
