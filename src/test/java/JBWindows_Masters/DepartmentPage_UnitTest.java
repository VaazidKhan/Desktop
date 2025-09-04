package JBWindows_Masters;


import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.COM.COM_Department;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class DepartmentPage_UnitTest extends BaseClass {

	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	COM_Department refDepartment;
	MessageBoxEffia refMessageBoxEffia;

	public DepartmentPage_UnitTest() {
		super();
	}

	@BeforeMethod
	public void fnBeforeMethod()  throws InterruptedException {
		GenericMethods.fnStartTestCase("fn Login and Open Page");
		DOMConfigurator.configure("log4j.xml");
		
		refLogin = new Login(driver);
		refDashboard = new APP_Dashboard(driver);
		refMenu = new APP_Menu(driver);
		refDepartment = new COM_Department();
		refMessageBoxEffia = new MessageBoxEffia(driver);
		GenericMethods.fnwait(24);
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
		refMenu.OpenPage("Departments");
		GenericMethods.fnwait(2);
		refDepartment.activatePage();

	}

	@Test 
	public void fnVerifyFieldVisibility() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Department add entry are present or not ");

		refDepartment.verifyFieldVisibility();		

		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void fnVerifyFieldEnableOrNot() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Department add entry are enable or not");

		refDepartment.verifyFieldEnableOrNot();
		
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnDepartmentCreation_for_MultiDiscountFeature() {
		GenericMethods.fnStartTestCase("Verify Department creation for MultiDiscountFeature");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Departments";
	    int RowNumber = 4;
	    String DepartmentName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String Discountrule = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		refDepartment.createNewDepartment(DepartmentName,Discountrule,Description);
		boolean result = refDepartment.Verify_NewDepartmentFeature_SaveorNot(DepartmentName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Department has been created & Saved ");
        GenericMethods.fnEndTestCase();
	}

	@Test 
	public void fnDepartmentCreation() {
		GenericMethods.fnStartTestCase("Verify Department creation");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Departments";
	    int RowNumber = 1;
	    String DepartmentName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String Discountrule = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		refDepartment.createNewDepartment(DepartmentName,Discountrule,Description);
		boolean result = refDepartment.Verify_NewDepartmentFeature_SaveorNot(DepartmentName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Department has been created & Saved ");
        GenericMethods.fnEndTestCase();
	}

	@Test 
	public void fnDepartmentEdit() {
		GenericMethods.fnStartTestCase("Verify Department Edit");
		
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Departments";
	    int RowNumber = 2;
	    String OldDepartmentName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String DepartmentName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String DiscountRule = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		refDepartment.verifyDepartmentEdit(OldDepartmentName,DepartmentName,DiscountRule,Description);
		boolean result = refDepartment.Verify_NewDepartmentFeature_SaveorNot(DepartmentName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Department has been Updated & Saved ");
		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void fnDepartmentCreation_for_withoutInternet() {
		GenericMethods.fnStartTestCase("Verify Department creation for withoutInternet");
		
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Departments";
	    int RowNumber = 3;
	    String DepartmentName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String Discountrule = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		refDepartment.createNewDepartment(DepartmentName,Discountrule,Description);
		boolean result = refDepartment.Verify_NewDepartmentFeature_SaveorNot(DepartmentName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Department has been created & Saved ");

		GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void fnDepartmentDelete() {
		GenericMethods.fnStartTestCase("Verify Department Delete");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Departments";
	    int RowNumber = 2;
	    String DepartmentName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    refDepartment.fnVerifyDepartmentDelete(DepartmentName);
	    boolean result = refDepartment.Verify_DepartmentDelete_SaveorNot(DepartmentName);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "Department has been Deleted");
	    GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnDepartmentDelete_for_withoutInternet() {
		GenericMethods.fnStartTestCase("Verify Department Delete for withoutInternet");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Departments";
	    int RowNumber = 3;
	    String DepartmentName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    refDepartment.fnVerifyDepartmentDelete(DepartmentName);
	    refDepartment.click_On_Yes_Button();
	    fnWriteSteps("Pass", "Department not Deleted");
	    GenericMethods.fnEndTestCase();
	}
	
	@AfterMethod
	public void fnAfterMethod() {
		GenericMethods.fnStartTestCase("fn Logout");
		refDepartment.clickCloseButton();
		GenericMethods.fnwait(2);
		refDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		refMessageBoxEffia.ExitApplication_Yes();
		GenericMethods.fnwait(24);
		refLogin.ClickCloseButton();
		fnWriteSteps("Pass", "Application Close Successfully");
		GenericMethods.fnEndTestCase();
	}

}
