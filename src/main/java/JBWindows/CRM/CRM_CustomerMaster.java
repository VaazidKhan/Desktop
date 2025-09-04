package JBWindows.CRM;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class CRM_CustomerMaster extends BaseClass {
	// Header elements
	@FindBy(id = "picClose")
	WebElement btnClose;
	@FindBy(id = "lblCaption")
	WebElement PageCaption;
	@FindBy(id = "picLogo")
	WebElement HeaderJBLogo;

	// Master page button elements
	@FindBy(id = "CRM_CustomerMaster")
	WebElement PageName;
	@FindBy(id = "picClose")
	WebElement picClose;
	@FindBy(id = "btnAdd")
	WebElement BtnAdd;
	@FindBy(id = "btnSave")
	WebElement btnEdit;
	@FindBy(id = "TxtSearch")
	WebElement txtSearch;
	@FindBy(id = "switchCustomerType")
	WebElement switchCustomerType;
	@FindBy(id = "btnAdvanceReceived")
	WebElement btnAdvanceReceived;
	@FindBy(id = "btnPayment")
	WebElement btnPayment;
	@FindBy(id = "btnListView")
	WebElement btnListView;
	@FindBy(id = "grdCustomer")
	WebElement grdCustomer;
	@FindBy(name = "ToggleSwitch")
	WebElement ToogleSwitch;

	// Entry OR Edit page elements
	@FindBy(name = "Open")
	WebElement customerTypeClick;
	@FindBy(id = "cboCustomerType")
	WebElement cboCustomerType;
	@FindBy(id = "chkActive")
	WebElement chkActive;
	@FindBy(id = "txtFirstName")
	WebElement txtFirstName;
	@FindBy(id = "txtLastName")
	WebElement txtLastName;
	@FindBy(id ="txtPhoneNo")
	WebElement txtPhoneNo;
	@FindBy(id = "txtAltPhoneNo")
	WebElement txtAltPhoneNo;
	@FindBy(id = "txtEmail")
	WebElement txtEmail;
	@FindBy(id = "dtDateOfBirth")
	WebElement dtDateOfBirth;
	@FindBy(id = "dtAnniversary")
	WebElement dtAnniversary;
	@FindBy(id = "txtDoorNo")
	WebElement txtDoorNo;
	@FindBy(id = "txtStreetName")
	WebElement txtStreetName;
	@FindBy(id = "txtArea")
	WebElement txtArea;
	@FindBy(id = "txtZipCode")
	WebElement txtZipCode;
	@FindBy(id = "lookupState")
	WebElement lookupState;
	@FindBy(id = "lookupCity")
	WebElement lookupCity;
	@FindBy(id = "memoBillingAddress")
	WebElement memoBillingAddress;
	@FindBy(id = "lookUpLoyaltyType")
	WebElement lookUpLoyaltyType;
	@FindBy(id = "txtPAN")
	WebElement txtPAN;
	@FindBy(id = "calcCreditLimit")
	WebElement calcCreditLimit;
	@FindBy(id = "calcCreditDays")
	WebElement calcCreditDays;
	@FindBy(id = "calcInitialOutstanding")
	WebElement calcInitialOutstanding;
	@FindBy(id = "txtGST")
	WebElement txtGST;
	@FindBy(id = "txtVAT")
	WebElement txtvat;

	// Entry or Edit page elements
	@FindBy(id = "btnSave")
	WebElement btnSave;
	@FindBy(id = "btnCancel")
	WebElement btnCancel;

	// Details display side elements
	@FindBy(id = "picCustomer")
	WebElement picCustomer;
	@FindBy(id = "grdCustomerDocuments")
	WebElement grdCustomerDocuments;
	@FindBy(id = "lblCustomerPhno")
	WebElement lblCustomerPhno;
	@FindBy(id = "lblCustomerEmail")
	WebElement lblCustomerEmail;
	@FindBy(id = "lblLoyalty")
	WebElement lblLoyalty;
	@FindBy(id = "lblCustomerDob")
	WebElement lblCustomerDob;
	@FindBy(id = "lblDue")
	WebElement lblDue;
	@FindBy(id = "lblCustomerAnniversary")
	WebElement lblCustomerAnniversary;
	@FindBy(id = "lblLastPayment")
	WebElement lblLastPayment;
	@FindBy(id = "lblCustomerName")
	WebElement lblCustomerName;
	@FindBy(id = "lblNoOfOrders")
	WebElement lblNoOfOrders;
	@FindBy(id = "lblTotalOrderAmount")
	WebElement lblTotalOrderAmount;
	@FindBy(id = "memoCustomerAddress")
	WebElement memoCustomerAddress;
	@FindBy(id = "picActive")
	WebElement picActive;
	@FindBy(id = "lblCaptionTotalOrderValue")
	WebElement lblCaptionTotalOrderValue;
	@FindBy(id = "btnOk")
	WebElement btnOk;
	
	//Customer Discount Elements
	@FindBy(id="btnCustomerDiscount")
	WebElement CustomerDiscount;
	@FindBy(id="lookupProduct")
	WebElement Product;
	@FindBy(id="lookupDiscountRules")
	WebElement DiscountRules;
	@FindBy(id="lookupSchemeDiscountRules")
	WebElement SchemeDiscountRules;
	@FindBy(id = "txtSearch")
	WebElement TxtSearch;

	// ---25-April-2018--Added by Moumita--------
	@FindBy(id = "lblCustomerName")
	WebElement lblNoData;

	/* 28-June-18-----Added by Moumita */
	@FindBy(id = "grdCustomer")
	WebElement grdRecordList;
	@FindBy(id = "lblNoData")
	WebElement noCustomerLabel;
	
    // WebElement Initialization method
	public CRM_CustomerMaster() {
		PageFactory.initElements(driver, this);
	}
    // Operations
	public void activatePage() {
		PageName.click();
	}
	
    // Actions
	public void clickNewCustomer() {
		BtnAdd.click();
	}

	public void clickEditCustomer() {
		btnEdit.click();
	}

	public void clickSaveCustomer() {
		btnSave.click();
	}

	public void clickAdvanceReceived() {
		btnAdvanceReceived.click();
	}

	public void clickPayment() {
		btnPayment.click();
	}

	public void clickListView() {
		btnListView.click();
	}

	public void clickCancelButton() {
		btnCancel.click();
	}

	public void clickSwitchCustomer() {
		switchCustomerType.click();
	}


	public void clickCloseButton() {
		driver.findElement(By.id("picLogo")).click();
		picClose.click();
	}

	// This method is for creating the customer with taking the input from Excel
	// Parameters are StartingRowNumber & LastCountOfRecord
	// This method for New Customer Creation :
	public void createNewCustomer(String CustFirstName,String CustLastName,String Customertype,String PhoneNO,String AltPhoneNO,String Email,String DOB,String Anniversary,String DoorNO,String StreetName,String Area,String Pincode,String State,String City,String Address,String CreditDays,String CreditLimit,String VATNo,String GSTIN,String Inactive) {
		
	     System.out.println("Customer type is:" +Customertype);
	            GenericMethods.fnwait(2);
	        	 if (BtnAdd.isDisplayed()) {
	        		 BtnAdd.click();
					    GenericMethods.fnwait(1);
					    if (txtFirstName.isDisplayed()) {
					    	  GenericMethods.fnwait(1);
					    	  txtFirstName.sendKeys(CustFirstName.trim());
						} else {
							fnWriteSteps("Fail", "First Name field is not enable");
						}
					    if (txtPhoneNo.isDisplayed()) {
							txtPhoneNo.sendKeys(PhoneNO);
						} else {
							fnWriteSteps("Fail", "Phone No field is not enable");
						}
						if (txtAltPhoneNo.isDisplayed()) {
							txtAltPhoneNo.sendKeys(AltPhoneNO);
						} else {
							fnWriteSteps("Fail", "Alt Phone no field is not enable");
						}
						if (txtEmail.isDisplayed()) {
							txtEmail.sendKeys(Email);
						} else {
							fnWriteSteps("Fail", "Email field is not enable");
						}
						if (txtDoorNo.isDisplayed()) {
							txtDoorNo.sendKeys(DoorNO);
						} else {
							fnWriteSteps("Fail", "Door No field is not enable");
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
						if (txtZipCode.isDisplayed()) {
							txtZipCode.sendKeys(Pincode);
						} else {
							fnWriteSteps("Fail", "Zip code field is not enable");
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
						if (memoBillingAddress.isDisplayed()) {
							memoBillingAddress.sendKeys(Address);
						} else {
							fnWriteSteps("Fail", "Billing Address field is not enable");
						}
						
						if (calcCreditLimit.isDisplayed()) {
							calcCreditLimit.sendKeys(CreditLimit);
						} else {
							fnWriteSteps("Fail", "Credit Limit field is not enable");
						}
						if (calcCreditDays.isDisplayed()) {
							calcCreditDays.sendKeys(CreditDays);
						} else {
							fnWriteSteps("Fail", "Credit Days field is not enable");
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
					switch (Customertype) {
					case "B2C":
						GenericMethods.fnwait(1);
						customerTypeClick.click();
					    Actions act = new Actions(driver);
					    act.moveToElement(driver.findElement(By.name("B2C"))).click().build().perform();
						if(txtLastName.isDisplayed()){
					    	txtLastName.sendKeys(CustLastName);
					    } else {
					    	fnWriteSteps("Fail", "First Name field is not enable");
					    }
					   
					    if (dtDateOfBirth.isDisplayed()) {
							dtDateOfBirth.sendKeys(DOB);
							
						} if (dtAnniversary.isDisplayed()) {
							dtAnniversary.sendKeys(Anniversary);
						}
						
						clickSaveCustomer();
						System.out.println("B2C Customer record has been Created & Saved");
						GenericMethods.fnwait(1);
						clickListView();
			              GenericMethods.fnwait(3);
						clickCancelButton();
						break;
						
					case "B2B":
						GenericMethods.fnwait(2);
						customerTypeClick.click();
						GenericMethods.windows_Set_DropDown_Value(customerTypeClick, "B2B");
						GenericMethods.fnwait(2);
						if(txtvat.isDisplayed()) {
							txtvat.sendKeys(VATNo);
						 } else {
								fnWriteSteps("Fail", "VATNo is not displayed in UI");
						 }
						if(txtGST.isDisplayed()) {
							txtGST.sendKeys(GSTIN);
						 } else {
								fnWriteSteps("Fail", "VATNo is not displayed in UI");
						 }
								
						 clickSaveCustomer();
						GenericMethods.fnwait(2);
						System.out.println("B2B Customer record has been Created & Saved");
				      ToogleSwitch.click();
				      GenericMethods.fnwait(1);
					  clickListView();
		             GenericMethods.fnwait(3);
					clickCancelButton();
					break;
					}
			 }
	}
	// This method for Validation of New Customer Creation :
			 public boolean Verify_NewCustomerCreation_SaveorNot(String PhoneNO) {
				
				      if (txtSearch.isDisplayed()) {
				    	  txtSearch.clear();
			               txtSearch.sendKeys(PhoneNO.trim());
				
			            } else {
				fnWriteSteps("Fail", "CustomerName is not displayed in UI");
				
			}
					GenericMethods.fnwait(2);
		              String Actual = driver.findElement(By.id("lblCustomerPhno")).getAttribute("Name");
		              String Expected = PhoneNO;
		              if(Actual.contains(Expected.trim())){
		            	  return true;
		              }
		            	
				         return false;
		            
		        } 
			 
		

			
			

	// -------------31_Jan_2018 added by Moumita--------------

	// This method is for verifying the customer has been saved or not
	// Parameters are StartingRowNumber & LastRowNumber
	public void verifyCustomerSavedOrNot(int StartingRowNumber, int LastRowNumber) throws IOException {
		for (int StartFrom = StartingRowNumber; StartFrom <= LastRowNumber; StartFrom++) {
			txtSearch.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", StartFrom, 0));
			clickEditCustomer();

			try {
				if (txtFirstName.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Customers", StartFrom, 0))) {
					fnWriteSteps("Pass", "First Name is saved successfully");
				} else {
					fnWriteSteps("Fail", "First Name is not saved");
				}
				if (txtLastName.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Customers", StartFrom, 1))) {
					fnWriteSteps("Pass", "Last Name is saved successfully");
				} else {
					fnWriteSteps("Fail", "Last Name is not saved");
				}
				if (txtPhoneNo.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Customers", StartFrom, 3))) {
					fnWriteSteps("Pass", "Phone No is saved successfully");
				} else {
					fnWriteSteps("Fail", "Phone No is not saved");
				}
				if (txtAltPhoneNo.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Customers", StartFrom, 4))) {
					fnWriteSteps("Pass", "Alt Phone No is saved successfully");
				} else {
					fnWriteSteps("Fail", "Alt Phone No is not saved");
				}
				if (txtEmail.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Customers", StartFrom, 5))) {
					fnWriteSteps("Pass", "Email is saved successfully");
				} else {
					fnWriteSteps("Fail", "Email is not saved");
				}
				if (txtDoorNo.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Customers", StartFrom, 8))) {
					fnWriteSteps("Pass", "Door No is saved successfully");
				} else {
					fnWriteSteps("Fail", "Door No is not saved");
				}
				if (txtStreetName.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Customers", StartFrom, 9))) {
					fnWriteSteps("Pass", "Street Name is saved successfully");
				} else {
					fnWriteSteps("Fail", "Street Name is not saved");
				}
				if (txtArea.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Customers", StartFrom, 10))) {
					fnWriteSteps("Pass", "Area is saved successfully");
				} else {
					fnWriteSteps("Fail", "Area is not saved");
				}
				if (txtZipCode.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Customers", StartFrom, 11))) {
					fnWriteSteps("Pass", "Zip Code is saved successfully");
				} else {
					fnWriteSteps("Fail", "Zip Code is not saved");
				}
				if (memoBillingAddress.getText().equals(ExcelUtils
						.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", StartFrom, 14))) {
					fnWriteSteps("Pass", "Billing Address is saved successfully");
				} else {
					fnWriteSteps("Fail", "Billing Address is not saved");
				}
				if (txtPAN.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Customers", StartFrom, 16))) {
					fnWriteSteps("Pass", "PAN is saved successfully");
				} else {
					fnWriteSteps("Fail", "PAN is not saved");
				}
				float creditLimitFromExcel = Float.parseFloat(ExcelUtils
						.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", StartFrom, 17));
				System.out.println("creditLimitFromExcel" + creditLimitFromExcel);
				float creditLimitFromApp = Float.parseFloat(calcCreditLimit.getText());
				System.out.println("creditLimitFromApp" + creditLimitFromApp);
				if (creditLimitFromExcel == creditLimitFromApp) {
					fnWriteSteps("Pass", "Credit Limit is saved successfully");
				} else {
					fnWriteSteps("Fail", "Credit Limit is not saved");
				}
				if (calcCreditDays.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Customers", StartFrom, 18))) {
					fnWriteSteps("Pass", "Credit Days is saved successfully");
				} else {
					fnWriteSteps("Fail", "Credit Days is not saved");
				}
				float initialOutstandingFromExcel = Float.parseFloat(ExcelUtils
						.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", StartFrom, 19));
				float initialOutstandingFromApp = Float.parseFloat(calcInitialOutstanding.getText());

				if (initialOutstandingFromExcel == initialOutstandingFromApp) {
					fnWriteSteps("Pass", "Initial Outstanding is saved successfully");
				} else {
					fnWriteSteps("Fail", "Initial Outstanding is not saved");
				}
				clickSaveCustomer();
				fnWriteSteps("Pass", "Customer is saved successfully");

			} catch (Exception e) {
				fnWriteSteps("Fail", "Customer is not saved successfully");
			}
		}

	}

	// This method is for verifying the customer edit
	// Parameter is EditFieldOldValue, EditFieldName & EditedValue
	// This method for Customer Edit :
	public void verifyEditCustomer(String CustType, String OldCustPhno, String CustFirstName, String CustLastName,
			String Phno, String Email, String DoorNo, String StreetName, String State, String City, String Area,
			String Pincode, String Address, String DOB, String Anniversary, String CreditDays, String CreditLimit,
			String VATNo, String GSTIN) throws AWTException {

		System.out.println("Customer type is:" + CustType);
		if (CustType.equalsIgnoreCase("B2B")) {
			ToogleSwitch.click();
		}

		txtSearch.click();
		txtSearch.clear();
		txtSearch.sendKeys(OldCustPhno);
		clickEditCustomer();
		GenericMethods.fnwait(1);
		GenericMethods.windows_Set_TextBoxValue(txtFirstName, CustFirstName);
		
		if(txtPhoneNo.isDisplayed()) {
			GenericMethods.fnwait(3);
			Robot rr=new Robot();
			rr.keyPress(KeyEvent.VK_TAB);
			GenericMethods.fnwait(2);
			rr.keyPress(KeyEvent.VK_TAB);
			GenericMethods.fnwait(2);
			rr.keyPress(KeyEvent.VK_DELETE);
	        GenericMethods.fnwait(3);
		    txtPhoneNo.sendKeys(Phno);
		 }
		GenericMethods.windows_Set_TextBoxValue(txtEmail, Email);
		GenericMethods.windows_Set_TextBoxValue(txtDoorNo, DoorNo);
		GenericMethods.windows_Set_TextBoxValue(txtStreetName, StreetName);
		GenericMethods.windows_Set_TextBoxValue(lookupState, State);
		GenericMethods.windows_Set_TextBoxValue(lookupCity, City);
		GenericMethods.windows_Set_TextBoxValue(txtArea, Area);
		
		if(txtZipCode.isDisplayed()) {
			GenericMethods.fnwait(3);
			Robot rr=new Robot();
			rr.keyPress(KeyEvent.VK_TAB);
			GenericMethods.fnwait(2);
			rr.keyPress(KeyEvent.VK_TAB);
			GenericMethods.fnwait(2);
			rr.keyPress(KeyEvent.VK_DELETE);
		    GenericMethods.fnwait(3);
		    txtZipCode.sendKeys(Pincode);
			 }
		GenericMethods.windows_Set_TextBoxValue(memoBillingAddress, Address);
		GenericMethods.windows_Set_TextBoxValue(calcCreditDays, CreditDays);
		GenericMethods.windows_Set_TextBoxValue(calcCreditLimit, CreditLimit);

		if (chkActive.isDisplayed()) {
			chkActive.click();
			fnWriteSteps("Pass", "Active checkbox is not checked by default ");
		} else {
			fnWriteSteps("Fail", "Active checkbox is checked by default ");
		}
		switch (CustType) {
		case "B2C":

			GenericMethods.windows_Set_TextBoxValue(txtLastName, CustLastName);
			GenericMethods.windows_Set_TextBoxValue(dtDateOfBirth, DOB);
			GenericMethods.windows_Set_TextBoxValue(dtAnniversary, Anniversary);
			clickSaveCustomer();
			System.out.println("B2C Customer record has been Updated & Saved");
			
			break;
		case "B2B":
			GenericMethods.windows_Set_TextBoxValue(txtvat, VATNo);
			GenericMethods.windows_Set_TextBoxValue(txtGST, GSTIN);
			clickSaveCustomer();
			System.out.println("B2B Customer record has been Updated & Saved");
			break;
		}

	}
	// This method for Validation of customer Edit :
	public boolean Verify_EditCustomerCreation_SaveorNot(String Phno) {
		
	      if (txtSearch.isDisplayed()) {
	    	  txtSearch.clear();
              txtSearch.sendKeys(Phno.trim());
	
          } else {
	  fnWriteSteps("Fail", "CustomerName is not displayed in UI");
	
   }
		GenericMethods.fnwait(2);
        String Actual = driver.findElement(By.id("lblCustomerPhno")).getAttribute("Name");
        String Expected = Phno;
        if(Actual.contains(Expected)){
      	  return true;
        }
      	
	         return false;
      
   } 

	
	// This method is to verify all the fields are visible or not

	public void verifyFieldVisibility(int rowNumber) {
		String strCustomerType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
				rowNumber, 2);

		switch (strCustomerType.toUpperCase()) {
		case "B2B":
			GenericMethods.fnwait(2);
			switchCustomerType.click();
			GenericMethods.fnwait(3);

			if (BtnAdd.isDisplayed()) {
				BtnAdd.click();

				if (cboCustomerType.isDisplayed()) {
					fnWriteSteps("Pass", "Customer Type field is present");
				} else {
					fnWriteSteps("Fail", "Customer Type field is not present");
				}
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
				if (txtAltPhoneNo.isDisplayed()) {
					fnWriteSteps("Pass", "Alt Phone No field is present");
				} else {
					fnWriteSteps("Fail", "Alt Phone No field is not present");
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
				if (txtZipCode.isDisplayed()) {
					fnWriteSteps("Pass", "Zip Code field is present");
				} else {
					fnWriteSteps("Fail", "Zip Code field is not present");
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
				if (memoBillingAddress.isDisplayed()) {
					fnWriteSteps("Pass", "Address field is present");
				} else {
					fnWriteSteps("Fail", "Address field is not present");
				}

				if (calcCreditLimit.isDisplayed()) {
					fnWriteSteps("Pass", "Credit Limit field is present");
				} else {
					fnWriteSteps("Fail", "Credit Limit field is not present");
				}
				if (calcCreditDays.isDisplayed()) {
					System.out.println("All B2B-CustomerType Fields are Displayed");
					fnWriteSteps("Pass", "Credit Days field is present");
				} else {
					fnWriteSteps("Fail", "Credit Days field is not present");
				}

				break;

			}

		case "B2C":

			if (BtnAdd.isDisplayed()) {
				BtnAdd.click();

				if (cboCustomerType.isDisplayed()) {
					fnWriteSteps("Pass", "Customer Type field is present");
				} else {
					fnWriteSteps("Fail", "Customer Type field is not present");
				}
				if (txtFirstName.isDisplayed()) {
					fnWriteSteps("Pass", "First Name Type field is present");
				} else {
					fnWriteSteps("Fail", "First Name Type field is not present");
				}
				if (txtLastName.isDisplayed()) {
					fnWriteSteps("Pass", "Last Name Type field is present");
				} else {
					fnWriteSteps("Fail", "Last Name Type field is not present");
				}

				if (txtPhoneNo.isDisplayed()) {
					fnWriteSteps("Pass", "Phone No field is present");
				} else {
					fnWriteSteps("Fail", "Phone No field is not present");
				}
				if (txtAltPhoneNo.isDisplayed()) {
					fnWriteSteps("Pass", "Alt Phone No field is present");
				} else {
					fnWriteSteps("Fail", "Alt Phone No field is not present");
				}
				if (txtEmail.isDisplayed()) {
					fnWriteSteps("Pass", "Email field is present");
				} else {
					fnWriteSteps("Fail", "Email field is not present");
				}
				if (dtDateOfBirth.isDisplayed()) {
					fnWriteSteps("Pass", "Date Of Birth field is present");
				} else {
					fnWriteSteps("Fail", "Date Of Birth field is not present");
				}
				if (chkActive.isDisplayed()) {
					fnWriteSteps("Pass", "Active checkbox is present");
				} else {
					fnWriteSteps("Fail", "Active checkbox is not present");
				}
				if (dtAnniversary.isDisplayed()) {
					fnWriteSteps("Pass", "Anniversary field is present");
				} else {
					fnWriteSteps("Fail", "Anniversary field is not present");
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
				if (txtZipCode.isDisplayed()) {
					fnWriteSteps("Pass", "Zip Code field is present");
				} else {
					fnWriteSteps("Fail", "Zip Code field is not present");
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
				if (memoBillingAddress.isDisplayed()) {
					fnWriteSteps("Pass", "Address field is present");
				} else {
					fnWriteSteps("Fail", "Address field is not present");
				}

				if (calcCreditLimit.isDisplayed()) {
					fnWriteSteps("Pass", "Credit Limit field is present");
				} else {
					fnWriteSteps("Fail", "Credit Limit field is not present");
				}
				if (calcCreditDays.isDisplayed()) {
					System.out.println("All B2C-CustomerType Fields are Displayed");
					fnWriteSteps("Pass", "Credit Days field is present");
				} else {
					fnWriteSteps("Fail", "Credit Days field is not present");
				}

				break;

			}
		}
	}

	// This method is to verify all the fields are enable or not

	public void verifyFieldEnableOrNot(int rowNumber) {
		String strCustomerType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
				rowNumber, 2);
		switch (strCustomerType.toUpperCase()) {
		case "B2B":
			GenericMethods.fnwait(2);
			switchCustomerType.click();
			GenericMethods.fnwait(3);

			if (BtnAdd.isDisplayed()) {
				BtnAdd.click();

				if (cboCustomerType.isEnabled()) {
					cboCustomerType.click();
					fnWriteSteps("Pass", "Customer Type field is enable");
				} else {
					fnWriteSteps("Fail", "Customer Type field is not enable");
				}
				if (chkActive.isEnabled()) {
					chkActive.click();
					fnWriteSteps("Pass", "Active field is enable");
				} else {
					fnWriteSteps("Fail", "Active field is not enable");
				}
				if (txtFirstName.isEnabled()) {
					txtFirstName.click();
					fnWriteSteps("Pass", "Customer Name field is enable");
				} else {
					fnWriteSteps("Fail", "Customer Name field is not enable");
				}

				if (txtPhoneNo.isEnabled()) {
					txtPhoneNo.click();
					fnWriteSteps("Pass", "Phone No field is enable");
				} else {
					fnWriteSteps("Fail", "Phone No field is not enable");
				}
				if (txtAltPhoneNo.isEnabled()) {
					txtAltPhoneNo.click();
					fnWriteSteps("Pass", "Alt Phone No field is enable");
				} else {
					fnWriteSteps("Fail", "Alt Phone No field is not enable");
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
				if (txtZipCode.isEnabled()) {
					txtZipCode.click();
					fnWriteSteps("Pass", "Zip Code field is enable");
				} else {
					fnWriteSteps("Fail", "Zip Code field is not enable");
				}
				if (lookupState.isEnabled()) {
					lookupState.click();
					lookupState.click();
					fnWriteSteps("Pass", "State field is enable");
				} else {
					fnWriteSteps("Fail", "State field is not enable");
				}
				if (lookupCity.isEnabled()) {
					lookupCity.click();
					lookupCity.click();
					fnWriteSteps("Pass", "City field is enable");
				} else {
					fnWriteSteps("Fail", "City field is not enable");
				}
				if (memoBillingAddress.isEnabled()) {
					memoBillingAddress.click();
					fnWriteSteps("Pass", "Address field is enable");
				} else {
					fnWriteSteps("Fail", "Address field is not enable");
				}

				if (calcCreditLimit.isEnabled()) {
					calcCreditLimit.click();
					fnWriteSteps("Pass", "Credit Limit field is enable");
				} else {
					fnWriteSteps("Fail", "Credit Limit field is not enable");
				}
				if (calcCreditDays.isEnabled()) {
					calcCreditDays.click();
					System.out.println("All B2B-CustomerType Fields are Enabled");
					fnWriteSteps("Pass", "Credit Days field is enable");
				} else {
					fnWriteSteps("Fail", "Credit Days field is not enable");
				}

			}
			break;

		case "B2C":
			
			if (BtnAdd.isDisplayed()) {
				BtnAdd.click();

				if (cboCustomerType.isEnabled()) {
					cboCustomerType.click();
					fnWriteSteps("Pass", "Customer Type field is enable");
				} else {
					fnWriteSteps("Fail", "Customer Type field is not enable");
				}
				if (txtLastName.isEnabled()) {
					txtLastName.click();
					fnWriteSteps("Pass", "Last Name field is enable");
				} else {
					fnWriteSteps("Fail", "Last Name field is not enable");
				}
				
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
				if (txtAltPhoneNo.isEnabled()) {
					txtAltPhoneNo.click();
					fnWriteSteps("Pass", "Alt Phone No field is enable");
				} else {
					fnWriteSteps("Fail", "Alt Phone No field is not enable");
				}
				if (txtEmail.isEnabled()) {
					txtEmail.click();
					fnWriteSteps("Pass", "Email field is enable");
				} else {
					fnWriteSteps("Fail", "Email field is not enable");
				}
				if (dtDateOfBirth.isEnabled()) {
					dtDateOfBirth.click();
					fnWriteSteps("Pass", "Date Of Birth field is enable");
				} else {
					fnWriteSteps("Fail", "Date Of Birth field is not enable");
				}
				if (dtAnniversary.isEnabled()) {
					dtAnniversary.click();
					fnWriteSteps("Pass", "Anniversary field is enable");
				} else {
					fnWriteSteps("Fail", "Anniversary field is not enable");
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
				if (txtZipCode.isEnabled()) {
					txtZipCode.click();
					fnWriteSteps("Pass", "Zip Code field is enable");
				} else {
					fnWriteSteps("Fail", "Zip Code field is not enable");
				}
				if (lookupState.isEnabled()) {
					lookupState.click();
					lookupState.click();
					fnWriteSteps("Pass", "State field is enable");
				} else {
					fnWriteSteps("Fail", "State field is not enable");
				}
				if (lookupCity.isEnabled()) {
					lookupCity.click();
					lookupCity.click();
					fnWriteSteps("Pass", "City field is enable");
				} else {
					fnWriteSteps("Fail", "City field is not enable");
				}
				if (memoBillingAddress.isEnabled()) {
					memoBillingAddress.click();
					fnWriteSteps("Pass", "Address field is enable");
				} else {
					fnWriteSteps("Fail", "Address field is not enable");
				}

				if (calcCreditLimit.isEnabled()) {
					calcCreditLimit.click();
					fnWriteSteps("Pass", "Credit Limit field is enable");
				} else {
					fnWriteSteps("Fail", "Credit Limit field is not enable");
				}
				if (calcCreditDays.isEnabled()) {
					calcCreditDays.click();
					System.out.println("All B2C-CustomerType Fields are Enabled");
					fnWriteSteps("Pass", "Credit Days field is enable");
				} else {
					fnWriteSteps("Fail", "Credit Days field is not enable");
				}

			}
			break;
		}
	}
	
	// ---8-Feb-2018 added by Moumita--------------
	// This method is for verifying runtime customer has been saved or not
	// Parameter is RowNumber

	public void VerifyRuntimeCustomerSavedOrNot(int RowNumber) {
		txtSearch.sendKeys(
				ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", RowNumber, 0));
		clickEditCustomer();

		try {
			if (txtFirstName.getText().equals(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", RowNumber, 0))) {
				fnWriteSteps("Pass", "First Name is saved successfully");
			} else {
				fnWriteSteps("Fail", "First Name is not saved");
			}
			if (txtLastName.getText().equals(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", RowNumber, 1))) {
				fnWriteSteps("Pass", "Last Name is saved successfully");
			} else {
				fnWriteSteps("Fail", "Last Name is not saved");
			}
			if (txtPhoneNo.getText().equals(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", RowNumber, 3))) {
				fnWriteSteps("Pass", "Phone No is saved successfully");
			} else {
				fnWriteSteps("Fail", "Phone No is not saved");
			}
			if (txtEmail.getText().equals(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", RowNumber, 5))) {
				fnWriteSteps("Pass", "Email is saved successfully");
			} else {
				fnWriteSteps("Fail", "Email is not saved");
			}
			if (txtDoorNo.getText().equals(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", RowNumber, 8))) {
				fnWriteSteps("Pass", "Door No is saved successfully");
			} else {
				fnWriteSteps("Fail", "Door No is not saved");
			}
			if (txtStreetName.getText().equals(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", RowNumber, 9))) {
				fnWriteSteps("Pass", "Street Name is saved successfully");
			} else {
				fnWriteSteps("Fail", "Street Name is not saved");
			}
			if (txtArea.getText().equals(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", RowNumber, 10))) {
				fnWriteSteps("Pass", "Area is saved successfully");
			} else {
				fnWriteSteps("Fail", "Area is not saved");
			}
			if (txtZipCode.getText().equals(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", RowNumber, 11))) {
				fnWriteSteps("Pass", "Zip Code is saved successfully");
			} else {
				fnWriteSteps("Fail", "Zip Code is not saved");
			}
			if (memoBillingAddress.getText().equals(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", RowNumber, 14))) {
				fnWriteSteps("Pass", "Billing Address is saved successfully");
			} else {
				fnWriteSteps("Fail", "Billing Address is not saved");
			}

			clickSaveCustomer();
			fnWriteSteps("Pass", "Customer is saved successfully");

		} catch (Exception e) {
			fnWriteSteps("Fail", "Customer is not saved successfully");
		}
	}

	// ---25-April-2018--Added by Moumita--------

	public String getNoDatalabelText() {
		String noDatalabelText = null;
		WebElement noDatalabelTextEle = driver.findElement(By.id("lblCustomerName"));
		noDatalabelText = noDatalabelTextEle.getAttribute("Name");
		return noDatalabelText;
	}

	public void fnSelectCustomerAndOpenAdvanceReceivedWindow(int rowNumber) {

		txtSearch.click();
		txtSearch.sendKeys(
				ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Estimations", rowNumber, 0));
		GenericMethods.fnwait(1);
		String noDatalabelText = getNoDatalabelText();
		GenericMethods.fnwait(1);
		if (noDatalabelText.contains("Please add a customer")) {
			GenericMethods.fnwait(1);
			switchCustomerType.click();
			GenericMethods.fnwait(1);
			txtSearch.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Estimations", rowNumber, 0));
			GenericMethods.fnwait(1);
			btnAdvanceReceived.click();
		} else {
			btnAdvanceReceived.click();
			GenericMethods.fnwait(1);
		}

	}

	/*
	 * 28-June-18-----Added by Moumita
	 * 
	 * @purpose: This is the method to delete the record by delete icon from Agent
	 * master page
	 * 
	 * @Parameter: element
	 */
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
			r1.mouseMove(x1 + 310, y1 - 200);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		GenericMethods.fnwait(1);
		Actions builder1 = new Actions(driver);
		builder1.click().build().perform();
	}
  //This method for To click on YES Button :
	public void click_On_Yes_Button() {
		driver.findElement(By.id("lblHeader")).click();
		GenericMethods.fnwait(1);
		btnOk.click();
		
	}

	/* 28-June-18-----Added by Moumita */
	/* This is the method to delete the record by delete icon from master page */
	// This method for CustomerDelete :
	public void fnVerifyCustomerDelete(String PhNo, String Customertype) {
		switch (Customertype.toUpperCase()) {
		case "B2B":
			GenericMethods.fnwait(1);
			switchCustomerType.click();
			GenericMethods.fnwait(1);
			txtSearch.click();
			txtSearch.sendKeys(PhNo);
			GenericMethods.fnwait(1);
			fnVerifyMasterRecordDelete(grdRecordList);
			btnOk.click();
			GenericMethods.fnwait(34);
			System.out.println("Created B2B_Customer has been Deleted");
			break;
		case "B2C":
			GenericMethods.fnwait(1);
			txtSearch.click();
			txtSearch.sendKeys(PhNo);
			GenericMethods.fnwait(1);
			fnVerifyMasterRecordDelete(grdRecordList);
			btnOk.click();
			GenericMethods.fnwait(32);
			System.out.println("Created B2C_Customer has been Deleted");
			break;
		}
	}
	// This method for Validation of CustomerDelete :
      public boolean Verify_CustomerDelete_SaveorNot(String PhNo) {
		
		if(txtSearch.isDisplayed()) {
			   txtSearch.clear();
			   txtSearch.click();
			   txtSearch.sendKeys(PhNo.trim());
			  
			}else {
				fnWriteSteps("Fail", "Product name field is not enable");
			}
		String Actual = driver.findElement(By.id("lblCustomerPhno")).getAttribute("Name");
		if(!Actual.contains(PhNo.trim())){
			
			return true;
			
		} else {
			return false;
			
		}

		
		
	}
	/* 28-June-18-----Added by Moumita */
	/*
	 * This is the method to verify the record has been deleted successfully or not
	 */
	public void fnVerifyCustomerDeleteSuccessfulOrNot(String strCustomerName, String strCustomerType) {
		switch (strCustomerType.toUpperCase()) {

		case "B2B":

			switchCustomerType.click();
			GenericMethods.fnwait(1);
			if (txtSearch.isDisplayed()) {
				txtSearch.clear();
				txtSearch.sendKeys(strCustomerName);
				String gridNoDataLabel_B2B = null;

				WebElement messageEle_B2B = driver.findElement(By.id("lblNoData"));
				gridNoDataLabel_B2B = messageEle_B2B.getAttribute("Name");
				if (gridNoDataLabel_B2B.contains("No customer found")) {
					fnWriteSteps("pass", "Record has been deleted successfully");
				} else {
					fnWriteSteps("pass", "Record has not been deleted");
				}
			} else {
				String gridZeroDataLabel_B2B = null;
				WebElement messageZeroEle_B2B = driver.findElement(By.id("lblNoData"));
				gridZeroDataLabel_B2B = messageZeroEle_B2B.getAttribute("Name");
				if (gridZeroDataLabel_B2B.contains("Let's get started by adding")) {
					fnWriteSteps("pass", "Record has been deleted successfully");
				} else {
					fnWriteSteps("pass", "Record has not been deleted");
				}
			}
			break;
		case "B2C":
			if (txtSearch.isDisplayed()) {
				txtSearch.clear();
				txtSearch.sendKeys(strCustomerName);
				String gridNoDataLabel_B2C = null;

				WebElement messageEle_B2C = driver.findElement(By.id("lblNoData"));
				gridNoDataLabel_B2C = messageEle_B2C.getAttribute("Name");
				if (gridNoDataLabel_B2C.contains("No customer found")) {
					fnWriteSteps("pass", "Record has been deleted successfully");
				} else {
					fnWriteSteps("pass", "Record has not been deleted");
				}
			} else {
				String gridZeroDataLabel_B2C = null;
				WebElement messageZeroEle_B2C = driver.findElement(By.id("lblNoData"));
				gridZeroDataLabel_B2C = messageZeroEle_B2C.getAttribute("Name");
				if (gridZeroDataLabel_B2C.contains("Let's get started by adding")) {
					fnWriteSteps("pass", "Record has been deleted successfully");
				} else {
					fnWriteSteps("pass", "Record has not been deleted");
				}
				break;
			}
		}
	}
	//This method for MultiDiscount Creation :
	public void fnVerifyMultiDiscount_Creation(String CustType,String CustName,String DRS,String Product1,String DRs,String DRs1,String SchemeDR,String SchemeDR1) throws FindFailed {
		HeaderJBLogo.click();
		if (CustType.equalsIgnoreCase("B2B")) {
			ToogleSwitch.click();
		}
		txtSearch.click();
		txtSearch.sendKeys(CustName);
		 GenericMethods.fnwait(1);
		CustomerDiscount.click();
		HeaderJBLogo.click();
	    clickNewCustomer();
		GenericMethods.windows_Set_DropDown_Value(Product, Product1);
		GenericMethods.windows_Set_DropDown_Value(DiscountRules,DRs);
		switch (DRS) {
		case "OnlyDR":
			clickSaveCustomer();
		    HeaderJBLogo.click();
		    TxtSearch.sendKeys(Product1);
		    btnEdit.click();
		    GenericMethods.fnwait(1);
		    GenericMethods.windows_Set_DropDown_Value(DiscountRules,DRs1);
		    break;
		case "Both":
	   GenericMethods.windows_Set_DropDown_Value(SchemeDiscountRules,SchemeDR );
	     clickSaveCustomer();
	    HeaderJBLogo.click();
	    TxtSearch.sendKeys(Product1);
	    btnEdit.click();
	    GenericMethods.fnwait(1);
	    GenericMethods.windows_Set_DropDown_Value(SchemeDiscountRules,SchemeDR1);
	    break;
		}
		 clickSaveCustomer();
}
	//This method for Validation of MultiDiscountCreation :
	public boolean Verify_MultiDiscountCreation_SaveorNot(String ProductName) {
		   HeaderJBLogo.click();
		   GenericMethods.fnwait(2);
	      if (TxtSearch.isDisplayed()) {
	    	  TxtSearch.clear();
	    	  TxtSearch.sendKeys(ProductName.trim());
	
          } else {
	fnWriteSteps("Fail", "ProductName is not displayed in UI");
	
}       
	    GenericMethods.fnwait(2);
        String Actual = "No customer discount found.";
        String Expected = ProductName;
        if(!Actual.contains(Expected.trim())){
      	  return true;
        }
      	
	      return false;
      
  } 
	// This method for CustomerDiscount Delete :
	public void fnVerifyCustomerDiscount_Deletion(String CustType,String CustName,String ProductName) throws FindFailed {
		HeaderJBLogo.click();
		if (CustType.equalsIgnoreCase("B2B")) {
			ToogleSwitch.click();
		}
		  txtSearch.click();
		  txtSearch.sendKeys(CustName);
		  GenericMethods.fnwait(1);
		  CustomerDiscount.click();
		  GenericMethods.fnwait(1);
		  HeaderJBLogo.click();
		  TxtSearch.sendKeys(ProductName);
		  GenericMethods.fnwait(1);
		  Screen sr = new Screen();
		  Pattern pr = new Pattern("E:\\Projects\\QAAutomation\\TestScripts\\Windows\\Sikuli-Images\\Delete2.PNG");
	      sr.click(pr);
    	  GenericMethods.fnwait(34);
		  System.out.println("Created CustomerDiscount has been Deleted");
			
	}
	//This method for Validation of CustomerDiscountDelete :
	public boolean Verify_CustomerDiscount_Delete_SaveorNot(String ProductName) {
		   HeaderJBLogo.click();
		   GenericMethods.fnwait(2);
	      if (TxtSearch.isDisplayed()) {
	    	  TxtSearch.clear();
	    	  TxtSearch.sendKeys(ProductName.trim());
	
       } else {
	fnWriteSteps("Fail", "ProductName is not displayed in UI");
	
}       
	    GenericMethods.fnwait(2);
     String Actual = driver.findElement(By.id("lblEditNoData")).getAttribute("Name");
     String Expected = driver.findElement(By.id("lblNoData")).getAttribute("Name");
     if(Actual.contains(Expected.trim())){
   	  return true;
     }
   	
	      return false;
   
} 
}

