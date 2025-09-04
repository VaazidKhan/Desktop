package JBWindows.APP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class APP_SubscriptionCancelOTPPopup extends BaseClass{
	
	@FindBy(id = "APP_SubscriptionCancelOTPPopup")	WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "txtOTP") WebElement txtOTP;
	@FindBy(id = "calcRefundableAmount") WebElement calcRefundableAmount;
	@FindBy(id = "calcRefundedAmount") WebElement calcRefundedAmount;
	@FindBy(id = "memoRemarks") WebElement memoRemarks;
	@FindBy(id = "btnResend") WebElement BtnResend;	
	@FindBy(id = "btnOk") WebElement BtnOk;
	
	public APP_SubscriptionCancelOTPPopup() {
		pageName.click();
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickResendButton()
	{
		BtnResend.click();
	}
	
	public void clickOkButton()
	{
		BtnOk.click();
	}


}
