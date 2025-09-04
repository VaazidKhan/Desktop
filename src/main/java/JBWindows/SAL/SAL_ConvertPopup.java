package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class SAL_ConvertPopup extends BaseClass{
	
	@FindBy(id = "SAL_ConvertPopup") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "btnOk") WebElement BtnOk;
	@FindBy(id = "rgConvertTo") WebElement rgConvertTo;
	
	@FindBy(id = "btnCancel") WebElement BtnCancel;


	public SAL_ConvertPopup() {
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
	
	public void clickOkButton()
	{
		BtnOk.click();
	}

}
