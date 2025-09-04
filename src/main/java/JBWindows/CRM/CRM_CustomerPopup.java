package JBWindows.CRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class CRM_CustomerPopup extends BaseClass {

	@FindBy(id = "CRM_CustomerPopup")
	WebElement pageName;
	@FindBy(id = "picClose")
	WebElement BtnClose;
	@FindBy(id = "txtSearch")
	WebElement txtSearch;
	@FindBy(id = "cboCustomerType")
	WebElement cboCustomerType;
	@FindBy(id = "txtFirstName")
	WebElement txtFirstName;
	@FindBy(id = "txtLastName")
	WebElement txtLastName;
	@FindBy(id = "txtPhoneNo")
	WebElement txtPhoneNo;
	@FindBy(id = "txtEmail")
	WebElement txtEmail;
	@FindBy(id = "txtDoorNo")
	WebElement txtDoorNo;
	@FindBy(id = "txtStreetName")
	WebElement txtStreetName;
	@FindBy(id = "txtArea")
	WebElement txtArea;
	@FindBy(id = "lookupState")
	WebElement lookupState;
	@FindBy(id = "lookupCity")
	WebElement lookupCity;
	@FindBy(id = "txtZipCode")
	WebElement txtZipCode;
	@FindBy(id = "memoBillingAddress")
	WebElement memoBillingAddress;
	@FindBy(id = "cboSubOrderType")
	WebElement cboSubOrderType;
	@FindBy(id = "btnCancel")
	WebElement BtnCancel;
	@FindBy(id = "btnSave")
	WebElement BtnSave;

	public CRM_CustomerPopup() {
		PageFactory.initElements(driver, this);
	}

	public void activatePage() {
		pageName.click();
	}

	public void clickCloseButton() {
		BtnClose.click();
	}

	public void clickCancelButton() {
		BtnCancel.click();
	}

	public void clickSaveButton() {
		BtnSave.click();
	}

	// ---21-April-2018--Added by Moumita--------
	// This is the method to create customer at runtime, while doing the transaction
	// Parameter is rowNumber
	public void fnRuntimeCustomerCreation(int rowNumber) {

		if (ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", rowNumber, 2)
				.equals("B2C")) {
			cboCustomerType.sendKeys("B2C");
			cboCustomerType.click();

		} else {
			cboCustomerType.sendKeys("B2B");
			cboCustomerType.click();
		}
		if (txtFirstName.isDisplayed()) {
			txtFirstName.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", rowNumber, 0));
		} else {
			fnWriteSteps("Fail", "First Name field is not enable");
		}
		if (txtLastName.isDisplayed()) {
			txtLastName.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", rowNumber, 1));
		} else {
			fnWriteSteps("Fail", "Last Name field is not enable");
		}
		if (txtPhoneNo.isDisplayed()) {
			txtPhoneNo.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", rowNumber, 3));
		} else {
			fnWriteSteps("Fail", "Phone No field is not enable");
		}
		if (txtEmail.isDisplayed()) {
			txtEmail.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", rowNumber, 5));
		} else {
			fnWriteSteps("Fail", "Email field is not enable");
		}
		if (txtDoorNo.isDisplayed()) {
			txtDoorNo.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", rowNumber, 8));
		} else {
			fnWriteSteps("Fail", "Door No field is not enable");
		}
		if (txtStreetName.isDisplayed()) {
			txtStreetName.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", rowNumber, 9));
		} else {
			fnWriteSteps("Fail", "Street name field is not enable");
		}
		if (txtArea.isDisplayed()) {
			txtArea.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", rowNumber, 10));
		} else {
			fnWriteSteps("Fail", "Area field is not enable");
		}
		if (txtZipCode.isDisplayed()) {
			txtZipCode.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", rowNumber, 11));
		} else {
			fnWriteSteps("Fail", "Zip code field is not enable");
		}
		if (lookupState.isDisplayed()) {
			lookupState.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", rowNumber, 12));
			lookupState.click();
		} else {
			fnWriteSteps("Fail", "State field is not enable");
		}
		if (lookupCity.isDisplayed()) {
			lookupCity.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", rowNumber, 13));
			lookupCity.click();
		} else {
			fnWriteSteps("Fail", "City field is not enable");
		}
		if (memoBillingAddress.isDisplayed()) {
			memoBillingAddress.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", rowNumber, 14));
		} else {
			fnWriteSteps("Fail", "Billing Address field is not enable");
		}

		clickSaveButton();
		GenericMethods.fnwait(2);
		fnWriteSteps("Pass", "Customer has been created at runtime successfully");

	}

	// ---25-April-2018--Added by Moumita--------
	// This is the method to select the existing customer, while doing the transaction
	// Parameter is rowNumber
	public void fnExistingCustomerSelection(int rowNumber) {		
		txtSearch.sendKeys(
				ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", rowNumber, 26));		
		txtSearch.submit();
	}

}
