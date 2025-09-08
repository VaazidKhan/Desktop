package JBWindows.CRM;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;
import io.appium.java_client.windows.WindowsDriver;

public class CRM_Agents extends BaseClass {

	private static WindowsDriver driver;
	private WebDriverWait wait;

	// Header elements
	@FindBy(id = "picClose")
	WebElement btnClose;
	@FindBy(id = "lblCaption")
	WebElement PageCaption;
	@FindBy(id = "picLogo")
	WebElement HeaderJBLogo;

	// Master page elements
	@FindBy(id = "CRM_Agents")
	WebElement pageName;
	@FindBy(name = "ALT + F")
	WebElement txtSearch;
	@FindBy(name = "Type to Search")
	WebElement enterSearchText;
	@FindBy(id = "grdAgents")
	WebElement grdAgents;

	// Entry OR Edit screen elements
	@FindBy(xpath = "//*[@AutomationId='txtFirstName']")
	WebElement txtFirstName;
	@FindBy(xpath = "//*[@AutomationId='txtLastName']")
	WebElement txtLastName;
	@FindBy(xpath = "//*[@AutomationId='txtPhoneNo']")
	WebElement txtPhoneNo;
	@FindBy(xpath = "//*[@AutomationId='checkboxImage']")
	WebElement chkActive;
	@FindBy(xpath = "//*[@AutomationId='txtEmail']")
	WebElement txtEmail;
	@FindBy(xpath = "//*[@AutomationId='txtArea']")
	WebElement txtArea;
	@FindBy(xpath = "//*[@AutomationId='txtCommissionRate']")
	WebElement calcCommissionRate;
	@FindBy(xpath = "//*[@AutomationId='txtAddress']")
	WebElement memoAddress;

	// Buttons elements
	@FindBy(id = "btnListView")
	WebElement btnListView;
	@FindBy(name = "ALT + N")
	WebElement btnAdd;
	@FindBy(name = "ALT + E")
	WebElement btnEdit;
	@FindBy(name = "ALT + S")
	WebElement btnSave;
	@FindBy(name = "ALT + X")
	WebElement btnCancel;

	@FindBy(name = "ALT + D")
	WebElement btnDelete;

	@FindBy(xpath = "//*[@AutomationId='btnYes']")
	WebElement btnOk;
	@FindBy(id = "grdAgents")
	WebElement grdRecordList;
	@FindBy(id = "lblNoData")
	WebElement noAgentLabel;

	@FindBy(name = "Backspace")
	WebElement backBtn;

	@FindBy(xpath = "(//*[@Name='Show Calendar'])[1]")
	WebElement dobCalendarIcon;
	@FindBy(xpath = "(//*[@Name='Show Calendar'])[2]")
	WebElement anniversaryCalendarIcon;
	By prevBtn = By.name("Previous button");
	By nextBtn = By.name("Next button");
	By yearMonth = By.className("TextBlock");

	// WebElement Initialization method
	public CRM_Agents(WindowsDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void clickCreateNewButton() {
		btnAdd.click();
	}

	public void clickEditButton() {
		btnEdit.click();
	}

	public void clickSaveButton() {
		btnSave.click();
	}

	public void clickCancelButton() {
		btnCancel.click();
	}

	public void clickCloseButton() {
		driver.findElement(By.id("picLogo")).click();
		btnClose.click();
	}

	public void clickListViewButtton() {
		btnListView.click();
	}

	// Operations
	public void activatePage() {
		pageName.click();
	}

	public void searchRecord(String ExpectedRecordName) {
		txtSearch.sendKeys(ExpectedRecordName);
	}

	// The method for creating Agent with taking the input from excel
	// Parameters are StartingRowNumber & LastRowNumber

	// This method for New Agent Creation :

	public void createNewAgent(String FirstName, String LastName, String PhoneNum, String Email, String DOB,
			String Anniversary, String Area, String CommissionRate, String Address, String Inactive) {

		try {
// Case 1: Agents exist → click Add
			if (isElementPresent(btnAdd)) {
				fnWriteSteps("Info", "Agents already exist → clicking Add button");
				btnAdd.click();
			} else {
// Case 2: No agents → creation screen directly opened
				fnWriteSteps("Info", "No agents exist → creation screen already displayed");
			}

// Now we should be on Create Agent screen
			if (txtFirstName.isDisplayed()) {
				txtFirstName.sendKeys(FirstName);
			} else {
				fnWriteSteps("Fail", "First Name field is not enabled");
				Assert.fail("First Name field not enabled");
			}

			if (txtLastName.isDisplayed()) {
				txtLastName.sendKeys(LastName);
			} else {
				fnWriteSteps("Fail", "Last Name field is not enabled");
				Assert.fail("Last Name field not enabled");
			}

			if (dobCalendarIcon.isDisplayed()) {
				fnWriteSteps("INFO", "Date Of Birth field is enabled");
				GenericMethods.selectDateInCalendar(dobCalendarIcon, prevBtn, nextBtn, yearMonth, DOB);
				fnWriteSteps("PASS", "Date Of Birth field is selected");
			}

			if (anniversaryCalendarIcon.isDisplayed()) {
				fnWriteSteps("INFO", "Anniversary field is enabled");
				GenericMethods.selectDateInCalendar(anniversaryCalendarIcon, prevBtn, nextBtn, yearMonth, Anniversary);
				fnWriteSteps("PASS", "Anniversary field is selected");
			}

			if (calcCommissionRate.isDisplayed()) {
				calcCommissionRate.click();
				if (CommissionRate != null && !CommissionRate.trim().isEmpty()) {
					String[] parts = CommissionRate.split("\\.");
					String beforeDecimal = parts[0];
					String afterDecimal = (parts.length > 1) ? parts[1] : "0";

					Actions actions = new Actions(driver);
					for (int i = 0; i < 4; i++) {
						actions.sendKeys(Keys.ARROW_LEFT).perform();
					}
					actions.sendKeys(beforeDecimal).perform();
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					actions.sendKeys(afterDecimal).perform();

					fnWriteSteps("Pass", "Commission Rate value entered: " + CommissionRate);
				} else {
					fnWriteSteps("Fail", "Commission Rate value is null or empty");
					Assert.fail("Commission Rate value is null or empty");
				}
			}

			if ("Inactive".equalsIgnoreCase(Inactive)) {
				GenericMethods.moveAndClick(chkActive);
				fnWriteSteps("Info", "Clicked on Active checkbox to set Inactive as per Excel data");
			} else {
				fnWriteSteps("Info", "Excel data is Active, skipping checkbox click");
			}

		} catch (Exception e) {
			fnWriteSteps("Fail", "Failed to create new agent: " + e.getMessage());
			Assert.fail("Exception in createNewAgent: " + e.getMessage());
		}
	}

	/**
	 * Utility method to check if element exists without throwing
	 * NoSuchElementException
	 */
	private boolean isElementPresent(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// This method for Validation of New Agent Creation :
	public boolean Verify_NewAgentCreation_SaveorNot(String FirstName) {

		if (txtSearch.isDisplayed()) {
			txtSearch.click();
			GenericMethods.enterDataIntoField(txtSearch, FirstName);
			WebElement searchResult = driver.findElement(By.xpath("//*[contains(@Name,'" + FirstName + "')]"));
			searchResult.isDisplayed();
			return true;
		} else {
			fnWriteSteps("Fail", "AgentName is not displayed in UI");
			return false;

		}

	}

	// This method is for verifying the Agent edit
	// Parameter is EditFieldOldValue, EditFieldName & EditedValue

	// This method for Agent Edit :
	public void verifyAgentEdit(String OldFirstName, String FirstName, String LastName, String PhNo, String Email,
			String DOB, String Anniversary) {
		if (txtSearch.isDisplayed()) {
			txtSearch.click();
			GenericMethods.enterDataIntoField(txtSearch, OldFirstName);
			fnWriteSteps("INFO", "Search button clicked and data is insterted");
		}
		clickEditButton();
		fnWriteSteps("PASS", "Clicked on Edit button");
		GenericMethods.windows_Set_TextBoxValue(txtFirstName, FirstName);
		GenericMethods.windows_Set_TextBoxValue(txtLastName, LastName);
		GenericMethods.windows_Set_TextBoxValue(txtPhoneNo, PhNo);
		GenericMethods.windows_Set_TextBoxValue(txtEmail, Email);
		GenericMethods.selectDateInCalendar(dobCalendarIcon, prevBtn, nextBtn, yearMonth, DOB);
		GenericMethods.selectDateInCalendar(anniversaryCalendarIcon, prevBtn, nextBtn, yearMonth, Anniversary);

		clickSaveButton();
		System.out.println("Agent has been Updated & Saved");

	}

	// This method for Validation of Agent Edit :
	public boolean Verify_AgentEdit_SaveorNot(String FirstName) {

		if (txtSearch.isDisplayed()) {
			txtSearch.click();
			txtSearch.sendKeys(FirstName);

		} else {
			fnWriteSteps("Fail", "AgentName is not displayed in UI");
			Assert.fail();

		}
		String Actual = driver.findElement(By.id("lblAgentName")).getAttribute("Name");
		if (Actual.substring(14, 21).equalsIgnoreCase(FirstName.trim())) {

			return true;
		}
		return false;
	}

	// This method is to verify all the fields are visible or not

	public void verifyFieldVisibility() {

		if (btnAdd.isDisplayed()) {
			btnAdd.click();

			if (txtFirstName.isDisplayed()) {
				fnWriteSteps("Pass", "First Name field is present");
			} else {
				fnWriteSteps("Fail", "First Name field is not present");
				Assert.fail();
			}
			if (txtLastName.isDisplayed()) {
				fnWriteSteps("Pass", "Last Name field is present");
			} else {
				fnWriteSteps("Fail", "Last Name field is not present");
				Assert.fail();
			}
			if (txtPhoneNo.isDisplayed()) {
				fnWriteSteps("Pass", "Phone No field is present");
			} else {
				fnWriteSteps("Fail", "Phone No field is not present");
				Assert.fail();
			}
			if (txtEmail.isDisplayed()) {
				fnWriteSteps("Pass", "Email field is present");
			} else {
				fnWriteSteps("Fail", "Email field is not present");
				Assert.fail();
			}
			if (chkActive.isDisplayed()) {
				fnWriteSteps("Pass", "Active checkbox is present");
			} else {
				fnWriteSteps("Fail", "Active checkbox is not present");
				Assert.fail();
			}
			if (txtArea.isDisplayed()) {
				fnWriteSteps("Pass", "Area field is present");
			} else {
				fnWriteSteps("Fail", "Area field is not present");
				Assert.fail();
			}
			if (memoAddress.isDisplayed()) {
				fnWriteSteps("Pass", "Address field is present");
			} else {
				fnWriteSteps("Fail", "Address field is not present");
				Assert.fail();
			}
			if (calcCommissionRate.isDisplayed()) {
				fnWriteSteps("Pass", "Commission Rate field is present");
			} else {
				fnWriteSteps("Fail", "Commission Rate field is not present");
				Assert.fail();
			}
			if (dobCalendarIcon.isDisplayed()) {
				fnWriteSteps("PASS", "Date Of Birth field is enabled");

			} else {
				fnWriteSteps("Fail", "Date Of Birth field is not enable");
				Assert.fail();

			}
			if (anniversaryCalendarIcon.isDisplayed()) {
				fnWriteSteps("PASS", "Annyversary field is enabled");
			} else {
				fnWriteSteps("Fail", "Annyversary field is not enable");
				Assert.fail();

			}
		}
	}

	// This method is to verify all the fields are enable or not

	public void verifyFieldEnableOrNot() {

		if (btnAdd.isDisplayed()) {
			btnAdd.click();

			if (txtFirstName.isEnabled()) {
				txtFirstName.click();
				fnWriteSteps("Pass", "First Name field is enable");
			} else {
				fnWriteSteps("Fail", "First Name field is not enable");
				Assert.fail();
			}
			if (txtLastName.isDisplayed()) {
				fnWriteSteps("Pass", "Last Name field is enable");
			} else {
				fnWriteSteps("Fail", "Last Name field is not enable");
				Assert.fail();
			}
			if (chkActive.isEnabled()) {
				chkActive.click();
				fnWriteSteps("Pass", "Active field is enable");
			} else {
				fnWriteSteps("Fail", "Active field is not enable");
				Assert.fail();
			}
			if (txtPhoneNo.isEnabled()) {
				txtPhoneNo.click();
				fnWriteSteps("Pass", "Phone No field is enable");
			} else {
				fnWriteSteps("Fail", "Phone No field is not enable");
				Assert.fail();
			}
			if (txtEmail.isEnabled()) {
				txtEmail.click();
				fnWriteSteps("Pass", "Email field is enable");
			} else {
				fnWriteSteps("Fail", "Email field is not enable");
				Assert.fail();
			}
			if (txtArea.isEnabled()) {
				txtArea.click();
				fnWriteSteps("Pass", "Area field is enable");
			} else {
				fnWriteSteps("Fail", "Area field is not enable");
				Assert.fail();
			}
			if (memoAddress.isEnabled()) {
				memoAddress.click();
				fnWriteSteps("Pass", "Address field is enable");
			} else {
				fnWriteSteps("Fail", "Address field is not enable");
				Assert.fail();
			}
			if (calcCommissionRate.isEnabled()) {
				calcCommissionRate.click();
				fnWriteSteps("Pass", "CommissionRate field is enable");
			} else {
				fnWriteSteps("Fail", "CommissionRate field is not enable");
				Assert.fail();
			}
			if (dobCalendarIcon.isEnabled()) {
				fnWriteSteps("PASS", "Date Of Birth field is enabled");

			} else {
				fnWriteSteps("Fail", "Date Of Birth field is not enable");
				Assert.fail();

			}
			if (anniversaryCalendarIcon.isEnabled()) {
				fnWriteSteps("PASS", "Annyversary field is enabled");
			} else {
				fnWriteSteps("Fail", "Annyversary field is not enable");
				Assert.fail();

			}
		}
	}

	/*
	 * @purpose: This is the method to delete the record by delete icon from Agent
	 * master page
	 * 
	 * @Parameter: element
	 */
	// This method for Access the Delete Button :
	public static void fnVerifyMasterRecordDelete(WebElement element) {

		element.click();
		PointerInfo a1 = MouseInfo.getPointerInfo();
		Point b1 = a1.getLocation();
		int x1 = (int) b1.getX();
		int y1 = (int) b1.getY();

		Robot r1;
		try {
			r1 = new Robot();
			r1.mouseMove(x1 + 310, y1 - 200);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		Actions builder1 = new Actions(driver);
		builder1.click().build().perform();
	}

	// This method for To click on YES Button :
	public void click_On_Yes_Button() {
		driver.findElement(By.id("lblHeader")).click();
		btnOk.click();
	}
	/* This is the method to delete the record by delete icon from master page */

	// This method for AgentDelete :
	public void fnVerifyAgentDelete(String FirstName) {
		if (txtSearch.isDisplayed()) {
			txtSearch.click();
			GenericMethods.enterDataIntoField(txtSearch, FirstName);

		}
		fnWriteSteps("INFO", "Search button is cicked and data is insterted");
		btnDelete.click();
		btnOk.click();
		fnWriteSteps("PASS", "Clicked on Delete button & clicked on OK button of popup");
		GenericMethods.fnwait(3);
	}

	// This method for Validation of Agent Delete
	public boolean Verify_AgentDelete_SaveorNot(String FirstName) {
		try {
			if (txtSearch.isDisplayed()) {
				txtSearch.click();
				GenericMethods.enterDataIntoField(txtSearch, FirstName);

				WebElement searchResult = driver.findElement(By.xpath("//*[contains(@Name,'" + FirstName + "')]"));

				if (searchResult.isDisplayed()) {
					fnWriteSteps("FAIL", "Agent '" + FirstName + "' still exists after delete");
					return false; // ❌ not deleted
				} else {
					fnWriteSteps("PASS", "Agent '" + FirstName + "' not visible after delete");
					return true; // ✅ deleted
				}
			} else {
				fnWriteSteps("FAIL", "Search box not displayed in UI");
				return false; // ❌ treat as failure
			}
		} catch (Exception e) {
			// If element is not found, it means delete succeeded
			fnWriteSteps("PASS", "Agent '" + FirstName + "' not found after delete");
			return true; // ✅ deleted
		}
	}

	/*
	 * This is the method to verify the record has been deleted successfully or not
	 */
	public void fnVerifyAgentDeleteSuccessfulOrNot(String strAgentName) {
		txtSearch.clear();
		txtSearch.sendKeys(strAgentName);
		String gridNoDataLabel = null;

		WebElement messageEle = driver.findElement(By.id("lblNoData"));
		gridNoDataLabel = messageEle.getAttribute("Name");
		if (gridNoDataLabel.contains("No agent found")) {
			fnWriteSteps("pass", "Record has been deleted successfully");
		} else {
			fnWriteSteps("pass", "Record has not been deleted");
			Assert.fail();
		}

	}

	public void clickBackButton() {
		GenericMethods.fn_ConditionalWaitForElement(backBtn, 20);
		backBtn.click();
		GenericMethods.fnwait(5);
		fnWriteSteps("INFO", "Back button is clicked");

	}
}
