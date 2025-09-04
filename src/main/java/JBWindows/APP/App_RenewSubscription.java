package JBWindows.APP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class App_RenewSubscription extends BaseClass{
	
	@FindBy(id = "App_RenewSubscription")	WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "txtSubscriptionCode") WebElement txtSubscriptionCode;
	@FindBy(id = "btnBuyNow") WebElement BtnBuyNow;
	@FindBy(id = "chkTerms") WebElement chkTerms;
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnSave") WebElement BtnSave;


	public App_RenewSubscription() {
		pageName.click();
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickBuyNowButton()
	{
		BtnBuyNow.click();
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
