package JBWindows.INV;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class INV_InventoryAllocation extends BaseClass{
	
	@FindBy(id = "INV_InventoryAllocation") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "lookupFromBinLocation") WebElement lookupFromBinLocation;
	@FindBy(id = "lookupToBinLocation") WebElement lookupToBinLocation;
	@FindBy(id = "txtSearch") WebElement txtSearch;
	@FindBy(id = "grdMassInventory") WebElement grdMassInventory;
	@FindBy(id = "btnSave") WebElement BtnSave;
	@FindBy(id = "btnCancel") WebElement BtnCancel;

	public INV_InventoryAllocation() {
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
