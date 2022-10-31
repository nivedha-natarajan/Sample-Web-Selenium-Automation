package com.projectName.pageObjects.salesBill.Controller;

import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorTabController extends AbstractPage {

    public CalculatorTabController(WebDriver driver) {
        super(driver);
    }

    private WebElement txt_Calculator;
    private WebElement txt_BillAmount;
    private WebElement txtbx_ReceivedAmount;
    private WebElement txt_ReturnAmount;
    private WebElement btn_Save;
    private WebElement btn_Print;

    private WebElement getTxt_Calculator(int tabCount) {
        txt_Calculator = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@id='tenderCalculator']/div/div/h2"));
        return txt_Calculator;
    }

    private WebElement getTxt_BillAmount(int tabCount) {
        txt_BillAmount = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//label[@id='billAmountForTenderCalculator']"));
        return txt_BillAmount;
    }

    private WebElement getTxtbx_ReceivedAmount(int tabCount) {
        txtbx_ReceivedAmount = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//input[@id='amountReceivedForTenderCalculator']"));
        return txtbx_ReceivedAmount;
    }

    private WebElement getTxt_ReturnAmount(int tabCount) {
        txt_ReturnAmount = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//label[@id='pendingAmountForTenderCalculator']"));
        return txt_ReturnAmount;
    }

    private WebElement getBtn_Save(int tabCount) {
        btn_Save = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@id='tenderCalculator']//button[contains(text(),'Save')]"));
        return btn_Save;
    }

    private WebElement getBtn_Print(int tabCount) {
        btn_Print = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@id='tenderCalculator']//button[text()='Print']"));
        return btn_Print;
    }

    public void click(int tabCount) {
        clickOn(driver, getTxt_BillAmount(tabCount));
    }

    public void setAmountReceived(int tabCount, String amountReceived) {
        typeSlow(driver, getTxtbx_ReceivedAmount(tabCount), amountReceived);
        click(tabCount);
    }

    public void getSave(int tabCount) {
        clickOn(driver, getBtn_Save(tabCount));
    }

    public void getPrint(int tabCount) {
        clickOn(driver, getBtn_Print(tabCount));
    }
}
