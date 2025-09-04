package JBWindows.INV;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class INV_CategoryPopup extends BaseClass{	
	
	@FindBy(id = "INV_CategoryPopup") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "picCategory") WebElement picCategory;
	@FindBy(id = "cboCategoryTypeCode") WebElement cboCategoryTypeCode;
	@FindBy(id = "txtCategory") WebElement txtCategory;
	@FindBy(id = "memoDescription") WebElement memoDescription;
	@FindBy(id = "LookUpDepartment") WebElement LookUpDepartment;
	@FindBy(id = "btnSave") WebElement BtnSave;
	@FindBy(id = "btnCancel") WebElement BtnCancel;

	public INV_CategoryPopup() {
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
