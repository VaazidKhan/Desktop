package JBWindows_Transactions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
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

public class EstimationHistoryPage_UnitTest extends BaseClass {

	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessgBox;
	SAL_DocumentHistory RefEstimationHistoryPage;
	SAL_PointOfSales RefEstimationScreen;
	SAL_DueDateEntry RefDueDateEntry;
	FRM_Payment RefPaymentWindow;

	public EstimationHistoryPage_UnitTest() {
		super();
	}

	@BeforeClass
	public void fnBeforeClass() throws InterruptedException {

		RefLogin = new Login(driver);
		RefDashboard = new APP_Dashboard(driver);
		RefMenu = new APP_Menu(driver);
		RefMessgBox = new MessageBoxEffia(driver);
		RefEstimationHistoryPage = new SAL_DocumentHistory();
		RefEstimationScreen = new SAL_PointOfSales();
		RefDueDateEntry = new SAL_DueDateEntry();
		RefPaymentWindow = new FRM_Payment();
	}

	@BeforeMethod
	public void fn_Login_and_Open_Page() {

		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);
		RefDashboard.activatePage();
		RefDashboard.clickMenuBtn();
		RefMenu.OpenPage("estimation history");
		GenericMethods.fnwait(1);
	}

	@Test
	public void fnVerifyEstimationEdit() {
		GenericMethods.fnStartTestCase("Verify Estimation Edit feature from Estimation History page");

		RefEstimationHistoryPage.verifyEditFeature("EST/0LOCAL/1/6");
		RefMessgBox.ClickOkButton();
		RefEstimationScreen.addProductToCart(1,1);
		RefEstimationScreen.clickSaveButton();
		String labelMessage = RefMessgBox.fnGetLabelMessage();
		if (labelMessage.contains("Saved successfully"))
		{
			fnWriteSteps("pass", "Estimation has been edited successfully");
		}
		else
		{
			fnWriteSteps("Fail", "Estimation has not been edited");
		}
		
		RefMessgBox.ClickOkButton();
		RefEstimationScreen.clickDashboardButton();

		GenericMethods.fnEndTestCase();
	}

	@Test
	public void fnVerifyEstimationToOrderConversion() {
		GenericMethods.fnStartTestCase("Verify Estimation to Order conversion");

		RefEstimationHistoryPage.serachRecord("EST/0LOCAL/1/6");
		RefEstimationHistoryPage.clickConvertToOrderButton();
		RefMessgBox.ClickOkButton();
		RefDueDateEntry.clickSaveButton();
		GenericMethods.fnwait(1);
		RefEstimationHistoryPage.clickFileCancelButton();

		String labelMessage = RefMessgBox.fnGetLabelMessage();
		if (labelMessage.contains("ORD/")) {
			fnWriteSteps("pass", "Estimation has been converted to Order successfully");
		} else {
			fnWriteSteps("Fail", "Estimation has not been converted to Order");
		}

		RefMessgBox.clickCancelButton();
		GenericMethods.fnwait(1);	

		GenericMethods.fnEndTestCase();
	}
	
	@Test
	public void fnVerifyEstimationToInvoiceConversion() {
		GenericMethods.fnStartTestCase("Verify Estimation to Invoice conversion");

		RefEstimationHistoryPage.serachRecord("EST/0LOCAL/1/7");
		RefEstimationHistoryPage.clickConvertToInvoiceButton();
		RefMessgBox.ClickOkButton();
		RefDueDateEntry.clickSaveButton();
		GenericMethods.fnwait(1);
		RefEstimationHistoryPage.clickFileCancelButton();
			

		String labelMessage = RefMessgBox.fnGetLabelMessage();
		if (labelMessage.contains("INV/")) {
			fnWriteSteps("pass", "Estimation has been converted to Invoice successfully");
		} else {
			fnWriteSteps("Fail", "Estimation has not been converted to Invoice");
		}
		
		GenericMethods.fnwait(1);	
		RefMessgBox.clickCancelButton();
		GenericMethods.fnwait(1);	
		RefPaymentWindow.clickCancelButton();
		GenericMethods.fnwait(1);	

		GenericMethods.fnEndTestCase();
	}
	
	@AfterMethod
	public void fn_Close_InvoiceScreen_And_Logout() {

		RefEstimationHistoryPage.clickCloseButton();
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
