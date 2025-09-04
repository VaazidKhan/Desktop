package JBWindows.FRM;

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

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class FRM_OperatingExpenses extends BaseClass {
	// Header elements
	@FindBy(id = "picClose")
	WebElement btnClose;
	@FindBy(id = "lblCaption")
	WebElement PageCaption;
	@FindBy(id = "picLogo")
	WebElement HeaderJBLogo;

	// Master page button elements
	@FindBy(id = "FRM_OperatingExpenses")
	WebElement PageName;
	@FindBy(id = "btnAdd")
	WebElement btnAdd;
	@FindBy(id = "btnSave")
	WebElement btnEdit;
	@FindBy(id = "txtSearch")
	WebElement TxtSearch;
	@FindBy(id = "btnPayment")
	WebElement btnPayment;

	// Entry OR Edit page elements
	@FindBy(id = "lookUpLedger")
	WebElement lookUpLedger;
	@FindBy (id="lookupBranch")
	WebElement requestBranch;
	@FindBy(id = "txtPaymentTo")
	WebElement txtPaymentTo;
	@FindBy (id="lookupExpenseCategory")
	WebElement dropExpenseCatagory;
	@FindBy (id="lookupSubExpenseCategory")
	WebElement dropExpenseSubCategory;
	@FindBy(id = "dtExpenseDate")
	WebElement dtExpenseDate;
	@FindBy(id = "dtExpenseVoucherDate")
	WebElement dtExpenseVoucherDate;
	@FindBy(id = "calcExpenseAmount")
	WebElement calcExpenseAmount;
	@FindBy(id = "txtReferenceDocumentNo")
	WebElement txtReferenceDocumentNo;
	@FindBy(id = "lookUpTax1")
	WebElement lookUpTax1;
	@FindBy(id = "calcTaxAmount1")
	WebElement calcTaxAmount1;
	@FindBy(id = "lookUpTax2")
	WebElement lookUpTax2;
	@FindBy(id = "calcTaxAmount2")
	WebElement calcTaxAmount2;
	@FindBy(id = "lookUpTax3")
	WebElement lookUpTax3;
	@FindBy(id = "calcTaxAmount3")
	WebElement calcTaxAmount3;
	@FindBy(id = "lookUpRounding")
	WebElement lookUpRounding;
	@FindBy(id = "calcRounding")
	WebElement calcRounding;
	@FindBy(id = "calcNetPayable")
	WebElement calcNetPayable;
	@FindBy(id = "lookupState")
	WebElement lookupState;
	@FindBy(id = "txtGST")
	WebElement txtGST;
	@FindBy(id = "memoExpenseDetails")
	WebElement memoExpenseDetails;
	@FindBy(id = "picExpence")
	WebElement Expense;
	@FindBy(id = "lblDiscountInvoices")
	WebElement DiscountInvoice;

	// Entry or Edit page elements
	@FindBy(id = "btnSave")
	WebElement btnSave;
	@FindBy(id = "btnCancel")
	WebElement btnCancel;
/*	
   @FindBy (id="lookUpEdit")
   WebElement ledger;
   @FindBy (id="txtPaymentTo")
   WebElement btnPaymentTo;*/
 //  @FindBy (id="")
	
	//----21-Feb-2018--Added by Moumita-------
	@FindBy(name = "scroll bar") WebElement listScrollBar;

	public FRM_OperatingExpenses() {
		PageFactory.initElements(driver, this);
	}

	public void activatePage() {
		PageName.click();
	}

	public void clickNewExpense() {
		btnAdd.click();
	}

	public void clickSaveButton() {
		btnSave.click();
	}

	public void clickEditButton() {
		btnEdit.click();
	}

	public void clickPaymentButton() {
		btnPayment.click();
	}

	public void clickCancelButton() {
		btnCancel.click();
	}
	public void ProductSearchClear() {
		TxtSearch.click();
		TxtSearch.clear();
	}
	
	
	public void clickCloseButton() {
		HeaderJBLogo.click();
		btnClose.click();
	}
	public void enter_Request_Branch(String strRequestBranch ) {
		HeaderJBLogo.click();
		GenericMethods.windows_Set_DropDown_Value(requestBranch, strRequestBranch);
		btnSave.click();
	}
	public void fnSearchExpenseAndCompletePayment(String expenseNumber) {
		
		TxtSearch.sendKeys(expenseNumber);
	//	txtSearch.submit();
		GenericMethods.fnwait(2);
		clickPaymentButton();
		
	}
	public void Click_on_ExpenseOption_From_Dashboard() {
		clickCloseButton();
		DiscountInvoice.click();
		Expense.click();
	}
	
	// ---20-Feb-2018--Modified by Moumita----
	public void createNewExpense(int rowNo) {

			// Enter details
			try {
				if (btnAdd.isDisplayed()) {
					btnAdd.click();
			lookUpLedger.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 0));
			lookUpLedger.submit();
			txtPaymentTo.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 1));
			GenericMethods.fnwait(2);
			/*dtExpenseDate.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 2));
			dtExpenseVoucherDate.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 3));
			*/
			calcExpenseAmount.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 4));
			txtReferenceDocumentNo.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 5));
			lookUpTax1.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 6));
			lookUpTax1.click();
			lookUpTax2.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 7));
			lookUpTax2.click();
			lookUpTax3.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 8));
			lookUpTax3.click();
			lookupState.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 9));
			lookupState.click();
			txtGST.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 10));
			memoExpenseDetails.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 11));

			// saving the record
			btnSave.click();			
		}
			} catch (Exception e) {
				lookUpLedger.sendKeys(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 0));
				lookUpLedger.click();
				txtPaymentTo.sendKeys(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 1));
				/*dtExpenseDate.sendKeys(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 2));
				dtExpenseVoucherDate.sendKeys(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 3));
				*/calcExpenseAmount.sendKeys(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 4));
				txtReferenceDocumentNo.sendKeys(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 5));
				lookUpTax1.sendKeys(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 6));
				lookUpTax1.click();
				lookUpTax2.sendKeys(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 7));
				lookUpTax2.click();
				lookUpTax3.sendKeys(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 8));
				lookUpTax3.click();
				lookupState.sendKeys(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 9));
				lookupState.click();
				txtGST.sendKeys(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 10));
				memoExpenseDetails.sendKeys(
						ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Expense", rowNo, 11));
				btnSave.click();	
			}
		}
	
	public void create_Expense_Vochure(String strLedge,String strPaymentTo,String Category,String strCategoryValue1,String stCategoryValue2,String Date,String strExpenseDate,
			String strExpenseVochureDate,String strExpenseAmount,String document,String strDocument,String strExpenseDetails,String strTax,String strTax1,String strTax2,String strTax3) {
		  HeaderJBLogo.click();
		  GenericMethods.windows_Set_DropDown_Value(lookUpLedger, strLedge);
		  txtPaymentTo.sendKeys(strPaymentTo);
		switch (Category) {
		case "Category":
			GenericMethods.windows_Set_DropDown_Value(dropExpenseCatagory, strCategoryValue1);
			break;

		case "Sub Category":
			GenericMethods.windows_Set_DropDown_Value(dropExpenseSubCategory, stCategoryValue2);
			break;
		case "Both":
			GenericMethods.windows_Set_DropDown_Value(dropExpenseCatagory, strCategoryValue1);
			GenericMethods.windows_Set_DropDown_Value(dropExpenseSubCategory, stCategoryValue2);
			break;
		}
		switch (Date) {
		case "Expense Date":
			GenericMethods.windows_Set_TextBoxValue(dtExpenseDate, strExpenseDate);
			break;

		case "Expense Vochure Date":
			GenericMethods.windows_Set_TextBoxValue(dtExpenseVoucherDate, strExpenseVochureDate);
			break;
		case "Both":
			GenericMethods.windows_Set_TextBoxValue(dtExpenseDate, strExpenseDate);
			GenericMethods.windows_Set_TextBoxValue(dtExpenseVoucherDate, strExpenseVochureDate);
			break;
		}
		
		calcExpenseAmount.sendKeys(strExpenseAmount);
		
		if(document.trim().equals("Document")) {
			txtReferenceDocumentNo.sendKeys(strDocument);
			}
		if(strTax.trim().equals("Tax")) {
			GenericMethods.windows_Set_DropDown_Value(lookUpTax1, strTax1);
			GenericMethods.windows_Set_DropDown_Value(lookUpTax2, strTax2);
			GenericMethods.windows_Set_DropDown_Value(lookUpTax3, strTax3);
		}
		memoExpenseDetails.sendKeys(strExpenseDetails);
		
		btnSave.click();
	}
	
		
		// This method is to verify all the fields are visible or not

		public void VerifyFieldVisibility() {
			try {
				if (btnAdd.isDisplayed()) {
					btnAdd.click();

					if (lookUpLedger.isDisplayed()) {
						fnWriteSteps("Pass", "Ledger field is present");
					} else {
						fnWriteSteps("Fail", "Ledger field is not present");
					}
					if (txtPaymentTo.isDisplayed()) {
						fnWriteSteps("Pass", "Payment To field is present");
					} else {
						fnWriteSteps("Fail", "Payment To field is not present");
					}
					if (dtExpenseDate.isDisplayed()) {
						fnWriteSteps("Pass", "Expense Date field is present");
					} else {
						fnWriteSteps("Fail", "Expense Date field is not present");
					}					
					if (dtExpenseVoucherDate.isDisplayed()) {
						fnWriteSteps("Pass", "Expense Voucher Date field is present");
					} else {
						fnWriteSteps("Fail", "Expense Voucher Date field is not present");
					}
					if (calcExpenseAmount.isDisplayed()) {
						fnWriteSteps("Pass", "Expense Amount field is present");
					} else {
						fnWriteSteps("Fail", "Expense Amount field is not present");
					}
					if (txtReferenceDocumentNo.isDisplayed()) {
						fnWriteSteps("Pass", "Reference Document No field is present");
					} else {
						fnWriteSteps("Fail", "Reference Document No field is not present");
					}
					if (lookUpTax1.isDisplayed()) {
						fnWriteSteps("Pass", "Tax 1 field is present");
					} else {
						fnWriteSteps("Fail", "Tax 1 field is not present");
					}
					if (lookUpTax2.isDisplayed()) {
						fnWriteSteps("Pass", "Tax 2 field is present");
					} else {
						fnWriteSteps("Fail", "Tax 2 field is not present");
					}
					if (lookupState.isDisplayed()) {
						fnWriteSteps("Pass", "State field is present");
					} else {
						fnWriteSteps("Fail", "State field is not present");
					}
					if (txtGST.isDisplayed()) {
						fnWriteSteps("Pass", "GST No field is present");
					} else {
						fnWriteSteps("Fail", "GST No field is not present");
					}
					if (memoExpenseDetails.isDisplayed()) {
						fnWriteSteps("Pass", "Expense Details field is present");
					} else {
						fnWriteSteps("Fail", "Expense Details field is not present");
					}
				}
			} catch (Exception e) {
				if (lookUpLedger.isDisplayed()) {
					fnWriteSteps("Pass", "Ledger field is present");
				} else {
					fnWriteSteps("Fail", "Ledger field is not present");
				}
				if (txtPaymentTo.isDisplayed()) {
					fnWriteSteps("Pass", "Payment To field is present");
				} else {
					fnWriteSteps("Fail", "Payment To field is not present");
				}
				if (dtExpenseDate.isDisplayed()) {
					fnWriteSteps("Pass", "Expense Date field is present");
				} else {
					fnWriteSteps("Fail", "Expense Date field is not present");
				}					
				if (dtExpenseVoucherDate.isDisplayed()) {
					fnWriteSteps("Pass", "Expense Voucher Date field is present");
				} else {
					fnWriteSteps("Fail", "Expense Voucher Date field is not present");
				}
				if (calcExpenseAmount.isDisplayed()) {
					fnWriteSteps("Pass", "Expense Amount field is present");
				} else {
					fnWriteSteps("Fail", "Expense Amount field is not present");
				}
				if (txtReferenceDocumentNo.isDisplayed()) {
					fnWriteSteps("Pass", "Reference Document No field is present");
				} else {
					fnWriteSteps("Fail", "Reference Document No field is not present");
				}
				if (lookUpTax1.isDisplayed()) {
					fnWriteSteps("Pass", "Tax 1 field is present");
				} else {
					fnWriteSteps("Fail", "Tax 1 field is not present");
				}
				if (lookUpTax2.isDisplayed()) {
					fnWriteSteps("Pass", "Tax 2 field is present");
				} else {
					fnWriteSteps("Fail", "Tax 2 field is not present");
				}
				if (lookupState.isDisplayed()) {
					fnWriteSteps("Pass", "State field is present");
				} else {
					fnWriteSteps("Fail", "State field is not present");
				}
				if (txtGST.isDisplayed()) {
					fnWriteSteps("Pass", "GST No field is present");
				} else {
					fnWriteSteps("Fail", "GST No field is not present");
				}
				if (memoExpenseDetails.isDisplayed()) {
					fnWriteSteps("Pass", "Expense Details field is present");
				} else {
					fnWriteSteps("Fail", "Expense Details field is not present");
				}
			}
		}

		// This method is to verify all the fields are enable or not

		public void VerifyFieldEnableOrNot() {
			try {
				if (btnAdd.isDisplayed()) {
					btnAdd.click();

					if (lookUpLedger.isEnabled()) {
						lookUpLedger.click();
						lookUpLedger.click();
						fnWriteSteps("Pass", "Ledger field is enable");
					} else {
						fnWriteSteps("Fail", "Ledger field is not enable");
					}
					if (txtPaymentTo.isEnabled()) {
						txtPaymentTo.click();
						fnWriteSteps("Pass", "Payment To field is enable");
					} else {
						fnWriteSteps("Fail", "Payment To field is not enable");
					}
					if (dtExpenseDate.isEnabled()) {
						dtExpenseDate.click();
						fnWriteSteps("Pass", "Expense Date field is enable");
					} else {
						fnWriteSteps("Fail", "Expense Date field is not enable");
					}
					if (dtExpenseVoucherDate.isEnabled()) {
						dtExpenseVoucherDate.click();
						fnWriteSteps("Pass", "Expense Voucher Date field is enable");
					} else {
						fnWriteSteps("Fail", "Expense Voucher Date field is not enable");
					}
					if (calcExpenseAmount.isEnabled()) {
						calcExpenseAmount.click();
						fnWriteSteps("Pass", "Expense Amount field is enable");
					} else {
						fnWriteSteps("Fail", "Expense Amount field is not enable");
					}
					if (txtReferenceDocumentNo.isEnabled()) {
						txtReferenceDocumentNo.click();
						fnWriteSteps("Pass", "Reference Document No field is enable");
					} else {
						fnWriteSteps("Fail", "Reference Document No field is not enable");
					}
					if (lookUpTax1.isEnabled()) {
						lookUpTax1.click();
						lookUpTax1.click();
						fnWriteSteps("Pass", "Tax 1 field is enable");
					} else {
						fnWriteSteps("Fail", "Tax 1 field is not enable");
					}
					if (lookUpTax2.isEnabled()) {
						lookUpTax2.click();
						lookUpTax2.click();
						fnWriteSteps("Pass", "Tax 2 field is enable");
					} else {
						fnWriteSteps("Fail", "Tax 2 field is not enable");
					}
					if (lookUpTax3.isEnabled()) {
						lookUpTax3.click();
						lookUpTax3.click();
						fnWriteSteps("Pass", "Tax 3 field is enable");
					} else {
						fnWriteSteps("Fail", "Tax 3 field is not enable");
					}
					if (lookupState.isEnabled()) {
						lookupState.click();
						fnWriteSteps("Pass", "State field is enable");
					} else {
						fnWriteSteps("Fail", "State field is not enable");
					}
					if (txtGST.isEnabled()) {
						txtGST.click();
						fnWriteSteps("Pass", "GST No field is enable");
					} else {
						fnWriteSteps("Fail", "GST No field is not enable");
					}
					if (memoExpenseDetails.isEnabled()) {
						memoExpenseDetails.click();
						fnWriteSteps("Pass", "Expense Details field is enable");
					} else {
						fnWriteSteps("Fail", "Expense Details field is not enable");
					}
				}
			} catch (Exception e) {
				if (lookUpLedger.isEnabled()) {
					lookUpLedger.click();
					lookUpLedger.click();
					fnWriteSteps("Pass", "Ledger field is enable");
				} else {
					fnWriteSteps("Fail", "Ledger field is not enable");
				}
				if (txtPaymentTo.isEnabled()) {
					txtPaymentTo.click();
					fnWriteSteps("Pass", "Payment To field is enable");
				} else {
					fnWriteSteps("Fail", "Payment To field is not enable");
				}
				if (dtExpenseDate.isEnabled()) {
					dtExpenseDate.click();
					fnWriteSteps("Pass", "Expense Date field is enable");
				} else {
					fnWriteSteps("Fail", "Expense Date field is not enable");
				}
				if (dtExpenseVoucherDate.isEnabled()) {
					dtExpenseVoucherDate.click();
					fnWriteSteps("Pass", "Expense Voucher Date field is enable");
				} else {
					fnWriteSteps("Fail", "Expense Voucher Date field is not enable");
				}
				if (calcExpenseAmount.isEnabled()) {
					calcExpenseAmount.click();
					fnWriteSteps("Pass", "Expense Amount field is enable");
				} else {
					fnWriteSteps("Fail", "Expense Amount field is not enable");
				}
				if (txtReferenceDocumentNo.isEnabled()) {
					txtReferenceDocumentNo.click();
					fnWriteSteps("Pass", "Reference Document No field is enable");
				} else {
					fnWriteSteps("Fail", "Reference Document No field is not enable");
				}
				if (lookUpTax1.isEnabled()) {
					lookUpTax1.click();
					lookUpTax1.click();
					fnWriteSteps("Pass", "Tax 1 field is enable");
				} else {
					fnWriteSteps("Fail", "Tax 1 field is not enable");
				}
				if (lookUpTax2.isEnabled()) {
					lookUpTax2.click();
					lookUpTax2.click();
					fnWriteSteps("Pass", "Tax 2 field is enable");
				} else {
					fnWriteSteps("Fail", "Tax 2 field is not enable");
				}
				if (lookUpTax3.isEnabled()) {
					lookUpTax3.click();
					lookUpTax3.click();
					fnWriteSteps("Pass", "Tax 3 field is enable");
				} else {
					fnWriteSteps("Fail", "Tax 3 field is not enable");
				}
				if (lookupState.isEnabled()) {
					lookupState.click();
					fnWriteSteps("Pass", "State field is enable");
				} else {
					fnWriteSteps("Fail", "State field is not enable");
				}
				if (txtGST.isEnabled()) {
					txtGST.click();
					fnWriteSteps("Pass", "GST No field is enable");
				} else {
					fnWriteSteps("Fail", "GST No field is not enable");
				}
				if (memoExpenseDetails.isEnabled()) {
					memoExpenseDetails.click();
					fnWriteSteps("Pass", "Expense Details field is enable");
				} else {
					fnWriteSteps("Fail", "Expense Details field is not enable");
				}
			}
		}
		//----21-Feb-2018--Added by Moumita-------		
		
		public void fnExpenseSavedOrNot(String expenseNumber) {
			
			TxtSearch.sendKeys(expenseNumber);
			GenericMethods.fnwait(1);
			if (listScrollBar.isDisplayed())
			{
				fnWriteSteps("Pass", "Expense has been saved successfully");
			}else 
			{
				fnWriteSteps("Fail", "Expense has not been saved");
			}
		}
		
		//
		public boolean validate_Expense_Date_Expense_Vochure(String Expense,String strExpenseDate,String strExpenseVochureDate) {
			boolean result=true;
			switch (Expense) {
			case "Greater":
				dtExpenseDate.clear();
				dtExpenseDate.sendKeys(strExpenseDate);
				dtExpenseVoucherDate.clear();
				dtExpenseVoucherDate.sendKeys(strExpenseVochureDate);
				
				/*GenericMethods.windows_Set_TextBoxValue(dtExpenseDate, strExpenseDate);
				GenericMethods.windows_Set_TextBoxValue(dtExpenseVoucherDate, strExpenseVochureDate);*/
				String date=dtExpenseDate.getAttribute("Name");
				if(date.trim().contains("Operating Expenses")) {
				result=false;
			}
				break;

			case "Expense Date":
				GenericMethods.windows_Set_TextBoxValue(dtExpenseDate, strExpenseDate);
				txtReferenceDocumentNo.click();
				String expenseDate1=strExpenseDate.substring(0,2);
				String expensedate=dtExpenseDate.getAttribute("Name");
				String expenseDate2=expensedate.substring(0,2);
				
				if(expenseDate1!=expenseDate2) {
					result=false;
				}
				break;
			case "Expense Vochure Date":
				GenericMethods.windows_Set_TextBoxValue(dtExpenseVoucherDate, strExpenseVochureDate);
				txtReferenceDocumentNo.click();
				String vochureDate=strExpenseVochureDate.substring(0,2);
				String expenseVochureDate=	dtExpenseVoucherDate.getAttribute("Name");
			    String vochureDate1=expenseVochureDate.substring(0,2);
			
			     if(vochureDate!=vochureDate1) {
				      result=false;
			}
			break;
			
		}
			return result;
		}
		
		public void expense_Vochure_Modification(String document,String strReferenceDocument,String Category,String strCategoryValue1,String stCategoryValue2,String taxes,String strTaxValue1,String strTaxValue2,String strTaxValue3 ) {
			if(document.equals("Document")) {
				GenericMethods.windows_Set_TextBoxValue(txtReferenceDocumentNo, strReferenceDocument);
				}
			switch (Category) {
			case "Expense Category":
				GenericMethods.windows_Set_DropDown_Value(dropExpenseCatagory, strCategoryValue1);
				break;
			case "Sub Category":
				GenericMethods.windows_Set_DropDown_Value(dropExpenseSubCategory, stCategoryValue2);
				break;
			case "Both":
				GenericMethods.windows_Set_DropDown_Value(dropExpenseCatagory, strCategoryValue1);
				GenericMethods.windows_Set_DropDown_Value(dropExpenseSubCategory, stCategoryValue2);
				break;
			}
			if(taxes.equals("Taxes")) {
				GenericMethods.windows_Set_DropDown_Value(lookUpTax1, strTaxValue1);
			    GenericMethods.windows_Set_DropDown_Value(lookUpTax2, strTaxValue2);
			    GenericMethods.windows_Set_DropDown_Value(lookUpTax3, strTaxValue3);
			}
			
        }
		
		public boolean validate_Modification_Edit_Button() {
			
		boolean result=true;
		int edit=	driver.findElements(By.id("btnSave")).size();
		if(edit==0) {
			result=false;
		}
		return result;	
		}
		public boolean delete_Vochure(String strVochure,String Remarks) {
			GenericMethods.fnwait(3);
			driver.findElement(By.id("lblCaption")).click();
			GenericMethods.windows_Set_TextBoxValue(TxtSearch, strVochure);
			GenericMethods.fnwait(3);
			/*Screen screen=new Screen();
			Pattern pattern=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Delete1.PNG");
			screen.click(pattern);*/
			//screen.click(pattern);
			PointerInfo a2 = MouseInfo.getPointerInfo();
		Point b2 = a2.getLocation();
			GenericMethods.fnwait(1);
			int x2 = (int) b2.getX();
			GenericMethods.fnwait(1);
			int y2 = (int) b2.getY();

			Robot r2;
			try {
				r2 = new Robot();
				r2.mouseMove(x2+380, y2+50);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			GenericMethods.fnwait(1);
			Actions builder2 = new Actions(driver);
			builder2.click().build().perform();
			GenericMethods.fnwait(3);
			//PopUpClick.click();
			driver.findElement(By.id("lblHeader")).click();
			
			//btnok.click();
			driver.findElement(By.id("btnOk")).click();
			
			GenericMethods.fnwait(5);
			HeaderJBLogo.click();
			driver.findElement(By.name("Delete remarks")).sendKeys(Remarks);
			WebElement saveButton=driver.findElement(By.id("btnSave"));//click();
			if(saveButton.isDisplayed()) {
				saveButton.click();
				return true;
			}
			return false;
		}
		public void search_Product(String strProduct) {
			GenericMethods.windows_Set_TextBoxValue(TxtSearch, strProduct);
		}
		public void click_Delete_Button() {
			driver.findElement(By.id("btnDelete")).click();
			GenericMethods.fnwait(2);
		}
		public boolean send_Remarks(String Remarks) {
			HeaderJBLogo.click();
			driver.findElement(By.name("Delete remarks")).sendKeys(Remarks);
			WebElement saveButton=driver.findElement(By.id("btnSave"));
			if(saveButton.isDisplayed()) {
				saveButton.click();
				GenericMethods.fnwait(10);
				return true;
			}
			return false;
		}
		
		
		
}
