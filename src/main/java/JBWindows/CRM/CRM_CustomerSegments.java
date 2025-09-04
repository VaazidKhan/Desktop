package JBWindows.CRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class CRM_CustomerSegments extends BaseClass{

	@FindBy(id = "CRM_CustomerProductInterest") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "txtSearch") WebElement txtSearch;
	@FindBy(id = "txtSegment") WebElement txtSegment;
	@FindBy(id = "cmbBusinessType") WebElement cmbBusinessType;
	@FindBy(id = "btnSave") WebElement BtnSave;
	@FindBy(id = "btnSave") WebElement BtnEdit;
	@FindBy(id = "btnAdd") WebElement BtnAdd;
	@FindBy(id = "btnCancel") WebElement BtnCancel;

	public CRM_CustomerSegments() {
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

	public void clickAddButton()
	{
		BtnAdd.click();
	}
	
	public void clickEditButton()
	{
		BtnEdit.click();
	}

	public void clickSaveButton()
	{
		BtnSave.click();
	}
	
}
