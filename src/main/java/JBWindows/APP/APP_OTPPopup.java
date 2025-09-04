package JBWindows.APP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class APP_OTPPopup extends BaseClass{
	
	@FindBy(id = "APP_OTPPopup")	WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "btnResend") WebElement BtnResend;
	@FindBy(id = "txtOTP") WebElement txtOTP;
	@FindBy(id = "btnActivate") WebElement BtnActivate;


	public APP_OTPPopup() {
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
	
	public void clickActivateButton()
	{
		BtnActivate.click();
	}
	

}
