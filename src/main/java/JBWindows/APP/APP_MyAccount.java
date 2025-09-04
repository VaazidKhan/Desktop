package JBWindows.APP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonClass.BaseClass;

public class APP_MyAccount extends BaseClass{
	
	@FindBy(id = "APP_MyAccount")	WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnRenew") WebElement BtnRenew;
	@FindBy(id = "btnCheckUpdates") WebElement BtnCheckUpdates;


	public APP_MyAccount() {
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
	
	public void clickCheckUpdateButton()
	{
		BtnCheckUpdates.click();
	}
	
	public void clickRenewButton()
	{
		BtnRenew.click();
	}
	
}

