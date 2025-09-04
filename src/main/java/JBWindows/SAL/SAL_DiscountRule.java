package JBWindows.SAL;

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

public class SAL_DiscountRule extends BaseClass {
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
	@FindBy(id = "lblDiscountName")
	WebElement lblDiscountName;
	@FindBy(id = "lblDiscountPercentage")
	WebElement lblDiscountPercentage;
	@FindBy(id = "lblDiscountFixedPrice")
	WebElement lblDiscountFixedPrice;

	// Master page button objects
	@FindBy(id = "SAL_DiscountRule")
	WebElement pageName;
	@FindBy(id = "btnAdd")
	WebElement btnAdd;
	@FindBy(id = "btnSave")
	WebElement btnEdit;
	@FindBy(id = "txtSearch")
	WebElement txtSearch;

	// Entry OR Edit page objects
	@FindBy(id = "lookUpDiscountType")
	WebElement lookUpDiscountType;
	@FindBy(id = "txtDiscountName")
	WebElement txtDiscountName;
	@FindBy(id = "calcSalesQuantity")
	WebElement calcSalesQuantity;
	@FindBy(id = "txtPromoCode")
	WebElement txtPromoCode;
	@FindBy(id = "calcFixedAmount")
	WebElement calcFixedAmount;
	@FindBy(id = "calcPercentage")
	WebElement calcPercentage;
	@FindBy(id = "chkActive")
	WebElement chkActive;
	@FindBy(id = "memoDescription")
	WebElement memoDescription;
	@FindBy (id = "lookUpEdit")
	WebElement LookUpEdit;
	@FindBy(id = "btnOk")
	WebElement btnOk;

	// Entry or Edit page buttons
	@FindBy(id = "btnSave")
	WebElement btnSave;
	@FindBy(id = "btnCancel")
	WebElement btnCancel;

	// Added by Moumita---26-June-2018
	@FindBy(id = "calcMinDiscountAmount")
	WebElement calcMinDiscountAmount;
	@FindBy(id = "calcMaxDiscountAmount")
	WebElement calcMaxDiscountAmount;

	/* 2-July-18-----Added by Moumita */
	@FindBy(id = "grdDiscountRule")
	WebElement grdRecordList;
	@FindBy(id = "lblNoData")
	WebElement noDiscountLabel;
	
    // WebElement Initialization method
	public SAL_DiscountRule() {
		PageFactory.initElements(driver, this);
	}
   // Operations
	public void activatePage() {
		pageName.click();
	}
   // Actions
	public void clickNewDiscountRule() {
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

	// ----------1-Feb-2018----added by Moumita---------------
	// The method for creating Discount Rule with taking the input from excel
	// Parameters are StartingRowNumber & LastRowNumber
	
	// This method for New DiscountRule Creation :
	public void createNewDiscountRule(String DiscountName, String DiscountType, String SaleQuantity, String Promocode,
			String FixedAmount, String Percentage, String Description,String MinDiscountAmt,String MaxDiscountAmt,String Inactive) {

		System.out.println(DiscountType);
		if (btnAdd.isDisplayed()) {
			btnAdd.click();
			
			if (txtDiscountName.isDisplayed()) {
				txtDiscountName.sendKeys(DiscountName);
			} else {
				fnWriteSteps("Fail", "Discount name field is not enable");
			}
			if (txtPromoCode.isDisplayed()) {
				txtPromoCode.sendKeys(Promocode);
			} else {
				fnWriteSteps("Fail", "Promo code field is not enable");
			}
			if (calcFixedAmount.isDisplayed()) {
				calcFixedAmount.sendKeys(FixedAmount);
			} else {
				fnWriteSteps("Fail", "Fixed Amount field is not enable");
			}
			if (calcPercentage.isDisplayed()) {
				calcPercentage.sendKeys(Percentage);
			} else {
				fnWriteSteps("Fail", "Percentage field is not enable");
			}
			if (chkActive.isSelected()) {
				switch (Inactive){
				case "Inactive":
				chkActive.click();
				}
				fnWriteSteps("Pass", "Active checkbox is checked by default ");
			} else {
				fnWriteSteps("Pass", "Active checkbox is not checked by default ");
			}
			if (memoDescription.isDisplayed()) {
				memoDescription.sendKeys(Description);
			} else {
				fnWriteSteps("Fail", "Description field is not enable");
			}
			
			switch (DiscountType) {
			case "Item":
				if (lookUpDiscountType.isDisplayed()) {
					lookUpDiscountType.click();
					LookUpEdit.sendKeys("Item");
					} else {
					fnWriteSteps("Fail", "Discount Type field is not enable");
				}

				if (calcSalesQuantity.isDisplayed()) {
						calcSalesQuantity.sendKeys(SaleQuantity);
					} else {
						fnWriteSteps("Fail", "Sales Quantity field is not enable");
					}
			      btnSave.click();
			  System.out.println("Item_DiscountRule has been Created & Saved");
	            
				break;
				
			case "Invoice":
                
				lookUpDiscountType.click();
				LookUpEdit.sendKeys("Invoice");
				if (calcMinDiscountAmount.isDisplayed()) {
					calcMinDiscountAmount.sendKeys(MinDiscountAmt);
				} else {
					fnWriteSteps("Fail", "Minimum invoice Amount field is not enable");
				}
				if (calcMaxDiscountAmount.isDisplayed()) {
					calcMaxDiscountAmount.sendKeys(MaxDiscountAmt);
				} else {
					fnWriteSteps("Fail", "Maximum invoice Amount field is not enable");
				}
				btnSave.click();
		   System.out.println("Invoice_DiscountRule has been Created & saved");
	      
				break;
			}
		}

	}
	// This method for Validation of New DiscountRule Creation :
	 public boolean Verify_DiscountRule_SaveorNot(String DiscountName) {
   	  
			if (txtSearch.isDisplayed()) {
				GenericMethods.fnwait(2);
				txtSearch.clear();
				txtSearch.sendKeys(DiscountName.trim());
				GenericMethods.fnwait(5);
			 } else {  fnWriteSteps("Fail", "DiscountName is not displayed in UI");
					   
         }
				 String Actual = driver.findElement(By.id("lblDiscountName")).getAttribute("Name");
			     if (Actual.substring(15,34).trim().substring(0,8).trim().equalsIgnoreCase(DiscountName.trim().substring(0, 8).trim())) {
							
						   return true;
						}
						
						   return false;
					}	
	// Modified by Moumita----26-June-2018----
	// This method is for verifying the Discount has been saved or not
	// Parameters are StartingRowNumber & LastRowNumber
	public void verifyDiscountSavedOrNot(int StartingRowNumber, int LastRowNumber) throws IOException {
		for (int StartFrom = StartingRowNumber; StartFrom <= LastRowNumber; StartFrom++) {
			String discountRuleType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Discount",
					StartFrom, 1);
			GenericMethods.fnwait(1);
			txtSearch.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Discount", StartFrom, 0));
			clickEditButton();
			GenericMethods.fnwait(1);
			try {
				switch (discountRuleType.toUpperCase()) {
				case "INVOICE":
					if (txtDiscountName.getText().equals(ExcelUtils
							.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Discount", StartFrom, 0))) {
						fnWriteSteps("Pass", "Discount Name is saved successfully");
					} else {
						fnWriteSteps("Fail", "Discount Name is not saved");
					}

					if (txtPromoCode.getText().equals(ExcelUtils
							.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Discount", StartFrom, 3))) {
						fnWriteSteps("Pass", "Promo Code is saved successfully");
					} else {
						fnWriteSteps("Fail", "Promo Code is not saved");
					}
					float fixedAmountFromExcel = Float.parseFloat(ExcelUtils
							.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Discount", StartFrom, 4));
					float fixedAmountFromApp = Float.parseFloat(calcFixedAmount.getText());

					/*
					 * Due to one issue with % symbol, I have commented this
					 * code float percentageFromExcel =
					 * Float.parseFloat(ExcelUtils
					 * .fnGetExcelCellValue(ApplicationVariables.
					 * MasterExcelPath, "Discount", StartFrom, 5)); float
					 * percentageFromApp =
					 * Float.parseFloat(calcPercentage.getText()); if
					 * (percentageFromExcel == percentageFromApp) {
					 * fnWriteSteps("Pass", "Percentage is saved successfully");
					 * } else { fnWriteSteps("Fail", "Percentage is not saved");
					 * }
					 */

					if (fixedAmountFromExcel == fixedAmountFromApp) {
						fnWriteSteps("Pass", "Fixed Amount is saved successfully");
					} else {
						fnWriteSteps("Fail", "Fixed Amount is not saved");
					}

					float minDiscountAmountFromExcel = Float.parseFloat(ExcelUtils
							.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Discount", StartFrom, 16));
					float minDiscountAmountFromApp = Float.parseFloat(calcMinDiscountAmount.getText());

					if (minDiscountAmountFromExcel == minDiscountAmountFromApp) {
						fnWriteSteps("Pass", "Minimum invoice Amount is saved successfully");
					} else {
						fnWriteSteps("Fail", "Minimum invoice Amount is not saved");
					}

					float maxDiscountAmountFromExcel = Float.parseFloat(ExcelUtils
							.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Discount", StartFrom, 17));
					float maxDiscountAmountFromApp = Float.parseFloat(calcMaxDiscountAmount.getText());
					if (maxDiscountAmountFromExcel == maxDiscountAmountFromApp) {
						fnWriteSteps("Pass", "Maximum invoice Amount is saved successfully");
					} else {
						fnWriteSteps("Fail", "Maximum invoice Amount is not saved");
					}

					if (chkActive.isSelected()) {
						fnWriteSteps("Pass", "Active checkbox is checked by default ");
					} else {
						fnWriteSteps("Pass", "Active checkbox is not checked by default ");
					}

					if (memoDescription.getText().equals(ExcelUtils
							.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Discount", StartFrom, 6))) {
						fnWriteSteps("Pass", "Description is saved successfully");
					} else {
						fnWriteSteps("Fail", "Description is not saved");
					}

					clickSaveButton();
					GenericMethods.fnwait(1);
					fnWriteSteps("Pass", "Discount Rule is saved successfully");
					break;

				case "ITEM":
					if (txtDiscountName.getText().equals(ExcelUtils
							.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Discount", StartFrom, 0))) {
						fnWriteSteps("Pass", "Discount Name is saved successfully");
					} else {
						fnWriteSteps("Fail", "Discount Name is not saved");
					}
					float salesQuantityFromExcel = Float.parseFloat(ExcelUtils
							.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Discount", StartFrom, 2));
					float salesQuantityFromApp = Float.parseFloat(calcSalesQuantity.getText());
					if (salesQuantityFromExcel == salesQuantityFromApp) {
						fnWriteSteps("Pass", "Sales Quantity is saved successfully");
					} else {
						fnWriteSteps("Fail", "Sales Quantity is not saved");
					}
					if (txtPromoCode.getText().equals(ExcelUtils
							.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Discount", StartFrom, 3))) {
						fnWriteSteps("Pass", "Promo Code is saved successfully");
					} else {
						fnWriteSteps("Fail", "Promo Code is not saved");
					}
					float fixedAmountFromExcel_item = Float.parseFloat(ExcelUtils
							.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Discount", StartFrom, 4));
					float fixedAmountFromApp_item = Float.parseFloat(calcFixedAmount.getText());

					/*
					 * Due to one issue with % symbol, I have commented this
					 * code float percentageFromExcel_item =
					 * Float.parseFloat(ExcelUtils
					 * .fnGetExcelCellValue(ApplicationVariables.
					 * MasterExcelPath, "Discount", StartFrom, 5));
					 * 
					 * String percentageFromApp_item = null;
					 * 
					 * WebElement percentageFromApp_itemEle =
					 * driver.findElement(By.id("calcPercentage"));
					 * 
					 * percentageFromApp_item =
					 * percentageFromApp_itemEle.getAttribute("Name"); String[]
					 * arrayList = percentageFromApp_item.split("%"); String
					 * percentageFromAppWithoutSymbol = arrayList[1];
					 * 
					 * System.out.println("percentageFromAppWithoutSymbol"
					 * +percentageFromAppWithoutSymbol); if
					 * (percentageFromExcel_item ==
					 * Float.parseFloat(percentageFromAppWithoutSymbol)) {
					 * fnWriteSteps("Pass", "Percentage is saved successfully");
					 * } else { fnWriteSteps("Fail", "Percentage is not saved");
					 * }
					 */

					if (fixedAmountFromExcel_item == fixedAmountFromApp_item) {
						fnWriteSteps("Pass", "Fixed Amount is saved successfully");
					} else {
						fnWriteSteps("Fail", "Fixed Amount is not saved");
					}

					if (chkActive.isSelected()) {
						fnWriteSteps("Pass", "Active checkbox is checked by default ");
					} else {
						fnWriteSteps("Pass", "Active checkbox is not checked by default ");
					}

					if (memoDescription.getText().equals(ExcelUtils
							.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Discount", StartFrom, 6))) {
						fnWriteSteps("Pass", "Description is saved successfully");
					} else {
						fnWriteSteps("Fail", "Description is not saved");
					}

					clickSaveButton();
					GenericMethods.fnwait(1);
					fnWriteSteps("Pass", "Discount Rule is saved successfully");

					break;
				}
			} catch (Exception e) {
				fnWriteSteps("Fail", "Discount Rule is not saved successfully");
			}
		}
	}
       // ...DiscountRule of Edit Option Removed...
	// This method for DiscountRule Edit :
	/*public void verifyDiscountEdit(String OldDiscountName,String DiscountName, String DiscountType, String SaleQuantity, String Promocode,
			String FixedAmount, String Percentage, String Description,String MinDiscountAmt,String MaxDiscountAmt) {
		
		txtSearch.sendKeys(OldDiscountName.trim());
		clickEditButton();
		GenericMethods.fnwait(1);
		GenericMethods.windows_Set_TextBoxValue(txtDiscountName, DiscountName);
		GenericMethods.windows_Set_TextBoxValue(txtPromoCode,Promocode);
		GenericMethods.windows_Set_TextBoxValue(calcFixedAmount,FixedAmount);
		GenericMethods.windows_Set_TextBoxValue(calcPercentage,Percentage);
		GenericMethods.windows_Set_TextBoxValue(memoDescription,Description);
		
		if (chkActive.isSelected()) {
			chkActive.click();
			fnWriteSteps("Pass", "Active checkbox is not checked by default ");
		} else {
			fnWriteSteps("Pass", "Active checkbox is checked by default ");
		}
		
		switch (DiscountType) {
		case "Item":
			
			if (lookUpDiscountType.isDisplayed()) {
				lookUpDiscountType.click();
				LookUpEdit.sendKeys("Item");
				} else {
				fnWriteSteps("Fail", "Discount Type field is not enable");
			}
			GenericMethods.windows_Set_TextBoxValue(calcSalesQuantity,SaleQuantity);
               btnSave.click();
		  System.out.println("Item_DiscountRule has been Updated & Saved");
            
			break;
			
		case "Invoice":
            
			lookUpDiscountType.click();
			LookUpEdit.sendKeys("Invoice");
			GenericMethods.windows_Set_TextBoxValue(calcMinDiscountAmount,MinDiscountAmt);
			GenericMethods.windows_Set_TextBoxValue(calcMaxDiscountAmount,MaxDiscountAmt);
		btnSave.click();
	   System.out.println("Invoice_DiscountRule has been Updated & saved");
      
			break;
		}
	}
*/     

	
  // This method is to verify all the fields are visible or not

	public void verifyFieldVisibility() {
	
		   if (btnAdd.isDisplayed()) {
				btnAdd.click();

				if (txtDiscountName.isDisplayed()) {
					fnWriteSteps("Pass", "Discount Name field is present");
				} else {
					fnWriteSteps("Fail", "Discount Name field is not present");
				}
				if (lookUpDiscountType.isDisplayed()) {
					lookUpDiscountType.sendKeys("Item");
					fnWriteSteps("Pass", "Discount Type field is present");
				} else {
					fnWriteSteps("Fail", "Discount Type field is not present");
				}
				if (calcSalesQuantity.isDisplayed()) {
					fnWriteSteps("Pass", "Sales Quantity field is present");
				} else {
					fnWriteSteps("Fail", "Sales Quantity field is not present");
				}
				if (txtPromoCode.isDisplayed()) {
					fnWriteSteps("Pass", "Promo code field is present");
				} else {
					fnWriteSteps("Fail", "Promo Code field is not present");
				}
				if (calcFixedAmount.isDisplayed()) {
					fnWriteSteps("Pass", "Fixed Amount field is present");
				} else {
					fnWriteSteps("Fail", "Fixed Amount field is not present");
				}
				if (calcPercentage.isDisplayed()) {
					fnWriteSteps("Pass", "Percentage field is present");
				} else {
					fnWriteSteps("Fail", "Percentage field is not present");
				}
				if (chkActive.isDisplayed()) {
					fnWriteSteps("Pass", "Active checkbox is present");
				} else {
					fnWriteSteps("Fail", "Active checkbox is not present");
				}
				if (memoDescription.isDisplayed()) {
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

				if (txtDiscountName.isEnabled()) {
					txtDiscountName.click();
					fnWriteSteps("Pass", "Discount Name field is enable");
				} else {
					fnWriteSteps("Fail", "Discount Name field is not enable");
				}
				if (lookUpDiscountType.isEnabled()) {
					lookUpDiscountType.click();
					lookUpDiscountType.sendKeys("Item");
					fnWriteSteps("Pass", "Discount Type field is enable");
				} else {
					fnWriteSteps("Fail", "Discount Type field is not enable");
				}
				if (calcSalesQuantity.isEnabled()) {
					calcSalesQuantity.click();
					fnWriteSteps("Pass", "Sales Quantity field is enable");
				} else {
					fnWriteSteps("Fail", "Sales Quantity field is not enable");
				}
				if (txtPromoCode.isEnabled()) {
					txtPromoCode.click();
					fnWriteSteps("Pass", "Promo code field is enable");
				} else {
					fnWriteSteps("Fail", "Promo code field is not enable");
				}
				if (calcFixedAmount.isEnabled()) {
					calcFixedAmount.click();
					fnWriteSteps("Pass", "Fixed Amount field is enable");
				} else {
					fnWriteSteps("Fail", "Fixed Amount field is not enable");
				}
				if (calcPercentage.isEnabled()) {
					calcPercentage.click();
					fnWriteSteps("Pass", "Percentage field is enable");
				} else {
					fnWriteSteps("Fail", "Percentage field is not enable");
				}
				if (chkActive.isEnabled()) {
					chkActive.click();
					fnWriteSteps("Pass", "Active checkbox is enable");
				} else {
					fnWriteSteps("Fail", "Active checkbox is not enable");
				}
				if (memoDescription.isEnabled()) {
					memoDescription.click();
					fnWriteSteps("Pass", "Description field is enable");
				} else {
					fnWriteSteps("Fail", "Description field is not enable");
				}
			}
		} 

	/*
	 * 2-July-18-----Added by Moumita
	 * 
	 * @purpose: This is the method to delete the record by delete icon from
	 * Agent master page
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
			r1.mouseMove(x1 + 360, y1 - 200);
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
	// This method for DiscountRuleDelete :
	public void fnVerifyDiscountDelete(String DiscountName) {
		txtSearch.sendKeys(DiscountName);
		GenericMethods.fnwait(1);
		fnVerifyMasterRecordDelete(grdRecordList);
		btnOk.click();
		GenericMethods.fnwait(35);
		System.out.println("Created DiscountRule has been Deleted");
	}
	// This method for Validation of DiscountRule Delete :
	public boolean Verify_DiscountRuleDelete_SaveorNot(String DiscountName) {
	   	  
		if (txtSearch.isDisplayed()) {
			GenericMethods.fnwait(1);
			txtSearch.sendKeys(DiscountName);
			GenericMethods.fnwait(4);
		 } else {  fnWriteSteps("Fail", "DiscountName is not displayed in UI");
				   
     }
			 String Actual = driver.findElement(By.id("lblDiscountName")).getAttribute("Name");
		    if (!Actual.substring(15,34).trim().substring(0,8).trim().contains(DiscountName.trim().substring(0, 8).trim())) {
						
					   return true;
					}
					
					   return false;
				}	

	/* 2-July-18-----Added by Moumita */
	/*
	 * This is the method to verify the record has been deleted successfully or
	 * not
	 */
	public void fnVerifyDiscountDeleteSuccessfulOrNot(String strDiscount) {
		txtSearch.clear();
		txtSearch.sendKeys(strDiscount);
		String gridNoDataLabel = null;

		WebElement messageEle = driver.findElement(By.id("lblNoData"));
		gridNoDataLabel = messageEle.getAttribute("Name");
		if (gridNoDataLabel.contains("No discount rule found")) {
			fnWriteSteps("pass", "Record has been deleted successfully");
		} else {
			fnWriteSteps("pass", "Record has not been deleted");
		}

	}
}
