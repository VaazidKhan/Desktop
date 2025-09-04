package JBWindows.INV;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class INV_MassInventoryEntry extends BaseClass{

	@FindBy(id = "INV_MassInventoryEntry") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "lookupAdjustmentType") WebElement lookupAdjustmentType;
	@FindBy(id = "lookupBinLocation") WebElement lookupBinLocation;
	@FindBy(id = "txtSearch") WebElement txtSearch;
	@FindBy(id = "grdMassInventory") WebElement grdMassInventory;
	@FindBy(id = "btnSave") WebElement BtnSave;
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	
	//--21-Feb-2018---Added by Moumita----
	@FindBy(name = "Quantity row 0") WebElement quantityRow;

	public INV_MassInventoryEntry() {
		PageFactory.initElements(driver, this);
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
	
	//--21-Feb-2018---Added by Moumita----
	public void fnUpdateInventory(int rowNo)
	{
		lookupAdjustmentType.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "InventoryAdjustment", rowNo, 0));
		lookupAdjustmentType.click();
		GenericMethods.fnwait(1);	
		
		txtSearch.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "InventoryAdjustment", rowNo, 1));
		GenericMethods.fnwait(1);
		quantityRow.sendKeys("10");
		clickSaveButton();
		GenericMethods.fnwait(1);		
	}

}
