package JBWindows.SAL;

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


public class SR_TaxGroup extends BaseClass {
	
	// WebElements
	@FindBy (id = "txtTaxGroupName")
	WebElement TxtTaxGroupName;
	@FindBy (name = "State row 0")
	WebElement StateRow_0 ;
	@FindBy (name = "Within State Tax 1 row 0")
	WebElement WithinState_Tax1_Row0;
	@FindBy (name = "Within State Tax 2 row 0")
	WebElement WithinState_Tax2_Row0;
	@FindBy (name = "Within State Tax 3 row 0")
	WebElement WithinState_Tax3_Row0;
	@FindBy (name = "Outside State Tax 1 row 0")
	WebElement OutsideState_Tax1_Row0;
	@FindBy (name = "Outside State Tax 2 row 0")
	WebElement OutsideState_Tax2_Row0;
	@FindBy (name = "Outside State Tax 3 row 0")
	WebElement OutsideState_Tax3_Row0;
	@FindBy (name = "btnCancel")
	WebElement BtnCancel;
	@FindBy (id ="btnSave")
	WebElement BtnSave;
	@FindBy (id = "picClose")
	WebElement btnClose;
	@FindBy (id ="txtSearch")
	WebElement TxtSearch;
	@FindBy (id ="btnAdd")
	WebElement BtnAdd;
	@FindBy(id = "btnOk")
	WebElement btnOk;
	@FindBy(id = "grdTaxGroupListView")
	WebElement grdRecordList;
	
	// Action
	public void clickCloseButton()
	{
		btnClose.click();
	}
	
	// WebElement Initialization method
	public SR_TaxGroup() {
		PageFactory.initElements(driver, this);
	}
	// This method is to verify all the fields are visible&&enabled or not
	public void VerifyFieldVisibility_FieldEnabledorNot() {
		if(BtnAdd.isDisplayed()) {
			  BtnAdd.click();
		  }
		if(TxtTaxGroupName.isDisplayed()&&TxtTaxGroupName.isEnabled()) {
			TxtTaxGroupName.click();
			fnWriteSteps("Pass", "TaxGroupName field is present and Enable");
		} else {
			fnWriteSteps("Fail", "TaxGroupName field is not present and Enable");
		}
		if(StateRow_0.isDisplayed()&&StateRow_0.isEnabled()) {
			StateRow_0.click();
			fnWriteSteps("Pass", "State field is Present and Enable");
		} else {
			fnWriteSteps("Fail", "State field is not Present and Enable");
		}
		if(WithinState_Tax1_Row0.isDisplayed()&&WithinState_Tax1_Row0.isEnabled()) {
			WithinState_Tax1_Row0.click();
			fnWriteSteps("Pass", "WithinState Tax1 field is present and Enable");
		} else {
			fnWriteSteps("Fail", "WithinState Tax1 field is not present and Enable");
		}
		if(WithinState_Tax2_Row0.isDisplayed()&&WithinState_Tax2_Row0.isEnabled()) {
			WithinState_Tax2_Row0.click();
			fnWriteSteps("Pass", "WithinState Tax2 field is present and Enable");
		} else {
			fnWriteSteps("Fail", "WithinState Tax2 field is not present and Enable");
		}
		if(WithinState_Tax3_Row0.isDisplayed()&&WithinState_Tax3_Row0.isEnabled()) {
			WithinState_Tax3_Row0.click();
			fnWriteSteps("Pass", "WithinState Tax3 field is present and Enable");
		} else {
			fnWriteSteps("Fail", "WithinState Tax3 field is not present and Enable");
		}
		if(OutsideState_Tax1_Row0.isDisplayed()&&OutsideState_Tax1_Row0.isEnabled()) {
			OutsideState_Tax1_Row0.click();
			fnWriteSteps("Pass", "OutsideState Tax1 field is present and enable");
		} else {
			fnWriteSteps("Fail", "OutsideState Tax1 field is not present and enable");
		}
		if(OutsideState_Tax2_Row0.isDisplayed()&&OutsideState_Tax2_Row0.isEnabled()) {
			OutsideState_Tax2_Row0.click();
			fnWriteSteps("Pass", "OutsideState Tax2 field is present and enable");
		} else {
			fnWriteSteps("Fail", "OutsideState Tax2 field is not present and enable");
		}
		if(OutsideState_Tax3_Row0.isDisplayed()&&OutsideState_Tax3_Row0.isEnabled()) {
			OutsideState_Tax3_Row0.click();
			fnWriteSteps("Pass", "OutsideState Tax3 field is present and enable");
		} else {
			fnWriteSteps("Fail", "OutsideState Tax3 field is not present and enable");
		}
		System.out.println("");
		  
			
		}
	// This method for New TaxGroup Creation :
	public boolean CreateNewTaxGroup(String TaxGroupName,String State,String WithinStateTax1,String WithinStateTax2,String WithinStateTax3,String OutsideStateTax1,String OutsideStateTax2,String OutsideStateTax3) {
		
		  boolean result=false;
		  if(BtnAdd.isDisplayed()) {
			  BtnAdd.click();
		  }
		if(TxtTaxGroupName.isDisplayed()) {
		   TxtTaxGroupName.sendKeys(TaxGroupName);
		} else {
			fnWriteSteps("Fail", "TaxGroupName field is not enable");
		}
		if(StateRow_0.isDisplayed()) {
		   StateRow_0.click();
		   StateRow_0.sendKeys(State);
		   StateRow_0.submit();
		} else {
			fnWriteSteps("Fail", "State field is not enable");
		}
		if(WithinState_Tax1_Row0.isDisplayed()) {
			WithinState_Tax1_Row0.click();
			WithinState_Tax1_Row0.sendKeys(WithinStateTax1);
			WithinState_Tax1_Row0.submit();
			} else {
				fnWriteSteps("Fail", "WithinState Tax1 Row0 field is not enable");
			}
		if(WithinState_Tax2_Row0.isDisplayed()) {
			WithinState_Tax2_Row0.click();
			WithinState_Tax2_Row0.sendKeys(WithinStateTax2);
			WithinState_Tax2_Row0.submit();
			} else {
				fnWriteSteps("Fail", "WithinState Tax2 Row0 field is not enable");
			}
		if(WithinState_Tax3_Row0.isDisplayed()) {
			WithinState_Tax3_Row0.click();
			WithinState_Tax3_Row0.sendKeys(WithinStateTax3);
			WithinState_Tax3_Row0.submit();
			} else {
				fnWriteSteps("Fail", "WithinState Tax3 Row0 field is not enable");
			}
		if(OutsideState_Tax1_Row0.isDisplayed()) {
			OutsideState_Tax1_Row0.click();
			OutsideState_Tax1_Row0.sendKeys(OutsideStateTax1);
			OutsideState_Tax1_Row0.submit();
			} else {
				fnWriteSteps("Fail", "OutsideState Tax1 Row0 field is not enable");
			}
		if(OutsideState_Tax2_Row0.isDisplayed()) {
			OutsideState_Tax2_Row0.click();
			OutsideState_Tax2_Row0.sendKeys(OutsideStateTax2);
			OutsideState_Tax2_Row0.submit();
			
			} else {
				fnWriteSteps("Fail", "OutsideState Tax2 Row0 field is not enable");
			}
		
		if(OutsideState_Tax3_Row0.isDisplayed()) {
			OutsideState_Tax3_Row0.click();
			OutsideState_Tax3_Row0.sendKeys(OutsideStateTax3);
			OutsideState_Tax3_Row0.submit();
			} else {
				fnWriteSteps("Fail", "OutsideState Tax3 Row0 field is not enable");
			}
		
	  if(BtnSave.isDisplayed()) {
		  BtnSave.click();
			result=true;
			System.out.println("TaxGroup has been created & Saved");
	         
		}
		return result;
	}
	
	// This method for TaxGroup Edit :
	public boolean VerifyTaxGroupEdit(String OldTaxGroupName,String TaxGroupName,String State,String WithinStateTax1,String WithinStateTax2,String WithinStateTax3,String OutsideStateTax1,String OutsideStateTax2,String OutsideStateTax3) {
		 boolean result=false;
		 TxtSearch.clear();
		 TxtSearch.sendKeys(OldTaxGroupName);
		  BtnSave.click();
		  GenericMethods.windows_Set_TextBoxValue(TxtTaxGroupName, TaxGroupName);
		    if(StateRow_0.isDisplayed()) {
			   StateRow_0.clear();
			   StateRow_0.sendKeys(State);
			   StateRow_0.submit();
			} else {
				fnWriteSteps("Fail", "State field is not enable");
			}
			if(WithinState_Tax1_Row0.isDisplayed()) {
				WithinState_Tax1_Row0.clear();
				WithinState_Tax1_Row0.sendKeys(WithinStateTax1);
				WithinState_Tax1_Row0.submit();
				} else {
					fnWriteSteps("Fail", "WithinState Tax1 Row0 field is not enable");
				}
			if(WithinState_Tax2_Row0.isDisplayed()) {
				WithinState_Tax2_Row0.clear();
				WithinState_Tax2_Row0.sendKeys(WithinStateTax2);
				WithinState_Tax2_Row0.submit();
				} else {
					fnWriteSteps("Fail", "WithinState Tax2 Row0 field is not enable");
				}
			if(WithinState_Tax3_Row0.isDisplayed()) {
				WithinState_Tax3_Row0.clear();
				WithinState_Tax3_Row0.sendKeys(WithinStateTax3);
				WithinState_Tax3_Row0.submit();
				} else {
					fnWriteSteps("Fail", "WithinState Tax3 Row0 field is not enable");
				}
			if(OutsideState_Tax1_Row0.isDisplayed()) {
				OutsideState_Tax1_Row0.clear();
				OutsideState_Tax1_Row0.sendKeys(OutsideStateTax1);
				OutsideState_Tax1_Row0.submit();
				} else {
					fnWriteSteps("Fail", "OutsideState Tax1 Row0 field is not enable");
				}
			if(OutsideState_Tax2_Row0.isDisplayed()) {
				OutsideState_Tax2_Row0.clear();
				OutsideState_Tax2_Row0.sendKeys(OutsideStateTax2);
				OutsideState_Tax2_Row0.submit();
				
				} else {
					fnWriteSteps("Fail", "OutsideState Tax2 Row0 field is not enable");
				}
			
			if(OutsideState_Tax3_Row0.isDisplayed()) {
				OutsideState_Tax3_Row0.clear();
				OutsideState_Tax3_Row0.sendKeys(OutsideStateTax3);
				OutsideState_Tax3_Row0.submit();
				} else {
					fnWriteSteps("Fail", "OutsideState Tax3 Row0 field is not enable");
				}
			
		  if(BtnSave.isDisplayed()) {
			  BtnSave.click();
				result=true;
				System.out.println("TaxGroup has been Updated & Saved");
		         
			}
			return result;
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
			r1.mouseMove(x1 + 250, y1 - 293);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		GenericMethods.fnwait(1);
		Actions builder1 = new Actions(driver);
		builder1.click().build().perform();
	}
   //  This method for To click on YES Button :
	public void click_On_Yes_Button() {
		driver.findElement(By.id("lblHeader")).click();
		GenericMethods.fnwait(1);
		btnOk.click();
	  }
	
	 // This method for TaxGroupDelete :
	 public void fnVerifyTaxGroupDelete(String TaxGroupName) {
			TxtSearch.sendKeys(TaxGroupName);
			GenericMethods.fnwait(2);
			fnVerifyMasterRecordDelete(grdRecordList);
			btnOk.click();
			GenericMethods.fnwait(5);
			System.out.println("Created TaxGroup has been Deleted");
		}
		
	 // This method for Validation of TaxGroup Delete :
	    public boolean Verify_TaxGroupDelete_SaveorNot(String TaxGroupName) {
			
			if(TxtSearch.isDisplayed()) {
				GenericMethods.fnwait(27);
				TxtSearch.clear();
				TxtSearch.sendKeys(TaxGroupName.trim());
				  
				
				}else {
					fnWriteSteps("Fail", "TaxGroupName field is not enable");
				}
			String Actual = driver.findElement(By.id("lblNoDataDispaly")).getAttribute("Name");
			if(!Actual.substring(0, 21).contains(TaxGroupName.trim())){
				
				return true;
				
			} else {
				return false;
				
			}
	    }
}

	

	
	
	
		
		
		
	

	
	


