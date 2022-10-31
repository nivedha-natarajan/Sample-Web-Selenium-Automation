package com.projectName.pageObjects.purchaseBill.Controller;

import com.projectName.pageObjects.common.Controller.SideMenuController;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BatchStockTabController extends AbstractPage {

    //AddFilter Tab
    private WebElement btn_ApplyFilter;
    private WebElement btn_ResetFilter;
    private WebElement txtbx_FilterMedicine;
    private WebElement txtbx_FilterMRPFrom;
    private WebElement txtbx_FilterMRPTo;
    private WebElement txtbx_FilterBatch;
    private WebElement txtbx_FilterRack;
    private WebElement txtbx_FilterExpiry;
    private WebElement txtbx_FilterLimit;
    private WebElement txtbx_FilterCategory;
    private WebElement clk_FilterStock;
    private WebElement slt_FilterAll;
    private WebElement slt_FilterGreaterThanZero;
    private WebElement slt_LessThanZero;
    private WebElement slt_EqualToZero;

    //StockBatch
    private WebElement btn_Filter;
    private WebElement btn_Export;
    private WebElement btn_Refresh;
    private WebElement txtbx_SearchMedicine;
    private WebElement txtbx_SearchBatch;
    private WebElement txtbx_SearchBarcode;
    private WebElement txt_Medicine;
    private WebElement txt_Batch;
    private WebElement txt_Barcode;
    private List<WebElement> list_HerderName;
    private List<WebElement> list_HerderInputName;
    private WebElement txt_Stock;
    private WebElement txtbx_Quantity;
    private WebElement txtbx_Loose;
    private WebElement btn_Save;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public BatchStockTabController(WebDriver driver) {
        super(driver);
    }

    private WebElement getBtn_ApplyFilter() {
        btn_ApplyFilter = driver.findElement(By.id("applyFilter"));
        return btn_ApplyFilter;
    }

    private WebElement getBtn_ResetFilter() {
        btn_ResetFilter = driver.findElement(By.id("resetFilter"));
        return btn_ResetFilter;
    }

    private WebElement getTxtbx_FilterMedicine() {
        txtbx_FilterMedicine = driver.findElement(By.id("lookbackMedicineName"));
        return txtbx_FilterMedicine;
    }

    private WebElement getTxtbx_FilterMRPFrom() {
        txtbx_FilterMRPFrom = driver.findElement(By.xpath("//input[@placeholder='Mrp From']"));
        return txtbx_FilterMRPFrom;
    }

    private WebElement getTxtbx_FilterMRPTo() {
        txtbx_FilterMRPTo = driver.findElement(By.xpath("//input[@placeholder='Mrp To']"));
        return txtbx_FilterMRPTo;
    }

    private WebElement getTxtbx_FilterBatch() {
        txtbx_FilterBatch = driver.findElement(By.id("lookbackTextField"));
        return txtbx_FilterBatch;
    }

    private WebElement getTxtbx_FilterRack() {
        txtbx_FilterRack = driver.findElement(By.id("lookbackRack"));
        return txtbx_FilterRack;
    }

    private WebElement getTxtbx_FilterExpiry() {
        txtbx_FilterExpiry = driver.findElement(By.id("lookbackExp"));
        return txtbx_FilterExpiry;
    }

    private WebElement getTxtbx_FilterLimit() {
        txtbx_FilterLimit = driver.findElement(By.id("lookbackLimit"));
        return txtbx_FilterLimit;
    }

    private WebElement getTxtbx_FilterCategory() {
        txtbx_FilterCategory = driver.findElement(By.id("lookbackCategory"));
        return txtbx_FilterCategory;
    }

    private WebElement getClk_FilterStock() {
        clk_FilterStock = driver.findElement(By.xpath("//table[@id='filterTable']//div/button/span[text()='All']"));
        return clk_FilterStock;
    }

    private WebElement getSlt_FilterAll() {
        slt_FilterAll = driver.findElement(By.xpath("//table[@id='filterTable']//div[@class='dropdown-menu open']/ul/li/a/span[text()='All']"));
        return slt_FilterAll;
    }

    private WebElement getSlt_FilterGreaterThanZero() {
        slt_FilterGreaterThanZero = driver.findElement(By.xpath("//table[@id='filterTable']//div[@class='dropdown-menu open']/ul/li/a/span[text()='Greater than 0']"));
        return slt_FilterGreaterThanZero;
    }

    private WebElement getSlt_LessThanZero() {
        slt_LessThanZero = driver.findElement(By.xpath("//table[@id='filterTable']//div[@class='dropdown-menu open']/ul/li/a/span[text()='Less than 0']"));
        return slt_LessThanZero;
    }

    private WebElement getSlt_EqualToZero() {
        slt_EqualToZero = driver.findElement(By.xpath("//table[@id='filterTable']//div[@class='dropdown-menu open']/ul/li/a/span[text()='Equal to 0']"));
        return slt_EqualToZero;
    }

    private WebElement getBtn_Filter(int tabCount) {
        btn_Filter = driver.findElement(By.xpath("//div[@id='tab_" + tabCount + "']//button[@id='filter']"));
        return btn_Filter;
    }

    private WebElement getBtn_Export(int tabCount) {
        btn_Export = driver.findElement(By.xpath("//div[@id='tab_" + tabCount + "']//button[@id='export']"));
        return btn_Export;
    }

    private WebElement getBtn_Refresh(int tabCount) {
        btn_Refresh = driver.findElement(By.xpath("//div[@id='tab_" + tabCount + "']//button[@id='refreshCTA']"));
        return btn_Refresh;
    }

    private WebElement getTxtbx_SearchMedicine(int tabCount) {
        txtbx_SearchMedicine = driver.findElement(By.xpath("//div[@id='tab_" + tabCount + "']//div[@class='dataTables_scrollHead']//input[@placeholder='Medicine']"));
        return txtbx_SearchMedicine;
    }

    private WebElement getTxtbx_SearchBatch(int tabCount) {
        txtbx_SearchBatch = driver.findElement(By.xpath("//div[@id='tab_" + tabCount + "']//div[@class='dataTables_scrollHead']//input[@placeholder='Batch']"));
        return txtbx_SearchBatch;
    }

    private WebElement getTxtbx_SearchBarcode(int tabCount) {
        txtbx_SearchBarcode = driver.findElement(By.xpath("//div[@id='tab_" + tabCount + "']//div[@class='dataTables_scrollHead']//input[@placeholder='Barcode']"));
        return txtbx_SearchBarcode;
    }

    private WebElement getTxt_Medicine(int tabCount) {
        txt_Medicine = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td/div)[1]"));
        return txt_Medicine;
    }

    private WebElement getTxt_Batch(int tabCount) {
        txt_Batch = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[5]/div)[1]"));
        return txt_Batch;
    }

    private WebElement getTxt_Barcode(int tabCount) {
        txt_Barcode = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[6]/div)[1]"));
        return txt_Barcode;
    }

    private List<WebElement> getList_HeaderName(int tabCount) {
        list_HerderName = driver.findElements(By.xpath("//div[@id='mainTable_tabCon_" + tabCount + "_wrapper']//table/thead/tr[@role='row']/descendant::th"));
        return list_HerderName;
    }

    private List<WebElement> getList_HeaderInputName(int tabCount) {
        list_HerderInputName = driver.findElements(By.xpath("//div[@id='mainTable_tabCon_" + tabCount + "_wrapper']//table/thead/tr[@role='row']/th/input"));
        return list_HerderInputName;
    }

    private WebElement getTxt_Stock(int tabCount, int col) {
        txt_Stock = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[" + col + "]/div)[1]"));
        return txt_Stock;
    }

    private WebElement getTxtbx_Quantity(int tabCount) {
        txtbx_Quantity = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[15]/div/input[contains(@id,'qtyStockAdjustment')])[1]"));
        return txtbx_Quantity;
    }

    private WebElement getTxtbx_Loose(int tabCount) {
        txtbx_Loose = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[15]/div/input[contains(@id,'looseStockAdjustment')])[1]"));
        return txtbx_Loose;
    }

    private WebElement getBtn_Save(int tabCount) {
        btn_Save = driver.findElement(By.xpath("(//table[@id='mainTable_tabCon_" + tabCount + "']/tbody/tr/td[15]/div/button)[1]"));
        return btn_Save;
    }

    public void getSearchMedicineStock(int tabCount, String medicine, String batch, String barcode) {
        getExplicitWait(driver, getTxtbx_SearchMedicine(tabCount), EXPLICIT_WAIT);
        type(getTxtbx_SearchMedicine(tabCount), medicine);
        type(getTxtbx_SearchBatch(tabCount), batch);
        type(getTxtbx_SearchBarcode(tabCount), barcode);
    }

    public int getStockColumnNumber(int tabCount) {
        int j = 0;
        for (int i = 0; i < (getList_HeaderName(tabCount).size() + getList_HeaderInputName(tabCount).size()); i++) {
            if (getList_HeaderName(tabCount).get(i).getText().isEmpty()) {
                if (getList_HeaderInputName(tabCount).get(j).getAttribute("placeholder").startsWith("St")) {
                    return i + 1;
                }
                j++;
            } else {
                if (getList_HeaderName(tabCount).get(i).getText().startsWith("St")) {
                    return i + 1;
                }
            }
        }
        return j;
    }

    public void getUpdateQuantity(int tabCount, String stock, String loose, String medicine, String reason) {
        pause();
        type(getTxtbx_Quantity(tabCount), stock);
        type(getTxtbx_Loose(tabCount), loose);
        clickOn(driver, getBtn_Save(tabCount));
        new SideMenuController(driver).getAlertAdjustmentPopUp(reason);
    }

    public void getListAllMedicine() {
        clickOn(driver, getBtn_ApplyFilter());
    }

    public void getStockRefresh(int tabCount) {
        clickOn(driver, getBtn_Refresh(tabCount));
    }

}
