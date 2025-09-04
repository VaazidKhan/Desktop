package JBWindows_Masters;

import JBWindows.APP.APP_Dashboard;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows_Configurations.BaseTest;
import commonClass.ApplicationVariables;
import commonClass.ExcelUtils;
import commonClass.TakeScreenshots;
import org.testng.annotations.*;

public class LoginPage_UnitTest extends BaseTest {

    Login refLogin;
    APP_Dashboard refDashboard;
    MessageBoxEffia refMessageBox;


    @BeforeMethod
    public void initDriver() {
        refLogin = new Login(driver);
        refDashboard = new APP_Dashboard(driver);
        refMessageBox = new MessageBoxEffia(driver);
    }



    @Test
    public void Verify_Successful_Login() {
    	fnStartTestCase("Verify Successful Login");

        try {
            String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
                    ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
            String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
                    ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");

            refLogin.fnDoLogin(Username, Password);

            refDashboard.logout();
        } catch (Exception e) {
            TakeScreenshots.fn_take_Screenshot("Login_Error");
            fnWriteSteps("Fail", "Login failed: " + e.getMessage());
            throw e;
        } finally {
        	fnEndTestCase();
        }
    }
    
    
 
}
