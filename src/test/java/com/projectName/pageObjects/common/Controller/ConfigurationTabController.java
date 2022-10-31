package com.projectName.pageObjects.common.Controller;


import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfigurationTabController extends AbstractPage {

    private WebElement txt_EnterPwd;
    private WebElement txtbx_ConfigPwd;
    private WebElement btn_Submit;

    //homepage
    private WebElement txt_CompanyName;

    //General
    private WebElement clk_General;

    private WebElement txt_saved;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public ConfigurationTabController(WebDriver driver) {
        super(driver);
    }

    private WebElement getTxt_EnterPwd(int tabCount) {
        txt_EnterPwd = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div/div/div[@class='configrationPasswordInnerHeading']"));
        return txt_EnterPwd;
    }

    private WebElement getTxtbx_ConfigPwd(int tabCount) {
        txtbx_ConfigPwd = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div/div/div/input[@id='configrationPasswordInput']"));
        return txtbx_ConfigPwd;
    }

    private WebElement getBtn_Submit(int tabCount) {
        btn_Submit = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div/div/div/div[text()='Submit']"));
        return btn_Submit;
    }

    private WebElement getTxt_CompanyName(int tabCount) {
        txt_CompanyName = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//h1[@id='updateConfigNewVersion']"));
        return txt_CompanyName;
    }

    private WebElement getClk_General(int tabCount) {
        clk_General = driver.findElement(By.xpath("//button[contains(@onclick,'tabCon_" + tabCount + "')]/span[text()='General']"));
        return clk_General;
    }

    private WebElement getTxt_saved() {
        txt_saved = driver.findElement(By.xpath("//div[text()='Saved successfully']"));
        return txt_saved;
    }

    public boolean checkEnterPassword(int tabCount, String password, String passwordText) {
        if (getTxt_EnterPwd(tabCount).getText().contains(passwordText)) {
            type(getTxtbx_ConfigPwd(tabCount), password);
            clickOn(driver, getBtn_Submit(tabCount));
            return true;
        }
        return false;
    }

    public void openGeneral(int tabCount) {
        clickOn(driver, getClk_General(tabCount));
        testInfoLog("Configuration", "General settings is Opened");
    }

}
