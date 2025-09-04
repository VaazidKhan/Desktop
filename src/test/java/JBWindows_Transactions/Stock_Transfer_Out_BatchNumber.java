package JBWindows_Transactions;

import org.apache.log4j.xml.DOMConfigurator;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.FRM.FRM_OperatingExpenses;
import JBWindows.SAL.SAL_DocumentHistory;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows.Transactions.Stock_Transfer_Out_Page;
import JBWindows.Transactions.Trans_Order_Page;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class Stock_Transfer_Out_BatchNumber extends BaseClass{
	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;	
	MessageBoxEffia RefMessageBoxEffia;
	Stock_Transfer_Out_Page RefStockTransfer;
	Trans_Order_Page refOrderPage;
	SAL_DocumentHistory RefEstimationHistory;
	FRM_OperatingExpenses RefExpensePage;
	
	public Stock_Transfer_Out_BatchNumber() {
		super();
	}


	@BeforeClass
	public void fnBeforeClass() throws InterruptedException {
		DOMConfigurator.configure("log4j.xml");
		GenericMethods.fnwait(2);
		RefLogin = new Login(driver);
		RefDashboard = new APP_Dashboard(driver);
		RefMenu = new APP_Menu(driver);		
		RefMessageBoxEffia = new MessageBoxEffia(driver);
		RefStockTransfer = new Stock_Transfer_Out_Page();
		refOrderPage = new Trans_Order_Page();
		RefEstimationHistory = new SAL_DocumentHistory();
		RefExpensePage = new FRM_OperatingExpenses();
	}
	
	@BeforeMethod
	public void fn_Login_and_Open_Page() throws FindFailed{
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(2);
		GenericMethods.fnwait(35);
		RefDashboard.clickMenuBtn();
		GenericMethods.fnwait(2);
	           
		       Screen screen=new Screen();
			   Pattern pattern;
			   pattern=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Arrow Down.PNG");
			   screen.click(pattern);
			   GenericMethods.fnwait(1);
			   screen.click(pattern);
			   GenericMethods.fnwait(1);
			   screen.click(pattern);
			   GenericMethods.fnwait(2);
			   screen.click(pattern);
			   GenericMethods.fnwait(2);
			   screen.click(pattern);
			   GenericMethods.fnwait(2);
			   screen.click(pattern);
			   pattern=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\StockTransfer.PNG");
			   screen.click(pattern);
			   GenericMethods.fnwait(2);
    }
	@AfterMethod
	public void fn_Close_InvoiceScreen_And_Logout() {

		RefStockTransfer.clickCloseButton();
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
