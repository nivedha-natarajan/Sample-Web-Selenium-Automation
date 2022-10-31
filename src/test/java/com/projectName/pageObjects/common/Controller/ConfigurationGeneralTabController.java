package com.projectName.pageObjects.common.Controller;

import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfigurationGeneralTabController extends AbstractPage {

    //Purchase
    private WebElement clk_Purchase;
    private WebElement chkbx_EnableChallan;
    private WebElement chkbx_EnableCESS;
    private WebElement chkbx_EnableIGST;
    private WebElement chkbx_EnableTCS;
    private WebElement chkbx_EnableHSN;
    private WebElement chkbx_EnableVAT;

    private WebElement btn_Submit;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public ConfigurationGeneralTabController(WebDriver driver) {
        super(driver);
    }

    private WebElement getClk_Purchase() {
        clk_Purchase = driver.findElement(By.xpath("//div[@id='General']/div//h3[text()='Purchase']"));
        return clk_Purchase;
    }

    private WebElement getChkbx_EnableChallan() {
        chkbx_EnableChallan = driver.findElement(By.name("enableChallan"));
        return chkbx_EnableChallan;
    }

    private WebElement getChkbx_EnableCESS() {
        chkbx_EnableCESS = driver.findElement(By.name("CESS"));
        return chkbx_EnableCESS;
    }

    private WebElement getChkbx_EnableIGST() {
        chkbx_EnableIGST = driver.findElement(By.name("isIgst"));
        return chkbx_EnableIGST;
    }

    private WebElement getChkbx_EnableTCS() {
        chkbx_EnableTCS = driver.findElement(By.name("enableTCS"));
        return chkbx_EnableTCS;
    }

    private WebElement getChkbx_EnableHSN() {
        chkbx_EnableHSN = driver.findElement(By.name("enableHsnCode"));
        return chkbx_EnableHSN;
    }

    private WebElement getChkbx_EnableVAT() {
        chkbx_EnableVAT = driver.findElement(By.name("isVat"));
        return chkbx_EnableVAT;
    }

    private WebElement getBtn_Submit() {
        btn_Submit = driver.findElement(By.xpath("//div[@id='configurePurchase']/div/div/button"));
        return btn_Submit;
    }

    public void openPurchase() {
        clickOn(driver, getClk_Purchase());
    }

    public void getChangeChallanCheckBox() {
        clickOn(driver, getChkbx_EnableChallan());
    }

    public void getChangeCESSCheckBox() {
        clickOn(driver, getChkbx_EnableCESS());
    }

    public void getChangeIGSTCheckBox() {
        clickOn(driver, getChkbx_EnableIGST());
    }

    public void getChangeHSNCheckBox() {
        clickOn(driver, getChkbx_EnableHSN());
    }

    public void getChangeTCSCheckBox() {
        clickOn(driver, getChkbx_EnableTCS());
    }

    public void getChangeVATCheckBox() {
        clickOn(driver, getChkbx_EnableVAT());
    }

    public void getChangeTaxesConfiguration() {
        getChangeCESSCheckBox();
        getChangeIGSTCheckBox();
        getChangeHSNCheckBox();
        getChangeTCSCheckBox();
        getChangeVATCheckBox();
    }

    public void clickSubmit() {
        clickOn(driver, getBtn_Submit());
    }


}
