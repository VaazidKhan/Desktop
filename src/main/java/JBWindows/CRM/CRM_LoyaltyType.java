package JBWindows.CRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class CRM_LoyaltyType extends BaseClass{
	
	@FindBy(id = "CRM_LoyaltyType") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "txtSearch") WebElement txtSearch;
	@FindBy(id = "txtLoyaltyType") WebElement txtLoyaltyType;
	@FindBy(id = "calcOrderAmountPerPoints") WebElement calcOrderAmountPerPoints;
	@FindBy(id = "calcRedeemAmountPerPoints") WebElement calcRedeemAmountPerPoints;
	@FindBy(id = "chkDefault") WebElement chkDefault;
	@FindBy(id = "memoDescription") WebElement memoDescription;
	@FindBy(id = "btnSave") WebElement BtnSave;
	@FindBy(id = "btnSave") WebElement BtnEdit;
	@FindBy(id = "btnAdd") WebElement BtnAdd;
	@FindBy(id = "btnCancel") WebElement BtnCancel;

	public CRM_LoyaltyType() {
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

	public void clickAddButton()
	{
		BtnAdd.click();
	}
	
	public void clickEditButton()
	{
		BtnEdit.click();
	}

	public void clickSaveButton()
	{
		BtnSave.click();
	}

	
}
