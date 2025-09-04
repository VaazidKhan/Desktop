package JBWindows.APP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonClass.BaseClass;

public class APP_ForgotPassword extends BaseClass {

	@FindBy(id = "APP_ForgotPassword")
	WebElement PageName;

	@FindBy(id = "txtUserName")
	WebElement txtUserName;

	@FindBy(id = "btnRetrievePassword")
	WebElement btnRetrievePassword;

	@FindBy(id = "picLogo")
	WebElement JB_LOGO;

	@FindBy(id = "lblCaption")
	WebElement PopupName;

	@FindBy(id = "picClose")
	WebElement btnClose;

	public APP_ForgotPassword() {
		PageFactory.initElements(driver, this);
	}
	
	public void activatePage()
	{
		PageName.click();
	}

	public boolean Check_JB_LOGO_Presence() {
		return JB_LOGO.isDisplayed();
	}

	public boolean Check_CloseButton_Presence() {
		return btnClose.isDisplayed();
	}

	public boolean Check_PopupName_Presence() {
		return PopupName.isDisplayed();
	}

	public String Check_PageName_Correctness(String ExpectedName) {

		String ActualName = PopupName.getText();

		if (ActualName.equals(ExpectedName)) {
			System.out.println("Correct");
		} else {
			System.out.println("False");
		}
		return ActualName;

	}

}
