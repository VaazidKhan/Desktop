package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;
import commonClass.GenericMethods;

public class SAL_InvoiceRecall extends BaseClass{

	@FindBy(id = "SAL_InvoiceRecall") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "txtSearch") WebElement txtSearch;
	@FindBy(id = "grdQuotation") WebElement grdQuotation;
	@FindBy(id = "grdOrders") WebElement grdOrders;
	@FindBy(id = "grdHoldInvoice") WebElement grdHoldInvoice;
	
	@FindBy(id = "btnPrint") WebElement BtnPrint;
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnOk") WebElement BtnOk;
	
	@FindBy(name = "Row 1") WebElement firstRow;

	//------9-Feb-2018-----added by Moumita----
	public SAL_InvoiceRecall() {
		PageFactory.initElements(driver, this);
	}
	
	public void searchRecord(String transactionNo)
	{	
			txtSearch.sendKeys(transactionNo);	
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
	
	public void clickOkButton()
	{
		BtnOk.click();
	}
	
	public void clickPrintButton()
	{
		BtnPrint.click();
	}
	
	//------12-Feb-2018-----added by Moumita----
	//This is the method to verify whether the Order has been cancelled or not
	//Parameter is txtOrderNo
	public void verifyOrderCancellation(String txtOrderNo) {
		searchRecord(txtOrderNo);
		GenericMethods.fnwait(2);
		Boolean checkBtnOkIsDisplayed = BtnOk.isDisplayed();		
		if (checkBtnOkIsDisplayed == false)
		{			
			clickCloseButton();
			fnWriteSteps("pass", "Order has been cancelled successfully");
			
		}
		else
		{
			fnWriteSteps("Fail", "Order has not been cancelled");
		}
	}
	
	public void recallHoldInvoice() {		
		GenericMethods.DoubleClickAction("window", firstRow);
		GenericMethods.fnwait(1);
	}

}
