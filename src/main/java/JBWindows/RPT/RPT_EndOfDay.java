package JBWindows.RPT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class RPT_EndOfDay extends BaseClass{

	@FindBy(id = "RPT_EndOfDay") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "cboPageSize") WebElement cboPageSize;
	@FindBy(id = "dtFromDate") WebElement dtFromDate;
	@FindBy(id = "ReportPreview") WebElement ReportPreview;	
	@FindBy(id = "btnSMS") WebElement BtnSMS;
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnPrint") WebElement BtnPrint;
	@FindBy(id = "btnShare") WebElement BtnShare;

	public RPT_EndOfDay() {
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
	public void clickSMSButton()
	{
		BtnSMS.click();
	}

}
