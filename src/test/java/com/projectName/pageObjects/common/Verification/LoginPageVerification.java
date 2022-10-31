package com.projectName.pageObjects.common.Verification;

import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPageVerification extends AbstractPage {

    public LoginPageVerification(WebDriver driver) {
        super(driver);
    }

    private WebElement navBar;
    private WebElement loginContent;

    private WebElement getNavBar() {
        navBar = driver.findElement(By.xpath("//div[contains(@class,'navHamButton')]"));
        return navBar;
    }

    private WebElement getloginContent() {
        loginContent = driver.findElement(By.xpath("//div[@class='loginContent login-content']"));
        return loginContent;
    }

    public void verifyLoginSuccessful() {
        getExplicitWait(driver, getNavBar(), EXPLICIT_WAIT);
        Assert.assertTrue(isElementPresent(getNavBar()));
        testVerifyLog("Login Successful");
    }

    public void verifyOpenLoginPage() {
        getExplicitWait(driver, getloginContent(), EXPLICIT_WAIT);
        Assert.assertTrue(isElementPresent(getloginContent()));
    }
}

