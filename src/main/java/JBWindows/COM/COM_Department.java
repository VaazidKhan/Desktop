package JBWindows.COM;

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

public class COM_Department extends BaseClass {
	// Header elements
	@FindBy(id = "picClose")
	WebElement btnClose;
	@FindBy(id = "lblCaption")
	WebElement PageCaption;
	@FindBy(id = "picLogo")
	WebElement HeaderJBLogo;

	// Master page button objects
	@FindBy(id = "COM_Department")
	WebElement pageName;
	@FindBy(id = "txtSearch")
	WebElement txtSearch;

	// Entry OR Edit page objects
	@FindBy(id = "txtDepartment")
	WebElement txtDepartment;
	@FindBy(id = "lookUpDiscountRule")
	WebElement lookUpDiscountRule;
	@FindBy(id = "btnSelectPrinter")
	WebElement btnSelectPrinter;
	@FindBy(id = "memoDescription")
	WebElement memoDescription;

	// Buttons elements
	@FindBy(id = "btnAdd")
	WebElement btnAdd;
	@FindBy(id = "btnSave")
	WebElement btnEdit;
	@FindBy(id = "btnSave")
	WebElement btnSave;
	@FindBy(id = "btnCancel")
	WebElement btnCancel;
	@FindBy(id = "btnOk")
	WebElement btnOk;

	
	/* 2-July-18-----Added by Moumita */
	@FindBy(id = "grdDepartment")
	WebElement grdRecordList;
	@FindBy(id = "lblNoData")
	WebElement noDepartmentLabel; 
	
	
	
	// WebElement Initialization method
	public COM_Department() {
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

	//Operations
	public void activatePage()
	{
		pageName.click();
	}

	
	 // This method for New Department Creation :
       public void createNewDepartment(String DepartmentName,String Discountrule,String Description) {
			
					if (btnAdd.isDisplayed()) {
						btnAdd.click();

						if (txtDepartment.isDisplayed()) {
							txtDepartment.sendKeys(DepartmentName);
						} else {
							fnWriteSteps("Fail", "Department Name field is not enable");
						}
						if (lookUpDiscountRule.isDisplayed()) {
							lookUpDiscountRule.sendKeys(Discountrule);
						} else {
							fnWriteSteps("Fail", "Discount Rule field is not enable");
						}
						
						if (memoDescription.isDisplayed()) {
							memoDescription.sendKeys(Description);
						} else {
							fnWriteSteps("Fail", "Description field is not enable");
						}
						
						clickSaveButton();
						System.out.println(" Department has been Created & Saved");
					}
				 
				}
    // This method for Validation of New Department Creation :
		public boolean Verify_NewDepartmentFeature_SaveorNot(String DepartmentName) {
	      	  
			if (txtSearch.isDisplayed()) {
				txtSearch.clear();
				txtSearch.sendKeys(DepartmentName.trim());

			 } else {  fnWriteSteps("Fail", "DepartmentName is not displayed in UI");
					   
         }
						String Actual = driver.findElement(By.id("lblDepartmentName")).getAttribute("Name");
					    if (Actual.substring(15,33).trim().contains(DepartmentName.trim())) {
							
						   return true;
						}
						
						   return false;
					}	
			
		

		// This method is for verifying the Department has been saved or not
		// Parameters are StartingRowNumber & LastRowNumber
		public void verifyDepartmentSavedOrNot(int StartingRowNumber, int LastRowNumber) throws IOException {
			for (int StartFrom = StartingRowNumber; StartFrom <= LastRowNumber; StartFrom++) {
				txtSearch.sendKeys(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Departments", StartFrom, 0));
				clickEditButton();

				try {
					if (txtDepartment.getText().equals(
							ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Departments", StartFrom, 0))) {
						fnWriteSteps("Pass", "Department Name is saved successfully");
					} else {
						fnWriteSteps("Fail", "Department Name is not saved");
					}
					if (memoDescription.getText().equals(
							ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Departments", StartFrom, 2))) {
						fnWriteSteps("Pass", "Description is saved successfully");
					} else {
						fnWriteSteps("Fail", "Description is not saved");
					}					

					clickSaveButton();
					GenericMethods.fnwait(1);
					fnWriteSteps("Pass", "Department is saved successfully");

				} catch (Exception e) {
					fnWriteSteps("Fail", "Department is not saved successfully");
				}
			}
		}

		// This method for Department Edit :
		public void verifyDepartmentEdit(String OldDepartmentName,String DepartmentName,String DiscountRule,String Description) {
			txtSearch.sendKeys(OldDepartmentName);
			clickEditButton();
			GenericMethods.fnwait(1);
			GenericMethods.windows_Set_TextBoxValue(txtDepartment,DepartmentName);
			GenericMethods.windows_Set_TextBoxValue(lookUpDiscountRule,DiscountRule );
			GenericMethods.windows_Set_TextBoxValue(memoDescription,Description);
			 GenericMethods.fnwait(2);
			 btnSave.click();
		  System.out.println(" Department has been Updated & Saved");
			}
		
	
		// This method is to verify all the fields are visible or not

		public void verifyFieldVisibility() {
			
				if (btnAdd.isDisplayed()) {
					btnAdd.click();

					if (txtDepartment.isDisplayed()) {
						fnWriteSteps("Pass", "Department field is present");
					} else {
						fnWriteSteps("Fail", "Department field is not present");
					}
					if (lookUpDiscountRule.isDisplayed()) {
						fnWriteSteps("Pass", "Discount Rule field is present");
					} else {
						fnWriteSteps("Fail", "Discount Rule field is not present");
					}
					if (memoDescription.isDisplayed()) {
						System.out.println("Successfully all fields are Displayed");
						fnWriteSteps("Pass", "Description field is present");
					} else {
						fnWriteSteps("Fail", "Description field is not present");
					}
					
				}
			} 
		

		// This method is to verify all the fields are enable or not

		public void verifyFieldEnableOrNot() {
			
				if (btnAdd.isDisplayed()) {
					btnAdd.click();

					if (txtDepartment.isEnabled()) {
						txtDepartment.click();
						fnWriteSteps("Pass", "Department field is enable");
					} else {
						fnWriteSteps("Fail", "Department field is not enable");
					}
					if (lookUpDiscountRule.isEnabled()) {
						lookUpDiscountRule.click();
						fnWriteSteps("Pass", "Discount Rule field is enable");
					} else {
						fnWriteSteps("Fail", "Discount Rule field is not enable");
					}
					if (memoDescription.isEnabled()) {
						memoDescription.click();
						System.out.println("Successfully all fields are Enabled");
						fnWriteSteps("Pass", "Description field is enable");
					} else {
						fnWriteSteps("Fail", "Description field is not enable");
					}					
				}
		   }
			
		
		
		// This method for Access the Delete Button :
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
				r1.mouseMove(x1 + 350, y1 - 200);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			GenericMethods.fnwait(1);
			Actions builder1 = new Actions(driver);
			builder1.click().build().perform();
		}
		// This method for To click on YES Button :
		public void click_On_Yes_Button() {
			driver.findElement(By.id("lblHeader")).click();
			GenericMethods.fnwait(1);
			btnOk.click();
			
		}
		// This method for DepartmentDelete :
		public void fnVerifyDepartmentDelete(String DepartmentName) {
			txtSearch.sendKeys(DepartmentName);
			GenericMethods.fnwait(1);
			fnVerifyMasterRecordDelete(grdRecordList);
			btnOk.click();
			GenericMethods.fnwait(24);
			System.out.println("Created Department has been Deleted");
		}
		// This method for Validation of Department Delete
		public boolean Verify_DepartmentDelete_SaveorNot(String DepartmentName) {
		   	  
			if (txtSearch.isDisplayed()) {
				GenericMethods.fnwait(1);
				txtSearch.sendKeys(DepartmentName);
				GenericMethods.fnwait(4);
			 } else {  fnWriteSteps("Fail", "DepartmentName is not displayed in UI");
					   
	     }
				 String Actual = driver.findElement(By.id("lblDepartmentName")).getAttribute("Name");
			     if (!Actual.substring(15,34).trim().substring(0,8).trim().contains(DepartmentName.trim().substring(0, 8).trim())) {
							
						   return true;
						}
						
						   return false;
					}	
		
		/* 2-July-18-----Added by Moumita */
		/* This is the method to verify the record has been deleted successfully or not*/
		public void fnVerifyDepartmentDeleteSuccessfulOrNot(String strDepartmentName) {
			txtSearch.clear();
			txtSearch.sendKeys(strDepartmentName);
			String gridNoDataLabel = null;			

			WebElement messageEle = driver.findElement(By.id("lblNoData"));
			gridNoDataLabel = messageEle.getAttribute("Name");		
			if (gridNoDataLabel.contains("No department found")) {
				fnWriteSteps("pass", "Record has been deleted successfully");
			} else
			{
				fnWriteSteps("pass", "Record has not been deleted");
			}
			
		}
		
		/* 2-July-18-----Added by Moumita 
		 This is the method to wait conditionally till the time record has not been deleted
		public void fn_ConditionalWaitForDepartmentDelete() {
		if(txtSearch.isDisplayed())
		GenericMethods.fn_ConditionalWaitForElementToDisappear("windows", txtSearch, 150);	
	}*/
			
}



