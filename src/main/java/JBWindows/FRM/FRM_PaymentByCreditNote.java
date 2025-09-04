package JBWindows.FRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class FRM_PaymentByCreditNote extends BaseClass{
	
	@FindBy(id = "FRM_PaymentByCreditNote") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "lookupCreditNoteNo") WebElement lookupCreditNoteNo;
	@FindBy(id = "dtCreditNoteDate") WebElement dtCreditNoteDate;
	@FindBy(id = "txtCustomer") WebElement txtCustomer;
	@FindBy(id = "calcNetPayble") WebElement calcNetPayble;
	@FindBy(id = "calcAmount") WebElement calcAmount;
	
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnSave") WebElement BtnSave;
	
	public FRM_PaymentByCreditNote() {
		PageFactory.initElements(driver, this);
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickCancelButton()
	{
		BtnCancel.click();
	}
	
	public void clickSaveButton()
	{
		BtnSave.click();
	}
	
	// ---26-April-2018--Added by Moumita--------
		public void selectCreditNoteDetails(int rowNumber, String amount) {

			lookupCreditNoteNo.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
					"Transaction_Invoice_TakeAway", 1,25));
			lookupCreditNoteNo.click();
			calcAmount.sendKeys(amount);
			BtnSave.click();
			GenericMethods.fnwait(2);
		}
	
}
