package JBWindows_Transactions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.COM.COM_TransactionDelete;
import JBWindows.FRM.FRM_Payment;
import JBWindows.SAL.SAL_DocumentHistory;
import JBWindows.SAL.SAL_DueDateEntry;
import JBWindows.SAL.SAL_PointOfSales;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class OrderHistoryPage_UnitTest extends BaseClass {

	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessgBox;
	SAL_DocumentHistory RefOrderHistoryPage;
	SAL_PointOfSales RefOrderScreen;
	SAL_DueDateEntry RefDueDateEntry;
	FRM_Payment RefPaymentWindow;
	COM_TransactionDelete RefTransactionDeletePopUp;

	public OrderHistoryPage_UnitTest() {
		super();
	}


	@BeforeClass
	public void fnBeforeClass() throws InterruptedException {
		RefLogin = new Login(driver);
		RefDashboard = new APP_Dashboard(driver);
		RefMenu = new APP_Menu(driver);
		RefMessgBox = new MessageBoxEffia(driver);
		RefOrderHistoryPage = new SAL_DocumentHistory();
		RefOrderScreen = new SAL_PointOfSales();
		RefDueDateEntry = new SAL_DueDateEntry();
		RefPaymentWindow = new FRM_Payment();
		RefTransactionDeletePopUp = new COM_TransactionDelete();
	}

	@BeforeMethod
	public void fn_Login_and_Open_Page() {

		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);		
		RefDashboard.clickMenuBtn();
		GenericMethods.fnwait(1);
		RefMenu.OpenPage("order history");
		GenericMethods.fnwait(1);
	}
	
	@Test
	public void fnVerifyOrderEdit() {
		GenericMethods.fnStartTestCase("Verify Order Edit feature from Order History page");

		RefOrderHistoryPage.verifyEditFeature("ORD/0LOCAL/1/41");
		GenericMethods.fnwait(2);
		RefMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);
		RefOrderScreen.addProductToCart(1,1);
		GenericMethods.fnwait(1);
		RefOrderScreen.clickSaveButton();
		GenericMethods.fnwait(1);
		RefDueDateEntry.clickSaveButton();
		
		String labelMessage = RefMessgBox.fnGetLabelMessage();
		if (labelMessage.contains("Saved successfully"))
		{
			fnWriteSteps("pass", "Order has been edited successfully");
		}
		else
		{
			fnWriteSteps("Fail", "Order has not been edited");
		}
		GenericMethods.fnwait(1);
		RefMessgBox.ClickOkButton();
		RefOrderScreen.clickDashboardButton();

		GenericMethods.fnEndTestCase();
	}

	@Test
	public void fnVerifyOrderToInvoiceConversion() {
		GenericMethods.fnStartTestCase("Verify Order to Invoice conversion");

		RefOrderHistoryPage.serachRecord("ORD/0LOCAL/1/41");
		RefOrderHistoryPage.clickConvertToInvoiceButton();
		GenericMethods.fnwait(3);
		RefMessgBox.ClickOkButton();
		GenericMethods.fnwait(2);
		
		String labelMessage = RefMessgBox.fnGetLabelMessage();
		if (labelMessage.contains("INV/")) {
			fnWriteSteps("pass", "Order has been converted to Invoice successfully");
		} else {
			fnWriteSteps("Fail", "Order has not been converted to Invoice");
		}			
		
		RefMessgBox.clickCancelButton();
		GenericMethods.fnwait(1);	
		RefPaymentWindow.clickCancelButton();
		GenericMethods.fnwait(1);	

		GenericMethods.fnEndTestCase();
	}
	
	@Test
	public void fnVerifyOrderCancelFromOrderHistory() {
		GenericMethods.fnStartTestCase("Verify Order cancel from Order History page");

		RefOrderHistoryPage.serachRecord("ORD/0LOCAL/1/27");
		GenericMethods.fnwait(5);
		RefOrderHistoryPage.clickCancelOrderButton();
		GenericMethods.fnwait(2);
		RefMessgBox.ClickOkButton();
		GenericMethods.fnwait(2);
		
		RefTransactionDeletePopUp.enterRemarks();	
		GenericMethods.fnwait(2);
		RefOrderHistoryPage.serachRecord("ORD/0LOCAL/1/27");
		GenericMethods.fnwait(5);
		RefOrderHistoryPage.verifyOrderCancellation();
		
		GenericMethods.fnEndTestCase();
	}

	@AfterMethod
	public void fn_Close_InvoiceScreen_And_Logout() {

		RefOrderHistoryPage.clickCloseButton();
		GenericMethods.fnwait(1);
		RefDashboard.logoutwithoutmenu();
		RefMessgBox.ExitApplication_Yes();
		GenericMethods.fnwait(1);
	}

	@AfterClass
	public void fnAfterClass() {

		GenericMethods.fnwait(2);
		RefLogin.ClickCloseButton();
	}

}
