package JBWindows_Configurations;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import JBWindows.APP.APP_Dashboard;
import commonClass.BaseClass;

public class BaseTest extends BaseClass{
    APP_Dashboard refDashboard;
    @BeforeSuite
    public void setUp() {
        try {
            fnInitializeReport();
            fnStartTestCase("Suite Setup");
            driver = BaseTest.startWinAppDriver();

            // ✅ Sync driver with BaseClass so screenshots work
            BaseClass.setDriver(driver);

            //fnWriteSteps("INFO", "Test setup complete: Application opened");
        } catch (Exception e) {
            //fnWriteSteps("FAIL", "Failed to set up test");
            throw new RuntimeException("Test setup failed");
        }
    }



    @AfterSuite
    public void tearDown() {
        try {
            fnStartTestCase("Suite Cleanup");

            if (driver != null) {
                try {
                    // logout via UI (if needed)
                    refDashboard = new APP_Dashboard(driver);
                    refDashboard.logoutwithoutmenu();

                    // OR directly kill the app
                    driver.closeApp();  // closes AUT
                    driver.quit();      // quits session
                } catch (Exception e) {
                    fnWriteSteps("WARN", "Could not logout cleanly, forcing quit: " + e.getMessage());
                    try { driver.quit(); } catch (Exception ignored) {}
                }
            }

            // finally stop WinAppDriver server
            BaseTest.stopWinAppDriver();
            BaseClass.setDriver(null);

            fnWriteSteps("PASS", "Test cleanup complete: Application closed");
            fnEndTestCase();
        } catch (Exception e) {
            fnWriteSteps("FAIL", "Error during test cleanup: " + e.getMessage());
        }
    }



}
