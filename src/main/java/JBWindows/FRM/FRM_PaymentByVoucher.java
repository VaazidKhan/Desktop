package JBWindows.FRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class FRM_PaymentByVoucher extends BaseClass {

	@FindBy(id = "FRM_PaymentByVoucher")
	WebElement pageName;
	@FindBy(id = "picClose")
	WebElement BtnClose;

	@FindBy(id = "rdgVoucherType")
	WebElement rdgVoucherType;
	@FindBy(id = "textGiftVoucherNo")
	WebElement textGiftVoucherNo;
	@FindBy(id = "calcAmount")
	WebElement calcAmount;

	@FindBy(id = "btnCancel")
	WebElement BtnCancel;
	@FindBy(id = "btnSave")
	WebElement BtnSave;

	// -----23-April-2018----Added by Moumita-----------
	@FindBy(name = "Own Voucher")
	WebElement raBtnOwnVoucher;
	@FindBy(name = "3rd Party Voucher")
	WebElement raBtn3rdPartyVoucher;

	public FRM_PaymentByVoucher() {
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

	public void clickSaveButton() {
		BtnSave.click();
	}

	// -----23-April-2018----Added by Moumita-----------
	// This is the method to select the voucher type according to the use input
	// Parameters are voucherType,rowNumber & totalAmount
	public void selectVoucherPaymentType(String voucherType, int rowNumber, String totalAmount) {
		switch (voucherType.toUpperCase()) {
		case "OWN_VOUCHER":
			raBtnOwnVoucher.click();
			textGiftVoucherNo.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
					"Transaction_Invoice_TakeAway", rowNumber, 11));
			calcAmount.sendKeys(totalAmount);
			GenericMethods.fnwait(2);
			clickSaveButton();
			GenericMethods.fnwait(2);
			break;
		case "3RD_PARTY_VOUCHER":
			raBtn3rdPartyVoucher.click();
			textGiftVoucherNo.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
					"Transaction_Invoice_TakeAway", rowNumber, 10));
			calcAmount.sendKeys(totalAmount);
			clickSaveButton();
			GenericMethods.fnwait(2);
			break;
		}
	}
}
