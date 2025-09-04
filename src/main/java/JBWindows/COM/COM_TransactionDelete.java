package JBWindows.COM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;
import commonClass.GenericMethods;

public class COM_TransactionDelete extends BaseClass{
	
	@FindBy(id = "COM_TransactionDelete") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "memoRemarks") WebElement memoRemarks;
	@FindBy(id = "btnSave") WebElement BtnSave;
	@FindBy(id = "btnCancel") WebElement BtnCancel;

	public COM_TransactionDelete() {
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
	
	//--12-February-2018----added by Moumita
	//--1-May-2018----modified by Moumita
	//This is the method to enter the remarks while removing the item from cart/canceling the order
	public void enterRemarks() {
		memoRemarks.sendKeys("Remarks");
		GenericMethods.fnwait(2);
		clickSaveButton();
		/*fnWriteSteps("pass", "Order has been cancelled successfully");*/
	}

}
