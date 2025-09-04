package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class SAL_SalesInstructions extends BaseClass{

	@FindBy(id = "SAL_SalesInstructions") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "txtSearch") WebElement txtSearch;
	@FindBy(id = "txtInstructionCode") WebElement txtInstructionCode;
	@FindBy(id = "memoDescription") WebElement memoDescription;
	@FindBy(id = "chkActive") WebElement chkActive;
	
	@FindBy(id = "btnAdd") WebElement BtnAdd;
	@FindBy(id = "btnSave") WebElement BtnEdit;
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnSave") WebElement BtnSave;


	public SAL_SalesInstructions() {
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
