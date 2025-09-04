package JBWindows.SAL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class SR_Table extends BaseClass {

	@FindBy(id = "SR_Table")
	WebElement pageName;
	@FindBy(id = "picClose")
	WebElement BtnClose;

	@FindBy(id = "txtSearch")
	WebElement txtSearch;
	@FindBy(id = "lookupTableType")
	WebElement lookupTableType;
	@FindBy(id = "txtTableNo")
	WebElement txtTableNo;
	@FindBy(id = "calcMaximumCapacity")
	WebElement calcMaximumCapacity;
	@FindBy(id = "memoDescription")
	WebElement memoDescription;

	@FindBy(id = "btnCancel")
	WebElement BtnCancel;
	@FindBy(id = "btnSave")
	WebElement btnSave;
	@FindBy(id = "btnAdd")
	WebElement btnAdd;

	/* 2-July-18-----Added by Moumita */
	@FindBy(id = "grdTable")
	WebElement grdRecordList;
	@FindBy(id = "lblNoData")
	WebElement noTableLabel; 

	public SR_Table() {
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
		btnSave.click();
	}

	/*
	 * -----------added by Moumita on 30/May/18--------------- This method is to
	 * create one or multiple table
	 */
	public void fnCreateTable(int startingRowNumber, int lastCountOfRecord) {
		int count = 0;
		for (int startFrom = startingRowNumber; startFrom <= lastCountOfRecord; startFrom++) {
			count = count + 1;
			try {
				if (btnAdd.isDisplayed()) {
					btnAdd.click();

					if (lookupTableType.isDisplayed()) {
						lookupTableType.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
								"Tables", startFrom, 0));
						lookupTableType.click();
					} else {
						fnWriteSteps("Fail", "Table type field is not enable");
					}
					if (txtTableNo.isDisplayed()) {
						txtTableNo.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
								"Tables", startFrom, 1));
					} else {
						fnWriteSteps("Fail", "Table No field is not enable");
					}
					if (calcMaximumCapacity.isDisplayed()) {
						calcMaximumCapacity.sendKeys(ExcelUtils
								.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Tables", startFrom, 2));
					} else {
						fnWriteSteps("Fail", "Maximum capacity field is not enable");
					}
					if (memoDescription.isDisplayed()) {
						memoDescription.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
								"Tables", startFrom, 3));

					} else {
						fnWriteSteps("Fail", "Description field is not enable");
					}
					btnSave.click();
					GenericMethods.fnwait(2);
					fnWriteSteps("Pass", "Table creation is successful " + count);
				}
			} catch (Exception e) {
				if (lookupTableType.isDisplayed()) {
					lookupTableType.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
							"Tables", startFrom, 0));
					lookupTableType.click();
				} else {
					fnWriteSteps("Fail", "Table type field is not enable");
				}
				if (txtTableNo.isDisplayed()) {
					txtTableNo.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Tables",
							startFrom, 1));
				} else {
					fnWriteSteps("Fail", "Table No field is not enable");
				}
				if (calcMaximumCapacity.isDisplayed()) {
					calcMaximumCapacity.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
							"Tables", startFrom, 2));
				} else {
					fnWriteSteps("Fail", "Maximum capacity field is not enable");
				}
				if (memoDescription.isDisplayed()) {
					memoDescription.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
							"Tables", startFrom, 3));

				} else {
					fnWriteSteps("Fail", "Description field is not enable");
				}
				btnSave.click();
				GenericMethods.fnwait(2);
				fnWriteSteps("Pass", "Table creation is successful " + count);

			}
		}
	}

	/*
	 * ------added by Moumita on 27-June-18----------
	 * This method is to verify record has been saved or not
	 */
	public void fnverifyTableSavedOrNot(int startingRowNumber, int lastCountOfRecord) {
		for (int startFrom = startingRowNumber; startFrom <= lastCountOfRecord; startFrom++) {
			txtSearch.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Tables", startFrom, 1));
			GenericMethods.fnwait(1);
			clickSaveButton();

			try {
				/*
				 * Due to technical issue, commented this code if
				 * (lookupTableType.isDisplayed()) {
				 * lookupTableType.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.
				 * MasterExcelPath, "Tables", startFrom, 0)); lookupTableType.click(); } else {
				 * fnWriteSteps("Fail", "Table type field is not enable"); }
				 */

				if (calcMaximumCapacity.getText().equals(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Tables", startFrom, 2))) {
					fnWriteSteps("Pass", "Maximum Capacity is saved successfully");
				} else {
					fnWriteSteps("Fail", "Maximum Capacity is not saved");
				}
				if (memoDescription.getText().equals(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Tables", startFrom, 3))) {
					fnWriteSteps("Pass", "Description is saved successfully");
				} else {
					fnWriteSteps("Fail", "Description is not saved");
				}

				btnSave.click();
				GenericMethods.fnwait(2);
				fnWriteSteps("Pass", "Table has been saved successful");
			} catch (Exception e) {
				fnWriteSteps("Fail", "Table is not saved successfully");
			}
		}
	}

	// --------added by Moumita on 27-June-18-----------
	// This method is to verify all the fields are visible or not

	public void verifyFieldVisibility() {
		try {
			if (btnAdd.isDisplayed()) {
				btnAdd.click();

				if (lookupTableType.isDisplayed()) {
					fnWriteSteps("Pass", "Table Type field is present");
				} else {
					fnWriteSteps("Fail", "Table Type field is not present");
				}
				if (txtTableNo.isDisplayed()) {
					fnWriteSteps("Pass", "Table No field is present");
				} else {
					fnWriteSteps("Fail", "Table No field is not present");
				}
				if (calcMaximumCapacity.isDisplayed()) {
					fnWriteSteps("Pass", "Maximum Capacity field is present");
				} else {
					fnWriteSteps("Fail", "Maximum Capacity field is not present");
				}
				if (memoDescription.isDisplayed()) {
					fnWriteSteps("Pass", "Description field is present");
				} else {
					fnWriteSteps("Fail", "Description field is not present");
				}
			}
		} catch (Exception e) {
			if (lookupTableType.isDisplayed()) {
				fnWriteSteps("Pass", "Table Type field is present");
			} else {
				fnWriteSteps("Fail", "Table Type field is not present");
			}
			if (txtTableNo.isDisplayed()) {
				fnWriteSteps("Pass", "Table No field is present");
			} else {
				fnWriteSteps("Fail", "Table No field is not present");
			}
			if (calcMaximumCapacity.isDisplayed()) {
				fnWriteSteps("Pass", "Maximum Capacity field is present");
			} else {
				fnWriteSteps("Fail", "Maximum Capacity field is not present");
			}
			if (memoDescription.isDisplayed()) {
				fnWriteSteps("Pass", "Description field is present");
			} else {
				fnWriteSteps("Fail", "Description field is not present");
			}
		}
	}

	// --------added by Moumita on 27-June-18-----------
	// This method is to verify all the fields are enable or not

	public void verifyFieldEnableOrNot() {
		try {
			if (btnAdd.isDisplayed()) {
				btnAdd.click();

				if (lookupTableType.isEnabled()) {
					lookupTableType.click();
					lookupTableType.click();
					fnWriteSteps("Pass", "Table Type field is enable");
				} else {
					fnWriteSteps("Fail", "Table Type field is not enable");
				}
				if (txtTableNo.isEnabled()) {
					txtTableNo.click();
					fnWriteSteps("Pass", "Table No field is enable");
				} else {
					fnWriteSteps("Fail", "Table No field is not enable");
				}
				if (calcMaximumCapacity.isEnabled()) {
					calcMaximumCapacity.click();
					fnWriteSteps("Pass", "Maximum Capacity field is enable");
				} else {
					fnWriteSteps("Fail", "Maximum Capacity field is not enable");
				}
				if (memoDescription.isEnabled()) {
					memoDescription.click();
					fnWriteSteps("Pass", "Description field is enable");
				} else {
					fnWriteSteps("Fail", "Description field is not enable");
				}
			}
		} catch (Exception e) {
			if (lookupTableType.isEnabled()) {
				lookupTableType.click();
				lookupTableType.click();
				fnWriteSteps("Pass", "Table Type field is enable");
			} else {
				fnWriteSteps("Fail", "Table Type field is not enable");
			}
			if (txtTableNo.isEnabled()) {
				txtTableNo.click();
				fnWriteSteps("Pass", "Table No field is enable");
			} else {
				fnWriteSteps("Fail", "Table No field is not enable");
			}
			if (calcMaximumCapacity.isEnabled()) {
				calcMaximumCapacity.click();
				fnWriteSteps("Pass", "Maximum Capacity field is enable");
			} else {
				fnWriteSteps("Fail", "Maximum Capacity field is not enable");
			}
			if (memoDescription.isEnabled()) {
				memoDescription.click();
				fnWriteSteps("Pass", "Description field is enable");
			} else {
				fnWriteSteps("Fail", "Description field is not enable");
			}
		}
	}

	// --------added by Moumita on 27-June-18-----------
	// This method is for verifying the table edit
	// Parameter are tableNo, EditFieldOldValue, EditFieldName & EditedValue
	public void verifyTableEdit(String tableNo, String EditFieldOldValue, String EditFieldName, String EditedValue) {
		txtSearch.sendKeys(tableNo);
		clickSaveButton();
		GenericMethods.fnwait(1);
		switch (EditFieldName.toLowerCase()) {
		case "maximum capacity":
			calcMaximumCapacity.clear();
			calcMaximumCapacity.sendKeys(EditedValue);
			break;
		case "description":
			memoDescription.clear();
			memoDescription.sendKeys(EditedValue);
			break;
		}

		clickSaveButton();

		txtSearch.sendKeys(tableNo);
		clickSaveButton();
		GenericMethods.fnwait(1);
		switch (EditFieldName.toLowerCase()) {
		case "maximum capacity":
			if (calcMaximumCapacity.getText().equals(EditedValue)) {
				fnWriteSteps("Pass", "Maximum Capacity edit is successful");
			} else {
				fnWriteSteps("Fail", "Maximum Capacity is not successful");
			}
			break;
		case "description":
			if (memoDescription.getText().equals(EditedValue)) {
				fnWriteSteps("Pass", "description edit is successful");
			} else {
				fnWriteSteps("Fail", "description edit is not successful");
			}
			break;
		}
	}
	
	/* 2-July-18-----Added by Moumita */
	/* This is the method to delete the record by delete icon from master page */
	public void fnVerifyTableDelete(String strTableNo) {
		txtSearch.sendKeys(strTableNo);
		GenericMethods.fnwait(1);
		GenericMethods.fnVerifyMasterRecordDelete(grdRecordList);
	}
	
	/* 2-July-18-----Added by Moumita */
	/* This is the method to verify the record has been deleted successfully or not*/
	public void fnVerifyTableDeleteSuccessfulOrNot(String strTableNo) {
		txtSearch.clear();
		txtSearch.sendKeys(strTableNo);
		String gridNoDataLabel = null;			

		WebElement messageEle = driver.findElement(By.id("lblNoData"));
		gridNoDataLabel = messageEle.getAttribute("Name");		
		if (gridNoDataLabel.contains("No table found")) {
			fnWriteSteps("pass", "Record has been deleted successfully");
		} else
		{
			fnWriteSteps("pass", "Record has not been deleted");
		}
		
	}
}