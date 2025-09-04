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

import commonClass.BaseClass;
import commonClass.GenericMethods;

public class UMX_UnitsView extends BaseClass {
	
	// Entry or Edit Screen Elements
	@FindBy(id = "btnAdd") WebElement btnAdd;
	@FindBy(id = "txtUnit") WebElement TxtUnit;
	@FindBy(id = "txtUnitCode") WebElement TxtUnitCode;
	@FindBy(id = "lookUpEdit") WebElement baseUnit;
	@FindBy(id = "chkActive") WebElement chkActive;
	@FindBy(id = "chkAllowFractionalQuantity") WebElement chkAllowFractionalQuantity;
	@FindBy(id = "btnSave") WebElement btnSave;
	@FindBy(id = "picClose") WebElement Close;
	@FindBy(id = "btnCancel") WebElement btnCancel;
	@FindBy(id = "TxtSearch") WebElement txtSearch;
	@FindBy(id = "btnOk") WebElement btnOk;
	@FindBy(id = "grdUnit") WebElement grdRecordList;
	
	// Action
	public void clickCloseButton()
	{
		Close.click();
	}
	// WebElement Initialization method
	public UMX_UnitsView() {
		PageFactory.initElements(driver, this);
	}
	
	// This method is to verify all the fields are visible or not
	public void verifyFieldVisibility() {
		
        if (btnAdd.isDisplayed()) {
	          btnAdd.click();

        if (TxtUnit.isDisplayed()) {
			fnWriteSteps("Pass", "Unit Name field is present");
		} else {
			fnWriteSteps("Fail", "Unit Name field is not present");
		}
        if (TxtUnitCode.isDisplayed()) {
			fnWriteSteps("Pass", "UnitCode field is present");
		} else {
			fnWriteSteps("Fail", "UnitCode field is not present");
		}
		if (baseUnit.isDisplayed()) {
			fnWriteSteps("Pass", "BaseUnit field is present");
		} else {
			fnWriteSteps("Fail", "BaseUnit field is not present");
		}
		
		if (chkActive.isDisplayed()) {
		    fnWriteSteps("Pass", "Active checkbox is present");
		} else {
			fnWriteSteps("Fail", "Active checkbox is not present");
		}
		if (chkAllowFractionalQuantity.isDisplayed()) {
			fnWriteSteps("Pass", "AllowFractionalQuantity field is present");
			System.out.println("Successfully all fields are Displayed");
		} else {
			fnWriteSteps("Fail", "AllowFractionalQuantity field is not present");
		}
		
	}
}
	// This method is to verify all the fields are enable or not
        public void VerifyFieldEnableOrNot() {
		
        if (btnAdd.isDisplayed()) {
	          btnAdd.click();

        if (TxtUnit.isEnabled()) {
			fnWriteSteps("Pass", "Unit Name field is enable");
		} else {
			fnWriteSteps("Fail", "Unit Name field is not enable");
		}
        if (TxtUnitCode.isEnabled()) {
			fnWriteSteps("Pass", "UnitCode field is enable");
		} else {
			fnWriteSteps("Fail", "UnitCode field is not enable");
		}
		if (baseUnit.isEnabled()) {
			fnWriteSteps("Pass", "BaseUnit field is enable");
		} else {
			fnWriteSteps("Fail", "BaseUnit field is not enable");
		}
		
		if (chkActive.isEnabled()) {
			fnWriteSteps("Pass", "Active checkbox is enable");
		} else {
			fnWriteSteps("Fail", "Active checkbox is not enable");
		}
		if (chkAllowFractionalQuantity.isEnabled()) {
			fnWriteSteps("Pass", "AllowFractionalQuantity field is enable");
			System.out.println("Successfully all fields are Enabled");
		} else {
			fnWriteSteps("Fail", "AllowFractionalQuantity field is not enable");
		}
		
	}
}
	   // This method for New Units Creation :
	   public void Create_NewUnits(String UnitName,String UnitCode,String BaseUnit,String Inactive) {
		   if(btnAdd.isDisplayed()) {
			   btnAdd.click();
		   
		   if(TxtUnit.isDisplayed()) {
			  TxtUnit.sendKeys(UnitName);
		   } else {
			   fnWriteSteps("Fail", "UnitName field is not enable");
		   
			      }
		   if(TxtUnitCode.isDisplayed()) {
			  TxtUnitCode.sendKeys(UnitCode);
		   } else {
			   fnWriteSteps("Fail", "UnitCode field is not enable");
		   }
		   
		   if(baseUnit.isDisplayed()) {
			  baseUnit.sendKeys(BaseUnit);
			  baseUnit.submit();
			   } else {
				   fnWriteSteps("Fail", "BaseUnit field is not enable");
			   }
			   
		    if(chkActive.isSelected()) {
		    	switch (Inactive) {
				case "Inactive":
					chkActive.click();
					break;
				}
		        fnWriteSteps("Pass", "Active checkbox is checked by default");
				   } else {
					   fnWriteSteps("Fail", "Active checkbox is not checked by default ");
				   }
		    if(chkAllowFractionalQuantity.isSelected()) {
		        fnWriteSteps("Pass", "AllowFractionalQuantity checkbox is checked by default");
				   } else {
					   fnWriteSteps("Fail", "AllowFractionalQuantity checkbox is not checked by default ");
				   }
		    
		    btnSave.click();
		    GenericMethods.fnwait(2);
		    System.out.println(" Units has been created successfully");
		   }
	   }

	   // This method for Validation of Units_Feature(Add & Edit) :
	   public boolean Verify_NewUnitsFeature_SaveorNot(String UnitName) {
	      	  
			if (txtSearch.isDisplayed()) {
				txtSearch.clear();
				txtSearch.sendKeys(UnitName);

			 } else {  fnWriteSteps("Fail", "UnitName is not displayed in UI");
					   
           }
						String Actual = driver.findElement(By.id("lblUnitName")).getAttribute("Name");
						if (Actual.substring(15,22).trim().contains(UnitName.trim())) {
							
						   return true;
						}
						
						   return false;
					}	

	   
	   // This method for Units Edit :

         public void Verify_EditUnits(String OldUnitName,String UnitName,String UnitCode,String BaseUnit) {
        	 txtSearch.isDisplayed();
        	 txtSearch.sendKeys(OldUnitName);
        	 btnSave.click();
        	 GenericMethods.windows_Set_TextBoxValue(TxtUnit,UnitName);
        	 GenericMethods.windows_Set_TextBoxValue(baseUnit,BaseUnit);
        	 
        	 if(TxtUnitCode.isDisplayed()) {
        		 
        		 fnWriteSteps("Pass", "Unitcode field is not Disabled");
        	 } else {
        		 fnWriteSteps("Fail", "Unitcode field is Disabled");
        	 }
        	 
        	 if(chkActive.isSelected()) {
        		chkActive.click();
        		
 		        fnWriteSteps("Pass", "Active checkbox is not checked by default");
 				   } else {
 					   fnWriteSteps("Fail", "Active checkbox is checked by default ");
 				   }
 		    if(chkAllowFractionalQuantity.isSelected()) {
 		    	chkAllowFractionalQuantity.click();
 		    	
 		        fnWriteSteps("Pass", "AllowFractionalQuantity checkbox is not checked by default");
 				   } else {
 					   fnWriteSteps("Fail", "AllowFractionalQuantity checkbox is checked by default ");
 				   }
 		    
 		   btnSave.click();
		    GenericMethods.fnwait(2);
		    System.out.println(" Units has been Updated successfully");
        	 
        	 
         }
         // This method for Access the Delete Button :
         public static void fnVerifyMasterRecordDelete(WebElement element) {

 			GenericMethods.fnwait(3);
 			element.click();
 			PointerInfo a1 = MouseInfo.getPointerInfo();
 			Point b1 = a1.getLocation();
 			GenericMethods.fnwait(3);
 			int x1 = (int) b1.getX();
 			GenericMethods.fnwait(1);
 			int y1 = (int) b1.getY();

 			Robot r1;
 			try {
 				r1 = new Robot();
 				r1.mouseMove(x1+400, y1 -200);
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
   // This method for UnitsDelete :
          public void fnVerifyUnitsDelete(String UnitName) {
	       txtSearch.sendKeys(UnitName);
	       GenericMethods.fnwait(1);
	       fnVerifyMasterRecordDelete(grdRecordList);
	        btnOk.click();
	       GenericMethods.fnwait(25);
	       System.out.println("Created Units has been Deleted");
   }
     // This method for Validation of Units Delete :
          public boolean Verify_UnitsDelete_SaveorNot(String UnitName) {
   	  
	       if (txtSearch.isDisplayed()) {
		      GenericMethods.fnwait(1);
		      txtSearch.clear();
		      txtSearch.sendKeys(UnitName);
		      GenericMethods.fnwait(4);
	  } else {  fnWriteSteps("Fail", "UnitName is not displayed in UI");
	  		   
   }

	      String Actual = driver.findElement(By.id("lblUnitName")).getAttribute("Name");
	      if (!Actual.substring(15,22).trim().contains(UnitName.trim())) {
					
				   return true;
				}
				
				   return false;
			}	


}


