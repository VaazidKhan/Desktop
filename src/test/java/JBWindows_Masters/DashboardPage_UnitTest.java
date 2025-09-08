package JBWindows_Masters;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class DashboardPage_UnitTest extends BaseClass {
	Login RefLogin;
	APP_Dashboard RefDashboard;
	MessageBoxEffia RefMessageBox;
	
	public DashboardPage_UnitTest() {
		super();
	}

	@BeforeClass
	public void initializedriver() throws InterruptedException, IOException {
		RefLogin = new Login(driver);
		RefDashboard = new APP_Dashboard(driver);
		RefMessageBox = new MessageBoxEffia(driver);
	}

	@BeforeMethod
	public void fnBeforeMethod() {
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);
	}

	@Test
	public void fnVerifyButtonPresence() {
		GenericMethods.fnStartTestCase("Verification of page Button presence on Dashboard");
		
		RefDashboard.fnVerifyProductPageButtonPresence();
		RefDashboard.fnVerifyCustomersPageButtonPresence();
		RefDashboard.fnVerifyInventoryPageButtonPresence();
		RefDashboard.fnVerifyExpensePageButtonPresence();
		RefDashboard.fnVerifyCreateBillButtonPresence();
		RefDashboard.fnVerifyCreateEstimationButtonPresence();
		RefDashboard.fnVerifyCreateOrderButtonPresence();
		RefDashboard.fnVerifySearchfieldPresence();
		RefDashboard.fnVerifySearchbuttonPresence();
		RefDashboard.fnVerifyFromDateFieldPresence();
		RefDashboard.fnVerifyToDateFieldPresence();
		RefDashboard.fnVerifyLogoutButtonPresence();
		RefDashboard.fnVerifyMinimizeButtonPresence();
		
		GenericMethods.fnEndTestCase();
	}

	@AfterMethod
	public void fnAM() {
		
		RefDashboard.logoutwithoutmenu();
		RefMessageBox.ExitApplication_Yes();
		GenericMethods.fnwait(5);
		RefLogin.ClickCloseButton();

	}


}
