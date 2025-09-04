package JBWindows_Masters;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.SAL.SR_Table;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class TablePage_UnitTest extends BaseClass {

	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	SR_Table refTable;
	MessageBoxEffia refMessageBoxEffia;

	public TablePage_UnitTest() {
		super();
	}

	@BeforeMethod
	public void fn_Login_and_Open_Page() throws InterruptedException {

		refLogin = new Login(driver);
		refDashboard = new APP_Dashboard(driver);
		refMenu = new APP_Menu(driver);
		refTable = new SR_Table();
		refMessageBoxEffia = new MessageBoxEffia(driver);

		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		refLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(10);
		refDashboard.activatePage();
		GenericMethods.fnwait(2);
		refDashboard.clickMenuBtn();
		GenericMethods.fnwait(2);
		refMenu.OpenPage("tables");
		GenericMethods.fnwait(1);
	}

	@Test
	public void fnVerifyFieldVisibility() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Table add entry are present or not ");

		refTable.verifyFieldVisibility();
		

		GenericMethods.fnEndTestCase();
	}

	@Test
	public void fnVerifyFieldEnableOrNot() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Table add entry are enable or not");

		refTable.verifyFieldEnableOrNot();

		GenericMethods.fnEndTestCase();
	}

	@Test
	public void fnTableCreation() {
		GenericMethods.fnStartTestCase("Verify Table creation");
		
		int startingRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Tables", 1, 4));
		
		int lastRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Tables", 1, 5));
		
		refTable.fnCreateTable(startingRowNumber, lastRowNumber);
		
		fnWriteSteps("Pass", "Table has been created till : " +(lastRowNumber+1));

		
		GenericMethods.fnEndTestCase();
	}

	@Test
	public void fnTableSavedOrNot() throws IOException {
		GenericMethods.fnStartTestCase("Verify Table has been saved or not");
		int startingRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Tables", 1, 4));
		
		int lastRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Tables", 1, 5));

		refTable.fnverifyTableSavedOrNot(startingRowNumber,lastRowNumber);

		GenericMethods.fnEndTestCase();
	}

	@Test
	public void fnTableEdit() {
		GenericMethods.fnStartTestCase("Verify Table Edit");	
		
		int startingRowNumberToEdit = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Tables", 1,9));		
		int lastRowNumberToEdit = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Tables", 1,10));				
			
		for (int rowNumber = startingRowNumberToEdit; rowNumber <= lastRowNumberToEdit; rowNumber++)
		{
			String tableNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
					"Tables",1,11);	
			String editFieldOldValue = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
					"Tables",rowNumber,6);
			String editFieldName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
					"Tables",rowNumber,7);
			String editedValue = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
					"Tables",rowNumber,8);				
			refTable.verifyTableEdit(tableNo, editFieldOldValue, editFieldName, editedValue);
			GenericMethods.fnwait(1);
			refTable.clickCancelButton();
		}	

		GenericMethods.fnEndTestCase();
	}
	
	@Test
	public void fnVerifyTableDelete()  {
		GenericMethods.fnStartTestCase("Verify Table Delete");			
		
		int rowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Tables", 1, 5));	
		String strTableNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Tables",(rowNumber +1),1);
		
		refTable.fnCreateTable((rowNumber +1), (rowNumber +1));
		fnWriteSteps("Pass", +(rowNumber +2)+ "th row from input file the Table records has been created" );
		
		refTable.fnVerifyTableDelete(strTableNo);	
		GenericMethods.fnwait(1);
		refMessageBoxEffia.ClickOkButton();		
		GenericMethods.fnwait(35);		
		refTable.fnVerifyTableDeleteSuccessfulOrNot(strTableNo);
		
		GenericMethods.fnEndTestCase();
	}

	@AfterMethod
	public void fn_Close_InvoiceScreen_And_Logout() {

		refTable.clickCloseButton();
		GenericMethods.fnwait(2);
		refDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		refMessageBoxEffia.ExitApplication_Yes();
		GenericMethods.fnwait(5);
		refLogin.ClickCloseButton();
	}

}
