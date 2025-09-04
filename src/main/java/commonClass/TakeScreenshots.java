package commonClass;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class TakeScreenshots {
    public static String fn_take_Screenshot(String fileName) {
        try {
            WindowsDriver driver = BaseClass.getDriver();
            if (driver == null) return null;

            File srcFile = driver.getScreenshotAs(OutputType.FILE);
            String screenshotPath = System.getProperty("user.dir") + "/Reports/Screenshots/" + fileName + ".png";
            File destFile = new File(screenshotPath);
            destFile.getParentFile().mkdirs();
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("[Screenshot] Saved: " + destFile.getAbsolutePath());
            return screenshotPath;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


