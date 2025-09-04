package commonClass;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;

public class ThreadLocalDriver {
    private static ThreadLocal<WindowsDriver<WebElement>> driverThread = new ThreadLocal<>();

    public static void setDriver(WindowsDriver<WebElement> driver) {
        driverThread.set(driver);
    }

    public static WindowsDriver<WebElement> getDriver() {
        return driverThread.get();
    }

    public static void removeDriver() {
        WindowsDriver<WebElement> driver = driverThread.get();
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                // Ignore errors during cleanup
            }
        }
        driverThread.remove();
    }
}