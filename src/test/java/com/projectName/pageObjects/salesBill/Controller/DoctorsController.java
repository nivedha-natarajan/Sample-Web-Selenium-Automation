package com.projectName.pageObjects.salesBill.Controller;

import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DoctorsController extends AbstractPage {

    public DoctorsController(WebDriver driver) {
        super(driver);
    }

    private WebElement txtbx_Doctor;
    private WebElement txt_Doctor;
    private WebElement btn_DeleteDoctor;

    private WebElement getTxtbx_Doctor(int tabCount) {
        txtbx_Doctor = driver.findElement(By.xpath("//div[@id='tab_" + tabCount + "']//label[text()='Name']//parent::th/input[@placeholder='Name']"));
        return txtbx_Doctor;
    }

    private WebElement getTxt_Doctor(int tabCount, String name, int row) {
        txt_Doctor = driver.findElement(By.xpath("//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr[" + row + "]/td/div[text()='" + name + "']"));
        return txt_Doctor;
    }

    private WebElement getBtn_DeleteDoctor(int tabCount, int row) {
        btn_DeleteDoctor = driver.findElement(By.xpath("//table[@id='mainTable_tabCon_" + tabCount + "']//tr[" + row + "]//span[contains(@class,'deleteReportButton')]"));
        return btn_DeleteDoctor;
    }

    public void getDeleteDoctor(String name) {
        int tabCount = new SideMenuController(driver).openDoctors();
        try {
            type(getTxtbx_Doctor(tabCount), name);
            if (isElementPresent(getTxt_Doctor(tabCount, name, 1))) {
                clickOn(driver, getBtn_DeleteDoctor(tabCount, 1));
                testInfoLog("Alert", new SideMenuController(driver).getAlertMessage());
            }
            testStepsLog(_logStep++, "Doctor Name is Deleted");
        } catch (Exception ignored) {
        }
        new SideMenuController(driver).closeCurrentTab(tabCount);
    }
}
