package com.projectName.pageObjects.purchaseBill.Controller;

import com.projectName.constants.DataColumnsPurchaseBill;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;

public class MedicinesController extends AbstractPage implements DataColumnsPurchaseBill {

    private WebElement txtbx_HeaderRack;
    private WebElement txtbx_HeaderMarkUp;
    private WebElement txtbx_HeaderMinStock;
    private WebElement txtbx_HeaderMaxStock;
    private WebElement btn_Filter;
    private WebElement txtbx_SearchMedicine;
    private WebElement txtbx_SearchRack;
    private WebElement chkbx_SelectAll;
    private WebElement chkbx_Select;
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
    private WebElement txt_CurrQty;
    private WebElement txt_SchCP;
    private WebElement btn_Save;
    private WebElement btn_SaveSelected;
    private WebElement txt_PageNo;
    private WebElement btn_Previous;
    private WebElement btn_Next;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public MedicinesController(WebDriver driver) {
        super(driver);
    }

    private WebElement getTxtbx_HeaderRack(int tabCount) {
        txtbx_HeaderRack = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//input[@id='setRack']"));
        return txtbx_HeaderRack;
    }

    private WebElement getTxtbx_HeaderMarkUp(int tabCount) {
        txtbx_HeaderMarkUp = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//input[@id='setMarkup']"));
        return txtbx_HeaderMarkUp;
    }

    private WebElement getTxtbx_HeaderMinStock(int tabCount) {
        txtbx_HeaderMinStock = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//input[@id='setMinStock']"));
        return txtbx_HeaderMinStock;
    }

    private WebElement getTxtbx_HeaderMaxStock(int tabCount) {
        txtbx_HeaderMaxStock = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//input[@id='setMaxStock']"));
        return txtbx_HeaderMaxStock;
    }

    private WebElement getBtn_Filter(int tabCount) {
        btn_Filter = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//button[contains(@onclick,'discountFilter')]"));
        return btn_Filter;
    }

    private WebElement getTxtbx_SearchMedicine(int tabCount) {
        txtbx_SearchMedicine = driver.findElement(By.xpath("//div[contains(@id,'tabCon_" + tabCount + "')]//div[@class='dataTables_scrollHead']//input[@placeholder='Medicine']"));
        return txtbx_SearchMedicine;
    }

    private WebElement getTxtbx_SearchRack(int tabCount) {
        txtbx_SearchRack = driver.findElement(By.xpath("//div[contains(@id,'tabCon_" + tabCount + "')]//div[@class='dataTables_scrollHead']//input[@placeholder='Rack']"));
        return txtbx_SearchRack;
    }

    private WebElement getChkbx_SelectAll(int tabCount) {
        chkbx_SelectAll = driver.findElement(By.xpath("//div[contains(@id,'tabCon_" + tabCount + "')]//div[@class='dataTables_scrollHead']//input[@id='checkAllMedicine']"));
        return chkbx_SelectAll;
    }

    private WebElement getChkbx_Select(int tabCount, int row) {
        chkbx_Select = driver.findElement(By.xpath("(//table[@id='discountTable_tabCon_" + tabCount + "']//tr/td/div/input[@id='saveSelectedMedicine'])[" + row + "]"));
        return chkbx_Select;
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

    private WebElement getTxt_CurrQty(int tabCount, int row) {
        txt_CurrQty = driver.findElement(By.xpath("(//table[@id='discountTable_tabCon_" + tabCount + "']//td[14]/div)[" + row + "]"));
        return txt_CurrQty;
    }

    private WebElement getTxt_SchCP(int tabCount, int row) {
        txt_SchCP = driver.findElement(By.xpath("(//table[@id='discountTable_tabCon_" + tabCount + "']//td/label[@class='schemeCp'])[" + row + "]"));
        return txt_SchCP;
    }

    private WebElement getBtn_Save(int tabCount, int row) {
        btn_Save = driver.findElement(By.xpath("(//table[@id='discountTable_tabCon_" + tabCount + "']//tr/td/button[contains(@onClick,'saveDiscDetails')])[" + row + "]"));
        return btn_Save;
    }

    private WebElement getBtn_SaveSelected(int tabCount) {
        btn_SaveSelected = driver.findElement(By.xpath("//div[@id='tabCon_" + tabCount + "']//div[@id='discountTableFooter']/button[contains(@onClick,'saveSelectedMedicinesButton')]"));
        return btn_SaveSelected;
    }

    private WebElement getBtn_Previous(int tabCount) {
        btn_Previous = driver.findElement(By.xpath("//a[@id='discountTable_tabCon_" + tabCount + "_previous']"));
        return btn_Previous;
    }

    private WebElement getBtn_Next(int tabCount) {
        btn_Next = driver.findElement(By.xpath("//a[@id='discountTable_tabCon_" + tabCount + "_next']"));
        return btn_Next;
    }

    private WebElement getTxt_PageNo(int tabCount) {
        txt_PageNo = driver.findElement(By.xpath("//div[@id='discountTable_tabCon_7_paginate']/span/a"));
        return txt_PageNo;
    }

    public void getEnterHeaderDetails(int tabCount, HashMap<String, ArrayList<Object>> map) {
        typeSlow(driver, getTxtbx_HeaderRack(tabCount), getData(map, RACK, 0));
        typeSlow(driver, getTxtbx_HeaderMarkUp(tabCount), getData(map, MARKUP, 0));
        typeSlow(driver, getTxtbx_HeaderMinStock(tabCount), getData(map, MIN_STOCK, 0));
        typeSlow(driver, getTxtbx_HeaderMaxStock(tabCount), getData(map, MAX_STOCK, 0));
    }

    public void getEnterMedicineDetails(int tabCount, int row, String disc, String markup, String sp, String maxDisc, String rack, String minStock, String maxStock, String loose) {
        type(getTxtbx_Disc(tabCount, row), disc);
        type(getTxtbx_MarkUp(tabCount, row), markup);
        type(getTxtbx_SP(tabCount, row), sp);
        type(getTxtbx_MaxDisc(tabCount, row), maxDisc);
        type(getTxtbx_Rack(tabCount, row), rack);
        type(getTxtbx_MinStk(tabCount, row), minStock);
        type(getTxtbx_MaxStk(tabCount, row), maxStock);
        type(getTxtbx_Loose(tabCount, row), loose);
        clickOn(driver, getBtn_Save(tabCount, row));
    }

    public void getSaveMedicineDetails(int tabCount) {
        clickOn(driver, getBtn_SaveSelected(tabCount));
    }

    public void getPreviousPage(int tabCount) {
        clickOn(driver, getBtn_Previous(tabCount));
    }

    public void getNext(int tabCount) {
        clickOn(driver, getBtn_Next(tabCount));
    }

    public String getPageNo(int tabCount) {
        return getTxt_PageNo(tabCount).getText();
    }

    public void getSelectAll(int tabCount) {
        clickOn(driver, getChkbx_SelectAll(tabCount));
    }
}
