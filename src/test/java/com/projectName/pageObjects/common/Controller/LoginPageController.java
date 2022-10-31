package com.projectName.pageObjects.common.Controller;

import com.projectName.pageObjects.common.Verification.LoginPageVerification;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageController extends AbstractPage {

    private WebElement txtbx_UserName;
    private WebElement txtbx_Password;
    private WebElement txtbx_PharmacyCode;
    private WebElement chkbx_Terms;
    private WebElement chkbx_Rememberme;
    private WebElement btn_login;

    public LoginPageController(WebDriver driver) {
        super(driver);
    }

    private WebElement getTxtbx_UserName() {
        txtbx_UserName = driver.findElement(By.id("username"));
        return txtbx_UserName;
    }

    private WebElement getTxtbx_Password() {
        txtbx_Password = driver.findElement(By.id("password"));
        return txtbx_Password;
    }

    private WebElement getTxtbx_PharmacyCode() {
        txtbx_PharmacyCode = driver.findElement(By.id("company"));
        return txtbx_PharmacyCode;
    }

    private WebElement getChkbx_Terms() {
        chkbx_Terms = driver.findElement(By.id("terms"));
        return chkbx_Terms;
    }

    private WebElement getChkbx_Rememberme() {
        chkbx_Rememberme = driver.findElement(By.id("rememberMeCheck"));
        return chkbx_Rememberme;
    }

    private WebElement getBtn_login() {
        btn_login = driver.findElement(By.xpath("//button[@class='btn btn-primary signIn navigation']"));
        return btn_login;
    }

    public void getLogin(String username, String password, String pharmacyCode) {
        new LoginPageVerification(driver).verifyOpenLoginPage();
        setUserName(username);
        setPassword(password);
        setPharmacyCode(pharmacyCode);
        clickOn(driver, getBtn_login());
    }

    public void setUserName(String username) {
        type(getTxtbx_UserName(), username);
    }

    public void setPassword(String password) {
        type(getTxtbx_Password(), password);
    }

    public void setPharmacyCode(String pharmacyCode) {
        type(getTxtbx_PharmacyCode(), pharmacyCode);
    }

    public void getSignin() {
        getLogin(USERNAME, LOGIN_PASSWORD, PHARMACY_CODE);
        new LoginPageVerification(driver).verifyLoginSuccessful();
    }

    public void getSignOut() {
        try {
            SideMenuController sideMenuController = new SideMenuController(driver);
            try {
                sideMenuController.getSignOut();
                new LoginPageVerification(driver).verifyOpenLoginPage();
            } catch (Exception e) {
                getBrowserRefresh(driver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
