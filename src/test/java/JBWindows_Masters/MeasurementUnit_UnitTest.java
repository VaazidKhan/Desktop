package JBWindows_Masters;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.INV.INV_MeasurementUnit;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class MeasurementUnit_UnitTest extends BaseClass {

	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	MessageBoxEffia refMessageBoxEffia;
	INV_MeasurementUnit refMeasurementUnit;

	public MeasurementUnit_UnitTest() {
		super();
	}


	@BeforeMethod
	public void fnBeforeMethod() throws InterruptedException {
		refLogin = new Login(driver);
		refDashboard = new APP_Dashboard(driver);
		refMenu = new APP_Menu(driver);
		refMeasurementUnit = new INV_MeasurementUnit();
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
		refMenu.OpenPage("Units");
		GenericMethods.fnwait(1);

	}

	@Test
	public void fnVerifyFieldVisibility() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Measurement Unit add entry are present or not ");

		refMeasurementUnit.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refMeasurementUnit.verifyFieldVisibility();

		GenericMethods.fnEndTestCase();
	}

	@Test
	public void fnVerifyFieldEnableOrNot() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Measurement Unit add entry are enable or not");

		refMeasurementUnit.clickCreateNewButton();
		refMeasurementUnit.verifyFieldEnableOrNot();
		GenericMethods.fnwait(1);

		GenericMethods.fnEndTestCase();
	}

	@Test
	public void fnMeasurementUnitCreation() {
		GenericMethods.fnStartTestCase("Verify Measurement Unit creation");

		int startingRowNumber = Integer
				.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Unit", 1, 3));

		int lastRowNumber = Integer
				.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Unit", 1, 4));

		refMeasurementUnit.clickCreateNewButton();
		refMeasurementUnit.createNewMeasurementUnit(startingRowNumber, lastRowNumber);
		
		fnWriteSteps("Pass", "Measurement Unit has been created till : " +(lastRowNumber+1));

		GenericMethods.fnEndTestCase();
	}

	@Test
	public void fnMeasurementUnitSavedOrNot() throws IOException {
		GenericMethods.fnStartTestCase("Verify Measurement Unit saved or not");

		int startingRowNumber = Integer
				.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Unit", 1, 3));

		int lastRowNumber = Integer
				.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Unit", 1, 4));

		refMeasurementUnit.verifyMeasurementUnitSavedOrNot(startingRowNumber,
				lastRowNumber);

		GenericMethods.fnEndTestCase();
	}

	@Test
	public void fnMeasurementUnitEdit() throws IOException {
		GenericMethods.fnStartTestCase("Verify Measurement Unit Edit");

		String editFieldOldValue = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Unit", 1, 5);;
		String editFieldName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Unit", 1, 6);
		String editedValue = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Unit", 1, 7);

		refMeasurementUnit.verifyMeasurementUnitEdit(editFieldOldValue, editFieldName, editedValue);

		GenericMethods.fnEndTestCase();
	}
	
	@Test
	public void fnVerifyMeasurementUnitDelete() {
		GenericMethods.fnStartTestCase("Verify Measurement Unit Delete");			
		
		int rowNumber = Integer
				.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Unit", 1, 4));
		String strUnitName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Unit",(rowNumber +1),0);
		
		refMeasurementUnit.clickCreateNewButton();
		refMeasurementUnit.createNewMeasurementUnit((rowNumber +1), (rowNumber +1));
		fnWriteSteps("Pass", +(rowNumber +2)+ "th row from input file the Measurement Unit records has been created" );
		
		refMeasurementUnit.fnVerifyMeasurementUnitDelete(strUnitName);	
		GenericMethods.fnwait(1);
		refMessageBoxEffia.ClickOkButton();
		GenericMethods.fnwait(35);	
		refMeasurementUnit.fnVerifyMeasurementUnitDeleteSuccessfulOrNot(strUnitName);
		
		GenericMethods.fnEndTestCase();
	}	

	@AfterMethod
	public void fnAfterMethod() {

		refMeasurementUnit.clickCloseButton();
		GenericMethods.fnwait(2);
		refDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		refMessageBoxEffia.ExitApplication_Yes();
		GenericMethods.fnwait(5);
		refLogin.ClickCloseButton();
	}


}