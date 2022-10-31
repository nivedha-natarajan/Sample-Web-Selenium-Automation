package com.projectName.pageObjects.salesBill.Verification;

import com.projectName.constants.DataConstantsSalesBill;
import com.projectName.pageObjects.salesBill.Controller.SalesOrderController;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SalesOrderVerification extends AbstractPage implements DataConstantsSalesBill {

    public SalesOrderVerification(WebDriver driver) {
        super(driver);
    }

    SalesOrderController salesOrderController = new SalesOrderController(driver);

    private WebElement txt_InvoiceDetails;
    private WebElement txt_Invoice;
    private WebElement txt_Payment;
    private WebElement txt_Patient;

    private WebElement getTxt_InvoiceDetails(int tabCount, int headerCount) {
        txt_InvoiceDetails = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr[1]/td/div)[" + headerCount + "]"));
        return txt_InvoiceDetails;
    }

    private WebElement getTxt_Patient(int tabCount, int row, String patient) {
        txt_Patient = driver.findElement(By.xpath("//table[@id='mainTable_tabCon_" + tabCount + "']//tr[" + row + "]//div[text()='" + patient + "']"));
        return txt_Patient;
    }

    private WebElement getTxt_Invoice(int tabCount) {
        txt_Invoice = driver.findElement(By.xpath("//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr[1]/td/a"));
        return txt_Invoice;
    }

    private WebElement getTxt_Payment(int tabCount, int headerCount) {
        txt_Payment = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr[1]/td)[" + headerCount + "]"));
        return txt_Payment;
    }

    public void verifySalesBill(int tabCount, String patient, String doctor, String payment, String totalAmount, String discount,
                                String status, String date) {
        salesOrderController.getFilterByDate(tabCount, date);
        salesOrderController.setSearchInvoice(tabCount, patient, doctor, payment, totalAmount, status);
        Assert.assertEquals(getTxt_InvoiceDetails(tabCount, salesOrderController.getHeaderColumnCount(tabCount, HEADER_PATIENT, false)).getText(), patient, "Patient is not Matching");
        Assert.assertEquals(getTxt_InvoiceDetails(tabCount, salesOrderController.getHeaderColumnCount(tabCount, HEADER_DOCTOR, false)).getText(), doctor, "Doctor is not Matching");
        Assert.assertEquals(getTxt_Payment(tabCount, (salesOrderController.getHeaderColumnCount(tabCount, HEADER_PAYMENT, false))).getText(), payment, "Payment is not Matching");
        Assert.assertTrue(getTxt_InvoiceDetails(tabCount, salesOrderController.getHeaderColumnCount(tabCount, HEADER_TOTAL_AMOUNT, false)).getText().contains(totalAmount), "Total Amount is not Matching");
        Assert.assertEquals(getTxt_InvoiceDetails(tabCount, salesOrderController.getHeaderColumnCount(tabCount, HEADER_DISCOUNT, false)).getText(), discount, "Discount is not Matching");
        Assert.assertEquals(getTxt_InvoiceDetails(tabCount, salesOrderController.getHeaderColumnCount(tabCount, HEADER_STATUS, false)).getText(), status, "Status is not Matching");
        testVerifyLog(patient + " - Sales invoice with Patient Name is Present");
    }

    public boolean isInvoicePresent(int tabCount, String patient, String payment) {
        pause();
        try {
            getTxt_Patient(tabCount, 1, patient).isDisplayed();
            testConfirmationLog(patient + " ; " + payment + " : Sales Invoice with Patient Name is Present");
            return true;
        } catch (Exception e) {
            testConfirmationLog(patient + " ; " + payment + " : Sales Invoice with the Patient Name not present");
            return false;
        }
    }
}
