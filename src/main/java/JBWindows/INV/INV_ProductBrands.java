package JBWindows.INV;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class INV_ProductBrands extends BaseClass {
	// Header elements
	@FindBy(id = "picClose")
	WebElement btnClose;
	@FindBy(id = "lblCaption")
	WebElement PageCaption;
	@FindBy(id = "picLogo")
	WebElement HeaderJBLogo;
	@FindBy(id = "lblNoData")
	WebElement lblNoData;

	// Details pane element
	@FindBy(id = "lblBrandName")
	WebElement lblBrandName;
	@FindBy(id = "lblDiscountName")
	WebElement lblDiscountName;

	// Master page button objects
	@FindBy(id = "INV_ProductBrands")
	WebElement pageName;
	@FindBy(id = "txtSearch")
	WebElement txtSearch;
	@FindBy(id = "btnAdd")
	WebElement btnAdd;
	@FindBy(id = "btnSave")
	WebElement btnEdit;

	// Entry OR Edit page objects
	@FindBy(id = "txtBrand")
	WebElement txtBrand;
	@FindBy(id = "txtManufacturer")
	WebElement txtManufacturer;
	@FindBy(id = "lookUpDiscountRule")
	WebElement lookUpDiscountRule;
	@FindBy(id = "memoDescription")
	WebElement memoDescription;

	// Entry or Edit page buttons
	@FindBy(id = "btnSave")
	WebElement btnSave;
	@FindBy(id = "btnCancel")
	WebElement btnCancel;
	@FindBy(id = "btnOk")
	WebElement btnOk;
	
	/* 28-June-18-----Added by Moumita */
	@FindBy(id = "grdProductBrand")
	WebElement grdRecordList;
	@FindBy(id = "lblNoData")
	WebElement noBrandLabel; 
	
	@FindBy(name = "Backspace")
	WebElement backBtn;

	// WebElement Initialization
	public INV_ProductBrands() {
		PageFactory.initElements(driver, this);
	}
	// Operations
	public void activatePage() {
		pageName.click();
	}

	// Actions
	public void clickNewBrand() {
		btnAdd.click();
	}

	public void clickEditBrand() {
		btnEdit.click();
	}

	public void clickSaveButton() {
		btnSave.click();
	}

	public void clickCancelButton() {
		btnCancel.click();
	}

	public void clickCloseButton() {
		GenericMethods.fnwait(6);
		driver.findElement(By.id("picLogo")).click();
		btnClose.click();
	}

	// This method is to create brand which will take data from Excel.
	// input parameter is StartingRowNumber, LastCountOfRecord
	
	// This method for New Brand Creation :
	public void verifyNewBrandCreation(String StrBrandName,String StrManufacturer,String DiscountRule,String Description) {
		       if (btnAdd.isDisplayed()) {
					btnAdd.click();
                
	           if (txtBrand.isDisplayed()) {
			        txtBrand.sendKeys(StrBrandName);
					} else {
						fnWriteSteps("Fail", "Brand field is not enable");
					}
					if (txtManufacturer.isDisplayed()) {
						txtManufacturer.sendKeys(StrManufacturer);
					} else {
						fnWriteSteps("Fail", "Manufacturer field is not enable");
					}
					if (lookUpDiscountRule.isDisplayed()) {
						lookUpDiscountRule.sendKeys(DiscountRule);
						lookUpDiscountRule.click();
					} else {
						fnWriteSteps("Fail", "Discount Rate field is not enable");
					}
					if (memoDescription.isDisplayed()) {
						memoDescription.sendKeys(Description);
					} else {
						fnWriteSteps("Fail", "Description field is not enable");
					}
					btnSave.click();
					System.out.println("Brand has been created & Saved");
					
		       }
	}
	// This method for Validation of New Brand Creation :
			   public boolean Verify_NewBrandCreation_SaveorNot(String StrBrandName) {
  
						if (txtSearch.isDisplayed()) {
							txtSearch.clear();
							txtSearch.sendKeys(StrBrandName);

						} else {
							fnWriteSteps("Fail", "BrandName is not displayed in UI");

						}
						String Actual = driver.findElement(By.id("lblBrandName")).getAttribute("Name");
						if (Actual.substring(15,19 ).contains(StrBrandName.substring(0, 4))) {
							
						   return true;
						}
						   return false;
					}
					
						
			
		
			
	// This method is to verify created brand which took data from Excel.
	// input parameter is StartingRowNumber, LastCountOfRecord
	public void verifyCreatedBrandSavedOrNot(int StartingRowNumber, int LastCountOfRecord) throws IOException {

		for (int StartFrom = StartingRowNumber; StartFrom <= LastCountOfRecord; StartFrom++) {
			txtSearch.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Brand", StartFrom, 0));
			clickEditBrand();

			if (txtBrand.getText().equals(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Brand", StartFrom, 0))) {
				fnWriteSteps("Pass", "Brand field value is saved successfully.");
			} else {
				fnWriteSteps("Fail", "Brand field value is not saved successfully.");
			}

			if (txtManufacturer.getText().equals(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Brand", StartFrom, 1))) {
				fnWriteSteps("Pass", "Manufacturer field value is saved successfully.");
			} else {
				fnWriteSteps("Fail", "Manufacturer field value is not saved successfully.");
			}
			/*
			 * if (lookUpDiscountRule.getText().equals(ExcelUtils.fnGetExcelCellValue(
			 * ApplicationVariables.MasterExcelPath, "Brand", StartFrom, 2))) {
			 * lookUpDiscountRule.click(); fnWriteSteps("Pass",
			 * "Discount Rule field value is saved successfully."); } else {
			 * fnWriteSteps("Fail", "Discount Rule field value is not saved successfully.");
			 * }
			 */
			if (memoDescription.getText().equals(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Brand", StartFrom, 3))) {
				fnWriteSteps("Pass", "Description field value is saved successfully.");
			} else {
				fnWriteSteps("Fail", "Description field value is not saved successfully.");
			}

			fnWriteSteps("Pass", "Brand saving process is Successful");
			clickCancelButton();
		}

	}

	// This method is to verify Editing Brand works or not.
	// input parameter is Brand Name, field name, new filed value
	
	// This method for Brand Details Edit :
	public void verifyEditBrandDetails(String StrBrandName,String StrManufacturer,String DiscountRule,String Description,String OldBrandName) {
		
		txtSearch.sendKeys(OldBrandName);
		btnEdit.click();
		
		if (txtBrand.isDisplayed()){
	        txtBrand.clear();
			txtBrand.sendKeys(StrBrandName);
		} else { 
			fnWriteSteps("Fail", "Brand field is not enable");
		}
		if (txtManufacturer.isDisplayed()){
			txtManufacturer.clear();
			txtManufacturer.sendKeys(StrManufacturer);
		} else {
			fnWriteSteps("Fail", "Manufacturer field is not enable");
		}
		if (lookUpDiscountRule.isDisplayed()){
			lookUpDiscountRule.clear();
			lookUpDiscountRule.sendKeys(DiscountRule);
			lookUpDiscountRule.click();
		} else {
			fnWriteSteps("Fail", "DiscountRule field is not enable");
		}
		if (memoDescription.isDisplayed()){
			memoDescription.clear();
			memoDescription.sendKeys(Description);
			
		} else {
			fnWriteSteps("Fail", "Description field is not enable");
		}
		btnSave.click();
		System.out.println("Brand has been Updated & Saved");

	}
	// This method for Validation of Brand Details Edit :
	 public boolean Verify_EditBrandDetails_SaveorNot(String StrBrandName) {
		  
			if (txtSearch.isDisplayed()) {
				txtSearch.clear();
				txtSearch.sendKeys(StrBrandName);

			} else {
				fnWriteSteps("Fail", "BrandName is not displayed in UI");

			}
			String Actual = driver.findElement(By.id("lblBrandName")).getAttribute("Name");
			if (Actual.substring(15, 21).contains(StrBrandName.substring(0, 4))) {
				
			   return true;
			}
			   return false;
		}

	
	
	// This method is to verify all the fields are visible or not

	public void verifyFieldVisibility() {
		
			if (btnAdd.isDisplayed()) {
				btnAdd.click();
				if (txtBrand.isDisplayed()) {
				  fnWriteSteps("Pass", "Brand field is present");
				} else {
					fnWriteSteps("Fail", "Brand field is not present");
				}
				if (txtManufacturer.isDisplayed()) {
					fnWriteSteps("Pass", "Manufacturer field is present");
				} else {
					fnWriteSteps("Fail", "Manufacturer field is not present");
				}
				if (lookUpDiscountRule.isDisplayed()) {
					fnWriteSteps("Pass", "Discount Rule field is present");
				} else {
					fnWriteSteps("Fail", "Discount Rule field is not present");
				}
				if (memoDescription.isDisplayed()) {
					System.out.println(" Successfully all fields are Displayed ");
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
				if (txtBrand.isEnabled()) {
					txtBrand.click();
					fnWriteSteps("Pass", "Brand field is enable");
				} else {
					fnWriteSteps("Fail", "Brand field is not enable");
				}
				if (txtManufacturer.isEnabled()) {
					txtManufacturer.click();
					fnWriteSteps("Pass", "Manufacturer field is enable");
				} else {
					fnWriteSteps("Fail", "Manufacturer field is not enable");
				}
				if (lookUpDiscountRule.isEnabled()) {
					lookUpDiscountRule.click();
					fnWriteSteps("Pass", "Discount Rule field is enable");
				} else {
					fnWriteSteps("Fail", "Discount Rule field is not enable");
				}
				if (memoDescription.isEnabled()) {
					memoDescription.click();
					System.out.println(" Successfully all fields are Enabled ");
					fnWriteSteps("Pass", "Description field is enable");
				} else {
					fnWriteSteps("Fail", "Description field is not present");
				}
			}
		} 
	/* 28-June-18-----Added by Moumita */
	/* This is the method to delete the record by delete icon from master page */
	
	// This method for BrandDelete :
	public void fnVerifyBrandDelete(String strBrandName) {
		txtSearch.sendKeys(strBrandName);
		GenericMethods.fnwait(1);
		GenericMethods.fnVerifyMasterRecordDelete(grdRecordList);
		btnOk.click();
		System.out.println("Created ProductBrand has been Deleted");
	}
	// This method for To click on YES Button :
	   public void click_On_Yes_Button() {
		driver.findElement(By.id("lblHeader")).click();
		GenericMethods.fnwait(1);
		btnOk.click();
		GenericMethods.fnwait(45);
	  }
	 // This method for Validation of Brand Delete :
	public boolean Verify_ProductBrandDelete_SaveorNot(String strBrandName) {
		  
		if (txtSearch.isDisplayed()) {
			txtSearch.clear();
			txtSearch.click();
			txtSearch.sendKeys(strBrandName.trim());
			
		} else {
			fnWriteSteps("Fail", "BrandName is not displayed in UI");

		}
		GenericMethods.fnwait(4);
		
		String Actual= driver.findElement(By.id("lblBrandName")).getAttribute("Name");
		if (!Actual.contains(strBrandName)) {
			
		   return true;
		}
		   return false;
	}
	
	/* 28-June-18-----Added by Moumita */
	/* This is the method to verify the record has been deleted successfully or not*/
	public void fnVerifyBrandDeleteSuccessfulOrNot(String strBrandName) {
		txtSearch.clear();
		txtSearch.sendKeys(strBrandName);
		String gridNoDataLabel = null;			

		WebElement messageEle = driver.findElement(By.id("lblNoData"));
		gridNoDataLabel = messageEle.getAttribute("Name");		
		if (gridNoDataLabel.contains("No brand found")) {
			fnWriteSteps("pass", "Record has been deleted successfully");
		} else
		{
			fnWriteSteps("pass", "Record has not been deleted");
		}
		
	}
	
	public void clickBackButton() {
		GenericMethods.fn_ConditionalWaitForElement(backBtn, 20);
		backBtn.click();
		GenericMethods.fnwait(5);
		fnWriteSteps("INFO", "Back button is clicked");

	}

}
