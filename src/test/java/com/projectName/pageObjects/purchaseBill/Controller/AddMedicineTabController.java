package com.projectName.pageObjects.purchaseBill.Controller;

import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddMedicineTabController extends AbstractPage {

    private WebElement txt_AddMedicine;
    private WebElement txtbx_AddMedicineName;
    private WebElement txtbx_ItemType;
    private WebElement txtbx_Category;
    private WebElement drpbx_CategoryList;
    private WebElement txtbx_Packaging;
    private WebElement txtbx_Therapeutic;
    private WebElement txtbx_SubTherapeutic;
    private WebElement chkbx_IsLoose;
    private WebElement txtbx_QtyPerUnit;
    private WebElement txtbx_MedicineBarcode;
    private WebElement txtbx_MedicineShortCode;
    private WebElement txtbx_Manufacturer;
    private List<WebElement> list_Manufacturer;
    private WebElement slt_Manufacturer;
    private WebElement txtbx_CGST;
    private WebElement txtbx_SGST;
    private WebElement txtbx_MinStock;
    private WebElement txtbx_MaxStrock;
    private WebElement txtbx_Salts;
    private WebElement rbtn_ScheduleNone;
    private WebElement rbtn_ScheduleH;
    private WebElement rbtn_ScheduleH1;
    private WebElement rbtn_Narcotics;
    private WebElement rbtn_ScheduleX;
    private WebElement txtbx_HSNCode;
    private WebElement txtbx_Rack;
    private WebElement txtbx_Substitute;
    private WebElement chkbx_TBMedicine;
    private WebElement txtbx_Remarks;
    private WebElement btn_AddMedicine;
    private WebElement clk_CloseAddMedicine;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public AddMedicineTabController(WebDriver driver) {
        super(driver);
    }

    private WebElement getTxt_AddMedicine() {
        txt_AddMedicine = driver.findElement(By.xpath("//div[@id='addMedicineSidebar']/div/h2/span[@id='addMedicineLabel']"));
        return txt_AddMedicine;
    }

    private WebElement getTxtbx_AddMedicineName() {
        txtbx_AddMedicineName = driver.findElement(By.id("sidebarMedicineName"));
        return txtbx_AddMedicineName;
    }

    private WebElement getTxtbx_ItemType() {
        txtbx_ItemType = driver.findElement(By.id("sidebarItemType"));
        return txtbx_ItemType;
    }

    private WebElement getTxtbx_Category() {
        txtbx_Category = driver.findElement(By.xpath("//div[@id='sidebarMedicineCategoryInput']/div/button"));
        return txtbx_Category;
    }

    private WebElement getDrpbx_CategoryList(String category) {
        drpbx_CategoryList = driver.findElement(By.xpath("//div[@id='sidebarMedicineCategoryInput']//a/span[text()='" + category + "']"));
        return drpbx_CategoryList;
    }

    private WebElement getTxtbx_Packaging() {
        txtbx_Packaging = driver.findElement(By.id("sidebarMedicinePackaging"));
        return txtbx_Packaging;
    }

    private WebElement getTxtbx_Therapeutic() {
        txtbx_Therapeutic = driver.findElement(By.id("sidebarTherapetic"));
        return txtbx_Therapeutic;
    }

    private WebElement getTxtbx_SubTherapeutic() {
        txtbx_SubTherapeutic = driver.findElement(By.id("sidebarSubTherapetic"));
        return txtbx_SubTherapeutic;
    }

    private WebElement getChkbx_IsLoose() {
        chkbx_IsLoose = driver.findElement(By.id("isLooseAddMedicineSidebar"));
        return chkbx_IsLoose;
    }

    private WebElement getTxtbx_QtyPerUnit() {
        txtbx_QtyPerUnit = driver.findElement(By.id("sidebarQty"));
        return txtbx_QtyPerUnit;
    }

    private WebElement getTxtbx_MedicineBarcode() {
        txtbx_MedicineBarcode = driver.findElement(By.id("sidebarMedicineBarcode"));
        return txtbx_MedicineBarcode;
    }

    private WebElement getTxtbx_MedicineShortCode() {
        txtbx_MedicineShortCode = driver.findElement(By.id("sidebarMedicineShortName"));
        return txtbx_MedicineShortCode;
    }

    private WebElement getTxtbx_Manufacturer() {
        txtbx_Manufacturer = driver.findElement(By.id("sidebarManufacturer"));
        return txtbx_Manufacturer;
    }

    private List<WebElement> getList_Manufacturer(String manufacturer) {
        list_Manufacturer = driver.findElements(By.xpath("//li[contains(@id,'ui-id') and starts-with(text(),'" + manufacturer + "')]"));
        return list_Manufacturer;
    }

    private WebElement getSlt_Manufacturer(String manufacturer, int count) {
        slt_Manufacturer = driver.findElement(By.xpath("(//li[contains(@id,'ui-id') and starts-with(text(),'" + manufacturer + "')])[" + count + "]"));
        return slt_Manufacturer;
    }

    private WebElement getTxtbx_CGST() {
        txtbx_CGST = driver.findElement(By.id("sidebarCGST"));
        return txtbx_CGST;
    }

    private WebElement getTxtbx_SGST() {
        txtbx_SGST = driver.findElement(By.id("sidebarSGST"));
        return txtbx_SGST;
    }

    private WebElement getTxtbx_MinStock() {
        txtbx_MinStock = driver.findElement(By.id("sidebarMinStock"));
        return txtbx_MinStock;
    }

    private WebElement getTxtbx_MaxStrock() {
        txtbx_MaxStrock = driver.findElement(By.id("sidebarMaxStock"));
        return txtbx_MaxStrock;
    }

    private WebElement getTxtbx_Salts() {
        txtbx_Salts = driver.findElement(By.id("s2id_compoundsAddMedicine"));
        return txtbx_Salts;
    }

    private WebElement getRbtn_ScheduleNone() {
        rbtn_ScheduleNone = driver.findElement(By.xpath("//tr[@id='sidebarScheduleType']/td/div/label/input[@value='103']"));
        return rbtn_ScheduleNone;
    }

    private WebElement getRbtn_ScheduleH() {
        rbtn_ScheduleH = driver.findElement(By.xpath("//tr[@id='sidebarScheduleType']/td/div/label/input[@value='-1']"));
        return rbtn_ScheduleH;
    }

    private WebElement getRbtn_ScheduleH1() {
        rbtn_ScheduleH1 = driver.findElement(By.xpath("//tr[@id='sidebarScheduleType']/td/div/label/input[@value='-2']"));
        return rbtn_ScheduleH1;
    }

    private WebElement getRbtn_Narcotics() {
        rbtn_Narcotics = driver.findElement(By.xpath("//tr[@id='sidebarScheduleType']/td/div/label/input[@value='-3']"));
        return rbtn_Narcotics;
    }

    private WebElement getRbtn_ScheduleX() {
        rbtn_ScheduleX = driver.findElement(By.xpath("//tr[@id='sidebarScheduleType']/td/div/label/input[@value='-4']"));
        return rbtn_ScheduleX;
    }

    private WebElement getTxtbx_HSNCode() {
        txtbx_HSNCode = driver.findElement(By.id("sidebarHSNCode"));
        return txtbx_HSNCode;
    }

    private WebElement getTxtbx_Rack() {
        txtbx_Rack = driver.findElement(By.id("sidebarRack"));
        return txtbx_Rack;
    }

    private WebElement getTxtbx_Substitute() {
        txtbx_Substitute = driver.findElement(By.id("sidebarSubstitute"));
        return txtbx_Substitute;
    }

    private WebElement getChkbx_TBMedicine() {
        chkbx_TBMedicine = driver.findElement(By.id("isTBAddMedicineSidebar"));
        return chkbx_TBMedicine;
    }

    private WebElement getTxtbx_Remarks() {
        txtbx_Remarks = driver.findElement(By.id("sidebarAddMedicineRemarks"));
        return txtbx_Remarks;
    }

    private WebElement getBtn_AddMedicine() {
        btn_AddMedicine = driver.findElement(By.xpath("//div[@id='addMedicineSidebar']//div[@class='sidebarFooterButton']/button"));
        return btn_AddMedicine;
    }

    private WebElement getClk_CloseAddMedicine() {
        clk_CloseAddMedicine = driver.findElement(By.xpath("//div[@id='addMedicineSidebar']/div/h2/a"));
        return clk_CloseAddMedicine;
    }

    public void getAddMedicine(String medName, String itemType, String category, String packaging, String therapeutic, String subTherapeutic,
                               String isLoose, String qty, String barcode, String shtCode, String manufacturer, String cgst, String minStock, String maxStock,
                               String salt, String schedule, String HSNCode, String rack, String substitute, String tb, String remarks) {
        getExplicitWait(driver, getTxt_AddMedicine(), EXPLICIT_WAIT);

        if (packaging.contains("TAB") || packaging.contains("Tab")) {
            type(getTxtbx_ItemType(), "TABLET");
        } else if (packaging.contains("ML") || packaging.contains("ml") || medName.contains("drops") || medName.contains("DROPS")) {
            type(getTxtbx_ItemType(), "LIQUID");
        } else if (packaging.contains("GM") || packaging.contains("gm")) {
            type(getTxtbx_ItemType(), "UNIT");
        } else {
            type(getTxtbx_ItemType(), "TABLET");
        }
        clickOn(driver, getTxtbx_Category());
        if (!category.isEmpty()) {
            clickOn(driver, getDrpbx_CategoryList(category));
        } else {
            clickOn(driver, getDrpbx_CategoryList("MEDICINE"));
        }
        if (getValue(getTxtbx_Packaging()).length() < 1) {
            type(getTxtbx_Packaging(), packaging);
        }
        type(getTxtbx_Therapeutic(), therapeutic);
        type(getTxtbx_SubTherapeutic(), subTherapeutic);
        if (isLoose.equalsIgnoreCase("Yes")) {
            clickOn(driver, getChkbx_IsLoose());
        }
        type(getTxtbx_QtyPerUnit(), qty);
        type(getTxtbx_MedicineBarcode(), barcode);
        type(getTxtbx_MedicineShortCode(), shtCode);
        pause(1);
        typeSlow(driver, getTxtbx_Manufacturer(), manufacturer);
        pause(1);
        if (getList_Manufacturer(manufacturer).size() > 0) {
            clickOn(driver, getSlt_Manufacturer(manufacturer, 1));
        } else {
            clickOn(driver, getSlt_Manufacturer("Add - " + manufacturer, 1));
        }
        type(getTxtbx_CGST(), cgst);
        type(getTxtbx_MinStock(), minStock);
        type(getTxtbx_MaxStrock(), maxStock);
        if (!salt.isEmpty()) {
            type(getTxtbx_Salts(), salt);
        }

        if (schedule.equals("H1")) {
            clickOn(driver, getRbtn_ScheduleH1());
        } else if (schedule.equals("H")) {
            clickOn(driver, getRbtn_ScheduleH());
        } else if (schedule.equalsIgnoreCase("Narcotics")) {
            clickOn(driver, getRbtn_Narcotics());
        } else if (schedule.equals("X")) {
            clickOn(driver, getRbtn_ScheduleX());
        }
        getMoveElementToVisibility(driver, getTxtbx_Remarks());
        type(getTxtbx_HSNCode(), HSNCode);
        type(getTxtbx_Rack(), rack);
        type(getTxtbx_Substitute(), substitute);
        if (tb.equalsIgnoreCase("Yes")) {
            clickOn(driver, getChkbx_TBMedicine());
        }
        type(getTxtbx_Remarks(), remarks);
        clickOn(driver, getBtn_AddMedicine());
    }
}
