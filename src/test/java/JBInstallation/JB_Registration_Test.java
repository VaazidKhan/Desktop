package JBInstallation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.Configurations.Registration_JB;
import JBWindows.SYS.Login;
import JBWindows_Configurations.BaseTest;
import commonClass.ApplicationVariables;
import commonClass.ConfigReader;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class JB_Registration_Test extends BaseTest {
	Registration_JB refRegistration;
	APP_Dashboard refDashboard;
    Login refLogin;

	@BeforeMethod
	public void initDriver() {
		refRegistration = new Registration_JB(driver);
		refDashboard = new APP_Dashboard(driver);
		refLogin = new Login(driver);
	}
	
	@Test
	public void Verify_JB_RegistrationExistingOrg() {
		fnStartTestCase("Verify JB Registration");

		try {

			String orgCode = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
					ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win",
					"OrganisationCode");
			//String oCode = ConfigReader.getProperty("org");
			//String aid = ConfigReader.getProperty("accid");
			String accId = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
					ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "AccountID");
			String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
					ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
			String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
					ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
			
			refRegistration.fnDORegistartion(orgCode, accId);
			fnWriteSteps("PASS", "Registration completed successfully");
			refLogin.fnDoLogin(Username, Password);
			//GenericMethods.fnwait(10);;

		} catch (Exception e) {
			throw e;
		}
	}
	
	//@AfterMethod
	public void fnAfterMethod() {
    	fnStartTestCase("fn Logout");
		refDashboard.logout();
		fnWriteSteps("Pass", "Application Close Successfully");
		fnEndTestCase();
	}


}
