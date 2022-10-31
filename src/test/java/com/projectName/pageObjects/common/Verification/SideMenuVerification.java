package com.projectName.pageObjects.common.Verification;

import com.projectName.constants.DataTabs;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SideMenuVerification extends AbstractPage implements DataTabs {

    private WebElement clk_MenuIcon;

    //Tab
    private WebElement tab_CurrentTabName;

    public SideMenuVerification(WebDriver driver) {
        super(driver);
    }

    private WebElement getTab_CurrentTabName() {
        tab_CurrentTabName = driver.findElement(By.xpath("//ul[@id='navWrapTabs']/li[@class='active']/a/label"));
        return tab_CurrentTabName;
    }

    public void verifyTabNameOpened(String tab) {
        getExplicitWait(driver, getTab_CurrentTabName(), EXPLICIT_WAIT);
        Assert.assertTrue(getTab_CurrentTabName().getText().contains(tab));
        testVerifyLog(tab + " is Opened");
    }
}

