package JBWindows.FRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;

public class FRM_Payment extends BaseClass{
	
	@FindBy(id = "FRM_Payment") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
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
	@FindBy(id = "btnCredit") WebElement BtnOnAccount;
	@FindBy(id = "btnLoyaltyWallet") WebElement BtnLoyaltyWallet;
	@FindBy(id = "btnCreditNote") WebElement BtnCreditNote;
	@FindBy(id = "btnDebitNote") WebElement BtnDebitNote;
	@FindBy(id = "btnAdvanceReceived") WebElement BtnAdvanceReceived;
	@FindBy(id = "btnAdvancePaid") WebElement BtnAdvancePaid;
	
	
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnFinish") WebElement BtnFinish;	
	
	public FRM_Payment() {
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
	
	//---13-Feb-2018--modified by Moumita--------
	public void SelectPaymentMode(String PaymentMode)
	{
		switch(PaymentMode.toUpperCase())
		{
		case "CASH" : BtnCash.click(); break;
		case "CARD" : BtnCard.click(); break;
		case "CHEQUE" : BtnCheque.click(); break;
		case "BANK" : BtnBank.click(); break;
		case "ADVANCERECEIVED" : BtnAdvanceReceived.click(); break;
		case "CREDIT" : BtnOnAccount.click(); break;
		case "CREDITNOTE" : BtnCreditNote.click(); break;
		case "DEBITNOTE" : BtnDebitNote.click(); break;
		case "LOYALTYWALLET" : BtnLoyaltyWallet.click(); break;
		case "VOUCHER" : BtnVoucher.click(); break;
		case "WALLET" : BtnWallet.click(); break;
		}

	}
	
	//---19-Feb-2018--modified by Moumita--------
	//This is the method to get the Receivable Amount
	public String getReceivableAmount() {
		String Amount = null;
		WebElement amountEle = driver.findElement(By.id("calcReceivable"));
		Amount = amountEle.getAttribute("Name");
		return Amount;		
		}	
	
	//---21-April-2018--Added by Moumita--------
	//This is the method to get the Balance Amount
	public String getBalanceAmount() {
		String balanceAmount = null;
		WebElement balanceAmountEle = driver.findElement(By.id("calcBalance"));
		balanceAmount = balanceAmountEle.getAttribute("Name");
		return balanceAmount;		
		}	
	
	//---25--April-2018--Added by Moumita-------
	//This is the method to get the Redeem Amount-
	public String getRedeemedAmount() {
		String redeemedAmount = null;
		WebElement redeemedAmountEle = driver.findElement(By.id("calcRedeemedAmount"));
		redeemedAmount = redeemedAmountEle.getAttribute("Name");
		return redeemedAmount;		
		}			
}
