package com.projectName.pageObjects.salesBill.Verification;

import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CalculatorTabVerification extends AbstractPage {

    public CalculatorTabVerification(WebDriver driver) {
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

    public boolean verifyCalculatorTabOpened(int tabCount) {
        if (getTxt_Calculator(tabCount).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void verifyBillAmount(int tabCount, String billAmount) {
        Assert.assertEquals(getTxt_BillAmount(tabCount).getText(), billAmount, "Bill Amount is not Matching");
    }

    public void verifyAmountReceived(int tabCount, String amountReceived) {
        Assert.assertEquals(getValue(getTxtbx_ReceivedAmount(tabCount)), amountReceived, "Amount Received is not Matching");
    }

    public void verifyReturnAmount(int tabCount, String returnAmount) {
        Assert.assertEquals(getTxt_ReturnAmount(tabCount).getText(), returnAmount, "Return Amount is not Matching");
    }

    public void verifyAmounts(int tabCount, String billAmount, String amountReceived, String returnAmount) {
        verifyBillAmount(tabCount, billAmount);
        verifyAmountReceived(tabCount, amountReceived);
        verifyReturnAmount(tabCount, returnAmount);
        testVerifyLog("Purchase amount Verified");
    }
}
