package com.projectName.pageObjects.common.Controller;

import com.projectName.constants.DataTabs;
import com.projectName.pageObjects.common.Verification.SideMenuVerification;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideMenuController extends AbstractPage implements DataTabs {

    private WebElement clk_MenuIcon;

    //Tab
    private WebElement tab_CurrentTabName;
    private WebElement btn_TabClose;
    private WebElement txt_TabClose;
    private WebElement btn_TabCloseOK;
    private WebElement btn_TabCloseCancel;

    //Purchase Bill
    private WebElement clk_PurchaseIcon;
    private WebElement clk_PurchaseBill;
    private WebElement clk_PurchaseOrder;

    //Sales Bill
    private WebElement clk_Sales;
    private WebElement txt_Sales;
    private WebElement clk_SalesBill;
    private WebElement clk_SalesOrder;

    //Distributor
    private WebElement clk_Master;
    private WebElement clk_Patients;
    private WebElement clk_Doctors;
    private WebElement clk_Distributors;
    private WebElement clk_InvoiceFromChallan;

    //Configuration
    private WebElement clk_Administration;
    private WebElement clk_Configuration;
    private WebElement clk_ExportToTally;

    //Returns
    private WebElement clk_Returns;
    private WebElement txt_Returns;
    private WebElement clk_PurchaseReturn;
    private WebElement clk_SalesReturn;

    //Reports
    private WebElement clk_Reports;
    private WebElement txt_Reports;
    private WebElement clk_PurchaseReports;
    private WebElement clk_CreditAmountTracking;
    private WebElement clk_StockReports;
    private WebElement clk_BatchStock;

    private WebElement clk_SignOut;

    //Alert
    private WebElement txt_AlertMessages;
    private WebElement btn_AlertClose;

    //DeleteBills
    private WebElement pop_Password;
    private WebElement txtbx_EnterPassword;
    private WebElement btn_PasswordOk;
    private WebElement btn_PasswordCancel;
    private WebElement pop_Delete;
    private WebElement btn_DeleteOk;
    private WebElement btn_DeleteCancel;
    private WebElement txt_Adjustment;
    private WebElement txtbx_Adjustment;
    private WebElement btn_AdjustmentOK;
    private WebElement btn_AdjustmentCancel;

    //Backup
    private WebElement txt_Backup;
    private WebElement btn_BackupClose;

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public SideMenuController(WebDriver driver) {
        super(driver);
    }

    private WebElement getClk_MenuIcon() {
        clk_MenuIcon = driver.findElement(By.xpath("//a[@class='sidebar-collapse-icon']"));
        return clk_MenuIcon;
    }

    private WebElement getTab_CurrentTabName() {
        tab_CurrentTabName = driver.findElement(By.xpath("//ul[@id='navWrapTabs']/li[@class='active']/a/label"));
        return tab_CurrentTabName;
    }

    private WebElement getTab_TabName(String tab) {
        tab_CurrentTabName = driver.findElement(By.xpath("//ul[@id='navWrapTabs']/li/a/label[contains(text(),'" + tab + "')]"));
        return tab_CurrentTabName;
    }

    private WebElement getBtn_TabClose(int tabCount) {
        btn_TabClose = driver.findElement(By.xpath("//li[@id='nav_tab_" + tabCount + "']/a/div/button"));
        return btn_TabClose;
    }

    private WebElement getTxt_TabClose() {
        txt_TabClose = driver.findElement(By.xpath("//div[@class='bootbox modal fade bootbox-confirm in']//div[@class='modal-body']/div"));
        return txt_TabClose;
    }

    private WebElement getBtn_TabCloseOK(int tabCount) {
        btn_TabCloseOK = driver.findElement(By.xpath("//div[@class='bootbox modal fade bootbox-confirm in']//div[@class='modal-footer']/button[text()='OK']"));
        return btn_TabCloseOK;
    }

    private WebElement getBtn_TabCloseCancel(int tabCount) {
        btn_TabCloseCancel = driver.findElement(By.xpath("//div[@class='bootbox modal fade bootbox-confirm in']//div[@class='modal-footer']/button[text()='Cancel']"));
        return btn_TabCloseCancel;
    }

    private WebElement getClk_PurchaseIcon() {
        clk_PurchaseIcon = driver.findElement(By.xpath("//div[@class='sidebar-menu leftSidebarMain']/ul/li/a/span[text()='Purchase']/parent::a/img"));
        return clk_PurchaseIcon;
    }

    private WebElement getClk_PurchaseBill() {
        clk_PurchaseBill = driver.findElement(By.xpath("//div[@class='sidebar-menu leftSidebarMain']//ul/li/a/span[text()='Purchase Bill']"));
        return clk_PurchaseBill;
    }

    private WebElement getClk_PurchaseOrder() {
        clk_PurchaseOrder = driver.findElement(By.xpath("//ul[@id='main-menu']/li/ul/li/a/span[text()='Purchase Orders']"));
        return clk_PurchaseOrder;
    }

    private WebElement getClk_Sales() {
        clk_Sales = driver.findElement(By.xpath("//ul[@id='main-menu']/li/a/span[text()='Sales']/parent::a/img"));
        return clk_Sales;
    }

    private WebElement getTxt_Sales() {
        txt_Sales = driver.findElement(By.xpath("//ul[@id='main-menu']/li/a/span[text()='Sales']"));
        return txt_Sales;
    }

    private WebElement getClk_SalesBill() {
        clk_SalesBill = driver.findElement(By.xpath("//ul[@id='main-menu']//li/a/span[text()='Sales Bill']"));
        return clk_SalesBill;
    }

    private WebElement getClk_SalesOrder() {
        clk_SalesOrder = driver.findElement(By.xpath("//ul[@id='main-menu']//li/a/span[text()='Sales Orders']"));
        return clk_SalesOrder;
    }

    private WebElement getClk_Master() {
        clk_Master = driver.findElement(By.xpath("//ul[@id='main-menu']/li/a/span[text()='Master']/parent::a/img"));
        return clk_Master;
    }

    private WebElement getClk_Patients() {
        clk_Patients = driver.findElement(By.xpath("//ul[@id='main-menu']/li/a/span[text()='Master']/parent::a/parent::li/ul/li/a/span[text()='Patients']/parent::a"));
        return clk_Patients;
    }

    private WebElement getClk_Doctors() {
        clk_Doctors = driver.findElement(By.xpath("//ul[@id='main-menu']/li/a/span[text()='Master']/parent::a/parent::li/ul/li/a/span[text()='Doctors']/parent::a"));
        return clk_Doctors;
    }

    private WebElement getClk_Distributors() {
        clk_Distributors = driver.findElement(By.xpath("//div[@class='sidebar-menu leftSidebarMain']//a/span[text()='Master']/parent::a/parent::li/ul/li/a/span[text()='Distributors']"));
        return clk_Distributors;
    }

    private WebElement getClk_InvoiceFromChallan() {
        clk_InvoiceFromChallan = driver.findElement(By.xpath("//ul[@id='main-menu']/li/ul/li/a/span[contains(text(),'Create Invoice from Challan')]"));
        return clk_InvoiceFromChallan;
    }

    private WebElement getClk_Administration() {
        clk_Administration = driver.findElement(By.xpath("//li[@id='UserHeader']/a"));
        return clk_Administration;
    }

    private WebElement getClk_Configuration() {
        clk_Configuration = driver.findElement(By.xpath("//ul[@id='UserHeaderUl']/li/a/span[text()='Configuration']"));
        return clk_Configuration;
    }

    private WebElement getClk_ExportToTally() {
        clk_ExportToTally = driver.findElement(By.xpath("//ul[@id='UserHeaderUl']/li/a/span[text()='Export for Tally']"));
        return clk_ExportToTally;
    }

    private WebElement getClk_Returns() {
        clk_Returns = driver.findElement(By.xpath("//ul[@id='main-menu']/li/a/span[text()='Returns']/parent::a/img"));
        return clk_Returns;
    }

    private WebElement getTxt_Returns() {
        txt_Returns = driver.findElement(By.xpath("//ul[@id='main-menu']/li/a/span[text()='Returns']"));
        return txt_Returns;
    }

    private WebElement getClk_PurchaseReturn() {
        clk_PurchaseReturn = driver.findElement(By.xpath("//ul[@id='main-menu']/li/ul/li/a/span[text()='Purchase Return']"));
        return clk_PurchaseReturn;
    }

    private WebElement getClk_SalesReturn() {
        clk_SalesReturn = driver.findElement(By.xpath("//ul[@id='main-menu']//li/a/span[text()='Sales Return']"));
        return clk_SalesReturn;
    }

    private WebElement getClk_Reports() {
        clk_Reports = driver.findElement(By.xpath("//ul[@id='main-menu']/li/a/span[text()='Reports']/parent::a/img"));
        return clk_Reports;
    }

    private WebElement getTxt_Reports() {
        txt_Reports = driver.findElement(By.xpath("//ul[@id='main-menu']/li/a/span[text()='Reports']"));
        return txt_Reports;
    }

    private WebElement getClk_PurchaseReports() {
        clk_PurchaseReports = driver.findElement(By.xpath("//ul[@id='main-menu']/li/ul/li/a/span[text()='Purchase Reports']"));
        return clk_PurchaseReports;
    }

    private WebElement getClk_CreditAmountTracking() {
        clk_CreditAmountTracking = driver.findElement(By.xpath("//ul[@id='main-menu']//li/ul/li/a/span[text()='Credit Amount Tracking']"));
        return clk_CreditAmountTracking;
    }

    private WebElement getClk_StockReports() {
        clk_StockReports = driver.findElement(By.xpath("//ul[@id='main-menu']/li/ul/li/a/span[text()='Stock Reports']"));
        return clk_StockReports;
    }

    private WebElement getClk_BatchStock() {
        clk_BatchStock = driver.findElement(By.xpath("//ul[@id='main-menu']//li/a/span[text()='Batch Stock']"));
        return clk_BatchStock;
    }

    private WebElement getClk_PurchaseReturnBillOrders() {
        clk_PurchaseReturn = driver.findElement(By.xpath("//ul[@id='main-menu']/li/ul/li/a/span[text()='Purchase Return Orders']"));
        return clk_PurchaseReturn;
    }

    private WebElement getClk_SignOut() {
        clk_SignOut = driver.findElement(By.xpath("//ul[@id='main-menu']/li/a[@title='Sign Out']/img"));
        return clk_SignOut;
    }

    private WebElement getTxt_AlertMessage(String message) {
        txt_AlertMessages = driver.findElement(By.xpath("//div[@id='toast-container']/div/div[contains(text(),'" + message + "')]"));
        return txt_AlertMessages;
    }

    private WebElement getTxt_AlertMessage() {
        txt_AlertMessages = driver.findElement(By.xpath("//div[@id='toast-container']/div/div"));
        return txt_AlertMessages;
    }

    private WebElement getBtn_AlertClose() {
        btn_AlertClose = driver.findElement(By.xpath("//div[@id='toast-container']/div/button"));
        return btn_AlertClose;
    }

    //Password PopUp
    private WebElement getPop_Password() {
        pop_Password = driver.findElement(By.xpath("//div[@class='bootbox modal fade bootbox-prompt in']//div[@class='modal-header']/h4"));
        return pop_Password;
    }

    private WebElement getTxtbx_EnterPassword() {
        txtbx_EnterPassword = driver.findElement(By.xpath("//div/form/input[@type='password']"));
        return txtbx_EnterPassword;
    }

    private WebElement getBtn_PasswordOk() {
        btn_PasswordOk = driver.findElement(By.xpath("//div[@class='bootbox modal fade bootbox-prompt in']//div[@class='modal-footer']/button[text()='OK']"));
        return btn_PasswordOk;
    }

    private WebElement getBtn_PasswordCancel() {
        btn_PasswordCancel = driver.findElement(By.xpath("//div[@class='bootbox modal fade bootbox-prompt in']//div[@class='modal-footer']/button[text()='Cancel']"));
        return btn_PasswordCancel;
    }

    private WebElement getPop_Delete() {
        pop_Delete = driver.findElement(By.xpath("//div[@class='bootbox modal fade bootbox-confirm in']//div[@class='modal-body']/div[text()]"));
        return pop_Delete;
    }

    private WebElement getBtn_DeleteOk() {
        btn_DeleteOk = driver.findElement(By.xpath("//div[@class='bootbox modal fade bootbox-confirm in']//div[@class='modal-footer']/button[text()='OK']"));
        return btn_DeleteOk;
    }

    private WebElement getBtn_DeleteCancel() {
        btn_DeleteCancel = driver.findElement(By.xpath("//div[@class='bootbox modal fade bootbox-confirm in']//div[@class='modal-footer']/button[text()='Cancel']"));
        return btn_DeleteCancel;
    }

    private WebElement getTxt_Adjustment() {
        txt_Adjustment = driver.findElement(By.xpath("//div[@class='bootbox modal fade bootbox-prompt in']//div[@class='modal-header']/h4"));
        return txt_Adjustment;
    }

    private WebElement getBtn_AdjustmentOK() {
        btn_AdjustmentOK = driver.findElement(By.xpath("//div[@class='bootbox modal fade bootbox-prompt in']//div[@class='modal-footer']/button[@data-bb-handler='confirm']"));
        return btn_AdjustmentOK;
    }

    private WebElement getTxtbx_Adjustment() {
        txtbx_Adjustment = driver.findElement(By.xpath("//div[@class='bootbox modal fade bootbox-prompt in']//div[@class='modal-body']/div//textarea"));
        return txtbx_Adjustment;
    }

    private WebElement getBtn_AdjustmentCancel() {
        btn_AdjustmentCancel = driver.findElement(By.xpath("//div[@class='bootbox modal fade bootbox-prompt in']//div[@class='modal-footer']/button[@data-bb-handler='cancel']"));
        return btn_AdjustmentCancel;
    }

    private WebElement getTxt_Backup() {
        txt_Backup = driver.findElement(By.xpath("//div[@id='backupInProgress']/div/div/h2[text()='Backup in Progress']"));
        return txt_Backup;
    }

    private WebElement getBtn_BackupClose() {
        btn_BackupClose = driver.findElement(By.xpath("//div[@id='backupInProgress']/span"));
        return btn_BackupClose;
    }

    public boolean getCheckBackUpPopUp() {
        if (getTxt_Backup().isDisplayed()) {
            clickOn(driver, getBtn_BackupClose());
            return true;
        }
        return false;
    }

    public void getSignOut() {
        clickMenuIcon();
        clickOn(driver, getClk_SignOut());
        driver.switchTo().alert().accept();
    }

    public void clickMenuIcon() {
        clickOn(driver, getClk_MenuIcon());
    }

    public void clickPurchaseIcon() {
        clickOn(driver, getClk_PurchaseIcon());
    }

    public void clickDistributorTab() {
        clickOn(driver, getClk_Distributors());
    }

    public void clickPurchaseBill() {
        clickOn(driver, getClk_PurchaseBill());
    }

    public void clickPurchases() {
        clickOn(driver, getClk_PurchaseOrder());
    }

    public void clickMaster() {
        clickOn(driver, getClk_Master());
    }

    public int openDistributorTab() {
        clickMenuIcon();
        clickMaster();
        clickDistributorTab();
        return getCurrentTabCount(TAB_DISTRIBUTORS);
    }

    public int openPurchaseBillTab() {
        clickMenuIcon();
        clickPurchaseIcon();
        clickPurchaseBill();
        return getCurrentTabCount(TAB_PURCHASEBILL);
    }

    public int openPurchasesOrderTab() {
        clickMenuIcon();
        clickPurchaseIcon();
        clickPurchases();
        return getCurrentTabCount(TAB_PURCHASES);
    }

    public int getCurrentTabCount(String tab) {
        clickOn(driver, getTabName(tab));
        new SideMenuVerification(driver).verifyTabNameOpened(tab);
        return getActiveTabCount(driver);
    }

    public int getSpecificTabCount(String tab) {
        clickOn(driver, getTabName(tab));
        return getActiveTabCount(driver);
    }

    public int openPurchaseReturns() {
        clickMenuIcon();
        clickReturns();
        clickOn(driver, getClk_PurchaseReturn());
        return getCurrentTabCount(TAB_PURCHASE_RETURN);
    }

    public int openPurchaseReturnOrders() {
        clickMenuIcon();
        clickReturns();
        clickOn(driver, getClk_PurchaseReturnBillOrders());
        return getCurrentTabCount(TAB_PURCHASE_RETURN_BILL_WISE);
    }

    public void clickReturns() {
        clickOn(driver, getClk_Returns());
    }

    public String getCurrentTabName() {
        return getTab_CurrentTabName().getText();
    }

    public WebElement getTabName(String tab) {
        return getTab_TabName(tab);
    }

    public boolean checkAlertMessage(String message) {
        try {
            getExplicitWait(driver, getTxt_AlertMessage(message), EXPLICIT_WAIT);
            clickOn(driver, getBtn_AlertClose());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getAlertMessage() {
        try {
            getExplicitWait(driver, getTxt_AlertMessage(), EXPLICIT_WAIT);
            String alert = getTxt_AlertMessage().getText();
            getCloseAlert();
            return alert;
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isAlertMessageVisible(String message) {
        try {
            getTxt_AlertMessage(message).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void getCloseAlert() {
        clickOn(driver, getBtn_AlertClose());
    }

    public int openConfigurationTab() {
        clickMenuIcon();
        clickAdministration();
        clickConfigurationTab();
        return getCurrentTabCount(TAB_CONFIGURATION);
    }

    public void clickConfigurationTab() {
        clickOn(driver, getClk_Configuration());
    }

    public void clickAdministration() {
        clickOn(driver, getClk_Administration());
    }

    public int openCreateInvoiceFromChallan() {
        clickMenuIcon();
        clickPurchaseIcon();
        clickOn(driver, getClk_InvoiceFromChallan());
        return getCurrentTabCount(TAB_INV_FROM_CHALLAN);
    }

    public void closeCurrentTab(int tabCount) {
        try {
            clickOn(driver, getBtn_TabClose(tabCount));
            clickOn(driver, getBtn_TabCloseOK(tabCount));
        } catch (Exception e) {
            getBrowserRefresh(driver);
        }
        pause();
    }

    public boolean getEnterPasswordOk(String password) {
        try {
            getExplicitWait(driver, getTxtbx_EnterPassword(), EXPLICIT_WAIT);
            type(getTxtbx_EnterPassword(), password);
            clickOn(driver, getBtn_PasswordOk());
        } catch (Exception ignored) {
        }
        return true;
    }

    public void getEnterPasswordCancel(String password) {
        getExplicitWait(driver, getTxtbx_EnterPassword(), EXPLICIT_WAIT);
        type(getTxtbx_EnterPassword(), password);
        clickOn(driver, getBtn_PasswordCancel());
    }

    public void getDeleteInvoiceAccept() {
        clickOn(driver, getBtn_DeleteOk());
    }

    public void setPasswordToDeleteInvoice(String password) {
        getEnterPasswordOk(password);
        getDeleteInvoiceAccept();
    }

    public void setPasswordToEditInvoice(String password) {
        getEnterPasswordOk(password);
    }

    public void clickReports() {
        clickOn(driver, getClk_Reports());
    }

    public int openCreditAmountTracking() {
        clickMenuIcon();
        clickReports();
        clickOn(driver, getClk_Reports());
        clickOn(driver, getClk_PurchaseReports());
        clickOn(driver, getClk_CreditAmountTracking());
        return getCurrentTabCount(TAB_CREDIT_AMOUT_TRACKING);
    }

    public int openBatchStock() {
        clickMenuIcon();
        clickReports();
        clickOn(driver, getClk_Reports());
        clickOn(driver, getClk_StockReports());
        clickOn(driver, getClk_BatchStock());
        return getCurrentTabCount(TAB_BATCH_STOCK);
    }

    public void clickSales() {
        clickOn(driver, getClk_Sales());
    }

    public int clickSalesBill() {
        clickMenuIcon();
        clickSales();
        clickOn(driver, getClk_SalesBill());
        return getCurrentTabCount(TAB_SALE);
    }

    public int openSalesOrder() {
        clickMenuIcon();
        clickSales();
        clickOn(driver, getClk_SalesOrder());
        return getCurrentTabCount(TAB_SALES_ORDER);
    }

    public int openSalesReturn() {
        clickMenuIcon();
        clickReturns();
        clickOn(driver, getClk_SalesReturn());
        return getCurrentTabCount(TAB_SALES_RETURN);
    }

    public int openPatients() {
        clickMenuIcon();
        clickMaster();
        clickOn(driver, getClk_Patients());
        return getCurrentTabCount(TAB_PATIENTS);
    }

    public int openDoctors() {
        clickMenuIcon();
        clickMaster();
        clickOn(driver, getClk_Doctors());
        return getCurrentTabCount(TAB_DOCTORS);
    }

    public void getAlertAdjustmentPopUp(String value) {
        try {
            getExplicitWait(driver, getTxt_Adjustment(), EXPLICIT_WAIT);
            typeSlow(driver, getTxtbx_Adjustment(), value);
            clickOn(driver, getBtn_AdjustmentOK());
        } catch (Exception ignored) {
        }
    }
}
