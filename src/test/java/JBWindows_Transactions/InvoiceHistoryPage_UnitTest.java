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
import JBWindows.FRM.FRM_PaymentNotes;
import JBWindows.SAL.SAL_DocumentHistory;
import JBWindows.SAL.SAL_DueDateEntry;
import JBWindows.SAL.SAL_PointOfSales;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class InvoiceHistoryPage_UnitTest extends BaseClass {

	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessgBox;
	SAL_DocumentHistory RefInvoiceHistoryPage;
	SAL_PointOfSales RefInvoiceScreen;
	SAL_DueDateEntry RefDueDateEntry;
	FRM_Payment RefPaymentWindow;
	COM_TransactionDelete RefTransactionDeletePopUp;
	FRM_PaymentNotes RefPaymentDenominationWindow;
	SAL_DocumentHistory RefDocumentHistoryPage;

	public InvoiceHistoryPage_UnitTest() {
		super();
	}


	@BeforeClass
	public void fnBeforeClass() throws InterruptedException {

		RefLogin = new Login(driver);
		RefDashboard = new APP_Dashboard(driver);
		RefMenu = new APP_Menu(driver);
		RefMessgBox = new MessageBoxEffia(driver);
		RefInvoiceHistoryPage = new SAL_DocumentHistory();
		RefInvoiceScreen = new SAL_PointOfSales();
		RefDueDateEntry = new SAL_DueDateEntry();
		RefPaymentWindow = new FRM_Payment();
		RefTransactionDeletePopUp = new COM_TransactionDelete();
		RefPaymentDenominationWindow = new FRM_PaymentNotes();
		RefDocumentHistoryPage = new SAL_DocumentHistory();
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
		RefMenu.OpenPage("invoice history");
		GenericMethods.fnwait(1);
	}

	@Test
	public void fnVerifyInvoiceEdit() {
		GenericMethods.fnStartTestCase("Verify Invoice Edit feature from Invoice History page");

		RefInvoiceHistoryPage.clickDuePaidToggle();
		GenericMethods.fnwait(1);
		RefInvoiceHistoryPage.verifyEditFeature("INV/MAUTOM/1/48");
		GenericMethods.fnwait(2);
		RefMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);		

		RefInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);

		RefPaymentWindow.SelectPaymentMode("CASH");
		GenericMethods.fnwait(3);
		RefPaymentDenominationWindow.clickSaveButton();
		GenericMethods.fnwait(1);
		RefPaymentWindow.clickFinishButton();

		GenericMethods.fnwait(1);
		String labelMessage = RefMessgBox.fnGetLabelMessage();
		if (labelMessage.contains("Payment")) {
			fnWriteSteps("pass", "Invoice Edit from Invoice History page is successful");
		} else {
			fnWriteSteps("Fail", "Invoice Edit from Invoice History page is not successful");
		}

		GenericMethods.fnwait(1);
		RefMessgBox.clickOkButton();
		GenericMethods.fnwait(1);
		RefInvoiceScreen.clickDashboardButton();
		GenericMethods.fnwait(1);

		GenericMethods.fnEndTestCase();

	}

	@Test
	public void fnVerifyDueInvoicePayment() {
		GenericMethods.fnStartTestCase("Verify payment of a Due Invoice from Invoice History page");				
		
		RefInvoiceHistoryPage.clickDuePaidToggle();
		GenericMethods.fnwait(1);
		RefInvoiceHistoryPage.serachRecord("INV/MAUTOM/1/47");
		GenericMethods.fnwait(2);
		RefInvoiceHistoryPage.clickPaymentButton();
		
		RefPaymentWindow.SelectPaymentMode("CASH");
		GenericMethods.fnwait(3);
		RefPaymentDenominationWindow.clickSaveButton();
		GenericMethods.fnwait(1);
		RefPaymentWindow.clickFinishButton();
		GenericMethods.fnwait(1);
		
		RefDocumentHistoryPage.clickFileCancelButton();
		GenericMethods.fnwait(1);
		
		String labelMessage = RefMessgBox.fnGetLabelMessage();
		if (labelMessage.contains("Payment")) {
			fnWriteSteps("pass", "Payment of a Due Invoice from Invoice History page is successful");
		} else {
			fnWriteSteps("Fail", "Payment of a Due Invoice from Invoice History page is not successful");
		}
		GenericMethods.fnwait(1);
		
		RefMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);
		
		GenericMethods.fnEndTestCase();

	}	
	
	@AfterMethod
	public void fn_Close_InvoiceScreen_And_Logout() {

		RefInvoiceHistoryPage.clickCloseButton();
		GenericMethods.fnwait(1);
		RefDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		RefMessgBox.ExitApplication_Yes();
	}

	@AfterClass
	public void fnAfterClass() {
		
		GenericMethods.fnwait(2);
		RefLogin.ClickCloseButton();
	}

}
