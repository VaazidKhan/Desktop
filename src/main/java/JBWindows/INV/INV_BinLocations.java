package JBWindows.INV;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class INV_BinLocations extends BaseClass{
	
	@FindBy(id = "INV_BinLocations") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "btnAdd") WebElement BtnAdd;
	@FindBy(id = "btnSave") WebElement BtnEdit;
	@FindBy(id = "txtSearch") WebElement txtSearch;
	@FindBy(id = "txtBinlocation") WebElement txtBinlocation;
	@FindBy(id = "chkActive") WebElement chkActive;
	@FindBy(id = "chkDefault") WebElement chkDefault;
	@FindBy(id = "btnSave") WebElement BtnSave;
	@FindBy(id = "btnCancel") WebElement BtnCancel;

	public INV_BinLocations() {
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
	
	public void clickEditButton()
	{
		BtnEdit.click();
	}
	
	public void clickAddButton()
	{
		BtnAdd.click();
	}
}
