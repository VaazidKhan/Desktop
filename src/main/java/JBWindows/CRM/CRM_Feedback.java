package JBWindows.CRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class CRM_Feedback extends BaseClass{

	@FindBy(id = "CRM_Feedback") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "txtSearch") WebElement txtSearch;
	@FindBy(id = "picHappy") WebElement picHappy;
	@FindBy(id = "picNutral") WebElement picNutral;
	@FindBy(id = "picSad") WebElement picSad;
	@FindBy(id = "lookUpCustomer") WebElement lookUpCustomer;
	@FindBy(id = "lookUpInvoice") WebElement lookUpInvoice;
	@FindBy(id = "dtFeadbackDate") WebElement dtFeadbackDate;
	@FindBy(id = "memoDescription") WebElement memoDescription;	
	@FindBy(id = "btnSave") WebElement BtnSave;
	@FindBy(id = "btnSave") WebElement BtnEdit;
	@FindBy(id = "btnAdd") WebElement BtnAdd;
	@FindBy(id = "btnCancel") WebElement BtnCancel;

	public CRM_Feedback() {
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
