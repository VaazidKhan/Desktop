package JBWindows.CRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class CRM_DocumentViewer extends BaseClass{

	@FindBy(id = "CRM_DocumentViewer") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "pdfViewerFiles") WebElement pdfViewerFiles;
	@FindBy(id = "btnShare") WebElement BtnShare;
	@FindBy(id = "btnPrint") WebElement BtnPrint;

	public CRM_DocumentViewer() {
		pageName.click();
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickShareButton()
	{
		BtnShare.click();
	}

	public void clickPrintButton()
	{
		BtnPrint.click();
	}

}
