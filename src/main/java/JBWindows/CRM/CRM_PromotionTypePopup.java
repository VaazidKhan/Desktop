package JBWindows.CRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class CRM_PromotionTypePopup extends BaseClass{
	
	@FindBy(id = "CRM_PromotionTypePopup") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "rgisPromotionModes") WebElement rgisPromotionModes;
	@FindBy(id = "btnOk") WebElement BtnOk;
	@FindBy(id = "btnCancel") WebElement BtnCancel;

	public CRM_PromotionTypePopup() {
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

	public void clickOkButton()
	{
		BtnOk.click();
	}

}
