package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;

public class SAL_DueDateEntry extends BaseClass{
	
	@FindBy(id = "SAL_DueDateEntry") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "dtDueDate") WebElement dtDueDate;
	@FindBy(id = "txtDueTime") WebElement txtDueTime;
	@FindBy(id = "memoInstruction") WebElement memoInstruction;
	
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnSave") WebElement BtnSave;


	public SAL_DueDateEntry() {
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

}
