package JBWindows.FRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;

public class FRM_PaymentDisbursement extends BaseClass{
	
	@FindBy(id = "FRM_PaymentDisbursement") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "lookUpCustomer") WebElement lookUpCustomer;
	@FindBy(id = "textVoucherNo") WebElement textVoucherNo;
	@FindBy(id = "dtVoucherDate") WebElement dtVoucherDate;
	@FindBy(id = "dtPaymentDate") WebElement dtPaymentDate;
	@FindBy(id = "calcReceivable") WebElement calcReceivable;
	@FindBy(id = "calcTendered") WebElement calcTendered;
	@FindBy(id = "calcBalance") WebElement calcBalance;
	@FindBy(id = "calcChangeAmount") WebElement calcChangeAmount;
	@FindBy(id = "lookUpAgents") WebElement lookUpAgents;
	@FindBy(id = "calcRedeemedAmount") WebElement calcRedeemedAmount;
	
	@FindBy(id = "btnCash") WebElement BtnCash;
	@FindBy(id = "btnCard") WebElement BtnCard;
	@FindBy(id = "btnWallet") WebElement BtnWallet;
	@FindBy(id = "btnBank") WebElement BtnBank;
	@FindBy(id = "btnVoucher") WebElement BtnVoucher;
	@FindBy(id = "btnCheque") WebElement BtnCheque;
	@FindBy(id = "btnCredit") WebElement BtnCredit;
	@FindBy(id = "btnLoyaltyWallet") WebElement BtnLoyaltyWallet;
	@FindBy(id = "btnCreditNote") WebElement BtnCreditNote;
	@FindBy(id = "btnDebitNote") WebElement BtnDebitNote;
	@FindBy(id = "btnAdvanceReceived") WebElement BtnAdvanceReceived;
	
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnFinish") WebElement BtnFinish;
	//----20-Feb-2018--Added by Moumita-------
	@FindBy(id = "btnSave") WebElement btnSave;
	//----21-Feb-2018--Added by Moumita-------
	@FindBy(id = "textVoucherNo") WebElement voucherNumber;
	
	public FRM_PaymentDisbursement() {
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
	
	public void clickFinishButton()
	{
		BtnFinish.click();
	}
	
	//----20-Feb-2018--Modified by Moumita-------	
	public void clickSaveButton()
	{
		btnSave.click();
	}
	
	public void selectPaymentMode(String paymentMode)
	{
		switch(paymentMode.toUpperCase())
		{
		case "CASH" : BtnCash.click(); break;
		case "CARD" : BtnCard.click(); break;
		case "CHEQUE" : BtnCard.click(); break;
		case "BANK" : BtnBank.click(); break;
		case "ADVANCERECEIVED" : BtnAdvanceReceived.click(); break;
		case "CREDIT" : BtnCredit.click(); break;
		case "CREDITNOTE" : BtnCreditNote.click(); break;
		case "DEBITNOTE" : BtnDebitNote.click(); break;
		case "LOYALTYWALLET" : BtnLoyaltyWallet.click(); break;
		case "VOUCHER" : BtnVoucher.click(); break;
		case "WALLET" : BtnWallet.click(); break;
		}

	}
	
	//----21-Feb-2018--Added by Moumita-------
	public String getExpenseNumber() {
		String expenseNumber = null;
		WebElement expenseNumberEle = driver.findElement(By.id("textVoucherNo"));
		expenseNumber = expenseNumberEle.getAttribute("Name");
		return expenseNumber;		
		}	
	
	//----26-April-2018--Added by Moumita-------
		public String getAdvanceReceivedVoucherNumber() {
			String voucherNumber = null;
			WebElement voucherNumberEle = driver.findElement(By.id("textVoucherNo"));
			voucherNumber = voucherNumberEle.getAttribute("Name");
			return voucherNumber;		
			}	
	
}
