package JBWindows_Transactions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.INV.INV_MassInventoryEntry;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class InventoryAdjustment_UnitTest extends BaseClass {
	
	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;	
	MessageBoxEffia RefMessageBoxEffia;
	INV_MassInventoryEntry RefInventoryEntry;
	
	public InventoryAdjustment_UnitTest() {
		super();
	}


	@BeforeClass
	public void fnBeforeClass() throws InterruptedException {
		GenericMethods.fnwait(2);
		RefLogin = new Login(driver);
		RefDashboard = new APP_Dashboard(driver);
		RefMenu = new APP_Menu(driver);		
		RefMessageBoxEffia = new MessageBoxEffia(driver);
		RefInventoryEntry = new INV_MassInventoryEntry();
	}
	
	@BeforeMethod
	public void fn_Login_and_Open_Page(){
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(2);
		RefDashboard.activatePage();
		GenericMethods.fnwait(2);
		RefDashboard.clickMenuBtn();
		GenericMethods.fnwait(2);
		RefMenu.OpenPage("inventory adjustments");
		GenericMethods.fnwait(2);			
	}
	
	@Test	
	public void fnVerifyInventoryUpdate() {
		GenericMethods.fnStartTestCase("Verify Inventory Update");
		
		RefInventoryEntry.fnUpdateInventory(1);
		RefMessageBoxEffia.ClickOkButton();
		GenericMethods.fnwait(1);
			
		String successfulMessage = RefMessageBoxEffia.fnGetLabelMessage();
		if (successfulMessage.contains("Saved successfully"))
		{
			fnWriteSteps("Pass", "Inventory has been updated successfully");
		}else 
		{
			fnWriteSteps("Fail", "Inventory does not updated");
		}
		RefMessageBoxEffia.ClickOkButton();	
		GenericMethods.fnwait(1);
		
		GenericMethods.fnEndTestCase();
	}
	
	@AfterMethod
	public void fn_Close_InvoiceScreen_And_Logout() {

		RefInventoryEntry.clickCloseButton();
		RefDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		RefMessageBoxEffia.ExitApplication_Yes();
		GenericMethods.fnwait(1);
	}

	@AfterClass
	public void fnAfterClass_Close_Application() {
		
		GenericMethods.fnwait(2);
		RefLogin.ClickCloseButton();
	}

}
