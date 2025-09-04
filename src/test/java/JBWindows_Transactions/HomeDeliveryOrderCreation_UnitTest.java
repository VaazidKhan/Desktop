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
import JBWindows.SAL.SAL_CollectDeliveryOrders;
import JBWindows.SAL.SAL_Delivery;
import JBWindows.SAL.SAL_DeliveryAddress;
import JBWindows.SAL.SAL_DocumentHistory;
import JBWindows.SAL.SAL_DueDateEntry;
import JBWindows.SAL.SAL_InvoiceRecall;
import JBWindows.SAL.SAL_InvoiceTaxAndDiscount;
import JBWindows.SAL.SAL_PointOfSales;
import JBWindows.SAL.SAL_SalesPersonDetails;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class HomeDeliveryOrderCreation_UnitTest extends BaseClass {

	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessgBox;
	SAL_PointOfSales RefOrderScreen;
	CRM_CustomerPopup RefCustomerPopup;
	APP_AppSettings RefAppSettings;
	SAL_DocumentHistory RefOrderHistory;
	CRM_CustomerMaster RefCustomerMaster;
	SAL_InvoiceRecall RefRecallPage;
	SAL_InvoiceTaxAndDiscount RefInvoiceTaxAndDiscount;
	SAL_DueDateEntry RefDueDateEntry;
	SAL_DeliveryAddress RefDeliveryAddressWindow;
	COM_TransactionDelete RefTransactionDeletePopUp;
	SAL_Delivery RefDeliveryWindow;
	SAL_SalesPersonDetails RefSalesPersonSelectionWindow;
	FRM_Payment RefPaymentWindow;
	FRM_PaymentNotes RefPaymentDenominationWindow;
	SAL_CollectDeliveryOrders RefCollectDeliveryOrders;

	public HomeDeliveryOrderCreation_UnitTest() {
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
		RefOrderHistory = new SAL_DocumentHistory();
		RefCustomerMaster = new CRM_CustomerMaster();
		RefRecallPage = new SAL_InvoiceRecall();
		RefInvoiceTaxAndDiscount = new SAL_InvoiceTaxAndDiscount();
		RefDueDateEntry = new SAL_DueDateEntry();
		RefDeliveryAddressWindow = new SAL_DeliveryAddress();
		RefTransactionDeletePopUp = new COM_TransactionDelete();
		RefDeliveryWindow = new SAL_Delivery();
		RefSalesPersonSelectionWindow = new SAL_SalesPersonDetails();
		RefPaymentWindow = new FRM_Payment();
		RefPaymentDenominationWindow = new FRM_PaymentNotes();
		RefCollectDeliveryOrders = new SAL_CollectDeliveryOrders();
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
	
	@Test(priority = 1,enabled = true)
	public void fnSetSalesOrderAsHomeDelivery() {
		RefOrderScreen.clickDashboardButton();
		GenericMethods.fnwait(2);

		RefDashboard.clickMenuBtn();
		RefMenu.OpenPage("application settings");
		GenericMethods.fnwait(4);
		RefAppSettings.salesOrderTypechange("Home Delivery");
		GenericMethods.fnwait(1);
		RefMessgBox.clickOkButton();
		GenericMethods.fnwait(1);	
		RefDashboard.clickMenuBtn();
		GenericMethods.fnwait(2);
		RefMenu.OpenPage("order");
		GenericMethods.fnwait(2);
	}

	@Test
	public void fnVerifyHomeDeliveryOrderCreation() {
		GenericMethods.fnStartTestCase("Verify Home Delivery Order and new Customer creation");	

		RefOrderScreen.VerifyRuntimeCustmerAndTransactionCreation(22, 1, 1);
		RefDueDateEntry.clickSaveButton();
		RefDeliveryAddressWindow.clickSaveButton();

		String labelMessage = RefMessgBox.fnGetLabelMessage();
		if (labelMessage.contains("ORD/")) {
			fnWriteSteps("pass", "Order has been created successfully");
		} else {
			fnWriteSteps("Fail", "Order has not been created");
		}

		RefMessgBox.clickOkButton();	

		GenericMethods.fnEndTestCase();
	}
	
	@Test
	public void fnVerifyOrderCancellation() {		
		GenericMethods.fnStartTestCase("Verify Order Cancellation from Order creation screen");
		
		RefOrderScreen.VerifyRuntimeCustmerAndTransactionCreation(23,1,1);
		GenericMethods.fnwait(1);
		RefDueDateEntry.clickSaveButton();
		GenericMethods.fnwait(1);
		RefDeliveryAddressWindow.clickSaveButton();
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

	/*HAve to separate Tax & Discount
	 * @Test(priority = 3, enabled = false)
	public void fnSetDiscountAndTaxRuntime() {
		GenericMethods.fnStartTestCase("Set Invoice level Discount and Tax at runtime");
		
		RefOrderScreen.addProductToCart(1, 1);
		RefOrderScreen.clickTaxDiscountButton();
		RefInvoiceTaxAndDiscount.setTaxAndDiscount(1);
		RefOrderScreen.clickSaveButton();
		RefDueDateEntry.clickSaveButton();
		RefDeliveryAddressWindow.clickSaveButton();
		RefMessgBox.clickOkButton();

		GenericMethods.fnEndTestCase();
	}*/

	@Test
	public void fnVerifyOrderRecall() {
		GenericMethods.fnStartTestCase("Verify Order Recall feature");
		
		RefOrderScreen.verifyTransactionRecordCreation(25, 1, 1);
		GenericMethods.fnwait(1);
		RefDueDateEntry.clickSaveButton();
		GenericMethods.fnwait(1);
		RefDeliveryAddressWindow.clickSaveButton();

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
		RefDeliveryAddressWindow.clickSaveButton();

		String labelMessage = RefMessgBox.fnGetLabelMessage();
		if (labelMessage.contains("Saved successfully")) {
			fnWriteSteps("pass", "Recalled Order has been saved successfully");
		} else {
			fnWriteSteps("Fail", "Recalled Order has not been saved");
		}

		GenericMethods.fnwait(1);
		RefMessgBox.clickOkButton();

		GenericMethods.fnEndTestCase();
	}

	@Test
	public void fnVerifyOrderSavedOrNot() {
		GenericMethods.fnStartTestCase("Verify Home Delivery Order has been successfully saved or not");
		
		RefOrderScreen.verifyTransactionRecordCreation(26, 1, 1);
		RefDueDateEntry.clickSaveButton();
		GenericMethods.fnwait(2);
		RefDeliveryAddressWindow.clickSaveButton();

		String orderNo = RefMessgBox.fnGetOrderNo();
		RefMessgBox.clickOkButton();
		RefOrderScreen.clickDashboardButton();
		GenericMethods.fnwait(2);

		RefDashboard.clickMenuBtn();
		RefMenu.OpenPage("order history");
		GenericMethods.fnwait(1);
		RefOrderHistory.serachRecord(orderNo);
		RefOrderHistory.verifyOrderOrEstimationIsSavedOrNot();
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
		RefCustomerMaster.VerifyRuntimeCustomerSavedOrNot(26);
		RefCustomerMaster.clickCloseButton();
		GenericMethods.fnwait(1);
		
		RefDashboard.clickMenuBtn();
		GenericMethods.fnwait(2);
		RefMenu.OpenPage("order");
		GenericMethods.fnwait(2);

		GenericMethods.fnEndTestCase();
	}
	
	@Test
	public void fnVerifyOrderDispatchProcessFromOrderScreen() {
		GenericMethods.fnStartTestCase("Verify dispatch process for Delivery order from Order Screen");
		
		RefOrderScreen.verifyTransactionRecordCreation(92, 1, 1);
		GenericMethods.fnwait(1);
		RefDueDateEntry.clickSaveButton();
		GenericMethods.fnwait(1);
		RefDeliveryAddressWindow.clickSaveButton();

		String orderNo = RefMessgBox.fnGetOrderNo();
		RefMessgBox.clickOkButton();
		GenericMethods.fnwait(1);
		
		RefOrderScreen.clickDeliveryButton();
		GenericMethods.fnwait(1);
		
		RefDeliveryWindow.searchAndSelectSingleRecordForDispatch(orderNo);
		RefSalesPersonSelectionWindow.selectAgent(1);
		GenericMethods.fnwait(2); 
		RefDeliveryWindow.clickCloseButton();
		
		GenericMethods.fnEndTestCase();
		
	}
	
	@Test
	public void fnVerifyCollectPaymentProcess() {
		GenericMethods.fnStartTestCase("Verify collect payment process for dispatched Delivery order from Order Screen");		
		
		RefOrderScreen.clickDeliveryButton();
		GenericMethods.fnwait(1);
		
		RefDeliveryWindow.clickCollectDeliveryButton();
		RefCollectDeliveryOrders.selectFirstPaymentIcon();
		GenericMethods.fnwait(1);	
		
		String Amount = RefPaymentWindow.getReceivableAmount();
		if (Amount.equals("0.00")) {
			
			RefPaymentWindow.SelectPaymentMode("CASH");
			RefMessgBox.ClickOkButton();
			GenericMethods.fnwait(1);
			RefPaymentWindow.clickFinishButton();
			String labelMessage = RefMessgBox.fnGetLabelMessage();
			if (labelMessage.contains("INV/")) {
				fnWriteSteps("pass", "Payment of Delivered order has been completed successfully");
			} else {
				fnWriteSteps("Fail", "Payment of Delivered order has not been completed");
			}

			RefMessgBox.ClickOkButton();
			GenericMethods.fnwait(1);
			RefMessgBox.ClickOkButton();
		} else 
		{
			RefPaymentWindow.SelectPaymentMode("CASH");
			RefPaymentDenominationWindow.clickSaveButton();
			GenericMethods.fnwait(1);
			RefPaymentWindow.clickFinishButton();
			GenericMethods.fnwait(1);
			String labelMessagetwo = RefMessgBox.fnGetLabelMessage();
			if (labelMessagetwo.contains("Payment")) {
				fnWriteSteps("pass", "Payment of Delivered order has been completed successfully with Cash payment mode");
			} else {
				fnWriteSteps("Fail", "Payment of Delivered order has not been completed");
			}
			
			GenericMethods.fnwait(1);
			RefMessgBox.ClickOkButton();
			GenericMethods.fnwait(1);
			RefMessgBox.ClickOkButton();
		}
		GenericMethods.fnwait(1);
		RefCollectDeliveryOrders.clickCloseButton();
		GenericMethods.fnwait(1);
		RefDeliveryWindow.clickCloseButton();
		
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

		GenericMethods.fnwait(1);		
		RefLogin.ClickCloseButton();
	}

}
