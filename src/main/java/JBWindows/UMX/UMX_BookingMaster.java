package JBWindows.UMX;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import commonClass.BaseClass;
import commonClass.GenericMethods;

public class UMX_BookingMaster extends BaseClass {
	
	//WebElements
	@FindBy (id= "dtBookingDate")      WebElement BookingDate;
	@FindBy (id= "txtName")            WebElement BookingNmae;
	@FindBy (id= "txtPhoneNo")         WebElement PhNo;
	@FindBy (id= "txtEmail")           WebElement Email;
	@FindBy (id= "calcNumberOfPax")    WebElement NoOfGuests;
	@FindBy (id= "lookUpEdit")         WebElement Status;
	@FindBy (id= "memoRemarks")        WebElement Remarks;
	@FindBy (id= "btnCancel")          WebElement BtnCancel;
	@FindBy (id= "btnSave")            WebElement BtnSave;
	@FindBy (id = "picClose")          WebElement btnClose;
	@FindBy (id = "btnAdd")            WebElement BtnAdd;
	@FindBy (id = "txtSearch")         WebElement TxtSearch;
	@FindBy(id = "btnOk")              WebElement btnOk;
	@FindBy(id = "grdBookingMaster")  WebElement grdRecordList;
	
	// This method for Click CLOSE Button :
	public void clickCloseButton()
	{
		driver.findElement(By.id("picLogo")).click();
		btnClose.click();
	}
	
	// // WebElement Initialization method
	public UMX_BookingMaster () {
		PageFactory.initElements(driver, this);
	}
	
	// This method is to verify all the fields are visible&&Enabled or not :
	   public void VerifyFieldVisibility_FieldEnabledorNot() {
		if(BtnAdd.isDisplayed()) {
			BtnAdd.click();
		}
		
		if(BookingDate.isDisplayed()&&BookingDate.isEnabled()) {
			BookingDate.click();
			fnWriteSteps("Pass", "BookingDate field is present and Enable");
		} else {
			fnWriteSteps("Fail", "BookingDate field is not present and Enable");
		}
		if(BookingNmae.isDisplayed()&&BookingNmae.isEnabled()) {
			BookingNmae.click();
			fnWriteSteps("Pass", "BookingName field is Present and Enable");
		} else {
			fnWriteSteps("Fail", "BookingName field is not Present and Enable");
		}
		if(PhNo.isDisplayed()&&PhNo.isEnabled()) {
			PhNo.click();
			fnWriteSteps("Pass", "PhNo field is present and Enable");
		} else {
			fnWriteSteps("Fail", "PhNo field is not present and Enable");
		}
		if(Email.isDisplayed()&&Email.isEnabled()) {
			Email.click();
			fnWriteSteps("Pass", "Email field is present and Enable");
		} else {
			fnWriteSteps("Fail", "Email field is not present and Enable");
		}
		if(NoOfGuests.isDisplayed()&&NoOfGuests.isEnabled()) {
			NoOfGuests.click();
			fnWriteSteps("Pass", "NoOfGuests field is present and Enable");
		} else {
			fnWriteSteps("Fail", "NoOfGuests field is not present and Enable");
		}
		if(Status.isDisplayed()&&Status.isEnabled()) {
			Status.click();
			fnWriteSteps("Pass", "Status field is present and enable");
		} else {
			fnWriteSteps("Fail", "Status field is not present and enable");
		}
		if(Remarks.isDisplayed()&&Remarks.isEnabled()) {
			Remarks.click();
			fnWriteSteps("Pass", "Remarks field is present and enable");
		} else {
			fnWriteSteps("Fail", "Remarks field is not present and enable");
		}
	
	}
	   // This method for New BookingMaster Creation :
	public void CreateNewBookingMaster(String Bookingdate,String Bookingname,String Phno,String EmailId,String Noofguests,String status,String remarks) {
		
		 if(BtnAdd.isDisplayed()) {
			  BtnAdd.click();
		  }
		if(BookingDate.isDisplayed()) {
			BookingDate.click();
			BookingDate.sendKeys(Bookingdate);
		
		} else {
			fnWriteSteps("Fail", "BookingDate field is not enable");
		}
		if(BookingNmae.isDisplayed()) {
			BookingNmae.sendKeys(Bookingname);
			
		} else {
			fnWriteSteps("Fail", "BookingName field is not enable");
		}
		if(PhNo.isDisplayed()) {
			PhNo.sendKeys(Phno);
			} else {
				fnWriteSteps("Fail", "Phone Number field is not enable");
			}
		if(Email.isDisplayed()) {
			Email.sendKeys(EmailId);
			
			} else {
				fnWriteSteps("Fail", "Email field is not enable");
			}
		if(NoOfGuests.isDisplayed()) {
			
			NoOfGuests.sendKeys(Noofguests);
			
			} else {
				fnWriteSteps("Fail", "NoOfguests field is not enable");
			}
		if(Status.isDisplayed()) {
			
			Status.sendKeys(status);
			
			} else {
				fnWriteSteps("Fail", "Status field is not enable");
			}
		if(Remarks.isDisplayed()) {
			Remarks.sendKeys(remarks);
			
			} else {
				fnWriteSteps("Fail", "Remarks field is not enable");
			}
		if(BtnSave.isDisplayed()) {
			  BtnSave.click();
		System.out.println("BookingMaster has been created & Saved");
		         
			}
		
		
	}
	//This method for Validation of New BookingMaster Creation :
	 public boolean Verify_NewBookingMaster_SaveorNot(String Phno) {
   	  
			if (TxtSearch.isDisplayed()) {
				GenericMethods.fnwait(2);
				TxtSearch.clear();
				TxtSearch.sendKeys(Phno);
				GenericMethods.fnwait(2);
			 } else {  fnWriteSteps("Fail", "Phno is not displayed in UI");
					   
			 }
				 String Actual = driver.findElement(By.id("lblMobileNo")).getAttribute("Name");
				 if (Actual.contains(Phno)) {
							
						   return true;
						}
						
						   return false;
					}
	 
	 // This method for BookingMaster Edit :
   public void verifyBookingMasterEdit(String OldPhno,String Bookingdate,String Bookingname,String Phno,String EmailId,String Noofguests,String status,String remarks ) {
	     TxtSearch.click();
		 TxtSearch.sendKeys(OldPhno);
		  BtnSave.click();
		 GenericMethods.windows_Set_TextBoxValue(BookingDate, Bookingdate);
		 GenericMethods.windows_Set_TextBoxValue(BookingNmae,Bookingname);
		 GenericMethods.windows_Set_DropDown_Value(PhNo,Phno);
		 GenericMethods.windows_Set_DropDown_Value(Email,EmailId);
		 GenericMethods.windows_Set_DropDown_Value(NoOfGuests,Noofguests );
		 GenericMethods.windows_Set_DropDown_Value(Status, status);
		 GenericMethods.windows_Set_DropDown_Value(Remarks,remarks );
		 if(BtnSave.isDisplayed()) {
			  BtnSave.click();
		System.out.println("BookingMaster has been Updated & Saved");
		         
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
	// This method for BookingMasterDelete :
	public void fnVerifyBookingMasterDelete(String Phno) {
		TxtSearch.sendKeys(Phno);
		GenericMethods.fnwait(2);
		fnVerifyMasterRecordDelete(grdRecordList);
		btnOk.click();
		System.out.println("Created Booking Master has been Deleted");
	}
	// This method for Validation of BookingMaster Delete :
   public boolean Verify_BookingMasterDelete_SaveorNot(String Phno) {
		
		if(TxtSearch.isDisplayed()) {
			GenericMethods.fnwait(15);
			   TxtSearch.clear();
			   TxtSearch.sendKeys(Phno);
			  
			
			}else {
				fnWriteSteps("Fail", "Phone Number field is not enable");
			}
		String Actual = driver.findElement(By.id("lblName")).getAttribute("Name");
		if(!Actual.contains(Phno)){
			
			return true;
			
		} else {
			return false;
			
		}
	                              
   }
   // This method for To Click on BOOKINGMASTER Button :
   public void click_Booking_Master() throws FindFailed {
	   Screen screen=new Screen();
	   Pattern pattern;
	   pattern  =new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Masters.PNG");
	   screen.click(pattern);
	   GenericMethods.fnwait(2);
	   pattern=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\ArrowDown.PNG");
	   screen.click(pattern);
	   GenericMethods.fnwait(1);
	   screen.click(pattern);
	   GenericMethods.fnwait(1);
	   screen.click(pattern);
	   GenericMethods.fnwait(2);
	   screen.click(pattern);
	   GenericMethods.fnwait(2);
	   screen.click(pattern);
	   screen.click(pattern);
	   pattern=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Booking Master.PNG");
	   screen.click(pattern);
	   GenericMethods.fnwait(2);
	   
   }
}


