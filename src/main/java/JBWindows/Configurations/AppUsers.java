package JBWindows.Configurations;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonClass.BaseClass;
import commonClass.GenericMethods;


public class AppUsers extends BaseClass {
	//WebElements
	@FindBy(id ="btnAdd")  WebElement BtnAdd; 
    @FindBy(id ="txtUsername")  WebElement TxtUsername;
    @FindBy(id ="txtPassword")  WebElement TxtPassword;
    @FindBy(id ="txtName")  WebElement TxtName;
    @FindBy(id ="lookUpEdit")  WebElement LookUpEdit;
    @FindBy(id ="txtEmail")  WebElement TxtEmail;
    @FindBy(id ="txtMobile")  WebElement TxtMobile;
    @FindBy(id ="txtPhoneNo") WebElement TxtPhoneNo;
    @FindBy(id ="dtActivationDate") WebElement ActivationDate;
    @FindBy(id ="dtExpirationDate") WebElement ExpirationDate;
    @FindBy(id ="memoDescription") WebElement Description;
    @FindBy(id ="ChkEnable") WebElement CheckEnable;
    @FindBy(id ="btnSave") WebElement BtnSave;
    @FindBy(id ="picLogo") WebElement Logo;
    @FindBy(id ="picClose") WebElement btnClose;
    @FindBy(id ="TxtSearch") WebElement txtSearch;
    @FindBy(id ="grdUsers") WebElement grdRecordList;
    
    // Action
    public void clickCloseButton()
	{
		btnClose.click();
	}
    // WebElement Initialization method
    public AppUsers() {
		PageFactory.initElements(driver, this);
	}
    // This method is to verify all the fields are visible&&Enabled or not
    public void VerifyFieldVisibility_FieldEnabledorNot() {
    	Logo.click();
		if(BtnAdd.isDisplayed()) {
			BtnAdd.click();
			
		}
		
		if(TxtUsername.isDisplayed()&&TxtUsername.isEnabled()) {
			TxtUsername.click();
			fnWriteSteps("Pass", "UserName field is present and Enable");
		} else {
			fnWriteSteps("Fail", "UserName field is not present and Enable");
		}
		if(TxtPassword.isDisplayed()&&TxtPassword.isEnabled()) {
			TxtPassword.click();
			fnWriteSteps("Pass", "Password field is Present and Enable");
		} else {
			fnWriteSteps("Fail", "Password field is not Present and Enable");
		}
		if(TxtName.isDisplayed()&&TxtName.isEnabled()) {
			TxtName.click();
			fnWriteSteps("Pass", "Name field is present and Enable");
		} else {
			fnWriteSteps("Fail", "Name field is not present and Enable");
		}
		if(LookUpEdit.isDisplayed()&&LookUpEdit.isEnabled()) {
			LookUpEdit.click();
			fnWriteSteps("Pass", "RoleName field is present and Enable");
		} else {
			fnWriteSteps("Fail", "RoleName field is not present and Enable");
		}
		if(TxtEmail.isDisplayed()&&TxtEmail.isEnabled()) {
			TxtEmail.click();
			fnWriteSteps("Pass", "Email field is present and Enable");
		} else {
			fnWriteSteps("Fail", "Email field is not present and Enable");
		}
		if(TxtMobile.isDisplayed()&&TxtMobile.isEnabled()) {
			TxtMobile.click();
			fnWriteSteps("Pass", "MobileNo field is present and Enable");
		} else {
			fnWriteSteps("Fail", "MobileNo field is not present and Enable");
		}
		if(TxtPhoneNo.isDisplayed()&&TxtPhoneNo.isEnabled()) {
			TxtPhoneNo.click();
			fnWriteSteps("Pass", "PhoneNo field is present and Enable");
		} else {
			fnWriteSteps("Fail", "PhoneNo field is not present and Enable");
		}
		if(ActivationDate.isDisplayed()&&ActivationDate.isEnabled()) {
			ActivationDate.click();
			fnWriteSteps("Pass", "ActivationDate field is present and Enable");
		} else {
			fnWriteSteps("Fail", "ActivationDate field is not present and Enable");
		}
		if(ExpirationDate.isDisplayed()&&ExpirationDate.isEnabled()) {
			ExpirationDate.click();
			fnWriteSteps("Pass", "ExpirationDate field is present and Enable");
		} else {
			fnWriteSteps("Fail", "ExpirationDate field is not present and Enable");
		}
		if(Description.isDisplayed()&&Description.isEnabled()) {
			Description.click();
			fnWriteSteps("Pass", "Particulars field is present and Enable");
		} else {
			fnWriteSteps("Fail", "Particulars field is not present and Enable");
		}
		if(CheckEnable.isDisplayed()&&CheckEnable.isEnabled()) {
			CheckEnable.click();
			fnWriteSteps("Pass", "CheckEnable field is present and Enable");
		} else {
			fnWriteSteps("Fail", "CheckEnable field is not present and Enable");
		}
	
		
    }
    // This method for New User Creation :
    public void NewUserCreation(String Username,String Password,String Name,String RoleName,String Email,String MobileNo,String PhNo,String Activationdate,String Expirationdate,String Particulars) {
    	if(BtnAdd.isDisplayed()) {
			BtnAdd.click();
		}
    	if(TxtUsername.isDisplayed()) {
    		TxtUsername.sendKeys(Username);
    	} else {
			fnWriteSteps("Fail", "UserName field is not enable");
		}
    	if(TxtPassword.isDisplayed()) {
    		TxtPassword.sendKeys(Password);
    	} else {
			fnWriteSteps("Fail", "Password field is not enable");
		}
    	if(TxtName.isDisplayed()) {
    		TxtName.sendKeys(Name);
    	} else {
			fnWriteSteps("Fail", "Name field is not enable");
		}
    	if(LookUpEdit.isDisplayed()) {
    		LookUpEdit.sendKeys(RoleName);
    		LookUpEdit.submit();
    	} else {
			fnWriteSteps("Fail", "RoleName field is not enable");
		}
    	if(TxtEmail.isDisplayed()) {
    		TxtEmail.sendKeys(Email);
    	} else {
			fnWriteSteps("Fail", "Email field is not enable");
		}
    	if(TxtMobile.isDisplayed()) {
    		TxtMobile.sendKeys(MobileNo);
    	} else {
			fnWriteSteps("Fail", "Mobile field is not enable");
		}
    	if(TxtPhoneNo.isDisplayed()) {
    		TxtPhoneNo.sendKeys(PhNo);
    	} else {
			fnWriteSteps("Fail", "PhoneNo field is not enable");
		}
    	if(ActivationDate.isDisplayed()) {
    		ActivationDate.sendKeys(Activationdate);
    		ActivationDate.submit();
    	} else {
			fnWriteSteps("Fail", "ActivationDate field is not enable");
		}
    	if(ExpirationDate.isDisplayed()) {
    		ExpirationDate.sendKeys(Expirationdate);
    		ExpirationDate.submit();
    	} else {
			fnWriteSteps("Fail", "ExpirationDate field is not enable");
		}
    	if(Description.isDisplayed()) {
    		Description.sendKeys(Particulars);
    	} else {
			fnWriteSteps("Fail", "Particulars field is not enable");
		}
    	if(CheckEnable.isEnabled()) {
    		
      } else {
			fnWriteSteps("Fail", "Enable field is not enabled");
		}
    	
    if(BtnSave.isDisplayed()) {
    	BtnSave.click();
    	}
    	System.out.println("User has been created & Saved");
    }
    
    // This method for Validation of New User Creation :
    public boolean Verify_NewUser_SaveorNot(String Username) throws AWTException {
    	GenericMethods.fnwait(2);
    	GenericMethods.windows_Set_TextBoxValue(txtSearch,Username);
    	GenericMethods.fnwait(1);
    	Robot rr=new Robot();
		rr.keyPress(KeyEvent.VK_ENTER);
  	     GenericMethods.fnwait(3);
  	   String Actual = driver.findElement(By.id("lblUsersName")).getAttribute("Name");
  	  
  	   if (Actual.substring(15, 20).equalsIgnoreCase(Username.substring(0, 5))) {
					 return true;
					}
					
					   return false;
				}	
    
    // This method for User Edit :
    public void NewUserEdit(String OldUserName,String Password,String Name,String Email,String MobileNo,String PhNo,String Particulars) throws AWTException {
    	
    	txtSearch.sendKeys(OldUserName);
    	BtnSave.click();
    	
    	GenericMethods.fnwait(1);
    	if(TxtPassword.isDisplayed()) {
			GenericMethods.fnwait(3);
			Robot rr=new Robot();
			rr.keyPress(KeyEvent.VK_TAB);
		    GenericMethods.fnwait(2);
			rr.keyPress(KeyEvent.VK_DELETE);
		    GenericMethods.fnwait(3);
		    TxtPassword.sendKeys(Password);
			 }
       
    	GenericMethods.windows_Set_TextBoxValue(TxtName,Name);
    	GenericMethods.windows_Set_TextBoxValue(TxtEmail,Email);
    	GenericMethods.windows_Set_TextBoxValue(TxtMobile,MobileNo);
    	GenericMethods.windows_Set_TextBoxValue(TxtPhoneNo,PhNo);
    	GenericMethods.windows_Set_TextBoxValue(Description,Particulars);
    	
       if(CheckEnable.isEnabled()) {
    	   CheckEnable.click();
    		fnWriteSteps("Fail", "Enable field is enabled");
      } else {
			fnWriteSteps("Fail", "Enable field is not enabled");
		}
    	if(BtnSave.isDisplayed()) {
     	   BtnSave.click();
     	}
     	System.out.println("User has been Updated & Saved");
     }
    
    
    	
}

    
    
    

