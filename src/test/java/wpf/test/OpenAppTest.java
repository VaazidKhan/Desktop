package wpf.test;

import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import reusableComponents.LoggerUtils;
import winAppDriverComponents.BaseTest;
import wpf.pages.LoginPage;
import wpf.pages.MenuPage;


/**
 * Test class to open and verify a WPF application using WinAppDriver.
 */
public class OpenAppTest extends BaseTest {
    LoginPage loginPage;
    MenuPage menuPage;
	JSONObject loginUsers;
    SoftAssert sa = new SoftAssert();

	
	
@BeforeClass
public void beforeClass() throws Exception {
		InputStream datais = null;
	  try {
		  String dataFileName = "data/loginUsers.json";
		  datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
		  JSONTokener tokener = new JSONTokener(datais);
		  loginUsers = new JSONObject(tokener);
	  } catch(Exception e) {
		  e.printStackTrace();
		  throw e;
	  } finally {
		  if(datais != null) {
			  datais.close();
		  }
	  }
}


    /**
     * Tests if the application opens successfully by checking its window title.
     */
    //@Test
    public void openApplication() {
        try {
            // Get the application window title
            String windowTitle = driver.getTitle();
            LoggerUtils.info("Application opened with title: " + windowTitle);

            // Verify the application is open (basic check for non-empty title)
            if (windowTitle == null || windowTitle.isEmpty()) {
                throw new AssertionError("Application window title is empty or null");
            }
            LoggerUtils.info("Test passed: Application opened successfully");
        } catch (Exception e) {
            LoggerUtils.error("Test failed: Unable to verify application", e);
            throw new AssertionError("Test failed", e);
        }
    }
    
    
    @Test
    public void signInApplication() {
    	try {
    		loginPage = new LoginPage(driver);
    		loginPage.login(loginUsers.getJSONObject("validUser").getString("username"),
    				loginUsers.getJSONObject("validUser").getString("password"));
    			
    	}
    	catch (Exception e) {
		}
    }
}