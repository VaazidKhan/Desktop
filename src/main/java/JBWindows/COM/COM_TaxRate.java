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

public class COM_TaxRate extends BaseClass {
	// Header elements
	@FindBy(id = "COM_TaxRate")	WebElement pageName;
	@FindBy(id = "picClose")	WebElement btnClose;
	@FindBy(id = "lblCaption")	WebElement PageCaption;
	@FindBy(id = "picLogo")	WebElement HeaderJBLogo;
	
	// Master page elements
	@FindBy(id = "txtSearch")	WebElement txtSearch;

	// Entry OR Edit screen elements
	@FindBy(id = "txtTaxName")	    WebElement txtTaxName;
	@FindBy(id = "calcTaxRate")	    WebElement calcTaxRate;
	@FindBy(id = "chkActive")	    WebElement chkActive;
	@FindBy(id = "cboTaxType")	    WebElement cboTaxType;
	@FindBy(id = "chkReturnable")	WebElement chkReturnable;
	@FindBy(id = "lookupGLCode")	WebElement lookupGLCode;
	@FindBy(id = "calcReturnRate")	WebElement Returnrate;
	// Display details section elements
	@FindBy(id = "lblProductTaxName")	WebElement lblProductTaxName;
	@FindBy(id = "lblProductTaxRate")	WebElement lblProductTaxRate;
	@FindBy(id = "picTaxActive")	WebElement picTaxActive;
	
	// Buttons elements
	@FindBy(id = "btnAdd")	WebElement btnAdd;
	@FindBy(id = "btnSave")	WebElement btnEdit;
	@FindBy(id = "btnSave")	WebElement btnSave;
	@FindBy(id = "btnCancel")	WebElement btnCancel;
	@FindBy(id = "btnOk") WebElement btnOk;
	/* 2-July-18-----Added by Moumita */
	@FindBy(id = "grdTaxRate")
	WebElement grdRecordList;
	@FindBy(id = "lblNoData")
	WebElement noTaxRateLabel; 

	//WebElement Initialization method
	public COM_TaxRate() {
		PageFactory.initElements(driver, this);
	}
	
	//Operations
	public void activatePage()
	{
		pageName.click();
	}
	
	//Actions
	public void clickCreateNewButton()
	{
		btnAdd.click();
	}
	public void clickEditButton()
	{
		btnEdit.click();
	}
	public void clickSaveButton()
	{
		btnSave.click();
	}
	public void clickCancelButton()
	{
		btnCancel.click();
	}
	public void clickCloseButton()
	{
		btnClose.click();
	}
	
	// This method for New Taxrate Creation :
		public void CreateNewTaxRate(String TaxName,String TaxRate,String TaxType,String GLCode,String ReturnRate,String Inactive) {
			
		          if (btnAdd.isDisplayed()) {
		              btnAdd.click();
			
					if (txtTaxName.isDisplayed()) {					
					txtTaxName.sendKeys(TaxName);
							
					}  else {
						fnWriteSteps("Fail", "Tax Name field is not enable");
					        }
					if(calcTaxRate.isDisplayed()) {
					calcTaxRate.sendKeys(TaxRate);
							
					}  else  {
						fnWriteSteps("Fail", "Tax Rate field is not enable" );
					
					         }
					if(cboTaxType.isDisplayed()) {
					   cboTaxType.sendKeys(TaxType);
					   cboTaxType.submit();		
					}  else {
					
						fnWriteSteps("Fail", "Tax Type field is not enable" );
					   
					        }
					if(lookupGLCode.isDisplayed()) {
					   lookupGLCode.sendKeys(GLCode);
					   lookupGLCode.submit(); 
					} else  {
					
						fnWriteSteps("Fail", "GL Code field is not enable" );
					
					        }
					if (chkActive.isSelected()) { 
						switch (Inactive) {
						case "Inactive":
							chkActive.click();
							break;
						}
						 fnWriteSteps("Pass", "Active checkbox is checked by default ");
					 }  else {
					 
						 fnWriteSteps("Fail", "Active checkbox is not checked by default ");
					         }	
					if (chkReturnable.isDisplayed()) { 
						chkReturnable.click();
						
					 } else {
					 
						 fnWriteSteps("Fail", "Returnable checkbox is checked by default ");
					        }
					if(Returnrate.isDisplayed()) {
						Returnrate.sendKeys(ReturnRate);
						Returnrate.click(); 
						} else  {
						
							fnWriteSteps("Fail", "ReturnRate field is not enable" );
						
						        }
					
					
					btnSave.click();
					GenericMethods.fnwait(2);
					System.out.println("Tax Rate has been created successfully");
				
					
				}
		}
		// This method for Validation of New Taxrate Creation :
		public boolean Verify_NewTaxrateFeature_SaveorNot(String TaxName) {
      	  
			if (txtSearch.isDisplayed()) {
				txtSearch.clear();
				txtSearch.sendKeys(TaxName);

			 } else {  fnWriteSteps("Fail", "TaxName is not displayed in UI");
					   
            }
						String Actual = driver.findElement(By.id("lblProductTaxName")).getAttribute("Name");
						if (Actual.substring(15,25).trim().contains(TaxName.trim())) {
							
						   return true;
						}
						
						   return false;
					}	
				



		// This method is for verifying the Tax Rate has been saved or not
		// Parameters are StartingRowNumber & LastRowNumber
		public void VerifyTaxRateSavedOrNot(int StartingRowNumber, int LastRowNumber) throws IOException {
			for (int StartFrom = StartingRowNumber; StartFrom <= LastRowNumber; StartFrom++) {
				txtSearch.sendKeys(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "TaxRate", StartFrom, 0));
				clickEditButton();

				try {
					if (txtTaxName.getText().equals(ExcelUtils
							.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "TaxRate", StartFrom, 0))) {
						fnWriteSteps("Pass", "Tax Name is saved successfully");
					} else {
						fnWriteSteps("Fail", "Tax Name is not saved");
					}
					if (calcTaxRate.getText().equals(ExcelUtils
							.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "TaxRate", StartFrom, 1))) {
						fnWriteSteps("Pass", "Tax rate is saved successfully");
					} else {
						fnWriteSteps("Fail", "Tax Rate is not saved");
					}					

					clickSaveButton();
					GenericMethods.fnwait(1);
					fnWriteSteps("Pass", "Tax Rate is saved successfully");

				} catch (Exception e) {
					fnWriteSteps("Fail", "Tax Rate is not saved successfully");
				}
			}
		}

		//  This method for TaxRate Edit :
		public void VerifyTaxEdit(String OldTaxName,String TaxName,String TaxRate,String TaxType,String GLCode,String ReturnRate) {
			
			txtSearch.sendKeys(OldTaxName);
			clickEditButton();
			GenericMethods.fnwait(1);
			GenericMethods.windows_Set_TextBoxValue(txtTaxName,TaxName);
			GenericMethods.windows_Set_TextBoxValue(calcTaxRate,TaxRate);
			GenericMethods.windows_Set_TextBoxValue(cboTaxType,TaxType);
			GenericMethods.windows_Set_TextBoxValue(lookupGLCode,GLCode);
			
			 if (chkActive.isDisplayed()) { 
				chkActive.click();
				 fnWriteSteps("Pass", "Active checkbox is not checked by default ");
			 }  else {
			 
				 fnWriteSteps("Fail", "Active checkbox is checked by default ");
			         }	
			if (chkReturnable.isSelected()) { 
				 fnWriteSteps("Pass", "Returnable checkbox is checked by default ");
				GenericMethods.windows_Set_TextBoxValue(Returnrate,ReturnRate);
			 } else {
			 
				 fnWriteSteps("Fail", "Returnable checkbox is not checked by default ");
			        }
			btnSave.click();
			GenericMethods.fnwait(2);
			System.out.println("Tax Rate has been Updated successfully");
			
			
			}

		
	 // This method is to verify all the fields are visible or not

		public void VerifyFieldVisibility() {
			
		     if (btnAdd.isDisplayed()) {
		            btnAdd.click();
			if (txtTaxName.isDisplayed()) {
				fnWriteSteps("Pass", "Tax Name field is present");
			} else {
				fnWriteSteps("Fail", "Tax Name field is not present");
			}
			if (calcTaxRate.isDisplayed()) {				
				fnWriteSteps("Pass", "Tax Rate Type field is present");
			} else {
				fnWriteSteps("Fail", "Tax Rate Type field is not present");
			}
			if (cboTaxType.isDisplayed()) {
				fnWriteSteps("Pass", "Tax Type field is present");
			} else {
				fnWriteSteps("Fail", "Tax Type field is not present");
			}
			if (lookupGLCode.isDisplayed()) {
				fnWriteSteps("Pass", "GL code field is present");
			} else {
				fnWriteSteps("Fail", "GL Code field is not present");
			}			
			if (chkActive.isDisplayed()) {
				fnWriteSteps("Pass", "Active checkbox is present");
			} else {
				fnWriteSteps("Fail", "Active checkbox is not present");
			}		
			if (chkReturnable.isDisplayed()) {
				System.out.println(" Successfully all fields are Displayed ");
				fnWriteSteps("Pass", "Returnable checkbox field is present");
			} else {
				fnWriteSteps("Fail", "Returnable checkbox field is not present");
			}
        }
  }


		// This method is to verify all the fields are enable or not

		public void VerifyFieldEnableOrNot() {
			
		
			 if (btnAdd.isDisplayed()) {
		         btnAdd.click();
			
			if (txtTaxName.isEnabled()) {
				txtTaxName.click();
				fnWriteSteps("Pass", "Tax Name field is enable");
			} else {
				fnWriteSteps("Fail", "Tax Name field is not enable");
			}
			if (calcTaxRate.isEnabled()) {			
				calcTaxRate.click();				
				fnWriteSteps("Pass", "Tax Rate Type field is enable");
			} else {
				fnWriteSteps("Fail", "Tax Rate Type field is not enable");
			}
			if (cboTaxType.isEnabled()) {			
				cboTaxType.click();
				fnWriteSteps("Pass", "Tax Type field is enable");
			} else {
				fnWriteSteps("Fail", "Tax Type field is not enable");
			}
			if (lookupGLCode.isEnabled()) {
				lookupGLCode.click();
				fnWriteSteps("Pass", "GL code field is enable");
			} else {
				fnWriteSteps("Fail", "GL code field is not enable");
			}			
			if (chkActive.isEnabled()) {
				chkActive.click();
				fnWriteSteps("Pass", "Active checkbox is enable");
			} else {
				fnWriteSteps("Fail", "Active checkbox is not enable");
			}			
			if (chkReturnable.isEnabled()) {
				chkReturnable.click();
				System.out.println(" Successfully all fields are Displayed ");
				fnWriteSteps("Pass", "Returnable field is enable");
			} else {
				fnWriteSteps("Fail", "Returnable field is not enable");
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
				r1.mouseMove(x1 + 410, y1 - 235);
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
		// This method for TaxrateDelete :
		public void fnVerifyTaxRateDelete(String TaxName) {
			txtSearch.sendKeys(TaxName);
			GenericMethods.fnwait(1);
			fnVerifyMasterRecordDelete(grdRecordList);
			btnOk.click();
		       GenericMethods.fnwait(30);
		       System.out.println("Created TaxRate has been Deleted");
		}
		// This method for Validation of Taxrate Delete :
		public boolean Verify_TaxrateDelete_SaveorNot(String TaxName) {
	      	  
			if (txtSearch.isDisplayed()) {
				txtSearch.clear();
				txtSearch.sendKeys(TaxName);

			 } else {  fnWriteSteps("Fail", "TaxName is not displayed in UI");
					   
            }
						String Actual = driver.findElement(By.id("lblProductTaxName")).getAttribute("Name");
						if (!Actual.substring(15,25).trim().contains(TaxName.trim())) {
							
						   return true;
						}
						
						   return false;
					}	
				
		
		
		/* 2-July-18-----Added by Moumita */
		/* This is the method to verify the record has been deleted successfully or not*/
		public void fnVerifyTaxRateDeleteSuccessfulOrNot(String strTaxRate) {
			txtSearch.clear();
			txtSearch.sendKeys(strTaxRate);
			String gridNoDataLabel = null;			

			WebElement messageEle = driver.findElement(By.id("lblNoData"));
			gridNoDataLabel = messageEle.getAttribute("Name");		
			if (gridNoDataLabel.contains("No tax rate found")) {
				fnWriteSteps("pass", "Record has been deleted successfully");
			} else
			{
				fnWriteSteps("pass", "Record has not been deleted");
			}
			
		}
	}



