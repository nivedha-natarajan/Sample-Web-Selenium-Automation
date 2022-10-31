package com.projectName.pageObjects.purchaseBill.Controller;

import com.projectName.constants.Validations;
import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DistributorsTabController extends AbstractPage implements Validations {

    private WebElement txt_DistributorName;
    private WebElement btn_DistributorNameRemove;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public DistributorsTabController(WebDriver driver) {
        super(driver);
    }

    private WebElement getTxt_DistributorName(int tabCount) {
        txt_DistributorName = driver.findElement(By.xpath("//div[contains(@id,'tabCon_" + tabCount + "')]//th/input[@placeholder='Distributor']"));
        return txt_DistributorName;
    }

    private WebElement getBtn_DistributorNameRemove(int tabCount) {
        btn_DistributorNameRemove = driver.findElement(By.xpath("//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[10]/div/button[2]/span"));
        return btn_DistributorNameRemove;
    }

    public boolean getDeleteDistributor(int tabCount, String DistributorName) {
        try {
            type(getTxt_DistributorName(tabCount), DistributorName);
            if (getBtn_DistributorNameRemove(tabCount).isDisplayed()) {
                clickOn(driver, getBtn_DistributorNameRemove(tabCount));
                return true;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }

    public boolean getDeleteDistributor(SideMenuController sideMenuController, String name) {
        boolean _flag;
        int tabCount = sideMenuController.openDistributorTab();

        if (getDeleteDistributor(tabCount, name)) {
            if (sideMenuController.checkAlertMessage(ALERT_DELETE_SUCCESS)) {
                getAlertCheck(sideMenuController.getAlertMessage());
                testStepsLog(_logStep++, "Newly added Distributor is deleted - " + name);
                sideMenuController.closeCurrentTab(tabCount);
                _flag = true;
            } else {
                getAlertCheck(sideMenuController.getAlertMessage());
                testStepsLog(_logStep++, "Newly added Distributor is not deleted - " + name);
                sideMenuController.closeCurrentTab(tabCount);
                _flag = false;
            }
        } else {
            testStepsLog(_logStep++, "Distributor is Not Present");
            sideMenuController.closeCurrentTab(tabCount);
            _flag = true;
        }
        return _flag;
    }
}
