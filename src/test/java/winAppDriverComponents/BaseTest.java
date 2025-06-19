// Updated BaseTest.java to preserve app instance by skipping temp.quit()
package winAppDriverComponents;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import reusableComponents.ConfigReader;
import reusableComponents.LoggerUtils;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String HOST = ConfigReader.getProperty("host");
    private static final int PORT = Integer.parseInt(ConfigReader.getProperty("port"));
    private static Process winAppDriverProcess;
    public static WindowsDriver driver;

    @BeforeSuite
    public void setUp() {
        try {
            driver = BaseTest.startWinAppDriver();
            LoggerUtils.info("Test setup complete: Application opened");
        } catch (Exception e) {
            LoggerUtils.error("Failed to set up test", e);
            throw new RuntimeException("Test setup failed", e);
        }
    }

    @AfterSuite
    public void tearDown() {
        try {
            BaseTest.stopWinAppDriver();
            LoggerUtils.info("Test cleanup complete: Driver and WinAppDriver stopped");
        } catch (Exception e) {
            LoggerUtils.error("Error during test cleanup", e);
        }
    }

    public static WindowsDriver startWinAppDriver() {
        try {
            Files.createDirectories(Paths.get("resources/logs/"));
            LoggerUtils.info("Logs directory ready: resources/logs/");
        } catch (IOException e) {
            LoggerUtils.error("Failed to create logs directory: resources/logs/", e);
        }

        killWinAppDriver();

        String winAppDriverPath = ConfigReader.getProperty("winAppDriverPath");
        if (winAppDriverPath == null || winAppDriverPath.isEmpty()) {
            LoggerUtils.error("winAppDriverPath not found in config.properties");
            throw new RuntimeException("winAppDriverPath not found");
        }

        try {
            ProcessBuilder pb = new ProcessBuilder(winAppDriverPath, HOST, String.valueOf(PORT));
            pb.redirectErrorStream(true);
            winAppDriverProcess = pb.start();
            LoggerUtils.info("WinAppDriver started at http://" + HOST + ":" + PORT);

            long startTime = System.currentTimeMillis();
            while (!isWinAppDriverRunning() && (System.currentTimeMillis() - startTime) < 5000) {
                Thread.sleep(500);
            }
            if (!isWinAppDriverRunning()) {
                throw new RuntimeException("WinAppDriver failed to start on port " + PORT);
            }

            return initializeDriver();
        } catch (IOException | InterruptedException e) {
            LoggerUtils.error("Failed to start WinAppDriver", e);
            if (winAppDriverProcess != null) {
                winAppDriverProcess.destroy();
            }
            throw new RuntimeException("Failed to start WinAppDriver", e);
        }
    }

    private static WindowsDriver initializeDriver() {
        try {
            DesiredCapabilities initialCaps = getWpfOptions();
            WindowsDriver temp = new WindowsDriver(new URL("http://" + HOST + ":" + PORT), initialCaps);
            LoggerUtils.info("Initial driver session created");
            Thread.sleep(2000);

            String hexHandle = temp.getWindowHandle();
            LoggerUtils.info("Window handle (hex): " + hexHandle);
            int decHandle = Integer.parseInt(hexHandle.replace("0x", ""), 16);
            String hexWindow = String.format("%08X", decHandle);
            LoggerUtils.info("Using appTopLevelWindow: " + hexWindow);

            DesiredCapabilities attachCaps = new DesiredCapabilities();
            attachCaps.setCapability("appTopLevelWindow", hexWindow);
            attachCaps.setCapability("platformName", "Windows");
            attachCaps.setCapability("deviceName", "WindowsPC");

            // temp.quit(); // Commented to keep app running
            Thread.sleep(1000);

            for (int i = 0; i < 3; i++) {
                LoggerUtils.info("🔁 Attempting to attach to appTopLevelWindow (try " + (i + 1) + ")");
                try {
                    driver = new WindowsDriver(new URL("http://" + HOST + ":" + PORT), attachCaps);
                    LoggerUtils.info("✅ WindowsDriver session started on retry " + (i + 1));
                    Thread.sleep(2000);
                    return driver;
                } catch (Exception e) {
                    LoggerUtils.warn("❌ Retry " + (i + 1) + " failed: " + e.getMessage());
                    Thread.sleep(2000);
                }
            }

            throw new RuntimeException("❌ All attempts to attach with appTopLevelWindow failed");
        } catch (Exception e) {
            LoggerUtils.error("Failed to attach WindowsDriver using appTopLevelWindow", e);
            throw new RuntimeException("Failed to attach WindowsDriver", e);
        }
    }

    private static DesiredCapabilities getWpfOptions() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", ConfigReader.getProperty("platformName", "Windows"));
        capabilities.setCapability("deviceName", ConfigReader.getProperty("deviceName", "WindowsPC"));

        String appPath = ConfigReader.getProperty("appPath");
        if (appPath == null || appPath.isEmpty()) {
            LoggerUtils.error("appPath not found in config.properties");
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
                LoggerUtils.info("Terminated existing WinAppDriver process");
            } catch (InterruptedException e) {
                LoggerUtils.warn("Interrupted while terminating WinAppDriver");
                Thread.currentThread().interrupt();
            }
        }

        try {
            ProcessBuilder pb = new ProcessBuilder("taskkill", "/IM", "WinAppDriver.exe", "/F");
            pb.start().waitFor(2, TimeUnit.SECONDS);
            LoggerUtils.info("Killed all WinAppDriver processes");
        } catch (IOException | InterruptedException e) {
            LoggerUtils.error("Error killing WinAppDriver processes", e);
        }
    }

    public static void stopWinAppDriver() {
        if (driver != null) {
            try {
                driver.quit();
                LoggerUtils.info("WindowsDriver session closed");
            } catch (Exception e) {
                LoggerUtils.error("Error closing WindowsDriver session", e);
            }
            driver = null;
        }
        killWinAppDriver();
    }

    public static WindowsDriver getDriver() {
        return driver;
    }
}
