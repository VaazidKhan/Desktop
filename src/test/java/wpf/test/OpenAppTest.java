package wpf.test;

import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commonClass.ApplicationVariables;
import commonClass.ExcelUtils;
import winAppDriverComponents.BaseTest;
import wpf.pages.DashboardPage;
import wpf.pages.LoginPage;

/**
 * Test class to open and verify a WPF application using WinAppDriver.
 */
@SuppressWarnings("unused")
public class OpenAppTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private JSONObject loginUsers;
    private SoftAssert sa = new SoftAssert();

    @BeforeClass
    public void beforeClass() throws Exception {
        InputStream datais = null;
        try {
            String dataFileName = "data/loginUsers.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);

            if (datais == null) {
                throw new RuntimeException("Could not find " + dataFileName);
            }

            JSONTokener tokener = new JSONTokener(datais);
            loginUsers = new JSONObject(tokener);
            fnWriteSteps("PASS", "Loaded login users JSON successfully");

        } catch (Exception e) {
        	fnWriteSteps("FAIL", "Failed to load login user data");
            throw e;
        } finally {
            if (datais != null) {
                datais.close();
            }
        }
    }
    @BeforeMethod
	public void beforeMethod() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
	}

    /**
     * Tests if the application opens successfully by checking its window title.
     */
    @Test (priority = 0, enabled = false)
    public void openApplication() {
        try {
            // Get the application window title
            String windowTitle = driver.getTitle();
            fnWriteSteps("PASS", "Application opened with title: " + windowTitle);

            // Verify the application is open (basic check for non-empty title)
            sa.assertTrue(windowTitle != null && !windowTitle.isEmpty(),
                    "Application window title is empty or null");
            fnWriteSteps("PASS", "Test passed: Application opened successfully");
        } catch (Exception e) {
        	fnWriteSteps("FAIL", "Test failed: Unable to verify application");
            sa.fail("Exception occurred while verifying application: " + e.getMessage());
        }
    }

    @Test (priority = 1, enabled = false)
    public void signInApplication() {
        try {
            String username = loginUsers.getJSONObject("validUser").getString("username");
            String password = loginUsers.getJSONObject("validUser").getString("password");

            fnWriteSteps("PASS", "Attempting login with user: " + username);
            loginPage.login(username, password);

            fnWriteSteps("INFO", "Login test executed successfully");
        } catch (Exception e) {
        	fnWriteSteps("FAIL", "Login test failed");
            sa.fail("Login test failed due to exception: " + e.getMessage());
        }
    }
    
    @Test (priority = 2)
    public void signInAndLogoutApplication() {
        try {
            loginPage = new LoginPage(driver);
            
//            String username = loginUsers.getJSONObject("validUser").getString("username");
//            String password = loginUsers.getJSONObject("validUser").getString("password");            
            
            String username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
                    ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
            String password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
                    ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");

            fnWriteSteps("INFO", "Attempting login with user: " + username);
            loginPage.login(username, password);

            sa.assertTrue(dashboardPage.isLoaded(), "Dashboard did not load after login");

            fnWriteSteps("INFO", "Attempting logout");
            dashboardPage.logout();

            fnWriteSteps("PASS", "Sign in and logout test completed");
            driver.close();
            fnWriteSteps("PASS", "Application closed successfully");
        } catch (Exception e) {
        	fnWriteSteps("FAIL", "Sign in and logout test failed");
            sa.fail("Sign in and logout test failed: " + e.getMessage());
        }
    }
    

    @AfterMethod(alwaysRun = true)
	public void afterMethod() {
    	try {
			// ✅ Flush the report even if the test failed
			if (RefReport != null) {
				RefReport.flush();
			}
		} catch (Exception e) {
			System.out.println("Error flushing report: " + e.getMessage());
		}
	}

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        sa.assertAll(); // report all assertion failures at the end
    }
}
