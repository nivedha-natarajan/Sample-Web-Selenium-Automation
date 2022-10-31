package com.projectName.pageObjects.salesBill.Controller;

import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientsController extends AbstractPage {

    public PatientsController(WebDriver driver) {
        super(driver);
    }

    private WebElement txtbx_Patient;
    private WebElement txt_Patient;
    private WebElement btn_DeletePatient;

    private WebElement getTxtbx_Patient(int tabCount) {
        txt_Patient = driver.findElement(By.xpath("//div[@id='tab_" + tabCount + "']//label[text()='Name']//parent::th/input[@placeholder='Name']"));
        return txtbx_Patient;
    }

    private WebElement getTxt_Patient(int tabCount, String name, int row) {
        txt_Patient = driver.findElement(By.xpath("//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr[" + row + "]/td/div[text()='" + name + "']"));
        return txt_Patient;
    }

    private WebElement getBtn_DeletePatient(int tabCount, int row) {
        btn_DeletePatient = driver.findElement(By.xpath("//table[@id='mainTable_tabCon_" + tabCount + "']//tr[" + row + "]//span[contains(@class,'deleteReportButton')]"));
        return btn_DeletePatient;
    }

    public void getDeletePatient(String name) {
        int tabCount = new SideMenuController(driver).openPatients();
        try {
            type(getTxtbx_Patient(tabCount), name);
            if (isElementPresent(getTxt_Patient(tabCount, name, 1))) {
                clickOn(driver, getBtn_DeletePatient(tabCount, 1));
                testInfoLog("Alert", new SideMenuController(driver).getAlertMessage());
            }
            testStepsLog(_logStep++, "Patient Name is Deleted");
        } catch (Exception ignored) {
        }
        new SideMenuController(driver).closeCurrentTab(tabCount);
    }
}
