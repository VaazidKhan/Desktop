package commonClass;

import io.appium.java_client.windows.WindowsDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WindowsDriver driver;
    protected static Logger logger;
    protected static Process winAppDriverProcess;
    private static final String HOST = ConfigReader.getProperty("host");
    private static final int PORT = Integer.parseInt(ConfigReader.getProperty("port"));



    static {
        initializeLogger();
    }
    
    public static ExtentReports RefReport;
	public static ExtentTest RefTest;
    
    public static void fnStartTestCase(String description) {
    	String testName = Reporter.getCurrentTestResult().getMethod().getMethodName();
        RefTest = RefReport.createTest(testName, description);
	}
 
    public static void fnWriteSteps(String strStatus, String strStepDesc) {
        // hide infra noise from Extent, keep only your steps
        if (strStepDesc != null && (strStepDesc.startsWith("[WinAppDriver]") || strStepDesc.startsWith("[Winium]"))) {
            LogClass.debug(strStepDesc);
            return;
        }
        if (RefTest == null) {
            System.out.println("[ExtentTest not initialized] " + strStatus + ": " + strStepDesc);
            return;
        }
        switch (strStatus.toUpperCase().trim()) {
            case "PASS": RefTest.log(Status.PASS, strStepDesc); LogClass.info(strStepDesc); break;
            case "FAIL": RefTest.log(Status.FAIL, strStepDesc); LogClass.error(strStepDesc);  break;
            default:     RefTest.log(Status.INFO, strStepDesc); LogClass.info(strStepDesc);
        }
    }


	public static void fnEndTestCase() {
		
		 try {
		        if (RefReport != null) {
		            RefReport.flush();
		        }
		    } catch (Exception e) {
		        System.out.println("Report flush failed in fnEndTestCase: " + e.getMessage());
		    }
	}
 
	public static void fnGenerateReport() {
		RefReport.flush();
	}

    private static void initializeLogger() {
        try {
            InputStream inputStream = BaseClass.class.getClassLoader().getResourceAsStream("log4j2.xml");
            if (inputStream == null) {
                throw new RuntimeException("log4j2.xml not found in classpath");
            }
            ConfigurationSource source = new ConfigurationSource(inputStream);
            Configurator.initialize(null, source);
            logger = LogManager.getLogger(BaseClass.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load Log4j configuration", e);
        }
    }    
    
    public static void setDriver(WindowsDriver driverInstance) {
        driver = driverInstance;
    }

    
    public static WindowsDriver getDriver() {
        return driver;
    }
    

    public static WindowsDriver startWinAppDriver() {

        killWinAppDriver();

        String winAppDriverPath = ConfigReader.getProperty("winAppDriverPath");
        if (winAppDriverPath == null || winAppDriverPath.isEmpty()) {
            //fnWriteSteps("FAIL", "winAppDriverPath not found in config.properties");
            throw new RuntimeException("winAppDriverPath not found");
        }

        try {
            ProcessBuilder pb = new ProcessBuilder(winAppDriverPath, HOST, String.valueOf(PORT));
            pb.redirectErrorStream(true);
            winAppDriverProcess = pb.start();

            // ✅ Capture and log WinAppDriver console output
            BufferedReader reader = new BufferedReader(new InputStreamReader(winAppDriverProcess.getInputStream(), "UTF-16LE"));
            new Thread(() -> {
                reader.lines().forEach(line -> fnWriteSteps("INFO", "[WinAppDriver] " + line));
            }).start();

            //fnWriteSteps("INFO", "WinAppDriver started at http://" + HOST + ":" + PORT);

            long startTime = System.currentTimeMillis();
            while (!isWinAppDriverRunning() && (System.currentTimeMillis() - startTime) < 30000) {
                Thread.sleep(500);
            }
            if (!isWinAppDriverRunning()) {
                throw new RuntimeException("WinAppDriver failed to start on port " + PORT);
            }

            return initializeDriver();
        } catch (IOException | InterruptedException e) {
            //fnWriteSteps("FAIL", "Failed to start WinAppDriver");
            if (winAppDriverProcess != null) {
                winAppDriverProcess.destroy();
            }
            throw new RuntimeException("Failed to start WinAppDriver");
        }
    }

    private static WindowsDriver initializeDriver() {
        try {
            DesiredCapabilities initialCaps = getWpfOptions();
            WindowsDriver temp = new WindowsDriver(new URL("http://" + HOST + ":" + PORT), initialCaps);
            //fnWriteSteps("INFO", "Initial driver session created");
            Thread.sleep(2000);

            String hexHandle = temp.getWindowHandle();
            int decHandle = Integer.parseInt(hexHandle.replace("0x", ""), 16);
            String hexWindow = String.format("%08X", decHandle);
            //fnWriteSteps("INFO", "Using appTopLevelWindow: " + hexWindow);

            DesiredCapabilities attachCaps = new DesiredCapabilities();
            attachCaps.setCapability("appTopLevelWindow", hexWindow);
            attachCaps.setCapability("platformName", "Windows");
            attachCaps.setCapability("deviceName", "WindowsPC");

            // temp.quit(); // Commented to keep app running
            Thread.sleep(1000);

            for (int i = 0; i < 3; i++) {
                //fnWriteSteps("INFO", "🔁 Attempting to attach to appTopLevelWindow (try " + (i + 1) + ")");
                try {
                    driver = new WindowsDriver(new URL("http://" + HOST + ":" + PORT), attachCaps);
                    //fnWriteSteps("INFO", "✅ WindowsDriver session started on retry " + (i + 1));
                    Thread.sleep(2000);
                    return driver;
                } catch (Exception e) {
                    //fnWriteSteps("INFO", "❌ Retry " + (i + 1) + " failed: " + e.getMessage());
                    Thread.sleep(2000);
                }
            }

            throw new RuntimeException("❌ All attempts to attach with appTopLevelWindow failed");
        } catch (Exception e) {
            //fnWriteSteps("FAIL", "Failed to attach WindowsDriver using appTopLevelWindow");
            throw new RuntimeException("Failed to attach WindowsDriver");
        }
    }

    private static DesiredCapabilities getWpfOptions() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", ConfigReader.getProperty("platformName", "Windows"));
        capabilities.setCapability("deviceName", ConfigReader.getProperty("deviceName", "WindowsPC"));

        String appPath = ConfigReader.getProperty("appPath");
        if (appPath == null || appPath.isEmpty()) {
            //fnWriteSteps("FAIL", "appPath not found in config.properties");
            throw new RuntimeException("appPath not found");
        }
        capabilities.setCapability("app", appPath);
        capabilities.setCapability("ms:waitForAppLaunch", ConfigReader.getProperty("waitForAppLaunch", "30"));
        return capabilities;
    }

    private static boolean isWinAppDriverRunning() {
        try (java.net.Socket socket = new java.net.Socket(HOST, PORT)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void killWinAppDriver() {
        if (winAppDriverProcess != null && winAppDriverProcess.isAlive()) {
            winAppDriverProcess.destroy();
            try {
                winAppDriverProcess.waitFor(2, TimeUnit.SECONDS);
                //fnWriteSteps("INFO", "Terminated existing WinAppDriver process");
            } catch (InterruptedException e) {
                //fnWriteSteps("INFO", "Interrupted while terminating WinAppDriver");
                Thread.currentThread().interrupt();
            }
        }

        try {
            ProcessBuilder pb = new ProcessBuilder("taskkill", "/IM", "WinAppDriver.exe", "/F");
            pb.start().waitFor(2, TimeUnit.SECONDS);
            //fnWriteSteps("INFO", "Killed all WinAppDriver processes");
        } catch (IOException | InterruptedException e) {
            //fnWriteSteps("FAIL", "Error killing WinAppDriver processes");
        }
    }

    public static void stopWinAppDriver() {
        if (driver != null) {
            try {
                driver.quit();
                //fnWriteSteps("INFO", "WindowsDriver session closed");
            } catch (Exception e) {
                //fnWriteSteps("FAIL", "Error closing WindowsDriver session");
            }
            driver = null;
        }
        killWinAppDriver();
    }
    
    
    
   	public static ExtentReports fnInitializeReport() {
   		// 🗓️ Format date as dd-MMM-yyyy (e.g., 05-Aug-2025)
   		String dateStamp = new SimpleDateFormat("dd-MMM-yyyy").format(new Date());
    
   		// 📁 Base report folder path
   		String reportBaseDir = System.getProperty("user.dir") + "/Reports/ExtentReport";
    
   		// 📄 Final report file path
   		String reportFilePath = reportBaseDir + "/ExtentReport_" + dateStamp + ".html";
    
   		// 📂 Create directory if not exists
   		File reportFolder = new File(reportBaseDir);
   		if (!reportFolder.exists()) {
   			reportFolder.mkdirs(); // create Reports/ExtentReport
   		}
    
   		// 📊 Set up Spark reporter
   		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFilePath);
   		sparkReporter.config().setDocumentTitle("Automation Report");
   		sparkReporter.config().setReportName("BackOffice Automation Execution");
   		sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);
    
   		// 🧾 Attach and add system info
   		RefReport = new ExtentReports();
   		RefReport.attachReporter(sparkReporter);
   		RefReport.setSystemInfo("Environment", "QA");
   		RefReport.setSystemInfo("Browser", "Chrome");
   		RefReport.setSystemInfo("Tester", "Vaazid");
		return RefReport;
   	}

    
}