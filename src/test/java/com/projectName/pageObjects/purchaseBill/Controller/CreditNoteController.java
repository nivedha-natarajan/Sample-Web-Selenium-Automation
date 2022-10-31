package com.projectName.pageObjects.purchaseBill.Controller;

import com.projectName.constants.DataColumnsPurchaseBill;
import com.projectName.pageObjects.purchaseBill.Verification.CreditNoteVerification;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class CreditNoteController extends AbstractPage implements DataColumnsPurchaseBill {

    private WebElement txt_NoCreditNote;
    private WebElement txt_CreditNote;
    private List<WebElement> list_CreditNoteEnable;
    private WebElement chkbx_Enable;
    private WebElement txt_Amount;
    private WebElement txt_Pending;
    private WebElement txtbx_AmountCaptured;
    private WebElement chkbx_Resolved;
    private WebElement txtbx_TotalAmtCaptured;
    private WebElement txtbx_Reason;
    private WebElement btn_CreditNoteOk;
    private WebElement btn_CreditNoteCancel;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public CreditNoteController(WebDriver driver) {
        super(driver);
    }


    private WebElement getTxt_NoCreditNote(int tabCount) {
        txt_NoCreditNote = driver.findElement(By.xpath("(//div[@id='tabCon_" + tabCount + "']/div[@id='addCreditNote']/div/div/text())[1]"));
        return txt_NoCreditNote;
    }

    private WebElement getTxt_CreditNote(int tabCount) {
        txt_CreditNote = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@id='addCreditNote']/div/h2"));
        return txt_CreditNote;
    }

    private List<WebElement> getList_CreditNoteEnable(int tabCount) {
        list_CreditNoteEnable = driver.findElements(By.xpath("//div[@id='tabCon_" + tabCount + "']//table[@id='creditNoteDetails']/tbody/tr/td[1]/input"));
        return list_CreditNoteEnable;
    }

    private WebElement getChkbx_Enable(int tabCount, int rowCount) {
        chkbx_Enable = driver.findElement(By.xpath("(//div[@id='tabCon_" + tabCount + "']//table[@id='creditNoteDetails']/tbody/tr/td[1]/input)[" + rowCount + "]"));
        return chkbx_Enable;
    }

    private WebElement getTxt_Amount(int tabCount, int rowCount) {
        txt_Amount = driver.findElement(By.xpath("(//div[@id='tabCon_" + tabCount + "']//table[@id='creditNoteDetails']/tbody/tr/td[@data-bind='text:cnamount()'])[" + rowCount + "]"));
        return txt_Amount;
    }

    private WebElement getTxt_Pending(int tabCount, int rowCount) {
        txt_Pending = driver.findElement(By.xpath("(//div[@id='tabCon_" + tabCount + "']//table[@id='creditNoteDetails']/tbody/tr/td[@data-bind='text:pending()'])[" + rowCount + "]"));
        return txt_Pending;
    }

    private WebElement getTxtbx_AmountCaptured(int tabCount, int rowCount) {
        txtbx_AmountCaptured = driver.findElement(By.xpath("(//div[@id='tabCon_" + tabCount + "']//input[@id='creditAmountCaptured'])[" + rowCount + "]"));
        return txtbx_AmountCaptured;
    }

    private WebElement getChkbx_Resolved(int tabCount, int rowCount) {
        chkbx_Resolved = driver.findElement(By.xpath("(//div[@id='tabCon_" + tabCount + "']//input[@id='creditAmountResolved'])[" + rowCount + "]"));
        return chkbx_Resolved;
    }

    private WebElement getTxtbx_Reason(int tabCount) {
        txtbx_Reason = driver.findElement(By.xpath("//input[@id='creditReasonAmountCapturedId' and @tab='tabCon_" + tabCount + "']"));
        return txtbx_Reason;
    }

    private WebElement getBtn_CreditNoteOk(int tabCount) {
        btn_CreditNoteOk = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@id='addCreditNote']/div/table/tbody/tr/td/div/button"));
        return btn_CreditNoteOk;
    }

    private WebElement getBtn_CreditNoteCancel(int tabCount) {
        btn_CreditNoteCancel = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@id='addCreditNote']/div/h2/a"));
        return btn_CreditNoteCancel;
    }

    public void getCancelCreditNote(int tabCount) {
        clickOn(driver, getBtn_CreditNoteCancel(tabCount));
    }

    public boolean getAddCreditNote(int tabCount, int rowCount, String amt, String pending, String amtCaptured, String isResolved) {
        getExplicitWait(driver, getTxt_CreditNote(tabCount), EXPLICIT_WAIT);

        if (getTxt_Amount(tabCount, rowCount).getText().equals(amt)) {
            if (getTxt_Pending(tabCount, rowCount).getText().equals(pending)) {
                clickOn(driver, getChkbx_Enable(tabCount, rowCount));
                type(getTxtbx_AmountCaptured(tabCount, rowCount), amtCaptured);
                if (isResolved.equalsIgnoreCase("yes")) {
                    clickOn(driver, getChkbx_Resolved(tabCount, rowCount));
                }
                clickOn(driver, getTxtbx_Reason(tabCount));
                return true;
            } else {
                testWarningLog("Additional credit notes are present for the Distributor. The pending amount - " + pending);
            }
        } else {
            testWarningLog("Additional credit notes are present for the Distributor. The Credit Note amount - " + amt);
        }
        return false;
    }

    public void setCreditNoteReason(int tabCount, String reason) {
        if (reason != null) {
            type(getTxtbx_Reason(tabCount), reason);
        }
    }

    public void getAddCreditOk(int tabCount) {
        clickOn(driver, getBtn_CreditNoteOk(tabCount));
    }

    public int getCreditNotesCount(int tabCount) {
        return getList_CreditNoteEnable(tabCount).size();
    }

    public boolean getCheckCreditNote(int tabCount) {
        if (getTxt_NoCreditNote(tabCount).isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean isCreditPresent(int tabCount) {
        try {
            if (getChkbx_Enable(tabCount, 1).isDisplayed()) {
                return true;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }

    public void getSelectCreditNotes(int tabCount, HashMap<String, ArrayList<Object>> map) {
        boolean addCheck = false;
        if (isCreditPresent(tabCount)) {
            for (int i = 1; i <= map.get(CREDIT_AMOUNT).size(); i++) {
                if (!Objects.equals(map.get(CREDIT_AMOUNT).get(i - 1).toString(), "")) {
                    if (getAddCreditNote(tabCount, i, getData(map, CREDIT_AMOUNT, i - 1), getData(map, CREDIT_PENDING, i - 1), getData(map, CREDIT_AMOUNT_CAPTURED, i - 1), getData(map, CREDIT_RESOLVED, i - 1))) {
                        testStepsLog(_logStep++, "Credit note enabled : " + getData(map, CREDIT_AMOUNT, i - 1) + " - Captured Credit Amount : " + getData(map, CREDIT_AMOUNT_CAPTURED, i - 1));
                        addCheck = true;
                    }
                }
            }
            if (addCheck) {
                new CreditNoteVerification(driver).verifyCreditAmountCapturedCheck(tabCount, getData(map, CREDIT_TOTAL_AMOUNT_CAPTURED, 0));
            }
        }

        setCreditNoteReason(tabCount, getData(map, CREDIT_REASON, 0));
        getAddCreditOk(tabCount);
    }

}
