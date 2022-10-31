package com.projectName.pageObjects.purchaseBill.Controller;

import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectInvoiceFromChallanController extends AbstractPage {

    private WebElement txt_CheckInvoice;
    private WebElement btn_AddToInvoice;
    private WebElement btn_AddInvoiceClose;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public SelectInvoiceFromChallanController(WebDriver driver) {
        super(driver);
    }

    private WebElement getTxt_CheckInvoice(int tabCount, String invoice) {
        txt_CheckInvoice = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div[@id='challanSelect']/div//label[text()='" + invoice + "']"));
        return txt_CheckInvoice;
    }

    private WebElement getBtn_AddToInvoice(int tabCount) {
        btn_AddToInvoice = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div[@id='challanSelect']//button[contains(text(),'Add To Invoice')]"));
        return btn_AddToInvoice;
    }

    private WebElement getBtn_AddInvoiceClose(int tabCount) {
        btn_AddInvoiceClose = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div[@id='challanSelect']/div/h2/a"));
        return btn_AddInvoiceClose;
    }

    public boolean clickAddToInvoice(int tabCount, String invoice) {
        getExplicitWait(driver, getTxt_CheckInvoice(tabCount, invoice), EXPLICIT_WAIT);
        if (getTxt_CheckInvoice(tabCount, invoice).isDisplayed()) {
            clickOn(driver, getBtn_AddToInvoice(tabCount));
            return true;
        }
        return false;
    }

    public void getAddInvoiceClose(int tabCount) {
        clickOn(driver, getBtn_AddInvoiceClose(tabCount));
    }

}
