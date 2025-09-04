package JBWindows.Configurations;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import commonClass.BaseClass;
import commonClass.GenericMethods;

public class InvoiceDelivery extends BaseClass {
	//WebElements
	@FindBy(id ="btnInvoiceDelivery")    WebElement BtnInvoiceDelivery;
	@FindBy(id ="chkPrint")       WebElement Print;
	@FindBy(id ="chkSMS")       WebElement SMS;
	@FindBy(id ="chkEmail")       WebElement Email;
	@FindBy(id ="chkLocalPrinterInvoice")  WebElement LocalPrinter;
	@FindBy(id ="chkNetworkPrinterInvoice")  WebElement NetworkPrinter;
	@FindBy(id ="btnInvoiceDeliverySave")  WebElement InvoiceDeliverySave;
	@FindBy(id ="picClose")  WebElement btnClose;
	@FindBy(id ="picLogo")  WebElement Logo;
	@FindBy(id ="btnOk")   WebElement BtnOk;
	@FindBy(id ="btnInvoiceTemplates")  WebElement  BtnInvoiceTemplates;
	@FindBy(id ="txtUploadSignature")   WebElement UploadSignature;
	@FindBy(id ="txtOffers")   WebElement FooterText;
	@FindBy(id ="cboPageSize") WebElement TemplateSize;
	@FindBy(id ="btnPaymentModes")   WebElement BtnPaymentModes;
	@FindBy(id ="chkCardPayment")   WebElement CardPayment;
	@FindBy(id ="chkChequePayment")   WebElement ChequePayment;
	@FindBy(id ="chkGiftVoucherPayment")   WebElement  GiftVoucherPayment;
	@FindBy(id ="chkWalletPayment")   WebElement  WalletPayment;
	@FindBy(id ="chkBankPayment")   WebElement BankPayment;
	@FindBy(id ="btnCard") WebElement BtnCard;
	@FindBy(id ="chkCreditNotePayment")   WebElement CreditNotePayment;
	@FindBy(id ="chkDebitNotePayment")   WebElement DebitNotePayment ;
	@FindBy(id ="chkAdvanceReceivedPayment")   WebElement AdvanceReceivedPayment;
	@FindBy(id ="chkAdvancePaidPayment")   WebElement AdvancePaidPayment;
	@FindBy(id ="chkBP50Payment")   WebElement BP50Payment;
	@FindBy(id ="chkBP5000Payment")   WebElement BP5000Payment;
	@FindBy(id ="btnPaymentModeSave")   WebElement PaymentModeSave;
	@FindBy(id ="btnPayment")  WebElement BtnPayment;
	@FindBy(id ="txtSearch") WebElement TxtSearch;
	@FindBy(id ="btnCash")  WebElement BtnCash;
	@FindBy(id ="btnWallet") WebElement BtnWallet;
	@FindBy(id ="btnBank") WebElement BtnBank;
	@FindBy(id ="btnVoucher") WebElement BtnVoucher;
	@FindBy(id ="btnCheque") WebElement BtnCheque;
	@FindBy (id ="btnDashBoard") WebElement BtnDashboard;
	@FindBy (id ="btnCustomer") WebElement SelectCustomer;
	@FindBy (id ="btnCredit") WebElement BtnCredit;
	@FindBy (id ="btnLoyaltyWallet") WebElement LoyaltyWallet;
	@FindBy(id ="textCardNo") WebElement CardNo;
	@FindBy(id ="btnSave") WebElement BtnSave;
	@FindBy (id ="btnFinish") WebElement BtnFinish;
	@FindBy (id ="lblCaption")  WebElement CaptionFeedback;
	@FindBy(id ="btnAdd") WebElement BtnAdd;
	@FindBy(id="dtInvoiceDate") WebElement PurchaseInvoiceDate;
	@FindBy(id="lookUpEdit") WebElement Suppliers;
	@FindBy(id="txtReferenceNo") WebElement RefNo;
	@FindBy(id="dtReceivingDate") WebElement ReceivingDate;
	@FindBy(id="lookUpEdit")  WebElement AdvancedPaymentModesID;
	@FindBy(id="btnAdvanceReceived") WebElement BtnAdvanceReceived;
	@FindBy(id="btnAdvancePaid")  WebElement BtnAdvancePaid;
	@FindBy(id="btnCancel")  WebElement BtnCancel;
	@FindBy(id="btnInvoiceTemplates") WebElement BtnInvoiceTemplate;
	@FindBy(name="Open") WebElement InvoiceTemplateSize;
	@FindBy(id = "grdTemplates")  WebElement grdRecordList;
	
	// Action
	public void clickCloseButton()
	{
		btnClose.click();
	}
	// WebElement Initialization method
    public InvoiceDelivery() {
		PageFactory.initElements(driver, this);
	}
    // This method for InvoiceDelivery_Option_Enabling :
    public void InvoiceDelivery_Option_Enabling() {
    	
    	if(BtnInvoiceDelivery.isDisplayed()) {
    		BtnInvoiceDelivery.click();
    	}
    	GenericMethods.fnwait(1);
    	Print.click();
    	GenericMethods.fnwait(1);
    	SMS.click();
    	GenericMethods.fnwait(1);
    	Email.click();
    	GenericMethods.fnwait(1);
    	LocalPrinter.click();
    	GenericMethods.fnwait(1);
    	NetworkPrinter.click();
    	GenericMethods.fnwait(1);
    	InvoiceDeliverySave.click();
    	GenericMethods.fnwait(2);
    	driver.findElement(By.id("lblHeader")).click();
    	BtnOk.click();
    }
    // This method for All PaymentModes Enabling :
    public void PaymentModes_Enabling() {
    	
    	if(BtnPaymentModes.isDisplayed()) {
    		BtnPaymentModes.click();
    	}
    	
    	GenericMethods.fnwait(1);
    	ChequePayment.click();
    	GenericMethods.fnwait(1);
    	GiftVoucherPayment.click();
    	GenericMethods.fnwait(1);
    	WalletPayment.click();
    	GenericMethods.fnwait(1);
    	BankPayment.click();
    	GenericMethods.fnwait(1);
    	CreditNotePayment.click();
    	GenericMethods.fnwait(1);
    	DebitNotePayment.click();
    	GenericMethods.fnwait(1);
    	AdvanceReceivedPayment.click();
    	GenericMethods.fnwait(1);
    	AdvancePaidPayment.click();
    	GenericMethods.fnwait(1);
    	BP50Payment.click();
    	GenericMethods.fnwait(1);
    	BP5000Payment.click();
    	GenericMethods.fnwait(1);
    	PaymentModeSave.click();
    	driver.findElement(By.id("lblHeader")).click();
    	BtnOk.click();
    }
    // This method for InvoiceGeneration with Customer and CashPaymentMode :
    public boolean InvoiceGeneration_with_Customer_and_CashPaymentMode(String SelectedCustomer,String strProduct) {
    	boolean result = false;
    	SelectCustomer.click();
  	    GenericMethods.windows_Set_DropDown_Value(TxtSearch,SelectedCustomer );
		GenericMethods.fnwait(1);
        GenericMethods.windows_Set_TextBoxValue(TxtSearch,strProduct);
		  GenericMethods.fnwait(3);
		  driver.findElement(By.id("btnAll")).click();
		  BtnPayment.click();
		  GenericMethods.fnwait(1);
		  if(BtnCash.isDisplayed()) {
			  if(BtnWallet.isDisplayed()) {
					 if(BtnBank.isDisplayed()) {
					  if(BtnVoucher.isDisplayed()) {
					   if(BtnCheque.isDisplayed()) {
			  result = true;
		           }
	           }
	       }
	   }
    }
        driver.findElement(By.id("picLogo")).click();
		clickCloseButton();
		GenericMethods.fnwait(2);
		BtnDashboard.click();
		BtnOk.click();
		return result;
		  
    }
    // This method for InvoiceGeneration without Customer and CashPaymentMode :
    public boolean InvoiceGeneration_without_Customer_and_CashPaymentMode(String strProduct) {
    	   boolean result = false;
          GenericMethods.windows_Set_TextBoxValue(TxtSearch,strProduct);
		  GenericMethods.fnwait(3);
		  driver.findElement(By.id("btnAll")).click();
		  BtnPayment.click();
		  GenericMethods.fnwait(1);
		  int Credit = driver.findElements(By.id("BtnCredit")).size();
			 int Wallet= driver.findElements(By.id("LoyaltyWallet")).size();
			  if(Credit == 0 && Wallet == 0) {
					   result = true;
				   }
						 
		  driver.findElement(By.id("picLogo")).click();
				 clickCloseButton();
				 GenericMethods.fnwait(2);
				 BtnDashboard.click();
				 BtnOk.click();
			   return result;
    }
    // This method for InvoiceGeneration with CardPaymentMode :
    public boolean InvoiceGeneration_with_CardPaymentMode(String SelectedCustomer, String strProduct)  {
    	boolean result = false;
    	SelectCustomer.click();
  	    GenericMethods.windows_Set_DropDown_Value(TxtSearch,SelectedCustomer );
		GenericMethods.fnwait(1);
        GenericMethods.windows_Set_TextBoxValue(TxtSearch,strProduct);
		  GenericMethods.fnwait(3);
		  driver.findElement(By.id("btnAll")).click();
		  BtnPayment.click();
		  GenericMethods.fnwait(1);
		  if(BtnCard.isDisplayed()) {
			  result = true;
		  }
		  GenericMethods.fnwait(1);
		 driver.findElement(By.id("picLogo")).click();
		   clickCloseButton();
		  GenericMethods.fnwait(2);
		  BtnDashboard.click();
		  BtnOk.click();
		   return result;
    }
    // This method for PurchaseInvoiceGeneration with AllPaymentModes :
    public boolean PurchaseInvoiceGeneration_with_AllPaymentModes(String PurchaseInvoicedate,String suppliers,String RefInvoiceNo,String Receivingdate,String strProduct) {
    	boolean result = false;
    	if(BtnAdd.isDisplayed()) {
    		BtnAdd.click();
    	  }
    	GenericMethods.windows_Set_TextBoxValue(PurchaseInvoiceDate,PurchaseInvoicedate);
    	GenericMethods.windows_Set_DropDown_Value(Suppliers,suppliers);
    	GenericMethods.windows_Set_TextBoxValue(RefNo, RefInvoiceNo);
        GenericMethods.windows_Set_TextBoxValue(ReceivingDate, Receivingdate);
        BtnSave.click();
        GenericMethods.fnwait(1);
        GenericMethods.windows_Set_TextBoxValue(TxtSearch,strProduct);
		  GenericMethods.fnwait(2);
		  driver.findElement(By.id("btnAll")).click();
		  BtnPayment.click();
		  GenericMethods.fnwait(1);
		  if(BtnCash.isDisplayed()) {
			  if(BtnWallet.isDisplayed()) {
					 if(BtnBank.isDisplayed()) {
					  if(BtnVoucher.isDisplayed()) {
					   if(BtnCheque.isDisplayed()) {
			  result = true;
		           }
	           }
	       }
	   }
    }
        driver.findElement(By.id("picLogo")).click();
		clickCloseButton();
		GenericMethods.fnwait(2);
		BtnCancel.click();
		GenericMethods.fnwait(2);
		driver.findElement(By.id("picLogo")).click();
		clickCloseButton();
		return result;
		 
    }
    // This method for PurchaseInvoiceGeneration with CardPaymentModes :
    public boolean PurchaseInvoiceGeneration_with_CardPaymentModes(String PurchaseInvoicedate,String suppliers,String RefInvoiceNo,String Receivingdate,String strProduct,String CardNumber) {
    	boolean result = false;
    	if(BtnAdd.isDisplayed()) {
    		BtnAdd.click();
    	  }
    	GenericMethods.windows_Set_TextBoxValue(PurchaseInvoiceDate,PurchaseInvoicedate);
    	GenericMethods.windows_Set_DropDown_Value(Suppliers,suppliers);
    	GenericMethods.windows_Set_TextBoxValue(RefNo, RefInvoiceNo);
        GenericMethods.windows_Set_TextBoxValue(ReceivingDate, Receivingdate);
        BtnSave.click();
        GenericMethods.fnwait(1);
        GenericMethods.windows_Set_TextBoxValue(TxtSearch,strProduct);
		  GenericMethods.fnwait(3);
		  driver.findElement(By.id("btnAll")).click();
		  BtnPayment.click();
		  GenericMethods.fnwait(1);
		  if(BtnCard.isDisplayed()) {
			  result = true;
		  }
		  GenericMethods.fnwait(1);
		 driver.findElement(By.id("picLogo")).click();
		   clickCloseButton();
		  GenericMethods.fnwait(2);
		   BtnCancel.click();
			GenericMethods.fnwait(2);
			driver.findElement(By.id("picLogo")).click();
			clickCloseButton();
			return result;
    }
    // This method for Validation of PaymentModes :
   public boolean PaymentModes_Validation(String SelectedCustomer,String strProduct) {
    	boolean result = false;
    	GenericMethods.fnwait(1);
    	  SelectCustomer.click();
    	GenericMethods.windows_Set_DropDown_Value(TxtSearch,SelectedCustomer );
		  GenericMethods.fnwait(1);
		  GenericMethods.windows_Set_TextBoxValue(TxtSearch,strProduct);
		  GenericMethods.fnwait(3);
		  driver.findElement(By.id("btnAll")).click();
		  BtnPayment.click();
		  GenericMethods.fnwait(1);
		  if(BtnCard.isDisplayed()) {
		   if(BtnWallet.isDisplayed()) {
			 if(BtnBank.isDisplayed()) {
			  if(BtnVoucher.isDisplayed()) {
			   if(BtnCheque.isDisplayed()) {
				   result = true;
			   }
					 }
				 }
			  }
		  }
		  
		  driver.findElement(By.id("picLogo")).click();
			 clickCloseButton();
			 GenericMethods.fnwait(3);
			 BtnDashboard.click();
			 BtnOk.click();
		   return result;
    }
   // This method for PaymentModes Validation withoutCustomer :
    public boolean PaymentModes_Validation_withoutCustomer(String strProduct) {
    	boolean result = false;
    	GenericMethods.fnwait(1);
    	GenericMethods.windows_Set_TextBoxValue(TxtSearch,strProduct);
		  GenericMethods.fnwait(3);
		  driver.findElement(By.id("btnAll")).click();
		  BtnPayment.click();
		  GenericMethods.fnwait(1);
		 int Credit = driver.findElements(By.id("BtnCredit")).size();
		 int Wallet= driver.findElements(By.id("LoyaltyWallet")).size();
		  if(Credit == 0 && Wallet == 0) {
				   result = true;
			   }
					 
	  driver.findElement(By.id("picLogo")).click();
			 clickCloseButton();
			 GenericMethods.fnwait(3);
			 BtnDashboard.click();
			 BtnOk.click();
		   return result;
    }
    // This method for InvoiceGeneration with AdvanceReceivedPaymentMode :
    public boolean InvoiceGeneration_with_AdvanceReceivedPaymentMode(String SelectedCustomer,String strProduct,String AdvanceReceivedid) {
    	 boolean result = false;
    	 GenericMethods.fnwait(1);
  	     SelectCustomer.click();
  	     GenericMethods.windows_Set_DropDown_Value(TxtSearch,SelectedCustomer );
		 GenericMethods.fnwait(1);
		 GenericMethods.windows_Set_TextBoxValue(TxtSearch,strProduct);
		 GenericMethods.fnwait(3);
		  driver.findElement(By.id("btnAll")).click();
		  BtnPayment.click();
		  GenericMethods.fnwait(1);
		  if(BtnAdvanceReceived.isDisplayed()) {
			  result = true;
		  }
		  GenericMethods.fnwait(1);
		  driver.findElement(By.id("picLogo")).click();
		   clickCloseButton();
		  GenericMethods.fnwait(1);
		  BtnDashboard.click();
		  BtnOk.click();
		  return result;
			
    }
    // This method for PurchaseInvoiceGeneration with AdvancedPaidMode :
    public boolean PurchaseInvoiceGeneration_with_AdvancedPaidMode(String PurchaseInvoicedate,String suppliers,String RefInvoiceNo,String Receivingdate,String strProduct,String Advancedpaid) {
    	boolean result = false;
    	if(BtnAdd.isDisplayed()) {
    		BtnAdd.click();
    	  }
    	GenericMethods.windows_Set_TextBoxValue(PurchaseInvoiceDate,PurchaseInvoicedate);
    	GenericMethods.windows_Set_DropDown_Value(Suppliers,suppliers);
    	GenericMethods.windows_Set_TextBoxValue(RefNo, RefInvoiceNo);
        GenericMethods.windows_Set_TextBoxValue(ReceivingDate, Receivingdate);
        BtnSave.click();
        GenericMethods.fnwait(1);
        GenericMethods.windows_Set_TextBoxValue(TxtSearch,strProduct);
		  GenericMethods.fnwait(3);
		  driver.findElement(By.id("btnAll")).click();
		  BtnPayment.click();
		  GenericMethods.fnwait(1);
		  if(BtnAdvancePaid.isDisplayed()) {
			  result = true;
		  }
		 
		  driver.findElement(By.id("picLogo")).click();
			 clickCloseButton();
			 GenericMethods.fnwait(1);
			   BtnCancel.click();
				GenericMethods.fnwait(2);
				driver.findElement(By.id("picLogo")).click();
				clickCloseButton();
				return result;
    } 
    // This method for InvoiceTemplate Generation :
    public void InvoiceTemplate_Generation(String TemplateSize) {
    	
    	if(BtnInvoiceTemplate.isDisplayed()) {
    		BtnInvoiceTemplate.click();																										
    	}
    	switch(TemplateSize){
    	case "A4":
    	InvoiceTemplateSize.click();
    	Actions act = new Actions(driver);
	    act.moveToElement(driver.findElement(By.name("A4"))).click().build().perform();
	    System.out.println("Hello");
	    
	    break;
	    case "A5":
    	InvoiceTemplateSize.click();
    	Actions act1 = new Actions(driver);
	    act1.moveToElement(driver.findElement(By.name("A5"))).click().build().perform();
	    GenericMethods.fnwait(2);
    	driver.findElement(By.id("lblHeader")).click();
    	BtnOk.click();
    	fnVerifyMasterRecordclick_A4(grdRecordList);
	    GenericMethods.fnwait(1);
	    driver.findElement(By.id("picLogo")).click();
		 clickCloseButton();
	    break;
	    case "2 Inch":
	    	InvoiceTemplateSize.click();
	    	Actions act2 = new Actions(driver);
		    act2.moveToElement(driver.findElement(By.name("2 Inch"))).click().build().perform();
		    break;
	    case "3.5 Inch":
	    	InvoiceTemplateSize.click();
	    	Actions act3 = new Actions(driver);
		    act3.moveToElement(driver.findElement(By.name("3.5 Inch"))).click().build().perform();
		    break;
	    case "3 Inch":
	    	InvoiceTemplateSize.click();
	    	Actions act4 = new Actions(driver);
		    act4.moveToElement(driver.findElement(By.name("3 Inch"))).click().build().perform();
		    break;
		   
	    
	    
      }
    }
    	public static void fnVerifyMasterRecordclick_A4(WebElement element) {

			GenericMethods.fnwait(1);
			element.click();
			PointerInfo a1 = MouseInfo.getPointerInfo();
			Point b1 = a1.getLocation();
			GenericMethods.fnwait(1);
			int x1 = (int) b1.getX();
			GenericMethods.fnwait(1);
			int y1 = (int) b1.getY();

			Robot r1;
			try {
				r1 = new Robot();
				r1.mouseMove(x1 + 429, y1 - 167);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			GenericMethods.fnwait(1);
			Actions builder1 = new Actions(driver);
			builder1.click().build().perform();
		}
    
    
    
    
    
    
    
  }



