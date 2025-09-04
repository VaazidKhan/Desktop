package JBWindows_Masters;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.COM.COM_TaxRate;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class TaxRatePage_UnitTest extends BaseClass {

	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	MessageBoxEffia refMessageBoxEffia;
	COM_TaxRate refTaxRate;

	public TaxRatePage_UnitTest() {
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
		refTaxRate = new COM_TaxRate();

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
		refMenu.OpenPage("tax rates");
		GenericMethods.fnwait(2);

	}

	@Test 
	public void fnVerifyFieldVisibility() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of TaxRate add entry are present or not");

		refTaxRate.VerifyFieldVisibility();

		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void fnVerifyFieldEnableOrNot() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of TaxRate add entry are enable or not");

		refTaxRate.VerifyFieldEnableOrNot();

		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnActive_TaxRateCreation() {
		GenericMethods.fnStartTestCase("Verify Active TaxRate creation");
		
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Taxrate";
	    int RowNumber = 1;
	    String TaxName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String TaxRate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String TaxType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String GLCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String ReturnRate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
	    refTaxRate.CreateNewTaxRate(TaxName,TaxRate,TaxType,GLCode,ReturnRate,Inactive);
	    boolean result = refTaxRate.Verify_NewTaxrateFeature_SaveorNot(TaxName);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "The Active TaxRate has been created & Saved");
          GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnInActive_TaxRateCreation() {
		GenericMethods.fnStartTestCase("Verify InActive TaxRate creation");
		
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Taxrate";
	    int RowNumber = 2;
	    String TaxName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String TaxRate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String TaxType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String GLCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String ReturnRate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
	    refTaxRate.CreateNewTaxRate(TaxName,TaxRate,TaxType,GLCode,ReturnRate,Inactive);
	    boolean result = refTaxRate.Verify_NewTaxrateFeature_SaveorNot(TaxName);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "The InActive TaxRate has been created & Saved");
          GenericMethods.fnEndTestCase();
	}

	@Test 
	public void fnTaxRateCreation() {
		GenericMethods.fnStartTestCase("Verify Tax Rate creation");
		
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Taxrate";
	    int RowNumber = 3;
	    String TaxName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String TaxRate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String TaxType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String GLCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String ReturnRate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
	    refTaxRate.CreateNewTaxRate(TaxName,TaxRate,TaxType,GLCode,ReturnRate,Inactive);
	    boolean result = refTaxRate.Verify_NewTaxrateFeature_SaveorNot(TaxName);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "Tax Rate has been created & Saved");
          GenericMethods.fnEndTestCase();
	}

	@Test 
	 public void fnTaxEdit() throws IOException {
		GenericMethods.fnStartTestCase("Verify TaxRate Edit");
		
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Taxrate";
	    int RowNumber = 4;
		String OldTaxName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String TaxName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String TaxRate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String TaxType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String GLCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String ReturnRate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
         refTaxRate.VerifyTaxEdit(OldTaxName,TaxName,TaxRate,TaxType,GLCode,ReturnRate);
         boolean result = refTaxRate.Verify_NewTaxrateFeature_SaveorNot(TaxName);
 	     Assert.assertTrue(result);
 	    fnWriteSteps("Pass", "TaxRate has been Updated & Saved");
         GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnTaxRateCreation_for_withoutInternet() {
		GenericMethods.fnStartTestCase("Verify TaxRate creation for withoutInternet");
		
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Taxrate";
	    int RowNumber = 5;
	    String TaxName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String TaxRate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String TaxType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String GLCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String ReturnRate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
	    refTaxRate.CreateNewTaxRate(TaxName,TaxRate,TaxType,GLCode,ReturnRate,Inactive);
	    boolean result = refTaxRate.Verify_NewTaxrateFeature_SaveorNot(TaxName);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "TaxRate has been created & Saved");
         GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void fnActive_TaxrateDelete() {
		GenericMethods.fnStartTestCase("Verify Active Taxrate Delete");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Taxrate";
	    int RowNumber = 1;
	    String TaxName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    refTaxRate.fnVerifyTaxRateDelete(TaxName);
	    boolean result = refTaxRate.Verify_TaxrateDelete_SaveorNot(TaxName);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "The Active Taxrate has been Deleted");
	    GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnInActive_TaxrateDelete() {
		GenericMethods.fnStartTestCase("Verify InActive Taxrate Delete");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Taxrate";
	    int RowNumber = 2;
	    String TaxName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    refTaxRate.fnVerifyTaxRateDelete(TaxName);
	    boolean result = refTaxRate.Verify_TaxrateDelete_SaveorNot(TaxName);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "The InActive Taxrate has been Deleted");
	    GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnTaxrateDelete() {
		GenericMethods.fnStartTestCase("Verify Taxrate Delete");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Taxrate";
	    int RowNumber = 4;
	    String TaxName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    refTaxRate.fnVerifyTaxRateDelete(TaxName);
	    boolean result = refTaxRate.Verify_TaxrateDelete_SaveorNot(TaxName);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "Taxrate has been Deleted");
	    GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnTaxrateDelete_for_withoutInternet() {
		GenericMethods.fnStartTestCase("Verify Taxrate Delete for withoutInternet");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Taxrate";
	    int RowNumber = 5;
	    String TaxName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    refTaxRate.fnVerifyTaxRateDelete(TaxName);
	    refTaxRate.click_On_Yes_Button();
	    fnWriteSteps("Pass", "TaxRate not Deleted");
	    GenericMethods.fnEndTestCase();
	}
   
	@AfterMethod
	public void fnAfterMethod() {
		GenericMethods.fnStartTestCase("fn Logout");
		refTaxRate.clickCloseButton();
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
