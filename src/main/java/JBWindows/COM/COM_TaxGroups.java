package JBWindows.COM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class COM_TaxGroups extends BaseClass{
	
	@FindBy(id = "COM_TaxGroups") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "txtSearch") WebElement txtSearch;
	@FindBy(id = "txtTaxGroupName") WebElement txtTaxGroupName;
	@FindBy(id = "btnAdd") WebElement BtnAdd;
	@FindBy(id = "btnSave") WebElement BtnSave;
	@FindBy(id = "btnCancel") WebElement BtnCancel;

	public COM_TaxGroups() {
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
	
	public void clickAddButton()
	{
		BtnAdd.click();
	}
}
