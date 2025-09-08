package JBWindows_Masters;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.CRM.CRM_Agents;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows_Configurations.BaseTest;
import commonClass.ApplicationVariables;
import commonClass.ExcelUtils;

public class AgentPage_UnitTest extends BaseTest {

	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	CRM_Agents refAgents;
	MessageBoxEffia refMessageBoxEffia;
	
	@BeforeClass
	public void init() {
		refLogin = new Login(driver);
		refDashboard = new APP_Dashboard(driver);
		refMenu = new APP_Menu(driver);
		refAgents = new CRM_Agents(driver);
		refMessageBoxEffia = new MessageBoxEffia(driver);
		
	}


	@BeforeMethod
	public void fn_Login_and_Open_Page() throws InterruptedException {
        	
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		refLogin.fnDoLogin(Username, Password);
        fnWriteSteps("INFO", "Login method executed");
        refDashboard.clickMenuBtn();
		refMenu.OpenPage("Agents");
		fnWriteSteps("INFO", "Agents Page Opened Successfully");

	}
	
	
	@AfterMethod
	public void fnAfterMethod() {
    	fnStartTestCase("fn Logout");
    	refAgents.clickBackButton();
    	refDashboard.logout();
		fnWriteSteps("Pass", "Application Close Successfully");
		fnEndTestCase();
	}

	@Test 
	public void fnVerifyFieldVisibility(){
		fnStartTestCase("Verify all the fields of Agent add entry are present or not ");
         refAgents.verifyFieldVisibility();
        fnEndTestCase();
	}

	@Test 
	public void fnVerifyFieldEnableOrNot() throws IOException, InterruptedException {
		fnStartTestCase("Verify all the fields of Agent add entry are enable or not");
        refAgents.verifyFieldEnableOrNot();
     	fnEndTestCase();
	}

	@Test 
	public void fn_Active_AgentCreation() {
		fnStartTestCase("Verify Active Agent creation");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Agents";
	    int RowNumber = 1;
	    String FirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String LastName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String PhoneNum = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String DOB  = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Anniversary = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String CommissionRate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
	    refAgents.createNewAgent(FirstName,LastName,PhoneNum,Email,DOB,Anniversary,Area,CommissionRate,Address,Inactive);
	    boolean result = refAgents.Verify_NewAgentCreation_SaveorNot(FirstName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Active Agent has been created & saved");
	    fnEndTestCase();
		
	}
	@Test 
	public void fn_InActive_AgentCreation() {
		fnStartTestCase("Verify InActive Agent creation");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Agents";
	    int RowNumber = 2;
	    String FirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String LastName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String PhoneNum = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String DOB  = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Anniversary = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String CommissionRate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
	    refAgents.createNewAgent(FirstName,LastName,PhoneNum,Email,DOB,Anniversary,Area,CommissionRate,Address,Inactive);
	    boolean result = refAgents.Verify_NewAgentCreation_SaveorNot(FirstName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "InActive Agent has been created & saved");
	    fnEndTestCase();
		
	}
	@Test 
	public void fnAgentCreation_for_WithoutInternet_Validation() {
		fnStartTestCase("Verify Agent creation_for_withoutInternet");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Agents";
	    int RowNumber = 3;
	    String FirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String LastName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String PhoneNum = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String DOB  = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Anniversary = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String CommissionRate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
	    refAgents.createNewAgent(FirstName,LastName,PhoneNum,Email,DOB,Anniversary,Area,CommissionRate,Address,Inactive);
	    boolean result = refAgents.Verify_NewAgentCreation_SaveorNot(FirstName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Agent has been created & saved");
	    fnEndTestCase();
		
	}
	@Test 
	public void fnAgentCreation() {
		fnStartTestCase("Verify Agent creation");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Agents";
	    int RowNumber = 4;
	    String FirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String LastName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String PhoneNum = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String DOB  = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Anniversary = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String CommissionRate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
	    refAgents.createNewAgent(FirstName,LastName,PhoneNum,Email,DOB,Anniversary,Area,CommissionRate,Address,Inactive);
	    boolean result = refAgents.Verify_NewAgentCreation_SaveorNot(FirstName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Agent has been created & saved");
	    fnEndTestCase();
		
	}

	@Test 
	public void fnAgentEdit() {
		fnStartTestCase("Verify Agent Edit");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Agents";
	    int RowNumber = 10;
	    String OldFirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
	    String FirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String LastName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String Phno = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String DOB = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    String Anniversary = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
	    refAgents.verifyAgentEdit(OldFirstName,FirstName,LastName,Phno,Email,DOB,Anniversary);
	    boolean result = refAgents.Verify_NewAgentCreation_SaveorNot(FirstName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Agent has been Updated & saved");
        fnEndTestCase();
	}
	
	@Test 
	public void fnDeleteAgent() {
		fnStartTestCase("Verify Delete Agent Feature");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Agents";
        int RowNumber = 10;
        String FirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        refAgents.fnVerifyAgentDelete(FirstName);
    	boolean result = refAgents.Verify_AgentDelete_SaveorNot(FirstName);
    	Assert.assertTrue(result);
    	fnWriteSteps("pass", "Agent has been Deleted");
    	fnEndTestCase();
	}
	@Test 
	public void fnDeleteActive_Agent() {
		fnStartTestCase("Verify Delete Active_Agent Feature");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Agents";
        int RowNumber = 1;
        String FirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        refAgents.fnVerifyAgentDelete(FirstName);
    	boolean result = refAgents.Verify_AgentDelete_SaveorNot(FirstName);
    	Assert.assertTrue(result);
    	fnWriteSteps("pass", "Active_Agent has been Deleted");
    	fnEndTestCase();
	}
	@Test 
	public void fnDeleteInActive_Agent() {
		fnStartTestCase("Verify Delete InActive_Agent Feature");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Agents";
        int RowNumber = 2;
        String FirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        refAgents.fnVerifyAgentDelete(FirstName);
    	boolean result = refAgents.Verify_AgentDelete_SaveorNot(FirstName);
    	Assert.assertTrue(result);
    	fnWriteSteps("pass", "InActive_Agent has been Deleted");
    	fnEndTestCase();
	}
	@Test 
	public void fnDelete_Agent_for_WithoutInternet() {
		fnStartTestCase("Verify Delete Agent Feature_for_withoutInternet");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Agents";
        int RowNumber = 3;
        String FirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        refAgents.fnVerifyAgentDelete(FirstName);
        refAgents.click_On_Yes_Button();
    	fnWriteSteps("pass", "Agent not Deleted");
    	fnEndTestCase();
	}

}
