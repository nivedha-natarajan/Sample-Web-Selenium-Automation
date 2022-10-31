package com.projectName.pageObjects.salesBill.Controller;

import com.projectName.constants.DataConstantsSalesBill;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.framework.init.AbstractPage;
import com.projectName.pageObjects.salesBill.Verification.EditDoctorVerification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;

public class AddDoctorController extends AbstractPage implements DataConstantsSalesBill {

    public AddDoctorController(WebDriver driver) {
        super(driver);
    }

    private WebElement txt_EditDoctor;
    private WebElement txtbx_DoctorName;
    private WebElement txtbx_Degree;
    private WebElement txtbx_RegNo;
    private WebElement txtbx_Hospital;
    private WebElement txtbx_Address;
    private WebElement txtbx_Phone;
    private WebElement btn_AddDoctor;
    private WebElement btn_Cancel;
    private WebElement clk_CancelEditDoctor;

    private WebElement getTxt_EditDoctor(int tabCount) {
        txt_EditDoctor = driver.findElement(By.xpath("//div[@id='addDoctor']/div/a[contains(@onclick,'tabCon_" + tabCount + "')]/parent::div/h2[@id='doctorHeader']"));
        return txt_EditDoctor;
    }

    private WebElement getTxtbx_DoctorName(int tabCount) {
        txtbx_DoctorName = driver.findElement(By.xpath("//input[@id='doctorName' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_DoctorName;
    }

    private WebElement getTxtbx_Degree(int tabCount) {
        txtbx_Degree = driver.findElement(By.xpath("//input[@id='doctorDegree' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Degree;
    }

    private WebElement getTxtbx_RegNo(int tabCount) {
        txtbx_RegNo = driver.findElement(By.xpath("//input[@id='doctorRegNo' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_RegNo;
    }

    private WebElement getTxtbx_Hospital(int tabCount) {
        txtbx_Hospital = driver.findElement(By.xpath("//input[@id='doctorHospital' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Hospital;
    }

    private WebElement getTxtbx_Address(int tabCount) {
        txtbx_Address = driver.findElement(By.xpath("//textarea[@id='doctorAddress' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Address;
    }

    private WebElement getTxtbx_Phone(int tabCount) {
        txtbx_Phone = driver.findElement(By.xpath("//input[@id='phoneDoctorSidebar' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Phone;
    }

    private WebElement getBtn_AddDoctor(int tabCount) {
        btn_AddDoctor = driver.findElement(By.xpath("//div[@id='addDoctor']//div[@class='sidebarFooterButton']/button[contains(@data-bind,'tabCon_" + tabCount + "')]"));
        return btn_AddDoctor;
    }

    private WebElement getBtn_Cancel(int tabCount) {
        btn_Cancel = driver.findElement(By.xpath("//div[@id='addDoctor']//div[@class='sidebarFooterButton']/button[contains(@onClick,'closeSidemenu_tabCon_" + tabCount + "')]"));
        return btn_Cancel;
    }

    private WebElement getClk_CancelEditDoctor(int tabCount) {
        clk_CancelEditDoctor = driver.findElement(By.xpath("//div[@id='addDoctor']/div[@class='overlay-content']/a[contains(@onClick,'closeSidemenu_tabCon_" + tabCount + "')]"));
        return clk_CancelEditDoctor;
    }

    public void getAddDoctor(int tabCount, HashMap<String, ArrayList<Object>> map) {
        new EditDoctorVerification(driver).verifyAddDoctorTabOpen(tabCount);
        typeSlow(driver, getTxtbx_DoctorName(tabCount), getData(map, DOCTOR_NAME, 0));
        type(getTxtbx_Degree(tabCount), getData(map, DOCTOR_DEGREE, 0));
        type(getTxtbx_RegNo(tabCount), getData(map, DOCTOR_REG_NO, 0));
        type(getTxtbx_Hospital(tabCount), getData(map, DOCTOR_HOSPITAL, 0));
        type(getTxtbx_Address(tabCount), getData(map, DOCTOR_ADDRESS, 0));
        type(getTxtbx_Phone(tabCount), getData(map, DOCTOR_PHONE, 0));
        new EditDoctorVerification(driver).verifyAddDoctor(tabCount, map);
        testStepsLog(_logStep++, "New Doctor Details Added");
        clickOn(driver, getBtn_AddDoctor(tabCount));
    }

    public void getAddDoctorSave(int tabCount) {
        new EditDoctorVerification(driver).verifyAddDoctorTabOpen(tabCount);
        testValidationLog("New Doctor Details Added");
        clickOn(driver, getBtn_AddDoctor(tabCount));
        testInfoLog("Alert", new SideMenuController(driver).getAlertMessage());
    }
}
