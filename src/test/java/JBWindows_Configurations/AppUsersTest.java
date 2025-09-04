package JBWindows_Configurations;

import java.awt.AWTException;
import java.io.IOException;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.Configurations.AppUsers;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class AppUsersTest extends BaseClass {
	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	AppUsers refAppUsers;
	MessageBoxEffia refMessageBoxEffia;

	public AppUsersTest() {
		super();
	}


	@BeforeMethod
	public void fn_Login_and_Open_Page() throws InterruptedException, FindFailed {

		refLogin = new Login(driver);
		refDashboard = new APP_Dashboard(driver);
		refMenu = new APP_Menu(driver);
		refAppUsers = new AppUsers();
		refMessageBoxEffia = new MessageBoxEffia(driver);

		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		refLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(10);
		refDashboard.clickMenuBtn();
        GenericMethods.fnwait(5);
        refMenu.OpenPage("users");
        GenericMethods.fnwait(1);
     //   fnWriteSteps("Pass", "Application Open Successfully" );
		GenericMethods.fnEndTestCase();

}    
	
	@Test 
	public void fnVerifyFieldVisibility_FieldEnabledorNot() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Users add entry are present/Enable or not ");
		refAppUsers.VerifyFieldVisibility_FieldEnabledorNot();
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void DefaultUserValidation() throws AWTException {
		GenericMethods.fnStartTestCase("DefaultUser Validation");
		String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName = "Users";
	    int RowNumber = 3;
	    String Username = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
	    boolean result = refAppUsers.Verify_NewUser_SaveorNot(Username);
		Assert.assertTrue(result);
	}
	
	@Test 
	public void fnUserCreation() throws AWTException {
		GenericMethods.fnStartTestCase("Verify User creation");
		String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName = "Users";
	    int RowNumber = 1;
	    String Username = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String Password = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String Name = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String RoleName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String Email  = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String MobileNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String PhNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String Activationdate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String Expirationdate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String Particulars = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		refAppUsers.NewUserCreation(Username, Password, Name, RoleName, Email, MobileNo, PhNo, Activationdate, Expirationdate, Particulars);
	    boolean result = refAppUsers.Verify_NewUser_SaveorNot(Username);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "User has been created & saved");
	    GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void fnUserEdit() throws AWTException {
		GenericMethods.fnStartTestCase("Verify User Edit");
		String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName = "Users";
	    int RowNumber = 2;
	    String OldUsername = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
	    String Password = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String Name = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String Email  = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String MobileNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String PhNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String Particulars = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		refAppUsers.NewUserEdit(OldUsername, Password, Name, Email, MobileNo, PhNo,Particulars);
		fnWriteSteps("Pass", "User has been Updated & saved");
	    GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void fnDefaultUserEdit() throws AWTException {
		GenericMethods.fnStartTestCase("Verify DefaultUser Edit");
		String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName = "Users";
	    int RowNumber = 3;
	    String OldUsername = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
	    String Password = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String Name = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String Email  = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String MobileNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String PhNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String Particulars = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		refAppUsers.NewUserEdit(OldUsername, Password, Name, Email, MobileNo, PhNo,Particulars);
		fnWriteSteps("Pass", "DefaultUser has been Updated & saved");
	    GenericMethods.fnEndTestCase();
		
	}
	
	@AfterMethod
	public void fnAfterMethod() {
		GenericMethods.fnStartTestCase("fnAfterMethod");
		refAppUsers.clickCloseButton();
		refDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		refMessageBoxEffia.ExitApplication_Yes();
		GenericMethods.fnwait(5);
		refLogin.ClickCloseButton();
		fnWriteSteps("Pass", "Application Close Successfully");
		GenericMethods.fnEndTestCase();
	}
	

}
