package JBWindows.PUR;

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

public class PUR_Suppliers extends BaseClass {
	// Header elements
	@FindBy(id = "picClose")
	WebElement btnClose;
	@FindBy(id = "lblCaption")
	WebElement PageCaption;
	@FindBy(id = "picLogo")
	WebElement HeaderJBLogo;

	// Master page elements
	@FindBy(id = "PUR_Suppliers")
	WebElement pageName;
	@FindBy(id = "TxtSearch")
	WebElement TxtSearch;
	@FindBy(id = "grdSupplier")
	WebElement grdSupplier;

	// Entry OR Edit screen elements
	@FindBy(id = "txtFirstName")
	WebElement txtFirstName;
	@FindBy(id = "txtPhoneNo")
	WebElement txtPhoneNo;
	@FindBy(id = "chkActive")
	WebElement chkActive;
	@FindBy(id = "txtEmail")
	WebElement txtEmail;
	@FindBy(id = "txtDoorNo")
	WebElement txtDoorNo;
	@FindBy(id = "txtStreetName")
	WebElement txtStreetName;
	@FindBy(id = "txtArea")
	WebElement txtArea;
	@FindBy(id = "memoBillingAddress")
	WebElement memoBillingAddress;
	@FindBy(id = "lookupState")
	WebElement lookupState;
	@FindBy(id = "lookupCity")
	WebElement lookupCity;
	@FindBy(id = "txtZipCode")
	WebElement txtZipCode;
	@FindBy(id = "calcCreditDays")
	WebElement calcCreditDays;
	@FindBy(id = "calcInitialOutstanding")
	WebElement calcInitialOutstanding;
	@FindBy(id = "txtVAT")
	WebElement txtVAT;
	@FindBy(id = "txtGST")
	WebElement txtGST;

	// Buttons elements
	@FindBy(id = "btnAdvancePaid")
	WebElement btnAdvancePaid;
	@FindBy(id = "btnListView")
	WebElement btnListView;
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
	@FindBy(id = "grdSupplier")
	WebElement grdRecordList;
	@FindBy(id = "lblNoData")
	WebElement noSupplierLabel; 

	// WebElement Initialization method
	public PUR_Suppliers() {
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

	public void clickAdvancePaidButton() {
		btnAdvancePaid.click();
	}

	public void clickListViewButtton() {
		btnListView.click();
	}

	// Operations
	public void activatePage() {
		pageName.click();
	}

	public void searchRecord(String ExpectedRecordName) {
		TxtSearch.sendKeys(ExpectedRecordName);
	}

	// This method for New Supplier Creation :
	public void createNewSupplier(String SupplierName,String PhNo,String Email,String DoorNo,String StreetName,String Area,String Address,String State,String City,String Zipcode,String CreditDays,String Vat,String GST,String Inactive) {
		
				if (btnAdd.isDisplayed()) {
					btnAdd.click();
                
					if (txtFirstName.isDisplayed()) {
						txtFirstName.sendKeys(SupplierName);
					} else {
						fnWriteSteps("Fail", "First name field is not enable");
					}
					if (txtPhoneNo.isDisplayed()) {
						txtPhoneNo.sendKeys(PhNo);
					} else {
						fnWriteSteps("Fail", "Phone No field is not enable");
					}
					if (txtEmail.isDisplayed()) {
						txtEmail.sendKeys(Email);
					} else {
						fnWriteSteps("Fail", "Email field is not enable");
					}
					if (txtDoorNo.isDisplayed()) {
						txtDoorNo.sendKeys(DoorNo);
					} else {
						fnWriteSteps("Fail", "Door no field is not enable");
					}
					if (txtStreetName.isDisplayed()) {
						txtStreetName.sendKeys(StreetName);
					} else {
						fnWriteSteps("Fail", "Street name field is not enable");
					}
					if (txtArea.isDisplayed()) {
						txtArea.sendKeys(Area);
					} else {
						fnWriteSteps("Fail", "Area field is not enable");
					}
					if (memoBillingAddress.isDisplayed()) {
						memoBillingAddress.sendKeys(Address);
					} else {
						fnWriteSteps("Fail", "Address field is not enable");
					}
					if (lookupState.isDisplayed()) {
						lookupState.sendKeys(State);
						lookupState.click();
					} else {
						fnWriteSteps("Fail", "State field is not enable");
					}
					if (lookupCity.isDisplayed()) {
						lookupCity.sendKeys(City);
						lookupCity.click();
					} else {
						fnWriteSteps("Fail", "City field is not enable");
					}
					if (txtZipCode.isDisplayed()) {
						txtZipCode.sendKeys(Zipcode);
					} else {
						fnWriteSteps("Fail", "Zip code field is not enable");
					}
					if (calcCreditDays.isDisplayed()) {
						calcCreditDays.sendKeys(CreditDays);
					} else {
						fnWriteSteps("Fail", "Credit days field is not enable");
					}
					
					if (txtVAT.isDisplayed()) {
						txtVAT.sendKeys(Vat);
					} else {
						fnWriteSteps("Fail", "VAT field is not enable");
					}
					if (txtGST.isDisplayed()) {
						txtGST.sendKeys(GST);
					} else {
						fnWriteSteps("Fail", "GST field is not enable");
					}
					if (chkActive.isSelected()) {
						switch (Inactive) {
						case "Inactive":
							chkActive.click();
							break;
						}
				 fnWriteSteps("Pass", "Active checkbox is checked by default ");
					} else {
						fnWriteSteps("Fail", "Active checkbox is not checked by default ");
					}

					btnSave.click();
					System.out.println("Supplier has been Created & Saved");
				}
      }
	
		// This method for Validation of New Supplier Creation :			
		public boolean Verify_SupplierCreation_Save_or_Not(String PhNo) {		
			
					if (TxtSearch.isDisplayed()) {
						GenericMethods.fnwait(3);
						TxtSearch.clear();
						TxtSearch.sendKeys(PhNo);

		            } else {
			fnWriteSteps("Fail", "Phone Number field is not displayed in UI");
			
		}
					GenericMethods.fnwait(2);
		           String Actual = driver.findElement(By.id("lblSupplierPhno")).getAttribute("Name");
	                 if(Actual.contains(PhNo)){
	                	 return true;
	                 } else {
	                	 return false;
	          
	              }
    } 

	// This method is for verifying the Supplier has been saved or not
	// Parameters are StartingRowNumber & LastRowNumber
	public void VerifySupplierSavedOrNot(int StartingRowNumber, int LastRowNumber) throws IOException {
		for (int StartFrom = StartingRowNumber; StartFrom <= LastRowNumber; StartFrom++) {
			TxtSearch.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Supplier", StartFrom, 0));
			clickEditButton();

			try {
				if (txtFirstName.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Supplier", StartFrom, 0))) {
					fnWriteSteps("Pass", "First Name is saved successfully");
				} else {
					fnWriteSteps("Fail", "First Name is not saved");
				}
				if (txtPhoneNo.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Supplier", StartFrom, 1))) {
					fnWriteSteps("Pass", "Phone No is saved successfully");
				} else {
					fnWriteSteps("Fail", "Phone No is not saved");
				}
				if (txtEmail.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Supplier", StartFrom, 2))) {
					fnWriteSteps("Pass", "Email is saved successfully");
				} else {
					fnWriteSteps("Fail", "Email is not saved");
				}
				if (txtDoorNo.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Supplier", StartFrom, 3))) {
					fnWriteSteps("Pass", "Door No is saved successfully");
				} else {
					fnWriteSteps("Fail", "Door No is not saved");
				}
				if (txtStreetName.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Supplier", StartFrom, 4))) {
					fnWriteSteps("Pass", "Street Name is saved successfully");
				} else {
					fnWriteSteps("Fail", "Street Name is not saved");
				}
				if (txtArea.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Supplier", StartFrom, 5))) {
					fnWriteSteps("Pass", "Area is saved successfully");
				} else {
					fnWriteSteps("Fail", "Area is not saved");
				}
				if (memoBillingAddress.getText().equals(ExcelUtils
						.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Supplier", StartFrom, 6))) {
					fnWriteSteps("Pass", "Address is saved successfully");
				} else {
					fnWriteSteps("Fail", "Address is not saved");
				}
				if (txtZipCode.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Supplier", StartFrom, 7))) {
					fnWriteSteps("Pass", "Zip Code is saved successfully");
				} else {
					fnWriteSteps("Fail", "Zip Code is not saved");
				}
				if (calcCreditDays.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Supplier", StartFrom, 7))) {
					fnWriteSteps("Pass", "Credit Days is saved successfully");
				} else {
					fnWriteSteps("Fail", "Credit Days is not saved");
				}
				if (calcInitialOutstanding.getText().equals(ExcelUtils
						.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Supplier", StartFrom, 7))) {
					fnWriteSteps("Pass", "Initial Outstanding is saved successfully");
				} else {
					fnWriteSteps("Fail", "Initial Outstanding is not saved");
				}
				if (txtVAT.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Supplier", StartFrom, 7))) {
					fnWriteSteps("Pass", "GST is saved successfully");
				} else {
					fnWriteSteps("Fail", "GST is not saved");
				}
				if (txtGST.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Supplier", StartFrom, 7))) {
					fnWriteSteps("Pass", "VAT is saved successfully");
				} else {
					fnWriteSteps("Fail", "VAT is not saved");
				}

				clickSaveButton();
				GenericMethods.fnwait(1);
				fnWriteSteps("Pass", "Supplier is saved successfully");

			} catch (Exception e) {
				fnWriteSteps("Fail", "Supplier is not saved successfully");
			}
		}
	}

	// This method is for verifying the Supplier edit
	
	public void VerifySupplierEdit(String OldSupplierPhNo,String SupplierName,String PhNo,String Email,String State,String City,String Address,String PinCode,String CreditDays,String VATNO,String GSTIN) {
		
		TxtSearch.sendKeys(OldSupplierPhNo);
		clickEditButton();
		GenericMethods.windows_Set_TextBoxValue(txtFirstName,SupplierName);
		GenericMethods.windows_Set_TextBoxValue(txtPhoneNo,PhNo);
		GenericMethods.windows_Set_TextBoxValue(txtEmail,Email);
		GenericMethods.windows_Set_TextBoxValue(lookupState,State);
		GenericMethods.windows_Set_TextBoxValue(lookupCity,City);
		GenericMethods.windows_Set_TextBoxValue(memoBillingAddress,Address);
		GenericMethods.windows_Set_TextBoxValue(txtZipCode,PinCode);
		GenericMethods.windows_Set_TextBoxValue(calcCreditDays,CreditDays);
		GenericMethods.windows_Set_TextBoxValue(txtVAT,VATNO);
		GenericMethods.windows_Set_TextBoxValue(txtGST,GSTIN);
		if (chkActive.isDisplayed()) {
			chkActive.click();
			fnWriteSteps("Pass", "Active checkbox is not checked by default ");
		} else {
			fnWriteSteps("Fail", "Active checkbox is checked by default ");
		}
		btnSave.click();
		System.out.println("Supplier has been Updated & Saved");
		
	}
	// This method for Validation of Supplier Edit :
	public boolean Verify_SupplierEdit_Save_or_Not(String PhNo) {		
	 	
		if (TxtSearch.isDisplayed()) {
			GenericMethods.fnwait(3);
			TxtSearch.clear();
			TxtSearch.sendKeys(PhNo);

        } else {
     fnWriteSteps("Fail", "Phone Number field is not displayed in UI");

   }
        GenericMethods.fnwait(2);
       String Actual = driver.findElement(By.id("lblSupplierPhno")).getAttribute("Name");
         if(Actual.contains(PhNo)){
        	 return true;
         } else {
        	 return false;
  
      }
	}
	
	// This method is to verify all the fields are visible or not

	public void VerifyFieldVisibility() {
		
			if (btnAdd.isDisplayed()) {
				btnAdd.click();

				if (txtFirstName.isDisplayed()) {
					fnWriteSteps("Pass", "First Name Type field is present");
				} else {
					fnWriteSteps("Fail", "First Name Type field is not present");
				}
				if (txtPhoneNo.isDisplayed()) {
					fnWriteSteps("Pass", "Phone No field is present");
				} else {
					fnWriteSteps("Fail", "Phone No field is not present");
				}
				if (txtEmail.isDisplayed()) {
					fnWriteSteps("Pass", "Email field is present");
				} else {
					fnWriteSteps("Fail", "Email field is not present");
				}
				if (chkActive.isDisplayed()) {
					fnWriteSteps("Pass", "Active checkbox is present");
				} else {
					fnWriteSteps("Fail", "Active checkbox is not present");
				}
				if (txtDoorNo.isDisplayed()) {
					fnWriteSteps("Pass", "Door no field is present");
				} else {
					fnWriteSteps("Fail", "Door no field is not present");
				}
				if (txtStreetName.isDisplayed()) {
					fnWriteSteps("Pass", "Street Name field is present");
				} else {
					fnWriteSteps("Fail", "Street Name field is not present");
				}
				if (txtArea.isDisplayed()) {
					fnWriteSteps("Pass", "Area field is present");
				} else {
					fnWriteSteps("Fail", "Area field is not present");
				}
				if (memoBillingAddress.isDisplayed()) {
					fnWriteSteps("Pass", "Address field is present");
				} else {
					fnWriteSteps("Fail", "Address field is not present");
				}
				
				if (lookupState.isDisplayed()) {
					fnWriteSteps("Pass", "State field is present");
				} else {
					fnWriteSteps("Fail", "State field is not present");
				}
				if (lookupCity.isDisplayed()) {
					fnWriteSteps("Pass", "City field is present");
				} else {
					fnWriteSteps("Fail", "City field is not present");
				}
				if (txtZipCode.isDisplayed()) {
					fnWriteSteps("Pass", "Zip Code field is present");
				} else {
					fnWriteSteps("Fail", "Zip Code field is not present");
				}
				
				if (calcCreditDays.isDisplayed()) {
					fnWriteSteps("Pass", "Credit Days field is present");
				} else {
					fnWriteSteps("Fail", "Credit Days field is not present");
				}
				
				if (txtVAT.isDisplayed()) {
					fnWriteSteps("Pass", "VAT field is present");
				} else {
					fnWriteSteps("Fail", "VAT field is not present");
				}
				if (txtGST.isDisplayed()) {
					fnWriteSteps("Pass", "GST field is present");
				} else {
					fnWriteSteps("Fail", "GST field is not present");
				}
			}
		}
	
	// This method is to verify all the fields are enable or not

	public void VerifyFieldEnableOrNot() {
		
			if (btnAdd.isDisplayed()) {
				btnAdd.click();

				if (txtFirstName.isEnabled()) {
					txtFirstName.click();
					fnWriteSteps("Pass", "First Name field is enable");
				} else {
					fnWriteSteps("Fail", "First Name field is not enable");
				}
				if (chkActive.isEnabled()) {
					chkActive.click();
					fnWriteSteps("Pass", "Active field is enable");
				} else {
					fnWriteSteps("Fail", "Active field is not enable");
				}
				if (txtPhoneNo.isEnabled()) {
					txtPhoneNo.click();
					fnWriteSteps("Pass", "Phone No field is enable");
				} else {
					fnWriteSteps("Fail", "Phone No field is not enable");
				}
				if (txtEmail.isEnabled()) {
					txtEmail.click();
					fnWriteSteps("Pass", "Email field is enable");
				} else {
					fnWriteSteps("Fail", "Email field is not enable");
				}
				if (txtDoorNo.isEnabled()) {
					txtDoorNo.click();
					fnWriteSteps("Pass", "Door No field is enable");
				} else {
					fnWriteSteps("Fail", "Door No field is not enable");
				}
				if (txtStreetName.isEnabled()) {
					txtStreetName.click();
					fnWriteSteps("Pass", "Street Name field is enable");
				} else {
					fnWriteSteps("Fail", "Street Name field is not enable");
				}
				if (txtArea.isEnabled()) {
					txtArea.click();
					fnWriteSteps("Pass", "Area field is enable");
				} else {
					fnWriteSteps("Fail", "Area field is not enable");
				}
				if (memoBillingAddress.isEnabled()) {
					memoBillingAddress.click();
					fnWriteSteps("Pass", "Address field is enable");
				} else {
					fnWriteSteps("Fail", "Address field is not enable");
				}
				
				if (lookupState.isEnabled()) {
					lookupState.click();
					
					fnWriteSteps("Pass", "State field is enable");
				} else {
					fnWriteSteps("Fail", "State field is not enable");
				}
				
				if (lookupCity.isEnabled()) {
					lookupCity.click();
					fnWriteSteps("Pass", "City field is not enable");
				} else {
					fnWriteSteps("Fail", "City field is enable");
				}
				if (txtZipCode.isEnabled()) {
					txtZipCode.click();
					fnWriteSteps("Pass", "Zip Code field is enable");
				} else {
					fnWriteSteps("Fail", "Zip Code field is not enable");
				}
				
				if (calcCreditDays.isEnabled()) {
					calcCreditDays.click();
					fnWriteSteps("Pass", "Credit Days field is enable");
				} else {
					fnWriteSteps("Fail", "Credit Days field is not enable");
				}
				
				if (txtVAT.isEnabled()) {
					txtVAT.click();
					fnWriteSteps("Pass", "VAT field is enable");
				} else {
					fnWriteSteps("Fail", "VAT field is not enable");
				}
				if (txtGST.isEnabled()) {
					txtGST.click();
					fnWriteSteps("Pass", "GST field is enable");
				} else {
					fnWriteSteps("Fail", "GST field is not enable");
				}
			}
		} 
	
	// This method for Access the Delete Button :
	public static void fnVerifyMasterRecordDelete(WebElement element) {

		GenericMethods.fnwait(2);
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
			r1.mouseMove(x1 + 370, y1 - 210);
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

	
	// This method for SupplierDelete :
	public void fnVerifySupplierDelete(String PhNo) {
		TxtSearch.click();
		TxtSearch.sendKeys(PhNo);
		GenericMethods.fnwait(1);
		fnVerifyMasterRecordDelete(grdRecordList);
		btnOk.click();
		GenericMethods.fnwait(30);
		System.out.println("Created Supplier has been Deleted");
	}
	// This method for Validation of Supplier Delete :
      public boolean Verify_SupplierDelete_SaveorNot(String PhNo) {
		
		if(TxtSearch.isDisplayed()) {
		   TxtSearch.clear();
		   TxtSearch.sendKeys(PhNo.trim());
			  
			}else {
				fnWriteSteps("Fail", "Phone Number field is not enable");
			}
		String Actual = driver.findElement(By.id("lblSupplierPhno")).getAttribute("Name");
	     if(!Actual.contains(PhNo.trim())){
			
			return true;
			
		} else {
			return false;
			
		}

		
		
	}
	/* 28-June-18-----Added by Moumita */
	/* This is the method to verify the record has been deleted successfully or not*/
	public void fnVerifySupplierDeleteSuccessfulOrNot(String strSupplierName) {
		TxtSearch.clear();
		TxtSearch.sendKeys(strSupplierName);
		String gridNoDataLabel = null;			

		WebElement messageEle = driver.findElement(By.id("lblNoData"));
		gridNoDataLabel = messageEle.getAttribute("Name");		
		if (gridNoDataLabel.contains("No supplier data found")) {
			fnWriteSteps("pass", "Record has been deleted successfully");
		} else
		{
			fnWriteSteps("pass", "Record has not been deleted");
		}
		
	}
}
