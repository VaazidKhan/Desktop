package JBWindows.CRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class CRM_CustomerPromotions extends BaseClass{

	@FindBy(id = "CRM_CustomerPromotions") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "txtEmailSubject") WebElement txtEmailSubject;
	@FindBy(id = "memoEmailBody") WebElement memoEmailBody;
	@FindBy(id = "memoSMSBody") WebElement memoSMSBody;
	@FindBy(id = "txtSearch") WebElement txtSearch;
	@FindBy(id = "btnSend") WebElement BtnSend;
	@FindBy(id = "btnCancel") WebElement BtnCancel;

	public CRM_CustomerPromotions() {
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
