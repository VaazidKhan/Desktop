package JBWindows.RPT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonClass.BaseClass;

public class RPT_CustomerLedger extends BaseClass{
	
	@FindBy(id = "RPT_CustomerLedger") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "switchCustomerType") WebElement switchCustomerType;
	@FindBy(id = "txtSearch") WebElement txtSearch;
	@FindBy(id = "grdCustomer") WebElement grdCustomer;
	@FindBy(id = "txtInvoiceSearch") WebElement txtInvoiceSearch;
	@FindBy(id = "grdInvoice") WebElement grdInvoice;
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnPrint") WebElement BtnPrint;
	@FindBy(id = "btnShare") WebElement BtnShare;

	public RPT_CustomerLedger() {
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

	public void clickPrintButton()
	{
		BtnPrint.click();
	}
	
	public void clickShareButton()
	{
		BtnShare.click();
	}

}
