package JBWindows.INV;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class INV_Production extends BaseClass{

	@FindBy(id = "INV_Production") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "LookupFinishedGood") WebElement LookupFinishedGood;
	@FindBy(id = "txtFinishedGoodUnit") WebElement txtFinishedGoodUnit;
	@FindBy(id = "calcQuantity") WebElement calcQuantity;
	@FindBy(id = "BomDate") WebElement BomDate;
	@FindBy(id = "LookUpBOM") WebElement LookUpBOM;
	@FindBy(id = "grdBomLines") WebElement grdBomLines;
	@FindBy(id = "calcLabourCost") WebElement calcLabourCost;
	@FindBy(id = "calcLoadingCost") WebElement calcLoadingCost;
	@FindBy(id = "calcMaterialCost") WebElement calcMaterialCost;
	@FindBy(id = "calcOverheadCost") WebElement calcOverheadCost;
	@FindBy(id = "calcWastageCost") WebElement calcWastageCost;
	@FindBy(id = "calcUnitprice") WebElement calcUnitprice;
	@FindBy(id = "btnSave") WebElement BtnSave;
	@FindBy(id = "btnSaveBOM") WebElement BtnSaveBOM;
	@FindBy(id = "btnCancel") WebElement BtnCancel;

	public INV_Production() {
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
	
	public void clickSaveBOMButton()
	{
		BtnSaveBOM.click();
	}
}
