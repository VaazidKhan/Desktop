package JBWindows.INV;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class INV_MeasurementUnit extends BaseClass {
	// Header elements
	@FindBy(id = "picClose")
	WebElement btnClose;
	@FindBy(id = "lblCaption")
	WebElement PageCaption;
	@FindBy(id = "picLogo")
	WebElement HeaderJBLogo;

	// Master page elements
	@FindBy(id = "INV_MeasurementUnit")
	WebElement pageName;
	@FindBy(id = "TxtSearch")
	WebElement TxtSearch;

	// Entry OR Edit screen elements
	@FindBy(id = "txtUnit")
	WebElement txtUnit;
	@FindBy(id = "txtUnitCode")
	WebElement txtUnitCode;
	@FindBy(id = "lookUpBaseUnit")
	WebElement lookUpBaseUnit;
	@FindBy(id = "chkActive")
	WebElement chkActive;
	@FindBy(id = "chkAllowFractionalQuantity")
	WebElement chkAllowFractionalQuantity;

	// Buttons elements
	@FindBy(id = "btnAdd")
	WebElement btnAdd;
	@FindBy(id = "btnSave")
	WebElement btnEdit;
	@FindBy(id = "btnSave")
	WebElement btnSave;
	@FindBy(id = "btnCancel")
	WebElement btnCancel;
	
	/* 2-July-18-----Added by Moumita */
	@FindBy(id = "grdUnit")
	WebElement grdRecordList;
	@FindBy(id = "lblNoData")
	WebElement noUnitLabel; 

	// WebElement Initialization method
	public INV_MeasurementUnit() {
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
		btnClose.click();
	}

	// Operations
	public void activatePage() {
		pageName.click();
	}

	// ----------1-Feb-2018----added by Moumita---------------
	// The method for creating Measurement Unit with taking the input from excel
	// Parameters are StartingRowNumber & LastRowNumber
	public void createNewMeasurementUnit(int StartingRowNumber, int LastRowNumber) {
		for (int StartFrom = StartingRowNumber; StartFrom <= LastRowNumber; StartFrom++) {
			try {
				if (txtUnit.isDisplayed()) {
					txtUnit.sendKeys(
							ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Unit", StartFrom, 0));
				} else {
					fnWriteSteps("Fail", "Unit is not enable");
				}
				if (txtUnitCode.isDisplayed()) {
					txtUnitCode.sendKeys(
							ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Unit", StartFrom, 1));
				} else {
					fnWriteSteps("Fail", "Unit code field is not enable");
				}
				if (lookUpBaseUnit.isDisplayed()) {
					lookUpBaseUnit.sendKeys(
							ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Unit", StartFrom, 2));
					lookUpBaseUnit.click();
				} else {
					fnWriteSteps("Fail", "Base Unit field is not enable");
				}
				if (chkActive.isSelected()) {
					fnWriteSteps("Pass", "Active checkbox is checked by default ");
				} else {
					fnWriteSteps("Fail", "Active checkbox is not checked by default ");
				}
				if (chkAllowFractionalQuantity.isSelected()) {
					fnWriteSteps("Pass", "Allow Fractional Quantity checkbox is checked by default ");
				} else {
					fnWriteSteps("Fail", "Allow Fractional Quantity checkbox is not checked by default ");
				}

				btnSave.click();
				GenericMethods.fnwait(1);
				fnWriteSteps("Pass", "Measurement Unit has been created successfully");
			} catch (Exception e) {
				fnWriteSteps("Fail", "Measurement Unit has not been created successfully");
			}
			clickCreateNewButton();
		}
		clickCancelButton();
	}

	// This method is for verifying the Measurement Unit has been saved or not
	// Parameters are StartingRowNumber & LastRowNumber
	public void verifyMeasurementUnitSavedOrNot(int StartingRowNumber, int LastRowNumber) throws IOException {
		for (int StartFrom = StartingRowNumber; StartFrom <= LastRowNumber; StartFrom++) {
			TxtSearch.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Unit", StartFrom, 0));
			clickEditButton();

			try {
				if (txtUnit.getText().equals(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Unit", StartFrom, 0))) {
					fnWriteSteps("Pass", "Unit Name is saved successfully");
				} else {
					fnWriteSteps("Fail", "Unit Name is not saved");
				}
				if (txtUnitCode.getText().equals(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Unit", StartFrom, 1))) {
					fnWriteSteps("Pass", "Unit code is saved successfully");
				} else {
					fnWriteSteps("Fail", "Unit code is not saved");
				}

				clickSaveButton();
				GenericMethods.fnwait(1);
				fnWriteSteps("Pass", "Measurement Unit is saved successfully");

			} catch (Exception e) {
				fnWriteSteps("Fail", "Measurement Unit is not saved successfully");
			}
		}
	}

	// This method is for verifying the Measurement Unit edit
	// Parameter is EditFieldOldValue, EditFieldName & EditedValue
	public void verifyMeasurementUnitEdit(String EditFieldOldValue, String EditFieldName, String EditedValue) {
		TxtSearch.sendKeys(EditFieldOldValue);
		clickEditButton();
		GenericMethods.fnwait(1);
		switch (EditFieldName.toLowerCase()) {
		case "unit":
			txtUnit.clear();
			txtUnit.sendKeys(EditedValue);
			break;
		}
		clickSaveButton();

		TxtSearch.sendKeys(EditedValue);
		clickEditButton();
		GenericMethods.fnwait(1);
		switch (EditFieldName.toLowerCase()) {
		case "unit":
			if (txtUnit.getText().equals(EditedValue)) {
				fnWriteSteps("Pass", "Measurement Unit edit is successful");
			} else {
				fnWriteSteps("Fail", "Measurement Unit edit is not successful");
			}

		}
	}

	// ---------3-Feb-2018 added by Moumita-------------------
	// This method is to verify all the fields are visible or not

	public void verifyFieldVisibility() {
		if (txtUnit.isDisplayed()) {
			fnWriteSteps("Pass", "Unit Name field is present");
		} else {
			fnWriteSteps("Fail", "Unit Name field is not present");
		}
		if (txtUnitCode.isDisplayed()) {
			fnWriteSteps("Pass", "Unit code Type field is present");
		} else {
			fnWriteSteps("Fail", "Unit code Type field is not present");
		}
		if (lookUpBaseUnit.isDisplayed()) {
			fnWriteSteps("Pass", "Base Unit field is present");
		} else {
			fnWriteSteps("Fail", "Base Unit field is not present");
		}
		if (chkActive.isDisplayed()) {
			fnWriteSteps("Pass", "Active checkbox is present");
		} else {
			fnWriteSteps("Fail", "Active checkbox is not present");
		}
		if (chkAllowFractionalQuantity.isDisplayed()) {
			fnWriteSteps("Pass", "Allow Fractional Quantity checkbox is present");
		} else {
			fnWriteSteps("Fail", "Allow Fractional Quantity checkbox is not present");
		}
	}

	// This method is to verify all the fields are enable or not

	public void verifyFieldEnableOrNot() {
		if (txtUnit.isEnabled()) {
			txtUnit.click();
			fnWriteSteps("Pass", "Unit Name field is enable");
		} else {
			fnWriteSteps("Fail", "Unit Name field is not enable");
		}
		if (txtUnitCode.isEnabled()) {
			txtUnitCode.click();
			fnWriteSteps("Pass", "Unit code Type field is enable");
		} else {
			fnWriteSteps("Fail", "Unit code Type field is not enable");
		}
		if (lookUpBaseUnit.isEnabled()) {
			lookUpBaseUnit.click();
			fnWriteSteps("Pass", "Base Unit field is enable");
		} else {
			fnWriteSteps("Fail", "Base Unit field is not enable");
		}
		if (chkActive.isEnabled()) {
			chkActive.click();
			fnWriteSteps("Pass", "Active field is enable");
		} else {
			fnWriteSteps("Fail", "Active field is not enable");
		}
		if (chkAllowFractionalQuantity.isEnabled()) {
			chkAllowFractionalQuantity.click();
			fnWriteSteps("Pass", "Allow Fractional Quantity checkbox is enable");
		} else {
			fnWriteSteps("Fail", "Allow Fractional Quantity checkbox is not enable");
		}
	}

	/*
	 *2-July-18-----Added by Moumita
	 * @purpose: This is the method to delete the record by delete icon from
	 * Measurement Unit master page 
	 * @Parameter: element
	 */
	public static void fnVerifyMasterRecordDelete(WebElement element) {

		GenericMethods.fnwait(1);
		element.click();
		PointerInfo a1 = MouseInfo.getPointerInfo();
		Point b1 = a1.getLocation();
		GenericMethods.fnwait(1);
		int x1 = (int) b1.getX();
		GenericMethods.fnwait(1);
		int y1 = (int) b1.getY();

		Robot r1;
		try {
			r1 = new Robot();
			r1.mouseMove(x1 + 395, y1 - 210);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		GenericMethods.fnwait(1);
		Actions builder1 = new Actions(driver);
		builder1.click().build().perform();
	}

	/* 2-July-18-----Added by Moumita */
	/* This is the method to delete the record by delete icon from master page */
	public void fnVerifyMeasurementUnitDelete(String strUnitName) {
		TxtSearch.sendKeys(strUnitName);
		GenericMethods.fnwait(1);
		fnVerifyMasterRecordDelete(grdRecordList);
	}

	/* 28-June-18-----Added by Moumita */
	/*
	 * This is the method to verify the record has been deleted successfully or not
	 */
	public void fnVerifyMeasurementUnitDeleteSuccessfulOrNot(String strUnitName) {
		TxtSearch.clear();
		TxtSearch.sendKeys(strUnitName);
		String gridNoDataLabel = null;

		WebElement messageEle = driver.findElement(By.id("lblNoData"));
		gridNoDataLabel = messageEle.getAttribute("Name");
		if (gridNoDataLabel.contains("No measurement unit found")) {
			fnWriteSteps("pass", "Record has been deleted successfully");
		} else {
			fnWriteSteps("pass", "Record has not been deleted");
		}

	}
}
