package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonClass.BaseClass;

public class SR_TableTypes extends BaseClass{

	@FindBy(id = "SR_TableTypes") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "txtSearch") WebElement txtSearch;
	@FindBy(id = "txtTableType") WebElement txtTableType;
	@FindBy(id = "lookUpTaxGroup") WebElement lookUpTaxGroup;
	@FindBy(id = "memoDescription") WebElement memoDescription;
	
	@FindBy(id = "btnAdd") WebElement BtnAdd;
	@FindBy(id = "btnSave") WebElement BtnEdit;
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnSave") WebElement BtnSave;


	public SR_TableTypes() {
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
	
	public void clickEditButton()
	{
		BtnEdit.click();
	}

}
