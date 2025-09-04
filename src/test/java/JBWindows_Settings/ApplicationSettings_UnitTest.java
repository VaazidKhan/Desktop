package JBWindows_Settings;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_AppSettings;
import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.CRM.CRM_CustomerFeedbackPopup;
import JBWindows.FRM.FRM_Payment;
import JBWindows.FRM.FRM_PaymentNotes;
import JBWindows.SAL.SAL_PointOfSales;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class ApplicationSettings_UnitTest extends BaseClass {

	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessgBox;
	APP_AppSettings RefAppSettings;
	SAL_PointOfSales RefInvoiceScreen;
	FRM_Payment RefPaymentWindow;
	FRM_PaymentNotes RefPaymentDenominationWindow;
	CRM_CustomerFeedbackPopup RefCustomerFeedbackPopup;
	
	public ApplicationSettings_UnitTest() {
		super();
	}


	@BeforeClass
	public void fnBeforeClass() throws InterruptedException {


		RefLogin = new Login(driver);
		RefDashboard = new APP_Dashboard(driver);
		RefMenu = new APP_Menu(driver);
		RefMessgBox = new MessageBoxEffia(driver);
		RefAppSettings = new APP_AppSettings();
		RefInvoiceScreen = new SAL_PointOfSales();
		RefPaymentWindow = new FRM_Payment();
		RefPaymentDenominationWindow = new FRM_PaymentNotes();
		RefCustomerFeedbackPopup = new CRM_CustomerFeedbackPopup();
}
	
	@BeforeMethod
	public void fn_Login_and_Open_Page() {

		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(10);

		RefDashboard.clickMenuBtn();
		GenericMethods.fnwait(1);
		RefMenu.OpenPage("application settings");
		GenericMethods.fnwait(1);
	}
	
	@Test(priority = 1, enabled = true)
	public void fnVerifyShowFeedbackAfterBillingFeature() {
		GenericMethods.fnStartTestCase("Verify show feedback after billing feature for Take Away invoice");
		
		RefAppSettings.enableShowFeedbackAfterBillingFeature();
		GenericMethods.fnwait(7);
		RefMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);
		RefDashboard.clickMenuBtn();
		RefMenu.OpenPage("application settings");
		GenericMethods.fnwait(1);
		RefAppSettings.salesOrderTypechange("Take Away");
		GenericMethods.fnwait(7);
		RefMessgBox.ClickOkButton();
		
		GenericMethods.fnwait(1);
		RefDashboard.ClickBillingPageButton();
		RefInvoiceScreen.addProductToCart(1,1);
		
		RefInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);

		RefPaymentWindow.SelectPaymentMode("CASH");
		GenericMethods.fnwait(3);
		RefPaymentDenominationWindow.clickSaveButton();
		GenericMethods.fnwait(1);
		RefPaymentWindow.clickFinishButton();
		GenericMethods.fnwait(1);
		RefMessgBox.ClickOkButton();
		
		RefCustomerFeedbackPopup.emoticonSelection("happy");
		GenericMethods.fnwait(1);
		RefCustomerFeedbackPopup.enterComments();
		fnWriteSteps("Pass", "Show feedback after billing feature is working fine");
		
		RefInvoiceScreen.clickDashboardButton();
		GenericMethods.fnwait(1);
		
		GenericMethods.fnEndTestCase();
	}

	@AfterClass
	public void fnAfterClass() {
		
		RefDashboard.logoutwithoutmenu();
		RefMessgBox.ExitApplication_Yes();
		GenericMethods.fnwait(2);
		RefLogin.ClickCloseButton();
	}

}
