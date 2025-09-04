package JBWindows.COM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class COM_DeptPrinterName extends BaseClass{
	
	@FindBy(id = "COM_DeptPrinterName") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnSave") WebElement BtnSave;

	public COM_DeptPrinterName() {
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
