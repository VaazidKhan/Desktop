package JBWindows.FRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;
import commonClass.GenericMethods;

public class FRM_YouPayWalletAuthentication extends BaseClass {

	@FindBy(id = "FRM_YouPayWalletAuthentication")
	WebElement pageName;
	@FindBy(id = "picClose")
	WebElement BtnClose;
	@FindBy(id = "rgWalletType")
	WebElement rgWalletType;
	@FindBy(id = "touchPad1")
	WebElement touchPad1;
	@FindBy(id = "calcAmount")
	WebElement calcAmount;
	@FindBy(id = "btnCancel")
	WebElement BtnCancel;
	@FindBy(id = "btnConfirm")
	WebElement BtnConfirm;

	// -----23-April-2018----Added by Moumita-----------
	@FindBy(name = "Paytm")
	WebElement raBtnPaytm;
	@FindBy(name = "Mobikwik")
	WebElement raBtnMobikwik;
	@FindBy(name = "Freecharge")
	WebElement raBtnFreecharge;
	@FindBy(name = "Airtel Money")
	WebElement raBtnAirtelMoney;
	@FindBy(name = "Ola Money")
	WebElement raBtnOlaMoney;

	// -----23-April-2018----Added by Moumita-----------

	public FRM_YouPayWalletAuthentication() {
		PageFactory.initElements(driver, this);
	}

	public void activatePage() {
		pageName.click();
	}

	public void clickCloseButton() {
		BtnClose.click();
	}

	public void clickCancelButton() {
		BtnCancel.click();
	}

	public void clickConfirmButton() {
		BtnConfirm.click();
	}

	// -----23-April-2018----Added by Moumita-----------
	// This is to select the wallet type to complete the payment

	public void selectWalletPaymentType(String walletPaymentType, String amount) {
		switch (walletPaymentType.toUpperCase()) {
		case "PAYTM":
			raBtnPaytm.click();
			calcAmount.sendKeys(amount);
			BtnConfirm.click();
			GenericMethods.fnwait(2);
			break;
		case "MOBIKWIK":
			raBtnMobikwik.click();
			calcAmount.sendKeys(amount);
			BtnConfirm.click();
			GenericMethods.fnwait(2);
			break;
		case "FREECHARGE":
			raBtnFreecharge.click();
			calcAmount.sendKeys(amount);
			BtnConfirm.click();
			GenericMethods.fnwait(2);
			break;
		case "AIRTEL_MONEY":
			raBtnAirtelMoney.click();
			calcAmount.sendKeys(amount);
			BtnConfirm.click();
			GenericMethods.fnwait(2);
			break;
		case "OLA_MONEY":
			raBtnOlaMoney.click();
			calcAmount.sendKeys(amount);
			BtnConfirm.click();
			GenericMethods.fnwait(2);
			break;
		}

	}
}
