package JBWindows.CRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonClass.BaseClass;

public class CRM_CustomerLoyaltyInfo extends BaseClass{
	
	@FindBy(id = "CRM_CustomerLoyaltyInfo") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "txtCustomerName") WebElement txtCustomerName;
	@FindBy(id = "txtLoyaltyType") WebElement txtLoyaltyType;
	@FindBy(id = "calcAmountEarned") WebElement calcAmountEarned;
	@FindBy(id = "calcAmountRedeemed") WebElement calcAmountRedeemed;
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnSave") WebElement BtnSave;

	public CRM_CustomerLoyaltyInfo() {
		PageFactory.initElements(driver, this);
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickSaveButton()
	{
		BtnSave.click();
	}

	public void clickCancelButton()
	{
		BtnCancel.click();
	}
	
	public void selectLoyaltyDetails(String totalAmount) {
		calcAmountRedeemed.click();
		calcAmountRedeemed.clear();
		calcAmountRedeemed.sendKeys(totalAmount);
	}
	
}
