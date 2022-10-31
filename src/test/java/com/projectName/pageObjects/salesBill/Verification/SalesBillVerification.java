package com.projectName.pageObjects.salesBill.Verification;

import com.projectName.constants.DataConstantsSalesBill;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SalesBillVerification extends AbstractPage implements DataConstantsSalesBill {

    public SalesBillVerification(WebDriver driver) {
        super(driver);
    }

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
    private WebElement list_ModeOfPayment;
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

    private WebElement getTxtbx_SalesInvoice(int tabCount) {
        txtbx_Invoice = driver.findElement(By.xpath("//input[@id='salesInvoice' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Invoice;
    }

    private WebElement getTxtbx_AddDisc(int tabCount) {
        txtbx_AddDisc = driver.findElement(By.xpath("//div[@id='patTuttabCon_" + tabCount + "']/div/label[text()='Add.Disc']/parent::div/input"));
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

    private WebElement get_HomeDelivery(int tabCount) {
        chkbx_HomeDelivery = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//td/span/div/input"));
        return chkbx_HomeDelivery;
    }

    private WebElement getClk_ModeOfPayment(int tabCount) {
        clk_ModeOfPayment = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//td[2]/div/div/button/span"));
        return clk_ModeOfPayment;
    }

    private WebElement getList_ModeOfPayment(int tabCount, String mop) {
        list_ModeOfPayment = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//td[2]//div/ul/li/a/span[text()='" + mop + "']"));
        return list_ModeOfPayment;
    }

    private WebElement getTxtbx_Received(int tabCount) {
        txtbx_Received = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//input[contains(@data-bind,'value:payNow')]"));
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
        return txt_Quantity;
    }

    private WebElement getTxt_DiscountRupees(int tabCount) {
        txt_DiscountRupees = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div//label[contains(@data-bind,'discount')]"));
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
        txt_TotalAmount = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div//label[text()='Total Amount']/parent::div//label[@data-bind='text: finalAmt']"));
        return txt_TotalAmount;
    }

    private WebElement getBtn_Save(int tabCount) {
        btn_Save = driver.findElement(By.xpath("//button[@id='saveSalesBill' and @tab='tabCon_" + tabCount + "']"));
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

    public boolean verifyUnlockSalesInvoice(int tabCount) {
        try {
            isElementDisplay(getTxt_LoadedTerminal(tabCount));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean verifySuperAdminTab(int tabCount) {
        return isElementDisplay(getTxt_SuperAdmin(tabCount));
    }

    public void verifyPatientName(int tabCount, String patient) {
        Assert.assertTrue(getValue(getTxtbx_Patient(tabCount)).contains(patient), "Patient Name is not Matching");
    }

    public void verifyDoctorName(int tabCount, String doctor) {
        Assert.assertTrue(getValue(getTxtbx_Doctor(tabCount)).contains(doctor), "Doctor Name is not Matching");
    }

    public void verifyHeaderDiscount(int tabCount, String headerDiscount) {
        Assert.assertEquals(getValue(getTxtbx_Discount(tabCount)), headerDiscount, "Header Discount is not Matching");
    }

    public void verifyInvoice(int tabCount, String invoice) {
        Assert.assertEquals(getValue(getTxtbx_SalesInvoice(tabCount)), invoice, "Invoice is not Matching");
    }

    public void verifyAdditionalDiscount(int tabCount, String addDisc) {
        Assert.assertEquals(getTxtbx_AddDisc(tabCount).getAttribute("prev_data"), addDisc, "Additional Discount is not Matching");
    }

    public void verifyDate(int tabCount, String date) {
        Assert.assertEquals(getValue(getTxtbx_Date(tabCount)), date, "Date is not Matching");
    }

    public void verifyHeaderDetails(int tabCount, String patient, String doctor, String headerDiscount, String addDisc, String date) {
        verifyPatientName(tabCount, patient);
        verifyDoctorName(tabCount, doctor);
        verifyHeaderDiscount(tabCount, headerDiscount);
        verifyAdditionalDiscount(tabCount, addDisc);
        verifyDate(tabCount, date);
        testVerifyLog("Sales Bill Header Details are Verified");
    }

    public void verifyMedicineName(int tabCount, String medicine, int row) {
        Assert.assertTrue(getValue(getTxtbx_SearchMedicine(tabCount, row)).startsWith(medicine), "Expected - " + medicine + " ; Actual - " + getValue(getTxtbx_SearchMedicine(tabCount, row)) + " ; Medicine Name is not Matching");
    }

    public void verifyBatch(int tabCount, String batch, int row) {
        Assert.assertTrue(getClk_Batch(tabCount, row).getText().contains(batch), "Batch is not Matching");
    }

    public void verifyExpiry(int tabCount, String expiry, int row) {
        Assert.assertTrue(getTxt_Expiry(tabCount, row).getText().equalsIgnoreCase(expiry), "Expiry is not Matching");
    }

    public void verifyMargin(int tabCount, String margin, int row) {
        Assert.assertTrue(getTxt_Margin(tabCount, row).getText().contains(margin), "Margin is not Matching");
    }

    public void verifyDiscountPercentage(int tabCount, String discPercentage, int row) {
        Assert.assertEquals(getValue(getTxtbx_DiscountPercentage(tabCount, row)), discPercentage, "Discount Percentage is not Matching");
    }

    public void verifyQuantity(int tabCount, String qty, int row) {
        Assert.assertEquals(getValue(getTxtbx_Quantity(tabCount, row)), qty, "Quantity is not Matching");
    }

    public void verifyLoose(int tabCount, String loose, int row) {
        Assert.assertEquals(getValue(getTxtbx_Loose(tabCount, row)), loose, "Loose is not Matching");
    }

    public void verifyMRP(int tabCount, String mrp, int row) {
        Assert.assertEquals(getValue(getTxtbx_MRP(tabCount, row)), mrp, "MRP is not Matching");
    }

    public void verifyNetGst(int tabCount, String netGst, int row) {
        Assert.assertEquals(getValue(getTxt_NetGST(tabCount, row)), netGst, "Net GST is not Matching");
    }

    public void verifyMedicineTotal(int tabCount, String total, int row) {
        Assert.assertEquals(getValue(getTxt_Total(tabCount, row)), total, "Medicine Total is not Matching");
    }

    public void verifyMedicineDetails(int tabCount, int row, String medicine, String batch, String expiry, String margin, String discPercentage,
                                      String qty, String loose, String mrp, String netGst, String total) {
        verifyMedicineName(tabCount, medicine, row);
        verifyBatch(tabCount, batch, row);
//            verifyExpiry(tabCount, expiry, row);
        verifyMargin(tabCount, margin, row);
        verifyDiscountPercentage(tabCount, discPercentage, row);
        verifyQuantity(tabCount, qty, row);
        verifyLoose(tabCount, loose, row);
        verifyMRP(tabCount, mrp, row);
        verifyNetGst(tabCount, netGst, row);
        verifyMedicineTotal(tabCount, total, row);
    }

    public void verifyRemarks(int tabCount, String remarks) {
        Assert.assertEquals(getValue(getTxtbx_Remarks(tabCount)), remarks, "Remarks is not Matching");
    }

    public void verifyOutstanding(int tabCount, String outstanding) {
        Assert.assertEquals(getTxt_Outstanding(tabCount).getText(), outstanding, "Outstanding is not Matching");
    }

    public void verifyModeOfPayment(int tabCount, String mop) {
        Assert.assertEquals(getClk_ModeOfPayment(tabCount).getText(), mop, "Mode of Payment is not Matching");
    }

    public void verifyReceived(int tabCount, String received) {
        Assert.assertEquals(getValue(getTxtbx_Received(tabCount)), received, "Received is not Matching");
    }

    public void verifyFooterItems(int tabCount, String items) {
        try {
            getClk_CancelRow(tabCount, Integer.parseInt(items) + 1);
        } catch (Exception ignored) {
        }
        Assert.assertEquals(getTxt_Items(tabCount).getText(), items, "Footer Items is not Matching");
    }

    public void verifyFooterQuantity(int tabCount, String footerQuantity) {
        Assert.assertEquals(getTxt_Quantity(tabCount).getText(), footerQuantity, "Footer Quantity is not Matching");
    }

    public void verifyDiscountRupees(int tabCount, String discRupees) {
        Assert.assertEquals(getTxt_DiscountRupees(tabCount).getText(), discRupees, "Discount Rupees is not Matching");
    }

    public void verifyBillAmount(int tabCount, String billAmount) {
        Assert.assertEquals(getTxt_BillAmount(tabCount).getText(), billAmount, "Bill Amount is not Matching");
    }

    public void verifyFooterMargin(int tabCount, String footerMargin) {
        Assert.assertEquals(getTxt_MarginPercentage(tabCount).getText(), footerMargin, "Footer Margin is not Matching");
    }

    public void verifyTotalAmount(int tabCount, String totalAmount) {
        Assert.assertEquals(getTxt_TotalAmount(tabCount).getText(), totalAmount, "Total Amount is not Matching");
    }

    public void verifyFooterDetails(int tabCount, String isHomeDelivery, String remarks, String outstanding, String mop, String received, String footerItem, String footerQuantity,
                                    String discRupees, String billAmount, String footerMargin, String totalAmount) {
        verifyRemarks(tabCount, remarks);
        verifyOutstanding(tabCount, outstanding);
        verifyModeOfPayment(tabCount, mop);
        verifyReceived(tabCount, received);
        verifyFooterItems(tabCount, footerItem);
        verifyFooterQuantity(tabCount, footerQuantity);
        verifyDiscountRupees(tabCount, discRupees);
        verifyBillAmount(tabCount, billAmount);
        verifyFooterMargin(tabCount, footerMargin);
        verifyTotalAmount(tabCount, totalAmount);
        testVerifyLog("Sales Bill Footer Details are Verified");
    }

    public void verifyBarcodeDetails(int tabCount, int row, String medName, String batch, String expiry, String mrp) {
        verifyMedicineName(tabCount, medName, row);
        verifyBatch(tabCount, batch, row);
        verifyExpiry(tabCount, expiry, row);
        verifyMRP(tabCount, mrp, row);
        testVerifyLog("Barcode details are auto populated");
    }

    public void verifySalesBill(int tabCount, HashMap<String, ArrayList<Object>> map) {
        verifyPatientName(tabCount, getData(map, PATIENT_NAME, 0));
        verifyDoctorName(tabCount, getData(map, DOCTOR_NAME, 0));
        testVerifyLog("Sales Header Details are Verified");
        int quantity = 0;
        int loose = 0;
        for (int i = 1; i <= map.get(MEDICINE_NAME).size(); i++) {
            verifyMedicineDetails(tabCount, i, getData(map, MEDICINE_NAME, i - 1), getData(map, BATCH, i - 1), getData(map, EXPIRY, i - 1),
                    getData(map, MARGIN, i - 1), getData(map, DISCOUNT_PERCENTAGE, i - 1), getData(map, QUANTITY, i - 1),
                    getData(map, LOOSE, i - 1), getData(map, MRP, i - 1), getData(map, NET_GST, i - 1), getData(map, MEDICINE_TOTAL, i - 1));
            quantity = quantity + Integer.parseInt(getData(map, QUANTITY, i - 1));
            loose = loose + Integer.parseInt(getData(map, LOOSE, i - 1));
        }
        String qty = String.valueOf(quantity);
        if (loose > 0) {
            qty = String.valueOf(quantity) + ":" + String.valueOf(loose);
        }
        testVerifyLog("Sales Medicine Details are Verified");
        verifyFooterDetails(tabCount, getData(map, IS_HOME_DELIVERY, 0), getData(map, REMARKS, 0), getData(map, OUTSTANDING, 0), getData(map, MODE_OF_PAYMENT, 0),
                getData(map, RECEIVED, 0), String.valueOf(map.get(MEDICINE_NAME).size()), qty, getData(map, DISCOUNT_RUPEES, 0), getData(map, BILL_AMOUNT, 0),
                getData(map, FOOTER_MARGIN, 0), getData(map, TOTAL_AMOUNT, 0));
    }
}