package JBWindows.Configurations;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonClass.BaseClass;
import commonClass.GenericMethods;
import io.appium.java_client.windows.WindowsDriver;

public class Registration_JB extends BaseClass{
	
    private WindowsDriver<WebElement> driver;
    private static WebDriverWait wait;
	
	@FindBy(name = "Existing Organization")
	WebElement existingOrganization;
	
	@FindBy(name = "New Organization")
	WebElement newOrganization;
	
	@FindBy(name = "I Agree")
	WebElement iAgreeBtn;
	
	@FindBy(name = "Disagree")
	WebElement diagreeBtn;

	@FindBy(xpath = "(//*[@Name='Organization Code')[2]")
	private WebElement organizationCode;
	
	@FindBy(xpath = "(//*[@Name='Account CID' and @ClassName='TextBox'])[2]")
	private WebElement accountId;
	
	@FindBy(name = "Verify")
	WebElement verifyBtn;
	
	@FindBy(xpath = "//*[@AutomationId = 'imgProceed']")
	WebElement proceed;


	
    public Registration_JB(WindowsDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }
	
    /**
     * Select Existing Organization
     * @return
     */
	public Registration_JB selectExistingOrganization() {
    	try {
    		GenericMethods.fn_ConditionalWaitForElement(existingOrganization,30);
    		GenericMethods.moveAndClick(existingOrganization);
    		fnWriteSteps("PASS", "Selected Existing Organization");
    	}catch(Exception e) {
    		fnWriteSteps("FAIL", "Failed to select Existing Organization");
			throw new RuntimeException("Failed to click on existing Organization", e);
    	}
		return this;
	}
	
	/**
	 * Select New Organization
	 * @return
	 */
	public Registration_JB selectNewOrganization() {
    	try {
    		GenericMethods.fn_ConditionalWaitForElement(newOrganization,30);
    		GenericMethods.moveAndClick(newOrganization);
    		fnWriteSteps("PASS", "Selected New Organization");
    	}catch(Exception e) {
    		fnWriteSteps("FAIL", "Failed to select New Organization");
			throw new RuntimeException("Failed to click on new Organization", e);
    	}
		return this;
	}
	
	/**
	 * Click on I Agree button
	 * 
	 * @return
	 */
	public Registration_JB clickIAgree() {
		try {
			GenericMethods.fn_ConditionalWaitForElement(iAgreeBtn, 30);
			GenericMethods.moveAndClick(iAgreeBtn);
			fnWriteSteps("PASS", "Clicked on I Agree button");
		} catch (Exception e) {
			fnWriteSteps("FAIL", "Failed to click on I Agree button");
			throw new RuntimeException("Failed to click on I Agree button", e);
		}
		return this;
	}
	
	/**
	 * Click on Disagree button
	 * 
	 * @return
	 */
	public Registration_JB clickDisagree() {
		try {
			GenericMethods.fn_ConditionalWaitForElement(diagreeBtn, 30);
			GenericMethods.moveAndClick(diagreeBtn);
			fnWriteSteps("PASS", "Clicked on Disagree button");
		} catch (Exception e) {
			fnWriteSteps("FAIL", "Failed to click on Disagree button");
			throw new RuntimeException("Failed to click on Disagree button", e);
		}
		return this;
	}
	
	/**
	 * Enter Organization Code
	 * @param orgCode
	 * @return
	 */
	public Registration_JB enterOrganizationCode(String orgCode) {
		try {
			//GenericMethods.fn_ConditionalWaitForElement(organizationCode, 30);
			//GenericMethods.enterDataIntoField(organizationCode, orgCode);
			driver.switchTo().activeElement().sendKeys(orgCode);
			fnWriteSteps("PASS", "Entered Organization Code: " + orgCode);
		} catch (Exception e) {
			fnWriteSteps("FAIL", "Failed to enter Organization Code");
			throw new RuntimeException("Failed to enter Organization Code", e);
		}
		return this;
	}
	
	/**
	 * Enter Account ID
	 * 
	 * @param accountIdValue
	 * @return
	 */
	public Registration_JB enterAccountID(String accountIdValue) {
		try

	{
		//GenericMethods.fn_ConditionalWaitForElement(accountId, 30);
		//GenericMethods.enterDataIntoField(accountId, accountIdValue);
		GenericMethods.fnwait(2);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys(accountIdValue);

		fnWriteSteps("PASS", "Entered Account ID: " + accountIdValue);
	}catch(
	Exception e)
	{
		fnWriteSteps("FAIL", "Failed to enter Account ID");
		throw new RuntimeException("Failed to enter Account ID", e);
	}return this;
	}
	
	/**
	 * Click on Verify button
	 * @return
	 */
	public Registration_JB clickVerify() {
		try {
			GenericMethods.fn_ConditionalWaitForElement(proceed, 30);
			GenericMethods.moveAndClick(proceed);
			fnWriteSteps("PASS", "Clicked on Verify button");
		} catch (Exception e) {
			fnWriteSteps("FAIL", "Failed to click on Verify button");
			throw new RuntimeException("Failed to click on Verify button", e);
		}
		return this;
	}
	
	public Registration_JB fnDORegistartion(String orgCode, String accId) {
		fnWriteSteps("INFO", "Attempting registartion");
		try {
		selectExistingOrganization();
		clickIAgree();
		enterOrganizationCode(orgCode);
		enterAccountID(accId);
		clickVerify();
		}catch (Exception e) {
			fnWriteSteps("FAIL", "Unable to complete registartion");
			throw e;
		}
		return this;
		
	}
}
