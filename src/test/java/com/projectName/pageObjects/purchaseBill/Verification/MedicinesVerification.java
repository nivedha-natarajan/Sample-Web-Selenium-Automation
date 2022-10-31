package com.projectName.pageObjects.purchaseBill.Verification;

import com.projectName.constants.DataConstantsPurchaseBill;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;

public class MedicinesVerification extends AbstractPage implements DataConstantsPurchaseBill {

    private WebElement txtbx_HeaderRack;
    private WebElement txt_Medicine;
    private WebElement txt_MRP;
    private WebElement txt_EffCP;
    private WebElement txt_Margin;
    private WebElement txtbx_Disc;
    private WebElement txtbx_MarkUp;
    private WebElement txtbx_SP;
    private WebElement txtbx_MaxDisc;
    private WebElement txtbx_Rack;
    private WebElement txtbx_MinStk;
    private WebElement txtbx_MaxStk;
    private WebElement txtbx_Loose;
    private WebElement txt_SchCP;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public MedicinesVerification(WebDriver driver) {
        super(driver);
    }

    private WebElement getTxtbx_HeaderRack(int tabCount) {
        txtbx_HeaderRack = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//input[@id='setRack']"));
        return txtbx_HeaderRack;
    }

    private WebElement getTxt_Medicine(int tabCount, int row) {
        txt_Medicine = driver.findElement(By.xpath("(//table[@id='discountTable_tabCon_" + tabCount + "']//tr/td[2]/div[@class='text-wrap'])[" + row + "]"));
        return txt_Medicine;
    }

    private WebElement getTxt_MRP(int tabCount, int row) {
        txt_MRP = driver.findElement(By.xpath("(//table[@id='discountTable_tabCon_" + tabCount + "']//tr/td/label[@class='mrp'])[" + row + "]"));
        return txt_MRP;
    }

    private WebElement getTxt_EffCP(int tabCount, int row) {
        txt_EffCP = driver.findElement(By.xpath("(//table[@id='discountTable_tabCon_" + tabCount + "']//tr/td/label[@class='cp'])[" + row + "]"));
        return txt_EffCP;
    }

    private WebElement getTxt_Margin(int tabCount, int row) {
        txt_Margin = driver.findElement(By.xpath("(//table[@id='discountTable_tabCon_" + tabCount + "']//tr/td/input[contains(@id,'marginColumn')])[" + row + "]"));
        return txt_Margin;
    }

    private WebElement getTxtbx_Disc(int tabCount, int row) {
        txtbx_Disc = driver.findElement(By.xpath("(//table[@id='discountTable_tabCon_" + tabCount + "']//tr/td/input[contains(@id,'discColumn')])[" + row + "]"));
        return txtbx_Disc;
    }

    private WebElement getTxtbx_MarkUp(int tabCount, int row) {
        txtbx_MarkUp = driver.findElement(By.xpath("(//table[@id='discountTable_tabCon_" + tabCount + "']//tr/td/input[contains(@id,'markupColumn')])[" + row + "]"));
        return txtbx_MarkUp;
    }

    private WebElement getTxtbx_SP(int tabCount, int row) {
        txtbx_SP = driver.findElement(By.xpath("(//table[@id='discountTable_tabCon_" + tabCount + "']//tr/td/input[contains(@id,'sellingPriceColumn')])[" + row + "]"));
        return txtbx_SP;
    }

    private WebElement getTxtbx_MaxDisc(int tabCount, int row) {
        txtbx_MaxDisc = driver.findElement(By.xpath("(//table[@id='discountTable_tabCon_" + tabCount + "']//tr/td/input[contains(@id,'maxDiscColumn')])[" + row + "]"));
        return txtbx_MaxDisc;
    }

    private WebElement getTxtbx_Rack(int tabCount, int row) {
        txtbx_Rack = driver.findElement(By.xpath("(//table[@id='discountTable_tabCon_" + tabCount + "']//tr/td/input[contains(@id,'rackColumn')])[" + row + "]"));
        return txtbx_Rack;
    }

    private WebElement getTxtbx_MinStk(int tabCount, int row) {
        txtbx_MinStk = driver.findElement(By.xpath("(//table[@id='discountTable_tabCon_" + tabCount + "']//tr/td/input[contains(@id,'minStockColumn')])[" + row + "]"));
        return txtbx_MinStk;
    }

    private WebElement getTxtbx_MaxStk(int tabCount, int row) {
        txtbx_MaxStk = driver.findElement(By.xpath("(//table[@id='discountTable_tabCon_" + tabCount + "']//tr/td/input[contains(@id,'maxStockColumn')])[" + row + "]"));
        return txtbx_MaxStk;
    }

    private WebElement getTxtbx_Loose(int tabCount, int row) {
        txtbx_Loose = driver.findElement(By.xpath("(//table[@id='discountTable_tabCon_" + tabCount + "']//tr/td/input[contains(@id,'setLoose')])[" + row + "]"));
        return txtbx_Loose;
    }

    private WebElement getTxt_SchCP(int tabCount, int row) {
        txt_SchCP = driver.findElement(By.xpath("(//table[@id='discountTable_tabCon_" + tabCount + "']//td/label[@class='schemeCp'])[" + row + "]"));
        return txt_SchCP;
    }

    public void getVerifyMedicineBeforeModifyDetails(int tabCount, HashMap<String, ArrayList<Object>> map) {
        getExplicitWait(driver, getTxtbx_HeaderRack(tabCount), 20);
        for (int i = 0; i < map.get(MEDICINE_NAME).size(); i++) {
            for (int j = 1; j <= getTxt_Medicine(tabCount, j).getText().length(); j++) {
                if (getTxt_Medicine(tabCount, j).getText().startsWith(getData(map, MEDICINE_NAME, i))) {
                    Assert.assertTrue(getTxt_Medicine(tabCount, j).getText().startsWith(getData(map, MEDICINE_NAME, i)), "Medicine name is not Matching");
                    Assert.assertEquals(getTxt_MRP(tabCount, j).getText(), getData(map, MRP, i));
                    Assert.assertEquals(getTxt_EffCP(tabCount, j).getText(), getData(map, EFF_CP, i));
                    Assert.assertEquals(getTxt_SchCP(tabCount, j).getText(), getData(map, SCH_CP, i));
                    break;
                }
            }
        }
    }

    public void getVerifyMedicineAfterModifyDetails(int tabCount, HashMap<String, ArrayList<Object>> map) {
        getExplicitWait(driver, getTxtbx_HeaderRack(tabCount), EXPLICIT_WAIT);
        for (int i = 0; i < map.get(MEDICINE_NAME).size(); i++) {
            for (int row = 1; row <= getTxt_Medicine(tabCount, row).getText().length(); row++) {
                if (getTxt_Medicine(tabCount, row).getText().startsWith(getData(map, MEDICINE_NAME, i))) {
                    Assert.assertTrue(getTxt_Medicine(tabCount, row).getText().startsWith(getData(map, MEDICINE_NAME, i)), "Medicine name is not Matching");
                    Assert.assertEquals(getTxt_MRP(tabCount, row).getText(), getData(map, MRP, i), "MRP is not Matching");
                    Assert.assertEquals(getTxt_EffCP(tabCount, row).getText(), getData(map, EFF_CP, i), "EffCP name is not Matching");
                    Assert.assertEquals(getValue(getTxt_Margin(tabCount, row)), getData(map, CHANGED_MARGIN, i), "Margin is not Matching");
                    Assert.assertEquals(getValue(getTxtbx_Disc(tabCount, row)), getData(map, DISC, i), "Discount is not Matching");
                    Assert.assertTrue(getValue(getTxtbx_MarkUp(tabCount, row)).startsWith(getData(map, MARKUP, i)), "Markup is not Matching");
                    Assert.assertEquals(getValue(getTxtbx_SP(tabCount, row)), getData(map, SP, i), "SP is not Matching");
                    Assert.assertEquals(getValue(getTxtbx_MaxDisc(tabCount, row)), getData(map, MAX_DISC, i), "Max Discount is not Matching");
                    Assert.assertEquals(getValue(getTxtbx_Rack(tabCount, row)), getData(map, RACK, i), "Rack is not Matching");
                    Assert.assertEquals(getValue(getTxtbx_MinStk(tabCount, row)), getData(map, MIN_STOCK, i), "Min Stock is not Matching");
                    Assert.assertEquals(getValue(getTxtbx_MaxStk(tabCount, row)), getData(map, MAX_STOCK, i), "Max Stock is not Matching");
                    Assert.assertEquals(getValue(getTxtbx_Loose(tabCount, row)), getData(map, LOOSE, i), "Loose quantity is not Matching");
                    Assert.assertEquals(getTxt_SchCP(tabCount, row).getText(), getData(map, SCH_CP, i), "SchCP is not Matching");
                    break;
                }
            }
        }
    }
}

