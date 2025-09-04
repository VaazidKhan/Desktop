package JBWindows.APP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class APP_ServiceRequests extends BaseClass{
	
	@FindBy(id = "APP_ServiceRequests")	WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "txtSearch") WebElement txtSearch;
	@FindBy(id = "btnAdd") WebElement BtnAdd;
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnSave") WebElement BtnSave;
	@FindBy(id = "memoComments") WebElement memoComments;
	@FindBy(id = "memoRequestDescription") WebElement memoRequestDescription;

	public APP_ServiceRequests() {
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
