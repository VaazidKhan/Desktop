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
import JBWindows.COM.COM_TransactionDelete;
import JBWindows.CRM.CRM_CustomerMaster;
import JBWindows.CRM.CRM_CustomerPopup;
import JBWindows.FRM.FRM_Payment;
import JBWindows.FRM.FRM_PaymentNotes;
import JBWindows.SAL.SAL_DocumentHistory;
import JBWindows.SAL.SAL_DueDateEntry;
import JBWindows.SAL.SAL_InvoiceRecall;
import JBWindows.SAL.SAL_InvoiceTaxAndDiscount;
import JBWindows.SAL.SAL_PointOfSales;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class TakeAwayOrderCreation_UnitTest extends BaseClass {

	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;	
	MessageBoxEffia RefMessgBox;
	SAL_PointOfSales RefOrderScreen;
	CRM_CustomerPopup RefCustomerPopup;
	APP_AppSettings RefAppSettings;
	CRM_CustomerMaster RefCustomerMaster;
	SAL_DocumentHistory RefOrderHistory;
	SAL_InvoiceRecall RefRecallPage;
	SAL_InvoiceTaxAndDiscount RefInvoiceTaxAndDiscount;
	SAL_DueDateEntry RefDueDateEntry;	
	COM_TransactionDelete RefTransactionDeletePopUp;
	FRM_Payment RefPaymentWindow;
	FRM_PaymentNotes RefPaymentDenominationWindow;
	
	public TakeAwayOrderCreation_UnitTest() {
		super();
	}

	@BeforeClass
	public void fnBeforeClass() throws InterruptedException {
				
		RefLogin = new Login(driver);
		RefDashboard = new APP_Dashboard(driver);
		RefMenu = new APP_Menu(driver);		
		RefMessgBox = new MessageBoxEffia(driver);
		RefOrderScreen = new SAL_PointOfSales();
		RefCustomerPopup = new CRM_CustomerPopup();		
		RefAppSettings = new APP_AppSettings();
		RefCustomerMaster = new CRM_CustomerMaster();
		RefOrderHistory = new SAL_DocumentHistory();
		RefRecallPage = new SAL_InvoiceRecall();
		RefInvoiceTaxAndDiscount = new SAL_InvoiceTaxAndDiscount();
		RefDueDateEntry = new SAL_DueDateEntry();
		RefTransactionDeletePopUp = new COM_TransactionDelete();
		RefPaymentWindow = new FRM_Payment();
		RefPaymentDenominationWindow = new FRM_PaymentNotes();
		
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
		RefMenu.OpenPage("order");
		GenericMethods.fnwait(2);
	}		
	
	@Test
	public void fnSetSalesOrderAsTakeAway() {
		
		RefOrderScreen.clickDashboardButton();
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
		RefMenu.OpenPage("order");
		GenericMethods.fnwait(2);
	}
	
	@Test
	public void fnVerifyRuntimeCustmerAndOrderCreation() {
		GenericMethods.fnStartTestCase("Verify Runtime Customer and Order creation");		
		
		RefOrderScreen.VerifyRuntimeCustmerAndTransactionCreation(85,1,1);	
		RefDueDateEntry.clickSaveButton();		
		GenericMethods.fnwait(1);
		
		String labelMessage = RefMessgBox.fnGetLabelMessage();		
		if (labelMessage.contains("ORD/"))
		{
			fnWriteSteps("pass", "Order has been created successfully");
		}
		else
		{
			fnWriteSteps("Fail", "Order has not been created");
		}
		
		RefMessgBox.clickOkButton();	
		
		GenericMethods.fnEndTestCase(); 
	}
	
	@Test
	public void fnVerifyOrderCancellation() {		
		GenericMethods.fnStartTestCase("Verify Order Cancellation from Order creation screen");
		
		RefOrderScreen.VerifyRuntimeCustmerAndTransactionCreation(86,1,1);
		GenericMethods.fnwait(1);
		RefDueDateEntry.clickSaveButton();
		GenericMethods.fnwait(1);
		
		String orderNo = RefMessgBox.fnGetOrderNo();		
		RefMessgBox.clickOkButton();	
		GenericMethods.fnwait(1);
	
		RefOrderScreen.clickRecallButton();		
		RefRecallPage.searchRecord(orderNo);
		GenericMethods.fnwait(1);
		RefRecallPage.clickOkButton();
		GenericMethods.fnwait(1);
		RefOrderScreen.clickCancelButton();
		GenericMethods.fnwait(1);
		RefTransactionDeletePopUp.enterRemarks();
		GenericMethods.fnwait(2);			
		
		GenericMethods.fnEndTestCase(); 
	}
	
	@Test
	public void fnVerifyOrderRecall() {
		GenericMethods.fnStartTestCase("Verify Order Recall feature");				
		
		RefOrderScreen.verifyTransactionRecordCreation(88,1,1);	
		GenericMethods.fnwait(1);
		RefDueDateEntry.clickSaveButton();
		GenericMethods.fnwait(1);
		
		String orderNo = RefMessgBox.fnGetOrderNo();		
		RefMessgBox.clickOkButton();	
		GenericMethods.fnwait(1);
	
		RefOrderScreen.clickRecallButton();		
		RefRecallPage.searchRecord(orderNo);
		GenericMethods.fnwait(1);
		RefRecallPage.clickOkButton();
		GenericMethods.fnwait(1);
		RefOrderScreen.clickSaveButton();
		GenericMethods.fnwait(1);
		RefDueDateEntry.clickSaveButton();
		
		String labelMessage = RefMessgBox.fnGetLabelMessage();		
		if (labelMessage.contains("Saved successfully"))
		{
			fnWriteSteps("pass", "Recalled Order has been saved successfully");
		}
		else
		{
			fnWriteSteps("Fail", "Recalled Order has not been saved");
		}
		
		GenericMethods.fnwait(1);
		RefMessgBox.clickOkButton();
		
		GenericMethods.fnEndTestCase();
	}
	
	@Test
	public void fnVerifyOrderToInvoiceConversion() {
		GenericMethods.fnStartTestCase("Verify Order to Invoice conversion from Order screen");			
		
		RefOrderScreen.verifyTransactionRecordCreation(89,1,1);	
		GenericMethods.fnwait(1);
		RefDueDateEntry.clickSaveButton();
		GenericMethods.fnwait(1);
		
		String orderNo = RefMessgBox.fnGetOrderNo();		
		RefMessgBox.clickOkButton();	
		GenericMethods.fnwait(1);
	
		RefOrderScreen.clickRecallButton();		
		RefRecallPage.searchRecord(orderNo);
		GenericMethods.fnwait(1);
		RefRecallPage.clickOkButton();
		GenericMethods.fnwait(1);
		
		RefOrderScreen.clickConvertButton();
		GenericMethods.fnwait(1);
		RefMessgBox.clickOkButton();
		GenericMethods.fnwait(1);
		RefMessgBox.clickCancelButton();
		GenericMethods.fnwait(2);
		
		RefPaymentWindow.SelectPaymentMode("CASH");
		GenericMethods.fnwait(3);
		RefPaymentDenominationWindow.clickSaveButton();
		GenericMethods.fnwait(1);
		RefPaymentWindow.clickFinishButton();
		GenericMethods.fnwait(1);
		RefMessgBox.ClickOkButton();
		fnWriteSteps("pass", "Order has been converted to Invoice successfully");					
		GenericMethods.fnwait(1);
		
		GenericMethods.fnEndTestCase();
	}	
	
	@Test
	public void fnVerifyOrderSavedOrNot() {
		GenericMethods.fnStartTestCase("Verify Take Away Order has been successfully saved or not");			
		
		RefOrderScreen.verifyTransactionRecordCreation(90,1,1);		
		RefDueDateEntry.clickSaveButton();
		GenericMethods.fnwait(2);
		
		String orderNo = RefMessgBox.fnGetOrderNo();
		RefMessgBox.clickOkButton();
		RefOrderScreen.clickDashboardButton();
		GenericMethods.fnwait(2);
		
		RefDashboard.clickMenuBtn();
		RefMenu.OpenPage("order history");
		GenericMethods.fnwait(1);
		RefOrderHistory.serachRecord(orderNo);
		GenericMethods.fnwait(1);
		RefOrderHistory.verifyOrderOrEstimationIsSavedOrNot();
		GenericMethods.fnwait(1);
		RefOrderHistory.clickCloseButton();			
		
		RefDashboard.clickMenuBtn();
		GenericMethods.fnwait(2);
		RefMenu.OpenPage("order");
		GenericMethods.fnwait(2);
		
		GenericMethods.fnEndTestCase();
	}		
	
	@Test
	public void fnVerifyCustomerSavedOrNot() throws IOException {
		GenericMethods.fnStartTestCase("Verify runtime created customer has been successfully saved or not");
		
		RefOrderScreen.clickDashboardButton();
		GenericMethods.fnwait(2);
		
		RefDashboard.clickMenuBtn();
		RefMenu.OpenPage("customers");		
		GenericMethods.fnwait(2);
		RefCustomerMaster.VerifyRuntimeCustomerSavedOrNot(90);
		GenericMethods.fnwait(2);
		RefCustomerMaster.clickCloseButton();
		GenericMethods.fnwait(1);
		
		RefDashboard.clickMenuBtn();
		GenericMethods.fnwait(2);
		RefMenu.OpenPage("order");
		GenericMethods.fnwait(2);
		
		GenericMethods.fnEndTestCase();
	}		
	
	@AfterMethod
	public void fn_Close_EstimationScreen_And_Logout() {

		RefOrderScreen.clickDashboardButton();
		GenericMethods.fnwait(2);
		RefDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		RefMessgBox.ExitApplication_Yes();
		GenericMethods.fnwait(1);
	}	
	
	@AfterClass
	public void fnAfterClass() {		
		
		GenericMethods.fnwait(2);
		RefLogin.ClickCloseButton();
	}

}
