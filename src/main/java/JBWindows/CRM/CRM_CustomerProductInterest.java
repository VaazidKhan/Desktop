package JBWindows.CRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class CRM_CustomerProductInterest extends BaseClass{
	
	@FindBy(id = "CRM_CustomerProductInterest") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "btnPrint") WebElement BtnPrint;
	@FindBy(id = "btnView") WebElement BtnView;
	@FindBy(id = "btnSave") WebElement BtnSave;
	@FindBy(id = "btnCancel") WebElement BtnCancel;

	public CRM_CustomerProductInterest() {
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
	
	public void clickViewButton()
	{
		BtnView.click();
	}

	public void clickSaveButton()
	{
		BtnSave.click();
	}
	
}
