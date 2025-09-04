package JBWindows_Transactions;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_AppSettings;
import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.CRM.CRM_CustomerMaster;
import JBWindows.CRM.CRM_CustomerPopup;
import JBWindows.SAL.SAL_DocumentHistory;
import JBWindows.SAL.SAL_InvoiceRecall;
import JBWindows.SAL.SAL_InvoiceTaxAndDiscount;
import JBWindows.SAL.SAL_PointOfSales;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class TakeAwayEstimationCreation_UnitTest extends BaseClass {

	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;	
	MessageBoxEffia RefMessgBox;
	SAL_PointOfSales RefEstimationScreen;
	CRM_CustomerPopup RefCustomerPopup;
	APP_AppSettings RefAppSettings;
	CRM_CustomerMaster RefCustomerMaster;
	SAL_DocumentHistory RefEstimationHistory;
	SAL_InvoiceRecall RefRecallPage;
	SAL_InvoiceTaxAndDiscount RefInvoiceTaxAndDiscount;
	

	public TakeAwayEstimationCreation_UnitTest() {
		super();
	}

	
	@BeforeClass
	public void fnBeforeClass() throws InterruptedException {
				
		RefLogin = new Login(driver);
		RefDashboard = new APP_Dashboard(driver);
		RefMenu = new APP_Menu(driver);		
		RefMessgBox = new MessageBoxEffia(driver);
		RefEstimationScreen = new SAL_PointOfSales();
		RefCustomerPopup = new CRM_CustomerPopup();		
		RefAppSettings = new APP_AppSettings();
		RefCustomerMaster = new CRM_CustomerMaster();
		RefEstimationHistory = new SAL_DocumentHistory();
		RefRecallPage = new SAL_InvoiceRecall();
		RefInvoiceTaxAndDiscount = new SAL_InvoiceTaxAndDiscount();
	}
	
	@BeforeMethod
	public void fn_Login_and_Open_Page() {
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(3);
		RefDashboard.activatePage();
		GenericMethods.fnwait(2);
		RefDashboard.clickMenuBtn();
		GenericMethods.fnwait(2);
		RefMenu.OpenPage("estimation");
		GenericMethods.fnwait(2);
	}	
	
	@Test
	public void fnSetSalesOrderAsTakeAway() {
		
		RefEstimationScreen.clickDashboardButton();
		GenericMethods.fnwait(2);
		
		RefDashboard.clickMenuBtn();
		GenericMethods.fnwait(4);
		RefMenu.activatePage();
		RefMenu.OpenPage("application settings");
		GenericMethods.fnwait(3);
		RefAppSettings.salesOrderTypechange("Take Away");
		GenericMethods.fnwait(1);
		RefMessgBox.clickOkButton();
		GenericMethods.fnwait(1);			
		RefDashboard.clickMenuBtn();
		GenericMethods.fnwait(2);
		RefMenu.OpenPage("estimation");
		GenericMethods.fnwait(2);
	}
	
	@Test
	public void fnVerifyRuntimeCustmerAndEstimationCreation() {
		GenericMethods.fnStartTestCase("Verify Runtime Custmer and Estimation creation");				
		
		RefEstimationScreen.VerifyRuntimeCustmerAndTransactionCreation(81,1,1);		
		String labelMessage = RefMessgBox.fnGetLabelMessage();		
		if (labelMessage.contains("EST/"))
		{
			fnWriteSteps("pass", "Estimation has been created successfully");
		}
		else
		{
			fnWriteSteps("Fail", "Estimation has not been created");
		}
	
		RefMessgBox.clickOkButton();		
		GenericMethods.fnwait(1);
		
		GenericMethods.fnEndTestCase(); 
	}
	
	/* HAve to separate Tax & Discount
	 * @Test(priority = 2, enabled = true)
	public void fnSetDiscountAndTaxRuntime() {		
		GenericMethods.fnStartTestCase("Set Invoice level Discount and Tax at runtime");
		
		RefEstimationScreen.addProductToCart(1,1);
		RefEstimationScreen.clickTaxDiscountButton();
		RefInvoiceTaxAndDiscount.setTaxAndDiscount(1);
		RefEstimationScreen.clickSaveButton();
		RefMessgBox.clickOkButton();
		GenericMethods.fnwait(1);
		
		GenericMethods.fnEndTestCase(); 
	}*/
	
	@Test
	public void fnVerifyEstimationRecall() {
		GenericMethods.fnStartTestCase("Verify Estimation Recall feature");		
		
		RefEstimationScreen.verifyTransactionRecordCreation(83,1,1);	
		String EstmationNo = RefMessgBox.fnGetEstimationNo();
		RefMessgBox.clickOkButton();
		RefEstimationScreen.clickRecallButton();		
		RefRecallPage.searchRecord(EstmationNo);
		RefRecallPage.clickOkButton();
		RefEstimationScreen.clickSaveButton();
		String labelMessage = RefMessgBox.fnGetLabelMessage();		
		if (labelMessage.contains("Saved successfully"))
		{
			fnWriteSteps("pass", "Recalled Estimation has been saved successfully");
		}
		else
		{
			fnWriteSteps("Fail", "Recalled Estimation has not been saved");
		}
		
		RefMessgBox.clickOkButton();
		GenericMethods.fnwait(1);
		
		GenericMethods.fnEndTestCase();
	}
	
	@Test
	public void fnVerifyEstimationSavedOrNot() {
		GenericMethods.fnStartTestCase("Verify Take Away Estimation has been successfully saved or not");			
		
		RefEstimationScreen.verifyTransactionRecordCreation(84,1,1);			
		GenericMethods.fnwait(2);
		String EstmationNo = RefMessgBox.fnGetEstimationNo();
		RefMessgBox.clickOkButton();
		RefEstimationScreen.clickDashboardButton();
		GenericMethods.fnwait(2);
		RefDashboard.clickMenuBtn();
		RefMenu.OpenPage("estimation history");
		GenericMethods.fnwait(1);
		RefEstimationHistory.serachRecord(EstmationNo);
		RefEstimationHistory.verifyOrderOrEstimationIsSavedOrNot();
		RefEstimationHistory.clickCloseButton();	

		RefDashboard.clickMenuBtn();
		GenericMethods.fnwait(1);		
		RefMenu.OpenPage("estimation");
		GenericMethods.fnwait(2);

		GenericMethods.fnEndTestCase();

	}		
	
	
	@Test
	public void fnVerifyCustomerSavedOrNot() throws IOException {
		GenericMethods.fnStartTestCase("Verify runtime created customer has been successfully saved or not");
		
		RefEstimationScreen.clickDashboardButton();
		GenericMethods.fnwait(2);
		
		RefDashboard.clickMenuBtn();
		RefMenu.OpenPage("customers");		
		RefCustomerMaster.VerifyRuntimeCustomerSavedOrNot(84);
		RefCustomerMaster.clickCloseButton();
		GenericMethods.fnwait(1);
		RefMenu.OpenPage("estimation");
		GenericMethods.fnwait(2);
		
		GenericMethods.fnEndTestCase();
	}		
	
	@Test
	public void fnVerifySelectSalesOrderTypeOnRunTime() throws IOException {
		GenericMethods.fnStartTestCase("Verify to change Sales Order Type on run time");
		
		String rowNumber_SOType = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.MasterInputExcelPath, "Transaction_Invoice", "Execution", "Yes",
				"rowNumber_SOType");
		
		RefEstimationScreen.fnSelectSalesOrderType(Integer.parseInt(rowNumber_SOType));
	
		GenericMethods.fnEndTestCase();
	}		
	
	@AfterMethod
	public void fn_Close_EstimationScreen_And_Logout() {

		RefEstimationScreen.clickDashboardButton();
		GenericMethods.fnwait(2);
		RefDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		RefMessgBox.ExitApplication_Yes();
		GenericMethods.fnwait(1);
	}	
	
	@AfterClass
	public void fnAfterClass() {					
		
		GenericMethods.fnwait(1);				
		RefLogin.ClickCloseButton();
	}
	

}
