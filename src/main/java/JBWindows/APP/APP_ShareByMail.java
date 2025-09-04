package JBWindows.APP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class APP_ShareByMail extends BaseClass{
	@FindBy(id = "APP_ShareByMail")	WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "txtTo") WebElement txtTo;
	@FindBy(id = "txtCC") WebElement txtCC;
	@FindBy(id = "txtBCC") WebElement txtBCC;
	@FindBy(id = "txtSubject") WebElement txtSubject;
	@FindBy(id = "memoBody") WebElement memoBody;	
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnSend") WebElement BtnSend;
	
	public APP_ShareByMail() {
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
