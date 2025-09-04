package JBWindows.SYS;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonClass.BaseClass;
import io.appium.java_client.windows.WindowsDriver;

public class Login extends BaseClass {

    private WindowsDriver<WebElement> driver;
    private static WebDriverWait wait;

    @FindBy(xpath = "//*[@AutomationId='txtUserID']") private WebElement txtUserName;
    @FindBy(xpath = "//*[@AutomationId='passwordBox']") private WebElement txtPassword;
    @FindBy(name = "Sign In") private WebElement btnSignIn;
    @FindBy(id = "btnExit") private static WebElement btnExit;
    @FindBy(id = "LookUpLanguage")private WebElement LookUpLanguage;
    @FindBy(id = "chkRememberMe")private WebElement chkRememberMe;
    @FindBy(id = "linkForgotPassword")private WebElement linkForgotPassword;
    @FindBy(id = "btnClose")private WebElement btnClose;
    @FindBy(id = "label1")private WebElement lblCopyrightStatement;
    @FindBy(id = "imgAppLogo")private WebElement pic_JB_LOGO;
    @FindBy(id = "PanelGroup")private WebElement lblSubscriptionExpiryStatement;
    @FindBy(name = "Warning")private WebElement Warning;
    @FindBy(name = "lblMessage")private WebElement InvalidCredentialMsg;
    @FindBy(name = "MessageBoxEffia")private WebElement InvalidCredentialMsgBox;
   

    public Login(WindowsDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }
    
	public Login enterUserName(String username) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(txtUserName));
            fnWriteSteps("INFO", "Username field found and enabled");
			txtUserName.clear();
			txtUserName.sendKeys(username);
			fnWriteSteps("PASS", "Entered username: " + username);
		} catch (Exception e) {
			fnWriteSteps("FAIL", "Failed to enter username");
			throw new RuntimeException("Failed to enter username", e);
		}
		return this;
	}
    
	public Login enterPassword(String password) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(txtPassword));
            fnWriteSteps("INFO", "Password field found and enabled");
            txtPassword.click();
            txtPassword.clear();
            txtPassword.sendKeys(password);
            fnWriteSteps("PASS", "Entered password");
        } catch (Exception e) {
        	fnWriteSteps("FAIL", "Failed to enter password");
        }
        return this;
    }

    public Login clickSignInBtn() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnSignIn));
            fnWriteSteps("INFO", "Clicking Sign In button");
            new Actions(driver).moveToElement(btnSignIn).click().perform();
        } catch (Exception e) {
        	fnWriteSteps("FAIL", "Failed to click Sign In button");
        }
        return this;
    }
    
    

    public Login fnDoLogin(String username, String password) {
        fnWriteSteps("INFO", "Attempting login with username: " + username);
        
        enterUserName(username);
        enterPassword(password);
        clickSignInBtn();
        
     // In your test, after login success:
        String windowHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(windowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        
        return this;
        
        
    }

    
    public static void safeExitApplication() {
        try {
            // Try to find and click exit button
            wait.until(ExpectedConditions.elementToBeClickable(btnExit));

            if (btnExit != null) {
            	btnExit.click();
                fnWriteSteps("INFO", "Application exited via Exit button");
                return;
            }
            
            // Fallback to Alt+F4
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_ALT);
            fnWriteSteps("INFO", "Application closed via Alt+F4");
            
        } catch (Exception e) {
            fnWriteSteps("WARN", "Application exit failed: " + e.getMessage());
        }
    }


    public boolean verifyLoginFailed() {
        try {
            return InvalidCredentialMsgBox.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    
    
    public void ClickCloseButton() {
    	try {
    		driver.close();
    		fnWriteSteps("PASS","Application closed via driver");
		} catch (Exception e) {
			fnWriteSteps("FAIL","Application close failed: {}");
			throw new RuntimeException("Could not close application", e);
		}
    }
    
      
    
}
