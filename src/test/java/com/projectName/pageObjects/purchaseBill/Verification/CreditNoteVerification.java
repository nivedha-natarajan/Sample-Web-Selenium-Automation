package com.projectName.pageObjects.purchaseBill.Verification;

import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CreditNoteVerification extends AbstractPage {
    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public CreditNoteVerification(WebDriver driver) {
        super(driver);
    }

    private WebElement txt_CreditNote;
    private WebElement txtbx_TotalAmtCaptured;

    private WebElement getTxt_CreditNote(int tabCount) {
        txt_CreditNote = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']/div[@id='addCreditNote']/div/h2"));
        return txt_CreditNote;
    }

    private WebElement getTxtbx_TotalAmtCaptured(int tabCount) {
        txtbx_TotalAmtCaptured = driver.findElement(By.xpath("//input[@id='creditTotalAmountCapturedId' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_TotalAmtCaptured;
    }

    public void verifyOpenCreditNoteCheck(int tabCount) {
        Assert.assertTrue(getTxt_CreditNote(tabCount).isDisplayed());
        testVerifyLog("Credit Note is Opened");
    }

    public boolean getTotalAmtCaptured(int tabCount, String amount) {
        Assert.assertTrue(getValue(getTxtbx_TotalAmtCaptured(tabCount)).startsWith(amount), "Expected Amount : " + amount + " - Actual Amount : " + getValue(getTxtbx_TotalAmtCaptured(tabCount)));
        return true;
    }

    public void verifyCreditAmountCapturedCheck(int tabCount, String amountCaptured) {
        if (getTotalAmtCaptured(tabCount, amountCaptured)) {
            testStepsLog(_logStep++, "Credit note/s are Enabled and Selected. Total Credit Amount - " + amountCaptured);
        }
    }
}
