package JBWindows_Configurations;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import commonClass.BaseClass;

public class BaseTest extends BaseClass{

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
            BaseTest.stopWinAppDriver();
            BaseClass.setDriver(null);  // ✅ clear reference
            //fnWriteSteps("INFO", "Test cleanup complete: Driver and WinAppDriver stopped");
        } catch (Exception e) {
            //fnWriteSteps("FAIL", "Error during test cleanup");
        }
    }


}
