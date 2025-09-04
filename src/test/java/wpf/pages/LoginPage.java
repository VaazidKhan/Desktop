package wpf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonClass.BaseClass;
import io.appium.java_client.windows.WindowsDriver;

public class LoginPage extends BaseClass{
    private WindowsDriver driver;
    private WebDriverWait wait;
    

    private By userNameTxtFldBy = By.xpath("//*[@AutomationId='txtUserID']");
    private By passwordTxtFldBy = By.xpath("//*[@AutomationId='passwordBox']");
    private By signInBtnBy      = By.name("Sign In");

    public LoginPage(WindowsDriver driver) {
        fnWriteSteps("INFO", "Entering LoginPage constructor");
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }


    public LoginPage enterUserName(String userName) {
        try {
            WebElement userNameTxtFld = wait.until(ExpectedConditions.elementToBeClickable(userNameTxtFldBy));
            fnWriteSteps("INFO", "Username field found and enabled");
            userNameTxtFld.clear();
            userNameTxtFld.sendKeys(userName);
            fnWriteSteps("PASS", "Entered username: " + userName);
        } catch (Exception e) {
            fnWriteSteps("FAIL", "Failed to enter username");
        }
        return this;
    }

    public LoginPage enterPassword(String password) {
        try {
            WebElement passwordTxtFld = wait.until(ExpectedConditions.elementToBeClickable(passwordTxtFldBy));
            fnWriteSteps("INFO", "Password field found and enabled");
            passwordTxtFld.click();
            passwordTxtFld.clear();
            passwordTxtFld.sendKeys(password);
            fnWriteSteps("PASS", "Entered password");
        } catch (Exception e) {
        	fnWriteSteps("FAIL", "Failed to enter password");
        }
        return this;
    }

    public LoginPage clickSignInBtn() {
        try {
            WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(signInBtnBy));
            fnWriteSteps("INFO", "Clicking Sign In button");
            new Actions(driver).moveToElement(signIn).click().perform();
        } catch (Exception e) {
        	fnWriteSteps("FAIL", "Failed to click Sign In button");
        }
        return this;
    }

    public LoginPage login(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickSignInBtn();
        return this;
    }
}