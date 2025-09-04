package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;

public class SAL_ExchangePopup extends BaseClass{

	@FindBy(id = "SAL_ExchangePopup") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "CalcDiscountRecovered") WebElement CalcDiscountRecovered;
	@FindBy(id = "calcExchangeLimit") WebElement calcExchangeLimit;
	
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnOk") WebElement BtnOk;


	public SAL_ExchangePopup() {
		PageFactory.initElements(driver, this);
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
	
	// ----20-Feb-18----Added by Moumita-------------
	public void clickOkButton()
	{
		BtnOk.click();
	}

}
