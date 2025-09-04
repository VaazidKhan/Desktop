package JBWindows_Masters;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.SAL.SR_TaxGroup;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class TaxGroupPage_Test extends BaseClass {
	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	SR_TaxGroup refTaxGroup;
	MessageBoxEffia refMessageBoxEffia;

	public TaxGroupPage_Test() {
		super();
	}

	@BeforeMethod
	public void fn_Login_and_Open_Page() throws InterruptedException {
		GenericMethods.fnStartTestCase("fn Login and Open Page");
		DOMConfigurator.configure("log4j.xml");
		refLogin = new Login(driver);
		refDashboard = new APP_Dashboard(driver);
		refMenu = new APP_Menu(driver);
		refTaxGroup = new SR_TaxGroup();
		refMessageBoxEffia = new MessageBoxEffia(driver);

		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		refLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(10);
		refDashboard.clickMenuBtn();
        GenericMethods.fnwait(2);
		refMenu.OpenPage("tax groups");
		GenericMethods.fnwait(1);
		fnWriteSteps("Pass", "Application open Successfully");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnVerifyFieldVisibility_FieldEnabledorNot() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of TaxGroup add entry are present/Enable or not ");

		refTaxGroup.VerifyFieldVisibility_FieldEnabledorNot();
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnTaxGroupCreation() {
		GenericMethods.fnStartTestCase("Verify TaxGroup creation");
		
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName ="TaxGroup";
	    int RowNumber = 1;
	    String TaxGroupName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,0);
	    String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,1);
	    String WithinStateTax1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,2);
	    String WithinStateTax2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,3);
	    String WithinStateTax3= ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,4);
	    String OutsideStateTax1= ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,5);
	    String OutsideStateTax2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,6);
	    String OutsideStateTax3 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,7);
	    boolean result = refTaxGroup.CreateNewTaxGroup(TaxGroupName,State,WithinStateTax1,WithinStateTax2,WithinStateTax3,OutsideStateTax1,OutsideStateTax2,OutsideStateTax3);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "TaxGroup has been created & Saved");
          GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnTaxGroupEdit() {
     GenericMethods.fnStartTestCase("Verify TaxGroup Edit");
		
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName ="TaxGroup";
	    int RowNumber = 2;
	    String OldTaxGroupName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,8);
	    String TaxGroupName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,0);
	    String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,1);
	    String WithinStateTax1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,2);
	    String WithinStateTax2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,3);
	    String WithinStateTax3= ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,4);
	    String OutsideStateTax1= ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,5);
	    String OutsideStateTax2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,6);
	    String OutsideStateTax3 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,7);
	    boolean result = refTaxGroup.VerifyTaxGroupEdit(OldTaxGroupName,TaxGroupName,State,WithinStateTax1,WithinStateTax2,WithinStateTax3,OutsideStateTax1,OutsideStateTax2,OutsideStateTax3);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "TaxGroup has been Updated & Saved");
          GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnTaxGroupCreation_for_withoutInternet() {
		GenericMethods.fnStartTestCase("Verify TaxGroup creation for WithoutInternet");
		
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName ="TaxGroup";
	    int RowNumber = 3;
	    String TaxGroupName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,0);
	    String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,1);
	    String WithinStateTax1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,2);
	    String WithinStateTax2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,3);
	    String WithinStateTax3= ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,4);
	    String OutsideStateTax1= ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,5);
	    String OutsideStateTax2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,6);
	    String OutsideStateTax3 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName.trim(), RowNumber,7);
	    boolean result = refTaxGroup.CreateNewTaxGroup(TaxGroupName,State,WithinStateTax1,WithinStateTax2,WithinStateTax3,OutsideStateTax1,OutsideStateTax2,OutsideStateTax3);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "TaxGroup has been created & Saved");
          GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnDeleteTaxGroup() {
			GenericMethods.fnStartTestCase("Verify Delete TaxGroup Feature");
			String StrExcelPath = ApplicationVariables.MasterExcelPath;
	        String StrSheetName = "TaxGroup";
	        int RowNumber = 2;
	        String TaxGroupName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	        refTaxGroup.fnVerifyTaxGroupDelete(TaxGroupName);
	        boolean result = refTaxGroup.Verify_TaxGroupDelete_SaveorNot(TaxGroupName);
	    	Assert.assertTrue(result);
	    	fnWriteSteps("pass", "TaxGroup has been Deleted");
	    	GenericMethods.fnEndTestCase();
		}
	@Test 
	public void fnDeleteTaxGroup_for_withoutInternet() {
		GenericMethods.fnStartTestCase("Verify Delete TaxGroup Feature for withoutInternet");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "TaxGroup";
        int RowNumber = 3;
        String TaxGroupName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        refTaxGroup.fnVerifyTaxGroupDelete(TaxGroupName);
        refTaxGroup.click_On_Yes_Button();
    	fnWriteSteps("pass", "TaxGroup not Deleted");
    	GenericMethods.fnEndTestCase();
	}
	@AfterMethod
	public void fnAfterMethod() {
		GenericMethods.fnStartTestCase("fn Logout");
		refTaxGroup.clickCloseButton();
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
