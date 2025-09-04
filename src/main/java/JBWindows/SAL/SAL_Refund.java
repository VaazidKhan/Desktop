package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;

public class SAL_Refund extends BaseClass{

	@FindBy(id = "SAL_Refund") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "CalcDiscountRecovered") WebElement CalcDiscountRecovered;
	@FindBy(id = "calcInvoiceAmount") WebElement calcInvoiceAmount;
	@FindBy(id = "calcRefundAmount") WebElement calcRefundAmount;
	
	@FindBy(id = "btnWallet") WebElement BtnWallet;
	@FindBy(id = "btnCash") WebElement BtnCash;


	public SAL_Refund()  {
		PageFactory.initElements(driver, this);
	}
	
	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickWalletButton()
	{
		BtnWallet.click();
	}
	
	public void clickCashButton()
	{
		BtnCash.click();
	}

}
