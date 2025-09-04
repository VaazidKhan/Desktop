package JBWindows.AppSetup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class SYS_UserType extends BaseClass{
	
	@FindBy(id = "SYS_UserType") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "rgUserType") WebElement rgUserType;
	@FindBy(id = "txtName") WebElement txtName;
	@FindBy(id = "txtMobileNumber") WebElement txtMobileNumber;
	@FindBy(id = "txtEmailAddress") WebElement txtEmailAddress;
	@FindBy(id = "txtPassword") WebElement txtPassword;
	@FindBy(id = "linkForgotPassword") WebElement linkForgotPassword;
	@FindBy(id = "txtBranchCode") WebElement txtBranchCode;	
	@FindBy(id = "btnBack") WebElement BtnBack;
	@FindBy(id = "btnNext") WebElement BtnNext;

	public SYS_UserType() {
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
