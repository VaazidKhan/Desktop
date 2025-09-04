package JBWindows.Transactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;
import commonClass.GenericMethods;

public class CustomerFeedback_Page extends BaseClass {
	
	//WebElements
	    @FindBy(id = "picLogo")   WebElement HeaderJBLogo;
        @FindBy (id= "txtSearch")   WebElement TxtSearch;
		@FindBy (id= "picNutral")   WebElement NaturalSmily;
		@FindBy (id= "picHappy")   WebElement HappySmily;
		@FindBy (id= "picSad")   WebElement SadSmily;
		@FindBy (id= "lookUpCustomer")   WebElement Customer;
		@FindBy (id= "dtFeadbackDate")  WebElement FeedBackDate;
		@FindBy (id= "memoDescription")    WebElement  FeedbackDescription;
		@FindBy (id= "btnSave")          WebElement BtnSave;
		@FindBy (id= "picClose")        WebElement Close;

public void clickCloseButton()
{
	Close.click();
}


public CustomerFeedback_Page () {
	PageFactory.initElements(driver, this);
}
public void VerifyFieldVisibility_FieldEnabledorNot() {
	 
	if(HappySmily.isDisplayed()&&HappySmily.isEnabled()) {
		fnWriteSteps("Pass", "HappySmily is present and Enable");
	} else {
		fnWriteSteps("Fail", "HappySmily is not present and Enable");
	}
	if(NaturalSmily.isDisplayed()&&NaturalSmily.isEnabled()) {
		NaturalSmily.click();
		fnWriteSteps("Pass", "NaturalSmily is present and Enable");
	} else {
		fnWriteSteps("Fail", "NaturalSmily is not present and Enable");
	}
	if(SadSmily.isDisplayed()&&SadSmily.isEnabled()) {
		SadSmily.click();
		fnWriteSteps("Pass", "SadSmily is present and Enable");
	} else {
		fnWriteSteps("Fail", "SadSmily is not present and Enable");
	}
	if(Customer.isDisplayed()&&Customer.isEnabled()) {
		Customer.click();
		fnWriteSteps("Pass", "Customer field is present and Enable");
	} else {
		fnWriteSteps("Fail", "Customer field is not present and Enable");
	}
	if(FeedBackDate.isDisplayed()&&FeedBackDate.isDisplayed()) {
		FeedBackDate.click();
		fnWriteSteps("Pass", "FeedBackDate is present and Enable");
	} else {
		fnWriteSteps("Pass", "FeedBackDate is present and Enable");
	}
	if(FeedbackDescription.isDisplayed()&&FeedbackDescription.isDisplayed()) {
		FeedbackDescription.click();
		fnWriteSteps("Pass", "FeedbackDescription is present and Enable");
	} else {
		fnWriteSteps("Pass", "FeedbackDescription is present and Enable");
	}
	
}
 public void CreateCustomerFeedback(String customer,String feedBackDate,String feedBackDescription) {
	
	   if(NaturalSmily.isDisplayed()) {
			NaturalSmily.click();
			fnWriteSteps("Pass", "NaturalSmily is present and Enable");
		} else {
			fnWriteSteps("Fail", "NaturalSmily is not present and Enable");
		}
	 if(Customer.isDisplayed()) {
			Customer.sendKeys(customer);
			Customer.submit();
	} else {
		fnWriteSteps("Fail", "Customer field is not enable");
	}
	 if(FeedBackDate.isDisplayed()) {
		 FeedBackDate.sendKeys(feedBackDate);
		 FeedBackDate.submit();
	} else {
		fnWriteSteps("Fail", "FeedBackdate field is not enable");
	}
	 if(FeedbackDescription.isDisplayed()) {
			FeedbackDescription.sendKeys(feedBackDescription);
			FeedbackDescription.submit();
			
		} else {
			fnWriteSteps("Pass", "FeedbackDescription is present and Enable");
		}
	 if(BtnSave.isDisplayed()) {
		  BtnSave.click();
	System.out.println("CustomerFeedback has been Saved");
	         
		}
	}

public boolean Verify_CustomerFeedback_SaveorNot(String Customer) {
  	  
		if (TxtSearch.isDisplayed()) {
			GenericMethods.fnwait(2);
			TxtSearch.clear();
			TxtSearch.sendKeys(Customer);
			GenericMethods.fnwait(2);
		 } else {  fnWriteSteps("Fail", "Customer is not displayed in UI");
				   
		 }
			 String Actual = driver.findElement(By.id("lblCustomerName")).getAttribute("Name");
			 if (Actual.contains(Customer)) {
						
					   return true;
					}
					
					   return false;
				}
public void VerifyCustomerFeedbackEdit(String OldCustomer,String feedBackDescription) {
	 if(TxtSearch.isDisplayed()) {
		 TxtSearch.sendKeys(OldCustomer);
		 BtnSave.click();
		}
	 if(NaturalSmily.isDisplayed()) {
			NaturalSmily.click();
			fnWriteSteps("Pass", "NaturalSmily is present and Enable");
		} else {
			fnWriteSteps("Fail", "NaturalSmily is not present and Enable");
		}
	
	GenericMethods.windows_Set_DropDown_Value(FeedbackDescription,feedBackDescription );
	
	 if(BtnSave.isDisplayed()) {
		  BtnSave.click();
	System.out.println("CustomerFeedback has been Updated & Saved");
	         
		}
	}
 
	 
 }

