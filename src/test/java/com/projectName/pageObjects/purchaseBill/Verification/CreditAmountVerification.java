package com.projectName.pageObjects.purchaseBill.Verification;

import com.projectName.constants.DataConstantsPurchaseBill;
import com.projectName.pageObjects.purchaseBill.Controller.CreditAmountTabController;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;

public class CreditAmountVerification extends AbstractPage implements DataConstantsPurchaseBill {

    CreditAmountTabController creditAmountTabController = new CreditAmountTabController(driver);

    private WebElement txt_Distributor;
    private WebElement txt_PurchaseInvoice;
    private WebElement txt_Amount;
    private WebElement txt_CreditAmount;
    private WebElement txt_Status;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public CreditAmountVerification(WebDriver driver) {
        super(driver);
    }

    private WebElement getTxt_Distributor(int tabCount, int row) {
        txt_Distributor = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[2]/div)[" + row + "]"));
        return txt_Distributor;
    }

    private WebElement getTxt_PurchaseInvoice(int tabCount, int row) {
        txt_PurchaseInvoice = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[5]/div)[" + row + "]"));
        return txt_PurchaseInvoice;
    }

    private WebElement getTxt_Amount(int tabCount, int row) {
        txt_Amount = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[6]/div)[" + row + "]"));
        return txt_Amount;
    }

    private WebElement getTxt_CreditAmount(int tabCount, int row) {
        txt_CreditAmount = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[7]/div)[" + row + "]"));
        return txt_CreditAmount;
    }

    private WebElement getTxt_Status(int tabCount, int row) {
        txt_Status = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[9]/div)[" + row + "]"));
        return txt_Status;
    }

    public void getVerifyPurchaseCreditAmount(int tabCount, int row, String distributor, String purchaseInvoice, String amount, String creditAmount, String status) {
        Assert.assertEquals(getTxt_Distributor(tabCount, row).getText(), distributor, "Distributor is not Matching");
        Assert.assertEquals(getTxt_PurchaseInvoice(tabCount, row).getText(), purchaseInvoice, "Purchase Invoice is not Matching");
        Assert.assertTrue(getTxt_Amount(tabCount, row).getText().contains(amount), "Amount is not Matching");
        Assert.assertEquals(getTxt_CreditAmount(tabCount, row).getText(), creditAmount, "Credit amount is not Matching");
        Assert.assertEquals(getTxt_Status(tabCount, row).getText(), status, "Status is not Matching");
        testStepsLog(_logStep++, "Distributor Name - " + getTxt_Distributor(tabCount, row).getText() + " ; Purchase Invoice - " + getTxt_PurchaseInvoice(tabCount, row).getText() +
                " ; Amount - " + getTxt_Amount(tabCount, row).getText() + " ; Credit Amount - " + getTxt_CreditAmount(tabCount, row).getText() +
                " ; Status - " + getTxt_Status(tabCount, row).getText());
    }

    public void getCreditAmountCheck(int tabCount, HashMap<String, ArrayList<Object>> map) {
        creditAmountTabController.getSearchPurchaseInvoice(tabCount, getData(map, DISTRIBUTOR_NAME, 0), getData(map, INVOICE_NO, 0), getData(map, CREDIT_AMOUNT, 0));

        int count = 0;
        int row = 1;
        for (int i = 0; i < map.get(CREDIT_AMOUNT).size(); i++) {
            if (!getData(map, CREDIT_AMOUNT, i).equals("")) {
                count++;
            }
        }

        for (int i = count; i > 0; i--) {
            getVerifyPurchaseCreditAmount(tabCount, row, getData(map, DISTRIBUTOR_NAME, 0), getData(map, INVOICE_NO, 0), getData(map, CREDIT_AMOUNT, i - 1),
                    getData(map, CREDIT_AMOUNT_CAPTURED, i - 1), getData(map, RETURN_CREDIT_STATUS, i - 1));
            row++;
        }
    }

}
