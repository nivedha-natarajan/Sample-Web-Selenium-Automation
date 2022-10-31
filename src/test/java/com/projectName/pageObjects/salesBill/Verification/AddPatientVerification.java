package com.projectName.pageObjects.salesBill.Verification;

import com.projectName.constants.DataConstantsSalesBill;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;

public class AddPatientVerification extends AbstractPage implements DataConstantsSalesBill {

    public AddPatientVerification(WebDriver driver) {
        super(driver);
    }

    private WebElement txt_AddPatient;
    private WebElement txtbx_PatientName;
    private WebElement txtbx_PrintName;
    private WebElement txtbx_Identifier;
    private WebElement txtbx_Family;
    private WebElement slt_Family;
    private WebElement txtbx_Email;
    private WebElement txtbx_Phone;
    private WebElement txtbx_Pincode;
    private WebElement txtbx_Address;
    private WebElement txtbx_Age;
    private WebElement txtbx_Gender;
    private WebElement txtbx_GSTIN;
    private WebElement txtbx_DiscountPercentage;
    private WebElement txtbx_CreditLimit;
    private WebElement chkbx_DontSendOrderSMS;
    private WebElement txtbx_Payment;
    private WebElement slt_Payment;
    private WebElement btn_AddPatient;
    private WebElement btn_Cancel;
    private WebElement clk_Close;

    private WebElement getTxt_AddPatient(int tabCount) {
        txt_AddPatient = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div[@id='addPatient']/div[@class='overlay-content']/h2"));
        return txt_AddPatient;
    }

    private WebElement getTxtbx_PatientName(int tabCount) {
        txtbx_PatientName = driver.findElement(By.xpath("//input[@id='patientName' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_PatientName;
    }

    private WebElement getTxtbx_PrintName(int tabCount) {
        txtbx_PrintName = driver.findElement(By.xpath("//input[@id='patientPrintName' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_PrintName;
    }

    private WebElement getTxtbx_Identifier(int tabCount) {
        txtbx_Identifier = driver.findElement(By.xpath("//input[@id='patientIdentifier' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Identifier;
    }

    private WebElement getTxtbx_Family(int tabCount) {
        txtbx_Family = driver.findElement(By.xpath("//div[@id='addPatient']//input[@placeholder='Search Family' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Family;
    }

    private WebElement getSlt_Family(String familyName) {
        slt_Family = driver.findElement(By.xpath("(//ul[contains(@id,'ui-id')]/li[contains(text(),'" + familyName + "')])[1]"));
        return slt_Family;
    }

    private WebElement getTxtbx_Email(int tabCount) {
        txtbx_Email = driver.findElement(By.xpath("//input[@id='patientEmail' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Email;
    }

    private WebElement getTxtbx_Phone(int tabCount) {
        txtbx_Phone = driver.findElement(By.xpath("//input[@id='patientPhone' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Phone;
    }

    private WebElement getTxtbx_Pincode(int tabCount) {
        txtbx_Pincode = driver.findElement(By.xpath("//input[@id='patientPincode' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Pincode;
    }

    private WebElement getTxtbx_Address(int tabCount) {
        txtbx_Address = driver.findElement(By.xpath("//input[@id='patientAddress' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Address;
    }

    private WebElement getTxtbx_Age(int tabCount) {
        txtbx_Age = driver.findElement(By.xpath("//input[@id='sidebarAge' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Age;
    }

    private WebElement getTxtbx_Gender(int tabCount, String gender) {
        txtbx_Gender = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div[@id='addPatient']//div/label/span[text()='" + gender + "']/parent::label/span[1]"));
        return txtbx_Gender;
    }

    private WebElement getTxtbx_GSTIN(int tabCount) {
        txtbx_GSTIN = driver.findElement(By.xpath("//input[@id='patientGstIn' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_GSTIN;
    }

    private WebElement getTxtbx_DiscountPercentage(int tabCount) {
        txtbx_DiscountPercentage = driver.findElement(By.xpath("//input[@id='patientDiscount' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_DiscountPercentage;
    }

    private WebElement getTxtbx_CreditLimit(int tabCount) {
        txtbx_CreditLimit = driver.findElement(By.xpath("//input[@id='sidebarCreditLimit' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_CreditLimit;
    }

    private WebElement getChkbx_DontSendOrderSMS(int tabCount) {
        chkbx_DontSendOrderSMS = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@id='addPatient']//div/input[contains(@data-bind,'disableOrderSMS')]"));
        return chkbx_DontSendOrderSMS;
    }

    private WebElement getTxtbx_Payment(int tabCount) {
        txtbx_Payment = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div[@id='addPatient']//div[@class='selectPaymentMediumDropdown']/div/button/span[1]"));
        return txtbx_Payment;
    }

    private WebElement getSlt_Payment(int tabCount, String payment) {
        slt_Payment = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div[@id='addPatient']//div[@class='selectPaymentMediumDropdown']/div/div//span[text()='" + payment + "']"));
        return slt_Payment;
    }

    private WebElement getBtn_AddPatient(int tabCount) {
        btn_AddPatient = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div[@id='addPatient']//div[@class='sidebarFooterButton']/button[contains(@data-bind,'save')]"));
        return btn_AddPatient;
    }

    private WebElement getBtn_Cancel(int tabCount) {
        btn_Cancel = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div[@id='addPatient']//div[@class='sidebarFooterButton']/button[contains(@onclick,'closeSidemenu')]"));
        return btn_Cancel;
    }

    private WebElement getClk_Close(int tabCount) {
        clk_Close = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div[@id='addPatient']/div[@class='overlay-content']/h2/a"));
        return clk_Close;
    }

    public void verifyAddPatientTabOpen(int tabCount) {
        getTxt_AddPatient(tabCount).isDisplayed();
        testVerifyLog("Add Patient Tab is Opened");
    }

    public void verifyAddPatientName(int tabCount, HashMap<String, ArrayList<Object>> map) {
        Assert.assertTrue(getValue(getTxtbx_PatientName(tabCount)).equalsIgnoreCase(getData(map, PATIENT_NAME, 0)));
        Assert.assertTrue(getValue(getTxtbx_PrintName(tabCount)).equalsIgnoreCase(getData(map, PATIENT_PRINT_NAME, 0)));
        Assert.assertTrue(getValue(getTxtbx_Identifier(tabCount)).equalsIgnoreCase(getData(map, PATIENT_IDENTIFIER, 0)));
        Assert.assertTrue(getValue(getTxtbx_Family(tabCount)).equalsIgnoreCase(getData(map, PATIENT_FAMILY, 0)));
        Assert.assertTrue(getValue(getTxtbx_Email(tabCount)).equalsIgnoreCase(getData(map, PATIENT_EMAIL, 0)));
        Assert.assertTrue(getValue(getTxtbx_Phone(tabCount)).equalsIgnoreCase(getData(map, PATIENT_PHONE, 0)));
        Assert.assertTrue(getValue(getTxtbx_Pincode(tabCount)).equalsIgnoreCase(getData(map, PATIENT_PINCODE, 0)));
        Assert.assertTrue(getValue(getTxtbx_Address(tabCount)).equalsIgnoreCase(getData(map, PATIENT_ADDRESS, 0)));
        Assert.assertTrue(getValue(getTxtbx_Age(tabCount)).equalsIgnoreCase(getData(map, PATIENT_AGE, 0)));
        Assert.assertTrue(getValue(getTxtbx_GSTIN(tabCount)).equalsIgnoreCase(getData(map, PATIENT_GSTIN, 0)));
        Assert.assertTrue(getValue(getTxtbx_DiscountPercentage(tabCount)).equalsIgnoreCase(getData(map, PATIENT_DISCOUNT, 0)));
        Assert.assertTrue(getValue(getTxtbx_CreditLimit(tabCount)).equalsIgnoreCase(getData(map, PATIENT_CREDIT_LIMIT, 0)));
        Assert.assertTrue(getValue(getTxtbx_Payment(tabCount)).equalsIgnoreCase(getData(map, PAYMENT_MODE, 0)));
        testVerifyLog("Add Patient Details Verified");
    }
}
