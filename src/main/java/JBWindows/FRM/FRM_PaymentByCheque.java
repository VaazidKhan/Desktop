package JBWindows.FRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;

public class FRM_PaymentByCheque extends BaseClass{

	@FindBy(id = "FRM_PaymentByCheque") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "lookupOrgBankAccountNo") WebElement lookupOrgBankAccountNo; 
	@FindBy(id = "textChequeNo") WebElement textChequeNo;
	@FindBy(id = "dtChequeDate") WebElement dtChequeDate;
	@FindBy(id = "textBankName") WebElement textBankName;
	@FindBy(id = "textBranchName") WebElement textBranchName;
	@FindBy(id = "calcAmount") WebElement calcAmount;
	
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnSave") WebElement BtnSave;

	public FRM_PaymentByCheque() {
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
	
	//---25-April-2018--Added by Moumita--------
    public void selectChequeDetails(int rowNumber, String amount) {
    	
    	lookupOrgBankAccountNo.click();		
		lookupOrgBankAccountNo.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", rowNumber, 5));		
		lookupOrgBankAccountNo.click();		
		textChequeNo.sendKeys("47852365");
		dtChequeDate.sendKeys("25-April-2018");
		textBankName.sendKeys("Axis");
		textBranchName.sendKeys("Miyapur");
		calcAmount.sendKeys(amount);
		BtnSave.click();
		
	}

}
