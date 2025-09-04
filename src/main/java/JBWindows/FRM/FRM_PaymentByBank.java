package JBWindows.FRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class FRM_PaymentByBank extends BaseClass{

	@FindBy(id = "FRM_PaymentByBank") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "lookupOrgBankAccountNo") WebElement lookupOrgBankAccountNo;
	@FindBy(id = "textReferenceNo") WebElement textReferenceNo;
	@FindBy(id = "textBankName") WebElement textBankName;
	@FindBy(id = "calcAmount") WebElement calcAmount;

	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnSave") WebElement BtnSave;
	
	public FRM_PaymentByBank() {
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
	
	//---16-April-2018--Added by Moumita--------	 
	//---27-April-2018--Modified by Moumita--------	
	public void selectBankDetails(int rowNumber, String amount) {
		
		lookupOrgBankAccountNo.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", rowNumber, 5));
		lookupOrgBankAccountNo.click();		
		textReferenceNo.sendKeys("47852365");
		textBankName.sendKeys("Axis");
		calcAmount.clear();
		GenericMethods.fnwait(1);
		calcAmount.sendKeys(amount);
		GenericMethods.fnwait(1);
		BtnSave.click();		
	}
	
}
