package JBWindows.AppSetup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class SYS_SubscriptionProduct extends BaseClass{
	
	@FindBy(id = "SYS_SubscriptionProduct") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "LookupBusinessTemplate") WebElement LookupBusinessTemplate;
	@FindBy(id = "chkFreeTrail") WebElement chkFreeTrail;
	@FindBy(id = "txtSubscriptionCode") WebElement txtSubscriptionCode;
	@FindBy(id = "btnBuyNow") WebElement BtnBuyNow;
	@FindBy(id = "chkTerms") WebElement chkTerms;
	@FindBy(id = "rgProductType") WebElement rgProductType;
	@FindBy(id = "btnBack") WebElement BtnBack;
	@FindBy(id = "btnNext") WebElement BtnNext;

	public SYS_SubscriptionProduct() {
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
	
	public void ClickBuyNowButton()
	{
		BtnBuyNow.click();
	}

}
