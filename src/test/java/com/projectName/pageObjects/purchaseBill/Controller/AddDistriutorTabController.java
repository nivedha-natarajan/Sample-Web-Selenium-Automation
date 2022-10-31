package com.projectName.pageObjects.purchaseBill.Controller;

import com.framework.init.AbstractPage;
import com.framework.utils.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddDistriutorTabController extends AbstractPage implements Configuration {

    //General
    private WebElement txt_General;
    private WebElement txtbx_AddName;
    private WebElement txtbx_AddShortName;
    private WebElement txtbx_AddManufacturers;
    private WebElement txtbx_AddAddress;
    private WebElement txtbx_AddGSTStateCode;
    private WebElement txtbx_AddPurchaseEmail;
    private WebElement txtbx_AddContact;
    private WebElement txtbx_AddSalesEmail;
    private WebElement txtbx_OpeningBalance;
    private WebElement Drpbx_Select;
    private WebElement Drpbx_Debit;
    private WebElement Drpbx_Credit;
    private WebElement Btn_DistributorSave;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public AddDistriutorTabController(WebDriver driver) {
        super(driver);
    }


    private WebElement getTxt_General(int tabCount) {
        txt_General = driver.findElement(By.xpath("//div[@id='addDistributor']/div/ul[contains(@class,'tabCon_" + tabCount + "')]/li/a[text()='General']"));
        return txt_General;
    }

    private WebElement getTxtbx_AddName(int tabCount) {
        txtbx_AddName = driver.findElement(By.xpath("//input[@tab='tabCon_" + tabCount + "' and  @id='distributorNameSideBar']"));
        return txtbx_AddName;
    }

    private WebElement getTxtbx_AddShortName(int tabCount) {
        txtbx_AddShortName = driver.findElement(By.xpath("//input[@tab='tabCon_" + tabCount + "' and  @id='distributorShortNameSideBar']"));
        return txtbx_AddShortName;
    }

    private WebElement getTxtbx_AddManufacturers() {
        txtbx_AddManufacturers = driver.findElement(By.id("s2id_autogen3"));
        return txtbx_AddManufacturers;
    }

    private WebElement getTxtbx_AddManufacturersList() {
        txtbx_AddManufacturers = driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[1]/div"));
        return txtbx_AddManufacturers;
    }

    private WebElement getTxtbx_AddAddress(int tabCount) {
        txtbx_AddAddress = driver.findElement(By.xpath("//textarea[@tab='tabCon_" + tabCount + "' and @id='addressSideBar']"));
        return txtbx_AddAddress;
    }

    private WebElement getTxtbx_AddGSTStateCode(int tabCount) {
        txtbx_AddGSTStateCode = driver.findElement(By.xpath("//input[@tab='tabCon_" + tabCount + "' and @id='gstStateCode']"));
        return txtbx_AddGSTStateCode;
    }

    private WebElement getTxtbx_AddPurchaseEmail(int tabCount) {
        txtbx_AddPurchaseEmail = driver.findElement(By.xpath("//input[@tab='tabCon_" + tabCount + "' and @id='pEmailSideBar']"));
        return txtbx_AddPurchaseEmail;
    }

    private WebElement getTxtbx_AddContact(int tabCount) {
        txtbx_AddContact = driver.findElement(By.id("s2id_autogen2"));
        return txtbx_AddContact;
    }

    private WebElement getTxtbx_AddSalesEmail(int tabCount) {
        txtbx_AddSalesEmail = driver.findElement(By.xpath("//input[@tab='tabCon_" + tabCount + "' and @id='sEmailSideBar']"));
        return txtbx_AddSalesEmail;
    }

    private WebElement getTxtbx_OpeningBalance(int tabCount) {
        txtbx_OpeningBalance = driver.findElement(By.xpath("//input[@tab='tabCon_" + tabCount + "' and @id='openingBalanceSidebar']"));
        return txtbx_OpeningBalance;
    }

    private WebElement getDrpbx_Select(int tabCount) {
        Drpbx_Select = driver.findElement(By.xpath("//div[contains(@id,'tabCon_" + tabCount + "')]//button[@data-id='selectBalanceType']"));
        return Drpbx_Select;
    }

    private WebElement getDrpbx_Debit(int tabCount) {
        Drpbx_Debit = driver.findElement(By.xpath("//div[contains(@id,'tabCon_" + tabCount + "')]//a/span[text()='Debit']"));
        return Drpbx_Debit;
    }

    private WebElement getDrpbx_Credit(int tabCount) {
        Drpbx_Credit = driver.findElement(By.xpath("//div[contains(@id,'tabCon_" + tabCount + "')]//a/span[text()='Credit']"));
        return Drpbx_Credit;
    }

    private WebElement getBtn_DistributorSave(int tabCount) {
        Btn_DistributorSave = driver.findElement(By.xpath("//div[contains(@id,'tabCon_" + tabCount + "')]/div/button[contains(text(),'Save[Ctrl+S]')]"));
        return Btn_DistributorSave;
    }

    public void getAddDistributorName(int tabCount, String distributorName) {
        clickOn(driver, getTxt_General(tabCount));
        type(getTxtbx_AddName(tabCount), distributorName);
        clickOn(driver, getBtn_DistributorSave(tabCount));
    }
}