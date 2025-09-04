package JBWindows.AppSetup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class SYS_SubscriptionDetails extends BaseClass{
	
	@FindBy(id = "SYS_SubscriptionDetails") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "chkFreeTrail") WebElement chkFreeTrail;
	@FindBy(id = "txtSubscriptionCode") WebElement txtSubscriptionCode;
	@FindBy(id = "btnBack") WebElement BtnBack;
	@FindBy(id = "btnNext") WebElement BtnNext;

	public SYS_SubscriptionDetails() {
		pageName.click();
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickNextButton()
	{
		BtnNext.click();
	}

	public void clickBackButton()
	{
		BtnBack.click();
	}
}
