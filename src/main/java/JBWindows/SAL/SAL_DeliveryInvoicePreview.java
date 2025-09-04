package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class SAL_DeliveryInvoicePreview extends BaseClass{

	@FindBy(id = "SAL_DeliveryInvoicePreview") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "TxtSearch") WebElement txtSearch;
	@FindBy(id = "grdInvoice") WebElement grdInvoice;
	@FindBy(id = "ReportPreview") WebElement ReportPreview;
	
	@FindBy(id = "btnPrint") WebElement BtnPrint;
	@FindBy(id = "btnPrintAll") WebElement BtnPrintAll;


	public SAL_DeliveryInvoicePreview() {
		pageName.click();
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickPrintButton()
	{
		BtnPrint.click();
	}
	
	public void clickPrintAllButton()
	{
		BtnPrintAll.click();
	}

}
