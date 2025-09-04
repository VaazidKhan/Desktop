package JBWindows.APP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;
import commonClass.GenericMethods;

public class APP_AppSettings extends BaseClass {

	@FindBy(id = "APP_AppSettings")
	WebElement pageName;

	@FindBy(id = "btnAppConfig")
	WebElement btnAppConfig;
	@FindBy(id = "btnInvoiceTemplates")
	WebElement btnInvoiceTemplates;
	@FindBy(id = "btnInvoiceDelivery")
	WebElement btnInvoiceDelivery;
	@FindBy(id = "btnKOTConfig")
	WebElement btnKOTConfig;
	@FindBy(id = "btnPaymentModes")
	WebElement btnPaymentModes;
	@FindBy(id = "btnSalesConfiguration")
	WebElement btnSalesConfiguration;
	@FindBy(id = "btnCustomerPromotion")
	WebElement btnCustomerPromotion;

	@FindBy(id = "picClose")
	WebElement BtnClose;
	@FindBy(id = "btnSave")
	WebElement BtnSave;
	@FindBy(id = "btnCancel")
	WebElement BtnCancel;

	@FindBy(id = "cboAllowInventoryFrom")
	WebElement cboAllowInventoryFrom;
	@FindBy(id = "LookUpCurrencies")
	WebElement LookUpCurrencies;
	@FindBy(id = "LookUpPriceCatelog")
	WebElement LookUpPriceCatelog;
	@FindBy(id = "tmStartTime")
	WebElement tmStartTime;
	@FindBy(id = "tmEndTime")
	WebElement tmEndTime;
	@FindBy(id = "chkShowFeedBack")
	WebElement chkShowFeedBack;
	@FindBy(id = "chkAddNewCustomer")
	WebElement chkAddNewCustomer;
	@FindBy(id = "chkAutoGRN")
	WebElement chkAutoGRN;
	@FindBy(id = "chkAutoEditItemPopup")
	WebElement chkAutoEditItemPopup;
	@FindBy(id = "chkShowBarCode")
	WebElement chkShowBarCode;
	@FindBy(id = "chkShowQRCode")
	WebElement chkShowQRCode;
	@FindBy(id = "cboPurgeData")
	WebElement cboPurgeData;

	@FindBy(id = "cboPageSize")
	WebElement cboPageSize;
	@FindBy(id = "txtUploadSignature")
	WebElement txtUploadSignature;
	@FindBy(id = "txtOffers")
	WebElement txtOffers;

	@FindBy(id = "chkPrint")
	WebElement chkPrint;
	@FindBy(id = "chkSMS")
	WebElement chkSMS;
	@FindBy(id = "chkEmail")
	WebElement chkEmail;

	@FindBy(id = "chkLocalPrinterInvoice")
	WebElement chkLocalPrinterInvoice;
	@FindBy(id = "cboLocalPrinterInvoice")
	WebElement cboLocalPrinterInvoice;
	@FindBy(id = "chkNetworkPrinterInvoice")
	WebElement chkNetworkPrinterInvoice;
	@FindBy(id = "cboNetworkPrinterInvoice")
	WebElement cboNetworkPrinterInvoice;

	@FindBy(id = "LookUpSMSTemplates")
	WebElement LookUpSMSTemplates;
	@FindBy(id = "txtSMSUserID")
	WebElement txtSMSUserID;
	@FindBy(id = "txtPassword")
	WebElement txtSMSPassword;
	@FindBy(id = "txtAPIKey")
	WebElement txtSMSAPIKey;
	@FindBy(id = "txtSenderID")
	WebElement txtSMSSenderID;
	@FindBy(id = "cboGetPost")
	WebElement cboSMSGetPost;
	@FindBy(id = "txtURL")
	WebElement txtSMSURL;

	@FindBy(id = "txtEmailID")
	WebElement txtEmailID;
	@FindBy(id = "txtEmailPassword")
	WebElement txtEmailPassword;
	@FindBy(id = "txtHost")
	WebElement txtEmailHost;
	@FindBy(id = "txtPort")
	WebElement txtEmailPort;
	@FindBy(id = "chkSMTP_SSL")
	WebElement chkEmailSMTP_SSL;
	@FindBy(id = "txtSubject")
	WebElement txtEmailSubject;
	@FindBy(id = "memobody")
	WebElement memoEmailbody;

	@FindBy(id = "chkLocalPrinterKOT")
	WebElement chkLocalPrinterKOT;
	@FindBy(id = "cboLocalPrinterKOT")
	WebElement cboLocalPrinterKOT;
	@FindBy(id = "chkNetworkPrinterKOT")
	WebElement chkNetworkPrinterKOT;
	@FindBy(id = "cboNetworkPrinterKOT")
	WebElement cboNetworkPrinterKOT;
	@FindBy(id = "chkKOTCheckEditNum")
	WebElement chkKOTCheckEditNum;
	@FindBy(id = "txtKotResetNum")
	WebElement txtKotResetNum;
	@FindBy(id = "chkKOTCheckEditTime")
	WebElement chkKOTCheckEditTime;
	@FindBy(id = "txtKotResetTime")
	WebElement txtKotResetTime;
	@FindBy(id = "ChkDepartmentWiseKOT")
	WebElement ChkDepartmentWiseKOT;

	@FindBy(id = "chkCashPayment")
	WebElement chkCashPayment;
	@FindBy(id = "chkCardPayment")
	WebElement chkCardPayment;
	@FindBy(id = "chkChequePayment")
	WebElement chkChequePayment;
	@FindBy(id = "chkGiftVoucherPayment")
	WebElement chkGiftVoucherPayment;
	@FindBy(id = "chkWalletPayment")
	WebElement chkWalletPayment;
	@FindBy(id = "chkBankPayment")
	WebElement chkBankPayment;
	@FindBy(id = "chkCreditNotePayment")
	WebElement chkCreditNotePayment;
	@FindBy(id = "chkDebitNotePayment")
	WebElement chkDebitNotePayment;
	@FindBy(id = "chkAdvanceReceivedPayment")
	WebElement chkAdvanceReceivedPayment;
	@FindBy(id = "chkAdvancePaidPayment")
	WebElement chkAdvancePaidPayment;

	@FindBy(id = "lookupSalesOrderType")
	WebElement lookupSalesOrderType;
	@FindBy(id = "chkDefault")
	WebElement chkDefault;
	@FindBy(id = "lookUpDiscount1")
	WebElement lookUpDiscount1;
	@FindBy(id = "lookUpDiscount2")
	WebElement lookUpDiscount2;
	@FindBy(id = "lookUpDiscount3")
	WebElement lookUpDiscount3;
	@FindBy(id = "lookupDelivaryChargeCode")
	WebElement lookupDelivaryChargeCode;
	@FindBy(id = "lookupPackingChargeCode")
	WebElement lookupPackingChargeCode;
	@FindBy(id = "lookUpTaxGroup")
	WebElement lookUpTaxGroup;
	@FindBy(id = "lookUpRoundingMathods")
	WebElement lookUpRoundingMathods;
	@FindBy(id = "calcNoOfInvoicePrint")
	WebElement calcNoOfInvoicePrint;
	@FindBy(id = "calcNoOfKOTPrint")
	WebElement calcNoOfKOTPrint;

	@FindBy(id = "txtPromotionSenderID")
	WebElement txtPromotionSenderID;
	@FindBy(id = "txtPromoAPIKey")
	WebElement txtPromoAPIKey;
	@FindBy(id = "txtPromotionUserID")
	WebElement txtPromotionUserID;
	@FindBy(id = "txtPromotionPassword")
	WebElement txtPromotionPassword;
	@FindBy(id = "memoPromotionSmsGatewayURL")
	WebElement memoPromotionSmsGatewayURL;

	public APP_AppSettings() {
		PageFactory.initElements(driver, this);
	}

	public void activatePage() {
		pageName.click();
	}

	public void clickSaveButton() {
		BtnSave.click();
	}

	public void clickCloseButton() {
		BtnClose.click();
	}

	public void clickCancelButton() {
		BtnCancel.click();
	}

	// -----7-Feb-2018----Added by Moumita-----------

	public void salesOrderTypechange(String salesOrderType) {
		btnSalesConfiguration.click();
		lookupSalesOrderType.sendKeys(salesOrderType);
		lookupSalesOrderType.click();
		if (!chkDefault.isSelected()) {
			chkDefault.click();
		}
		BtnSave.click();
	}

	// -----21-Feb-2018----Added by Moumita-----------

	public void enableShowFeedbackAfterBillingFeature() {
		btnAppConfig.click();
		GenericMethods.fnwait(1);
		if (!chkShowFeedBack.isSelected()) {
			chkShowFeedBack.click();
			fnWriteSteps("Pass", "Settings for Show Feedback after Billing has been done");
		}
		BtnSave.click();
		GenericMethods.fnwait(1);
	}

	// -----23-April-2018----Added by Moumita-----------
	// This method is to enable all the payment modes from settings page
	public void enableAllPaymentmodes() {
		btnPaymentModes.click();
		GenericMethods.fnwait(2);
		if (chkChequePayment.isDisplayed()) {
			if (!chkChequePayment.isSelected()) {
				chkChequePayment.click();
			}
		} else {
			fnWriteSteps("Fail", "Cheque payment mode is not present");
		}
		if (chkGiftVoucherPayment.isDisplayed()) {
			if (!chkGiftVoucherPayment.isSelected()) {
				chkGiftVoucherPayment.click();
			}
		} else {
			fnWriteSteps("Fail", "Gift Voucher payment mode is not present");
		}
		if (chkWalletPayment.isDisplayed()) {
			if (!chkWalletPayment.isSelected()) {
				chkWalletPayment.click();
			}
		} else {
			fnWriteSteps("Fail", "Wallet payment mode is not present");
		}
		if (chkBankPayment.isDisplayed()) {
			if (!chkBankPayment.isSelected()) {
				chkBankPayment.click();
			}
		} else {
			fnWriteSteps("Fail", "Bank payment mode is not present");
		}
		if (chkCreditNotePayment.isDisplayed()) {
			if (!chkCreditNotePayment.isSelected()) {
				chkCreditNotePayment.click();
			}
		} else {
			fnWriteSteps("Fail", "Credit Note payment mode is not present");
		}
		if (chkDebitNotePayment.isDisplayed()) {
			if (!chkDebitNotePayment.isSelected()) {
				chkDebitNotePayment.click();
			}
		} else {
			fnWriteSteps("Fail", "Debit Note payment mode is not present");
		}
		if (chkAdvanceReceivedPayment.isDisplayed()) {
			if (!chkAdvanceReceivedPayment.isSelected()) {
				chkAdvanceReceivedPayment.click();
			}
		} else {
			fnWriteSteps("Fail", "Advance Received payment mode is not present");
		}
		if (chkAdvancePaidPayment.isDisplayed()) {
			if (!chkAdvancePaidPayment.isSelected()) {
				chkAdvancePaidPayment.click();
			}
		} else {
			fnWriteSteps("Fail", "Advance Paid payment mode is not present");
		}
		BtnSave.click();
		GenericMethods.fnwait(1);
	}

	// -----23-April-2018----Added by Moumita-----------
	// This method is to enable Auto Edit Item Pop up in Cart
	public void enableAutoEditItemPopup() {
		if (chkAutoEditItemPopup.isDisplayed()) {
			if (!chkAutoEditItemPopup.isSelected()) {
				chkAutoEditItemPopup.click();
			}
		} else {
			fnWriteSteps("Fail", "Auto Edit Item Popup checkbox is not present");
		}

		BtnSave.click();
		GenericMethods.fnwait(1);
	}
	
	// -----23-April-2018----Added by Moumita-----------
	// This method is to disable Auto Edit Item Pop up in Cart
	public void disableAutoEditItemPopup() {
		if (chkAutoEditItemPopup.isDisplayed()) {
			if (chkAutoEditItemPopup.isSelected()) {
				chkAutoEditItemPopup.click();
			}
		} else {
			fnWriteSteps("Fail", "Auto Edit Item Popup checkbox is not present");
		}

		BtnSave.click();
		GenericMethods.fnwait(1);
	}

}
