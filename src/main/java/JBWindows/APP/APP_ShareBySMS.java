package JBWindows.APP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class APP_ShareBySMS extends BaseClass{
	
	@FindBy(id = "APP_ShareBySMS")	WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "txtMobile") WebElement txtMobile;	
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnSend") WebElement BtnSend;
	
	public APP_ShareBySMS() {
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
	
	public void clickSendButton()
	{
		BtnSend.click();
	}

}
