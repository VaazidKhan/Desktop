package wpf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonClass.BaseClass;
import io.appium.java_client.windows.WindowsDriver;

public class DashboardPage extends BaseClass {
    private WindowsDriver driver;
    private WebDriverWait wait;

    private By menuFldBy = By.xpath("//*[@AutomationId='btnMenu']");
    private By logoutBtnBy = By.name("Logout");
    private By btnYesBy = By.xpath("//*[@AutomationId='btnYes']");

    public DashboardPage(WindowsDriver driver) {
    	fnWriteSteps("INFO", "Entering DashboardPage constructor");
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15); // increase timeout
        PageFactory.initElements(driver, this);
    }

    public boolean isLoaded() {
        try {
            WebElement menu = wait.until(ExpectedConditions.presenceOfElementLocated(menuFldBy));
            fnWriteSteps("INFO", "✅ Dashboard loaded, menu button found");
            return menu.isDisplayed();
        } catch (Exception e) {
        	fnWriteSteps("FAIL", "❌ Dashboard did not load properly");
            return false;
        }
    }

    public DashboardPage clickMenuBtn() {
        try {
            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuFldBy));
            fnWriteSteps("INFO", "Clicking Menu button");
            new Actions(driver).moveToElement(menu).click().perform();
            fnWriteSteps("PASS", "Clicked Menu button");

        } catch (Exception e) {
        	fnWriteSteps("FAIL", "Failed to click menu button");
            throw e;
        }
        return this;
    }

    public DashboardPage clickLogoutBtn() {
        try {
            WebElement logOut = wait.until(ExpectedConditions.elementToBeClickable(logoutBtnBy));
            fnWriteSteps("INFO", "Clicking Logout button");
            new Actions(driver).moveToElement(logOut).click().perform();
            fnWriteSteps("PASS", "Clicked Logout button");


            WebElement yesBtn = wait.until(ExpectedConditions.elementToBeClickable(btnYesBy));
            fnWriteSteps("INFO", "Confirming logout");
            new Actions(driver).moveToElement(yesBtn).click().perform();
            fnWriteSteps("PASS", "Logout COnfirmed");

        } catch (Exception e) {
        	fnWriteSteps("FAIL", "Failed to click Logout button");
            throw e;
        }
        return this;
    }

    public DashboardPage logout() {
        if (isLoaded()) {
            clickMenuBtn();
            clickLogoutBtn();
        } else {
        	fnWriteSteps("FAIL", "❌ Dashboard not loaded, cannot logout");
        }
        return this;
    }
}
