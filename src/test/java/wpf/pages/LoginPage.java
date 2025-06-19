// Updated LoginPage.java with retry locators, element dump, and entry log
package wpf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.windows.WindowsDriver;
import reusableComponents.LoggerUtils;

import java.util.List;
import java.util.Set;

public class LoginPage {
    private WindowsDriver driver;
    private WebDriverWait wait;

    private WebElement userNameTxtFld;
    private WebElement passwordTxtFld;
    private WebElement signIn;

    public LoginPage(WindowsDriver driver) {
        LoggerUtils.info("⏳ Entering LoginPage constructor");
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

        try {
            switchToMainWindow();
            Thread.sleep(1000);

            boolean found = false;
            for (int attempt = 1; attempt <= 5; attempt++) {
                LoggerUtils.info("Attempt " + attempt + ": Checking for Edit and Button fields...");

                List<WebElement> edits = driver.findElements(By.className("Edit"));
                LoggerUtils.info("Total Edit fields: " + edits.size());
                for (int i = 0; i < edits.size(); i++) {
                    LoggerUtils.info("Edit[" + i + "]: " + edits.get(i).getAttribute("Name") + " | AutomationId: " + edits.get(i).getAttribute("AutomationId"));
                }

                List<WebElement> buttons = driver.findElements(By.className("Button"));
                LoggerUtils.info("Total Button fields: " + buttons.size());
                for (WebElement button : buttons) {
                    String name = button.getAttribute("Name");
                    LoggerUtils.info("Button: " + name);
                }

                if (edits.size() >= 2) {
                    userNameTxtFld = edits.get(0);
                    passwordTxtFld = edits.get(1);

                    for (WebElement button : buttons) {
                        String name = button.getAttribute("Name");
                        if (name != null && name.toLowerCase().contains("sign")) {
                            signIn = button;
                            break;
                        }
                    }

                    if (signIn != null) {
                        found = true;
                        break;
                    }
                }
                Thread.sleep(1000);
            }

            if (!found) {
                dumpAllElements();
                throw new RuntimeException("Login controls not found after retries.");
            }

        } catch (Exception e) {
            LoggerUtils.error("Element initialization failed", e);
            throw new RuntimeException("Element initialization failed", e);
        }
    }

    private void switchToMainWindow() {
        try {
            Set<String> handles = driver.getWindowHandles();
            LoggerUtils.info("Window handles count: " + handles.size());
            for (String handle : handles) {
                driver.switchTo().window(handle);
                LoggerUtils.info("Switched to window: " + driver.getTitle());
            }
        } catch (Exception e) {
            LoggerUtils.warn("Failed to switch to main window: " + e.getMessage());
        }
    }

    private void dumpAllElements() {
        try {
            List<WebElement> all = driver.findElements(By.xpath("//*"));
            LoggerUtils.info("Dumping all elements found by //* : Total = " + all.size());
            for (WebElement ele : all) {
                LoggerUtils.info("Tag: " + ele.getTagName()
                        + " | Name: " + ele.getAttribute("Name")
                        + " | AutomationId: " + ele.getAttribute("AutomationId")
                        + " | Class: " + ele.getAttribute("ClassName"));
            }
        } catch (Exception e) {
            LoggerUtils.warn("Unable to dump all elements: " + e.getMessage());
        }
    }

    public LoginPage enterUserName(String userName) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(userNameTxtFld));
            LoggerUtils.info("Username field found and enabled");
            userNameTxtFld.clear();
            userNameTxtFld.sendKeys(userName);
            LoggerUtils.info("Entered username: " + userName);
        } catch (Exception e) {
            LoggerUtils.error("Failed to enter username", e);
        }
        return this;
    }

    public LoginPage enterPassword(String password) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(passwordTxtFld));
            LoggerUtils.info("Password field found and enabled");
            passwordTxtFld.click();
            passwordTxtFld.sendKeys(Keys.CONTROL + "a");
            passwordTxtFld.sendKeys(Keys.DELETE);
            passwordTxtFld.sendKeys(password);
            LoggerUtils.info("Entered password");
        } catch (Exception e) {
            LoggerUtils.error("Failed to enter password", e);
        }
        return this;
    }

    public LoginPage clickSignInBtn() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(signIn));
            LoggerUtils.info("Clicking Sign In button");
            new Actions(driver).moveToElement(signIn).click().perform();
        } catch (Exception e) {
            LoggerUtils.error("Failed to click Sign In button", e);
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
