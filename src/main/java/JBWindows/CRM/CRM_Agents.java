package JBWindows.CRM;

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
import org.openqa.selenium.support.ui.WebDriverWait;

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
	@FindBy(id = "txtSearch")
	WebElement txtSearch;
	@FindBy(id = "grdAgents")
	WebElement grdAgents;

	// Entry OR Edit screen elements
	@FindBy(id = "txtFirstName")
	WebElement txtFirstName;
	@FindBy(id = "txtLastName")
	WebElement txtLastName;
	@FindBy(id = "txtPhoneNo")
	WebElement txtPhoneNo;
	@FindBy(id = "chkActive")
	WebElement chkActive;
	@FindBy(id = "txtEmail")
	WebElement txtEmail;
	@FindBy(id = "dtDateOfBirth")
	WebElement dtDateOfBirth;
	@FindBy(id = "dtAnniversary")
	WebElement dtAnniversary;
	@FindBy(id = "txtArea")
	WebElement txtArea;
	@FindBy(id = "calcCommissionRate")
	WebElement calcCommissionRate;
	@FindBy(id = "memoAddress")
	WebElement memoAddress;

	// Buttons elements
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
	@FindBy(id = "grdAgents")
	WebElement grdRecordList;
	@FindBy(id = "lblNoData")
	WebElement noAgentLabel; 

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

	// ----------31-Jan-2018----added by Moumita---------------
	// The method for creating Agent with taking the input from excel
	// Parameters are StartingRowNumber & LastRowNumber
	
	//This method for New Agent Creation :
	public void createNewAgent(String FirstName,String LastName,String PhoneNum,String Email,String DOB,String Anniversary,String Area,String CommissionRate,String Address,String Inactive) {
		          
		             if (btnAdd.isDisplayed()) {
			                 btnAdd.click();
		            if (txtFirstName.isDisplayed()) {
						txtFirstName.sendKeys(FirstName);
					} else {
						fnWriteSteps("Fail", "First Name field is not enable");
					}
					if (txtLastName.isDisplayed()) {
						txtLastName.sendKeys(LastName);
					} else {
						fnWriteSteps("Fail", "Last Name field is not enable");
					}
					if (txtPhoneNo.isDisplayed()) {
						txtPhoneNo.sendKeys(PhoneNum);
					} else {
						fnWriteSteps("Fail", "Phone No field is not enable");
					}
					if (txtEmail.isDisplayed()) {
						txtEmail.sendKeys(Email);
					} else {
						fnWriteSteps("Fail", "Email field is not enable");
					}
					if (dtDateOfBirth.isDisplayed()) {
						dtDateOfBirth.sendKeys(DOB);
					} else {
						fnWriteSteps("Fail", "Date Of Birth field is not enable");
					}
					if (dtAnniversary.isDisplayed()) {
						dtAnniversary.sendKeys(Anniversary);
					} else {
						fnWriteSteps("Fail", "Annyversary field is not enable");
					}
					if (txtArea.isDisplayed()) {
						txtArea.sendKeys(Area);
					} else {
						fnWriteSteps("Fail", "Area field is not enable");
					}
					if (calcCommissionRate.isDisplayed()) {
						calcCommissionRate.sendKeys(CommissionRate);
					} else {
						fnWriteSteps("Fail", "Commission Rate field is not enable");
					}
					if (memoAddress.isDisplayed()) {
						memoAddress.sendKeys(Address);
					} else {
						fnWriteSteps("Fail", "Address field is not enable");
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

					clickSaveButton();
					System.out.println("Agent has been created & Saved");
					
		  }
	}
	
	 // This method for Validation of New Agent Creation :
	     public boolean Verify_NewAgentCreation_SaveorNot(String FirstName) {
		            	  
				if (txtSearch.isDisplayed()) {
					txtSearch.clear();
					txtSearch.sendKeys(FirstName);
				 } else {  fnWriteSteps("Fail", "AgentName is not displayed in UI");
						   
                }
					 String Actual = driver.findElement(By.id("lblAgentName")).getAttribute("Name");
					 if (Actual.substring(15,22).trim().substring(0,3).trim().equalsIgnoreCase(FirstName.trim().substring(0, 3).trim())) {
								
							   return true;
							}
							
							   return false;
						}	
					
					
					
	
			
	// This method is for verifying the Agent has been saved or not
	// Parameters are StartingRowNumber & LastRowNumber
	public void verifyAgentSavedOrNot(int StartingRowNumber, int LastRowNumber) throws IOException {
		for (int StartFrom = StartingRowNumber; StartFrom <= LastRowNumber; StartFrom++) {
			txtSearch.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Agents", StartFrom, 0));
			clickEditButton();

			try {
				if (txtFirstName.getText().equals(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Agents", StartFrom, 0))) {
					fnWriteSteps("Pass", "First Name is saved successfully");
				} else {
					fnWriteSteps("Fail", "First Name is not saved");
				}
				if (txtLastName.getText().equals(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Agents", StartFrom, 1))) {
					fnWriteSteps("Pass", "Last Name is saved successfully");
				} else {
					fnWriteSteps("Fail", "Last Name is not saved");
				}
				if (txtPhoneNo.getText().equals(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Agents", StartFrom, 2))) {
					fnWriteSteps("Pass", "Phone No is saved successfully");
				} else {
					fnWriteSteps("Fail", "Phone No is not saved");
				}
				if (txtEmail.getText().equals(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Agents", StartFrom, 3))) {
					fnWriteSteps("Pass", "Email is saved successfully");
				} else {
					fnWriteSteps("Fail", "Email is not saved");
				}
				if (txtArea.getText().equals(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Agents", StartFrom, 6))) {
					fnWriteSteps("Pass", "Area is saved successfully");
				} else {
					fnWriteSteps("Fail", "Area is not saved");
				}
				
				float commissionRateFromExcel = Float.parseFloat(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Agents", StartFrom, 7));							
				float commissionRateFromApp = Float.parseFloat(calcCommissionRate.getText());			
				if (commissionRateFromApp == commissionRateFromExcel) {
					fnWriteSteps("Pass", "Commission Rate is saved successfully");
				} else {					
					fnWriteSteps("Fail", "Commission Rate is not saved");
				}
				if (memoAddress.getText().equals(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Agents", StartFrom, 8))) {
					fnWriteSteps("Pass", "Address is saved successfully");
				} else {
					fnWriteSteps("Fail", "Address is not saved");
				}

				clickSaveButton();
				fnWriteSteps("Pass", "Agent is saved successfully");

			} catch (Exception e) {
				fnWriteSteps("Fail", "Agent is not saved successfully");
			}
		}
	}

	// This method is for verifying the Agent edit
	// Parameter is EditFieldOldValue, EditFieldName & EditedValue
	
	// This method for Agent Edit :
	public void verifyAgentEdit(String OldFirstName,String FirstName,String LastName,String PhNo,String Email,String DOB,String Anniversary) {
		
		  txtSearch.sendKeys(OldFirstName);
		  clickEditButton();
		  GenericMethods.windows_Set_TextBoxValue(txtFirstName, FirstName);
		  GenericMethods.windows_Set_TextBoxValue(txtLastName, LastName);
		  GenericMethods.windows_Set_TextBoxValue(txtPhoneNo,PhNo );
		  GenericMethods.windows_Set_TextBoxValue(txtEmail,Email);
		  GenericMethods.windows_Set_TextBoxValue(dtDateOfBirth,DOB );
		  GenericMethods.windows_Set_TextBoxValue(dtAnniversary,Anniversary);
	    
	      if (chkActive.isDisplayed()) {
	    	  chkActive.click();
				fnWriteSteps("Pass", "Active checkbox is not checked by default ");
			} else {
				fnWriteSteps("Fail", "Active checkbox is checked by default ");
			}
		  clickSaveButton();
		  System.out.println("Agent has been Updated & Saved");

	}
	 // This method for Validation of Agent Edit :
	    public boolean Verify_AgentEdit_SaveorNot(String FirstName) {
   	  
			if (txtSearch.isDisplayed()) {
				txtSearch.clear();
				txtSearch.sendKeys(FirstName);

			} else {
				fnWriteSteps("Fail", "AgentName is not displayed in UI");

			}
			String Actual = driver.findElement(By.id("lblAgentName")).getAttribute("Name");
			if (Actual.substring(14,21).equalsIgnoreCase(FirstName.trim())) {
				
			   return true;
			}
			   return false;
		}	

		
	    
	// ---------3-Feb-2018 added by Moumita-------------------
	    
	// This method is to verify all the fields are visible or not
	    
        public void verifyFieldVisibility() {
		
		        if (btnAdd.isDisplayed()) {
			          btnAdd.click();
		
                if (txtFirstName.isDisplayed()) {
					fnWriteSteps("Pass", "First Name field is present");
				} else {
					fnWriteSteps("Fail", "First Name field is not present");
				}
                if (txtLastName.isDisplayed()) {
					fnWriteSteps("Pass", "Last Name field is present");
				} else {
					fnWriteSteps("Fail", "Last Name field is not present");
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
				if (txtArea.isDisplayed()) {
					fnWriteSteps("Pass", "Area field is present");
				} else {
					fnWriteSteps("Fail", "Area field is not present");
				}
				if (memoAddress.isDisplayed()) {
					fnWriteSteps("Pass", "Address field is present");
				} else {
					fnWriteSteps("Fail", "Address field is not present");
				}
				if (calcCommissionRate.isDisplayed()) {
					fnWriteSteps("Pass", "Commission Rate field is present");
				} else {
					fnWriteSteps("Fail", "Commission Rate field is not present");
				}
				if (dtDateOfBirth.isDisplayed()) {
					fnWriteSteps("Pass", "Date of Birth field is present");
				} else {
					fnWriteSteps("Fail", "Date of Birth field is not present");
				}
				if (dtAnniversary.isDisplayed()) {
					System.out.println(" Successfully all fields are Displayed ");
					fnWriteSteps("Pass", "Anniversary field is present");
				} else {
					fnWriteSteps("Fail", "Anniversary field is not present");
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
				}
		        if (txtLastName.isDisplayed()) {
					fnWriteSteps("Pass", "Last Name field is enable");
				} else {
					fnWriteSteps("Fail", "Last Name field is not enable");
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
				if (txtArea.isEnabled()) {
					txtArea.click();
					fnWriteSteps("Pass", "Area field is enable");
				} else {
					fnWriteSteps("Fail", "Area field is not enable");
				}
				if (memoAddress.isEnabled()) {
					memoAddress.click();
					fnWriteSteps("Pass", "Address field is enable");
				} else {
					fnWriteSteps("Fail", "Address field is not enable");
				}
				if (calcCommissionRate.isEnabled()) {
					calcCommissionRate.click();
					fnWriteSteps("Pass", "CommissionRate field is enable");
				} else {
					fnWriteSteps("Fail", "CommissionRate field is not enable");
				}
				if (dtDateOfBirth.isEnabled()) {
					dtDateOfBirth.click();
					fnWriteSteps("Pass", "Date of Birth field is enable");
				} else {
					fnWriteSteps("Fail", "Date of Birth field is not enable");
				}
				if (dtAnniversary.isEnabled()) {
					dtAnniversary.click();
					System.out.println(" Successfully all fields are Enabled ");
					fnWriteSteps("Pass", "Anniversary field is enable");
				} else {
					fnWriteSteps("Fail", "Anniversary field is not enable");
				}
			}
	}
		
	
	/*
	 * 28-June-18-----Added by Moumita
	 * @purpose: This is the method to delete the record by delete icon from
	 * Agent master page 
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
	/* 28-June-18-----Added by Moumita */
	/* This is the method to delete the record by delete icon from master page */
	
	// This method for AgentDelete :
	public void fnVerifyAgentDelete(String FirstName) {
		txtSearch.sendKeys(FirstName);
		fnVerifyMasterRecordDelete(grdRecordList);
		btnOk.click();
		System.out.println("Created Agent has been Deleted");
	}
	// This method for Validation of Agent Delete
    public boolean Verify_AgentDelete_SaveorNot(String FirstName) {
		
		if(txtSearch.isDisplayed()) {
			   txtSearch.clear();
			   txtSearch.sendKeys(FirstName.trim());
			  
			
			}else {
				fnWriteSteps("Fail", "First name field is not enable");
			}
		String Actual = driver.findElement(By.id("lblAgentName")).getAttribute("Name");
		if(!Actual.substring(15, 31).contains(FirstName.trim())){
			
			return true;
			
		} else {
			return false;
			
		}

		
		
	}
	
	/* 28-June-18-----Added by Moumita */
	/* This is the method to verify the record has been deleted successfully or not*/
	public void fnVerifyAgentDeleteSuccessfulOrNot(String strAgentName) {
		txtSearch.clear();
		txtSearch.sendKeys(strAgentName);
		String gridNoDataLabel = null;			

		WebElement messageEle = driver.findElement(By.id("lblNoData"));
		gridNoDataLabel = messageEle.getAttribute("Name");		
		if (gridNoDataLabel.contains("No agent found")) {
			fnWriteSteps("pass", "Record has been deleted successfully");
		} else
		{
			fnWriteSteps("pass", "Record has not been deleted");
		}
		
	}
}
