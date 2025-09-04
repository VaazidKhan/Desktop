package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class SAL_DataFilterPopup extends BaseClass{

	@FindBy(id = "SAL_DataFilterPopup") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "cboDateType") WebElement cboDateType;
	@FindBy(id = "DtFromDate") WebElement DtFromDate;
	@FindBy(id = "DtTodate") WebElement DtTodate;
	@FindBy(id = "lookupStatus") WebElement lookupStatus;
	
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnOk") WebElement BtnOk;


	public SAL_DataFilterPopup() {
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
