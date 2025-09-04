package JBWindows.FRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class FRM_PaymentByDebitNote extends BaseClass{

	@FindBy(id = "FRM_PaymentByDebitNote") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "lookupDebitNoteNo") WebElement lookupDebitNoteNo;
	@FindBy(id = "dtDebitNoteDate") WebElement dtDebitNoteDate;
	@FindBy(id = "txtAccount") WebElement txtAccount;
	@FindBy(id = "calcNetReceivable") WebElement calcNetReceivable;
	@FindBy(id = "calcAmount") WebElement calcAmount;
	
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnSave") WebElement BtnSave;


	public FRM_PaymentByDebitNote() {
		pageName.click();
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
	
}
