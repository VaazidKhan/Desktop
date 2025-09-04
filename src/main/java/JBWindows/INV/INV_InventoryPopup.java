package JBWindows.INV;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class INV_InventoryPopup extends BaseClass{

	@FindBy(id = "INV_InventoryPopup") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "rgAdjustmentType") WebElement rgAdjustmentType;
	@FindBy(id = "btnOk") WebElement BtnOk;
	@FindBy(id = "btnCancel") WebElement BtnCancel;

	public INV_InventoryPopup() {
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
