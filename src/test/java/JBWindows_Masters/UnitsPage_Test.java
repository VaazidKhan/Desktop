package JBWindows_Masters;
import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows.UMX.UMX_UnitsView;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class UnitsPage_Test extends BaseClass {

	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	MessageBoxEffia refMessageBoxEffia;
	UMX_UnitsView refUnits;

	public UnitsPage_Test() {
		super();
	}


	@BeforeMethod
	public void fnLogin() throws InterruptedException {
		GenericMethods.fnStartTestCase("fn Login and Open Page");
		DOMConfigurator.configure("log4j.xml");
		refLogin = new Login(driver);
		refDashboard = new APP_Dashboard(driver);
		refMenu = new APP_Menu(driver);
		refMessageBoxEffia = new MessageBoxEffia(driver);
		refUnits = new UMX_UnitsView();

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
		refMenu.OpenPage("units");
		GenericMethods.fnwait(2);

	}

	@Test 
	public void fnVerifyFieldVisibility() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Units add entry are present or not");

		refUnits.verifyFieldVisibility();

		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void fnVerifyFieldEnableOrNot() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Units add entry are enable or not");

		refUnits.VerifyFieldEnableOrNot();

		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnActive_UnitsCreation() {
		GenericMethods.fnStartTestCase("Verify Active Units creation");
		
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Unit";
	    int RowNumber = 1;
	    String UnitName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String UnitCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String BaseUnit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    refUnits.Create_NewUnits(UnitName,UnitCode,BaseUnit,Inactive);
	    boolean result = refUnits.Verify_NewUnitsFeature_SaveorNot(UnitName);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "The Active Units has been created & Saved");
          GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnInActive_UnitsCreation() {
		GenericMethods.fnStartTestCase("Verify InActive Units creation");
		
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Unit";
	    int RowNumber = 2;
	    String UnitName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String UnitCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String BaseUnit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    refUnits.Create_NewUnits(UnitName,UnitCode,BaseUnit,Inactive);
	    boolean result = refUnits.Verify_NewUnitsFeature_SaveorNot(UnitName);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "The InActive Units has been created & Saved");
          GenericMethods.fnEndTestCase();
	}

	@Test 
	public void fnUnitsCreation() {
		GenericMethods.fnStartTestCase("Verify Units creation");
		
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Unit";
	    int RowNumber = 3;
	    String UnitName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String UnitCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String BaseUnit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    refUnits.Create_NewUnits(UnitName,UnitCode,BaseUnit,Inactive);
	    boolean result = refUnits.Verify_NewUnitsFeature_SaveorNot(UnitName);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "Units has been created & Saved");
          GenericMethods.fnEndTestCase();
	}

	
	@Test 
	 public void fnUnitEdit() throws IOException {
		GenericMethods.fnStartTestCase("Verify Units Edit");
		
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Unit";
	    int RowNumber = 4;
		String OldUnitName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String UnitName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String UnitCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String BaseUnit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		refUnits.Verify_EditUnits(OldUnitName,UnitName,UnitCode,BaseUnit);
         boolean result = refUnits.Verify_NewUnitsFeature_SaveorNot(UnitName);
 	     Assert.assertTrue(result);
 	    fnWriteSteps("Pass", "Units has been Updated & Saved");
         GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnUnitsCreation_for_withoutInternet() {
		GenericMethods.fnStartTestCase("Verify Units creation for withoutInternet");
		
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Unit";
	    int RowNumber = 5;
	    String UnitName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String UnitCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String BaseUnit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    refUnits.Create_NewUnits(UnitName,UnitCode,BaseUnit,Inactive);
	    boolean result = refUnits.Verify_NewUnitsFeature_SaveorNot(UnitName);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "Units has been created & Saved");
         GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void fnActive_UnitsDelete() {
		GenericMethods.fnStartTestCase("Verify Units Delete");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Unit";
	    int RowNumber = 1;
	    String UnitName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    refUnits.fnVerifyUnitsDelete(UnitName);
	    boolean result = refUnits.Verify_UnitsDelete_SaveorNot(UnitName);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "The Active Units has been Deleted");
	    GenericMethods.fnEndTestCase();
	}
	@Test 
	 public void fnInactive_UnitsDelete() {
		GenericMethods.fnStartTestCase("Verify Inactive Units Delete");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Unit";
	    int RowNumber = 2;
	    String UnitName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    refUnits.fnVerifyUnitsDelete(UnitName);
	    boolean result = refUnits.Verify_UnitsDelete_SaveorNot(UnitName);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "The Inactive Units has been Deleted");
	    GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnUnitsDelete() {
		GenericMethods.fnStartTestCase("Verify Units Delete");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Unit";
	    int RowNumber = 4;
	    String UnitName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    refUnits.fnVerifyUnitsDelete(UnitName);
	    boolean result = refUnits.Verify_UnitsDelete_SaveorNot(UnitName);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "Units has been Deleted");
	    GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnUnitsDelete_for_withoutInternet() {
		GenericMethods.fnStartTestCase("Verify Units Delete for withoutInternet");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Unit";
	    int RowNumber = 5;
	    String UnitName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    refUnits.fnVerifyUnitsDelete(UnitName);
	    refUnits.click_On_Yes_Button();
	    fnWriteSteps("Pass", "Units not Deleted");
	    GenericMethods.fnEndTestCase();
	}
	
	@AfterMethod
	public void fnAfterMethod() {
		GenericMethods.fnStartTestCase("fn Logout");
		refUnits.clickCloseButton();
		GenericMethods.fnwait(2);
		refDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		refMessageBoxEffia.ExitApplication_Yes();
		GenericMethods.fnwait(5);
		refLogin.ClickCloseButton();
		fnWriteSteps("Pass", "Application Close Successfully");
		GenericMethods.fnEndTestCase();
	}

}

