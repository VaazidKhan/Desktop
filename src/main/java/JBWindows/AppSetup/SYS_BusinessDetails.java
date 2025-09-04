package JBWindows.AppSetup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class SYS_BusinessDetails extends BaseClass{
	
	@FindBy(id = "SYS_BusinessDetails")	WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "txtCompanyName") WebElement txtCompanyName;
	@FindBy(id = "txtOwnerName") WebElement txtOwnerName;
	@FindBy(id = "txtMobileNumber") WebElement txtMobileNumber;
	@FindBy(id = "txtEmailAddress") WebElement txtEmailAddress;
	@FindBy(id = "txtPassword") WebElement txtPassword;	
	@FindBy(id = "txtConfirmPassword") WebElement txtConfirmPassword;
	@FindBy(id = "lookupCountry") WebElement lookupCountry;
	@FindBy(id = "lookupState") WebElement lookupState;
	@FindBy(id = "lookupCity") WebElement lookupCity;
	@FindBy(id = "txtGSTIN") WebElement txtGSTIN;
	@FindBy(id = "LookUpLanguage") WebElement LookUpLanguage;
	@FindBy(id = "LookUpCurrencies") WebElement LookUpCurrencies;
	@FindBy(id = "memoAddress") WebElement memoAddress;
	@FindBy(id = "txtReferralCode") WebElement txtReferralCode;
	@FindBy(id = "btnBack") WebElement BtnBack;
	@FindBy(id = "btnNext") WebElement BtnNext;

	public SYS_BusinessDetails() {
		pageName.click();
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickBackButton()
	{
		BtnBack.click();
	}
	
	public void clickNextButton()
	{
		BtnNext.click();
	}

}
