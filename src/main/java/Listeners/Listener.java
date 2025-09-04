package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.LogClass;
import commonClass.TakeScreenshots;

public class Listener extends BaseClass implements ITestListener, org.testng.IConfigurationListener {
	
	@Override
	public void onStart(ITestContext context) {
	    // Initialize ExtentReports once per suite
	    if (RefReport == null) {
	        RefReport = fnInitializeReport(); // your Extent setup
	    }
	}

	@Override
	public void onFinish(ITestContext context) {
		fnGenerateReport();
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void onTestStart(ITestResult result) {
	    if (result.getMethod().isTest()) {   // only for @Test, skip @Before/@After
	        String methodName = result.getMethod().getMethodName();
	        String description = result.getMethod().getDescription();
	        RefTest = RefReport.createTest(methodName, description);
	    }
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	    RefTest.log(Status.PASS, "Test Passed");
	    LogClass.info("Test passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
	    RefTest.fail(result.getThrowable());   // log failure in same node
	    
	    String screenshotPath = TakeScreenshots.fn_take_Screenshot(result.getName());  // get actual path
	    try {
	        if (screenshotPath != null) {
	            RefTest.addScreenCaptureFromPath(screenshotPath);
	        } else {
	            LogClass.error("Screenshot path is null for " + result.getName());
	        }
	    } catch (Exception e) {
	        LogClass.error("Failed to add screenshot: " + e.getMessage());
	    }
	}




	@Override
	public void onTestSkipped(ITestResult result) {
	    RefTest.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
	    LogClass.warn("Test skipped: " + result.getName());
	}
	
	@Override
	public void onConfigurationFailure(ITestResult result) {
	    String methodName = result.getMethod().getMethodName();
	    RefTest = RefReport.createTest(methodName + " (Configuration Failure)");
	    RefTest.fail("Configuration method failed: " + result.getThrowable());

	    String screenshotPath = TakeScreenshots.fn_take_Screenshot(methodName);
	    try {
	        if (screenshotPath != null) {
	            RefTest.addScreenCaptureFromPath(screenshotPath);
	        }
	    } catch (Exception e) {
	        LogClass.error("Failed to add screenshot for config failure: " + e.getMessage());
	    }
	}

	@Override
	public void onConfigurationSkip(ITestResult result) {
	    String methodName = result.getMethod().getMethodName();
	    RefTest = RefReport.createTest(methodName + " (Configuration Skipped)");
	    RefTest.log(Status.SKIP, "Configuration skipped: " + result.getThrowable());
	}
	
	@Override
	public void onConfigurationSuccess(ITestResult result) {
	    LogClass.info("Configuration method passed: " + result.getMethod().getMethodName());
	}



}
